package com.engineersbox.continuity.instrumenter.bytecode;

import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.InsnList;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class InsnListCollector implements Collector<Object, InsnList, InsnList> {

    private InsnListCollector() {}

    public static InsnListCollector toInsnList() {
        return new InsnListCollector();
    }

    @Override
    public Supplier<InsnList> supplier() {
        return InsnList::new;
    }

    @Override
    public BiConsumer<InsnList, Object> accumulator() {
        return (final InsnList list, final Object node) -> {
            if (node instanceof AbstractInsnNode insnNode) {
                list.add(insnNode);
            } else if (node instanceof InsnList insnList) {
                list.add(insnList);
            }
        };
    }

    @Override
    public BinaryOperator<InsnList> combiner() {
        return (final InsnList list1, final InsnList list2) -> {
            list1.add(list2);
            return list1;
        };
    }

    @Override
    public Function<InsnList, InsnList> finisher() {
        return (final InsnList list) -> list;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.IDENTITY_FINISH);
    }
}
