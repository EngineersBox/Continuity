package com.engineersbox.continuity.instrumenter.stage;

import com.engineersbox.continuity.instrumenter.method.MethodContext;
import org.objectweb.asm.tree.MethodNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InstrumentationStageContext {
    private final Map<MethodNode, MethodContext> methods;

    public InstrumentationStageContext() {
        this.methods = new HashMap<>();
    }

    public void putMethod(final MethodNode node,
                          final MethodContext context) {
        this.methods.put(node, context);
    }

    public Map<MethodNode, MethodContext> getMethods() {
        return this.methods;
    }
}
