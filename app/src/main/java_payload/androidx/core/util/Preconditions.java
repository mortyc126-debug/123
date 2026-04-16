/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package androidx.core.util;

import android.text.TextUtils;
import java.util.Locale;

public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean bl) {
        if (bl) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void checkArgument(boolean bl, Object object) {
        if (bl) {
            return;
        }
        throw new IllegalArgumentException(String.valueOf(object));
    }

    public static void checkArgument(boolean bl, String string2, Object ... objectArray) {
        if (bl) {
            return;
        }
        throw new IllegalArgumentException(String.format(string2, objectArray));
    }

    public static float checkArgumentFinite(float f, String string2) {
        if (!Float.isNaN(f)) {
            if (!Float.isInfinite(f)) {
                return f;
            }
            throw new IllegalArgumentException(string2 + " must not be infinite");
        }
        throw new IllegalArgumentException(string2 + " must not be NaN");
    }

    public static double checkArgumentInRange(double d, double d2, double d3, String string2) {
        if (!(d < d2)) {
            if (!(d > d3)) {
                return d;
            }
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", string2, d2, d3));
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", string2, d2, d3));
    }

    public static float checkArgumentInRange(float f, float f2, float f3, String string2) {
        if (!(f < f2)) {
            if (!(f > f3)) {
                return f;
            }
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", string2, Float.valueOf(f2), Float.valueOf(f3)));
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", string2, Float.valueOf(f2), Float.valueOf(f3)));
    }

    public static int checkArgumentInRange(int n, int n2, int n3, String string2) {
        if (n >= n2) {
            if (n <= n3) {
                return n;
            }
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", string2, n2, n3));
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", string2, n2, n3));
    }

    public static long checkArgumentInRange(long l, long l2, long l3, String string2) {
        if (l >= l2) {
            if (l <= l3) {
                return l;
            }
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", string2, l2, l3));
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", string2, l2, l3));
    }

    public static int checkArgumentNonnegative(int n) {
        if (n >= 0) {
            return n;
        }
        throw new IllegalArgumentException();
    }

    public static int checkArgumentNonnegative(int n, String string2) {
        if (n >= 0) {
            return n;
        }
        throw new IllegalArgumentException(string2);
    }

    public static int checkFlagsArgument(int n, int n2) {
        if ((n & n2) == n) {
            return n;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(n) + ", but only 0x" + Integer.toHexString(n2) + " are allowed");
    }

    public static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static <T> T checkNotNull(T t, Object object) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(object));
    }

    public static void checkState(boolean bl) {
        Preconditions.checkState(bl, null);
    }

    public static void checkState(boolean bl, String string2) {
        if (bl) {
            return;
        }
        throw new IllegalStateException(string2);
    }

    public static <T extends CharSequence> T checkStringNotEmpty(T t) {
        if (!TextUtils.isEmpty(t)) {
            return t;
        }
        throw new IllegalArgumentException();
    }

    public static <T extends CharSequence> T checkStringNotEmpty(T t, Object object) {
        if (!TextUtils.isEmpty(t)) {
            return t;
        }
        throw new IllegalArgumentException(String.valueOf(object));
    }

    public static <T extends CharSequence> T checkStringNotEmpty(T t, String string2, Object ... objectArray) {
        if (!TextUtils.isEmpty(t)) {
            return t;
        }
        throw new IllegalArgumentException(String.format(string2, objectArray));
    }
}

