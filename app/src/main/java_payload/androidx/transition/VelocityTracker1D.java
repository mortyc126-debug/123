/*
 * Decompiled with CFR 0.152.
 */
package androidx.transition;

import java.util.Arrays;

class VelocityTracker1D {
    private static final int ASSUME_POINTER_MOVE_STOPPED_MILLIS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final int HORIZON_MILLIS = 100;
    private float[] mDataSamples;
    private int mIndex = 0;
    private long[] mTimeSamples = new long[20];

    VelocityTracker1D() {
        this.mDataSamples = new float[20];
        Arrays.fill(this.mTimeSamples, Long.MIN_VALUE);
    }

    private float kineticEnergyToVelocity(float f) {
        return (float)((double)Math.signum(f) * Math.sqrt(Math.abs(f) * 2.0f));
    }

    public void addDataPoint(long l, float f) {
        this.mIndex = (this.mIndex + 1) % 20;
        this.mTimeSamples[this.mIndex] = l;
        this.mDataSamples[this.mIndex] = f;
    }

    float calculateVelocity() {
        float f;
        float f2;
        long l;
        int n;
        long l2;
        int n2 = 0;
        int n3 = this.mIndex;
        if (n3 == 0 && this.mTimeSamples[n3] == Long.MIN_VALUE) {
            return 0.0f;
        }
        long l3 = l2 = this.mTimeSamples[n3];
        do {
            if ((l = this.mTimeSamples[n3]) == Long.MIN_VALUE) {
                n = n2;
                break;
            }
            f2 = l2 - l;
            f = Math.abs(l - l3);
            l3 = l;
            n = n2;
            if (f2 > 100.0f) break;
            if (f > 40.0f) {
                n = n2;
                break;
            }
            n = n3 == 0 ? 20 : n3;
            n3 = n - 1;
            n2 = n = n2 + 1;
        } while (n < 20);
        if (n < 2) {
            return 0.0f;
        }
        if (n == 2) {
            n2 = this.mIndex == 0 ? 19 : this.mIndex - 1;
            f = this.mTimeSamples[this.mIndex] - this.mTimeSamples[n2];
            if (f == 0.0f) {
                return 0.0f;
            }
            return (this.mDataSamples[this.mIndex] - this.mDataSamples[n2]) / f * 1000.0f;
        }
        f2 = 0.0f;
        n3 = (this.mIndex - n + 20 + 1) % 20;
        int n4 = this.mIndex;
        l3 = this.mTimeSamples[n3];
        f = this.mDataSamples[n3];
        n2 = (n3 + 1) % 20;
        while (n2 != (n4 + 1 + 20) % 20) {
            float f3;
            l2 = this.mTimeSamples[n2];
            l = l2 - l3;
            if ((float)l == 0.0f) {
                f3 = f;
            } else {
                f3 = this.mDataSamples[n2];
                float f4 = this.kineticEnergyToVelocity(f2);
                f = (f3 - f) / (float)l;
                f2 += (f - f4) * Math.abs(f);
                f = f2;
                if (n2 == n3 + 1) {
                    f = f2 * 0.5f;
                }
                l3 = l2;
                f2 = f;
            }
            n2 = (n2 + 1) % 20;
            f = f3;
        }
        return this.kineticEnergyToVelocity(f2) * 1000.0f;
    }

    public void resetTracking() {
        this.mIndex = 0;
        Arrays.fill(this.mTimeSamples, Long.MIN_VALUE);
        Arrays.fill(this.mDataSamples, 0.0f);
    }
}

