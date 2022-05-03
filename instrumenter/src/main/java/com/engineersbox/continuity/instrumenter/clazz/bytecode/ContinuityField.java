package com.engineersbox.continuity.instrumenter.clazz.bytecode;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.FieldNode;

import java.util.Objects;

public class ContinuityField {

    public static final int FIELD_ACCESS_MODIFIERS = Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC | Opcodes.ACC_FINAL;
    public static final String FIELD_NAME = "__CONTINUITY_INSTRUMENTATION_MARKER";
    public static final String FIELD_TYPE_DESCRIPTOR = Type.LONG_TYPE.getDescriptor();
    public static final long FIELD_VALUE = 0;

    public static FieldNode construct() {
        return new FieldNode(
                FIELD_ACCESS_MODIFIERS,
                FIELD_NAME,
                FIELD_TYPE_DESCRIPTOR,
                null,
                FIELD_VALUE
        );
    }
}
