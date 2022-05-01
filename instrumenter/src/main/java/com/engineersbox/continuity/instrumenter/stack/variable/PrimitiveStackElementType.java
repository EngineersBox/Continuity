package com.engineersbox.continuity.instrumenter.stack.variable;

public enum PrimitiveStackElementType {
    INTEGER(int[].class, Integer.TYPE),
    LONG(long[].class, Long.TYPE),
    FLOAT(float[].class, Float.TYPE),
    DOUBLE(double[].class, Double.TYPE),
    OBJECT(Object[].class, Object.class);

    private final Class<?> arrayClass;
    private final Class<?> literalClass;

    PrimitiveStackElementType(final Class<?> arrayClass,
                              final Class<?> literalClass) {
        this.arrayClass = arrayClass;
        this.literalClass = literalClass;
    }

    public Class<?> getArrayClass() { return this.arrayClass; }
    public Class<?> getLiteralClass() { return this.literalClass; }
}
