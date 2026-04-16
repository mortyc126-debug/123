/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.content.res;

import androidx.core.content.res.CamUtils;

final class ViewingConditions {
    static final ViewingConditions DEFAULT = ViewingConditions.make(CamUtils.WHITE_POINT_D65, (float)((double)CamUtils.yFromLStar(50.0f) * 63.66197723675813 / 100.0), 50.0f, 2.0f, false);
    private final float mAw;
    private final float mC;
    private final float mFl;
    private final float mFlRoot;
    private final float mN;
    private final float mNbb;
    private final float mNc;
    private final float mNcb;
    private final float[] mRgbD;
    private final float mZ;

    private ViewingConditions(float f, float f2, float f3, float f4, float f5, float f6, float[] fArray, float f7, float f8, float f9) {
        this.mN = f;
        this.mAw = f2;
        this.mNbb = f3;
        this.mNcb = f4;
        this.mC = f5;
        this.mNc = f6;
        this.mRgbD = fArray;
        this.mFl = f7;
        this.mFlRoot = f8;
        this.mZ = f9;
    }

    static ViewingConditions make(float[] fArray, float f, float f2, float f3, boolean bl) {
        Object object = CamUtils.XYZ_TO_CAM16RGB;
        float f4 = fArray[0] * object[0][0] + fArray[1] * object[0][1] + fArray[2] * object[0][2];
        float f5 = fArray[0] * object[1][0] + fArray[1] * object[1][1] + fArray[2] * object[1][2];
        float f6 = fArray[0] * object[2][0] + fArray[1] * object[2][1] + fArray[2] * object[2][2];
        float f7 = f3 / 10.0f + 0.8f;
        float f8 = (double)f7 >= 0.9 ? CamUtils.lerp(0.59f, 0.69f, (f7 - 0.9f) * 10.0f) : CamUtils.lerp(0.525f, 0.59f, (f7 - 0.8f) * 10.0f);
        f3 = bl ? 1.0f : (1.0f - (float)Math.exp((-f - 42.0f) / 92.0f) * 0.2777778f) * f7;
        if ((double)f3 > 1.0) {
            f3 = 1.0f;
        } else if ((double)f3 < 0.0) {
            f3 = 0.0f;
        }
        object = new float[3];
        object[0] = (float[])(100.0f / f4 * f3 + 1.0f - f3);
        object[1] = (float[])(100.0f / f5 * f3 + 1.0f - f3);
        object[2] = (float[])(100.0f / f6 * f3 + 1.0f - f3);
        f3 = 1.0f / (5.0f * f + 1.0f);
        f3 = f3 * f3 * f3 * f3;
        float f9 = 1.0f - f3;
        f = f3 * f + 0.1f * f9 * f9 * (float)Math.cbrt((double)f * 5.0);
        f2 = CamUtils.yFromLStar(f2) / fArray[1];
        f3 = (float)Math.sqrt(f2);
        f9 = 0.725f / (float)Math.pow(f2, 0.2);
        fArray = new float[]{(float)Math.pow((double)(object[0] * f * f4) / 100.0, 0.42), (float)Math.pow((double)(object[1] * f * f5) / 100.0, 0.42), (float)Math.pow((double)(object[2] * f * f6) / 100.0, 0.42)};
        float[] fArray2 = new float[]{fArray[0] * 400.0f / (fArray[0] + 27.13f), fArray[1] * 400.0f / (fArray[1] + 27.13f), fArray[2] * 400.0f / (fArray[2] + 27.13f)};
        return new ViewingConditions(f2, (fArray2[0] * 2.0f + fArray2[1] + fArray2[2] * 0.05f) * f9, f9, f9, f8, f7, (float[])object, f, (float)Math.pow(f, 0.25), f3 + 1.48f);
    }

    float getAw() {
        return this.mAw;
    }

    float getC() {
        return this.mC;
    }

    float getFl() {
        return this.mFl;
    }

    float getFlRoot() {
        return this.mFlRoot;
    }

    float getN() {
        return this.mN;
    }

    float getNbb() {
        return this.mNbb;
    }

    float getNc() {
        return this.mNc;
    }

    float getNcb() {
        return this.mNcb;
    }

    float[] getRgbD() {
        return this.mRgbD;
    }

    float getZ() {
        return this.mZ;
    }
}

