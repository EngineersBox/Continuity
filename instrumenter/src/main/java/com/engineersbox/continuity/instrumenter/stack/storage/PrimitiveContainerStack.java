package com.engineersbox.continuity.instrumenter.stack.storage;

import com.engineersbox.continuity.instrumenter.stack.storage.VariableLUT.Variable;
import org.objectweb.asm.Type;

public class PrimitiveContainerStack {
    private final Variable containerVariable;

    public PrimitiveContainerStack(final Variable containerVariable) {
        if (containerVariable == null) {
            throw new IllegalArgumentException("Container variable must not be null");
        } else if (containerVariable.getType().equals(Type.getType(Object[].class))) {
            throw new IllegalArgumentException("Container variable must be an Object[]");
        }
        this.containerVariable = containerVariable;
    }
    public Variable getContainerVar() {
        return this.containerVariable;
    }
}
