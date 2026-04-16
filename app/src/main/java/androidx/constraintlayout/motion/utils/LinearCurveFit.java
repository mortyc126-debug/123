/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.motion.utils.CurveFit;

public class LinearCurveFit
extends CurveFit {
    private static final String TAG = "LinearCurveFit";
    private double[] mT;
    private double mTotalLength;
    private double[][] mY;

    public LinearCurveFit(double[] dArray, double[][] dArray2) {
        block2: {
            this.mTotalLength = Double.NaN;
            int n = dArray.length;
            int n2 = dArray2[0].length;
            this.mT = dArray;
            this.mY = dArray2;
            if (n2 <= 2) break block2;
            double d = 0.0;
            double d2 = 0.0;
            double d3 = 0.0;
            for (n = 0; n < dArray.length; ++n) {
                double d4 = dArray2[n][0];
                double d5 = dArray2[n][0];
                if (n > 0) {
                    d += Math.hypot(d4 - d2, d5 - d3);
                }
                d2 = d4;
                d3 = d5;
            }
            this.mTotalLength = 0.0;
        }
    }

    private double getLength2D(double d) {
        if (Double.isNaN(this.mTotalLength)) {
            return 0.0;
        }
        int n = this.mT.length;
        if (d <= this.mT[0]) {
            return 0.0;
        }
        if (d >= this.mT[n - 1]) {
            return this.mTotalLength;
        }
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        for (int i = 0; i < n - 1; ++i) {
            double d5 = this.mY[i][0];
            double d6 = this.mY[i][1];
            if (i > 0) {
                d2 += Math.hypot(d5 - d3, d6 - d4);
            }
            d3 = d5;
            d4 = d6;
            if (d == this.mT[i]) {
                return d2;
            }
            if (!(d < this.mT[i + 1])) continue;
            d3 = this.mT[i + 1];
            d4 = this.mT[i];
            d3 = (d - this.mT[i]) / (d3 - d4);
            d4 = this.mY[i][0];
            d = this.mY[i + 1][0];
            return d2 + Math.hypot(d6 - ((1.0 - d3) * this.mY[i][1] + this.mY[i + 1][1] * d3), d5 - ((1.0 - d3) * d4 + d * d3));
        }
        return 0.0;
    }

    @Override
    public double getPos(double d, int n) {
        int n2 = this.mT.length;
        if (d <= this.mT[0]) {
            return this.mY[0][n];
        }
        if (d >= this.mT[n2 - 1]) {
            return this.mY[n2 - 1][n];
        }
        for (int i = 0; i < n2 - 1; ++i) {
            if (d == this.mT[i]) {
                return this.mY[i][n];
            }
            if (!(d < this.mT[i + 1])) continue;
            double d2 = this.mT[i + 1];
            double d3 = this.mT[i];
            d = (d - this.mT[i]) / (d2 - d3);
            return (1.0 - d) * this.mY[i][n] + this.mY[i + 1][n] * d;
        }
        return 0.0;
    }

    @Override
    public void getPos(double d, double[] dArray) {
        int n = this.mT.length;
        int n2 = this.mY[0].length;
        if (d <= this.mT[0]) {
            for (int i = 0; i < n2; ++i) {
                dArray[i] = this.mY[0][i];
            }
            return;
        }
        if (d >= this.mT[n - 1]) {
            for (int i = 0; i < n2; ++i) {
                dArray[i] = this.mY[n - 1][i];
            }
            return;
        }
        for (int i = 0; i < n - 1; ++i) {
            int n3;
            if (d == this.mT[i]) {
                for (n3 = 0; n3 < n2; ++n3) {
                    dArray[n3] = this.mY[i][n3];
                }
            }
            if (!(d < this.mT[i + 1])) continue;
            double d2 = this.mT[i + 1];
            double d3 = this.mT[i];
            d = (d - this.mT[i]) / (d2 - d3);
            for (n3 = 0; n3 < n2; ++n3) {
                dArray[n3] = (1.0 - d) * this.mY[i][n3] + this.mY[i + 1][n3] * d;
            }
            return;
        }
    }

    @Override
    public void getPos(double d, float[] fArray) {
        int n = this.mT.length;
        int n2 = this.mY[0].length;
        if (d <= this.mT[0]) {
            for (int i = 0; i < n2; ++i) {
                fArray[i] = (float)this.mY[0][i];
            }
            return;
        }
        if (d >= this.mT[n - 1]) {
            for (int i = 0; i < n2; ++i) {
                fArray[i] = (float)this.mY[n - 1][i];
            }
            return;
        }
        for (int i = 0; i < n - 1; ++i) {
            int n3;
            if (d == this.mT[i]) {
                for (n3 = 0; n3 < n2; ++n3) {
                    fArray[n3] = (float)this.mY[i][n3];
                }
            }
            if (!(d < this.mT[i + 1])) continue;
            double d2 = this.mT[i + 1];
            double d3 = this.mT[i];
            d = (d - this.mT[i]) / (d2 - d3);
            for (n3 = 0; n3 < n2; ++n3) {
                fArray[n3] = (float)((1.0 - d) * this.mY[i][n3] + this.mY[i + 1][n3] * d);
            }
            return;
        }
    }

    @Override
    public double getSlope(double d, int n) {
        int n2 = this.mT.length;
        if (d < this.mT[0]) {
            d = this.mT[0];
        } else if (d >= this.mT[n2 - 1]) {
            d = this.mT[n2 - 1];
        }
        for (int i = 0; i < n2 - 1; ++i) {
            if (!(d <= this.mT[i + 1])) continue;
            double d2 = this.mT[i + 1] - this.mT[i];
            d = (d - this.mT[i]) / d2;
            d = this.mY[i][n];
            return (this.mY[i + 1][n] - d) / d2;
        }
        return 0.0;
    }

    @Override
    public void getSlope(double d, double[] dArray) {
        int n = this.mT.length;
        int n2 = this.mY[0].length;
        if (d <= this.mT[0]) {
            d = this.mT[0];
        } else if (d >= this.mT[n - 1]) {
            d = this.mT[n - 1];
        }
        for (int i = 0; i < n - 1; ++i) {
            if (!(d <= this.mT[i + 1])) continue;
            double d2 = this.mT[i + 1] - this.mT[i];
            d = (d - this.mT[i]) / d2;
            for (n = 0; n < n2; ++n) {
                d = this.mY[i][n];
                dArray[n] = (this.mY[i + 1][n] - d) / d2;
            }
            break;
        }
    }

    @Override
    public double[] getTimePoints() {
        return this.mT;
    }
}

