package com.engineersbox.continuity.core.coroutine;

import com.engineersbox.continuity.core.continuation.Continuation;

public interface Coroutine {
    @SuppressWarnings("java:S112")
    void run(final Continuation continuation) throws Exception;
}
