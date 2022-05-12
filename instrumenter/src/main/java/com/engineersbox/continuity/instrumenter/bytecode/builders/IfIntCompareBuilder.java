package com.engineersbox.continuity.instrumenter.bytecode.builders;

import com.engineersbox.continuity.instrumenter.bytecode.BytecodeBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.InsnBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.annotation.BytecodeGenerator;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;

@BytecodeGenerator
public class IfIntCompareBuilder implements BytecodeBuilder {

    private InsnList lhsArg;
    private InsnList rhsArg;
    private InsnList trueAction;
    private int comparisonOpcode;

    public IfIntCompareBuilder() {}

    public IfIntCompareBuilder lhs(final InsnList lhsArg) {
        if (lhsArg == null) {
            throw new IllegalArgumentException("Left hand side of comparison cannot be null for primitive int");
        }
        this.lhsArg = lhsArg;
        return this;
    }

    public IfIntCompareBuilder rhs(final InsnList rhsArg) {
        if (rhsArg == null) {
            throw new IllegalArgumentException("Right hand side of comparison cannot be null for primitive int");
        }
        this.rhsArg = rhsArg;
        return this;
    }

    public IfIntCompareBuilder action(final InsnList trueAction) {
        if (trueAction == null) {
            throw new IllegalArgumentException("Action to perform when comparison true cannot be null");
        }
        this.trueAction = trueAction;
        return this;
    }

    public IfIntCompareBuilder invertedComparisonType(final int comparisonOpcode) {
        this.comparisonOpcode = comparisonOpcode;
        return this;
    }

    @Override
    public InsnList build() {
        final LabelNode neqLabel = new LabelNode();
        return InsnBuilder.combine(
                this.lhsArg,
                this.rhsArg,
                new JumpInsnNode(this.comparisonOpcode, neqLabel),
                this.trueAction,
                neqLabel
        ).build();
    }
}
