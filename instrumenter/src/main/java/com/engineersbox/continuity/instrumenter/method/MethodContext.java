package com.engineersbox.continuity.instrumenter.method;

import com.engineersbox.continuity.instrumenter.stack.point.ContinuationPoint;

import java.util.List;
import java.util.stream.Collectors;

public record MethodContext(MethodSignature signature,
                            List<? extends ContinuationPoint> continuationPoints) {
    @Override
    public String toString() {
        return String.format(
                "%s.%s [%s]",
                signature.className(),
                signature.methodName(),
                continuationPoints.stream()
                        .map((final ContinuationPoint continuationPoint) -> String.format(
                                "%s$%s%s:%d",
                                continuationPoint.getInvokeInstruction().owner,
                                continuationPoint.getInvokeInstruction().name,
                                continuationPoint.getInvokeInstruction().desc,
                                continuationPoint.getLineNumber()
                        )).collect(Collectors.joining(", "))
        );
    }
}
