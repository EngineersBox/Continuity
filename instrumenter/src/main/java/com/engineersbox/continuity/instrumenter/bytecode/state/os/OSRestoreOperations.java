package com.engineersbox.continuity.instrumenter.bytecode.state.os;

import com.engineersbox.continuity.instrumenter.bytecode.InsnBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.annotation.BytecodeGenerator;
import com.engineersbox.continuity.instrumenter.stack.storage.PrimitiveStack;
import com.engineersbox.continuity.instrumenter.stage.DebugMarker;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.analysis.BasicValue;
import org.objectweb.asm.tree.analysis.Frame;

@BytecodeGenerator
public class OSRestoreOperations {

    private OSRestoreOperations() {}

    public static InsnList restore(final DebugMarker markerType,
                                   final PrimitiveStack os,
                                   final Frame<BasicValue> frame) {
        return restore(
                markerType,
                os,
                frame,
                0,
                0,
                frame.getMaxStackSize()
        );
    }

    public static InsnList restore(final DebugMarker markerType,
                                   final PrimitiveStack os,
                                   final Frame<BasicValue> frame,
                                   final int osStartIndex,
                                   final int osLoadIndex,
                                   final int count) {
        return InsnBuilder.combine(
                
        ).build();
    }

}
