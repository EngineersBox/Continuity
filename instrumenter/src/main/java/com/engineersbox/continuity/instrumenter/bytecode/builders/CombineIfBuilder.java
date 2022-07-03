package com.engineersbox.continuity.instrumenter.bytecode.builders;

import com.engineersbox.continuity.instrumenter.bytecode.BytecodeBuilder;
import com.engineersbox.continuity.instrumenter.lang.transform.stdlib.annotation.StdlibBuilder;
import com.engineersbox.continuity.instrumenter.lang.transform.stdlib.annotation.StdlibBuilderParam;
import org.objectweb.asm.tree.InsnList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

@StdlibBuilder(methodName = "combineIf")
public class CombineIfBuilder implements BytecodeBuilder {

    private final List<Object> generatedInstructions;

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

    @SuppressWarnings("unused")
    public CombineIfBuilder combineIf(@StdlibBuilderParam(pos = 0) final boolean condition,
                                      @StdlibBuilderParam(pos = 1, varargs = true) final Object ...insns) {
        return combineIf(
                condition,
                insns == null || insns.length == 0 ? null : () -> insns
        );
    }

    @Override
    public InsnList build() {
        return new CombineBuilder()
                .insns(this.generatedInstructions.toArray())
                .build();
    }
}
