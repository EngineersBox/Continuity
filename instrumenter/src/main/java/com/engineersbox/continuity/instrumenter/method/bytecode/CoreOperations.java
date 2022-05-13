package com.engineersbox.continuity.instrumenter.method.bytecode;

import com.engineersbox.continuity.instrumenter.method.bytecode.annotation.ClassInstancedInvokable;
import com.engineersbox.continuity.instrumenter.stack.point.ContinuationPoint;
import org.objectweb.asm.tree.InsnList;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract sealed class CoreOperations permits RestoreOperations, SaveOperations {

    private static final Logger LOGGER = LoggerFactory.getLogger(CoreOperations.class);
    private static final String REFLECTIONS_PACKAGE_TO_SCAN = "com.engineersbox.continuity.instrumenter.method.bytecode";
    private static final Reflections REFLECTIONS = new Reflections(REFLECTIONS_PACKAGE_TO_SCAN, Scanners.MethodsAnnotated);

    protected static InsnList invokeInstanceDeterminedOperation(final Class<? extends CoreOperations> clazz,
                                                                final Class<? extends ContinuationPoint> point,
                                                                final Object ...args) {
        final Method invokableMethod = REFLECTIONS.getMethodsAnnotatedWith(ClassInstancedInvokable.class)
                .stream()
                .filter((final Method method) -> method.getDeclaringClass().isAssignableFrom(clazz))
                .filter((final Method method) -> {
                    final ClassInstancedInvokable annotation = method.getAnnotation(ClassInstancedInvokable.class);
                    return annotation.value().isAssignableFrom(point);
                }).findFirst()
                .orElseThrow(() -> {
                    throw new IllegalStateException(String.format(
                            "No matching methods for point type: %s",
                            point.getName()
                    ));
                });
        LOGGER.debug(
                "Point matched to {} for method {}",
                invokableMethod.getAnnotation(ClassInstancedInvokable.class).value().getSimpleName(),
                invokableMethod.getName()
        );
        try {
            return (InsnList) invokableMethod.invoke(null, args);
        } catch (final InvocationTargetException | IllegalAccessException e) {
            throw new IllegalStateException("Handler for continuation point class was not invokable", e);
        }
    }

}
