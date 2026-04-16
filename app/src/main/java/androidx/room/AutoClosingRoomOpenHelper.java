/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentValues
 *  android.database.CharArrayBuffer
 *  android.database.ContentObserver
 *  android.database.Cursor
 *  android.database.DataSetObserver
 *  android.database.SQLException
 *  android.database.sqlite.SQLiteTransactionListener
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.CancellationSignal
 *  android.util.Pair
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.room;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.room.AutoCloser;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.room.DelegatingOpenHelper;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u001a\u001b\u001cB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0011\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0097\u0001R\u0010\u0010\u0004\u001a\u00020\u00058\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u0001X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012\u00a8\u0006\u001d"}, d2={"Landroidx/room/AutoClosingRoomOpenHelper;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "Landroidx/room/DelegatingOpenHelper;", "delegate", "autoCloser", "Landroidx/room/AutoCloser;", "(Landroidx/sqlite/db/SupportSQLiteOpenHelper;Landroidx/room/AutoCloser;)V", "autoClosingDb", "Landroidx/room/AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase;", "databaseName", "", "getDatabaseName", "()Ljava/lang/String;", "getDelegate", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "readableDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getReadableDatabase", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "writableDatabase", "getWritableDatabase", "close", "", "setWriteAheadLoggingEnabled", "enabled", "", "AutoClosingSupportSQLiteDatabase", "AutoClosingSupportSqliteStatement", "KeepAliveCursor", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
public final class AutoClosingRoomOpenHelper
implements SupportSQLiteOpenHelper,
DelegatingOpenHelper {
    public final AutoCloser autoCloser;
    private final AutoClosingSupportSQLiteDatabase autoClosingDb;
    private final SupportSQLiteOpenHelper delegate;

    public AutoClosingRoomOpenHelper(SupportSQLiteOpenHelper supportSQLiteOpenHelper, AutoCloser autoCloser) {
        Intrinsics.checkNotNullParameter((Object)supportSQLiteOpenHelper, (String)"delegate");
        Intrinsics.checkNotNullParameter((Object)autoCloser, (String)"autoCloser");
        this.delegate = supportSQLiteOpenHelper;
        this.autoCloser = autoCloser;
        this.autoCloser.init(this.getDelegate());
        this.autoClosingDb = new AutoClosingSupportSQLiteDatabase(this.autoCloser);
    }

    @Override
    public void close() {
        this.autoClosingDb.close();
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
        this.autoClosingDb.pokeOpen();
        return this.autoClosingDb;
    }

    @Override
    public SupportSQLiteDatabase getWritableDatabase() {
        this.autoClosingDb.pokeOpen();
        return this.autoClosingDb;
    }

    @Override
    public void setWriteAheadLoggingEnabled(boolean bl) {
        this.delegate.setWriteAheadLoggingEnabled(bl);
    }

    @Metadata(d1={"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020%H\u0016J\u0010\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020%2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010+\u001a\u00020%H\u0016J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\bH\u0016J3\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u00010\b2\u0012\u00102\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000104\u0018\u000103H\u0016\u00a2\u0006\u0002\u00105J\b\u00106\u001a\u00020%H\u0016J\b\u00107\u001a\u00020\fH\u0016J\b\u00108\u001a\u00020%H\u0016J\u0010\u00109\u001a\u00020%2\u0006\u0010.\u001a\u00020\bH\u0016J'\u00109\u001a\u00020%2\u0006\u0010.\u001a\u00020\b2\u0010\u0010:\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010403H\u0016\u00a2\u0006\u0002\u0010;J\b\u0010<\u001a\u00020\fH\u0016J \u0010=\u001a\u00020\u00132\u0006\u00100\u001a\u00020\b2\u0006\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020\f2\u0006\u0010B\u001a\u00020\u001fH\u0016J\u0006\u0010C\u001a\u00020%J\u0010\u0010D\u001a\u00020E2\u0006\u0010D\u001a\u00020FH\u0016J\u001a\u0010D\u001a\u00020E2\u0006\u0010D\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010HH\u0017J\u0010\u0010D\u001a\u00020E2\u0006\u0010D\u001a\u00020\bH\u0016J'\u0010D\u001a\u00020E2\u0006\u0010D\u001a\u00020\b2\u0010\u0010:\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010403H\u0016\u00a2\u0006\u0002\u0010IJ\u0010\u0010J\u001a\u00020%2\u0006\u0010K\u001a\u00020\fH\u0017J\u0010\u0010L\u001a\u00020%2\u0006\u0010M\u001a\u00020NH\u0016J\u0010\u0010O\u001a\u00020%2\u0006\u0010P\u001a\u00020\u001fH\u0016J\u0010\u0010Q\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010R\u001a\u00020%H\u0016JC\u0010S\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\b2\u0006\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020@2\b\u00101\u001a\u0004\u0018\u00010\b2\u0012\u00102\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000104\u0018\u000103H\u0016\u00a2\u0006\u0002\u0010TJ\b\u0010U\u001a\u00020\fH\u0016J\u0010\u0010U\u001a\u00020\f2\u0006\u0010V\u001a\u00020\u0013H\u0016R(\u0010\u0005\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\f8WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00138V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006W"}, d2={"Landroidx/room/AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "autoCloser", "Landroidx/room/AutoCloser;", "(Landroidx/room/AutoCloser;)V", "attachedDbs", "", "Landroid/util/Pair;", "", "getAttachedDbs", "()Ljava/util/List;", "isDatabaseIntegrityOk", "", "()Z", "isDbLockedByCurrentThread", "isOpen", "isReadOnly", "isWriteAheadLoggingEnabled", "maximumSize", "", "getMaximumSize", "()J", "numBytes", "pageSize", "getPageSize", "setPageSize", "(J)V", "path", "getPath", "()Ljava/lang/String;", "version", "", "getVersion", "()I", "setVersion", "(I)V", "beginTransaction", "", "beginTransactionNonExclusive", "beginTransactionWithListener", "transactionListener", "Landroid/database/sqlite/SQLiteTransactionListener;", "beginTransactionWithListenerNonExclusive", "close", "compileStatement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "sql", "delete", "table", "whereClause", "whereArgs", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I", "disableWriteAheadLogging", "enableWriteAheadLogging", "endTransaction", "execSQL", "bindArgs", "(Ljava/lang/String;[Ljava/lang/Object;)V", "inTransaction", "insert", "conflictAlgorithm", "values", "Landroid/content/ContentValues;", "needUpgrade", "newVersion", "pokeOpen", "query", "Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Ljava/lang/String;[Ljava/lang/Object;)Landroid/database/Cursor;", "setForeignKeyConstraintsEnabled", "enabled", "setLocale", "locale", "Ljava/util/Locale;", "setMaxSqlCacheSize", "cacheSize", "setMaximumSize", "setTransactionSuccessful", "update", "(Ljava/lang/String;ILandroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/Object;)I", "yieldIfContendedSafely", "sleepAfterYieldDelayMillis", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class AutoClosingSupportSQLiteDatabase
    implements SupportSQLiteDatabase {
        private final AutoCloser autoCloser;

        public AutoClosingSupportSQLiteDatabase(AutoCloser autoCloser) {
            Intrinsics.checkNotNullParameter((Object)autoCloser, (String)"autoCloser");
            this.autoCloser = autoCloser;
        }

        @Override
        public void beginTransaction() {
            SupportSQLiteDatabase supportSQLiteDatabase = this.autoCloser.incrementCountAndEnsureDbIsOpen();
            try {
                supportSQLiteDatabase.beginTransaction();
                return;
            }
            catch (Throwable throwable) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw throwable;
            }
        }

        @Override
        public void beginTransactionNonExclusive() {
            SupportSQLiteDatabase supportSQLiteDatabase = this.autoCloser.incrementCountAndEnsureDbIsOpen();
            try {
                supportSQLiteDatabase.beginTransactionNonExclusive();
                return;
            }
            catch (Throwable throwable) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw throwable;
            }
        }

        @Override
        public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
            Intrinsics.checkNotNullParameter((Object)sQLiteTransactionListener, (String)"transactionListener");
            SupportSQLiteDatabase supportSQLiteDatabase = this.autoCloser.incrementCountAndEnsureDbIsOpen();
            try {
                supportSQLiteDatabase.beginTransactionWithListener(sQLiteTransactionListener);
                return;
            }
            catch (Throwable throwable) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw throwable;
            }
        }

        @Override
        public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
            Intrinsics.checkNotNullParameter((Object)sQLiteTransactionListener, (String)"transactionListener");
            SupportSQLiteDatabase supportSQLiteDatabase = this.autoCloser.incrementCountAndEnsureDbIsOpen();
            try {
                supportSQLiteDatabase.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
                return;
            }
            catch (Throwable throwable) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw throwable;
            }
        }

        @Override
        public void close() throws IOException {
            this.autoCloser.closeDatabaseIfOpen();
        }

        @Override
        public SupportSQLiteStatement compileStatement(String string2) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"sql");
            return new AutoClosingSupportSqliteStatement(string2, this.autoCloser);
        }

        @Override
        public int delete(String string2, String string3, Object[] objectArray) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"table");
            return ((Number)this.autoCloser.executeRefCountingFunction((Function1)new Function1<SupportSQLiteDatabase, Integer>(string2, string3, objectArray){
                final String $table;
                final Object[] $whereArgs;
                final String $whereClause;
                {
                    this.$table = string2;
                    this.$whereClause = string3;
                    this.$whereArgs = objectArray;
                    super(1);
                }

                public final Integer invoke(SupportSQLiteDatabase supportSQLiteDatabase) {
                    Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
                    return supportSQLiteDatabase.delete(this.$table, this.$whereClause, this.$whereArgs);
                }
            })).intValue();
        }

        @Override
        public void disableWriteAheadLogging() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        @Override
        public boolean enableWriteAheadLogging() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        @Override
        public void endTransaction() {
            if (this.autoCloser.getDelegateDatabase$room_runtime_release() != null) {
                try {
                    SupportSQLiteDatabase supportSQLiteDatabase = this.autoCloser.getDelegateDatabase$room_runtime_release();
                    Intrinsics.checkNotNull((Object)supportSQLiteDatabase);
                    supportSQLiteDatabase.endTransaction();
                    return;
                }
                finally {
                    this.autoCloser.decrementCountAndScheduleClose();
                }
            }
            throw new IllegalStateException("End transaction called but delegateDb is null".toString());
        }

        @Override
        public void execSQL(String string2) throws SQLException {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"sql");
            this.autoCloser.executeRefCountingFunction((Function1)new Function1<SupportSQLiteDatabase, Object>(string2){
                final String $sql;
                {
                    this.$sql = string2;
                    super(1);
                }

                public final Object invoke(SupportSQLiteDatabase supportSQLiteDatabase) {
                    Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
                    supportSQLiteDatabase.execSQL(this.$sql);
                    return null;
                }
            });
        }

        @Override
        public void execSQL(String string2, Object[] objectArray) throws SQLException {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"sql");
            Intrinsics.checkNotNullParameter((Object)objectArray, (String)"bindArgs");
            this.autoCloser.executeRefCountingFunction((Function1)new Function1<SupportSQLiteDatabase, Object>(string2, objectArray){
                final Object[] $bindArgs;
                final String $sql;
                {
                    this.$sql = string2;
                    this.$bindArgs = objectArray;
                    super(1);
                }

                public final Object invoke(SupportSQLiteDatabase supportSQLiteDatabase) {
                    Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
                    supportSQLiteDatabase.execSQL(this.$sql, this.$bindArgs);
                    return null;
                }
            });
        }

        @Override
        public List<Pair<String, String>> getAttachedDbs() {
            return (List)this.autoCloser.executeRefCountingFunction(attachedDbs.1.INSTANCE);
        }

        @Override
        public long getMaximumSize() {
            return ((Number)this.autoCloser.executeRefCountingFunction((Function1)maximumSize.1.INSTANCE)).longValue();
        }

        @Override
        public long getPageSize() {
            return ((Number)this.autoCloser.executeRefCountingFunction((Function1)pageSize.1.INSTANCE)).longValue();
        }

        @Override
        public String getPath() {
            return (String)this.autoCloser.executeRefCountingFunction(path.1.INSTANCE);
        }

        @Override
        public int getVersion() {
            return ((Number)this.autoCloser.executeRefCountingFunction((Function1)version.1.INSTANCE)).intValue();
        }

        @Override
        public boolean inTransaction() {
            boolean bl = this.autoCloser.getDelegateDatabase$room_runtime_release() == null ? false : (Boolean)this.autoCloser.executeRefCountingFunction(inTransaction.1.INSTANCE);
            return bl;
        }

        @Override
        public long insert(String string2, int n, ContentValues contentValues) throws SQLException {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"table");
            Intrinsics.checkNotNullParameter((Object)contentValues, (String)"values");
            return ((Number)this.autoCloser.executeRefCountingFunction((Function1)new Function1<SupportSQLiteDatabase, Long>(string2, n, contentValues){
                final int $conflictAlgorithm;
                final String $table;
                final ContentValues $values;
                {
                    this.$table = string2;
                    this.$conflictAlgorithm = n;
                    this.$values = contentValues;
                    super(1);
                }

                public final Long invoke(SupportSQLiteDatabase supportSQLiteDatabase) {
                    Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
                    return supportSQLiteDatabase.insert(this.$table, this.$conflictAlgorithm, this.$values);
                }
            })).longValue();
        }

        @Override
        public boolean isDatabaseIntegrityOk() {
            return (Boolean)this.autoCloser.executeRefCountingFunction(isDatabaseIntegrityOk.1.INSTANCE);
        }

        @Override
        public boolean isDbLockedByCurrentThread() {
            boolean bl = this.autoCloser.getDelegateDatabase$room_runtime_release() == null ? false : (Boolean)this.autoCloser.executeRefCountingFunction((Function1)isDbLockedByCurrentThread.1.INSTANCE);
            return bl;
        }

        @Override
        public boolean isOpen() {
            SupportSQLiteDatabase supportSQLiteDatabase = this.autoCloser.getDelegateDatabase$room_runtime_release();
            if (supportSQLiteDatabase == null) {
                return false;
            }
            return supportSQLiteDatabase.isOpen();
        }

        @Override
        public boolean isReadOnly() {
            return (Boolean)this.autoCloser.executeRefCountingFunction(isReadOnly.1.INSTANCE);
        }

        @Override
        public boolean isWriteAheadLoggingEnabled() {
            return (Boolean)this.autoCloser.executeRefCountingFunction(isWriteAheadLoggingEnabled.1.INSTANCE);
        }

        @Override
        public boolean needUpgrade(int n) {
            return (Boolean)this.autoCloser.executeRefCountingFunction((Function1)new Function1<SupportSQLiteDatabase, Boolean>(n){
                final int $newVersion;
                {
                    this.$newVersion = n;
                    super(1);
                }

                public final Boolean invoke(SupportSQLiteDatabase supportSQLiteDatabase) {
                    Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
                    return supportSQLiteDatabase.needUpgrade(this.$newVersion);
                }
            });
        }

        public final void pokeOpen() {
            this.autoCloser.executeRefCountingFunction(pokeOpen.1.INSTANCE);
        }

        @Override
        public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
            Intrinsics.checkNotNullParameter((Object)supportSQLiteQuery, (String)"query");
            try {
                supportSQLiteQuery = this.autoCloser.incrementCountAndEnsureDbIsOpen().query(supportSQLiteQuery);
            }
            catch (Throwable throwable) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw throwable;
            }
            return new KeepAliveCursor((Cursor)supportSQLiteQuery, this.autoCloser);
        }

        @Override
        public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
            Intrinsics.checkNotNullParameter((Object)supportSQLiteQuery, (String)"query");
            try {
                supportSQLiteQuery = this.autoCloser.incrementCountAndEnsureDbIsOpen().query(supportSQLiteQuery, cancellationSignal);
            }
            catch (Throwable throwable) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw throwable;
            }
            return new KeepAliveCursor((Cursor)supportSQLiteQuery, this.autoCloser);
        }

        @Override
        public Cursor query(String string2) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"query");
            try {
                string2 = this.autoCloser.incrementCountAndEnsureDbIsOpen().query(string2);
            }
            catch (Throwable throwable) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw throwable;
            }
            return new KeepAliveCursor((Cursor)string2, this.autoCloser);
        }

        @Override
        public Cursor query(String string2, Object[] objectArray) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"query");
            Intrinsics.checkNotNullParameter((Object)objectArray, (String)"bindArgs");
            try {
                string2 = this.autoCloser.incrementCountAndEnsureDbIsOpen().query(string2, objectArray);
            }
            catch (Throwable throwable) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw throwable;
            }
            return new KeepAliveCursor((Cursor)string2, this.autoCloser);
        }

        @Override
        public void setForeignKeyConstraintsEnabled(boolean bl) {
            this.autoCloser.executeRefCountingFunction((Function1)new Function1<SupportSQLiteDatabase, Object>(bl){
                final boolean $enabled;
                {
                    this.$enabled = bl;
                    super(1);
                }

                public final Object invoke(SupportSQLiteDatabase supportSQLiteDatabase) {
                    Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
                    supportSQLiteDatabase.setForeignKeyConstraintsEnabled(this.$enabled);
                    return null;
                }
            });
        }

        @Override
        public void setLocale(Locale locale) {
            Intrinsics.checkNotNullParameter((Object)locale, (String)"locale");
            this.autoCloser.executeRefCountingFunction((Function1)new Function1<SupportSQLiteDatabase, Object>(locale){
                final Locale $locale;
                {
                    this.$locale = locale;
                    super(1);
                }

                public final Object invoke(SupportSQLiteDatabase supportSQLiteDatabase) {
                    Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
                    supportSQLiteDatabase.setLocale(this.$locale);
                    return null;
                }
            });
        }

        @Override
        public void setMaxSqlCacheSize(int n) {
            this.autoCloser.executeRefCountingFunction((Function1)new Function1<SupportSQLiteDatabase, Object>(n){
                final int $cacheSize;
                {
                    this.$cacheSize = n;
                    super(1);
                }

                public final Object invoke(SupportSQLiteDatabase supportSQLiteDatabase) {
                    Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
                    supportSQLiteDatabase.setMaxSqlCacheSize(this.$cacheSize);
                    return null;
                }
            });
        }

        @Override
        public long setMaximumSize(long l) {
            return ((Number)this.autoCloser.executeRefCountingFunction((Function1)new Function1<SupportSQLiteDatabase, Long>(l){
                final long $numBytes;
                {
                    this.$numBytes = l;
                    super(1);
                }

                public final Long invoke(SupportSQLiteDatabase supportSQLiteDatabase) {
                    Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
                    return supportSQLiteDatabase.setMaximumSize(this.$numBytes);
                }
            })).longValue();
        }

        @Override
        public void setPageSize(long l) {
            this.autoCloser.executeRefCountingFunction((Function1)new Function1<SupportSQLiteDatabase, Object>(l){
                final long $numBytes;
                {
                    this.$numBytes = l;
                    super(1);
                }

                public final Object invoke(SupportSQLiteDatabase supportSQLiteDatabase) {
                    Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
                    supportSQLiteDatabase.setPageSize(this.$numBytes);
                    return null;
                }
            });
        }

        @Override
        public void setTransactionSuccessful() {
            SupportSQLiteDatabase supportSQLiteDatabase = this.autoCloser.getDelegateDatabase$room_runtime_release();
            if (supportSQLiteDatabase != null) {
                supportSQLiteDatabase.setTransactionSuccessful();
                supportSQLiteDatabase = Unit.INSTANCE;
            } else {
                supportSQLiteDatabase = null;
            }
            if (supportSQLiteDatabase != null) {
                return;
            }
            throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null".toString());
        }

        @Override
        public void setVersion(int n) {
            this.autoCloser.executeRefCountingFunction((Function1)new Function1<SupportSQLiteDatabase, Object>(n){
                final int $version;
                {
                    this.$version = n;
                    super(1);
                }

                public final Object invoke(SupportSQLiteDatabase supportSQLiteDatabase) {
                    Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
                    supportSQLiteDatabase.setVersion(this.$version);
                    return null;
                }
            });
        }

        @Override
        public int update(String string2, int n, ContentValues contentValues, String string3, Object[] objectArray) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"table");
            Intrinsics.checkNotNullParameter((Object)contentValues, (String)"values");
            return ((Number)this.autoCloser.executeRefCountingFunction((Function1)new Function1<SupportSQLiteDatabase, Integer>(string2, n, contentValues, string3, objectArray){
                final int $conflictAlgorithm;
                final String $table;
                final ContentValues $values;
                final Object[] $whereArgs;
                final String $whereClause;
                {
                    this.$table = string2;
                    this.$conflictAlgorithm = n;
                    this.$values = contentValues;
                    this.$whereClause = string3;
                    this.$whereArgs = objectArray;
                    super(1);
                }

                public final Integer invoke(SupportSQLiteDatabase supportSQLiteDatabase) {
                    Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
                    return supportSQLiteDatabase.update(this.$table, this.$conflictAlgorithm, this.$values, this.$whereClause, this.$whereArgs);
                }
            })).intValue();
        }

        @Override
        public boolean yieldIfContendedSafely() {
            return (Boolean)this.autoCloser.executeRefCountingFunction(yieldIfContendedSafely.1.INSTANCE);
        }

        @Override
        public boolean yieldIfContendedSafely(long l) {
            return (Boolean)this.autoCloser.executeRefCountingFunction(yieldIfContendedSafely.2.INSTANCE);
        }
    }

    @Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0001H\u0002J\b\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0016J'\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u001e0 H\u0002\u00a2\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u000eH\u0016J\u001a\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010%\u001a\u00020\u0014H\u0016J\n\u0010&\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\t0\bj\n\u0012\u0006\u0012\u0004\u0018\u00010\t`\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006'"}, d2={"Landroidx/room/AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement;", "Landroidx/sqlite/db/SupportSQLiteStatement;", "sql", "", "autoCloser", "Landroidx/room/AutoCloser;", "(Ljava/lang/String;Landroidx/room/AutoCloser;)V", "binds", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "bindBlob", "", "index", "", "value", "", "bindDouble", "", "bindLong", "", "bindNull", "bindString", "clearBindings", "close", "doBinds", "supportSQLiteStatement", "execute", "executeInsert", "executeSqliteStatementWithRefCount", "T", "block", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "executeUpdateDelete", "saveBinds", "bindIndex", "simpleQueryForLong", "simpleQueryForString", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
    private static final class AutoClosingSupportSqliteStatement
    implements SupportSQLiteStatement {
        private final AutoCloser autoCloser;
        private final ArrayList<Object> binds;
        private final String sql;

        public AutoClosingSupportSqliteStatement(String string2, AutoCloser autoCloser) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"sql");
            Intrinsics.checkNotNullParameter((Object)autoCloser, (String)"autoCloser");
            this.sql = string2;
            this.autoCloser = autoCloser;
            this.binds = new ArrayList();
        }

        public static final /* synthetic */ void access$doBinds(AutoClosingSupportSqliteStatement autoClosingSupportSqliteStatement, SupportSQLiteStatement supportSQLiteStatement) {
            autoClosingSupportSqliteStatement.doBinds(supportSQLiteStatement);
        }

        public static final /* synthetic */ String access$getSql$p(AutoClosingSupportSqliteStatement autoClosingSupportSqliteStatement) {
            return autoClosingSupportSqliteStatement.sql;
        }

        private final void doBinds(SupportSQLiteStatement supportSQLiteStatement) {
            Object object = this.binds;
            int n = 0;
            object = object.iterator();
            while (object.hasNext()) {
                object.next();
                if (n < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                int n2 = n + 1;
                Object object2 = this.binds.get(n);
                if (object2 == null) {
                    supportSQLiteStatement.bindNull(n2);
                } else if (object2 instanceof Long) {
                    supportSQLiteStatement.bindLong(n2, ((Number)object2).longValue());
                } else if (object2 instanceof Double) {
                    supportSQLiteStatement.bindDouble(n2, ((Number)object2).doubleValue());
                } else if (object2 instanceof String) {
                    supportSQLiteStatement.bindString(n2, (String)object2);
                } else if (object2 instanceof byte[]) {
                    supportSQLiteStatement.bindBlob(n2, (byte[])object2);
                }
                ++n;
            }
        }

        private final <T> T executeSqliteStatementWithRefCount(Function1<? super SupportSQLiteStatement, ? extends T> function1) {
            return (T)this.autoCloser.executeRefCountingFunction((Function1)new Function1<SupportSQLiteDatabase, T>(this, function1){
                final Function1<SupportSQLiteStatement, T> $block;
                final AutoClosingSupportSqliteStatement this$0;
                {
                    this.this$0 = autoClosingSupportSqliteStatement;
                    this.$block = function1;
                    super(1);
                }

                public final T invoke(SupportSQLiteDatabase closeable) {
                    Intrinsics.checkNotNullParameter((Object)closeable, (String)"db");
                    closeable = closeable.compileStatement(AutoClosingSupportSqliteStatement.access$getSql$p(this.this$0));
                    AutoClosingSupportSqliteStatement.access$doBinds(this.this$0, (SupportSQLiteStatement)closeable);
                    return (T)this.$block.invoke((Object)closeable);
                }
            });
        }

        private final void saveBinds(int n, Object object) {
            int n2 = n - 1;
            if (n2 >= this.binds.size() && (n = this.binds.size()) <= n2) {
                while (true) {
                    this.binds.add(null);
                    if (n == n2) break;
                    ++n;
                }
            }
            this.binds.set(n2, object);
        }

        @Override
        public void bindBlob(int n, byte[] byArray) {
            Intrinsics.checkNotNullParameter((Object)byArray, (String)"value");
            this.saveBinds(n, byArray);
        }

        @Override
        public void bindDouble(int n, double d) {
            this.saveBinds(n, d);
        }

        @Override
        public void bindLong(int n, long l) {
            this.saveBinds(n, l);
        }

        @Override
        public void bindNull(int n) {
            this.saveBinds(n, null);
        }

        @Override
        public void bindString(int n, String string2) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"value");
            this.saveBinds(n, string2);
        }

        @Override
        public void clearBindings() {
            this.binds.clear();
        }

        @Override
        public void close() throws IOException {
        }

        @Override
        public void execute() {
            this.executeSqliteStatementWithRefCount(execute.1.INSTANCE);
        }

        @Override
        public long executeInsert() {
            return ((Number)this.executeSqliteStatementWithRefCount(executeInsert.1.INSTANCE)).longValue();
        }

        @Override
        public int executeUpdateDelete() {
            return ((Number)this.executeSqliteStatementWithRefCount(executeUpdateDelete.1.INSTANCE)).intValue();
        }

        @Override
        public long simpleQueryForLong() {
            return ((Number)this.executeSqliteStatementWithRefCount(simpleQueryForLong.1.INSTANCE)).longValue();
        }

        @Override
        public String simpleQueryForString() {
            return (String)this.executeSqliteStatementWithRefCount(simpleQueryForString.1.INSTANCE);
        }
    }

    @Metadata(d1={"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J!\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fH\u0096\u0001J\t\u0010\u000e\u001a\u00020\u0007H\u0097\u0001J\u0019\u0010\u000f\u001a\n \r*\u0004\u0018\u00010\u00100\u00102\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\t\u0010\u0011\u001a\u00020\nH\u0096\u0001J\u0019\u0010\u0012\u001a\u00020\n2\u000e\u0010\t\u001a\n \r*\u0004\u0018\u00010\u00130\u0013H\u0096\u0001J\u0019\u0010\u0014\u001a\u00020\n2\u000e\u0010\t\u001a\n \r*\u0004\u0018\u00010\u00130\u0013H\u0096\u0001J\u0019\u0010\u0015\u001a\n \r*\u0004\u0018\u00010\u00130\u00132\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J4\u0010\u0016\u001a(\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00130\u0013 \r*\u0014\u0012\u000e\b\u0001\u0012\n \r*\u0004\u0018\u00010\u00130\u0013\u0018\u00010\u00170\u0017H\u0096\u0001\u00a2\u0006\u0002\u0010\u0018J\t\u0010\u0019\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u001c\u001a\n \r*\u0004\u0018\u00010\u001d0\u001dH\u0096\u0001J\u0011\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0011\u0010 \u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0011\u0010!\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\b\u0010#\u001a\u00020$H\u0017J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020$0&H\u0017J\t\u0010'\u001a\u00020\nH\u0096\u0001J\u0011\u0010(\u001a\u00020)2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0019\u0010*\u001a\n \r*\u0004\u0018\u00010\u00130\u00132\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0011\u0010+\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\t\u0010,\u001a\u00020-H\u0096\u0001J\t\u0010.\u001a\u00020-H\u0096\u0001J\t\u0010/\u001a\u00020-H\u0096\u0001J\t\u00100\u001a\u00020-H\u0096\u0001J\t\u00101\u001a\u00020-H\u0096\u0001J\t\u00102\u001a\u00020-H\u0096\u0001J\u0011\u00103\u001a\u00020-2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0011\u00104\u001a\u00020-2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\t\u00105\u001a\u00020-H\u0096\u0001J\t\u00106\u001a\u00020-H\u0096\u0001J\t\u00107\u001a\u00020-H\u0096\u0001J\u0011\u00108\u001a\u00020-2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\t\u00109\u001a\u00020-H\u0096\u0001J\u0019\u0010:\u001a\u00020\u00072\u000e\u0010\t\u001a\n \r*\u0004\u0018\u00010;0;H\u0096\u0001J\u0019\u0010<\u001a\u00020\u00072\u000e\u0010\t\u001a\n \r*\u0004\u0018\u00010=0=H\u0096\u0001J\t\u0010>\u001a\u00020-H\u0097\u0001J!\u0010?\u001a\n \r*\u0004\u0018\u00010\u001d0\u001d2\u000e\u0010\t\u001a\n \r*\u0004\u0018\u00010\u001d0\u001dH\u0096\u0001J\u0010\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u001dH\u0017J)\u0010B\u001a\u00020\u00072\u000e\u0010\t\u001a\n \r*\u0004\u0018\u00010C0C2\u000e\u0010\u000b\u001a\n \r*\u0004\u0018\u00010$0$H\u0096\u0001J\u001e\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020C2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020$0&H\u0017J\u0019\u0010G\u001a\u00020\u00072\u000e\u0010\t\u001a\n \r*\u0004\u0018\u00010;0;H\u0096\u0001J\u0019\u0010H\u001a\u00020\u00072\u000e\u0010\t\u001a\n \r*\u0004\u0018\u00010=0=H\u0096\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006I"}, d2={"Landroidx/room/AutoClosingRoomOpenHelper$KeepAliveCursor;", "Landroid/database/Cursor;", "delegate", "autoCloser", "Landroidx/room/AutoCloser;", "(Landroid/database/Cursor;Landroidx/room/AutoCloser;)V", "close", "", "copyStringToBuffer", "p0", "", "p1", "Landroid/database/CharArrayBuffer;", "kotlin.jvm.PlatformType", "deactivate", "getBlob", "", "getColumnCount", "getColumnIndex", "", "getColumnIndexOrThrow", "getColumnName", "getColumnNames", "", "()[Ljava/lang/String;", "getCount", "getDouble", "", "getExtras", "Landroid/os/Bundle;", "getFloat", "", "getInt", "getLong", "", "getNotificationUri", "Landroid/net/Uri;", "getNotificationUris", "", "getPosition", "getShort", "", "getString", "getType", "getWantsAllOnMoveCalls", "", "isAfterLast", "isBeforeFirst", "isClosed", "isFirst", "isLast", "isNull", "move", "moveToFirst", "moveToLast", "moveToNext", "moveToPosition", "moveToPrevious", "registerContentObserver", "Landroid/database/ContentObserver;", "registerDataSetObserver", "Landroid/database/DataSetObserver;", "requery", "respond", "setExtras", "extras", "setNotificationUri", "Landroid/content/ContentResolver;", "setNotificationUris", "cr", "uris", "unregisterContentObserver", "unregisterDataSetObserver", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
    private static final class KeepAliveCursor
    implements Cursor {
        private final AutoCloser autoCloser;
        private final Cursor delegate;

        public KeepAliveCursor(Cursor cursor, AutoCloser autoCloser) {
            Intrinsics.checkNotNullParameter((Object)cursor, (String)"delegate");
            Intrinsics.checkNotNullParameter((Object)autoCloser, (String)"autoCloser");
            this.delegate = cursor;
            this.autoCloser = autoCloser;
        }

        public void close() {
            this.delegate.close();
            this.autoCloser.decrementCountAndScheduleClose();
        }

        public void copyStringToBuffer(int n, CharArrayBuffer charArrayBuffer) {
            this.delegate.copyStringToBuffer(n, charArrayBuffer);
        }

        @Deprecated(message="Deprecated in Java")
        public void deactivate() {
            this.delegate.deactivate();
        }

        public byte[] getBlob(int n) {
            return this.delegate.getBlob(n);
        }

        public int getColumnCount() {
            return this.delegate.getColumnCount();
        }

        public int getColumnIndex(String string2) {
            return this.delegate.getColumnIndex(string2);
        }

        public int getColumnIndexOrThrow(String string2) {
            return this.delegate.getColumnIndexOrThrow(string2);
        }

        public String getColumnName(int n) {
            return this.delegate.getColumnName(n);
        }

        public String[] getColumnNames() {
            return this.delegate.getColumnNames();
        }

        public int getCount() {
            return this.delegate.getCount();
        }

        public double getDouble(int n) {
            return this.delegate.getDouble(n);
        }

        public Bundle getExtras() {
            return this.delegate.getExtras();
        }

        public float getFloat(int n) {
            return this.delegate.getFloat(n);
        }

        public int getInt(int n) {
            return this.delegate.getInt(n);
        }

        public long getLong(int n) {
            return this.delegate.getLong(n);
        }

        public Uri getNotificationUri() {
            return SupportSQLiteCompat.Api19Impl.getNotificationUri(this.delegate);
        }

        public List<Uri> getNotificationUris() {
            return SupportSQLiteCompat.Api29Impl.getNotificationUris(this.delegate);
        }

        public int getPosition() {
            return this.delegate.getPosition();
        }

        public short getShort(int n) {
            return this.delegate.getShort(n);
        }

        public String getString(int n) {
            return this.delegate.getString(n);
        }

        public int getType(int n) {
            return this.delegate.getType(n);
        }

        public boolean getWantsAllOnMoveCalls() {
            return this.delegate.getWantsAllOnMoveCalls();
        }

        public boolean isAfterLast() {
            return this.delegate.isAfterLast();
        }

        public boolean isBeforeFirst() {
            return this.delegate.isBeforeFirst();
        }

        public boolean isClosed() {
            return this.delegate.isClosed();
        }

        public boolean isFirst() {
            return this.delegate.isFirst();
        }

        public boolean isLast() {
            return this.delegate.isLast();
        }

        public boolean isNull(int n) {
            return this.delegate.isNull(n);
        }

        public boolean move(int n) {
            return this.delegate.move(n);
        }

        public boolean moveToFirst() {
            return this.delegate.moveToFirst();
        }

        public boolean moveToLast() {
            return this.delegate.moveToLast();
        }

        public boolean moveToNext() {
            return this.delegate.moveToNext();
        }

        public boolean moveToPosition(int n) {
            return this.delegate.moveToPosition(n);
        }

        public boolean moveToPrevious() {
            return this.delegate.moveToPrevious();
        }

        public void registerContentObserver(ContentObserver contentObserver) {
            this.delegate.registerContentObserver(contentObserver);
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.delegate.registerDataSetObserver(dataSetObserver);
        }

        @Deprecated(message="Deprecated in Java")
        public boolean requery() {
            return this.delegate.requery();
        }

        public Bundle respond(Bundle bundle) {
            return this.delegate.respond(bundle);
        }

        public void setExtras(Bundle bundle) {
            Intrinsics.checkNotNullParameter((Object)bundle, (String)"extras");
            SupportSQLiteCompat.Api23Impl.setExtras(this.delegate, bundle);
        }

        public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
            this.delegate.setNotificationUri(contentResolver, uri);
        }

        public void setNotificationUris(ContentResolver contentResolver, List<? extends Uri> list) {
            Intrinsics.checkNotNullParameter((Object)contentResolver, (String)"cr");
            Intrinsics.checkNotNullParameter(list, (String)"uris");
            SupportSQLiteCompat.Api29Impl.setNotificationUris(this.delegate, contentResolver, list);
        }

        public void unregisterContentObserver(ContentObserver contentObserver) {
            this.delegate.unregisterContentObserver(contentObserver);
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.delegate.unregisterDataSetObserver(dataSetObserver);
        }
    }
}

