package com.engineersbox.continuity.instrumenter;

import com.engineersbox.continuity.instrumenter.clazz.CoreClassNode;
import com.engineersbox.continuity.instrumenter.clazz.CoreClassWriter;
import com.engineersbox.continuity.instrumenter.stack.StackReconstructor;
import com.engineersbox.continuity.instrumenter.stage.InstrumentationContext;
import com.engineersbox.continuity.instrumenter.stage.InstrumentationStage;
import com.engineersbox.continuity.instrumenter.stage.MethodIntrospectionStage;
import com.engineersbox.continuity.instrumenter.stage.MethodLocatorStage;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;

import java.util.List;

public class Instrumenter {

    public Instrumenter() {}

    private static final List<InstrumentationStage> STAGES = List.of(
            new MethodLocatorStage(),
            new MethodIntrospectionStage()
    );

    public byte[] instrument(final byte[] raw) {
        final ClassReader classReader = new ClassReader(raw);
        ClassNode classNode = new CoreClassNode();
        classReader.accept(classNode, 0);

        classNode = StackReconstructor.reconstructStackMapFrames(classNode);
        final InstrumentationContext context = new InstrumentationContext();

        for (final InstrumentationStage stage : STAGES) {
            stage.invoke(classNode, context);
        }

        /* TODO:
         * 1. Do instrumentation in stages
         * 2. Evaluate instrumentation results
         *
         * Instrumentation stages:
         *  1. Find relevant methods calling Continuation#suspend()
         *  2. Filter methods by usage and dependent call structure with parent context
         *  3. Serialize existing coroutine structure and store as a file for restore and persistence
         *  4. Perform instrumentation:
         *    a. Create restore marker and early return before Continuation#suspend() call
         *    b. Create continuation marker and goto call to jump Continuation#suspend() call and continue
         *    c. Store method state
         *  5. Add versioning fields and convert class to serializable format
         */

        final ClassWriter classWriter = new CoreClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
        classNode.accept(classWriter);

        return classWriter.toByteArray();
    }
}
