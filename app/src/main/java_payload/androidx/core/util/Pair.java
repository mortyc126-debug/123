/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.util;

import androidx.core.util.ObjectsCompat;

public class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F f, S s) {
        this.first = f;
        this.second = s;
    }

    public static <A, B> Pair<A, B> create(A a, B b) {
        return new Pair<A, B>(a, b);
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof Pair;
        boolean bl2 = false;
        if (!bl) {
            return false;
        }
        object = (Pair)object;
        bl = bl2;
        if (ObjectsCompat.equals(((Pair)object).first, this.first)) {
            bl = bl2;
            if (ObjectsCompat.equals(((Pair)object).second, this.second)) {
                bl = true;
            }
        }
        return bl;
    }

    public int hashCode() {
        F f = this.first;
        int n = 0;
        int n2 = f == null ? 0 : this.first.hashCode();
        if (this.second != null) {
            n = this.second.hashCode();
        }
        return n2 ^ n;
    }

    public String toString() {
        return "Pair{" + this.first + " " + this.second + "}";
    }
}

