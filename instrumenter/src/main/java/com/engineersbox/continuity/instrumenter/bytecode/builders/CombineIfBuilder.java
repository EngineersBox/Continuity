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

    // TODO: Address inputting supplier object
    public CombineIfBuilder combineIf(@StdlibBuilderParam(pos = 0) final boolean condition,
                                      @StdlibBuilderParam(pos = 1) final Supplier<Object[]> insnsSupplier) {
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
