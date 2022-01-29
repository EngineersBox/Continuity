package com.engineersbox.continuity.coroutine;

import com.engineersbox.continuity.continuation.Continuation;

import java.io.Serializable;

public interface Coroutine extends Serializable {

    @SuppressWarnings("java:S112")
    void run(final Continuation continuation) throws Exception;

}
