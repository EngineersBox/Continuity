package com.engineersbox.continuity.core.continuation;

import com.engineersbox.continuity.core.annotation.BytecodeInternal;
import com.engineersbox.continuity.core.method.MethodState;
import com.engineersbox.continuity.core.state.ContinuationState;

import java.io.Serial;
import java.io.Serializable;

public final class Continuation implements Serializable {

    @Serial
    private static final long serialVersionUID = 4510386612784934318L;
    private int state = ContinuationState.IDLE.ordinal();
    private MethodState firstPointer;
    private MethodState nextLoadPointer;
    private MethodState nextUnloadPointer;
    private MethodState firstCutpointPointer;

    public Continuation() {}

    public void suspend() {
        throw new UnsupportedOperationException("Continuation context was not instrumented");
    }

    @BytecodeInternal
    public MethodState loadNextMethodState() {
        final MethodState ret = this.nextLoadPointer;
        this.nextLoadPointer = this.nextLoadPointer.next();
        if (this.nextLoadPointer == null) {
            this.nextUnloadPointer = ret;
        }
        return ret;
    }

    @BytecodeInternal
    public void unloadCurrentMethodState() {
        this.nextUnloadPointer = this.nextUnloadPointer.previous();
    }

    @BytecodeInternal
    public void pushNewMethodState(final MethodState newState) {
        newState.setNext(this.firstCutpointPointer);
        this.firstCutpointPointer = newState;
    }

    @BytecodeInternal
    public int getState() {
        return this.state;
    }

    @BytecodeInternal(key = "Continuation.setStateEnum")
    public void setState(final ContinuationState state) {
        this.state = state.ordinal();
    }

    @BytecodeInternal
    public void setState(final int state) {
        this.state = ContinuationState.fromOrdinal(state).ordinal();
    }

    public void successExecutionCycle() {
        if (this.nextUnloadPointer != null) {
            this.nextUnloadPointer.setNext(this.firstCutpointPointer);
        } else {
            this.firstPointer = this.firstCutpointPointer;
        }

        this.nextLoadPointer = this.firstPointer;
        this.nextUnloadPointer = null;
        this.firstCutpointPointer = null;
    }

    public void failedExecutionCycle() {
        this.nextLoadPointer = this.firstPointer;
        this.nextUnloadPointer = null;
        this.firstCutpointPointer = null;
    }

    public void reset() {
        this.firstPointer = null;
        this.nextLoadPointer = null;
        this.nextUnloadPointer = null;
        this.firstCutpointPointer = null;
        this.state = ContinuationState.IDLE.ordinal();
    }
}
