package com.engineersbox.continuity.instrumenter.method;

import com.engineersbox.continuity.core.continuation.Continuation;
import com.engineersbox.continuity.logger.LogFormatter;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.*;

import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.StreamSupport;

public class MethodInstrospector {

    private static final Logger LOGGER = LogFormatter.getLogger(MethodInstrospector.class, Level.ALL);

    private static final String CONSTRUCTOR_METHOD_NAME = "<init>";
    private static final Method CONTINUATION_CLASS_TYPE = MethodUtils.getAccessibleMethod(Continuation.class, "suspend");

    public MethodInstrospector() {}

    public void introspect(final ClassNode classNode,
                           final MethodNode methodNode) {
        if (methodNode.name.equals(CONSTRUCTOR_METHOD_NAME)) {
            throw new IllegalStateException("Cannot instrument constructor");
        }

        final List<AbstractInsnNode> suspendCallInsnNodes = findMethodCall(
                methodNode.instructions,
                CONTINUATION_CLASS_TYPE
        );
        suspendCallInsnNodes.forEach((final AbstractInsnNode insnNode) -> {
            final MethodInsnNode node = (MethodInsnNode) insnNode;
            LOGGER.info(String.format(
                    "INSTRUMENTING: %s$%s%s",
                    classNode.name,
                    node.name,
                    node.desc
            ));
        });
    }

    private List<AbstractInsnNode> findMethodCall(final InsnList insnList,
                                                  final Method method) {
        Type expectedMethodDesc = Type.getType(method);
        Type expectedMethodOwner = Type.getType(method.getDeclaringClass());

        return StreamSupport.stream(insnList.spliterator(), false)
                .filter(MethodInsnNode.class::isInstance)
                .filter((final AbstractInsnNode insnNode) -> {
                    final MethodInsnNode methodInsnNode = (MethodInsnNode) insnNode;
                    final Type methodDesc = Type.getType(methodInsnNode.desc);
                    final Type methodOwner = Type.getObjectType(methodInsnNode.owner);
                    return methodDesc.equals(expectedMethodDesc) && methodOwner.equals(expectedMethodOwner);
                }).toList();
    }
}
