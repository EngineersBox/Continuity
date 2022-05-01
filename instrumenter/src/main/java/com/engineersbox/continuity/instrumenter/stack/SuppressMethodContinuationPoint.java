package com.engineersbox.continuity.instrumenter.stack;

import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.analysis.BasicValue;
import org.objectweb.asm.tree.analysis.Frame;

public class SuppressMethodContinuationPoint implements ContinuationPoint {

    private final int lineNumber;
    private final MethodInsnNode invokeInstruction;
    private final LabelNode label;
    private final Frame<BasicValue> frame;

    public SuppressMethodContinuationPoint(final int lineNumber,
                                           final MethodInsnNode invokeInstruction,
                                           final Frame<BasicValue> frame) {
        this.lineNumber = lineNumber;
        this.invokeInstruction = invokeInstruction;
        this.label = new LabelNode();
        this.frame = frame;
    }

    @Override
    public Integer getLineNumber() {
        return this.lineNumber;
    }

    @Override
    public MethodInsnNode getInvokeInstruction() {
        return this.invokeInstruction;
    }

    @Override
    public LabelNode getContinueExecutionLabel() {
        return this.label;
    }

    @Override
    public Frame<BasicValue> getFrame() {
        return this.frame;
    }
}
