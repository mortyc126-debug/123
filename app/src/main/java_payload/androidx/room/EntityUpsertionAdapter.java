/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteConstraintException
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 */
package androidx.room;

import android.database.sqlite.SQLiteConstraintException;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0013\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u000eJ\u001b\u0010\f\u001a\u00020\t2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0010\u00a2\u0006\u0002\u0010\u0011J\u0014\u0010\f\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0015J\u001b\u0010\u0016\u001a\u00020\u00172\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0010\u00a2\u0006\u0002\u0010\u0018J\u0014\u0010\u0016\u001a\u00020\u00172\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019J#\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00102\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0010\u00a2\u0006\u0002\u0010\u001bJ!\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019\u00a2\u0006\u0002\u0010\u001cJ!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u001e2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0010\u00a2\u0006\u0002\u0010\u001fJ\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u001e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2={"Landroidx/room/EntityUpsertionAdapter;", "T", "", "insertionAdapter", "Landroidx/room/EntityInsertionAdapter;", "updateAdapter", "Landroidx/room/EntityDeletionOrUpdateAdapter;", "(Landroidx/room/EntityInsertionAdapter;Landroidx/room/EntityDeletionOrUpdateAdapter;)V", "checkUniquenessException", "", "ex", "Landroid/database/sqlite/SQLiteConstraintException;", "upsert", "entity", "(Ljava/lang/Object;)V", "entities", "", "([Ljava/lang/Object;)V", "", "upsertAndReturnId", "", "(Ljava/lang/Object;)J", "upsertAndReturnIdsArray", "", "([Ljava/lang/Object;)[J", "", "upsertAndReturnIdsArrayBox", "([Ljava/lang/Object;)[Ljava/lang/Long;", "(Ljava/util/Collection;)[Ljava/lang/Long;", "upsertAndReturnIdsList", "", "([Ljava/lang/Object;)Ljava/util/List;", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
public final class EntityUpsertionAdapter<T> {
    private final EntityInsertionAdapter<T> insertionAdapter;
    private final EntityDeletionOrUpdateAdapter<T> updateAdapter;

    public EntityUpsertionAdapter(EntityInsertionAdapter<T> entityInsertionAdapter, EntityDeletionOrUpdateAdapter<T> entityDeletionOrUpdateAdapter) {
        Intrinsics.checkNotNullParameter(entityInsertionAdapter, (String)"insertionAdapter");
        Intrinsics.checkNotNullParameter(entityDeletionOrUpdateAdapter, (String)"updateAdapter");
        this.insertionAdapter = entityInsertionAdapter;
        this.updateAdapter = entityDeletionOrUpdateAdapter;
    }

    private final void checkUniquenessException(SQLiteConstraintException sQLiteConstraintException) {
        String string2 = sQLiteConstraintException.getMessage();
        if (string2 != null) {
            if (StringsKt.contains((CharSequence)string2, (CharSequence)"1555", (boolean)true)) {
                return;
            }
            throw sQLiteConstraintException;
        }
        throw sQLiteConstraintException;
    }

    public final void upsert(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, (String)"entities");
        for (T t : iterable) {
            try {
                this.insertionAdapter.insert(t);
            }
            catch (SQLiteConstraintException sQLiteConstraintException) {
                this.checkUniquenessException(sQLiteConstraintException);
                this.updateAdapter.handle(t);
            }
        }
    }

    public final void upsert(T t) {
        try {
            this.insertionAdapter.insert(t);
        }
        catch (SQLiteConstraintException sQLiteConstraintException) {
            this.checkUniquenessException(sQLiteConstraintException);
            this.updateAdapter.handle(t);
        }
    }

    public final void upsert(T[] TArray) {
        Intrinsics.checkNotNullParameter(TArray, (String)"entities");
        for (T t : TArray) {
            try {
                this.insertionAdapter.insert(t);
            }
            catch (SQLiteConstraintException sQLiteConstraintException) {
                this.checkUniquenessException(sQLiteConstraintException);
                this.updateAdapter.handle(t);
            }
        }
    }

    public final long upsertAndReturnId(T t) {
        long l;
        try {
            l = this.insertionAdapter.insertAndReturnId(t);
        }
        catch (SQLiteConstraintException sQLiteConstraintException) {
            this.checkUniquenessException(sQLiteConstraintException);
            this.updateAdapter.handle(t);
            l = -1L;
        }
        return l;
    }

    public final long[] upsertAndReturnIdsArray(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, (String)"entities");
        Iterator<T> iterator2 = collection.iterator();
        int n = collection.size();
        long[] lArray = new long[n];
        for (int i = 0; i < n; ++i) {
            long l;
            T t = iterator2.next();
            try {
                l = this.insertionAdapter.insertAndReturnId(t);
            }
            catch (SQLiteConstraintException sQLiteConstraintException) {
                this.checkUniquenessException(sQLiteConstraintException);
                this.updateAdapter.handle(t);
                l = -1L;
            }
            lArray[i] = l;
        }
        return lArray;
    }

    public final long[] upsertAndReturnIdsArray(T[] TArray) {
        Intrinsics.checkNotNullParameter(TArray, (String)"entities");
        int n = TArray.length;
        long[] lArray = new long[n];
        for (int i = 0; i < n; ++i) {
            long l;
            try {
                l = this.insertionAdapter.insertAndReturnId(TArray[i]);
            }
            catch (SQLiteConstraintException sQLiteConstraintException) {
                this.checkUniquenessException(sQLiteConstraintException);
                this.updateAdapter.handle(TArray[i]);
                l = -1L;
            }
            lArray[i] = l;
        }
        return lArray;
    }

    public final Long[] upsertAndReturnIdsArrayBox(Collection<? extends T> longArray) {
        Intrinsics.checkNotNullParameter(longArray, (String)"entities");
        Iterator<T> iterator2 = longArray.iterator();
        int n = longArray.size();
        longArray = new Long[n];
        for (int i = 0; i < n; ++i) {
            long l;
            T t = iterator2.next();
            try {
                l = this.insertionAdapter.insertAndReturnId(t);
            }
            catch (SQLiteConstraintException sQLiteConstraintException) {
                this.checkUniquenessException(sQLiteConstraintException);
                this.updateAdapter.handle(t);
                l = -1L;
            }
            longArray[i] = l;
        }
        return longArray;
    }

    public final Long[] upsertAndReturnIdsArrayBox(T[] TArray) {
        Intrinsics.checkNotNullParameter(TArray, (String)"entities");
        int n = TArray.length;
        Long[] longArray = new Long[n];
        for (int i = 0; i < n; ++i) {
            long l;
            try {
                l = this.insertionAdapter.insertAndReturnId(TArray[i]);
            }
            catch (SQLiteConstraintException sQLiteConstraintException) {
                this.checkUniquenessException(sQLiteConstraintException);
                this.updateAdapter.handle(TArray[i]);
                l = -1L;
            }
            longArray[i] = l;
        }
        return longArray;
    }

    public final List<Long> upsertAndReturnIdsList(Collection<? extends T> collection2) {
        Intrinsics.checkNotNullParameter(collection2, (String)"entities");
        List list = CollectionsKt.createListBuilder();
        for (Collection<Object> collection2 : (Iterable)collection2) {
            try {
                list.add(this.insertionAdapter.insertAndReturnId(collection2));
            }
            catch (SQLiteConstraintException sQLiteConstraintException) {
                this.checkUniquenessException(sQLiteConstraintException);
                this.updateAdapter.handle(collection2);
                list.add(-1L);
            }
        }
        return CollectionsKt.build((List)list);
    }

    public final List<Long> upsertAndReturnIdsList(T[] TArray) {
        Intrinsics.checkNotNullParameter(TArray, (String)"entities");
        List list = CollectionsKt.createListBuilder();
        for (T t : TArray) {
            try {
                list.add(this.insertionAdapter.insertAndReturnId(t));
            }
            catch (SQLiteConstraintException sQLiteConstraintException) {
                this.checkUniquenessException(sQLiteConstraintException);
                this.updateAdapter.handle(t);
                list.add(-1L);
            }
        }
        return CollectionsKt.build((List)list);
    }
}

