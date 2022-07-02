package com.engineersbox.continuity.instrumenter.bytecode.builders;

import com.engineersbox.continuity.instrumenter.bytecode.BytecodeBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.InsnBuilder;
import com.engineersbox.continuity.instrumenter.lang.transform.stdlib.annotation.StdlibBuilder;
import com.engineersbox.continuity.instrumenter.lang.transform.stdlib.annotation.StdlibBuilderParam;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.LdcInsnNode;

@StdlibBuilder(methodName = "constant")
public class ConstantBuilder implements BytecodeBuilder {

    private Object value;

    public ConstantBuilder() {}

    public ConstantBuilder constant(@StdlibBuilderParam(pos = 0) final Object value) {
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
