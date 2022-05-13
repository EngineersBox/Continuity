package com.engineersbox.continuity.instrumenter.method;

import com.engineersbox.continuity.instrumenter.method.bytecode.InitialCutpoint;
import com.engineersbox.continuity.instrumenter.method.bytecode.SaveOperations;
import com.engineersbox.continuity.instrumenter.stack.point.ContinuationPoint;
import com.engineersbox.continuity.instrumenter.util.InsnUtils;
import org.apache.commons.lang3.Validate;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

public class MethodInstrumenter {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodInstrumenter.class);

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
        methodContext.continuationPoints()
                .stream()
                .map(ContinuationPoint::getInvokeInstruction)
                .filter(Predicate.not(methodNode.instructions::contains))
                .findAny()
                .ifPresent((final MethodInsnNode node) -> { throw new IllegalStateException("Invocation instruction does not belong to method"); });
        methodNode.instructions.insert(InitialCutpoint.constructInitialInlineCutpoint(methodContext));
        final List<? extends ContinuationPoint> continuationPoints = methodContext.continuationPoints();
        for (int i = 0; i < continuationPoints.size(); i++) {
            final AbstractInsnNode nodeToReplace = continuationPoints.get(i).getInvokeInstruction();
            methodNode.instructions.insertBefore(nodeToReplace, SaveOperations.constructSaveBytecode(methodContext, i));
            methodNode.instructions.remove(nodeToReplace);
        }
        final String methodFqcn = String.format(
                "%s-%s",
                classNode.name.replace('/', '-'),
                methodNode.name
        );
        LOGGER.info("Finished instrumenting {}",
                methodFqcn
        );
        writeBytecodeToFile(
                "./bytecode/" + methodFqcn  + ".bytecode",
                methodNode
        );
//        LOGGER.trace("Method Bytecode: {}\n{}", methodNode.name, InsnUtils.insnsToString(methodNode.instructions));
    }

    private void writeBytecodeToFile(final String filename,
                                     final MethodNode methodNode) {
        try (final BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(methodNode.name + "\n" + InsnUtils.insnsToString(methodNode.instructions));
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }
}
