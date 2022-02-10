package com.engineersbox.continuity.instrumenter.bytecode;

import com.engineersbox.continuity.instrumenter.method.MethodContext;
import com.engineersbox.continuity.instrumenter.stack.ContinuationPoint;
import com.engineersbox.continuity.instrumenter.stack.variable.PrimitiveStack;
import com.engineersbox.continuity.instrumenter.stack.variable.PrimitiveStackElementType;
import com.engineersbox.continuity.instrumenter.stack.variable.StackVariable;
import com.engineersbox.continuity.instrumenter.stack.variable.StackVarsSizes;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.*;
import org.objectweb.asm.tree.analysis.BasicValue;
import org.objectweb.asm.tree.analysis.Frame;

public class SaveStateGenerator {

    public static InsnList createSaveStateInsns(final MethodContext<?> context,
                                                final int index) {
        final ContinuationPoint continuationPoint = context.continuationPoints().get(index);
        final PrimitiveStack osVars = context.OS();
        final PrimitiveStack lvaVars = context.LVA();
        final Frame<BasicValue> frame = continuationPoint.getFrame();
        return InsnFormatter.combine(
                saveOS(osVars, frame),
                saveLVA(lvaVars, frame)
        );
    }

    public static InsnList saveLVA(final PrimitiveStack lvaVars,
                                   final Frame<BasicValue> frame) {
        StackVariable intsVar = lvaVars.getStackVar(PrimitiveStackElementType.INTEGER);
        StackVariable floatsVar = lvaVars.getStackVar(PrimitiveStackElementType.FLOAT);
        StackVariable longsVar = lvaVars.getStackVar(PrimitiveStackElementType.LONG);
        StackVariable doublesVar = lvaVars.getStackVar(PrimitiveStackElementType.DOUBLE);
        StackVariable objectsVar = lvaVars.getStackVar(PrimitiveStackElementType.OBJECT);

        int intsCounter = 0;
        int floatsCounter = 0;
        int longsCounter = 0;
        int doublesCounter = 0;
        int objectsCounter = 0;

        final StackVarsSizes sizes = calculateLVAStackVarsSizes(frame);

        final InsnList insnList = new InsnList();
        insnList.add(InsnFormatter.combine(
                InsnFormatter.combineIf(intsVar != null, () -> new Object[] {
                        new LdcInsnNode(sizes.intsSize()),
                        new IntInsnNode(Opcodes.NEWARRAY, Opcodes.T_INT),
                        new VarInsnNode(Opcodes.ASTORE, intsVar.getIndex())
                }),
                InsnFormatter.combineIf(floatsVar != null, () -> new Object[] {
                        new LdcInsnNode(sizes.floatsSize()),
                        new IntInsnNode(Opcodes.NEWARRAY, Opcodes.T_FLOAT),
                        new VarInsnNode(Opcodes.ASTORE, floatsVar.getIndex())
                }),
                InsnFormatter.combineIf(longsVar != null, () -> new Object[] {
                        new LdcInsnNode(sizes.longsSize()),
                        new IntInsnNode(Opcodes.NEWARRAY, Opcodes.T_LONG),
                        new VarInsnNode(Opcodes.ASTORE, longsVar.getIndex())
                }),
                InsnFormatter.combineIf(doublesVar != null, () -> new Object[] {
                        new LdcInsnNode(sizes.longsSize()),
                        new IntInsnNode(Opcodes.NEWARRAY, Opcodes.T_DOUBLE),
                        new VarInsnNode(Opcodes.ASTORE, doublesVar.getIndex())
                }),
                InsnFormatter.combineIf(objectsVar != null, () -> new Object[] {
                        new LdcInsnNode(sizes.longsSize()),
                        new TypeInsnNode(Opcodes.NEWARRAY, "java/lang/Object"),
                        new VarInsnNode(Opcodes.ASTORE, objectsVar.getIndex())
                })
        ));

        for (int i = 0; i < frame.getLocals(); i++) {
            final Type type = frame.getLocal(i).getType();
            if (type == null || type.getDescriptor().equals("Lnull;")) {
                continue;
            }
            switch (type.getSort()) {
                case Type.BOOLEAN, Type.BYTE, Type.SHORT, Type.CHAR, Type.INT -> {
                    insnList.add(new VarInsnNode(Opcodes.ALOAD, intsVar.getIndex()));
                    insnList.add(new LdcInsnNode(intsCounter));
                    insnList.add(new VarInsnNode(Opcodes.ILOAD, i));
                    insnList.add(new InsnNode(Opcodes.IASTORE));
                    intsCounter++;
                }
                case Type.FLOAT -> {
                    insnList.add(new VarInsnNode(Opcodes.ALOAD, floatsVar.getIndex()));
                    insnList.add(new LdcInsnNode(floatsCounter));
                    insnList.add(new VarInsnNode(Opcodes.FLOAD, i));
                    insnList.add(new InsnNode(Opcodes.FASTORE));
                    floatsCounter++;
                }
                case Type.LONG -> {
                    insnList.add(new VarInsnNode(Opcodes.ALOAD, longsVar.getIndex()));
                    insnList.add(new LdcInsnNode(longsCounter));
                    insnList.add(new VarInsnNode(Opcodes.LLOAD, i));
                    insnList.add(new InsnNode(Opcodes.LASTORE));
                    longsCounter++;
                }
                case Type.DOUBLE -> {
                    insnList.add(new VarInsnNode(Opcodes.ALOAD, doublesVar.getIndex()));
                    insnList.add(new LdcInsnNode(doublesCounter));
                    insnList.add(new VarInsnNode(Opcodes.DLOAD, i));
                    insnList.add(new InsnNode(Opcodes.DASTORE));
                    doublesCounter++;
                }
                case Type.ARRAY, Type.OBJECT -> {
                    insnList.add(new VarInsnNode(Opcodes.ALOAD, objectsVar.getIndex()));
                    insnList.add(new LdcInsnNode(objectsCounter));
                    insnList.add(new VarInsnNode(Opcodes.ALOAD, i));
                    insnList.add(new InsnNode(Opcodes.AASTORE));
                    objectsCounter++;
                }
                case Type.METHOD, Type.VOID, default -> throw new IllegalStateException();
            }
        }

        return insnList;
    }

    public static InsnList saveOS(final PrimitiveStack osVars,
                                  final Frame<BasicValue> frame) {
        final int count = frame.getStackSize();
        final StackVariable intsVar = osVars.getStackVar(PrimitiveStackElementType.INTEGER);
        final StackVariable floatsVar = osVars.getStackVar(PrimitiveStackElementType.FLOAT);
        final StackVariable longsVar = osVars.getStackVar(PrimitiveStackElementType.LONG);
        final StackVariable doublesVar = osVars.getStackVar(PrimitiveStackElementType.DOUBLE);
        final StackVariable objectsVar = osVars.getStackVar(PrimitiveStackElementType.OBJECT);

        final StackVarsSizes sizes = calculateOSStackVarsSizes(
                frame,
                frame.getStackSize() - count,
                count
        );

        int intsCounter = sizes.intsSize() - 1;
        int floatsCounter = sizes.floatsSize() - 1;
        int longsCounter = sizes.longsSize() - 1;
        int doublesCounter = sizes.doublesSize() - 1;
        int objectsCounter = sizes.objectsSize() - 1;

        final InsnList insnList = new InsnList();
        insnList.add(InsnFormatter.combine(
                InsnFormatter.combineIf(sizes.intsSize() > 0, () -> new Object[] {
                        new LdcInsnNode(sizes.intsSize()),
                        new IntInsnNode(Opcodes.NEWARRAY, Opcodes.T_INT),
                        new VarInsnNode(Opcodes.ASTORE, intsVar.getIndex())
                }),
                InsnFormatter.combineIf(sizes.floatsSize() > 0, () -> new Object[] {
                        new LdcInsnNode(sizes.floatsSize()),
                        new IntInsnNode(Opcodes.NEWARRAY, Opcodes.T_FLOAT),
                        new VarInsnNode(Opcodes.ASTORE, floatsVar.getIndex())
                }),
                InsnFormatter.combineIf(sizes.longsSize() > 0, () -> new Object[] {
                        new LdcInsnNode(sizes.longsSize()),
                        new IntInsnNode(Opcodes.NEWARRAY, Opcodes.T_LONG),
                        new VarInsnNode(Opcodes.ASTORE, longsVar.getIndex())
                }),
                InsnFormatter.combineIf(sizes.doublesSize() > 0, () -> new Object[] {
                        new LdcInsnNode(sizes.longsSize()),
                        new IntInsnNode(Opcodes.NEWARRAY, Opcodes.T_DOUBLE),
                        new VarInsnNode(Opcodes.ASTORE, doublesVar.getIndex())
                }),
                InsnFormatter.combineIf(sizes.objectsSize() > 0, () -> new Object[] {
                        new LdcInsnNode(sizes.objectsSize()),
                        new TypeInsnNode(Opcodes.NEWARRAY, "java/lang/Object"),
                        new VarInsnNode(Opcodes.ASTORE, objectsVar.getIndex())
                })
        ));

        final int stackStart = frame.getStackSize() - 1;
        final int stackEnd = frame.getStackSize() - count;
        for (int i = stackStart; i >= stackEnd; i--) {
            final Type type = frame.getStack(i).getType();
            if (type.getDescriptor().equals("Lnull;")) {
                insnList.add(new InsnNode(Opcodes.POP));
                continue;
            }

            switch (type.getSort()) {
                case Type.BOOLEAN, Type.BYTE, Type.SHORT, Type.CHAR, Type.INT -> {
                    insnList.add(new VarInsnNode(Opcodes.ALOAD, intsVar.getIndex()));
                    insnList.add(new InsnNode(Opcodes.SWAP));
                    insnList.add(new LdcInsnNode(intsCounter));
                    insnList.add(new InsnNode(Opcodes.SWAP));
                    insnList.add(new InsnNode(Opcodes.IASTORE));
                    intsCounter--;
                }
                case Type.FLOAT -> {
                    insnList.add(new VarInsnNode(Opcodes.ALOAD, floatsVar.getIndex()));
                    insnList.add(new InsnNode(Opcodes.SWAP));
                    insnList.add(new LdcInsnNode(floatsCounter));
                    insnList.add(new InsnNode(Opcodes.SWAP));
                    insnList.add(new InsnNode(Opcodes.FASTORE));
                    floatsCounter--;
                }
                case Type.LONG -> {
                    insnList.add(new VarInsnNode(Opcodes.ALOAD, longsVar.getIndex()));
                    insnList.add(new LdcInsnNode(longsCounter));
                    insnList.add(new InsnNode(Opcodes.DUP2_X2));
                    insnList.add(new InsnNode(Opcodes.POP2));
                    insnList.add(new InsnNode(Opcodes.LASTORE));
                    longsCounter--;
                }
                case Type.DOUBLE -> {
                    insnList.add(new VarInsnNode(Opcodes.ALOAD, doublesVar.getIndex()));
                    insnList.add(new LdcInsnNode(doublesCounter));
                    insnList.add(new InsnNode(Opcodes.DUP2_X2));
                    insnList.add(new InsnNode(Opcodes.POP2));
                    insnList.add(new InsnNode(Opcodes.DASTORE));
                    doublesCounter--;
                }
                case Type.ARRAY, Type.OBJECT -> {
                    insnList.add(new VarInsnNode(Opcodes.ALOAD, objectsVar.getIndex()));
                    insnList.add(new InsnNode(Opcodes.SWAP));
                    insnList.add(new LdcInsnNode(objectsCounter));
                    insnList.add(new InsnNode(Opcodes.SWAP));
                    insnList.add(new InsnNode(Opcodes.AASTORE));
                    objectsCounter--;
                }
                case Type.METHOD, Type.VOID, default -> throw new IllegalArgumentException();
            }
        }

        return insnList;
    }

    private static StackVarsSizes calculateLVAStackVarsSizes(final Frame<BasicValue> frame) {
        int intsSize = 0;
        int longsSize = 0;
        int floatsSize = 0;
        int doublesSize = 0;
        int objectsSize = 0;
        for (int i = 0; i < frame.getLocals(); i++) {
            final Type type = frame.getLocal(i).getType();

            if (type == null || type.getDescriptor().equals("Lnull;")) {
                continue;
            }

            switch (type.getSort()) {
                case Type.BOOLEAN, Type.BYTE, Type.SHORT, Type.CHAR, Type.INT -> intsSize++;
                case Type.FLOAT -> floatsSize++;
                case Type.LONG -> longsSize++;
                case Type.DOUBLE -> doublesSize++;
                case Type.ARRAY, Type.OBJECT -> objectsSize++;
                case Type.METHOD, Type.VOID, default -> throw new IllegalStateException();
            }
        }
        return new StackVarsSizes(
                intsSize,
                floatsSize,
                longsSize,
                doublesSize,
                objectsSize
        );
    }

    private static StackVarsSizes calculateOSStackVarsSizes(final Frame<BasicValue> frame,
                                                            final int offset,
                                                            final int length) {
        int intsSize = 0;
        int floatsSize = 0;
        int longsSize = 0;
        int doublesSize = 0;
        int objectsSize = 0;
        for (int i = offset + length - 1; i >= offset; i--) {
            final Type type = frame.getStack(i).getType();
            if (type.getDescriptor().equals("Lnull;")) {
                continue;
            }
            switch (type.getSort()) {
                case Type.BOOLEAN, Type.BYTE, Type.SHORT, Type.CHAR, Type.INT -> intsSize++;
                case Type.FLOAT -> floatsSize++;
                case Type.LONG -> longsSize++;
                case Type.DOUBLE -> doublesSize++;
                case Type.ARRAY, Type.OBJECT -> objectsSize++;
                case Type.METHOD, Type.VOID, default -> throw new IllegalStateException();
            }
        }
        return new StackVarsSizes(
                intsSize,
                floatsSize,
                longsSize,
                doublesSize,
                objectsSize
        );
    }
}
