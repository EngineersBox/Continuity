package com.engineersbox.continuity.instrumenter.stage;

import com.engineersbox.continuity.instrumenter.method.MethodContext;
import org.objectweb.asm.tree.MethodNode;

import java.util.HashMap;
import java.util.Map;

public class InstrumentationContext {

    private final Map<MethodNode, MethodContext<?>> methods;

    public InstrumentationContext() {
        this.methods = new HashMap<>();
    }

    public void putMethod(final MethodNode node,
                          final MethodContext<?> context) {
        this.methods.put(node, context);
    }

    public Map<MethodNode, MethodContext<?>> getMethods() {
        return this.methods;
    }
}
