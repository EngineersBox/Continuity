package com.engineersbox.continuity.instrumenter.bytecode.state.lva;

import com.engineersbox.continuity.instrumenter.bytecode.InsnBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.annotation.BytecodeGenerator;
import com.engineersbox.continuity.instrumenter.stack.storage.PrimitiveStack;
import com.engineersbox.continuity.instrumenter.stage.DebugMarker;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.analysis.BasicValue;
import org.objectweb.asm.tree.analysis.Frame;

@BytecodeGenerator
public class LVASaveOperations {

    public static InsnList save(final DebugMarker markerType,
                                final PrimitiveStack lva,
                                final Frame<BasicValue> frame) {
        return InsnBuilder.combine(

        ).build();
    }

}
