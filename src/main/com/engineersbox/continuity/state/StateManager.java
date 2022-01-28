package com.engineersbox.continuity.state;

import com.engineersbox.continuity.api.ContinuationState;

public class StateManager {

    private final Runnable target;

    public StateManager(final Runnable target) {
        this.target = target;
    }

    public static Object suspend(final ContinuationState state) {
        return null;
    }

    public static void resume() {

    }

    public void snapshot() {

    }
}
