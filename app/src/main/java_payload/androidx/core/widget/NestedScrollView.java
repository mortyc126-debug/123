/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.TypedValue
 *  android.view.FocusFinder
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.View$BaseSavedState
 *  android.view.View$MeasureSpec
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityRecord
 *  android.view.animation.AnimationUtils
 *  android.widget.EdgeEffect
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.OverScroller
 *  android.widget.ScrollView
 */
package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.R;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.DifferentialMotionFlingController;
import androidx.core.view.DifferentialMotionFlingTarget;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.core.widget.EdgeEffectCompat;
import java.util.ArrayList;

public class NestedScrollView
extends FrameLayout
implements NestedScrollingParent3,
NestedScrollingChild3,
ScrollingView {
    private static final AccessibilityDelegate ACCESSIBILITY_DELEGATE;
    static final int ANIMATED_SCROLL_GAP = 250;
    private static final float DECELERATION_RATE;
    private static final int DEFAULT_SMOOTH_SCROLL_DURATION = 250;
    private static final float FLING_DESTRETCH_FACTOR = 4.0f;
    private static final float INFLEXION = 0.35f;
    private static final int INVALID_POINTER = -1;
    static final float MAX_SCROLL_FACTOR = 0.5f;
    private static final int[] SCROLLVIEW_STYLEABLE;
    private static final float SCROLL_FRICTION = 0.015f;
    private static final String TAG = "NestedScrollView";
    private int mActivePointerId = -1;
    private final NestedScrollingChildHelper mChildHelper;
    private View mChildToScrollTo = null;
    DifferentialMotionFlingController mDifferentialMotionFlingController;
    final DifferentialMotionFlingTargetImpl mDifferentialMotionFlingTarget;
    public EdgeEffect mEdgeGlowBottom;
    public EdgeEffect mEdgeGlowTop;
    private boolean mFillViewport;
    private boolean mIsBeingDragged = false;
    private boolean mIsLaidOut = false;
    private boolean mIsLayoutDirty = true;
    private int mLastMotionY;
    private long mLastScroll;
    private int mLastScrollerY;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mNestedYOffset;
    private OnScrollChangeListener mOnScrollChangeListener;
    private final NestedScrollingParentHelper mParentHelper;
    private final float mPhysicalCoeff;
    private SavedState mSavedState;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;
    private OverScroller mScroller;
    private boolean mSmoothScrollingEnabled = true;
    private final Rect mTempRect = new Rect();
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private float mVerticalScrollFactor;

    static {
        DECELERATION_RATE = (float)(Math.log(0.78) / Math.log(0.9));
        ACCESSIBILITY_DELEGATE = new AccessibilityDelegate();
        SCROLLVIEW_STYLEABLE = new int[]{16843130};
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.nestedScrollViewStyle);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        this.mDifferentialMotionFlingTarget = new DifferentialMotionFlingTargetImpl(this);
        this.mDifferentialMotionFlingController = new DifferentialMotionFlingController(this.getContext(), this.mDifferentialMotionFlingTarget);
        this.mEdgeGlowTop = EdgeEffectCompat.create(context, attributeSet);
        this.mEdgeGlowBottom = EdgeEffectCompat.create(context, attributeSet);
        this.mPhysicalCoeff = 386.0878f * (context.getResources().getDisplayMetrics().density * 160.0f) * 0.84f;
        this.initScrollView();
        context = context.obtainStyledAttributes(attributeSet, SCROLLVIEW_STYLEABLE, n, 0);
        this.setFillViewport(context.getBoolean(0, false));
        context.recycle();
        this.mParentHelper = new NestedScrollingParentHelper((ViewGroup)this);
        this.mChildHelper = new NestedScrollingChildHelper((View)this);
        this.setNestedScrollingEnabled(true);
        ViewCompat.setAccessibilityDelegate((View)this, ACCESSIBILITY_DELEGATE);
    }

    private void abortAnimatedScroll() {
        this.mScroller.abortAnimation();
        this.stopNestedScroll(1);
    }

    private boolean canOverScroll() {
        boolean bl;
        block0: {
            int n = this.getOverScrollMode();
            bl = true;
            if (n == 0 || n == 1 && this.getScrollRange() > 0) break block0;
            bl = false;
        }
        return bl;
    }

    private boolean canScroll() {
        int n = this.getChildCount();
        boolean bl = false;
        if (n > 0) {
            View view = this.getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
            if (view.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > this.getHeight() - this.getPaddingTop() - this.getPaddingBottom()) {
                bl = true;
            }
            return bl;
        }
        return false;
    }

    private static int clamp(int n, int n2, int n3) {
        if (n2 < n3 && n >= 0) {
            if (n2 + n > n3) {
                return n3 - n2;
            }
            return n;
        }
        return 0;
    }

    private void doScrollY(int n) {
        if (n != 0) {
            if (this.mSmoothScrollingEnabled) {
                this.smoothScrollBy(0, n);
            } else {
                this.scrollBy(0, n);
            }
        }
    }

    private boolean edgeEffectFling(int n) {
        boolean bl = true;
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) != 0.0f) {
            if (this.shouldAbsorb(this.mEdgeGlowTop, n)) {
                this.mEdgeGlowTop.onAbsorb(n);
            } else {
                this.fling(-n);
            }
        } else if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) != 0.0f) {
            if (this.shouldAbsorb(this.mEdgeGlowBottom, -n)) {
                this.mEdgeGlowBottom.onAbsorb(-n);
            } else {
                this.fling(-n);
            }
        } else {
            bl = false;
        }
        return bl;
    }

    private void endTouchDrag() {
        this.mActivePointerId = -1;
        this.mIsBeingDragged = false;
        this.recycleVelocityTracker();
        this.stopNestedScroll(0);
        this.mEdgeGlowTop.onRelease();
        this.mEdgeGlowBottom.onRelease();
    }

    private View findFocusableViewInBounds(boolean bl, int n, int n2) {
        ArrayList arrayList = this.getFocusables(2);
        View view = null;
        boolean bl2 = false;
        int n3 = arrayList.size();
        for (int i = 0; i < n3; ++i) {
            View view2 = (View)arrayList.get(i);
            int n4 = view2.getTop();
            int n5 = view2.getBottom();
            View view3 = view;
            boolean bl3 = bl2;
            if (n < n5) {
                view3 = view;
                bl3 = bl2;
                if (n4 < n2) {
                    boolean bl4 = false;
                    boolean bl5 = n < n4 && n5 < n2;
                    if (view == null) {
                        view3 = view2;
                        bl3 = bl5;
                    } else {
                        if (bl && n4 < view.getTop() || !bl && n5 > view.getBottom()) {
                            bl4 = true;
                        }
                        if (bl2) {
                            view3 = view;
                            bl3 = bl2;
                            if (bl5) {
                                view3 = view;
                                bl3 = bl2;
                                if (bl4) {
                                    view3 = view2;
                                    bl3 = bl2;
                                }
                            }
                        } else if (bl5) {
                            view3 = view2;
                            bl3 = true;
                        } else {
                            view3 = view;
                            bl3 = bl2;
                            if (bl4) {
                                view3 = view2;
                                bl3 = bl2;
                            }
                        }
                    }
                }
            }
            view = view3;
            bl2 = bl3;
        }
        return view;
    }

    private float getSplineFlingDistance(int n) {
        double d = Math.log((float)Math.abs(n) * 0.35f / (this.mPhysicalCoeff * 0.015f));
        double d2 = DECELERATION_RATE;
        return (float)((double)(this.mPhysicalCoeff * 0.015f) * Math.exp((double)DECELERATION_RATE / (d2 - 1.0) * d));
    }

    private boolean inChild(int n, int n2) {
        int n3 = this.getChildCount();
        boolean bl = false;
        if (n3 > 0) {
            n3 = this.getScrollY();
            View view = this.getChildAt(0);
            if (n2 >= view.getTop() - n3 && n2 < view.getBottom() - n3 && n >= view.getLeft() && n < view.getRight()) {
                bl = true;
            }
            return bl;
        }
        return false;
    }

    private void initOrResetVelocityTracker() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
    }

    private void initScrollView() {
        this.mScroller = new OverScroller(this.getContext());
        this.setFocusable(true);
        this.setDescendantFocusability(262144);
        this.setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get((Context)this.getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void initializeTouchDrag(int n, int n2) {
        this.mLastMotionY = n;
        this.mActivePointerId = n2;
        this.startNestedScroll(2, 0);
    }

    private boolean isOffScreen(View view) {
        return this.isWithinDeltaOfScreen(view, 0, this.getHeight()) ^ true;
    }

    private static boolean isViewDescendantOf(View view, View view2) {
        boolean bl = true;
        if (view == view2) {
            return true;
        }
        if (!((view = view.getParent()) instanceof ViewGroup) || !NestedScrollView.isViewDescendantOf(view, view2)) {
            bl = false;
        }
        return bl;
    }

    private boolean isWithinDeltaOfScreen(View view, int n, int n2) {
        view.getDrawingRect(this.mTempRect);
        this.offsetDescendantRectToMyCoords(view, this.mTempRect);
        boolean bl = this.mTempRect.bottom + n >= this.getScrollY() && this.mTempRect.top - n <= this.getScrollY() + n2;
        return bl;
    }

    private void onNestedScrollInternal(int n, int n2, int[] nArray) {
        int n3 = this.getScrollY();
        this.scrollBy(0, n);
        n3 = this.getScrollY() - n3;
        if (nArray != null) {
            nArray[1] = nArray[1] + n3;
        }
        this.mChildHelper.dispatchNestedScroll(0, n3, 0, n - n3, null, n2, nArray);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int n = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(n) == this.mActivePointerId) {
            n = n == 0 ? 1 : 0;
            this.mLastMotionY = (int)motionEvent.getY(n);
            this.mActivePointerId = motionEvent.getPointerId(n);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
    }

    private void recycleVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private int releaseVerticalGlow(int n, float f) {
        float f2 = 0.0f;
        float f3 = f / (float)this.getWidth();
        float f4 = (float)n / (float)this.getHeight();
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) != 0.0f) {
            f = f2 = -EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, -f4, f3);
            if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) == 0.0f) {
                this.mEdgeGlowTop.onRelease();
                f = f2;
            }
        } else {
            f = f2;
            if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) != 0.0f) {
                f = f2 = EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, f4, 1.0f - f3);
                if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) == 0.0f) {
                    this.mEdgeGlowBottom.onRelease();
                    f = f2;
                }
            }
        }
        if ((n = Math.round((float)this.getHeight() * f)) != 0) {
            this.invalidate();
        }
        return n;
    }

    private void runAnimatedScroll(boolean bl) {
        if (bl) {
            this.startNestedScroll(2, 1);
        } else {
            this.stopNestedScroll(1);
        }
        this.mLastScrollerY = this.getScrollY();
        this.postInvalidateOnAnimation();
    }

    private boolean scrollAndFocus(int n, int n2, int n3) {
        View view;
        boolean bl = true;
        int n4 = this.getHeight();
        int n5 = this.getScrollY();
        n4 = n5 + n4;
        boolean bl2 = n == 33;
        Object object = view = this.findFocusableViewInBounds(bl2, n2, n3);
        if (view == null) {
            object = this;
        }
        if (n2 >= n5 && n3 <= n4) {
            bl2 = false;
        } else {
            n2 = bl2 ? (n2 -= n5) : n3 - n4;
            this.scrollBy(n2, 0, 1, true);
            bl2 = bl;
        }
        if (object != this.findFocus()) {
            object.requestFocus(n);
        }
        return bl2;
    }

    private int scrollBy(int n, int n2, int n3, boolean bl) {
        int n4;
        int n5;
        if (n3 == 1) {
            this.startNestedScroll(2, n3);
        }
        if (this.dispatchNestedPreScroll(0, n, this.mScrollConsumed, this.mScrollOffset, n3)) {
            n5 = this.mScrollConsumed[1];
            n4 = this.mScrollOffset[1];
            n5 = n - n5;
            n4 += 0;
        } else {
            n4 = 0;
            n5 = n;
        }
        int n6 = this.getScrollY();
        int n7 = this.getScrollRange();
        boolean bl2 = this.canOverScroll() && !bl;
        n = this.overScrollByCompat(0, n5, 0, n6, 0, n7, 0, 0, true) && !this.hasNestedScrollingParent(n3) ? 1 : 0;
        int n8 = this.getScrollY() - n6;
        this.mScrollConsumed[1] = 0;
        this.dispatchNestedScroll(0, n8, 0, n5 - n8, this.mScrollOffset, n3, this.mScrollConsumed);
        n8 = this.mScrollOffset[1];
        if ((n6 += (n5 -= this.mScrollConsumed[1])) < 0) {
            if (bl2) {
                EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, (float)(-n5) / (float)this.getHeight(), (float)n2 / (float)this.getWidth());
                if (!this.mEdgeGlowBottom.isFinished()) {
                    this.mEdgeGlowBottom.onRelease();
                }
            }
        } else if (n6 > n7 && bl2) {
            EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, (float)n5 / (float)this.getHeight(), 1.0f - (float)n2 / (float)this.getWidth());
            if (!this.mEdgeGlowTop.isFinished()) {
                this.mEdgeGlowTop.onRelease();
            }
        }
        if (!this.mEdgeGlowTop.isFinished() || !this.mEdgeGlowBottom.isFinished()) {
            this.postInvalidateOnAnimation();
            n = 0;
        }
        if (n != 0 && n3 == 0 && this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
        }
        if (n3 == 1) {
            this.stopNestedScroll(n3);
            this.mEdgeGlowTop.onRelease();
            this.mEdgeGlowBottom.onRelease();
        }
        return n4 + n8;
    }

    private void scrollToChild(View view) {
        view.getDrawingRect(this.mTempRect);
        this.offsetDescendantRectToMyCoords(view, this.mTempRect);
        int n = this.computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
        if (n != 0) {
            this.scrollBy(0, n);
        }
    }

    private boolean scrollToChildRect(Rect rect, boolean bl) {
        int n = this.computeScrollDeltaToGetChildRectOnScreen(rect);
        boolean bl2 = n != 0;
        if (bl2) {
            if (bl) {
                this.scrollBy(0, n);
            } else {
                this.smoothScrollBy(0, n);
            }
        }
        return bl2;
    }

    private boolean shouldAbsorb(EdgeEffect edgeEffect, int n) {
        boolean bl = true;
        if (n > 0) {
            return true;
        }
        float f = EdgeEffectCompat.getDistance(edgeEffect);
        float f2 = this.getHeight();
        if (!(this.getSplineFlingDistance(-n) < f * f2)) {
            bl = false;
        }
        return bl;
    }

    private void smoothScrollBy(int n, int n2, int n3, boolean bl) {
        if (this.getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 250L) {
            View view = this.getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
            int n4 = view.getHeight();
            int n5 = layoutParams.topMargin;
            int n6 = layoutParams.bottomMargin;
            int n7 = this.getHeight();
            int n8 = this.getPaddingTop();
            int n9 = this.getPaddingBottom();
            n = this.getScrollY();
            n2 = Math.max(0, Math.min(n + n2, Math.max(0, n4 + n5 + n6 - (n7 - n8 - n9))));
            this.mScroller.startScroll(this.getScrollX(), n, 0, n2 - n, n3);
            this.runAnimatedScroll(bl);
        } else {
            if (!this.mScroller.isFinished()) {
                this.abortAnimatedScroll();
            }
            this.scrollBy(n, n2);
        }
        this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
    }

    private boolean stopGlowAnimations(MotionEvent motionEvent) {
        boolean bl = false;
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) != 0.0f) {
            EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, 0.0f, motionEvent.getX() / (float)this.getWidth());
            bl = true;
        }
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) != 0.0f) {
            EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, 0.0f, 1.0f - motionEvent.getX() / (float)this.getWidth());
            bl = true;
        }
        return bl;
    }

    public void addView(View view) {
        if (this.getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, int n) {
        if (this.getChildCount() <= 0) {
            super.addView(view, n);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, int n, ViewGroup.LayoutParams layoutParams) {
        if (this.getChildCount() <= 0) {
            super.addView(view, n, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public boolean arrowScroll(int n) {
        View view;
        View view2 = view = this.findFocus();
        if (view == this) {
            view2 = null;
        }
        view = FocusFinder.getInstance().findNextFocus((ViewGroup)this, view2, n);
        int n2 = this.getMaxScrollAmount();
        if (view != null && this.isWithinDeltaOfScreen(view, n2, this.getHeight())) {
            view.getDrawingRect(this.mTempRect);
            this.offsetDescendantRectToMyCoords(view, this.mTempRect);
            this.scrollBy(this.computeScrollDeltaToGetChildRectOnScreen(this.mTempRect), 0, 1, true);
            view.requestFocus(n);
        } else {
            int n3;
            int n4 = n2;
            if (n == 33 && this.getScrollY() < n4) {
                n3 = this.getScrollY();
            } else {
                n3 = n4;
                if (n == 130) {
                    n3 = n4;
                    if (this.getChildCount() > 0) {
                        view = this.getChildAt(0);
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
                        n3 = Math.min(view.getBottom() + layoutParams.bottomMargin - (this.getScrollY() + this.getHeight() - this.getPaddingBottom()), n2);
                    }
                }
            }
            if (n3 == 0) {
                return false;
            }
            n = n == 130 ? n3 : -n3;
            this.scrollBy(n, 0, 1, true);
        }
        if (view2 != null && view2.isFocused() && this.isOffScreen(view2)) {
            n = this.getDescendantFocusability();
            this.setDescendantFocusability(131072);
            this.requestFocus();
            this.setDescendantFocusability(n);
        }
        return true;
    }

    @Override
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        block13: {
            int n;
            int n2;
            block15: {
                block14: {
                    if (this.mScroller.isFinished()) {
                        return;
                    }
                    this.mScroller.computeScrollOffset();
                    n2 = this.mScroller.getCurrY();
                    n = this.consumeFlingInVerticalStretch(n2 - this.mLastScrollerY);
                    this.mLastScrollerY = n2;
                    int[] nArray = this.mScrollConsumed;
                    int n3 = 0;
                    nArray[1] = 0;
                    this.dispatchNestedPreScroll(0, n, this.mScrollConsumed, null, 1);
                    n2 = n - this.mScrollConsumed[1];
                    int n4 = this.getScrollRange();
                    n = n2;
                    if (n2 != 0) {
                        n = this.getScrollY();
                        this.overScrollByCompat(0, n2, this.getScrollX(), n, 0, n4, 0, 0, false);
                        n = this.getScrollY() - n;
                        this.mScrollConsumed[1] = 0;
                        this.dispatchNestedScroll(0, n, 0, n2 -= n, this.mScrollOffset, 1, this.mScrollConsumed);
                        n = n2 - this.mScrollConsumed[1];
                    }
                    if (n == 0) break block13;
                    int n5 = this.getOverScrollMode();
                    if (n5 == 0) break block14;
                    n2 = n3;
                    if (n5 != 1) break block15;
                    n2 = n3;
                    if (n4 <= 0) break block15;
                }
                n2 = 1;
            }
            if (n2 != 0) {
                if (n < 0) {
                    if (this.mEdgeGlowTop.isFinished()) {
                        this.mEdgeGlowTop.onAbsorb((int)this.mScroller.getCurrVelocity());
                    }
                } else if (this.mEdgeGlowBottom.isFinished()) {
                    this.mEdgeGlowBottom.onAbsorb((int)this.mScroller.getCurrVelocity());
                }
            }
            this.abortAnimatedScroll();
        }
        if (!this.mScroller.isFinished()) {
            this.postInvalidateOnAnimation();
        } else {
            this.stopNestedScroll(1);
        }
    }

    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        if (this.getChildCount() == 0) {
            return 0;
        }
        int n = this.getHeight();
        int n2 = this.getScrollY();
        int n3 = n2 + n;
        int n4 = this.getVerticalFadingEdgeLength();
        int n5 = n2;
        if (rect.top > 0) {
            n5 = n2 + n4;
        }
        View view = this.getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        n2 = n3;
        if (rect.bottom < view.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin) {
            n2 = n3 - n4;
        }
        n4 = n2;
        int n6 = 0;
        if (rect.bottom > n4 && rect.top > n5) {
            n2 = rect.height() > n ? 0 + (rect.top - n5) : 0 + (rect.bottom - n4);
            n2 = Math.min(n2, view.getBottom() + layoutParams.bottomMargin - n3);
        } else {
            n2 = n6;
            if (rect.top < n5) {
                n2 = n6;
                if (rect.bottom < n4) {
                    n2 = rect.height() > n ? 0 - (n4 - rect.bottom) : 0 - (n5 - rect.top);
                    n2 = Math.max(n2, -this.getScrollY());
                }
            }
        }
        return n2;
    }

    @Override
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override
    public int computeVerticalScrollRange() {
        int n = this.getChildCount();
        int n2 = this.getHeight() - this.getPaddingBottom() - this.getPaddingTop();
        if (n == 0) {
            return n2;
        }
        View view = this.getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        n = view.getBottom() + layoutParams.bottomMargin;
        int n3 = this.getScrollY();
        int n4 = Math.max(0, n - n2);
        if (n3 < 0) {
            n2 = n - n3;
        } else {
            n2 = n;
            if (n3 > n4) {
                n2 = n + (n3 - n4);
            }
        }
        return n2;
    }

    int consumeFlingInVerticalStretch(int n) {
        int n2 = this.getHeight();
        if (n > 0 && EdgeEffectCompat.getDistance(this.mEdgeGlowTop) != 0.0f) {
            float f = (float)(-n) * 4.0f / (float)n2;
            if ((n2 = Math.round((float)(-n2) / 4.0f * EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, f, 0.5f))) != n) {
                this.mEdgeGlowTop.finish();
            }
            return n - n2;
        }
        if (n < 0 && EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) != 0.0f) {
            float f = (float)n * 4.0f / (float)n2;
            if ((n2 = Math.round((float)n2 / 4.0f * EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, f, 0.5f))) != n) {
                this.mEdgeGlowBottom.finish();
            }
            return n - n2;
        }
        return n;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean bl = super.dispatchKeyEvent(keyEvent) || this.executeKeyEvent(keyEvent);
        return bl;
    }

    @Override
    public boolean dispatchNestedFling(float f, float f2, boolean bl) {
        return this.mChildHelper.dispatchNestedFling(f, f2, bl);
    }

    @Override
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mChildHelper.dispatchNestedPreFling(f, f2);
    }

    @Override
    public boolean dispatchNestedPreScroll(int n, int n2, int[] nArray, int[] nArray2) {
        return this.dispatchNestedPreScroll(n, n2, nArray, nArray2, 0);
    }

    @Override
    public boolean dispatchNestedPreScroll(int n, int n2, int[] nArray, int[] nArray2, int n3) {
        return this.mChildHelper.dispatchNestedPreScroll(n, n2, nArray, nArray2, n3);
    }

    @Override
    public void dispatchNestedScroll(int n, int n2, int n3, int n4, int[] nArray, int n5, int[] nArray2) {
        this.mChildHelper.dispatchNestedScroll(n, n2, n3, n4, nArray, n5, nArray2);
    }

    @Override
    public boolean dispatchNestedScroll(int n, int n2, int n3, int n4, int[] nArray) {
        return this.mChildHelper.dispatchNestedScroll(n, n2, n3, n4, nArray);
    }

    @Override
    public boolean dispatchNestedScroll(int n, int n2, int n3, int n4, int[] nArray, int n5) {
        return this.mChildHelper.dispatchNestedScroll(n, n2, n3, n4, nArray, n5);
    }

    public void draw(Canvas canvas) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        super.draw(canvas);
        int n8 = this.getScrollY();
        if (!this.mEdgeGlowTop.isFinished()) {
            n7 = canvas.save();
            n6 = this.getWidth();
            n5 = this.getHeight();
            n4 = 0;
            n3 = Math.min(0, n8);
            n2 = n6;
            if (Api21Impl.getClipToPadding((ViewGroup)this)) {
                n2 = n6 - (this.getPaddingLeft() + this.getPaddingRight());
                n4 = 0 + this.getPaddingLeft();
            }
            n = n5;
            n6 = n3;
            if (Api21Impl.getClipToPadding((ViewGroup)this)) {
                n = n5 - (this.getPaddingTop() + this.getPaddingBottom());
                n6 = n3 + this.getPaddingTop();
            }
            canvas.translate((float)n4, (float)n6);
            this.mEdgeGlowTop.setSize(n2, n);
            if (this.mEdgeGlowTop.draw(canvas)) {
                this.postInvalidateOnAnimation();
            }
            canvas.restoreToCount(n7);
        }
        if (!this.mEdgeGlowBottom.isFinished()) {
            n7 = canvas.save();
            n6 = this.getWidth();
            n5 = this.getHeight();
            n4 = 0;
            n3 = Math.max(this.getScrollRange(), n8) + n5;
            n2 = n6;
            if (Api21Impl.getClipToPadding((ViewGroup)this)) {
                n2 = n6 - (this.getPaddingLeft() + this.getPaddingRight());
                n4 = 0 + this.getPaddingLeft();
            }
            n = n5;
            n6 = n3;
            if (Api21Impl.getClipToPadding((ViewGroup)this)) {
                n = n5 - (this.getPaddingTop() + this.getPaddingBottom());
                n6 = n3 - this.getPaddingBottom();
            }
            canvas.translate((float)(n4 - n2), (float)n6);
            canvas.rotate(180.0f, (float)n2, 0.0f);
            this.mEdgeGlowBottom.setSize(n2, n);
            if (this.mEdgeGlowBottom.draw(canvas)) {
                this.postInvalidateOnAnimation();
            }
            canvas.restoreToCount(n7);
        }
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        boolean bl;
        this.mTempRect.setEmpty();
        boolean bl2 = this.canScroll();
        int n = 130;
        if (!bl2) {
            boolean bl3 = this.isFocused();
            bl2 = false;
            if (bl3 && keyEvent.getKeyCode() != 4) {
                View view = this.findFocus();
                keyEvent = view;
                if (view == this) {
                    keyEvent = null;
                }
                if ((keyEvent = FocusFinder.getInstance().findNextFocus((ViewGroup)this, (View)keyEvent, 130)) != null && keyEvent != this && keyEvent.requestFocus(130)) {
                    bl2 = true;
                }
                return bl2;
            }
            return false;
        }
        bl2 = bl = false;
        if (keyEvent.getAction() == 0) {
            switch (keyEvent.getKeyCode()) {
                default: {
                    bl2 = bl;
                    break;
                }
                case 123: {
                    this.pageScroll(130);
                    bl2 = bl;
                    break;
                }
                case 122: {
                    this.pageScroll(33);
                    bl2 = bl;
                    break;
                }
                case 93: {
                    bl2 = this.fullScroll(130);
                    break;
                }
                case 92: {
                    bl2 = this.fullScroll(33);
                    break;
                }
                case 62: {
                    if (keyEvent.isShiftPressed()) {
                        n = 33;
                    }
                    this.pageScroll(n);
                    bl2 = bl;
                    break;
                }
                case 20: {
                    if (keyEvent.isAltPressed()) {
                        bl2 = this.fullScroll(130);
                        break;
                    }
                    bl2 = this.arrowScroll(130);
                    break;
                }
                case 19: {
                    bl2 = keyEvent.isAltPressed() ? this.fullScroll(33) : this.arrowScroll(33);
                }
            }
        }
        return bl2;
    }

    public void fling(int n) {
        if (this.getChildCount() > 0) {
            this.mScroller.fling(this.getScrollX(), this.getScrollY(), 0, n, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            this.runAnimatedScroll(true);
        }
    }

    public boolean fullScroll(int n) {
        int n2 = n == 130 ? 1 : 0;
        int n3 = this.getHeight();
        this.mTempRect.top = 0;
        this.mTempRect.bottom = n3;
        if (n2 != 0 && (n2 = this.getChildCount()) > 0) {
            View view = this.getChildAt(n2 - 1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
            this.mTempRect.bottom = view.getBottom() + layoutParams.bottomMargin + this.getPaddingBottom();
            this.mTempRect.top = this.mTempRect.bottom - n3;
        }
        return this.scrollAndFocus(n, this.mTempRect.top, this.mTempRect.bottom);
    }

    protected float getBottomFadingEdgeStrength() {
        if (this.getChildCount() == 0) {
            return 0.0f;
        }
        View view = this.getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        int n = this.getVerticalFadingEdgeLength();
        int n2 = this.getHeight();
        int n3 = this.getPaddingBottom();
        n2 = view.getBottom() + layoutParams.bottomMargin - this.getScrollY() - (n2 - n3);
        if (n2 < n) {
            return (float)n2 / (float)n;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int)((float)this.getHeight() * 0.5f);
    }

    @Override
    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    int getScrollRange() {
        int n = 0;
        if (this.getChildCount() > 0) {
            View view = this.getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
            n = Math.max(0, view.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin - (this.getHeight() - this.getPaddingTop() - this.getPaddingBottom()));
        }
        return n;
    }

    protected float getTopFadingEdgeStrength() {
        if (this.getChildCount() == 0) {
            return 0.0f;
        }
        int n = this.getVerticalFadingEdgeLength();
        int n2 = this.getScrollY();
        if (n2 < n) {
            return (float)n2 / (float)n;
        }
        return 1.0f;
    }

    float getVerticalScrollFactorCompat() {
        if (this.mVerticalScrollFactor == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = this.getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.mVerticalScrollFactor = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.mVerticalScrollFactor;
    }

    @Override
    public boolean hasNestedScrollingParent() {
        return this.hasNestedScrollingParent(0);
    }

    @Override
    public boolean hasNestedScrollingParent(int n) {
        return this.mChildHelper.hasNestedScrollingParent(n);
    }

    public boolean isFillViewport() {
        return this.mFillViewport;
    }

    @Override
    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    public boolean isSmoothScrollingEnabled() {
        return this.mSmoothScrollingEnabled;
    }

    protected void measureChild(View view, int n, int n2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(NestedScrollView.getChildMeasureSpec((int)n, (int)(this.getPaddingLeft() + this.getPaddingRight()), (int)layoutParams.width), View.MeasureSpec.makeMeasureSpec((int)0, (int)0));
    }

    protected void measureChildWithMargins(View view, int n, int n2, int n3, int n4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        view.measure(NestedScrollView.getChildMeasureSpec((int)n, (int)(this.getPaddingLeft() + this.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + n2), (int)marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec((int)(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin), (int)0));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsLaidOut = false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 8 && !this.mIsBeingDragged) {
            int n;
            int n2;
            float f;
            if (MotionEventCompat.isFromSource(motionEvent, 2)) {
                f = motionEvent.getAxisValue(9);
                n2 = (int)motionEvent.getX();
                n = 9;
            } else if (MotionEventCompat.isFromSource(motionEvent, 0x400000)) {
                f = motionEvent.getAxisValue(26);
                n2 = this.getWidth() / 2;
                n = 26;
            } else {
                f = 0.0f;
                n2 = 0;
                n = 0;
            }
            if (f != 0.0f) {
                int n3 = (int)(this.getVerticalScrollFactorCompat() * f);
                boolean bl = MotionEventCompat.isFromSource(motionEvent, 8194);
                this.scrollBy(-n3, n2, 1, bl);
                if (n != 0) {
                    this.mDifferentialMotionFlingController.onMotionEvent(motionEvent, n);
                }
                return true;
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int n = motionEvent.getAction();
        boolean bl = true;
        boolean bl2 = true;
        if (n == 2 && this.mIsBeingDragged) {
            return true;
        }
        switch (n & 0xFF) {
            default: {
                break;
            }
            case 6: {
                this.onSecondaryPointerUp(motionEvent);
                break;
            }
            case 2: {
                n = this.mActivePointerId;
                if (n == -1) break;
                int n2 = motionEvent.findPointerIndex(n);
                if (n2 == -1) {
                    Log.e((String)TAG, (String)("Invalid pointerId=" + n + " in onInterceptTouchEvent"));
                    break;
                }
                n = (int)motionEvent.getY(n2);
                if (Math.abs(n - this.mLastMotionY) <= this.mTouchSlop || (2 & this.getNestedScrollAxes()) != 0) break;
                this.mIsBeingDragged = true;
                this.mLastMotionY = n;
                this.initVelocityTrackerIfNotExists();
                this.mVelocityTracker.addMovement(motionEvent);
                this.mNestedYOffset = 0;
                motionEvent = this.getParent();
                if (motionEvent == null) break;
                motionEvent.requestDisallowInterceptTouchEvent(true);
                break;
            }
            case 1: 
            case 3: {
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                this.recycleVelocityTracker();
                if (this.mScroller.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
                    this.postInvalidateOnAnimation();
                }
                this.stopNestedScroll(0);
                break;
            }
            case 0: {
                n = (int)motionEvent.getY();
                if (!this.inChild((int)motionEvent.getX(), n)) {
                    boolean bl3 = bl2;
                    if (!this.stopGlowAnimations(motionEvent)) {
                        bl3 = !this.mScroller.isFinished() ? bl2 : false;
                    }
                    this.mIsBeingDragged = bl3;
                    this.recycleVelocityTracker();
                    break;
                }
                this.mLastMotionY = n;
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.initOrResetVelocityTracker();
                this.mVelocityTracker.addMovement(motionEvent);
                this.mScroller.computeScrollOffset();
                boolean bl4 = bl;
                if (!this.stopGlowAnimations(motionEvent)) {
                    bl4 = !this.mScroller.isFinished() ? bl : false;
                }
                this.mIsBeingDragged = bl4;
                this.startNestedScroll(2, 0);
            }
        }
        return this.mIsBeingDragged;
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        super.onLayout(bl, n, n2, n3, n4);
        this.mIsLayoutDirty = false;
        if (this.mChildToScrollTo != null && NestedScrollView.isViewDescendantOf(this.mChildToScrollTo, (View)this)) {
            this.scrollToChild(this.mChildToScrollTo);
        }
        this.mChildToScrollTo = null;
        if (!this.mIsLaidOut) {
            if (this.mSavedState != null) {
                this.scrollTo(this.getScrollX(), this.mSavedState.scrollPosition);
                this.mSavedState = null;
            }
            n = 0;
            if (this.getChildCount() > 0) {
                View view = this.getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
                n = view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int n5 = this.getPaddingTop();
            int n6 = this.getPaddingBottom();
            n3 = this.getScrollY();
            n = NestedScrollView.clamp(n3, n4 - n2 - n5 - n6, n);
            if (n != n3) {
                this.scrollTo(this.getScrollX(), n);
            }
        }
        this.scrollTo(this.getScrollX(), this.getScrollY());
        this.mIsLaidOut = true;
    }

    protected void onMeasure(int n, int n2) {
        super.onMeasure(n, n2);
        if (!this.mFillViewport) {
            return;
        }
        if (View.MeasureSpec.getMode((int)n2) == 0) {
            return;
        }
        if (this.getChildCount() > 0) {
            View view = this.getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
            int n3 = view.getMeasuredHeight();
            if (n3 < (n2 = this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom() - layoutParams.topMargin - layoutParams.bottomMargin)) {
                n = NestedScrollView.getChildMeasureSpec((int)n, (int)(this.getPaddingLeft() + this.getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin), (int)layoutParams.width);
                view.measure(n, View.MeasureSpec.makeMeasureSpec((int)n2, (int)0x40000000));
            }
        }
    }

    @Override
    public boolean onNestedFling(View view, float f, float f2, boolean bl) {
        if (!bl) {
            this.dispatchNestedFling(0.0f, f2, true);
            this.fling((int)f2);
            return true;
        }
        return false;
    }

    @Override
    public boolean onNestedPreFling(View view, float f, float f2) {
        return this.dispatchNestedPreFling(f, f2);
    }

    @Override
    public void onNestedPreScroll(View view, int n, int n2, int[] nArray) {
        this.onNestedPreScroll(view, n, n2, nArray, 0);
    }

    @Override
    public void onNestedPreScroll(View view, int n, int n2, int[] nArray, int n3) {
        this.dispatchNestedPreScroll(n, n2, nArray, null, n3);
    }

    @Override
    public void onNestedScroll(View view, int n, int n2, int n3, int n4) {
        this.onNestedScrollInternal(n4, 0, null);
    }

    @Override
    public void onNestedScroll(View view, int n, int n2, int n3, int n4, int n5) {
        this.onNestedScrollInternal(n4, n5, null);
    }

    @Override
    public void onNestedScroll(View view, int n, int n2, int n3, int n4, int n5, int[] nArray) {
        this.onNestedScrollInternal(n4, n5, nArray);
    }

    @Override
    public void onNestedScrollAccepted(View view, View view2, int n) {
        this.onNestedScrollAccepted(view, view2, n, 0);
    }

    @Override
    public void onNestedScrollAccepted(View view, View view2, int n, int n2) {
        this.mParentHelper.onNestedScrollAccepted(view, view2, n, n2);
        this.startNestedScroll(2, n2);
    }

    protected void onOverScrolled(int n, int n2, boolean bl, boolean bl2) {
        super.scrollTo(n, n2);
    }

    protected boolean onRequestFocusInDescendants(int n, Rect rect) {
        int n2;
        if (n == 2) {
            n2 = 130;
        } else {
            n2 = n;
            if (n == 1) {
                n2 = 33;
            }
        }
        View view = rect == null ? FocusFinder.getInstance().findNextFocus((ViewGroup)this, null, n2) : FocusFinder.getInstance().findNextFocusFromRect((ViewGroup)this, rect, n2);
        if (view == null) {
            return false;
        }
        if (this.isOffScreen(view)) {
            return false;
        }
        return view.requestFocus(n2, rect);
    }

    protected void onRestoreInstanceState(Parcelable object) {
        if (!(object instanceof SavedState)) {
            super.onRestoreInstanceState(object);
            return;
        }
        object = (SavedState)((Object)object);
        super.onRestoreInstanceState(object.getSuperState());
        this.mSavedState = object;
        this.requestLayout();
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.scrollPosition = this.getScrollY();
        return savedState;
    }

    protected void onScrollChanged(int n, int n2, int n3, int n4) {
        super.onScrollChanged(n, n2, n3, n4);
        if (this.mOnScrollChangeListener != null) {
            this.mOnScrollChangeListener.onScrollChange(this, n, n2, n3, n4);
        }
    }

    protected void onSizeChanged(int n, int n2, int n3, int n4) {
        super.onSizeChanged(n, n2, n3, n4);
        View view = this.findFocus();
        if (view != null && this != view) {
            if (this.isWithinDeltaOfScreen(view, 0, n4)) {
                view.getDrawingRect(this.mTempRect);
                this.offsetDescendantRectToMyCoords(view, this.mTempRect);
                this.doScrollY(this.computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
            }
            return;
        }
    }

    @Override
    public boolean onStartNestedScroll(View view, View view2, int n) {
        return this.onStartNestedScroll(view, view2, n, 0);
    }

    @Override
    public boolean onStartNestedScroll(View view, View view2, int n, int n2) {
        boolean bl = (n & 2) != 0;
        return bl;
    }

    @Override
    public void onStopNestedScroll(View view) {
        this.onStopNestedScroll(view, 0);
    }

    @Override
    public void onStopNestedScroll(View view, int n) {
        this.mParentHelper.onStopNestedScroll(view, n);
        this.stopNestedScroll(n);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.initVelocityTrackerIfNotExists();
        int n = motionEvent.getActionMasked();
        if (n == 0) {
            this.mNestedYOffset = 0;
        }
        MotionEvent motionEvent2 = MotionEvent.obtain((MotionEvent)motionEvent);
        motionEvent2.offsetLocation(0.0f, (float)this.mNestedYOffset);
        switch (n) {
            default: {
                break;
            }
            case 6: {
                this.onSecondaryPointerUp(motionEvent);
                this.mLastMotionY = (int)motionEvent.getY(motionEvent.findPointerIndex(this.mActivePointerId));
                break;
            }
            case 5: {
                n = motionEvent.getActionIndex();
                this.mLastMotionY = (int)motionEvent.getY(n);
                this.mActivePointerId = motionEvent.getPointerId(n);
                break;
            }
            case 3: {
                if (this.mIsBeingDragged && this.getChildCount() > 0 && this.mScroller.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
                    this.postInvalidateOnAnimation();
                }
                this.endTouchDrag();
                break;
            }
            case 2: {
                int n2;
                int n3 = motionEvent.findPointerIndex(this.mActivePointerId);
                if (n3 == -1) {
                    Log.e((String)TAG, (String)("Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent"));
                    break;
                }
                int n4 = (int)motionEvent.getY(n3);
                n = this.mLastMotionY - n4;
                n = n2 = n - this.releaseVerticalGlow(n, motionEvent.getX(n3));
                if (!this.mIsBeingDragged) {
                    n = n2;
                    if (Math.abs(n2) > this.mTouchSlop) {
                        ViewParent viewParent = this.getParent();
                        if (viewParent != null) {
                            viewParent.requestDisallowInterceptTouchEvent(true);
                        }
                        this.mIsBeingDragged = true;
                        n = n2 > 0 ? n2 - this.mTouchSlop : n2 + this.mTouchSlop;
                    }
                }
                if (!this.mIsBeingDragged) break;
                n = this.scrollBy(n, (int)motionEvent.getX(n3), 0, false);
                this.mLastMotionY = n4 - n;
                this.mNestedYOffset += n;
                break;
            }
            case 1: {
                motionEvent = this.mVelocityTracker;
                motionEvent.computeCurrentVelocity(1000, (float)this.mMaximumVelocity);
                n = (int)motionEvent.getYVelocity(this.mActivePointerId);
                if (Math.abs(n) >= this.mMinimumVelocity) {
                    if (!this.edgeEffectFling(n) && !this.dispatchNestedPreFling(0.0f, -n)) {
                        this.dispatchNestedFling(0.0f, -n, true);
                        this.fling(-n);
                    }
                } else if (this.mScroller.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
                    this.postInvalidateOnAnimation();
                }
                this.endTouchDrag();
                break;
            }
            case 0: {
                ViewParent viewParent;
                if (this.getChildCount() == 0) {
                    return false;
                }
                if (this.mIsBeingDragged && (viewParent = this.getParent()) != null) {
                    viewParent.requestDisallowInterceptTouchEvent(true);
                }
                if (!this.mScroller.isFinished()) {
                    this.abortAnimatedScroll();
                }
                this.initializeTouchDrag((int)motionEvent.getY(), motionEvent.getPointerId(0));
            }
        }
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.addMovement(motionEvent2);
        }
        motionEvent2.recycle();
        return true;
    }

    boolean overScrollByCompat(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, boolean bl) {
        boolean bl2;
        int n9 = this.getOverScrollMode();
        boolean bl3 = this.computeHorizontalScrollRange() > this.computeHorizontalScrollExtent();
        boolean bl4 = this.computeVerticalScrollRange() > this.computeVerticalScrollExtent();
        bl3 = n9 == 0 || n9 == 1 && bl3;
        bl4 = n9 == 0 || n9 == 1 && bl4;
        n3 += n;
        n = !bl3 ? 0 : n7;
        n4 += n2;
        n2 = !bl4 ? 0 : n8;
        n7 = -n;
        n += n5;
        n5 = -n2;
        n2 += n6;
        if (n3 > n) {
            bl = true;
        } else if (n3 < n7) {
            n = n7;
            bl = true;
        } else {
            bl = false;
            n = n3;
        }
        if (n4 > n2) {
            bl2 = true;
        } else if (n4 < n5) {
            n2 = n5;
            bl2 = true;
        } else {
            bl2 = false;
            n2 = n4;
        }
        if (bl2 && !this.hasNestedScrollingParent(1)) {
            this.mScroller.springBack(n, n2, 0, 0, 0, this.getScrollRange());
        }
        this.onOverScrolled(n, n2, bl, bl2);
        bl = bl || bl2;
        return bl;
    }

    public boolean pageScroll(int n) {
        int n2 = n == 130 ? 1 : 0;
        int n3 = this.getHeight();
        if (n2 != 0) {
            this.mTempRect.top = this.getScrollY() + n3;
            n2 = this.getChildCount();
            if (n2 > 0) {
                View view = this.getChildAt(n2 - 1);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
                n2 = view.getBottom() + layoutParams.bottomMargin + this.getPaddingBottom();
                if (this.mTempRect.top + n3 > n2) {
                    this.mTempRect.top = n2 - n3;
                }
            }
        } else {
            this.mTempRect.top = this.getScrollY() - n3;
            if (this.mTempRect.top < 0) {
                this.mTempRect.top = 0;
            }
        }
        this.mTempRect.bottom = this.mTempRect.top + n3;
        return this.scrollAndFocus(n, this.mTempRect.top, this.mTempRect.bottom);
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.mIsLayoutDirty) {
            this.scrollToChild(view2);
        } else {
            this.mChildToScrollTo = view2;
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean bl) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return this.scrollToChildRect(rect, bl);
    }

    public void requestDisallowInterceptTouchEvent(boolean bl) {
        if (bl) {
            this.recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(bl);
    }

    public void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }

    public void scrollTo(int n, int n2) {
        if (this.getChildCount() > 0) {
            View view = this.getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
            int n3 = this.getWidth();
            int n4 = this.getPaddingLeft();
            int n5 = this.getPaddingRight();
            int n6 = view.getWidth();
            int n7 = layoutParams.leftMargin;
            int n8 = layoutParams.rightMargin;
            int n9 = this.getHeight();
            int n10 = this.getPaddingTop();
            int n11 = this.getPaddingBottom();
            int n12 = view.getHeight();
            int n13 = layoutParams.topMargin;
            int n14 = layoutParams.bottomMargin;
            n = NestedScrollView.clamp(n, n3 - n4 - n5, n6 + n7 + n8);
            n2 = NestedScrollView.clamp(n2, n9 - n10 - n11, n12 + n13 + n14);
            if (n != this.getScrollX() || n2 != this.getScrollY()) {
                super.scrollTo(n, n2);
            }
        }
    }

    public void setFillViewport(boolean bl) {
        if (bl != this.mFillViewport) {
            this.mFillViewport = bl;
            this.requestLayout();
        }
    }

    @Override
    public void setNestedScrollingEnabled(boolean bl) {
        this.mChildHelper.setNestedScrollingEnabled(bl);
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.mOnScrollChangeListener = onScrollChangeListener;
    }

    public void setSmoothScrollingEnabled(boolean bl) {
        this.mSmoothScrollingEnabled = bl;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public final void smoothScrollBy(int n, int n2) {
        this.smoothScrollBy(n, n2, 250, false);
    }

    public final void smoothScrollBy(int n, int n2, int n3) {
        this.smoothScrollBy(n, n2, n3, false);
    }

    public final void smoothScrollTo(int n, int n2) {
        this.smoothScrollTo(n, n2, 250, false);
    }

    public final void smoothScrollTo(int n, int n2, int n3) {
        this.smoothScrollTo(n, n2, n3, false);
    }

    void smoothScrollTo(int n, int n2, int n3, boolean bl) {
        this.smoothScrollBy(n - this.getScrollX(), n2 - this.getScrollY(), n3, bl);
    }

    void smoothScrollTo(int n, int n2, boolean bl) {
        this.smoothScrollTo(n, n2, 250, bl);
    }

    @Override
    public boolean startNestedScroll(int n) {
        return this.startNestedScroll(n, 0);
    }

    @Override
    public boolean startNestedScroll(int n, int n2) {
        return this.mChildHelper.startNestedScroll(n, n2);
    }

    @Override
    public void stopNestedScroll() {
        this.stopNestedScroll(0);
    }

    @Override
    public void stopNestedScroll(int n) {
        this.mChildHelper.stopNestedScroll(n);
    }

    static class AccessibilityDelegate
    extends AccessibilityDelegateCompat {
        AccessibilityDelegate() {
        }

        @Override
        public void onInitializeAccessibilityEvent(View object, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent((View)object, accessibilityEvent);
            object = (NestedScrollView)object;
            accessibilityEvent.setClassName((CharSequence)ScrollView.class.getName());
            boolean bl = ((NestedScrollView)object).getScrollRange() > 0;
            accessibilityEvent.setScrollable(bl);
            accessibilityEvent.setScrollX(object.getScrollX());
            accessibilityEvent.setScrollY(object.getScrollY());
            AccessibilityRecordCompat.setMaxScrollX((AccessibilityRecord)accessibilityEvent, object.getScrollX());
            AccessibilityRecordCompat.setMaxScrollY((AccessibilityRecord)accessibilityEvent, ((NestedScrollView)object).getScrollRange());
        }

        @Override
        public void onInitializeAccessibilityNodeInfo(View object, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int n;
            super.onInitializeAccessibilityNodeInfo((View)object, accessibilityNodeInfoCompat);
            object = (NestedScrollView)object;
            accessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
            if (object.isEnabled() && (n = ((NestedScrollView)object).getScrollRange()) > 0) {
                accessibilityNodeInfoCompat.setScrollable(true);
                if (object.getScrollY() > 0) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                }
                if (object.getScrollY() < n) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                }
            }
        }

        @Override
        public boolean performAccessibilityAction(View view, int n, Bundle object) {
            if (super.performAccessibilityAction(view, n, (Bundle)object)) {
                return true;
            }
            object = (NestedScrollView)view;
            if (!object.isEnabled()) {
                return false;
            }
            int n2 = object.getHeight();
            view = new Rect();
            int n3 = n2;
            if (object.getMatrix().isIdentity()) {
                n3 = n2;
                if (object.getGlobalVisibleRect((Rect)view)) {
                    n3 = view.height();
                }
            }
            switch (n) {
                default: {
                    return false;
                }
                case 8192: 
                case 16908344: {
                    n = object.getPaddingBottom();
                    n2 = object.getPaddingTop();
                    n = Math.max(object.getScrollY() - (n3 - n - n2), 0);
                    if (n != object.getScrollY()) {
                        ((NestedScrollView)object).smoothScrollTo(0, n, true);
                        return true;
                    }
                    return false;
                }
                case 4096: 
                case 16908346: 
            }
            n = object.getPaddingBottom();
            n2 = object.getPaddingTop();
            n = Math.min(object.getScrollY() + (n3 - n - n2), ((NestedScrollView)object).getScrollRange());
            if (n != object.getScrollY()) {
                ((NestedScrollView)object).smoothScrollTo(0, n, true);
                return true;
            }
            return false;
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static boolean getClipToPadding(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    class DifferentialMotionFlingTargetImpl
    implements DifferentialMotionFlingTarget {
        final NestedScrollView this$0;

        DifferentialMotionFlingTargetImpl(NestedScrollView nestedScrollView) {
            this.this$0 = nestedScrollView;
        }

        @Override
        public float getScaledScrollFactor() {
            return -this.this$0.getVerticalScrollFactorCompat();
        }

        @Override
        public boolean startDifferentialMotionFling(float f) {
            if (f == 0.0f) {
                return false;
            }
            this.stopDifferentialMotionFling();
            this.this$0.fling((int)f);
            return true;
        }

        @Override
        public void stopDifferentialMotionFling() {
            this.this$0.mScroller.abortAnimation();
        }
    }

    public static interface OnScrollChangeListener {
        public void onScrollChange(NestedScrollView var1, int var2, int var3, int var4, int var5);
    }

    static class SavedState
    extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>(){

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int n) {
                return new SavedState[n];
            }
        };
        public int scrollPosition;

        SavedState(Parcel parcel) {
            super(parcel);
            this.scrollPosition = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode((Object)this)) + " scrollPosition=" + this.scrollPosition + "}";
        }

        public void writeToParcel(Parcel parcel, int n) {
            super.writeToParcel(parcel, n);
            parcel.writeInt(this.scrollPosition);
        }
    }
}

