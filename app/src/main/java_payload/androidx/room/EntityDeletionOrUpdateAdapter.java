/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.room;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0000\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H$\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH$J\u0013\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\u000f2\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0013\u00a2\u0006\u0002\u0010\u0014J\u0014\u0010\u0011\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\u00a8\u0006\u0016"}, d2={"Landroidx/room/EntityDeletionOrUpdateAdapter;", "T", "Landroidx/room/SharedSQLiteStatement;", "database", "Landroidx/room/RoomDatabase;", "(Landroidx/room/RoomDatabase;)V", "bind", "", "statement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "entity", "(Landroidx/sqlite/db/SupportSQLiteStatement;Ljava/lang/Object;)V", "createQuery", "", "handle", "", "(Ljava/lang/Object;)I", "handleMultiple", "entities", "", "([Ljava/lang/Object;)I", "", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
public abstract class EntityDeletionOrUpdateAdapter<T>
extends SharedSQLiteStatement {
    public EntityDeletionOrUpdateAdapter(RoomDatabase roomDatabase) {
        Intrinsics.checkNotNullParameter((Object)roomDatabase, (String)"database");
        super(roomDatabase);
    }

    protected abstract void bind(SupportSQLiteStatement var1, T var2);

    @Override
    protected abstract String createQuery();

    public final int handle(T t) {
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        try {
            this.bind(supportSQLiteStatement, t);
            int n = supportSQLiteStatement.executeUpdateDelete();
            return n;
        }
        finally {
            this.release(supportSQLiteStatement);
        }
    }

    public final int handleMultiple(Iterable<? extends T> object) {
        Intrinsics.checkNotNullParameter(object, (String)"entities");
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        int n = 0;
        try {
            object = object.iterator();
            while (object.hasNext()) {
                this.bind(supportSQLiteStatement, object.next());
                int n2 = supportSQLiteStatement.executeUpdateDelete();
                n += n2;
            }
        }
        catch (Throwable throwable) {
            this.release(supportSQLiteStatement);
            throw throwable;
        }
        this.release(supportSQLiteStatement);
        return n;
    }

    public final int handleMultiple(T[] TArray) {
        int n;
        Intrinsics.checkNotNullParameter(TArray, (String)"entities");
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        int n2 = 0;
        try {
            n = TArray.length;
        }
        catch (Throwable throwable) {
            this.release(supportSQLiteStatement);
            throw throwable;
        }
        for (int i = 0; i < n; ++i) {
            this.bind(supportSQLiteStatement, TArray[i]);
            int n3 = supportSQLiteStatement.executeUpdateDelete();
            n2 += n3;
            continue;
        }
        this.release(supportSQLiteStatement);
        return n2;
    }
}

