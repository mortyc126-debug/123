/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$OnApplyWindowInsetsListener
 *  android.view.ViewGroup
 *  android.view.WindowInsets
 *  android.view.WindowInsetsAnimation
 *  android.view.WindowInsetsAnimation$Bounds
 *  android.view.WindowInsetsAnimation$Callback
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.view.animation.PathInterpolator
 */
package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.core.R;
import androidx.core.graphics.Insets;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public final class WindowInsetsAnimationCompat {
    private static final boolean DEBUG = false;
    private static final String TAG = "WindowInsetsAnimCompat";
    private Impl mImpl;

    public WindowInsetsAnimationCompat(int n, Interpolator interpolator2, long l) {
        this.mImpl = Build.VERSION.SDK_INT >= 30 ? new Impl30(n, interpolator2, l) : new Impl21(n, interpolator2, l);
    }

    private WindowInsetsAnimationCompat(WindowInsetsAnimation windowInsetsAnimation) {
        this(0, null, 0L);
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new Impl30(windowInsetsAnimation);
        }
    }

    static void setCallback(View view, Callback callback2) {
        if (Build.VERSION.SDK_INT >= 30) {
            Impl30.setCallback(view, callback2);
        } else {
            Impl21.setCallback(view, callback2);
        }
    }

    static WindowInsetsAnimationCompat toWindowInsetsAnimationCompat(WindowInsetsAnimation windowInsetsAnimation) {
        return new WindowInsetsAnimationCompat(windowInsetsAnimation);
    }

    public float getAlpha() {
        return this.mImpl.getAlpha();
    }

    public long getDurationMillis() {
        return this.mImpl.getDurationMillis();
    }

    public float getFraction() {
        return this.mImpl.getFraction();
    }

    public float getInterpolatedFraction() {
        return this.mImpl.getInterpolatedFraction();
    }

    public Interpolator getInterpolator() {
        return this.mImpl.getInterpolator();
    }

    public int getTypeMask() {
        return this.mImpl.getTypeMask();
    }

    public void setAlpha(float f) {
        this.mImpl.setAlpha(f);
    }

    public void setFraction(float f) {
        this.mImpl.setFraction(f);
    }

    public static final class BoundsCompat {
        private final Insets mLowerBound;
        private final Insets mUpperBound;

        private BoundsCompat(WindowInsetsAnimation.Bounds bounds) {
            this.mLowerBound = Impl30.getLowerBounds(bounds);
            this.mUpperBound = Impl30.getHigherBounds(bounds);
        }

        public BoundsCompat(Insets insets, Insets insets2) {
            this.mLowerBound = insets;
            this.mUpperBound = insets2;
        }

        public static BoundsCompat toBoundsCompat(WindowInsetsAnimation.Bounds bounds) {
            return new BoundsCompat(bounds);
        }

        public Insets getLowerBound() {
            return this.mLowerBound;
        }

        public Insets getUpperBound() {
            return this.mUpperBound;
        }

        public BoundsCompat inset(Insets insets) {
            return new BoundsCompat(WindowInsetsCompat.insetInsets(this.mLowerBound, insets.left, insets.top, insets.right, insets.bottom), WindowInsetsCompat.insetInsets(this.mUpperBound, insets.left, insets.top, insets.right, insets.bottom));
        }

        public WindowInsetsAnimation.Bounds toBounds() {
            return Impl30.createPlatformBounds(this);
        }

        public String toString() {
            return "Bounds{lower=" + this.mLowerBound + " upper=" + this.mUpperBound + "}";
        }
    }

    public static abstract class Callback {
        public static final int DISPATCH_MODE_CONTINUE_ON_SUBTREE = 1;
        public static final int DISPATCH_MODE_STOP = 0;
        WindowInsets mDispachedInsets;
        private final int mDispatchMode;

        public Callback(int n) {
            this.mDispatchMode = n;
        }

        public final int getDispatchMode() {
            return this.mDispatchMode;
        }

        public void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        }

        public void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        }

        public abstract WindowInsetsCompat onProgress(WindowInsetsCompat var1, List<WindowInsetsAnimationCompat> var2);

        public BoundsCompat onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, BoundsCompat boundsCompat) {
            return boundsCompat;
        }

        @Retention(value=RetentionPolicy.SOURCE)
        public static @interface DispatchMode {
        }
    }

    private static class Impl {
        private float mAlpha;
        private final long mDurationMillis;
        private float mFraction;
        private final Interpolator mInterpolator;
        private final int mTypeMask;

        Impl(int n, Interpolator interpolator2, long l) {
            this.mTypeMask = n;
            this.mInterpolator = interpolator2;
            this.mDurationMillis = l;
        }

        public float getAlpha() {
            return this.mAlpha;
        }

        public long getDurationMillis() {
            return this.mDurationMillis;
        }

        public float getFraction() {
            return this.mFraction;
        }

        public float getInterpolatedFraction() {
            if (this.mInterpolator != null) {
                return this.mInterpolator.getInterpolation(this.mFraction);
            }
            return this.mFraction;
        }

        public Interpolator getInterpolator() {
            return this.mInterpolator;
        }

        public int getTypeMask() {
            return this.mTypeMask;
        }

        public void setAlpha(float f) {
            this.mAlpha = f;
        }

        public void setFraction(float f) {
            this.mFraction = f;
        }
    }

    private static class Impl21
    extends Impl {
        private static final Interpolator DEFAULT_INSET_INTERPOLATOR;
        private static final Interpolator HIDE_IME_INTERPOLATOR;
        private static final Interpolator SHOW_IME_INTERPOLATOR;

        static {
            SHOW_IME_INTERPOLATOR = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);
            HIDE_IME_INTERPOLATOR = new FastOutLinearInInterpolator();
            DEFAULT_INSET_INTERPOLATOR = new DecelerateInterpolator();
        }

        Impl21(int n, Interpolator interpolator2, long l) {
            super(n, interpolator2, l);
        }

        static int buildAnimationMask(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2) {
            int n = 0;
            for (int i = 1; i <= 256; i <<= 1) {
                int n2 = n;
                if (!windowInsetsCompat.getInsets(i).equals(windowInsetsCompat2.getInsets(i))) {
                    n2 = n | i;
                }
                n = n2;
            }
            return n;
        }

        static BoundsCompat computeAnimationBounds(WindowInsetsCompat object, WindowInsetsCompat object2, int n) {
            object = ((WindowInsetsCompat)object).getInsets(n);
            object2 = ((WindowInsetsCompat)object2).getInsets(n);
            return new BoundsCompat(Insets.of(Math.min(((Insets)object).left, ((Insets)object2).left), Math.min(((Insets)object).top, ((Insets)object2).top), Math.min(((Insets)object).right, ((Insets)object2).right), Math.min(((Insets)object).bottom, ((Insets)object2).bottom)), Insets.of(Math.max(((Insets)object).left, ((Insets)object2).left), Math.max(((Insets)object).top, ((Insets)object2).top), Math.max(((Insets)object).right, ((Insets)object2).right), Math.max(((Insets)object).bottom, ((Insets)object2).bottom)));
        }

        static Interpolator createInsetInterpolator(int n, WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2) {
            if ((n & 8) != 0) {
                if (windowInsetsCompat.getInsets((int)WindowInsetsCompat.Type.ime()).bottom > windowInsetsCompat2.getInsets((int)WindowInsetsCompat.Type.ime()).bottom) {
                    return SHOW_IME_INTERPOLATOR;
                }
                return HIDE_IME_INTERPOLATOR;
            }
            return DEFAULT_INSET_INTERPOLATOR;
        }

        private static View.OnApplyWindowInsetsListener createProxyListener(View view, Callback callback2) {
            return new Impl21OnApplyWindowInsetsListener(view, callback2);
        }

        static void dispatchOnEnd(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
            Callback callback2 = Impl21.getCallback(view);
            if (callback2 != null) {
                callback2.onEnd(windowInsetsAnimationCompat);
                if (callback2.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                view = (ViewGroup)view;
                for (int i = 0; i < view.getChildCount(); ++i) {
                    Impl21.dispatchOnEnd(view.getChildAt(i), windowInsetsAnimationCompat);
                }
            }
        }

        static void dispatchOnPrepare(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsets windowInsets, boolean bl) {
            Callback callback2 = Impl21.getCallback(view);
            boolean bl2 = bl;
            if (callback2 != null) {
                callback2.mDispachedInsets = windowInsets;
                bl2 = bl;
                if (!bl) {
                    callback2.onPrepare(windowInsetsAnimationCompat);
                    bl = callback2.getDispatchMode() == 0;
                    bl2 = bl;
                }
            }
            if (view instanceof ViewGroup) {
                view = (ViewGroup)view;
                for (int i = 0; i < view.getChildCount(); ++i) {
                    Impl21.dispatchOnPrepare(view.getChildAt(i), windowInsetsAnimationCompat, windowInsets, bl2);
                }
            }
        }

        static void dispatchOnProgress(View view, WindowInsetsCompat windowInsetsCompat, List<WindowInsetsAnimationCompat> list) {
            WindowInsetsCompat windowInsetsCompat2;
            Callback callback2 = Impl21.getCallback(view);
            windowInsetsCompat = windowInsetsCompat2 = windowInsetsCompat;
            if (callback2 != null) {
                windowInsetsCompat = callback2.onProgress(windowInsetsCompat2, list);
                if (callback2.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                view = (ViewGroup)view;
                for (int i = 0; i < view.getChildCount(); ++i) {
                    Impl21.dispatchOnProgress(view.getChildAt(i), windowInsetsCompat, list);
                }
            }
        }

        static void dispatchOnStart(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, BoundsCompat boundsCompat) {
            Callback callback2 = Impl21.getCallback(view);
            if (callback2 != null) {
                callback2.onStart(windowInsetsAnimationCompat, boundsCompat);
                if (callback2.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                view = (ViewGroup)view;
                for (int i = 0; i < view.getChildCount(); ++i) {
                    Impl21.dispatchOnStart(view.getChildAt(i), windowInsetsAnimationCompat, boundsCompat);
                }
            }
        }

        static WindowInsets forwardToViewIfNeeded(View view, WindowInsets windowInsets) {
            if (view.getTag(R.id.tag_on_apply_window_listener) != null) {
                return windowInsets;
            }
            return view.onApplyWindowInsets(windowInsets);
        }

        static Callback getCallback(View object) {
            Object object2 = object.getTag(R.id.tag_window_insets_animation_callback);
            object = null;
            if (object2 instanceof Impl21OnApplyWindowInsetsListener) {
                object = ((Impl21OnApplyWindowInsetsListener)object2).mCallback;
            }
            return object;
        }

        static WindowInsetsCompat interpolateInsets(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, float f, int n) {
            WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder(windowInsetsCompat);
            for (int i = 1; i <= 256; i <<= 1) {
                if ((n & i) == 0) {
                    builder.setInsets(i, windowInsetsCompat.getInsets(i));
                    continue;
                }
                Insets insets = windowInsetsCompat.getInsets(i);
                Insets insets2 = windowInsetsCompat2.getInsets(i);
                builder.setInsets(i, WindowInsetsCompat.insetInsets(insets, (int)((double)((float)(insets.left - insets2.left) * (1.0f - f)) + 0.5), (int)((double)((float)(insets.top - insets2.top) * (1.0f - f)) + 0.5), (int)((double)((float)(insets.right - insets2.right) * (1.0f - f)) + 0.5), (int)((double)((float)(insets.bottom - insets2.bottom) * (1.0f - f)) + 0.5)));
            }
            return builder.build();
        }

        static void setCallback(View view, Callback callback2) {
            Object object = view.getTag(R.id.tag_on_apply_window_listener);
            if (callback2 == null) {
                view.setTag(R.id.tag_window_insets_animation_callback, null);
                if (object == null) {
                    view.setOnApplyWindowInsetsListener(null);
                }
            } else {
                callback2 = Impl21.createProxyListener(view, callback2);
                view.setTag(R.id.tag_window_insets_animation_callback, (Object)callback2);
                if (object == null) {
                    view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener)callback2);
                }
            }
        }

        private static class Impl21OnApplyWindowInsetsListener
        implements View.OnApplyWindowInsetsListener {
            private static final int COMPAT_ANIMATION_DURATION = 160;
            final Callback mCallback;
            private WindowInsetsCompat mLastInsets;

            Impl21OnApplyWindowInsetsListener(View object, Callback callback2) {
                this.mCallback = callback2;
                object = ViewCompat.getRootWindowInsets(object);
                object = object != null ? new WindowInsetsCompat.Builder((WindowInsetsCompat)object).build() : null;
                this.mLastInsets = object;
            }

            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                if (!view.isLaidOut()) {
                    this.mLastInsets = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
                    return Impl21.forwardToViewIfNeeded(view, windowInsets);
                }
                WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
                if (this.mLastInsets == null) {
                    this.mLastInsets = ViewCompat.getRootWindowInsets(view);
                }
                if (this.mLastInsets == null) {
                    this.mLastInsets = windowInsetsCompat;
                    return Impl21.forwardToViewIfNeeded(view, windowInsets);
                }
                Callback callback2 = Impl21.getCallback(view);
                if (callback2 != null && Objects.equals(callback2.mDispachedInsets, windowInsets)) {
                    return Impl21.forwardToViewIfNeeded(view, windowInsets);
                }
                int n = Impl21.buildAnimationMask(windowInsetsCompat, this.mLastInsets);
                if (n == 0) {
                    return Impl21.forwardToViewIfNeeded(view, windowInsets);
                }
                WindowInsetsCompat windowInsetsCompat2 = this.mLastInsets;
                WindowInsetsAnimationCompat windowInsetsAnimationCompat = new WindowInsetsAnimationCompat(n, Impl21.createInsetInterpolator(n, windowInsetsCompat, windowInsetsCompat2), 160L);
                windowInsetsAnimationCompat.setFraction(0.0f);
                callback2 = ValueAnimator.ofFloat((float[])new float[]{0.0f, 1.0f}).setDuration(windowInsetsAnimationCompat.getDurationMillis());
                BoundsCompat boundsCompat = Impl21.computeAnimationBounds(windowInsetsCompat, windowInsetsCompat2, n);
                Impl21.dispatchOnPrepare(view, windowInsetsAnimationCompat, windowInsets, false);
                callback2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
                    final Impl21OnApplyWindowInsetsListener this$0;
                    final WindowInsetsAnimationCompat val$anim;
                    final int val$animationMask;
                    final WindowInsetsCompat val$startingInsets;
                    final WindowInsetsCompat val$targetInsets;
                    final View val$v;
                    {
                        this.this$0 = impl21OnApplyWindowInsetsListener;
                        this.val$anim = windowInsetsAnimationCompat;
                        this.val$targetInsets = windowInsetsCompat;
                        this.val$startingInsets = windowInsetsCompat2;
                        this.val$animationMask = n;
                        this.val$v = view;
                    }

                    public void onAnimationUpdate(ValueAnimator object) {
                        this.val$anim.setFraction(object.getAnimatedFraction());
                        object = Impl21.interpolateInsets(this.val$targetInsets, this.val$startingInsets, this.val$anim.getInterpolatedFraction(), this.val$animationMask);
                        List<WindowInsetsAnimationCompat> list = Collections.singletonList(this.val$anim);
                        Impl21.dispatchOnProgress(this.val$v, (WindowInsetsCompat)object, list);
                    }
                });
                callback2.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, windowInsetsAnimationCompat, view){
                    final Impl21OnApplyWindowInsetsListener this$0;
                    final WindowInsetsAnimationCompat val$anim;
                    final View val$v;
                    {
                        this.this$0 = impl21OnApplyWindowInsetsListener;
                        this.val$anim = windowInsetsAnimationCompat;
                        this.val$v = view;
                    }

                    public void onAnimationEnd(Animator animator2) {
                        this.val$anim.setFraction(1.0f);
                        Impl21.dispatchOnEnd(this.val$v, this.val$anim);
                    }
                });
                OneShotPreDrawListener.add(view, new Runnable(){
                    final Impl21OnApplyWindowInsetsListener this$0;
                    final WindowInsetsAnimationCompat val$anim;
                    final BoundsCompat val$animationBounds;
                    final ValueAnimator val$animator;
                    final View val$v;
                    {
                        this.this$0 = impl21OnApplyWindowInsetsListener;
                        this.val$v = view;
                        this.val$anim = windowInsetsAnimationCompat;
                        this.val$animationBounds = boundsCompat;
                        this.val$animator = valueAnimator;
                    }

                    @Override
                    public void run() {
                        Impl21.dispatchOnStart(this.val$v, this.val$anim, this.val$animationBounds);
                        this.val$animator.start();
                    }
                });
                this.mLastInsets = windowInsetsCompat;
                return Impl21.forwardToViewIfNeeded(view, windowInsets);
            }
        }
    }

    private static class Impl30
    extends Impl {
        private final WindowInsetsAnimation mWrapped;

        Impl30(int n, Interpolator interpolator2, long l) {
            this(new WindowInsetsAnimation(n, interpolator2, l));
        }

        Impl30(WindowInsetsAnimation windowInsetsAnimation) {
            super(0, null, 0L);
            this.mWrapped = windowInsetsAnimation;
        }

        public static WindowInsetsAnimation.Bounds createPlatformBounds(BoundsCompat boundsCompat) {
            return new WindowInsetsAnimation.Bounds(boundsCompat.getLowerBound().toPlatformInsets(), boundsCompat.getUpperBound().toPlatformInsets());
        }

        public static Insets getHigherBounds(WindowInsetsAnimation.Bounds bounds) {
            return Insets.toCompatInsets(bounds.getUpperBound());
        }

        public static Insets getLowerBounds(WindowInsetsAnimation.Bounds bounds) {
            return Insets.toCompatInsets(bounds.getLowerBound());
        }

        public static void setCallback(View view, Callback object) {
            object = object != null ? new ProxyCallback((Callback)object) : null;
            view.setWindowInsetsAnimationCallback((WindowInsetsAnimation.Callback)object);
        }

        @Override
        public long getDurationMillis() {
            return this.mWrapped.getDurationMillis();
        }

        @Override
        public float getFraction() {
            return this.mWrapped.getFraction();
        }

        @Override
        public float getInterpolatedFraction() {
            return this.mWrapped.getInterpolatedFraction();
        }

        @Override
        public Interpolator getInterpolator() {
            return this.mWrapped.getInterpolator();
        }

        @Override
        public int getTypeMask() {
            return this.mWrapped.getTypeMask();
        }

        @Override
        public void setFraction(float f) {
            this.mWrapped.setFraction(f);
        }

        private static class ProxyCallback
        extends WindowInsetsAnimation.Callback {
            private final HashMap<WindowInsetsAnimation, WindowInsetsAnimationCompat> mAnimations = new HashMap();
            private final Callback mCompat;
            private List<WindowInsetsAnimationCompat> mRORunningAnimations;
            private ArrayList<WindowInsetsAnimationCompat> mTmpRunningAnimations;

            ProxyCallback(Callback callback2) {
                super(callback2.getDispatchMode());
                this.mCompat = callback2;
            }

            private WindowInsetsAnimationCompat getWindowInsetsAnimationCompat(WindowInsetsAnimation windowInsetsAnimation) {
                WindowInsetsAnimationCompat windowInsetsAnimationCompat;
                WindowInsetsAnimationCompat windowInsetsAnimationCompat2 = windowInsetsAnimationCompat = this.mAnimations.get(windowInsetsAnimation);
                if (windowInsetsAnimationCompat == null) {
                    windowInsetsAnimationCompat2 = WindowInsetsAnimationCompat.toWindowInsetsAnimationCompat(windowInsetsAnimation);
                    this.mAnimations.put(windowInsetsAnimation, windowInsetsAnimationCompat2);
                }
                return windowInsetsAnimationCompat2;
            }

            public void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
                this.mCompat.onEnd(this.getWindowInsetsAnimationCompat(windowInsetsAnimation));
                this.mAnimations.remove(windowInsetsAnimation);
            }

            public void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
                this.mCompat.onPrepare(this.getWindowInsetsAnimationCompat(windowInsetsAnimation));
            }

            public WindowInsets onProgress(WindowInsets windowInsets, List<WindowInsetsAnimation> list) {
                if (this.mTmpRunningAnimations == null) {
                    this.mTmpRunningAnimations = new ArrayList(list.size());
                    this.mRORunningAnimations = Collections.unmodifiableList(this.mTmpRunningAnimations);
                } else {
                    this.mTmpRunningAnimations.clear();
                }
                for (int i = list.size() - 1; i >= 0; --i) {
                    WindowInsetsAnimation windowInsetsAnimation = list.get(i);
                    WindowInsetsAnimationCompat windowInsetsAnimationCompat = this.getWindowInsetsAnimationCompat(windowInsetsAnimation);
                    windowInsetsAnimationCompat.setFraction(windowInsetsAnimation.getFraction());
                    this.mTmpRunningAnimations.add(windowInsetsAnimationCompat);
                }
                return this.mCompat.onProgress(WindowInsetsCompat.toWindowInsetsCompat(windowInsets), this.mRORunningAnimations).toWindowInsets();
            }

            public WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
                return this.mCompat.onStart(this.getWindowInsetsAnimationCompat(windowInsetsAnimation), BoundsCompat.toBoundsCompat(bounds)).toBounds();
            }
        }
    }
}

