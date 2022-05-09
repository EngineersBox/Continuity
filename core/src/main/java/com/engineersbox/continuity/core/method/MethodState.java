package com.engineersbox.continuity.core.method;

import com.engineersbox.continuity.core.annotation.BytecodeInternal;

public class MethodState {

    private final String className;
    private final int methodId;
    private final int continuationPoint;
    private final Object[] data;

    private MethodState next;
    private MethodState previous;

    @BytecodeInternal(key = "methodState.init")
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

    @BytecodeInternal(key = "methodState.next")
    public MethodState next() { return this.next; }

    @BytecodeInternal(key = "methodState.setNext")
    public void setNext(final MethodState state) { this.next = state; }

    @BytecodeInternal(key = "methodState.previous")
    public MethodState previous() { return this.previous; }

    @BytecodeInternal(key = "methodState.setPrevious")
    public void setPrevious(final MethodState state) { this.previous = state; }

    @BytecodeInternal(key = "methodState.getData")
    public Object[] getData() {
        return this.data;
    }

    @BytecodeInternal(key = "methodState.getContinuationPoint")
    public int getContinuationPoint() {
        return this.continuationPoint;
    }
}
