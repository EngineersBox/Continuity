package com.engineersbox.continuity.instrumenter.bytecode.builders;

import com.engineersbox.continuity.instrumenter.bytecode.BytecodeBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.annotation.BytecodeGenerator;
import org.objectweb.asm.tree.InsnList;

@BytecodeGenerator
public class IfIntEqualBuilder implements BytecodeBuilder {
    @Override
    public InsnList build() {
        return null;
    }
}
