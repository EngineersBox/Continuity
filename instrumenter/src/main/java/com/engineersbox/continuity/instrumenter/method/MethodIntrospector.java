package com.engineersbox.continuity.instrumenter.method;

import com.engineersbox.continuity.core.continuation.Continuation;
import com.engineersbox.continuity.instrumenter.stack.point.ContinuationPoint;
import com.engineersbox.continuity.instrumenter.stack.point.InvokeContinuationPoint;
import com.engineersbox.continuity.instrumenter.stack.point.SuspendMethodContinuationPoint;
import org.apache.commons.lang3.reflect.MethodUtils;
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

        /* TODO:
         *  1. Get invocation return types from continueInvocationInsnNodes
         *  2. Get types on LVA at suspend/continue points from union(continueInvocationInsnNodes, suspendInvocationInsnNodes)
         *  3. Get types on OS at suspend/continue points from union(continueInvocationInsnNodes, suspendInvocationInsnNodes)
         *  4. Find index of continuation object in LVA table
         *  5. Create variables for continuation argument and method state
         *  6. Create PrimitiveStack for LVA variables
         *  7. Create PrimitiveStack for OS variables
         *  8. Create PrimitiveContainerStack for container variables
         *  9. Create CacheStack for cache vars such as return values
         *  10. Construct MethodContext and return
         */

        return new MethodContext(
                new MethodSignature(
                    classNode.name,
                    methodNode.name,
                    Type.getMethodType(methodNode.desc)
                ),
                continuationPoints
        );
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
