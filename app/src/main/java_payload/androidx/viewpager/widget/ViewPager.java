/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources$NotFoundException
 *  android.database.DataSetObserver
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$ClassLoaderCreator
 *  android.os.Parcelable$Creator
 *  android.os.SystemClock
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.FocusFinder
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 *  android.view.SoundEffectConstants
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.animation.Interpolator
 *  android.widget.EdgeEffect
 *  android.widget.Scroller
 */
package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.viewpager.widget.PagerAdapter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager
extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator<ItemInfo> COMPARATOR;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    static final int[] LAYOUT_ATTRS;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private static final Interpolator sInterpolator;
    private static final ViewPositionComparator sPositionComparator;
    private int mActivePointerId = -1;
    PagerAdapter mAdapter;
    private List<OnAdapterChangeListener> mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout = true;
    private float mFirstOffset = -3.4028235E38f;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<ItemInfo> mItems = new ArrayList();
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private EdgeEffect mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets = false;
    private PagerObserver mObserver;
    private int mOffscreenPageLimit = 1;
    private OnPageChangeListener mOnPageChangeListener;
    private List<OnPageChangeListener> mOnPageChangeListeners;
    private int mPageMargin;
    private PageTransformer mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState = null;
    private ClassLoader mRestoredClassLoader = null;
    private int mRestoredCurItem = -1;
    private EdgeEffect mRightEdge;
    private int mScrollState = 0;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final ItemInfo mTempItem = new ItemInfo();
    private final Rect mTempRect = new Rect();
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    static {
        LAYOUT_ATTRS = new int[]{16842931};
        COMPARATOR = new Comparator<ItemInfo>(){

            @Override
            public int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
                return itemInfo.position - itemInfo2.position;
            }
        };
        sInterpolator = new Interpolator(){

            public float getInterpolation(float f) {
                return (f -= 1.0f) * f * f * f * f + 1.0f;
            }
        };
        sPositionComparator = new ViewPositionComparator();
    }

    public ViewPager(Context context) {
        super(context);
        this.mLastOffset = Float.MAX_VALUE;
        this.mEndScrollRunnable = new Runnable(this){
            final ViewPager this$0;
            {
                this.this$0 = viewPager;
            }

            @Override
            public void run() {
                this.this$0.setScrollState(0);
                this.this$0.populate();
            }
        };
        this.initViewPager();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastOffset = Float.MAX_VALUE;
        this.mEndScrollRunnable = new /* invalid duplicate definition of identical inner class */;
        this.initViewPager();
    }

    private void calculatePageOffsets(ItemInfo itemInfo, int n, ItemInfo itemInfo2) {
        int n2;
        float f;
        float f2;
        int n3;
        int n4 = this.mAdapter.getCount();
        int n5 = this.getClientWidth();
        float f3 = n5 > 0 ? (float)this.mPageMargin / (float)n5 : 0.0f;
        if (itemInfo2 != null) {
            n5 = itemInfo2.position;
            if (n5 < itemInfo.position) {
                n3 = 0;
                f2 = itemInfo2.offset + itemInfo2.widthFactor + f3;
                ++n5;
                while (n5 <= itemInfo.position && n3 < this.mItems.size()) {
                    itemInfo2 = this.mItems.get(n3);
                    while (true) {
                        f = f2;
                        n2 = n5;
                        if (n5 <= itemInfo2.position) break;
                        f = f2;
                        n2 = n5;
                        if (n3 >= this.mItems.size() - 1) break;
                        itemInfo2 = this.mItems.get(++n3);
                    }
                    while (n2 < itemInfo2.position) {
                        f += this.mAdapter.getPageWidth(n2) + f3;
                        ++n2;
                    }
                    itemInfo2.offset = f;
                    f2 = f + (itemInfo2.widthFactor + f3);
                    n5 = n2 + 1;
                }
            } else if (n5 > itemInfo.position) {
                n3 = this.mItems.size() - 1;
                f2 = itemInfo2.offset;
                --n5;
                while (n5 >= itemInfo.position && n3 >= 0) {
                    itemInfo2 = this.mItems.get(n3);
                    while (true) {
                        f = f2;
                        n2 = n5;
                        if (n5 >= itemInfo2.position) break;
                        f = f2;
                        n2 = n5;
                        if (n3 <= 0) break;
                        itemInfo2 = this.mItems.get(--n3);
                    }
                    while (n2 > itemInfo2.position) {
                        f -= this.mAdapter.getPageWidth(n2) + f3;
                        --n2;
                    }
                    itemInfo2.offset = f2 = f - (itemInfo2.widthFactor + f3);
                    n5 = n2 - 1;
                }
            }
        }
        n2 = this.mItems.size();
        f = itemInfo.offset;
        n5 = itemInfo.position - 1;
        f2 = itemInfo.position == 0 ? itemInfo.offset : -3.4028235E38f;
        this.mFirstOffset = f2;
        f2 = itemInfo.position == n4 - 1 ? itemInfo.offset + itemInfo.widthFactor - 1.0f : Float.MAX_VALUE;
        this.mLastOffset = f2;
        n3 = n - 1;
        f2 = f;
        while (n3 >= 0) {
            itemInfo2 = this.mItems.get(n3);
            while (n5 > itemInfo2.position) {
                f2 -= this.mAdapter.getPageWidth(n5) + f3;
                --n5;
            }
            itemInfo2.offset = f2 -= itemInfo2.widthFactor + f3;
            if (itemInfo2.position == 0) {
                this.mFirstOffset = f2;
            }
            --n3;
            --n5;
        }
        f2 = itemInfo.offset + itemInfo.widthFactor + f3;
        n3 = itemInfo.position + 1;
        n5 = n + 1;
        n = n3;
        while (n5 < n2) {
            itemInfo = this.mItems.get(n5);
            while (n < itemInfo.position) {
                f2 += this.mAdapter.getPageWidth(n) + f3;
                ++n;
            }
            if (itemInfo.position == n4 - 1) {
                this.mLastOffset = itemInfo.widthFactor + f2 - 1.0f;
            }
            itemInfo.offset = f2;
            f2 += itemInfo.widthFactor + f3;
            ++n5;
            ++n;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    private void completeScroll(boolean bl) {
        int n;
        boolean bl2 = this.mScrollState == 2;
        if (bl2) {
            this.setScrollingCacheEnabled(false);
            if (this.mScroller.isFinished() ^ true) {
                this.mScroller.abortAnimation();
                int n2 = this.getScrollX();
                n = this.getScrollY();
                int n3 = this.mScroller.getCurrX();
                int n4 = this.mScroller.getCurrY();
                if (n2 != n3 || n != n4) {
                    this.scrollTo(n3, n4);
                    if (n3 != n2) {
                        this.pageScrolled(n3);
                    }
                }
            }
        }
        this.mPopulatePending = false;
        for (n = 0; n < this.mItems.size(); ++n) {
            ItemInfo itemInfo = this.mItems.get(n);
            if (!itemInfo.scrolling) continue;
            bl2 = true;
            itemInfo.scrolling = false;
        }
        if (bl2) {
            if (bl) {
                ViewCompat.postOnAnimation((View)this, this.mEndScrollRunnable);
            } else {
                this.mEndScrollRunnable.run();
            }
        }
    }

    private int determineTargetPage(int n, float f, int n2, int n3) {
        if (Math.abs(n3) > this.mFlingDistance && Math.abs(n2) > this.mMinimumVelocity) {
            if (n2 <= 0) {
                ++n;
            }
        } else {
            float f2 = n >= this.mCurItem ? 0.4f : 0.6f;
            n = (int)(f + f2) + n;
        }
        n2 = n;
        if (this.mItems.size() > 0) {
            ItemInfo itemInfo = this.mItems.get(0);
            ItemInfo itemInfo2 = this.mItems.get(this.mItems.size() - 1);
            n2 = Math.max(itemInfo.position, Math.min(n, itemInfo2.position));
        }
        return n2;
    }

    private void dispatchOnPageScrolled(int n, float f, int n2) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(n, f, n2);
        }
        if (this.mOnPageChangeListeners != null) {
            int n3 = this.mOnPageChangeListeners.size();
            for (int i = 0; i < n3; ++i) {
                OnPageChangeListener onPageChangeListener = this.mOnPageChangeListeners.get(i);
                if (onPageChangeListener == null) continue;
                onPageChangeListener.onPageScrolled(n, f, n2);
            }
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageScrolled(n, f, n2);
        }
    }

    private void dispatchOnPageSelected(int n) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(n);
        }
        if (this.mOnPageChangeListeners != null) {
            int n2 = this.mOnPageChangeListeners.size();
            for (int i = 0; i < n2; ++i) {
                OnPageChangeListener onPageChangeListener = this.mOnPageChangeListeners.get(i);
                if (onPageChangeListener == null) continue;
                onPageChangeListener.onPageSelected(n);
            }
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageSelected(n);
        }
    }

    private void dispatchOnScrollStateChanged(int n) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrollStateChanged(n);
        }
        if (this.mOnPageChangeListeners != null) {
            int n2 = this.mOnPageChangeListeners.size();
            for (int i = 0; i < n2; ++i) {
                OnPageChangeListener onPageChangeListener = this.mOnPageChangeListeners.get(i);
                if (onPageChangeListener == null) continue;
                onPageChangeListener.onPageScrollStateChanged(n);
            }
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageScrollStateChanged(n);
        }
    }

    private void enableLayers(boolean bl) {
        int n = this.getChildCount();
        for (int i = 0; i < n; ++i) {
            int n2 = bl ? this.mPageTransformerLayerType : 0;
            this.getChildAt(i).setLayerType(n2, null);
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        Rect rect2 = rect;
        if (rect == null) {
            rect2 = new Rect();
        }
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        for (rect = view.getParent(); rect instanceof ViewGroup && rect != this; rect = rect.getParent()) {
            rect = (ViewGroup)rect;
            rect2.left += rect.getLeft();
            rect2.right += rect.getRight();
            rect2.top += rect.getTop();
            rect2.bottom += rect.getBottom();
        }
        return rect2;
    }

    private int getClientWidth() {
        return this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight();
    }

    private ItemInfo infoForCurrentScrollPosition() {
        int n = this.getClientWidth();
        float f = 0.0f;
        float f2 = n > 0 ? (float)this.getScrollX() / (float)n : 0.0f;
        if (n > 0) {
            f = (float)this.mPageMargin / (float)n;
        }
        int n2 = -1;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean bl = true;
        ItemInfo itemInfo = null;
        n = 0;
        while (n < this.mItems.size()) {
            ItemInfo itemInfo2 = this.mItems.get(n);
            int n3 = n;
            ItemInfo itemInfo3 = itemInfo2;
            if (!bl) {
                n3 = n;
                itemInfo3 = itemInfo2;
                if (itemInfo2.position != n2 + 1) {
                    itemInfo3 = this.mTempItem;
                    itemInfo3.offset = f3 + f4 + f;
                    itemInfo3.position = n2 + 1;
                    itemInfo3.widthFactor = this.mAdapter.getPageWidth(itemInfo3.position);
                    n3 = n - 1;
                }
            }
            f3 = itemInfo3.offset;
            f4 = itemInfo3.widthFactor;
            if (!bl && !(f2 >= f3)) {
                return itemInfo;
            }
            if (!(f2 < f4 + f3 + f) && n3 != this.mItems.size() - 1) {
                bl = false;
                n2 = itemInfo3.position;
                f4 = itemInfo3.widthFactor;
                n = n3 + 1;
                itemInfo = itemInfo3;
                continue;
            }
            return itemInfo3;
        }
        return itemInfo;
    }

    private static boolean isDecorView(View view) {
        boolean bl = view.getClass().getAnnotation(DecorView.class) != null;
        return bl;
    }

    private boolean isGutterDrag(float f, float f2) {
        boolean bl = f < (float)this.mGutterSize && f2 > 0.0f || f > (float)(this.getWidth() - this.mGutterSize) && f2 < 0.0f;
        return bl;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int n = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(n) == this.mActivePointerId) {
            n = n == 0 ? 1 : 0;
            this.mLastMotionX = motionEvent.getX(n);
            this.mActivePointerId = motionEvent.getPointerId(n);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
    }

    private boolean pageScrolled(int n) {
        if (this.mItems.size() == 0) {
            if (this.mFirstLayout) {
                return false;
            }
            this.mCalledSuper = false;
            this.onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        ItemInfo itemInfo = this.infoForCurrentScrollPosition();
        int n2 = this.getClientWidth();
        int n3 = this.mPageMargin;
        float f = (float)this.mPageMargin / (float)n2;
        int n4 = itemInfo.position;
        f = ((float)n / (float)n2 - itemInfo.offset) / (itemInfo.widthFactor + f);
        n = (int)((float)(n3 + n2) * f);
        this.mCalledSuper = false;
        this.onPageScrolled(n4, f, n);
        if (this.mCalledSuper) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean performDrag(float f) {
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        float f2 = this.mLastMotionX;
        this.mLastMotionX = f;
        float f3 = (float)this.getScrollX() + (f2 - f);
        int n = this.getClientWidth();
        f = (float)n * this.mFirstOffset;
        f2 = (float)n * this.mLastOffset;
        boolean bl4 = true;
        boolean bl5 = true;
        ItemInfo itemInfo = this.mItems.get(0);
        ItemInfo itemInfo2 = this.mItems.get(this.mItems.size() - 1);
        if (itemInfo.position != 0) {
            bl4 = false;
            f = itemInfo.offset * (float)n;
        }
        if (itemInfo2.position != this.mAdapter.getCount() - 1) {
            bl5 = false;
            f2 = itemInfo2.offset * (float)n;
        }
        if (f3 < f) {
            bl2 = bl3;
            if (bl4) {
                this.mLeftEdge.onPull(Math.abs(f - f3) / (float)n);
                bl2 = true;
            }
        } else {
            f = f3;
            if (f3 > f2) {
                bl2 = bl;
                if (bl5) {
                    this.mRightEdge.onPull(Math.abs(f3 - f2) / (float)n);
                    bl2 = true;
                }
                f = f2;
            }
        }
        this.mLastMotionX += f - (float)((int)f);
        this.scrollTo((int)f, this.getScrollY());
        this.pageScrolled((int)f);
        return bl2;
    }

    private void recomputeScrollPosition(int n, int n2, int n3, int n4) {
        if (n2 > 0 && !this.mItems.isEmpty()) {
            if (!this.mScroller.isFinished()) {
                this.mScroller.setFinalX(this.getCurrentItem() * this.getClientWidth());
            } else {
                int n5 = this.getPaddingLeft();
                int n6 = this.getPaddingRight();
                int n7 = this.getPaddingLeft();
                int n8 = this.getPaddingRight();
                float f = (float)this.getScrollX() / (float)(n2 - n7 - n8 + n4);
                this.scrollTo((int)((float)(n - n5 - n6 + n3) * f), this.getScrollY());
            }
        } else {
            ItemInfo itemInfo = this.infoForPosition(this.mCurItem);
            float f = itemInfo != null ? Math.min(itemInfo.offset, this.mLastOffset) : 0.0f;
            if ((n = (int)((float)(n - this.getPaddingLeft() - this.getPaddingRight()) * f)) != this.getScrollX()) {
                this.completeScroll(false);
                this.scrollTo(n, this.getScrollY());
            }
        }
    }

    private void removeNonDecorViews() {
        int n = 0;
        while (n < this.getChildCount()) {
            int n2 = n;
            if (!((LayoutParams)this.getChildAt((int)n).getLayoutParams()).isDecor) {
                this.removeViewAt(n);
                n2 = n - 1;
            }
            n = n2 + 1;
        }
    }

    private void requestParentDisallowInterceptTouchEvent(boolean bl) {
        ViewParent viewParent = this.getParent();
        if (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(bl);
        }
    }

    private boolean resetTouch() {
        this.mActivePointerId = -1;
        this.endDrag();
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        boolean bl = this.mLeftEdge.isFinished() || this.mRightEdge.isFinished();
        return bl;
    }

    private void scrollToItem(int n, boolean bl, int n2, boolean bl2) {
        ItemInfo itemInfo = this.infoForPosition(n);
        int n3 = 0;
        if (itemInfo != null) {
            n3 = (int)((float)this.getClientWidth() * Math.max(this.mFirstOffset, Math.min(itemInfo.offset, this.mLastOffset)));
        }
        if (bl) {
            this.smoothScrollTo(n3, 0, n2);
            if (bl2) {
                this.dispatchOnPageSelected(n);
            }
        } else {
            if (bl2) {
                this.dispatchOnPageSelected(n);
            }
            this.completeScroll(false);
            this.scrollTo(n3, 0);
            this.pageScrolled(n3);
        }
    }

    private void setScrollingCacheEnabled(boolean bl) {
        if (this.mScrollingCacheEnabled != bl) {
            this.mScrollingCacheEnabled = bl;
        }
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder != 0) {
            if (this.mDrawingOrderedChildren == null) {
                this.mDrawingOrderedChildren = new ArrayList();
            } else {
                this.mDrawingOrderedChildren.clear();
            }
            int n = this.getChildCount();
            for (int i = 0; i < n; ++i) {
                View view = this.getChildAt(i);
                this.mDrawingOrderedChildren.add(view);
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int n, int n2) {
        int n3 = arrayList.size();
        int n4 = this.getDescendantFocusability();
        if (n4 != 393216) {
            for (int i = 0; i < this.getChildCount(); ++i) {
                ItemInfo itemInfo;
                View view = this.getChildAt(i);
                if (view.getVisibility() != 0 || (itemInfo = this.infoForChild(view)) == null || itemInfo.position != this.mCurItem) continue;
                view.addFocusables(arrayList, n, n2);
            }
        }
        if (n4 != 262144 || n3 == arrayList.size()) {
            if (!this.isFocusable()) {
                return;
            }
            if ((n2 & 1) == 1 && this.isInTouchMode() && !this.isFocusableInTouchMode()) {
                return;
            }
            if (arrayList != null) {
                arrayList.add((View)this);
            }
        }
    }

    ItemInfo addNewItem(int n, int n2) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.position = n;
        itemInfo.object = this.mAdapter.instantiateItem(this, n);
        itemInfo.widthFactor = this.mAdapter.getPageWidth(n);
        if (n2 >= 0 && n2 < this.mItems.size()) {
            this.mItems.add(n2, itemInfo);
        } else {
            this.mItems.add(itemInfo);
        }
        return itemInfo;
    }

    public void addOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        if (this.mAdapterChangeListeners == null) {
            this.mAdapterChangeListeners = new ArrayList<OnAdapterChangeListener>();
        }
        this.mAdapterChangeListeners.add(onAdapterChangeListener);
    }

    public void addOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList<OnPageChangeListener>();
        }
        this.mOnPageChangeListeners.add(onPageChangeListener);
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < this.getChildCount(); ++i) {
            ItemInfo itemInfo;
            View view = this.getChildAt(i);
            if (view.getVisibility() != 0 || (itemInfo = this.infoForChild(view)) == null || itemInfo.position != this.mCurItem) continue;
            view.addTouchables(arrayList);
        }
    }

    public void addView(View view, int n, ViewGroup.LayoutParams layoutParams) {
        ViewGroup.LayoutParams layoutParams2 = layoutParams;
        if (!this.checkLayoutParams(layoutParams)) {
            layoutParams2 = this.generateLayoutParams(layoutParams);
        }
        layoutParams = (LayoutParams)layoutParams2;
        layoutParams.isDecor |= ViewPager.isDecorView(view);
        if (this.mInLayout) {
            if (layoutParams != null && layoutParams.isDecor) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            layoutParams.needsMeasure = true;
            this.addViewInLayout(view, n, layoutParams2);
        } else {
            super.addView(view, n, layoutParams2);
        }
    }

    public boolean arrowScroll(int n) {
        int n2;
        int n3;
        View view;
        View view2 = this.findFocus();
        if (view2 == this) {
            view = null;
        } else {
            view = view2;
            if (view2 != null) {
                n3 = 0;
                view = view2.getParent();
                while (true) {
                    n2 = n3;
                    if (!(view instanceof ViewGroup)) break;
                    if (view == this) {
                        n2 = 1;
                        break;
                    }
                    view = view.getParent();
                }
                view = view2;
                if (n2 == 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(view2.getClass().getSimpleName());
                    view = view2.getParent();
                    while (view instanceof ViewGroup) {
                        stringBuilder.append(" => ").append(view.getClass().getSimpleName());
                        view = view.getParent();
                    }
                    Log.e((String)TAG, (String)("arrowScroll tried to find focus based on non-child current focused view " + stringBuilder.toString()));
                    view = null;
                }
            }
        }
        boolean bl = false;
        boolean bl2 = false;
        view2 = FocusFinder.getInstance().findNextFocus((ViewGroup)this, view, n);
        if (view2 != null && view2 != view) {
            if (n == 17) {
                n3 = this.getChildRectInPagerCoordinates((Rect)this.mTempRect, (View)view2).left;
                n2 = this.getChildRectInPagerCoordinates((Rect)this.mTempRect, (View)view).left;
                bl = view != null && n3 >= n2 ? this.pageLeft() : view2.requestFocus();
            } else {
                bl = bl2;
                if (n == 66) {
                    n2 = this.getChildRectInPagerCoordinates((Rect)this.mTempRect, (View)view2).left;
                    n3 = this.getChildRectInPagerCoordinates((Rect)this.mTempRect, (View)view).left;
                    bl = view != null && n2 <= n3 ? this.pageRight() : view2.requestFocus();
                }
            }
        } else if (n != 17 && n != 1) {
            if (n == 66 || n == 2) {
                bl = this.pageRight();
            }
        } else {
            bl = this.pageLeft();
        }
        if (bl) {
            this.playSoundEffect(SoundEffectConstants.getContantForFocusDirection((int)n));
        }
        return bl;
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        this.setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
        long l = SystemClock.uptimeMillis();
        MotionEvent motionEvent = MotionEvent.obtain((long)l, (long)l, (int)0, (float)0.0f, (float)0.0f, (int)0);
        this.mVelocityTracker.addMovement(motionEvent);
        motionEvent.recycle();
        this.mFakeDragBeginTime = l;
        return true;
    }

    protected boolean canScroll(View view, boolean bl, int n, int n2, int n3) {
        boolean bl2 = view instanceof ViewGroup;
        boolean bl3 = true;
        if (bl2) {
            ViewGroup viewGroup = (ViewGroup)view;
            int n4 = view.getScrollX();
            int n5 = view.getScrollY();
            for (int i = viewGroup.getChildCount() - 1; i >= 0; --i) {
                View view2 = viewGroup.getChildAt(i);
                if (n2 + n4 < view2.getLeft() || n2 + n4 >= view2.getRight() || n3 + n5 < view2.getTop() || n3 + n5 >= view2.getBottom() || !this.canScroll(view2, true, n, n2 + n4 - view2.getLeft(), n3 + n5 - view2.getTop())) continue;
                return true;
            }
        }
        bl = bl && view.canScrollHorizontally(-n) ? bl3 : false;
        return bl;
    }

    public boolean canScrollHorizontally(int n) {
        PagerAdapter pagerAdapter = this.mAdapter;
        boolean bl = false;
        boolean bl2 = false;
        if (pagerAdapter == null) {
            return false;
        }
        int n2 = this.getClientWidth();
        int n3 = this.getScrollX();
        if (n < 0) {
            bl = bl2;
            if (n3 > (int)((float)n2 * this.mFirstOffset)) {
                bl = true;
            }
            return bl;
        }
        if (n > 0) {
            if (n3 < (int)((float)n2 * this.mLastOffset)) {
                bl = true;
            }
            return bl;
        }
        return false;
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        boolean bl = layoutParams instanceof LayoutParams && super.checkLayoutParams(layoutParams);
        return bl;
    }

    public void clearOnPageChangeListeners() {
        if (this.mOnPageChangeListeners != null) {
            this.mOnPageChangeListeners.clear();
        }
    }

    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
            int n = this.getScrollX();
            int n2 = this.getScrollY();
            int n3 = this.mScroller.getCurrX();
            int n4 = this.mScroller.getCurrY();
            if (n != n3 || n2 != n4) {
                this.scrollTo(n3, n4);
                if (!this.pageScrolled(n3)) {
                    this.mScroller.abortAnimation();
                    this.scrollTo(0, n4);
                }
            }
            ViewCompat.postInvalidateOnAnimation((View)this);
            return;
        }
        this.completeScroll(true);
    }

    void dataSetChanged() {
        Object object;
        int n;
        this.mExpectedAdapterCount = n = this.mAdapter.getCount();
        int n2 = this.mItems.size() < this.mOffscreenPageLimit * 2 + 1 && this.mItems.size() < n ? 1 : 0;
        int n3 = this.mCurItem;
        int n4 = 0;
        int n5 = 0;
        while (n5 < this.mItems.size()) {
            int n6;
            int n7;
            int n8;
            object = this.mItems.get(n5);
            int n9 = this.mAdapter.getItemPosition(object.object);
            if (n9 == -1) {
                n8 = n3;
                n7 = n4;
                n6 = n5;
            } else if (n9 == -2) {
                this.mItems.remove(n5);
                n9 = n5 - 1;
                n5 = n4;
                if (n4 == 0) {
                    this.mAdapter.startUpdate(this);
                    n5 = 1;
                }
                this.mAdapter.destroyItem(this, object.position, object.object);
                n2 = 1;
                n8 = n3;
                n7 = n5;
                n6 = n9;
                if (this.mCurItem == object.position) {
                    n8 = Math.max(0, Math.min(this.mCurItem, n - 1));
                    n2 = 1;
                    n7 = n5;
                    n6 = n9;
                }
            } else {
                n8 = n3;
                n7 = n4;
                n6 = n5;
                if (object.position != n9) {
                    if (object.position == this.mCurItem) {
                        n3 = n9;
                    }
                    object.position = n9;
                    n2 = 1;
                    n6 = n5;
                    n7 = n4;
                    n8 = n3;
                }
            }
            n5 = n6 + 1;
            n3 = n8;
            n4 = n7;
        }
        if (n4 != 0) {
            this.mAdapter.finishUpdate(this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (n2 != 0) {
            n4 = this.getChildCount();
            for (n2 = 0; n2 < n4; ++n2) {
                object = (LayoutParams)this.getChildAt(n2).getLayoutParams();
                if (((LayoutParams)((Object)object)).isDecor) continue;
                ((LayoutParams)((Object)object)).widthFactor = 0.0f;
            }
            this.setCurrentItemInternal(n3, false, true);
            this.requestLayout();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean bl = super.dispatchKeyEvent(keyEvent) || this.executeKeyEvent(keyEvent);
        return bl;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int n = this.getChildCount();
        for (int i = 0; i < n; ++i) {
            ItemInfo itemInfo;
            View view = this.getChildAt(i);
            if (view.getVisibility() != 0 || (itemInfo = this.infoForChild(view)) == null || itemInfo.position != this.mCurItem || !view.dispatchPopulateAccessibilityEvent(accessibilityEvent)) continue;
            return true;
        }
        return false;
    }

    float distanceInfluenceForSnapDuration(float f) {
        return (float)Math.sin((f - 0.5f) * 0.47123894f);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int n = 0;
        int n2 = 0;
        int n3 = this.getOverScrollMode();
        if (n3 != 0 && (n3 != 1 || this.mAdapter == null || this.mAdapter.getCount() <= 1)) {
            this.mLeftEdge.finish();
            this.mRightEdge.finish();
        } else {
            if (!this.mLeftEdge.isFinished()) {
                n = canvas.save();
                n3 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
                n2 = this.getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float)(-n3 + this.getPaddingTop()), this.mFirstOffset * (float)n2);
                this.mLeftEdge.setSize(n3, n2);
                n2 = 0 | this.mLeftEdge.draw(canvas);
                canvas.restoreToCount(n);
            }
            n = n2;
            if (!this.mRightEdge.isFinished()) {
                n3 = canvas.save();
                int n4 = this.getWidth();
                n = this.getHeight();
                int n5 = this.getPaddingTop();
                int n6 = this.getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float)(-this.getPaddingTop()), -(this.mLastOffset + 1.0f) * (float)n4);
                this.mRightEdge.setSize(n - n5 - n6, n4);
                n = n2 | this.mRightEdge.draw(canvas);
                canvas.restoreToCount(n3);
            }
        }
        if (n != 0) {
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable2 = this.mMarginDrawable;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(this.getDrawableState());
        }
    }

    public void endFakeDrag() {
        if (this.mFakeDragging) {
            if (this.mAdapter != null) {
                Object object = this.mVelocityTracker;
                object.computeCurrentVelocity(1000, (float)this.mMaximumVelocity);
                int n = (int)object.getXVelocity(this.mActivePointerId);
                this.mPopulatePending = true;
                int n2 = this.getClientWidth();
                int n3 = this.getScrollX();
                object = this.infoForCurrentScrollPosition();
                this.setCurrentItemInternal(this.determineTargetPage(object.position, ((float)n3 / (float)n2 - object.offset) / object.widthFactor, n, (int)(this.mLastMotionX - this.mInitialMotionX)), true, true, n);
            }
            this.endDrag();
            this.mFakeDragging = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        boolean bl;
        boolean bl2 = bl = false;
        if (keyEvent.getAction() == 0) {
            switch (keyEvent.getKeyCode()) {
                default: {
                    bl2 = bl;
                    break;
                }
                case 61: {
                    if (keyEvent.hasNoModifiers()) {
                        bl2 = this.arrowScroll(2);
                        break;
                    }
                    bl2 = bl;
                    if (!keyEvent.hasModifiers(1)) break;
                    bl2 = this.arrowScroll(1);
                    break;
                }
                case 22: {
                    if (keyEvent.hasModifiers(2)) {
                        bl2 = this.pageRight();
                        break;
                    }
                    bl2 = this.arrowScroll(66);
                    break;
                }
                case 21: {
                    bl2 = keyEvent.hasModifiers(2) ? this.pageLeft() : this.arrowScroll(17);
                }
            }
        }
        return bl2;
    }

    public void fakeDragBy(float f) {
        if (this.mFakeDragging) {
            if (this.mAdapter == null) {
                return;
            }
            this.mLastMotionX += f;
            float f2 = (float)this.getScrollX() - f;
            int n = this.getClientWidth();
            f = (float)n * this.mFirstOffset;
            float f3 = (float)n * this.mLastOffset;
            ItemInfo itemInfo = this.mItems.get(0);
            ItemInfo itemInfo2 = this.mItems.get(this.mItems.size() - 1);
            if (itemInfo.position != 0) {
                f = itemInfo.offset * (float)n;
            }
            if (itemInfo2.position != this.mAdapter.getCount() - 1) {
                f3 = itemInfo2.offset * (float)n;
            }
            if (!(f2 < f)) {
                f = f2;
                if (f2 > f3) {
                    f = f3;
                }
            }
            this.mLastMotionX += f - (float)((int)f);
            this.scrollTo((int)f, this.getScrollY());
            this.pageScrolled((int)f);
            long l = SystemClock.uptimeMillis();
            itemInfo = MotionEvent.obtain((long)this.mFakeDragBeginTime, (long)l, (int)2, (float)this.mLastMotionX, (float)0.0f, (int)0);
            this.mVelocityTracker.addMovement((MotionEvent)itemInfo);
            itemInfo.recycle();
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(this.getContext(), attributeSet);
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return this.generateDefaultLayoutParams();
    }

    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    protected int getChildDrawingOrder(int n, int n2) {
        n = this.mDrawingOrder == 2 ? n - 1 - n2 : n2;
        return ((LayoutParams)this.mDrawingOrderedChildren.get((int)n).getLayoutParams()).childIndex;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    ItemInfo infoForAnyChild(View view) {
        ViewParent viewParent;
        while ((viewParent = view.getParent()) != this) {
            if (viewParent != null && viewParent instanceof View) {
                view = (View)viewParent;
                continue;
            }
            return null;
        }
        return this.infoForChild(view);
    }

    ItemInfo infoForChild(View view) {
        for (int i = 0; i < this.mItems.size(); ++i) {
            ItemInfo itemInfo = this.mItems.get(i);
            if (!this.mAdapter.isViewFromObject(view, itemInfo.object)) continue;
            return itemInfo;
        }
        return null;
    }

    ItemInfo infoForPosition(int n) {
        for (int i = 0; i < this.mItems.size(); ++i) {
            ItemInfo itemInfo = this.mItems.get(i);
            if (itemInfo.position != n) continue;
            return itemInfo;
        }
        return null;
    }

    void initViewPager() {
        this.setWillNotDraw(false);
        this.setDescendantFocusability(262144);
        this.setFocusable(true);
        Context context = this.getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get((Context)context);
        float f = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int)(400.0f * f);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(context);
        this.mRightEdge = new EdgeEffect(context);
        this.mFlingDistance = (int)(25.0f * f);
        this.mCloseEnough = (int)(2.0f * f);
        this.mDefaultGutterSize = (int)(16.0f * f);
        ViewCompat.setAccessibilityDelegate((View)this, new MyAccessibilityDelegate(this));
        if (ViewCompat.getImportantForAccessibility((View)this) == 0) {
            ViewCompat.setImportantForAccessibility((View)this, 1);
        }
        ViewCompat.setOnApplyWindowInsetsListener((View)this, new OnApplyWindowInsetsListener(this){
            private final Rect mTempRect;
            final ViewPager this$0;
            {
                this.this$0 = viewPager;
                this.mTempRect = new Rect();
            }

            @Override
            public WindowInsetsCompat onApplyWindowInsets(View object, WindowInsetsCompat windowInsetsCompat) {
                if ((windowInsetsCompat = ViewCompat.onApplyWindowInsets((View)object, windowInsetsCompat)).isConsumed()) {
                    return windowInsetsCompat;
                }
                Rect rect = this.mTempRect;
                rect.left = windowInsetsCompat.getSystemWindowInsetLeft();
                rect.top = windowInsetsCompat.getSystemWindowInsetTop();
                rect.right = windowInsetsCompat.getSystemWindowInsetRight();
                rect.bottom = windowInsetsCompat.getSystemWindowInsetBottom();
                int n = this.this$0.getChildCount();
                for (int i = 0; i < n; ++i) {
                    object = ViewCompat.dispatchApplyWindowInsets(this.this$0.getChildAt(i), windowInsetsCompat);
                    rect.left = Math.min(((WindowInsetsCompat)object).getSystemWindowInsetLeft(), rect.left);
                    rect.top = Math.min(((WindowInsetsCompat)object).getSystemWindowInsetTop(), rect.top);
                    rect.right = Math.min(((WindowInsetsCompat)object).getSystemWindowInsetRight(), rect.right);
                    rect.bottom = Math.min(((WindowInsetsCompat)object).getSystemWindowInsetBottom(), rect.bottom);
                }
                return windowInsetsCompat.replaceSystemWindowInsets(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    protected void onDetachedFromWindow() {
        this.removeCallbacks(this.mEndScrollRunnable);
        if (this.mScroller != null && !this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mPageMargin > 0 && this.mMarginDrawable != null && this.mItems.size() > 0 && this.mAdapter != null) {
            int n = this.getScrollX();
            int n2 = this.getWidth();
            float f = (float)this.mPageMargin / (float)n2;
            int n3 = 0;
            Object object = this.mItems.get(0);
            float f2 = ((ItemInfo)object).offset;
            int n4 = this.mItems.size();
            int n5 = this.mItems.get((int)(n4 - 1)).position;
            for (int i = ((ItemInfo)object).position; i < n5; ++i) {
                float f3;
                while (i > ((ItemInfo)object).position && n3 < n4) {
                    object = this.mItems;
                    object = (ItemInfo)((ArrayList)object).get(++n3);
                }
                if (i == ((ItemInfo)object).position) {
                    f3 = (((ItemInfo)object).offset + ((ItemInfo)object).widthFactor) * (float)n2;
                    f2 = ((ItemInfo)object).offset + ((ItemInfo)object).widthFactor + f;
                } else {
                    f3 = this.mAdapter.getPageWidth(i);
                    float f4 = n2;
                    float f5 = f2 + (f3 + f);
                    f3 = (f2 + f3) * f4;
                    f2 = f5;
                }
                if ((float)this.mPageMargin + f3 > (float)n) {
                    this.mMarginDrawable.setBounds(Math.round(f3), this.mTopPageBounds, Math.round((float)this.mPageMargin + f3), this.mBottomPageBounds);
                    this.mMarginDrawable.draw(canvas);
                }
                if (f3 > (float)(n + n2)) break;
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int n = motionEvent.getAction() & 0xFF;
        if (n != 3 && n != 1) {
            if (n != 0) {
                if (this.mIsBeingDragged) {
                    return true;
                }
                if (this.mIsUnableToDrag) {
                    return false;
                }
            }
            switch (n) {
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
                    n = motionEvent.findPointerIndex(n);
                    float f = motionEvent.getX(n);
                    float f2 = f - this.mLastMotionX;
                    float f3 = Math.abs(f2);
                    float f4 = motionEvent.getY(n);
                    float f5 = Math.abs(f4 - this.mInitialMotionY);
                    if (f2 != 0.0f && !this.isGutterDrag(this.mLastMotionX, f2) && this.canScroll((View)this, false, (int)f2, (int)f, (int)f4)) {
                        this.mLastMotionX = f;
                        this.mLastMotionY = f4;
                        this.mIsUnableToDrag = true;
                        return false;
                    }
                    if (f3 > (float)this.mTouchSlop && 0.5f * f3 > f5) {
                        this.mIsBeingDragged = true;
                        this.requestParentDisallowInterceptTouchEvent(true);
                        this.setScrollState(1);
                        f5 = f2 > 0.0f ? this.mInitialMotionX + (float)this.mTouchSlop : this.mInitialMotionX - (float)this.mTouchSlop;
                        this.mLastMotionX = f5;
                        this.mLastMotionY = f4;
                        this.setScrollingCacheEnabled(true);
                    } else if (f5 > (float)this.mTouchSlop) {
                        this.mIsUnableToDrag = true;
                    }
                    if (!this.mIsBeingDragged || !this.performDrag(f)) break;
                    ViewCompat.postInvalidateOnAnimation((View)this);
                    break;
                }
                case 0: {
                    float f;
                    this.mInitialMotionX = f = motionEvent.getX();
                    this.mLastMotionX = f;
                    this.mInitialMotionY = f = motionEvent.getY();
                    this.mLastMotionY = f;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    this.mIsUnableToDrag = false;
                    this.mIsScrollStarted = true;
                    this.mScroller.computeScrollOffset();
                    if (this.mScrollState == 2 && Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough) {
                        this.mScroller.abortAnimation();
                        this.mPopulatePending = false;
                        this.populate();
                        this.mIsBeingDragged = true;
                        this.requestParentDisallowInterceptTouchEvent(true);
                        this.setScrollState(1);
                        break;
                    }
                    this.completeScroll(false);
                    this.mIsBeingDragged = false;
                }
            }
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            return this.mIsBeingDragged;
        }
        this.resetTouch();
        return false;
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        Object object;
        int n5;
        int n6;
        View view;
        int n7;
        int n8 = this.getChildCount();
        int n9 = n3 - n;
        int n10 = n4 - n2;
        n = this.getPaddingLeft();
        n2 = this.getPaddingTop();
        int n11 = this.getPaddingRight();
        n4 = this.getPaddingBottom();
        int n12 = this.getScrollX();
        int n13 = 0;
        for (n7 = 0; n7 < n8; ++n7) {
            view = this.getChildAt(n7);
            n3 = n;
            n6 = n2;
            n5 = n11;
            int n14 = n4;
            int n15 = n13;
            if (view.getVisibility() != 8) {
                object = (LayoutParams)view.getLayoutParams();
                if (object.isDecor) {
                    n3 = object.gravity;
                    n5 = object.gravity;
                    switch (n3 & 7) {
                        default: {
                            n3 = n;
                            n6 = n;
                            break;
                        }
                        case 5: {
                            n3 = n9 - n11 - view.getMeasuredWidth();
                            n11 += view.getMeasuredWidth();
                            n6 = n;
                            break;
                        }
                        case 3: {
                            n3 = n;
                            n6 = n + view.getMeasuredWidth();
                            break;
                        }
                        case 1: {
                            n3 = Math.max((n9 - view.getMeasuredWidth()) / 2, n);
                            n6 = n;
                        }
                    }
                    switch (n5 & 0x70) {
                        default: {
                            n = n2;
                            break;
                        }
                        case 80: {
                            n = n10 - n4 - view.getMeasuredHeight();
                            n4 += view.getMeasuredHeight();
                            break;
                        }
                        case 48: {
                            n = n2;
                            n2 += view.getMeasuredHeight();
                            break;
                        }
                        case 16: {
                            n = Math.max((n10 - view.getMeasuredHeight()) / 2, n2);
                        }
                    }
                    view.layout(n3 += n12, n, n3 + view.getMeasuredWidth(), n + view.getMeasuredHeight());
                    n15 = n13 + 1;
                    n3 = n6;
                    n6 = n2;
                    n5 = n11;
                    n14 = n4;
                } else {
                    n15 = n13;
                    n14 = n4;
                    n5 = n11;
                    n6 = n2;
                    n3 = n;
                }
            }
            n = n3;
            n2 = n6;
            n11 = n5;
            n4 = n14;
            n13 = n15;
        }
        n7 = n9 - n - n11;
        n3 = n9;
        n11 = n8;
        for (n6 = 0; n6 < n11; ++n6) {
            view = this.getChildAt(n6);
            if (view.getVisibility() == 8) continue;
            LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            if (layoutParams.isDecor || (object = this.infoForChild(view)) == null) continue;
            n5 = n + (int)((float)n7 * ((ItemInfo)object).offset);
            if (layoutParams.needsMeasure) {
                layoutParams.needsMeasure = false;
                view.measure(View.MeasureSpec.makeMeasureSpec((int)((int)((float)n7 * layoutParams.widthFactor)), (int)0x40000000), View.MeasureSpec.makeMeasureSpec((int)(n10 - n2 - n4), (int)0x40000000));
            }
            view.layout(n5, n2, view.getMeasuredWidth() + n5, view.getMeasuredHeight() + n2);
        }
        this.mTopPageBounds = n2;
        this.mBottomPageBounds = n10 - n4;
        this.mDecorChildCount = n13;
        if (this.mFirstLayout) {
            this.scrollToItem(this.mCurItem, false, 0, false);
        }
        this.mFirstLayout = false;
    }

    protected void onMeasure(int n, int n2) {
        int n3;
        LayoutParams layoutParams;
        View view;
        this.setMeasuredDimension(ViewPager.getDefaultSize((int)0, (int)n), ViewPager.getDefaultSize((int)0, (int)n2));
        int n4 = this.getMeasuredWidth();
        int n5 = n4 / 10;
        this.mGutterSize = Math.min(n5, this.mDefaultGutterSize);
        n = n4 - this.getPaddingLeft() - this.getPaddingRight();
        n2 = this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom();
        int n6 = this.getChildCount();
        for (int i = 0; i < n6; ++i) {
            int n7;
            view = this.getChildAt(i);
            if (view.getVisibility() != 8) {
                layoutParams = (LayoutParams)view.getLayoutParams();
                if (layoutParams != null && layoutParams.isDecor) {
                    int n8;
                    n3 = layoutParams.gravity & 7;
                    int n9 = layoutParams.gravity & 0x70;
                    int n10 = Integer.MIN_VALUE;
                    n7 = Integer.MIN_VALUE;
                    n9 = n9 != 48 && n9 != 80 ? 0 : 1;
                    boolean bl = n3 == 3 || n3 == 5;
                    if (n9 != 0) {
                        n3 = 0x40000000;
                    } else {
                        n3 = n10;
                        if (bl) {
                            n7 = 0x40000000;
                            n3 = n10;
                        }
                    }
                    if (layoutParams.width != -2) {
                        n8 = 0x40000000;
                        n3 = layoutParams.width != -1 ? layoutParams.width : n;
                    } else {
                        n10 = n;
                        n8 = n3;
                        n3 = n10;
                    }
                    if (layoutParams.height != -2) {
                        if (layoutParams.height != -1) {
                            n10 = layoutParams.height;
                            n7 = 0x40000000;
                        } else {
                            n7 = 0x40000000;
                            n10 = n2;
                        }
                    } else {
                        n10 = n2;
                    }
                    view.measure(View.MeasureSpec.makeMeasureSpec((int)n3, (int)n8), View.MeasureSpec.makeMeasureSpec((int)n10, (int)n7));
                    if (n9 != 0) {
                        n7 = n2 - view.getMeasuredHeight();
                        n3 = n;
                    } else {
                        n3 = n;
                        n7 = n2;
                        if (bl) {
                            n3 = n - view.getMeasuredWidth();
                            n7 = n2;
                        }
                    }
                } else {
                    n3 = n;
                    n7 = n2;
                }
            } else {
                n7 = n2;
                n3 = n;
            }
            n = n3;
            n2 = n7;
        }
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec((int)n, (int)0x40000000);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec((int)n2, (int)0x40000000);
        this.mInLayout = true;
        this.populate();
        this.mInLayout = false;
        n3 = this.getChildCount();
        for (n2 = 0; n2 < n3; ++n2) {
            view = this.getChildAt(n2);
            if (view.getVisibility() == 8 || (layoutParams = (LayoutParams)view.getLayoutParams()) != null && layoutParams.isDecor) continue;
            view.measure(View.MeasureSpec.makeMeasureSpec((int)((int)((float)n * layoutParams.widthFactor)), (int)0x40000000), this.mChildHeightMeasureSpec);
        }
    }

    protected void onPageScrolled(int n, float f, int n2) {
        View view;
        int n3;
        if (this.mDecorChildCount > 0) {
            int n4 = this.getScrollX();
            n3 = this.getPaddingLeft();
            int n5 = this.getPaddingRight();
            int n6 = this.getWidth();
            int n7 = this.getChildCount();
            for (int i = 0; i < n7; ++i) {
                int n8;
                int n9;
                view = this.getChildAt(i);
                LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
                if (!layoutParams.isDecor) {
                    n9 = n3;
                    n8 = n5;
                } else {
                    switch (layoutParams.gravity & 7) {
                        default: {
                            n8 = n3;
                            break;
                        }
                        case 5: {
                            n8 = n6 - n5 - view.getMeasuredWidth();
                            n5 += view.getMeasuredWidth();
                            break;
                        }
                        case 3: {
                            n8 = n3;
                            n3 += view.getWidth();
                            break;
                        }
                        case 1: {
                            n8 = Math.max((n6 - view.getMeasuredWidth()) / 2, n3);
                        }
                    }
                    int n10 = n8 + n4 - view.getLeft();
                    n9 = n3;
                    n8 = n5;
                    if (n10 != 0) {
                        view.offsetLeftAndRight(n10);
                        n8 = n5;
                        n9 = n3;
                    }
                }
                n3 = n9;
                n5 = n8;
            }
        }
        this.dispatchOnPageScrolled(n, f, n2);
        if (this.mPageTransformer != null) {
            n2 = this.getScrollX();
            n3 = this.getChildCount();
            for (n = 0; n < n3; ++n) {
                view = this.getChildAt(n);
                if (((LayoutParams)view.getLayoutParams()).isDecor) continue;
                f = (float)(view.getLeft() - n2) / (float)this.getClientWidth();
                this.mPageTransformer.transformPage(view, f);
            }
        }
        this.mCalledSuper = true;
    }

    protected boolean onRequestFocusInDescendants(int n, Rect rect) {
        int n2;
        int n3;
        int n4 = this.getChildCount();
        if ((n & 2) != 0) {
            n3 = 0;
            n2 = 1;
        } else {
            n3 = n4 - 1;
            n2 = -1;
            n4 = -1;
        }
        while (n3 != n4) {
            ItemInfo itemInfo;
            View view = this.getChildAt(n3);
            if (view.getVisibility() == 0 && (itemInfo = this.infoForChild(view)) != null && itemInfo.position == this.mCurItem && view.requestFocus(n, rect)) {
                return true;
            }
            n3 += n2;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        if (this.mAdapter != null) {
            this.mAdapter.restoreState(parcelable.adapterState, parcelable.loader);
            this.setCurrentItemInternal(parcelable.position, false, true);
        } else {
            this.mRestoredCurItem = parcelable.position;
            this.mRestoredAdapterState = parcelable.adapterState;
            this.mRestoredClassLoader = parcelable.loader;
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.mCurItem;
        if (this.mAdapter != null) {
            savedState.adapterState = this.mAdapter.saveState();
        }
        return savedState;
    }

    protected void onSizeChanged(int n, int n2, int n3, int n4) {
        super.onSizeChanged(n, n2, n3, n4);
        if (n != n3) {
            this.recomputeScrollPosition(n, n3, this.mPageMargin, this.mPageMargin);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mFakeDragging) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.mAdapter != null && this.mAdapter.getCount() != 0) {
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            int n = motionEvent.getAction();
            boolean bl = false;
            switch (n & 0xFF) {
                default: {
                    break;
                }
                case 6: {
                    this.onSecondaryPointerUp(motionEvent);
                    this.mLastMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                    break;
                }
                case 5: {
                    n = motionEvent.getActionIndex();
                    this.mLastMotionX = motionEvent.getX(n);
                    this.mActivePointerId = motionEvent.getPointerId(n);
                    break;
                }
                case 3: {
                    if (!this.mIsBeingDragged) break;
                    this.scrollToItem(this.mCurItem, true, 0, false);
                    bl = this.resetTouch();
                    break;
                }
                case 2: {
                    if (!this.mIsBeingDragged) {
                        n = motionEvent.findPointerIndex(this.mActivePointerId);
                        if (n == -1) {
                            bl = this.resetTouch();
                            break;
                        }
                        float f = motionEvent.getX(n);
                        float f2 = Math.abs(f - this.mLastMotionX);
                        float f3 = motionEvent.getY(n);
                        float f4 = Math.abs(f3 - this.mLastMotionY);
                        if (f2 > (float)this.mTouchSlop && f2 > f4) {
                            this.mIsBeingDragged = true;
                            this.requestParentDisallowInterceptTouchEvent(true);
                            f2 = f - this.mInitialMotionX > 0.0f ? this.mInitialMotionX + (float)this.mTouchSlop : this.mInitialMotionX - (float)this.mTouchSlop;
                            this.mLastMotionX = f2;
                            this.mLastMotionY = f3;
                            this.setScrollState(1);
                            this.setScrollingCacheEnabled(true);
                            ViewParent viewParent = this.getParent();
                            if (viewParent != null) {
                                viewParent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                    if (!this.mIsBeingDragged) break;
                    bl = false | this.performDrag(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)));
                    break;
                }
                case 1: {
                    if (!this.mIsBeingDragged) break;
                    Object object = this.mVelocityTracker;
                    object.computeCurrentVelocity(1000, (float)this.mMaximumVelocity);
                    n = (int)object.getXVelocity(this.mActivePointerId);
                    this.mPopulatePending = true;
                    int n2 = this.getClientWidth();
                    int n3 = this.getScrollX();
                    object = this.infoForCurrentScrollPosition();
                    float f = (float)this.mPageMargin / (float)n2;
                    this.setCurrentItemInternal(this.determineTargetPage(object.position, ((float)n3 / (float)n2 - object.offset) / (object.widthFactor + f), n, (int)(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, n);
                    bl = this.resetTouch();
                    break;
                }
                case 0: {
                    float f;
                    this.mScroller.abortAnimation();
                    this.mPopulatePending = false;
                    this.populate();
                    this.mInitialMotionX = f = motionEvent.getX();
                    this.mLastMotionX = f;
                    this.mInitialMotionY = f = motionEvent.getY();
                    this.mLastMotionY = f;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                }
            }
            if (bl) {
                ViewCompat.postInvalidateOnAnimation((View)this);
            }
            return true;
        }
        return false;
    }

    boolean pageLeft() {
        if (this.mCurItem > 0) {
            this.setCurrentItem(this.mCurItem - 1, true);
            return true;
        }
        return false;
    }

    boolean pageRight() {
        if (this.mAdapter != null && this.mCurItem < this.mAdapter.getCount() - 1) {
            this.setCurrentItem(this.mCurItem + 1, true);
            return true;
        }
        return false;
    }

    void populate() {
        this.populate(this.mCurItem);
    }

    void populate(int n) {
        String string2;
        ItemInfo itemInfo;
        if (this.mCurItem != n) {
            itemInfo = this.infoForPosition(this.mCurItem);
            this.mCurItem = n;
        } else {
            itemInfo = null;
        }
        if (this.mAdapter == null) {
            this.sortChildDrawingOrder();
            return;
        }
        if (this.mPopulatePending) {
            this.sortChildDrawingOrder();
            return;
        }
        if (this.getWindowToken() == null) {
            return;
        }
        this.mAdapter.startUpdate(this);
        int n2 = this.mOffscreenPageLimit;
        int n3 = Math.max(0, this.mCurItem - n2);
        int n4 = this.mAdapter.getCount();
        int n5 = Math.min(n4 - 1, this.mCurItem + n2);
        if (n4 == this.mExpectedAdapterCount) {
            int n6;
            ItemInfo itemInfo2;
            Object object;
            ItemInfo itemInfo3 = null;
            n = 0;
            while (true) {
                object = itemInfo3;
                if (n >= this.mItems.size()) break;
                itemInfo2 = this.mItems.get(n);
                if (itemInfo2.position >= this.mCurItem) {
                    object = itemInfo3;
                    if (itemInfo2.position != this.mCurItem) break;
                    object = itemInfo2;
                    break;
                }
                ++n;
            }
            itemInfo2 = object;
            if (object == null) {
                itemInfo2 = object;
                if (n4 > 0) {
                    itemInfo2 = this.addNewItem(this.mCurItem, n);
                }
            }
            if (itemInfo2 != null) {
                float f;
                int n7;
                float f2 = 0.0f;
                int n8 = n - 1;
                object = n8 >= 0 ? this.mItems.get(n8) : null;
                int n9 = this.getClientWidth();
                float f3 = n9 <= 0 ? 0.0f : 2.0f - itemInfo2.widthFactor + (float)this.getPaddingLeft() / (float)n9;
                itemInfo3 = object;
                int n10 = n;
                for (n7 = this.mCurItem - 1; n7 >= 0; --n7) {
                    if (f2 >= f3 && n7 < n3) {
                        if (itemInfo3 == null) break;
                        n = n10;
                        f = f2;
                        n6 = n8;
                        object = itemInfo3;
                        if (n7 == itemInfo3.position) {
                            n = n10;
                            f = f2;
                            n6 = n8;
                            object = itemInfo3;
                            if (!itemInfo3.scrolling) {
                                this.mItems.remove(n8);
                                this.mAdapter.destroyItem(this, n7, itemInfo3.object);
                                n6 = n8 - 1;
                                n = n10 - 1;
                                object = n6 >= 0 ? this.mItems.get(n6) : null;
                                f = f2;
                            }
                        }
                    } else if (itemInfo3 != null && n7 == itemInfo3.position) {
                        f = f2 + itemInfo3.widthFactor;
                        n6 = n8 - 1;
                        object = n6 >= 0 ? this.mItems.get(n6) : null;
                        n = n10;
                    } else {
                        f = f2 + this.addNewItem((int)n7, (int)(n8 + 1)).widthFactor;
                        n = n10 + 1;
                        object = n8 >= 0 ? this.mItems.get(n8) : null;
                        n6 = n8;
                    }
                    n10 = n;
                    f2 = f;
                    n8 = n6;
                    itemInfo3 = object;
                }
                f = itemInfo2.widthFactor;
                n = n10 + 1;
                if (f < 2.0f) {
                    object = n < this.mItems.size() ? this.mItems.get(n) : null;
                    f3 = n9 <= 0 ? 0.0f : (float)this.getPaddingRight() / (float)n9 + 2.0f;
                    n6 = n3;
                    n8 = n2;
                    for (n7 = this.mCurItem + 1; n7 < n4; ++n7) {
                        if (f >= f3 && n7 > n5) {
                            if (object == null) break;
                            if (n7 != object.position || object.scrolling) continue;
                            this.mItems.remove(n);
                            this.mAdapter.destroyItem(this, n7, object.object);
                            if (n < this.mItems.size()) {
                                object = this.mItems.get(n);
                                continue;
                            }
                            object = null;
                            continue;
                        }
                        if (object != null && n7 == object.position) {
                            f += object.widthFactor;
                            if (++n < this.mItems.size()) {
                                object = this.mItems.get(n);
                                continue;
                            }
                            object = null;
                            continue;
                        }
                        object = this.addNewItem(n7, n);
                        f += object.widthFactor;
                        object = ++n < this.mItems.size() ? this.mItems.get(n) : null;
                    }
                }
                this.calculatePageOffsets(itemInfo2, n10, itemInfo);
                this.mAdapter.setPrimaryItem(this, this.mCurItem, itemInfo2.object);
            }
            this.mAdapter.finishUpdate(this);
            n6 = this.getChildCount();
            for (n = 0; n < n6; ++n) {
                itemInfo = this.getChildAt(n);
                object = (LayoutParams)itemInfo.getLayoutParams();
                ((LayoutParams)((Object)object)).childIndex = n;
                if (((LayoutParams)((Object)object)).isDecor || ((LayoutParams)((Object)object)).widthFactor != 0.0f || (itemInfo = this.infoForChild((View)itemInfo)) == null) continue;
                ((LayoutParams)((Object)object)).widthFactor = itemInfo.widthFactor;
                ((LayoutParams)((Object)object)).position = itemInfo.position;
            }
            this.sortChildDrawingOrder();
            if (this.hasFocus() && ((object = (object = this.findFocus()) != null ? this.infoForAnyChild((View)object) : null) == null || object.position != this.mCurItem)) {
                for (n = 0; !(n >= this.getChildCount() || (itemInfo = this.infoForChild((View)(object = this.getChildAt(n)))) != null && itemInfo.position == this.mCurItem && object.requestFocus(2)); ++n) {
                }
            }
            return;
        }
        try {
            string2 = this.getResources().getResourceName(this.getId());
        }
        catch (Resources.NotFoundException notFoundException) {
            string2 = Integer.toHexString(this.getId());
        }
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + n4 + " Pager id: " + string2 + " Pager class: " + ((Object)((Object)this)).getClass() + " Problematic adapter: " + this.mAdapter.getClass());
    }

    public void removeOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        if (this.mAdapterChangeListeners != null) {
            this.mAdapterChangeListeners.remove(onAdapterChangeListener);
        }
    }

    public void removeOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.mOnPageChangeListeners != null) {
            this.mOnPageChangeListeners.remove(onPageChangeListener);
        }
    }

    public void removeView(View view) {
        if (this.mInLayout) {
            this.removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        Object object;
        int n;
        if (this.mAdapter != null) {
            this.mAdapter.setViewPagerObserver(null);
            this.mAdapter.startUpdate(this);
            for (n = 0; n < this.mItems.size(); ++n) {
                object = this.mItems.get(n);
                this.mAdapter.destroyItem(this, ((ItemInfo)object).position, ((ItemInfo)object).object);
            }
            this.mAdapter.finishUpdate(this);
            this.mItems.clear();
            this.removeNonDecorViews();
            this.mCurItem = 0;
            this.scrollTo(0, 0);
        }
        object = this.mAdapter;
        this.mAdapter = pagerAdapter;
        this.mExpectedAdapterCount = 0;
        if (this.mAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new PagerObserver(this);
            }
            this.mAdapter.setViewPagerObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean bl = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                this.setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (!bl) {
                this.populate();
            } else {
                this.requestLayout();
            }
        }
        if (this.mAdapterChangeListeners != null && !this.mAdapterChangeListeners.isEmpty()) {
            int n2 = this.mAdapterChangeListeners.size();
            for (n = 0; n < n2; ++n) {
                this.mAdapterChangeListeners.get(n).onAdapterChanged(this, (PagerAdapter)object, pagerAdapter);
            }
        }
    }

    public void setCurrentItem(int n) {
        this.mPopulatePending = false;
        this.setCurrentItemInternal(n, this.mFirstLayout ^ true, false);
    }

    public void setCurrentItem(int n, boolean bl) {
        this.mPopulatePending = false;
        this.setCurrentItemInternal(n, bl, false);
    }

    void setCurrentItemInternal(int n, boolean bl, boolean bl2) {
        this.setCurrentItemInternal(n, bl, bl2, 0);
    }

    void setCurrentItemInternal(int n, boolean bl, boolean bl2, int n2) {
        PagerAdapter pagerAdapter = this.mAdapter;
        boolean bl3 = false;
        if (pagerAdapter != null && this.mAdapter.getCount() > 0) {
            int n3;
            if (!bl2 && this.mCurItem == n && this.mItems.size() != 0) {
                this.setScrollingCacheEnabled(false);
                return;
            }
            if (n < 0) {
                n3 = 0;
            } else {
                n3 = n;
                if (n >= this.mAdapter.getCount()) {
                    n3 = this.mAdapter.getCount() - 1;
                }
            }
            n = this.mOffscreenPageLimit;
            if (n3 > this.mCurItem + n || n3 < this.mCurItem - n) {
                for (n = 0; n < this.mItems.size(); ++n) {
                    this.mItems.get((int)n).scrolling = true;
                }
            }
            bl2 = bl3;
            if (this.mCurItem != n3) {
                bl2 = true;
            }
            if (this.mFirstLayout) {
                this.mCurItem = n3;
                if (bl2) {
                    this.dispatchOnPageSelected(n3);
                }
                this.requestLayout();
            } else {
                this.populate(n3);
                this.scrollToItem(n3, bl, n2, bl2);
            }
            return;
        }
        this.setScrollingCacheEnabled(false);
    }

    OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = onPageChangeListener;
        return onPageChangeListener2;
    }

    public void setOffscreenPageLimit(int n) {
        int n2 = n;
        if (n < 1) {
            Log.w((String)TAG, (String)("Requested offscreen page limit " + n + " too small; defaulting to " + 1));
            n2 = 1;
        }
        if (n2 != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = n2;
            this.populate();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setPageMargin(int n) {
        int n2 = this.mPageMargin;
        this.mPageMargin = n;
        int n3 = this.getWidth();
        this.recomputeScrollPosition(n3, n3, n, n2);
        this.requestLayout();
    }

    public void setPageMarginDrawable(int n) {
        this.setPageMarginDrawable(ContextCompat.getDrawable(this.getContext(), n));
    }

    public void setPageMarginDrawable(Drawable drawable2) {
        this.mMarginDrawable = drawable2;
        if (drawable2 != null) {
            this.refreshDrawableState();
        }
        boolean bl = drawable2 == null;
        this.setWillNotDraw(bl);
        this.invalidate();
    }

    public void setPageTransformer(boolean bl, PageTransformer pageTransformer) {
        this.setPageTransformer(bl, pageTransformer, 2);
    }

    public void setPageTransformer(boolean bl, PageTransformer pageTransformer, int n) {
        int n2 = 1;
        boolean bl2 = pageTransformer != null;
        boolean bl3 = this.mPageTransformer != null;
        boolean bl4 = bl2 != bl3;
        this.mPageTransformer = pageTransformer;
        this.setChildrenDrawingOrderEnabled(bl2);
        if (bl2) {
            if (bl) {
                n2 = 2;
            }
            this.mDrawingOrder = n2;
            this.mPageTransformerLayerType = n;
        } else {
            this.mDrawingOrder = 0;
        }
        if (bl4) {
            this.populate();
        }
    }

    void setScrollState(int n) {
        if (this.mScrollState == n) {
            return;
        }
        this.mScrollState = n;
        if (this.mPageTransformer != null) {
            boolean bl = n != 0;
            this.enableLayers(bl);
        }
        this.dispatchOnScrollStateChanged(n);
    }

    void smoothScrollTo(int n, int n2) {
        this.smoothScrollTo(n, n2, 0);
    }

    void smoothScrollTo(int n, int n2, int n3) {
        if (this.getChildCount() == 0) {
            this.setScrollingCacheEnabled(false);
            return;
        }
        int n4 = this.mScroller != null && !this.mScroller.isFinished() ? 1 : 0;
        if (n4 != 0) {
            n4 = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
            this.mScroller.abortAnimation();
            this.setScrollingCacheEnabled(false);
        } else {
            n4 = this.getScrollX();
        }
        int n5 = this.getScrollY();
        int n6 = n - n4;
        if (n6 == 0 && (n2 -= n5) == 0) {
            this.completeScroll(false);
            this.populate();
            this.setScrollState(0);
            return;
        }
        this.setScrollingCacheEnabled(true);
        this.setScrollState(2);
        n = this.getClientWidth();
        int n7 = n / 2;
        float f = Math.min(1.0f, (float)Math.abs(n6) * 1.0f / (float)n);
        float f2 = n7;
        float f3 = n7;
        f = this.distanceInfluenceForSnapDuration(f);
        n3 = Math.abs(n3);
        if (n3 > 0) {
            n = Math.round(Math.abs((f2 + f3 * f) / (float)n3) * 1000.0f) * 4;
        } else {
            f3 = n;
            f2 = this.mAdapter.getPageWidth(this.mCurItem);
            n = (int)((1.0f + (float)Math.abs(n6) / ((float)this.mPageMargin + f3 * f2)) * 100.0f);
        }
        n = Math.min(n, 600);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(n4, n5, n6, n2, n);
        ViewCompat.postInvalidateOnAnimation((View)this);
    }

    protected boolean verifyDrawable(Drawable drawable2) {
        boolean bl = super.verifyDrawable(drawable2) || drawable2 == this.mMarginDrawable;
        return bl;
    }

    @Inherited
    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.TYPE})
    public static @interface DecorView {
    }

    static class ItemInfo {
        Object object;
        float offset;
        int position;
        boolean scrolling;
        float widthFactor;

        ItemInfo() {
        }
    }

    public static class LayoutParams
    extends ViewGroup.LayoutParams {
        int childIndex;
        public int gravity;
        public boolean isDecor;
        boolean needsMeasure;
        int position;
        float widthFactor = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = context.obtainStyledAttributes(attributeSet, LAYOUT_ATTRS);
            this.gravity = context.getInteger(0, 48);
            context.recycle();
        }
    }

    class MyAccessibilityDelegate
    extends AccessibilityDelegateCompat {
        final ViewPager this$0;

        MyAccessibilityDelegate(ViewPager viewPager) {
            this.this$0 = viewPager;
        }

        private boolean canScroll() {
            boolean bl;
            block3: {
                block2: {
                    if (this.this$0.mAdapter == null) break block2;
                    int n = this.this$0.mAdapter.getCount();
                    bl = true;
                    if (n > 1) break block3;
                }
                bl = false;
            }
            return bl;
        }

        @Override
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName((CharSequence)ViewPager.class.getName());
            accessibilityEvent.setScrollable(this.canScroll());
            if (accessibilityEvent.getEventType() == 4096 && this.this$0.mAdapter != null) {
                accessibilityEvent.setItemCount(this.this$0.mAdapter.getCount());
                accessibilityEvent.setFromIndex(this.this$0.mCurItem);
                accessibilityEvent.setToIndex(this.this$0.mCurItem);
            }
        }

        @Override
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
            accessibilityNodeInfoCompat.setScrollable(this.canScroll());
            if (this.this$0.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (this.this$0.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
            }
        }

        @Override
        public boolean performAccessibilityAction(View view, int n, Bundle bundle) {
            if (super.performAccessibilityAction(view, n, bundle)) {
                return true;
            }
            switch (n) {
                default: {
                    return false;
                }
                case 8192: {
                    if (this.this$0.canScrollHorizontally(-1)) {
                        this.this$0.setCurrentItem(this.this$0.mCurItem - 1);
                        return true;
                    }
                    return false;
                }
                case 4096: 
            }
            if (this.this$0.canScrollHorizontally(1)) {
                this.this$0.setCurrentItem(this.this$0.mCurItem + 1);
                return true;
            }
            return false;
        }
    }

    public static interface OnAdapterChangeListener {
        public void onAdapterChanged(ViewPager var1, PagerAdapter var2, PagerAdapter var3);
    }

    public static interface OnPageChangeListener {
        public void onPageScrollStateChanged(int var1);

        public void onPageScrolled(int var1, float var2, int var3);

        public void onPageSelected(int var1);
    }

    public static interface PageTransformer {
        public void transformPage(View var1, float var2);
    }

    private class PagerObserver
    extends DataSetObserver {
        final ViewPager this$0;

        PagerObserver(ViewPager viewPager) {
            this.this$0 = viewPager;
        }

        public void onChanged() {
            this.this$0.dataSetChanged();
        }

        public void onInvalidated() {
            this.this$0.dataSetChanged();
        }
    }

    public static class SavedState
    extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>(){

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState[] newArray(int n) {
                return new SavedState[n];
            }
        };
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            ClassLoader classLoader2 = classLoader;
            if (classLoader == null) {
                classLoader2 = this.getClass().getClassLoader();
            }
            this.position = parcel.readInt();
            this.adapterState = parcel.readParcelable(classLoader2);
            this.loader = classLoader2;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        @Override
        public void writeToParcel(Parcel parcel, int n) {
            super.writeToParcel(parcel, n);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.adapterState, n);
        }
    }

    public static class SimpleOnPageChangeListener
    implements OnPageChangeListener {
        @Override
        public void onPageScrollStateChanged(int n) {
        }

        @Override
        public void onPageScrolled(int n, float f, int n2) {
        }

        @Override
        public void onPageSelected(int n) {
        }
    }

    static class ViewPositionComparator
    implements Comparator<View> {
        ViewPositionComparator() {
        }

        @Override
        public int compare(View object, View object2) {
            object = (LayoutParams)object.getLayoutParams();
            object2 = (LayoutParams)object2.getLayoutParams();
            if (object.isDecor != object2.isDecor) {
                int n = object.isDecor ? 1 : -1;
                return n;
            }
            return object.position - object2.position;
        }
    }
}

