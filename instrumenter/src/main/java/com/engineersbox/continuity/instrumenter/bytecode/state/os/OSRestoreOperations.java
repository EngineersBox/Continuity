package com.engineersbox.continuity.instrumenter.bytecode.state.os;

import com.engineersbox.continuity.instrumenter.bytecode.InsnBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.ObjectConstants;
import com.engineersbox.continuity.instrumenter.bytecode.annotation.BytecodeGenerator;
import com.engineersbox.continuity.instrumenter.bytecode.state.StackStateLoadOperations;
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
public class OSRestoreOperations extends StackStateLoadOperations {

    private OSRestoreOperations() {}

    public static InsnList restore(final DebugMarker markerType,
                                   final PrimitiveStack os,
                                   final Frame<BasicValue> frame) {
        return restore(
                markerType,
                os,
                frame,
                0,
                0,
                frame.getMaxStackSize()
        );
    }

    public static InsnList restore(final DebugMarker markerType,
                                   final PrimitiveStack os,
                                   final Frame<BasicValue> frame,
                                   final int osStartIndex,
                                   final int osLoadIndex,
                                   final int count) {
        if (markerType == null) {
            throw new IllegalArgumentException("Debug marker cannot be null");
        } else if (os == null) {
            throw new IllegalArgumentException("OS stack cannot be null");
        } else if (frame == null) {
            throw new IllegalArgumentException("Frame cannot be null");
        } else if (osStartIndex < 0) {
            throw new IndexOutOfBoundsException(osStartIndex);
        } else if (osLoadIndex < 0) {
            throw new IndexOutOfBoundsException(osLoadIndex);
        } else if (osLoadIndex < osStartIndex) {
            throw new IndexOutOfBoundsException(String.format(
                    "Load index cannot be less than start index: %d < %d",
                    osLoadIndex,
                    osStartIndex
            ));
        } else if (osStartIndex + count > frame.getStackSize()) {
            throw new IndexOutOfBoundsException(String.format(
                    "Last element cannot be out of bounds of stack: %d > %d",
                    osStartIndex + count,
                    frame.getStackSize()
            ));
        } else if (osStartIndex + count < 0) {
            throw new IndexOutOfBoundsException("Last element cannot be negative");
        }
        final VariableSizeManager sizes = new VariableSizeManager();
        for (int i = osStartIndex; i < osLoadIndex; i++) {
            final Type type = frame.getStack(i).getType();
            if (type.getSort() == Type.OBJECT && type.getDescriptor().equals(ObjectConstants.NULL_OBJ_DESCRIPTOR)) {
                continue;
            }
            sizes.incrementSize(type);
        }
        final InsnList insnList = new InsnList();
        insnList.add(InsnBuilder.debugMarker()
                .marker(markerType)
                .message("Loading OS variables")
                .build());
        for (int i = osStartIndex; i < osLoadIndex + count; i++) {
            final Type type = frame.getStack(i).getType();
            if (type.getSort() == Type.OBJECT && type.getDescriptor().equals(ObjectConstants.NULL_OBJ_DESCRIPTOR)) {
                insnList.add(InsnBuilder.combine(
                        InsnBuilder.debugMarker()
                                .marker(markerType)
                                .message("Loading null at " + i)
                                .build(),
                        new InsnNode(Opcodes.ACONST_NULL)
                ).build());
            }
            insnList.add(InsnBuilder.combine(
                    InsnBuilder.debugMarker()
                            .marker(markerType)
                            .message(String.format(
                                    "Loading %s at %d from container index %d",
                                    type.getInternalName(),
                                    i,
                                    sizes.getSize(type)
                            )).build(),
                    loadVariable(
                            type,
                            os.get(type),
                            sizes
                    ),
                    InsnBuilder.combineIf(
                            type.getSort() == Type.ARRAY || type.getSort() == Type.OBJECT,
                            () -> new Object[]{ new TypeInsnNode(Opcodes.CHECKCAST, type.getInternalName())}
                    ).build()
            ).build());
            sizes.incrementSize(type);
        }
        return insnList;
    }

    private static InsnList loadVariable(final Type type,
                                         final VariableLUT.Variable variable,
                                         final VariableSizeManager sizes) {
        return InsnBuilder.combine(
                new VarInsnNode(Opcodes.ALOAD, variable.getIndex()),
                new LdcInsnNode(sizes.getSize(type)),
                new InsnNode(mapTypeToLoadArrayInsn(type))
        ).build();
    }
}
