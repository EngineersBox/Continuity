package com.engineersbox.continuity.instrumenter.bytecode.state.lva;

import com.engineersbox.continuity.instrumenter.bytecode.InsnBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.ObjectConstants;
import com.engineersbox.continuity.instrumenter.bytecode.annotation.BytecodeGenerator;
import com.engineersbox.continuity.instrumenter.bytecode.state.StackStateLoadOperations;
import com.engineersbox.continuity.instrumenter.bytecode.state.VariableContainerConstants;
import com.engineersbox.continuity.instrumenter.stack.storage.PrimitiveStack;
import com.engineersbox.continuity.instrumenter.stack.storage.VariableLUT;
import com.engineersbox.continuity.instrumenter.stack.storage.VariableSizeManager;
import com.engineersbox.continuity.instrumenter.bytecode.DebugMarker;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.VarInsnNode;
import org.objectweb.asm.tree.analysis.BasicValue;
import org.objectweb.asm.tree.analysis.Frame;

@BytecodeGenerator
public class LVARestoreOperations extends StackStateLoadOperations {

    private LVARestoreOperations() {}

    public static InsnList restore(final DebugMarker markerType,
                                   final PrimitiveStack lva,
                                   final Frame<BasicValue> frame) {
        if (markerType == null) {
            throw new IllegalArgumentException("Debug marker cannot be null");
        } else if (lva == null) {
            throw new IllegalArgumentException("LVA stack cannot be null");
        } else if (frame == null) {
            throw new IllegalArgumentException("Frame cannot be null");
        }
        final VariableSizeManager sizes = new VariableSizeManager();
        final InsnList insnList = new InsnList();
        for (int i = 0; i < frame.getLocals(); i++) {
            final Type type = frame.getLocal(i).getType();
            if (type == null) {
                insnList.add(InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Skipping uninitialized value at " + i)
                        .build());
                continue;
            }
            if (type.getSort() == Type.OBJECT && type.getDescriptor().equals(ObjectConstants.NULL_OBJ_DESCRIPTOR)) {
                insnList.add(InsnBuilder.combine(
                        InsnBuilder.debugMarker()
                                .marker(markerType)
                                .message("Loading null at " + i)
                                .build(),
                        new InsnNode(Opcodes.ACONST_NULL),
                        new VarInsnNode(Opcodes.ASTORE, i)
                ).build());
                continue;
            }
            insnList.add(InsnBuilder.combine(
                    loadVariable(
                            markerType,
                            i,
                            type,
                            lva.get(type),
                            sizes
                    ),
                    new VarInsnNode(mapTypeToStoreInsn(type), i)
            ).build());
            sizes.incrementSize(type);
        }
        return insnList;
    }

    public static InsnList unpackVariablesFromContainer(final DebugMarker markerType,
                                                        final Frame<BasicValue> frame,
                                                        final VariableLUT.Variable container,
                                                        final PrimitiveStack lva) {
        if (markerType == null) {
            throw new IllegalArgumentException("Debug marker cannot be null");
        } else if (frame == null) {
            throw new IllegalStateException("Frame cannot be null");
        } else if (container == null) {
            throw new IllegalStateException("Container cannot be null");
        } else if (lva == null) {
            throw new IllegalStateException("LVA stack cannot be null");
        }
        final VariableSizeManager sizes = VariableSizeManager.computeSizes(
                (final int i) -> frame.getLocal(i).getType(),
                0,
                frame.getLocals(),
                false,
                false
        );
        return unpackVariablesFromContainer0(
                markerType,
                sizes,
                container,
                lva,
                VariableContainerConstants.INDEXED_LVA_TYPES.stream()
        );
    }

}
