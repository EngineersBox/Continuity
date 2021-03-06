package com.engineersbox.continuity.instrumenter.lang.transform.stdlib.exception;

public class BuilderResolverException extends RuntimeException {

    public BuilderResolverException(final String message) {
        super(message);
    }

    public BuilderResolverException(final Throwable cause) {
        super(cause);
    }
}
