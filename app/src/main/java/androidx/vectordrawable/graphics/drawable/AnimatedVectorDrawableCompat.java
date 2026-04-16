/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.AnimatorSet
 *  android.animation.ArgbEvaluator
 *  android.animation.ObjectAnimator
 *  android.animation.TypeEvaluator
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.AnimatedVectorDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.util.AttributeSet
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AndroidResources;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCommon;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatedVectorDrawableCompat
extends VectorDrawableCommon
implements Animatable2Compat {
    private static final String ANIMATED_VECTOR = "animated-vector";
    private static final boolean DBG_ANIMATION_VECTOR_DRAWABLE = false;
    private static final String LOGTAG = "AnimatedVDCompat";
    private static final String TARGET = "target";
    private AnimatedVectorDrawableCompatState mAnimatedVectorState;
    ArrayList<Animatable2Compat.AnimationCallback> mAnimationCallbacks = null;
    private Animator.AnimatorListener mAnimatorListener = null;
    private ArgbEvaluator mArgbEvaluator = null;
    AnimatedVectorDrawableDelegateState mCachedConstantStateDelegate;
    final Drawable.Callback mCallback = new Drawable.Callback(this){
        final AnimatedVectorDrawableCompat this$0;
        {
            this.this$0 = animatedVectorDrawableCompat;
        }

        public void invalidateDrawable(Drawable drawable2) {
            this.this$0.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable2, Runnable runnable2, long l) {
            this.this$0.scheduleSelf(runnable2, l);
        }

        public void unscheduleDrawable(Drawable drawable2, Runnable runnable2) {
            this.this$0.unscheduleSelf(runnable2);
        }
    };
    private Context mContext;

    AnimatedVectorDrawableCompat() {
        this(null, null, null);
    }

    private AnimatedVectorDrawableCompat(Context context) {
        this(context, null, null);
    }

    private AnimatedVectorDrawableCompat(Context context, AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState, Resources resources) {
        this.mContext = context;
        this.mAnimatedVectorState = animatedVectorDrawableCompatState != null ? animatedVectorDrawableCompatState : new AnimatedVectorDrawableCompatState(context, animatedVectorDrawableCompatState, this.mCallback, resources);
    }

    public static void clearAnimationCallbacks(Drawable drawable2) {
        if (!(drawable2 instanceof Animatable)) {
            return;
        }
        ((AnimatedVectorDrawable)drawable2).clearAnimationCallbacks();
    }

    public static AnimatedVectorDrawableCompat create(Context context, int n) {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
        animatedVectorDrawableCompat.mDelegateDrawable = ResourcesCompat.getDrawable(context.getResources(), n, context.getTheme());
        animatedVectorDrawableCompat.mDelegateDrawable.setCallback(animatedVectorDrawableCompat.mCallback);
        animatedVectorDrawableCompat.mCachedConstantStateDelegate = new AnimatedVectorDrawableDelegateState(animatedVectorDrawableCompat.mDelegateDrawable.getConstantState());
        return animatedVectorDrawableCompat;
    }

    public static AnimatedVectorDrawableCompat createFromXmlInner(Context object, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        object = new AnimatedVectorDrawableCompat((Context)object);
        ((AnimatedVectorDrawableCompat)object).inflate(resources, xmlPullParser, attributeSet, theme);
        return object;
    }

    public static void registerAnimationCallback(Drawable drawable2, Animatable2Compat.AnimationCallback animationCallback) {
        if (drawable2 != null && animationCallback != null) {
            if (!(drawable2 instanceof Animatable)) {
                return;
            }
            AnimatedVectorDrawableCompat.registerPlatformCallback((AnimatedVectorDrawable)drawable2, animationCallback);
            return;
        }
    }

    private static void registerPlatformCallback(AnimatedVectorDrawable animatedVectorDrawable, Animatable2Compat.AnimationCallback animationCallback) {
        animatedVectorDrawable.registerAnimationCallback(animationCallback.getPlatformCallback());
    }

    private void removeAnimatorSetListener() {
        if (this.mAnimatorListener != null) {
            this.mAnimatedVectorState.mAnimatorSet.removeListener(this.mAnimatorListener);
            this.mAnimatorListener = null;
        }
    }

    private void setupAnimatorsForTarget(String string2, Animator animator2) {
        animator2.setTarget(this.mAnimatedVectorState.mVectorDrawable.getTargetByName(string2));
        if (this.mAnimatedVectorState.mAnimators == null) {
            this.mAnimatedVectorState.mAnimators = new ArrayList();
            this.mAnimatedVectorState.mTargetNameMap = new ArrayMap();
        }
        this.mAnimatedVectorState.mAnimators.add(animator2);
        this.mAnimatedVectorState.mTargetNameMap.put(animator2, string2);
    }

    private void setupColorAnimator(Animator animator2) {
        Object object;
        if (animator2 instanceof AnimatorSet && (object = ((AnimatorSet)animator2).getChildAnimations()) != null) {
            for (int i = 0; i < object.size(); ++i) {
                this.setupColorAnimator((Animator)object.get(i));
            }
        }
        if (animator2 instanceof ObjectAnimator && ("fillColor".equals(object = (animator2 = (ObjectAnimator)animator2).getPropertyName()) || "strokeColor".equals(object))) {
            if (this.mArgbEvaluator == null) {
                this.mArgbEvaluator = new ArgbEvaluator();
            }
            animator2.setEvaluator((TypeEvaluator)this.mArgbEvaluator);
        }
    }

    public static boolean unregisterAnimationCallback(Drawable drawable2, Animatable2Compat.AnimationCallback animationCallback) {
        if (drawable2 != null && animationCallback != null) {
            if (!(drawable2 instanceof Animatable)) {
                return false;
            }
            return AnimatedVectorDrawableCompat.unregisterPlatformCallback((AnimatedVectorDrawable)drawable2, animationCallback);
        }
        return false;
    }

    private static boolean unregisterPlatformCallback(AnimatedVectorDrawable animatedVectorDrawable, Animatable2Compat.AnimationCallback animationCallback) {
        return animatedVectorDrawable.unregisterAnimationCallback(animationCallback.getPlatformCallback());
    }

    @Override
    public void applyTheme(Resources.Theme theme) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.applyTheme(this.mDelegateDrawable, theme);
            return;
        }
    }

    public boolean canApplyTheme() {
        if (this.mDelegateDrawable != null) {
            return DrawableCompat.canApplyTheme(this.mDelegateDrawable);
        }
        return false;
    }

    @Override
    public void clearAnimationCallbacks() {
        if (this.mDelegateDrawable != null) {
            ((AnimatedVectorDrawable)this.mDelegateDrawable).clearAnimationCallbacks();
            return;
        }
        this.removeAnimatorSetListener();
        if (this.mAnimationCallbacks == null) {
            return;
        }
        this.mAnimationCallbacks.clear();
    }

    public void draw(Canvas canvas) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.draw(canvas);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.draw(canvas);
        if (this.mAnimatedVectorState.mAnimatorSet.isStarted()) {
            this.invalidateSelf();
        }
    }

    public int getAlpha() {
        if (this.mDelegateDrawable != null) {
            return DrawableCompat.getAlpha(this.mDelegateDrawable);
        }
        return this.mAnimatedVectorState.mVectorDrawable.getAlpha();
    }

    public int getChangingConfigurations() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.mAnimatedVectorState.mChangingConfigurations;
    }

    public ColorFilter getColorFilter() {
        if (this.mDelegateDrawable != null) {
            return DrawableCompat.getColorFilter(this.mDelegateDrawable);
        }
        return this.mAnimatedVectorState.mVectorDrawable.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.mDelegateDrawable != null) {
            return new AnimatedVectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
        }
        return null;
    }

    public int getIntrinsicHeight() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getIntrinsicHeight();
        }
        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getIntrinsicWidth();
        }
        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicWidth();
    }

    public int getOpacity() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getOpacity();
        }
        return this.mAnimatedVectorState.mVectorDrawable.getOpacity();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        this.inflate(resources, xmlPullParser, attributeSet, null);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.inflate(this.mDelegateDrawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int n = xmlPullParser.getEventType();
        int n2 = xmlPullParser.getDepth();
        while (n != 1 && (xmlPullParser.getDepth() >= n2 + 1 || n != 3)) {
            if (n == 2) {
                TypedArray typedArray;
                Object object = xmlPullParser.getName();
                if (ANIMATED_VECTOR.equals(object)) {
                    typedArray = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE);
                    n = typedArray.getResourceId(0, 0);
                    if (n != 0) {
                        object = VectorDrawableCompat.create(resources, n, theme);
                        ((VectorDrawableCompat)object).setAllowCaching(false);
                        object.setCallback(this.mCallback);
                        if (this.mAnimatedVectorState.mVectorDrawable != null) {
                            this.mAnimatedVectorState.mVectorDrawable.setCallback(null);
                        }
                        this.mAnimatedVectorState.mVectorDrawable = object;
                    }
                    typedArray.recycle();
                } else if (TARGET.equals(object)) {
                    typedArray = resources.obtainAttributes(attributeSet, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE_TARGET);
                    object = typedArray.getString(0);
                    n = typedArray.getResourceId(1, 0);
                    if (n != 0) {
                        if (this.mContext != null) {
                            this.setupAnimatorsForTarget((String)object, AnimatorInflaterCompat.loadAnimator(this.mContext, n));
                        } else {
                            typedArray.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    typedArray.recycle();
                }
            }
            n = xmlPullParser.next();
        }
        this.mAnimatedVectorState.setupAnimatorSet();
    }

    public boolean isAutoMirrored() {
        if (this.mDelegateDrawable != null) {
            return DrawableCompat.isAutoMirrored(this.mDelegateDrawable);
        }
        return this.mAnimatedVectorState.mVectorDrawable.isAutoMirrored();
    }

    public boolean isRunning() {
        if (this.mDelegateDrawable != null) {
            return ((AnimatedVectorDrawable)this.mDelegateDrawable).isRunning();
        }
        return this.mAnimatedVectorState.mAnimatorSet.isRunning();
    }

    public boolean isStateful() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.isStateful();
        }
        return this.mAnimatedVectorState.mVectorDrawable.isStateful();
    }

    public Drawable mutate() {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.mutate();
        }
        return this;
    }

    @Override
    protected void onBoundsChange(Rect rect) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setBounds(rect);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.setBounds(rect);
    }

    @Override
    protected boolean onLevelChange(int n) {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.setLevel(n);
        }
        return this.mAnimatedVectorState.mVectorDrawable.setLevel(n);
    }

    protected boolean onStateChange(int[] nArray) {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.setState(nArray);
        }
        return this.mAnimatedVectorState.mVectorDrawable.setState(nArray);
    }

    @Override
    public void registerAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        if (this.mDelegateDrawable != null) {
            AnimatedVectorDrawableCompat.registerPlatformCallback((AnimatedVectorDrawable)this.mDelegateDrawable, animationCallback);
            return;
        }
        if (animationCallback == null) {
            return;
        }
        if (this.mAnimationCallbacks == null) {
            this.mAnimationCallbacks = new ArrayList();
        }
        if (this.mAnimationCallbacks.contains(animationCallback)) {
            return;
        }
        this.mAnimationCallbacks.add(animationCallback);
        if (this.mAnimatorListener == null) {
            this.mAnimatorListener = new AnimatorListenerAdapter(this){
                final AnimatedVectorDrawableCompat this$0;
                {
                    this.this$0 = animatedVectorDrawableCompat;
                }

                public void onAnimationEnd(Animator object) {
                    object = new ArrayList<Animatable2Compat.AnimationCallback>(this.this$0.mAnimationCallbacks);
                    int n = ((ArrayList)object).size();
                    for (int i = 0; i < n; ++i) {
                        ((Animatable2Compat.AnimationCallback)((ArrayList)object).get(i)).onAnimationEnd(this.this$0);
                    }
                }

                public void onAnimationStart(Animator object) {
                    object = new ArrayList<Animatable2Compat.AnimationCallback>(this.this$0.mAnimationCallbacks);
                    int n = ((ArrayList)object).size();
                    for (int i = 0; i < n; ++i) {
                        ((Animatable2Compat.AnimationCallback)((ArrayList)object).get(i)).onAnimationStart(this.this$0);
                    }
                }
            };
        }
        this.mAnimatedVectorState.mAnimatorSet.addListener(this.mAnimatorListener);
    }

    public void setAlpha(int n) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setAlpha(n);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.setAlpha(n);
    }

    public void setAutoMirrored(boolean bl) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setAutoMirrored(this.mDelegateDrawable, bl);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.setAutoMirrored(bl);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setColorFilter(colorFilter);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.setColorFilter(colorFilter);
    }

    @Override
    public void setTint(int n) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setTint(this.mDelegateDrawable, n);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.setTint(n);
    }

    @Override
    public void setTintList(ColorStateList colorStateList) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setTintList(this.mDelegateDrawable, colorStateList);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.setTintList(colorStateList);
    }

    @Override
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setTintMode(this.mDelegateDrawable, mode);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.setTintMode(mode);
    }

    public boolean setVisible(boolean bl, boolean bl2) {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.setVisible(bl, bl2);
        }
        this.mAnimatedVectorState.mVectorDrawable.setVisible(bl, bl2);
        return super.setVisible(bl, bl2);
    }

    public void start() {
        if (this.mDelegateDrawable != null) {
            ((AnimatedVectorDrawable)this.mDelegateDrawable).start();
            return;
        }
        if (this.mAnimatedVectorState.mAnimatorSet.isStarted()) {
            return;
        }
        this.mAnimatedVectorState.mAnimatorSet.start();
        this.invalidateSelf();
    }

    public void stop() {
        if (this.mDelegateDrawable != null) {
            ((AnimatedVectorDrawable)this.mDelegateDrawable).stop();
            return;
        }
        this.mAnimatedVectorState.mAnimatorSet.end();
    }

    @Override
    public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        if (this.mDelegateDrawable != null) {
            AnimatedVectorDrawableCompat.unregisterPlatformCallback((AnimatedVectorDrawable)this.mDelegateDrawable, animationCallback);
        }
        if (this.mAnimationCallbacks != null && animationCallback != null) {
            boolean bl = this.mAnimationCallbacks.remove(animationCallback);
            if (this.mAnimationCallbacks.size() == 0) {
                this.removeAnimatorSetListener();
            }
            return bl;
        }
        return false;
    }

    private static class AnimatedVectorDrawableCompatState
    extends Drawable.ConstantState {
        AnimatorSet mAnimatorSet;
        ArrayList<Animator> mAnimators;
        int mChangingConfigurations;
        ArrayMap<Animator, String> mTargetNameMap;
        VectorDrawableCompat mVectorDrawable;

        public AnimatedVectorDrawableCompatState(Context context, AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState, Drawable.Callback object, Resources resources) {
            if (animatedVectorDrawableCompatState != null) {
                this.mChangingConfigurations = animatedVectorDrawableCompatState.mChangingConfigurations;
                if (animatedVectorDrawableCompatState.mVectorDrawable != null) {
                    context = animatedVectorDrawableCompatState.mVectorDrawable.getConstantState();
                    this.mVectorDrawable = resources != null ? (VectorDrawableCompat)context.newDrawable(resources) : (VectorDrawableCompat)context.newDrawable();
                    this.mVectorDrawable = (VectorDrawableCompat)this.mVectorDrawable.mutate();
                    this.mVectorDrawable.setCallback((Drawable.Callback)object);
                    this.mVectorDrawable.setBounds(animatedVectorDrawableCompatState.mVectorDrawable.getBounds());
                    this.mVectorDrawable.setAllowCaching(false);
                }
                if (animatedVectorDrawableCompatState.mAnimators != null) {
                    int n = animatedVectorDrawableCompatState.mAnimators.size();
                    this.mAnimators = new ArrayList(n);
                    this.mTargetNameMap = new ArrayMap(n);
                    for (int i = 0; i < n; ++i) {
                        object = animatedVectorDrawableCompatState.mAnimators.get(i);
                        context = object.clone();
                        object = (String)animatedVectorDrawableCompatState.mTargetNameMap.get(object);
                        context.setTarget(this.mVectorDrawable.getTargetByName((String)object));
                        this.mAnimators.add((Animator)context);
                        this.mTargetNameMap.put((Animator)context, (String)object);
                    }
                    this.setupAnimatorSet();
                }
            }
        }

        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public void setupAnimatorSet() {
            if (this.mAnimatorSet == null) {
                this.mAnimatorSet = new AnimatorSet();
            }
            this.mAnimatorSet.playTogether(this.mAnimators);
        }
    }

    private static class AnimatedVectorDrawableDelegateState
    extends Drawable.ConstantState {
        private final Drawable.ConstantState mDelegateState;

        public AnimatedVectorDrawableDelegateState(Drawable.ConstantState constantState) {
            this.mDelegateState = constantState;
        }

        public boolean canApplyTheme() {
            return this.mDelegateState.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.mDelegateState.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            animatedVectorDrawableCompat.mDelegateDrawable = this.mDelegateState.newDrawable();
            animatedVectorDrawableCompat.mDelegateDrawable.setCallback(animatedVectorDrawableCompat.mCallback);
            return animatedVectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            animatedVectorDrawableCompat.mDelegateDrawable = this.mDelegateState.newDrawable(resources);
            animatedVectorDrawableCompat.mDelegateDrawable.setCallback(animatedVectorDrawableCompat.mCallback);
            return animatedVectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            animatedVectorDrawableCompat.mDelegateDrawable = this.mDelegateState.newDrawable(resources, theme);
            animatedVectorDrawableCompat.mDelegateDrawable.setCallback(animatedVectorDrawableCompat.mCallback);
            return animatedVectorDrawableCompat;
        }
    }
}

