/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Log
 */
package androidx.recyclerview.widget;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class MessageThreadUtil<T>
implements ThreadUtil<T> {
    MessageThreadUtil() {
    }

    @Override
    public ThreadUtil.BackgroundCallback<T> getBackgroundProxy(ThreadUtil.BackgroundCallback<T> backgroundCallback) {
        return new ThreadUtil.BackgroundCallback<T>(this, backgroundCallback){
            static final int LOAD_TILE = 3;
            static final int RECYCLE_TILE = 4;
            static final int REFRESH = 1;
            static final int UPDATE_RANGE = 2;
            private Runnable mBackgroundRunnable;
            AtomicBoolean mBackgroundRunning;
            private final Executor mExecutor;
            final MessageQueue mQueue;
            final MessageThreadUtil this$0;
            final ThreadUtil.BackgroundCallback val$callback;
            {
                this.this$0 = messageThreadUtil;
                this.val$callback = backgroundCallback;
                this.mQueue = new MessageQueue();
                this.mExecutor = AsyncTask.THREAD_POOL_EXECUTOR;
                this.mBackgroundRunning = new AtomicBoolean(false);
                this.mBackgroundRunnable = new Runnable(this){
                    final 2 this$1;
                    {
                        this.this$1 = var1_1;
                    }

                    @Override
                    public void run() {
                        block6: while (true) {
                            Object object;
                            if ((object = this.this$1.mQueue.next()) == null) {
                                this.this$1.mBackgroundRunning.set(false);
                                return;
                            }
                            switch (((SyncQueueItem)object).what) {
                                default: {
                                    Log.e((String)"ThreadUtil", (String)("Unsupported message, what=" + ((SyncQueueItem)object).what));
                                    continue block6;
                                }
                                case 4: {
                                    object = (TileList.Tile)((SyncQueueItem)object).data;
                                    this.this$1.val$callback.recycleTile(object);
                                    continue block6;
                                }
                                case 3: {
                                    this.this$1.val$callback.loadTile(((SyncQueueItem)object).arg1, ((SyncQueueItem)object).arg2);
                                    continue block6;
                                }
                                case 2: {
                                    this.this$1.mQueue.removeMessages(2);
                                    this.this$1.mQueue.removeMessages(3);
                                    this.this$1.val$callback.updateRange(((SyncQueueItem)object).arg1, ((SyncQueueItem)object).arg2, ((SyncQueueItem)object).arg3, ((SyncQueueItem)object).arg4, ((SyncQueueItem)object).arg5);
                                    continue block6;
                                }
                                case 1: 
                            }
                            this.this$1.mQueue.removeMessages(1);
                            this.this$1.val$callback.refresh(((SyncQueueItem)object).arg1);
                        }
                    }
                };
            }

            private void maybeExecuteBackgroundRunnable() {
                if (this.mBackgroundRunning.compareAndSet(false, true)) {
                    this.mExecutor.execute(this.mBackgroundRunnable);
                }
            }

            private void sendMessage(SyncQueueItem syncQueueItem) {
                this.mQueue.sendMessage(syncQueueItem);
                this.maybeExecuteBackgroundRunnable();
            }

            private void sendMessageAtFrontOfQueue(SyncQueueItem syncQueueItem) {
                this.mQueue.sendMessageAtFrontOfQueue(syncQueueItem);
                this.maybeExecuteBackgroundRunnable();
            }

            @Override
            public void loadTile(int n, int n2) {
                this.sendMessage(SyncQueueItem.obtainMessage(3, n, n2));
            }

            @Override
            public void recycleTile(TileList.Tile<T> tile) {
                this.sendMessage(SyncQueueItem.obtainMessage(4, 0, tile));
            }

            @Override
            public void refresh(int n) {
                this.sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(1, n, null));
            }

            @Override
            public void updateRange(int n, int n2, int n3, int n4, int n5) {
                this.sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(2, n, n2, n3, n4, n5, null));
            }
        };
    }

    @Override
    public ThreadUtil.MainThreadCallback<T> getMainThreadProxy(ThreadUtil.MainThreadCallback<T> mainThreadCallback) {
        return new ThreadUtil.MainThreadCallback<T>(this, mainThreadCallback){
            static final int ADD_TILE = 2;
            static final int REMOVE_TILE = 3;
            static final int UPDATE_ITEM_COUNT = 1;
            private final Handler mMainThreadHandler;
            private Runnable mMainThreadRunnable;
            final MessageQueue mQueue;
            final MessageThreadUtil this$0;
            final ThreadUtil.MainThreadCallback val$callback;
            {
                this.this$0 = messageThreadUtil;
                this.val$callback = mainThreadCallback;
                this.mQueue = new MessageQueue();
                this.mMainThreadHandler = new Handler(Looper.getMainLooper());
                this.mMainThreadRunnable = new Runnable(this){
                    final 1 this$1;
                    {
                        this.this$1 = var1_1;
                    }

                    @Override
                    public void run() {
                        SyncQueueItem syncQueueItem = this.this$1.mQueue.next();
                        while (syncQueueItem != null) {
                            switch (syncQueueItem.what) {
                                default: {
                                    Log.e((String)"ThreadUtil", (String)("Unsupported message, what=" + syncQueueItem.what));
                                    break;
                                }
                                case 3: {
                                    this.this$1.val$callback.removeTile(syncQueueItem.arg1, syncQueueItem.arg2);
                                    break;
                                }
                                case 2: {
                                    TileList.Tile tile = (TileList.Tile)syncQueueItem.data;
                                    this.this$1.val$callback.addTile(syncQueueItem.arg1, tile);
                                    break;
                                }
                                case 1: {
                                    this.this$1.val$callback.updateItemCount(syncQueueItem.arg1, syncQueueItem.arg2);
                                }
                            }
                            syncQueueItem = this.this$1.mQueue.next();
                        }
                    }
                };
            }

            private void sendMessage(SyncQueueItem syncQueueItem) {
                this.mQueue.sendMessage(syncQueueItem);
                this.mMainThreadHandler.post(this.mMainThreadRunnable);
            }

            @Override
            public void addTile(int n, TileList.Tile<T> tile) {
                this.sendMessage(SyncQueueItem.obtainMessage(2, n, tile));
            }

            @Override
            public void removeTile(int n, int n2) {
                this.sendMessage(SyncQueueItem.obtainMessage(3, n, n2));
            }

            @Override
            public void updateItemCount(int n, int n2) {
                this.sendMessage(SyncQueueItem.obtainMessage(1, n, n2));
            }
        };
    }

    static class MessageQueue {
        private SyncQueueItem mRoot;

        MessageQueue() {
        }

        SyncQueueItem next() {
            synchronized (this) {
                SyncQueueItem syncQueueItem;
                block4: {
                    syncQueueItem = this.mRoot;
                    if (syncQueueItem != null) break block4;
                    return null;
                }
                syncQueueItem = this.mRoot;
                this.mRoot = this.mRoot.next;
                return syncQueueItem;
            }
        }

        void removeMessages(int n) {
            synchronized (this) {
                block8: {
                    SyncQueueItem syncQueueItem;
                    while (this.mRoot != null && this.mRoot.what == n) {
                        syncQueueItem = this.mRoot;
                        this.mRoot = this.mRoot.next;
                        syncQueueItem.recycle();
                    }
                    if (this.mRoot == null) break block8;
                    SyncQueueItem syncQueueItem2 = this.mRoot;
                    syncQueueItem = syncQueueItem2.next;
                    while (syncQueueItem != null) {
                        SyncQueueItem syncQueueItem3 = syncQueueItem.next;
                        if (syncQueueItem.what == n) {
                            syncQueueItem2.next = syncQueueItem3;
                            syncQueueItem.recycle();
                        } else {
                            syncQueueItem2 = syncQueueItem;
                        }
                        syncQueueItem = syncQueueItem3;
                    }
                }
                return;
            }
        }

        void sendMessage(SyncQueueItem syncQueueItem) {
            synchronized (this) {
                if (this.mRoot == null) {
                    this.mRoot = syncQueueItem;
                    return;
                }
                SyncQueueItem syncQueueItem2 = this.mRoot;
                while (syncQueueItem2.next != null) {
                    syncQueueItem2 = syncQueueItem2.next;
                }
                syncQueueItem2.next = syncQueueItem;
                return;
            }
        }

        void sendMessageAtFrontOfQueue(SyncQueueItem syncQueueItem) {
            synchronized (this) {
                syncQueueItem.next = this.mRoot;
                this.mRoot = syncQueueItem;
                return;
            }
        }
    }

    static class SyncQueueItem {
        private static SyncQueueItem sPool;
        private static final Object sPoolLock;
        public int arg1;
        public int arg2;
        public int arg3;
        public int arg4;
        public int arg5;
        public Object data;
        SyncQueueItem next;
        public int what;

        static {
            sPoolLock = new Object();
        }

        SyncQueueItem() {
        }

        static SyncQueueItem obtainMessage(int n, int n2, int n3) {
            return SyncQueueItem.obtainMessage(n, n2, n3, 0, 0, 0, null);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        static SyncQueueItem obtainMessage(int n, int n2, int n3, int n4, int n5, int n6, Object object) {
            Object object2 = sPoolLock;
            synchronized (object2) {
                SyncQueueItem syncQueueItem;
                if (sPool == null) {
                    syncQueueItem = new SyncQueueItem();
                } else {
                    syncQueueItem = sPool;
                    sPool = SyncQueueItem.sPool.next;
                    syncQueueItem.next = null;
                }
                syncQueueItem.what = n;
                syncQueueItem.arg1 = n2;
                syncQueueItem.arg2 = n3;
                syncQueueItem.arg3 = n4;
                syncQueueItem.arg4 = n5;
                syncQueueItem.arg5 = n6;
                syncQueueItem.data = object;
                return syncQueueItem;
            }
        }

        static SyncQueueItem obtainMessage(int n, int n2, Object object) {
            return SyncQueueItem.obtainMessage(n, n2, 0, 0, 0, 0, object);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        void recycle() {
            this.next = null;
            this.arg5 = 0;
            this.arg4 = 0;
            this.arg3 = 0;
            this.arg2 = 0;
            this.arg1 = 0;
            this.what = 0;
            this.data = null;
            Object object = sPoolLock;
            synchronized (object) {
                if (sPool != null) {
                    this.next = sPool;
                }
                sPool = this;
                return;
            }
        }
    }
}

