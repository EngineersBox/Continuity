package com.engineersbox.continuity.agent;

import java.lang.instrument.Instrumentation;

public class ContinuityAgent {

    private ContinuityAgent() {}

    public static void premain(final String args,
                               final Instrumentation instrumentation) {
        instrumentation.addTransformer(new ContinuityClassFileTransformer());
    }

}
