package com.engineersbox.continuity.instrumenter.bytecode.builders;

import com.engineersbox.continuity.instrumenter.bytecode.BytecodeBuilder;
import org.objectweb.asm.tree.InsnList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class CombineIfBuilder implements BytecodeBuilder {

    private List<Object> generatedInstructions;

    public CombineIfBuilder() {
        this.generatedInstructions = new ArrayList<>();
    }

    public CombineIfBuilder combineIf(final boolean condition,
                                      final Supplier<Object[]> insnsSupplier) {
        if (insnsSupplier == null) {
            throw new IllegalArgumentException("Supplier cannot be null");
        } else if (condition) {
            this.generatedInstructions.addAll(Arrays.asList(insnsSupplier.get()));
        }
        return this;
    }

    @Override
    public InsnList build() {
        return new CombineBuilder()
                .insns(this.generatedInstructions.toArray())
                .build();
    }
}
