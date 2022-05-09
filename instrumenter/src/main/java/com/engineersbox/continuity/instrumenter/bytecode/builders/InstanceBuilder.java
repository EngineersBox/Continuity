package com.engineersbox.continuity.instrumenter.bytecode.builders;

import com.engineersbox.continuity.instrumenter.bytecode.BytecodeBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.InsnBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.ObjectConstants;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.TypeInsnNode;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Objects;

public class InstanceBuilder implements BytecodeBuilder {

    private Constructor<?> constructor;
    private InsnList[] args;

    public InstanceBuilder() {}

    public InstanceBuilder constructor(final Constructor<?> constructor) {
        if (constructor == null) {
            throw new IllegalArgumentException("Constructor cannot be null");
        }
        this.constructor = constructor;
        return this;
    }

    public InstanceBuilder args(final InsnList ...args) {
        if (args == null || Arrays.stream(args).anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("Arguments cannot be null");
        } else if (args.length != this.constructor.getParameterCount()) {
            throw new IllegalArgumentException(String.format(
                    "Supplied arguments does not match expected arguments: %d != %s",
                    this.constructor.getParameterCount(),
                    args.length
            ));
        }
        this.args = args;
        return this;
    }

    @Override
    public InsnList build() {
        final Type clsType = Type.getType(constructor.getDeclaringClass());
        final Type methodType = Type.getType(constructor);
        return InsnBuilder.combine(
                new TypeInsnNode(Opcodes.NEW, clsType.getInternalName()),
                new InsnNode(Opcodes.DUP),
                this.args,
                new MethodInsnNode(
                        Opcodes.INVOKESPECIAL,
                        clsType.getInternalName(),
                        ObjectConstants.CONSTRUCTOR_METHOD_NAME,
                        methodType.getDescriptor(),
                        false
                )
        ).build();
    }
}
