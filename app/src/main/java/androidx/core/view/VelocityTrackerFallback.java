/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 */
package androidx.core.view;

import android.view.MotionEvent;

class VelocityTrackerFallback {
    private static final long ASSUME_POINTER_STOPPED_MS = 40L;
    private static final int HISTORY_SIZE = 20;
    private static final long RANGE_MS = 100L;
    private int mDataPointsBufferLastUsedIndex = 0;
    private int mDataPointsBufferSize = 0;
    private final long[] mEventTimes;
    private float mLastComputedVelocity = 0.0f;
    private final float[] mMovements = new float[20];

    VelocityTrackerFallback() {
        this.mEventTimes = new long[20];
    }

    private void clear() {
        this.mDataPointsBufferSize = 0;
        this.mLastComputedVelocity = 0.0f;
    }

    private float getCurrentVelocity() {
        if (this.mDataPointsBufferSize < 2) {
            return 0.0f;
        }
        int n = (this.mDataPointsBufferLastUsedIndex + 20 - (this.mDataPointsBufferSize - 1)) % 20;
        long l = this.mEventTimes[this.mDataPointsBufferLastUsedIndex];
        while (l - this.mEventTimes[n] > 100L) {
            --this.mDataPointsBufferSize;
            n = (n + 1) % 20;
        }
        if (this.mDataPointsBufferSize < 2) {
            return 0.0f;
        }
        if (this.mDataPointsBufferSize == 2) {
            int n2 = (n + 1) % 20;
            if (this.mEventTimes[n] == this.mEventTimes[n2]) {
                return 0.0f;
            }
            return this.mMovements[n2] / (float)(this.mEventTimes[n2] - this.mEventTimes[n]);
        }
        float f = 0.0f;
        int n3 = 0;
        for (int i = 0; i < this.mDataPointsBufferSize - 1; ++i) {
            int n4 = i + n;
            int n5 = (n4 + 1) % 20;
            l = this.mEventTimes[n4 % 20];
            if (this.mEventTimes[n5] == l) continue;
            n4 = n3 + 1;
            float f2 = VelocityTrackerFallback.kineticEnergyToVelocity(f);
            float f3 = this.mMovements[n5] / (float)(this.mEventTimes[n5] - l);
            f = f3 = f + (f3 - f2) * Math.abs(f3);
            n3 = n4;
            if (n4 != 1) continue;
            f = f3 * 0.5f;
            n3 = n4;
        }
        return VelocityTrackerFallback.kineticEnergyToVelocity(f);
    }

    private static float kineticEnergyToVelocity(float f) {
        float f2 = f < 0.0f ? -1.0f : 1.0f;
        return f2 * (float)Math.sqrt(Math.abs(f) * 2.0f);
    }

    void addMovement(MotionEvent motionEvent) {
        long l = motionEvent.getEventTime();
        if (this.mDataPointsBufferSize != 0 && l - this.mEventTimes[this.mDataPointsBufferLastUsedIndex] > 40L) {
            this.clear();
        }
        this.mDataPointsBufferLastUsedIndex = (this.mDataPointsBufferLastUsedIndex + 1) % 20;
        if (this.mDataPointsBufferSize != 20) {
            ++this.mDataPointsBufferSize;
        }
        this.mMovements[this.mDataPointsBufferLastUsedIndex] = motionEvent.getAxisValue(26);
        this.mEventTimes[this.mDataPointsBufferLastUsedIndex] = l;
    }

    void computeCurrentVelocity(int n) {
        this.computeCurrentVelocity(n, Float.MAX_VALUE);
    }

    void computeCurrentVelocity(int n, float f) {
        this.mLastComputedVelocity = this.getCurrentVelocity() * (float)n;
        if (this.mLastComputedVelocity < -Math.abs(f)) {
            this.mLastComputedVelocity = -Math.abs(f);
        } else if (this.mLastComputedVelocity > Math.abs(f)) {
            this.mLastComputedVelocity = Math.abs(f);
        }
    }

    float getAxisVelocity(int n) {
        if (n != 26) {
            return 0.0f;
        }
        return this.mLastComputedVelocity;
    }
}

