package com.engineersbox.continuity.instrumenter.method;

import com.engineersbox.continuity.core.continuation.Continuation;
import com.engineersbox.continuity.core.method.MethodState;
import com.engineersbox.continuity.instrumenter.stack.ContextHandledTypes;
import com.engineersbox.continuity.instrumenter.stack.ContinuationPoint;
import com.engineersbox.continuity.instrumenter.stack.SuppressMethodContinuationPoint;
import com.engineersbox.continuity.instrumenter.stack.variable.PrimitiveStack;
import com.engineersbox.continuity.instrumenter.stack.variable.StackVarLUT;
import com.engineersbox.continuity.instrumenter.stack.variable.StackVariable;
import com.engineersbox.continuity.logger.LogFormatter;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.*;
import org.objectweb.asm.tree.analysis.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.StreamSupport;

public class MethodInstrospector {

    private static final Logger LOGGER = LogFormatter.getLogger(MethodInstrospector.class, Level.ALL);

    private static final String CONSTRUCTOR_METHOD_NAME = "<init>";
    private static final Method CONTINUATION_CLASS_TYPE = MethodUtils.getAccessibleMethod(Continuation.class, "suspend");

    public MethodInstrospector() {}

    public MethodContext introspect(final ClassNode classNode,
                                    final MethodNode methodNode) {
        if (methodNode.name.equals(CONSTRUCTOR_METHOD_NAME)) {
            throw new IllegalStateException("Cannot instrument constructor");
        }

        final List<AbstractInsnNode> suspendCallInsnNodes = findInvocationsOf(
                methodNode.instructions,
                CONTINUATION_CLASS_TYPE
        );
        final List<AbstractInsnNode> continuationCallInsnNodes = findInvocationsWithParameter(
                methodNode.instructions,
                Type.getType(CONTINUATION_CLASS_TYPE)
        );

        Frame<BasicValue>[] frames;
        try {
            frames = new Analyzer<>(new SimpleVerifier()).analyze(classNode.name, methodNode);
        } catch (final AnalyzerException e) {
            throw new IllegalArgumentException("Could not analyze method", e);
        }

        final List<SuppressMethodContinuationPoint> continuationPoints = suspendCallInsnNodes.stream().map((final AbstractInsnNode insnNode) -> {
            final MethodInsnNode node = (MethodInsnNode) insnNode;
            final LineNumberNode lineNumberNode = getLineNumberForInsn(methodNode.instructions, insnNode);
            return new SuppressMethodContinuationPoint(
                    lineNumberNode != null ? lineNumberNode.line : null,
                    node,
                    frames[methodNode.instructions.indexOf(insnNode)]
            );
        }).toList();

        final ContextHandledTypes handledTypesLVA = new ContextHandledTypes();
        for (final AbstractInsnNode invokeInsnNode : CollectionUtils.union(continuationCallInsnNodes, suspendCallInsnNodes)) {
            final Frame<BasicValue> frame = frames[methodNode.instructions.indexOf(invokeInsnNode)];
            LOGGER.fine(String.format("FRAME: %s", frame.toString()));
            for (int i = 0; i < frame.getLocals(); i++) {
                Type type = frame.getLocal(i).getType();
                if (type == null || type.getDescriptor().equals("Lnull;")) {
                    continue;
                }
                LOGGER.fine(String.format("  TYPE: %s", type.getDescriptor()));
                handledTypesLVA.trackType(type);
            }
        }

        final ContextHandledTypes handledTypesOS = new ContextHandledTypes();
        for (final AbstractInsnNode invokeInsnNode : CollectionUtils.union(continuationCallInsnNodes, suspendCallInsnNodes)) {
            final Frame<BasicValue> frame = frames[methodNode.instructions.indexOf(invokeInsnNode)];
            LOGGER.fine(String.format("FRAME: %s", frame.toString()));
            for (int i = 0; i < frame.getStackSize(); i++) {
                final Type type = frame.getStack(i).getType();
                if (type.getDescriptor().equals("Lnull;")) {
                    continue;
                }
                LOGGER.fine(String.format("  TYPE: %s", type.getDescriptor()));
                handledTypesOS.trackType(type);
            }
        }

        final int continuationArgIndex = 0;

        final StackVarLUT stackVarLUT = new StackVarLUT(classNode, methodNode);
        final StackVariable continuationVar = stackVarLUT.getArg(continuationArgIndex);
        final StackVariable methodStateVariable = stackVarLUT.obtainExtraArg(Type.getType(MethodState.class));

        final PrimitiveStack LVA = PrimitiveStack.allocateSlots(stackVarLUT, handledTypesLVA);
        final PrimitiveStack OS = PrimitiveStack.allocateSlots(stackVarLUT, handledTypesOS);

        return new MethodContext<>(
                continuationPoints,
                continuationVar,
                methodStateVariable,
                LVA,
                OS
        );
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

    public static List<AbstractInsnNode> findInvocationsWithParameter(final InsnList insnList,
                                                                      final Type expectedParamType) {
        if (expectedParamType.getSort() == Type.METHOD) {
            throw new IllegalArgumentException("Cannot find invocations for sort METHOD");
        } else if (expectedParamType.getSort() == Type.VOID) {
            throw new IllegalArgumentException("Cannot find invocations for sort VOID");
        }

        return StreamSupport.stream(insnList.spliterator(), false)
                .map((final AbstractInsnNode instructionNode) -> {
                    if (instructionNode instanceof MethodInsnNode methodInsnNode) {
                        Type methodType = Type.getType(methodInsnNode.desc);
                        return Pair.of(methodType.getArgumentTypes(), instructionNode);
                    } else if (instructionNode instanceof InvokeDynamicInsnNode invokeDynamicInsnNode) {
                        Type methodType = Type.getType(invokeDynamicInsnNode.desc);
                        return ImmutablePair.of(methodType.getArgumentTypes(), instructionNode);
                    }
                    return null;
                }).filter(Objects::nonNull)
                .filter((final Pair<Type[], AbstractInsnNode> pair) -> Arrays.asList(pair.getLeft()).contains(expectedParamType))
                .map(Pair::getRight)
                .toList();
    }

    private LineNumberNode getLineNumberForInsn(final InsnList insnList,
                                                final AbstractInsnNode insnNode) {
        int idx = insnList.indexOf(insnNode);
        ListIterator<AbstractInsnNode> insnIt = insnList.iterator(idx);
        while (insnIt.hasPrevious()) {
            AbstractInsnNode node = insnIt.previous();
            if (node instanceof LineNumberNode lineNumberNode) {
                return lineNumberNode;
            }
        }

        return null;
    }
}
