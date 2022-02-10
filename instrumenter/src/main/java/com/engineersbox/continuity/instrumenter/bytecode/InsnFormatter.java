package com.engineersbox.continuity.instrumenter.bytecode;

import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.InsnList;

import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.StreamSupport;

public class InsnFormatter {

    public static InsnList combine(final Object ...insns) {
        InsnList ret = new InsnList();
        for (final Object insn : insns) {
            switch (insn) {
                case AbstractInsnNode insnNode -> ret.add(insnNode);
                case InsnList insnList -> {
                    StreamSupport.stream(insnList.spliterator(), false)
                            .filter(Objects::isNull)
                            .findAny()
                            .ifPresent((final AbstractInsnNode node) -> {
                                throw new IllegalArgumentException("Instruction cannot be null");
                            });
                    ret.add((InsnList) insn);
                }
                case BytecodeGenerator generator -> {
                    final InsnList insnList = generator.generate();
                    StreamSupport.stream(insnList.spliterator(), false)
                            .filter(Objects::isNull)
                            .findAny()
                            .ifPresent((final AbstractInsnNode node) -> {
                                throw new IllegalArgumentException("Instruction cannot be null");
                            });
                    ret.add(insnList);
                }
                case null, default -> throw new IllegalArgumentException(String.format("Invalid instruction format: %s", insn));
            }
        }
        return ret;
    }

    public static BytecodeGenerator combineIf(final boolean condition,
                                              final Supplier<Object[]> insns) {
        return new BCConditionalGenerator(condition, insns);
    }
}
