package com.engineersbox.continuity.instrumenter.stage;

import com.engineersbox.continuity.core.continuation.Continuation;
import com.engineersbox.continuity.logger.LogFormatter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MethodLocatorStage implements InstrumentationStage {

    private static final Logger LOGGER = LogFormatter.getLogger(InstrumentationStage.class, Level.ALL);

    @Override
    public void invoke(final ClassNode classNode,
                       final InstrumentationContext context) {
        if ((classNode.access & Opcodes.ACC_INTERFACE) == Opcodes.ACC_INTERFACE) {
            return;
        }
        final List<MethodNode> instrumentableMethods = findInstrumentableMethods(
                classNode.methods,
                Type.getType(Continuation.class),
                classNode
        );
        instrumentableMethods.forEach((final MethodNode methodNode) -> context.putMethod(methodNode, null));
    }

    private List<MethodNode> findInstrumentableMethods(final List<MethodNode> methodNodes,
                                                       final Type classType,
                                                       final ClassNode classNode) {
        if (classType.getSort() == Type.METHOD) {
            // TODO: Implement exception
            throw new RuntimeException("Unsupported method argument type METHOD");
        } else if ( classType.getSort() == Type.VOID) {
            // TODO: Implement exception
            throw new RuntimeException("Unsupported method argument type VOID");
        }
        return methodNodes.stream()
                .map((final MethodNode methodNode) -> {
                    final Type methodDescription = Type.getType(methodNode.desc);
                    final Type[] methodArguments = methodDescription.getArgumentTypes();
                    if (Arrays.asList(methodArguments).contains(classType)) {
                        LOGGER.info(String.format(
                                "METHOD NODE: %s$%s%s",
                                classNode.name,
                                methodNode.name,
                                methodNode.desc
                        ));
                        return methodNode;
                    }
                    return null;
                }).filter(Objects::nonNull).toList();
    }
}
