/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.util.AndroidRuntimeException
 */
package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringForce;

public final class SpringAnimation
extends DynamicAnimation<SpringAnimation> {
    private static final float UNSET = Float.MAX_VALUE;
    private boolean mEndRequested = false;
    private float mPendingPosition = Float.MAX_VALUE;
    private SpringForce mSpring = null;

    public SpringAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
    }

    public <K> SpringAnimation(K k, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k, floatPropertyCompat);
    }

    public <K> SpringAnimation(K k, FloatPropertyCompat<K> floatPropertyCompat, float f) {
        super(k, floatPropertyCompat);
        this.mSpring = new SpringForce(f);
    }

    private void sanityCheck() {
        if (this.mSpring != null) {
            double d = this.mSpring.getFinalPosition();
            if (!(d > (double)this.mMaxValue)) {
                if (!(d < (double)this.mMinValue)) {
                    return;
                }
                throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
            }
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
    }

    public void animateToFinalPosition(float f) {
        if (this.isRunning()) {
            this.mPendingPosition = f;
        } else {
            if (this.mSpring == null) {
                this.mSpring = new SpringForce(f);
            }
            this.mSpring.setFinalPosition(f);
            this.start();
        }
    }

    public boolean canSkipToEnd() {
        boolean bl = this.mSpring.mDampingRatio > 0.0;
        return bl;
    }

    @Override
    float getAcceleration(float f, float f2) {
        return this.mSpring.getAcceleration(f, f2);
    }

    public SpringForce getSpring() {
        return this.mSpring;
    }

    @Override
    boolean isAtEquilibrium(float f, float f2) {
        return this.mSpring.isAtEquilibrium(f, f2);
    }

    public SpringAnimation setSpring(SpringForce springForce) {
        this.mSpring = springForce;
        return this;
    }

    @Override
    void setValueThreshold(float f) {
    }

    public void skipToEnd() {
        if (this.canSkipToEnd()) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                if (this.mRunning) {
                    this.mEndRequested = true;
                }
                return;
            }
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
    }

    @Override
    public void start() {
        this.sanityCheck();
        this.mSpring.setValueThreshold(this.getValueThreshold());
        super.start();
    }

    @Override
    boolean updateValueAndVelocity(long l) {
        if (this.mEndRequested) {
            if (this.mPendingPosition != Float.MAX_VALUE) {
                this.mSpring.setFinalPosition(this.mPendingPosition);
                this.mPendingPosition = Float.MAX_VALUE;
            }
            this.mValue = this.mSpring.getFinalPosition();
            this.mVelocity = 0.0f;
            this.mEndRequested = false;
            return true;
        }
        if (this.mPendingPosition != Float.MAX_VALUE) {
            double d = this.mSpring.getFinalPosition();
            DynamicAnimation.MassState massState = this.mSpring.updateValues(this.mValue, this.mVelocity, l / 2L);
            this.mSpring.setFinalPosition(this.mPendingPosition);
            this.mPendingPosition = Float.MAX_VALUE;
            massState = this.mSpring.updateValues(massState.mValue, massState.mVelocity, l / 2L);
            this.mValue = massState.mValue;
            this.mVelocity = massState.mVelocity;
        } else {
            DynamicAnimation.MassState massState = this.mSpring.updateValues(this.mValue, this.mVelocity, l);
            this.mValue = massState.mValue;
            this.mVelocity = massState.mVelocity;
        }
        this.mValue = Math.max(this.mValue, this.mMinValue);
        this.mValue = Math.min(this.mValue, this.mMaxValue);
        if (this.isAtEquilibrium(this.mValue, this.mVelocity)) {
            this.mValue = this.mSpring.getFinalPosition();
            this.mVelocity = 0.0f;
            return true;
        }
        return false;
    }
}

