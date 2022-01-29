package com.engineersbox.continuity.core.coroutine;

import com.engineersbox.continuity.core.continuation.Continuation;

import java.io.Serializable;

public interface Coroutine extends Serializable {

    @SuppressWarnings("java:S112")
    void run(final Continuation continuation) throws Exception;

}
