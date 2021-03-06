package com.engineersbox.continuity.instrumenter.method.bytecode;

import com.engineersbox.continuity.core.annotation.BytecodeInternal;
import com.engineersbox.continuity.core.state.ContinuationState;
import com.engineersbox.continuity.instrumenter.bytecode.InsnBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.annotation.BytecodeGenerator;
import com.engineersbox.continuity.instrumenter.bytecode.state.lva.LVARestoreOperations;
import com.engineersbox.continuity.instrumenter.bytecode.state.os.OSRestoreOperations;
import com.engineersbox.continuity.instrumenter.method.MethodContext;
import com.engineersbox.continuity.instrumenter.method.bytecode.annotation.ClassInstancedInvokable;
import com.engineersbox.continuity.instrumenter.stack.point.ContinuationPoint;
import com.engineersbox.continuity.instrumenter.stack.point.InvokeContinuationPoint;
import com.engineersbox.continuity.instrumenter.stack.point.SuspendMethodContinuationPoint;
import com.engineersbox.continuity.instrumenter.stack.storage.PrimitiveStack;
import com.engineersbox.continuity.instrumenter.stack.storage.VariableLUT;
import com.engineersbox.continuity.instrumenter.bytecode.DebugMarker;
import com.engineersbox.continuity.instrumenter.util.InsnUtils;
import com.engineersbox.continuity.instrumenter.util.MethodInsnUtils;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.analysis.BasicValue;
import org.objectweb.asm.tree.analysis.Frame;

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
    public static InsnList constructSuspendRestoreBytecode(final MethodContext methodContext,
                                                           final int index) {
        final DebugMarker markerType = DebugMarker.STDOUT;
        final SuspendMethodContinuationPoint point = methodContext.getContinuationPointByClass(
                index,
                SuspendMethodContinuationPoint.class
        );
        final Integer lineNumber = point.getLineNumber();
        final PrimitiveStack os = methodContext.OS();
        final PrimitiveStack lva = methodContext.LVA();
        final Frame<BasicValue> frame = point.getFrame();
        final VariableLUT.Variable container = methodContext.containers().containerVariable();
        final VariableLUT.Variable continuationArgVar = methodContext.continuityVariables().continuationArgVar();

        return InsnBuilder.combine(
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Restoring from suspend point")
                        .build(),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Unpacking OS variables from container")
                        .build(),
                OSRestoreOperations.unpackVariablesFromContainer(
                        markerType,
                        frame,
                        container,
                        os
                ),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Unpacking LVA variables from container")
                        .build(),
                LVARestoreOperations.unpackVariablesFromContainer(
                        markerType,
                        frame,
                        container,
                        lva
                ),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Restoring OS variables")
                        .build(),
                OSRestoreOperations.restore(
                        markerType,
                        os,
                        frame
                ),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Restoring LVA variables")
                        .build(),
                LVARestoreOperations.restore(
                        markerType,
                        lva,
                        frame
                ),
                InsnBuilder.combineIf(
                        lineNumber != null,
                        () -> new Object[]{
                                InsnBuilder.lineNumber(lineNumber).build()
                        }
                ).build(),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Popping continuation object")
                        .build(),
                new InsnNode(Opcodes.POP),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Setting mode to IDLE")
                        .build(),
                InsnBuilder.call()
                        .method(BytecodeInternal.Accessor.getMethod("Continuation.setState"))
                        .args(
                                InsnBuilder.loadVar(continuationArgVar).build(),
                                InsnBuilder.constant(ContinuationState.IDLE.ordinal()).build()
                        ).build(),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Setting mode to IDLE")
                        .build(),
                InsnBuilder.call()
                        .method(BytecodeInternal.Accessor.getMethod("Continuation.unloadCurrentMethodState"))
                        .args(InsnBuilder.loadVar(continuationArgVar).build())
                        .build(),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Continuing execution")
                        .build(),
                InsnBuilder.jumpTo()
                        .label(point.getContinueExecutionLabel())
                        .build()
        ).build();
    }

    /* BUG: Fix this AALOAD bad type issue. Originates at OSRestoreOperations.restore(...) it seems.
     *  Exception in thread "main" java.lang.VerifyError: Bad type on operand stack in aaload
     *  Exception Details:
     *    Location:
     *      com/engineersbox/continuity/core/Main$TestCoroutine.run(Lcom/engineersbox/continuity/core/continuation/Continuation;)V @229: aaload
     *    Reason:
     *      Type 'com/engineersbox/continuity/core/Main$TestCoroutine' (current frame, stack[0]) is not assignable to reference type
     *    Current Frame:
     *      bci: @229
     *      flags: { }
     *      locals: { 'com/engineersbox/continuity/core/Main$TestCoroutine', 'com/engineersbox/continuity/core/continuation/Continuation', top, 'com/engineersbox/continuity/core/Main$TestCoroutine', top, 'I', top, top, top, 'com/engineersbox/continuity/core/Main$TestCoroutine', top, top, top, '[Ljava/lang/Object;', 'com/engineersbox/continuity/core/method/MethodState' }
     *      stack: { 'com/engineersbox/continuity/core/Main$TestCoroutine', integer }
     */

    @SuppressWarnings("unused")
    @ClassInstancedInvokable(InvokeContinuationPoint.class)
    public static InsnList constructInvokeRestoreBytecode(final MethodContext methodContext,
                                                          final int index) {
        final DebugMarker markerType = DebugMarker.STDOUT;
        final boolean debugMode = false; // TODO: Store this in a settings object on the context alongside markerType
        final InvokeContinuationPoint point = methodContext.getContinuationPointByClass(
                index,
                InvokeContinuationPoint.class
        );

        final Integer lineNumber = point.getLineNumber();
        final PrimitiveStack os = methodContext.OS();
        final PrimitiveStack lva = methodContext.LVA();
        final Frame<BasicValue> frame = point.getFrame();
        final VariableLUT.Variable container = methodContext.containers().containerVariable();
        final VariableLUT.Variable continuationArgVar = methodContext.continuityVariables().continuationArgVar();

        final MethodInsnNode invokeNode = point.getInvokeInstruction();

        final Type invokeReturnType = MethodInsnUtils.getReturnTypeOfInvocation(invokeNode);
        final int invokeArgCount = InsnUtils.argumentCountForInvocation(invokeNode);
        final VariableLUT.Variable returnCacheVar = methodContext.cache().getReturnCacheVar(invokeReturnType);


        return InsnBuilder.combine(
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Restoring from invocation")
                        .build(),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Unpacking OS variables from container")
                        .build(),
                OSRestoreOperations.unpackVariablesFromContainer(
                        markerType,
                        frame,
                        container,
                        os
                ),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Restoring top %d items of OS", invokeArgCount)
                        .build(),
                OSRestoreOperations.restore(
                        markerType,
                        os,
                        frame,
                        0,
                        frame.getStackSize() - invokeArgCount,
                        invokeArgCount
                ),
                InsnBuilder.combineIf(debugMode, () -> new Object[]{
                        InsnBuilder.debugMarker()
                                .marker(markerType)
                                .message("Unpacking LVA variables from container")
                                .build(),
                        LVARestoreOperations.unpackVariablesFromContainer(
                                markerType,
                                frame,
                                container,
                                lva
                        ),
                        InsnBuilder.debugMarker()
                                .marker(markerType)
                                .message("Restoring LVA variables")
                                .build(),
                        LVARestoreOperations.restore(
                                markerType,
                                lva,
                                frame
                        )
                }),
                InsnBuilder.combineIf(lineNumber != null, () -> new Object[]{
                        InsnBuilder.lineNumber(lineNumber).build()
                }),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Invoking method")
                        .build(),
                InsnUtils.cloneInvokeNode(invokeNode),
                InsnBuilder.ifIntEqual()
                        .lhs(InsnBuilder.call()
                                .method(BytecodeInternal.Accessor.getMethod("Continuation.getState"))
                                .args(InsnBuilder.loadVar(continuationArgVar).build())
                                .build())
                        .rhs(InsnBuilder.constant(ContinuationState.SAVING.ordinal()).build())
                        .action(InsnBuilder.combine(
                                InsnBuilder.debugMarker()
                                        .marker(markerType)
                                        .message("Mode set to SAVING, popping dummy return from OS")
                                        .build(),
                                InsnBuilder.popMethodResult(invokeNode).build(),
                                InsnBuilder.debugMarker()
                                        .marker(markerType)
                                        .message("Returning dummy value for non-void return")
                                        .build(),
                                InsnBuilder.dummyReturn(invokeReturnType).build()
                        ).build())
                        .build(),
                InsnBuilder.combineIf(returnCacheVar != null, () -> new Object[]{
                        InsnBuilder.debugMarker()
                                .marker(markerType)
                                .message("Caching invocation return value")
                                .build(),
                        InsnBuilder.saveVar(returnCacheVar).build()
                }).build(),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Unpacking LVA variables from container")
                        .build(),
                LVARestoreOperations.unpackVariablesFromContainer(
                        markerType,
                        frame,
                        container,
                        lva
                ),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Restoring OS variables")
                        .build(),
                OSRestoreOperations.restore(
                        markerType,
                        os,
                        frame,
                        0,
                        0,
                        frame.getStackSize() - invokeArgCount
                ),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Restoring LVA variables")
                        .build(),
                LVARestoreOperations.restore(
                        markerType,
                        lva,
                        frame
                ),
                InsnBuilder.combineIf(returnCacheVar != null, () -> new Object[]{
                        InsnBuilder.debugMarker()
                                .marker(markerType)
                                .message("Loading invocation return value")
                                .build(),
                        InsnBuilder.loadVar(returnCacheVar).build()
                }).build(),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Discarding saved method state")
                        .build(),
                InsnBuilder.call()
                        .method(BytecodeInternal.Accessor.getMethod("Continuation.unloadCurrentMethodState"))
                        .args(InsnBuilder.loadVar(continuationArgVar).build())
                        .build(),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Continuing execution from post-invocation label")
                        .build(),
                InsnBuilder.jumpTo()
                        .label(point.getContinueExecutionLabel())
                        .build()
        ).build();
    }

}
