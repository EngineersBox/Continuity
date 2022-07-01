package com.engineersbox.continuity.instrumenter.lang.transform.stdlib;

import com.engineersbox.continuity.instrumenter.bytecode.BytecodeBuilder;
import com.engineersbox.continuity.instrumenter.lang.transform.stdlib.annotation.StdlibBuilderParam;
import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

public class StdlibBuilderMethod {

    private final Method method;
    private final List<Pair<StdlibBuilderParam, Class<?>>> bindings;

    public StdlibBuilderMethod(final Method method) {
        this.method = method;
        this.bindings = new ArrayList<>();
    }

    public void bind(final StdlibBuilderParam param,
                     final Class<?> type) {
        this.bindings.add(Pair.of(param, type));
    }

    private void validateParameterType(final Pair<StdlibBuilderParam, Class<?>> pair,
                                       final List<Object> parameters) {
        try {
            final int index = pair.getLeft().pos();
            final Class<?> type = pair.getRight();
            final Object param = parameters.get(pair.getLeft().pos());
            if (!type.isInstance(param) && (type.isArray() && !type.getComponentType().isInstance(param))) {
                throw new StdlibBuilderMethodException(String.format(
                        "Expected type \"%s\", but got \"%s\" at parameter index %d",
                        type.getName(),
                        param.getClass().getName(),
                        index
                ));
            }
        } catch (final IndexOutOfBoundsException e) {
            if (!pair.getLeft().varargs()) {
                throw e;
            }
        }
    }

    private void validateParameterPresent(final Pair<StdlibBuilderParam, Class<?>> pair,
                                          final List<Object> parameters) {
        if (!pair.getLeft().varargs() && pair.getLeft().pos() >= parameters.size()) {
            throw new StdlibBuilderMethodException(String.format(
                    "No parameter provided for index %d, expected value of type \"%s\"",
                    pair.getLeft().pos(),
                    pair.getRight().getName()
            ));
        }
    }

    private Object getParameterOrDefault(final Pair<StdlibBuilderParam, Class<?>> pair,
                                         final List<Object> parameters) {
        final StdlibBuilderParam builderParam = pair.getLeft();
        if (builderParam.varargs() && builderParam.pos() >= parameters.size()) {
            return Array.newInstance(pair.getRight(), 1);
        }
        Object param = parameters.get(builderParam.pos());
        if (builderParam.varargs()) {
            final Object varargsWrapper = Array.newInstance(param.getClass(), 1);
            Array.set(varargsWrapper, 0, param);
            param = varargsWrapper;
        }
        return param;
    }

    @SuppressWarnings("unchecked")
    public <T extends BytecodeBuilder> T apply(final T builder,
                                               final List<Object> parameters) {
        final Object[] params = this.bindings.stream()
                .peek((final Pair<StdlibBuilderParam, Class<?>> pair) -> validateParameterPresent(pair, parameters))
                .peek((final Pair<StdlibBuilderParam, Class<?>> pair) -> validateParameterType(pair, parameters))
                .map((final Pair<StdlibBuilderParam, Class<?>> pair) -> getParameterOrDefault(pair, parameters))
                .toArray(Object[]::new);
        try {
            return (T) this.method.invoke(builder, params);
        } catch (final InvocationTargetException | IllegalAccessException e) {
            throw new StdlibBuilderMethodException(e);
        } catch (final IllegalArgumentException e) {
            throw new StdlibBuilderMethodException(String.format(
                    "Mismatch in method type parameters. [Expected: %s] [Actual: %s]",
                    Arrays.stream(this.method.getParameterTypes())
                            .map(Class::getCanonicalName)
                            .collect(Collectors.joining(", ")),
                    Arrays.stream(params)
                            .map(Object::getClass)
                            .map(Class::getCanonicalName)
                            .collect(Collectors.joining(", "))
            ));
        }
    }
}
