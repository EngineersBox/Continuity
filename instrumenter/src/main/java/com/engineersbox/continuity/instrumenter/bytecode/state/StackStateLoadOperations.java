package com.engineersbox.continuity.instrumenter.bytecode.state;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public abstract class StackStateLoadOperations {

    protected static int mapTypeToLoadArrayInsn(final Type type) {
        return switch (type.getSort()) {
            case Type.BOOLEAN, Type.BYTE, Type.SHORT, Type.CHAR, Type.INT -> Opcodes.IALOAD;
            case Type.FLOAT -> Opcodes.FALOAD;
            case Type.LONG -> Opcodes.LALOAD;
            case Type.DOUBLE -> Opcodes.DALOAD;
            case Type.ARRAY, Type.OBJECT -> Opcodes.AALOAD;
            default -> throw new IllegalArgumentException("No such operand for type");
        };
    }

}
