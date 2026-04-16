/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.PointF
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.View
 *  android.view.accessibility.AccessibilityEvent
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ScrollbarHelper;
import java.util.List;

public class LinearLayoutManager
extends RecyclerView.LayoutManager
implements ItemTouchHelper.ViewDropHandler,
RecyclerView.SmoothScroller.ScrollVectorProvider {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final AnchorInfo mAnchorInfo;
    private int mInitialPrefetchItemCount = 2;
    private boolean mLastStackFromEnd;
    private final LayoutChunkResult mLayoutChunkResult;
    private LayoutState mLayoutState;
    int mOrientation = 1;
    OrientationHelper mOrientationHelper;
    SavedState mPendingSavedState = null;
    int mPendingScrollPosition = -1;
    int mPendingScrollPositionOffset = Integer.MIN_VALUE;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout = false;
    boolean mShouldReverseLayout = false;
    private boolean mSmoothScrollbarEnabled = true;
    private boolean mStackFromEnd = false;

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int n, boolean bl) {
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mReusableIntPair = new int[2];
        this.setOrientation(n);
        this.setReverseLayout(bl);
    }

    public LinearLayoutManager(Context object, AttributeSet attributeSet, int n, int n2) {
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mReusableIntPair = new int[2];
        object = LinearLayoutManager.getProperties(object, attributeSet, n, n2);
        this.setOrientation(object.orientation);
        this.setReverseLayout(object.reverseLayout);
        this.setStackFromEnd(object.stackFromEnd);
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (this.getChildCount() == 0) {
            return 0;
        }
        this.ensureLayoutState();
        return ScrollbarHelper.computeScrollExtent(state, this.mOrientationHelper, this.findFirstVisibleChildClosestToStart(this.mSmoothScrollbarEnabled ^ true, true), this.findFirstVisibleChildClosestToEnd(this.mSmoothScrollbarEnabled ^ true, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (this.getChildCount() == 0) {
            return 0;
        }
        this.ensureLayoutState();
        return ScrollbarHelper.computeScrollOffset(state, this.mOrientationHelper, this.findFirstVisibleChildClosestToStart(this.mSmoothScrollbarEnabled ^ true, true), this.findFirstVisibleChildClosestToEnd(this.mSmoothScrollbarEnabled ^ true, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (this.getChildCount() == 0) {
            return 0;
        }
        this.ensureLayoutState();
        return ScrollbarHelper.computeScrollRange(state, this.mOrientationHelper, this.findFirstVisibleChildClosestToStart(this.mSmoothScrollbarEnabled ^ true, true), this.findFirstVisibleChildClosestToEnd(this.mSmoothScrollbarEnabled ^ true, true), this, this.mSmoothScrollbarEnabled);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return this.findOnePartiallyOrCompletelyInvisibleChild(0, this.getChildCount());
    }

    private View findFirstReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.findReferenceChild(recycler, state, 0, this.getChildCount(), state.getItemCount());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return this.findOnePartiallyOrCompletelyInvisibleChild(this.getChildCount() - 1, -1);
    }

    private View findLastReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.findReferenceChild(recycler, state, this.getChildCount() - 1, -1, state.getItemCount());
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        View view = this.mShouldReverseLayout ? this.findFirstPartiallyOrCompletelyInvisibleChild() : this.findLastPartiallyOrCompletelyInvisibleChild();
        return view;
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        View view = this.mShouldReverseLayout ? this.findLastPartiallyOrCompletelyInvisibleChild() : this.findFirstPartiallyOrCompletelyInvisibleChild();
        return view;
    }

    private View findReferenceChildClosestToEnd(RecyclerView.Recycler recycler, RecyclerView.State state) {
        recycler = this.mShouldReverseLayout ? this.findFirstReferenceChild(recycler, state) : this.findLastReferenceChild(recycler, state);
        return recycler;
    }

    private View findReferenceChildClosestToStart(RecyclerView.Recycler recycler, RecyclerView.State state) {
        recycler = this.mShouldReverseLayout ? this.findLastReferenceChild(recycler, state) : this.findFirstReferenceChild(recycler, state);
        return recycler;
    }

    private int fixLayoutEndGap(int n, RecyclerView.Recycler recycler, RecyclerView.State state, boolean bl) {
        int n2 = this.mOrientationHelper.getEndAfterPadding() - n;
        if (n2 > 0) {
            n2 = -this.scrollBy(-n2, recycler, state);
            if (bl && (n = this.mOrientationHelper.getEndAfterPadding() - (n + n2)) > 0) {
                this.mOrientationHelper.offsetChildren(n);
                return n + n2;
            }
            return n2;
        }
        return 0;
    }

    private int fixLayoutStartGap(int n, RecyclerView.Recycler recycler, RecyclerView.State state, boolean bl) {
        int n2 = n - this.mOrientationHelper.getStartAfterPadding();
        if (n2 > 0) {
            n2 = -this.scrollBy(n2, recycler, state);
            if (bl && (n = n + n2 - this.mOrientationHelper.getStartAfterPadding()) > 0) {
                this.mOrientationHelper.offsetChildren(-n);
                return n2 - n;
            }
            return n2;
        }
        return 0;
    }

    private View getChildClosestToEnd() {
        int n = this.mShouldReverseLayout ? 0 : this.getChildCount() - 1;
        return this.getChildAt(n);
    }

    private View getChildClosestToStart() {
        int n = this.mShouldReverseLayout ? this.getChildCount() - 1 : 0;
        return this.getChildAt(n);
    }

    private void layoutForPredictiveAnimations(RecyclerView.Recycler recycler, RecyclerView.State state, int n, int n2) {
        if (state.willRunPredictiveAnimations() && this.getChildCount() != 0 && !state.isPreLayout() && this.supportsPredictiveItemAnimations()) {
            int n3 = 0;
            int n4 = 0;
            List<RecyclerView.ViewHolder> list = recycler.getScrapList();
            int n5 = list.size();
            int n6 = this.getPosition(this.getChildAt(0));
            for (int i = 0; i < n5; ++i) {
                RecyclerView.ViewHolder viewHolder = list.get(i);
                if (viewHolder.isRemoved()) continue;
                int n7 = viewHolder.getLayoutPosition();
                int n8 = 1;
                boolean bl = n7 < n6;
                if (bl != this.mShouldReverseLayout) {
                    n8 = -1;
                }
                if (n8 == -1) {
                    n3 += this.mOrientationHelper.getDecoratedMeasurement(viewHolder.itemView);
                    continue;
                }
                n4 += this.mOrientationHelper.getDecoratedMeasurement(viewHolder.itemView);
            }
            this.mLayoutState.mScrapList = list;
            if (n3 > 0) {
                this.updateLayoutStateToFillStart(this.getPosition(this.getChildClosestToStart()), n);
                this.mLayoutState.mExtraFillSpace = n3;
                this.mLayoutState.mAvailable = 0;
                this.mLayoutState.assignPositionFromScrapList();
                this.fill(recycler, this.mLayoutState, state, false);
            }
            if (n4 > 0) {
                this.updateLayoutStateToFillEnd(this.getPosition(this.getChildClosestToEnd()), n2);
                this.mLayoutState.mExtraFillSpace = n4;
                this.mLayoutState.mAvailable = 0;
                this.mLayoutState.assignPositionFromScrapList();
                this.fill(recycler, this.mLayoutState, state, false);
            }
            this.mLayoutState.mScrapList = null;
            return;
        }
    }

    private void logChildren() {
        Log.d((String)TAG, (String)"internal representation of views on the screen");
        for (int i = 0; i < this.getChildCount(); ++i) {
            View view = this.getChildAt(i);
            Log.d((String)TAG, (String)("item " + this.getPosition(view) + ", coord:" + this.mOrientationHelper.getDecoratedStart(view)));
        }
        Log.d((String)TAG, (String)"==============");
    }

    private void recycleByLayoutState(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (layoutState.mRecycle && !layoutState.mInfinite) {
            int n = layoutState.mScrollingOffset;
            int n2 = layoutState.mNoRecycleSpace;
            if (layoutState.mLayoutDirection == -1) {
                this.recycleViewsFromEnd(recycler, n, n2);
            } else {
                this.recycleViewsFromStart(recycler, n, n2);
            }
            return;
        }
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int n, int n2) {
        if (n == n2) {
            return;
        }
        if (n2 > n) {
            --n2;
            while (n2 >= n) {
                this.removeAndRecycleViewAt(n2, recycler);
                --n2;
            }
        } else {
            while (n > n2) {
                this.removeAndRecycleViewAt(n, recycler);
                --n;
            }
        }
    }

    private void recycleViewsFromEnd(RecyclerView.Recycler recycler, int n, int n2) {
        int n3 = this.getChildCount();
        if (n < 0) {
            return;
        }
        n2 = this.mOrientationHelper.getEnd() - n + n2;
        if (this.mShouldReverseLayout) {
            for (n = 0; n < n3; ++n) {
                View view = this.getChildAt(n);
                if (this.mOrientationHelper.getDecoratedStart(view) >= n2 && this.mOrientationHelper.getTransformedStartWithDecoration(view) >= n2) {
                    continue;
                }
                this.recycleChildren(recycler, 0, n);
                return;
            }
        } else {
            for (n = n3 - 1; n >= 0; --n) {
                View view = this.getChildAt(n);
                if (this.mOrientationHelper.getDecoratedStart(view) >= n2 && this.mOrientationHelper.getTransformedStartWithDecoration(view) >= n2) {
                    continue;
                }
                this.recycleChildren(recycler, n3 - 1, n);
                return;
            }
        }
    }

    private void recycleViewsFromStart(RecyclerView.Recycler recycler, int n, int n2) {
        if (n < 0) {
            return;
        }
        n2 = n - n2;
        int n3 = this.getChildCount();
        if (this.mShouldReverseLayout) {
            for (n = n3 - 1; n >= 0; --n) {
                View view = this.getChildAt(n);
                if (this.mOrientationHelper.getDecoratedEnd(view) <= n2 && this.mOrientationHelper.getTransformedEndWithDecoration(view) <= n2) {
                    continue;
                }
                this.recycleChildren(recycler, n3 - 1, n);
                return;
            }
        } else {
            for (n = 0; n < n3; ++n) {
                View view = this.getChildAt(n);
                if (this.mOrientationHelper.getDecoratedEnd(view) <= n2 && this.mOrientationHelper.getTransformedEndWithDecoration(view) <= n2) {
                    continue;
                }
                this.recycleChildren(recycler, 0, n);
                return;
            }
        }
    }

    private void resolveShouldLayoutReverse() {
        this.mShouldReverseLayout = this.mOrientation != 1 && this.isLayoutRTL() ? this.mReverseLayout ^ true : this.mReverseLayout;
    }

    private boolean updateAnchorFromChildren(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        int n = this.getChildCount();
        int n2 = 0;
        if (n == 0) {
            return false;
        }
        View view = this.getFocusedChild();
        if (view != null && anchorInfo.isViewValidAsAnchor(view, state)) {
            anchorInfo.assignFromViewAndKeepVisibleRect(view, this.getPosition(view));
            return true;
        }
        if (this.mLastStackFromEnd != this.mStackFromEnd) {
            return false;
        }
        recycler = anchorInfo.mLayoutFromEnd ? this.findReferenceChildClosestToEnd(recycler, state) : this.findReferenceChildClosestToStart(recycler, state);
        if (recycler != null) {
            anchorInfo.assignFromView((View)recycler, this.getPosition((View)recycler));
            if (!state.isPreLayout() && this.supportsPredictiveItemAnimations()) {
                if (this.mOrientationHelper.getDecoratedStart((View)recycler) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd((View)recycler) < this.mOrientationHelper.getStartAfterPadding()) {
                    n2 = 1;
                }
                if (n2 != 0) {
                    n2 = anchorInfo.mLayoutFromEnd ? this.mOrientationHelper.getEndAfterPadding() : this.mOrientationHelper.getStartAfterPadding();
                    anchorInfo.mCoordinate = n2;
                }
            }
            return true;
        }
        return false;
    }

    private boolean updateAnchorFromPendingData(RecyclerView.State state, AnchorInfo anchorInfo) {
        boolean bl = state.isPreLayout();
        boolean bl2 = false;
        if (!bl && this.mPendingScrollPosition != -1) {
            if (this.mPendingScrollPosition >= 0 && this.mPendingScrollPosition < state.getItemCount()) {
                anchorInfo.mPosition = this.mPendingScrollPosition;
                if (this.mPendingSavedState != null && this.mPendingSavedState.hasValidAnchor()) {
                    anchorInfo.mLayoutFromEnd = this.mPendingSavedState.mAnchorLayoutFromEnd;
                    anchorInfo.mCoordinate = anchorInfo.mLayoutFromEnd ? this.mOrientationHelper.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset : this.mOrientationHelper.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset;
                    return true;
                }
                if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    state = this.findViewByPosition(this.mPendingScrollPosition);
                    if (state != null) {
                        if (this.mOrientationHelper.getDecoratedMeasurement((View)state) > this.mOrientationHelper.getTotalSpace()) {
                            anchorInfo.assignCoordinateFromPadding();
                            return true;
                        }
                        if (this.mOrientationHelper.getDecoratedStart((View)state) - this.mOrientationHelper.getStartAfterPadding() < 0) {
                            anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding();
                            anchorInfo.mLayoutFromEnd = false;
                            return true;
                        }
                        if (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd((View)state) < 0) {
                            anchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
                            anchorInfo.mLayoutFromEnd = true;
                            return true;
                        }
                        int n = anchorInfo.mLayoutFromEnd ? this.mOrientationHelper.getDecoratedEnd((View)state) + this.mOrientationHelper.getTotalSpaceChange() : this.mOrientationHelper.getDecoratedStart((View)state);
                        anchorInfo.mCoordinate = n;
                    } else {
                        if (this.getChildCount() > 0) {
                            int n = this.getPosition(this.getChildAt(0));
                            bl = this.mPendingScrollPosition < n;
                            if (bl == this.mShouldReverseLayout) {
                                bl2 = true;
                            }
                            anchorInfo.mLayoutFromEnd = bl2;
                        }
                        anchorInfo.assignCoordinateFromPadding();
                    }
                    return true;
                }
                anchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
                anchorInfo.mCoordinate = this.mShouldReverseLayout ? this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset : this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                return true;
            }
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            return false;
        }
        return false;
    }

    private void updateAnchorInfoForLayout(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        if (this.updateAnchorFromPendingData(state, anchorInfo)) {
            return;
        }
        if (this.updateAnchorFromChildren(recycler, state, anchorInfo)) {
            return;
        }
        anchorInfo.assignCoordinateFromPadding();
        int n = this.mStackFromEnd ? state.getItemCount() - 1 : 0;
        anchorInfo.mPosition = n;
    }

    private void updateLayoutState(int n, int n2, boolean bl, RecyclerView.State object) {
        this.mLayoutState.mInfinite = this.resolveIsInfinite();
        this.mLayoutState.mLayoutDirection = n;
        Object object2 = this.mReusableIntPair;
        boolean bl2 = false;
        object2[0] = 0;
        object2 = this.mReusableIntPair;
        int n3 = 1;
        int n4 = 1;
        object2[1] = 0;
        this.calculateExtraLayoutSpace((RecyclerView.State)object, this.mReusableIntPair);
        int n5 = Math.max(0, this.mReusableIntPair[0]);
        int n6 = Math.max(0, this.mReusableIntPair[1]);
        if (n == 1) {
            bl2 = true;
        }
        object = this.mLayoutState;
        n = bl2 ? n6 : n5;
        ((LayoutState)object).mExtraFillSpace = n;
        object = this.mLayoutState;
        if (bl2) {
            n6 = n5;
        }
        ((LayoutState)object).mNoRecycleSpace = n6;
        if (bl2) {
            object = this.mLayoutState;
            ((LayoutState)object).mExtraFillSpace += this.mOrientationHelper.getEndPadding();
            object2 = this.getChildClosestToEnd();
            object = this.mLayoutState;
            n = n4;
            if (this.mShouldReverseLayout) {
                n = -1;
            }
            ((LayoutState)object).mItemDirection = n;
            this.mLayoutState.mCurrentPosition = this.getPosition((View)object2) + this.mLayoutState.mItemDirection;
            this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedEnd((View)object2);
            n = this.mOrientationHelper.getDecoratedEnd((View)object2) - this.mOrientationHelper.getEndAfterPadding();
        } else {
            object = this.getChildClosestToStart();
            object2 = this.mLayoutState;
            object2.mExtraFillSpace += this.mOrientationHelper.getStartAfterPadding();
            object2 = this.mLayoutState;
            n = this.mShouldReverseLayout ? n3 : -1;
            object2.mItemDirection = n;
            this.mLayoutState.mCurrentPosition = this.getPosition((View)object) + this.mLayoutState.mItemDirection;
            this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedStart((View)object);
            n = -this.mOrientationHelper.getDecoratedStart((View)object) + this.mOrientationHelper.getStartAfterPadding();
        }
        this.mLayoutState.mAvailable = n2;
        if (bl) {
            object = this.mLayoutState;
            ((LayoutState)object).mAvailable -= n;
        }
        this.mLayoutState.mScrollingOffset = n;
    }

    private void updateLayoutStateToFillEnd(int n, int n2) {
        this.mLayoutState.mAvailable = this.mOrientationHelper.getEndAfterPadding() - n2;
        LayoutState layoutState = this.mLayoutState;
        int n3 = this.mShouldReverseLayout ? -1 : 1;
        layoutState.mItemDirection = n3;
        this.mLayoutState.mCurrentPosition = n;
        this.mLayoutState.mLayoutDirection = 1;
        this.mLayoutState.mOffset = n2;
        this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillEnd(AnchorInfo anchorInfo) {
        this.updateLayoutStateToFillEnd(anchorInfo.mPosition, anchorInfo.mCoordinate);
    }

    private void updateLayoutStateToFillStart(int n, int n2) {
        this.mLayoutState.mAvailable = n2 - this.mOrientationHelper.getStartAfterPadding();
        this.mLayoutState.mCurrentPosition = n;
        LayoutState layoutState = this.mLayoutState;
        n = this.mShouldReverseLayout ? 1 : -1;
        layoutState.mItemDirection = n;
        this.mLayoutState.mLayoutDirection = -1;
        this.mLayoutState.mOffset = n2;
        this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(AnchorInfo anchorInfo) {
        this.updateLayoutStateToFillStart(anchorInfo.mPosition, anchorInfo.mCoordinate);
    }

    @Override
    public void assertNotInLayoutOrScroll(String string2) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(string2);
        }
    }

    protected void calculateExtraLayoutSpace(RecyclerView.State state, int[] nArray) {
        int n = 0;
        int n2 = 0;
        int n3 = this.getExtraLayoutSpace(state);
        if (this.mLayoutState.mLayoutDirection == -1) {
            n = n3;
            n3 = n2;
        }
        nArray[0] = n;
        nArray[1] = n3;
    }

    @Override
    public boolean canScrollHorizontally() {
        boolean bl = this.mOrientation == 0;
        return bl;
    }

    @Override
    public boolean canScrollVertically() {
        int n = this.mOrientation;
        boolean bl = true;
        if (n != 1) {
            bl = false;
        }
        return bl;
    }

    @Override
    public void collectAdjacentPrefetchPositions(int n, int n2, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        if (this.mOrientation != 0) {
            n = n2;
        }
        if (this.getChildCount() != 0 && n != 0) {
            this.ensureLayoutState();
            n2 = n > 0 ? 1 : -1;
            this.updateLayoutState(n2, Math.abs(n), true, state);
            this.collectPrefetchPositionsForLayoutState(state, this.mLayoutState, layoutPrefetchRegistry);
            return;
        }
    }

    @Override
    public void collectInitialPrefetchPositions(int n, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int n2;
        boolean bl;
        SavedState savedState = this.mPendingSavedState;
        int n3 = -1;
        if (savedState != null && this.mPendingSavedState.hasValidAnchor()) {
            bl = this.mPendingSavedState.mAnchorLayoutFromEnd;
            n2 = this.mPendingSavedState.mAnchorPosition;
        } else {
            this.resolveShouldLayoutReverse();
            bl = this.mShouldReverseLayout;
            n2 = this.mPendingScrollPosition == -1 ? (bl ? n - 1 : 0) : this.mPendingScrollPosition;
        }
        if (!bl) {
            n3 = 1;
        }
        int n4 = n2;
        for (n2 = 0; n2 < this.mInitialPrefetchItemCount && n4 >= 0 && n4 < n; n4 += n3, ++n2) {
            layoutPrefetchRegistry.addPosition(n4, 0);
        }
    }

    void collectPrefetchPositionsForLayoutState(RecyclerView.State state, LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int n = layoutState.mCurrentPosition;
        if (n >= 0 && n < state.getItemCount()) {
            layoutPrefetchRegistry.addPosition(n, Math.max(0, layoutState.mScrollingOffset));
        }
    }

    @Override
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return this.computeScrollExtent(state);
    }

    @Override
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return this.computeScrollOffset(state);
    }

    @Override
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return this.computeScrollRange(state);
    }

    @Override
    public PointF computeScrollVectorForPosition(int n) {
        if (this.getChildCount() == 0) {
            return null;
        }
        boolean bl = false;
        int n2 = this.getPosition(this.getChildAt(0));
        int n3 = 1;
        if (n < n2) {
            bl = true;
        }
        n = n3;
        if (bl != this.mShouldReverseLayout) {
            n = -1;
        }
        if (this.mOrientation == 0) {
            return new PointF((float)n, 0.0f);
        }
        return new PointF(0.0f, (float)n);
    }

    @Override
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return this.computeScrollExtent(state);
    }

    @Override
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return this.computeScrollOffset(state);
    }

    @Override
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return this.computeScrollRange(state);
    }

    int convertFocusDirectionToLayoutDirection(int n) {
        int n2 = -1;
        int n3 = Integer.MIN_VALUE;
        switch (n) {
            default: {
                return Integer.MIN_VALUE;
            }
            case 130: {
                if (this.mOrientation == 1) {
                    n3 = 1;
                }
                return n3;
            }
            case 66: {
                if (this.mOrientation == 0) {
                    n3 = 1;
                }
                return n3;
            }
            case 33: {
                if (this.mOrientation != 1) {
                    n2 = Integer.MIN_VALUE;
                }
                return n2;
            }
            case 17: {
                if (this.mOrientation != 0) {
                    n2 = Integer.MIN_VALUE;
                }
                return n2;
            }
            case 2: {
                if (this.mOrientation == 1) {
                    return 1;
                }
                if (this.isLayoutRTL()) {
                    return -1;
                }
                return 1;
            }
            case 1: 
        }
        if (this.mOrientation == 1) {
            return -1;
        }
        if (this.isLayoutRTL()) {
            return 1;
        }
        return -1;
    }

    LayoutState createLayoutState() {
        return new LayoutState();
    }

    void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = this.createLayoutState();
        }
    }

    int fill(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state, boolean bl) {
        int n = layoutState.mAvailable;
        if (layoutState.mScrollingOffset != Integer.MIN_VALUE) {
            if (layoutState.mAvailable < 0) {
                layoutState.mScrollingOffset += layoutState.mAvailable;
            }
            this.recycleByLayoutState(recycler, layoutState);
        }
        int n2 = layoutState.mAvailable + layoutState.mExtraFillSpace;
        LayoutChunkResult layoutChunkResult = this.mLayoutChunkResult;
        while ((layoutState.mInfinite || n2 > 0) && layoutState.hasMore(state)) {
            int n3;
            block9: {
                block8: {
                    layoutChunkResult.resetInternal();
                    this.layoutChunk(recycler, state, layoutState, layoutChunkResult);
                    if (layoutChunkResult.mFinished) break;
                    layoutState.mOffset += layoutChunkResult.mConsumed * layoutState.mLayoutDirection;
                    if (!layoutChunkResult.mIgnoreConsumed || layoutState.mScrapList != null) break block8;
                    n3 = n2;
                    if (state.isPreLayout()) break block9;
                }
                layoutState.mAvailable -= layoutChunkResult.mConsumed;
                n3 = n2 - layoutChunkResult.mConsumed;
            }
            if (layoutState.mScrollingOffset != Integer.MIN_VALUE) {
                layoutState.mScrollingOffset += layoutChunkResult.mConsumed;
                if (layoutState.mAvailable < 0) {
                    layoutState.mScrollingOffset += layoutState.mAvailable;
                }
                this.recycleByLayoutState(recycler, layoutState);
            }
            n2 = n3;
            if (!bl) continue;
            n2 = n3;
            if (!layoutChunkResult.mFocusable) continue;
        }
        return n - layoutState.mAvailable;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View view = this.findOneVisibleChild(0, this.getChildCount(), true, false);
        int n = view == null ? -1 : this.getPosition(view);
        return n;
    }

    View findFirstVisibleChildClosestToEnd(boolean bl, boolean bl2) {
        if (this.mShouldReverseLayout) {
            return this.findOneVisibleChild(0, this.getChildCount(), bl, bl2);
        }
        return this.findOneVisibleChild(this.getChildCount() - 1, -1, bl, bl2);
    }

    View findFirstVisibleChildClosestToStart(boolean bl, boolean bl2) {
        if (this.mShouldReverseLayout) {
            return this.findOneVisibleChild(this.getChildCount() - 1, -1, bl, bl2);
        }
        return this.findOneVisibleChild(0, this.getChildCount(), bl, bl2);
    }

    public int findFirstVisibleItemPosition() {
        View view = this.findOneVisibleChild(0, this.getChildCount(), false, true);
        int n = view == null ? -1 : this.getPosition(view);
        return n;
    }

    public int findLastCompletelyVisibleItemPosition() {
        int n = this.getChildCount();
        int n2 = -1;
        View view = this.findOneVisibleChild(n - 1, -1, true, false);
        if (view != null) {
            n2 = this.getPosition(view);
        }
        return n2;
    }

    public int findLastVisibleItemPosition() {
        int n = this.getChildCount();
        int n2 = -1;
        View view = this.findOneVisibleChild(n - 1, -1, false, true);
        if (view != null) {
            n2 = this.getPosition(view);
        }
        return n2;
    }

    View findOnePartiallyOrCompletelyInvisibleChild(int n, int n2) {
        int n3;
        this.ensureLayoutState();
        int n4 = n2 > n ? 1 : (n2 < n ? -1 : 0);
        if (n4 == 0) {
            return this.getChildAt(n);
        }
        if (this.mOrientationHelper.getDecoratedStart(this.getChildAt(n)) < this.mOrientationHelper.getStartAfterPadding()) {
            n4 = 16644;
            n3 = 16388;
        } else {
            n4 = 4161;
            n3 = 4097;
        }
        View view = this.mOrientation == 0 ? this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(n, n2, n4, n3) : this.mVerticalBoundCheck.findOneViewWithinBoundFlags(n, n2, n4, n3);
        return view;
    }

    View findOneVisibleChild(int n, int n2, boolean bl, boolean bl2) {
        this.ensureLayoutState();
        int n3 = 0;
        int n4 = bl ? 24579 : 320;
        if (bl2) {
            n3 = 320;
        }
        View view = this.mOrientation == 0 ? this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(n, n2, n4, n3) : this.mVerticalBoundCheck.findOneViewWithinBoundFlags(n, n2, n4, n3);
        return view;
    }

    View findReferenceChild(RecyclerView.Recycler object, RecyclerView.State state, int n, int n2, int n3) {
        this.ensureLayoutState();
        state = null;
        object = null;
        int n4 = this.mOrientationHelper.getStartAfterPadding();
        int n5 = this.mOrientationHelper.getEndAfterPadding();
        int n6 = n2 > n ? 1 : -1;
        while (n != n2) {
            View view = this.getChildAt(n);
            int n7 = this.getPosition(view);
            RecyclerView.State state2 = state;
            Object object2 = object;
            if (n7 >= 0) {
                state2 = state;
                object2 = object;
                if (n7 < n3) {
                    if (((RecyclerView.LayoutParams)view.getLayoutParams()).isItemRemoved()) {
                        state2 = state;
                        object2 = object;
                        if (state == null) {
                            state2 = view;
                            object2 = object;
                        }
                    } else {
                        if (this.mOrientationHelper.getDecoratedStart(view) < n5 && this.mOrientationHelper.getDecoratedEnd(view) >= n4) {
                            return view;
                        }
                        state2 = state;
                        object2 = object;
                        if (object == null) {
                            object2 = view;
                            state2 = state;
                        }
                    }
                }
            }
            n += n6;
            state = state2;
            object = object2;
        }
        if (object == null) {
            object = state;
        }
        return object;
    }

    @Override
    public View findViewByPosition(int n) {
        View view;
        int n2 = this.getChildCount();
        if (n2 == 0) {
            return null;
        }
        int n3 = n - this.getPosition(this.getChildAt(0));
        if (n3 >= 0 && n3 < n2 && this.getPosition(view = this.getChildAt(n3)) == n) {
            return view;
        }
        return super.findViewByPosition(n);
    }

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Deprecated
    protected int getExtraLayoutSpace(RecyclerView.State state) {
        if (state.hasTargetScrollPosition()) {
            return this.mOrientationHelper.getTotalSpace();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    @Override
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    protected boolean isLayoutRTL() {
        int n = this.getLayoutDirection();
        boolean bl = true;
        if (n != 1) {
            bl = false;
        }
        return bl;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    void layoutChunk(RecyclerView.Recycler object, RecyclerView.State state, LayoutState layoutState, LayoutChunkResult layoutChunkResult) {
        int n;
        int n2;
        int n3;
        int n4;
        state = layoutState.next((RecyclerView.Recycler)object);
        if (state == null) {
            layoutChunkResult.mFinished = true;
            return;
        }
        object = (RecyclerView.LayoutParams)state.getLayoutParams();
        if (layoutState.mScrapList == null) {
            boolean bl = this.mShouldReverseLayout;
            boolean bl2 = layoutState.mLayoutDirection == -1;
            if (bl == bl2) {
                this.addView((View)state);
            } else {
                this.addView((View)state, 0);
            }
        } else {
            boolean bl = this.mShouldReverseLayout;
            boolean bl3 = layoutState.mLayoutDirection == -1;
            if (bl == bl3) {
                this.addDisappearingView((View)state);
            } else {
                this.addDisappearingView((View)state, 0);
            }
        }
        this.measureChildWithMargins((View)state, 0, 0);
        layoutChunkResult.mConsumed = this.mOrientationHelper.getDecoratedMeasurement((View)state);
        if (this.mOrientation == 1) {
            if (this.isLayoutRTL()) {
                n4 = this.getWidth() - this.getPaddingRight();
                n3 = n4 - this.mOrientationHelper.getDecoratedMeasurementInOther((View)state);
            } else {
                n3 = this.getPaddingLeft();
                n4 = this.mOrientationHelper.getDecoratedMeasurementInOther((View)state) + n3;
            }
            if (layoutState.mLayoutDirection == -1) {
                n2 = layoutState.mOffset;
                int n5 = layoutState.mOffset;
                int n6 = layoutChunkResult.mConsumed;
                n = n4;
                n4 = n2;
                n2 = n3;
                n3 = n;
                n = n5 -= n6;
            } else {
                n = layoutState.mOffset;
                int n7 = layoutState.mOffset;
                n2 = layoutChunkResult.mConsumed;
                n7 += n2;
                n2 = n3;
                n3 = n4;
                n4 = n7;
            }
        } else {
            n3 = this.getPaddingTop();
            n4 = this.mOrientationHelper.getDecoratedMeasurementInOther((View)state) + n3;
            if (layoutState.mLayoutDirection == -1) {
                n2 = layoutState.mOffset;
                n = layoutState.mOffset;
                int n8 = layoutChunkResult.mConsumed;
                n8 = n - n8;
                n = n3;
                n3 = n2;
                n2 = n8;
            } else {
                n2 = layoutState.mOffset;
                n = layoutState.mOffset;
                int n9 = layoutChunkResult.mConsumed;
                n9 = n + n9;
                n = n3;
                n3 = n9;
            }
        }
        this.layoutDecoratedWithMargins((View)state, n2, n, n3, n4);
        if (((RecyclerView.LayoutParams)((Object)object)).isItemRemoved() || ((RecyclerView.LayoutParams)((Object)object)).isItemChanged()) {
            layoutChunkResult.mIgnoreConsumed = true;
        }
        layoutChunkResult.mFocusable = state.hasFocusable();
    }

    void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo, int n) {
    }

    @Override
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.mRecycleChildrenOnDetach) {
            this.removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @Override
    public View onFocusSearchFailed(View view, int n, RecyclerView.Recycler recycler, RecyclerView.State state) {
        this.resolveShouldLayoutReverse();
        if (this.getChildCount() == 0) {
            return null;
        }
        if ((n = this.convertFocusDirectionToLayoutDirection(n)) == Integer.MIN_VALUE) {
            return null;
        }
        this.ensureLayoutState();
        this.updateLayoutState(n, (int)((float)this.mOrientationHelper.getTotalSpace() * 0.33333334f), false, state);
        this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
        this.mLayoutState.mRecycle = false;
        this.fill(recycler, this.mLayoutState, state, true);
        view = n == -1 ? this.findPartiallyOrCompletelyInvisibleChildClosestToStart() : this.findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        recycler = n == -1 ? this.getChildClosestToStart() : this.getChildClosestToEnd();
        if (recycler.hasFocusable()) {
            if (view == null) {
                return null;
            }
            return recycler;
        }
        return view;
    }

    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (this.getChildCount() > 0) {
            accessibilityEvent.setFromIndex(this.findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(this.findLastVisibleItemPosition());
        }
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Object object = this.mPendingSavedState;
        int n = -1;
        if ((object != null || this.mPendingScrollPosition != -1) && state.getItemCount() == 0) {
            this.removeAndRecycleAllViews(recycler);
            return;
        }
        if (this.mPendingSavedState != null && this.mPendingSavedState.hasValidAnchor()) {
            this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
        }
        this.ensureLayoutState();
        this.mLayoutState.mRecycle = false;
        this.resolveShouldLayoutReverse();
        object = this.getFocusedChild();
        if (this.mAnchorInfo.mValid && this.mPendingScrollPosition == -1 && this.mPendingSavedState == null) {
            if (object != null && (this.mOrientationHelper.getDecoratedStart((View)object) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd((View)object) <= this.mOrientationHelper.getStartAfterPadding())) {
                this.mAnchorInfo.assignFromViewAndKeepVisibleRect((View)object, this.getPosition((View)object));
            }
        } else {
            this.mAnchorInfo.reset();
            this.mAnchorInfo.mLayoutFromEnd = this.mShouldReverseLayout ^ this.mStackFromEnd;
            this.updateAnchorInfoForLayout(recycler, state, this.mAnchorInfo);
            this.mAnchorInfo.mValid = true;
        }
        object = this.mLayoutState;
        int n2 = this.mLayoutState.mLastScrollDelta >= 0 ? 1 : -1;
        ((LayoutState)object).mLayoutDirection = n2;
        this.mReusableIntPair[0] = 0;
        this.mReusableIntPair[1] = 0;
        this.calculateExtraLayoutSpace(state, this.mReusableIntPair);
        int n3 = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.getStartAfterPadding();
        int n4 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.getEndPadding();
        int n5 = n3;
        n2 = n4;
        if (state.isPreLayout()) {
            n5 = n3;
            n2 = n4;
            if (this.mPendingScrollPosition != -1) {
                n5 = n3;
                n2 = n4;
                if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                    object = this.findViewByPosition(this.mPendingScrollPosition);
                    n5 = n3;
                    n2 = n4;
                    if (object != null) {
                        if (this.mShouldReverseLayout) {
                            n2 = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd((View)object) - this.mPendingScrollPositionOffset;
                        } else {
                            n2 = this.mOrientationHelper.getDecoratedStart((View)object);
                            n5 = this.mOrientationHelper.getStartAfterPadding();
                            n2 = this.mPendingScrollPositionOffset - (n2 - n5);
                        }
                        if (n2 > 0) {
                            n5 = n3 + n2;
                            n2 = n4;
                        } else {
                            n2 = n4 - n2;
                            n5 = n3;
                        }
                    }
                }
            }
        }
        if (this.mAnchorInfo.mLayoutFromEnd) {
            if (this.mShouldReverseLayout) {
                n = 1;
            }
        } else if (!this.mShouldReverseLayout) {
            n = 1;
        }
        this.onAnchorReady(recycler, state, this.mAnchorInfo, n);
        this.detachAndScrapAttachedViews(recycler);
        this.mLayoutState.mInfinite = this.resolveIsInfinite();
        this.mLayoutState.mIsPreLayout = state.isPreLayout();
        this.mLayoutState.mNoRecycleSpace = 0;
        if (this.mAnchorInfo.mLayoutFromEnd) {
            this.updateLayoutStateToFillStart(this.mAnchorInfo);
            this.mLayoutState.mExtraFillSpace = n5;
            this.fill(recycler, this.mLayoutState, state, false);
            n = this.mLayoutState.mOffset;
            n3 = this.mLayoutState.mCurrentPosition;
            n5 = n2;
            if (this.mLayoutState.mAvailable > 0) {
                n5 = n2 + this.mLayoutState.mAvailable;
            }
            this.updateLayoutStateToFillEnd(this.mAnchorInfo);
            this.mLayoutState.mExtraFillSpace = n5;
            object = this.mLayoutState;
            ((LayoutState)object).mCurrentPosition += this.mLayoutState.mItemDirection;
            this.fill(recycler, this.mLayoutState, state, false);
            n2 = this.mLayoutState.mOffset;
            n5 = n;
            if (this.mLayoutState.mAvailable > 0) {
                n5 = this.mLayoutState.mAvailable;
                this.updateLayoutStateToFillStart(n3, n);
                this.mLayoutState.mExtraFillSpace = n5;
                this.fill(recycler, this.mLayoutState, state, false);
                n5 = this.mLayoutState.mOffset;
            }
        } else {
            this.updateLayoutStateToFillEnd(this.mAnchorInfo);
            this.mLayoutState.mExtraFillSpace = n2;
            this.fill(recycler, this.mLayoutState, state, false);
            n = this.mLayoutState.mOffset;
            n3 = this.mLayoutState.mCurrentPosition;
            n2 = n5;
            if (this.mLayoutState.mAvailable > 0) {
                n2 = n5 + this.mLayoutState.mAvailable;
            }
            this.updateLayoutStateToFillStart(this.mAnchorInfo);
            this.mLayoutState.mExtraFillSpace = n2;
            object = this.mLayoutState;
            ((LayoutState)object).mCurrentPosition += this.mLayoutState.mItemDirection;
            this.fill(recycler, this.mLayoutState, state, false);
            n2 = this.mLayoutState.mOffset;
            if (this.mLayoutState.mAvailable > 0) {
                n5 = this.mLayoutState.mAvailable;
                this.updateLayoutStateToFillEnd(n3, n);
                this.mLayoutState.mExtraFillSpace = n5;
                this.fill(recycler, this.mLayoutState, state, false);
                n = this.mLayoutState.mOffset;
                n5 = n2;
                n2 = n;
            } else {
                n5 = n2;
                n2 = n;
            }
        }
        n3 = n5;
        n = n2;
        if (this.getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                n = this.fixLayoutEndGap(n2, recycler, state, true);
                n3 = n5 + n;
                n5 = this.fixLayoutStartGap(n3, recycler, state, false);
                n3 += n5;
                n = n2 + n + n5;
            } else {
                n3 = this.fixLayoutStartGap(n5, recycler, state, true);
                n = this.fixLayoutEndGap(n2 += n3, recycler, state, false);
                n3 = n5 + n3 + n;
                n = n2 + n;
            }
        }
        this.layoutForPredictiveAnimations(recycler, state, n3, n);
        if (!state.isPreLayout()) {
            this.mOrientationHelper.onLayoutComplete();
        } else {
            this.mAnchorInfo.reset();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @Override
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.reset();
    }

    @Override
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.mPendingSavedState = (SavedState)parcelable;
            this.requestLayout();
        }
    }

    @Override
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        if (this.getChildCount() > 0) {
            boolean bl;
            this.ensureLayoutState();
            savedState.mAnchorLayoutFromEnd = bl = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            if (bl) {
                View view = this.getChildClosestToEnd();
                savedState.mAnchorOffset = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(view);
                savedState.mAnchorPosition = this.getPosition(view);
            } else {
                View view = this.getChildClosestToStart();
                savedState.mAnchorPosition = this.getPosition(view);
                savedState.mAnchorOffset = this.mOrientationHelper.getDecoratedStart(view) - this.mOrientationHelper.getStartAfterPadding();
            }
        } else {
            savedState.invalidateAnchor();
        }
        return savedState;
    }

    @Override
    public void prepareForDrop(View view, View view2, int n, int n2) {
        this.assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        this.ensureLayoutState();
        this.resolveShouldLayoutReverse();
        n = this.getPosition(view);
        n2 = this.getPosition(view2);
        n = n < n2 ? 1 : -1;
        if (this.mShouldReverseLayout) {
            if (n == 1) {
                this.scrollToPositionWithOffset(n2, this.mOrientationHelper.getEndAfterPadding() - (this.mOrientationHelper.getDecoratedStart(view2) + this.mOrientationHelper.getDecoratedMeasurement(view)));
            } else {
                this.scrollToPositionWithOffset(n2, this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(view2));
            }
        } else if (n == -1) {
            this.scrollToPositionWithOffset(n2, this.mOrientationHelper.getDecoratedStart(view2));
        } else {
            this.scrollToPositionWithOffset(n2, this.mOrientationHelper.getDecoratedEnd(view2) - this.mOrientationHelper.getDecoratedMeasurement(view));
        }
    }

    boolean resolveIsInfinite() {
        boolean bl = this.mOrientationHelper.getMode() == 0 && this.mOrientationHelper.getEnd() == 0;
        return bl;
    }

    int scrollBy(int n, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.getChildCount() != 0 && n != 0) {
            this.ensureLayoutState();
            this.mLayoutState.mRecycle = true;
            int n2 = n > 0 ? 1 : -1;
            int n3 = Math.abs(n);
            this.updateLayoutState(n2, n3, true, state);
            int n4 = this.mLayoutState.mScrollingOffset + this.fill(recycler, this.mLayoutState, state, false);
            if (n4 < 0) {
                return 0;
            }
            if (n3 > n4) {
                n = n2 * n4;
            }
            this.mOrientationHelper.offsetChildren(-n);
            this.mLayoutState.mLastScrollDelta = n;
            return n;
        }
        return 0;
    }

    @Override
    public int scrollHorizontallyBy(int n, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return this.scrollBy(n, recycler, state);
    }

    @Override
    public void scrollToPosition(int n) {
        this.mPendingScrollPosition = n;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        if (this.mPendingSavedState != null) {
            this.mPendingSavedState.invalidateAnchor();
        }
        this.requestLayout();
    }

    public void scrollToPositionWithOffset(int n, int n2) {
        this.mPendingScrollPosition = n;
        this.mPendingScrollPositionOffset = n2;
        if (this.mPendingSavedState != null) {
            this.mPendingSavedState.invalidateAnchor();
        }
        this.requestLayout();
    }

    @Override
    public int scrollVerticallyBy(int n, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return this.scrollBy(n, recycler, state);
    }

    public void setInitialPrefetchItemCount(int n) {
        this.mInitialPrefetchItemCount = n;
    }

    public void setOrientation(int n) {
        if (n != 0 && n != 1) {
            throw new IllegalArgumentException("invalid orientation:" + n);
        }
        this.assertNotInLayoutOrScroll(null);
        if (n != this.mOrientation || this.mOrientationHelper == null) {
            this.mAnchorInfo.mOrientationHelper = this.mOrientationHelper = OrientationHelper.createOrientationHelper(this, n);
            this.mOrientation = n;
            this.requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean bl) {
        this.mRecycleChildrenOnDetach = bl;
    }

    public void setReverseLayout(boolean bl) {
        this.assertNotInLayoutOrScroll(null);
        if (bl == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = bl;
        this.requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean bl) {
        this.mSmoothScrollbarEnabled = bl;
    }

    public void setStackFromEnd(boolean bl) {
        this.assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd == bl) {
            return;
        }
        this.mStackFromEnd = bl;
        this.requestLayout();
    }

    @Override
    boolean shouldMeasureTwice() {
        boolean bl = this.getHeightMode() != 0x40000000 && this.getWidthMode() != 0x40000000 && this.hasFlexibleChildInBothOrientations();
        return bl;
    }

    @Override
    public void smoothScrollToPosition(RecyclerView object, RecyclerView.State state, int n) {
        object = new LinearSmoothScroller(object.getContext());
        ((RecyclerView.SmoothScroller)object).setTargetPosition(n);
        this.startSmoothScroll((RecyclerView.SmoothScroller)object);
    }

    @Override
    public boolean supportsPredictiveItemAnimations() {
        boolean bl = this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
        return bl;
    }

    void validateChildOrder() {
        Log.d((String)TAG, (String)("validating child count " + this.getChildCount()));
        int n = this.getChildCount();
        boolean bl = true;
        boolean bl2 = true;
        if (n < 1) {
            return;
        }
        int n2 = this.getPosition(this.getChildAt(0));
        int n3 = this.mOrientationHelper.getDecoratedStart(this.getChildAt(0));
        if (this.mShouldReverseLayout) {
            for (n = 1; n < this.getChildCount(); ++n) {
                Object object = this.getChildAt(n);
                int n4 = this.getPosition((View)object);
                int n5 = this.mOrientationHelper.getDecoratedStart((View)object);
                if (n4 < n2) {
                    this.logChildren();
                    object = new StringBuilder().append("detected invalid position. loc invalid? ");
                    if (n5 >= n3) {
                        bl2 = false;
                    }
                    throw new RuntimeException(((StringBuilder)object).append(bl2).toString());
                }
                if (n5 <= n3) {
                    continue;
                }
                this.logChildren();
                throw new RuntimeException("detected invalid location");
            }
        } else {
            for (n = 1; n < this.getChildCount(); ++n) {
                Object object = this.getChildAt(n);
                int n6 = this.getPosition((View)object);
                int n7 = this.mOrientationHelper.getDecoratedStart((View)object);
                if (n6 < n2) {
                    this.logChildren();
                    object = new StringBuilder().append("detected invalid position. loc invalid? ");
                    bl2 = n7 < n3 ? bl : false;
                    throw new RuntimeException(((StringBuilder)object).append(bl2).toString());
                }
                if (n7 >= n3) {
                    continue;
                }
                this.logChildren();
                throw new RuntimeException("detected invalid location");
            }
        }
    }

    static class AnchorInfo {
        int mCoordinate;
        boolean mLayoutFromEnd;
        OrientationHelper mOrientationHelper;
        int mPosition;
        boolean mValid;

        AnchorInfo() {
            this.reset();
        }

        void assignCoordinateFromPadding() {
            int n = this.mLayoutFromEnd ? this.mOrientationHelper.getEndAfterPadding() : this.mOrientationHelper.getStartAfterPadding();
            this.mCoordinate = n;
        }

        public void assignFromView(View view, int n) {
            this.mCoordinate = this.mLayoutFromEnd ? this.mOrientationHelper.getDecoratedEnd(view) + this.mOrientationHelper.getTotalSpaceChange() : this.mOrientationHelper.getDecoratedStart(view);
            this.mPosition = n;
        }

        public void assignFromViewAndKeepVisibleRect(View view, int n) {
            int n2 = this.mOrientationHelper.getTotalSpaceChange();
            if (n2 >= 0) {
                this.assignFromView(view, n);
                return;
            }
            this.mPosition = n;
            if (this.mLayoutFromEnd) {
                n = this.mOrientationHelper.getEndAfterPadding() - n2 - this.mOrientationHelper.getDecoratedEnd(view);
                this.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - n;
                if (n > 0) {
                    int n3 = this.mOrientationHelper.getDecoratedMeasurement(view);
                    n2 = this.mCoordinate;
                    int n4 = this.mOrientationHelper.getStartAfterPadding();
                    if ((n2 = n2 - n3 - (Math.min(this.mOrientationHelper.getDecoratedStart(view) - n4, 0) + n4)) < 0) {
                        this.mCoordinate += Math.min(n, -n2);
                    }
                }
            } else {
                int n5 = this.mOrientationHelper.getDecoratedStart(view);
                n = n5 - this.mOrientationHelper.getStartAfterPadding();
                this.mCoordinate = n5;
                if (n > 0) {
                    int n6 = this.mOrientationHelper.getDecoratedMeasurement(view);
                    int n7 = this.mOrientationHelper.getEndAfterPadding();
                    int n8 = this.mOrientationHelper.getDecoratedEnd(view);
                    n2 = this.mOrientationHelper.getEndAfterPadding() - Math.min(0, n7 - n2 - n8) - (n6 + n5);
                    if (n2 < 0) {
                        this.mCoordinate -= Math.min(n, -n2);
                    }
                }
            }
        }

        boolean isViewValidAsAnchor(View object, RecyclerView.State state) {
            boolean bl = !((RecyclerView.LayoutParams)((Object)(object = (RecyclerView.LayoutParams)object.getLayoutParams()))).isItemRemoved() && ((RecyclerView.LayoutParams)((Object)object)).getViewLayoutPosition() >= 0 && ((RecyclerView.LayoutParams)((Object)object)).getViewLayoutPosition() < state.getItemCount();
            return bl;
        }

        void reset() {
            this.mPosition = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mLayoutFromEnd = false;
            this.mValid = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.mCoordinate + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + '}';
        }
    }

    protected static class LayoutChunkResult {
        public int mConsumed;
        public boolean mFinished;
        public boolean mFocusable;
        public boolean mIgnoreConsumed;

        protected LayoutChunkResult() {
        }

        void resetInternal() {
            this.mConsumed = 0;
            this.mFinished = false;
            this.mIgnoreConsumed = false;
            this.mFocusable = false;
        }
    }

    static class LayoutState {
        static final int INVALID_LAYOUT = Integer.MIN_VALUE;
        static final int ITEM_DIRECTION_HEAD = -1;
        static final int ITEM_DIRECTION_TAIL = 1;
        static final int LAYOUT_END = 1;
        static final int LAYOUT_START = -1;
        static final int SCROLLING_OFFSET_NaN = Integer.MIN_VALUE;
        static final String TAG = "LLM#LayoutState";
        int mAvailable;
        int mCurrentPosition;
        int mExtraFillSpace = 0;
        boolean mInfinite;
        boolean mIsPreLayout = false;
        int mItemDirection;
        int mLastScrollDelta;
        int mLayoutDirection;
        int mNoRecycleSpace = 0;
        int mOffset;
        boolean mRecycle = true;
        List<RecyclerView.ViewHolder> mScrapList = null;
        int mScrollingOffset;

        LayoutState() {
        }

        private View nextViewFromScrapList() {
            int n = this.mScrapList.size();
            for (int i = 0; i < n; ++i) {
                View view = this.mScrapList.get((int)i).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
                if (layoutParams.isItemRemoved() || this.mCurrentPosition != layoutParams.getViewLayoutPosition()) continue;
                this.assignPositionFromScrapList(view);
                return view;
            }
            return null;
        }

        public void assignPositionFromScrapList() {
            this.assignPositionFromScrapList(null);
        }

        public void assignPositionFromScrapList(View view) {
            this.mCurrentPosition = (view = this.nextViewInLimitedList(view)) == null ? -1 : ((RecyclerView.LayoutParams)view.getLayoutParams()).getViewLayoutPosition();
        }

        boolean hasMore(RecyclerView.State state) {
            boolean bl = this.mCurrentPosition >= 0 && this.mCurrentPosition < state.getItemCount();
            return bl;
        }

        void log() {
            Log.d((String)TAG, (String)("avail:" + this.mAvailable + ", ind:" + this.mCurrentPosition + ", dir:" + this.mItemDirection + ", offset:" + this.mOffset + ", layoutDir:" + this.mLayoutDirection));
        }

        View next(RecyclerView.Recycler recycler) {
            if (this.mScrapList != null) {
                return this.nextViewFromScrapList();
            }
            recycler = recycler.getViewForPosition(this.mCurrentPosition);
            this.mCurrentPosition += this.mItemDirection;
            return recycler;
        }

        public View nextViewInLimitedList(View view) {
            View view2;
            int n = this.mScrapList.size();
            View view3 = null;
            int n2 = Integer.MAX_VALUE;
            int n3 = 0;
            while (true) {
                view2 = view3;
                if (n3 >= n) break;
                View view4 = this.mScrapList.get((int)n3).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view4.getLayoutParams();
                view2 = view3;
                int n4 = n2;
                if (view4 != view) {
                    if (layoutParams.isItemRemoved()) {
                        view2 = view3;
                        n4 = n2;
                    } else {
                        int n5 = (layoutParams.getViewLayoutPosition() - this.mCurrentPosition) * this.mItemDirection;
                        if (n5 < 0) {
                            view2 = view3;
                            n4 = n2;
                        } else {
                            view2 = view3;
                            n4 = n2;
                            if (n5 < n2) {
                                view3 = view4;
                                n4 = n5;
                                view2 = view3;
                                if (n5 == 0) {
                                    view2 = view3;
                                    break;
                                }
                            }
                        }
                    }
                }
                ++n3;
                view3 = view2;
                n2 = n4;
            }
            return view2;
        }
    }

    public static class SavedState
    implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>(){

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int n) {
                return new SavedState[n];
            }
        };
        boolean mAnchorLayoutFromEnd;
        int mAnchorOffset;
        int mAnchorPosition;

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mAnchorOffset = parcel.readInt();
            int n = parcel.readInt();
            boolean bl = true;
            if (n != 1) {
                bl = false;
            }
            this.mAnchorLayoutFromEnd = bl;
        }

        public SavedState(SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
        }

        public int describeContents() {
            return 0;
        }

        boolean hasValidAnchor() {
            boolean bl = this.mAnchorPosition >= 0;
            return bl;
        }

        void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        public void writeToParcel(Parcel parcel, int n) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
        }
    }
}

