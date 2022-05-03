package com.engineersbox.continuity.instrumenter.method;

import com.engineersbox.continuity.instrumenter.stack.point.ContinuationPoint;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodNode;

import java.util.List;

public class MethodInstrumenter {

    public void instrument(final ClassNode classNode,
                           final MethodNode methodNode,
                           final MethodContext methodContext) {
        if (classNode == null) {
            throw new IllegalArgumentException("ClassNode cannot be null");
        } else if (methodNode == null) {
            throw new IllegalArgumentException("MethodNode cannot be null");
        } else if (methodContext == null) {
            throw new IllegalArgumentException("MethodContext cannot be null");
        }
        methodNode.instructions.insert(constructRestoreBytecode(methodContext));
        List<? extends ContinuationPoint> continuationPoints = methodContext.continuationPoints();
        for (int i = 0; i < continuationPoints.size(); i++) {
            ContinuationPoint cp = continuationPoints.get(i);
            AbstractInsnNode nodeToReplace = cp.getInvokeInstruction();
            InsnList insnsToReplaceWith = constructSaveBytecode(methodContext, i);
            methodNode.instructions.insertBefore(nodeToReplace, insnsToReplaceWith);
            methodNode.instructions.remove(nodeToReplace);
        }
    }

    private InsnList constructRestoreBytecode(final MethodContext methodContext) {
        return null;
    }

    private InsnList constructSaveBytecode(final MethodContext methodContext,
                                           final int index) {
        return null;
    }
}
