package com.engineersbox.continuity.core.continuation;

import com.engineersbox.continuity.core.method.MethodState;
import com.engineersbox.continuity.core.state.ContinuationState;

import java.io.Serial;
import java.io.Serializable;

public final class Continuation implements Serializable {

    @Serial
    private static final long serialVersionUID = -8747747298133665674L;

    private MethodState firstPointer;
    private MethodState nextLoadPointer;
    private MethodState nextUnloadPointer;
    private MethodState firstCutpointPointer;

    private int mode = ContinuationState.IDLE.ordinal();
    private Object context;

    public Continuation() {}

    public void suspend() {
        /* TODO:
         *  1. Store the current thread context/stack
         *  2. Unload/pause thread
         */
    }

    public int getMode() { return this.mode; }

    public void setMode(final int mode) { this.mode = mode; }

    public MethodState popToNextMethodState() {
        final MethodState ret = this.nextLoadPointer;
        this.nextLoadPointer = this.nextLoadPointer.next();
        if (this.nextLoadPointer == null) {
            this.nextUnloadPointer = ret;
        }
        return ret;
    }

    public void popMethodState() {
        this.nextUnloadPointer = this.nextUnloadPointer.previous();
    }

    public void popToPreviousMethodState(final MethodState state) {
        this.nextUnloadPointer = state.previous();
    }

    public void pushMethodState(final MethodState state) {
        state.setNext(this.firstCutpointPointer);
        this.firstCutpointPointer = state;
    }

    public void reset() {
        this.firstPointer = null;
        this.nextLoadPointer = null;
        this.nextUnloadPointer = null;
        this.firstCutpointPointer = null;
        this.mode = ContinuationState.IDLE.ordinal();
    }

    public Object getContext() { return this.context; }

    public void setContext(final Object context) { this.context = context; }
}
