package com.engineersbox.continuity.instrumenter.stack.variable;

import com.engineersbox.continuity.instrumenter.stack.ContextHandledTypes;
import org.objectweb.asm.Type;

import java.util.EnumMap;
import java.util.Map;

public class PrimitiveStack {

    private final Map<PrimitiveStackElementType, StackVariable> stackVars = new EnumMap<>(PrimitiveStackElementType.class);

    public void putStackVar(final PrimitiveStackElementType type,
                            final StackVariable stackVar) {
        this.stackVars.put(type, stackVar);
    }

    public StackVariable getStackVar(final PrimitiveStackElementType type) {
        return this.stackVars.get(type);
    }

    public static PrimitiveStack allocateSlots(final StackVarLUT stackVarLUT,
                                               final ContextHandledTypes handledTypes) {
        final PrimitiveStack primitiveStack = new PrimitiveStack();
        handledTypes.handledTypes.forEach((final PrimitiveStackElementType type) -> {
            final StackVariable stackVar = stackVarLUT.obtainExtraArg(Type.getType(type.getArrayClass()));
            switch (type) {
                case INTEGER -> primitiveStack.putStackVar(PrimitiveStackElementType.INTEGER, stackVar);
                case LONG -> primitiveStack.putStackVar(PrimitiveStackElementType.LONG, stackVar);
                case FLOAT -> primitiveStack.putStackVar(PrimitiveStackElementType.FLOAT, stackVar);
                case DOUBLE -> primitiveStack.putStackVar(PrimitiveStackElementType.DOUBLE, stackVar);
                case OBJECT -> primitiveStack.putStackVar(PrimitiveStackElementType.OBJECT, stackVar);
                default -> throw new IllegalStateException("Unsupported primitive stack element type");
            }
        });
        return primitiveStack;
    }
}
