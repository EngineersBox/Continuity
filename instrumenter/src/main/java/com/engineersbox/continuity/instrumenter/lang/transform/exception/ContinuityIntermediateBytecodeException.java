package com.engineersbox.continuity.instrumenter.lang.transform.exception;

public class ContinuityIntermediateBytecodeException extends RuntimeException {

    public ContinuityIntermediateBytecodeException(final String message) {
        super(message);
    }

    public ContinuityIntermediateBytecodeException(final Throwable cause) {
        super(cause);
    }

    public ContinuityIntermediateBytecodeException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
