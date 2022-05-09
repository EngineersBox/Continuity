package com.engineersbox.continuity.instrumenter.util;

import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InvokeDynamicInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.StreamSupport;

public class MethodInsnUtils {

    private MethodInsnUtils() {}

    public static Type getReturnTypeOfInvocation(AbstractInsnNode invokeNode) {
        return switch (invokeNode) {
            case MethodInsnNode methodInsnNode -> Type.getType(methodInsnNode.desc).getReturnType();
            case InvokeDynamicInsnNode invokeDynamicInsnNode -> Type.getType(invokeDynamicInsnNode.desc).getReturnType();
            case null -> throw new IllegalArgumentException("InsnNode cannot be null");
            default -> throw new IllegalArgumentException("Unsupported node type");
        };
    }

    public static List<AbstractInsnNode> getInvocationWithParameterType(final InsnList insnList,
                                                                        final Type expectedParamType) {
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

    public static List<AbstractInsnNode> getInvocation(final InsnList insnList,
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
}
