/*
 * Decompiled with CFR 0.152.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder>
extends RecyclerView.Adapter<VH> {
    final AsyncListDiffer<T> mDiffer;
    private final AsyncListDiffer.ListListener<T> mListener = new AsyncListDiffer.ListListener<T>(this){
        final ListAdapter this$0;
        {
            this.this$0 = listAdapter;
        }

        @Override
        public void onCurrentListChanged(List<T> list, List<T> list2) {
            this.this$0.onCurrentListChanged(list, list2);
        }
    };

    protected ListAdapter(AsyncDifferConfig<T> asyncDifferConfig) {
        this.mDiffer = new AsyncListDiffer<T>(new AdapterListUpdateCallback(this), asyncDifferConfig);
        this.mDiffer.addListListener(this.mListener);
    }

    protected ListAdapter(DiffUtil.ItemCallback<T> itemCallback) {
        this.mDiffer = new AsyncListDiffer<T>(new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder<T>(itemCallback).build());
        this.mDiffer.addListListener(this.mListener);
    }

    public List<T> getCurrentList() {
        return this.mDiffer.getCurrentList();
    }

    protected T getItem(int n) {
        return this.mDiffer.getCurrentList().get(n);
    }

    @Override
    public int getItemCount() {
        return this.mDiffer.getCurrentList().size();
    }

    public void onCurrentListChanged(List<T> list, List<T> list2) {
    }

    public void submitList(List<T> list) {
        this.mDiffer.submitList(list);
    }

    public void submitList(List<T> list, Runnable runnable2) {
        this.mDiffer.submitList(list, runnable2);
    }
}

