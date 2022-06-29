package com.engineersbox.continuity.instrumenter.lang.transform.stdlib;

import com.engineersbox.continuity.instrumenter.bytecode.BytecodeBuilder;
import com.engineersbox.continuity.instrumenter.lang.transform.stdlib.annotation.StdlibBuilderParam;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.*;

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

    private void validateParameterType(final int index,
                                       final Class<?> type,
                                       final Object param) {
        if (!type.isInstance(param)) {
            throw new StdlibBuilderMethodException(String.format(
                    "Expected type \"%s\", but got \"%s\" at parameter index %d",
                    type.getName(),
                    param.getClass().getName(),
                    index
            ));
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends BytecodeBuilder> T apply(final T builder,
                                               final List<Object> parameters) {
        final Object[] params = this.bindings.stream()
                .peek((final Pair<StdlibBuilderParam, Class<?>> pair) -> {
                    if (parameters.size() >= pair.getLeft().pos()) {
                        throw new StdlibBuilderMethodException(String.format(
                                "No parameter provided for index %d, expected value of type \"%s\"",
                                pair.getLeft().pos(),
                                pair.getRight().getName()
                        ));
                    }
                }).peek((final Pair<StdlibBuilderParam, Class<?>> pair) -> validateParameterType(
                        pair.getLeft().pos(),
                        pair.getRight(),
                        parameters.get(pair.getLeft().pos())
                )).map(Pair::getLeft)
                .map(StdlibBuilderParam::pos)
                .map(parameters::get)
                .toArray(Object[]::new);
        try {
            return (T) this.method.invoke(builder, params);
        } catch (final InvocationTargetException | IllegalAccessException e) {
            throw new StdlibBuilderMethodException(e);
        }
    }
}
