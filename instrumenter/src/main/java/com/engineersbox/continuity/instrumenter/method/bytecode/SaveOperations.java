package com.engineersbox.continuity.instrumenter.method.bytecode;

import com.engineersbox.continuity.core.continuation.Continuation;
import com.engineersbox.continuity.core.method.MethodState;
import com.engineersbox.continuity.instrumenter.bytecode.InsnBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.Retriever;
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
import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.analysis.BasicValue;
import org.objectweb.asm.tree.analysis.Frame;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

@BytecodeGenerator
public class SaveOperations {

    private static final Method CONTINUATION_PUSHNEWMETHODSTATE_METHOD = MethodUtils.getAccessibleMethod(
            Continuation.class,
            "pushNewMethodState"
    );

    private static final Constructor<MethodState> METHODSTATE_CONSTRUCTOR = ConstructorUtils.getAccessibleConstructor(
            MethodState.class,
            String.class,
            Integer.TYPE,
            Integer.TYPE,
            Object[].class
    );

    private SaveOperations() {}

    public static InsnList constructSaveBytecode(final MethodContext methodContext,
                                                 final int index) {
        final ContinuationPoint point = Retriever.getContinuationPoint(
                methodContext,
                index,
                ContinuationPoint.class
        );
        if (point instanceof SuspendMethodContinuationPoint suspendPoint) {
            return constructSuspendSaveBytecode(methodContext, index, suspendPoint);
        } else if (point instanceof InvokeContinuationPoint invokePoint) {
            return constructInvokeSaveBytecode(methodContext, index, invokePoint);
        }
        throw new IllegalStateException(String.format(
                "Unknown continuation point type: %s",
                point.getClass().getName()
        ));
    }

    private static InsnList constructSuspendSaveBytecode(final MethodContext methodContext,
                                                         final int index,
                                                         final SuspendMethodContinuationPoint point) {
        final DebugMarker markerType = DebugMarker.STDOUT;
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
                        .method(CONTINUATION_PUSHNEWMETHODSTATE_METHOD)
                        .args(
                                InsnBuilder.loadVar(methodContext.continuityVariables().methodStateVar()).build(),
                                InsnBuilder.newInstance()
                                        .constructor(METHODSTATE_CONSTRUCTOR)
                                        .args(
                                                InsnBuilder.constant(className).build(),
                                                InsnBuilder.constant(methodContext.signature().id()).build(),
                                                InsnBuilder.constant(index).build(),
                                                InsnBuilder.loadVar(container).build()
                                        ).build()
                        ).build()
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
                                                        final int index,
                                                        final InvokeContinuationPoint point) {
        return InsnBuilder.combine(
        ).build();
    }
}
