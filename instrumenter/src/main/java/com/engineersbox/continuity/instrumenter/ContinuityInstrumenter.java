package com.engineersbox.continuity.instrumenter;

import com.engineersbox.continuity.instrumenter.clazz.CoreClassNode;
import com.engineersbox.continuity.instrumenter.method.MethodContext;
import com.engineersbox.continuity.instrumenter.stack.StackReconstructor;
import com.engineersbox.continuity.instrumenter.stage.*;
import com.engineersbox.continuity.instrumenter.util.InsnUtils;
import org.apache.commons.collections4.set.ListOrderedSet;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ContinuityInstrumenter implements Instrumenter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContinuityInstrumenter.class);

    private final ListOrderedSet<InstrumentationStage> stages = ListOrderedSet.listOrderedSet(List.of(
            new MethodLocatorStage(),
            new MethodIntrospectionStage(),
            new BytecodeInjectionStage()
    ));

    @Override
    public byte[] instrument(final byte[] classByteBuffer) {
        final ClassReader classReader = new ClassReader(classByteBuffer);
        ClassNode classNode = new CoreClassNode();
        classReader.accept(classNode, 0);
        classNode = StackReconstructor.reconstructStackMapFrames(classNode);
        final InstrumentationStageContext context = new InstrumentationStageContext();

//        printMethodNodes(classNode);
        for (final InstrumentationStage stage : this.stages) {
            stage.invoke(classNode, context);
        }
        context.getMethods().forEach((final MethodNode node, final MethodContext methodContext) ->
                LOGGER.debug("{}: {}", node.signature, methodContext)
        );

        return classByteBuffer;
    }

    void printMethodNodes(final ClassNode node) {
        node.methods.stream()
                .filter((final MethodNode methodNode) -> methodNode.instructions != null)
                .forEach((final MethodNode methodNode) -> {
                    final String insns = Arrays.stream(methodNode.instructions.toArray())
                            .map(InsnUtils::insnToString)
                            .collect(Collectors.joining(""));
                    LOGGER.debug("Instructions:\n{}", insns);
                });
    }
}
