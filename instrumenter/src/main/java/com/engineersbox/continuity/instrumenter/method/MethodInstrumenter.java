package com.engineersbox.continuity.instrumenter.method;

import com.engineersbox.continuity.instrumenter.method.bytecode.InitialCutpoint;
import com.engineersbox.continuity.instrumenter.method.bytecode.SaveOperations;
import com.engineersbox.continuity.instrumenter.stack.point.ContinuationPoint;
import com.engineersbox.continuity.instrumenter.util.InsnUtils;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
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
        methodNode.instructions.insert(InitialCutpoint.constructInitialInlineCutpoint(methodContext));
        InsnUtils.printInsns(methodNode.instructions);
//        List<? extends ContinuationPoint> continuationPoints = methodContext.continuationPoints();
//        for (int i = 0; i < continuationPoints.size(); i++) {
//            final AbstractInsnNode nodeToReplace = continuationPoints.get(i).getInvokeInstruction();
//            methodNode.instructions.insertBefore(nodeToReplace, SaveOperations.constructSaveBytecode(methodContext, i));
//            methodNode.instructions.remove(nodeToReplace);
//        }
    }
}
