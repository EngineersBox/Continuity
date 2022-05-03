package com.engineersbox.continuity.instrumenter.stage;

import com.engineersbox.continuity.instrumenter.clazz.ClassInstrumenter;
import com.engineersbox.continuity.instrumenter.method.MethodContext;
import com.engineersbox.continuity.instrumenter.method.MethodInstrumenter;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.HashSet;

public class BytecodeInjectionStage implements InstrumentationStage {
    @Override
    public void invoke(final ClassNode classNode,
                       final InstrumentationStageContext context) {
        if (classNode == null) {
            throw new IllegalArgumentException("ClassNode cannot be null");
        } else if (context == null) {
            throw new IllegalStateException("Context cannot be null");
        } else if (!new HashSet<>(classNode.methods).containsAll(context.getMethods().keySet())) {
            throw new IllegalStateException("Target instrumenting methods are not present in the ClassNode");
        }
        final MethodInstrumenter methodInstrumenter = new MethodInstrumenter();
        context.getMethods().forEach((final MethodNode methodNode, final MethodContext methodContext) ->
                methodInstrumenter.instrument(classNode, methodNode, methodContext));
        final ClassInstrumenter classInstrumenter = new ClassInstrumenter();
        classInstrumenter.instrument(classNode);
    }
}
