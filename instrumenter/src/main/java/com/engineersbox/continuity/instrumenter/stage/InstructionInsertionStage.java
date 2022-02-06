package com.engineersbox.continuity.instrumenter.stage;

import org.objectweb.asm.tree.ClassNode;

public class InstructionInsertionStage implements InstrumentationStage {

    @Override
    public void invoke(final ClassNode node, final InstrumentationContext context) {
        /* SUSPEND CALL INSTRUMENTING
         * ===========================
         * 1. Get method state from previous instrumentation stage (MethodIntrospectionStage)
         * 2. Iterate through the ContinuationPoints
         * 3. Retrieve the invocation instruction from the current ContinuationPoint
         * 4. Construct an InsnList with bytecode to store the current method state
         * 5. Insert it before the invocation instruction
         * 6. Remove the Continuation$suspend() invocation
         *
         * CONSTRUCT InsnList
         * ===========================
         * 1. Save OS
         * 2. Save LVA
         * 3. Pack storage array with OS and LVA data
         * 4. Construct new MethodState instance and pass to Continuation$pushMethodState(MethodState)
         * 5. Call Continuation$setMode(ContinuationMode.SAVING)
         * 6. Create return statement with dummy value for whatever the parent method expects as a return value type
         * 7. Add a label after the return as the continuation point
         *
         * SAVE OS
         * ===========================
         * 1. Compute the sizes of each of the types of storage vars (INT, FLOAT, LONG, DOUBLE, OBJECT)
         * 2. Store the counts of each type
         * 3. Save each of the storage vars types with the following:
         *      a. LOAD_CONST StorageSizes.typeSize() <- typeSize can be intSize, floatSize, etc
         *      b. INT_INSN(NEWARRAY, T_TYPE) <- T_TYPE can be T_INT, T_FLOAT, etc
         *      c. VAR = ASTORE typeVar.getIndex() <- typeVar can be intsVar, floatsVar, etc
         * 4. Add all the generated above instructions to an IsnsList
         * 5. Iterate over the stack and perform the following:
         *      a. Get the current stack value type frame.getStack(i).getType()
         *      b. If type.getDescriptor() is "Lnull;" then add InsnNode(Opcodes.POP) to the InsnList and continue to next iteration
         *      c. Switch on the type.getSort()
         *      d. If the sort is BOOLEAN, BYTE, SHORT, CHAR or INT:
         *          1. ALOAD intsVar.getIndex()
         *          2. SWAP
         *          3. LOAD_CONST intsCounter
         *          4. SWAP
         *          5. IASTOR
         *          6. Decrement intsCounter
         *          7. Break
         *      e. If the sort is FLOAT:
         *          1. ALOAD floatsVar.getIndex()
         *          2. SWAP
         *          3. LOAD_CONST floatsCounter
         *          4. SWAP
         *          5. FASTORE
         *          6. Decrement floatsCounter
         *          7. Break
         *      f. If the sort is LONG:
         *          1. ALOAD longsVar.getIndex()
         *          2. LOAD_CONST longsCounter
         *          3. DUP2_X2
         *          4. POP2
         *          5. LASTORE
         *          6. Decrement longsCounter
         *          7. Break
         *      g. If the sort is DOUBLE:
         *          1. ALOAD doublesVar.getIndex()
         *          2. LOAD_CONST doublesCounter
         *          3. DUP2_X2
         *          4. POP2
         *          5. DASTORE
         *          6. Decrement doublesCounter
         *          7. Break
         *      h. If the sort is ARRAY or OBJECT:
         *          1. ALOAD objectsVar.getIndex()
         *          2. SWAP
         *          3. LOAD_CONST objectsCounter
         *          4. SWAP
         *          5. AASTORE
         *          6. Decrement objectsCounter
         *          7. Break
         *      i. If the sort is METHOD or VOID, then throw an exception
         * 6. Return the InsnList
         *
         * SAVE LVA
         * ===========================
         * 1. Compute the sizes of each of the types of storage vars (INT, FLOAT, LONG, DOUBLE, OBJECT)
         * 2. Create counters for each storage type
         * 3. Save each of the storage vars types with the following:
         *      a. LOAD_CONST StorageSizes.typeSize() <- typeSize can be intSize, floatSize, etc
         *      b. INT_INSN(NEWARRAY, T_TYPE) <- T_TYPE can be T_INT, T_FLOAT, etc
         *      c. VAR = ASTORE typeVar.getIndex() <- typeVar can be intsVar, floatsVar, etc
         * 4. Add all the generated above instructions to an IsnsList
         * 5. Iterate over the locals and perform the following (let the loop variable be known as localIdx):
         *      a. Get the current stack value type frame.getLocal(i).getType()
         *      b. If type is null then continue to next iteration
         *      c. If type.getDescriptor() is "Lnull;" then continue to next iteration
         *      d. c. Switch on the type.getSort()
         *      e. If the type is BOOLEAN, BYTE, SHORT, CHAR, INT:
         *          1. VAR = ALOAD intsVar.getIndex()
         *          2. LOAD_CONST intsCounter
         *          3. VAR = ILOAD localIdx
         *          4. IASTORE
         *          5. Increment intsCounter
         *          6. Break
         *      f. If the type is FLOAT:
         *          1. VAR = ALOAD floatsVar.getIndex()
         *          2. LOAD_CONST floatsCounter
         *          3. VAR = FLOAD localIdx
         *          4. FASTORE
         *          5. Increment floatsCounter
         *          6. Break
         *      g. If the type is LONG:
         *          1. VAR = ALOAD longsVar.getIndex()
         *          2. LOAD_CONST longsCounter
         *          3. VAR = LLOAD localIdx
         *          4. LASTORE
         *          5. Increment longsCounter
         *          6. Break
         *      h. If the type is DOUBLE:
         *          1. VAR = ALOAD doublesVar.getIndex()
         *          2. LOAD_CONST doublesCounter
         *          3. VAR = DLOAD localIdx
         *          4. DASTORE
         *          5. Increment doublesCounter
         *          6. Break
         *      i. If the type is ARRAY or OBJECT:
         *          1. VAR = ALOAD objectsVar.getIndex()
         *          2. LOAD_CONST objectsCounter
         *          3. VAR = ALOAD localIdx
         *          4. AASTORE
         *          5. Increment objectsCounter
         *          6. Break
         *      j. If the type is METHOD or VOID, throw an exception
         * 6. Return the InsnList
         *
         * PACK STORAGE ARRAYS
         * ===========================
         * 1. Store LVA locals and OS stack vars for later access
         * 2. Create an InsnList and append the following:
         *      a. LOAD_CONST 10
         *      b. ANEWARRAY "java/lang/Object"
         *      c. ASTORE containerVar.getIndex()
         *      d. For each of the locals var types do the following:
         *          1. ALOAD containerVar.getIndex()
         *          2. LOAD_CONST value <- value can be matching: { INT: 0, FLOAT: 1, LONG: 2, DOUBLE: 3, OBJECT: 4 }
         *          3. ALOAD localsTypeVar.getIndex() <- localsTypeVar can be localsIntsVar, localsFloatsVar, etc
         *          4. AASTORE
         *      e. For each of the stack var types do the following:
         *          1. ALOAD containerVar.getIndex()
         *          2. LOAD_CONST value <- value can be matching: { INT: 5, FLOAT: 6, LONG: 7, DOUBLE: 8, OBJECT: 9 }
         *          3. ALOAD stackTypeVar.getIndex() <- stackTypeVar can be stackIntsVar, stackFloatsVar, etc
         *          4. AASTORE
         *  3. Return the InsnList
         *
         * CONSTRUCT MethodState
         * ===========================
         * 1. Get the Constructor<?> instance for MethodState.<init>(String className, int methodId, int continuationPoint, Object[] data)
         * 2. Create an InsnList
         * 3. Get the class type from Constructor.getDeclaringClass()
         * 4. Get the constructor type from Type.getType(Constructor)
         * 5. Add the following to the InsnList:
         *      a. NEW clsType.getInternalName()
         *      b. DUP
         *      c. LOAD_CONST methodAttributes.getSignature().getClassName().replace('/','.')
         *      d. LOAD_CONST methodId
         *      e. LOAD_CONST idx
         *      f. XLOAD storageContainerVar <- XLOAD can be matching: { [BOOLEAN,BYTE,CHAR,SHORT,INT]: ILOAD, LONG: LLOAD, FLOAT: FLOAD, DOUBLE: DLOAD, [OBJECT,ARRAY]: ALOAD }
         *      g. MethodInsnNode(INVOKESPECIAL, clsType.getInternalName(), "<init>", methodType.getDescriptor(), false)
         * 6. Return the InsnList
         *
         * INVOKE pushMethodState CALL
         * ===========================
         * 1. Create InsnList
         * 2. Add the following to the InsnList:
         *      a. XLOAD continuationArg <- XLOAD can be matching: { [BOOLEAN,BYTE,CHAR,SHORT,INT]: ILOAD, LONG: LLOAD, FLOAT: FLOAD, DOUBLE: DLOAD, [OBJECT,ARRAY]: ALOAD }
         *      b. CONSTRUCT MethodState
         * 3. Get the method class type with Type.getType(method.getDeclaringClass())
         * 4. Get the method type with Type.getType(method)
         * 5. If (method.getModifiers() & STATIC) == STATIC:
         *      a. Add to InsnList: MethodInsnNode(INVOKESTATIC, classType.getInternalName(), method.getName(), methodType.getDescriptor(), false)
         * 6. Else if method.getDeclaringClass().isInterface()
         *      a. Add to InsnList: MethodInsnNode(INVOKEINTERFACE, classType.getInternalName(), method.getName(), methodType.getDescriptor(), true)
         * 7. Else
         *      a. Add to InsnList: MethodInsnNode(INVOKEVIRTUAL, classType.getInternalName(), method.getName(), methodType.getDescriptor(), false)
         * 8. Return the InsnList
         */
    }

}
