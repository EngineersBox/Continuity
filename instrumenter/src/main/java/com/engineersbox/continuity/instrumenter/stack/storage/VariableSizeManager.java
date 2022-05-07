package com.engineersbox.continuity.instrumenter.stack.storage;

import org.objectweb.asm.Type;

public class VariableSizeManager {

    private int intsSize;
    private int longsSize;
    private int floatsSize;
    private int doublesSize;
    private int objectsSize;

    public VariableSizeManager(int intsSize,
                               int longsSize,
                               int floatsSize,
                               int doublesSize,
                               int objectsSize) {
         this.intsSize = intsSize;
         this.longsSize = longsSize;
         this.floatsSize = floatsSize;
         this.doublesSize = doublesSize;
         this.objectsSize = objectsSize;
    }

    public VariableSizeManager() {
        this(0,0,0,0,0);
    }


    public int getSize(final Type type) {
        return switch (type.getSort()) {
            case Type.BOOLEAN, Type.BYTE, Type.SHORT, Type.CHAR, Type.INT -> this.intsSize;
            case Type.FLOAT -> this.floatsSize;
            case Type.LONG -> this.longsSize;
            case Type.DOUBLE -> this.doublesSize;
            case Type.ARRAY, Type.OBJECT -> this.objectsSize;
            case Type.METHOD, Type.VOID, default -> throw new IllegalStateException("Unsupported type");
        };
    }

    public void decrementSize(final Type type) {
        switch (type.getSort()) {
            case Type.BOOLEAN, Type.BYTE, Type.SHORT, Type.CHAR, Type.INT -> this.intsSize--;
            case Type.FLOAT -> this.floatsSize--;
            case Type.LONG -> this.longsSize--;
            case Type.DOUBLE -> this.doublesSize--;
            case Type.ARRAY, Type.OBJECT -> this.objectsSize--;
            case Type.METHOD, Type.VOID, default -> throw new IllegalStateException("Unsupported type");
        };
    }

    public void incrementSize(final Type type) {
        switch (type.getSort()) {
            case Type.BOOLEAN, Type.BYTE, Type.SHORT, Type.CHAR, Type.INT -> this.intsSize++;
            case Type.FLOAT -> this.floatsSize++;
            case Type.LONG -> this.longsSize++;
            case Type.DOUBLE -> this.doublesSize++;
            case Type.ARRAY, Type.OBJECT -> this.objectsSize++;
            case Type.METHOD, Type.VOID, default -> throw new IllegalStateException("Unsupported type");
        };
    }
}
