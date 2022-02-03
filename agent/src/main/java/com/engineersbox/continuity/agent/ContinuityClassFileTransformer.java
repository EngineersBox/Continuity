package com.engineersbox.continuity.agent;

import com.engineersbox.continuity.instrumenter.Instrumenter;
import com.engineersbox.continuity.logger.LogFormatter;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContinuityClassFileTransformer implements ClassFileTransformer {

    private static final Logger LOGGER = LogFormatter.getLogger(ContinuityClassFileTransformer.class, Level.ALL);

    private static final String CONTINUITY_CORE_PACKAGE = "com/engineersbox/continuity/core";
    private static final String TEST_MAIN = CONTINUITY_CORE_PACKAGE + "/Main";

    public ContinuityClassFileTransformer() {}

    @Override
    @SuppressWarnings({"java:S1181", "java:S106"})
    public byte[] transform(final ClassLoader loader,
                            final String className,
                            final Class<?> classBeingRedefined,
                            final ProtectionDomain protectionDomain,
                            final byte[] classBytes) {
        if (className == null || loader == null || (className.startsWith(CONTINUITY_CORE_PACKAGE) && !className.startsWith(TEST_MAIN))) {
            return null;
        }
        LOGGER.info(className);
        try {
            final Instrumenter instrumenter = new Instrumenter();
            return instrumenter.instrument(classBytes);
        } catch (final Throwable e) {
            System.err.println("Could not instrument for continuity: " + e.getMessage());
            return null;
        }
    }
}
