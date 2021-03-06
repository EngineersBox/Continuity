package com.engineersbox.continuity.instrumenter.lang.transform.stdlib.annotation;

import com.engineersbox.continuity.instrumenter.bytecode.BytecodeBuilder;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface StdlibBuilder {
    String methodName() default "<STDLIB METHOD>";
    boolean isBaseClass() default false;
    Class<? extends BytecodeBuilder>[] parent() default {};
}
