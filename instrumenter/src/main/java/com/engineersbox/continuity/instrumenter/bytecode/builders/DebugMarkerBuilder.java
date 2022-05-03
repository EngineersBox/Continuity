package com.engineersbox.continuity.instrumenter.bytecode.builders;

import com.engineersbox.continuity.instrumenter.bytecode.BaseBytecodeBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.InsnListBuilder;
import com.engineersbox.continuity.instrumenter.stage.DebugMarker;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;

public class DebugMarkerBuilder implements BaseBytecodeBuilder {

    private static final String SYSTEM_PATH_FQN = java.lang.System.class.getCanonicalName().replace('.', '/');
    private static final String STATIC_FIELD_OUT_NAME = "out";
    private static final String PRINT_STREAM_DESCRIPTOR = java.io.PrintStream.class.descriptorString();
    private static final String PRINT_STREAM_PATH_FQN = java.io.PrintStream.class.getCanonicalName().replace('.', '/');
    private static final String PRINTLN_METHOD_NAME = "println";
    private static final String STRING_PARAMETER_METHOD_SIGNATURE = "(Ljava/lang/String;)V";

    private DebugMarker marker;
    private String message;

    public DebugMarkerBuilder() {}

    public DebugMarkerBuilder marker(final DebugMarker marker) {
        if (marker == null) {
            throw new IllegalArgumentException("Marker type cannot be null");
        }
        this.marker = marker;
        return this;
    }

    public DebugMarkerBuilder message(final String message) {
        this.message = message;
        return this;
    }

    @Override
    public InsnList build() {
        final InsnListBuilder list = new InsnListBuilder();
        switch (this.marker) {
            case STDOUT -> list.addAll(
                    new FieldInsnNode(
                            Opcodes.GETSTATIC,
                            SYSTEM_PATH_FQN,
                            STATIC_FIELD_OUT_NAME,
                            PRINT_STREAM_DESCRIPTOR
                    ),
                    new LdcInsnNode(this.message),
                    new MethodInsnNode(
                            Opcodes.INVOKEVIRTUAL,
                            PRINT_STREAM_PATH_FQN,
                            PRINTLN_METHOD_NAME,
                            STRING_PARAMETER_METHOD_SIGNATURE,
                            false
                    )
            );
        }
        return list.build();
    }
}
