package com.engineersbox.continuity.core.annotation;

import com.engineersbox.continuity.core.exception.UnknownBytecodeInvokeTargetException;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Retention(RetentionPolicy.RUNTIME)
@Target({
        ElementType.METHOD,
        ElementType.CONSTRUCTOR
})
public @interface BytecodeInternal {
    String key();

    class Accessor {

        private Accessor() {}

        private static final String ACCESSOR_SEARCH_PACKAGE = "com.engineersbox.continuity.core";
        private static final Reflections BYTECODE_INTERNAL_REFLECTIONS = new Reflections(
                ACCESSOR_SEARCH_PACKAGE,
                Scanners.ConstructorsAnnotated,
                Scanners.MethodsAnnotated
        );
        private static final Map<String, Constructor> CAPTURED_CONSTRUCTORS;
        private static final Map<String, Method> CAPTURED_METHODS;

        static {
            CAPTURED_CONSTRUCTORS = BYTECODE_INTERNAL_REFLECTIONS.getConstructorsAnnotatedWith(BytecodeInternal.class)
                    .stream()
                    .collect(Collectors.toMap(
                            (final Constructor constructor) -> ((Constructor<?>) constructor).getAnnotation(BytecodeInternal.class).key(),
                            Function.identity()
                    ));
            CAPTURED_METHODS = BYTECODE_INTERNAL_REFLECTIONS.getMethodsAnnotatedWith(BytecodeInternal.class)
                    .stream()
                    .collect(Collectors.toMap(
                            (final Method method) -> method.getAnnotation(BytecodeInternal.class).key(),
                            Function.identity()
                    ));
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
