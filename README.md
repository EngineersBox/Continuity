# Continuity

A Java state persistence/continuation/checkpointing library with runtime JVM state reification

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
