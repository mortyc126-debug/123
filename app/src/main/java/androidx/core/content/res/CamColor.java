/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.content.res;

import androidx.core.content.res.CamUtils;
import androidx.core.content.res.ViewingConditions;
import androidx.core.graphics.ColorUtils;

public class CamColor {
    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    private static final float DE_MAX = 1.0f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private final float mAstar;
    private final float mBstar;
    private final float mChroma;
    private final float mHue;
    private final float mJ;
    private final float mJstar;
    private final float mM;
    private final float mQ;
    private final float mS;

    CamColor(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.mHue = f;
        this.mChroma = f2;
        this.mJ = f3;
        this.mQ = f4;
        this.mM = f5;
        this.mS = f6;
        this.mJstar = f7;
        this.mAstar = f8;
        this.mBstar = f9;
    }

    private static CamColor findCamByJ(float f, float f2, float f3) {
        CamColor camColor;
        float f4 = 0.0f;
        float f5 = 100.0f;
        float f6 = 1000.0f;
        float f7 = 1000.0f;
        CamColor camColor2 = null;
        while (true) {
            camColor = camColor2;
            if (!(Math.abs(f4 - f5) > 0.01f)) break;
            float f8 = f4 + (f5 - f4) / 2.0f;
            int n = CamColor.fromJch(f8, f2, f).viewedInSrgb();
            float f9 = CamUtils.lStarFromInt(n);
            float f10 = Math.abs(f3 - f9);
            float f11 = f6;
            float f12 = f7;
            camColor = camColor2;
            if (f10 < 0.2f) {
                CamColor camColor3 = CamColor.fromColor(n);
                float f13 = camColor3.distance(CamColor.fromJch(camColor3.getJ(), camColor3.getChroma(), f));
                f11 = f6;
                f12 = f7;
                camColor = camColor2;
                if (f13 <= 1.0f) {
                    f11 = f10;
                    f12 = f13;
                    camColor = camColor3;
                }
            }
            if (f11 == 0.0f && f12 == 0.0f) break;
            if (f9 < f3) {
                f4 = f8;
            } else {
                f5 = f8;
            }
            f6 = f11;
            f7 = f12;
            camColor2 = camColor;
        }
        return camColor;
    }

    static CamColor fromColor(int n) {
        float[] fArray = new float[7];
        float[] fArray2 = new float[3];
        CamColor.fromColorInViewingConditions(n, ViewingConditions.DEFAULT, fArray, fArray2);
        return new CamColor(fArray2[0], fArray2[1], fArray[0], fArray[1], fArray[2], fArray[3], fArray[4], fArray[5], fArray[6]);
    }

    static void fromColorInViewingConditions(int n, ViewingConditions viewingConditions, float[] fArray, float[] fArray2) {
        CamUtils.xyzFromInt(n, fArray2);
        float[][] fArray3 = CamUtils.XYZ_TO_CAM16RGB;
        float f = fArray2[0];
        float f2 = fArray3[0][0];
        float f3 = fArray2[1];
        float f4 = fArray3[0][1];
        float f5 = fArray2[2];
        float f6 = fArray3[0][2];
        float f7 = fArray2[0];
        float f8 = fArray3[1][0];
        float f9 = fArray2[1];
        float f10 = fArray3[1][1];
        float f11 = fArray2[2];
        float f12 = fArray3[1][2];
        float f13 = fArray2[0];
        float f14 = fArray3[2][0];
        float f15 = fArray2[1];
        float f16 = fArray3[2][1];
        float f17 = fArray2[2];
        float f18 = fArray3[2][2];
        f2 = viewingConditions.getRgbD()[0] * (f * f2 + f3 * f4 + f5 * f6);
        f9 = viewingConditions.getRgbD()[1] * (f7 * f8 + f9 * f10 + f11 * f12);
        f17 = viewingConditions.getRgbD()[2] * (f13 * f14 + f15 * f16 + f17 * f18);
        f16 = (float)Math.pow((double)(viewingConditions.getFl() * Math.abs(f2)) / 100.0, 0.42);
        f13 = (float)Math.pow((double)(viewingConditions.getFl() * Math.abs(f9)) / 100.0, 0.42);
        f15 = (float)Math.pow((double)(viewingConditions.getFl() * Math.abs(f17)) / 100.0, 0.42);
        f16 = Math.signum(f2) * 400.0f * f16 / (f16 + 27.13f);
        f13 = Math.signum(f9) * 400.0f * f13 / (f13 + 27.13f);
        f17 = Math.signum(f17) * 400.0f * f15 / (27.13f + f15);
        f12 = (float)((double)f16 * 11.0 + (double)f13 * -12.0 + (double)f17) / 11.0f;
        f11 = (float)((double)(f16 + f13) - (double)f17 * 2.0) / 9.0f;
        f8 = (f16 * 20.0f + f13 * 20.0f + 21.0f * f17) / 20.0f;
        f17 = (40.0f * f16 + f13 * 20.0f + f17) / 20.0f;
        f16 = (float)Math.atan2(f11, f12) * 180.0f / (float)Math.PI;
        if (f16 < 0.0f) {
            f16 += 360.0f;
        } else if (f16 >= 360.0f) {
            f16 -= 360.0f;
        }
        f14 = f16 * (float)Math.PI / 180.0f;
        f7 = (float)Math.pow(viewingConditions.getNbb() * f17 / viewingConditions.getAw(), viewingConditions.getC() * viewingConditions.getZ()) * 100.0f;
        f18 = 4.0f / viewingConditions.getC();
        f13 = (float)Math.sqrt(f7 / 100.0f);
        f15 = viewingConditions.getAw();
        f9 = viewingConditions.getFlRoot();
        f17 = (double)f16 < 20.14 ? f16 + 360.0f : f16;
        f17 = (float)(Math.cos((double)f17 * Math.PI / 180.0 + 2.0) + 3.8);
        f2 = viewingConditions.getNc();
        f10 = viewingConditions.getNcb();
        f17 = (float)Math.sqrt(f12 * f12 + f11 * f11) * (3846.1538f * (f17 * 0.25f) * f2 * f10) / (0.305f + f8);
        f12 = (float)Math.pow(1.64 - Math.pow(0.29, viewingConditions.getN()), 0.73) * (float)Math.pow(f17, 0.9);
        f8 = (float)Math.sqrt((double)f7 / 100.0) * f12;
        f17 = viewingConditions.getFlRoot() * f8;
        f12 = (float)Math.sqrt(viewingConditions.getC() * f12 / (viewingConditions.getAw() + 4.0f));
        f2 = 1.7f * f7 / (0.007f * f7 + 1.0f);
        f10 = (float)Math.log(0.0228f * f17 + 1.0f) * 43.85965f;
        f11 = (float)Math.cos(f14);
        f14 = (float)Math.sin(f14);
        fArray2[0] = f16;
        fArray2[1] = f8;
        if (fArray != null) {
            fArray[0] = f7;
            fArray[1] = f18 * f13 * (f15 + 4.0f) * f9;
            fArray[2] = f17;
            fArray[3] = f12 * 50.0f;
            fArray[4] = f2;
            fArray[5] = f11 * f10;
            fArray[6] = f14 * f10;
        }
    }

    private static CamColor fromJch(float f, float f2, float f3) {
        return CamColor.fromJchInFrame(f, f2, f3, ViewingConditions.DEFAULT);
    }

    private static CamColor fromJchInFrame(float f, float f2, float f3, ViewingConditions viewingConditions) {
        float f4 = 4.0f / viewingConditions.getC();
        float f5 = (float)Math.sqrt((double)f / 100.0);
        float f6 = viewingConditions.getAw();
        float f7 = viewingConditions.getFlRoot();
        float f8 = f2 * viewingConditions.getFlRoot();
        float f9 = f2 / (float)Math.sqrt((double)f / 100.0);
        float f10 = (float)Math.sqrt(viewingConditions.getC() * f9 / (viewingConditions.getAw() + 4.0f));
        float f11 = (float)Math.PI * f3 / 180.0f;
        float f12 = 1.7f * f / (0.007f * f + 1.0f);
        f9 = (float)Math.log((double)f8 * 0.0228 + 1.0) * 43.85965f;
        return new CamColor(f3, f2, f, f4 * f5 * (f6 + 4.0f) * f7, f8, f10 * 50.0f, f12, f9 * (float)Math.cos(f11), f9 * (float)Math.sin(f11));
    }

    public static void getM3HCTfromColor(int n, float[] fArray) {
        CamColor.fromColorInViewingConditions(n, ViewingConditions.DEFAULT, null, fArray);
        fArray[2] = CamUtils.lStarFromInt(n);
    }

    public static int toColor(float f, float f2, float f3) {
        return CamColor.toColor(f, f2, f3, ViewingConditions.DEFAULT);
    }

    static int toColor(float f, float f2, float f3, ViewingConditions viewingConditions) {
        if (!((double)f2 < 1.0 || (double)Math.round(f3) <= 0.0 || (double)Math.round(f3) >= 100.0)) {
            float f4 = 0.0f;
            if (!(f < 0.0f)) {
                f4 = Math.min(360.0f, f);
            }
            float f5 = f2;
            f = f2;
            f2 = 0.0f;
            boolean bl = true;
            CamColor camColor = null;
            while (Math.abs(f2 - f5) >= 0.4f) {
                CamColor camColor2 = CamColor.findCamByJ(f4, f, f3);
                if (bl) {
                    if (camColor2 != null) {
                        return camColor2.viewed(viewingConditions);
                    }
                    bl = false;
                    f = f2 + (f5 - f2) / 2.0f;
                    continue;
                }
                if (camColor2 == null) {
                    f5 = f;
                } else {
                    camColor = camColor2;
                    f2 = f;
                }
                f = f2 + (f5 - f2) / 2.0f;
            }
            if (camColor == null) {
                return CamUtils.intFromLStar(f3);
            }
            return camColor.viewed(viewingConditions);
        }
        return CamUtils.intFromLStar(f3);
    }

    float distance(CamColor camColor) {
        float f = this.getJStar() - camColor.getJStar();
        float f2 = this.getAStar() - camColor.getAStar();
        float f3 = this.getBStar() - camColor.getBStar();
        return (float)(Math.pow(Math.sqrt(f * f + f2 * f2 + f3 * f3), 0.63) * 1.41);
    }

    float getAStar() {
        return this.mAstar;
    }

    float getBStar() {
        return this.mBstar;
    }

    float getChroma() {
        return this.mChroma;
    }

    float getHue() {
        return this.mHue;
    }

    float getJ() {
        return this.mJ;
    }

    float getJStar() {
        return this.mJstar;
    }

    float getM() {
        return this.mM;
    }

    float getQ() {
        return this.mQ;
    }

    float getS() {
        return this.mS;
    }

    int viewed(ViewingConditions object) {
        float f = (double)this.getChroma() != 0.0 && (double)this.getJ() != 0.0 ? this.getChroma() / (float)Math.sqrt((double)this.getJ() / 100.0) : 0.0f;
        float f2 = (float)Math.pow((double)f / Math.pow(1.64 - Math.pow(0.29, ((ViewingConditions)object).getN()), 0.73), 1.1111111111111112);
        Object object2 = this.getHue() * (float)Math.PI / 180.0f;
        Object object3 = (float)(Math.cos((double)object2 + 2.0) + 3.8);
        Object object4 = ((ViewingConditions)object).getAw();
        f = (float)Math.pow((double)this.getJ() / 100.0, 1.0 / (double)((ViewingConditions)object).getC() / (double)((ViewingConditions)object).getZ());
        float f3 = ((ViewingConditions)object).getNc();
        Object object5 = ((ViewingConditions)object).getNcb();
        f = object4 * f / ((ViewingConditions)object).getNbb();
        object4 = (float)Math.sin(object2);
        object2 = (float)Math.cos(object2);
        f2 = (0.305f + f) * 23.0f * f2 / (23.0f * (3846.1538f * (object3 * 0.25f) * f3 * object5) + 11.0f * f2 * object2 + 108.0f * f2 * object4);
        object5 = f2 * object2;
        object4 = f2 * object4;
        f2 = (f * 460.0f + 451.0f * object5 + 288.0f * object4) / 1403.0f;
        object3 = (f * 460.0f - 891.0f * object5 - 261.0f * object4) / 1403.0f;
        object2 = (460.0f * f - 220.0f * object5 - 6300.0f * object4) / 1403.0f;
        object5 = (float)Math.max(0.0, (double)Math.abs(f2) * 27.13 / (400.0 - (double)Math.abs(f2)));
        f2 = Math.signum(f2);
        f = 100.0f / ((ViewingConditions)object).getFl();
        object5 = (float)Math.pow(object5, 2.380952380952381);
        f3 = (float)Math.max(0.0, (double)Math.abs(object3) * 27.13 / (400.0 - (double)Math.abs(object3)));
        object3 = Math.signum(object3);
        object4 = 100.0f / ((ViewingConditions)object).getFl();
        f3 = (float)Math.pow(f3, 2.380952380952381);
        Object object6 = (float)Math.max(0.0, (double)Math.abs(object2) * 27.13 / (400.0 - (double)Math.abs(object2)));
        object2 = Math.signum(object2);
        Object object7 = 100.0f / ((ViewingConditions)object).getFl();
        object6 = (float)Math.pow(object6, 2.380952380952381);
        f = f2 * f * object5 / ((ViewingConditions)object).getRgbD()[0];
        f2 = object3 * object4 * f3 / ((ViewingConditions)object).getRgbD()[1];
        f3 = object2 * object7 * object6 / ((ViewingConditions)object).getRgbD()[2];
        object = CamUtils.CAM16RGB_TO_XYZ;
        object2 = object[0][0];
        Object object8 = object[0][1];
        object7 = object[0][2];
        object6 = object[1][0];
        object3 = object[1][1];
        object4 = object[1][2];
        Object object9 = object[2][0];
        object5 = object[2][1];
        Object object10 = object[2][2];
        return ColorUtils.XYZToColor(object2 * f + object8 * f2 + object7 * f3, object6 * f + object3 * f2 + object4 * f3, (double)(object9 * f + object5 * f2 + object10 * f3));
    }

    int viewedInSrgb() {
        return this.viewed(ViewingConditions.DEFAULT);
    }
}

