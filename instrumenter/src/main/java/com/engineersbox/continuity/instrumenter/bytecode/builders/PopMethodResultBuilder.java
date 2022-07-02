package com.engineersbox.continuity.instrumenter.bytecode.builders;

import com.engineersbox.continuity.instrumenter.bytecode.BytecodeBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.InsnBuilder;
import com.engineersbox.continuity.instrumenter.lang.transform.stdlib.annotation.StdlibBuilder;
import com.engineersbox.continuity.instrumenter.lang.transform.stdlib.annotation.StdlibBuilderParam;
import com.engineersbox.continuity.instrumenter.util.MethodInsnUtils;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;

@StdlibBuilder(methodName = "popMethodResult")
public class PopMethodResultBuilder implements BytecodeBuilder {

    private AbstractInsnNode insnNode;

    public PopMethodResultBuilder() {}

    public PopMethodResultBuilder methodNode(@StdlibBuilderParam(pos = 0) final AbstractInsnNode insnNode) {
        if (insnNode == null) {
            throw new IllegalArgumentException("Method node cannot be null");
        }
        this.insnNode = insnNode;
        return this;
    }

    @Override
    public InsnList build() {
        final Type returnType = MethodInsnUtils.getReturnTypeOfInvocation(this.insnNode);
        return switch (returnType.getSort()) {
            case Type.METHOD -> throw new IllegalStateException("Cannot pop method result for method type");
            case Type.LONG, Type.DOUBLE -> InsnBuilder.combine(new InsnNode(Opcodes.POP2)).build();
            case Type.VOID -> new InsnList();
            default -> InsnBuilder.combine(new InsnNode(Opcodes.POP)).build();
        };
    }
}
