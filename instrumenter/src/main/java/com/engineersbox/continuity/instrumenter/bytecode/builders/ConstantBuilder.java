package com.engineersbox.continuity.instrumenter.bytecode.builders;

import com.engineersbox.continuity.instrumenter.bytecode.BytecodeBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.InsnBuilder;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.LdcInsnNode;

public class ConstantBuilder implements BytecodeBuilder {

    private Object value;

    public ConstantBuilder() {}

    public ConstantBuilder constant(final Object value) {
        if (value == null) {
            throw new IllegalArgumentException("Constant value cannot be null");
        }
        this.value = value;
        return this;
    }

    @Override
    public InsnList build() {
        return InsnBuilder.combine(
                new LdcInsnNode(this.value)
        ).build();
    }
}
