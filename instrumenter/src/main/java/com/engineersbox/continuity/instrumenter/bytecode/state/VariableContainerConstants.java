package com.engineersbox.continuity.instrumenter.bytecode.state;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.objectweb.asm.Type;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class VariableContainerConstants {

    private VariableContainerConstants() {}

    public static final List<Type> VARIABLE_TYPES = List.of(
            Type.INT_TYPE,
            Type.FLOAT_TYPE,
            Type.LONG_TYPE,
            Type.DOUBLE_TYPE,
            Type.getType(Object.class)
    );

    public static final List<Pair<Integer, Type>> INDEXED_LVA_TYPES = IntStream.range(0, 5)
            .mapToObj((final int index) -> ImmutablePair.of(index + 5, VARIABLE_TYPES.get(index)))
            .collect(Collectors.toList());

    public static final List<Pair<Integer, Type>> INDEXED_OS_TYPES = IntStream.range(0, 5)
            .mapToObj((final int index) -> ImmutablePair.of(index, VARIABLE_TYPES.get(index)))
            .collect(Collectors.toList());
}
