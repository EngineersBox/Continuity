package com.engineersbox.continuity.instrumenter.util;

import org.objectweb.asm.Type;

public class TypeTranslationUtils {

    private TypeTranslationUtils() {}

    public static Class<?> sortToClass(final Type type) {
        return switch (type.getSort()) {
            case Type.BOOLEAN, Type.BYTE, Type.CHAR, Type.SHORT, Type.INT -> Integer.TYPE;
            case Type.LONG -> Long.TYPE;
            case Type.FLOAT -> Float.TYPE;
            case Type.DOUBLE -> Double.TYPE;
            case Type.ARRAY, Type.OBJECT -> Object.class;
            default -> null;
        };
    }

    public static Class<?> sortToArrayClass(final Type type) {
        return switch (type.getSort()) {
            case Type.BOOLEAN, Type.BYTE, Type.CHAR, Type.SHORT, Type.INT -> int[].class;
            case Type.LONG -> long[].class;
            case Type.FLOAT -> float[].class;
            case Type.DOUBLE -> double[].class;
            case Type.ARRAY, Type.OBJECT -> Object[].class;
            default -> null;
        };
    }
}
