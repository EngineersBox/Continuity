package com.engineersbox.continuity.instrumenter.bytecode.builders;

import com.engineersbox.continuity.instrumenter.bytecode.BytecodeBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.InsnListBuilder;
import com.engineersbox.continuity.instrumenter.lang.transform.stdlib.annotation.StdlibBuilder;
import com.engineersbox.continuity.instrumenter.lang.transform.stdlib.annotation.StdlibBuilderParam;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.LineNumberNode;

@StdlibBuilder(methodName = "lineNumber")
public class LineNumberBuilder implements BytecodeBuilder {

    private int number;

    public LineNumberBuilder() {}

    public LineNumberBuilder lineNumber(@StdlibBuilderParam(pos = 0) final int number) {
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
