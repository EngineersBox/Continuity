package com.engineersbox.continuity.instrumenter.bytecode.state;

import com.engineersbox.continuity.instrumenter.bytecode.InsnBuilder;
import com.engineersbox.continuity.instrumenter.stack.storage.PrimitiveStack;
import com.engineersbox.continuity.instrumenter.stack.storage.VariableLUT;
import com.engineersbox.continuity.instrumenter.stack.storage.VariableSizeManager;
import com.engineersbox.continuity.instrumenter.stage.DebugMarker;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.*;

public abstract class StackStateSaveOperations {

    protected StackStateSaveOperations() {}

    protected static InsnList saveVariable(final DebugMarker markerType,
                                           final PrimitiveStack lva,
                                           final VariableSizeManager sizes,
                                           final Type type) {
        final VariableLUT.Variable variable = lva.get(type);
        if (variable == null) {
            return new InsnList();
        }
        final int containerSize = sizes.getSize(type);
        final boolean isObjectType = type.equals(Type.getType(Object.class));
        return InsnBuilder.combineIf(
                containerSize > 0,
                () -> new Object[]{
                        InsnBuilder.debugMarker()
                                .marker(markerType)
                                .message(String.format(
                                        "Generating %s container of size %d",
                                        type.getInternalName(),
                                        containerSize
                                )).build(),
                        new LdcInsnNode(containerSize),
                        isObjectType
                                ? new TypeInsnNode(Opcodes.ANEWARRAY, "java/lang/Object")
                                : new IntInsnNode(Opcodes.NEWARRAY, mapTypeToTypeOperandInsn(type)),
                        new VarInsnNode(Opcodes.ASTORE, variable.getIndex())
                }
        ).build();
    }

    private static int mapTypeToTypeOperandInsn(final Type type) {
        return switch (type.getSort()) {
            case Type.BOOLEAN, Type.BYTE, Type.SHORT, Type.CHAR, Type.INT -> Opcodes.T_INT;
            case Type.FLOAT -> Opcodes.T_FLOAT;
            case Type.LONG -> Opcodes.T_LONG;
            case Type.DOUBLE -> Opcodes.T_DOUBLE;
            default -> throw new IllegalArgumentException("No such operand for type");
        };
    }

}
