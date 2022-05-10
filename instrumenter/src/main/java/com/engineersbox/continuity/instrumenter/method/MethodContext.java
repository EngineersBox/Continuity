package com.engineersbox.continuity.instrumenter.method;

import com.engineersbox.continuity.instrumenter.stack.ContinuityVariables;
import com.engineersbox.continuity.instrumenter.stack.point.ContinuationPoint;
import com.engineersbox.continuity.instrumenter.stack.storage.PrimitiveContainerStack;
import com.engineersbox.continuity.instrumenter.stack.storage.PrimitiveStack;
import com.engineersbox.continuity.instrumenter.stack.storage.VariableCache;

import java.util.List;

public record MethodContext(MethodSignature signature,
                            List<? extends ContinuationPoint> continuationPoints,
                            VariableCache cache,
                            PrimitiveStack LVA,
                            PrimitiveStack OS,
                            PrimitiveContainerStack containers,
                            ContinuityVariables continuityVariables) {

    @SuppressWarnings("unchecked")
    public <T extends ContinuationPoint> T getContinuationPointByClass(final int index,
                                                                       final Class<T> expectedType) {
        if (expectedType == null) {
            throw new IllegalArgumentException("Expected type cannot be null");
        } else if (index < 0) {
            throw new IndexOutOfBoundsException(index);
        }
        final List<? extends ContinuationPoint> points = this.continuationPoints();
        if (index >= points.size()) {
            throw new IndexOutOfBoundsException(index);
        }
        final ContinuationPoint point = points.get(index);
        if (!expectedType.isAssignableFrom(point.getClass())) {
            throw new ClassCastException(String.format(
                    "Continuation point was not of expected type: %s != %s",
                    point.getClass().getSimpleName(),
                    expectedType.getSimpleName()
            ));
        }
        return (T) point;
    }

}
