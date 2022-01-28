package com.engineersbox.continuity.api;

import com.engineersbox.continuity.state.StateManager;

import java.io.Serializable;

public abstract class Continuation implements Serializable {

    private final StateManager stateManager;
    private final Object value;

    Continuation(final StateManager stateManager,
                 final Object value) {
        this.stateManager = stateManager;
        this.value = value;
    }

    public static Continuation startWith(final Runnable target) {
        return new PersistentContinuation(new StateManager(target), null);
    }

    public static Object suspend(final Object value) {
        return StateManager.suspend(ContinuationState.SUSPENDED);
    }

    public Continuation resume(final Object context) {
        return null;
    }

    public Object value() {
        return this.value;
    }

    public abstract Continuation snapshot();
}
