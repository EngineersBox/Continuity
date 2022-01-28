package com.engineersbox.continuity.api;

import com.engineersbox.continuity.state.StateManager;

public class PersistentContinuation extends Continuation {
    PersistentContinuation(final StateManager stateManager,
                           final Object value) {
        super(stateManager, value);
    }

    @Override
    public Continuation resume(final Object context) {
        return null;
    }

    @Override
    public Continuation snapshot() {
        return null;
    }
}
