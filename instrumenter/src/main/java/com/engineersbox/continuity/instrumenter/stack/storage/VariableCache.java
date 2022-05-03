package com.engineersbox.continuity.instrumenter.stack.storage;

import com.engineersbox.continuity.instrumenter.stack.storage.VariableLUT.Variable;
import org.objectweb.asm.Type;

import java.util.HashMap;
import java.util.Map;

public class VariableCache {
    private final Map<Type, Variable> cacheVars;

    public VariableCache() {
        this.cacheVars = new HashMap<>();
    }

    private void putIfNotExists(final Type type, final Variable variable) {
        if (this.cacheVars.containsKey(type)) {
            return;
        }
        this.cacheVars.put(type, variable);
    }

    public void put(final Type type, final Variable variable) {
        validateVariable(type, variable);
        switch (type.getSort()) {
            case Type.BOOLEAN, Type.BYTE, Type.CHAR, Type.SHORT, Type.INT -> putIfNotExists(Type.INT_TYPE, variable);
            case Type.LONG -> putIfNotExists(Type.LONG_TYPE, variable);
            case Type.FLOAT -> putIfNotExists(Type.FLOAT_TYPE, variable);
            case Type.DOUBLE -> putIfNotExists(Type.DOUBLE_TYPE, variable);
            case Type.ARRAY, Type.OBJECT -> putIfNotExists(Type.getType(Object.class), variable);
            default -> throw new IllegalArgumentException("Unsupported variable type");
        }
    }

    private void validateVariable(final Type type,
                                  final Variable variable) {
        if (variable != null && variable.getType().equals(type)) {
            throw new IllegalArgumentException(String.format(
                    "Variable type did not match expected type: %s != %s",
                    variable.getType(),
                    type
            ));
        }
    }

    private void validateVariableState(final Variable variable) {
        if (variable == null) {
            throw new IllegalStateException("Variable not assigned");
        }
    }

    private Variable get(final Type type) {
        final Variable variable = this.cacheVars.get(type);
        validateVariableState(variable);
        return variable;
    }

    public Variable getReturnCacheVar(final Type type) {
        return switch (type.getSort()) {
            case Type.BOOLEAN, Type.BYTE, Type.CHAR, Type.SHORT, Type.INT -> get(Type.INT_TYPE);
            case Type.LONG -> get(Type.LONG_TYPE);
            case Type.FLOAT -> get(Type.FLOAT_TYPE);
            case Type.DOUBLE -> get(Type.DOUBLE_TYPE);
            case Type.ARRAY, Type.OBJECT -> get(Type.getType(Object.class));
            case Type.VOID -> null;
            default -> throw new IllegalArgumentException("Unsupported variable type");
        };
    }
}
