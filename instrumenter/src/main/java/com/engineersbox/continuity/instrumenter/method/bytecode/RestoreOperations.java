package com.engineersbox.continuity.instrumenter.method.bytecode;

import com.engineersbox.continuity.instrumenter.bytecode.annotation.BytecodeGenerator;
import com.engineersbox.continuity.instrumenter.method.MethodContext;
import org.objectweb.asm.tree.InsnList;

@BytecodeGenerator
public class RestoreOperations {

    public static InsnList constructRestoreBytecode(final MethodContext methodContext,
                                                    final int index) {
        return new InsnList();
    }

}
