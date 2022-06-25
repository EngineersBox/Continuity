package com.engineersbox.continuity.core.coroutine;

import com.engineersbox.continuity.core.continuation.Continuation;
import com.engineersbox.continuity.core.state.ContinuationState;

public class CoroutineExecutor {

    private final Coroutine coroutine;
    private final Continuation continuation;

    public CoroutineExecutor(final Coroutine coroutine) {
        this(coroutine, new Continuation());
    }

    public CoroutineExecutor(final Coroutine coroutine,
                             final Continuation continuation) {
        if (coroutine == null) {
            throw new NullPointerException();
        }
        this.coroutine = coroutine;
        this.continuation = continuation;
    }

    @SuppressWarnings("java:S112")
    public boolean execute() {
        try {
            this.coroutine.run(this.continuation);
            this.continuation.successExecutionCycle();
        } catch (final Exception e) {
            this.continuation.failedExecutionCycle();
            throw new RuntimeException("Exception encountered during execution:", e);
        }
        if (this.continuation.getState() != ContinuationState.SAVING.ordinal()) {
            continuation.reset();
            return false;
        }
        continuation.setState(ContinuationState.LOADING);
        return true;
    }
}
