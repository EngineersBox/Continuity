package com.engineersbox.continuity.core.continuation;

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
        // TODO
    }

    public MethodState loadNextMethodState() {
        final MethodState ret = this.nextLoadPointer;
        this.nextLoadPointer = this.nextLoadPointer.next();
        if (this.nextLoadPointer == null) {
            this.nextUnloadPointer = ret;
        }
        return ret;
    }

    public void pushNewMethodState(final MethodState newState) {
        newState.setNext(firstCutpointPointer);
        this.firstCutpointPointer = newState;
    }

    public int getState() {
        return this.state;
    }

    public void setState(final ContinuationState state) {
        this.state = state.ordinal();
    }

    public void setState(final int state) {
        this.state = ContinuationState.fromOrdinal(state).ordinal();
    }
}
