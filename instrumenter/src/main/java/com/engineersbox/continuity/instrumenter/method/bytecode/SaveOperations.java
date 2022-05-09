package com.engineersbox.continuity.instrumenter.method.bytecode;

import com.engineersbox.continuity.core.annotation.BytecodeInternal;
import com.engineersbox.continuity.core.state.ContinuationState;
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
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.analysis.BasicValue;
import org.objectweb.asm.tree.analysis.Frame;

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
                        .method(BytecodeInternal.Accessor.getMethod("Continuation.pushNewMethodState"))
                        .args(
                                InsnBuilder.loadVar(methodContext.continuityVariables().methodStateVar()).build(),
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
                        )
                        .build(),
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Returning dummy (none if void)")
                        .build(),
                InsnBuilder.dummyReturn(methodContext.signature().descriptor().getReturnType()), // <- BUG: Error originates from here (*)
                InsnBuilder.label(point.getContinueExecutionLabel()).build()
        ).build();
    }

    /*
     * BUG: Fix this bytecode verification error [Location: (*)]
     * Exception in thread "main" java.lang.VerifyError: Bad type on operand stack in aastore
     * Exception Details:
     *   Location:
     *     com/engineersbox/continuity/core/Main$TestCoroutine.run(Lcom/engineersbox/continuity/core/continuation/Continuation;)V @233: aastore
     *   Reason:
     *     Type 'com/engineersbox/continuity/core/Main$TestCoroutine' (current frame, stack[3]) is not assignable to reference type
     *   Current Frame:
     *     bci: @233
     *     flags: { }
     *     locals: { 'com/engineersbox/continuity/core/Main$TestCoroutine', 'com/engineersbox/continuity/core/continuation/Continuation', integer, top, top, top, top, top, top, top, top, '[I' }
     *     stack: { 'com/engineersbox/continuity/core/Main$TestCoroutine', 'com/engineersbox/continuity/core/continuation/Continuation', integer, 'com/engineersbox/continuity/core/Main$TestCoroutine', integer, 'com/engineersbox/continuity/core/continuation/Continuation' }
     *   Bytecode:
     *     0000000: b200 1c12 1eb6 0024 2bb6 002a aa00 0000
     *     0000010: 0000 0082 0000 0000 0000 0002 0000 001c
     *     0000020: 0000 0027 0000 0039 b200 1c12 2cb6 0024
     *     0000030: a700 70b2 001c 122e b600 24bb 0030 5912
     *     0000040: 32b7 0034 bfb2 001c 1236 b600 242b b600
     *     0000050: 3a3a 0e19 0eb6 0040 3a0d b200 1c12 42b6
     *     0000060: 0024 190e b600 45aa 0000 0015 0000 0000
     *     0000070: 0000 0001 0000 0015 0000 0015 b200 1c12
     *     0000080: 47b6 0024 bb00 3059 1247 b700 34bf b200
     *     0000090: 1c12 49b6 0024 bb00 3059 124b b700 34bf
     *     00000a0: b200 1c12 4db6 0024 b200 5112 53b9 0058
     *     00000b0: 0200 033d 1c10 0aa2 00fb 2a2b 1c2b b200
     *     00000c0: 1c12 5ab6 0024 b200 1c12 5cb6 0024 b200
     *     00000d0: 1c12 5eb6 0024 125f bc0a 3a0b b200 1c12
     *     00000e0: 61b6 0024 2a5f 1262 5f53 b200 1c12 64b6
     *     00000f0: 0024 b200 1c12 66b6 0024 1267 bd00 044e
     *     0000100: b200 1c12 5eb6 0024 125f bc0a 3a05 b200
     *     0000110: 1c12 69b6 0024 2d12 672a 53b2 001c 126b
     *     0000120: b600 242d 126c 2b53 b200 1c12 6eb6 0024
     *     0000130: 1905 125f 1c4f b200 1c12 70b6 0024 b200
     *     0000140: 1c12 72b6 0024 1273 bd00 043a 0db2 001c
     *     0000150: 1275 b600 2419 0d12 622d 53b2 001c 1277
     *     0000160: b600 2419 0d12 6c19 0553 b200 1c12 79b6
     *     0000170: 0024 190d 127a 1909 53b2 001c 127c b600
     *     0000180: 2419 0ebb 003c 5912 7e12 5f12 6219 0db7
     *     0000190: 0081 b600 85b2 001c 1287 b600 242b 125f
     *     00001a0: b600 8bb2 001c 128d b600 24b1 0000 0000
     *     00001b0: 00bf b1
     *   Stackmap Table:
     *     same_frame(@40)
     *     same_frame(@51)
     *     same_frame(@69)
     *     full_frame(@124,{Object[#2],Object[#38],Top,Top,Top,Top,Top,Top,Top,Top,Top,Top,Top,Object[#147],Object[#60]},{})
     *     full_frame(@142,{Object[#2],Object[#38]},{})
     *     same_frame(@160)
     *     append_frame(@180,Integer)
     *     full_frame(@428,{},{Object[#149]})
     *     append_frame(@434,Object[#2],Object[#38],Integer)
     *
     *     at com.engineersbox.continuity.core.Main.main(Main.java:31)
     * Disconnected from the target VM, address: '127.0.0.1:58583', transport: 'socket'
     *
     * Process finished with exit code 1
     */

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
