package com.engineersbox.continuity.instrumenter.stage;

import com.engineersbox.continuity.instrumenter.method.MethodContext;
import com.engineersbox.continuity.instrumenter.method.MethodIntrospector;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.HashSet;
import java.util.Set;

public class MethodIntrospectionStage implements InstrumentationStage {

    @Override
    public void invoke(final ClassNode node,
                       final InstrumentationContext context) {
        final MethodIntrospector introspector = new MethodIntrospector();
        Set<MethodNode> methodNodes = new HashSet<>(context.getMethods().keySet());
        for (final MethodNode methodNode : methodNodes) {
            final MethodContext<?> methodContext = introspector.introspect(node, methodNode);
            context.putMethod(methodNode, methodContext);
        }
    }

}
