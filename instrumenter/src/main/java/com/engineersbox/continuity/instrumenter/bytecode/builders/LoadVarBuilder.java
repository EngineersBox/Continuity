package com.engineersbox.continuity.instrumenter.bytecode.builders;

import com.engineersbox.continuity.instrumenter.bytecode.BytecodeBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.InsnBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.InsnListBuilder;
import com.engineersbox.continuity.instrumenter.stack.storage.VariableLUT;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.VarInsnNode;

public class LoadVarBuilder implements BytecodeBuilder {

    private VariableLUT.Variable variable;

    public LoadVarBuilder() {}

    public LoadVarBuilder var(final VariableLUT.Variable variable) {
        if (variable == null) {
            throw new IllegalArgumentException("Variable must not be null");
        }
        this.variable = variable;
        return this;
    }

    private int getLoadOp(final int sort) {
        return switch (sort) {
            case Type.BOOLEAN, Type.BYTE, Type.CHAR, Type.SHORT, Type.INT -> Opcodes.ILOAD;
            case Type.LONG -> Opcodes.LLOAD;
            case Type.FLOAT -> Opcodes.FLOAD;
            case Type.DOUBLE -> Opcodes.DLOAD;
            case Type.ARRAY, Type.OBJECT -> Opcodes.ALOAD;
            default -> throw new IllegalArgumentException(String.format("Unsupported variable sort: %d", sort));
        };
    }

    @Override
    public InsnList build() {
        return InsnBuilder.combine(new VarInsnNode(
                getLoadOp(this.variable.getType().getSort()),
                this.variable.getIndex()
        )).build();
    }
}
