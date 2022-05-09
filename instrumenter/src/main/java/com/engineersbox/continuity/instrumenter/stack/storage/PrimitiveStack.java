package com.engineersbox.continuity.instrumenter.stack.storage;

import org.objectweb.asm.Type;

import java.util.HashMap;
import java.util.Map;

public class PrimitiveStack {
    private final Map<Integer, VariableLUT.Variable> stackVars;

    public PrimitiveStack() {
        this.stackVars = new HashMap<>();
    }

    private void putIfNotExists(final Type type, final VariableLUT.Variable variable) {
        if (this.stackVars.containsKey(internalSort(type))) {
            return;
        }
        this.stackVars.put(internalSort(type), variable);
    }

    public void put(final Type type, final VariableLUT.Variable variable) {
        validateVariable(type, variable);
        putIfNotExists(type, variable);
    }

    private void validateVariable(final Type type,
                                  final VariableLUT.Variable variable) {
        if (variable != null && !variable.getType().equals(type)) {
            throw new IllegalArgumentException(String.format(
                    "Variable type did not match expected type: %s != %s",
                    variable.getType(),
                    type
            ));
        }
    }

    public VariableLUT.Variable get(final Type type) {
        return this.stackVars.get(internalSort(type));
    }

    private int internalSort(final Type type) {
        return switch (type.getSort()) {
            case Type.BOOLEAN, Type.BYTE, Type.CHAR, Type.SHORT, Type.INT -> Type.INT;
            case Type.LONG -> Type.LONG;
            case Type.FLOAT -> Type.FLOAT;
            case Type.DOUBLE -> Type.DOUBLE;
            case Type.ARRAY, Type.OBJECT -> Type.OBJECT;
            default -> throw new IllegalArgumentException("Unsupported variable type");
        };
    }
}
