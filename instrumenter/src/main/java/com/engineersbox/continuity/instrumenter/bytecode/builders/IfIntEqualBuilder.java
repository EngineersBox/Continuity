package com.engineersbox.continuity.instrumenter.bytecode.builders;

import com.engineersbox.continuity.instrumenter.bytecode.BaseBytecodeBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.annotation.BytecodeGenerator;
import org.objectweb.asm.tree.InsnList;

@BytecodeGenerator
public class IfIntEqualBuilder implements BaseBytecodeBuilder {
    @Override
    public InsnList build() {
        return null;
    }
}
