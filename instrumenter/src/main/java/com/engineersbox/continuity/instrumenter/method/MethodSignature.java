package com.engineersbox.continuity.instrumenter.method;

import org.objectweb.asm.Type;

public record MethodSignature(String className,
                              String methodName,
                              Type methodDescriptor) {

    public MethodSignature {
        if (methodDescriptor.getSort() != Type.METHOD) {
            throw new IllegalArgumentException("Method descriptor must be of sort Type.METHOD");
        }
    }

}
