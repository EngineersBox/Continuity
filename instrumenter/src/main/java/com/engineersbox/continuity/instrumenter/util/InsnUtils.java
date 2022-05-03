package com.engineersbox.continuity.instrumenter.util;

import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.LineNumberNode;
import org.objectweb.asm.util.Printer;
import org.objectweb.asm.util.Textifier;
import org.objectweb.asm.util.TraceMethodVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class InsnUtils {

    private static final Printer PRINTER = new Textifier();
    private static final TraceMethodVisitor METHOD_VISITOR = new TraceMethodVisitor(PRINTER);

    public static String insnToString(final AbstractInsnNode insn){
        insn.accept(METHOD_VISITOR);
        final StringWriter sw = new StringWriter();
        PRINTER.print(new PrintWriter(sw));
        PRINTER.getText().clear();
        return sw.toString().stripTrailing();
    }

    public static String insnsToString(final InsnList insnList) {
        return StreamSupport.stream(insnList.spliterator(), false)
                .map(InsnUtils::insnToString)
                .collect(Collectors.joining("\n"));
    }

    public static LineNumberNode getLineNumberForInsn(final InsnList insnList,
                                                      final AbstractInsnNode insnNode) {
        final ListIterator<AbstractInsnNode> insnIterator = insnList.iterator(insnList.indexOf(insnNode));
        while (insnIterator.hasPrevious()) {
            AbstractInsnNode node = insnIterator.previous();
            if (node instanceof LineNumberNode lineNumberNode) {
                return lineNumberNode;
            }
        }
        return null;
    }
}
