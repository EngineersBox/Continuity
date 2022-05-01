package com.engineersbox.continuity.instrumenter.method;

import com.engineersbox.continuity.instrumenter.bytecode.SaveStateGenerator;
import com.engineersbox.continuity.instrumenter.stack.ContinuationPoint;
import org.objectweb.asm.tree.*;

import java.util.List;

public class MethodInstrumenter {

    public void instrument(final ClassNode classNode,
                           final MethodNode methodNode,
                           final MethodContext<?> context) {
        if (!classNode.methods.contains(methodNode)) {
            throw new IllegalArgumentException("Method does not belong to current class");
        }
        context.continuationPoints().stream()
                .map(ContinuationPoint::getInvokeInstruction)
                .forEach((final MethodInsnNode insn) -> {
                    if (!methodNode.instructions.contains(insn)) {
                        throw new IllegalStateException(String.format(
                                "Instruction %s%s is not part of method %s%s",
                                insn.name, insn.desc,
                                methodNode.name, methodNode.desc
                        ));
                    }
                });

        final List<? extends ContinuationPoint> continuationPoints = context.continuationPoints();
        for (int i = 0; i < continuationPoints.size(); i++) {
            final AbstractInsnNode nodeToReplace = continuationPoints.get(i).getInvokeInstruction();
            methodNode.instructions.insertBefore(
                    nodeToReplace,
                    SaveStateGenerator.createSaveStateInsns(context, i)
            );
            methodNode.instructions.remove(nodeToReplace);
        }
    }

}
