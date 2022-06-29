package com.engineersbox.continuity.instrumenter.lang.transform.stdlib;

import com.engineersbox.continuity.instrumenter.bytecode.BytecodeBuilder;
import com.engineersbox.continuity.instrumenter.lang.transform.stdlib.annotation.StdlibBuilder;
import com.engineersbox.continuity.instrumenter.lang.transform.stdlib.annotation.StdlibBuilderParam;
import org.apache.commons.collections4.SetUtils;
import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.objectweb.asm.tree.InsnList;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BuilderResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(BuilderResolver.class);

    private static final String RESOLVER_SEARCH_PACKAGE = "com.engineersbox.continuity.instrumenter.bytecode";
    private static final Reflections STDLIB_REFLECTIONS = new Reflections(
            RESOLVER_SEARCH_PACKAGE,
            Scanners.TypesAnnotated,
            Scanners.MethodsParameter,
            Scanners.TypesAnnotated
    );

    private final Map<String, Pair<Class<? extends BytecodeBuilder>, List<StdlibBuilderMethod>>> builders;

    public BuilderResolver() {
        this.builders = new HashMap<>();
        mapBuilders();
    }

    @SuppressWarnings({"unchecked"})
    private Set<Class<? extends BytecodeBuilder>> resolveBuilders() {
        final Set<Class<? extends BytecodeBuilder>> extendsClasses = STDLIB_REFLECTIONS.getSubTypesOf(BytecodeBuilder.class);
        final Set<Class<?>> annotatedClasses = STDLIB_REFLECTIONS.getTypesAnnotatedWith(StdlibBuilder.class);
        final Set<Class<?>> intersection = SetUtils.intersection(extendsClasses, annotatedClasses).toSet();
        logResolvedClasses(
                extendsClasses,
                annotatedClasses,
                intersection
        );
        return (Set<Class<? extends BytecodeBuilder>>) intersection;
    }

    private void logResolvedClasses(final Set<Class<? extends BytecodeBuilder>> extendsClasses,
                                    final Set<Class<?>> annotatedClasses,
                                    final Set<Class<?>> intersection) {
        final Set<Class<?>> annotationOnly = SetUtils.difference(annotatedClasses, intersection);
        final Set<Class<?>> extendsOnly = SetUtils.intersection(extendsClasses, intersection);
        if (!annotationOnly.isEmpty()) {
            LOGGER.warn(
                    "Found {} stdlib builder classes missing extends: \n\t - {}",
                    annotationOnly.size(),
                    annotationOnly.stream()
                            .map(Class::getCanonicalName)
                            .collect(Collectors.joining(",\n\t - "))
            );
        }
        if (!extendsOnly.isEmpty()) {
            LOGGER.warn(
                    "Found {} stdlib builder classes missing annotations: \n\t - {}",
                    extendsOnly.size(),
                    extendsOnly.stream()
                            .map(Class::getCanonicalName)
                            .collect(Collectors.joining(",\n\t - "))
            );
        }
        if (!intersection.isEmpty()) {
            LOGGER.info(
                    "Found {} valid stdlib builder classes: \n\t - {}",
                    intersection.size(),
                    intersection.stream()
                            .map(Class::getCanonicalName)
                            .collect(Collectors.joining(",\n\t - "))
            );
        }
    }

    private boolean annotationsContainStdlibBuilderParam(final Annotation[] annotations) {
        return Arrays.stream(annotations)
                .anyMatch((final Annotation annotation) -> annotation instanceof StdlibBuilderParam);
    }

    private boolean methodParameterAnnotationsAreWellFormed(final Method method) {
        if (method.getParameterAnnotations().length == 0) {
            return false;
        }
        return Arrays.stream(method.getParameterAnnotations())
                .allMatch(this::annotationsContainStdlibBuilderParam);
    }

    private Set<Method> resolveMethods(final Class<? extends BytecodeBuilder> cls) {
        return Arrays.stream(cls.getDeclaredMethods())
                .filter(this::methodParameterAnnotationsAreWellFormed)
                .collect(Collectors.toSet());

    }

    private Optional<StdlibBuilderParam> findParamAnnotation(final Annotation[] annotations) {
        return Arrays.stream(annotations)
                .filter((final Annotation annotation) -> annotation instanceof StdlibBuilderParam)
                .map((final Annotation annotation) -> (StdlibBuilderParam) annotation)
                .findFirst();
    }

    private void bindMethod(final Class<? extends BytecodeBuilder> cls,
                            final Method method,
                            final int index,
                            final StdlibBuilderMethod stdlibBuilderMethod) {
        final Optional<StdlibBuilderParam> annotation = findParamAnnotation(method.getParameterAnnotations()[index]);
        if (annotation.isEmpty()) {
            throw new BuilderResolverException(String.format(
                    "[%s$%s] Missing @StdlibBuilderParam annotation on parameter index %d",
                    cls.getCanonicalName(),
                    method.getName(),
                    index
            ));
        }
        stdlibBuilderMethod.bind(
                annotation.get(),
                method.getParameterTypes()[index]
        );
    }

    private StdlibBuilderMethod constructStdlibBuilderMethod(final Class<? extends BytecodeBuilder> cls,
                                                             final Method method) {
        final StdlibBuilderMethod stdlibBuilderMethod = new StdlibBuilderMethod(method);
        final Annotation[][] annotations = method.getParameterAnnotations();
        final Class<?>[] types = method.getParameterTypes();
        if (annotations.length != types.length) {
            throw new BuilderResolverException(String.format(
                    "[%s$%s] Method types and annotations did not match: %d != %d",
                    cls.getCanonicalName(),
                    method.getName(),
                    annotations.length,
                    types.length
            ));
        }
        IntStream.range(0, annotations.length).forEach((final int i) -> bindMethod(
                cls,
                method,
                i,
                stdlibBuilderMethod
        ));
        return stdlibBuilderMethod;
    }

    private void mapBuilders() {
        for (final Class<? extends BytecodeBuilder> cls : resolveBuilders()) {
            final List<StdlibBuilderMethod> methods = resolveMethods(cls).stream()
                    .map((final Method method) -> constructStdlibBuilderMethod(cls, method))
                    .toList();
            final StdlibBuilder builderAnnotation = cls.getAnnotation(StdlibBuilder.class);
            if (builderAnnotation == null) {
                throw new BuilderResolverException(String.format(
                        "Expected @StdlibBuilder annotation on class \"%s\"",
                        cls.getCanonicalName()
                ));
            }
            this.builders.put(
                    builderAnnotation.methodName(),
                    Pair.of(cls, methods)
            );
        }
    }

    private <T extends BytecodeBuilder> T instantiateBuilder(final Class<? extends T> builderClass) {
        try {
            return ConstructorUtils.invokeExactConstructor(builderClass);
        } catch (final InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
            throw new BuilderResolverException(e);
        }
    }

    public InsnList invokeStdlibMethod(final String methodName,
                                       final List<Object> parameters) {
        final Pair<Class<? extends BytecodeBuilder>, List<StdlibBuilderMethod>> pair = this.builders.get(methodName);
        final List<StdlibBuilderMethod> methods = pair.getRight();
        if (methods == null || methods.isEmpty()) {
            throw new BuilderResolverException(String.format(
                    "No such method \"%s\" in std",
                    methodName
            ));
        }
        BytecodeBuilder builder = instantiateBuilder(pair.getLeft());
        for (final StdlibBuilderMethod method : methods) {
            builder = method.apply(builder, parameters);
        }
        return builder.build();
    }
}
