package com.engineersbox.continuity.instrumenter.stack.storage;

import org.objectweb.asm.Type;

import java.util.List;

public class VariableLUT {

    private List<Variable> argVars;
    private int otherOffset;
    private List<Variable> otherVars;

    public final class Variable {
        private final Type type;
        private final int index;
        private final boolean used;

        private Variable(final Type type,
                         final int index,
                         final boolean used) {
            this.type = type;
            this.index = index;
            this.used = used;
        }

        public Type getType() {
            if (!this.used) {
                throw new IllegalStateException("Variable has been released");
            }
            return type;
        }

        public int getIndex() {
            if (!this.used) {
                throw new IllegalStateException("Variable has been released");
            }
            return index;
        }

        public boolean isUsed() {
            return used;
        }

        private VariableLUT getParent() {
            return VariableLUT.this;
        }
    }
}
