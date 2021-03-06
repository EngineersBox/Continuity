# Continuity

A Java state persistence/continuation/checkpointing library with runtime JVM state reification.

### Attribution

This implementation is based around OffByNull's Coroutines library <https://github.com/offbynull/coroutines>. I'm aiming
to attempt at providing support for lambdas via `INVOKEDYNAMIC` calls which are not supported in the coroutines library.

## Instrumentation Stages

* Method location
* Method introspection
* Serialization of .continuity files
* Bytecode injection
* Serialization data creation

## Stage 1: Method Location

Find methods to instrument in each ClassNode. Ignore classes that are interfaces since they possess no body or direct callsite.
Check if the class has already been instrumented, if it has, then ensure the marker is formatted correctly and then skip class 
if marker valid.

Find methods that have a Continuation instance passed as a parameter. Store these in the stage context and return;

## Stage 2: Method Introspection

Using the method instructions, find the call points for continuation and suspend points. Then Get method frames and
figure out what vars need to be allocated in order to store the LVA and OS stack vars. Also determine if there are
return values that need to be cached. Once these have been determined, allocate stack slots for them to be put into
during the bytecode injection stage. Next, create the variables for the Continuation parameter and the method state.

## Stage 3: Serialization of .continuity Files

TODO

## Stage 4: Bytecode Injection

See the `doc` directory for details on how state management bytecode is implemented and injected into the methods.

## Stage 5: Serialization Data Creation

## Continuity Lang

An intermediate language is used to create the bytecode definitions. The language is compiled into
Java, as a set of instructions loaded through `InsnBuilder`. All native functions in the `continuity`
language are direct static methods on `InsnBuilder`. Any function invocations that are from reference
chains such as `OSRestoreOperations.loadContainerVars(...)` are namespaced to invoke actual Java
classes.

This is not designed to be a full language, only a meta language as an intermediate transform. As such
the namespacing and available context is bound by a `HashMap` provided as context to the parser. Theoretically,
you can do anything you want in the language but it would require extensive modification of the parser
and additional context that would handle state in Java as opposed to the language.

Files are expected to use the `cib` extension, indicating `Continuity Intermediate Bytecode`, an example
of this is the following:

```cib
// File: example.cib
// Declare some vars that will be provided to the parser as translation context
ctx {
    contArgVar;
    example;
    other;
};

// Reference an external class in the JVM via ClassLoader
ext com.engineersbox.continuity.core.annotation.BytecodeInternal $ Accessor;

let testString: str = "string";
// Declare an array variable with an initialiser
let arrayVariable: int32[] = {
    434,
    8234532
};

/**
 * Declare a function, essentially acting as a macro
 */
fn test() {
    // Declare a scoped variable
    let test: Object = std::loadVar(ctx::contArgVar);
    // Reference a scoped variable
    let.test;
    std::loadVar(ctx::contArgVar);
};

/*
 * Invoke an external context driven function via a reference chain,
 * the OSRestoreOperations reference is expected to loaded via ext <path>;
 * or ext { ... <path>; }.
 */
std::call(ext::Accessor->getMethod(ctx::example->get().replace('$', '.')), std::loadVar(ctx::contArgVar));
std::combineIf(
    // Evaluate boolean expressions
    ctx::example->get().contains("$") && (5.3 >=  let.arrayVariable[0] ^ let.testString == "string"),
    // Invoke a declared function
    fn.test()
);
// If statement evaluation
if (!ctx::example->get().contains("$") && (5.3 >= let.arrayVariable[1] ^ "string" == "string")) {
    std::loadVar(ctx::contArgVar);
} else if (ctx::other == null) {
    std::lineNumber(ctx::other);
} else if (ctx::example->get().contains("$")) {
    fn.test();
    std::lineNumber(ctx::other);
} else {
    std::call(ext::Accessor->getMethod(ctx::example->get().replace('$', '.')), std::loadVar(ctx::contArgVar));
    std::debug("Unknown state");
};
```

Which generates the following parse tree:

<img src="doc/exampleParseTree.png" alt="Example Parse Tree">