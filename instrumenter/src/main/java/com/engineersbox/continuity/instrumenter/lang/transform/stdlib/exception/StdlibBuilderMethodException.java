package com.engineersbox.continuity.instrumenter.lang.transform.stdlib.exception;

public class StdlibBuilderMethodException extends RuntimeException {

    public StdlibBuilderMethodException(final String message) {
        super(message);
    }

    public StdlibBuilderMethodException(final Throwable cause) {
        super(cause);
    }
}
