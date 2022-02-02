package com.engineersbox.continuity.agent;

import com.engineersbox.continuity.instrumenter.Instrumenter;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

public class ContinuityClassFileTransformer implements ClassFileTransformer {

    private static final String CONTINUITY_CORE_PACKAGE = "com/engineersbox/continuity/core";

    public ContinuityClassFileTransformer() {}

    @Override
    public byte[] transform(final ClassLoader loader,
                            final String className,
                            final Class<?> classBeingRedefined,
                            final ProtectionDomain protectionDomain,
                            final byte[] classBytes) {
        if (className == null || className.startsWith(CONTINUITY_CORE_PACKAGE) || loader == null) {
            return null;
        }
        try {
            final Instrumenter instrumenter = new Instrumenter();
            return instrumenter.instrument(classBytes);
        } catch (final Throwable e) {
            System.err.println("Could not instrument for continuity: " + e.getMessage());
            return null;
        }
    }
}
