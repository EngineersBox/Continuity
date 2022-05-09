package com.engineersbox.continuity.core.method;

import com.engineersbox.continuity.core.annotation.BytecodeInternal;

public class MethodState {

    private final String className;
    private final int methodId;
    private final int continuationPoint;
    private final Object[] data;

    private MethodState next;
    private MethodState previous;

    @BytecodeInternal
    public MethodState(final String className,
                       final int methodId,
                       final int continuationPoint,
                       final Object[] data) {
        if (continuationPoint < 0) {
            throw new IllegalArgumentException();
        } else if (data == null) {
            throw new NullPointerException();
        }
        this.className = className;
        this.methodId = methodId;
        this.continuationPoint = continuationPoint;
        this.data = data;
    }

    @BytecodeInternal
    public MethodState next() { return this.next; }

    @BytecodeInternal
    public void setNext(final MethodState state) { this.next = state; }

    @BytecodeInternal
    public MethodState previous() { return this.previous; }

    @BytecodeInternal
    public void setPrevious(final MethodState state) { this.previous = state; }

    @BytecodeInternal
    public Object[] getData() {
        return this.data;
    }

    @BytecodeInternal
    public int getContinuationPoint() {
        return this.continuationPoint;
    }
}
