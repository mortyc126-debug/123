/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.motion.utils;

public class HyperSpline {
    double[][] mCtl;
    Cubic[][] mCurve;
    double[] mCurveLength;
    int mDimensionality;
    int mPoints;
    double mTotalLength;

    public HyperSpline() {
    }

    public HyperSpline(double[][] dArray) {
        this.setup(dArray);
    }

    static Cubic[] calcNaturalCubic(int n, double[] dArray) {
        Object[] objectArray = new double[n];
        double[] dArray2 = new double[n];
        double[] dArray3 = new double[n];
        int n2 = n - 1;
        objectArray[0] = 0.5;
        for (n = 1; n < n2; ++n) {
            objectArray[n] = 1.0 / (4.0 - objectArray[n - 1]);
        }
        objectArray[n2] = 1.0 / (2.0 - objectArray[n2 - 1]);
        dArray2[0] = (dArray[1] - dArray[0]) * 3.0 * objectArray[0];
        for (n = 1; n < n2; ++n) {
            dArray2[n] = ((dArray[n + 1] - dArray[n - 1]) * 3.0 - dArray2[n - 1]) * objectArray[n];
        }
        dArray2[n2] = ((dArray[n2] - dArray[n2 - 1]) * 3.0 - dArray2[n2 - 1]) * objectArray[n2];
        dArray3[n2] = dArray2[n2];
        for (n = n2 - 1; n >= 0; --n) {
            dArray3[n] = dArray2[n] - objectArray[n] * dArray3[n + 1];
        }
        objectArray = new Cubic[n2];
        for (n = 0; n < n2; ++n) {
            objectArray[n] = (double)new Cubic((float)dArray[n], dArray3[n], (dArray[n + 1] - dArray[n]) * 3.0 - dArray3[n] * 2.0 - dArray3[n + 1], (dArray[n] - dArray[n + 1]) * 2.0 + dArray3[n] + dArray3[n + 1]);
        }
        return objectArray;
    }

    public double approxLength(Cubic[] cubicArray) {
        double d;
        double d2;
        double d3;
        double d4 = 0.0;
        int n = cubicArray.length;
        double[] dArray = new double[cubicArray.length];
        for (d3 = 0.0; d3 < 1.0; d3 += 0.1) {
            d2 = 0.0;
            for (n = 0; n < cubicArray.length; ++n) {
                double d5;
                d = dArray[n];
                dArray[n] = d5 = cubicArray[n].eval(d3);
                d2 += (d -= d5) * d;
            }
            d = d4;
            if (d3 > 0.0) {
                d = d4 + Math.sqrt(d2);
            }
            d4 = d;
        }
        d3 = 0.0;
        for (n = 0; n < cubicArray.length; ++n) {
            d = dArray[n];
            dArray[n] = d2 = cubicArray[n].eval(1.0);
            d2 = d - d2;
            d3 += d2 * d2;
        }
        return d4 + Math.sqrt(d3);
    }

    public double getPos(double d, int n) {
        int n2;
        d = this.mTotalLength * d;
        for (n2 = 0; n2 < this.mCurveLength.length - 1 && this.mCurveLength[n2] < d; d -= this.mCurveLength[n2], ++n2) {
        }
        return this.mCurve[n][n2].eval(d / this.mCurveLength[n2]);
    }

    public void getPos(double d, double[] dArray) {
        int n;
        d = this.mTotalLength * d;
        for (n = 0; n < this.mCurveLength.length - 1 && this.mCurveLength[n] < d; d -= this.mCurveLength[n], ++n) {
        }
        for (int i = 0; i < dArray.length; ++i) {
            dArray[i] = this.mCurve[i][n].eval(d / this.mCurveLength[n]);
        }
    }

    public void getPos(double d, float[] fArray) {
        int n;
        d = this.mTotalLength * d;
        for (n = 0; n < this.mCurveLength.length - 1 && this.mCurveLength[n] < d; d -= this.mCurveLength[n], ++n) {
        }
        for (int i = 0; i < fArray.length; ++i) {
            fArray[i] = (float)this.mCurve[i][n].eval(d / this.mCurveLength[n]);
        }
    }

    public void getVelocity(double d, double[] dArray) {
        int n;
        d = this.mTotalLength * d;
        for (n = 0; n < this.mCurveLength.length - 1 && this.mCurveLength[n] < d; d -= this.mCurveLength[n], ++n) {
        }
        for (int i = 0; i < dArray.length; ++i) {
            dArray[i] = this.mCurve[i][n].vel(d / this.mCurveLength[n]);
        }
    }

    public void setup(double[][] object) {
        this.mDimensionality = object[0].length;
        this.mPoints = ((double[][])object).length;
        int n = this.mDimensionality;
        int n2 = this.mPoints;
        this.mCtl = new double[n][n2];
        this.mCurve = new Cubic[this.mDimensionality][];
        for (n = 0; n < this.mDimensionality; ++n) {
            for (n2 = 0; n2 < this.mPoints; ++n2) {
                this.mCtl[n][n2] = object[n2][n];
            }
        }
        for (n = 0; n < this.mDimensionality; ++n) {
            this.mCurve[n] = HyperSpline.calcNaturalCubic(this.mCtl[n].length, this.mCtl[n]);
        }
        this.mCurveLength = new double[this.mPoints - 1];
        this.mTotalLength = 0.0;
        object = new Cubic[this.mDimensionality];
        for (n = 0; n < this.mCurveLength.length; ++n) {
            double d;
            for (n2 = 0; n2 < this.mDimensionality; ++n2) {
                object[n2] = (double[])this.mCurve[n2][n];
            }
            double d2 = this.mTotalLength;
            double[] dArray = this.mCurveLength;
            dArray[n] = d = this.approxLength((Cubic[])object);
            this.mTotalLength = d2 + d;
        }
    }

    public static class Cubic {
        public static final double HALF = 0.5;
        public static final double THIRD = 0.3333333333333333;
        double mA;
        double mB;
        double mC;
        double mD;

        public Cubic(double d, double d2, double d3, double d4) {
            this.mA = d;
            this.mB = d2;
            this.mC = d3;
            this.mD = d4;
        }

        public double eval(double d) {
            return ((this.mD * d + this.mC) * d + this.mB) * d + this.mA;
        }

        public double vel(double d) {
            return (this.mD * 0.3333333333333333 * d + this.mC * 0.5) * d + this.mB;
        }
    }
}

