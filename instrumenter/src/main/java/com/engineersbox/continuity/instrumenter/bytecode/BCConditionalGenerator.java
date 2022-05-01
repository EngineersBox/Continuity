package com.engineersbox.continuity.instrumenter.bytecode;

import org.objectweb.asm.tree.InsnList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

class BCConditionalGenerator implements BytecodeGenerator {

    private final List<Object> instructions;

    BCConditionalGenerator(final boolean condition,
                           final Supplier<Object[]> insnsSupplier) {
        this.instructions = new ArrayList<>();
        if (condition && insnsSupplier != null) {
            this.instructions.addAll(List.of(insnsSupplier.get()));
        }
    }

    @Override
    public InsnList generate() {
        return InsnFormatter.combine(this.instructions.toArray());
    }

}
