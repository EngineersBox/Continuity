package com.engineersbox.continuity.instrumenter.method.bytecode;

import com.engineersbox.continuity.instrumenter.bytecode.InsnBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.Retriever;
import com.engineersbox.continuity.instrumenter.bytecode.annotation.BytecodeGenerator;
import com.engineersbox.continuity.instrumenter.method.MethodContext;
import com.engineersbox.continuity.instrumenter.stack.point.ContinuationPoint;
import com.engineersbox.continuity.instrumenter.stack.point.InvokeContinuationPoint;
import com.engineersbox.continuity.instrumenter.stack.point.SuspendMethodContinuationPoint;
import org.objectweb.asm.tree.InsnList;

@BytecodeGenerator
public class SaveOperations {

    private SaveOperations() {}

    public static InsnList constructSaveBytecode(final MethodContext methodContext,
                                                 final int index) {
        final ContinuationPoint point = Retriever.getContinuationPoint(
                methodContext,
                index,
                ContinuationPoint.class
        );
        if (point instanceof SuspendMethodContinuationPoint) {
            return constructSuspendSaveBytecode(methodContext, index);
        } else if (point instanceof InvokeContinuationPoint) {
            return constructInvokeSaveBytecode(methodContext, index);
        }
        throw new IllegalStateException(String.format(
                "Unknown continuation point type: %s",
                point.getClass().getName()
        ));
    }

    private static InsnList constructSuspendSaveBytecode(final MethodContext methodContext,
                                                         final int index) {
        return InsnBuilder.combine(

        ).build();
    }

    private static InsnList constructInvokeSaveBytecode(final MethodContext methodContext,
                                                        final int index) {
        return InsnBuilder.combine(

        ).build();
    }
}
