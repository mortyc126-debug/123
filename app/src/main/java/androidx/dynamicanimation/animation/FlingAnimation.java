/*
 * Decompiled with CFR 0.152.
 */
package androidx.dynamicanimation.animation;

import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.Force;

public final class FlingAnimation
extends DynamicAnimation<FlingAnimation> {
    private final DragForce mFlingForce = new DragForce();

    public FlingAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
        this.mFlingForce.setValueThreshold(this.getValueThreshold());
    }

    public <K> FlingAnimation(K k, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k, floatPropertyCompat);
        this.mFlingForce.setValueThreshold(this.getValueThreshold());
    }

    @Override
    float getAcceleration(float f, float f2) {
        return this.mFlingForce.getAcceleration(f, f2);
    }

    public float getFriction() {
        return this.mFlingForce.getFrictionScalar();
    }

    @Override
    boolean isAtEquilibrium(float f, float f2) {
        boolean bl = f >= this.mMaxValue || f <= this.mMinValue || this.mFlingForce.isAtEquilibrium(f, f2);
        return bl;
    }

    public FlingAnimation setFriction(float f) {
        if (!(f <= 0.0f)) {
            this.mFlingForce.setFrictionScalar(f);
            return this;
        }
        throw new IllegalArgumentException("Friction must be positive");
    }

    @Override
    public FlingAnimation setMaxValue(float f) {
        super.setMaxValue(f);
        return this;
    }

    @Override
    public FlingAnimation setMinValue(float f) {
        super.setMinValue(f);
        return this;
    }

    @Override
    public FlingAnimation setStartVelocity(float f) {
        super.setStartVelocity(f);
        return this;
    }

    @Override
    void setValueThreshold(float f) {
        this.mFlingForce.setValueThreshold(f);
    }

    @Override
    boolean updateValueAndVelocity(long l) {
        DynamicAnimation.MassState massState = this.mFlingForce.updateValueAndVelocity(this.mValue, this.mVelocity, l);
        this.mValue = massState.mValue;
        this.mVelocity = massState.mVelocity;
        if (this.mValue < this.mMinValue) {
            this.mValue = this.mMinValue;
            return true;
        }
        if (this.mValue > this.mMaxValue) {
            this.mValue = this.mMaxValue;
            return true;
        }
        return this.isAtEquilibrium(this.mValue, this.mVelocity);
    }

    static final class DragForce
    implements Force {
        private static final float DEFAULT_FRICTION = -4.2f;
        private static final float VELOCITY_THRESHOLD_MULTIPLIER = 62.5f;
        private float mFriction = -4.2f;
        private final DynamicAnimation.MassState mMassState = new DynamicAnimation.MassState();
        private float mVelocityThreshold;

        DragForce() {
        }

        @Override
        public float getAcceleration(float f, float f2) {
            return this.mFriction * f2;
        }

        float getFrictionScalar() {
            return this.mFriction / -4.2f;
        }

        @Override
        public boolean isAtEquilibrium(float f, float f2) {
            boolean bl = Math.abs(f2) < this.mVelocityThreshold;
            return bl;
        }

        void setFrictionScalar(float f) {
            this.mFriction = -4.2f * f;
        }

        void setValueThreshold(float f) {
            this.mVelocityThreshold = 62.5f * f;
        }

        DynamicAnimation.MassState updateValueAndVelocity(float f, float f2, long l) {
            this.mMassState.mVelocity = (float)((double)f2 * Math.exp((float)l / 1000.0f * this.mFriction));
            this.mMassState.mValue = (float)((double)(f - f2 / this.mFriction) + (double)(f2 / this.mFriction) * Math.exp(this.mFriction * (float)l / 1000.0f));
            if (this.isAtEquilibrium(this.mMassState.mValue, this.mMassState.mVelocity)) {
                this.mMassState.mVelocity = 0.0f;
            }
            return this.mMassState;
        }
    }
}

