package com.engineersbox.continuity.instrumenter.bytecode.builders;

import com.engineersbox.continuity.instrumenter.bytecode.BytecodeBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.InsnListBuilder;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;

public class JumpBuilder implements BytecodeBuilder {

    private LabelNode label;

    public JumpBuilder() {}

    public JumpBuilder label(final LabelNode label) {
        this.label = label;
        return this;
    }

    @Override
    public InsnList build() {
        return new InsnListBuilder()
                .addAll(new JumpInsnNode(Opcodes.GOTO, this.label))
                .build();
    }
}
