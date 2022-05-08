package com.engineersbox.continuity.instrumenter.bytecode.state.lva;

import com.engineersbox.continuity.instrumenter.bytecode.InsnBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.ObjectConstants;
import com.engineersbox.continuity.instrumenter.bytecode.annotation.BytecodeGenerator;
import com.engineersbox.continuity.instrumenter.stack.storage.PrimitiveStack;
import com.engineersbox.continuity.instrumenter.stack.storage.VariableLUT;
import com.engineersbox.continuity.instrumenter.stack.storage.VariableSizeManager;
import com.engineersbox.continuity.instrumenter.stage.DebugMarker;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.*;
import org.objectweb.asm.tree.analysis.BasicValue;
import org.objectweb.asm.tree.analysis.Frame;

@BytecodeGenerator
public class LVASaveOperations {

    public static InsnList save(final DebugMarker markerType,
                                final PrimitiveStack lva,
                                final Frame<BasicValue> frame) {
        if (markerType == null) {
            throw new IllegalArgumentException("Debug marker cannot be null");
        } else if (lva == null) {
            throw new IllegalArgumentException("Local variable array cannot be null");
        } else if (frame == null) {
            throw new IllegalArgumentException("Frame cannot be null");
        }
        final VariableSizeManager sizes = VariableSizeManager.computeSizes(
                (final int i) -> frame.getLocal(i).getType(),
                0,
                frame.getLocals(),
                false,
                false
        );
        final InsnList list = new InsnList();
        VariableLUT.Variable.ALL_TYPES.stream()
                .map((final Type type) -> saveVariable(markerType, lva, sizes, type))
                .forEach(list::add);

        for (int i = 0; i < frame.getLocals();  i++) {
            final Type type = frame.getLocal(i).getType();
            if (type.getDescriptor().equals(ObjectConstants.NULL_OBJ_DESCRIPTOR)) {
                list.add(InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message(String.format(
                                "Skipped null value at index %d",
                                i
                        )).build());
                continue;
            }
            list.add(storeVarInStorageArray(markerType, i, sizes, lva.get(type), type));
            sizes.incrementSize(type);
        }
        return InsnBuilder.combine(
                list
        ).build();
    }

    private static InsnList storeVarInStorageArray(final DebugMarker markerType,
                                                   final int index,
                                                   final VariableSizeManager sizes,
                                                   final VariableLUT.Variable variable,
                                                   final Type type) {
        return InsnBuilder.combine(
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message(String.format(
                                "Storing %s at %d for index %d",
                                type.getInternalName(),
                                index,
                                sizes.getSize(type)
                        )),
                new VarInsnNode(Opcodes.ALOAD, variable.getIndex()),
                new LdcInsnNode(sizes.getSize(type)),
                getLoadStoreOps(type, index)
        ).build();
    }

    private static InsnList getLoadStoreOps(final Type type,
                                            final int index) {
        return switch (type.getSort()) {
            case Type.BOOLEAN, Type.BYTE, Type.SHORT, Type.CHAR, Type.INT -> InsnBuilder.combine(
                    new VarInsnNode(Opcodes.ILOAD, index),
                    new InsnNode(Opcodes.IASTORE)
            ).build();
            case Type.FLOAT -> InsnBuilder.combine(
                    new VarInsnNode(Opcodes.FLOAD, index),
                    new InsnNode(Opcodes.FASTORE)
            ).build();
            case Type.LONG -> InsnBuilder.combine(
                    new VarInsnNode(Opcodes.LLOAD, index),
                    new InsnNode(Opcodes.LASTORE)
            ).build();
            case Type.DOUBLE -> InsnBuilder.combine(
                    new VarInsnNode(Opcodes.DLOAD, index),
                    new InsnNode(Opcodes.DASTORE)
            ).build();
            case Type.ARRAY, Type.OBJECT -> InsnBuilder.combine(
                    new VarInsnNode(Opcodes.ALOAD, index),
                    new InsnNode(Opcodes.AASTORE)
            ).build();
            default -> throw new IllegalArgumentException("No such operand for type");
        };
    }

    private static InsnList saveVariable(final DebugMarker markerType,
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
