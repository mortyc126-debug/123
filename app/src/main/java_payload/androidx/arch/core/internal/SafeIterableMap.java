/*
 * Decompiled with CFR 0.152.
 */
package androidx.arch.core.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class SafeIterableMap<K, V>
implements Iterable<Map.Entry<K, V>> {
    private Entry<K, V> mEnd;
    private final WeakHashMap<SupportRemove<K, V>, Boolean> mIterators = new WeakHashMap();
    private int mSize = 0;
    Entry<K, V> mStart;

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        DescendingIterator<K, V> descendingIterator = new DescendingIterator<K, V>(this.mEnd, this.mStart);
        this.mIterators.put(descendingIterator, false);
        return descendingIterator;
    }

    public Map.Entry<K, V> eldest() {
        return this.mStart;
    }

    public boolean equals(Object iterator2) {
        boolean bl = true;
        if (iterator2 == this) {
            return true;
        }
        if (!(iterator2 instanceof SafeIterableMap)) {
            return false;
        }
        Object object = (SafeIterableMap)((Object)iterator2);
        if (this.size() != ((SafeIterableMap)object).size()) {
            return false;
        }
        iterator2 = this.iterator();
        Iterator<Map.Entry<K, V>> iterator3 = ((SafeIterableMap)object).iterator();
        while (iterator2.hasNext() && iterator3.hasNext()) {
            object = iterator2.next();
            Map.Entry<K, V> entry = iterator3.next();
            if ((object != null || entry == null) && (object == null || object.equals(entry))) continue;
            return false;
        }
        if (iterator2.hasNext() || iterator3.hasNext()) {
            bl = false;
        }
        return bl;
    }

    protected Entry<K, V> get(K k) {
        Entry<K, V> entry = this.mStart;
        while (entry != null && !entry.mKey.equals(k)) {
            entry = entry.mNext;
        }
        return entry;
    }

    public int hashCode() {
        int n = 0;
        Iterator<Map.Entry<K, V>> iterator2 = this.iterator();
        while (iterator2.hasNext()) {
            n += ((Object)iterator2.next()).hashCode();
        }
        return n;
    }

    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        AscendingIterator<K, V> ascendingIterator = new AscendingIterator<K, V>(this.mStart, this.mEnd);
        this.mIterators.put(ascendingIterator, false);
        return ascendingIterator;
    }

    public IteratorWithAdditions iteratorWithAdditions() {
        IteratorWithAdditions iteratorWithAdditions = new IteratorWithAdditions(this);
        this.mIterators.put(iteratorWithAdditions, false);
        return iteratorWithAdditions;
    }

    public Map.Entry<K, V> newest() {
        return this.mEnd;
    }

    Entry<K, V> put(K object, V v) {
        object = new Entry<K, V>(object, v);
        ++this.mSize;
        if (this.mEnd == null) {
            this.mStart = object;
            this.mEnd = this.mStart;
            return object;
        }
        this.mEnd.mNext = object;
        ((Entry)object).mPrevious = this.mEnd;
        this.mEnd = object;
        return object;
    }

    public V putIfAbsent(K k, V v) {
        Entry<K, V> entry = this.get(k);
        if (entry != null) {
            return entry.mValue;
        }
        this.put(k, v);
        return null;
    }

    public V remove(K object) {
        Entry<K, V> entry = this.get(object);
        if (entry == null) {
            return null;
        }
        --this.mSize;
        if (!this.mIterators.isEmpty()) {
            object = this.mIterators.keySet().iterator();
            while (object.hasNext()) {
                ((SupportRemove)object.next()).supportRemove(entry);
            }
        }
        if (entry.mPrevious != null) {
            entry.mPrevious.mNext = entry.mNext;
        } else {
            this.mStart = entry.mNext;
        }
        if (entry.mNext != null) {
            entry.mNext.mPrevious = entry.mPrevious;
        } else {
            this.mEnd = entry.mPrevious;
        }
        entry.mNext = null;
        entry.mPrevious = null;
        return entry.mValue;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Iterator<Map.Entry<K, V>> iterator2 = this.iterator();
        while (iterator2.hasNext()) {
            stringBuilder.append(iterator2.next().toString());
            if (!iterator2.hasNext()) continue;
            stringBuilder.append(", ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    static class AscendingIterator<K, V>
    extends ListIterator<K, V> {
        AscendingIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            super(entry, entry2);
        }

        @Override
        Entry<K, V> backward(Entry<K, V> entry) {
            return entry.mPrevious;
        }

        @Override
        Entry<K, V> forward(Entry<K, V> entry) {
            return entry.mNext;
        }
    }

    private static class DescendingIterator<K, V>
    extends ListIterator<K, V> {
        DescendingIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            super(entry, entry2);
        }

        @Override
        Entry<K, V> backward(Entry<K, V> entry) {
            return entry.mNext;
        }

        @Override
        Entry<K, V> forward(Entry<K, V> entry) {
            return entry.mPrevious;
        }
    }

    static class Entry<K, V>
    implements Map.Entry<K, V> {
        final K mKey;
        Entry<K, V> mNext;
        Entry<K, V> mPrevious;
        final V mValue;

        Entry(K k, V v) {
            this.mKey = k;
            this.mValue = v;
        }

        @Override
        public boolean equals(Object object) {
            boolean bl = true;
            if (object == this) {
                return true;
            }
            if (!(object instanceof Entry)) {
                return false;
            }
            object = (Entry)object;
            if (!this.mKey.equals(((Entry)object).mKey) || !this.mValue.equals(((Entry)object).mValue)) {
                bl = false;
            }
            return bl;
        }

        @Override
        public K getKey() {
            return this.mKey;
        }

        @Override
        public V getValue() {
            return this.mValue;
        }

        @Override
        public int hashCode() {
            return this.mKey.hashCode() ^ this.mValue.hashCode();
        }

        @Override
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.mKey + "=" + this.mValue;
        }
    }

    public class IteratorWithAdditions
    extends SupportRemove<K, V>
    implements Iterator<Map.Entry<K, V>> {
        private boolean mBeforeStart;
        private Entry<K, V> mCurrent;
        final SafeIterableMap this$0;

        IteratorWithAdditions(SafeIterableMap safeIterableMap) {
            this.this$0 = safeIterableMap;
            this.mBeforeStart = true;
        }

        @Override
        public boolean hasNext() {
            boolean bl = this.mBeforeStart;
            boolean bl2 = true;
            boolean bl3 = true;
            if (bl) {
                bl2 = this.this$0.mStart != null ? bl3 : false;
                return bl2;
            }
            if (this.mCurrent == null || this.mCurrent.mNext == null) {
                bl2 = false;
            }
            return bl2;
        }

        @Override
        public Map.Entry<K, V> next() {
            if (this.mBeforeStart) {
                this.mBeforeStart = false;
                this.mCurrent = this.this$0.mStart;
            } else {
                Entry entry = this.mCurrent != null ? this.mCurrent.mNext : null;
                this.mCurrent = entry;
            }
            return this.mCurrent;
        }

        @Override
        void supportRemove(Entry<K, V> entry) {
            if (entry == this.mCurrent) {
                this.mCurrent = this.mCurrent.mPrevious;
                boolean bl = this.mCurrent == null;
                this.mBeforeStart = bl;
            }
        }
    }

    private static abstract class ListIterator<K, V>
    extends SupportRemove<K, V>
    implements Iterator<Map.Entry<K, V>> {
        Entry<K, V> mExpectedEnd;
        Entry<K, V> mNext;

        ListIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            this.mExpectedEnd = entry2;
            this.mNext = entry;
        }

        private Entry<K, V> nextNode() {
            if (this.mNext != this.mExpectedEnd && this.mExpectedEnd != null) {
                return this.forward(this.mNext);
            }
            return null;
        }

        abstract Entry<K, V> backward(Entry<K, V> var1);

        abstract Entry<K, V> forward(Entry<K, V> var1);

        @Override
        public boolean hasNext() {
            boolean bl = this.mNext != null;
            return bl;
        }

        @Override
        public Map.Entry<K, V> next() {
            Entry<K, V> entry = this.mNext;
            this.mNext = this.nextNode();
            return entry;
        }

        @Override
        public void supportRemove(Entry<K, V> entry) {
            if (this.mExpectedEnd == entry && entry == this.mNext) {
                this.mNext = null;
                this.mExpectedEnd = null;
            }
            if (this.mExpectedEnd == entry) {
                this.mExpectedEnd = this.backward(this.mExpectedEnd);
            }
            if (this.mNext == entry) {
                this.mNext = this.nextNode();
            }
        }
    }

    public static abstract class SupportRemove<K, V> {
        abstract void supportRemove(Entry<K, V> var1);
    }
}

