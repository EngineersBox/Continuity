package com.engineersbox.continuity.instrumenter.clazz;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.JSRInlinerAdapter;
import org.objectweb.asm.tree.ClassNode;

public class CoreClassNode extends ClassNode {

    public CoreClassNode() {
        super(Opcodes.ASM9);
    }

    @Override
    public MethodVisitor visitMethod(final int access,
                                     final String name,
                                     final String desc,
                                     final String signature,
                                     final String[] exceptions) {
        return new JSRInlinerAdapter(
                super.visitMethod(
                        access,
                        name,
                        desc,
                        signature,
                        exceptions
                ),
                access,
                name,
                desc,
                signature,
                exceptions
        );
    }
}
