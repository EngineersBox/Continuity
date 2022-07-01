package com.engineersbox.continuity.instrumenter.lang.transform.stdlib.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface StdlibBuilderParam {
    int pos();
    boolean varargs() default false;
}
