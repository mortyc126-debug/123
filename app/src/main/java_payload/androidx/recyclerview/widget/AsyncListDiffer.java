/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

public class AsyncListDiffer<T> {
    private static final Executor sMainThreadExecutor = new MainThreadExecutor();
    final AsyncDifferConfig<T> mConfig;
    private List<T> mList;
    private final List<ListListener<T>> mListeners = new CopyOnWriteArrayList<ListListener<T>>();
    Executor mMainThreadExecutor;
    int mMaxScheduledGeneration;
    private List<T> mReadOnlyList = Collections.emptyList();
    private final ListUpdateCallback mUpdateCallback;

    public AsyncListDiffer(ListUpdateCallback listUpdateCallback, AsyncDifferConfig<T> asyncDifferConfig) {
        this.mUpdateCallback = listUpdateCallback;
        this.mConfig = asyncDifferConfig;
        this.mMainThreadExecutor = asyncDifferConfig.getMainThreadExecutor() != null ? asyncDifferConfig.getMainThreadExecutor() : sMainThreadExecutor;
    }

    public AsyncListDiffer(RecyclerView.Adapter adapter, DiffUtil.ItemCallback<T> itemCallback) {
        this(new AdapterListUpdateCallback(adapter), new AsyncDifferConfig.Builder<T>(itemCallback).build());
    }

    private void onCurrentListChanged(List<T> list, Runnable runnable2) {
        Iterator<ListListener<T>> iterator2 = this.mListeners.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().onCurrentListChanged(list, this.mReadOnlyList);
        }
        if (runnable2 != null) {
            runnable2.run();
        }
    }

    public void addListListener(ListListener<T> listListener) {
        this.mListeners.add(listListener);
    }

    public List<T> getCurrentList() {
        return this.mReadOnlyList;
    }

    void latchList(List<T> list, DiffUtil.DiffResult diffResult, Runnable runnable2) {
        List<T> list2 = this.mReadOnlyList;
        this.mList = list;
        this.mReadOnlyList = Collections.unmodifiableList(list);
        diffResult.dispatchUpdatesTo(this.mUpdateCallback);
        this.onCurrentListChanged(list2, runnable2);
    }

    public void removeListListener(ListListener<T> listListener) {
        this.mListeners.remove(listListener);
    }

    public void submitList(List<T> list) {
        this.submitList(list, null);
    }

    public void submitList(List<T> list, Runnable runnable2) {
        int n;
        this.mMaxScheduledGeneration = n = this.mMaxScheduledGeneration + 1;
        if (list == this.mList) {
            if (runnable2 != null) {
                runnable2.run();
            }
            return;
        }
        List<T> list2 = this.mReadOnlyList;
        if (list == null) {
            n = this.mList.size();
            this.mList = null;
            this.mReadOnlyList = Collections.emptyList();
            this.mUpdateCallback.onRemoved(0, n);
            this.onCurrentListChanged(list2, runnable2);
            return;
        }
        if (this.mList == null) {
            this.mList = list;
            this.mReadOnlyList = Collections.unmodifiableList(list);
            this.mUpdateCallback.onInserted(0, list.size());
            this.onCurrentListChanged(list2, runnable2);
            return;
        }
        list2 = this.mList;
        this.mConfig.getBackgroundThreadExecutor().execute(new Runnable(this, list2, list, n, runnable2){
            final AsyncListDiffer this$0;
            final Runnable val$commitCallback;
            final List val$newList;
            final List val$oldList;
            final int val$runGeneration;
            {
                this.this$0 = asyncListDiffer;
                this.val$oldList = list;
                this.val$newList = list2;
                this.val$runGeneration = n;
                this.val$commitCallback = runnable2;
            }

            @Override
            public void run() {
                DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtil.Callback(this){
                    final 1 this$1;
                    {
                        this.this$1 = var1_1;
                    }

                    @Override
                    public boolean areContentsTheSame(int n, int n2) {
                        Object e = this.this$1.val$oldList.get(n);
                        Object e2 = this.this$1.val$newList.get(n2);
                        if (e != null && e2 != null) {
                            return this.this$1.this$0.mConfig.getDiffCallback().areContentsTheSame(e, e2);
                        }
                        if (e == null && e2 == null) {
                            return true;
                        }
                        throw new AssertionError();
                    }

                    @Override
                    public boolean areItemsTheSame(int n, int n2) {
                        Object e = this.this$1.val$oldList.get(n);
                        Object e2 = this.this$1.val$newList.get(n2);
                        if (e != null && e2 != null) {
                            return this.this$1.this$0.mConfig.getDiffCallback().areItemsTheSame(e, e2);
                        }
                        boolean bl = e == null && e2 == null;
                        return bl;
                    }

                    @Override
                    public Object getChangePayload(int n, int n2) {
                        Object e = this.this$1.val$oldList.get(n);
                        Object e2 = this.this$1.val$newList.get(n2);
                        if (e != null && e2 != null) {
                            return this.this$1.this$0.mConfig.getDiffCallback().getChangePayload(e, e2);
                        }
                        throw new AssertionError();
                    }

                    @Override
                    public int getNewListSize() {
                        return this.this$1.val$newList.size();
                    }

                    @Override
                    public int getOldListSize() {
                        return this.this$1.val$oldList.size();
                    }
                });
                this.this$0.mMainThreadExecutor.execute(new Runnable(this, diffResult){
                    final 1 this$1;
                    final DiffUtil.DiffResult val$result;
                    {
                        this.this$1 = var1_1;
                        this.val$result = diffResult;
                    }

                    @Override
                    public void run() {
                        if (this.this$1.this$0.mMaxScheduledGeneration == this.this$1.val$runGeneration) {
                            this.this$1.this$0.latchList(this.this$1.val$newList, this.val$result, this.this$1.val$commitCallback);
                        }
                    }
                });
            }
        });
    }

    public static interface ListListener<T> {
        public void onCurrentListChanged(List<T> var1, List<T> var2);
    }

    private static class MainThreadExecutor
    implements Executor {
        final Handler mHandler = new Handler(Looper.getMainLooper());

        MainThreadExecutor() {
        }

        @Override
        public void execute(Runnable runnable2) {
            this.mHandler.post(runnable2);
        }
    }
}

