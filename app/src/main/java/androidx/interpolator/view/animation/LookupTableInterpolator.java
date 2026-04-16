/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 */
package androidx.interpolator.view.animation;

import android.view.animation.Interpolator;

abstract class LookupTableInterpolator
implements Interpolator {
    private final float mStepSize;
    private final float[] mValues;

    protected LookupTableInterpolator(float[] fArray) {
        this.mValues = fArray;
        this.mStepSize = 1.0f / (float)(this.mValues.length - 1);
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int n = Math.min((int)((float)(this.mValues.length - 1) * f), this.mValues.length - 2);
        f = (f - (float)n * this.mStepSize) / this.mStepSize;
        return this.mValues[n] + (this.mValues[n + 1] - this.mValues[n]) * f;
    }
}

