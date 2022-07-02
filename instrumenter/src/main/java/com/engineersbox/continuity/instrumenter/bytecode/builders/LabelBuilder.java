package com.engineersbox.continuity.instrumenter.bytecode.builders;

import com.engineersbox.continuity.instrumenter.bytecode.BytecodeBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.InsnListBuilder;
import com.engineersbox.continuity.instrumenter.lang.transform.stdlib.annotation.StdlibBuilder;
import com.engineersbox.continuity.instrumenter.lang.transform.stdlib.annotation.StdlibBuilderParam;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.LabelNode;

@StdlibBuilder(methodName = "label")
public class LabelBuilder implements BytecodeBuilder {

    private LabelNode label;

    public LabelBuilder() {}

    public LabelBuilder label(@StdlibBuilderParam(pos = 0) final LabelNode label) {
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
