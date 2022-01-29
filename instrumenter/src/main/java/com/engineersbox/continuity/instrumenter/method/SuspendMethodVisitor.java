package com.engineersbox.continuity.instrumenter.method;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class SuspendMethodVisitor extends MethodVisitor {

    public SuspendMethodVisitor(final MethodVisitor methodVisitor) {
        super(Opcodes.ASM9, methodVisitor);
    }
}
