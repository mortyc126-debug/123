/*
 * Decompiled with CFR 0.152.
 */
package androidx.dynamicanimation.animation;

import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.Force;

public final class SpringForce
implements Force {
    public static final float DAMPING_RATIO_HIGH_BOUNCY = 0.2f;
    public static final float DAMPING_RATIO_LOW_BOUNCY = 0.75f;
    public static final float DAMPING_RATIO_MEDIUM_BOUNCY = 0.5f;
    public static final float DAMPING_RATIO_NO_BOUNCY = 1.0f;
    public static final float STIFFNESS_HIGH = 10000.0f;
    public static final float STIFFNESS_LOW = 200.0f;
    public static final float STIFFNESS_MEDIUM = 1500.0f;
    public static final float STIFFNESS_VERY_LOW = 50.0f;
    private static final double UNSET = Double.MAX_VALUE;
    private static final double VELOCITY_THRESHOLD_MULTIPLIER = 62.5;
    private double mDampedFreq;
    double mDampingRatio = 0.5;
    private double mFinalPosition;
    private double mGammaMinus;
    private double mGammaPlus;
    private boolean mInitialized = false;
    private final DynamicAnimation.MassState mMassState;
    double mNaturalFreq = Math.sqrt(1500.0);
    private double mValueThreshold;
    private double mVelocityThreshold;

    public SpringForce() {
        this.mFinalPosition = Double.MAX_VALUE;
        this.mMassState = new DynamicAnimation.MassState();
    }

    public SpringForce(float f) {
        this.mFinalPosition = Double.MAX_VALUE;
        this.mMassState = new DynamicAnimation.MassState();
        this.mFinalPosition = f;
    }

    private void init() {
        if (this.mInitialized) {
            return;
        }
        if (this.mFinalPosition != Double.MAX_VALUE) {
            if (this.mDampingRatio > 1.0) {
                this.mGammaPlus = -this.mDampingRatio * this.mNaturalFreq + this.mNaturalFreq * Math.sqrt(this.mDampingRatio * this.mDampingRatio - 1.0);
                this.mGammaMinus = -this.mDampingRatio * this.mNaturalFreq - this.mNaturalFreq * Math.sqrt(this.mDampingRatio * this.mDampingRatio - 1.0);
            } else if (this.mDampingRatio >= 0.0 && this.mDampingRatio < 1.0) {
                this.mDampedFreq = this.mNaturalFreq * Math.sqrt(1.0 - this.mDampingRatio * this.mDampingRatio);
            }
            this.mInitialized = true;
            return;
        }
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }

    @Override
    public float getAcceleration(float f, float f2) {
        float f3 = this.getFinalPosition();
        double d = this.mNaturalFreq;
        double d2 = this.mNaturalFreq;
        double d3 = this.mNaturalFreq;
        double d4 = this.mDampingRatio;
        return (float)(-(d * d2) * (double)(f - f3) - (double)f2 * (d3 * 2.0 * d4));
    }

    public float getDampingRatio() {
        return (float)this.mDampingRatio;
    }

    public float getFinalPosition() {
        return (float)this.mFinalPosition;
    }

    public float getStiffness() {
        return (float)(this.mNaturalFreq * this.mNaturalFreq);
    }

    @Override
    public boolean isAtEquilibrium(float f, float f2) {
        return (double)Math.abs(f2) < this.mVelocityThreshold && (double)Math.abs(f - this.getFinalPosition()) < this.mValueThreshold;
    }

    public SpringForce setDampingRatio(float f) {
        if (!(f < 0.0f)) {
            this.mDampingRatio = f;
            this.mInitialized = false;
            return this;
        }
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public SpringForce setFinalPosition(float f) {
        this.mFinalPosition = f;
        return this;
    }

    public SpringForce setStiffness(float f) {
        if (!(f <= 0.0f)) {
            this.mNaturalFreq = Math.sqrt(f);
            this.mInitialized = false;
            return this;
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    void setValueThreshold(double d) {
        this.mValueThreshold = Math.abs(d);
        this.mVelocityThreshold = this.mValueThreshold * 62.5;
    }

    DynamicAnimation.MassState updateValues(double d, double d2, long l) {
        this.init();
        double d3 = (double)l / 1000.0;
        double d4 = d - this.mFinalPosition;
        if (this.mDampingRatio > 1.0) {
            double d5 = d4 - (this.mGammaMinus * d4 - d2) / (this.mGammaMinus - this.mGammaPlus);
            d2 = (this.mGammaMinus * d4 - d2) / (this.mGammaMinus - this.mGammaPlus);
            d = Math.pow(Math.E, this.mGammaMinus * d3) * d5 + Math.pow(Math.E, this.mGammaPlus * d3) * d2;
            d2 = this.mGammaMinus * d5 * Math.pow(Math.E, this.mGammaMinus * d3) + this.mGammaPlus * d2 * Math.pow(Math.E, this.mGammaPlus * d3);
        } else if (this.mDampingRatio == 1.0) {
            d = Math.pow(Math.E, -this.mNaturalFreq * d3) * ((d2 += this.mNaturalFreq * d4) * d3 + d4);
            d2 = (d2 * d3 + d4) * Math.pow(Math.E, -this.mNaturalFreq * d3) * -this.mNaturalFreq + Math.pow(Math.E, -this.mNaturalFreq * d3) * d2;
        } else {
            d2 = 1.0 / this.mDampedFreq * (this.mDampingRatio * this.mNaturalFreq * d4 + d2);
            d = Math.pow(Math.E, -this.mDampingRatio * this.mNaturalFreq * d3);
            d = (Math.cos(this.mDampedFreq * d3) * d4 + Math.sin(this.mDampedFreq * d3) * d2) * d;
            d2 = -this.mNaturalFreq * d * this.mDampingRatio + Math.pow(Math.E, -this.mDampingRatio * this.mNaturalFreq * d3) * (-this.mDampedFreq * d4 * Math.sin(this.mDampedFreq * d3) + this.mDampedFreq * d2 * Math.cos(this.mDampedFreq * d3));
        }
        this.mMassState.mValue = (float)(this.mFinalPosition + d);
        this.mMassState.mVelocity = (float)d2;
        return this.mMassState;
    }
}

