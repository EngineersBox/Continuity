package com.engineersbox.continuity.instrumenter.method.bytecode;

import com.engineersbox.continuity.instrumenter.bytecode.Retriever;
import com.engineersbox.continuity.instrumenter.bytecode.annotation.BytecodeGenerator;
import com.engineersbox.continuity.instrumenter.method.MethodContext;
import com.engineersbox.continuity.instrumenter.stack.point.ContinuationPoint;
import com.engineersbox.continuity.instrumenter.stack.point.SuspendMethodContinuationPoint;
import org.objectweb.asm.tree.InsnList;

@BytecodeGenerator
public class SaveOperations {

    public static InsnList constructSaveBytecode(final MethodContext methodContext,
                                                 final int index) {
        final ContinuationPoint point = Retriever.getContinuationPoint(
                methodContext,
                index,
                SuspendMethodContinuationPoint.class
        );
        return new InsnList();
    }

}
