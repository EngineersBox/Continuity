package com.engineersbox.continuity.instrumenter.util;

import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.InvokeDynamicInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;

public class MethodInsnUtils {
    public static Type getReturnTypeOfInvocation(AbstractInsnNode invokeNode) {
        if (invokeNode == null) {
            throw new IllegalArgumentException("InsnNode cannot be null");
        } else  if (invokeNode instanceof MethodInsnNode methodInsnNode) {
            return Type.getType(methodInsnNode.desc).getReturnType();
        } else if (invokeNode instanceof InvokeDynamicInsnNode invokeDynamicInsnNode) {
            return Type.getType(invokeDynamicInsnNode.desc).getReturnType();
        } else {
            throw new IllegalArgumentException("Unsupported node type");
        }
    }
}
