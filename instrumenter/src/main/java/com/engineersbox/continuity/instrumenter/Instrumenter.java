package com.engineersbox.continuity.instrumenter;

import com.engineersbox.continuity.instrumenter.clazz.CoreClassNode;
import com.engineersbox.continuity.instrumenter.clazz.CoreClassWriter;
import com.engineersbox.continuity.instrumenter.stack.StackReconstructor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;

public class Instrumenter {

    /* SAVE STATE AT SUSPEND
     * ====================
     * 3 cases to handle:
     * 1. Continuation point is a SuspendPoint
     * 2. Continuation point is a NormalInvokePoint
     * 3. Continuation point is a TryCatchInvokePoint
     *
     * Case 1
     * ------
     * Object[] stack = saveOperandStack();
     * Object[] locals = saveLocals();
     * continuation.addPending(new MethodState(<number>, stack, locals, lockState);
     * continuation.setMode(MODE_SAVING);
     * exitLocks(lockState);
     * return <dummy>;
     * restorePoint_<number>_continue: // at this label: empty exec stack / uninit exec var table
     *
     * Case 2
     * ------
     * Object[] duplicatedArgs = saveOperandStack(<method param count>); -- Why do we do this? because when we want to save the
     *                                                                   -- args to this method when we call
     *                                                                   -- saveOperandStack(). We need to save here becuase
     *                                                                   -- once we invoke the method the args will be consumed
     *                                                                   -- off the stack. The args need to be saved because
     *                                                                   -- when we load, we need to call in to this method
     *                                                                   -- again (see loading code generator above).
     * <method invocation>
     * if (continuation.getMode() == MODE_SAVING) {
     *     Object[] stack = saveOperandStack();
     *     Object[] locals = saveLocals();
     *     exitLocks(lockState);
     *     continuation.addPending(new MethodState(<number>, stack, locals, lockState);
     *     return <dummy>;
     * }
     * restorePoint_<number>_continue:
     *
     * Case 3
     * ------
     * Same as case 2, except re-throwing the exception after the continuation point
     * has saved the state
     */


    /*
     * RESTORE STATE FROM SUSPEND POINT
     * ================================
     * 3 cases to handle:
     * 1. Continuation point is a SuspendPoint
     * 2. Continuation point is a NormalInvokePoint
     * 3. Continuation point is a TryCatchInvokePoint
     *
     * Case 1
     * ------
     * enterLocks(lockState);
     * restoreOperandStack(stack);
     * restoreLocalsStack(localVars);
     * continuation.setMode(MODE_NORMAL);
     * goto restorePoint_<number>_continue;
     *
     * Case 2
     * ------
     * enterLocks(lockState);
     *     // Load up enough of the stack to invoke the method. The invocation here needs to be wrapped in a try catch because
     *     // the original invocation was within a try catch block (at least 1, maybe more). If we do get a throwable, jump
     *     // back to the area where the original invocation was and rethrow it there so the proper catch handlers can
     *     // handle it (if the handler is for the expected throwable type).
     * restoreStackSuffix(stack, <number of items required for method invocation below>);
     * <method invocation>
     * if (continuation.getMode() == MODE_SAVING) {
     *     exitLocks(lockState);
     *     continuation.addPending(methodState); // method state should be loaded from Continuation.saved
     *     return <dummy>;
     * }
     *    // At this point the invocation happened successfully, so we want to save the invocation's result, restore this
     *    // method's state, and then put the result on top of the stack as if invocation just happened. We then jump in to
     *    // the method and continue running it from the instruction after the original invocation point.
     * tempObjVar2 = <method invocation>'s return value; // does nothing if ret type is void
     * restoreOperandStack(stack);
     * restoreLocalsStack(localVars);
     * place tempObjVar2 on top of stack if not void (as if it <method invocation> were just run and returned that value)
     * goto restorePoint_<number>_continue;
     *
     * Case 3
     * ------
     * enterLocks(lockState);
     * continuation.addPending(methodState); // method state should be loaded from Continuation.saved
     *     // Load up enough of the stack to invoke the method. The invocation here needs to be wrapped in a try catch because
     *     // the original invocation was within a try catch block (at least 1, maybe more). If we do get a throwable, jump
     *     // back to the area where the original invocation was and rethrow it there so the proper catch handlers can
     *     // handle it (if the handler is for the expected throwable type).
     * restoreStackSuffix(stack, <number of items required for method invocation below>);
     * try {
     *     <method invocation>
     * } catch (throwable) {
     *     tempObjVar2 = throwable;
     *     restoreOperandStack(stack);
     *     restoreLocalsStack(localVars);
     *     goto restorePoint_<number>_rethrow;
     * }
     * if (continuation.getMode() == MODE_SAVING) {
     *     exitLocks(lockState);
     *     return <dummy>;
     * }
     *    // At this point the invocation happened successfully, so we want to save the invocation's result, restore this
     *    // method's state, and then put the result on top of the stack as if invocation just happened. We then jump in to
     *    // the method and continue running it from the instruction after the original invocation point.
     * tempObjVar2 = <method invocation>'s return value; // does nothing if ret type is void
     * restoreOperandStack(stack);
     * restoreLocalsStack(localVars);
     * place tempObjVar2 on top of stack if not void (as if it <method invocation> were just run and returned that value)
     * goto restorePoint_<number>_continue;
     */

    public Instrumenter() {}

    public byte[] Instrument(final byte[] raw) {
        final ClassReader classReader = new ClassReader(raw);
        ClassNode classNode = new CoreClassNode();
        classReader.accept(classNode, 0);

        classNode = StackReconstructor.reconstructStackMapFrames(classNode);

        /* TODO:
         * 1. Do instrumentation in stages:
         * 2. Evaluate instrumentation results
         *
         * Instrumentation stages:
         *  1. Find relevant methods calling Continuation#suspend()
         *  2. Filter methods by usage and dependent call structure with parent context
         *  3. Serialize existing coroutine structure and store as a file for restore and persistence
         *  4. Perform instrumentation:
         *    a. Create restore marker and early return before Continuation#suspend() call
         *    b. Create continuation marker and goto call to jump Continuation#suspend() call and continue
         *    c. Store method state
         *  5. Add versioning fields and convert class to serializable format
         */

        final ClassWriter classWriter = new CoreClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
        classNode.accept(classWriter);

        return classWriter.toByteArray();
    }
}
