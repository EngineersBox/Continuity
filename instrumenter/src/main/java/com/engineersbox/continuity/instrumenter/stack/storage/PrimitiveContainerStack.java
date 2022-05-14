package com.engineersbox.continuity.instrumenter.stack.storage;

import com.engineersbox.continuity.instrumenter.stack.storage.VariableLUT.Variable;
import org.objectweb.asm.Type;

public record PrimitiveContainerStack(Variable containerVariable) {
    public PrimitiveContainerStack {
        if (containerVariable == null) {
            throw new IllegalArgumentException("Container variable must not be null");
        } else if (!containerVariable.getType().equals(Type.getType(Object[].class))) {
            throw new IllegalArgumentException("Container variable must be an Object[]");
        }
    }
}
