/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.motion.utils;

import java.util.Arrays;

public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    double PI2;
    double[] mArea;
    private boolean mNormalized = false;
    float[] mPeriod = new float[0];
    double[] mPosition = new double[0];
    int mType;

    public Oscillator() {
        this.PI2 = Math.PI * 2;
    }

    public void addPoint(double d, float f) {
        int n;
        int n2 = this.mPeriod.length + 1;
        int n3 = n = Arrays.binarySearch(this.mPosition, d);
        if (n < 0) {
            n3 = -n - 1;
        }
        this.mPosition = Arrays.copyOf(this.mPosition, n2);
        this.mPeriod = Arrays.copyOf(this.mPeriod, n2);
        this.mArea = new double[n2];
        System.arraycopy(this.mPosition, n3, this.mPosition, n3 + 1, n2 - n3 - 1);
        this.mPosition[n3] = d;
        this.mPeriod[n3] = f;
        this.mNormalized = false;
    }

    double getDP(double d) {
        if (d <= 0.0) {
            d = 1.0E-5;
        } else if (d >= 1.0) {
            d = 0.999999;
        }
        int n = Arrays.binarySearch(this.mPosition, d);
        double d2 = 0.0;
        if (n > 0) {
            return 0.0;
        }
        if (n != 0) {
            n = -n - 1;
            d2 = (double)(this.mPeriod[n] - this.mPeriod[n - 1]) / (this.mPosition[n] - this.mPosition[n - 1]);
            d2 = d2 * d + ((double)this.mPeriod[n - 1] - this.mPosition[n - 1] * d2);
        }
        return d2;
    }

    double getP(double d) {
        if (d < 0.0) {
            d = 0.0;
        } else if (d > 1.0) {
            d = 1.0;
        }
        int n = Arrays.binarySearch(this.mPosition, d);
        double d2 = 0.0;
        if (n > 0) {
            d2 = 1.0;
        } else if (n != 0) {
            n = -n - 1;
            d2 = (double)(this.mPeriod[n] - this.mPeriod[n - 1]) / (this.mPosition[n] - this.mPosition[n - 1]);
            d2 = this.mArea[n - 1] + ((double)this.mPeriod[n - 1] - this.mPosition[n - 1] * d2) * (d - this.mPosition[n - 1]) + (d * d - this.mPosition[n - 1] * this.mPosition[n - 1]) * d2 / 2.0;
        }
        return d2;
    }

    public double getSlope(double d) {
        switch (this.mType) {
            default: {
                return this.PI2 * this.getDP(d) * Math.cos(this.PI2 * this.getP(d));
            }
            case 6: {
                return this.getDP(d) * 4.0 * ((this.getP(d) * 4.0 + 2.0) % 4.0 - 2.0);
            }
            case 5: {
                return -this.PI2 * this.getDP(d) * Math.sin(this.PI2 * this.getP(d));
            }
            case 4: {
                return -this.getDP(d) * 2.0;
            }
            case 3: {
                return this.getDP(d) * 2.0;
            }
            case 2: {
                return this.getDP(d) * 4.0 * Math.signum((this.getP(d) * 4.0 + 3.0) % 4.0 - 2.0);
            }
            case 1: 
        }
        return 0.0;
    }

    public double getValue(double d) {
        switch (this.mType) {
            default: {
                return Math.sin(this.PI2 * this.getP(d));
            }
            case 6: {
                d = 1.0 - Math.abs(this.getP(d) * 4.0 % 4.0 - 2.0);
                return 1.0 - d * d;
            }
            case 5: {
                return Math.cos(this.PI2 * this.getP(d));
            }
            case 4: {
                return 1.0 - (this.getP(d) * 2.0 + 1.0) % 2.0;
            }
            case 3: {
                return (this.getP(d) * 2.0 + 1.0) % 2.0 - 1.0;
            }
            case 2: {
                return 1.0 - Math.abs((this.getP(d) * 4.0 + 1.0) % 4.0 - 2.0);
            }
            case 1: 
        }
        return Math.signum(0.5 - this.getP(d) % 1.0);
    }

    public void normalize() {
        float f;
        int n;
        double d = 0.0;
        double d2 = 0.0;
        for (n = 0; n < this.mPeriod.length; ++n) {
            d2 += (double)this.mPeriod[n];
        }
        for (n = 1; n < this.mPeriod.length; ++n) {
            f = (this.mPeriod[n - 1] + this.mPeriod[n]) / 2.0f;
            double d3 = this.mPosition[n];
            double d4 = this.mPosition[n - 1];
            d += (double)f * (d3 - d4);
        }
        for (n = 0; n < this.mPeriod.length; ++n) {
            float[] fArray = this.mPeriod;
            fArray[n] = (float)((double)fArray[n] * (d2 / d));
        }
        this.mArea[0] = 0.0;
        for (n = 1; n < this.mPeriod.length; ++n) {
            f = (this.mPeriod[n - 1] + this.mPeriod[n]) / 2.0f;
            d = this.mPosition[n];
            d2 = this.mPosition[n - 1];
            this.mArea[n] = this.mArea[n - 1] + (double)f * (d - d2);
        }
        this.mNormalized = true;
    }

    public void setType(int n) {
        this.mType = n;
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.mPosition) + " period=" + Arrays.toString(this.mPeriod);
    }
}

