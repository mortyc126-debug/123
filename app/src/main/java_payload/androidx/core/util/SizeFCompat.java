/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SizeF
 */
package androidx.core.util;

import android.util.SizeF;
import androidx.core.util.Preconditions;

public final class SizeFCompat {
    private final float mHeight;
    private final float mWidth;

    public SizeFCompat(float f, float f2) {
        this.mWidth = Preconditions.checkArgumentFinite(f, "width");
        this.mHeight = Preconditions.checkArgumentFinite(f2, "height");
    }

    public static SizeFCompat toSizeFCompat(SizeF sizeF) {
        return Api21Impl.toSizeFCompat(sizeF);
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (this == object) {
            return true;
        }
        if (!(object instanceof SizeFCompat)) {
            return false;
        }
        object = (SizeFCompat)object;
        if (((SizeFCompat)object).mWidth != this.mWidth || ((SizeFCompat)object).mHeight != this.mHeight) {
            bl = false;
        }
        return bl;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public float getWidth() {
        return this.mWidth;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.mWidth) ^ Float.floatToIntBits(this.mHeight);
    }

    public SizeF toSizeF() {
        return Api21Impl.toSizeF(this);
    }

    public String toString() {
        return this.mWidth + "x" + this.mHeight;
    }

    private static final class Api21Impl {
        private Api21Impl() {
        }

        static SizeF toSizeF(SizeFCompat sizeFCompat) {
            Preconditions.checkNotNull(sizeFCompat);
            return new SizeF(sizeFCompat.getWidth(), sizeFCompat.getHeight());
        }

        static SizeFCompat toSizeFCompat(SizeF sizeF) {
            Preconditions.checkNotNull(sizeF);
            return new SizeFCompat(sizeF.getWidth(), sizeF.getHeight());
        }
    }
}

