/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.ViewConfiguration
 */
package androidx.core.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda1;
import androidx.core.view.DifferentialMotionFlingTarget;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewConfigurationCompat;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class DifferentialMotionFlingController {
    private final Context mContext;
    private final int[] mFlingVelocityThresholds = new int[]{Integer.MAX_VALUE, 0};
    private float mLastFlingVelocity;
    private int mLastProcessedAxis = -1;
    private int mLastProcessedDeviceId = -1;
    private int mLastProcessedSource = -1;
    private final DifferentialMotionFlingTarget mTarget;
    private final DifferentialVelocityProvider mVelocityProvider;
    private final FlingVelocityThresholdCalculator mVelocityThresholdCalculator;
    private VelocityTracker mVelocityTracker;

    public static /* synthetic */ void $r8$lambda$fyam27PSWwBPLoRnvh-8qovKLVc(Context context, int[] nArray, MotionEvent motionEvent, int n) {
        DifferentialMotionFlingController.calculateFlingVelocityThresholds(context, nArray, motionEvent, n);
    }

    public static /* synthetic */ float $r8$lambda$kW3lwUZVQIj0GhmsuwxWObzpxIU(VelocityTracker velocityTracker, MotionEvent motionEvent, int n) {
        return DifferentialMotionFlingController.getCurrentVelocity(velocityTracker, motionEvent, n);
    }

    public DifferentialMotionFlingController(Context context, DifferentialMotionFlingTarget differentialMotionFlingTarget) {
        this(context, differentialMotionFlingTarget, new DifferentialMotionFlingController$$ExternalSyntheticLambda0(), new DifferentialMotionFlingController$$ExternalSyntheticLambda1());
    }

    DifferentialMotionFlingController(Context context, DifferentialMotionFlingTarget differentialMotionFlingTarget, FlingVelocityThresholdCalculator flingVelocityThresholdCalculator, DifferentialVelocityProvider differentialVelocityProvider) {
        this.mContext = context;
        this.mTarget = differentialMotionFlingTarget;
        this.mVelocityThresholdCalculator = flingVelocityThresholdCalculator;
        this.mVelocityProvider = differentialVelocityProvider;
    }

    private static void calculateFlingVelocityThresholds(Context context, int[] nArray, MotionEvent motionEvent, int n) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get((Context)context);
        nArray[0] = ViewConfigurationCompat.getScaledMinimumFlingVelocity(context, viewConfiguration, motionEvent.getDeviceId(), n, motionEvent.getSource());
        nArray[1] = ViewConfigurationCompat.getScaledMaximumFlingVelocity(context, viewConfiguration, motionEvent.getDeviceId(), n, motionEvent.getSource());
    }

    private boolean calculateFlingVelocityThresholds(MotionEvent motionEvent, int n) {
        int n2 = motionEvent.getSource();
        int n3 = motionEvent.getDeviceId();
        if (this.mLastProcessedSource == n2 && this.mLastProcessedDeviceId == n3 && this.mLastProcessedAxis == n) {
            return false;
        }
        this.mVelocityThresholdCalculator.calculateFlingVelocityThresholds(this.mContext, this.mFlingVelocityThresholds, motionEvent, n);
        this.mLastProcessedSource = n2;
        this.mLastProcessedDeviceId = n3;
        this.mLastProcessedAxis = n;
        return true;
    }

    private float getCurrentVelocity(MotionEvent motionEvent, int n) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        return this.mVelocityProvider.getCurrentVelocity(this.mVelocityTracker, motionEvent, n);
    }

    private static float getCurrentVelocity(VelocityTracker velocityTracker, MotionEvent motionEvent, int n) {
        VelocityTrackerCompat.addMovement(velocityTracker, motionEvent);
        VelocityTrackerCompat.computeCurrentVelocity(velocityTracker, 1000);
        return VelocityTrackerCompat.getAxisVelocity(velocityTracker, n);
    }

    public void onMotionEvent(MotionEvent motionEvent, int n) {
        boolean bl = this.calculateFlingVelocityThresholds(motionEvent, n);
        if (this.mFlingVelocityThresholds[0] == Integer.MAX_VALUE) {
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
            }
            return;
        }
        float f = this.getCurrentVelocity(motionEvent, n) * this.mTarget.getScaledScrollFactor();
        float f2 = Math.signum(f);
        float f3 = 0.0f;
        if (bl || f2 != Math.signum(this.mLastFlingVelocity) && f2 != 0.0f) {
            this.mTarget.stopDifferentialMotionFling();
        }
        if (Math.abs(f) < (float)this.mFlingVelocityThresholds[0]) {
            return;
        }
        if (this.mTarget.startDifferentialMotionFling(f = Math.max((float)(-this.mFlingVelocityThresholds[1]), Math.min(f, (float)this.mFlingVelocityThresholds[1])))) {
            f3 = f;
        }
        this.mLastFlingVelocity = f3;
    }

    static interface DifferentialVelocityProvider {
        public float getCurrentVelocity(VelocityTracker var1, MotionEvent var2, int var3);
    }

    static interface FlingVelocityThresholdCalculator {
        public void calculateFlingVelocityThresholds(Context var1, int[] var2, MotionEvent var3, int var4);
    }
}

