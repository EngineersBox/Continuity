package com.engineersbox.continuity.instrumenter.method.bytecode.annotation;

import com.engineersbox.continuity.instrumenter.stack.point.ContinuationPoint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ClassInstancedInvokable {
    Class<? extends ContinuationPoint> value();
}
