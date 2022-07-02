package com.engineersbox.continuity.instrumenter.lang.transform.exception;

public class CIBSyntaxError extends ContinuityIntermediateBytecodeException {

    public CIBSyntaxError(String message) {
        super(String.format("[CIB: Syntax Error] %s", message));
    }

    public CIBSyntaxError(Throwable cause) {
        super(
                "[CIB: Syntax Error] From cause",
                cause
        );
    }

    public CIBSyntaxError(String message, Throwable cause) {
        super(
                String.format("[CIB: Syntax Error] %s", message),
                cause
        );
    }
}
