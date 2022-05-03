package com.engineersbox.continuity.instrumenter.bytecode.builders;

import com.engineersbox.continuity.instrumenter.bytecode.BaseBytecodeBuilder;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodInsnNode;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Objects;

public class CallBuilder implements BaseBytecodeBuilder {

    private Method method;
    private InsnList[] args;

    public CallBuilder() {}

    public CallBuilder method(final Method method) {
        if (method == null) {
            throw new IllegalArgumentException("Method cannot be null");
        }
        this.method = method;
        return this;
    }

    public CallBuilder args(final InsnList ...args) {
        if (args == null || Arrays.stream(args).anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        this.args = args;
        return this;
    }

    private void validateMethodParameters(final int expected, final int given) {
        if (expected != given) {
            throw new IllegalStateException(String.format(
                    "Method parameter count did not match supplied arguments: %d != %d",
                    expected,
                    given
            ));
        }
    }

    @Override
    public InsnList build() {
        final InsnList ret = new InsnList();
        Arrays.stream(args).forEach(ret::add);
        final Type clsType = Type.getType(method.getDeclaringClass());
        final Type methodType = Type.getType(method);
        if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC) {
            validateMethodParameters(method.getParameterCount(), this.args.length);
            ret.add(new MethodInsnNode(Opcodes.INVOKESTATIC,
                    clsType.getInternalName(),
                    method.getName(),
                    methodType.getDescriptor(),
                    false
            ));
        } else if (method.getDeclaringClass().isInterface()) {
            validateMethodParameters(method.getParameterCount() + 1, this.args.length);
            ret.add(new MethodInsnNode(
                    Opcodes.INVOKEINTERFACE,
                    clsType.getInternalName(),
                    method.getName(),
                    methodType.getDescriptor(),
                    true
            ));
        } else {
            validateMethodParameters(method.getParameterCount() + 1, this.args.length);
            ret.add(new MethodInsnNode(
                    Opcodes.INVOKEVIRTUAL,
                    clsType.getInternalName(),
                    method.getName(),
                    methodType.getDescriptor(),
                    false
            ));
        }
        return ret;
    }
}
