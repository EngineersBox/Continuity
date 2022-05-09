package com.engineersbox.continuity.instrumenter.method;

import com.engineersbox.continuity.core.continuation.Continuation;
import com.engineersbox.continuity.core.method.MethodState;
import com.engineersbox.continuity.instrumenter.bytecode.ObjectConstants;
import com.engineersbox.continuity.instrumenter.stack.ContinuityVariables;
import com.engineersbox.continuity.instrumenter.stack.point.ContinuationPoint;
import com.engineersbox.continuity.instrumenter.stack.point.InvokeContinuationPoint;
import com.engineersbox.continuity.instrumenter.stack.point.SuspendMethodContinuationPoint;
import com.engineersbox.continuity.instrumenter.stack.storage.PrimitiveContainerStack;
import com.engineersbox.continuity.instrumenter.stack.storage.PrimitiveStack;
import com.engineersbox.continuity.instrumenter.stack.storage.VariableCache;
import com.engineersbox.continuity.instrumenter.stack.storage.VariableLUT;
import com.engineersbox.continuity.instrumenter.util.InsnUtils;
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
    private static final Type CONTINUATION_CLASS_TYPE = Type.getType(Continuation.class);
    private static final Method CONTINUATION_SUSPEND_METHOD = MethodUtils.getAccessibleMethod(Continuation.class, "suspend");

    public MethodContext introspect(final ClassNode classNode,
                                    final MethodNode methodNode) {
        if (methodNode.name.equals(ObjectConstants.CONSTRUCTOR_METHOD_NAME)) {
            throw new IllegalStateException(String.format(
                    "Cannot instrument constructor: %s",
                    methodNode.signature
            ));
        }
        final List<AbstractInsnNode> suspendCallInsnNodes = MethodInsnUtils.getInvocation(
                methodNode.instructions,
                CONTINUATION_SUSPEND_METHOD
        );
        final List<AbstractInsnNode> continueInvocationInsnNodes = MethodInsnUtils.getInvocationWithParameterType(
                methodNode.instructions,
                CONTINUATION_CLASS_TYPE
        );
        LOGGER.trace("Suspend call count: {}", suspendCallInsnNodes.size());
        LOGGER.trace("Continuation parameterised call count: {}", continueInvocationInsnNodes.size());

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
        final PrimitiveStack lva = allocateLVASlots(
                varLUT,
                continueInvocationInsnNodes,
                suspendCallInsnNodes,
                frames,
                methodNode
        );
        final PrimitiveStack os = allocateOSSlots(
                varLUT,
                continueInvocationInsnNodes,
                suspendCallInsnNodes,
                frames,
                methodNode
        );
        final PrimitiveContainerStack containerStack = new PrimitiveContainerStack(varLUT.allocExtra(Object[].class));

        final ContinuityVariables continuityVariables = new ContinuityVariables(
                varLUT.getArgument(getContinuationLVAIndex(methodNode)),
                varLUT.allocExtra(MethodState.class)
        );

        return new MethodContext(
                new MethodSignature(
                        classNode.name,
                        methodNode.name,
                        Type.getMethodType(methodNode.desc),
                    1
                ),
                continuationPoints,
                cache,
                lva,
                os,
                containerStack,
                continuityVariables
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
        final PrimitiveStack lva = new PrimitiveStack();
        for (final AbstractInsnNode insnNode : CollectionUtils.union(continueInvocationInsnNodes, suspendCallInsnNodes)) {
            final Frame<BasicValue> frame = frames[methodNode.instructions.indexOf(insnNode)];
            for (int i = 0; i < frame.getLocals(); i++) {
                final Type type = frame.getLocal(i).getType();
                if (type == null || type.getDescriptor().equals(ObjectConstants.NULL_OBJ_DESCRIPTOR)) {
                    continue;
                }
                lva.put(type, varLUT.allocExtra(type));
            }
        }
        return lva;
    }

    private PrimitiveStack allocateOSSlots(final VariableLUT varLUT,
                                           final List<AbstractInsnNode> continueInvocationInsnNodes,
                                           final List<AbstractInsnNode> suspendCallInsnNodes,
                                           final Frame<BasicValue>[] frames,
                                           final MethodNode methodNode) {
        final PrimitiveStack os = new PrimitiveStack();
        for (final AbstractInsnNode insnNode : CollectionUtils.union(continueInvocationInsnNodes, suspendCallInsnNodes)) {
            final Frame<BasicValue> frame = frames[methodNode.instructions.indexOf(insnNode)];
            for (int i = 0; i < frame.getStackSize(); i++) {
                final Type type = frame.getStack(i).getType();
                if (type == null || type.getDescriptor().equals(ObjectConstants.NULL_OBJ_DESCRIPTOR)) {
                    continue;
                }
                os.put(type, varLUT.allocExtra(type));
            }
        }
        return os;
    }

    private List<? extends ContinuationPoint> createSuspendContinuationPoints(List<AbstractInsnNode> suspendCallInsnNodes,
                                                                              final Frame<BasicValue>[] frames,
                                                                              final MethodNode methodNode) {
        return suspendCallInsnNodes.stream().map((final AbstractInsnNode insnNode) -> {
            final LineNumberNode lineNumberNode = InsnUtils.getLineNumberForInsn(methodNode.instructions, insnNode);
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
            LineNumberNode lineNumberNode = InsnUtils.getLineNumberForInsn(methodNode.instructions, insnNode);
            return new InvokeContinuationPoint(
                    lineNumberNode != null ? lineNumberNode.line : null,
                    (MethodInsnNode) insnNode,
                    frames[methodNode.instructions.indexOf(insnNode)]
            );
        }).toList();
    }
}
