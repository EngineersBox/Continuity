package com.engineersbox.continuity.instrumenter.bytecode.state.store;

import com.engineersbox.continuity.instrumenter.bytecode.InsnBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.InsnListCollector;
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

import java.util.concurrent.atomic.AtomicInteger;

@BytecodeGenerator
public class ArrayStoreSaveOperations {

    private ArrayStoreSaveOperations() {}


    public static InsnList save(final DebugMarker markerType,
                                final VariableLUT.Variable container,
                                final PrimitiveStack lva,
                                final PrimitiveStack os,
                                final Frame<BasicValue> frame) {
        final VariableSizeManager osSizes = VariableSizeManager.computeSizes(
                (final int i) -> frame.getStack(i).getType(),
                0,
                frame.getStackSize(),
                false,
                true
        );
        final VariableSizeManager lvaSizes = VariableSizeManager.computeSizes(
                (final int i) -> frame.getLocal(i).getType(),
                0,
                frame.getLocals(),
                false,
                false
        );
        final AtomicInteger index = new AtomicInteger(0);
        return InsnBuilder.combine(
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message("Packing LVA and OS vars into array")
                        .build(),
                new LdcInsnNode(10),
                new TypeInsnNode(Opcodes.ANEWARRAY, "java/lang/Object"),
                new VarInsnNode(Opcodes.ASTORE, container.getIndex()),
                VariableLUT.Variable.ALL_TYPES.stream()
                        .map((final Type type) -> {
                            final InsnList storeInsns = storeVariable(
                                    markerType,
                                    container,
                                    lva.get(type),
                                    type,
                                    lvaSizes,
                                    index.get()
                            );
                            index.getAndIncrement();
                            return storeInsns;
                        }).collect(InsnListCollector.toInsnList()),
                VariableLUT.Variable.ALL_TYPES.stream()
                        .map((final Type type) -> {
                            final InsnList storeInsns = storeVariable(
                                    markerType,
                                    container,
                                    os.get(type),
                                    type,
                                    osSizes,
                                    index.get()
                            );
                            index.getAndIncrement();
                            return storeInsns;
                        }).collect(InsnListCollector.toInsnList())
        ).build();
    }

    private static InsnList storeVariable(final DebugMarker markerType,
                                          final VariableLUT.Variable container,
                                          final VariableLUT.Variable variable,
                                          final Type type,
                                          final VariableSizeManager sizes,
                                          final int index) {
        return InsnBuilder.combineIf(
                sizes.getSize(type) > 0,
                () -> new Object[]{
                        InsnBuilder.debugMarker()
                                .marker(markerType)
                                .message(String.format(
                                "Storing %s into array at index %d",
                                type.getInternalName(),
                                index
                        )).build(),
                        new VarInsnNode(Opcodes.ALOAD, container.getIndex()),
                        new LdcInsnNode(index),
                        new VarInsnNode(Opcodes.ALOAD, variable.getIndex()),
                        new InsnNode(Opcodes.AASTORE),
                }
        ).build();
    }
}
