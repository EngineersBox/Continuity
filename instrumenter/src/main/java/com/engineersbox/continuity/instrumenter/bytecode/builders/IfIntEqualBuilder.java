package com.engineersbox.continuity.instrumenter.bytecode.builders;

import com.engineersbox.continuity.instrumenter.bytecode.BytecodeBuilder;
import com.engineersbox.continuity.instrumenter.lang.transform.stdlib.annotation.StdlibBuilder;
import com.engineersbox.continuity.instrumenter.lang.transform.stdlib.annotation.StdlibBuilderParam;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.InsnList;

@StdlibBuilder(methodName = "ifIntEqual")
public class IfIntEqualBuilder implements BytecodeBuilder {

    private IfIntCompareBuilder builder;

    public IfIntEqualBuilder() {
        this.builder = new IfIntCompareBuilder().invertedComparisonType(Opcodes.IF_ICMPNE);
    }

    public IfIntEqualBuilder lhs(@StdlibBuilderParam(pos = 0) final InsnList lhsArg) {
        this.builder = this.builder.lhs(lhsArg);
        return this;
    }

    public IfIntEqualBuilder rhs(@StdlibBuilderParam(pos = 1) final InsnList rhsArg) {
        this.builder = this.builder.rhs(rhsArg);
        return this;
    }

    public IfIntEqualBuilder action(@StdlibBuilderParam(pos = 2) final InsnList trueAction) {
        this.builder = this.builder.action(trueAction);
        return this;
    }

    @Override
    public InsnList build() {
        return this.builder.build();
    }
}
