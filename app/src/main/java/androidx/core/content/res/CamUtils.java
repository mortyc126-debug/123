/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 */
package androidx.core.content.res;

import android.graphics.Color;
import androidx.core.graphics.ColorUtils;

final class CamUtils {
    static final float[][] CAM16RGB_TO_XYZ;
    static final float[][] SRGB_TO_XYZ;
    static final float[] WHITE_POINT_D65;
    static final float[][] XYZ_TO_CAM16RGB;

    static {
        XYZ_TO_CAM16RGB = new float[][]{{0.401288f, 0.650173f, -0.051461f}, {-0.250268f, 1.204414f, 0.045854f}, {-0.002079f, 0.048952f, 0.953127f}};
        CAM16RGB_TO_XYZ = new float[][]{{1.8620678f, -1.0112547f, 0.14918678f}, {0.38752654f, 0.62144744f, -0.00897398f}, {-0.0158415f, -0.03412294f, 1.0499644f}};
        WHITE_POINT_D65 = new float[]{95.047f, 100.0f, 108.883f};
        SRGB_TO_XYZ = new float[][]{{0.41233894f, 0.35762063f, 0.18051042f}, {0.2126f, 0.7152f, 0.0722f}, {0.01932141f, 0.11916382f, 0.9503448f}};
    }

    private CamUtils() {
    }

    static int intFromLStar(float f) {
        if (f < 1.0f) {
            return -16777216;
        }
        if (f > 99.0f) {
            return -1;
        }
        float f2 = (f + 16.0f) / 116.0f;
        boolean bl = f > 8.0f;
        f = bl ? f2 * f2 * f2 : (f /= 903.2963f);
        bl = f2 * f2 * f2 > 0.008856452f;
        float f3 = bl ? f2 * f2 * f2 : (f2 * 116.0f - 16.0f) / 903.2963f;
        f2 = bl ? f2 * f2 * f2 : (116.0f * f2 - 16.0f) / 903.2963f;
        return ColorUtils.XYZToColor(WHITE_POINT_D65[0] * f3, WHITE_POINT_D65[1] * f, WHITE_POINT_D65[2] * f2);
    }

    static float lStarFromInt(int n) {
        return CamUtils.lStarFromY(CamUtils.yFromInt(n));
    }

    static float lStarFromY(float f) {
        if ((f /= 100.0f) <= 0.008856452f) {
            return 903.2963f * f;
        }
        return 116.0f * (float)Math.cbrt(f) - 16.0f;
    }

    static float lerp(float f, float f2, float f3) {
        return (f2 - f) * f3 + f;
    }

    static float linearized(int n) {
        float f = (float)n / 255.0f;
        if (f <= 0.04045f) {
            return f / 12.92f * 100.0f;
        }
        return (float)Math.pow((0.055f + f) / 1.055f, 2.4f) * 100.0f;
    }

    static void xyzFromInt(int n, float[] fArray) {
        float f = CamUtils.linearized(Color.red((int)n));
        float f2 = CamUtils.linearized(Color.green((int)n));
        float f3 = CamUtils.linearized(Color.blue((int)n));
        float[][] fArray2 = SRGB_TO_XYZ;
        fArray[0] = fArray2[0][0] * f + fArray2[0][1] * f2 + fArray2[0][2] * f3;
        fArray[1] = fArray2[1][0] * f + fArray2[1][1] * f2 + fArray2[1][2] * f3;
        fArray[2] = fArray2[2][0] * f + fArray2[2][1] * f2 + fArray2[2][2] * f3;
    }

    static float yFromInt(int n) {
        float f = CamUtils.linearized(Color.red((int)n));
        float f2 = CamUtils.linearized(Color.green((int)n));
        float f3 = CamUtils.linearized(Color.blue((int)n));
        float[][] fArray = SRGB_TO_XYZ;
        return fArray[1][0] * f + fArray[1][1] * f2 + fArray[1][2] * f3;
    }

    static float yFromLStar(float f) {
        if (f > 8.0f) {
            return (float)Math.pow(((double)f + 16.0) / 116.0, 3.0) * 100.0f;
        }
        return f / 903.2963f * 100.0f;
    }
}

