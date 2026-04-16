/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 */
package androidx.core.util;

import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TypedValueCompat {
    private static final float INCHES_PER_MM = 0.03937008f;
    private static final float INCHES_PER_PT = 0.013888889f;

    private TypedValueCompat() {
    }

    public static float deriveDimension(int n, float f, DisplayMetrics displayMetrics) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.deriveDimension(n, f, displayMetrics);
        }
        switch (n) {
            default: {
                throw new IllegalArgumentException("Invalid unitToConvertTo " + n);
            }
            case 5: {
                if (displayMetrics.xdpi == 0.0f) {
                    return 0.0f;
                }
                return f / displayMetrics.xdpi / 0.03937008f;
            }
            case 4: {
                if (displayMetrics.xdpi == 0.0f) {
                    return 0.0f;
                }
                return f / displayMetrics.xdpi;
            }
            case 3: {
                if (displayMetrics.xdpi == 0.0f) {
                    return 0.0f;
                }
                return f / displayMetrics.xdpi / 0.013888889f;
            }
            case 2: {
                if (displayMetrics.scaledDensity == 0.0f) {
                    return 0.0f;
                }
                return f / displayMetrics.scaledDensity;
            }
            case 1: {
                if (displayMetrics.density == 0.0f) {
                    return 0.0f;
                }
                return f / displayMetrics.density;
            }
            case 0: 
        }
        return f;
    }

    public static float dpToPx(float f, DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension((int)1, (float)f, (DisplayMetrics)displayMetrics);
    }

    public static int getUnitFromComplexDimension(int n) {
        return n >> 0 & 0xF;
    }

    public static float pxToDp(float f, DisplayMetrics displayMetrics) {
        return TypedValueCompat.deriveDimension(1, f, displayMetrics);
    }

    public static float pxToSp(float f, DisplayMetrics displayMetrics) {
        return TypedValueCompat.deriveDimension(2, f, displayMetrics);
    }

    public static float spToPx(float f, DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension((int)2, (float)f, (DisplayMetrics)displayMetrics);
    }

    private static class Api34Impl {
        private Api34Impl() {
        }

        public static float deriveDimension(int n, float f, DisplayMetrics displayMetrics) {
            return TypedValue.deriveDimension((int)n, (float)f, (DisplayMetrics)displayMetrics);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface ComplexDimensionUnit {
    }
}

