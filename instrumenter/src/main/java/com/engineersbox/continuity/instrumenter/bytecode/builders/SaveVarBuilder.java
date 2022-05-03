package com.engineersbox.continuity.instrumenter.bytecode.builders;

import com.engineersbox.continuity.instrumenter.bytecode.BaseBytecodeBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.InsnListBuilder;
import com.engineersbox.continuity.instrumenter.stack.storage.VariableLUT;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.VarInsnNode;

public class SaveVarBuilder implements BaseBytecodeBuilder {

    private VariableLUT.Variable variable;

    public SaveVarBuilder() {}

    public SaveVarBuilder var(final VariableLUT.Variable variable) {
        if (variable == null) {
            throw new IllegalArgumentException("Variable must not be null");
        }
        this.variable = variable;
        return this;
    }

    private int getStoreOp(final int sort) {
        return switch (sort) {
            case Type.BOOLEAN, Type.BYTE, Type.CHAR, Type.SHORT, Type.INT -> Opcodes.ISTORE;
            case Type.LONG -> Opcodes.LSTORE;
            case Type.FLOAT -> Opcodes.FSTORE;
            case Type.DOUBLE -> Opcodes.DSTORE;
            case Type.ARRAY, Type.OBJECT -> Opcodes.ASTORE;
            default -> throw new IllegalArgumentException(String.format("Unsupported variable sort: %d", sort));
        };
    }

    @Override
    public InsnList build() {
        return new InsnListBuilder().addAll(new VarInsnNode(
                getStoreOp(this.variable.getType().getSort()),
                this.variable.getIndex()
        )).build();
    }
}
