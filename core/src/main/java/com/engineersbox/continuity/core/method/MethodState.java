package com.engineersbox.continuity.core.method;

public class MethodState {

    private final String className;
    private final int methodId;
    private final int continuationPoint;
    private final Object[] data;

    private MethodState next;
    private MethodState previous;

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

    public MethodState next() { return this.next; }

    public void setNext(final MethodState state) { this.next = state; }

    public MethodState previous() { return this.previous; }

    public void setPrevious(final MethodState state) { this.previous = state; }
}
