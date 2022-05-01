package com.engineersbox.continuity.instrumenter.stack;

import com.engineersbox.continuity.instrumenter.stack.variable.PrimitiveStackElementType;
import org.objectweb.asm.Type;

import java.util.HashSet;
import java.util.Set;

public class ContextHandledTypes {
    public final Set<PrimitiveStackElementType> handledTypes = new HashSet<>();

    public void trackType(final Type type) {
        switch (type.getSort()) {
            case Type.BOOLEAN, Type.BYTE, Type.CHAR, Type.SHORT, Type.INT -> this.handledTypes.add(PrimitiveStackElementType.INTEGER);
            case Type.LONG -> this.handledTypes.add(PrimitiveStackElementType.LONG);
            case Type.FLOAT -> this.handledTypes.add(PrimitiveStackElementType.FLOAT);
            case Type.DOUBLE -> this.handledTypes.add(PrimitiveStackElementType.DOUBLE);
            case Type.OBJECT, Type.ARRAY -> this.handledTypes.add(PrimitiveStackElementType.OBJECT);
            case Type.VOID, Type.METHOD, default -> throw new IllegalArgumentException();
        }
    }
}
