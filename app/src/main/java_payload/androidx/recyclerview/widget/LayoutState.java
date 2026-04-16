/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

class LayoutState {
    static final int INVALID_LAYOUT = Integer.MIN_VALUE;
    static final int ITEM_DIRECTION_HEAD = -1;
    static final int ITEM_DIRECTION_TAIL = 1;
    static final int LAYOUT_END = 1;
    static final int LAYOUT_START = -1;
    int mAvailable;
    int mCurrentPosition;
    int mEndLine = 0;
    boolean mInfinite;
    int mItemDirection;
    int mLayoutDirection;
    boolean mRecycle = true;
    int mStartLine = 0;
    boolean mStopInFocusable;

    LayoutState() {
    }

    boolean hasMore(RecyclerView.State state) {
        boolean bl = this.mCurrentPosition >= 0 && this.mCurrentPosition < state.getItemCount();
        return bl;
    }

    View next(RecyclerView.Recycler recycler) {
        recycler = recycler.getViewForPosition(this.mCurrentPosition);
        this.mCurrentPosition += this.mItemDirection;
        return recycler;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.mAvailable + ", mCurrentPosition=" + this.mCurrentPosition + ", mItemDirection=" + this.mItemDirection + ", mLayoutDirection=" + this.mLayoutDirection + ", mStartLine=" + this.mStartLine + ", mEndLine=" + this.mEndLine + '}';
    }
}

