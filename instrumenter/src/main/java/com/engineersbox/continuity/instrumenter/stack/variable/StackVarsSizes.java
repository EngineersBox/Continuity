package com.engineersbox.continuity.instrumenter.stack.variable;

public record StackVarsSizes(int intsSize,
                             int floatsSize,
                             int longsSize,
                             int doublesSize,
                             int objectsSize) {
}
