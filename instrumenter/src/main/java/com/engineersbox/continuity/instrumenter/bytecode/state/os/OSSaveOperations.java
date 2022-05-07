package com.engineersbox.continuity.instrumenter.bytecode.state.os;

import com.engineersbox.continuity.instrumenter.bytecode.InsnBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.InsnListBuilder;
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
public class OSSaveOperations {

    private static final String NULL_OBJ_DESCRIPTOR = "Lnull;";

    private OSSaveOperations() {}

    public static InsnList save(final DebugMarker markerType,
                                final PrimitiveStack os,
                                final Frame<BasicValue> frame) {
        return save(markerType, os, frame, frame.getStackSize());
    }

    public static InsnList save(final DebugMarker markerType,
                                final PrimitiveStack os,
                                final Frame<BasicValue> frame,
                                final int count) {
        if (markerType == null) {
            throw new IllegalArgumentException("Debug marker cannot be null");
        } else if (os == null) {
            throw new IllegalArgumentException("Operand stack cannot be null");
        } else if (frame == null) {
            throw new IllegalArgumentException("Frame cannot be null");
        } else if (count < 0 || count > frame.getStackSize()) {
            throw new IndexOutOfBoundsException(String.format(
                    "Variable count %d is not in range 0-%d",
                    count,
                    frame.getStackSize()
            ));
        }
        final VariableSizeManager sizes = computeSizes(frame, frame.getStackSize() - count, count);
        final InsnList list = new InsnList();
        VariableLUT.Variable.ALL_TYPES.stream()
                .map((final Type type) -> saveVariable(markerType, os, sizes, type))
                .forEach(list::add);

        for (int i = (frame.getStackSize() - 1); i >= (frame.getStackSize() - count); i--) {
            final Type type = frame.getStack(i).getType();
            if (type.getDescriptor().equals(NULL_OBJ_DESCRIPTOR)) {
                list.add(InsnBuilder.combine(
                        InsnBuilder.debugMarker()
                                .marker(markerType)
                                .message(String.format(
                                        "Skipped null value at index %d",
                                        i
                                )).build(),
                        new InsnNode(Opcodes.POP)
                ).build());
            }
            list.add(storeVarInLVA(markerType, i, os, sizes, type));
            sizes.decrementSize(type);
        }
        return InsnBuilder.combine(
                list
        ).build();
    }

    private static VariableSizeManager computeSizes(final Frame<BasicValue> frame,
                                                    final int offset,
                                                    final int count) {
        int intsSize = 0;
        int longsSize = 0;
        int floatsSize = 0;
        int doublesSize = 0;
        int objectsSize = 0;
        for (int i = offset + count - 1; i >= offset; i--) {
            Type type = frame.getStack(i).getType();
            if (type.getDescriptor().equals(NULL_OBJ_DESCRIPTOR)) {
                continue;
            }
            switch (type.getSort()) {
                case Type.BOOLEAN, Type.BYTE, Type.SHORT, Type.CHAR, Type.INT -> intsSize++;
                case Type.FLOAT -> floatsSize++;
                case Type.LONG -> longsSize++;
                case Type.DOUBLE -> doublesSize++;
                case Type.ARRAY, Type.OBJECT -> objectsSize++;
                case Type.METHOD, Type.VOID, default -> throw new IllegalStateException("Unsupported type");
            }
        }
        return new VariableSizeManager(
                intsSize,
                longsSize,
                floatsSize,
                doublesSize,
                objectsSize
        );
    }

    private static InsnList storeVarInLVA(final DebugMarker markerType,
                                          final int index,
                                          final PrimitiveStack os,
                                          final VariableSizeManager sizes,
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
                new VarInsnNode(Opcodes.ALOAD, sizes.getSize(type)),
                getStoreSwapOps(sizes, type)
        ).build();
    }

    private static InsnList getStoreSwapOps(final VariableSizeManager sizes,
                                            final Type type) {
        return switch (type.getSort()) {
            case Type.BOOLEAN, Type.BYTE, Type.SHORT, Type.CHAR, Type.INT, Type.FLOAT, Type.ARRAY, Type.OBJECT -> InsnBuilder.combine(
                    new InsnNode(Opcodes.SWAP),
                    new LdcInsnNode(sizes.getSize(type)),
                    new InsnNode(Opcodes.SWAP)
            ).build();
            case Type.LONG, Type.DOUBLE -> InsnBuilder.combine(
                    new LdcInsnNode(sizes.getSize(type)),
                    new InsnNode(Opcodes.DUP2_X2),
                    new InsnNode(Opcodes.POP2)
            ).build();
            case Type.METHOD, Type.VOID, default -> throw new IllegalStateException("Unsupported type");
        };
    }

    private static InsnList saveVariable(final DebugMarker markerType,
                                         final PrimitiveStack os,
                                         final VariableSizeManager sizes,
                                         final Type type) {
        final VariableLUT.Variable variable = os.get(type);
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
