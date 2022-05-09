package com.engineersbox.continuity.agent;

import com.engineersbox.continuity.instrumenter.ContinuityInstrumenter;
import com.engineersbox.continuity.instrumenter.Instrumenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ContinuityClassFileTransformer implements ClassFileTransformer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContinuityClassFileTransformer.class);

    private static final String CONTINUITY_CORE_PACKAGE = "com/engineersbox/continuity/core";
    private static final String TEST_MAIN = CONTINUITY_CORE_PACKAGE + "/Main";

    @SuppressWarnings("java:S1181")
    @Override
    public byte[] transform(final ClassLoader loader,
                            final String className,
                            final Class<?> classBeingRedefined,
                            final ProtectionDomain protectionDomain,
                            final byte[] classfileBuffer) {
        if (className == null
            || loader == null
            || (
                className.startsWith(CONTINUITY_CORE_PACKAGE)
                && !className.startsWith(TEST_MAIN)
            )) {
            return null;
        }
        LOGGER.debug("Transforming: {}", className);
        try {
            final Instrumenter instrumenter = new ContinuityInstrumenter();
            return instrumenter.instrument(classfileBuffer);
        } catch (final Throwable e) {
            LOGGER.error(
                    "{}\n\t{}",
                    e,
                    Arrays.stream(e.getStackTrace())
                            .map(StackTraceElement::toString)
                            .collect(Collectors.joining("\n\t"))
            );
            return null;
        }
    }

}
