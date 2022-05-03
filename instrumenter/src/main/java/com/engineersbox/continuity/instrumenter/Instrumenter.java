package com.engineersbox.continuity.instrumenter;

public interface Instrumenter {
    byte[] instrument(final byte[] classByteBuffer);
}
