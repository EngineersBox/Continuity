package com.engineersbox.continuity.core.state;

public enum ContinuationState {
    IDLE,
    SAVING,
    LOADING;

    private static final ContinuationState[] values = ContinuationState.values();

    public static ContinuationState fromOrdinal(final int ordinal) {
        final int boundedOrdinal = Math.min(Math.max(ordinal, 0), ContinuationState.values.length - 1);
        return ContinuationState.values[boundedOrdinal];
    }
}
