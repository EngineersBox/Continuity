package com.engineersbox.continuity.instrumenter.bytecode;

import org.objectweb.asm.tree.InsnList;

interface BytecodeGenerator {
    InsnList generate();
}
