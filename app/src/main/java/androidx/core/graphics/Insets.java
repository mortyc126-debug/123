/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Insets
 *  android.graphics.Rect
 */
package androidx.core.graphics;

import android.graphics.Rect;

public final class Insets {
    public static final Insets NONE = new Insets(0, 0, 0, 0);
    public final int bottom;
    public final int left;
    public final int right;
    public final int top;

    private Insets(int n, int n2, int n3, int n4) {
        this.left = n;
        this.top = n2;
        this.right = n3;
        this.bottom = n4;
    }

    public static Insets add(Insets insets, Insets insets2) {
        return Insets.of(insets.left + insets2.left, insets.top + insets2.top, insets.right + insets2.right, insets.bottom + insets2.bottom);
    }

    public static Insets max(Insets insets, Insets insets2) {
        return Insets.of(Math.max(insets.left, insets2.left), Math.max(insets.top, insets2.top), Math.max(insets.right, insets2.right), Math.max(insets.bottom, insets2.bottom));
    }

    public static Insets min(Insets insets, Insets insets2) {
        return Insets.of(Math.min(insets.left, insets2.left), Math.min(insets.top, insets2.top), Math.min(insets.right, insets2.right), Math.min(insets.bottom, insets2.bottom));
    }

    public static Insets of(int n, int n2, int n3, int n4) {
        if (n == 0 && n2 == 0 && n3 == 0 && n4 == 0) {
            return NONE;
        }
        return new Insets(n, n2, n3, n4);
    }

    public static Insets of(Rect rect) {
        return Insets.of(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static Insets subtract(Insets insets, Insets insets2) {
        return Insets.of(insets.left - insets2.left, insets.top - insets2.top, insets.right - insets2.right, insets.bottom - insets2.bottom);
    }

    public static Insets toCompatInsets(android.graphics.Insets insets) {
        return Insets.of(insets.left, insets.top, insets.right, insets.bottom);
    }

    @Deprecated
    public static Insets wrap(android.graphics.Insets insets) {
        return Insets.toCompatInsets(insets);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && this.getClass() == object.getClass()) {
            object = (Insets)object;
            if (this.bottom != ((Insets)object).bottom) {
                return false;
            }
            if (this.left != ((Insets)object).left) {
                return false;
            }
            if (this.right != ((Insets)object).right) {
                return false;
            }
            return this.top == ((Insets)object).top;
        }
        return false;
    }

    public int hashCode() {
        return ((this.left * 31 + this.top) * 31 + this.right) * 31 + this.bottom;
    }

    public android.graphics.Insets toPlatformInsets() {
        return Api29Impl.of(this.left, this.top, this.right, this.bottom);
    }

    public String toString() {
        return "Insets{left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + '}';
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static android.graphics.Insets of(int n, int n2, int n3, int n4) {
            return android.graphics.Insets.of((int)n, (int)n2, (int)n3, (int)n4);
        }
    }
}

