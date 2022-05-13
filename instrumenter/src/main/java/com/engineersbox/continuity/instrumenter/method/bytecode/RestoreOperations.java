package com.engineersbox.continuity.instrumenter.method.bytecode;

import com.engineersbox.continuity.instrumenter.bytecode.InsnBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.annotation.BytecodeGenerator;
import com.engineersbox.continuity.instrumenter.method.MethodContext;
import com.engineersbox.continuity.instrumenter.method.bytecode.annotation.ClassInstancedInvokable;
import com.engineersbox.continuity.instrumenter.stack.point.ContinuationPoint;
import com.engineersbox.continuity.instrumenter.stack.point.InvokeContinuationPoint;
import com.engineersbox.continuity.instrumenter.stack.point.SuspendMethodContinuationPoint;
import org.objectweb.asm.tree.InsnList;

@BytecodeGenerator
public final class RestoreOperations extends CoreOperations {

    private RestoreOperations() {}

    public static InsnList constructRestoreBytecode(final MethodContext methodContext,
                                                    final int index) {
        if (methodContext == null) {
            throw new IllegalArgumentException("Method context cannot be null");
        } else if (index < 0) {
            throw new IllegalArgumentException("Index cannot be negative");
        }
        final ContinuationPoint point = methodContext.getContinuationPointByClass(
                index,
                ContinuationPoint.class
        );
        return invokeInstanceDeterminedOperation(
                RestoreOperations.class,
                point.getClass(),
                methodContext,
                index
        );
    }

    @SuppressWarnings("unused")
    @ClassInstancedInvokable(SuspendMethodContinuationPoint.class)
    static InsnList constructSuspendRestoreBytecode(final MethodContext methodContext,
                                                    final int index) {
        return InsnBuilder.combine(

        ).build();
    }

    @SuppressWarnings("unused")
    @ClassInstancedInvokable(InvokeContinuationPoint.class)
    static InsnList constructInvokeRestoreBytecode(final MethodContext methodContext,
                                                   final int index) {
        return InsnBuilder.combine(

        ).build();
    }

}
