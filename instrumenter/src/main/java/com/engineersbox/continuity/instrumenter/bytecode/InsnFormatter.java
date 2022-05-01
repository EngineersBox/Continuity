package com.engineersbox.continuity.instrumenter.bytecode;

import com.engineersbox.continuity.instrumenter.stack.variable.StackVariable;
import org.apache.commons.lang3.Validate;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.StreamSupport;

public class InsnFormatter {

    public static InsnList combine(final Object ...insns) {
        InsnList ret = new InsnList();
        for (final Object insn : insns) {
            switch (insn) {
                case AbstractInsnNode insnNode -> ret.add(insnNode);
                case InsnList insnList -> {
                    StreamSupport.stream(insnList.spliterator(), false)
                            .filter(Objects::isNull)
                            .findAny()
                            .ifPresent((final AbstractInsnNode node) -> {
                                throw new IllegalArgumentException("Instruction cannot be null");
                            });
                    ret.add((InsnList) insn);
                }
                case BytecodeGenerator generator -> {
                    final InsnList insnList = generator.generate();
                    StreamSupport.stream(insnList.spliterator(), false)
                            .filter(Objects::isNull)
                            .findAny()
                            .ifPresent((final AbstractInsnNode node) -> {
                                throw new IllegalArgumentException("Instruction cannot be null");
                            });
                    ret.add(insnList);
                }
                case null, default -> throw new IllegalArgumentException(String.format("Invalid instruction format: %s", insn));
            }
        }
        return ret;
    }

    public static BytecodeGenerator combineIf(final boolean condition,
                                              final Supplier<Object[]> insns) {
        return new BCConditionalGenerator(condition, insns);
    }

    public static InsnList call(final Method method,
                                final InsnList ...insns) {
        final InsnList ret = new InsnList();
        for (final InsnList insnList : insns) {
            ret.add(insnList);
        }
        final Type clsType = Type.getType(method.getDeclaringClass());
        final Type methodType = Type.getType(method);

        if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC) {
            if (method.getParameterCount() != insns.length) {
                throw new IllegalStateException("Method argument count differs from supplied arguments");
            }
            ret.add(new MethodInsnNode(
                    Opcodes.INVOKESTATIC,
                    clsType.getInternalName(),
                    method.getName(),
                    methodType.getDescriptor(),
                    false
            ));
        } else if (method.getDeclaringClass().isInterface()) {
            if (method.getParameterCount() + 1 != insns.length) {
                throw new IllegalStateException("Method argument count differs from supplied arguments");
            }
            ret.add(new MethodInsnNode(
                    Opcodes.INVOKEINTERFACE,
                    clsType.getInternalName(),
                    method.getName(),
                    methodType.getDescriptor(),
                    true
            ));
        } else {
            if (method.getParameterCount() + 1 != insns.length) {
                throw new IllegalStateException("Method argument count differs from supplied arguments");
            }
            ret.add(new MethodInsnNode(
                    Opcodes.INVOKEVIRTUAL,
                    clsType.getInternalName(),
                    method.getName(),
                    methodType.getDescriptor(),
                    false
            ));
        }

        return ret;
    }

    public static InsnList loadVar(final StackVariable variable) {
        final InsnList ret = new InsnList();
        switch (variable.getType().getSort()) {
            case Type.BOOLEAN, Type.BYTE, Type.CHAR, Type.SHORT, Type.INT -> ret.add(new VarInsnNode(Opcodes.ILOAD, variable.getIndex()));
            case Type.LONG -> ret.add(new VarInsnNode(Opcodes.LLOAD, variable.getIndex()));
            case Type.FLOAT -> ret.add(new VarInsnNode(Opcodes.FLOAD, variable.getIndex()));
            case Type.DOUBLE -> ret.add(new VarInsnNode(Opcodes.DLOAD, variable.getIndex()));
            case Type.OBJECT, Type.ARRAY -> ret.add(new VarInsnNode(Opcodes.ALOAD, variable.getIndex()));
            default -> throw new IllegalStateException(String.format("Invalid variable sort: %s", variable.getType().getSort()));
        }
        return ret;
    }

    public static InsnList invokeConstructor(final Constructor<?> constructor,
                                             final InsnList ...args) {
        if (constructor.getParameterCount() != args.length) {
            throw new IllegalArgumentException("Supplied arguments do not match constructor arguments");
        }
        final InsnList ret = new InsnList();
        final Type clsType = Type.getType(constructor.getDeclaringClass());

        ret.add(new TypeInsnNode(Opcodes.NEW, clsType.getInternalName()));
        ret.add(new InsnNode(Opcodes.DUP));
        for (final InsnList arg : args) {
            ret.add(arg);
        }
        ret.add(new MethodInsnNode(Opcodes.INVOKESPECIAL, clsType.getInternalName(), "<init>", Type.getType(constructor).getDescriptor(), false));

        return ret;
    }

    public static InsnList loadStringConst(final String s) {
        final InsnList ret = new InsnList();
        ret.add(new LdcInsnNode(s));
        return ret;
    }

    public static InsnList loadIntConst(final int i) {
        final InsnList ret = new InsnList();
        ret.add(new LdcInsnNode(i));
        return ret;
    }

    public static InsnList mockValue(final Type returnType) {
        if (returnType.getSort() == Type.METHOD) {
            throw new IllegalArgumentException("Cannot mock return for type METHOD");
        }
        final InsnList ret = new InsnList();
        switch (returnType.getSort()) {
            case Type.VOID -> ret.add(new InsnNode(Opcodes.RETURN));
            case Type.BOOLEAN, Type.BYTE, Type.SHORT, Type.CHAR, Type.INT -> {
                ret.add(new InsnNode(Opcodes.ICONST_0));
                ret.add(new InsnNode(Opcodes.IRETURN));
            }
            case Type.LONG -> {
                ret.add(new InsnNode(Opcodes.LCONST_0));
                ret.add(new InsnNode(Opcodes.LRETURN));
            }
            case Type.FLOAT -> {
                ret.add(new InsnNode(Opcodes.FCONST_0));
                ret.add(new InsnNode(Opcodes.FRETURN));
            }
            case Type.DOUBLE -> {
                ret.add(new InsnNode(Opcodes.DCONST_0));
                ret.add(new InsnNode(Opcodes.DRETURN));
            }
            case Type.OBJECT, Type.ARRAY -> {
                ret.add(new InsnNode(Opcodes.ACONST_NULL));
                ret.add(new InsnNode(Opcodes.ARETURN));
            }
            default -> throw new IllegalStateException();
        }

        return ret;
    }

    public static InsnList addLabel(final LabelNode labelNode) {
        final InsnList ret = new InsnList();
        ret.add(labelNode);
        return ret;
    }
}
