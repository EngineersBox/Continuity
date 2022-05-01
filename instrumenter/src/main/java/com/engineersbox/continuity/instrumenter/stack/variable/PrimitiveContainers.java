package com.engineersbox.continuity.instrumenter.stack.variable;

import org.objectweb.asm.Type;

public record PrimitiveContainers(StackVariable containerVariable) {

    public PrimitiveContainers {
        if (!containerVariable.getType().equals(Type.getType(Object[].class))) {
            throw new IllegalArgumentException("Container variable must be of type Object[]");
        }
    }

    public static PrimitiveContainers allocateContainerSlots(final StackVarLUT stackVarLUT) {
        return new PrimitiveContainers(stackVarLUT.obtainExtraArg(Type.getType(Object[].class)));
    }
}
