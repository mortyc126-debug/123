/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.content.Context
 *  android.content.Intent
 *  android.database.Cursor
 *  android.os.CancellationSignal
 *  android.os.Looper
 *  android.util.Log
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.room;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.AutoCloser;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.room.AutoClosingRoomOpenHelperFactory;
import androidx.room.DatabaseConfiguration;
import androidx.room.DelegatingOpenHelper;
import androidx.room.ExperimentalRoomApi;
import androidx.room.InvalidationTracker;
import androidx.room.MultiInstanceInvalidationService;
import androidx.room.QueryInterceptorOpenHelperFactory;
import androidx.room.Room;
import androidx.room.SQLiteCopyOpenHelper;
import androidx.room.SQLiteCopyOpenHelperFactory;
import androidx.room.TransactionExecutor;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u00c4\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000 n2\u00020\u0001:\u0007lmnopqrB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u00108\u001a\u000209H\u0017J\b\u0010:\u001a\u000209H\u0017J\b\u0010;\u001a\u000209H\u0017J\b\u0010<\u001a\u000209H'J\b\u0010=\u001a\u000209H\u0016J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0010H\u0016J\b\u0010A\u001a\u00020\u0018H$J\u0010\u0010B\u001a\u00020\u00132\u0006\u0010C\u001a\u00020DH$J\b\u0010E\u001a\u000209H\u0017J*\u0010F\u001a\b\u0012\u0004\u0012\u00020G0!2\u001a\u0010\u0007\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\n0HH\u0017J\r\u0010I\u001a\u00020JH\u0000\u00a2\u0006\u0002\bKJ\u0016\u0010L\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t0MH\u0017J\"\u0010N\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0!0HH\u0015J#\u0010O\u001a\u0004\u0018\u0001HP\"\u0004\b\u0000\u0010P2\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002HP0\tH\u0016\u00a2\u0006\u0002\u0010RJ\b\u0010S\u001a\u00020\u0004H\u0016J\u0010\u0010T\u001a\u0002092\u0006\u0010U\u001a\u00020DH\u0017J\b\u0010V\u001a\u000209H\u0002J\b\u0010W\u001a\u000209H\u0002J\u0010\u0010X\u001a\u0002092\u0006\u0010Y\u001a\u00020%H\u0014J\u001c\u0010Z\u001a\u00020[2\u0006\u0010Z\u001a\u00020\\2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010^H\u0017J)\u0010Z\u001a\u00020[2\u0006\u0010Z\u001a\u00020\u00102\u0012\u0010_\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010`H\u0016\u00a2\u0006\u0002\u0010aJ\u0010\u0010b\u001a\u0002092\u0006\u0010c\u001a\u00020dH\u0016J!\u0010b\u001a\u0002He\"\u0004\b\u0000\u0010e2\f\u0010c\u001a\b\u0012\u0004\u0012\u0002He0fH\u0016\u00a2\u0006\u0002\u0010gJ\b\u0010h\u001a\u000209H\u0017J+\u0010i\u001a\u0004\u0018\u0001HP\"\u0004\b\u0000\u0010P2\f\u0010j\u001a\b\u0012\u0004\u0012\u0002HP0\t2\u0006\u0010'\u001a\u00020\u0013H\u0002\u00a2\u0006\u0002\u0010kR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R2\u0010\u0007\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\n0\b8\u0004@\u0004X\u0085\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001f\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\b8G\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00048@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\f\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b\u001e\u0010\u001dR \u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0004@\u0004X\u0085\u000e\u00a2\u0006\b\n\u0000\u0012\u0004\b#\u0010\u0002R\u001a\u0010$\u001a\u0004\u0018\u00010%8\u0004@\u0004X\u0085\u000e\u00a2\u0006\b\n\u0000\u0012\u0004\b&\u0010\u0002R\u0014\u0010'\u001a\u00020\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010/\u001a\b\u0012\u0004\u0012\u000201008G\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u00020\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b5\u0010,R\u001e\u00106\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006s"}, d2={"Landroidx/room/RoomDatabase;", "", "()V", "allowMainThreadQueries", "", "autoCloser", "Landroidx/room/AutoCloser;", "autoMigrationSpecs", "", "Ljava/lang/Class;", "Landroidx/room/migration/AutoMigrationSpec;", "getAutoMigrationSpecs", "()Ljava/util/Map;", "setAutoMigrationSpecs", "(Ljava/util/Map;)V", "backingFieldMap", "", "getBackingFieldMap", "internalOpenHelper", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "internalQueryExecutor", "Ljava/util/concurrent/Executor;", "internalTransactionExecutor", "invalidationTracker", "Landroidx/room/InvalidationTracker;", "getInvalidationTracker", "()Landroidx/room/InvalidationTracker;", "isMainThread", "isMainThread$room_runtime_release", "()Z", "isOpen", "isOpen$annotations", "mCallbacks", "", "Landroidx/room/RoomDatabase$Callback;", "getMCallbacks$annotations", "mDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getMDatabase$annotations", "openHelper", "getOpenHelper", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "queryExecutor", "getQueryExecutor", "()Ljava/util/concurrent/Executor;", "readWriteLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "suspendingTransactionId", "Ljava/lang/ThreadLocal;", "", "getSuspendingTransactionId", "()Ljava/lang/ThreadLocal;", "transactionExecutor", "getTransactionExecutor", "typeConverters", "writeAheadLoggingEnabled", "assertNotMainThread", "", "assertNotSuspendingTransaction", "beginTransaction", "clearAllTables", "close", "compileStatement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "sql", "createInvalidationTracker", "createOpenHelper", "config", "Landroidx/room/DatabaseConfiguration;", "endTransaction", "getAutoMigrations", "Landroidx/room/migration/Migration;", "", "getCloseLock", "Ljava/util/concurrent/locks/Lock;", "getCloseLock$room_runtime_release", "getRequiredAutoMigrationSpecs", "", "getRequiredTypeConverters", "getTypeConverter", "T", "klass", "(Ljava/lang/Class;)Ljava/lang/Object;", "inTransaction", "init", "configuration", "internalBeginTransaction", "internalEndTransaction", "internalInitInvalidationTracker", "db", "query", "Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "signal", "Landroid/os/CancellationSignal;", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)Landroid/database/Cursor;", "runInTransaction", "body", "Ljava/lang/Runnable;", "V", "Ljava/util/concurrent/Callable;", "(Ljava/util/concurrent/Callable;)Ljava/lang/Object;", "setTransactionSuccessful", "unwrapOpenHelper", "clazz", "(Ljava/lang/Class;Landroidx/sqlite/db/SupportSQLiteOpenHelper;)Ljava/lang/Object;", "Builder", "Callback", "Companion", "JournalMode", "MigrationContainer", "PrepackagedDatabaseCallback", "QueryCallback", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
public abstract class RoomDatabase {
    public static final Companion Companion = new Companion(null);
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean allowMainThreadQueries;
    private AutoCloser autoCloser;
    private Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs;
    private final Map<String, Object> backingFieldMap;
    private SupportSQLiteOpenHelper internalOpenHelper;
    private Executor internalQueryExecutor;
    private Executor internalTransactionExecutor;
    private final InvalidationTracker invalidationTracker = this.createInvalidationTracker();
    protected List<? extends Callback> mCallbacks;
    protected volatile SupportSQLiteDatabase mDatabase;
    private final ReentrantReadWriteLock readWriteLock;
    private final ThreadLocal<Integer> suspendingTransactionId;
    private final Map<Class<?>, Object> typeConverters;
    private boolean writeAheadLoggingEnabled;

    public RoomDatabase() {
        this.autoMigrationSpecs = new LinkedHashMap();
        this.readWriteLock = new ReentrantReadWriteLock();
        this.suspendingTransactionId = new ThreadLocal();
        Map map2 = Collections.synchronizedMap(new LinkedHashMap());
        Intrinsics.checkNotNullExpressionValue(map2, (String)"synchronizedMap(mutableMapOf())");
        this.backingFieldMap = map2;
        this.typeConverters = new LinkedHashMap();
    }

    public static final /* synthetic */ void access$internalBeginTransaction(RoomDatabase roomDatabase) {
        roomDatabase.internalBeginTransaction();
    }

    public static final /* synthetic */ void access$internalEndTransaction(RoomDatabase roomDatabase) {
        roomDatabase.internalEndTransaction();
    }

    @Deprecated(message="Will be hidden in a future release.")
    protected static /* synthetic */ void getMCallbacks$annotations() {
    }

    @Deprecated(message="Will be hidden in the next release.")
    protected static /* synthetic */ void getMDatabase$annotations() {
    }

    private final void internalBeginTransaction() {
        this.assertNotMainThread();
        SupportSQLiteDatabase supportSQLiteDatabase = this.getOpenHelper().getWritableDatabase();
        this.getInvalidationTracker().syncTriggers$room_runtime_release(supportSQLiteDatabase);
        if (supportSQLiteDatabase.isWriteAheadLoggingEnabled()) {
            supportSQLiteDatabase.beginTransactionNonExclusive();
        } else {
            supportSQLiteDatabase.beginTransaction();
        }
    }

    private final void internalEndTransaction() {
        this.getOpenHelper().getWritableDatabase().endTransaction();
        if (!this.inTransaction()) {
            this.getInvalidationTracker().refreshVersionsAsync();
        }
    }

    public static /* synthetic */ void isOpen$annotations() {
    }

    public static /* synthetic */ Cursor query$default(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal, int n, Object object) {
        if (object == null) {
            if ((n & 2) != 0) {
                cancellationSignal = null;
            }
            return roomDatabase.query(supportSQLiteQuery, cancellationSignal);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: query");
    }

    private final <T> T unwrapOpenHelper(Class<T> clazz, SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        if (clazz.isInstance(supportSQLiteOpenHelper)) {
            return (T)supportSQLiteOpenHelper;
        }
        clazz = supportSQLiteOpenHelper instanceof DelegatingOpenHelper ? this.unwrapOpenHelper(clazz, ((DelegatingOpenHelper)((Object)supportSQLiteOpenHelper)).getDelegate()) : null;
        return (T)clazz;
    }

    public void assertNotMainThread() {
        if (this.allowMainThreadQueries) {
            return;
        }
        if (this.isMainThread$room_runtime_release() ^ true) {
            return;
        }
        throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.".toString());
    }

    public void assertNotSuspendingTransaction() {
        boolean bl = this.inTransaction() || this.suspendingTransactionId.get() == null;
        if (bl) {
            return;
        }
        throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.".toString());
    }

    @Deprecated(message="beginTransaction() is deprecated", replaceWith=@ReplaceWith(expression="runInTransaction(Runnable)", imports={}))
    public void beginTransaction() {
        this.assertNotMainThread();
        AutoCloser autoCloser = this.autoCloser;
        if (autoCloser == null) {
            this.internalBeginTransaction();
        } else {
            autoCloser.executeRefCountingFunction((Function1)new Function1<SupportSQLiteDatabase, Object>(this){
                final RoomDatabase this$0;
                {
                    this.this$0 = roomDatabase;
                    super(1);
                }

                public final Object invoke(SupportSQLiteDatabase supportSQLiteDatabase) {
                    Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"it");
                    RoomDatabase.access$internalBeginTransaction(this.this$0);
                    return null;
                }
            });
        }
    }

    public abstract void clearAllTables();

    public void close() {
        if (this.isOpen()) {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            Intrinsics.checkNotNullExpressionValue((Object)writeLock, (String)"readWriteLock.writeLock()");
            Lock lock = writeLock;
            lock.lock();
            try {
                this.getInvalidationTracker().stopMultiInstanceInvalidation$room_runtime_release();
                this.getOpenHelper().close();
            }
            finally {
                lock.unlock();
            }
        }
    }

    public SupportSQLiteStatement compileStatement(String string2) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"sql");
        this.assertNotMainThread();
        this.assertNotSuspendingTransaction();
        return this.getOpenHelper().getWritableDatabase().compileStatement(string2);
    }

    protected abstract InvalidationTracker createInvalidationTracker();

    protected abstract SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration var1);

    @Deprecated(message="endTransaction() is deprecated", replaceWith=@ReplaceWith(expression="runInTransaction(Runnable)", imports={}))
    public void endTransaction() {
        AutoCloser autoCloser = this.autoCloser;
        if (autoCloser == null) {
            this.internalEndTransaction();
        } else {
            autoCloser.executeRefCountingFunction((Function1)new Function1<SupportSQLiteDatabase, Object>(this){
                final RoomDatabase this$0;
                {
                    this.this$0 = roomDatabase;
                    super(1);
                }

                public final Object invoke(SupportSQLiteDatabase supportSQLiteDatabase) {
                    Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"it");
                    RoomDatabase.access$internalEndTransaction(this.this$0);
                    return null;
                }
            });
        }
    }

    protected final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> getAutoMigrationSpecs() {
        return this.autoMigrationSpecs;
    }

    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map2) {
        Intrinsics.checkNotNullParameter(map2, (String)"autoMigrationSpecs");
        return CollectionsKt.emptyList();
    }

    public final Map<String, Object> getBackingFieldMap() {
        return this.backingFieldMap;
    }

    public final Lock getCloseLock$room_runtime_release() {
        ReentrantReadWriteLock.ReadLock readLock = this.readWriteLock.readLock();
        Intrinsics.checkNotNullExpressionValue((Object)readLock, (String)"readWriteLock.readLock()");
        return readLock;
    }

    public InvalidationTracker getInvalidationTracker() {
        return this.invalidationTracker;
    }

    public SupportSQLiteOpenHelper getOpenHelper() {
        SupportSQLiteOpenHelper supportSQLiteOpenHelper;
        SupportSQLiteOpenHelper supportSQLiteOpenHelper2 = supportSQLiteOpenHelper = this.internalOpenHelper;
        if (supportSQLiteOpenHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"internalOpenHelper");
            supportSQLiteOpenHelper2 = null;
        }
        return supportSQLiteOpenHelper2;
    }

    public Executor getQueryExecutor() {
        Executor executor;
        Executor executor2 = executor = this.internalQueryExecutor;
        if (executor == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"internalQueryExecutor");
            executor2 = null;
        }
        return executor2;
    }

    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return SetsKt.emptySet();
    }

    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        return MapsKt.emptyMap();
    }

    public final ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.suspendingTransactionId;
    }

    public Executor getTransactionExecutor() {
        Executor executor;
        Executor executor2 = executor = this.internalTransactionExecutor;
        if (executor == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"internalTransactionExecutor");
            executor2 = null;
        }
        return executor2;
    }

    public <T> T getTypeConverter(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, (String)"klass");
        return (T)this.typeConverters.get(clazz);
    }

    public boolean inTransaction() {
        return this.getOpenHelper().getWritableDatabase().inTransaction();
    }

    /*
     * WARNING - void declaration
     */
    public void init(DatabaseConfiguration object) {
        block29: {
            AutoClosingRoomOpenHelper autoClosingRoomOpenHelper;
            int n;
            Collection<Object> collection;
            int n2;
            boolean bl;
            Collection<Object> set;
            block28: {
                BitSet bitSet;
                block22: {
                    Intrinsics.checkNotNullParameter((Object)object, (String)"configuration");
                    this.internalOpenHelper = this.createOpenHelper((DatabaseConfiguration)object);
                    set = this.getRequiredAutoMigrationSpecs();
                    bitSet = new BitSet();
                    Iterator<Class<? extends AutoMigrationSpec>> object32 = set.iterator();
                    while (true) {
                        block23: {
                            bl = object32.hasNext();
                            n2 = 1;
                            if (!bl) break block22;
                            collection = object32.next();
                            int n3 = -1;
                            int n4 = ((DatabaseConfiguration)object).autoMigrationSpecs.size() - 1;
                            n = n3;
                            if (n4 >= 0) {
                                n = n4;
                                do {
                                    n4 = n - 1;
                                    if (((Class)((Object)collection)).isAssignableFrom(((DatabaseConfiguration)object).autoMigrationSpecs.get(n).getClass())) {
                                        bitSet.set(n);
                                        break block23;
                                    }
                                    n = n4;
                                } while (n4 >= 0);
                                n = n3;
                            }
                        }
                        if (n < 0) {
                            n2 = 0;
                        }
                        if (n2 == 0) break;
                        this.autoMigrationSpecs.put((Class<? extends AutoMigrationSpec>)((Object)collection), ((DatabaseConfiguration)object).autoMigrationSpecs.get(n));
                    }
                    throw new IllegalArgumentException(("A required auto migration spec (" + ((Class)((Object)collection)).getCanonicalName() + ") is missing in the database configuration.").toString());
                }
                n = ((DatabaseConfiguration)object).autoMigrationSpecs.size() - 1;
                if (n >= 0) {
                    block24: {
                        do {
                            n2 = n - 1;
                            if (!bitSet.get(n)) break block24;
                            n = n2;
                        } while (n2 >= 0);
                        break block28;
                    }
                    throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.".toString());
                }
            }
            collection = this.getAutoMigrations(this.autoMigrationSpecs);
            for (Migration migration : collection) {
                if (((DatabaseConfiguration)object).migrationContainer.contains(migration.startVersion, migration.endVersion)) continue;
                ((DatabaseConfiguration)object).migrationContainer.addMigrations(migration);
            }
            SQLiteCopyOpenHelper sQLiteCopyOpenHelper = this.unwrapOpenHelper(SQLiteCopyOpenHelper.class, this.getOpenHelper());
            if (sQLiteCopyOpenHelper != null) {
                sQLiteCopyOpenHelper.setDatabaseConfiguration((DatabaseConfiguration)object);
            }
            if ((autoClosingRoomOpenHelper = this.unwrapOpenHelper(AutoClosingRoomOpenHelper.class, this.getOpenHelper())) != null) {
                this.autoCloser = autoClosingRoomOpenHelper.autoCloser;
                this.getInvalidationTracker().setAutoCloser$room_runtime_release(autoClosingRoomOpenHelper.autoCloser);
            }
            bl = ((DatabaseConfiguration)object).journalMode == JournalMode.WRITE_AHEAD_LOGGING;
            this.getOpenHelper().setWriteAheadLoggingEnabled(bl);
            this.mCallbacks = ((DatabaseConfiguration)object).callbacks;
            this.internalQueryExecutor = ((DatabaseConfiguration)object).queryExecutor;
            this.internalTransactionExecutor = new TransactionExecutor(((DatabaseConfiguration)object).transactionExecutor);
            this.allowMainThreadQueries = ((DatabaseConfiguration)object).allowMainThreadQueries;
            this.writeAheadLoggingEnabled = bl;
            if (((DatabaseConfiguration)object).multiInstanceInvalidationServiceIntent != null) {
                if (((DatabaseConfiguration)object).name != null) {
                    this.getInvalidationTracker().startMultiInstanceInvalidation$room_runtime_release(((DatabaseConfiguration)object).context, ((DatabaseConfiguration)object).name, ((DatabaseConfiguration)object).multiInstanceInvalidationServiceIntent);
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            Map<Class<?>, List<Class<?>>> map2 = this.getRequiredTypeConverters();
            BitSet bitSet = new BitSet();
            for (Map.Entry<Class<?>, List<Class<?>>> entry : map2.entrySet()) {
                Class<?> clazz = entry.getKey();
                for (Class<?> clazz2 : entry.getValue()) {
                    block25: {
                        block26: {
                            n = ((DatabaseConfiguration)object).typeConverters.size() - 1;
                            if (n >= 0) {
                                Set<Class<? extends AutoMigrationSpec>> set2 = collection;
                                collection = set;
                                while (true) {
                                    void var10_14;
                                    n2 = n - 1;
                                    set = ((DatabaseConfiguration)object).typeConverters;
                                    Object e = set.get(n);
                                    set = var10_14;
                                    if (clazz2.isAssignableFrom(e.getClass())) {
                                        bitSet.set(n);
                                        break block25;
                                    }
                                    if (n2 >= 0) {
                                        Collection<Object> collection2 = set;
                                        n = n2;
                                        continue;
                                    }
                                    break block26;
                                    break;
                                }
                            }
                            Set<Class<? extends AutoMigrationSpec>> set3 = collection;
                            collection = set;
                            set = set3;
                        }
                        n = -1;
                    }
                    n2 = n >= 0 ? 1 : 0;
                    if (n2 != 0) {
                        this.typeConverters.put(clazz2, ((DatabaseConfiguration)object).typeConverters.get(n));
                        Collection<Object> collection3 = set;
                        set = collection;
                        collection = collection3;
                        continue;
                    }
                    object = new StringBuilder().append("A required type converter (").append(clazz2).append(") for ").append(clazz.getCanonicalName());
                    throw new IllegalArgumentException(((StringBuilder)object).append(" is missing in the database configuration.").toString().toString());
                }
            }
            n = ((DatabaseConfiguration)object).typeConverters.size() - 1;
            if (n >= 0) {
                block27: {
                    do {
                        n2 = n - 1;
                        if (!bitSet.get(n)) break block27;
                        n = n2;
                    } while (n2 >= 0);
                    break block29;
                }
                object = ((DatabaseConfiguration)object).typeConverters.get(n);
                throw new IllegalArgumentException("Unexpected type converter " + object + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
            }
        }
    }

    protected void internalInitInvalidationTracker(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
        this.getInvalidationTracker().internalInit$room_runtime_release(supportSQLiteDatabase);
    }

    public final boolean isMainThread$room_runtime_release() {
        boolean bl = Looper.getMainLooper().getThread() == Thread.currentThread();
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean isOpen() {
        boolean bl;
        Object object = this.autoCloser;
        if (object != null) {
            bl = ((AutoCloser)object).isActive();
        } else {
            object = this.mDatabase;
            if (object == null) {
                object = null;
                return Intrinsics.areEqual((Object)object, (Object)true);
            }
            bl = object.isOpen();
        }
        object = bl;
        return Intrinsics.areEqual((Object)object, (Object)true);
    }

    public final Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        Intrinsics.checkNotNullParameter((Object)supportSQLiteQuery, (String)"query");
        return RoomDatabase.query$default(this, supportSQLiteQuery, null, 2, null);
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter((Object)supportSQLiteQuery, (String)"query");
        this.assertNotMainThread();
        this.assertNotSuspendingTransaction();
        supportSQLiteQuery = cancellationSignal != null ? this.getOpenHelper().getWritableDatabase().query(supportSQLiteQuery, cancellationSignal) : this.getOpenHelper().getWritableDatabase().query(supportSQLiteQuery);
        return supportSQLiteQuery;
    }

    public Cursor query(String string2, Object[] objectArray) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"query");
        return this.getOpenHelper().getWritableDatabase().query(new SimpleSQLiteQuery(string2, objectArray));
    }

    public <V> V runInTransaction(Callable<V> callable) {
        Intrinsics.checkNotNullParameter(callable, (String)"body");
        this.beginTransaction();
        try {
            callable = callable.call();
            this.setTransactionSuccessful();
            return (V)callable;
        }
        finally {
            this.endTransaction();
        }
    }

    public void runInTransaction(Runnable runnable2) {
        Intrinsics.checkNotNullParameter((Object)runnable2, (String)"body");
        this.beginTransaction();
        try {
            runnable2.run();
            this.setTransactionSuccessful();
            return;
        }
        finally {
            this.endTransaction();
        }
    }

    protected final void setAutoMigrationSpecs(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map2) {
        Intrinsics.checkNotNullParameter(map2, (String)"<set-?>");
        this.autoMigrationSpecs = map2;
    }

    @Deprecated(message="setTransactionSuccessful() is deprecated", replaceWith=@ReplaceWith(expression="runInTransaction(Runnable)", imports={}))
    public void setTransactionSuccessful() {
        this.getOpenHelper().getWritableDatabase().setTransactionSuccessful();
    }

    @Metadata(d1={"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0015\n\u0002\b\u000b\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B'\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\u0016\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00104\u001a\u00020\u0014H\u0016J\u0016\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00106\u001a\u00020\u0016H\u0016J'\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u00108\u001a\n\u0012\u0006\b\u0001\u0012\u00020:09\"\u00020:H\u0016\u00a2\u0006\u0002\u0010;J\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010=\u001a\u00020\u0003H\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\r\u0010>\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010?J\u0016\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010A\u001a\u00020\tH\u0016J\u001e\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010A\u001a\u00020\t2\u0006\u00106\u001a\u00020*H\u0017J\u0016\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010C\u001a\u00020\u0019H\u0016J\u001e\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010C\u001a\u00020\u00192\u0006\u00106\u001a\u00020*H\u0017J\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0017J$\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u00106\u001a\u00020*H\u0017J\u000e\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u000e\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\u0010I\u001a\u00020J\"\u00020%H\u0016J\u000e\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u0018\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J \u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0001\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J\u0016\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0016\u0010O\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010P\u001a\u00020(H\u0017J\u001e\u0010Q\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010R\u001a\u00020.H\u0016J\u0016\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010R\u001a\u00020.H\u0016J\u0016\u0010T\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010R\u001a\u00020.H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006U"}, d2={"Landroidx/room/RoomDatabase$Builder;", "T", "Landroidx/room/RoomDatabase;", "", "context", "Landroid/content/Context;", "klass", "Ljava/lang/Class;", "name", "", "(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;)V", "allowDestructiveMigrationOnDowngrade", "", "allowMainThreadQueries", "autoCloseTimeUnit", "Ljava/util/concurrent/TimeUnit;", "autoCloseTimeout", "", "autoMigrationSpecs", "", "Landroidx/room/migration/AutoMigrationSpec;", "callbacks", "Landroidx/room/RoomDatabase$Callback;", "copyFromAssetPath", "copyFromFile", "Ljava/io/File;", "copyFromInputStream", "Ljava/util/concurrent/Callable;", "Ljava/io/InputStream;", "factory", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;", "journalMode", "Landroidx/room/RoomDatabase$JournalMode;", "migrationContainer", "Landroidx/room/RoomDatabase$MigrationContainer;", "migrationStartAndEndVersions", "", "", "migrationsNotRequiredFrom", "multiInstanceInvalidationIntent", "Landroid/content/Intent;", "prepackagedDatabaseCallback", "Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;", "queryCallback", "Landroidx/room/RoomDatabase$QueryCallback;", "queryCallbackExecutor", "Ljava/util/concurrent/Executor;", "queryExecutor", "requireMigration", "transactionExecutor", "typeConverters", "addAutoMigrationSpec", "autoMigrationSpec", "addCallback", "callback", "addMigrations", "migrations", "", "Landroidx/room/migration/Migration;", "([Landroidx/room/migration/Migration;)Landroidx/room/RoomDatabase$Builder;", "addTypeConverter", "typeConverter", "build", "()Landroidx/room/RoomDatabase;", "createFromAsset", "databaseFilePath", "createFromFile", "databaseFile", "createFromInputStream", "inputStreamCallable", "enableMultiInstanceInvalidation", "fallbackToDestructiveMigration", "fallbackToDestructiveMigrationFrom", "startVersions", "", "fallbackToDestructiveMigrationOnDowngrade", "openHelperFactory", "setAutoCloseTimeout", "setJournalMode", "setMultiInstanceInvalidationServiceIntent", "invalidationServiceIntent", "setQueryCallback", "executor", "setQueryExecutor", "setTransactionExecutor", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static class Builder<T extends RoomDatabase> {
        private boolean allowDestructiveMigrationOnDowngrade;
        private boolean allowMainThreadQueries;
        private TimeUnit autoCloseTimeUnit;
        private long autoCloseTimeout;
        private List<AutoMigrationSpec> autoMigrationSpecs;
        private final List<Callback> callbacks;
        private final Context context;
        private String copyFromAssetPath;
        private File copyFromFile;
        private Callable<InputStream> copyFromInputStream;
        private SupportSQLiteOpenHelper.Factory factory;
        private JournalMode journalMode;
        private final Class<T> klass;
        private final MigrationContainer migrationContainer;
        private Set<Integer> migrationStartAndEndVersions;
        private Set<Integer> migrationsNotRequiredFrom;
        private Intent multiInstanceInvalidationIntent;
        private final String name;
        private PrepackagedDatabaseCallback prepackagedDatabaseCallback;
        private QueryCallback queryCallback;
        private Executor queryCallbackExecutor;
        private Executor queryExecutor;
        private boolean requireMigration;
        private Executor transactionExecutor;
        private final List<Object> typeConverters;

        public Builder(Context context, Class<T> clazz, String string2) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter(clazz, (String)"klass");
            this.context = context;
            this.klass = clazz;
            this.name = string2;
            this.callbacks = new ArrayList();
            this.typeConverters = new ArrayList();
            this.autoMigrationSpecs = new ArrayList();
            this.journalMode = JournalMode.AUTOMATIC;
            this.requireMigration = true;
            this.autoCloseTimeout = -1L;
            this.migrationContainer = new MigrationContainer();
            this.migrationsNotRequiredFrom = new LinkedHashSet();
        }

        public Builder<T> addAutoMigrationSpec(AutoMigrationSpec autoMigrationSpec) {
            Intrinsics.checkNotNullParameter((Object)autoMigrationSpec, (String)"autoMigrationSpec");
            this.autoMigrationSpecs.add(autoMigrationSpec);
            return this;
        }

        public Builder<T> addCallback(Callback callback2) {
            Intrinsics.checkNotNullParameter((Object)callback2, (String)"callback");
            this.callbacks.add(callback2);
            return this;
        }

        public Builder<T> addMigrations(Migration ... migrationArray) {
            Intrinsics.checkNotNullParameter((Object)migrationArray, (String)"migrations");
            Builder builder = this;
            if (builder.migrationStartAndEndVersions == null) {
                builder.migrationStartAndEndVersions = new HashSet();
            }
            int n = migrationArray.length;
            for (int i = 0; i < n; ++i) {
                Migration migration = migrationArray[i];
                Set<Integer> set = builder.migrationStartAndEndVersions;
                Intrinsics.checkNotNull(set);
                set.add(migration.startVersion);
                set = builder.migrationStartAndEndVersions;
                Intrinsics.checkNotNull(set);
                set.add(migration.endVersion);
            }
            builder.migrationContainer.addMigrations(Arrays.copyOf(migrationArray, migrationArray.length));
            return this;
        }

        public Builder<T> addTypeConverter(Object object) {
            Intrinsics.checkNotNullParameter((Object)object, (String)"typeConverter");
            this.typeConverters.add(object);
            return this;
        }

        public Builder<T> allowMainThreadQueries() {
            this.allowMainThreadQueries = true;
            return this;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public T build() {
            Object object;
            Object object2;
            int n;
            if (this.queryExecutor == null && this.transactionExecutor == null) {
                this.queryExecutor = this.transactionExecutor = ArchTaskExecutor.getIOThreadExecutor();
            } else if (this.queryExecutor != null && this.transactionExecutor == null) {
                this.transactionExecutor = this.queryExecutor;
            } else if (this.queryExecutor == null) {
                this.queryExecutor = this.transactionExecutor;
            }
            Object object3 = this.migrationStartAndEndVersions;
            int n2 = 1;
            if (object3 != null) {
                object3 = this.migrationStartAndEndVersions;
                Intrinsics.checkNotNull(object3);
                object3 = object3.iterator();
                while (object3.hasNext()) {
                    n = ((Number)object3.next()).intValue();
                    if (this.migrationsNotRequiredFrom.contains(n) ^ true) continue;
                    object3 = new StringBuilder().append("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: ");
                    throw new IllegalArgumentException(((StringBuilder)object3).append(n).toString().toString());
                }
            }
            if ((object3 = this.factory == null ? (SupportSQLiteOpenHelper.Factory)new FrameworkSQLiteOpenHelperFactory() : this.factory) != null) {
                if (this.autoCloseTimeout > 0L) {
                    if (this.name == null) throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.".toString());
                    long l = this.autoCloseTimeout;
                    TimeUnit timeUnit = this.autoCloseTimeUnit;
                    if (timeUnit == null) throw new IllegalArgumentException("Required value was null.".toString());
                    object2 = this.queryExecutor;
                    if (object2 == null) throw new IllegalArgumentException("Required value was null.".toString());
                    object3 = new AutoClosingRoomOpenHelperFactory((SupportSQLiteOpenHelper.Factory)object3, new AutoCloser(l, timeUnit, (Executor)object2));
                }
                if (this.copyFromAssetPath != null || this.copyFromFile != null || this.copyFromInputStream != null) {
                    int n3;
                    if (this.name == null) throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.".toString());
                    n = this.copyFromAssetPath == null ? 0 : 1;
                    int n4 = this.copyFromFile == null ? 0 : 1;
                    if ((n = n + n4 + (n3 = this.copyFromInputStream == null ? 0 : 1) == 1 ? n2 : 0) == 0) throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.".toString());
                    String string2 = this.copyFromAssetPath;
                    object2 = this.copyFromFile;
                    object = this.copyFromInputStream;
                    object3 = new SQLiteCopyOpenHelperFactory(string2, (File)object2, (Callable<InputStream>)object, (SupportSQLiteOpenHelper.Factory)object3);
                }
            } else {
                object3 = null;
            }
            if (object3 == null) throw new IllegalArgumentException("Required value was null.".toString());
            if (this.queryCallback != null) {
                Executor executor = this.queryCallbackExecutor;
                if (executor == null) throw new IllegalArgumentException("Required value was null.".toString());
                object2 = this.queryCallback;
                if (object2 == null) throw new IllegalArgumentException("Required value was null.".toString());
                object3 = new QueryInterceptorOpenHelperFactory((SupportSQLiteOpenHelper.Factory)object3, executor, (QueryCallback)object2);
            }
            Context context = this.context;
            object2 = this.name;
            MigrationContainer migrationContainer = this.migrationContainer;
            List<Callback> list = this.callbacks;
            boolean bl = this.allowMainThreadQueries;
            JournalMode journalMode = this.journalMode.resolve$room_runtime_release(this.context);
            object = this.queryExecutor;
            if (object == null) throw new IllegalArgumentException("Required value was null.".toString());
            Executor executor = this.transactionExecutor;
            if (executor == null) throw new IllegalArgumentException("Required value was null.".toString());
            object3 = new DatabaseConfiguration(context, (String)object2, (SupportSQLiteOpenHelper.Factory)object3, migrationContainer, list, bl, journalMode, (Executor)object, executor, this.multiInstanceInvalidationIntent, this.requireMigration, this.allowDestructiveMigrationOnDowngrade, this.migrationsNotRequiredFrom, this.copyFromAssetPath, this.copyFromFile, this.copyFromInputStream, this.prepackagedDatabaseCallback, this.typeConverters, this.autoMigrationSpecs);
            RoomDatabase roomDatabase = (RoomDatabase)Room.getGeneratedImplementation(this.klass, "_Impl");
            roomDatabase.init((DatabaseConfiguration)object3);
            return (T)roomDatabase;
        }

        public Builder<T> createFromAsset(String string2) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"databaseFilePath");
            this.copyFromAssetPath = string2;
            return this;
        }

        public Builder<T> createFromAsset(String string2, PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"databaseFilePath");
            Intrinsics.checkNotNullParameter((Object)prepackagedDatabaseCallback, (String)"callback");
            Builder builder = this;
            builder.prepackagedDatabaseCallback = prepackagedDatabaseCallback;
            builder.copyFromAssetPath = string2;
            return this;
        }

        public Builder<T> createFromFile(File file) {
            Intrinsics.checkNotNullParameter((Object)file, (String)"databaseFile");
            this.copyFromFile = file;
            return this;
        }

        public Builder<T> createFromFile(File file, PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
            Intrinsics.checkNotNullParameter((Object)file, (String)"databaseFile");
            Intrinsics.checkNotNullParameter((Object)prepackagedDatabaseCallback, (String)"callback");
            Builder builder = this;
            builder.prepackagedDatabaseCallback = prepackagedDatabaseCallback;
            builder.copyFromFile = file;
            return this;
        }

        public Builder<T> createFromInputStream(Callable<InputStream> callable) {
            Intrinsics.checkNotNullParameter(callable, (String)"inputStreamCallable");
            this.copyFromInputStream = callable;
            return this;
        }

        public Builder<T> createFromInputStream(Callable<InputStream> callable, PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
            Intrinsics.checkNotNullParameter(callable, (String)"inputStreamCallable");
            Intrinsics.checkNotNullParameter((Object)prepackagedDatabaseCallback, (String)"callback");
            Builder builder = this;
            builder.prepackagedDatabaseCallback = prepackagedDatabaseCallback;
            builder.copyFromInputStream = callable;
            return this;
        }

        public Builder<T> enableMultiInstanceInvalidation() {
            Intent intent;
            Builder builder = this;
            if (builder.name != null) {
                intent = new Intent(builder.context, MultiInstanceInvalidationService.class);
            } else {
                intent = null;
                Intent intent2 = null;
            }
            builder.multiInstanceInvalidationIntent = intent;
            return this;
        }

        public Builder<T> fallbackToDestructiveMigration() {
            Builder builder = this;
            builder.requireMigration = false;
            builder.allowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        public Builder<T> fallbackToDestructiveMigrationFrom(int ... nArray) {
            Intrinsics.checkNotNullParameter((Object)nArray, (String)"startVersions");
            Builder builder = this;
            for (int n : nArray) {
                builder.migrationsNotRequiredFrom.add(n);
            }
            return this;
        }

        public Builder<T> fallbackToDestructiveMigrationOnDowngrade() {
            Builder builder = this;
            builder.requireMigration = true;
            builder.allowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        public Builder<T> openHelperFactory(SupportSQLiteOpenHelper.Factory factory2) {
            this.factory = factory2;
            return this;
        }

        @ExperimentalRoomApi
        public Builder<T> setAutoCloseTimeout(long l, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"autoCloseTimeUnit");
            Builder builder = this;
            boolean bl = l >= 0L;
            if (bl) {
                builder.autoCloseTimeout = l;
                builder.autoCloseTimeUnit = timeUnit;
                return this;
            }
            throw new IllegalArgumentException("autoCloseTimeout must be >= 0".toString());
        }

        public Builder<T> setJournalMode(JournalMode journalMode) {
            Intrinsics.checkNotNullParameter((Object)((Object)journalMode), (String)"journalMode");
            this.journalMode = journalMode;
            return this;
        }

        @ExperimentalRoomApi
        public Builder<T> setMultiInstanceInvalidationServiceIntent(Intent intent) {
            Intrinsics.checkNotNullParameter((Object)intent, (String)"invalidationServiceIntent");
            Builder builder = this;
            if (builder.name == null) {
                intent = null;
            }
            builder.multiInstanceInvalidationIntent = intent;
            return this;
        }

        public Builder<T> setQueryCallback(QueryCallback queryCallback, Executor executor) {
            Intrinsics.checkNotNullParameter((Object)queryCallback, (String)"queryCallback");
            Intrinsics.checkNotNullParameter((Object)executor, (String)"executor");
            Builder builder = this;
            builder.queryCallback = queryCallback;
            builder.queryCallbackExecutor = executor;
            return this;
        }

        public Builder<T> setQueryExecutor(Executor executor) {
            Intrinsics.checkNotNullParameter((Object)executor, (String)"executor");
            this.queryExecutor = executor;
            return this;
        }

        public Builder<T> setTransactionExecutor(Executor executor) {
            Intrinsics.checkNotNullParameter((Object)executor, (String)"executor");
            this.transactionExecutor = executor;
            return this;
        }
    }

    @Metadata(d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2={"Landroidx/room/RoomDatabase$Callback;", "", "()V", "onCreate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "onDestructiveMigration", "onOpen", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static abstract class Callback {
        public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
        }

        public void onDestructiveMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
        }

        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2={"Landroidx/room/RoomDatabase$Companion;", "", "()V", "MAX_BIND_PARAMETER_CNT", "", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tH\u0000\u00a2\u0006\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2={"Landroidx/room/RoomDatabase$JournalMode;", "", "(Ljava/lang/String;I)V", "isLowRamDevice", "", "activityManager", "Landroid/app/ActivityManager;", "resolve", "context", "Landroid/content/Context;", "resolve$room_runtime_release", "AUTOMATIC", "TRUNCATE", "WRITE_AHEAD_LOGGING", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static enum JournalMode {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;


        private final boolean isLowRamDevice(ActivityManager activityManager) {
            return SupportSQLiteCompat.Api19Impl.isLowRamDevice(activityManager);
        }

        public final JournalMode resolve$room_runtime_release(Context object) {
            Intrinsics.checkNotNullParameter((Object)object, (String)"context");
            if (this != AUTOMATIC) {
                return this;
            }
            object = object.getSystemService("activity");
            Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type android.app.ActivityManager");
            if (!this.isLowRamDevice((ActivityManager)object)) {
                return WRITE_AHEAD_LOGGING;
            }
            return TRUNCATE;
        }
    }

    @Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002J!\u0010\u000b\u001a\u00020\t2\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\f\"\u00020\u0007H\u0016\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000b\u001a\u00020\t2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J \u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J6\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00182\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J \u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u001b0\u001bH\u0016R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2={"Landroidx/room/RoomDatabase$MigrationContainer;", "", "()V", "migrations", "", "", "Ljava/util/TreeMap;", "Landroidx/room/migration/Migration;", "addMigration", "", "migration", "addMigrations", "", "([Landroidx/room/migration/Migration;)V", "", "contains", "", "startVersion", "endVersion", "findMigrationPath", "start", "end", "findUpMigrationPath", "result", "", "upgrade", "getMigrations", "", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static class MigrationContainer {
        private final Map<Integer, TreeMap<Integer, Migration>> migrations = new LinkedHashMap();

        private final void addMigration(Migration migration) {
            int n = migration.startVersion;
            int n2 = migration.endVersion;
            Map<Integer, TreeMap<Integer, Migration>> map2 = this.migrations;
            Integer n3 = n;
            TreeMap<Integer, Migration> treeMap = map2.get(n3);
            if (treeMap == null) {
                treeMap = new TreeMap();
                map2.put(n3, treeMap);
            }
            if (((Map)treeMap).containsKey(n2)) {
                Log.w((String)"ROOM", (String)("Overriding migration " + treeMap.get(n2) + " with " + migration));
            }
            ((Map)treeMap).put(n2, migration);
        }

        private final List<Migration> findUpMigrationPath(List<Migration> list, boolean bl, int n, int n2) {
            int n3 = n;
            while ((n = (bl ? n3 < n2 : n3 > n2) ? 1 : 0) != 0) {
                int n4;
                block5: {
                    TreeMap<Integer, Migration> treeMap = this.migrations.get(n3);
                    if (treeMap == null) {
                        return null;
                    }
                    Object object = bl ? (Set)treeMap.descendingKeySet() : treeMap.keySet();
                    int n5 = 0;
                    Iterator iterator2 = object.iterator();
                    do {
                        n4 = n3;
                        n = n5;
                        if (!iterator2.hasNext()) break block5;
                        object = (Integer)iterator2.next();
                        if (bl) {
                            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"targetVersion");
                            n = (Integer)object;
                            if (n3 + 1 <= n && n <= n2) {
                                n = 1;
                                continue;
                            }
                            n = 0;
                            continue;
                        }
                        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"targetVersion");
                        n = (Integer)object;
                        n = n2 <= n && n < n3 ? 1 : 0;
                    } while (n == 0);
                    treeMap = treeMap.get(object);
                    Intrinsics.checkNotNull((Object)treeMap);
                    list.add((Migration)((Object)treeMap));
                    n4 = (Integer)object;
                    n = 1;
                }
                n3 = n4;
                if (n != 0) continue;
                return null;
            }
            return list;
        }

        public void addMigrations(List<? extends Migration> object) {
            Intrinsics.checkNotNullParameter(object, (String)"migrations");
            object = ((Iterable)object).iterator();
            while (object.hasNext()) {
                this.addMigration((Migration)object.next());
            }
        }

        public void addMigrations(Migration ... migrationArray) {
            Intrinsics.checkNotNullParameter((Object)migrationArray, (String)"migrations");
            int n = migrationArray.length;
            for (int i = 0; i < n; ++i) {
                this.addMigration(migrationArray[i]);
            }
        }

        public final boolean contains(int n, int n2) {
            Map<Integer, Map<Integer, Migration>> map2 = this.getMigrations();
            if (map2.containsKey(n)) {
                Map<Integer, Migration> map3 = map2.get(n);
                map2 = map3;
                if (map3 == null) {
                    map2 = MapsKt.emptyMap();
                }
                return map2.containsKey(n2);
            }
            return false;
        }

        public List<Migration> findMigrationPath(int n, int n2) {
            if (n == n2) {
                return CollectionsKt.emptyList();
            }
            boolean bl = n2 > n;
            return this.findUpMigrationPath(new ArrayList(), bl, n, n2);
        }

        public Map<Integer, Map<Integer, Migration>> getMigrations() {
            return this.migrations;
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2={"Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;", "", "()V", "onOpenPrepackagedDatabase", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static abstract class PrepackagedDatabaseCallback {
        public void onOpenPrepackagedDatabase(SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
        }
    }

    @Metadata(d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H&\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\b\u00c0\u0006\u0001"}, d2={"Landroidx/room/RoomDatabase$QueryCallback;", "", "onQuery", "", "sqlQuery", "", "bindArgs", "", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static interface QueryCallback {
        public void onQuery(String var1, List<? extends Object> var2);
    }
}

