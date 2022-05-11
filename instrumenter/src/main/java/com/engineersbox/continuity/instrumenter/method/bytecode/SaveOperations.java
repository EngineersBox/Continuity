package com.engineersbox.continuity.instrumenter.method.bytecode;

import com.engineersbox.continuity.core.annotation.BytecodeInternal;
import com.engineersbox.continuity.core.state.ContinuationState;
import com.engineersbox.continuity.instrumenter.bytecode.InsnBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.annotation.BytecodeGenerator;
import com.engineersbox.continuity.instrumenter.bytecode.state.lva.LVASaveOperations;
import com.engineersbox.continuity.instrumenter.bytecode.state.os.OSSaveOperations;
import com.engineersbox.continuity.instrumenter.bytecode.state.store.ArrayStoreSaveOperations;
import com.engineersbox.continuity.instrumenter.method.MethodContext;
import com.engineersbox.continuity.instrumenter.stack.point.ContinuationPoint;
import com.engineersbox.continuity.instrumenter.stack.point.InvokeContinuationPoint;
import com.engineersbox.continuity.instrumenter.stack.point.SuspendMethodContinuationPoint;
import com.engineersbox.continuity.instrumenter.stack.storage.PrimitiveStack;
import com.engineersbox.continuity.instrumenter.stack.storage.VariableLUT;
import com.engineersbox.continuity.instrumenter.stage.DebugMarker;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.analysis.BasicValue;
import org.objectweb.asm.tree.analysis.Frame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@BytecodeGenerator
public class SaveOperations {

    private static final Logger LOGGER = LoggerFactory.getLogger(SaveOperations.class);

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
        if (point instanceof SuspendMethodContinuationPoint) {
            LOGGER.info("Point matched to: SuspendMethodContinuationPoint");
            return constructSuspendSaveBytecode(methodContext, index);
        } else if (point instanceof InvokeContinuationPoint) {
            LOGGER.info("Point matched to: InvokeContinuationPoint");
            return constructInvokeSaveBytecode(methodContext, index);
        }
        throw new IllegalStateException(String.format(
                "Unknown continuation point type: %s",
                point.getClass().getName()
        ));
    }

    private static InsnList constructSuspendSaveBytecode(final MethodContext methodContext,
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
        final VariableLUT.Variable container = methodContext.containers().getContainerVar();
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

    private static InsnList constructInvokeSaveBytecode(final MethodContext methodContext,
                                                        final int index) {
        final DebugMarker markerType = DebugMarker.STDOUT;
        final InvokeContinuationPoint point = methodContext.getContinuationPointByClass(
                index,
                InvokeContinuationPoint.class
        );
        final Integer lineNumber = point.getLineNumber();
        final PrimitiveStack os = methodContext.OS();
        final PrimitiveStack lva = methodContext.LVA();
        final Frame<BasicValue> frame = point.getFrame();

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
                )
        ).build();
    }
}
