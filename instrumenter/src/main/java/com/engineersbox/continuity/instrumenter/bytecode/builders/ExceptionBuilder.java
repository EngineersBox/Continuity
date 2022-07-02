package com.engineersbox.continuity.instrumenter.bytecode.builders;

import com.engineersbox.continuity.instrumenter.bytecode.BytecodeBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.InsnListBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.ObjectConstants;
import com.engineersbox.continuity.instrumenter.lang.transform.stdlib.annotation.StdlibBuilder;
import com.engineersbox.continuity.instrumenter.lang.transform.stdlib.annotation.StdlibBuilderParam;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

@StdlibBuilder(methodName = "exception")
public class ExceptionBuilder implements BytecodeBuilder {

    private Class<? extends RuntimeException> exceptionClass;
    private String message;

    public ExceptionBuilder() {}

    public ExceptionBuilder exceptionClass(@StdlibBuilderParam(pos = 0)final Class<? extends RuntimeException> exceptionClass) {
        if (exceptionClass == null) {
            throw new IllegalArgumentException("Exception class cannot be null");
        }
        this.exceptionClass = exceptionClass;
        return this;
    }

    public ExceptionBuilder message(@StdlibBuilderParam(pos = 1) final String message) {
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
                        ObjectConstants.CONSTRUCTOR_METHOD_NAME,
                        ObjectConstants.STRING_PARAMETER_METHOD_SIGNATURE,
                        false
                ), new InsnNode(Opcodes.ATHROW)
        ).build();
    }
}
