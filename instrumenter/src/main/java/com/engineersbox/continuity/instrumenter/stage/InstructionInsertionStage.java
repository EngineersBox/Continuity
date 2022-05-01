package com.engineersbox.continuity.instrumenter.stage;

import com.engineersbox.continuity.instrumenter.method.MethodContext;
import com.engineersbox.continuity.instrumenter.method.MethodInstrumenter;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.Map;

public class InstructionInsertionStage implements InstrumentationStage {

    @Override
    public void invoke(final ClassNode node,
                       final InstrumentationContext context) {
        /* Saving: method_save_state_instrumenting.md
         * Loading: method_load_sate_instrumenting.md
         */
        if (!node.methods.containsAll(context.getMethods().keySet())) {
            throw new IllegalStateException("Method set does not match declared methods on class");
        }
        final MethodInstrumenter instrumenter = new MethodInstrumenter();
        for (final Map.Entry<MethodNode, MethodContext<?>> method : context.getMethods().entrySet()) {
            instrumenter.instrument(
                    node,
                    method.getKey(),
                    method.getValue()
            );
        }
    }

}
