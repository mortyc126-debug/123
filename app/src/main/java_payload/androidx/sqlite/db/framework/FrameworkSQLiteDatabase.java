/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.Cursor
 *  android.database.SQLException
 *  android.database.sqlite.SQLiteCursor
 *  android.database.sqlite.SQLiteCursorDriver
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteProgram
 *  android.database.sqlite.SQLiteQuery
 *  android.database.sqlite.SQLiteStatement
 *  android.database.sqlite.SQLiteTransactionListener
 *  android.os.Build$VERSION
 *  android.os.CancellationSignal
 *  android.text.TextUtils
 *  android.util.Pair
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.sqlite.db.framework;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.Build;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase$$ExternalSyntheticLambda0;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase$$ExternalSyntheticLambda1;
import androidx.sqlite.db.framework.FrameworkSQLiteProgram;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
@Metadata(d1={"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \\2\u00020\u0001:\u0002[\\B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020(H\u0016J\u0010\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010.\u001a\u00020(H\u0016J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\bH\u0016J3\u00102\u001a\u00020!2\u0006\u00103\u001a\u00020\b2\b\u00104\u001a\u0004\u0018\u00010\b2\u0012\u00105\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000107\u0018\u000106H\u0016\u00a2\u0006\u0002\u00108J\b\u00109\u001a\u00020(H\u0017J\b\u0010:\u001a\u00020\fH\u0016J\b\u0010;\u001a\u00020(H\u0016J)\u0010<\u001a\u00020(2\u0006\u00101\u001a\u00020\b2\u0012\u0010=\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000107\u0018\u000106H\u0016\u00a2\u0006\u0002\u0010>J\u0010\u0010?\u001a\u00020(2\u0006\u00101\u001a\u00020\bH\u0016J'\u0010?\u001a\u00020(2\u0006\u00101\u001a\u00020\b2\u0010\u0010=\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010706H\u0016\u00a2\u0006\u0002\u0010>J\b\u0010@\u001a\u00020\fH\u0016J \u0010A\u001a\u00020\u00142\u0006\u00103\u001a\u00020\b2\u0006\u0010B\u001a\u00020!2\u0006\u0010C\u001a\u00020DH\u0016J\u000e\u0010E\u001a\u00020\f2\u0006\u0010F\u001a\u00020\u0003J\u0010\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020!H\u0016J\u0010\u0010I\u001a\u00020J2\u0006\u0010I\u001a\u00020KH\u0016J\u001a\u0010I\u001a\u00020J2\u0006\u0010I\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010MH\u0017J\u0010\u0010I\u001a\u00020J2\u0006\u0010I\u001a\u00020\bH\u0016J'\u0010I\u001a\u00020J2\u0006\u0010I\u001a\u00020\b2\u0010\u0010=\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010706H\u0016\u00a2\u0006\u0002\u0010NJ\u0010\u0010O\u001a\u00020(2\u0006\u0010P\u001a\u00020\fH\u0017J\u0010\u0010Q\u001a\u00020(2\u0006\u0010R\u001a\u00020SH\u0016J\u0010\u0010T\u001a\u00020(2\u0006\u0010U\u001a\u00020!H\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010V\u001a\u00020(H\u0016JC\u0010W\u001a\u00020!2\u0006\u00103\u001a\u00020\b2\u0006\u0010B\u001a\u00020!2\u0006\u0010C\u001a\u00020D2\b\u00104\u001a\u0004\u0018\u00010\b2\u0012\u00105\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000107\u0018\u000106H\u0016\u00a2\u0006\u0002\u0010XJ\b\u0010Y\u001a\u00020\fH\u0016J\u0010\u0010Y\u001a\u00020\f2\u0006\u0010Z\u001a\u00020\u0014H\u0016R(\u0010\u0005\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\f8WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\rR$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00148V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00148V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR$\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020!8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006]"}, d2={"Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "delegate", "Landroid/database/sqlite/SQLiteDatabase;", "(Landroid/database/sqlite/SQLiteDatabase;)V", "attachedDbs", "", "Landroid/util/Pair;", "", "getAttachedDbs", "()Ljava/util/List;", "isDatabaseIntegrityOk", "", "()Z", "isDbLockedByCurrentThread", "isExecPerConnectionSQLSupported", "isOpen", "isReadOnly", "isWriteAheadLoggingEnabled", "numBytes", "", "maximumSize", "getMaximumSize", "()J", "setMaximumSize", "(J)V", "pageSize", "getPageSize", "setPageSize", "path", "getPath", "()Ljava/lang/String;", "value", "", "version", "getVersion", "()I", "setVersion", "(I)V", "beginTransaction", "", "beginTransactionNonExclusive", "beginTransactionWithListener", "transactionListener", "Landroid/database/sqlite/SQLiteTransactionListener;", "beginTransactionWithListenerNonExclusive", "close", "compileStatement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "sql", "delete", "table", "whereClause", "whereArgs", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I", "disableWriteAheadLogging", "enableWriteAheadLogging", "endTransaction", "execPerConnectionSQL", "bindArgs", "(Ljava/lang/String;[Ljava/lang/Object;)V", "execSQL", "inTransaction", "insert", "conflictAlgorithm", "values", "Landroid/content/ContentValues;", "isDelegate", "sqLiteDatabase", "needUpgrade", "newVersion", "query", "Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Ljava/lang/String;[Ljava/lang/Object;)Landroid/database/Cursor;", "setForeignKeyConstraintsEnabled", "enabled", "setLocale", "locale", "Ljava/util/Locale;", "setMaxSqlCacheSize", "cacheSize", "setTransactionSuccessful", "update", "(Ljava/lang/String;ILandroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/Object;)I", "yieldIfContendedSafely", "sleepAfterYieldDelayMillis", "Api30Impl", "Companion", "sqlite-framework_release"}, k=1, mv={1, 7, 1}, xi=48)
public final class FrameworkSQLiteDatabase
implements SupportSQLiteDatabase {
    private static final String[] CONFLICT_VALUES;
    public static final Companion Companion;
    private static final String[] EMPTY_STRING_ARRAY;
    private final List<Pair<String, String>> attachedDbs;
    private final SQLiteDatabase delegate;

    public static /* synthetic */ Cursor $r8$lambda$BFGJjdMOCDz5XPIMAR1G27bXFjU(SupportSQLiteQuery supportSQLiteQuery, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String string2, SQLiteQuery sQLiteQuery) {
        return FrameworkSQLiteDatabase.query$lambda$1(supportSQLiteQuery, sQLiteDatabase, sQLiteCursorDriver, string2, sQLiteQuery);
    }

    public static /* synthetic */ Cursor $r8$lambda$xWs7VTYEzeAWyi_2-SJixQ1HyKQ(Function4 function4, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String string2, SQLiteQuery sQLiteQuery) {
        return FrameworkSQLiteDatabase.query$lambda$0(function4, sQLiteDatabase, sQLiteCursorDriver, string2, sQLiteQuery);
    }

    static {
        Companion = new Companion(null);
        CONFLICT_VALUES = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
        EMPTY_STRING_ARRAY = new String[0];
    }

    public FrameworkSQLiteDatabase(SQLiteDatabase sQLiteDatabase) {
        Intrinsics.checkNotNullParameter((Object)sQLiteDatabase, (String)"delegate");
        this.delegate = sQLiteDatabase;
        this.attachedDbs = this.delegate.getAttachedDbs();
    }

    private static final Cursor query$lambda$0(Function4 function4, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String string2, SQLiteQuery sQLiteQuery) {
        Intrinsics.checkNotNullParameter((Object)function4, (String)"$tmp0");
        return (Cursor)function4.invoke((Object)sQLiteDatabase, (Object)sQLiteCursorDriver, (Object)string2, (Object)sQLiteQuery);
    }

    private static final Cursor query$lambda$1(SupportSQLiteQuery supportSQLiteQuery, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String string2, SQLiteQuery sQLiteQuery) {
        Intrinsics.checkNotNullParameter((Object)supportSQLiteQuery, (String)"$query");
        Intrinsics.checkNotNull((Object)sQLiteQuery);
        supportSQLiteQuery.bindTo(new FrameworkSQLiteProgram((SQLiteProgram)sQLiteQuery));
        return (Cursor)new SQLiteCursor(sQLiteCursorDriver, string2, sQLiteQuery);
    }

    @Override
    public void beginTransaction() {
        this.delegate.beginTransaction();
    }

    @Override
    public void beginTransactionNonExclusive() {
        this.delegate.beginTransactionNonExclusive();
    }

    @Override
    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        Intrinsics.checkNotNullParameter((Object)sQLiteTransactionListener, (String)"transactionListener");
        this.delegate.beginTransactionWithListener(sQLiteTransactionListener);
    }

    @Override
    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        Intrinsics.checkNotNullParameter((Object)sQLiteTransactionListener, (String)"transactionListener");
        this.delegate.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
    }

    @Override
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override
    public SupportSQLiteStatement compileStatement(String string2) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"sql");
        string2 = this.delegate.compileStatement(string2);
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"delegate.compileStatement(sql)");
        return new FrameworkSQLiteStatement((SQLiteStatement)string2);
    }

    @Override
    public int delete(String object, String string2, Object[] objectArray) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"table");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DELETE FROM ");
        stringBuilder.append((String)object);
        object = string2;
        boolean bl = object == null || object.length() == 0;
        if (!bl) {
            stringBuilder.append(" WHERE ");
            stringBuilder.append(string2);
        }
        object = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"StringBuilder().apply(builderAction).toString()");
        object = this.compileStatement((String)object);
        SimpleSQLiteQuery.Companion.bind((SupportSQLiteProgram)object, objectArray);
        return object.executeUpdateDelete();
    }

    @Override
    public void disableWriteAheadLogging() {
        SupportSQLiteCompat.Api16Impl.disableWriteAheadLogging(this.delegate);
    }

    @Override
    public boolean enableWriteAheadLogging() {
        return this.delegate.enableWriteAheadLogging();
    }

    @Override
    public void endTransaction() {
        this.delegate.endTransaction();
    }

    @Override
    public void execPerConnectionSQL(String string2, Object[] objectArray) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"sql");
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.INSTANCE.execPerConnectionSQL(this.delegate, string2, objectArray);
            return;
        }
        throw new UnsupportedOperationException("execPerConnectionSQL is not supported on a SDK version lower than 30, current version is: " + Build.VERSION.SDK_INT);
    }

    @Override
    public void execSQL(String string2) throws SQLException {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"sql");
        this.delegate.execSQL(string2);
    }

    @Override
    public void execSQL(String string2, Object[] objectArray) throws SQLException {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"sql");
        Intrinsics.checkNotNullParameter((Object)objectArray, (String)"bindArgs");
        this.delegate.execSQL(string2, objectArray);
    }

    @Override
    public List<Pair<String, String>> getAttachedDbs() {
        return this.attachedDbs;
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
    public long insert(String string2, int n, ContentValues contentValues) throws SQLException {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"table");
        Intrinsics.checkNotNullParameter((Object)contentValues, (String)"values");
        return this.delegate.insertWithOnConflict(string2, null, contentValues, n);
    }

    @Override
    public boolean isDatabaseIntegrityOk() {
        return this.delegate.isDatabaseIntegrityOk();
    }

    @Override
    public boolean isDbLockedByCurrentThread() {
        return this.delegate.isDbLockedByCurrentThread();
    }

    public final boolean isDelegate(SQLiteDatabase sQLiteDatabase) {
        Intrinsics.checkNotNullParameter((Object)sQLiteDatabase, (String)"sqLiteDatabase");
        return Intrinsics.areEqual((Object)this.delegate, (Object)sQLiteDatabase);
    }

    @Override
    public boolean isExecPerConnectionSQLSupported() {
        boolean bl = Build.VERSION.SDK_INT >= 30;
        return bl;
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
        return SupportSQLiteCompat.Api16Impl.isWriteAheadLoggingEnabled(this.delegate);
    }

    @Override
    public boolean needUpgrade(int n) {
        return this.delegate.needUpgrade(n);
    }

    @Override
    public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        Intrinsics.checkNotNullParameter((Object)supportSQLiteQuery, (String)"query");
        Function4 function4 = (Function4)new Function4<SQLiteDatabase, SQLiteCursorDriver, String, SQLiteQuery, SQLiteCursor>(supportSQLiteQuery){
            final SupportSQLiteQuery $query;
            {
                this.$query = supportSQLiteQuery;
                super(4);
            }

            public final SQLiteCursor invoke(SQLiteDatabase object, SQLiteCursorDriver sQLiteCursorDriver, String string2, SQLiteQuery sQLiteQuery) {
                object = this.$query;
                Intrinsics.checkNotNull((Object)sQLiteQuery);
                object.bindTo(new FrameworkSQLiteProgram((SQLiteProgram)sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, string2, sQLiteQuery);
            }
        };
        supportSQLiteQuery = this.delegate.rawQueryWithFactory((SQLiteDatabase.CursorFactory)new FrameworkSQLiteDatabase$$ExternalSyntheticLambda1(function4), supportSQLiteQuery.getSql(), EMPTY_STRING_ARRAY, null);
        Intrinsics.checkNotNullExpressionValue((Object)supportSQLiteQuery, (String)"delegate.rawQueryWithFac\u2026EMPTY_STRING_ARRAY, null)");
        return supportSQLiteQuery;
    }

    @Override
    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter((Object)supportSQLiteQuery, (String)"query");
        SQLiteDatabase sQLiteDatabase = this.delegate;
        String string2 = supportSQLiteQuery.getSql();
        String[] stringArray = EMPTY_STRING_ARRAY;
        Intrinsics.checkNotNull((Object)cancellationSignal);
        return SupportSQLiteCompat.Api16Impl.rawQueryWithFactory(sQLiteDatabase, string2, stringArray, null, cancellationSignal, new FrameworkSQLiteDatabase$$ExternalSyntheticLambda0(supportSQLiteQuery));
    }

    @Override
    public Cursor query(String string2) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"query");
        return this.query(new SimpleSQLiteQuery(string2));
    }

    @Override
    public Cursor query(String string2, Object[] objectArray) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"query");
        Intrinsics.checkNotNullParameter((Object)objectArray, (String)"bindArgs");
        return this.query(new SimpleSQLiteQuery(string2, objectArray));
    }

    @Override
    public void setForeignKeyConstraintsEnabled(boolean bl) {
        SupportSQLiteCompat.Api16Impl.setForeignKeyConstraintsEnabled(this.delegate, bl);
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
        this.delegate.setMaximumSize(l);
        return this.delegate.getMaximumSize();
    }

    public void setMaximumSize(long l) {
        this.delegate.setMaximumSize(l);
    }

    @Override
    public void setPageSize(long l) {
        this.delegate.setPageSize(l);
    }

    @Override
    public void setTransactionSuccessful() {
        this.delegate.setTransactionSuccessful();
    }

    @Override
    public void setVersion(int n) {
        this.delegate.setVersion(n);
    }

    @Override
    public int update(String object, int n, ContentValues contentValues, String string2, Object[] objectArray) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"table");
        Intrinsics.checkNotNullParameter((Object)contentValues, (String)"values");
        int n2 = contentValues.size() != 0 ? 1 : 0;
        if (n2 != 0) {
            n2 = contentValues.size();
            int n3 = objectArray == null ? n2 : objectArray.length + n2;
            Object[] objectArray2 = new Object[n3];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("UPDATE ");
            stringBuilder.append(CONFLICT_VALUES[n]);
            stringBuilder.append((String)object);
            stringBuilder.append(" SET ");
            n = 0;
            for (String string3 : contentValues.keySet()) {
                object = n > 0 ? "," : "";
                stringBuilder.append((String)object);
                stringBuilder.append(string3);
                objectArray2[n] = contentValues.get(string3);
                stringBuilder.append("=?");
                ++n;
            }
            if (objectArray != null) {
                for (n = n2; n < n3; ++n) {
                    objectArray2[n] = objectArray[n - n2];
                }
            }
            if (!TextUtils.isEmpty((CharSequence)string2)) {
                stringBuilder.append(" WHERE ");
                stringBuilder.append(string2);
            }
            object = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"StringBuilder().apply(builderAction).toString()");
            object = this.compileStatement((String)object);
            SimpleSQLiteQuery.Companion.bind((SupportSQLiteProgram)object, objectArray2);
            return object.executeUpdateDelete();
        }
        throw new IllegalArgumentException("Empty values".toString());
    }

    @Override
    public boolean yieldIfContendedSafely() {
        return this.delegate.yieldIfContendedSafely();
    }

    @Override
    public boolean yieldIfContendedSafely(long l) {
        return this.delegate.yieldIfContendedSafely(l);
    }

    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u00c1\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\nH\u0007\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2={"Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase$Api30Impl;", "", "()V", "execPerConnectionSQL", "", "sQLiteDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "sql", "", "bindArgs", "", "(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/Object;)V", "sqlite-framework_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Api30Impl {
        public static final Api30Impl INSTANCE = new Api30Impl();

        private Api30Impl() {
        }

        public final void execPerConnectionSQL(SQLiteDatabase sQLiteDatabase, String string2, Object[] objectArray) {
            Intrinsics.checkNotNullParameter((Object)sQLiteDatabase, (String)"sQLiteDatabase");
            Intrinsics.checkNotNullParameter((Object)string2, (String)"sql");
            sQLiteDatabase.execPerConnectionSQL(string2, objectArray);
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006\b"}, d2={"Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase$Companion;", "", "()V", "CONFLICT_VALUES", "", "", "[Ljava/lang/String;", "EMPTY_STRING_ARRAY", "sqlite-framework_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

