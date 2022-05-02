package com.engineersbox.continuity.instrumenter.stack.storage;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.ArrayList;
import java.util.List;

public class VariableLUT {

    private final List<Variable> argVars;
    private final int stackVarsOffset;
    private final List<Variable> stackVars;

    public VariableLUT(final ClassNode classNode,
                       final MethodNode methodNode) {
        this(
                (methodNode.access & Opcodes.ACC_STATIC) != 0,
                Type.getObjectType(classNode.name),
                Type.getType(methodNode.desc),
                methodNode.maxLocals
        );
        if (!classNode.methods.contains(methodNode)) {
            throw new IllegalArgumentException(String.format(
                    "Method node %s is not part of class node %s",
                    methodNode.signature,
                    classNode.signature
            ));
        }
    }

    private VariableLUT(final boolean isStatic,
                        final Type objectType,
                        final Type methodType,
                        final int maxLocals) {
        if (objectType == null) {
            throw new IllegalArgumentException("Object type cannot be null");
        } else if (methodType == null) {
            throw new IllegalArgumentException("method type cannot be null");
        } else if (maxLocals < 0) {
            throw new IllegalArgumentException("Max for LVAs must be at least 1");
        } else if (objectType.getSort() != Type.OBJECT) {
            throw new IllegalArgumentException("Object type was not of sort object");
        } else if (methodType.getSort() != Type.METHOD) {
            throw new IllegalArgumentException("method type was not of sort method");
        }
        this.stackVarsOffset = maxLocals;
        this.argVars = new ArrayList<>();
        this.stackVars = new ArrayList<>();
        if (!isStatic) {
            this.argVars.add(0, new Variable(objectType, 0, true));
        }
        final Type[] argTypes = methodType.getArgumentTypes();
        for (int i = 0; i < argTypes.length; i++) {
            this.argVars.add(new Variable(
                    argTypes[i],
                    isStatic ? i : i + 1,
                    true
            ));
        }
    }

    public Variable getArgument(final int index) {
        if (index < 0 || index >= this.argVars.size()) {
            throw new IndexOutOfBoundsException(index);
        }
        return this.argVars.get(index);
    }

    public Variable allocExtra(final Class<?> type) {
        if (type == null) {
            throw new IllegalArgumentException("Class type cannot be null");
        }
        return allocExtra(Type.getType(type));
    }

    public Variable allocExtra(final Type type) {
        if (type == null) {
            throw new IllegalArgumentException("Type cannot be null");
        }
        final int sort = type.getSort();
        if (sort == Type.VOID || sort == Type.METHOD) {
            throw new IllegalArgumentException("Type cannot be VOID or METHOD");
        }
        for (Variable variable : this.stackVars) {
            if (variable.used || !variable.type.equals(type)) {
                continue;
            }
            this.stackVars.remove(variable);
            variable = new Variable(type, variable.index, true);
            this.stackVars.add(variable);
            return variable;
        }

        final int stackVarSlotLen = this.stackVars.stream()
                .mapToInt(x -> x.type.equals(Type.LONG_TYPE) || x.type.equals(Type.DOUBLE_TYPE) ? 2 : 1)
                .sum();
        final Variable variable = new Variable(type, this.stackVarsOffset + stackVarSlotLen, true);
        this.stackVars.add(variable);
        return variable;
    }

    public void freeExtra(final Variable variable) {
        if (variable == null) {
            throw new IllegalArgumentException("Variable cannot be null");
        } else if (variable.getParent() != this) {
            throw new IllegalArgumentException("Parent instance was not the current VariableLUT instance");
        } else if (variable.index < this.argVars.size()) {
            throw new IllegalArgumentException("Cannot free an argument variable");
        } else if (!variable.used) {
            throw new IllegalArgumentException("Variable is not marked as used");
        }
        variable.used = false;
    }

    public int getArgCount() {
        return this.argVars.size();
    }

    public final class Variable {
        private final Type type;
        private final int index;
        private boolean used;

        private Variable(final Type type,
                         final int index,
                         final boolean used) {
            this.type = type;
            this.index = index;
            this.used = used;
        }

        public Type getType() {
            if (!this.used) {
                throw new IllegalStateException("Variable has been released");
            }
            return type;
        }

        public int getIndex() {
            if (!this.used) {
                throw new IllegalStateException("Variable has been released");
            }
            return index;
        }

        public boolean isUsed() {
            return used;
        }

        private VariableLUT getParent() {
            return VariableLUT.this;
        }
    }
}
