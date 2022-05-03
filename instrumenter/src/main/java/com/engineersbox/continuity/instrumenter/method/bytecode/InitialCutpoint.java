package com.engineersbox.continuity.instrumenter.method.bytecode;

import com.engineersbox.continuity.core.continuation.Continuation;
import com.engineersbox.continuity.core.method.MethodState;
import com.engineersbox.continuity.instrumenter.bytecode.InsnBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.annotation.BytecodeGenerator;
import com.engineersbox.continuity.instrumenter.method.MethodContext;
import com.engineersbox.continuity.instrumenter.stack.storage.VariableLUT;
import com.engineersbox.continuity.instrumenter.stage.DebugMarker;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.LabelNode;

import java.lang.reflect.Method;
import java.util.stream.IntStream;

@BytecodeGenerator
public class InitialCutpoint {

    private static final Method CONTINUATION_GETSTATE_METHOD = MethodUtils.getAccessibleMethod(
            Continuation.class,
            "getState"
    );
    private static final Method CONTINUATION_LOADNEXTMETHODSTATE_METHOD = MethodUtils.getAccessibleMethod(
            Continuation.class,
            "loadNextMethodState"
    );
    private static final Method CONTINUATION_GETDATA_METHOD = MethodUtils.getAccessibleMethod(
            Continuation.class,
            "getData"
    );
    private static final Method METHODSTATE_GETCONTINUATIONPOINT_METHOD = MethodUtils.getAccessibleMethod(
            MethodState.class,
            "getContinuationPoint"
    );

    public static InsnList constructInitialInlineCutpoint(final MethodContext methodContext) {
        final DebugMarker markerType = DebugMarker.STDOUT;

        final VariableLUT.Variable continuationArgVar = methodContext.continuityVariables().continuationArgVar();
        final VariableLUT.Variable methodState = methodContext.continuityVariables().methodStateVar();
        final VariableLUT.Variable containerVar = methodContext.containers().getContainerVar();

        final LabelNode startOfMethodLabelNode = new LabelNode();
        return InsnBuilder.combine(
                InsnBuilder.switchTable()
                        .index(InsnBuilder.combine(
                                InsnBuilder.debugMarker()
                                        .marker(markerType)
                                        .message("Retrieving continuation state")
                                        .build(),
                                InsnBuilder.call()
                                        .method(CONTINUATION_GETSTATE_METHOD)
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
                        .cases(
                                InsnBuilder.combine(
                                        InsnBuilder.debugMarker()
                                                .marker(markerType)
                                                .message("[Case 0]: Initial invocation, jumping to start of method")
                                                .build(),
                                        InsnBuilder.jumpTo()
                                                .label(startOfMethodLabelNode)
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
                                        InsnBuilder.call()
                                                .method(CONTINUATION_LOADNEXTMETHODSTATE_METHOD)
                                                .args(InsnBuilder.loadVar(continuationArgVar).build()),
                                        InsnBuilder.saveVar(methodState).build(),
                                        InsnBuilder.call()
                                                .method(CONTINUATION_GETDATA_METHOD)
                                                .args(InsnBuilder.loadVar(methodState).build()),
                                        InsnBuilder.saveVar(containerVar).build(),
                                        InsnBuilder.switchTable()
                                                .index(InsnBuilder.combine(
                                                        InsnBuilder.debugMarker()
                                                                .marker(markerType)
                                                                .message("Retrieving continuation point")
                                                                .build(),
                                                        InsnBuilder.call()
                                                                .method(METHODSTATE_GETCONTINUATIONPOINT_METHOD)
                                                                .args(InsnBuilder.loadVar(methodState).build()).build()
                                                ).build())
                                                .defaultBranch(InsnBuilder.combine(
                                                        InsnBuilder.debugMarker()
                                                                .marker(markerType)
                                                                .message("Invalid continuation id")
                                                                .build(),
                                                        InsnBuilder.exception()
                                                                .exceptionClass(RuntimeException.class)
                                                                .message("Invalid continuation id").build()
                                                ).build())
                                                .caseStartIndex(0)
                                                .cases(IntStream.range(0, methodContext.continuationPoints().size())
                                                                .mapToObj((final int index) -> RestoreOperations.constructRestoreBytecode(methodContext, index))
                                                                .toArray(InsnList[]::new))
                                ).build()
                        ).build(),
                InsnBuilder.label(startOfMethodLabelNode).build(),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Executing method")
                        .build()
        ).build();
    }

}
