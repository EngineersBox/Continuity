package com.engineersbox.continuity.instrumenter.method;

import com.engineersbox.continuity.core.continuation.Continuation;
import com.engineersbox.continuity.core.method.MethodState;
import com.engineersbox.continuity.instrumenter.stack.ContinuityVariables;
import com.engineersbox.continuity.instrumenter.stack.point.ContinuationPoint;
import com.engineersbox.continuity.instrumenter.stack.point.InvokeContinuationPoint;
import com.engineersbox.continuity.instrumenter.stack.point.SuspendMethodContinuationPoint;
import com.engineersbox.continuity.instrumenter.stack.storage.PrimitiveContainerStack;
import com.engineersbox.continuity.instrumenter.stack.storage.PrimitiveStack;
import com.engineersbox.continuity.instrumenter.stack.storage.VariableCache;
import com.engineersbox.continuity.instrumenter.stack.storage.VariableLUT;
import com.engineersbox.continuity.instrumenter.util.MethodInsnUtils;
import com.engineersbox.continuity.instrumenter.util.TypeTranslationUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.*;
import org.objectweb.asm.tree.analysis.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.StreamSupport;

public class MethodIntrospector {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodIntrospector.class);

    private static final String CONSTRUCTOR_METHOD_NAME = "<init>";
    private static final Type CONTINUATION_CLASS_TYPE = Type.getType(Continuation.class);
    private static final Method CONTINUATION_SUSPEND_METHOD = MethodUtils.getAccessibleMethod(Continuation.class, "suspend");

    public MethodContext introspect(final ClassNode classNode,
                                    final MethodNode methodNode) {
        if (methodNode.name.equals(CONSTRUCTOR_METHOD_NAME)) {
            throw new IllegalStateException(String.format(
                    "Cannot instrument constructor: %s",
                    methodNode.signature
            ));
        }
        final List<AbstractInsnNode> suspendCallInsnNodes = findInvocationsOf(
                methodNode.instructions,
                CONTINUATION_SUSPEND_METHOD
        );
        final List<AbstractInsnNode> continueInvocationInsnNodes = findInvocationsWithParameter(
                methodNode.instructions,
                CONTINUATION_CLASS_TYPE
        );
        LOGGER.info("Suspend call count: {}", suspendCallInsnNodes.size());
        LOGGER.info("Continue call count: {}", continueInvocationInsnNodes.size());

        final Frame<BasicValue>[] frames;
        try {
            frames = new Analyzer<>(new SimpleVerifier()).analyze(classNode.name, methodNode);
        } catch (final AnalyzerException e) {
            throw new IllegalArgumentException("Could not analyze method", e);
        }
        final List<ContinuationPoint> continuationPoints = new ArrayList<>();
        continuationPoints.addAll(createSuspendContinuationPoints(
                suspendCallInsnNodes,
                frames,
                methodNode
        ));
        continuationPoints.addAll(createInvokeContinuationPoints(
                continueInvocationInsnNodes,
                frames,
                methodNode
        ));

        final VariableLUT varLUT = new VariableLUT(classNode, methodNode);
        final VariableCache cache = allocateCacheSlots(varLUT, continueInvocationInsnNodes);
        final PrimitiveStack LVA = allocateLVASlots(
                varLUT,
                continueInvocationInsnNodes,
                suspendCallInsnNodes,
                frames,
                methodNode
        );
        final PrimitiveStack OS = allocateOSSlots(
                varLUT,
                continueInvocationInsnNodes,
                suspendCallInsnNodes,
                frames,
                methodNode
        );
        final PrimitiveContainerStack containerStack = new PrimitiveContainerStack(varLUT.allocExtra(Object[].class));

        final ContinuityVariables continuationVariables = new ContinuityVariables(
                varLUT.getArgument(getContinuationLVAIndex(methodNode)),
                varLUT.allocExtra(MethodState.class)
        );

        return new MethodContext(
                new MethodSignature(
                    classNode.name,
                    methodNode.name,
                    Type.getMethodType(methodNode.desc)
                ),
                continuationPoints,
                cache,
                LVA,
                OS,
                containerStack,
                continuationVariables
        );
    }

    private int getContinuationLVAIndex(final MethodNode methodNode) {
        final boolean isStatic = (methodNode.access & Opcodes.ACC_STATIC) == Opcodes.ACC_STATIC;
        final Type[] argumentTypes = Type.getMethodType(methodNode.desc).getArgumentTypes();
        int idx = -1;
        for (int i = 0; i < argumentTypes.length; i++) {
            if (!argumentTypes[i].equals(CONTINUATION_CLASS_TYPE)) {
                continue;
            }
            if (idx != -1) {
                throw new IllegalArgumentException("Multiple Continuation arguments found in method " + methodNode.name);
            }
            idx = i;
        }
        return isStatic ? idx : idx + 1;
    }

    private VariableCache allocateCacheSlots(final VariableLUT varLUT,
                                             final List<AbstractInsnNode> continueInvocationInsnNodes) {
        final VariableCache cache = new VariableCache();
        for (final AbstractInsnNode insnNode : continueInvocationInsnNodes) {
            final Type returnType = MethodInsnUtils.getReturnTypeOfInvocation(insnNode);
            if (returnType.getSort() == Type.VOID) {
                continue;
            }
            final Class<?> matchType = TypeTranslationUtils.sortToClass(returnType);
            if (matchType == null) {
                throw new IllegalArgumentException("Unsupported type");
            }
            cache.put(returnType, varLUT.allocExtra(matchType));
        }
        return cache;
    }

    private PrimitiveStack allocateLVASlots(final VariableLUT varLUT,
                                            final List<AbstractInsnNode> continueInvocationInsnNodes,
                                            final List<AbstractInsnNode> suspendCallInsnNodes,
                                            final Frame<BasicValue>[] frames,
                                            final MethodNode methodNode) {
        final PrimitiveStack LVA = new PrimitiveStack();
        for (final AbstractInsnNode insnNode : CollectionUtils.union(continueInvocationInsnNodes, suspendCallInsnNodes)) {
            final Frame<BasicValue> frame = frames[methodNode.instructions.indexOf(insnNode)];
            for (int i = 0; i < frame.getLocals(); i++) {
                final Type type = frame.getLocal(i).getType();
                if (type == null || "Lnull;".equals(type.getDescriptor())) {
                    continue;
                }
                final Class<?> matchType = TypeTranslationUtils.sortToArrayClass(type);
                if (matchType == null) {
                    throw new IllegalArgumentException("Unsupported type");
                }
                LVA.put(type, varLUT.allocExtra(matchType));
            }
        }
        return LVA;
    }

    private PrimitiveStack allocateOSSlots(final VariableLUT varLUT,
                                           final List<AbstractInsnNode> continueInvocationInsnNodes,
                                           final List<AbstractInsnNode> suspendCallInsnNodes,
                                           final Frame<BasicValue>[] frames,
                                           final MethodNode methodNode) {
        final PrimitiveStack LVA = new PrimitiveStack();
        for (final AbstractInsnNode insnNode : CollectionUtils.union(continueInvocationInsnNodes, suspendCallInsnNodes)) {
            final Frame<BasicValue> frame = frames[methodNode.instructions.indexOf(insnNode)];
            for (int i = 0; i < frame.getStackSize(); i++) {
                final Type type = frame.getStack(i).getType();
                if ("Lnull;".equals(type.getDescriptor())) {
                    continue;
                }
                final Class<?> matchType = TypeTranslationUtils.sortToClass(type);
                if (matchType == null) {
                    throw new IllegalArgumentException("Unsupported type");
                }
                LVA.put(type, varLUT.allocExtra(matchType));
            }
        }
        return LVA;
    }

    private List<? extends ContinuationPoint> createSuspendContinuationPoints(List<AbstractInsnNode> suspendCallInsnNodes,
                                                                              final Frame<BasicValue>[] frames,
                                                                              final MethodNode methodNode) {
        return suspendCallInsnNodes.stream().map((final AbstractInsnNode insnNode) -> {
            final LineNumberNode lineNumberNode = getLineNumberForInsn(methodNode.instructions, insnNode);
            return new SuspendMethodContinuationPoint(
                    lineNumberNode != null ? lineNumberNode.line : null,
                    (MethodInsnNode) insnNode,
                    frames[methodNode.instructions.indexOf(insnNode)]
            );
        }).toList();
    }

    private List<? extends ContinuationPoint> createInvokeContinuationPoints(final List<AbstractInsnNode> continueInvocationInsnNodes,
                                                                             final Frame<BasicValue>[] frames,
                                                                             final MethodNode methodNode) {
        return continueInvocationInsnNodes.stream().map((final AbstractInsnNode insnNode) -> {
            LineNumberNode lineNumberNode = getLineNumberForInsn(methodNode.instructions, insnNode);
            return new InvokeContinuationPoint(
                    lineNumberNode != null ? lineNumberNode.line : null,
                    (MethodInsnNode) insnNode,
                    frames[methodNode.instructions.indexOf(insnNode)]
            );
        }).toList();
    }

    public static List<AbstractInsnNode> findInvocationsWithParameter(InsnList insnList,
                                                                      Type expectedParamType) {
        if (insnList == null) {
            throw new IllegalArgumentException("Instruction list cannot be null");
        } else if (expectedParamType == null) {
            throw new IllegalArgumentException("Parameter type cannot be null");
        } else if (expectedParamType.getSort() == Type.METHOD || expectedParamType.getSort() == Type.VOID) {
            throw new IllegalArgumentException("Parameter type cannot be METHOD or VOID");
        }
        List<AbstractInsnNode> ret = new ArrayList<>();
        for (final AbstractInsnNode instructionNode : insnList) {
            Type[] methodParamTypes;
            if (instructionNode instanceof MethodInsnNode methodInsnNode) {
                final Type methodType = Type.getType(methodInsnNode.desc);
                methodParamTypes = methodType.getArgumentTypes();
            } else if (instructionNode instanceof InvokeDynamicInsnNode invokeDynamicInsnNode) {
                final Type methodType = Type.getType(invokeDynamicInsnNode.desc);
                methodParamTypes = methodType.getArgumentTypes();
            } else {
                continue;
            }
            if (Arrays.asList(methodParamTypes).contains(expectedParamType)) {
                ret.add(instructionNode);
            }
        }
        return ret;
    }

    private List<AbstractInsnNode> findInvocationsOf(final InsnList insnList,
                                                     final Method method) {
        return StreamSupport.stream(insnList.spliterator(), false)
                .filter(MethodInsnNode.class::isInstance)
                .filter((final AbstractInsnNode insnNode) -> {
                    final MethodInsnNode methodInsnNode = (MethodInsnNode) insnNode;
                    final Type methodDesc = Type.getType(methodInsnNode.desc);
                    final Type methodOwner = Type.getObjectType(methodInsnNode.owner);
                    return methodDesc.equals(Type.getType(method))
                            && methodOwner.equals(Type.getType(method.getDeclaringClass()));
                }).toList();
    }

    private LineNumberNode getLineNumberForInsn(final InsnList insnList,
                                                final AbstractInsnNode insnNode) {
        final ListIterator<AbstractInsnNode> insnIterator = insnList.iterator(insnList.indexOf(insnNode));
        while (insnIterator.hasPrevious()) {
            AbstractInsnNode node = insnIterator.previous();
            if (node instanceof LineNumberNode lineNumberNode) {
                return lineNumberNode;
            }
        }
        return null;
    }
}
