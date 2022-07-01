package com.engineersbox.continuity.instrumenter.stack.storage;

import com.engineersbox.continuity.instrumenter.bytecode.ObjectConstants;
import org.objectweb.asm.Type;

import java.util.function.IntFunction;
import java.util.stream.IntStream;

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
            default -> throw new IllegalStateException("Unsupported type");
        };
    }

    public void decrementSize(final Type type) {
        switch (type.getSort()) {
            case Type.BOOLEAN, Type.BYTE, Type.SHORT, Type.CHAR, Type.INT -> this.intsSize--;
            case Type.FLOAT -> this.floatsSize--;
            case Type.LONG -> this.longsSize--;
            case Type.DOUBLE -> this.doublesSize--;
            case Type.ARRAY, Type.OBJECT -> this.objectsSize--;
            default -> throw new IllegalStateException("Unsupported type");
        }
    }

    public void incrementSize(final Type type) {
        switch (type.getSort()) {
            case Type.BOOLEAN, Type.BYTE, Type.SHORT, Type.CHAR, Type.INT -> this.intsSize++;
            case Type.FLOAT -> this.floatsSize++;
            case Type.LONG -> this.longsSize++;
            case Type.DOUBLE -> this.doublesSize++;
            case Type.ARRAY, Type.OBJECT -> this.objectsSize++;
            default -> throw new IllegalStateException("Unsupported type");
        }
    }

    private static IntStream createStream(final int from,
                                          final int to,
                                          final boolean reverse) {
        final IntStream stream = IntStream.range(from, to);
        return reverse ? stream.map(i -> to - i + from - 1) : stream;
    }

    public static VariableSizeManager computeSizes(final IntFunction<Type> frameParser,
                                                   final int from,
                                                   final int to,
                                                   final boolean reverse,
                                                   final boolean isNullable) {
        final VariableSizeManager manager = new VariableSizeManager();
        createStream(
                from,
                to,
                reverse
        ).forEach((final int i) -> {
            Type type = frameParser.apply(i);
            if ((isNullable && type == null) || type.getDescriptor().equals(ObjectConstants.NULL_OBJ_DESCRIPTOR)) {
                return;
            }
            manager.incrementSize(type);
        });
        return manager;
    }
}
