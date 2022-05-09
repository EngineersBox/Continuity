package com.engineersbox.continuity.core.annotation;

import com.engineersbox.continuity.core.annotation.exception.UnknownBytecodeInvokeTargetException;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Retention(RetentionPolicy.RUNTIME)
@Target({
        ElementType.METHOD,
        ElementType.CONSTRUCTOR
})
public @interface BytecodeInternal {
    String key() default "";

    class Accessor {

        private Accessor() {}

        private static final String ACCESSOR_SEARCH_PACKAGE = "com.engineersbox.continuity.core";
        private static final Reflections BYTECODE_INTERNAL_REFLECTIONS = new Reflections(
                ACCESSOR_SEARCH_PACKAGE,
                Scanners.ConstructorsAnnotated,
                Scanners.MethodsAnnotated
        );

        @SuppressWarnings({"rawtypes","java:S3740"})
        private static final Map<String, Constructor> CAPTURED_CONSTRUCTORS = convertCallablesToMap(
                BYTECODE_INTERNAL_REFLECTIONS.getConstructorsAnnotatedWith(BytecodeInternal.class),
                Accessor::getConstructorKey
        );
        private static final Map<String, Method> CAPTURED_METHODS = convertCallablesToMap(
                BYTECODE_INTERNAL_REFLECTIONS.getMethodsAnnotatedWith(BytecodeInternal.class),
                Accessor::getMethodKey
        );

        private static <T> Map<String, T> convertCallablesToMap(final Set<T> callables,
                                                                final Function<T, String> keyMapper) {
            return callables.stream().collect(Collectors.toMap(
                    keyMapper,
                    Function.identity()
            ));
        }

        @SuppressWarnings({"rawtypes","java:S3740"})
        private static String getConstructorKey(final Constructor constructor) {
            final String annotationKey = ((Constructor<?>) constructor).getAnnotation(BytecodeInternal.class).key();
            return !annotationKey.equals("") ? annotationKey : String.format(
                    "%s.init",
                    constructor.getDeclaringClass().getSimpleName()
            );
        }

        private static String getMethodKey(final Method method) {
            final String annotationKey = method.getAnnotation(BytecodeInternal.class).key();
            return !annotationKey.equals("") ? annotationKey : String.format(
                    "%s.%s",
                    method.getDeclaringClass().getSimpleName(),
                    method.getName()
            );
        }

        public static Constructor<?> getConstructor(final String key) {
            if (key == null) {
                throw new IllegalArgumentException("Key cannot be null");
            }
            final Constructor<?> result = CAPTURED_CONSTRUCTORS.get(key);
            if (result == null) {
                throw new UnknownBytecodeInvokeTargetException(String.format(
                        "No such constructor registered for key: %s",
                        key
                ));
            }
            return result;
        }
        public static Method getMethod(final String key) {
            if (key == null) {
                throw new IllegalArgumentException("Key cannot be null");
            }
            final Method result = CAPTURED_METHODS.get(key);
            if (result == null) {
                throw new UnknownBytecodeInvokeTargetException(String.format(
                        "No such method registered for key: %s",
                        key
                ));
            }
            return result;
        }
    }
}
