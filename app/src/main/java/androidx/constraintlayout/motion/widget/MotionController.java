/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.View
 *  android.view.View$MeasureSpec
 */
package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.VelocityMatrix;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.KeyAttributes;
import androidx.constraintlayout.motion.widget.KeyCache;
import androidx.constraintlayout.motion.widget.KeyCycle;
import androidx.constraintlayout.motion.widget.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.KeyPosition;
import androidx.constraintlayout.motion.widget.KeyPositionBase;
import androidx.constraintlayout.motion.widget.KeyTimeCycle;
import androidx.constraintlayout.motion.widget.KeyTrigger;
import androidx.constraintlayout.motion.widget.MotionConstrainedPoint;
import androidx.constraintlayout.motion.widget.MotionPaths;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.motion.widget.TimeCycleSplineSet;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class MotionController {
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    private int MAX_DIMENSION = 4;
    String[] attributeTable;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpCount;
    private String[] mAttributeNames;
    private HashMap<String, SplineSet> mAttributesMap;
    String mConstraintTag;
    private int mCurveFitType = -1;
    private HashMap<String, KeyCycleOscillator> mCycleMap;
    private MotionPaths mEndMotionPath;
    private MotionConstrainedPoint mEndPoint;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private ArrayList<Key> mKeyList;
    private KeyTrigger[] mKeyTriggers;
    private ArrayList<MotionPaths> mMotionPaths;
    float mMotionStagger;
    private int mPathMotionArc;
    private CurveFit[] mSpline;
    float mStaggerOffset = 0.0f;
    float mStaggerScale = 1.0f;
    private MotionPaths mStartMotionPath = new MotionPaths();
    private MotionConstrainedPoint mStartPoint;
    private HashMap<String, TimeCycleSplineSet> mTimeCycleAttributesMap;
    private float[] mValuesBuff;
    private float[] mVelocity;
    View mView;

    MotionController(View view) {
        this.mEndMotionPath = new MotionPaths();
        this.mStartPoint = new MotionConstrainedPoint();
        this.mEndPoint = new MotionConstrainedPoint();
        this.mMotionStagger = Float.NaN;
        this.mValuesBuff = new float[this.MAX_DIMENSION];
        this.mMotionPaths = new ArrayList();
        this.mVelocity = new float[1];
        this.mKeyList = new ArrayList();
        this.mPathMotionArc = Key.UNSET;
        this.setView(view);
    }

    private float getAdjustedPosition(float f, float[] fArray) {
        float f2;
        float f3;
        if (fArray != null) {
            fArray[0] = 1.0f;
            f3 = f;
        } else {
            f3 = f;
            if ((double)this.mStaggerScale != 1.0) {
                f2 = f;
                if (f < this.mStaggerOffset) {
                    f2 = 0.0f;
                }
                f3 = f2;
                if (f2 > this.mStaggerOffset) {
                    f3 = f2;
                    if ((double)f2 < 1.0) {
                        f3 = (f2 - this.mStaggerOffset) * this.mStaggerScale;
                    }
                }
            }
        }
        float f4 = f3;
        Easing easing = this.mStartMotionPath.mKeyFrameEasing;
        f2 = 0.0f;
        f = Float.NaN;
        for (MotionPaths motionPaths : this.mMotionPaths) {
            Easing easing2 = easing;
            float f5 = f2;
            float f6 = f;
            if (motionPaths.mKeyFrameEasing != null) {
                if (motionPaths.time < f3) {
                    easing2 = motionPaths.mKeyFrameEasing;
                    f5 = motionPaths.time;
                    f6 = f;
                } else {
                    easing2 = easing;
                    f5 = f2;
                    f6 = f;
                    if (Float.isNaN(f)) {
                        f6 = motionPaths.time;
                        f5 = f2;
                        easing2 = easing;
                    }
                }
            }
            easing = easing2;
            f2 = f5;
            f = f6;
        }
        if (easing != null) {
            f4 = f;
            if (Float.isNaN(f)) {
                f4 = 1.0f;
            }
            f3 = (f3 - f2) / (f4 - f2);
            f4 = f = (f4 - f2) * (float)easing.get(f3) + f2;
            if (fArray != null) {
                fArray[0] = (float)easing.getDiff(f3);
                f4 = f;
            }
        }
        return f4;
    }

    private float getPreCycleDistance() {
        int n = 100;
        float[] fArray = new float[2];
        float f = 0.0f;
        float f2 = 1.0f / (float)(100 - 1);
        double d = 0.0;
        double d2 = 0.0;
        for (int i = 0; i < n; ++i) {
            float f3;
            float f4 = (float)i * f2;
            double d3 = f4;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            float f5 = 0.0f;
            float f6 = Float.NaN;
            for (MotionPaths motionPaths : this.mMotionPaths) {
                Easing easing2 = easing;
                float f7 = f5;
                f3 = f6;
                if (motionPaths.mKeyFrameEasing != null) {
                    if (motionPaths.time < f4) {
                        easing2 = motionPaths.mKeyFrameEasing;
                        f7 = motionPaths.time;
                        f3 = f6;
                    } else {
                        easing2 = easing;
                        f7 = f5;
                        f3 = f6;
                        if (Float.isNaN(f6)) {
                            f3 = motionPaths.time;
                            f7 = f5;
                            easing2 = easing;
                        }
                    }
                }
                easing = easing2;
                f5 = f7;
                f6 = f3;
            }
            if (easing != null) {
                f3 = f6;
                if (Float.isNaN(f6)) {
                    f3 = 1.0f;
                }
                d3 = (f3 - f5) * (float)easing.get((f4 - f5) / (f3 - f5)) + f5;
            }
            this.mSpline[0].getPos(d3, this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArray, 0);
            if (i > 0) {
                f = (float)((double)f + Math.hypot(d2 - (double)fArray[1], d - (double)fArray[0]));
            }
            d = fArray[0];
            d2 = fArray[1];
        }
        return f;
    }

    private void insertKey(MotionPaths motionPaths) {
        int n = Collections.binarySearch(this.mMotionPaths, motionPaths);
        if (n == 0) {
            Log.e((String)TAG, (String)(" KeyPath positon \"" + motionPaths.position + "\" outside of range"));
        }
        this.mMotionPaths.add(-n - 1, motionPaths);
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds((int)this.mView.getX(), (int)this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    void addKey(Key key) {
        this.mKeyList.add(key);
    }

    void addKeys(ArrayList<Key> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    void buildBounds(float[] fArray, int n) {
        Object object;
        float f = 1.0f / (float)(n - 1);
        SplineSet splineSet = this.mAttributesMap == null ? null : this.mAttributesMap.get("translationX");
        if (this.mAttributesMap != null) {
            object = this.mAttributesMap.get("translationY");
        }
        if (this.mCycleMap != null) {
            object = this.mCycleMap.get("translationX");
        }
        if (this.mCycleMap != null) {
            object = this.mCycleMap.get("translationY");
        }
        for (int i = 0; i < n; ++i) {
            float f2;
            float f3;
            float f4;
            float f5 = f4 = (float)i * f;
            if (this.mStaggerScale != 1.0f) {
                f3 = f4;
                if (f4 < this.mStaggerOffset) {
                    f3 = 0.0f;
                }
                f5 = f3;
                if (f3 > this.mStaggerOffset) {
                    f5 = f3;
                    if ((double)f3 < 1.0) {
                        f5 = (f3 - this.mStaggerOffset) * this.mStaggerScale;
                    }
                }
            }
            double d = f5;
            object = this.mStartMotionPath.mKeyFrameEasing;
            f4 = 0.0f;
            f3 = Float.NaN;
            for (MotionPaths motionPaths : this.mMotionPaths) {
                Object object2 = object;
                float f6 = f4;
                f2 = f3;
                if (motionPaths.mKeyFrameEasing != null) {
                    if (motionPaths.time < f5) {
                        object2 = motionPaths.mKeyFrameEasing;
                        f6 = motionPaths.time;
                        f2 = f3;
                    } else {
                        object2 = object;
                        f6 = f4;
                        f2 = f3;
                        if (Float.isNaN(f3)) {
                            f2 = motionPaths.time;
                            f6 = f4;
                            object2 = object;
                        }
                    }
                }
                object = object2;
                f4 = f6;
                f3 = f2;
            }
            if (object != null) {
                f2 = f3;
                if (Float.isNaN(f3)) {
                    f2 = 1.0f;
                }
                d = (f2 - f4) * (float)((Easing)object).get((f5 - f4) / (f2 - f4)) + f4;
            }
            this.mSpline[0].getPos(d, this.mInterpolateData);
            if (this.mArcSpline != null && this.mInterpolateData.length > 0) {
                this.mArcSpline.getPos(d, this.mInterpolateData);
            }
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArray, i * 2);
        }
    }

    int buildKeyBounds(float[] fArray, int[] nArray) {
        if (fArray != null) {
            int n = 0;
            double[] dArray = this.mSpline[0].getTimePoints();
            if (nArray != null) {
                Iterator<MotionPaths> iterator2 = this.mMotionPaths.iterator();
                while (iterator2.hasNext()) {
                    nArray[n] = iterator2.next().mMode;
                    ++n;
                }
            }
            int n2 = 0;
            for (n = 0; n < dArray.length; ++n) {
                this.mSpline[0].getPos(dArray[n], this.mInterpolateData);
                this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArray, n2);
                n2 += 2;
            }
            return n2 / 2;
        }
        return 0;
    }

    int buildKeyFrames(float[] fArray, int[] nArray) {
        if (fArray != null) {
            int n = 0;
            double[] dArray = this.mSpline[0].getTimePoints();
            if (nArray != null) {
                Iterator<MotionPaths> iterator2 = this.mMotionPaths.iterator();
                while (iterator2.hasNext()) {
                    nArray[n] = iterator2.next().mMode;
                    ++n;
                }
            }
            int n2 = 0;
            for (n = 0; n < dArray.length; ++n) {
                this.mSpline[0].getPos(dArray[n], this.mInterpolateData);
                this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArray, n2);
                n2 += 2;
            }
            return n2 / 2;
        }
        return 0;
    }

    void buildPath(float[] fArray, int n) {
        float f = 1.0f / (float)(n - 1);
        Object object = this.mAttributesMap;
        KeyCycleOscillator keyCycleOscillator = null;
        object = object == null ? null : this.mAttributesMap.get("translationX");
        SplineSet splineSet = this.mAttributesMap == null ? null : this.mAttributesMap.get("translationY");
        KeyCycleOscillator keyCycleOscillator2 = this.mCycleMap == null ? null : this.mCycleMap.get("translationX");
        if (this.mCycleMap != null) {
            keyCycleOscillator = this.mCycleMap.get("translationY");
        }
        for (int i = 0; i < n; ++i) {
            int n2;
            float f2;
            float f3;
            float f4;
            float f5 = f4 = (float)i * f;
            if (this.mStaggerScale != 1.0f) {
                f3 = f4;
                if (f4 < this.mStaggerOffset) {
                    f3 = 0.0f;
                }
                f5 = f3;
                if (f3 > this.mStaggerOffset) {
                    f5 = f3;
                    if ((double)f3 < 1.0) {
                        f5 = (f3 - this.mStaggerOffset) * this.mStaggerScale;
                    }
                }
            }
            double d = f5;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            f4 = 0.0f;
            f3 = Float.NaN;
            for (MotionPaths motionPaths : this.mMotionPaths) {
                Easing easing2 = easing;
                f2 = f4;
                float f6 = f3;
                if (motionPaths.mKeyFrameEasing != null) {
                    if (motionPaths.time < f5) {
                        easing2 = motionPaths.mKeyFrameEasing;
                        f2 = motionPaths.time;
                        f6 = f3;
                    } else {
                        easing2 = easing;
                        f2 = f4;
                        f6 = f3;
                        if (Float.isNaN(f3)) {
                            f6 = motionPaths.time;
                            f2 = f4;
                            easing2 = easing;
                        }
                    }
                }
                easing = easing2;
                f4 = f2;
                f3 = f6;
            }
            if (easing != null) {
                f2 = f3;
                if (Float.isNaN(f3)) {
                    f2 = 1.0f;
                }
                d = (f2 - f4) * (float)easing.get((f5 - f4) / (f2 - f4)) + f4;
            }
            this.mSpline[0].getPos(d, this.mInterpolateData);
            if (this.mArcSpline != null && this.mInterpolateData.length > 0) {
                this.mArcSpline.getPos(d, this.mInterpolateData);
            }
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArray, i * 2);
            if (keyCycleOscillator2 != null) {
                n2 = i * 2;
                fArray[n2] = fArray[n2] + keyCycleOscillator2.get(f5);
            } else if (object != null) {
                n2 = i * 2;
                fArray[n2] = fArray[n2] + ((SplineSet)object).get(f5);
            }
            if (keyCycleOscillator != null) {
                n2 = i * 2 + 1;
                fArray[n2] = fArray[n2] + keyCycleOscillator.get(f5);
                continue;
            }
            if (splineSet == null) continue;
            n2 = i * 2 + 1;
            fArray[n2] = fArray[n2] + splineSet.get(f5);
        }
    }

    void buildRect(float f, float[] fArray, int n) {
        f = this.getAdjustedPosition(f, null);
        this.mSpline[0].getPos((double)f, this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArray, n);
    }

    void buildRectangles(float[] fArray, int n) {
        float f = 1.0f / (float)(n - 1);
        for (int i = 0; i < n; ++i) {
            float f2 = this.getAdjustedPosition((float)i * f, null);
            this.mSpline[0].getPos((double)f2, this.mInterpolateData);
            this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArray, i * 8);
        }
    }

    int getAttributeValues(String object, float[] fArray, int n) {
        float f = 1.0f / (float)(n - 1);
        if ((object = this.mAttributesMap.get(object)) == null) {
            return -1;
        }
        for (n = 0; n < fArray.length; ++n) {
            fArray[n] = ((SplineSet)object).get(n / (fArray.length - 1));
        }
        return fArray.length;
    }

    void getDpDt(float f, float f2, float f3, float[] fArray) {
        float f4 = this.getAdjustedPosition(f, this.mVelocity);
        if (this.mSpline != null) {
            this.mSpline[0].getSlope((double)f4, this.mInterpolateVelocity);
            this.mSpline[0].getPos((double)f4, this.mInterpolateData);
            f = this.mVelocity[0];
            for (int i = 0; i < this.mInterpolateVelocity.length; ++i) {
                double[] dArray = this.mInterpolateVelocity;
                dArray[i] = dArray[i] * (double)f;
            }
            if (this.mArcSpline != null) {
                if (this.mInterpolateData.length > 0) {
                    this.mArcSpline.getPos((double)f4, this.mInterpolateData);
                    this.mArcSpline.getSlope((double)f4, this.mInterpolateVelocity);
                    this.mStartMotionPath.setDpDt(f2, f3, fArray, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
                }
                return;
            }
            this.mStartMotionPath.setDpDt(f2, f3, fArray, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            return;
        }
        f4 = this.mEndMotionPath.x - this.mStartMotionPath.x;
        float f5 = this.mEndMotionPath.y - this.mStartMotionPath.y;
        float f6 = this.mEndMotionPath.width;
        float f7 = this.mStartMotionPath.width;
        f = this.mEndMotionPath.height;
        float f8 = this.mStartMotionPath.height;
        fArray[0] = (1.0f - f2) * f4 + (f4 + (f6 - f7)) * f2;
        fArray[1] = (1.0f - f3) * f5 + (f5 + (f - f8)) * f3;
    }

    public int getDrawPath() {
        int n = this.mStartMotionPath.mDrawPath;
        Iterator<MotionPaths> iterator2 = this.mMotionPaths.iterator();
        while (iterator2.hasNext()) {
            n = Math.max(n, iterator2.next().mDrawPath);
        }
        return Math.max(n, this.mEndMotionPath.mDrawPath);
    }

    float getFinalX() {
        return this.mEndMotionPath.x;
    }

    float getFinalY() {
        return this.mEndMotionPath.y;
    }

    MotionPaths getKeyFrame(int n) {
        return this.mMotionPaths.get(n);
    }

    public int getKeyFrameInfo(int n, int[] nArray) {
        int n2 = 0;
        int n3 = 0;
        float[] fArray = new float[2];
        Iterator<Key> iterator2 = this.mKeyList.iterator();
        while (true) {
            int n4 = n3;
            if (!iterator2.hasNext()) break;
            Key key = iterator2.next();
            if (key.mType != n && n == -1) {
                n3 = n4;
                continue;
            }
            nArray[n4] = 0;
            n3 = n4 + 1;
            nArray[n3] = key.mType;
            nArray[++n3] = key.mFramePosition;
            float f = (float)key.mFramePosition / 100.0f;
            this.mSpline[0].getPos((double)f, this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArray, 0);
            nArray[++n3] = Float.floatToIntBits(fArray[0]);
            int n5 = n3 + 1;
            nArray[n5] = Float.floatToIntBits(fArray[1]);
            n3 = n5;
            if (key instanceof KeyPosition) {
                key = (KeyPosition)key;
                n3 = n5 + 1;
                nArray[n3] = ((KeyPosition)key).mPositionType;
                nArray[++n3] = Float.floatToIntBits(((KeyPosition)key).mPercentX);
                nArray[++n3] = Float.floatToIntBits(((KeyPosition)key).mPercentY);
            }
            nArray[n4] = ++n3 - n4;
            ++n2;
        }
        return n2;
    }

    float getKeyFrameParameter(int n, float f, float f2) {
        float f3 = this.mEndMotionPath.x - this.mStartMotionPath.x;
        float f4 = this.mEndMotionPath.y - this.mStartMotionPath.y;
        float f5 = this.mStartMotionPath.x;
        float f6 = this.mStartMotionPath.width / 2.0f;
        float f7 = this.mStartMotionPath.y;
        float f8 = this.mStartMotionPath.height / 2.0f;
        float f9 = (float)Math.hypot(f3, f4);
        if ((double)f9 < 1.0E-7) {
            return Float.NaN;
        }
        if ((float)Math.hypot(f -= f5 + f6, f7 = f2 - (f7 + f8)) == 0.0f) {
            return 0.0f;
        }
        f2 = f * f3 + f7 * f4;
        switch (n) {
            default: {
                return 0.0f;
            }
            case 5: {
                return f7 / f4;
            }
            case 4: {
                return f / f4;
            }
            case 3: {
                return f7 / f3;
            }
            case 2: {
                return f / f3;
            }
            case 1: {
                return (float)Math.sqrt(f9 * f9 - f2 * f2);
            }
            case 0: 
        }
        return f2 / f9;
    }

    KeyPositionBase getPositionKeyframe(int n, int n2, float f, float f2) {
        RectF rectF = new RectF();
        rectF.left = this.mStartMotionPath.x;
        rectF.top = this.mStartMotionPath.y;
        rectF.right = rectF.left + this.mStartMotionPath.width;
        rectF.bottom = rectF.top + this.mStartMotionPath.height;
        RectF rectF2 = new RectF();
        rectF2.left = this.mEndMotionPath.x;
        rectF2.top = this.mEndMotionPath.y;
        rectF2.right = rectF2.left + this.mEndMotionPath.width;
        rectF2.bottom = rectF2.top + this.mEndMotionPath.height;
        for (Key key : this.mKeyList) {
            if (!(key instanceof KeyPositionBase) || !((KeyPositionBase)key).intersects(n, n2, rectF, rectF2, f, f2)) continue;
            return (KeyPositionBase)key;
        }
        return null;
    }

    void getPostLayoutDvDp(float f, int n, int n2, float f2, float f3, float[] fArray) {
        float f4 = this.getAdjustedPosition(f, this.mVelocity);
        Object object = this.mAttributesMap;
        KeyCycleOscillator keyCycleOscillator = null;
        object = object == null ? null : this.mAttributesMap.get("translationX");
        SplineSet splineSet = this.mAttributesMap == null ? null : this.mAttributesMap.get("translationY");
        SplineSet splineSet2 = this.mAttributesMap == null ? null : this.mAttributesMap.get("rotation");
        SplineSet splineSet3 = this.mAttributesMap == null ? null : this.mAttributesMap.get("scaleX");
        SplineSet splineSet4 = this.mAttributesMap == null ? null : this.mAttributesMap.get("scaleY");
        KeyCycleOscillator keyCycleOscillator2 = this.mCycleMap == null ? null : this.mCycleMap.get("translationX");
        KeyCycleOscillator keyCycleOscillator3 = this.mCycleMap == null ? null : this.mCycleMap.get("translationY");
        KeyCycleOscillator keyCycleOscillator4 = this.mCycleMap == null ? null : this.mCycleMap.get("rotation");
        KeyCycleOscillator keyCycleOscillator5 = this.mCycleMap == null ? null : this.mCycleMap.get("scaleX");
        if (this.mCycleMap != null) {
            keyCycleOscillator = this.mCycleMap.get("scaleY");
        }
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(splineSet2, f4);
        velocityMatrix.setTranslationVelocity((SplineSet)object, splineSet, f4);
        velocityMatrix.setScaleVelocity(splineSet3, splineSet4, f4);
        velocityMatrix.setRotationVelocity(keyCycleOscillator4, f4);
        velocityMatrix.setTranslationVelocity(keyCycleOscillator2, keyCycleOscillator3, f4);
        velocityMatrix.setScaleVelocity(keyCycleOscillator5, keyCycleOscillator, f4);
        if (this.mArcSpline != null) {
            if (this.mInterpolateData.length > 0) {
                this.mArcSpline.getPos((double)f4, this.mInterpolateData);
                this.mArcSpline.getSlope((double)f4, this.mInterpolateVelocity);
                this.mStartMotionPath.setDpDt(f2, f3, fArray, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            }
            velocityMatrix.applyTransform(f2, f3, n, n2, fArray);
            return;
        }
        if (this.mSpline != null) {
            f = this.getAdjustedPosition(f4, this.mVelocity);
            this.mSpline[0].getSlope((double)f, this.mInterpolateVelocity);
            this.mSpline[0].getPos((double)f, this.mInterpolateData);
            f = this.mVelocity[0];
            for (int i = 0; i < this.mInterpolateVelocity.length; ++i) {
                object = this.mInterpolateVelocity;
                object[i] = object[i] * (double)f;
            }
            this.mStartMotionPath.setDpDt(f2, f3, fArray, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            velocityMatrix.applyTransform(f2, f3, n, n2, fArray);
            return;
        }
        float f5 = this.mEndMotionPath.x - this.mStartMotionPath.x;
        float f6 = this.mEndMotionPath.y - this.mStartMotionPath.y;
        float f7 = this.mEndMotionPath.width;
        float f8 = this.mStartMotionPath.width;
        float f9 = this.mEndMotionPath.height;
        f = this.mStartMotionPath.height;
        fArray[0] = (1.0f - f2) * f5 + (f5 + (f7 - f8)) * f2;
        fArray[1] = (1.0f - f3) * f6 + (f6 + (f9 - f)) * f3;
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(splineSet2, f4);
        velocityMatrix.setTranslationVelocity((SplineSet)object, splineSet, f4);
        velocityMatrix.setScaleVelocity(splineSet3, splineSet4, f4);
        velocityMatrix.setRotationVelocity(keyCycleOscillator4, f4);
        velocityMatrix.setTranslationVelocity(keyCycleOscillator2, keyCycleOscillator3, f4);
        velocityMatrix.setScaleVelocity(keyCycleOscillator5, keyCycleOscillator, f4);
        velocityMatrix.applyTransform(f2, f3, n, n2, fArray);
    }

    float getStartX() {
        return this.mStartMotionPath.x;
    }

    float getStartY() {
        return this.mStartMotionPath.y;
    }

    public int getkeyFramePositions(int[] nArray, float[] fArray) {
        int n = 0;
        int n2 = 0;
        for (Key key : this.mKeyList) {
            nArray[n] = key.mFramePosition + key.mType * 1000;
            float f = (float)key.mFramePosition / 100.0f;
            this.mSpline[0].getPos((double)f, this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArray, n2);
            n2 += 2;
            ++n;
        }
        return n;
    }

    boolean interpolate(View view, float f, long l, KeyCache object3) {
        boolean bl;
        int n;
        boolean bl2;
        Iterator<KeyCycleOscillator> iterator2;
        float f2 = this.getAdjustedPosition(f, null);
        if (this.mAttributesMap != null) {
            iterator2 = this.mAttributesMap.values().iterator();
            while (iterator2.hasNext()) {
                iterator2.next().setProperty(view, f2);
            }
        }
        if (this.mTimeCycleAttributesMap != null) {
            Iterator<TimeCycleSplineSet> iterator3 = this.mTimeCycleAttributesMap.values().iterator();
            bl2 = false;
            iterator2 = null;
            while (iterator3.hasNext()) {
                TimeCycleSplineSet timeCycleSplineSet = iterator3.next();
                if (timeCycleSplineSet instanceof TimeCycleSplineSet.PathRotate) {
                    iterator2 = (TimeCycleSplineSet.PathRotate)timeCycleSplineSet;
                    continue;
                }
                bl2 |= timeCycleSplineSet.setProperty(view, f2, l, (KeyCache)object3);
            }
        } else {
            bl2 = false;
            iterator2 = null;
        }
        if (this.mSpline != null) {
            this.mSpline[0].getPos((double)f2, this.mInterpolateData);
            this.mSpline[0].getSlope((double)f2, this.mInterpolateVelocity);
            if (this.mArcSpline != null && this.mInterpolateData.length > 0) {
                this.mArcSpline.getPos((double)f2, this.mInterpolateData);
                this.mArcSpline.getSlope((double)f2, this.mInterpolateVelocity);
            }
            this.mStartMotionPath.setView(view, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null);
            if (this.mAttributesMap != null) {
                for (SplineSet splineSet : this.mAttributesMap.values()) {
                    if (!(splineSet instanceof SplineSet.PathRotate)) continue;
                    ((SplineSet.PathRotate)splineSet).setPathRotate(view, f2, this.mInterpolateVelocity[0], this.mInterpolateVelocity[1]);
                }
            }
            if (iterator2 != null) {
                bl2 = ((TimeCycleSplineSet.PathRotate)((Object)iterator2)).setPathRotate(view, (KeyCache)object3, f2, l, this.mInterpolateVelocity[0], this.mInterpolateVelocity[1]) | bl2;
            }
            for (n = 1; n < this.mSpline.length; ++n) {
                this.mSpline[n].getPos((double)f2, this.mValuesBuff);
                this.mStartMotionPath.attributes.get(this.mAttributeNames[n - 1]).setInterpolatedValue(view, this.mValuesBuff);
            }
            if (this.mStartPoint.mVisibilityMode == 0) {
                if (f2 <= 0.0f) {
                    view.setVisibility(this.mStartPoint.visibility);
                } else if (f2 >= 1.0f) {
                    view.setVisibility(this.mEndPoint.visibility);
                } else if (this.mEndPoint.visibility != this.mStartPoint.visibility) {
                    view.setVisibility(0);
                }
            }
            bl = bl2;
            if (this.mKeyTriggers != null) {
                for (n = 0; n < this.mKeyTriggers.length; ++n) {
                    this.mKeyTriggers[n].conditionallyFire(f2, view);
                }
                bl = bl2;
            }
        } else {
            float f3 = this.mStartMotionPath.x + (this.mEndMotionPath.x - this.mStartMotionPath.x) * f2;
            f = this.mStartMotionPath.y + (this.mEndMotionPath.y - this.mStartMotionPath.y) * f2;
            float f4 = this.mStartMotionPath.width;
            float f5 = this.mEndMotionPath.width;
            float f6 = this.mStartMotionPath.width;
            float f7 = this.mStartMotionPath.height;
            float f8 = this.mEndMotionPath.height;
            float f9 = this.mStartMotionPath.height;
            int n2 = (int)(f3 + 0.5f);
            int n3 = (int)(f + 0.5f);
            n = (int)(f3 + 0.5f + (f4 + (f5 - f6) * f2));
            int n4 = (int)(0.5f + f + (f7 + (f8 - f9) * f2));
            if (this.mEndMotionPath.width != this.mStartMotionPath.width || this.mEndMotionPath.height != this.mStartMotionPath.height) {
                view.measure(View.MeasureSpec.makeMeasureSpec((int)(n - n2), (int)0x40000000), View.MeasureSpec.makeMeasureSpec((int)(n4 - n3), (int)0x40000000));
            }
            view.layout(n2, n3, n, n4);
            bl = bl2;
        }
        if (this.mCycleMap != null) {
            for (KeyCycleOscillator keyCycleOscillator : this.mCycleMap.values()) {
                if (keyCycleOscillator instanceof KeyCycleOscillator.PathRotateSet) {
                    ((KeyCycleOscillator.PathRotateSet)keyCycleOscillator).setPathRotate(view, f2, this.mInterpolateVelocity[0], this.mInterpolateVelocity[1]);
                    continue;
                }
                keyCycleOscillator.setProperty(view, f2);
            }
        }
        return bl;
    }

    String name() {
        return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
    }

    void positionKeyframe(View view, KeyPositionBase keyPositionBase, float f, float f2, String[] stringArray, float[] fArray) {
        RectF rectF = new RectF();
        rectF.left = this.mStartMotionPath.x;
        rectF.top = this.mStartMotionPath.y;
        rectF.right = rectF.left + this.mStartMotionPath.width;
        rectF.bottom = rectF.top + this.mStartMotionPath.height;
        RectF rectF2 = new RectF();
        rectF2.left = this.mEndMotionPath.x;
        rectF2.top = this.mEndMotionPath.y;
        rectF2.right = rectF2.left + this.mEndMotionPath.width;
        rectF2.bottom = rectF2.top + this.mEndMotionPath.height;
        keyPositionBase.positionAttributes(view, rectF, rectF2, f, f2, stringArray, fArray);
    }

    public void setDrawPath(int n) {
        this.mStartMotionPath.mDrawPath = n;
    }

    void setEndState(ConstraintWidget constraintWidget, ConstraintSet constraintSet) {
        this.mEndMotionPath.time = 1.0f;
        this.mEndMotionPath.position = 1.0f;
        this.readView(this.mEndMotionPath);
        this.mEndMotionPath.setBounds(constraintWidget.getX(), constraintWidget.getY(), constraintWidget.getWidth(), constraintWidget.getHeight());
        this.mEndMotionPath.applyParameters(constraintSet.getParameters(this.mId));
        this.mEndPoint.setState(constraintWidget, constraintSet, this.mId);
    }

    public void setPathMotionArc(int n) {
        this.mPathMotionArc = n;
    }

    void setStartCurrentState(View view) {
        this.mStartMotionPath.time = 0.0f;
        this.mStartMotionPath.position = 0.0f;
        this.mStartMotionPath.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mStartPoint.setState(view);
    }

    void setStartState(ConstraintWidget constraintWidget, ConstraintSet constraintSet) {
        this.mStartMotionPath.time = 0.0f;
        this.mStartMotionPath.position = 0.0f;
        this.readView(this.mStartMotionPath);
        this.mStartMotionPath.setBounds(constraintWidget.getX(), constraintWidget.getY(), constraintWidget.getWidth(), constraintWidget.getHeight());
        ConstraintSet.Constraint constraint = constraintSet.getParameters(this.mId);
        this.mStartMotionPath.applyParameters(constraint);
        this.mMotionStagger = constraint.motion.mMotionStagger;
        this.mStartPoint.setState(constraintWidget, constraintSet, this.mId);
    }

    public void setView(View view) {
        this.mView = view;
        this.mId = view.getId();
        if ((view = view.getLayoutParams()) instanceof ConstraintLayout.LayoutParams) {
            this.mConstraintTag = ((ConstraintLayout.LayoutParams)view).getConstraintTag();
        }
    }

    /*
     * WARNING - void declaration
     */
    public void setup(int n, int n2, float f, long l) {
        int n3;
        Object object;
        Object object2;
        HashSet object42 = new HashSet();
        Object object3 = new HashSet<String>();
        Object object4 = new HashSet<String>();
        HashSet<String> hashSet = new HashSet<String>();
        Object object5 = new HashMap<String, Integer>();
        Object object6 = null;
        Object var12_42 = null;
        if (this.mPathMotionArc != Key.UNSET) {
            this.mStartMotionPath.mPathMotionArc = this.mPathMotionArc;
        }
        this.mStartPoint.different(this.mEndPoint, (HashSet<String>)object4);
        if (this.mKeyList != null) {
            void var12_43;
            for (Key key : this.mKeyList) {
                if (key instanceof KeyPosition) {
                    object6 = (KeyPosition)key;
                    this.insertKey(new MotionPaths(n, n2, (KeyPosition)object6, this.mStartMotionPath, this.mEndMotionPath));
                    if (((KeyPosition)object6).mCurveFit == Key.UNSET) continue;
                    this.mCurveFitType = ((KeyPosition)object6).mCurveFit;
                    continue;
                }
                if (key instanceof KeyCycle) {
                    key.getAttributeNames(hashSet);
                    continue;
                }
                if (key instanceof KeyTimeCycle) {
                    key.getAttributeNames((HashSet<String>)object3);
                    continue;
                }
                if (key instanceof KeyTrigger) {
                    object6 = var12_43;
                    if (var12_43 == null) {
                        object6 = new ArrayList<KeyTrigger>();
                    }
                    ((ArrayList)object6).add((KeyTrigger)key);
                    ArrayList<KeyTrigger> arrayList = object6;
                    continue;
                }
                key.setInterpolation((HashMap<String, Integer>)object5);
                key.getAttributeNames((HashSet<String>)object4);
            }
            object6 = var12_43;
        }
        if (object6 != null) {
            this.mKeyTriggers = ((ArrayList)object6).toArray(new KeyTrigger[0]);
        }
        if (!((HashSet)object4).isEmpty()) {
            this.mAttributesMap = new HashMap();
            Iterator<String> iterator2 = ((HashSet)object4).iterator();
            while (iterator2.hasNext()) {
                void var12_49;
                object2 = iterator2.next();
                if (((String)object2).startsWith("CUSTOM,")) {
                    object = new SparseArray();
                    String string2 = ((String)object2).split(",")[1];
                    for (Key key : this.mKeyList) {
                        ConstraintAttribute constraintAttribute;
                        if (key.mCustomConstraints == null || (constraintAttribute = key.mCustomConstraints.get(string2)) == null) continue;
                        object.append(key.mFramePosition, (Object)constraintAttribute);
                    }
                    SplineSet splineSet = SplineSet.makeCustomSpline((String)object2, (SparseArray<ConstraintAttribute>)object);
                } else {
                    SplineSet splineSet = SplineSet.makeSpline((String)object2);
                }
                if (var12_49 == null) continue;
                var12_49.setType((String)object2);
                this.mAttributesMap.put((String)object2, (SplineSet)var12_49);
            }
            if (this.mKeyList != null) {
                for (Key key : this.mKeyList) {
                    if (!(key instanceof KeyAttributes)) continue;
                    key.addValues(this.mAttributesMap);
                }
            }
            this.mStartPoint.addValues(this.mAttributesMap, 0);
            this.mEndPoint.addValues(this.mAttributesMap, 100);
            for (String string3 : this.mAttributesMap.keySet()) {
                n = 0;
                if (((HashMap)object5).containsKey(string3)) {
                    n = ((HashMap)object5).get(string3);
                }
                this.mAttributesMap.get(string3).setup(n);
            }
        }
        if (!((HashSet)object3).isEmpty()) {
            if (this.mTimeCycleAttributesMap == null) {
                this.mTimeCycleAttributesMap = new HashMap();
            }
            Iterator iterator3 = ((HashSet)object3).iterator();
            while (iterator3.hasNext()) {
                void var14_15;
                object2 = (String)iterator3.next();
                if (this.mTimeCycleAttributesMap.containsKey(object2)) continue;
                if (((String)object2).startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String string4 = ((String)object2).split(",")[1];
                    for (Key key : this.mKeyList) {
                        if (key.mCustomConstraints == null || (object = key.mCustomConstraints.get(string4)) == null) continue;
                        sparseArray.append(key.mFramePosition, object);
                    }
                    TimeCycleSplineSet timeCycleSplineSet = TimeCycleSplineSet.makeCustomSpline((String)object2, (SparseArray<ConstraintAttribute>)sparseArray);
                } else {
                    TimeCycleSplineSet timeCycleSplineSet = TimeCycleSplineSet.makeSpline((String)object2, l);
                }
                if (var14_15 == null) continue;
                var14_15.setType((String)object2);
                this.mTimeCycleAttributesMap.put((String)object2, (TimeCycleSplineSet)var14_15);
            }
            if (this.mKeyList != null) {
                for (Key key : this.mKeyList) {
                    if (!(key instanceof KeyTimeCycle)) continue;
                    ((KeyTimeCycle)key).addTimeValues(this.mTimeCycleAttributesMap);
                }
            }
            for (String string5 : this.mTimeCycleAttributesMap.keySet()) {
                n = 0;
                if (((HashMap)object5).containsKey(string5)) {
                    n = ((HashMap)object5).get(string5);
                }
                this.mTimeCycleAttributesMap.get(string5).setup(n);
            }
        }
        object2 = new MotionPaths[this.mMotionPaths.size() + 2];
        n = 1;
        object2[0] = this.mStartMotionPath;
        object2[((MotionPaths[])object2).length - 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0 && this.mCurveFitType == -1) {
            this.mCurveFitType = 0;
        }
        Iterator<MotionPaths> iterator4 = this.mMotionPaths.iterator();
        while (iterator4.hasNext()) {
            object2[n] = iterator4.next();
            ++n;
        }
        int n4 = 18;
        HashSet<String> hashSet2 = new HashSet<String>();
        for (String string6 : this.mEndMotionPath.attributes.keySet()) {
            if (!this.mStartMotionPath.attributes.containsKey(string6) || ((HashSet)object4).contains("CUSTOM," + string6)) continue;
            hashSet2.add(string6);
        }
        this.mAttributeNames = hashSet2.toArray(new String[0]);
        this.mAttributeInterpCount = new int[this.mAttributeNames.length];
        HashSet<String> hashSet3 = object3;
        block11: for (n = 0; n < this.mAttributeNames.length; ++n) {
            String string7 = this.mAttributeNames[n];
            this.mAttributeInterpCount[n] = 0;
            for (n2 = 0; n2 < ((Object)object2).length; ++n2) {
                if (!((MotionPaths)object2[n2]).attributes.containsKey(string7)) continue;
                object3 = this.mAttributeInterpCount;
                object3[n] = object3[n] + ((MotionPaths)object2[n2]).attributes.get(string7).noOfInterpValues();
                continue block11;
            }
        }
        boolean bl = ((MotionPaths)object2[0]).mPathMotionArc != Key.UNSET;
        object3 = new boolean[this.mAttributeNames.length + 18];
        HashSet<String> hashSet4 = object4;
        for (n = 1; n < ((Object)object2).length; ++n) {
            ((MotionPaths)object2[n]).different((MotionPaths)object2[n - 1], (boolean[])object3, this.mAttributeNames, bl);
        }
        n2 = 0;
        for (n = 1; n < ((Object)object3).length; ++n) {
            n3 = n2;
            if (object3[n] != false) {
                n3 = n2 + 1;
            }
            n2 = n3;
        }
        this.mInterpolateVariables = new int[n2];
        this.mInterpolateData = new double[this.mInterpolateVariables.length];
        this.mInterpolateVelocity = new double[this.mInterpolateVariables.length];
        n = 0;
        for (n2 = 1; n2 < ((Object)object3).length; ++n2) {
            n3 = n;
            if (object3[n2] != false) {
                this.mInterpolateVariables[n] = n2;
                n3 = n + 1;
            }
            n = n3;
        }
        n2 = ((Object)object2).length;
        n3 = this.mInterpolateVariables.length;
        object4 = new double[n2][n3];
        double[] dArray = new double[((Object)object2).length];
        for (n2 = 0; n2 < ((Object)object2).length; ++n2) {
            ((MotionPaths)object2[n2]).fillStandard((double[])object4[n2], this.mInterpolateVariables);
            dArray[n2] = ((MotionPaths)object2[n2]).time;
        }
        ArrayList<KeyTrigger> arrayList = object6;
        object6 = object5;
        for (n = 0; n < this.mInterpolateVariables.length; ++n) {
            if (this.mInterpolateVariables[n] >= MotionPaths.names.length) continue;
            String string8 = MotionPaths.names[this.mInterpolateVariables[n]] + " [";
            for (n2 = 0; n2 < ((Object)object2).length; ++n2) {
                void var14_26;
                String string9 = (String)var14_26 + (double)object4[n2][n];
            }
        }
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        n = n4;
        Object object7 = object3;
        for (n2 = 0; n2 < this.mAttributeNames.length; ++n2) {
            void var14_30;
            n4 = 0;
            object6 = null;
            Object var14_29 = null;
            object3 = this.mAttributeNames[n2];
            for (n3 = 0; n3 < ((Object)object2).length; ++n3) {
                if (!((MotionPaths)object2[n3]).hasCustomData((String)object3)) continue;
                object5 = object6;
                if (object6 == null) {
                    double[] dArray2 = new double[((Object)object2).length];
                    int n5 = ((Object)object2).length;
                    int n6 = ((MotionPaths)object2[n3]).getCustomDataCount((String)object3);
                    object5 = new double[n5][n6];
                }
                var14_30[n4] = ((MotionPaths)object2[n3]).time;
                ((MotionPaths)object2[n3]).getCustomData((String)object3, (double[])object5[n4], 0);
                ++n4;
                object6 = object5;
            }
            double[] dArray3 = Arrays.copyOf((double[])var14_30, n4);
            object6 = (double[][])Arrays.copyOf(object6, n4);
            this.mSpline[n2 + 1] = CurveFit.get(this.mCurveFitType, dArray3, object6);
        }
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, dArray, (double[][])object4);
        if (((MotionPaths)object2[0]).mPathMotionArc != Key.UNSET) {
            n2 = ((Object)object2).length;
            object6 = new int[n2];
            double[] dArray4 = new double[n2];
            double[][] dArray5 = new double[n2][2];
            for (n = 0; n < n2; ++n) {
                object6[n] = (Iterator<String>)((MotionPaths)object2[n]).mPathMotionArc;
                dArray4[n] = ((MotionPaths)object2[n]).time;
                dArray5[n][0] = ((MotionPaths)object2[n]).x;
                dArray5[n][1] = ((MotionPaths)object2[n]).y;
            }
            this.mArcSpline = CurveFit.getArc(object6, dArray4, dArray5);
        }
        float f2 = Float.NaN;
        this.mCycleMap = new HashMap();
        if (this.mKeyList != null) {
            for (String string10 : hashSet) {
                KeyCycleOscillator keyCycleOscillator = KeyCycleOscillator.makeSpline(string10);
                if (keyCycleOscillator == null) continue;
                f = f2;
                if (keyCycleOscillator.variesByPath()) {
                    f = f2;
                    if (Float.isNaN(f2)) {
                        f = this.getPreCycleDistance();
                    }
                }
                keyCycleOscillator.setType(string10);
                this.mCycleMap.put(string10, keyCycleOscillator);
                f2 = f;
            }
            for (Key key : this.mKeyList) {
                if (!(key instanceof KeyCycle)) continue;
                ((KeyCycle)key).addCycleValues(this.mCycleMap);
            }
            Iterator<KeyCycleOscillator> iterator5 = this.mCycleMap.values().iterator();
            while (iterator5.hasNext()) {
                iterator5.next().setup(f2);
            }
        }
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.x + " y: " + this.mStartMotionPath.y + " end: x: " + this.mEndMotionPath.x + " y: " + this.mEndMotionPath.y;
    }
}

