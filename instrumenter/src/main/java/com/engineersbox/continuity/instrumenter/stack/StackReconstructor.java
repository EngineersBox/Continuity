package com.engineersbox.continuity.instrumenter.stack;

import com.engineersbox.continuity.instrumenter.clazz.CoreClassNode;
import com.engineersbox.continuity.instrumenter.clazz.CoreClassWriter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

public class StackReconstructor {

    private StackReconstructor() {}

    public static ClassNode reconstructStackMapFrames(final ClassNode classNode) {
        classNode.methods.stream()
                .filter((final MethodNode methodNode) -> methodNode.instructions != null)
                .forEach(StackReconstructor::removeStackFrame);

        return constructClassWithComputerFrames(classNode);
    }

    private static void removeStackFrame(final MethodNode methodNode) {
        AbstractInsnNode insn = methodNode.instructions.getFirst();
        while (insn != null) {
            final AbstractInsnNode nextInsn = insn.getNext();
            if (insn.getType() == AbstractInsnNode.FRAME) {
                methodNode.instructions.remove(insn);
            }
            insn = nextInsn;
        }
    }

    private static ClassNode constructClassWithComputerFrames(final ClassNode classNode) {
        final ClassWriter classWriter = new CoreClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
        classNode.accept(classWriter);

        final ClassReader classReader = new ClassReader(classWriter.toByteArray());
        final ClassNode newClassNode = new CoreClassNode();
        classReader.accept(newClassNode, 0);

        return newClassNode;
    }
}
