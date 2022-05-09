package com.engineersbox.continuity.instrumenter.bytecode.builders;

import com.engineersbox.continuity.instrumenter.bytecode.BytecodeBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.InsnBuilder;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;

public class DummyReturnBuilder implements BytecodeBuilder {

    private Type returnType;

    public DummyReturnBuilder() {}

    public DummyReturnBuilder dummyType(final Type returnType) {
        if (returnType == null) {
            throw new IllegalArgumentException("Return type cannot be null");
        } else if (returnType.getSort() == Type.METHOD) {
            throw new IllegalArgumentException("Return type cannot be a method");
        }
        this.returnType = returnType;
        return this;
    }

    @Override
    public InsnList build() {
        return switch (returnType.getSort()) {
            case Type.VOID -> InsnBuilder.combine(new InsnNode(Opcodes.RETURN)).build();
            case Type.BOOLEAN, Type.BYTE, Type.SHORT, Type.CHAR, Type.INT -> InsnBuilder.combine(
                    new InsnNode(Opcodes.ICONST_0),
                    new InsnNode(Opcodes.IRETURN)
            ).build();
            case Type.LONG -> InsnBuilder.combine(
                    new InsnNode(Opcodes.LCONST_0),
                    new InsnNode(Opcodes.LRETURN)
            ).build();
            case Type.FLOAT -> InsnBuilder.combine(
                    new InsnNode(Opcodes.FCONST_0),
                    new InsnNode(Opcodes.FRETURN)
            ).build();
            case Type.DOUBLE -> InsnBuilder.combine(
                    new InsnNode(Opcodes.DCONST_0),
                    new InsnNode(Opcodes.DRETURN)
            ).build();
            case Type.OBJECT, Type.ARRAY -> InsnBuilder.combine(
                    new InsnNode(Opcodes.ACONST_NULL),
                    new InsnNode(Opcodes.ARETURN)
            ).build();
            default -> throw new IllegalStateException();
        };
    }
}
