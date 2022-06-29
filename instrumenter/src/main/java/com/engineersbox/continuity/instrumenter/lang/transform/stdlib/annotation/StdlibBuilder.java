package com.engineersbox.continuity.instrumenter.lang.transform.stdlib.annotation;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface StdlibBuilder {
    String methodName();
}
