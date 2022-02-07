# LOAD STATE INSTRUMENTING

1. Get method state from previous instrumentation stage (MethodIntrospectionStage)
2. Generate InsnList for continuing/restoring
3. Insert InsnList into `methodNode.instructions`

## LOADING METHOD STATE

1. Create new label at the start of the method with `new LabelNode()`
2. Create an InsnList
3. Generate a switch table for state handling
4. Add switch table to InsnList
5. Add the label to InsnList
6. Return the InsnList

### STATE SWITCH TABLE

1. Create InsnList
2. Create default label node
3. Initialise case labels `LabelNode` array of size 3
4. Get the continuation arg var
5. Create call to `Continuation$getMode()` and append to InsnList
6. Add `TableSwitchInsnNode(0, 2, defaultLabelNode, caseLabelNodes)` to InsnList
7. Iterate through the switch cases:
   1. Get label node for index
   2. Get case InsnList for index
   3. If `caseInsnList != null`
      1. Append case label node
      2. Append case InsnList
8. If `defaultInsnList != null`
   1. Append default label node
   2. Append default case InsnList
9. Return InsnList

### INVOKE getMode CALL

1. Create InsnList
2. Add the following to the InsnList:
  1. `XLOAD continuationArg` <- XLOAD can be matching: `{ [BOOLEAN,BYTE,CHAR,SHORT,INT]: ILOAD, LONG: LLOAD, FLOAT: FLOAD, DOUBLE: DLOAD, [OBJECT,ARRAY]: ALOAD }`
  2. `CONSTRUCT MethodState`
3. Get the method class type with `Type.getType(method.getDeclaringClass())`
4. Get the method type with `Type.getType(method)`
5. If `(method.getModifiers() & STATIC) == STATIC`:
  1. Add to `InsnList: MethodInsnNode(INVOKESTATIC, classType.getInternalName(), method.getName(), methodType.getDescriptor(), false)`
6. Else if `method.getDeclaringClass().isInterface()`
  1. Add to `InsnList: MethodInsnNode(INVOKEINTERFACE, classType.getInternalName(), method.getName(), methodType.getDescriptor(), true)`
7. Else
  1. Add to `InsnList: MethodInsnNode(INVOKEVIRTUAL, classType.getInternalName(), method.getName(), methodType.getDescriptor(), false)`
8. Return the InsnList

#### CASE 0: CALL TO EXECUTE

1. Get the method start label
2. Append `JumpInsnNode(GOTO, methodStartLabel)` to InsnList

#### CASE 1: SAVING

1. `TypeInsnNode(NEW, "java/lang/RuntimeException")`
2. `DUP`
3. `LOAD_CONST "Cannot save coroutine state here`
4. `MethodInsnNode(INVOKESPECIAL, "java/lang/RunmtimeException", "<init>", "(Ljava/lang/String;)V", false)`
5. `ATHROW`

#### CASE 2: LOADING

1. Get the continuation arg var
2. Generate call to `Continuation$popToNextMethodState()`
3. Get method state stack var
4. Save method state var
   1. Create InsnList
   2. Switch on `variable.getType().getSort()`
   3. If the type is `BOOLEAN`, `BYTE`, `SHORT`, `CHAR`, `INT`:
      1. `VAR = ISTORE variable.getIndex()`
   4. If the type is `LONG`:
      1. `VAR = LSTORE variable.getIndex()`
   5. If the type is `FLOAT`:
      1. `VAR = FSTORE variable.getIndex()`
   6. If the type is `DOUBLE`:
      1. `VAR = DSTORE variable.getIndex()`
   7. If the type is `OBJECT`, `ARRAY`:
      1. `VAR = ASTORE variable.getIndex()`
   8. Otherwise, throw an exception
   9. Return InsnList
5. Get the method state var
6. Generate call to `MethodState$getData()`
7. Save storage container stack var
   1. Create InsnList
   2. Switch on `variable.getType().getSort()`
   3. If the type is `BOOLEAN`, `BYTE`, `SHORT`, `CHAR`, `INT`:
      1. `VAR = ISTORE variable.getIndex()`
   4. If the type is `LONG`:
      1. `VAR = LSTORE variable.getIndex()`
   5. If the type is `FLOAT`:
      1. `VAR = FSTORE variable.getIndex()`
   6. If the type is `DOUBLE`:
      1. `VAR = DSTORE variable.getIndex()`
   7. If the type is `OBJECT`, `ARRAY`:
      1. `VAR = ASTORE variable.getIndex()`
   8. Otherwise, throw an exception
   9. Return InsnList
8. Create table switch for restore state
9. Add method start label to InsnList
10. Return InsnList

### RESTORE STATE TABLE

1. Create InsnList
2. Create default label node
3. Initialise case labels `LabelNode` array of size 3
4. Get the method state var
5. Generate call to `MethodState$getContinuationPoint()`
6. Generate restore state InsnList for switch cases
7. Get `numOfContinuationPoints`
8. Add `TableSwitchInsnNode(0, 2, defaultLabelNode, numOfContinuationPoints)` to InsnList
9. Iterate through the switch cases:
10. Get label node for index
    1. Get case InsnList for index
    2. If `caseInsnList != null`
       1. Append case label node
       2. Append case InsnList
11. If `defaultInsnList != null`
    1. Append default label node
    2. Append default case InsnList
12. Return InsnList

#### RESTORE STATE

1. Get frame
2. Get storage container var
3. Get saved OS vars
4. Get saved LVA vars
5. Get method current line number
6. Get continuation execution label
7. Unpack OS
8. Unpack LVA
9. Load OS
10. Load LVA
11. Create linenumber after LVA loaded
12. `POP` <- this will pop the stack entry for the `Continuation$suspend()` call
13. Get continuation arg var
14. Generate call to `Continuation$.setMode(MODE_IDLE)`
15. Generate call to `Continuation$popMethodState()`
16. `GOTO continuationExecutionLabel`

##### UNPACK OS

1. Compute the sizes of each of the types of storage vars (`INT`, `FLOAT`, `LONG`, `DOUBLE`, `OBJECT`)
2. Store the counts of each type
3. Create InsnList
4. Load each of the storage vars types with the following (appending instructions to InsnList):
   1. `ALOAD containerVar.getIndex()`
   2. `LOAD_CONST x` <- x can be `{ INT: 5, FLOAT: 6, LONG: 7, DOUBLE: 8, OBJECT: 9 }`
   3. `AALOAD`
   4. `CHECKCAST stackTypeVar.getType().getInternalName()` <- stackTypeVar can be `stackIntsVar`, `stackFloatsVar`, etc
   5. `ASTORE stackTypeVar.getIndex()` <- stackTypeVar can be `stackIntsVar`, `stackFloatsVar`, etc
5. Return InsnList

##### UNPACK LVA

1. Compute the sizes of each of the types of storage vars (`INT`, `FLOAT`, `LONG`, `DOUBLE`, `OBJECT`)
2. Store the counts of each type
3. Create InsnList
4. Load each of the storage vars types with the following (appending instructions to InsnList):
   1. `ALOAD containerVar.getIndex()`
   2. `LOAD_CONST x` <- x can be `{ INT: 0, FLOAT: 1, LONG: 2, DOUBLE: 3, OBJECT: 4 }`
   3. `AALOAD`
   4. `CHECKCAST stackTypeVar.getType().getInternalName()` <- stackTypeVar can be `stackIntsVar`, `stackFloatsVar`, etc
   5. `ASTORE stackTypeVar.getIndex()` <- stackTypeVar can be `stackIntsVar`, `stackFloatsVar`, etc
5. Return InsnList

##### LOAD OS

1. Create InsnList
2. Note stack start index is 0
3. Note stack load index is 0
4. Note count is the stack size
5. Store OS vars for later access
6. Create counters for OS vars
7. Iterate from the start index to load index
   1. Get the type of stack entry at the current index with `frame.getStack(i).getType()`
   2. If `type.getSort() == Type.OBJECT && type.getDescriptor().equals("Lnull;")` then continue to next iteration
   3. Switch on the `type.getSort()`
   4. If the type is `BOOLEAN`, `BYTE`, `SHORT`, `CHAR`, `INT`:
      1. Increment intsCounter
      2. Break
   5. If the type is `FLOAT`:
      1. Increment the floatsCounter
      2. Break
   6. If the type is `LONG`:
      1. Increment the longsCounter
      2. Break
   7. If the type is `DOUBLE`:
      1. Increment the doublesCounter
      2. Break
   8. If the type is `ARRAY`, `OBJECT`:
      1. Increment the objectsCounter
      2. Break
   9. If the type is `METHOD`, `VOID` throw an exception
8. Iterate from the start index to load index
   1. Get the type of stack entry at the current index with `frame.getStack(i).getType()`
   2. If `type.getSort() == Type.OBJECT && type.getDescriptor().equals("Lnull;")`
      1. `ACONST_NULL`
      2. Continue iteration
   3. Switch on the `type.getSort()`
   4. Create cases for `{ [BOOLEAN,BYTE,CHAR,SHORT,INT], LONG, FLOAT, DOUBLE, [OBJECT,ARRAY] }`
      1. `ALOAD typeVar.getIndex()` <- typeVar can be `intsVar`, `floatsVar`, etc
      2. `LOAD_CONST typeCounter` <- typeCounter can be `intsCounter`, `floatsCounter`, etc
      3. `XALOAD` <- XALOAD can be `{ [BOOLEAN,BYTE,CHAR,SHORT,INT]: IALOAD, FLOAT: FALOAD, LONG: LALOAD, DOUBLE: DALOAD, [OBJECT,ARRAY]: AALOAD }`
      4. Increment typeCounter <- typeCounter can be `intsCounter`, `floatsCounter`, etc
      5. Break
   5. If the type is `METHOD`, `VOID`, throw an exception
9. Return InsnList

##### LOAD LVA

1. Create InsnList
2. Store OS vars for later access
3. Create counters for OS vars
4. Iterate over LVA entries
   1. Get the type of local entry at the current index with `frame.getLocal(i).getType()`
   2. If `type == null`, then continue iteration
   3. If `type.getSort() == Type.OBJECT && "Lnull;".equals(type.getDescriptor())`
      1. `ACONST_NULL`
      2. `ASOTRE idx` <- idx is loop var
      3. Continue iteration
   4. Switch on the `type.getSort()`
   5. Create cases for `{ [BOOLEAN,BYTE,CHAR,SHORT,INT], LONG, FLOAT, DOUBLE, [OBJECT,ARRAY] }`
      1. `ALOAD typeVar.getIndex()` <- typeVar can be `intsVar`, `floatsVar`, etc
      2. `LOAD_CONST typeCounter` <- typeCounter can be `intsCounter`, `floatsCounter`, etc
      3. `XALOAD` <- XALOAD can be `{ [BOOLEAN,BYTE,CHAR,SHORT,INT]: IALOAD, FLOAT: FALOAD, LONG: LALOAD, DOUBLE: DALOAD, [OBJECT,ARRAY]: AALOAD }`
      4. `XASTORE idx` <- XASTORE can be `{ [BOOLEAN,BYTE,CHAR,SHORT,INT]: IASTORE, FLOAT: FASTORE, LONG: LASTORE, DOUBLE: DASTORE, [OBJECT,ARRAY]: AASTORE }`
      5. Increment typeCounter <- typeCounter can be `intsCounter`, `floatsCounter`, etc
      6. Break
   6. If the type is `METHOD`, `VOID`, throw an exception
5. Return InsnList