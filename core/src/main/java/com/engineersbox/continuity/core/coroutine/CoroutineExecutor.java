package com.engineersbox.continuity.core.coroutine;

import com.engineersbox.continuity.core.continuation.Continuation;

public class CoroutineExecutor {

    private final Coroutine coroutine;
    private final Continuation continuation;

    public CoroutineExecutor(final Coroutine coroutine) {
        this(coroutine, new Continuation());
    }

    public CoroutineExecutor(final Coroutine coroutine,
                             final Continuation continuation) {
        this.coroutine = coroutine;
        this.continuation = continuation;
    }

    @SuppressWarnings("java:S112")
    public void execute() {
        try {
            this.coroutine.run(this.continuation);
        } catch (final Exception e) {
            throw new RuntimeException("Exception encountered during execution:", e);
        }
    }
}
