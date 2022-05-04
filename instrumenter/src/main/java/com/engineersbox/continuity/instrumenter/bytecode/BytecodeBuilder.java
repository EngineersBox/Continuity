package com.engineersbox.continuity.instrumenter.bytecode;

import org.objectweb.asm.tree.InsnList;

public interface BytecodeBuilder {

    InsnList build();
}
