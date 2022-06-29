package com.engineersbox.continuity.instrumenter.bytecode.builders;

import com.engineersbox.continuity.instrumenter.bytecode.BytecodeBuilder;
import com.engineersbox.continuity.instrumenter.lang.transform.stdlib.annotation.StdlibBuilder;
import com.engineersbox.continuity.instrumenter.lang.transform.stdlib.annotation.StdlibBuilderParam;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodInsnNode;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;

@StdlibBuilder(methodName = "call")
public class CallBuilder implements BytecodeBuilder {

    private Method method;
    private InsnList[] args;

    public CallBuilder() {}

    public CallBuilder method(@StdlibBuilderParam(pos = 0) final Method method) {
        if (method == null) {
            throw new IllegalArgumentException("Method cannot be null");
        }
        this.method = method;
        return this;
    }

    public CallBuilder args(@StdlibBuilderParam(pos = 1) final InsnList ...args) {
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
        final BiFunction<Integer, Boolean, MethodInsnNode> createMethodNode = (final Integer opcode, final Boolean isInterface) -> new MethodInsnNode(
                opcode,
                Type.getType(method.getDeclaringClass()).getInternalName(),
                method.getName(),
                Type.getType(method).getDescriptor(),
            isInterface
        );
        if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC) {
            validateMethodParameters(method.getParameterCount(), this.args.length);
            ret.add(createMethodNode.apply(Opcodes.INVOKESTATIC, false));
        } else if (method.getDeclaringClass().isInterface()) {
            validateMethodParameters(method.getParameterCount() + 1, this.args.length);
            ret.add(createMethodNode.apply(Opcodes.INVOKEINTERFACE, true));
        } else {
            validateMethodParameters(method.getParameterCount() + 1, this.args.length);
            ret.add(createMethodNode.apply(Opcodes.INVOKEVIRTUAL, false));
        }
        return ret;
    }
}
