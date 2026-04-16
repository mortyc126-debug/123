/*
 * Decompiled with CFR 0.152.
 */
package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public abstract class ViewModel {
    private final Map<String, Object> mBagOfTags = new HashMap<String, Object>();
    private volatile boolean mCleared = false;
    private final Set<Closeable> mCloseables = new LinkedHashSet<Closeable>();

    public ViewModel() {
    }

    public ViewModel(Closeable ... closeableArray) {
        this.mCloseables.addAll(Arrays.asList(closeableArray));
    }

    private static void closeWithRuntimeException(Object object) {
        if (object instanceof Closeable) {
            try {
                ((Closeable)object).close();
            }
            catch (IOException iOException) {
                throw new RuntimeException(iOException);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addCloseable(Closeable closeable) {
        if (this.mCloseables == null) return;
        Set<Closeable> set = this.mCloseables;
        synchronized (set) {
            this.mCloseables.add(closeable);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    final void clear() {
        Iterator<Object> iterator2;
        Object object;
        this.mCleared = true;
        if (this.mBagOfTags != null) {
            object = this.mBagOfTags;
            synchronized (object) {
                iterator2 = this.mBagOfTags.values().iterator();
                while (iterator2.hasNext()) {
                    ViewModel.closeWithRuntimeException(iterator2.next());
                }
            }
        }
        if (this.mCloseables != null) {
            object = this.mCloseables;
            synchronized (object) {
                iterator2 = this.mCloseables.iterator();
                while (iterator2.hasNext()) {
                    ViewModel.closeWithRuntimeException((Closeable)iterator2.next());
                }
            }
        }
        this.onCleared();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    <T> T getTag(String object) {
        if (this.mBagOfTags == null) {
            return null;
        }
        Map<String, Object> map2 = this.mBagOfTags;
        synchronized (map2) {
            object = this.mBagOfTags.get(object);
            return (T)object;
        }
    }

    protected void onCleared() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    <T> T setTagIfAbsent(String object, T t) {
        Object object2;
        Map<String, Object> map2 = this.mBagOfTags;
        synchronized (map2) {
            object2 = this.mBagOfTags.get(object);
            if (object2 == null) {
                this.mBagOfTags.put((String)object, t);
            }
        }
        object = object2 == null ? t : object2;
        if (this.mCleared) {
            ViewModel.closeWithRuntimeException(object);
        }
        return (T)object;
    }
}

