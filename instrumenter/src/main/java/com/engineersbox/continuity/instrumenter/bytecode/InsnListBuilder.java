package com.engineersbox.continuity.instrumenter.bytecode;

import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.InsnList;

import java.util.Arrays;

public class InsnListBuilder {

    private final InsnList list;

    public InsnListBuilder() {
        this.list = new InsnList();
    }

    public InsnListBuilder addAll(final InsnList ...list) {
        Arrays.stream(list).forEach(this.list::add);
        return this;
    }

    public InsnListBuilder addAll(final AbstractInsnNode ...node) {
        Arrays.stream(node).forEach(this.list::add);
        return this;
    }

    public InsnList build() {
        return this.list;
    }
}
