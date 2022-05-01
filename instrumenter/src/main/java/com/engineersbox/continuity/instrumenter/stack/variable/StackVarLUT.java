package com.engineersbox.continuity.instrumenter.stack.variable;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.objectweb.asm.Type.DOUBLE_TYPE;
import static org.objectweb.asm.Type.LONG_TYPE;

public class StackVarLUT {
    private List<StackVariable> argVars;
    private List<StackVariable> extraVars;
    private int extraOffset;

    public StackVarLUT(final ClassNode classNode,
                       final MethodNode methodNode) {
        this(
                (methodNode.access & Opcodes.ACC_STATIC) != 0,
                Type.getObjectType(classNode.name),
                Type.getType(methodNode.desc),
                methodNode.maxLocals
        );
    }

    private StackVarLUT(final boolean isStatic,
                        final Type objectType,
                        final Type methodType,
                        final int maxLocals) {
        if (maxLocals < 0) throw new IllegalArgumentException("Max locals cannot be negative");
        if (objectType.getSort() != Type.OBJECT) throw new IllegalArgumentException("Object type must be of OBJECT sort");
        if (methodType.getSort() != Type.METHOD) throw new IllegalArgumentException("Method type must be of METHOD sort");

        this.extraOffset = maxLocals;
        this.argVars = new ArrayList<>();
        this.extraVars = new ArrayList<>();

        if (!isStatic)  argVars.add(0, new StackVariable(objectType, 0, true));
        final Type[] argTypes = methodType.getArgumentTypes();
        for (int i = 0; i < argTypes.length; i++) {
            int idx = isStatic ? i : i + 1;
            this.argVars.add(new StackVariable(argTypes[i], idx, true));
        }
    }

    public StackVariable getArg(final int index) {
        return this.argVars.get(index);
    }

    public StackVariable obtainExtraArg(final Type type) {
        final Optional<StackVariable> potentialVariable = this.extraVars.stream()
                .filter((final StackVariable variable) -> !variable.used() && variable.type().equals(type))
                .findFirst();
        if (potentialVariable.isPresent()) {
            this.extraVars.remove(potentialVariable.get());
            final StackVariable variable = new StackVariable(type, potentialVariable.get().index(), true);
            this.extraVars.add(variable);
            return variable;
        }
        final int slotSize = extraVars.stream()
                .mapToInt((final StackVariable variable) -> variable.type().equals(LONG_TYPE) || variable.type().equals(DOUBLE_TYPE) ? 2 : 1)
                .sum();
        final StackVariable variable = new StackVariable(type, this.extraOffset + slotSize, true);
        this.extraVars.add(variable);
        return variable;
    }
}
