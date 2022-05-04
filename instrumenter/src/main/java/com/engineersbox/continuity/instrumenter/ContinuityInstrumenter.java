package com.engineersbox.continuity.instrumenter;

import com.engineersbox.continuity.instrumenter.clazz.CoreClassNode;
import com.engineersbox.continuity.instrumenter.method.MethodContext;
import com.engineersbox.continuity.instrumenter.stack.StackReconstructor;
import com.engineersbox.continuity.instrumenter.stage.*;
import com.engineersbox.continuity.instrumenter.stage.annotation.StageProvider;
import com.engineersbox.continuity.instrumenter.util.InsnUtils;
import org.apache.commons.collections4.set.ListOrderedSet;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ContinuityInstrumenter implements Instrumenter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContinuityInstrumenter.class);
    private static final String STAGES_SEARCH_PACKAGE = "com.engineersbox.continuity.instrumenter";
    private static final Reflections STAGES_REFLECTIONS = new Reflections(STAGES_SEARCH_PACKAGE);

    @SuppressWarnings("java:S1874")
    private ListOrderedSet<InstrumentationStage> findInstrumentationStages() {
        return ListOrderedSet.listOrderedSet(
                STAGES_REFLECTIONS.getTypesAnnotatedWith(StageProvider.class)
                        .stream()
                        .sorted((final Class<?> class1, final Class<?> class2) -> {
                            final StageProvider class1StageProvider = class1.getAnnotation(StageProvider.class);
                            final StageProvider class2StageProvider = class2.getAnnotation(StageProvider.class);
                            return Integer.compare(
                                    class1StageProvider.priority(),
                                    class2StageProvider.priority()
                            );
                        }).map((final Class<?> clazz) -> {
                            try {
                                return (InstrumentationStage) clazz.newInstance();
                            } catch (final InstantiationException | IllegalAccessException e) {
                                throw new RuntimeException("Could not create instrumentation stage", e);
                            }
                        }).toList()
        );
    }

    @Override
    public byte[] instrument(final byte[] classByteBuffer) {
        final ClassReader classReader = new ClassReader(classByteBuffer);
        ClassNode classNode = new CoreClassNode();
        classReader.accept(classNode, 0);
        classNode = StackReconstructor.reconstructStackMapFrames(classNode);
        final InstrumentationStageContext context = new InstrumentationStageContext();

        for (final InstrumentationStage stage : findInstrumentationStages()) {
            stage.invoke(classNode, context);
        }
        context.getMethods().forEach((final MethodNode node, final MethodContext methodContext) ->
                LOGGER.debug("{}: {}", node.signature, methodContext)
        );

        final ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
        classNode.accept(classWriter);
        return classWriter.toByteArray();
    }
}
