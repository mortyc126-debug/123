/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Outline
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.SystemClock
 *  android.util.SparseArray
 */
package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.core.graphics.drawable.DrawableCompat;

public class DrawableContainerCompat
extends Drawable
implements Drawable.Callback {
    private static final boolean DEBUG = false;
    private static final boolean DEFAULT_DITHER = true;
    private static final String TAG = "DrawableContainerCompat";
    private int mAlpha = 255;
    private Runnable mAnimationRunnable;
    private BlockInvalidateCallback mBlockInvalidateCallback;
    private int mCurIndex = -1;
    private Drawable mCurrDrawable;
    private DrawableContainerState mDrawableContainerState;
    private long mEnterAnimationEnd;
    private long mExitAnimationEnd;
    private boolean mHasAlpha;
    private Rect mHotspotBounds;
    private Drawable mLastDrawable;
    private boolean mMutated;

    private void initializeDrawableForDisplay(Drawable drawable2) {
        block10: {
            if (this.mBlockInvalidateCallback == null) {
                this.mBlockInvalidateCallback = new BlockInvalidateCallback();
            }
            drawable2.setCallback((Drawable.Callback)this.mBlockInvalidateCallback.wrap(drawable2.getCallback()));
            if (this.mDrawableContainerState.mEnterFadeDuration <= 0 && this.mHasAlpha) {
                drawable2.setAlpha(this.mAlpha);
            }
            if (this.mDrawableContainerState.mHasColorFilter) {
                drawable2.setColorFilter(this.mDrawableContainerState.mColorFilter);
            } else {
                if (this.mDrawableContainerState.mHasTintList) {
                    DrawableCompat.setTintList(drawable2, this.mDrawableContainerState.mTintList);
                }
                if (this.mDrawableContainerState.mHasTintMode) {
                    DrawableCompat.setTintMode(drawable2, this.mDrawableContainerState.mTintMode);
                }
            }
            drawable2.setVisible(this.isVisible(), true);
            drawable2.setDither(this.mDrawableContainerState.mDither);
            drawable2.setState(this.getState());
            drawable2.setLevel(this.getLevel());
            drawable2.setBounds(this.getBounds());
            DrawableCompat.setLayoutDirection(drawable2, DrawableCompat.getLayoutDirection(this));
            DrawableCompat.setAutoMirrored(drawable2, this.mDrawableContainerState.mAutoMirrored);
            Rect rect = this.mHotspotBounds;
            if (rect == null) break block10;
            DrawableCompat.setHotspotBounds(drawable2, rect.left, rect.top, rect.right, rect.bottom);
        }
        return;
        finally {
            drawable2.setCallback(this.mBlockInvalidateCallback.unwrap());
        }
    }

    private boolean needsMirroring() {
        boolean bl;
        block3: {
            block2: {
                if (!this.isAutoMirrored()) break block2;
                int n = DrawableCompat.getLayoutDirection(this);
                bl = true;
                if (n == 1) break block3;
            }
            bl = false;
        }
        return bl;
    }

    static int resolveDensity(Resources resources, int n) {
        block1: {
            if (resources != null) {
                n = resources.getDisplayMetrics().densityDpi;
            }
            if (n != 0) break block1;
            n = 160;
        }
        return n;
    }

    void animate(boolean bl) {
        int n;
        this.mHasAlpha = true;
        long l = SystemClock.uptimeMillis();
        int n2 = 0;
        if (this.mCurrDrawable != null) {
            n = n2;
            if (this.mEnterAnimationEnd != 0L) {
                if (this.mEnterAnimationEnd <= l) {
                    this.mCurrDrawable.setAlpha(this.mAlpha);
                    this.mEnterAnimationEnd = 0L;
                    n = n2;
                } else {
                    n = (int)((this.mEnterAnimationEnd - l) * 255L) / this.mDrawableContainerState.mEnterFadeDuration;
                    this.mCurrDrawable.setAlpha((255 - n) * this.mAlpha / 255);
                    n = 1;
                }
            }
        } else {
            this.mEnterAnimationEnd = 0L;
            n = n2;
        }
        if (this.mLastDrawable != null) {
            n2 = n;
            if (this.mExitAnimationEnd != 0L) {
                if (this.mExitAnimationEnd <= l) {
                    this.mLastDrawable.setVisible(false, false);
                    this.mLastDrawable = null;
                    this.mExitAnimationEnd = 0L;
                    n2 = n;
                } else {
                    n = (int)((this.mExitAnimationEnd - l) * 255L) / this.mDrawableContainerState.mExitFadeDuration;
                    this.mLastDrawable.setAlpha(this.mAlpha * n / 255);
                    n2 = 1;
                }
            }
        } else {
            this.mExitAnimationEnd = 0L;
            n2 = n;
        }
        if (bl && n2 != 0) {
            this.scheduleSelf(this.mAnimationRunnable, 16L + l);
        }
    }

    public void applyTheme(Resources.Theme theme) {
        this.mDrawableContainerState.applyTheme(theme);
    }

    public boolean canApplyTheme() {
        return this.mDrawableContainerState.canApplyTheme();
    }

    void clearMutated() {
        this.mDrawableContainerState.clearMutated();
        this.mMutated = false;
    }

    DrawableContainerState cloneConstantState() {
        return this.mDrawableContainerState;
    }

    public void draw(Canvas canvas) {
        if (this.mCurrDrawable != null) {
            this.mCurrDrawable.draw(canvas);
        }
        if (this.mLastDrawable != null) {
            this.mLastDrawable.draw(canvas);
        }
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.mDrawableContainerState.getChangingConfigurations();
    }

    public final Drawable.ConstantState getConstantState() {
        if (this.mDrawableContainerState.canConstantState()) {
            this.mDrawableContainerState.mChangingConfigurations = this.getChangingConfigurations();
            return this.mDrawableContainerState;
        }
        return null;
    }

    public Drawable getCurrent() {
        return this.mCurrDrawable;
    }

    int getCurrentIndex() {
        return this.mCurIndex;
    }

    public void getHotspotBounds(Rect rect) {
        if (this.mHotspotBounds != null) {
            rect.set(this.mHotspotBounds);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    public int getIntrinsicHeight() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantHeight();
        }
        int n = this.mCurrDrawable != null ? this.mCurrDrawable.getIntrinsicHeight() : -1;
        return n;
    }

    public int getIntrinsicWidth() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantWidth();
        }
        int n = this.mCurrDrawable != null ? this.mCurrDrawable.getIntrinsicWidth() : -1;
        return n;
    }

    public int getMinimumHeight() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantMinimumHeight();
        }
        int n = this.mCurrDrawable != null ? this.mCurrDrawable.getMinimumHeight() : 0;
        return n;
    }

    public int getMinimumWidth() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantMinimumWidth();
        }
        int n = this.mCurrDrawable != null ? this.mCurrDrawable.getMinimumWidth() : 0;
        return n;
    }

    public int getOpacity() {
        int n = this.mCurrDrawable != null && this.mCurrDrawable.isVisible() ? this.mDrawableContainerState.getOpacity() : -2;
        return n;
    }

    public void getOutline(Outline outline) {
        if (this.mCurrDrawable != null) {
            Api21Impl.getOutline(this.mCurrDrawable, outline);
        }
    }

    public boolean getPadding(Rect rect) {
        boolean bl;
        Rect rect2 = this.mDrawableContainerState.getConstantPadding();
        if (rect2 != null) {
            rect.set(rect2);
            bl = (rect2.left | rect2.top | rect2.bottom | rect2.right) != 0;
        } else {
            bl = this.mCurrDrawable != null ? this.mCurrDrawable.getPadding(rect) : super.getPadding(rect);
        }
        if (this.needsMirroring()) {
            int n = rect.left;
            rect.left = rect.right;
            rect.right = n;
        }
        return bl;
    }

    public void invalidateDrawable(Drawable drawable2) {
        if (this.mDrawableContainerState != null) {
            this.mDrawableContainerState.invalidateCache();
        }
        if (drawable2 == this.mCurrDrawable && this.getCallback() != null) {
            this.getCallback().invalidateDrawable((Drawable)this);
        }
    }

    public boolean isAutoMirrored() {
        return this.mDrawableContainerState.mAutoMirrored;
    }

    public boolean isStateful() {
        return this.mDrawableContainerState.isStateful();
    }

    public void jumpToCurrentState() {
        boolean bl = false;
        if (this.mLastDrawable != null) {
            this.mLastDrawable.jumpToCurrentState();
            this.mLastDrawable = null;
            bl = true;
        }
        if (this.mCurrDrawable != null) {
            this.mCurrDrawable.jumpToCurrentState();
            if (this.mHasAlpha) {
                this.mCurrDrawable.setAlpha(this.mAlpha);
            }
        }
        if (this.mExitAnimationEnd != 0L) {
            this.mExitAnimationEnd = 0L;
            bl = true;
        }
        if (this.mEnterAnimationEnd != 0L) {
            this.mEnterAnimationEnd = 0L;
            bl = true;
        }
        if (bl) {
            this.invalidateSelf();
        }
    }

    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            DrawableContainerState drawableContainerState = this.cloneConstantState();
            drawableContainerState.mutate();
            this.setConstantState(drawableContainerState);
            this.mMutated = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.mLastDrawable != null) {
            this.mLastDrawable.setBounds(rect);
        }
        if (this.mCurrDrawable != null) {
            this.mCurrDrawable.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int n) {
        return this.mDrawableContainerState.setLayoutDirection(n, this.getCurrentIndex());
    }

    protected boolean onLevelChange(int n) {
        if (this.mLastDrawable != null) {
            return this.mLastDrawable.setLevel(n);
        }
        if (this.mCurrDrawable != null) {
            return this.mCurrDrawable.setLevel(n);
        }
        return false;
    }

    protected boolean onStateChange(int[] nArray) {
        if (this.mLastDrawable != null) {
            return this.mLastDrawable.setState(nArray);
        }
        if (this.mCurrDrawable != null) {
            return this.mCurrDrawable.setState(nArray);
        }
        return false;
    }

    public void scheduleDrawable(Drawable drawable2, Runnable runnable2, long l) {
        if (drawable2 == this.mCurrDrawable && this.getCallback() != null) {
            this.getCallback().scheduleDrawable((Drawable)this, runnable2, l);
        }
    }

    boolean selectDrawable(int n) {
        if (n == this.mCurIndex) {
            return false;
        }
        long l = SystemClock.uptimeMillis();
        if (this.mDrawableContainerState.mExitFadeDuration > 0) {
            if (this.mLastDrawable != null) {
                this.mLastDrawable.setVisible(false, false);
            }
            if (this.mCurrDrawable != null) {
                this.mLastDrawable = this.mCurrDrawable;
                this.mExitAnimationEnd = (long)this.mDrawableContainerState.mExitFadeDuration + l;
            } else {
                this.mLastDrawable = null;
                this.mExitAnimationEnd = 0L;
            }
        } else if (this.mCurrDrawable != null) {
            this.mCurrDrawable.setVisible(false, false);
        }
        if (n >= 0 && n < this.mDrawableContainerState.mNumChildren) {
            Drawable drawable2;
            this.mCurrDrawable = drawable2 = this.mDrawableContainerState.getChild(n);
            this.mCurIndex = n;
            if (drawable2 != null) {
                if (this.mDrawableContainerState.mEnterFadeDuration > 0) {
                    this.mEnterAnimationEnd = (long)this.mDrawableContainerState.mEnterFadeDuration + l;
                }
                this.initializeDrawableForDisplay(drawable2);
            }
        } else {
            this.mCurrDrawable = null;
            this.mCurIndex = -1;
        }
        if (this.mEnterAnimationEnd != 0L || this.mExitAnimationEnd != 0L) {
            if (this.mAnimationRunnable == null) {
                this.mAnimationRunnable = new Runnable(this){
                    final DrawableContainerCompat this$0;
                    {
                        this.this$0 = drawableContainerCompat;
                    }

                    @Override
                    public void run() {
                        this.this$0.animate(true);
                        this.this$0.invalidateSelf();
                    }
                };
            } else {
                this.unscheduleSelf(this.mAnimationRunnable);
            }
            this.animate(true);
        }
        this.invalidateSelf();
        return true;
    }

    public void setAlpha(int n) {
        if (!this.mHasAlpha || this.mAlpha != n) {
            this.mHasAlpha = true;
            this.mAlpha = n;
            if (this.mCurrDrawable != null) {
                if (this.mEnterAnimationEnd == 0L) {
                    this.mCurrDrawable.setAlpha(n);
                } else {
                    this.animate(false);
                }
            }
        }
    }

    public void setAutoMirrored(boolean bl) {
        if (this.mDrawableContainerState.mAutoMirrored != bl) {
            this.mDrawableContainerState.mAutoMirrored = bl;
            if (this.mCurrDrawable != null) {
                DrawableCompat.setAutoMirrored(this.mCurrDrawable, this.mDrawableContainerState.mAutoMirrored);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mDrawableContainerState.mHasColorFilter = true;
        if (this.mDrawableContainerState.mColorFilter != colorFilter) {
            this.mDrawableContainerState.mColorFilter = colorFilter;
            if (this.mCurrDrawable != null) {
                this.mCurrDrawable.setColorFilter(colorFilter);
            }
        }
    }

    void setConstantState(DrawableContainerState drawableContainerState) {
        this.mDrawableContainerState = drawableContainerState;
        if (this.mCurIndex >= 0) {
            this.mCurrDrawable = drawableContainerState.getChild(this.mCurIndex);
            if (this.mCurrDrawable != null) {
                this.initializeDrawableForDisplay(this.mCurrDrawable);
            }
        }
        this.mLastDrawable = null;
    }

    void setCurrentIndex(int n) {
        this.selectDrawable(n);
    }

    public void setDither(boolean bl) {
        if (this.mDrawableContainerState.mDither != bl) {
            this.mDrawableContainerState.mDither = bl;
            if (this.mCurrDrawable != null) {
                this.mCurrDrawable.setDither(this.mDrawableContainerState.mDither);
            }
        }
    }

    public void setEnterFadeDuration(int n) {
        this.mDrawableContainerState.mEnterFadeDuration = n;
    }

    public void setExitFadeDuration(int n) {
        this.mDrawableContainerState.mExitFadeDuration = n;
    }

    public void setHotspot(float f, float f2) {
        if (this.mCurrDrawable != null) {
            DrawableCompat.setHotspot(this.mCurrDrawable, f, f2);
        }
    }

    public void setHotspotBounds(int n, int n2, int n3, int n4) {
        if (this.mHotspotBounds == null) {
            this.mHotspotBounds = new Rect(n, n2, n3, n4);
        } else {
            this.mHotspotBounds.set(n, n2, n3, n4);
        }
        if (this.mCurrDrawable != null) {
            DrawableCompat.setHotspotBounds(this.mCurrDrawable, n, n2, n3, n4);
        }
    }

    public void setTint(int n) {
        this.setTintList(ColorStateList.valueOf((int)n));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.mDrawableContainerState.mHasTintList = true;
        if (this.mDrawableContainerState.mTintList != colorStateList) {
            this.mDrawableContainerState.mTintList = colorStateList;
            DrawableCompat.setTintList(this.mCurrDrawable, colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.mDrawableContainerState.mHasTintMode = true;
        if (this.mDrawableContainerState.mTintMode != mode) {
            this.mDrawableContainerState.mTintMode = mode;
            DrawableCompat.setTintMode(this.mCurrDrawable, mode);
        }
    }

    public boolean setVisible(boolean bl, boolean bl2) {
        boolean bl3 = super.setVisible(bl, bl2);
        if (this.mLastDrawable != null) {
            this.mLastDrawable.setVisible(bl, bl2);
        }
        if (this.mCurrDrawable != null) {
            this.mCurrDrawable.setVisible(bl, bl2);
        }
        return bl3;
    }

    public void unscheduleDrawable(Drawable drawable2, Runnable runnable2) {
        if (drawable2 == this.mCurrDrawable && this.getCallback() != null) {
            this.getCallback().unscheduleDrawable((Drawable)this, runnable2);
        }
    }

    final void updateDensity(Resources resources) {
        this.mDrawableContainerState.updateDensity(resources);
    }

    private static class Api21Impl {
        private Api21Impl() {
        }

        public static boolean canApplyTheme(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static void getOutline(Drawable drawable2, Outline outline) {
            drawable2.getOutline(outline);
        }

        public static Resources getResources(Resources.Theme theme) {
            return theme.getResources();
        }
    }

    static class BlockInvalidateCallback
    implements Drawable.Callback {
        private Drawable.Callback mCallback;

        BlockInvalidateCallback() {
        }

        public void invalidateDrawable(Drawable drawable2) {
        }

        public void scheduleDrawable(Drawable drawable2, Runnable runnable2, long l) {
            if (this.mCallback != null) {
                this.mCallback.scheduleDrawable(drawable2, runnable2, l);
            }
        }

        public void unscheduleDrawable(Drawable drawable2, Runnable runnable2) {
            if (this.mCallback != null) {
                this.mCallback.unscheduleDrawable(drawable2, runnable2);
            }
        }

        public Drawable.Callback unwrap() {
            Drawable.Callback callback2 = this.mCallback;
            this.mCallback = null;
            return callback2;
        }

        public BlockInvalidateCallback wrap(Drawable.Callback callback2) {
            this.mCallback = callback2;
            return this;
        }
    }

    static abstract class DrawableContainerState
    extends Drawable.ConstantState {
        boolean mAutoMirrored;
        boolean mCanConstantState;
        int mChangingConfigurations;
        boolean mCheckedConstantSize;
        boolean mCheckedConstantState;
        boolean mCheckedOpacity;
        boolean mCheckedPadding;
        boolean mCheckedStateful;
        int mChildrenChangingConfigurations;
        ColorFilter mColorFilter;
        int mConstantHeight;
        int mConstantMinimumHeight;
        int mConstantMinimumWidth;
        Rect mConstantPadding;
        boolean mConstantSize = false;
        int mConstantWidth;
        int mDensity;
        boolean mDither = true;
        SparseArray<Drawable.ConstantState> mDrawableFutures;
        Drawable[] mDrawables;
        int mEnterFadeDuration = 0;
        int mExitFadeDuration = 0;
        boolean mHasColorFilter;
        boolean mHasTintList;
        boolean mHasTintMode;
        int mLayoutDirection;
        boolean mMutated;
        int mNumChildren;
        int mOpacity;
        final DrawableContainerCompat mOwner;
        Resources mSourceRes;
        boolean mStateful;
        ColorStateList mTintList;
        PorterDuff.Mode mTintMode;
        boolean mVariablePadding = false;

        DrawableContainerState(DrawableContainerState constantState, DrawableContainerCompat object, Resources resources) {
            this.mOwner = object;
            Object var6_4 = null;
            object = resources != null ? resources : (constantState != null ? constantState.mSourceRes : null);
            this.mSourceRes = object;
            int n = constantState != null ? constantState.mDensity : 0;
            this.mDensity = DrawableContainerCompat.resolveDensity(resources, n);
            if (constantState != null) {
                this.mChangingConfigurations = constantState.mChangingConfigurations;
                this.mChildrenChangingConfigurations = constantState.mChildrenChangingConfigurations;
                this.mCheckedConstantState = true;
                this.mCanConstantState = true;
                this.mVariablePadding = constantState.mVariablePadding;
                this.mConstantSize = constantState.mConstantSize;
                this.mDither = constantState.mDither;
                this.mMutated = constantState.mMutated;
                this.mLayoutDirection = constantState.mLayoutDirection;
                this.mEnterFadeDuration = constantState.mEnterFadeDuration;
                this.mExitFadeDuration = constantState.mExitFadeDuration;
                this.mAutoMirrored = constantState.mAutoMirrored;
                this.mColorFilter = constantState.mColorFilter;
                this.mHasColorFilter = constantState.mHasColorFilter;
                this.mTintList = constantState.mTintList;
                this.mTintMode = constantState.mTintMode;
                this.mHasTintList = constantState.mHasTintList;
                this.mHasTintMode = constantState.mHasTintMode;
                if (constantState.mDensity == this.mDensity) {
                    if (constantState.mCheckedPadding) {
                        object = constantState.mConstantPadding != null ? new Rect(constantState.mConstantPadding) : var6_4;
                        this.mConstantPadding = object;
                        this.mCheckedPadding = true;
                    }
                    if (constantState.mCheckedConstantSize) {
                        this.mConstantWidth = constantState.mConstantWidth;
                        this.mConstantHeight = constantState.mConstantHeight;
                        this.mConstantMinimumWidth = constantState.mConstantMinimumWidth;
                        this.mConstantMinimumHeight = constantState.mConstantMinimumHeight;
                        this.mCheckedConstantSize = true;
                    }
                }
                if (constantState.mCheckedOpacity) {
                    this.mOpacity = constantState.mOpacity;
                    this.mCheckedOpacity = true;
                }
                if (constantState.mCheckedStateful) {
                    this.mStateful = constantState.mStateful;
                    this.mCheckedStateful = true;
                }
                object = constantState.mDrawables;
                this.mDrawables = new Drawable[((Rect)object).length];
                this.mNumChildren = constantState.mNumChildren;
                constantState = constantState.mDrawableFutures;
                this.mDrawableFutures = constantState != null ? constantState.clone() : new SparseArray(this.mNumChildren);
                int n2 = this.mNumChildren;
                for (n = 0; n < n2; ++n) {
                    if (object[n] == null) continue;
                    constantState = object[n].getConstantState();
                    if (constantState != null) {
                        this.mDrawableFutures.put(n, (Object)constantState);
                        continue;
                    }
                    this.mDrawables[n] = object[n];
                }
            } else {
                this.mDrawables = new Drawable[10];
                this.mNumChildren = 0;
            }
        }

        private void createAllFutures() {
            if (this.mDrawableFutures != null) {
                int n = this.mDrawableFutures.size();
                for (int i = 0; i < n; ++i) {
                    int n2 = this.mDrawableFutures.keyAt(i);
                    Drawable.ConstantState constantState = (Drawable.ConstantState)this.mDrawableFutures.valueAt(i);
                    this.mDrawables[n2] = this.prepareDrawable(constantState.newDrawable(this.mSourceRes));
                }
                this.mDrawableFutures = null;
            }
        }

        private Drawable prepareDrawable(Drawable drawable2) {
            DrawableCompat.setLayoutDirection(drawable2, this.mLayoutDirection);
            drawable2 = drawable2.mutate();
            drawable2.setCallback((Drawable.Callback)this.mOwner);
            return drawable2;
        }

        public final int addChild(Drawable drawable2) {
            int n = this.mNumChildren;
            if (n >= this.mDrawables.length) {
                this.growArray(n, n + 10);
            }
            drawable2.mutate();
            drawable2.setVisible(false, true);
            drawable2.setCallback((Drawable.Callback)this.mOwner);
            this.mDrawables[n] = drawable2;
            ++this.mNumChildren;
            this.mChildrenChangingConfigurations |= drawable2.getChangingConfigurations();
            this.invalidateCache();
            this.mConstantPadding = null;
            this.mCheckedPadding = false;
            this.mCheckedConstantSize = false;
            this.mCheckedConstantState = false;
            return n;
        }

        final void applyTheme(Resources.Theme theme) {
            if (theme != null) {
                this.createAllFutures();
                int n = this.mNumChildren;
                Drawable[] drawableArray = this.mDrawables;
                for (int i = 0; i < n; ++i) {
                    if (drawableArray[i] == null || !DrawableCompat.canApplyTheme(drawableArray[i])) continue;
                    DrawableCompat.applyTheme(drawableArray[i], theme);
                    this.mChildrenChangingConfigurations |= drawableArray[i].getChangingConfigurations();
                }
                this.updateDensity(Api21Impl.getResources(theme));
            }
        }

        public boolean canApplyTheme() {
            int n = this.mNumChildren;
            Drawable[] drawableArray = this.mDrawables;
            for (int i = 0; i < n; ++i) {
                Drawable drawable2 = drawableArray[i];
                if (!(drawable2 != null ? DrawableCompat.canApplyTheme(drawable2) : (drawable2 = (Drawable.ConstantState)this.mDrawableFutures.get(i)) != null && Api21Impl.canApplyTheme((Drawable.ConstantState)drawable2))) continue;
                return true;
            }
            return false;
        }

        public boolean canConstantState() {
            if (this.mCheckedConstantState) {
                return this.mCanConstantState;
            }
            this.createAllFutures();
            this.mCheckedConstantState = true;
            int n = this.mNumChildren;
            Drawable[] drawableArray = this.mDrawables;
            for (int i = 0; i < n; ++i) {
                if (drawableArray[i].getConstantState() != null) continue;
                this.mCanConstantState = false;
                return false;
            }
            this.mCanConstantState = true;
            return true;
        }

        final void clearMutated() {
            this.mMutated = false;
        }

        protected void computeConstantSize() {
            this.mCheckedConstantSize = true;
            this.createAllFutures();
            int n = this.mNumChildren;
            Drawable[] drawableArray = this.mDrawables;
            this.mConstantHeight = -1;
            this.mConstantWidth = -1;
            this.mConstantMinimumHeight = 0;
            this.mConstantMinimumWidth = 0;
            for (int i = 0; i < n; ++i) {
                Drawable drawable2 = drawableArray[i];
                int n2 = drawable2.getIntrinsicWidth();
                if (n2 > this.mConstantWidth) {
                    this.mConstantWidth = n2;
                }
                if ((n2 = drawable2.getIntrinsicHeight()) > this.mConstantHeight) {
                    this.mConstantHeight = n2;
                }
                if ((n2 = drawable2.getMinimumWidth()) > this.mConstantMinimumWidth) {
                    this.mConstantMinimumWidth = n2;
                }
                if ((n2 = drawable2.getMinimumHeight()) <= this.mConstantMinimumHeight) continue;
                this.mConstantMinimumHeight = n2;
            }
        }

        final int getCapacity() {
            return this.mDrawables.length;
        }

        public int getChangingConfigurations() {
            return this.mChangingConfigurations | this.mChildrenChangingConfigurations;
        }

        public final Drawable getChild(int n) {
            int n2;
            Drawable drawable2 = this.mDrawables[n];
            if (drawable2 != null) {
                return drawable2;
            }
            if (this.mDrawableFutures != null && (n2 = this.mDrawableFutures.indexOfKey(n)) >= 0) {
                this.mDrawables[n] = drawable2 = this.prepareDrawable(((Drawable.ConstantState)this.mDrawableFutures.valueAt(n2)).newDrawable(this.mSourceRes));
                this.mDrawableFutures.removeAt(n2);
                if (this.mDrawableFutures.size() == 0) {
                    this.mDrawableFutures = null;
                }
                return drawable2;
            }
            return null;
        }

        public final int getChildCount() {
            return this.mNumChildren;
        }

        public final int getConstantHeight() {
            if (!this.mCheckedConstantSize) {
                this.computeConstantSize();
            }
            return this.mConstantHeight;
        }

        public final int getConstantMinimumHeight() {
            if (!this.mCheckedConstantSize) {
                this.computeConstantSize();
            }
            return this.mConstantMinimumHeight;
        }

        public final int getConstantMinimumWidth() {
            if (!this.mCheckedConstantSize) {
                this.computeConstantSize();
            }
            return this.mConstantMinimumWidth;
        }

        public final Rect getConstantPadding() {
            if (this.mVariablePadding) {
                return null;
            }
            if (this.mConstantPadding == null && !this.mCheckedPadding) {
                this.createAllFutures();
                Rect rect = null;
                Rect rect2 = new Rect();
                int n = this.mNumChildren;
                Drawable[] drawableArray = this.mDrawables;
                for (int i = 0; i < n; ++i) {
                    Rect rect3 = rect;
                    if (drawableArray[i].getPadding(rect2)) {
                        Rect rect4 = rect;
                        if (rect == null) {
                            rect4 = new Rect(0, 0, 0, 0);
                        }
                        if (rect2.left > rect4.left) {
                            rect4.left = rect2.left;
                        }
                        if (rect2.top > rect4.top) {
                            rect4.top = rect2.top;
                        }
                        if (rect2.right > rect4.right) {
                            rect4.right = rect2.right;
                        }
                        rect3 = rect4;
                        if (rect2.bottom > rect4.bottom) {
                            rect4.bottom = rect2.bottom;
                            rect3 = rect4;
                        }
                    }
                    rect = rect3;
                }
                this.mCheckedPadding = true;
                this.mConstantPadding = rect;
                return rect;
            }
            return this.mConstantPadding;
        }

        public final int getConstantWidth() {
            if (!this.mCheckedConstantSize) {
                this.computeConstantSize();
            }
            return this.mConstantWidth;
        }

        public final int getEnterFadeDuration() {
            return this.mEnterFadeDuration;
        }

        public final int getExitFadeDuration() {
            return this.mExitFadeDuration;
        }

        public final int getOpacity() {
            if (this.mCheckedOpacity) {
                return this.mOpacity;
            }
            this.createAllFutures();
            int n = this.mNumChildren;
            Drawable[] drawableArray = this.mDrawables;
            int n2 = n > 0 ? drawableArray[0].getOpacity() : -2;
            for (int i = 1; i < n; ++i) {
                n2 = Drawable.resolveOpacity((int)n2, (int)drawableArray[i].getOpacity());
            }
            this.mOpacity = n2;
            this.mCheckedOpacity = true;
            return n2;
        }

        public void growArray(int n, int n2) {
            Drawable[] drawableArray = new Drawable[n2];
            if (this.mDrawables != null) {
                System.arraycopy(this.mDrawables, 0, drawableArray, 0, n);
            }
            this.mDrawables = drawableArray;
        }

        void invalidateCache() {
            this.mCheckedOpacity = false;
            this.mCheckedStateful = false;
        }

        public final boolean isConstantSize() {
            return this.mConstantSize;
        }

        public final boolean isStateful() {
            boolean bl;
            if (this.mCheckedStateful) {
                return this.mStateful;
            }
            this.createAllFutures();
            int n = this.mNumChildren;
            Drawable[] drawableArray = this.mDrawables;
            boolean bl2 = false;
            int n2 = 0;
            while (true) {
                bl = bl2;
                if (n2 >= n) break;
                if (drawableArray[n2].isStateful()) {
                    bl = true;
                    break;
                }
                ++n2;
            }
            this.mStateful = bl;
            this.mCheckedStateful = true;
            return bl;
        }

        void mutate() {
            int n = this.mNumChildren;
            Drawable[] drawableArray = this.mDrawables;
            for (int i = 0; i < n; ++i) {
                if (drawableArray[i] == null) continue;
                drawableArray[i].mutate();
            }
            this.mMutated = true;
        }

        public final void setConstantSize(boolean bl) {
            this.mConstantSize = bl;
        }

        public final void setEnterFadeDuration(int n) {
            this.mEnterFadeDuration = n;
        }

        public final void setExitFadeDuration(int n) {
            this.mExitFadeDuration = n;
        }

        final boolean setLayoutDirection(int n, int n2) {
            boolean bl = false;
            int n3 = this.mNumChildren;
            Drawable[] drawableArray = this.mDrawables;
            for (int i = 0; i < n3; ++i) {
                boolean bl2 = bl;
                if (drawableArray[i] != null) {
                    boolean bl3 = DrawableCompat.setLayoutDirection(drawableArray[i], n);
                    bl2 = bl;
                    if (i == n2) {
                        bl2 = bl3;
                    }
                }
                bl = bl2;
            }
            this.mLayoutDirection = n;
            return bl;
        }

        public final void setVariablePadding(boolean bl) {
            this.mVariablePadding = bl;
        }

        final void updateDensity(Resources resources) {
            if (resources != null) {
                this.mSourceRes = resources;
                int n = DrawableContainerCompat.resolveDensity(resources, this.mDensity);
                int n2 = this.mDensity;
                this.mDensity = n;
                if (n2 != n) {
                    this.mCheckedConstantSize = false;
                    this.mCheckedPadding = false;
                }
            }
        }
    }
}

