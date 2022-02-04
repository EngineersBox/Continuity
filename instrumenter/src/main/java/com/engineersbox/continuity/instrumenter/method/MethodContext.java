package com.engineersbox.continuity.instrumenter.method;

import com.engineersbox.continuity.instrumenter.stack.ContinuationPoint;
import com.engineersbox.continuity.instrumenter.stack.variable.PrimitiveStack;
import com.engineersbox.continuity.instrumenter.stack.variable.StackVariable;

import java.util.List;

public record MethodContext<T extends ContinuationPoint>(List<T> continuationPoints,
                                                         StackVariable continuationVar,
                                                         StackVariable methodStateVar,
                                                         PrimitiveStack LVA,
                                                         PrimitiveStack OS) {
}
