/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.View
 */
package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.widget.KeyCache;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;

public abstract class TimeCycleSplineSet {
    private static final int CURVE_OFFSET = 2;
    private static final int CURVE_PERIOD = 1;
    private static final int CURVE_VALUE = 0;
    private static final String TAG = "SplineSet";
    private static float VAL_2PI = (float)Math.PI * 2;
    private int count;
    float last_cycle;
    long last_time;
    private float[] mCache;
    protected boolean mContinue = false;
    protected CurveFit mCurveFit;
    protected int[] mTimePoints = new int[10];
    private String mType;
    protected float[][] mValues = new float[10][3];
    protected int mWaveShape = 0;

    public TimeCycleSplineSet() {
        this.mCache = new float[3];
        this.last_cycle = Float.NaN;
    }

    static TimeCycleSplineSet makeCustomSpline(String string2, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(string2, sparseArray);
    }

    /*
     * Enabled aggressive block sorting
     */
    static TimeCycleSplineSet makeSpline(String object, long l) {
        int n;
        block28: {
            switch (((String)object).hashCode()) {
                case 92909918: {
                    if (!((String)object).equals("alpha")) break;
                    n = 0;
                    break block28;
                }
                case 37232917: {
                    if (!((String)object).equals("transitionPathRotate")) break;
                    n = 5;
                    break block28;
                }
                case -4379043: {
                    if (!((String)object).equals("elevation")) break;
                    n = 1;
                    break block28;
                }
                case -40300674: {
                    if (!((String)object).equals("rotation")) break;
                    n = 2;
                    break block28;
                }
                case -908189617: {
                    if (!((String)object).equals("scaleY")) break;
                    n = 7;
                    break block28;
                }
                case -908189618: {
                    if (!((String)object).equals("scaleX")) break;
                    n = 6;
                    break block28;
                }
                case -1001078227: {
                    if (!((String)object).equals("progress")) break;
                    n = 11;
                    break block28;
                }
                case -1225497655: {
                    if (!((String)object).equals("translationZ")) break;
                    n = 10;
                    break block28;
                }
                case -1225497656: {
                    if (!((String)object).equals("translationY")) break;
                    n = 9;
                    break block28;
                }
                case -1225497657: {
                    if (!((String)object).equals("translationX")) break;
                    n = 8;
                    break block28;
                }
                case -1249320805: {
                    if (!((String)object).equals("rotationY")) break;
                    n = 4;
                    break block28;
                }
                case -1249320806: {
                    if (!((String)object).equals("rotationX")) break;
                    n = 3;
                    break block28;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                return null;
            }
            case 11: {
                object = new ProgressSet();
                break;
            }
            case 10: {
                object = new TranslationZset();
                break;
            }
            case 9: {
                object = new TranslationYset();
                break;
            }
            case 8: {
                object = new TranslationXset();
                break;
            }
            case 7: {
                object = new ScaleYset();
                break;
            }
            case 6: {
                object = new ScaleXset();
                break;
            }
            case 5: {
                object = new PathRotate();
                break;
            }
            case 4: {
                object = new RotationYset();
                break;
            }
            case 3: {
                object = new RotationXset();
                break;
            }
            case 2: {
                object = new RotationSet();
                break;
            }
            case 1: {
                object = new ElevationSet();
                break;
            }
            case 0: {
                object = new AlphaSet();
            }
        }
        ((TimeCycleSplineSet)object).setStartTime(l);
        return object;
    }

    protected float calcWave(float f) {
        switch (this.mWaveShape) {
            default: {
                return (float)Math.sin(VAL_2PI * f);
            }
            case 6: {
                f = 1.0f - Math.abs(f * 4.0f % 4.0f - 2.0f);
                return 1.0f - f * f;
            }
            case 5: {
                return (float)Math.cos(VAL_2PI * f);
            }
            case 4: {
                return 1.0f - (f * 2.0f + 1.0f) % 2.0f;
            }
            case 3: {
                return (f * 2.0f + 1.0f) % 2.0f - 1.0f;
            }
            case 2: {
                return 1.0f - Math.abs(f);
            }
            case 1: 
        }
        return Math.signum(VAL_2PI * f);
    }

    public float get(float f, long l, View view, KeyCache keyCache) {
        this.mCurveFit.getPos((double)f, this.mCache);
        float f2 = this.mCache[1];
        boolean bl = false;
        if (f2 == 0.0f) {
            this.mContinue = false;
            return this.mCache[2];
        }
        if (Float.isNaN(this.last_cycle)) {
            this.last_cycle = keyCache.getFloatValue(view, this.mType, 0);
            if (Float.isNaN(this.last_cycle)) {
                this.last_cycle = 0.0f;
            }
        }
        long l2 = this.last_time;
        this.last_cycle = (float)(((double)this.last_cycle + (double)(l - l2) * 1.0E-9 * (double)f2) % 1.0);
        keyCache.setFloatValue(view, this.mType, 0, this.last_cycle);
        this.last_time = l;
        float f3 = this.mCache[0];
        float f4 = this.calcWave(this.last_cycle);
        f = this.mCache[2];
        if (f3 != 0.0f || f2 != 0.0f) {
            bl = true;
        }
        this.mContinue = bl;
        return f3 * f4 + f;
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public void setPoint(int n, float f, float f2, int n2, float f3) {
        this.mTimePoints[this.count] = n;
        this.mValues[this.count][0] = f;
        this.mValues[this.count][1] = f2;
        this.mValues[this.count][2] = f3;
        this.mWaveShape = Math.max(this.mWaveShape, n2);
        ++this.count;
    }

    public abstract boolean setProperty(View var1, float var2, long var3, KeyCache var5);

    protected void setStartTime(long l) {
        this.last_time = l;
    }

    public void setType(String string2) {
        this.mType = string2;
    }

    public void setup(int n) {
        int n2;
        if (this.count == 0) {
            Log.e((String)TAG, (String)("Error no points added to " + this.mType));
            return;
        }
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, this.count - 1);
        int n3 = 0;
        for (n2 = 1; n2 < this.mTimePoints.length; ++n2) {
            int n4 = n3;
            if (this.mTimePoints[n2] != this.mTimePoints[n2 - 1]) {
                n4 = n3 + 1;
            }
            n3 = n4;
        }
        n2 = n3;
        if (n3 == 0) {
            n2 = 1;
        }
        double[] dArray = new double[n2];
        double[][] dArray2 = new double[n2][3];
        n2 = 0;
        for (n3 = 0; n3 < this.count; ++n3) {
            if (n3 > 0 && this.mTimePoints[n3] == this.mTimePoints[n3 - 1]) continue;
            dArray[n2] = (double)this.mTimePoints[n3] * 0.01;
            dArray2[n2][0] = this.mValues[n3][0];
            dArray2[n2][1] = this.mValues[n3][1];
            dArray2[n2][2] = this.mValues[n3][2];
            ++n2;
        }
        this.mCurveFit = CurveFit.get(n, dArray, dArray2);
    }

    public String toString() {
        String string2 = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i = 0; i < this.count; ++i) {
            string2 = string2 + "[" + this.mTimePoints[i] + " , " + decimalFormat.format(this.mValues[i]) + "] ";
        }
        return string2;
    }

    static class AlphaSet
    extends TimeCycleSplineSet {
        AlphaSet() {
        }

        @Override
        public boolean setProperty(View view, float f, long l, KeyCache keyCache) {
            view.setAlpha(this.get(f, l, view, keyCache));
            return this.mContinue;
        }
    }

    static class CustomSet
    extends TimeCycleSplineSet {
        String mAttributeName;
        float[] mCache;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;
        SparseArray<float[]> mWaveProperties = new SparseArray();

        public CustomSet(String string2, SparseArray<ConstraintAttribute> sparseArray) {
            this.mAttributeName = string2.split(",")[1];
            this.mConstraintAttributeList = sparseArray;
        }

        @Override
        public void setPoint(int n, float f, float f2, int n2, float f3) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public void setPoint(int n, ConstraintAttribute constraintAttribute, float f, int n2, float f2) {
            this.mConstraintAttributeList.append(n, (Object)constraintAttribute);
            this.mWaveProperties.append(n, (Object)new float[]{f, f2});
            this.mWaveShape = Math.max(this.mWaveShape, n2);
        }

        @Override
        public boolean setProperty(View view, float f, long l, KeyCache keyCache) {
            this.mCurveFit.getPos((double)f, this.mTempValues);
            float f2 = this.mTempValues[this.mTempValues.length - 2];
            float f3 = this.mTempValues[this.mTempValues.length - 1];
            long l2 = this.last_time;
            this.last_cycle = (float)(((double)this.last_cycle + (double)(l - l2) * 1.0E-9 * (double)f2) % 1.0);
            this.last_time = l;
            f = this.calcWave(this.last_cycle);
            this.mContinue = false;
            for (int i = 0; i < this.mCache.length; ++i) {
                boolean bl = this.mContinue;
                boolean bl2 = (double)this.mTempValues[i] != 0.0;
                this.mContinue = bl | bl2;
                this.mCache[i] = this.mTempValues[i] * f + f3;
            }
            ((ConstraintAttribute)this.mConstraintAttributeList.valueAt(0)).setInterpolatedValue(view, this.mCache);
            if (f2 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        @Override
        public void setup(int n) {
            int n2 = this.mConstraintAttributeList.size();
            int n3 = ((ConstraintAttribute)this.mConstraintAttributeList.valueAt(0)).noOfInterpValues();
            double[] dArray = new double[n2];
            this.mTempValues = new float[n3 + 2];
            this.mCache = new float[n3];
            double[][] dArray2 = new double[n2][n3 + 2];
            for (int i = 0; i < n2; ++i) {
                int n4 = this.mConstraintAttributeList.keyAt(i);
                ConstraintAttribute constraintAttribute = (ConstraintAttribute)this.mConstraintAttributeList.valueAt(i);
                float[] fArray = (float[])this.mWaveProperties.valueAt(i);
                dArray[i] = (double)n4 * 0.01;
                constraintAttribute.getValuesToInterpolate(this.mTempValues);
                for (n4 = 0; n4 < this.mTempValues.length; ++n4) {
                    dArray2[i][n4] = this.mTempValues[n4];
                }
                dArray2[i][n3] = fArray[0];
                dArray2[i][n3 + 1] = fArray[1];
            }
            this.mCurveFit = CurveFit.get(n, dArray, dArray2);
        }
    }

    static class ElevationSet
    extends TimeCycleSplineSet {
        ElevationSet() {
        }

        @Override
        public boolean setProperty(View view, float f, long l, KeyCache keyCache) {
            view.setElevation(this.get(f, l, view, keyCache));
            return this.mContinue;
        }
    }

    static class PathRotate
    extends TimeCycleSplineSet {
        PathRotate() {
        }

        public boolean setPathRotate(View view, KeyCache keyCache, float f, long l, double d, double d2) {
            view.setRotation(this.get(f, l, view, keyCache) + (float)Math.toDegrees(Math.atan2(d2, d)));
            return this.mContinue;
        }

        @Override
        public boolean setProperty(View view, float f, long l, KeyCache keyCache) {
            return this.mContinue;
        }
    }

    static class ProgressSet
    extends TimeCycleSplineSet {
        boolean mNoMethod = false;

        ProgressSet() {
        }

        @Override
        public boolean setProperty(View view, float f, long l, KeyCache keyCache) {
            if (view instanceof MotionLayout) {
                ((MotionLayout)view).setProgress(this.get(f, l, view, keyCache));
            } else {
                Method method;
                if (this.mNoMethod) {
                    return false;
                }
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    this.mNoMethod = true;
                    method = null;
                }
                if (method != null) {
                    try {
                        method.invoke((Object)view, Float.valueOf(this.get(f, l, view, keyCache)));
                    }
                    catch (InvocationTargetException invocationTargetException) {
                        Log.e((String)TimeCycleSplineSet.TAG, (String)"unable to setProgress", (Throwable)invocationTargetException);
                    }
                    catch (IllegalAccessException illegalAccessException) {
                        Log.e((String)TimeCycleSplineSet.TAG, (String)"unable to setProgress", (Throwable)illegalAccessException);
                    }
                }
            }
            return this.mContinue;
        }
    }

    static class RotationSet
    extends TimeCycleSplineSet {
        RotationSet() {
        }

        @Override
        public boolean setProperty(View view, float f, long l, KeyCache keyCache) {
            view.setRotation(this.get(f, l, view, keyCache));
            return this.mContinue;
        }
    }

    static class RotationXset
    extends TimeCycleSplineSet {
        RotationXset() {
        }

        @Override
        public boolean setProperty(View view, float f, long l, KeyCache keyCache) {
            view.setRotationX(this.get(f, l, view, keyCache));
            return this.mContinue;
        }
    }

    static class RotationYset
    extends TimeCycleSplineSet {
        RotationYset() {
        }

        @Override
        public boolean setProperty(View view, float f, long l, KeyCache keyCache) {
            view.setRotationY(this.get(f, l, view, keyCache));
            return this.mContinue;
        }
    }

    static class ScaleXset
    extends TimeCycleSplineSet {
        ScaleXset() {
        }

        @Override
        public boolean setProperty(View view, float f, long l, KeyCache keyCache) {
            view.setScaleX(this.get(f, l, view, keyCache));
            return this.mContinue;
        }
    }

    static class ScaleYset
    extends TimeCycleSplineSet {
        ScaleYset() {
        }

        @Override
        public boolean setProperty(View view, float f, long l, KeyCache keyCache) {
            view.setScaleY(this.get(f, l, view, keyCache));
            return this.mContinue;
        }
    }

    private static class Sort {
        private Sort() {
        }

        static void doubleQuickSort(int[] nArray, float[][] fArray, int n, int n2) {
            int[] nArray2 = new int[nArray.length + 10];
            int n3 = 0 + 1;
            nArray2[0] = n2;
            n2 = n3 + 1;
            nArray2[n3] = n;
            n = n2;
            while (n > 0) {
                int n4 = nArray2[--n];
                n2 = n - 1;
                int n5 = nArray2[n2];
                n = n2;
                if (n4 >= n5) continue;
                n3 = Sort.partition(nArray, fArray, n4, n5);
                n = n2 + 1;
                nArray2[n2] = n3 - 1;
                n2 = n + 1;
                nArray2[n] = n4;
                n4 = n2 + 1;
                nArray2[n2] = n5;
                n = n4 + 1;
                nArray2[n4] = n3 + 1;
            }
        }

        private static int partition(int[] nArray, float[][] fArray, int n, int n2) {
            int n3;
            int n4 = nArray[n2];
            int n5 = n3 = n;
            while (n < n2) {
                n3 = n5;
                if (nArray[n] <= n4) {
                    Sort.swap(nArray, fArray, n5, n);
                    n3 = n5 + 1;
                }
                ++n;
                n5 = n3;
            }
            Sort.swap(nArray, fArray, n5, n2);
            return n5;
        }

        private static void swap(int[] objectArray, float[][] fArray, int n, int n2) {
            int n3 = objectArray[n];
            objectArray[n] = objectArray[n2];
            objectArray[n2] = n3;
            objectArray = fArray[n];
            fArray[n] = fArray[n2];
            fArray[n2] = objectArray;
        }
    }

    static class TranslationXset
    extends TimeCycleSplineSet {
        TranslationXset() {
        }

        @Override
        public boolean setProperty(View view, float f, long l, KeyCache keyCache) {
            view.setTranslationX(this.get(f, l, view, keyCache));
            return this.mContinue;
        }
    }

    static class TranslationYset
    extends TimeCycleSplineSet {
        TranslationYset() {
        }

        @Override
        public boolean setProperty(View view, float f, long l, KeyCache keyCache) {
            view.setTranslationY(this.get(f, l, view, keyCache));
            return this.mContinue;
        }
    }

    static class TranslationZset
    extends TimeCycleSplineSet {
        TranslationZset() {
        }

        @Override
        public boolean setProperty(View view, float f, long l, KeyCache keyCache) {
            view.setTranslationZ(this.get(f, l, view, keyCache));
            return this.mContinue;
        }
    }
}

