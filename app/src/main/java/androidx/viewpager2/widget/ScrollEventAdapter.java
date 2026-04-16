/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 */
package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.AnimateLayoutChangeDetector;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

final class ScrollEventAdapter
extends RecyclerView.OnScrollListener {
    private static final int NO_POSITION = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_IN_PROGRESS_FAKE_DRAG = 4;
    private static final int STATE_IN_PROGRESS_IMMEDIATE_SCROLL = 3;
    private static final int STATE_IN_PROGRESS_MANUAL_DRAG = 1;
    private static final int STATE_IN_PROGRESS_SMOOTH_SCROLL = 2;
    private int mAdapterState;
    private ViewPager2.OnPageChangeCallback mCallback;
    private boolean mDataSetChangeHappened;
    private boolean mDispatchSelected;
    private int mDragStartPosition;
    private boolean mFakeDragging;
    private final LinearLayoutManager mLayoutManager;
    private final RecyclerView mRecyclerView;
    private boolean mScrollHappened;
    private int mScrollState;
    private ScrollEventValues mScrollValues;
    private int mTarget;
    private final ViewPager2 mViewPager;

    ScrollEventAdapter(ViewPager2 viewPager2) {
        this.mViewPager = viewPager2;
        this.mRecyclerView = this.mViewPager.mRecyclerView;
        this.mLayoutManager = (LinearLayoutManager)this.mRecyclerView.getLayoutManager();
        this.mScrollValues = new ScrollEventValues();
        this.resetState();
    }

    private void dispatchScrolled(int n, float f, int n2) {
        if (this.mCallback != null) {
            this.mCallback.onPageScrolled(n, f, n2);
        }
    }

    private void dispatchSelected(int n) {
        if (this.mCallback != null) {
            this.mCallback.onPageSelected(n);
        }
    }

    private void dispatchStateChanged(int n) {
        if (this.mAdapterState == 3 && this.mScrollState == 0) {
            return;
        }
        if (this.mScrollState == n) {
            return;
        }
        this.mScrollState = n;
        if (this.mCallback != null) {
            this.mCallback.onPageScrollStateChanged(n);
        }
    }

    private int getPosition() {
        return this.mLayoutManager.findFirstVisibleItemPosition();
    }

    private boolean isInAnyDraggingState() {
        boolean bl;
        int n = this.mAdapterState;
        boolean bl2 = bl = true;
        if (n != 1) {
            bl2 = this.mAdapterState == 4 ? bl : false;
        }
        return bl2;
    }

    private void resetState() {
        this.mAdapterState = 0;
        this.mScrollState = 0;
        this.mScrollValues.reset();
        this.mDragStartPosition = -1;
        this.mTarget = -1;
        this.mDispatchSelected = false;
        this.mScrollHappened = false;
        this.mFakeDragging = false;
        this.mDataSetChangeHappened = false;
    }

    private void startDrag(boolean bl) {
        this.mFakeDragging = bl;
        int n = bl ? 4 : 1;
        this.mAdapterState = n;
        if (this.mTarget != -1) {
            this.mDragStartPosition = this.mTarget;
            this.mTarget = -1;
        } else if (this.mDragStartPosition == -1) {
            this.mDragStartPosition = this.getPosition();
        }
        this.dispatchStateChanged(1);
    }

    private void updateScrollEventValues() {
        ScrollEventValues scrollEventValues = this.mScrollValues;
        scrollEventValues.mPosition = this.mLayoutManager.findFirstVisibleItemPosition();
        if (scrollEventValues.mPosition == -1) {
            scrollEventValues.reset();
            return;
        }
        View view = this.mLayoutManager.findViewByPosition(scrollEventValues.mPosition);
        if (view == null) {
            scrollEventValues.reset();
            return;
        }
        int n = this.mLayoutManager.getLeftDecorationWidth(view);
        int n2 = this.mLayoutManager.getRightDecorationWidth(view);
        int n3 = this.mLayoutManager.getTopDecorationHeight(view);
        int n4 = this.mLayoutManager.getBottomDecorationHeight(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int n5 = n;
        int n6 = n2;
        int n7 = n3;
        int n8 = n4;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            layoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
            n5 = n + layoutParams.leftMargin;
            n6 = n2 + layoutParams.rightMargin;
            n7 = n3 + layoutParams.topMargin;
            n8 = n4 + layoutParams.bottomMargin;
        }
        n3 = view.getHeight();
        n2 = view.getWidth();
        n4 = this.mLayoutManager.getOrientation() == 0 ? 1 : 0;
        if (n4 != 0) {
            n6 = n2 + n5 + n6;
            n5 = view.getLeft() - n5 - this.mRecyclerView.getPaddingLeft();
            n7 = n6;
            n8 = n5;
            if (this.mViewPager.isRtl()) {
                n8 = -n5;
                n7 = n6;
            }
        } else {
            n6 = n3 + n7 + n8;
            n8 = view.getTop() - n7 - this.mRecyclerView.getPaddingTop();
            n7 = n6;
        }
        scrollEventValues.mOffsetPx = -n8;
        if (scrollEventValues.mOffsetPx < 0) {
            if (new AnimateLayoutChangeDetector(this.mLayoutManager).mayHaveInterferingAnimations()) {
                throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
            }
            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", scrollEventValues.mOffsetPx));
        }
        float f = n7 == 0 ? 0.0f : (float)scrollEventValues.mOffsetPx / (float)n7;
        scrollEventValues.mOffset = f;
    }

    double getRelativeScrollPosition() {
        this.updateScrollEventValues();
        return (double)this.mScrollValues.mPosition + (double)this.mScrollValues.mOffset;
    }

    int getScrollState() {
        return this.mScrollState;
    }

    boolean isDragging() {
        int n = this.mScrollState;
        boolean bl = true;
        if (n != 1) {
            bl = false;
        }
        return bl;
    }

    boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    boolean isIdle() {
        boolean bl = this.mScrollState == 0;
        return bl;
    }

    void notifyBeginFakeDrag() {
        this.mAdapterState = 4;
        this.startDrag(true);
    }

    void notifyDataSetChangeHappened() {
        this.mDataSetChangeHappened = true;
    }

    void notifyEndFakeDrag() {
        if (this.isDragging() && !this.mFakeDragging) {
            return;
        }
        this.mFakeDragging = false;
        this.updateScrollEventValues();
        if (this.mScrollValues.mOffsetPx == 0) {
            if (this.mScrollValues.mPosition != this.mDragStartPosition) {
                this.dispatchSelected(this.mScrollValues.mPosition);
            }
            this.dispatchStateChanged(0);
            this.resetState();
        } else {
            this.dispatchStateChanged(2);
        }
    }

    void notifyProgrammaticScroll(int n, boolean bl) {
        int n2 = bl ? 2 : 3;
        this.mAdapterState = n2;
        n2 = 0;
        this.mFakeDragging = false;
        if (this.mTarget != n) {
            n2 = 1;
        }
        this.mTarget = n;
        this.dispatchStateChanged(2);
        if (n2 != 0) {
            this.dispatchSelected(n);
        }
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int n) {
        if ((this.mAdapterState != 1 || this.mScrollState != 1) && n == 1) {
            this.startDrag(false);
            return;
        }
        if (this.isInAnyDraggingState() && n == 2) {
            if (this.mScrollHappened) {
                this.dispatchStateChanged(2);
                this.mDispatchSelected = true;
            }
            return;
        }
        if (this.isInAnyDraggingState() && n == 0) {
            boolean bl = false;
            this.updateScrollEventValues();
            if (!this.mScrollHappened) {
                if (this.mScrollValues.mPosition != -1) {
                    this.dispatchScrolled(this.mScrollValues.mPosition, 0.0f, 0);
                }
                bl = true;
            } else if (this.mScrollValues.mOffsetPx == 0) {
                boolean bl2;
                bl = bl2 = true;
                if (this.mDragStartPosition != this.mScrollValues.mPosition) {
                    this.dispatchSelected(this.mScrollValues.mPosition);
                    bl = bl2;
                }
            }
            if (bl) {
                this.dispatchStateChanged(0);
                this.resetState();
            }
        }
        if (this.mAdapterState == 2 && n == 0 && this.mDataSetChangeHappened) {
            this.updateScrollEventValues();
            if (this.mScrollValues.mOffsetPx == 0) {
                if (this.mTarget != this.mScrollValues.mPosition) {
                    n = this.mScrollValues.mPosition == -1 ? 0 : this.mScrollValues.mPosition;
                    this.dispatchSelected(n);
                }
                this.dispatchStateChanged(0);
                this.resetState();
            }
        }
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int n, int n2) {
        this.mScrollHappened = true;
        this.updateScrollEventValues();
        if (this.mDispatchSelected) {
            boolean bl;
            this.mDispatchSelected = false;
            n = n2 <= 0 && (n2 != 0 || (bl = n < 0) != this.mViewPager.isRtl()) ? 0 : 1;
            n = n != 0 && this.mScrollValues.mOffsetPx != 0 ? this.mScrollValues.mPosition + 1 : this.mScrollValues.mPosition;
            this.mTarget = n;
            if (this.mDragStartPosition != this.mTarget) {
                this.dispatchSelected(this.mTarget);
            }
        } else if (this.mAdapterState == 0) {
            n = this.mScrollValues.mPosition;
            if (n == -1) {
                n = 0;
            }
            this.dispatchSelected(n);
        }
        n = this.mScrollValues.mPosition == -1 ? 0 : this.mScrollValues.mPosition;
        this.dispatchScrolled(n, this.mScrollValues.mOffset, this.mScrollValues.mOffsetPx);
        if ((this.mScrollValues.mPosition == this.mTarget || this.mTarget == -1) && this.mScrollValues.mOffsetPx == 0 && this.mScrollState != 1) {
            this.dispatchStateChanged(0);
            this.resetState();
        }
    }

    void setOnPageChangeCallback(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.mCallback = onPageChangeCallback;
    }

    private static final class ScrollEventValues {
        float mOffset;
        int mOffsetPx;
        int mPosition;

        ScrollEventValues() {
        }

        void reset() {
            this.mPosition = -1;
            this.mOffset = 0.0f;
            this.mOffsetPx = 0;
        }
    }
}

