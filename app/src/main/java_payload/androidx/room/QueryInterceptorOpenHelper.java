/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.room;

import androidx.room.DelegatingOpenHelper;
import androidx.room.QueryInterceptorDatabase;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0001J\u0011\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0097\u0001R\u0014\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u0001X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012\u00a8\u0006\u001a"}, d2={"Landroidx/room/QueryInterceptorOpenHelper;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "Landroidx/room/DelegatingOpenHelper;", "delegate", "queryCallbackExecutor", "Ljava/util/concurrent/Executor;", "queryCallback", "Landroidx/room/RoomDatabase$QueryCallback;", "(Landroidx/sqlite/db/SupportSQLiteOpenHelper;Ljava/util/concurrent/Executor;Landroidx/room/RoomDatabase$QueryCallback;)V", "databaseName", "", "getDatabaseName", "()Ljava/lang/String;", "getDelegate", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "readableDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getReadableDatabase", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "writableDatabase", "getWritableDatabase", "close", "", "setWriteAheadLoggingEnabled", "enabled", "", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
public final class QueryInterceptorOpenHelper
implements SupportSQLiteOpenHelper,
DelegatingOpenHelper {
    private final SupportSQLiteOpenHelper delegate;
    private final RoomDatabase.QueryCallback queryCallback;
    private final Executor queryCallbackExecutor;

    public QueryInterceptorOpenHelper(SupportSQLiteOpenHelper supportSQLiteOpenHelper, Executor executor, RoomDatabase.QueryCallback queryCallback) {
        Intrinsics.checkNotNullParameter((Object)supportSQLiteOpenHelper, (String)"delegate");
        Intrinsics.checkNotNullParameter((Object)executor, (String)"queryCallbackExecutor");
        Intrinsics.checkNotNullParameter((Object)queryCallback, (String)"queryCallback");
        this.delegate = supportSQLiteOpenHelper;
        this.queryCallbackExecutor = executor;
        this.queryCallback = queryCallback;
    }

    @Override
    public void close() {
        this.delegate.close();
    }

    @Override
    public String getDatabaseName() {
        return this.delegate.getDatabaseName();
    }

    @Override
    public SupportSQLiteOpenHelper getDelegate() {
        return this.delegate;
    }

    @Override
    public SupportSQLiteDatabase getReadableDatabase() {
        return new QueryInterceptorDatabase(this.getDelegate().getReadableDatabase(), this.queryCallbackExecutor, this.queryCallback);
    }

    @Override
    public SupportSQLiteDatabase getWritableDatabase() {
        return new QueryInterceptorDatabase(this.getDelegate().getWritableDatabase(), this.queryCallbackExecutor, this.queryCallback);
    }

    @Override
    public void setWriteAheadLoggingEnabled(boolean bl) {
        this.delegate.setWriteAheadLoggingEnabled(bl);
    }
}

