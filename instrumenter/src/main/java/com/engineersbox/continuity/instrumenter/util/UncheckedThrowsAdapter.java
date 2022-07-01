package com.engineersbox.continuity.instrumenter.util;

import com.engineersbox.continuity.instrumenter.util.throwable.ThrowsBiFunction;
import com.engineersbox.continuity.instrumenter.util.throwable.ThrowsFunction;

import java.util.function.BiFunction;
import java.util.function.Function;

public abstract class UncheckedThrowsAdapter {

    public static <T, R> Function<T, R> unchecked(final ThrowsFunction<T, R> function) {
        return (final T t) -> {
            try {
                return function.apply(t);
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static <T, U, R> BiFunction<T, U, R> unchecked(final ThrowsBiFunction<T, U, R> function) {
        return (final T t, final U u) -> {
            try {
                return function.apply(t, u);
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

}
