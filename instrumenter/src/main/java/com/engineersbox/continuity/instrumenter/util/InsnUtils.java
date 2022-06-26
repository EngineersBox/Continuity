package com.engineersbox.continuity.instrumenter.util;

import com.engineersbox.continuity.instrumenter.bytecode.InsnBuilder;
import org.apache.commons.lang3.Validate;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.*;
import org.objectweb.asm.util.Printer;
import org.objectweb.asm.util.Textifier;
import org.objectweb.asm.util.TraceMethodVisitor;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class InsnUtils {

    private InsnUtils() {}

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

    public static int argumentCountForInvocation(final AbstractInsnNode insnNode) {
        if (insnNode == null) {
            throw new IllegalArgumentException("Node cannot be null");
        }
        if (insnNode instanceof MethodInsnNode methodInsnNode) {
            return argumentCountForMethodInvocation(methodInsnNode);
        } else if (insnNode instanceof InvokeDynamicInsnNode invokeDynamicInsnNode) {
            return argumentCountForDynamicInvocation(invokeDynamicInsnNode);
        }
        throw new IllegalArgumentException("Unknown invocation type");
    }

    private static int argumentCountForMethodInvocation(final MethodInsnNode methodInsnNode) {
        final int extra = switch (methodInsnNode.getOpcode()) {
            case Opcodes.INVOKEVIRTUAL, Opcodes.INVOKESPECIAL, Opcodes.INVOKEINTERFACE -> 1;
            case Opcodes.INVOKESTATIC -> 0;
            default -> throw new IllegalArgumentException("Unknown invocation type");
        };
        final int argCount = Type.getType(methodInsnNode.desc).getArgumentTypes().length;
        return argCount + extra;
    }

    private static int argumentCountForDynamicInvocation(final InvokeDynamicInsnNode invokeDynamicInsnNode) {
        return Type.getType(invokeDynamicInsnNode.desc).getArgumentTypes().length;
    }

    public static InsnList cloneInvokeNode(final AbstractInsnNode insnNode) {
        if (insnNode == null) {
            throw new IllegalArgumentException("Node cannot be null");
        } else if (!(insnNode instanceof MethodInsnNode || insnNode instanceof InvokeDynamicInsnNode)) {
            throw new IllegalArgumentException(String.format(
                    "Node must be either MethodInsnNode or InvokeDynamicInsnNode not %s",
                    insnNode.getClass().getName()
            ));
        }
        return InsnBuilder.combine(
                insnNode.clone(new HashMap<>())
        ).build();
    }
}
