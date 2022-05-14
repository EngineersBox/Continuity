package com.engineersbox.continuity.instrumenter.bytecode.state;

import com.engineersbox.continuity.instrumenter.bytecode.InsnBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.InsnListCollector;
import com.engineersbox.continuity.instrumenter.stack.storage.PrimitiveStack;
import com.engineersbox.continuity.instrumenter.stack.storage.VariableLUT;
import com.engineersbox.continuity.instrumenter.stack.storage.VariableSizeManager;
import com.engineersbox.continuity.instrumenter.stage.DebugMarker;
import org.apache.commons.lang3.tuple.Pair;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.*;
import org.objectweb.asm.tree.analysis.BasicValue;
import org.objectweb.asm.tree.analysis.Frame;

import java.util.stream.Stream;

public abstract class StackStateLoadOperations {

    protected static int mapTypeToLoadArrayInsn(final Type type) {
        return switch (type.getSort()) {
            case Type.BOOLEAN, Type.BYTE, Type.SHORT, Type.CHAR, Type.INT -> Opcodes.IALOAD;
            case Type.FLOAT -> Opcodes.FALOAD;
            case Type.LONG -> Opcodes.LALOAD;
            case Type.DOUBLE -> Opcodes.DALOAD;
            case Type.ARRAY, Type.OBJECT -> Opcodes.AALOAD;
            default -> throw new IllegalArgumentException("No such operand for type");
        };
    }

    protected static int mapTypeToStoreInsn(final Type type) {
        return switch (type.getSort()) {
            case Type.BOOLEAN, Type.BYTE, Type.SHORT, Type.CHAR, Type.INT -> Opcodes.ISTORE;
            case Type.FLOAT -> Opcodes.FSTORE;
            case Type.LONG -> Opcodes.LSTORE;
            case Type.DOUBLE -> Opcodes.DSTORE;
            case Type.ARRAY, Type.OBJECT -> Opcodes.ASTORE;
            default -> throw new IllegalArgumentException("No such operand for type");
        };
    }

    protected static InsnList loadVariable(final DebugMarker markerType,
                                           final int index,
                                           final Type type,
                                           final VariableLUT.Variable variable,
                                           final VariableSizeManager sizes) {
        return InsnBuilder.combine(
                InsnBuilder.debugMarker()
                        .marker(markerType)
                        .message(String.format(
                                "Loading %s at %d from container index %d",
                                type.getInternalName(),
                                index,
                                sizes.getSize(type)
                        )).build(),
                new VarInsnNode(Opcodes.ALOAD, variable.getIndex()),
                new LdcInsnNode(sizes.getSize(type)),
                new InsnNode(mapTypeToLoadArrayInsn(type)),
                InsnBuilder.combineIf(
                        type.getSort() == Type.ARRAY || type.getSort() == Type.OBJECT,
                        () -> new Object[]{ new TypeInsnNode(Opcodes.CHECKCAST, type.getInternalName())}
                ).build()
        ).build();
    }

    protected static InsnList unpackVariablesFromContainer0(final DebugMarker markerType,
                                                            final VariableSizeManager sizes,
                                                            final VariableLUT.Variable container,
                                                            final PrimitiveStack stack,
                                                            final Stream<Pair<Integer, Type>> typeStream) {
        return typeStream.map((final Pair<Integer, Type> indexedType) -> InsnBuilder.combineIf(
                        sizes.getSize(indexedType.getRight()) > 0,
                        () -> new Object[]{
                                InsnBuilder.debugMarker()
                                        .marker(markerType)
                                        .message(String.format(
                                        "Unpacking %s from container",
                                        indexedType.getRight().getInternalName()
                                )),
                                new VarInsnNode(Opcodes.ALOAD, container.getIndex()),
                                new LdcInsnNode(indexedType.getLeft()),
                                new InsnNode(Opcodes.AALOAD),
                                new TypeInsnNode(Opcodes.CHECKCAST, stack.get(indexedType.getRight()).getType().getInternalName()),
                                new VarInsnNode(Opcodes.ASTORE, stack.get(indexedType.getRight()).getIndex()),
                        }
                ).build())
                .collect(InsnListCollector.toInsnList());
    }
}
