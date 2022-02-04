package com.engineersbox.continuity.instrumenter.stack.variable;

import org.objectweb.asm.Type;

public record StackVariable(Type type,
                            int index,
                            boolean used) {
    public Type getType() {
        return this.type;
    }

    public int getIndex() {
        return this.index;
    }

    public boolean isUsed() {
        return this.used;
    }
}
