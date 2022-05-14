package com.engineersbox.continuity.instrumenter.method.bytecode;

import com.engineersbox.continuity.core.annotation.BytecodeInternal;
import com.engineersbox.continuity.core.state.ContinuationState;
import com.engineersbox.continuity.instrumenter.bytecode.InsnBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.annotation.BytecodeGenerator;
import com.engineersbox.continuity.instrumenter.bytecode.state.lva.LVASaveOperations;
import com.engineersbox.continuity.instrumenter.bytecode.state.os.OSRestoreOperations;
import com.engineersbox.continuity.instrumenter.bytecode.state.os.OSSaveOperations;
import com.engineersbox.continuity.instrumenter.bytecode.state.store.ArrayStoreSaveOperations;
import com.engineersbox.continuity.instrumenter.method.MethodContext;
import com.engineersbox.continuity.instrumenter.method.bytecode.annotation.ClassInstancedInvokable;
import com.engineersbox.continuity.instrumenter.stack.point.ContinuationPoint;
import com.engineersbox.continuity.instrumenter.stack.point.InvokeContinuationPoint;
import com.engineersbox.continuity.instrumenter.stack.point.SuspendMethodContinuationPoint;
import com.engineersbox.continuity.instrumenter.stack.storage.PrimitiveStack;
import com.engineersbox.continuity.instrumenter.stack.storage.VariableLUT;
import com.engineersbox.continuity.instrumenter.stage.DebugMarker;
import com.engineersbox.continuity.instrumenter.util.InsnUtils;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.analysis.BasicValue;
import org.objectweb.asm.tree.analysis.Frame;

@BytecodeGenerator
public final class SaveOperations extends CoreOperations {

    private SaveOperations() {}

    public static InsnList constructSaveBytecode(final MethodContext methodContext,
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
                SaveOperations.class,
                point.getClass(),
                methodContext,
                index
        );
    }

    @SuppressWarnings("unused")
    @ClassInstancedInvokable(SuspendMethodContinuationPoint.class)
    public static InsnList constructSuspendSaveBytecode(final MethodContext methodContext,
                                                 final int index) {
        final DebugMarker markerType = DebugMarker.STDOUT;
        final SuspendMethodContinuationPoint point = methodContext.getContinuationPointByClass(
                index,
                SuspendMethodContinuationPoint.class
        );
        final Integer lineNumber = point.getLineNumber();
        final PrimitiveStack lva = methodContext.LVA();
        final PrimitiveStack os = methodContext.OS();
        final Frame<BasicValue> frame = point.getFrame();
        final VariableLUT.Variable container = methodContext.containers().containerVariable();
        final String className = methodContext.signature().className().replace('/', '.');

        return InsnBuilder.combine(
                InsnBuilder.combineIf(lineNumber != null, () -> new Object[]{
                    InsnBuilder.lineNumber(lineNumber).build()
                }),
                saveVariables(
                        markerType,
                        index,
                        lva,
                        os,
                        container,
                        frame
                ),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Pushing method state snapshot")
                        .build(),
                InsnBuilder.call()
                        .method(BytecodeInternal.Accessor.getMethod("Continuation.pushNewMethodState"))
                        .args(
                                InsnBuilder.loadVar(methodContext.continuityVariables().continuationArgVar()).build(),
                                InsnBuilder.newInstance()
                                        .constructor(BytecodeInternal.Accessor.getConstructor("MethodState.init"))
                                        .args(
                                                InsnBuilder.constant(className).build(),
                                                InsnBuilder.constant(methodContext.signature().id()).build(),
                                                InsnBuilder.constant(index).build(),
                                                InsnBuilder.loadVar(container).build()
                                        ).build()
                        ).build(),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Setting save state")
                        .build(),
                InsnBuilder.call()
                        .method(BytecodeInternal.Accessor.getMethod("Continuation.setState"))
                        .args(
                                InsnBuilder.loadVar(methodContext.continuityVariables().continuationArgVar()).build(),
                                InsnBuilder.constant(ContinuationState.SAVING.ordinal()).build()
                        ).build(),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Returning dummy (none if void)")
                        .build(),
                InsnBuilder.dummyReturn(methodContext.signature().descriptor().getReturnType()),
                InsnBuilder.label(point.getContinueExecutionLabel()).build()
        ).build();
    }

    private static InsnList saveVariables(final DebugMarker markerType,
                                          final int index,
                                          final PrimitiveStack lva,
                                          final PrimitiveStack os,
                                          final VariableLUT.Variable container,
                                          final Frame<BasicValue> frame) {
        return InsnBuilder.combine(
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message(String.format("Saving suspend point %d", index))
                        .build(),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Saving OS variables")
                        .build(),
                OSSaveOperations.save(
                        markerType,
                        os,
                        frame
                ),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Saving LVA variables")
                        .build(),
                LVASaveOperations.save(
                        markerType,
                        lva,
                        frame
                ),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Packing LVA and OS variables")
                        .build(),
                ArrayStoreSaveOperations.save(
                        markerType,
                        container,
                        lva,
                        os,
                        frame
                )
        ).build();
    }

    @SuppressWarnings("unused")
    @ClassInstancedInvokable(InvokeContinuationPoint.class)
    public static InsnList constructInvokeSaveBytecode(final MethodContext methodContext,
                                                final int index) {
        final DebugMarker markerType = DebugMarker.STDOUT;
        final InvokeContinuationPoint point = methodContext.getContinuationPointByClass(
                index,
                InvokeContinuationPoint.class
        );
        final Integer lineNumber = point.getLineNumber();
        final PrimitiveStack os = methodContext.OS();
        final Frame<BasicValue> frame = point.getFrame();

        final int invokeArgCount = InsnUtils.argumentCountForInvocation(point.getInvokeInstruction());
        return InsnBuilder.combine(
                InsnBuilder.combineIf(lineNumber != null, () -> new Object[]{
                        InsnBuilder.lineNumber(lineNumber).build()
                }),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Saving invoke")
                        .build(),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Saving OS variables")
                        .build(),
                OSSaveOperations.save(
                        markerType,
                        os,
                        frame
                ),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Loading invoke arguments")
                        .build(),
                OSRestoreOperations.restore(
                        markerType,
                        os,
                        frame,
                        frame.getStackSize() - invokeArgCount,
                        frame.getStackSize() - invokeArgCount,
                        invokeArgCount
                ),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Invoking method")
                        .build(),
                InsnBuilder.cloneMethod(point.getInvokeInstruction()).build(),
                InsnBuilder.ifIntNotEqual()
                        .lhs(InsnBuilder.call()
                                .method(BytecodeInternal.Accessor.getMethod("Continuation.getState"))
                                .args(InsnBuilder.loadVar(methodContext.continuityVariables().continuationArgVar()).build())
                                .build()
                        ).rhs(InsnBuilder.constant(ContinuationState.SAVING.ordinal()).build())
                        .action(InsnBuilder.jumpTo()
                                .label(point.getContinueExecutionLabel())
                                .build())
                        .build(),
                saveInvocationState(
                        markerType,
                        methodContext,
                        index,
                        os,
                        frame,
                        point,
                        invokeArgCount
                ),
                InsnBuilder.label(point.getContinueExecutionLabel()).build()
        ).build();
    }

    private static InsnList saveInvocationState(final DebugMarker markerType,
                                                final MethodContext methodContext,
                                                final int index,
                                                final PrimitiveStack os,
                                                final Frame<BasicValue> frame,
                                                final InvokeContinuationPoint point,
                                                final int invokeArgCount) {
        final PrimitiveStack lva = methodContext.LVA();
        final VariableLUT.Variable container = methodContext.containers().containerVariable();
        final String className = methodContext.signature().className().replace('/', '.');
        return InsnBuilder.combine(
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Popping method result")
                        .build(),
                InsnBuilder.popMethodResult(point.getInvokeInstruction()).build(),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Loading invocation arguments")
                        .build(),
                OSRestoreOperations.restore(
                        markerType,
                        os,
                        frame,
                        frame.getStackSize() - invokeArgCount,
                        frame.getStackSize() - invokeArgCount,
                        invokeArgCount
                ),
                saveVariables(
                        markerType,
                        index,
                        lva,
                        os,
                        container,
                        frame
                ),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Pushing method state snapshot")
                        .build(),
                InsnBuilder.call()
                        .method(BytecodeInternal.Accessor.getMethod("Continuation.pushNewMethodState"))
                        .args(
                                InsnBuilder.loadVar(methodContext.continuityVariables().continuationArgVar()).build(),
                                InsnBuilder.newInstance()
                                        .constructor(BytecodeInternal.Accessor.getConstructor("MethodState.init"))
                                        .args(
                                                InsnBuilder.constant(className).build(),
                                                InsnBuilder.constant(methodContext.signature().id()).build(),
                                                InsnBuilder.constant(index).build(),
                                                InsnBuilder.loadVar(container).build()
                                        ).build()
                        ).build(),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Returning dummy (none if void)")
                        .build(),
                InsnBuilder.dummyReturn(methodContext.signature().descriptor().getReturnType())
        ).build();
    }
}
