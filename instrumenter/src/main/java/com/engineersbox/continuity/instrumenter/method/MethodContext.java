package com.engineersbox.continuity.instrumenter.method;

import com.engineersbox.continuity.instrumenter.stack.ContinuityVariables;
import com.engineersbox.continuity.instrumenter.stack.point.ContinuationPoint;
import com.engineersbox.continuity.instrumenter.stack.storage.PrimitiveContainerStack;
import com.engineersbox.continuity.instrumenter.stack.storage.PrimitiveStack;
import com.engineersbox.continuity.instrumenter.stack.storage.VariableCache;

import java.util.List;
import java.util.stream.Collectors;

public record MethodContext(MethodSignature signature,
                            List<? extends ContinuationPoint> continuationPoints,
                            VariableCache cache,
                            PrimitiveStack LVA,
                            PrimitiveStack OS,
                            PrimitiveContainerStack containers,
                            ContinuityVariables continuityVariables) {
}
