package com.engineersbox.continuity.instrumenter.stack.storage;

import com.engineersbox.continuity.instrumenter.util.TypeTranslationUtils;
import org.objectweb.asm.Type;

import java.util.HashMap;
import java.util.Map;

public class PrimitiveStack {
    private final Map<Type, VariableLUT.Variable> stackVars;

    public PrimitiveStack() {
        this.stackVars = new HashMap<>();
    }

    private void putIfNotExists(final Type type, final VariableLUT.Variable variable) {
        if (this.stackVars.containsKey(type)) {
            return;
        }
        this.stackVars.put(type, variable);
    }

    public void put(final Type type, final VariableLUT.Variable variable) {
        validateVariable(variable, TypeTranslationUtils.sortToClass(type));
        switch (type.getSort()) {
            case Type.BOOLEAN, Type.BYTE, Type.CHAR, Type.SHORT, Type.INT -> putIfNotExists(Type.INT_TYPE, variable);
            case Type.LONG -> putIfNotExists(Type.LONG_TYPE, variable);
            case Type.FLOAT -> putIfNotExists(Type.FLOAT_TYPE, variable);
            case Type.DOUBLE -> putIfNotExists(Type.DOUBLE_TYPE, variable);
            case Type.ARRAY, Type.OBJECT -> putIfNotExists(Type.getType(Object.class), variable);
            default -> throw new IllegalArgumentException("Unsupported variable type");
        }
    }

    private void validateVariable(final VariableLUT.Variable variable,
                                  final Class<?> type) {
        if (variable != null && !variable.getType().equals(Type.getType(type))) {
            throw new IllegalArgumentException(String.format(
                    "Variable type did not match expected type: %s != %s",
                    variable.getType(),
                    type
            ));
        }
    }

    private void validateVariableState(final VariableLUT.Variable variable) {
        if (variable == null) {
            throw new IllegalStateException("Variable not assigned");
        }
    }

    private VariableLUT.Variable get(final Type type) {
        final VariableLUT.Variable variable = this.stackVars.get(type);
        validateVariableState(variable);
        return variable;
    }
}
