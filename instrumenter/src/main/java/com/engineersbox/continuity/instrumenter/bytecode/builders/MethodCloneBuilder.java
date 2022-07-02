package com.engineersbox.continuity.instrumenter.bytecode.builders;

import com.engineersbox.continuity.instrumenter.bytecode.BytecodeBuilder;
import com.engineersbox.continuity.instrumenter.bytecode.InsnBuilder;
import com.engineersbox.continuity.instrumenter.lang.transform.stdlib.annotation.StdlibBuilder;
import com.engineersbox.continuity.instrumenter.lang.transform.stdlib.annotation.StdlibBuilderParam;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InvokeDynamicInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;

import java.util.HashMap;

@StdlibBuilder(methodName = "cloneMethod")
public class MethodCloneBuilder implements BytecodeBuilder {

    private AbstractInsnNode insnNode;

    public MethodCloneBuilder() {}

    public MethodCloneBuilder method(@StdlibBuilderParam(pos = 0) final AbstractInsnNode insnNode) {
        if (insnNode == null) {
            throw new IllegalArgumentException("Node cannot be null");
        } else if (!(insnNode instanceof MethodInsnNode) && !(insnNode instanceof InvokeDynamicInsnNode)) {
            throw new IllegalArgumentException("Cannot clone method invocation of type: " + insnNode.getOpcode());
        }
        this.insnNode = insnNode;
        return this;
    }

    @Override
    public InsnList build() {
        return InsnBuilder.combine(
                this.insnNode.clone(new HashMap<>())
        ).build();
    }
}
