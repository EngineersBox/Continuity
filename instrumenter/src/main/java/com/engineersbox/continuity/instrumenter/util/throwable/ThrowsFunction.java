package com.engineersbox.continuity.instrumenter.util.throwable;

public interface ThrowsFunction<T, R> {

    R apply(final T t) throws Exception;

}
