/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteTransactionListener
 *  android.os.CancellationSignal
 *  android.util.Pair
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.room;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda0;
import androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda1;
import androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda10;
import androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda11;
import androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda2;
import androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda3;
import androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda4;
import androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda5;
import androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda6;
import androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda7;
import androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda8;
import androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda9;
import androidx.room.QueryInterceptorProgram;
import androidx.room.QueryInterceptorStatement;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020(H\u0016J\u0010\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0016J\t\u0010.\u001a\u00020(H\u0096\u0001J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u000bH\u0016J4\u00102\u001a\u00020\"2\u0006\u00103\u001a\u00020\u000b2\b\u00104\u001a\u0004\u0018\u00010\u000b2\u0012\u00105\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000107\u0018\u000106H\u0096\u0001\u00a2\u0006\u0002\u00108J\t\u00109\u001a\u00020(H\u0097\u0001J\t\u0010:\u001a\u00020\u000fH\u0096\u0001J\b\u0010;\u001a\u00020(H\u0016J,\u0010<\u001a\u00020(2\u0006\u00101\u001a\u00020\u000b2\u0014\b\u0001\u0010=\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000107\u0018\u000106H\u0096\u0001\u00a2\u0006\u0002\u0010>J\u0010\u0010?\u001a\u00020(2\u0006\u00101\u001a\u00020\u000bH\u0016J'\u0010?\u001a\u00020(2\u0006\u00101\u001a\u00020\u000b2\u0010\u0010=\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010706H\u0016\u00a2\u0006\u0002\u0010>J\t\u0010@\u001a\u00020\u000fH\u0096\u0001J!\u0010A\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020DH\u0096\u0001J\u0011\u0010E\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020\"H\u0096\u0001J\u0010\u0010G\u001a\u00020H2\u0006\u0010G\u001a\u00020IH\u0016J\u001a\u0010G\u001a\u00020H2\u0006\u0010G\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\u0010\u0010G\u001a\u00020H2\u0006\u0010G\u001a\u00020\u000bH\u0016J'\u0010G\u001a\u00020H2\u0006\u0010G\u001a\u00020\u000b2\u0010\u0010=\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010706H\u0016\u00a2\u0006\u0002\u0010LJ\u0011\u0010M\u001a\u00020(2\u0006\u0010N\u001a\u00020\u000fH\u0097\u0001J\u0011\u0010O\u001a\u00020(2\u0006\u0010P\u001a\u00020QH\u0096\u0001J\u0011\u0010R\u001a\u00020(2\u0006\u0010S\u001a\u00020\"H\u0096\u0001J\u0011\u0010T\u001a\u00020\u00172\u0006\u0010U\u001a\u00020\u0017H\u0096\u0001J\b\u0010V\u001a\u00020(H\u0016JD\u0010W\u001a\u00020\"2\u0006\u00103\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020D2\b\u00104\u001a\u0004\u0018\u00010\u000b2\u0012\u00105\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000107\u0018\u000106H\u0096\u0001\u00a2\u0006\u0002\u0010XJ\t\u0010Y\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010Y\u001a\u00020\u000f2\u0006\u0010Z\u001a\u00020\u0017H\u0096\u0001R(\u0010\b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\t8VX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000fX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u000fX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0012\u0010\u0013\u001a\u00020\u000fX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010R\u0012\u0010\u0014\u001a\u00020\u000fX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u000f8WX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010R\u0012\u0010\u0016\u001a\u00020\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u00020\u0017X\u0096\u000f\u00a2\u0006\f\u001a\u0004\b\u001b\u0010\u0019\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u000bX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010!\u001a\u00020\"X\u0096\u000f\u00a2\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006["}, d2={"Landroidx/room/QueryInterceptorDatabase;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "delegate", "queryCallbackExecutor", "Ljava/util/concurrent/Executor;", "queryCallback", "Landroidx/room/RoomDatabase$QueryCallback;", "(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/util/concurrent/Executor;Landroidx/room/RoomDatabase$QueryCallback;)V", "attachedDbs", "", "Landroid/util/Pair;", "", "getAttachedDbs", "()Ljava/util/List;", "isDatabaseIntegrityOk", "", "()Z", "isDbLockedByCurrentThread", "isExecPerConnectionSQLSupported", "isOpen", "isReadOnly", "isWriteAheadLoggingEnabled", "maximumSize", "", "getMaximumSize", "()J", "pageSize", "getPageSize", "setPageSize", "(J)V", "path", "getPath", "()Ljava/lang/String;", "version", "", "getVersion", "()I", "setVersion", "(I)V", "beginTransaction", "", "beginTransactionNonExclusive", "beginTransactionWithListener", "transactionListener", "Landroid/database/sqlite/SQLiteTransactionListener;", "beginTransactionWithListenerNonExclusive", "close", "compileStatement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "sql", "delete", "table", "whereClause", "whereArgs", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I", "disableWriteAheadLogging", "enableWriteAheadLogging", "endTransaction", "execPerConnectionSQL", "bindArgs", "(Ljava/lang/String;[Ljava/lang/Object;)V", "execSQL", "inTransaction", "insert", "conflictAlgorithm", "values", "Landroid/content/ContentValues;", "needUpgrade", "newVersion", "query", "Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Ljava/lang/String;[Ljava/lang/Object;)Landroid/database/Cursor;", "setForeignKeyConstraintsEnabled", "enabled", "setLocale", "locale", "Ljava/util/Locale;", "setMaxSqlCacheSize", "cacheSize", "setMaximumSize", "numBytes", "setTransactionSuccessful", "update", "(Ljava/lang/String;ILandroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/Object;)I", "yieldIfContendedSafely", "sleepAfterYieldDelayMillis", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
public final class QueryInterceptorDatabase
implements SupportSQLiteDatabase {
    private final SupportSQLiteDatabase delegate;
    private final RoomDatabase.QueryCallback queryCallback;
    private final Executor queryCallbackExecutor;

    public static /* synthetic */ void $r8$lambda$3nqW82Zqx2VSpCkGWA-yR8NbjIM(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        QueryInterceptorDatabase.query$lambda$8(queryInterceptorDatabase, supportSQLiteQuery, queryInterceptorProgram);
    }

    public static /* synthetic */ void $r8$lambda$3s68izs9RCe2upmu8CDLAvlPAwI(QueryInterceptorDatabase queryInterceptorDatabase) {
        QueryInterceptorDatabase.beginTransactionWithListener$lambda$2(queryInterceptorDatabase);
    }

    public static /* synthetic */ void $r8$lambda$4C_ITtrC3gjVZMSZyw1Sxxv4ic4(QueryInterceptorDatabase queryInterceptorDatabase) {
        QueryInterceptorDatabase.beginTransaction$lambda$0(queryInterceptorDatabase);
    }

    public static /* synthetic */ void $r8$lambda$Dioq6ZJjT472mWjAQIRwVg5bWbI(QueryInterceptorDatabase queryInterceptorDatabase, String string2, Object[] objectArray) {
        QueryInterceptorDatabase.query$lambda$7(queryInterceptorDatabase, string2, objectArray);
    }

    public static /* synthetic */ void $r8$lambda$ESli_u-fGKTMJTbM4iCdFlNcDiE(QueryInterceptorDatabase queryInterceptorDatabase, String string2, List list) {
        QueryInterceptorDatabase.execSQL$lambda$11(queryInterceptorDatabase, string2, list);
    }

    public static /* synthetic */ void $r8$lambda$H_SBEG9RXHaL-4kIiF5ViKOQLZM(QueryInterceptorDatabase queryInterceptorDatabase) {
        QueryInterceptorDatabase.beginTransactionWithListenerNonExclusive$lambda$3(queryInterceptorDatabase);
    }

    public static /* synthetic */ void $r8$lambda$JwG54xY9OuUVdVWoxMHN3HSB5TM(QueryInterceptorDatabase queryInterceptorDatabase) {
        QueryInterceptorDatabase.endTransaction$lambda$4(queryInterceptorDatabase);
    }

    public static /* synthetic */ void $r8$lambda$LVN74JJqCqCfwEWaHRC8n0Un2m0(QueryInterceptorDatabase queryInterceptorDatabase) {
        QueryInterceptorDatabase.setTransactionSuccessful$lambda$5(queryInterceptorDatabase);
    }

    public static /* synthetic */ void $r8$lambda$ouzRkg2RWZvzWqaXpn1vapooSoE(QueryInterceptorDatabase queryInterceptorDatabase, String string2) {
        QueryInterceptorDatabase.execSQL$lambda$10(queryInterceptorDatabase, string2);
    }

    public static /* synthetic */ void $r8$lambda$rBUkojwUw7EIsqAZ40YXCOpJQkc(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        QueryInterceptorDatabase.query$lambda$9(queryInterceptorDatabase, supportSQLiteQuery, queryInterceptorProgram);
    }

    public static /* synthetic */ void $r8$lambda$w1qlF-OxXaEnb0tz5DMFEAdIrHU(QueryInterceptorDatabase queryInterceptorDatabase, String string2) {
        QueryInterceptorDatabase.query$lambda$6(queryInterceptorDatabase, string2);
    }

    public static /* synthetic */ void $r8$lambda$xXhyjBFfIFBi3uBWfyjF_r55EDQ(QueryInterceptorDatabase queryInterceptorDatabase) {
        QueryInterceptorDatabase.beginTransactionNonExclusive$lambda$1(queryInterceptorDatabase);
    }

    public QueryInterceptorDatabase(SupportSQLiteDatabase supportSQLiteDatabase, Executor executor, RoomDatabase.QueryCallback queryCallback) {
        Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"delegate");
        Intrinsics.checkNotNullParameter((Object)executor, (String)"queryCallbackExecutor");
        Intrinsics.checkNotNullParameter((Object)queryCallback, (String)"queryCallback");
        this.delegate = supportSQLiteDatabase;
        this.queryCallbackExecutor = executor;
        this.queryCallback = queryCallback;
    }

    private static final void beginTransaction$lambda$0(QueryInterceptorDatabase queryInterceptorDatabase) {
        Intrinsics.checkNotNullParameter((Object)queryInterceptorDatabase, (String)"this$0");
        queryInterceptorDatabase.queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", CollectionsKt.emptyList());
    }

    private static final void beginTransactionNonExclusive$lambda$1(QueryInterceptorDatabase queryInterceptorDatabase) {
        Intrinsics.checkNotNullParameter((Object)queryInterceptorDatabase, (String)"this$0");
        queryInterceptorDatabase.queryCallback.onQuery("BEGIN DEFERRED TRANSACTION", CollectionsKt.emptyList());
    }

    private static final void beginTransactionWithListener$lambda$2(QueryInterceptorDatabase queryInterceptorDatabase) {
        Intrinsics.checkNotNullParameter((Object)queryInterceptorDatabase, (String)"this$0");
        queryInterceptorDatabase.queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", CollectionsKt.emptyList());
    }

    private static final void beginTransactionWithListenerNonExclusive$lambda$3(QueryInterceptorDatabase queryInterceptorDatabase) {
        Intrinsics.checkNotNullParameter((Object)queryInterceptorDatabase, (String)"this$0");
        queryInterceptorDatabase.queryCallback.onQuery("BEGIN DEFERRED TRANSACTION", CollectionsKt.emptyList());
    }

    private static final void endTransaction$lambda$4(QueryInterceptorDatabase queryInterceptorDatabase) {
        Intrinsics.checkNotNullParameter((Object)queryInterceptorDatabase, (String)"this$0");
        queryInterceptorDatabase.queryCallback.onQuery("END TRANSACTION", CollectionsKt.emptyList());
    }

    private static final void execSQL$lambda$10(QueryInterceptorDatabase queryInterceptorDatabase, String string2) {
        Intrinsics.checkNotNullParameter((Object)queryInterceptorDatabase, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"$sql");
        queryInterceptorDatabase.queryCallback.onQuery(string2, CollectionsKt.emptyList());
    }

    private static final void execSQL$lambda$11(QueryInterceptorDatabase queryInterceptorDatabase, String string2, List list) {
        Intrinsics.checkNotNullParameter((Object)queryInterceptorDatabase, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"$sql");
        Intrinsics.checkNotNullParameter((Object)list, (String)"$inputArguments");
        queryInterceptorDatabase.queryCallback.onQuery(string2, list);
    }

    private static final void query$lambda$6(QueryInterceptorDatabase queryInterceptorDatabase, String string2) {
        Intrinsics.checkNotNullParameter((Object)queryInterceptorDatabase, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"$query");
        queryInterceptorDatabase.queryCallback.onQuery(string2, CollectionsKt.emptyList());
    }

    private static final void query$lambda$7(QueryInterceptorDatabase queryInterceptorDatabase, String string2, Object[] objectArray) {
        Intrinsics.checkNotNullParameter((Object)queryInterceptorDatabase, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"$query");
        Intrinsics.checkNotNullParameter((Object)objectArray, (String)"$bindArgs");
        queryInterceptorDatabase.queryCallback.onQuery(string2, ArraysKt.toList((Object[])objectArray));
    }

    private static final void query$lambda$8(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        Intrinsics.checkNotNullParameter((Object)queryInterceptorDatabase, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)supportSQLiteQuery, (String)"$query");
        Intrinsics.checkNotNullParameter((Object)queryInterceptorProgram, (String)"$queryInterceptorProgram");
        queryInterceptorDatabase.queryCallback.onQuery(supportSQLiteQuery.getSql(), queryInterceptorProgram.getBindArgsCache$room_runtime_release());
    }

    private static final void query$lambda$9(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        Intrinsics.checkNotNullParameter((Object)queryInterceptorDatabase, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)supportSQLiteQuery, (String)"$query");
        Intrinsics.checkNotNullParameter((Object)queryInterceptorProgram, (String)"$queryInterceptorProgram");
        queryInterceptorDatabase.queryCallback.onQuery(supportSQLiteQuery.getSql(), queryInterceptorProgram.getBindArgsCache$room_runtime_release());
    }

    private static final void setTransactionSuccessful$lambda$5(QueryInterceptorDatabase queryInterceptorDatabase) {
        Intrinsics.checkNotNullParameter((Object)queryInterceptorDatabase, (String)"this$0");
        queryInterceptorDatabase.queryCallback.onQuery("TRANSACTION SUCCESSFUL", CollectionsKt.emptyList());
    }

    @Override
    public void beginTransaction() {
        this.queryCallbackExecutor.execute(new QueryInterceptorDatabase$$ExternalSyntheticLambda8(this));
        this.delegate.beginTransaction();
    }

    @Override
    public void beginTransactionNonExclusive() {
        this.queryCallbackExecutor.execute(new QueryInterceptorDatabase$$ExternalSyntheticLambda0(this));
        this.delegate.beginTransactionNonExclusive();
    }

    @Override
    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        Intrinsics.checkNotNullParameter((Object)sQLiteTransactionListener, (String)"transactionListener");
        this.queryCallbackExecutor.execute(new QueryInterceptorDatabase$$ExternalSyntheticLambda2(this));
        this.delegate.beginTransactionWithListener(sQLiteTransactionListener);
    }

    @Override
    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        Intrinsics.checkNotNullParameter((Object)sQLiteTransactionListener, (String)"transactionListener");
        this.queryCallbackExecutor.execute(new QueryInterceptorDatabase$$ExternalSyntheticLambda6(this));
        this.delegate.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
    }

    @Override
    public void close() {
        this.delegate.close();
    }

    @Override
    public SupportSQLiteStatement compileStatement(String string2) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"sql");
        SupportSQLiteStatement supportSQLiteStatement = this.delegate.compileStatement(string2);
        return new QueryInterceptorStatement(supportSQLiteStatement, string2, this.queryCallbackExecutor, this.queryCallback);
    }

    @Override
    public int delete(String string2, String string3, Object[] objectArray) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"table");
        return this.delegate.delete(string2, string3, objectArray);
    }

    @Override
    public void disableWriteAheadLogging() {
        this.delegate.disableWriteAheadLogging();
    }

    @Override
    public boolean enableWriteAheadLogging() {
        return this.delegate.enableWriteAheadLogging();
    }

    @Override
    public void endTransaction() {
        this.queryCallbackExecutor.execute(new QueryInterceptorDatabase$$ExternalSyntheticLambda10(this));
        this.delegate.endTransaction();
    }

    @Override
    public void execPerConnectionSQL(String string2, Object[] objectArray) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"sql");
        this.delegate.execPerConnectionSQL(string2, objectArray);
    }

    @Override
    public void execSQL(String string2) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"sql");
        this.queryCallbackExecutor.execute(new QueryInterceptorDatabase$$ExternalSyntheticLambda1(this, string2));
        this.delegate.execSQL(string2);
    }

    @Override
    public void execSQL(String string2, Object[] objectArray) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"sql");
        Intrinsics.checkNotNullParameter((Object)objectArray, (String)"bindArgs");
        List list = new ArrayList();
        list.addAll(CollectionsKt.listOf((Object)objectArray));
        this.queryCallbackExecutor.execute(new QueryInterceptorDatabase$$ExternalSyntheticLambda11(this, string2, list));
        this.delegate.execSQL(string2, new List[]{list});
    }

    @Override
    public List<Pair<String, String>> getAttachedDbs() {
        return this.delegate.getAttachedDbs();
    }

    @Override
    public long getMaximumSize() {
        return this.delegate.getMaximumSize();
    }

    @Override
    public long getPageSize() {
        return this.delegate.getPageSize();
    }

    @Override
    public String getPath() {
        return this.delegate.getPath();
    }

    @Override
    public int getVersion() {
        return this.delegate.getVersion();
    }

    @Override
    public boolean inTransaction() {
        return this.delegate.inTransaction();
    }

    @Override
    public long insert(String string2, int n, ContentValues contentValues) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"table");
        Intrinsics.checkNotNullParameter((Object)contentValues, (String)"values");
        return this.delegate.insert(string2, n, contentValues);
    }

    @Override
    public boolean isDatabaseIntegrityOk() {
        return this.delegate.isDatabaseIntegrityOk();
    }

    @Override
    public boolean isDbLockedByCurrentThread() {
        return this.delegate.isDbLockedByCurrentThread();
    }

    @Override
    public boolean isExecPerConnectionSQLSupported() {
        return this.delegate.isExecPerConnectionSQLSupported();
    }

    @Override
    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    @Override
    public boolean isReadOnly() {
        return this.delegate.isReadOnly();
    }

    @Override
    public boolean isWriteAheadLoggingEnabled() {
        return this.delegate.isWriteAheadLoggingEnabled();
    }

    @Override
    public boolean needUpgrade(int n) {
        return this.delegate.needUpgrade(n);
    }

    @Override
    public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        Intrinsics.checkNotNullParameter((Object)supportSQLiteQuery, (String)"query");
        QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        supportSQLiteQuery.bindTo(queryInterceptorProgram);
        this.queryCallbackExecutor.execute(new QueryInterceptorDatabase$$ExternalSyntheticLambda7(this, supportSQLiteQuery, queryInterceptorProgram));
        return this.delegate.query(supportSQLiteQuery);
    }

    @Override
    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal object) {
        Intrinsics.checkNotNullParameter((Object)supportSQLiteQuery, (String)"query");
        object = new QueryInterceptorProgram();
        supportSQLiteQuery.bindTo((SupportSQLiteProgram)object);
        this.queryCallbackExecutor.execute(new QueryInterceptorDatabase$$ExternalSyntheticLambda3(this, supportSQLiteQuery, (QueryInterceptorProgram)object));
        return this.delegate.query(supportSQLiteQuery);
    }

    @Override
    public Cursor query(String string2) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"query");
        this.queryCallbackExecutor.execute(new QueryInterceptorDatabase$$ExternalSyntheticLambda9(this, string2));
        return this.delegate.query(string2);
    }

    @Override
    public Cursor query(String string2, Object[] objectArray) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"query");
        Intrinsics.checkNotNullParameter((Object)objectArray, (String)"bindArgs");
        this.queryCallbackExecutor.execute(new QueryInterceptorDatabase$$ExternalSyntheticLambda4(this, string2, objectArray));
        return this.delegate.query(string2, objectArray);
    }

    @Override
    public void setForeignKeyConstraintsEnabled(boolean bl) {
        this.delegate.setForeignKeyConstraintsEnabled(bl);
    }

    @Override
    public void setLocale(Locale locale) {
        Intrinsics.checkNotNullParameter((Object)locale, (String)"locale");
        this.delegate.setLocale(locale);
    }

    @Override
    public void setMaxSqlCacheSize(int n) {
        this.delegate.setMaxSqlCacheSize(n);
    }

    @Override
    public long setMaximumSize(long l) {
        return this.delegate.setMaximumSize(l);
    }

    @Override
    public void setPageSize(long l) {
        this.delegate.setPageSize(l);
    }

    @Override
    public void setTransactionSuccessful() {
        this.queryCallbackExecutor.execute(new QueryInterceptorDatabase$$ExternalSyntheticLambda5(this));
        this.delegate.setTransactionSuccessful();
    }

    @Override
    public void setVersion(int n) {
        this.delegate.setVersion(n);
    }

    @Override
    public int update(String string2, int n, ContentValues contentValues, String string3, Object[] objectArray) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"table");
        Intrinsics.checkNotNullParameter((Object)contentValues, (String)"values");
        return this.delegate.update(string2, n, contentValues, string3, objectArray);
    }

    @Override
    public boolean yieldIfContendedSafely() {
        return this.delegate.yieldIfContendedSafely();
    }

    @Override
    public boolean yieldIfContendedSafely(long l) {
        return this.delegate.yieldIfContendedSafely(l);
    }
}

