package com.engineersbox.continuity.instrumenter.bytecode.state.lva;

import com.engineersbox.continuity.instrumenter.bytecode.InsnBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.ObjectConstants;
import com.engineersbox.continuity.instrumenter.bytecode.annotation.BytecodeGenerator;
import com.engineersbox.continuity.instrumenter.bytecode.state.StackStateSaveOperations;
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
public class LVASaveOperations extends StackStateSaveOperations {

    private LVASaveOperations() {}

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
        final VariableSizeManager lvaStoreSizes = new VariableSizeManager();
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
            list.add(storeVarInStorageArray(markerType, i, lvaStoreSizes, lva.get(type), type));
            lvaStoreSizes.incrementSize(type);
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
}
