package com.engineersbox.continuity.core.annotation.exception;

public class UnknownBytecodeInvokeTargetException extends RuntimeException {
    public UnknownBytecodeInvokeTargetException(final String message) {
        super(message);
    }
}
