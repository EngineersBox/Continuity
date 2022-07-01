package com.engineersbox.continuity.instrumenter.util.throwable;

public interface ThrowsBiFunction<T, U, R> {

    R apply(final T t, final U u) throws Exception;

}
