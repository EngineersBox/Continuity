package com.engineersbox.continuity.instrumenter.bytecode.builders;

import com.engineersbox.continuity.instrumenter.bytecode.BytecodeBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.InsnListBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.ObjectConstants;
import com.engineersbox.continuity.instrumenter.bytecode.DebugMarker;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;

public class DebugMarkerBuilder implements BytecodeBuilder {

    private static final String DEBUG_LOG_PREFIX = "[BYTECODE DEBUG] ";

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

    public DebugMarkerBuilder message(final String messageTemplate, final Object ...values) {
        this.message = DEBUG_LOG_PREFIX + String.format(messageTemplate, values);
        return this;
    }

    @Override
    public InsnList build() {
        final InsnListBuilder list = new InsnListBuilder();
        switch (this.marker) {
            case STDOUT -> list.addAll(
                    new FieldInsnNode(
                            Opcodes.GETSTATIC,
                            ObjectConstants.SYSTEM_PATH_FQN,
                            ObjectConstants.STATIC_FIELD_OUT_NAME,
                            ObjectConstants.PRINT_STREAM_DESCRIPTOR
                    ),
                    new LdcInsnNode(this.message),
                    new MethodInsnNode(
                            Opcodes.INVOKEVIRTUAL,
                            ObjectConstants.PRINT_STREAM_PATH_FQN,
                            ObjectConstants.PRINTLN_METHOD_NAME,
                            ObjectConstants.STRING_PARAMETER_METHOD_SIGNATURE,
                            false
                    )
            );
        }
        return list.build();
    }
}
