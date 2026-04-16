/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.math;

public class MathUtils {
    private MathUtils() {
    }

    public static int addExact(int n, int n2) {
        int n3 = n + n2;
        int n4 = 1;
        int n5 = n >= 0 ? 1 : 0;
        if (n5 == (n2 = n2 >= 0 ? 1 : 0) && (n = n >= 0 ? 1 : 0) != (n2 = n3 >= 0 ? n4 : 0)) {
            throw new ArithmeticException("integer overflow");
        }
        return n3;
    }

    public static long addExact(long l, long l2) {
        boolean bl;
        long l3 = l + l2;
        boolean bl2 = true;
        boolean bl3 = l >= 0L;
        if (bl3 == (bl = l2 >= 0L) && (bl3 = l >= 0L) != (bl = l3 >= 0L ? bl2 : false)) {
            throw new ArithmeticException("integer overflow");
        }
        return l3;
    }

    public static double clamp(double d, double d2, double d3) {
        if (d < d2) {
            return d2;
        }
        if (d > d3) {
            return d3;
        }
        return d;
    }

    public static float clamp(float f, float f2, float f3) {
        if (f < f2) {
            return f2;
        }
        if (f > f3) {
            return f3;
        }
        return f;
    }

    public static int clamp(int n, int n2, int n3) {
        if (n < n2) {
            return n2;
        }
        if (n > n3) {
            return n3;
        }
        return n;
    }

    public static long clamp(long l, long l2, long l3) {
        if (l < l2) {
            return l2;
        }
        if (l > l3) {
            return l3;
        }
        return l;
    }

    public static int decrementExact(int n) {
        if (n != Integer.MIN_VALUE) {
            return n - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long decrementExact(long l) {
        if (l != Long.MIN_VALUE) {
            return l - 1L;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int incrementExact(int n) {
        if (n != Integer.MAX_VALUE) {
            return n + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long incrementExact(long l) {
        if (l != Long.MAX_VALUE) {
            return 1L + l;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int multiplyExact(int n, int n2) {
        int n3 = n * n2;
        if (n != 0 && n2 != 0 && (n3 / n != n2 || n3 / n2 != n)) {
            throw new ArithmeticException("integer overflow");
        }
        return n3;
    }

    public static long multiplyExact(long l, long l2) {
        long l3 = l * l2;
        if (l != 0L && l2 != 0L && (l3 / l != l2 || l3 / l2 != l)) {
            throw new ArithmeticException("integer overflow");
        }
        return l3;
    }

    public static int negateExact(int n) {
        if (n != Integer.MIN_VALUE) {
            return -n;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long negateExact(long l) {
        if (l != Long.MIN_VALUE) {
            return -l;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int subtractExact(int n, int n2) {
        int n3 = n - n2;
        int n4 = 1;
        int n5 = n < 0 ? 1 : 0;
        if (n5 != (n2 = n2 < 0 ? 1 : 0) && (n = n < 0 ? 1 : 0) != (n2 = n3 < 0 ? n4 : 0)) {
            throw new ArithmeticException("integer overflow");
        }
        return n3;
    }

    public static long subtractExact(long l, long l2) {
        boolean bl;
        long l3 = l - l2;
        boolean bl2 = true;
        boolean bl3 = l < 0L;
        if (bl3 != (bl = l2 < 0L) && (bl3 = l < 0L) != (bl = l3 < 0L ? bl2 : false)) {
            throw new ArithmeticException("integer overflow");
        }
        return l3;
    }

    public static int toIntExact(long l) {
        if (l <= Integer.MAX_VALUE && l >= Integer.MIN_VALUE) {
            return (int)l;
        }
        throw new ArithmeticException("integer overflow");
    }
}

