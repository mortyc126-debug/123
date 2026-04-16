/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.util.AndroidRuntimeException
 *  android.view.View
 */
package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.AnimationHandler;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.FloatValueHolder;
import java.util.ArrayList;

public abstract class DynamicAnimation<T extends DynamicAnimation<T>>
implements AnimationHandler.AnimationFrameCallback {
    public static final ViewProperty ALPHA;
    public static final float MIN_VISIBLE_CHANGE_ALPHA = 0.00390625f;
    public static final float MIN_VISIBLE_CHANGE_PIXELS = 1.0f;
    public static final float MIN_VISIBLE_CHANGE_ROTATION_DEGREES = 0.1f;
    public static final float MIN_VISIBLE_CHANGE_SCALE = 0.002f;
    public static final ViewProperty ROTATION;
    public static final ViewProperty ROTATION_X;
    public static final ViewProperty ROTATION_Y;
    public static final ViewProperty SCALE_X;
    public static final ViewProperty SCALE_Y;
    public static final ViewProperty SCROLL_X;
    public static final ViewProperty SCROLL_Y;
    private static final float THRESHOLD_MULTIPLIER = 0.75f;
    public static final ViewProperty TRANSLATION_X;
    public static final ViewProperty TRANSLATION_Y;
    public static final ViewProperty TRANSLATION_Z;
    private static final float UNSET = Float.MAX_VALUE;
    public static final ViewProperty X;
    public static final ViewProperty Y;
    public static final ViewProperty Z;
    private final ArrayList<OnAnimationEndListener> mEndListeners;
    private long mLastFrameTime = 0L;
    float mMaxValue;
    float mMinValue;
    private float mMinVisibleChange;
    final FloatPropertyCompat mProperty;
    boolean mRunning = false;
    boolean mStartValueIsSet = false;
    final Object mTarget;
    private final ArrayList<OnAnimationUpdateListener> mUpdateListeners;
    float mValue = Float.MAX_VALUE;
    float mVelocity = 0.0f;

    static {
        TRANSLATION_X = new ViewProperty("translationX"){

            @Override
            public float getValue(View view) {
                return view.getTranslationX();
            }

            @Override
            public void setValue(View view, float f) {
                view.setTranslationX(f);
            }
        };
        TRANSLATION_Y = new ViewProperty("translationY"){

            @Override
            public float getValue(View view) {
                return view.getTranslationY();
            }

            @Override
            public void setValue(View view, float f) {
                view.setTranslationY(f);
            }
        };
        TRANSLATION_Z = new ViewProperty("translationZ"){

            @Override
            public float getValue(View view) {
                return ViewCompat.getTranslationZ(view);
            }

            @Override
            public void setValue(View view, float f) {
                ViewCompat.setTranslationZ(view, f);
            }
        };
        SCALE_X = new ViewProperty("scaleX"){

            @Override
            public float getValue(View view) {
                return view.getScaleX();
            }

            @Override
            public void setValue(View view, float f) {
                view.setScaleX(f);
            }
        };
        SCALE_Y = new ViewProperty("scaleY"){

            @Override
            public float getValue(View view) {
                return view.getScaleY();
            }

            @Override
            public void setValue(View view, float f) {
                view.setScaleY(f);
            }
        };
        ROTATION = new ViewProperty("rotation"){

            @Override
            public float getValue(View view) {
                return view.getRotation();
            }

            @Override
            public void setValue(View view, float f) {
                view.setRotation(f);
            }
        };
        ROTATION_X = new ViewProperty("rotationX"){

            @Override
            public float getValue(View view) {
                return view.getRotationX();
            }

            @Override
            public void setValue(View view, float f) {
                view.setRotationX(f);
            }
        };
        ROTATION_Y = new ViewProperty("rotationY"){

            @Override
            public float getValue(View view) {
                return view.getRotationY();
            }

            @Override
            public void setValue(View view, float f) {
                view.setRotationY(f);
            }
        };
        X = new ViewProperty("x"){

            @Override
            public float getValue(View view) {
                return view.getX();
            }

            @Override
            public void setValue(View view, float f) {
                view.setX(f);
            }
        };
        Y = new ViewProperty("y"){

            @Override
            public float getValue(View view) {
                return view.getY();
            }

            @Override
            public void setValue(View view, float f) {
                view.setY(f);
            }
        };
        Z = new ViewProperty("z"){

            @Override
            public float getValue(View view) {
                return ViewCompat.getZ(view);
            }

            @Override
            public void setValue(View view, float f) {
                ViewCompat.setZ(view, f);
            }
        };
        ALPHA = new ViewProperty("alpha"){

            @Override
            public float getValue(View view) {
                return view.getAlpha();
            }

            @Override
            public void setValue(View view, float f) {
                view.setAlpha(f);
            }
        };
        SCROLL_X = new ViewProperty("scrollX"){

            @Override
            public float getValue(View view) {
                return view.getScrollX();
            }

            @Override
            public void setValue(View view, float f) {
                view.setScrollX((int)f);
            }
        };
        SCROLL_Y = new ViewProperty("scrollY"){

            @Override
            public float getValue(View view) {
                return view.getScrollY();
            }

            @Override
            public void setValue(View view, float f) {
                view.setScrollY((int)f);
            }
        };
    }

    DynamicAnimation(FloatValueHolder floatValueHolder) {
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -this.mMaxValue;
        this.mEndListeners = new ArrayList();
        this.mUpdateListeners = new ArrayList();
        this.mTarget = null;
        this.mProperty = new FloatPropertyCompat(this, "FloatValueHolder", floatValueHolder){
            final DynamicAnimation this$0;
            final FloatValueHolder val$floatValueHolder;
            {
                this.this$0 = dynamicAnimation;
                this.val$floatValueHolder = floatValueHolder;
                super(string2);
            }

            public float getValue(Object object) {
                return this.val$floatValueHolder.getValue();
            }

            public void setValue(Object object, float f) {
                this.val$floatValueHolder.setValue(f);
            }
        };
        this.mMinVisibleChange = 1.0f;
    }

    <K> DynamicAnimation(K k, FloatPropertyCompat<K> floatPropertyCompat) {
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -this.mMaxValue;
        this.mEndListeners = new ArrayList();
        this.mUpdateListeners = new ArrayList();
        this.mTarget = k;
        this.mProperty = floatPropertyCompat;
        this.mMinVisibleChange = this.mProperty != ROTATION && this.mProperty != ROTATION_X && this.mProperty != ROTATION_Y ? (this.mProperty == ALPHA ? 0.00390625f : (this.mProperty != SCALE_X && this.mProperty != SCALE_Y ? 1.0f : 0.00390625f)) : 0.1f;
    }

    private void endAnimationInternal(boolean bl) {
        this.mRunning = false;
        AnimationHandler.getInstance().removeCallback(this);
        this.mLastFrameTime = 0L;
        this.mStartValueIsSet = false;
        for (int i = 0; i < this.mEndListeners.size(); ++i) {
            if (this.mEndListeners.get(i) == null) continue;
            this.mEndListeners.get(i).onAnimationEnd(this, bl, this.mValue, this.mVelocity);
        }
        DynamicAnimation.removeNullEntries(this.mEndListeners);
    }

    private float getPropertyValue() {
        return this.mProperty.getValue(this.mTarget);
    }

    private static <T> void removeEntry(ArrayList<T> arrayList, T t) {
        int n = arrayList.indexOf(t);
        if (n >= 0) {
            arrayList.set(n, null);
        }
    }

    private static <T> void removeNullEntries(ArrayList<T> arrayList) {
        for (int i = arrayList.size() - 1; i >= 0; --i) {
            if (arrayList.get(i) != null) continue;
            arrayList.remove(i);
        }
    }

    private void startAnimationInternal() {
        if (!this.mRunning) {
            this.mRunning = true;
            if (!this.mStartValueIsSet) {
                this.mValue = this.getPropertyValue();
            }
            if (!(this.mValue > this.mMaxValue) && !(this.mValue < this.mMinValue)) {
                AnimationHandler.getInstance().addAnimationFrameCallback(this, 0L);
            } else {
                throw new IllegalArgumentException("Starting value need to be in between min value and max value");
            }
        }
    }

    public T addEndListener(OnAnimationEndListener onAnimationEndListener) {
        if (!this.mEndListeners.contains(onAnimationEndListener)) {
            this.mEndListeners.add(onAnimationEndListener);
        }
        return (T)this;
    }

    public T addUpdateListener(OnAnimationUpdateListener onAnimationUpdateListener) {
        if (!this.isRunning()) {
            if (!this.mUpdateListeners.contains(onAnimationUpdateListener)) {
                this.mUpdateListeners.add(onAnimationUpdateListener);
            }
            return (T)this;
        }
        throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
    }

    public void cancel() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (this.mRunning) {
                this.endAnimationInternal(true);
            }
            return;
        }
        throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
    }

    @Override
    public boolean doAnimationFrame(long l) {
        if (this.mLastFrameTime == 0L) {
            this.mLastFrameTime = l;
            this.setPropertyValue(this.mValue);
            return false;
        }
        long l2 = this.mLastFrameTime;
        this.mLastFrameTime = l;
        boolean bl = this.updateValueAndVelocity(l - l2);
        this.mValue = Math.min(this.mValue, this.mMaxValue);
        this.mValue = Math.max(this.mValue, this.mMinValue);
        this.setPropertyValue(this.mValue);
        if (bl) {
            this.endAnimationInternal(false);
        }
        return bl;
    }

    abstract float getAcceleration(float var1, float var2);

    public float getMinimumVisibleChange() {
        return this.mMinVisibleChange;
    }

    float getValueThreshold() {
        return this.mMinVisibleChange * 0.75f;
    }

    abstract boolean isAtEquilibrium(float var1, float var2);

    public boolean isRunning() {
        return this.mRunning;
    }

    public void removeEndListener(OnAnimationEndListener onAnimationEndListener) {
        DynamicAnimation.removeEntry(this.mEndListeners, onAnimationEndListener);
    }

    public void removeUpdateListener(OnAnimationUpdateListener onAnimationUpdateListener) {
        DynamicAnimation.removeEntry(this.mUpdateListeners, onAnimationUpdateListener);
    }

    public T setMaxValue(float f) {
        this.mMaxValue = f;
        return (T)this;
    }

    public T setMinValue(float f) {
        this.mMinValue = f;
        return (T)this;
    }

    public T setMinimumVisibleChange(float f) {
        if (!(f <= 0.0f)) {
            this.mMinVisibleChange = f;
            this.setValueThreshold(0.75f * f);
            return (T)this;
        }
        throw new IllegalArgumentException("Minimum visible change must be positive.");
    }

    void setPropertyValue(float f) {
        this.mProperty.setValue(this.mTarget, f);
        for (int i = 0; i < this.mUpdateListeners.size(); ++i) {
            if (this.mUpdateListeners.get(i) == null) continue;
            this.mUpdateListeners.get(i).onAnimationUpdate(this, this.mValue, this.mVelocity);
        }
        DynamicAnimation.removeNullEntries(this.mUpdateListeners);
    }

    public T setStartValue(float f) {
        this.mValue = f;
        this.mStartValueIsSet = true;
        return (T)this;
    }

    public T setStartVelocity(float f) {
        this.mVelocity = f;
        return (T)this;
    }

    abstract void setValueThreshold(float var1);

    public void start() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (!this.mRunning) {
                this.startAnimationInternal();
            }
            return;
        }
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    }

    abstract boolean updateValueAndVelocity(long var1);

    static class MassState {
        float mValue;
        float mVelocity;

        MassState() {
        }
    }

    public static interface OnAnimationEndListener {
        public void onAnimationEnd(DynamicAnimation var1, boolean var2, float var3, float var4);
    }

    public static interface OnAnimationUpdateListener {
        public void onAnimationUpdate(DynamicAnimation var1, float var2, float var3);
    }

    public static abstract class ViewProperty
    extends FloatPropertyCompat<View> {
        private ViewProperty(String string2) {
            super(string2);
        }
    }
}

