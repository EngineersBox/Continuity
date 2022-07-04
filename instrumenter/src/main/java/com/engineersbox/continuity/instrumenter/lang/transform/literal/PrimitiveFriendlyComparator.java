package com.engineersbox.continuity.instrumenter.lang.transform.literal;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class PrimitiveFriendlyComparator {

    private PrimitiveFriendlyComparator() {}

    public static int compareObjects(final Object a, final Object b) {
        if (a == null) {
            return b != null ? -1 : 0;
        } else if (b == null) {
            return 1;
        } else if (!(a instanceof Boolean) && !(a instanceof Character) && !(a instanceof Number)) {
            throw new IllegalArgumentException(String.format(
                    "Cannot compare object of type \"%s\"",
                    a.getClass().getCanonicalName()
            ));
        } else if (!(b instanceof Boolean) && !(b instanceof Character) && !(b instanceof Number)) {
            throw new IllegalArgumentException(String.format(
                    "Cannot compare object of type \"%s\"",
                    a.getClass().getCanonicalName()
            ));
        }
        final Number numberA;
        final Number numberB;
        if (a instanceof Boolean boolA) {
            numberA = Boolean.TRUE.equals(boolA) ? 1 : 0;
        } else if (a instanceof Character charA) {
            numberA = (int) charA;
        } else {
            numberA = (Number) a;
        }
        if (b instanceof Boolean boolB) {
            numberB = Boolean.TRUE.equals(boolB) ? 1 : 0;
        } else if (b instanceof Character charB) {
            numberB = (int) charB;
        } else {
            numberB = (Number) b;
        }
        return compare(numberA, numberB);
    }

    private static int compare(final Number a, final Number b) {
        if (isSpecial(a) || isSpecial(b)) {
            return Double.compare(a.doubleValue(), b.doubleValue());
        }
        return toBigDecimal(a).compareTo(toBigDecimal(b));
    }

    private static boolean isSpecial(final Number number) {
        final boolean specialDouble = number instanceof Double doubleNumber
                && (Double.isNaN(doubleNumber) || Double.isInfinite(doubleNumber));
        final boolean specialFloat = number instanceof Float floatNumber
                && (Float.isNaN(floatNumber) || Float.isInfinite(floatNumber));
        return specialDouble || specialFloat;
    }

    private static BigDecimal toBigDecimal(final Number number) {
        if (number instanceof BigDecimal bigDecimal) {
            return bigDecimal;
        } else if (number instanceof BigInteger bigInteger) {
            return new BigDecimal(bigInteger);
        } else if (number instanceof Byte || number instanceof Short || number instanceof Integer || number instanceof Long) {
            return new BigDecimal(number.longValue());
        } else if (number instanceof Float || number instanceof Double) {
            return BigDecimal.valueOf(number.doubleValue());
        }
        try {
            return new BigDecimal(number.toString());
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException(String.format(
                    "Cannot convert Number \"%s\" to comparable value",
                    number
            ));
        }
    }
}
