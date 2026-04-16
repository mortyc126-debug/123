/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.util.SparseBooleanArray
 *  android.util.SparseIntArray
 */
package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.recyclerview.widget.MessageThreadUtil;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;

public class AsyncListUtil<T> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncListUtil";
    boolean mAllowScrollHints;
    private final ThreadUtil.BackgroundCallback<T> mBackgroundCallback;
    final ThreadUtil.BackgroundCallback<T> mBackgroundProxy;
    final DataCallback<T> mDataCallback;
    int mDisplayedGeneration;
    int mItemCount = 0;
    private final ThreadUtil.MainThreadCallback<T> mMainThreadCallback;
    final ThreadUtil.MainThreadCallback<T> mMainThreadProxy;
    final SparseIntArray mMissingPositions;
    final int[] mPrevRange;
    int mRequestedGeneration;
    private int mScrollHint = 0;
    final Class<T> mTClass;
    final TileList<T> mTileList;
    final int mTileSize;
    final int[] mTmpRange = new int[2];
    final int[] mTmpRangeExtended;
    final ViewCallback mViewCallback;

    public AsyncListUtil(Class<T> object, int n, DataCallback<T> dataCallback, ViewCallback viewCallback) {
        this.mPrevRange = new int[2];
        this.mTmpRangeExtended = new int[2];
        this.mRequestedGeneration = this.mDisplayedGeneration = 0;
        this.mMissingPositions = new SparseIntArray();
        this.mMainThreadCallback = new ThreadUtil.MainThreadCallback<T>(this){
            final AsyncListUtil this$0;
            {
                this.this$0 = asyncListUtil;
            }

            private boolean isRequestedGeneration(int n) {
                boolean bl = n == this.this$0.mRequestedGeneration;
                return bl;
            }

            private void recycleAllTiles() {
                for (int i = 0; i < this.this$0.mTileList.size(); ++i) {
                    this.this$0.mBackgroundProxy.recycleTile(this.this$0.mTileList.getAtIndex(i));
                }
                this.this$0.mTileList.clear();
            }

            @Override
            public void addTile(int n, TileList.Tile<T> tile) {
                if (!this.isRequestedGeneration(n)) {
                    this.this$0.mBackgroundProxy.recycleTile(tile);
                    return;
                }
                TileList.Tile tile2 = this.this$0.mTileList.addOrReplace(tile);
                if (tile2 != null) {
                    Log.e((String)AsyncListUtil.TAG, (String)("duplicate tile @" + tile2.mStartPosition));
                    this.this$0.mBackgroundProxy.recycleTile(tile2);
                }
                int n2 = tile.mStartPosition;
                int n3 = tile.mItemCount;
                n = 0;
                while (n < this.this$0.mMissingPositions.size()) {
                    int n4 = this.this$0.mMissingPositions.keyAt(n);
                    if (tile.mStartPosition <= n4 && n4 < n2 + n3) {
                        this.this$0.mMissingPositions.removeAt(n);
                        this.this$0.mViewCallback.onItemLoaded(n4);
                        continue;
                    }
                    ++n;
                }
            }

            @Override
            public void removeTile(int n, int n2) {
                if (!this.isRequestedGeneration(n)) {
                    return;
                }
                TileList.Tile tile = this.this$0.mTileList.removeAtPos(n2);
                if (tile == null) {
                    Log.e((String)AsyncListUtil.TAG, (String)("tile not found @" + n2));
                    return;
                }
                this.this$0.mBackgroundProxy.recycleTile(tile);
            }

            @Override
            public void updateItemCount(int n, int n2) {
                if (!this.isRequestedGeneration(n)) {
                    return;
                }
                this.this$0.mItemCount = n2;
                this.this$0.mViewCallback.onDataRefresh();
                this.this$0.mDisplayedGeneration = this.this$0.mRequestedGeneration;
                this.recycleAllTiles();
                this.this$0.mAllowScrollHints = false;
                this.this$0.updateRange();
            }
        };
        this.mBackgroundCallback = new ThreadUtil.BackgroundCallback<T>(this){
            private int mFirstRequiredTileStart;
            private int mGeneration;
            private int mItemCount;
            private int mLastRequiredTileStart;
            final SparseBooleanArray mLoadedTiles;
            private TileList.Tile<T> mRecycledRoot;
            final AsyncListUtil this$0;
            {
                this.this$0 = asyncListUtil;
                this.mLoadedTiles = new SparseBooleanArray();
            }

            private TileList.Tile<T> acquireTile() {
                if (this.mRecycledRoot != null) {
                    TileList.Tile tile = this.mRecycledRoot;
                    this.mRecycledRoot = this.mRecycledRoot.mNext;
                    return tile;
                }
                return new TileList.Tile(this.this$0.mTClass, this.this$0.mTileSize);
            }

            private void addTile(TileList.Tile<T> tile) {
                this.mLoadedTiles.put(tile.mStartPosition, true);
                this.this$0.mMainThreadProxy.addTile(this.mGeneration, tile);
            }

            private void flushTileCache(int n) {
                int n2 = this.this$0.mDataCallback.getMaxCachedTiles();
                while (this.mLoadedTiles.size() >= n2) {
                    int n3 = this.mLoadedTiles.keyAt(0);
                    int n4 = this.mLoadedTiles.keyAt(this.mLoadedTiles.size() - 1);
                    int n5 = this.mFirstRequiredTileStart - n3;
                    int n6 = n4 - this.mLastRequiredTileStart;
                    if (n5 > 0 && (n5 >= n6 || n == 2)) {
                        this.removeTile(n3);
                        continue;
                    }
                    if (n6 > 0 && (n5 < n6 || n == 1)) {
                        this.removeTile(n4);
                        continue;
                    }
                    return;
                }
            }

            private int getTileStart(int n) {
                return n - n % this.this$0.mTileSize;
            }

            private boolean isTileLoaded(int n) {
                return this.mLoadedTiles.get(n);
            }

            private void log(String string2, Object ... objectArray) {
                Log.d((String)AsyncListUtil.TAG, (String)("[BKGR] " + String.format(string2, objectArray)));
            }

            private void removeTile(int n) {
                this.mLoadedTiles.delete(n);
                this.this$0.mMainThreadProxy.removeTile(this.mGeneration, n);
            }

            private void requestTiles(int n, int n2, int n3, boolean bl) {
                for (int i = n; i <= n2; i += this.this$0.mTileSize) {
                    int n4 = bl ? n2 + n - i : i;
                    this.this$0.mBackgroundProxy.loadTile(n4, n3);
                }
            }

            @Override
            public void loadTile(int n, int n2) {
                if (this.isTileLoaded(n)) {
                    return;
                }
                TileList.Tile tile = this.acquireTile();
                tile.mStartPosition = n;
                tile.mItemCount = Math.min(this.this$0.mTileSize, this.mItemCount - tile.mStartPosition);
                this.this$0.mDataCallback.fillData(tile.mItems, tile.mStartPosition, tile.mItemCount);
                this.flushTileCache(n2);
                this.addTile(tile);
            }

            @Override
            public void recycleTile(TileList.Tile<T> tile) {
                this.this$0.mDataCallback.recycleData(tile.mItems, tile.mItemCount);
                tile.mNext = this.mRecycledRoot;
                this.mRecycledRoot = tile;
            }

            @Override
            public void refresh(int n) {
                this.mGeneration = n;
                this.mLoadedTiles.clear();
                this.mItemCount = this.this$0.mDataCallback.refreshData();
                this.this$0.mMainThreadProxy.updateItemCount(this.mGeneration, this.mItemCount);
            }

            @Override
            public void updateRange(int n, int n2, int n3, int n4, int n5) {
                if (n > n2) {
                    return;
                }
                n = this.getTileStart(n);
                n2 = this.getTileStart(n2);
                this.mFirstRequiredTileStart = this.getTileStart(n3);
                this.mLastRequiredTileStart = this.getTileStart(n4);
                if (n5 == 1) {
                    this.requestTiles(this.mFirstRequiredTileStart, n2, n5, true);
                    this.requestTiles(this.this$0.mTileSize + n2, this.mLastRequiredTileStart, n5, false);
                } else {
                    this.requestTiles(n, this.mLastRequiredTileStart, n5, false);
                    this.requestTiles(this.mFirstRequiredTileStart, n - this.this$0.mTileSize, n5, true);
                }
            }
        };
        this.mTClass = object;
        this.mTileSize = n;
        this.mDataCallback = dataCallback;
        this.mViewCallback = viewCallback;
        this.mTileList = new TileList(this.mTileSize);
        object = new MessageThreadUtil();
        this.mMainThreadProxy = object.getMainThreadProxy(this.mMainThreadCallback);
        this.mBackgroundProxy = object.getBackgroundProxy(this.mBackgroundCallback);
        this.refresh();
    }

    private boolean isRefreshPending() {
        boolean bl = this.mRequestedGeneration != this.mDisplayedGeneration;
        return bl;
    }

    public T getItem(int n) {
        if (n >= 0 && n < this.mItemCount) {
            T t = this.mTileList.getItemAt(n);
            if (t == null && !this.isRefreshPending()) {
                this.mMissingPositions.put(n, 0);
            }
            return t;
        }
        throw new IndexOutOfBoundsException(n + " is not within 0 and " + this.mItemCount);
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    void log(String string2, Object ... objectArray) {
        Log.d((String)TAG, (String)("[MAIN] " + String.format(string2, objectArray)));
    }

    public void onRangeChanged() {
        if (this.isRefreshPending()) {
            return;
        }
        this.updateRange();
        this.mAllowScrollHints = true;
    }

    public void refresh() {
        int n;
        this.mMissingPositions.clear();
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.mBackgroundProxy;
        this.mRequestedGeneration = n = this.mRequestedGeneration + 1;
        backgroundCallback.refresh(n);
    }

    void updateRange() {
        this.mViewCallback.getItemRangeInto(this.mTmpRange);
        if (this.mTmpRange[0] <= this.mTmpRange[1] && this.mTmpRange[0] >= 0) {
            if (this.mTmpRange[1] >= this.mItemCount) {
                return;
            }
            if (!this.mAllowScrollHints) {
                this.mScrollHint = 0;
            } else if (this.mTmpRange[0] <= this.mPrevRange[1] && this.mPrevRange[0] <= this.mTmpRange[1]) {
                if (this.mTmpRange[0] < this.mPrevRange[0]) {
                    this.mScrollHint = 1;
                } else if (this.mTmpRange[0] > this.mPrevRange[0]) {
                    this.mScrollHint = 2;
                }
            } else {
                this.mScrollHint = 0;
            }
            this.mPrevRange[0] = this.mTmpRange[0];
            this.mPrevRange[1] = this.mTmpRange[1];
            this.mViewCallback.extendRangeInto(this.mTmpRange, this.mTmpRangeExtended, this.mScrollHint);
            this.mTmpRangeExtended[0] = Math.min(this.mTmpRange[0], Math.max(this.mTmpRangeExtended[0], 0));
            this.mTmpRangeExtended[1] = Math.max(this.mTmpRange[1], Math.min(this.mTmpRangeExtended[1], this.mItemCount - 1));
            this.mBackgroundProxy.updateRange(this.mTmpRange[0], this.mTmpRange[1], this.mTmpRangeExtended[0], this.mTmpRangeExtended[1], this.mScrollHint);
            return;
        }
    }

    public static abstract class DataCallback<T> {
        public abstract void fillData(T[] var1, int var2, int var3);

        public int getMaxCachedTiles() {
            return 10;
        }

        public void recycleData(T[] TArray, int n) {
        }

        public abstract int refreshData();
    }

    public static abstract class ViewCallback {
        public static final int HINT_SCROLL_ASC = 2;
        public static final int HINT_SCROLL_DESC = 1;
        public static final int HINT_SCROLL_NONE = 0;

        public void extendRangeInto(int[] nArray, int[] nArray2, int n) {
            int n2 = nArray[1] - nArray[0] + 1;
            int n3 = n2 / 2;
            int n4 = nArray[0];
            int n5 = n == 1 ? n2 : n3;
            nArray2[0] = n4 - n5;
            n5 = nArray[1];
            if (n == 2) {
                n3 = n2;
            }
            nArray2[1] = n5 + n3;
        }

        public abstract void getItemRangeInto(int[] var1);

        public abstract void onDataRefresh();

        public abstract void onItemLoaded(int var1);
    }
}

