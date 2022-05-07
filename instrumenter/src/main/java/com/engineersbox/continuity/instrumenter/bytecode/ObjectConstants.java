package com.engineersbox.continuity.instrumenter.bytecode;

public class ObjectConstants {

    private ObjectConstants() {}

    public static final String NULL_OBJ_DESCRIPTOR = "Lnull;";
    public static final String STRING_PARAMETER_METHOD_SIGNATURE = "(Ljava/lang/String;)V";
    public static final String CONSTRUCTOR_METHOD_NAME = "<init>";
    public static final String SYSTEM_PATH_FQN = java.lang.System.class.getCanonicalName().replace('.', '/');
    public static final String STATIC_FIELD_OUT_NAME = "out";
    public static final String PRINT_STREAM_DESCRIPTOR = java.io.PrintStream.class.descriptorString();
    public static final String PRINT_STREAM_PATH_FQN = java.io.PrintStream.class.getCanonicalName().replace('.', '/');
    public static final String PRINTLN_METHOD_NAME = "println";
}
