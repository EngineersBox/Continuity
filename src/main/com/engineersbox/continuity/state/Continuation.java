package com.engineersbox.continuity.state;

import java.io.Serializable;

public abstract class Continuation implements Serializable {

    public static Continuation startWith(final Runnable target) {
        return null; // TODO
    }

    public Continuation resume(final Object context) {
        return null; // TODO
    }

    public static Object suspend(final long id) {
        // Pause current thread context execution
        return null;
    }

    public Object value() {
        return null; // TODO
    }

    public Continuation snapshot(final long id) {
        final Object heldContext = suspend(id);
        // TODO: Take a snapshot and save
        snapshot0();
        return resume(heldContext);
    }

    public Object snapshotSuspended(final long id) {
        final Object heldContext = suspend(id);
        // TODO: take a snapshot and save
        snapshot0();
        return heldContext;
    }

    private void snapshot0() {
        // TODO
    }
}
