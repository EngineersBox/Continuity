package com.engineersbox.continuity.instrumenter.bytecode.builders;

import com.engineersbox.continuity.instrumenter.bytecode.BaseBytecodeBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.InsnListBuilder;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

public class ExceptionBuilder implements BaseBytecodeBuilder {

    private static final String CONSTRUCTOR_METHOD_NAME = "<init>";
    private static final String STRING_PARAMETER_METHOD_SIGNATURE = "(Ljava/lang/String;)V";

    private Class<? extends RuntimeException> exceptionClass;
    private String message;

    public ExceptionBuilder() {}

    public ExceptionBuilder exceptionClass(final Class<? extends RuntimeException> exceptionClass) {
        if (exceptionClass == null) {
            throw new IllegalArgumentException("Exception class cannot be null");
        }
        this.exceptionClass = exceptionClass;
        return this;
    }

    public ExceptionBuilder message(final String message) {
        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null");
        }
        this.message = message;
        return this;
    }

    @Override
    public InsnList build() {
        final String pathCanonicalName = this.exceptionClass.getCanonicalName().replace('.', '/');
        return new InsnListBuilder().addAll(
                new TypeInsnNode(Opcodes.NEW, pathCanonicalName),
                new InsnNode(Opcodes.DUP),
                new LdcInsnNode(this.message),
                new MethodInsnNode(
                        Opcodes.INVOKESPECIAL,
                        pathCanonicalName,
                        CONSTRUCTOR_METHOD_NAME,
                        STRING_PARAMETER_METHOD_SIGNATURE,
                        false
                ), new InsnNode(Opcodes.ATHROW)
        ).build();
    }
}
