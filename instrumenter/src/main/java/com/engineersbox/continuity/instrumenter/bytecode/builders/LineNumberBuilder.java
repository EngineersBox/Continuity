package com.engineersbox.continuity.instrumenter.bytecode.builders;

import com.engineersbox.continuity.instrumenter.bytecode.BytecodeBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.InsnListBuilder;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.LineNumberNode;

public class LineNumberBuilder implements BytecodeBuilder {

    private int number;

    public LineNumberBuilder() {}

    public LineNumberBuilder lineNumber(final int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Line number must be positive");
        }
        this.number = number;
        return this;
    }

    @Override
    public InsnList build() {
         final LabelNode labelNode = new LabelNode();
        return new InsnListBuilder().addAll(
                labelNode,
                new LineNumberNode(this.number, labelNode)
        ).build();
    }
}
