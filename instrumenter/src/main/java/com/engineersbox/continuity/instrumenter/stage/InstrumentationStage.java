package com.engineersbox.continuity.instrumenter.stage;

import org.objectweb.asm.tree.ClassNode;

public interface InstrumentationStage {
    void invoke(final ClassNode node, final InstrumentationStageContext context);
}
