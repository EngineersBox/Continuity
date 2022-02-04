package com.engineersbox.continuity.instrumenter.stack;

import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.analysis.BasicValue;
import org.objectweb.asm.tree.analysis.Frame;

public interface ContinuationPoint {
    Integer getLineNumber();
    MethodInsnNode getInvokeInstruction();
    LabelNode getContinueExecutionLabel();
    Frame<BasicValue> getFrame();
}
