/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.room;

import androidx.room.QueryInterceptorStatement$$ExternalSyntheticLambda0;
import androidx.room.QueryInterceptorStatement$$ExternalSyntheticLambda1;
import androidx.room.QueryInterceptorStatement$$ExternalSyntheticLambda2;
import androidx.room.QueryInterceptorStatement$$ExternalSyntheticLambda3;
import androidx.room.QueryInterceptorStatement$$ExternalSyntheticLambda4;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\t\u0010\u001a\u001a\u00020\u000eH\u0096\u0001J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\u001a\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010 \u001a\u00020\u0016H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2={"Landroidx/room/QueryInterceptorStatement;", "Landroidx/sqlite/db/SupportSQLiteStatement;", "delegate", "sqlStatement", "", "queryCallbackExecutor", "Ljava/util/concurrent/Executor;", "queryCallback", "Landroidx/room/RoomDatabase$QueryCallback;", "(Landroidx/sqlite/db/SupportSQLiteStatement;Ljava/lang/String;Ljava/util/concurrent/Executor;Landroidx/room/RoomDatabase$QueryCallback;)V", "bindArgsCache", "", "", "bindBlob", "", "index", "", "value", "", "bindDouble", "", "bindLong", "", "bindNull", "bindString", "clearBindings", "close", "execute", "executeInsert", "executeUpdateDelete", "saveArgsToCache", "bindIndex", "simpleQueryForLong", "simpleQueryForString", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
public final class QueryInterceptorStatement
implements SupportSQLiteStatement {
    private final List<Object> bindArgsCache;
    private final SupportSQLiteStatement delegate;
    private final RoomDatabase.QueryCallback queryCallback;
    private final Executor queryCallbackExecutor;
    private final String sqlStatement;

    public static /* synthetic */ void $r8$lambda$Pmi7YUr_0sVZjB_L4FDjiZZURU8(QueryInterceptorStatement queryInterceptorStatement) {
        QueryInterceptorStatement.simpleQueryForLong$lambda$3(queryInterceptorStatement);
    }

    public static /* synthetic */ void $r8$lambda$QdLFHZkpmZJ_LPUgODEMde_afXU(QueryInterceptorStatement queryInterceptorStatement) {
        QueryInterceptorStatement.execute$lambda$0(queryInterceptorStatement);
    }

    public static /* synthetic */ void $r8$lambda$Ry-pL5WhdgLiTeBboZW8YGkMwwQ(QueryInterceptorStatement queryInterceptorStatement) {
        QueryInterceptorStatement.executeUpdateDelete$lambda$1(queryInterceptorStatement);
    }

    public static /* synthetic */ void $r8$lambda$sZPNtLZUec1i4RI8FPsPU8yXMwU(QueryInterceptorStatement queryInterceptorStatement) {
        QueryInterceptorStatement.executeInsert$lambda$2(queryInterceptorStatement);
    }

    public static /* synthetic */ void $r8$lambda$sfBXlNb-XvWZ8iQIzcxh0kX5ho8(QueryInterceptorStatement queryInterceptorStatement) {
        QueryInterceptorStatement.simpleQueryForString$lambda$4(queryInterceptorStatement);
    }

    public QueryInterceptorStatement(SupportSQLiteStatement supportSQLiteStatement, String string2, Executor executor, RoomDatabase.QueryCallback queryCallback) {
        Intrinsics.checkNotNullParameter((Object)supportSQLiteStatement, (String)"delegate");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"sqlStatement");
        Intrinsics.checkNotNullParameter((Object)executor, (String)"queryCallbackExecutor");
        Intrinsics.checkNotNullParameter((Object)queryCallback, (String)"queryCallback");
        this.delegate = supportSQLiteStatement;
        this.sqlStatement = string2;
        this.queryCallbackExecutor = executor;
        this.queryCallback = queryCallback;
        this.bindArgsCache = new ArrayList();
    }

    private static final void execute$lambda$0(QueryInterceptorStatement queryInterceptorStatement) {
        Intrinsics.checkNotNullParameter((Object)queryInterceptorStatement, (String)"this$0");
        queryInterceptorStatement.queryCallback.onQuery(queryInterceptorStatement.sqlStatement, queryInterceptorStatement.bindArgsCache);
    }

    private static final void executeInsert$lambda$2(QueryInterceptorStatement queryInterceptorStatement) {
        Intrinsics.checkNotNullParameter((Object)queryInterceptorStatement, (String)"this$0");
        queryInterceptorStatement.queryCallback.onQuery(queryInterceptorStatement.sqlStatement, queryInterceptorStatement.bindArgsCache);
    }

    private static final void executeUpdateDelete$lambda$1(QueryInterceptorStatement queryInterceptorStatement) {
        Intrinsics.checkNotNullParameter((Object)queryInterceptorStatement, (String)"this$0");
        queryInterceptorStatement.queryCallback.onQuery(queryInterceptorStatement.sqlStatement, queryInterceptorStatement.bindArgsCache);
    }

    private final void saveArgsToCache(int n, Object object) {
        int n2 = n - 1;
        if (n2 >= this.bindArgsCache.size()) {
            int n3 = this.bindArgsCache.size();
            for (n = 0; n < n2 - n3 + 1; ++n) {
                this.bindArgsCache.add(null);
            }
        }
        this.bindArgsCache.set(n2, object);
    }

    private static final void simpleQueryForLong$lambda$3(QueryInterceptorStatement queryInterceptorStatement) {
        Intrinsics.checkNotNullParameter((Object)queryInterceptorStatement, (String)"this$0");
        queryInterceptorStatement.queryCallback.onQuery(queryInterceptorStatement.sqlStatement, queryInterceptorStatement.bindArgsCache);
    }

    private static final void simpleQueryForString$lambda$4(QueryInterceptorStatement queryInterceptorStatement) {
        Intrinsics.checkNotNullParameter((Object)queryInterceptorStatement, (String)"this$0");
        queryInterceptorStatement.queryCallback.onQuery(queryInterceptorStatement.sqlStatement, queryInterceptorStatement.bindArgsCache);
    }

    @Override
    public void bindBlob(int n, byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"value");
        this.saveArgsToCache(n, byArray);
        this.delegate.bindBlob(n, byArray);
    }

    @Override
    public void bindDouble(int n, double d) {
        this.saveArgsToCache(n, d);
        this.delegate.bindDouble(n, d);
    }

    @Override
    public void bindLong(int n, long l) {
        this.saveArgsToCache(n, l);
        this.delegate.bindLong(n, l);
    }

    @Override
    public void bindNull(int n) {
        Object[] objectArray = ((Collection)this.bindArgsCache).toArray(new Object[0]);
        Intrinsics.checkNotNull((Object)objectArray, (String)"null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.saveArgsToCache(n, Arrays.copyOf(objectArray, objectArray.length));
        this.delegate.bindNull(n);
    }

    @Override
    public void bindString(int n, String string2) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"value");
        this.saveArgsToCache(n, string2);
        this.delegate.bindString(n, string2);
    }

    @Override
    public void clearBindings() {
        this.bindArgsCache.clear();
        this.delegate.clearBindings();
    }

    @Override
    public void close() {
        this.delegate.close();
    }

    @Override
    public void execute() {
        this.queryCallbackExecutor.execute(new QueryInterceptorStatement$$ExternalSyntheticLambda1(this));
        this.delegate.execute();
    }

    @Override
    public long executeInsert() {
        this.queryCallbackExecutor.execute(new QueryInterceptorStatement$$ExternalSyntheticLambda2(this));
        return this.delegate.executeInsert();
    }

    @Override
    public int executeUpdateDelete() {
        this.queryCallbackExecutor.execute(new QueryInterceptorStatement$$ExternalSyntheticLambda0(this));
        return this.delegate.executeUpdateDelete();
    }

    @Override
    public long simpleQueryForLong() {
        this.queryCallbackExecutor.execute(new QueryInterceptorStatement$$ExternalSyntheticLambda4(this));
        return this.delegate.simpleQueryForLong();
    }

    @Override
    public String simpleQueryForString() {
        this.queryCallbackExecutor.execute(new QueryInterceptorStatement$$ExternalSyntheticLambda3(this));
        return this.delegate.simpleQueryForString();
    }
}

