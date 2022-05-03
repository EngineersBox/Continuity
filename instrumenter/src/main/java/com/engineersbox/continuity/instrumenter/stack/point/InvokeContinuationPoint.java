package com.engineersbox.continuity.instrumenter.stack.point;

import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.analysis.BasicValue;
import org.objectweb.asm.tree.analysis.Frame;

public class InvokeContinuationPoint implements ContinuationPoint {
    private final Integer lineNumber;
    private final MethodInsnNode invokeInstruction;
    private final LabelNode label;
    private final Frame<BasicValue> frame;

    public InvokeContinuationPoint(final Integer lineNumber,
                                   final MethodInsnNode invokeInstruction,
                                   final Frame<BasicValue> frame) {
        if (invokeInstruction == null) {
            throw new IllegalArgumentException("Invoke instruction cannot be null");
        } else if (frame == null) {
            throw new IllegalArgumentException("Frame cannot be null");
        }
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
