package com.engineersbox.continuity.instrumenter.stage;

import com.engineersbox.continuity.core.continuation.Continuation;
import com.engineersbox.continuity.instrumenter.clazz.bytecode.ContinuityField;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MethodLocatorStage implements InstrumentationStage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodLocatorStage.class);

    @Override
    public void invoke(final ClassNode classNode,
                       final InstrumentationStageContext context) {
        if ((classNode.access & Opcodes.ACC_INTERFACE) == Opcodes.ACC_INTERFACE || isClassAlreadyInstrumented(classNode)) {
            return;
        }
        final List<MethodNode> instrumentableMethods = findInstrumentableMethods(
                classNode.methods,
                Type.getType(Continuation.class)
        );
        instrumentableMethods.forEach((final MethodNode methodNode) -> context.putMethod(methodNode, null));
    }

    private List<MethodNode> findInstrumentableMethods(final List<MethodNode> methodNodes,
                                                       final Type classType) {
        if (classType.getSort() == Type.METHOD) {
            throw new IllegalArgumentException("Unsupported method argument type METHOD");
        } else if (classType.getSort() == Type.VOID) {
            throw new IllegalArgumentException("Unsupported method argument type VOID");
        }
        return methodNodes.stream()
                .filter((final MethodNode methodNode) -> {
                    final Type methodDescription = Type.getType(methodNode.desc);
                    final List<Type> methodArguments = Arrays.asList(methodDescription.getArgumentTypes());
                    return methodArguments.contains(classType);
                }).toList();
    }

    private boolean isClassAlreadyInstrumented(final ClassNode classNode) {
        final ContinuityField continuityField = new ContinuityField();
        return classNode.fields.stream().anyMatch(continuityField::equals);
    }
}
