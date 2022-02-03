package com.engineersbox.continuity.instrumenter.stage;

import com.engineersbox.continuity.instrumenter.method.MethodInstrospector;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.HashSet;
import java.util.Set;

public class MethodIntrospectionStage implements InstrumentationStage {

    @Override
    public void invoke(final ClassNode node,
                       final InstrumentationContext context) {
        final MethodInstrospector introspector = new MethodInstrospector();
        Set<MethodNode> methodNodes = new HashSet<>(context.getMethods().keySet());
        for (final MethodNode methodNode : methodNodes) {
            introspector.introspect(node, methodNode);
        }
    }

}
