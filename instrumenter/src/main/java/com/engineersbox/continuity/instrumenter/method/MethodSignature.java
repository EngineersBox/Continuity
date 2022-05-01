package com.engineersbox.continuity.instrumenter.method;

import org.objectweb.asm.Type;

public record MethodSignature(String className,
                              String methodName,
                              Type descriptor) {
    public MethodSignature {
        if (descriptor.getSort() != Type.METHOD) {
            throw new IllegalArgumentException("Method descriptor must be of sort Type.METHOD");
        }
    }
}
