package com.engineersbox.continuity.instrumenter.stage;

import org.objectweb.asm.tree.ClassNode;

public class InstructionInsertionStage implements InstrumentationStage {

    @Override
    public void invoke(final ClassNode node, final InstrumentationContext context) {
        /* Saving: method_save_state_instrumenting.md
         * Loading: method_load_sate_instrumenting.md
         */
    }

}
