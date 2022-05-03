package com.engineersbox.continuity.instrumenter.clazz;

import com.engineersbox.continuity.instrumenter.clazz.bytecode.ContinuityField;
import org.objectweb.asm.tree.ClassNode;

public class ClassInstrumenter {

    public void instrument(final ClassNode classNode) {
        classNode.fields.add(ContinuityField.construct());
    }

}
