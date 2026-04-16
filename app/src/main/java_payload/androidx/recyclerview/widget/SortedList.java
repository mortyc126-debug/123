/*
 * Decompiled with CFR 0.152.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.BatchingListUpdateCallback;
import androidx.recyclerview.widget.ListUpdateCallback;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class SortedList<T> {
    private static final int CAPACITY_GROWTH = 10;
    private static final int DELETION = 2;
    private static final int INSERTION = 1;
    public static final int INVALID_POSITION = -1;
    private static final int LOOKUP = 4;
    private static final int MIN_CAPACITY = 10;
    private BatchedCallback mBatchedCallback;
    private Callback mCallback;
    T[] mData;
    private int mNewDataStart;
    private T[] mOldData;
    private int mOldDataSize;
    private int mOldDataStart;
    private int mSize;
    private final Class<T> mTClass;

    public SortedList(Class<T> clazz, Callback<T> callback2) {
        this(clazz, callback2, 10);
    }

    public SortedList(Class<T> clazz, Callback<T> callback2, int n) {
        this.mTClass = clazz;
        this.mData = (Object[])Array.newInstance(clazz, n);
        this.mCallback = callback2;
        this.mSize = 0;
    }

    private int add(T t, boolean bl) {
        int n;
        int n2 = this.findIndexOf(t, this.mData, 0, this.mSize, 1);
        if (n2 == -1) {
            n = 0;
        } else {
            n = n2;
            if (n2 < this.mSize) {
                T t2 = this.mData[n2];
                n = n2;
                if (this.mCallback.areItemsTheSame(t2, t)) {
                    if (this.mCallback.areContentsTheSame(t2, t)) {
                        this.mData[n2] = t;
                        return n2;
                    }
                    this.mData[n2] = t;
                    this.mCallback.onChanged(n2, 1, this.mCallback.getChangePayload(t2, t));
                    return n2;
                }
            }
        }
        this.addToData(n, t);
        if (bl) {
            this.mCallback.onInserted(n, 1);
        }
        return n;
    }

    private void addAllInternal(T[] TArray) {
        if (TArray.length < 1) {
            return;
        }
        int n = this.sortAndDedup(TArray);
        if (this.mSize == 0) {
            this.mData = TArray;
            this.mSize = n;
            this.mCallback.onInserted(0, n);
        } else {
            this.merge(TArray, n);
        }
    }

    private void addToData(int n, T t) {
        if (n <= this.mSize) {
            if (this.mSize == this.mData.length) {
                Object[] objectArray = (Object[])Array.newInstance(this.mTClass, this.mData.length + 10);
                System.arraycopy(this.mData, 0, objectArray, 0, n);
                objectArray[n] = t;
                System.arraycopy(this.mData, n, objectArray, n + 1, this.mSize - n);
                this.mData = objectArray;
            } else {
                System.arraycopy(this.mData, n, this.mData, n + 1, this.mSize - n);
                this.mData[n] = t;
            }
            ++this.mSize;
            return;
        }
        throw new IndexOutOfBoundsException("cannot add item to " + n + " because size is " + this.mSize);
    }

    private T[] copyArray(T[] TArray) {
        Object[] objectArray = (Object[])Array.newInstance(this.mTClass, TArray.length);
        System.arraycopy(TArray, 0, objectArray, 0, TArray.length);
        return objectArray;
    }

    private int findIndexOf(T t, T[] TArray, int n, int n2, int n3) {
        int n4;
        while (true) {
            n4 = -1;
            if (n >= n2) break;
            n4 = (n + n2) / 2;
            T t2 = TArray[n4];
            int n5 = this.mCallback.compare(t2, t);
            if (n5 < 0) {
                n = n4 + 1;
                continue;
            }
            if (n5 == 0) {
                if (this.mCallback.areItemsTheSame(t2, t)) {
                    return n4;
                }
                n = this.linearEqualitySearch(t, n4, n, n2);
                if (n3 == 1) {
                    if (n == -1) {
                        n = n4;
                    }
                    return n;
                }
                return n;
            }
            n2 = n4;
        }
        n2 = n4;
        if (n3 == 1) {
            n2 = n;
        }
        return n2;
    }

    private int findSameItem(T t, T[] TArray, int n, int n2) {
        while (n < n2) {
            if (this.mCallback.areItemsTheSame(TArray[n], t)) {
                return n;
            }
            ++n;
        }
        return -1;
    }

    private int linearEqualitySearch(T t, int n, int n2, int n3) {
        T t2;
        for (int i = n - 1; i >= n2 && this.mCallback.compare(t2 = this.mData[i], t) == 0; --i) {
            if (!this.mCallback.areItemsTheSame(t2, t)) continue;
            return i;
        }
        ++n;
        while (n < n3 && this.mCallback.compare(t2 = this.mData[n], t) == 0) {
            if (this.mCallback.areItemsTheSame(t2, t)) {
                return n;
            }
            ++n;
        }
        return -1;
    }

    private void merge(T[] TArray, int n) {
        boolean bl = this.mCallback instanceof BatchedCallback ^ true;
        if (bl) {
            this.beginBatchedUpdates();
        }
        this.mOldData = this.mData;
        this.mOldDataStart = 0;
        this.mOldDataSize = this.mSize;
        int n2 = this.mSize;
        this.mData = (Object[])Array.newInstance(this.mTClass, n2 + n + 10);
        this.mNewDataStart = 0;
        n2 = 0;
        while (true) {
            block10: {
                block8: {
                    block9: {
                        if (this.mOldDataStart >= this.mOldDataSize && n2 >= n) break block8;
                        if (this.mOldDataStart != this.mOldDataSize) break block9;
                        System.arraycopy(TArray, n2, this.mData, this.mNewDataStart, n -= n2);
                        this.mNewDataStart += n;
                        this.mSize += n;
                        this.mCallback.onInserted(this.mNewDataStart - n, n);
                        break block8;
                    }
                    if (n2 != n) break block10;
                    n = this.mOldDataSize - this.mOldDataStart;
                    System.arraycopy(this.mOldData, this.mOldDataStart, this.mData, this.mNewDataStart, n);
                    this.mNewDataStart += n;
                }
                this.mOldData = null;
                if (bl) {
                    this.endBatchedUpdates();
                }
                return;
            }
            Object object = this.mOldData[this.mOldDataStart];
            Object object2 = TArray[n2];
            int n3 = this.mCallback.compare(object, object2);
            if (n3 > 0) {
                object = this.mData;
                n3 = this.mNewDataStart;
                this.mNewDataStart = n3 + 1;
                object[n3] = object2;
                ++this.mSize;
                ++n2;
                this.mCallback.onInserted(this.mNewDataStart - 1, 1);
                continue;
            }
            if (n3 == 0 && this.mCallback.areItemsTheSame(object, object2)) {
                T[] TArray2 = this.mData;
                n3 = this.mNewDataStart;
                this.mNewDataStart = n3 + 1;
                TArray2[n3] = object2;
                n3 = n2 + 1;
                ++this.mOldDataStart;
                n2 = n3;
                if (this.mCallback.areContentsTheSame(object, object2)) continue;
                this.mCallback.onChanged(this.mNewDataStart - 1, 1, this.mCallback.getChangePayload(object, object2));
                n2 = n3;
                continue;
            }
            object2 = this.mData;
            n3 = this.mNewDataStart;
            this.mNewDataStart = n3 + 1;
            object2[n3] = object;
            ++this.mOldDataStart;
        }
    }

    private boolean remove(T t, boolean bl) {
        int n = this.findIndexOf(t, this.mData, 0, this.mSize, 2);
        if (n == -1) {
            return false;
        }
        this.removeItemAtIndex(n, bl);
        return true;
    }

    private void removeItemAtIndex(int n, boolean bl) {
        System.arraycopy(this.mData, n + 1, this.mData, n, this.mSize - n - 1);
        --this.mSize;
        this.mData[this.mSize] = null;
        if (bl) {
            this.mCallback.onRemoved(n, 1);
        }
    }

    private void replaceAllInsert(T t) {
        this.mData[this.mNewDataStart] = t;
        ++this.mNewDataStart;
        ++this.mSize;
        this.mCallback.onInserted(this.mNewDataStart - 1, 1);
    }

    private void replaceAllInternal(T[] TArray) {
        boolean bl = this.mCallback instanceof BatchedCallback ^ true;
        if (bl) {
            this.beginBatchedUpdates();
        }
        this.mOldDataStart = 0;
        this.mOldDataSize = this.mSize;
        this.mOldData = this.mData;
        this.mNewDataStart = 0;
        int n = this.sortAndDedup(TArray);
        this.mData = (Object[])Array.newInstance(this.mTClass, n);
        while (true) {
            int n2;
            block11: {
                block9: {
                    block10: {
                        if (this.mNewDataStart >= n && this.mOldDataStart >= this.mOldDataSize) break block9;
                        if (this.mOldDataStart < this.mOldDataSize) break block10;
                        n2 = this.mNewDataStart;
                        System.arraycopy(TArray, n2, this.mData, n2, n -= this.mNewDataStart);
                        this.mNewDataStart += n;
                        this.mSize += n;
                        this.mCallback.onInserted(n2, n);
                        break block9;
                    }
                    if (this.mNewDataStart < n) break block11;
                    n = this.mOldDataSize - this.mOldDataStart;
                    this.mSize -= n;
                    this.mCallback.onRemoved(this.mNewDataStart, n);
                }
                this.mOldData = null;
                if (bl) {
                    this.endBatchedUpdates();
                }
                return;
            }
            T t = this.mOldData[this.mOldDataStart];
            T t2 = TArray[this.mNewDataStart];
            n2 = this.mCallback.compare(t, t2);
            if (n2 < 0) {
                this.replaceAllRemove();
                continue;
            }
            if (n2 > 0) {
                this.replaceAllInsert(t2);
                continue;
            }
            if (!this.mCallback.areItemsTheSame(t, t2)) {
                this.replaceAllRemove();
                this.replaceAllInsert(t2);
                continue;
            }
            this.mData[this.mNewDataStart] = t2;
            ++this.mOldDataStart;
            ++this.mNewDataStart;
            if (this.mCallback.areContentsTheSame(t, t2)) continue;
            this.mCallback.onChanged(this.mNewDataStart - 1, 1, this.mCallback.getChangePayload(t, t2));
        }
    }

    private void replaceAllRemove() {
        --this.mSize;
        ++this.mOldDataStart;
        this.mCallback.onRemoved(this.mNewDataStart, 1);
    }

    private int sortAndDedup(T[] TArray) {
        if (TArray.length == 0) {
            return 0;
        }
        Arrays.sort(TArray, this.mCallback);
        int n = 0;
        int n2 = 1;
        for (int i = 1; i < TArray.length; ++i) {
            T t = TArray[i];
            if (this.mCallback.compare(TArray[n], t) == 0) {
                int n3 = this.findSameItem(t, TArray, n, n2);
                if (n3 != -1) {
                    TArray[n3] = t;
                    continue;
                }
                if (n2 != i) {
                    TArray[n2] = t;
                }
                ++n2;
                continue;
            }
            if (n2 != i) {
                TArray[n2] = t;
            }
            n = n2++;
        }
        return n2;
    }

    private void throwIfInMutationOperation() {
        if (this.mOldData == null) {
            return;
        }
        throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
    }

    public int add(T t) {
        this.throwIfInMutationOperation();
        return this.add(t, true);
    }

    public void addAll(Collection<T> collection) {
        this.addAll(collection.toArray((Object[])Array.newInstance(this.mTClass, collection.size())), true);
    }

    public void addAll(T ... TArray) {
        this.addAll(TArray, false);
    }

    public void addAll(T[] TArray, boolean bl) {
        this.throwIfInMutationOperation();
        if (TArray.length == 0) {
            return;
        }
        if (bl) {
            this.addAllInternal(TArray);
        } else {
            this.addAllInternal(this.copyArray(TArray));
        }
    }

    public void beginBatchedUpdates() {
        this.throwIfInMutationOperation();
        if (this.mCallback instanceof BatchedCallback) {
            return;
        }
        if (this.mBatchedCallback == null) {
            this.mBatchedCallback = new BatchedCallback(this.mCallback);
        }
        this.mCallback = this.mBatchedCallback;
    }

    public void clear() {
        this.throwIfInMutationOperation();
        if (this.mSize == 0) {
            return;
        }
        int n = this.mSize;
        Arrays.fill(this.mData, 0, n, null);
        this.mSize = 0;
        this.mCallback.onRemoved(0, n);
    }

    public void endBatchedUpdates() {
        this.throwIfInMutationOperation();
        if (this.mCallback instanceof BatchedCallback) {
            ((BatchedCallback)this.mCallback).dispatchLastEvent();
        }
        if (this.mCallback == this.mBatchedCallback) {
            this.mCallback = this.mBatchedCallback.mWrappedCallback;
        }
    }

    public T get(int n) throws IndexOutOfBoundsException {
        if (n < this.mSize && n >= 0) {
            if (this.mOldData != null && n >= this.mNewDataStart) {
                return this.mOldData[n - this.mNewDataStart + this.mOldDataStart];
            }
            return this.mData[n];
        }
        throw new IndexOutOfBoundsException("Asked to get item at " + n + " but size is " + this.mSize);
    }

    public int indexOf(T t) {
        if (this.mOldData != null) {
            int n = this.findIndexOf(t, this.mData, 0, this.mNewDataStart, 4);
            if (n != -1) {
                return n;
            }
            n = this.findIndexOf(t, this.mOldData, this.mOldDataStart, this.mOldDataSize, 4);
            if (n != -1) {
                return n - this.mOldDataStart + this.mNewDataStart;
            }
            return -1;
        }
        return this.findIndexOf(t, this.mData, 0, this.mSize, 4);
    }

    public void recalculatePositionOfItemAt(int n) {
        this.throwIfInMutationOperation();
        T t = this.get(n);
        this.removeItemAtIndex(n, false);
        int n2 = this.add(t, false);
        if (n != n2) {
            this.mCallback.onMoved(n, n2);
        }
    }

    public boolean remove(T t) {
        this.throwIfInMutationOperation();
        return this.remove(t, true);
    }

    public T removeItemAt(int n) {
        this.throwIfInMutationOperation();
        T t = this.get(n);
        this.removeItemAtIndex(n, true);
        return t;
    }

    public void replaceAll(Collection<T> collection) {
        this.replaceAll(collection.toArray((Object[])Array.newInstance(this.mTClass, collection.size())), true);
    }

    public void replaceAll(T ... TArray) {
        this.replaceAll(TArray, false);
    }

    public void replaceAll(T[] TArray, boolean bl) {
        this.throwIfInMutationOperation();
        if (bl) {
            this.replaceAllInternal(TArray);
        } else {
            this.replaceAllInternal(this.copyArray(TArray));
        }
    }

    public int size() {
        return this.mSize;
    }

    public void updateItemAt(int n, T t) {
        this.throwIfInMutationOperation();
        T t2 = this.get(n);
        int n2 = t2 != t && this.mCallback.areContentsTheSame(t2, t) ? 0 : 1;
        if (t2 != t && this.mCallback.compare(t2, t) == 0) {
            this.mData[n] = t;
            if (n2 != 0) {
                this.mCallback.onChanged(n, 1, this.mCallback.getChangePayload(t2, t));
            }
            return;
        }
        if (n2 != 0) {
            this.mCallback.onChanged(n, 1, this.mCallback.getChangePayload(t2, t));
        }
        this.removeItemAtIndex(n, false);
        n2 = this.add(t, false);
        if (n != n2) {
            this.mCallback.onMoved(n, n2);
        }
    }

    public static class BatchedCallback<T2>
    extends Callback<T2> {
        private final BatchingListUpdateCallback mBatchingListUpdateCallback;
        final Callback<T2> mWrappedCallback;

        public BatchedCallback(Callback<T2> callback2) {
            this.mWrappedCallback = callback2;
            this.mBatchingListUpdateCallback = new BatchingListUpdateCallback(this.mWrappedCallback);
        }

        @Override
        public boolean areContentsTheSame(T2 T2, T2 T22) {
            return this.mWrappedCallback.areContentsTheSame(T2, T22);
        }

        @Override
        public boolean areItemsTheSame(T2 T2, T2 T22) {
            return this.mWrappedCallback.areItemsTheSame(T2, T22);
        }

        @Override
        public int compare(T2 T2, T2 T22) {
            return this.mWrappedCallback.compare(T2, T22);
        }

        public void dispatchLastEvent() {
            this.mBatchingListUpdateCallback.dispatchLastEvent();
        }

        @Override
        public Object getChangePayload(T2 T2, T2 T22) {
            return this.mWrappedCallback.getChangePayload(T2, T22);
        }

        @Override
        public void onChanged(int n, int n2) {
            this.mBatchingListUpdateCallback.onChanged(n, n2, null);
        }

        @Override
        public void onChanged(int n, int n2, Object object) {
            this.mBatchingListUpdateCallback.onChanged(n, n2, object);
        }

        @Override
        public void onInserted(int n, int n2) {
            this.mBatchingListUpdateCallback.onInserted(n, n2);
        }

        @Override
        public void onMoved(int n, int n2) {
            this.mBatchingListUpdateCallback.onMoved(n, n2);
        }

        @Override
        public void onRemoved(int n, int n2) {
            this.mBatchingListUpdateCallback.onRemoved(n, n2);
        }
    }

    public static abstract class Callback<T2>
    implements Comparator<T2>,
    ListUpdateCallback {
        public abstract boolean areContentsTheSame(T2 var1, T2 var2);

        public abstract boolean areItemsTheSame(T2 var1, T2 var2);

        @Override
        public abstract int compare(T2 var1, T2 var2);

        public Object getChangePayload(T2 T2, T2 T22) {
            return null;
        }

        public abstract void onChanged(int var1, int var2);

        @Override
        public void onChanged(int n, int n2, Object object) {
            this.onChanged(n, n2);
        }
    }
}

