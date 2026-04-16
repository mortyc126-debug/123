/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$MeasureSpec
 */
package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.KeyPosition;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.Arrays;
import java.util.LinkedHashMap;

class MotionPaths
implements Comparable<MotionPaths> {
    static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    static final int PERPENDICULAR = 1;
    static final int SCREEN = 3;
    public static final String TAG = "MotionPaths";
    static String[] names = new String[]{"position", "x", "y", "width", "height", "pathRotate"};
    LinkedHashMap<String, ConstraintAttribute> attributes;
    float height;
    int mDrawPath = 0;
    Easing mKeyFrameEasing;
    int mMode = 0;
    int mPathMotionArc;
    float mPathRotate = Float.NaN;
    float mProgress = Float.NaN;
    double[] mTempDelta;
    double[] mTempValue;
    float position;
    float time;
    float width;
    float x;
    float y;

    public MotionPaths() {
        this.mPathMotionArc = Key.UNSET;
        this.attributes = new LinkedHashMap();
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    public MotionPaths(int n, int n2, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        this.mPathMotionArc = Key.UNSET;
        this.attributes = new LinkedHashMap();
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        switch (keyPosition.mPositionType) {
            default: {
                this.initCartesian(keyPosition, motionPaths, motionPaths2);
                return;
            }
            case 2: {
                this.initScreen(n, n2, keyPosition, motionPaths, motionPaths2);
                return;
            }
            case 1: 
        }
        this.initPath(keyPosition, motionPaths, motionPaths2);
    }

    private boolean diff(float f, float f2) {
        boolean bl = Float.isNaN(f);
        boolean bl2 = true;
        boolean bl3 = true;
        if (!bl && !Float.isNaN(f2)) {
            if (!(Math.abs(f - f2) > 1.0E-6f)) {
                bl3 = false;
            }
            return bl3;
        }
        bl3 = Float.isNaN(f) != Float.isNaN(f2) ? bl2 : false;
        return bl3;
    }

    private static final float xRotate(float f, float f2, float f3, float f4, float f5, float f6) {
        return (f5 - f3) * f2 - (f6 - f4) * f + f3;
    }

    private static final float yRotate(float f, float f2, float f3, float f4, float f5, float f6) {
        return (f5 - f3) * f + (f6 - f4) * f2 + f4;
    }

    public void applyParameters(ConstraintSet.Constraint constraint) {
        this.mKeyFrameEasing = Easing.getInterpolator(constraint.motion.mTransitionEasing);
        this.mPathMotionArc = constraint.motion.mPathMotionArc;
        this.mPathRotate = constraint.motion.mPathRotate;
        this.mDrawPath = constraint.motion.mDrawPath;
        this.mProgress = constraint.propertySet.mProgress;
        for (String string2 : constraint.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.mCustomConstraints.get(string2);
            if (constraintAttribute.getType() == ConstraintAttribute.AttributeType.STRING_TYPE) continue;
            this.attributes.put(string2, constraintAttribute);
        }
    }

    @Override
    public int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.position, motionPaths.position);
    }

    void different(MotionPaths motionPaths, boolean[] blArray, String[] stringArray, boolean bl) {
        int n = 0 + 1;
        blArray[0] = blArray[0] | this.diff(this.position, motionPaths.position);
        int n2 = n + 1;
        blArray[n] = blArray[n] | (this.diff(this.x, motionPaths.x) | bl);
        n = n2 + 1;
        blArray[n2] = blArray[n2] | (this.diff(this.y, motionPaths.y) | bl);
        n2 = n + 1;
        blArray[n] = blArray[n] | this.diff(this.width, motionPaths.width);
        blArray[n2] = blArray[n2] | this.diff(this.height, motionPaths.height);
    }

    void fillStandard(double[] dArray, int[] nArray) {
        float[] fArray = new float[]{this.position, this.x, this.y, this.width, this.height, this.mPathRotate};
        int n = 0;
        for (int i = 0; i < nArray.length; ++i) {
            int n2 = n;
            if (nArray[i] < fArray.length) {
                dArray[n] = fArray[nArray[i]];
                n2 = n + 1;
            }
            n = n2;
        }
    }

    void getBounds(int[] nArray, double[] dArray, float[] fArray, int n) {
        float f = this.x;
        f = this.y;
        float f2 = this.width;
        f = this.height;
        block6: for (int i = 0; i < nArray.length; ++i) {
            float f3 = (float)dArray[i];
            switch (nArray[i]) {
                default: {
                    continue block6;
                }
                case 4: {
                    f = f3;
                    continue block6;
                }
                case 3: {
                    f2 = f3;
                    continue block6;
                }
                case 2: {
                }
                case 1: 
            }
        }
        fArray[n] = f2;
        fArray[n + 1] = f;
    }

    void getCenter(int[] nArray, double[] dArray, float[] fArray, int n) {
        float f = this.x;
        float f2 = this.y;
        float f3 = this.width;
        float f4 = this.height;
        block6: for (int i = 0; i < nArray.length; ++i) {
            float f5 = (float)dArray[i];
            switch (nArray[i]) {
                default: {
                    continue block6;
                }
                case 4: {
                    f4 = f5;
                    continue block6;
                }
                case 3: {
                    f3 = f5;
                    continue block6;
                }
                case 2: {
                    f2 = f5;
                    continue block6;
                }
                case 1: {
                    f = f5;
                }
            }
        }
        fArray[n] = f3 / 2.0f + f + 0.0f;
        fArray[n + 1] = f4 / 2.0f + f2 + 0.0f;
    }

    int getCustomData(String object, double[] dArray, int n) {
        if (((ConstraintAttribute)(object = this.attributes.get(object))).noOfInterpValues() == 1) {
            dArray[n] = ((ConstraintAttribute)object).getValueToInterpolate();
            return 1;
        }
        int n2 = ((ConstraintAttribute)object).noOfInterpValues();
        float[] fArray = new float[n2];
        ((ConstraintAttribute)object).getValuesToInterpolate(fArray);
        int n3 = 0;
        while (n3 < n2) {
            dArray[n] = fArray[n3];
            ++n3;
            ++n;
        }
        return n2;
    }

    int getCustomDataCount(String string2) {
        return this.attributes.get(string2).noOfInterpValues();
    }

    void getRect(int[] nArray, double[] dArray, float[] fArray, int n) {
        float f;
        float f2 = this.x;
        float f3 = this.y;
        float f4 = this.width;
        float f5 = this.height;
        float f6 = 0.0f;
        boolean bl = false;
        boolean bl2 = false;
        int n2 = 0;
        while (true) {
            f = f6;
            if (n2 >= nArray.length) break;
            f6 = (float)dArray[n2];
            switch (nArray[n2]) {
                default: {
                    f6 = f;
                    break;
                }
                case 4: {
                    f5 = f6;
                    f6 = f;
                    break;
                }
                case 3: {
                    f4 = f6;
                    f6 = f;
                    break;
                }
                case 2: {
                    f3 = f6;
                    f6 = f;
                    break;
                }
                case 1: {
                    f2 = f6;
                    f6 = f;
                }
                case 0: 
            }
            ++n2;
        }
        float f7 = f2;
        f = f3;
        float f8 = f2 + f4;
        float f9 = f;
        float f10 = f8;
        float f11 = f3 + f5;
        float f12 = f7;
        float f13 = f11;
        float f14 = f7 + f4 / 2.0f;
        float f15 = f + f5 / 2.0f;
        if (!Float.isNaN(Float.NaN)) {
            f14 = f7 + (f8 - f7) * Float.NaN;
        }
        if (!Float.isNaN(Float.NaN)) {
            f15 = f + (f11 - f) * Float.NaN;
        }
        f5 = f7;
        f2 = f8;
        f3 = f10;
        f6 = f12;
        if (1.0f != 1.0f) {
            f6 = (f7 + f8) / 2.0f;
            f5 = (f7 - f6) * 1.0f + f6;
            f2 = (f8 - f6) * 1.0f + f6;
            f3 = (f10 - f6) * 1.0f + f6;
            f6 = (f12 - f6) * 1.0f + f6;
        }
        f10 = f;
        f12 = f9;
        f4 = f11;
        f7 = f13;
        if (1.0f != 1.0f) {
            f7 = (f + f11) / 2.0f;
            f10 = (f - f7) * 1.0f + f7;
            f12 = (f9 - f7) * 1.0f + f7;
            f4 = (f11 - f7) * 1.0f + f7;
            f7 = (f13 - f7) * 1.0f + f7;
        }
        if (0.0f != 0.0f) {
            f9 = (float)Math.sin(Math.toRadians(0.0f));
            f11 = (float)Math.cos(Math.toRadians(0.0f));
            f = MotionPaths.xRotate(f9, f11, f14, f15, f5, f10);
            f13 = MotionPaths.yRotate(f9, f11, f14, f15, f5, f10);
            f10 = MotionPaths.xRotate(f9, f11, f14, f15, f2, f12);
            f12 = MotionPaths.yRotate(f9, f11, f14, f15, f2, f12);
            f5 = MotionPaths.xRotate(f9, f11, f14, f15, f3, f4);
            f3 = MotionPaths.yRotate(f9, f11, f14, f15, f3, f4);
            f4 = MotionPaths.xRotate(f9, f11, f14, f15, f6, f7);
            f7 = MotionPaths.yRotate(f9, f11, f14, f15, f6, f7);
            f14 = f;
            f6 = f13;
            f2 = f10;
            f = f4;
            f10 = f6;
            f6 = f5;
            f4 = f3;
        } else {
            f = f6;
            f6 = f3;
            f14 = f5;
        }
        n2 = n + 1;
        fArray[n] = f14 + 0.0f;
        n = n2 + 1;
        fArray[n2] = f10 + 0.0f;
        int n3 = n + 1;
        fArray[n] = f2 + 0.0f;
        n2 = n3 + 1;
        fArray[n3] = f12 + 0.0f;
        n = n2 + 1;
        fArray[n2] = f6 + 0.0f;
        n2 = n + 1;
        fArray[n] = f4 + 0.0f;
        n = n2 + 1;
        fArray[n2] = f + 0.0f;
        fArray[n] = f7 + 0.0f;
    }

    boolean hasCustomData(String string2) {
        return this.attributes.containsKey(string2);
    }

    void initCartesian(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f;
        this.time = f = (float)keyPosition.mFramePosition / 100.0f;
        this.mDrawPath = keyPosition.mDrawPath;
        float f2 = Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f3 = Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f4 = motionPaths2.width - motionPaths.width;
        float f5 = motionPaths2.height - motionPaths.height;
        this.position = this.time;
        float f6 = motionPaths.x;
        float f7 = motionPaths.width / 2.0f;
        float f8 = motionPaths.y;
        float f9 = motionPaths.height / 2.0f;
        float f10 = motionPaths2.x;
        float f11 = motionPaths2.width / 2.0f;
        float f12 = motionPaths2.y;
        float f13 = motionPaths2.height / 2.0f;
        f11 = f10 + f11 - (f6 + f7);
        f9 = f12 + f13 - (f8 + f9);
        this.x = (int)(motionPaths.x + f11 * f - f4 * f2 / 2.0f);
        this.y = (int)(motionPaths.y + f9 * f - f5 * f3 / 2.0f);
        this.width = (int)(motionPaths.width + f4 * f2);
        this.height = (int)(motionPaths.height + f5 * f3);
        f12 = Float.isNaN(keyPosition.mPercentX) ? f : keyPosition.mPercentX;
        boolean bl = Float.isNaN(keyPosition.mAltPercentY);
        f8 = 0.0f;
        f13 = bl ? 0.0f : keyPosition.mAltPercentY;
        if (!Float.isNaN(keyPosition.mPercentY)) {
            f = keyPosition.mPercentY;
        }
        if (!Float.isNaN(keyPosition.mAltPercentX)) {
            f8 = keyPosition.mAltPercentX;
        }
        this.mMode = 2;
        this.x = (int)(motionPaths.x + f11 * f12 + f9 * f8 - f4 * f2 / 2.0f);
        this.y = (int)(motionPaths.y + f11 * f13 + f9 * f - f5 * f3 / 2.0f);
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    void initPath(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f;
        this.time = f = (float)keyPosition.mFramePosition / 100.0f;
        this.mDrawPath = keyPosition.mDrawPath;
        float f2 = Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f3 = Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f4 = motionPaths2.width - motionPaths.width;
        float f5 = motionPaths2.height - motionPaths.height;
        this.position = this.time;
        if (!Float.isNaN(keyPosition.mPercentX)) {
            f = keyPosition.mPercentX;
        }
        float f6 = motionPaths.x;
        float f7 = motionPaths.width / 2.0f;
        float f8 = motionPaths.y;
        float f9 = motionPaths.height / 2.0f;
        float f10 = motionPaths2.x;
        float f11 = motionPaths2.width / 2.0f;
        float f12 = motionPaths2.y;
        float f13 = motionPaths2.height / 2.0f;
        f10 = f10 + f11 - (f6 + f7);
        f12 = f12 + f13 - (f8 + f9);
        this.x = (int)(motionPaths.x + f10 * f - f4 * f2 / 2.0f);
        this.y = (int)(motionPaths.y + f12 * f - f5 * f3 / 2.0f);
        this.width = (int)(motionPaths.width + f4 * f2);
        this.height = (int)(motionPaths.height + f5 * f3);
        f8 = Float.isNaN(keyPosition.mPercentY) ? 0.0f : keyPosition.mPercentY;
        f13 = -f12;
        this.mMode = 1;
        this.x = (int)(motionPaths.x + f10 * f - f4 * f2 / 2.0f);
        this.y = (int)(motionPaths.y + f12 * f - f5 * f3 / 2.0f);
        this.x += f13 * f8;
        this.y += f10 * f8;
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    void initScreen(int n, int n2, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f;
        this.time = f = (float)keyPosition.mFramePosition / 100.0f;
        this.mDrawPath = keyPosition.mDrawPath;
        float f2 = Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f3 = Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f4 = motionPaths2.width - motionPaths.width;
        float f5 = motionPaths2.height - motionPaths.height;
        this.position = this.time;
        float f6 = motionPaths.x;
        float f7 = motionPaths.width / 2.0f;
        float f8 = motionPaths.y;
        float f9 = motionPaths.height / 2.0f;
        float f10 = motionPaths2.x;
        float f11 = motionPaths2.width / 2.0f;
        float f12 = motionPaths2.y;
        float f13 = motionPaths2.height / 2.0f;
        this.x = (int)(motionPaths.x + (f10 + f11 - (f6 + f7)) * f - f4 * f2 / 2.0f);
        this.y = (int)(motionPaths.y + (f12 + f13 - (f8 + f9)) * f - f5 * f3 / 2.0f);
        this.width = (int)(motionPaths.width + f4 * f2);
        this.height = (int)(motionPaths.height + f5 * f3);
        this.mMode = 3;
        if (!Float.isNaN(keyPosition.mPercentX)) {
            n = (int)((float)n - this.width);
            this.x = (int)(keyPosition.mPercentX * (float)n);
        }
        if (!Float.isNaN(keyPosition.mPercentY)) {
            n = (int)((float)n2 - this.height);
            this.y = (int)(keyPosition.mPercentY * (float)n);
        }
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    void setBounds(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.width = f3;
        this.height = f4;
    }

    void setDpDt(float f, float f2, float[] fArray, int[] nArray, double[] dArray, double[] dArray2) {
        float f3;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        for (int i = 0; i < nArray.length; ++i) {
            f3 = (float)dArray[i];
            float f8 = (float)dArray2[i];
            switch (nArray[i]) {
                default: {
                    f3 = f7;
                    break;
                }
                case 4: {
                    break;
                }
                case 3: {
                    f6 = f3;
                    f3 = f7;
                    break;
                }
                case 2: {
                    f5 = f3;
                    f3 = f7;
                    break;
                }
                case 1: {
                    f4 = f3;
                    f3 = f7;
                    break;
                }
                case 0: {
                    f3 = f7;
                }
            }
            f7 = f3;
        }
        f3 = f4 - 0.0f * f6 / 2.0f;
        fArray[0] = (1.0f - f) * f3 + (f3 + (0.0f + 1.0f) * f6) * f + 0.0f;
        fArray[1] = (1.0f - f2) * (f5 -= 0.0f * f7 / 2.0f) + (f5 + (0.0f + 1.0f) * f7) * f2 + 0.0f;
    }

    void setView(View view, int[] objectArray, double[] dArray, double[] dArray2, double[] dArray3) {
        float f;
        float f2;
        int n;
        float f3 = this.x;
        float f4 = this.y;
        float f5 = this.width;
        float f6 = this.height;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = Float.NaN;
        if (objectArray.length != 0 && this.mTempValue.length <= objectArray[objectArray.length - 1]) {
            n = objectArray[objectArray.length - 1] + 1;
            this.mTempValue = new double[n];
            this.mTempDelta = new double[n];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        for (n = 0; n < objectArray.length; ++n) {
            this.mTempValue[objectArray[n]] = dArray[n];
            this.mTempDelta[objectArray[n]] = dArray2[n];
        }
        block9: for (n = 0; n < this.mTempValue.length; ++n) {
            boolean bl = Double.isNaN(this.mTempValue[n]);
            double d = 0.0;
            if (bl && (dArray3 == null || dArray3[n] == 0.0)) continue;
            if (dArray3 != null) {
                d = dArray3[n];
            }
            if (!Double.isNaN(this.mTempValue[n])) {
                d = this.mTempValue[n] + d;
            }
            f2 = (float)d;
            objectArray = this.mTempDelta;
            f = objectArray[n];
            switch (n) {
                default: {
                    continue block9;
                }
                case 5: {
                    f11 = f2;
                    continue block9;
                }
                case 4: {
                    f6 = f2;
                    f10 = f;
                    continue block9;
                }
                case 3: {
                    f5 = f2;
                    f9 = f;
                    continue block9;
                }
                case 2: {
                    f4 = f2;
                    f8 = f;
                    continue block9;
                }
                case 1: {
                    f7 = f;
                    f3 = f2;
                    continue block9;
                }
                case 0: {
                    continue block9;
                }
            }
        }
        if (Float.isNaN(f11)) {
            if (!Float.isNaN(Float.NaN)) {
                view.setRotation(Float.NaN);
            }
        } else {
            f2 = Float.isNaN(Float.NaN) ? 0.0f : Float.NaN;
            f = f9 / 2.0f;
            view.setRotation((float)((double)f2 + ((double)f11 + Math.toDegrees(Math.atan2((f10 /= 2.0f) + f8, f + f7)))));
        }
        int n2 = (int)(f3 + 0.5f);
        int n3 = (int)(f4 + 0.5f);
        int n4 = (int)(f3 + 0.5f + f5);
        int n5 = (int)(0.5f + f4 + f6);
        int n6 = n4 - n2;
        int n7 = n5 - n3;
        n = n6 == view.getMeasuredWidth() && n7 == view.getMeasuredHeight() ? 0 : 1;
        if (n != 0) {
            view.measure(View.MeasureSpec.makeMeasureSpec((int)n6, (int)0x40000000), View.MeasureSpec.makeMeasureSpec((int)n7, (int)0x40000000));
        }
        view.layout(n2, n3, n4, n5);
    }
}

