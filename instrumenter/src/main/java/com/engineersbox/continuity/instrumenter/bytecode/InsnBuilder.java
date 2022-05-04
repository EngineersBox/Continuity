package com.engineersbox.continuity.instrumenter.bytecode;

import com.engineersbox.continuity.instrumenter.bytecode.builders.*;
import com.engineersbox.continuity.instrumenter.stack.storage.VariableLUT;
import org.objectweb.asm.tree.LabelNode;

import java.util.function.Supplier;

public class InsnBuilder {

    private InsnBuilder() {}

    public static CombineBuilder combine(final Object... insns) {
        return new CombineBuilder().insns(insns);
    }

    public static IfIntEqualBuilder IfIntEqual() {
        return new IfIntEqualBuilder();
    }

    public static SwitchTableBuilder switchTable() {
        return new SwitchTableBuilder();
    }

    public static LoadVarBuilder loadVar(final VariableLUT.Variable variable) {
        return new LoadVarBuilder().var(variable);
    }

    public static SaveVarBuilder saveVar(final VariableLUT.Variable variable) {
        return new SaveVarBuilder().var(variable);
    }

    public static CallBuilder call() {
        return new CallBuilder();
    }

    public static ExceptionBuilder exception() {
        return new ExceptionBuilder();
    }

    public static JumpBuilder jumpTo() {
        return new JumpBuilder();
    }

    public static DebugMarkerBuilder debugMarker() {
        return new DebugMarkerBuilder();
    }

    public static LabelBuilder label(final LabelNode label) {
        return new LabelBuilder().label(label);
    }

    public static CombineIfBuilder combineIf(final boolean condition, final Supplier<Object[]> supplier) {
        return new CombineIfBuilder().combineIf(condition, supplier);
    }
}
