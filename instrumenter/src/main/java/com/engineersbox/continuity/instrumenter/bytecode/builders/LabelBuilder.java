package com.engineersbox.continuity.instrumenter.bytecode.builders;

import com.engineersbox.continuity.instrumenter.bytecode.BytecodeBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.InsnListBuilder;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.LabelNode;

public class LabelBuilder implements BytecodeBuilder {

    private LabelNode label;

    public LabelBuilder() {}

    public LabelBuilder label(final LabelNode label) {
        if (label == null) {
            throw new IllegalArgumentException("Label cannot be null");
        }
        this.label = label;
        return this;
    }

    @Override
    public InsnList build() {
        return new InsnListBuilder()
                .addAll(this.label)
                .build();
    }
}
