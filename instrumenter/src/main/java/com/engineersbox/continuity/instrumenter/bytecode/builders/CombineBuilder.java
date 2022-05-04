package com.engineersbox.continuity.instrumenter.bytecode.builders;

import com.engineersbox.continuity.instrumenter.bytecode.BytecodeBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.InsnListCollector;
import com.engineersbox.continuity.instrumenter.bytecode.annotation.BytecodeGenerator;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.InsnList;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.StreamSupport;

@BytecodeGenerator
public class CombineBuilder implements BytecodeBuilder {

    private Object[] insns;

    public CombineBuilder() {
    }

    public CombineBuilder insns(final Object... insns) {
        if (insns == null || Arrays.stream(insns).anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("Instructions cannot be null");
        }
        this.insns = insns;
        return this;
    }

    @Override
    public InsnList build() {
        return Arrays.stream(this.insns).map((final Object insn) -> {
            if (insn instanceof AbstractInsnNode insnNode) {
                return insnNode;
            } else if (insn instanceof InsnList insnList) {
                if (StreamSupport.stream(insnList.spliterator(), false).anyMatch(Objects::isNull)) {
                    throw new IllegalArgumentException("InsnList cannot contain null instructions");
                }
                return (InsnList) insn;
            } else if (insn instanceof BytecodeBuilder builder) {
                final InsnList insnList = builder.build();
                if (StreamSupport.stream(insnList.spliterator(), false).anyMatch(Objects::isNull)) {
                    throw new IllegalArgumentException("InsnList cannot contain null instructions");
                }
                return insnList;
            }
            throw new IllegalArgumentException("Unsupported instruction type");
        }).collect(InsnListCollector.toInsnList());
    }
}
