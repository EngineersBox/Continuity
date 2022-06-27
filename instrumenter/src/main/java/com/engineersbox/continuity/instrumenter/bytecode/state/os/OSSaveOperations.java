package com.engineersbox.continuity.instrumenter.bytecode.state.os;

import com.engineersbox.continuity.instrumenter.bytecode.InsnBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.ObjectConstants;
import com.engineersbox.continuity.instrumenter.bytecode.annotation.BytecodeGenerator;
import com.engineersbox.continuity.instrumenter.bytecode.state.StackStateSaveOperations;
import com.engineersbox.continuity.instrumenter.stack.storage.PrimitiveStack;
import com.engineersbox.continuity.instrumenter.stack.storage.VariableLUT;
import com.engineersbox.continuity.instrumenter.stack.storage.VariableSizeManager;
import com.engineersbox.continuity.instrumenter.bytecode.DebugMarker;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.*;
import org.objectweb.asm.tree.analysis.BasicValue;
import org.objectweb.asm.tree.analysis.Frame;

@BytecodeGenerator
public class OSSaveOperations extends StackStateSaveOperations {

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
        final VariableSizeManager sizes = VariableSizeManager.computeSizes(
                (final int i) -> frame.getStack(i).getType(),
                0,
                frame.getStackSize(),
                true,
                true
        );
        final InsnList list = new InsnList();
        VariableLUT.Variable.ALL_TYPES.stream()
                .map((final Type type) -> saveVariable(markerType, os, sizes, type))
                .forEach(list::add);

        for (int i = (frame.getStackSize() - 1); i >= (frame.getStackSize() - count); i--) {
            final Type type = frame.getStack(i).getType();
            if (type.getDescriptor().equals(ObjectConstants.NULL_OBJ_DESCRIPTOR)) {
                list.add(InsnBuilder.combine(
                        InsnBuilder.debugMarker()
                                .marker(markerType)
                                .message(String.format(
                                        "Skipped null value at index %d",
                                        i
                                )).build(),
                        new InsnNode(Opcodes.POP)
                ).build());
                continue;
            }
            list.add(storeVarInLVA(
                    markerType,
                    i,
                    sizes,
                    os,
                    type
            ));
            sizes.decrementSize(type);
        }
        return InsnBuilder.combine(
                list
        ).build();
    }

    private static InsnList storeVarInLVA(final DebugMarker markerType,
                                          final int index,
                                          final VariableSizeManager sizes,
                                          final PrimitiveStack os,
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
                new VarInsnNode(Opcodes.ALOAD, os.get(type).getIndex()),
                getStoreSwapOps(sizes, type),
                getStoreOp(type)
        ).build();
    }

    private static InsnList getStoreSwapOps(final VariableSizeManager sizes,
                                            final Type type) {
        return switch (type.getSort()) {
            case Type.BOOLEAN, Type.BYTE, Type.SHORT, Type.CHAR, Type.INT, Type.FLOAT, Type.ARRAY, Type.OBJECT -> InsnBuilder.combine(
                    new InsnNode(Opcodes.SWAP),
                    new LdcInsnNode(sizes.getSize(type) - 1),
                    new InsnNode(Opcodes.SWAP)
            ).build();
            case Type.LONG, Type.DOUBLE -> InsnBuilder.combine(
                    new LdcInsnNode(sizes.getSize(type) - 1),
                    new InsnNode(Opcodes.DUP2_X2),
                    new InsnNode(Opcodes.POP2)
            ).build();
            default -> throw new IllegalStateException("Unsupported type");
        };
    }

    private static InsnNode getStoreOp(final Type type) {
        return new InsnNode(switch (type.getSort()) {
            case Type.BOOLEAN, Type.BYTE, Type.SHORT, Type.CHAR, Type.INT -> Opcodes.IASTORE;
            case Type.FLOAT -> Opcodes.FASTORE;
            case Type.LONG -> Opcodes.LASTORE;
            case Type.DOUBLE -> Opcodes.DASTORE;
            case Type.ARRAY, Type.OBJECT -> Opcodes.AASTORE;
            default -> throw new IllegalArgumentException("No such operand for type");
        });
    }
}
