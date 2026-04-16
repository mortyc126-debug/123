/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.ArrayIteratorKt
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.room;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u001f\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00028\u0000H$\u00a2\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\rJ\u001b\u0010\f\u001a\u00020\u00072\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f\u00a2\u0006\u0002\u0010\u0010J\u0014\u0010\f\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\u00162\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f\u00a2\u0006\u0002\u0010\u0017J\u0014\u0010\u0015\u001a\u00020\u00162\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018J#\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u000f2\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f\u00a2\u0006\u0002\u0010\u001aJ!\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018\u00a2\u0006\u0002\u0010\u001bJ!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u001d2\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f\u00a2\u0006\u0002\u0010\u001eJ\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u001d2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018\u00a8\u0006\u001f"}, d2={"Landroidx/room/EntityInsertionAdapter;", "T", "Landroidx/room/SharedSQLiteStatement;", "database", "Landroidx/room/RoomDatabase;", "(Landroidx/room/RoomDatabase;)V", "bind", "", "statement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "entity", "(Landroidx/sqlite/db/SupportSQLiteStatement;Ljava/lang/Object;)V", "insert", "(Ljava/lang/Object;)V", "entities", "", "([Ljava/lang/Object;)V", "", "insertAndReturnId", "", "(Ljava/lang/Object;)J", "insertAndReturnIdsArray", "", "([Ljava/lang/Object;)[J", "", "insertAndReturnIdsArrayBox", "([Ljava/lang/Object;)[Ljava/lang/Long;", "(Ljava/util/Collection;)[Ljava/lang/Long;", "insertAndReturnIdsList", "", "([Ljava/lang/Object;)Ljava/util/List;", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
public abstract class EntityInsertionAdapter<T>
extends SharedSQLiteStatement {
    public EntityInsertionAdapter(RoomDatabase roomDatabase) {
        Intrinsics.checkNotNullParameter((Object)roomDatabase, (String)"database");
        super(roomDatabase);
    }

    protected abstract void bind(SupportSQLiteStatement var1, T var2);

    public final void insert(Iterable<? extends T> object) {
        Intrinsics.checkNotNullParameter(object, (String)"entities");
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        try {
            object = object.iterator();
            while (object.hasNext()) {
                this.bind(supportSQLiteStatement, object.next());
                supportSQLiteStatement.executeInsert();
            }
            return;
        }
        finally {
            this.release(supportSQLiteStatement);
        }
    }

    public final void insert(T t) {
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        try {
            this.bind(supportSQLiteStatement, t);
            supportSQLiteStatement.executeInsert();
            return;
        }
        finally {
            this.release(supportSQLiteStatement);
        }
    }

    public final void insert(T[] TArray) {
        int n;
        Intrinsics.checkNotNullParameter(TArray, (String)"entities");
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        try {
            n = TArray.length;
        }
        catch (Throwable throwable) {
            this.release(supportSQLiteStatement);
            throw throwable;
        }
        for (int i = 0; i < n; ++i) {
            this.bind(supportSQLiteStatement, TArray[i]);
            supportSQLiteStatement.executeInsert();
            continue;
        }
        this.release(supportSQLiteStatement);
        return;
    }

    public final long insertAndReturnId(T t) {
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        try {
            this.bind(supportSQLiteStatement, t);
            long l = supportSQLiteStatement.executeInsert();
            return l;
        }
        finally {
            this.release(supportSQLiteStatement);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final long[] insertAndReturnIdsArray(Collection<? extends T> iterator2) {
        Intrinsics.checkNotNullParameter(iterator2, (String)"entities");
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        try {
            long[] lArray = new long[iterator2.size()];
            iterator2 = (Iterable)((Object)iterator2);
            int n = 0;
            iterator2 = iterator2.iterator();
            while (iterator2.hasNext()) {
                Object t = iterator2.next();
                if (n < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                this.bind(supportSQLiteStatement, t);
                lArray[n] = supportSQLiteStatement.executeInsert();
                ++n;
            }
            return lArray;
        }
        finally {
            this.release(supportSQLiteStatement);
        }
    }

    public final long[] insertAndReturnIdsArray(T[] TArray) {
        int n;
        int n2;
        Intrinsics.checkNotNullParameter(TArray, (String)"entities");
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        long[] lArray = new long[TArray.length];
        int n3 = 0;
        try {
            n2 = TArray.length;
            n = 0;
        }
        catch (Throwable throwable) {
            this.release(supportSQLiteStatement);
            throw throwable;
        }
        while (n < n2) {
            this.bind(supportSQLiteStatement, TArray[n]);
            lArray[n3] = supportSQLiteStatement.executeInsert();
            ++n;
            ++n3;
        }
        this.release(supportSQLiteStatement);
        return lArray;
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> longArray) {
        int n;
        Intrinsics.checkNotNullParameter(longArray, (String)"entities");
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        Iterator<T> iterator2 = longArray.iterator();
        try {
            n = longArray.size();
            longArray = new Long[n];
        }
        catch (Throwable throwable) {
            this.release(supportSQLiteStatement);
            throw throwable;
        }
        for (int i = 0; i < n; ++i) {
            this.bind(supportSQLiteStatement, iterator2.next());
            longArray[i] = supportSQLiteStatement.executeInsert();
            continue;
        }
        this.release(supportSQLiteStatement);
        return longArray;
    }

    public final Long[] insertAndReturnIdsArrayBox(T[] objectArray) {
        int n;
        Intrinsics.checkNotNullParameter(objectArray, (String)"entities");
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        Iterator iterator2 = ArrayIteratorKt.iterator((Object[])objectArray);
        try {
            n = objectArray.length;
            objectArray = new Long[n];
        }
        catch (Throwable throwable) {
            this.release(supportSQLiteStatement);
            throw throwable;
        }
        for (int i = 0; i < n; ++i) {
            this.bind(supportSQLiteStatement, iterator2.next());
            objectArray[i] = supportSQLiteStatement.executeInsert();
            continue;
        }
        this.release(supportSQLiteStatement);
        return objectArray;
    }

    public final List<Long> insertAndReturnIdsList(Collection<? extends T> object) {
        Intrinsics.checkNotNullParameter(object, (String)"entities");
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        try {
            List list = CollectionsKt.createListBuilder();
            object = ((Iterable)object).iterator();
            while (object.hasNext()) {
                this.bind(supportSQLiteStatement, object.next());
                list.add(supportSQLiteStatement.executeInsert());
            }
            object = CollectionsKt.build((List)list);
            return object;
        }
        finally {
            this.release(supportSQLiteStatement);
        }
    }

    public final List<Long> insertAndReturnIdsList(T[] object) {
        Intrinsics.checkNotNullParameter(object, (String)"entities");
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        List list = CollectionsKt.createListBuilder();
        int n = ((T[])object).length;
        for (int i = 0; i < n; ++i) {
            this.bind(supportSQLiteStatement, object[i]);
            list.add(supportSQLiteStatement.executeInsert());
            continue;
        }
        try {
            object = CollectionsKt.build((List)list);
            return object;
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        finally {
            this.release(supportSQLiteStatement);
        }
    }
}

