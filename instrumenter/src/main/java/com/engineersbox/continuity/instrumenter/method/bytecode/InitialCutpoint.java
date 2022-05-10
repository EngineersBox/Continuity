package com.engineersbox.continuity.instrumenter.method.bytecode;

import com.engineersbox.continuity.core.annotation.BytecodeInternal;
import com.engineersbox.continuity.instrumenter.bytecode.InsnBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.annotation.BytecodeGenerator;
import com.engineersbox.continuity.instrumenter.method.MethodContext;
import com.engineersbox.continuity.instrumenter.stack.storage.VariableLUT;
import com.engineersbox.continuity.instrumenter.stage.DebugMarker;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.LabelNode;

import java.util.stream.IntStream;

@BytecodeGenerator
public class InitialCutpoint {

    private InitialCutpoint() {}

    public static InsnList constructInitialInlineCutpoint(final MethodContext methodContext) {
        final DebugMarker markerType = DebugMarker.STDOUT;

        final VariableLUT.Variable continuationArgVar = methodContext.continuityVariables().continuationArgVar();
        final VariableLUT.Variable methodState = methodContext.continuityVariables().methodStateVar();
        final VariableLUT.Variable containerVar = methodContext.containers().getContainerVar();

        final LabelNode methodStartLabel = new LabelNode();
        return InsnBuilder.combine(
                InsnBuilder.switchTable()
                        .index(InsnBuilder.combine(
                                InsnBuilder.debugMarker()
                                        .marker(markerType)
                                        .message("Retrieving continuation state")
                                        .build(),
                                InsnBuilder.call()
                                        .method(BytecodeInternal.Accessor.getMethod("Continuation.getState"))
                                        .args(InsnBuilder.loadVar(continuationArgVar).build()).build()
                        ).build())
                        .defaultBranch(InsnBuilder.combine(
                                InsnBuilder.debugMarker()
                                        .marker(markerType)
                                        .message("Received an unknown Continuation state")
                                        .build(),
                                InsnBuilder.exception()
                                        .exceptionClass(RuntimeException.class)
                                        .message("Unknown state").build()
                        ).build())
                        .caseStartIndex(0)
                        .cases(createStateCases(
                                markerType,
                                methodStartLabel,
                                continuationArgVar,
                                containerVar,
                                methodState,
                                methodContext
                        )).build(),
                InsnBuilder.label(methodStartLabel).build(),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Executing method")
                        .build()
        ).build();
    }

    private static InsnList[] createStateCases(final DebugMarker markerType,
                                               final LabelNode methodStartLabel,
                                               final VariableLUT.Variable continuationArgVar,
                                               final VariableLUT.Variable containerVar,
                                               final VariableLUT.Variable methodState,
                                               final MethodContext methodContext) {
        return new InsnList[]{
                InsnBuilder.combine(
                        InsnBuilder.debugMarker()
                                .marker(markerType)
                                .message("[Case 0]: Initial invocation, jumping to start of method")
                                .build(),
                        InsnBuilder.jumpTo()
                                .label(methodStartLabel)
                                .build()
                ).build(),
                InsnBuilder.combine(
                        InsnBuilder.debugMarker()
                                .marker(markerType)
                                .message("[Case 1]: Attempt to save at an invalid time")
                                .build(),
                        InsnBuilder.exception()
                                .exceptionClass(RuntimeException.class)
                                .message("Saving is not allowed at this stage").build()
                ).build(),
                InsnBuilder.combine(
                        InsnBuilder.debugMarker()
                                .marker(markerType)
                                .message("[Case 2]: Loading continuation state")
                                .build(),
                        loadContinuationState(
                                markerType,
                                continuationArgVar,
                                containerVar,
                                methodState,
                                methodContext
                        )
                ).build()
        };
    }

    private static InsnList loadContinuationState(final DebugMarker markerType,
                                                  final VariableLUT.Variable continuationArgVar,
                                                  final VariableLUT.Variable containerVar,
                                                  final VariableLUT.Variable methodState,
                                                  final MethodContext methodContext) {
        return InsnBuilder.combine(
                InsnBuilder.call()
                        .method(BytecodeInternal.Accessor.getMethod("Continuation.loadNextMethodState"))
                        .args(InsnBuilder.loadVar(continuationArgVar).build())
                        .build(),
                InsnBuilder.saveVar(methodState).build(),
                InsnBuilder.call()
                        .method(BytecodeInternal.Accessor.getMethod("MethodState.getData"))
                        .args(InsnBuilder.loadVar(methodState).build())
                        .build(),
                InsnBuilder.saveVar(containerVar).build(),
                InsnBuilder.switchTable()
                        .index(InsnBuilder.combine(
                                InsnBuilder.debugMarker()
                                        .marker(markerType)
                                        .message("Retrieving continuation point")
                                        .build(),
                                InsnBuilder.call()
                                        .method(BytecodeInternal.Accessor.getMethod("MethodState.getContinuationPoint"))
                                        .args(InsnBuilder.loadVar(methodState).build())
                                        .build()
                        ).build())
                        .defaultBranch(InsnBuilder.combine(
                                InsnBuilder.debugMarker()
                                        .marker(markerType)
                                        .message("Invalid continuation id")
                                        .build(),
                                InsnBuilder.exception()
                                        .exceptionClass(RuntimeException.class)
                                        .message("Invalid continuation id")
                                        .build()
                        ).build())
                        .caseStartIndex(0)
                        .cases(IntStream.range(0, methodContext.continuationPoints().size())
                                .mapToObj((final int index) -> RestoreOperations.constructRestoreBytecode(methodContext, index))
                                .toArray(InsnList[]::new))
                        .build()
        ).build();
    }
}
