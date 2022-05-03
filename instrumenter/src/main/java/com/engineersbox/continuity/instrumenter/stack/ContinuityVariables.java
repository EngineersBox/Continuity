package com.engineersbox.continuity.instrumenter.stack;

import com.engineersbox.continuity.core.continuation.Continuation;
import com.engineersbox.continuity.core.method.MethodState;
import com.engineersbox.continuity.instrumenter.stack.storage.VariableLUT;
import org.objectweb.asm.Type;

public record ContinuityVariables(VariableLUT.Variable continuationArgVar,
                                  VariableLUT.Variable methodStateVar) {
    public ContinuityVariables(VariableLUT.Variable continuationArgVar,
                               VariableLUT.Variable methodStateVar) {
        if (continuationArgVar == null) {
            throw new IllegalArgumentException("Continuation argument cannot be null");
        } else if (methodStateVar == null) {
            throw new IllegalArgumentException("Method state argument cannot be null");
        } else if (!continuationArgVar.getType().equals(Type.getType(Continuation.class))) {
            throw new IllegalArgumentException("Continuation argument not of type Continuation");
        } else if (!methodStateVar.getType().equals(Type.getType(MethodState.class))) {
            throw new IllegalArgumentException("Method state arguments not of type MethodState");
        }
        this.continuationArgVar = continuationArgVar;
        this.methodStateVar = methodStateVar;
    }
}
