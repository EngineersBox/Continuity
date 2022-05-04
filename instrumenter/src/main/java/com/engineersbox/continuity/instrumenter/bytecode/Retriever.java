package com.engineersbox.continuity.instrumenter.bytecode;

import com.engineersbox.continuity.instrumenter.method.MethodContext;
import com.engineersbox.continuity.instrumenter.stack.point.ContinuationPoint;

import java.util.List;

public class Retriever {

    @SuppressWarnings("unchecked")
    public static <T extends ContinuationPoint> T getContinuationPoint(final MethodContext methodContext,
                                                                       final int index,
                                                                       final Class<T> continuationPointClass) {
        if (methodContext == null) {
            throw new IllegalArgumentException("Method context cannot be null");
        } else if (continuationPointClass == null) {
            throw new IllegalArgumentException("Target continuation point class cannot be null");
        } else if (index < 0) {
            throw new IndexOutOfBoundsException("Index must be positive");
        }
        final List<? extends ContinuationPoint> points = methodContext.continuationPoints();
        if (index >= points.size()) {
            throw new IndexOutOfBoundsException(String.format(
                    "No continuation point at index %d",
                    index
            ));
        }
        final ContinuationPoint point = points.get(index);
        if (!continuationPointClass.isAssignableFrom(point.getClass())) {
            throw new IllegalStateException(String.format(
                    "Point was not of expected class: %s != %s",
                    continuationPointClass.getName(),
                    point.getClass().getName()
            ));
        }
        return (T) point;
    }

}
