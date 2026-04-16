/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.constraintlayout.motion.utils;

import android.util.Log;
import androidx.constraintlayout.motion.widget.MotionInterpolator;

public class StopLogic
extends MotionInterpolator {
    private boolean mBackwards = false;
    private float mLastPosition;
    private int mNumberOfStages;
    private float mStage1Duration;
    private float mStage1EndPosition;
    private float mStage1Velocity;
    private float mStage2Duration;
    private float mStage2EndPosition;
    private float mStage2Velocity;
    private float mStage3Duration;
    private float mStage3EndPosition;
    private float mStage3Velocity;
    private float mStartPosition;
    private String mType;

    private float calcY(float f) {
        if (f <= this.mStage1Duration) {
            return this.mStage1Velocity * f + (this.mStage2Velocity - this.mStage1Velocity) * f * f / (this.mStage1Duration * 2.0f);
        }
        if (this.mNumberOfStages == 1) {
            return this.mStage1EndPosition;
        }
        if ((f -= this.mStage1Duration) < this.mStage2Duration) {
            return this.mStage1EndPosition + this.mStage2Velocity * f + (this.mStage3Velocity - this.mStage2Velocity) * f * f / (this.mStage2Duration * 2.0f);
        }
        if (this.mNumberOfStages == 2) {
            return this.mStage2EndPosition;
        }
        if ((f -= this.mStage2Duration) < this.mStage3Duration) {
            return this.mStage2EndPosition + this.mStage3Velocity * f - this.mStage3Velocity * f * f / (this.mStage3Duration * 2.0f);
        }
        return this.mStage3EndPosition;
    }

    private void setup(float f, float f2, float f3, float f4, float f5) {
        if (f == 0.0f) {
            f = 1.0E-4f;
        }
        this.mStage1Velocity = f;
        float f6 = f / f3;
        float f7 = f6 * f / 2.0f;
        if (f < 0.0f) {
            f5 = (float)Math.sqrt(f3 * (f2 - -f / f3 * f / 2.0f));
            if (f5 < f4) {
                this.mType = "backward accelerate, decelerate";
                this.mNumberOfStages = 2;
                this.mStage1Velocity = f;
                this.mStage2Velocity = f5;
                this.mStage3Velocity = 0.0f;
                this.mStage1Duration = (f5 - f) / f3;
                this.mStage2Duration = f5 / f3;
                this.mStage1EndPosition = (f + f5) * this.mStage1Duration / 2.0f;
                this.mStage2EndPosition = f2;
                this.mStage3EndPosition = f2;
                return;
            }
            this.mType = "backward accelerate cruse decelerate";
            this.mNumberOfStages = 3;
            this.mStage1Velocity = f;
            this.mStage2Velocity = f4;
            this.mStage3Velocity = f4;
            this.mStage1Duration = (f4 - f) / f3;
            this.mStage3Duration = f4 / f3;
            f = (f + f4) * this.mStage1Duration / 2.0f;
            f3 = this.mStage3Duration * f4 / 2.0f;
            this.mStage2Duration = (f2 - f - f3) / f4;
            this.mStage1EndPosition = f;
            this.mStage2EndPosition = f2 - f3;
            this.mStage3EndPosition = f2;
            return;
        }
        if (f7 >= f2) {
            this.mType = "hard stop";
            f3 = 2.0f * f2 / f;
            this.mNumberOfStages = 1;
            this.mStage1Velocity = f;
            this.mStage2Velocity = 0.0f;
            this.mStage1EndPosition = f2;
            this.mStage1Duration = f3;
            return;
        }
        float f8 = f2 - f7;
        if ((f7 = f8 / f) + f6 < f5) {
            this.mType = "cruse decelerate";
            this.mNumberOfStages = 2;
            this.mStage1Velocity = f;
            this.mStage2Velocity = f;
            this.mStage3Velocity = 0.0f;
            this.mStage1EndPosition = f8;
            this.mStage2EndPosition = f2;
            this.mStage1Duration = f7;
            this.mStage2Duration = f / f3;
            return;
        }
        f5 = (float)Math.sqrt(f3 * f2 + f * f / 2.0f);
        this.mStage1Duration = (f5 - f) / f3;
        this.mStage2Duration = f5 / f3;
        if (f5 < f4) {
            this.mType = "accelerate decelerate";
            this.mNumberOfStages = 2;
            this.mStage1Velocity = f;
            this.mStage2Velocity = f5;
            this.mStage3Velocity = 0.0f;
            this.mStage1Duration = (f5 - f) / f3;
            this.mStage2Duration = f5 / f3;
            this.mStage1EndPosition = (f + f5) * this.mStage1Duration / 2.0f;
            this.mStage2EndPosition = f2;
            return;
        }
        this.mType = "accelerate cruse decelerate";
        this.mNumberOfStages = 3;
        this.mStage1Velocity = f;
        this.mStage2Velocity = f4;
        this.mStage3Velocity = f4;
        this.mStage1Duration = (f4 - f) / f3;
        this.mStage3Duration = f4 / f3;
        f3 = (f + f4) * this.mStage1Duration / 2.0f;
        f = this.mStage3Duration * f4 / 2.0f;
        this.mStage2Duration = (f2 - f3 - f) / f4;
        this.mStage1EndPosition = f3;
        this.mStage2EndPosition = f2 - f;
        this.mStage3EndPosition = f2;
    }

    public void config(float f, float f2, float f3, float f4, float f5, float f6) {
        this.mStartPosition = f;
        boolean bl = f > f2;
        this.mBackwards = bl;
        if (this.mBackwards) {
            this.setup(-f3, f - f2, f5, f6, f4);
        } else {
            this.setup(f3, f2 - f, f5, f6, f4);
        }
    }

    public void debug(String string2, String string3, float f) {
        Log.v((String)string2, (String)(string3 + " ===== " + this.mType));
        StringBuilder stringBuilder = new StringBuilder().append(string3);
        String string4 = this.mBackwards ? "backwards" : "forward ";
        Log.v((String)string2, (String)stringBuilder.append(string4).append(" time = ").append(f).append("  stages ").append(this.mNumberOfStages).toString());
        Log.v((String)string2, (String)(string3 + " dur " + this.mStage1Duration + " vel " + this.mStage1Velocity + " pos " + this.mStage1EndPosition));
        if (this.mNumberOfStages > 1) {
            Log.v((String)string2, (String)(string3 + " dur " + this.mStage2Duration + " vel " + this.mStage2Velocity + " pos " + this.mStage2EndPosition));
        }
        if (this.mNumberOfStages > 2) {
            Log.v((String)string2, (String)(string3 + " dur " + this.mStage3Duration + " vel " + this.mStage3Velocity + " pos " + this.mStage3EndPosition));
        }
        if (f <= this.mStage1Duration) {
            Log.v((String)string2, (String)(string3 + "stage 0"));
            return;
        }
        if (this.mNumberOfStages == 1) {
            Log.v((String)string2, (String)(string3 + "end stage 0"));
            return;
        }
        if ((f -= this.mStage1Duration) < this.mStage2Duration) {
            Log.v((String)string2, (String)(string3 + " stage 1"));
            return;
        }
        if (this.mNumberOfStages == 2) {
            Log.v((String)string2, (String)(string3 + "end stage 1"));
            return;
        }
        if (f - this.mStage2Duration < this.mStage3Duration) {
            Log.v((String)string2, (String)(string3 + " stage 2"));
            return;
        }
        Log.v((String)string2, (String)(string3 + " end stage 2"));
    }

    @Override
    public float getInterpolation(float f) {
        float f2 = this.calcY(f);
        this.mLastPosition = f;
        f = this.mBackwards ? this.mStartPosition - f2 : this.mStartPosition + f2;
        return f;
    }

    @Override
    public float getVelocity() {
        float f = this.mBackwards ? -this.getVelocity(this.mLastPosition) : this.getVelocity(this.mLastPosition);
        return f;
    }

    public float getVelocity(float f) {
        if (f <= this.mStage1Duration) {
            return this.mStage1Velocity + (this.mStage2Velocity - this.mStage1Velocity) * f / this.mStage1Duration;
        }
        if (this.mNumberOfStages == 1) {
            return 0.0f;
        }
        if ((f -= this.mStage1Duration) < this.mStage2Duration) {
            return this.mStage2Velocity + (this.mStage3Velocity - this.mStage2Velocity) * f / this.mStage2Duration;
        }
        if (this.mNumberOfStages == 2) {
            return this.mStage2EndPosition;
        }
        if ((f -= this.mStage2Duration) < this.mStage3Duration) {
            return this.mStage3Velocity - this.mStage3Velocity * f / this.mStage3Duration;
        }
        return this.mStage3EndPosition;
    }
}

