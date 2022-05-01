package com.engineersbox.continuity.instrumenter.util;

import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.util.Printer;
import org.objectweb.asm.util.Textifier;
import org.objectweb.asm.util.TraceMethodVisitor;

import java.io.PrintWriter;
import java.io.StringWriter;

public class InsnUtils {

    private static final Printer PRINTER = new Textifier();
    private static final TraceMethodVisitor METHOD_VISITOR = new TraceMethodVisitor(PRINTER);

    public static String insnToString(final AbstractInsnNode insn){
        insn.accept(METHOD_VISITOR);
        final StringWriter sw = new StringWriter();
        PRINTER.print(new PrintWriter(sw));
        PRINTER.getText().clear();
        return sw.toString().trim();
    }
}
