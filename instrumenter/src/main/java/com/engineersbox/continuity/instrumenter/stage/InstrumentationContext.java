package com.engineersbox.continuity.instrumenter.stage;

import org.objectweb.asm.tree.MethodNode;

import java.util.HashMap;
import java.util.Map;

public class InstrumentationContext {

    private final Map<MethodNode, String> methods;

    public InstrumentationContext() {
        this.methods = new HashMap<>();
    }

    public void putMethod(final MethodNode node,
                          final String context) {
        this.methods.put(node, context);
    }
}
