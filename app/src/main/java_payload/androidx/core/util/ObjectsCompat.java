/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.util;

import java.util.Objects;

public class ObjectsCompat {
    private ObjectsCompat() {
    }

    public static boolean equals(Object object, Object object2) {
        return Objects.equals(object, object2);
    }

    public static int hash(Object ... objectArray) {
        return Objects.hash(objectArray);
    }

    public static int hashCode(Object object) {
        int n = object != null ? object.hashCode() : 0;
        return n;
    }

    public static <T> T requireNonNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static <T> T requireNonNull(T t, String string2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(string2);
    }

    public static String toString(Object object, String string2) {
        object = object != null ? object.toString() : string2;
        return object;
    }
}

