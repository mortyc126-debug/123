/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteException
 *  android.util.Log
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.collections.SetsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 */
package androidx.room;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.LiveData;
import androidx.room.AutoCloser;
import androidx.room.InvalidationLiveDataContainer;
import androidx.room.InvalidationTracker$$ExternalSyntheticLambda0;
import androidx.room.MultiInstanceInvalidationClient;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u0000 f2\u00020\u0001:\u0005fghijB#\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006\u00a2\u0006\u0002\u0010\u0007BV\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\t\u0012\u001d\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u000b\u00a2\u0006\u0002\b\f0\t\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006\u00a2\u0006\u0002\u0010\rJ\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\"H\u0017J\u0010\u0010;\u001a\u0002092\u0006\u0010:\u001a\u00020\"H\u0017J7\u0010<\u001a\b\u0012\u0004\u0012\u0002H>0=\"\u0004\b\u0000\u0010>2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\f\u0010?\u001a\b\u0012\u0004\u0012\u0002H>0@H\u0017\u00a2\u0006\u0002\u0010AJ?\u0010<\u001a\b\u0012\u0004\u0012\u0002H>0=\"\u0004\b\u0000\u0010>2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\u0006\u0010B\u001a\u00020\u00192\f\u0010?\u001a\b\u0012\u0004\u0012\u0002H>0@H\u0017\u00a2\u0006\u0002\u0010CJ\r\u0010D\u001a\u00020\u0019H\u0000\u00a2\u0006\u0002\bEJ\u0015\u0010F\u001a\u0002092\u0006\u0010\u0002\u001a\u00020GH\u0000\u00a2\u0006\u0002\bHJ!\u0010I\u001a\u0002092\u0012\u0010J\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\u0007\u00a2\u0006\u0002\u0010KJ\r\u0010L\u001a\u000209H\u0000\u00a2\u0006\u0002\bMJ\b\u0010N\u001a\u000209H\u0016J\b\u0010O\u001a\u000209H\u0017J\u0010\u0010P\u001a\u0002092\u0006\u0010:\u001a\u00020\"H\u0017J%\u0010Q\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\u000e\u0010R\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0002\u00a2\u0006\u0002\u0010SJ\u0015\u0010T\u001a\u0002092\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u00a2\u0006\u0002\bUJ%\u0010V\u001a\u0002092\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020[H\u0000\u00a2\u0006\u0002\b\\J\u0018\u0010]\u001a\u0002092\u0006\u0010^\u001a\u00020G2\u0006\u0010_\u001a\u000200H\u0002J\r\u0010`\u001a\u000209H\u0000\u00a2\u0006\u0002\baJ\u0018\u0010b\u001a\u0002092\u0006\u0010^\u001a\u00020G2\u0006\u0010_\u001a\u000200H\u0002J\r\u0010c\u001a\u000209H\u0000\u00a2\u0006\u0002\bdJ\u0015\u0010c\u001a\u0002092\u0006\u0010\u0002\u001a\u00020GH\u0000\u00a2\u0006\u0002\bdJ%\u0010e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0002\u00a2\u0006\u0002\u0010SR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!8\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020'8GX\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020+8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b,\u0010-R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002000\tX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u001e\u00103\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005X\u0080\u0004\u00a2\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u000e\u00107\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R%\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u000b\u00a2\u0006\u0002\b\f0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006k"}, d2={"Landroidx/room/InvalidationTracker;", "", "database", "Landroidx/room/RoomDatabase;", "tableNames", "", "", "(Landroidx/room/RoomDatabase;[Ljava/lang/String;)V", "shadowTablesMap", "", "viewTables", "", "Lkotlin/jvm/JvmSuppressWildcards;", "(Landroidx/room/RoomDatabase;Ljava/util/Map;Ljava/util/Map;[Ljava/lang/String;)V", "autoCloser", "Landroidx/room/AutoCloser;", "cleanupStatement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "getCleanupStatement$room_runtime_release", "()Landroidx/sqlite/db/SupportSQLiteStatement;", "setCleanupStatement$room_runtime_release", "(Landroidx/sqlite/db/SupportSQLiteStatement;)V", "getDatabase$room_runtime_release", "()Landroidx/room/RoomDatabase;", "initialized", "", "invalidationLiveDataContainer", "Landroidx/room/InvalidationLiveDataContainer;", "multiInstanceInvalidationClient", "Landroidx/room/MultiInstanceInvalidationClient;", "observedTableTracker", "Landroidx/room/InvalidationTracker$ObservedTableTracker;", "observerMap", "Landroidx/arch/core/internal/SafeIterableMap;", "Landroidx/room/InvalidationTracker$Observer;", "Landroidx/room/InvalidationTracker$ObserverWrapper;", "getObserverMap$room_runtime_release", "()Landroidx/arch/core/internal/SafeIterableMap;", "pendingRefresh", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getPendingRefresh", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "refreshRunnable", "Ljava/lang/Runnable;", "getRefreshRunnable$annotations", "()V", "syncTriggersLock", "tableIdLookup", "", "getTableIdLookup$room_runtime_release", "()Ljava/util/Map;", "tablesNames", "getTablesNames$room_runtime_release", "()[Ljava/lang/String;", "[Ljava/lang/String;", "trackerLock", "addObserver", "", "observer", "addWeakObserver", "createLiveData", "Landroidx/lifecycle/LiveData;", "T", "computeFunction", "Ljava/util/concurrent/Callable;", "([Ljava/lang/String;Ljava/util/concurrent/Callable;)Landroidx/lifecycle/LiveData;", "inTransaction", "([Ljava/lang/String;ZLjava/util/concurrent/Callable;)Landroidx/lifecycle/LiveData;", "ensureInitialization", "ensureInitialization$room_runtime_release", "internalInit", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "internalInit$room_runtime_release", "notifyObserversByTableNames", "tables", "([Ljava/lang/String;)V", "onAutoCloseCallback", "onAutoCloseCallback$room_runtime_release", "refreshVersionsAsync", "refreshVersionsSync", "removeObserver", "resolveViews", "names", "([Ljava/lang/String;)[Ljava/lang/String;", "setAutoCloser", "setAutoCloser$room_runtime_release", "startMultiInstanceInvalidation", "context", "Landroid/content/Context;", "name", "serviceIntent", "Landroid/content/Intent;", "startMultiInstanceInvalidation$room_runtime_release", "startTrackingTable", "db", "tableId", "stopMultiInstanceInvalidation", "stopMultiInstanceInvalidation$room_runtime_release", "stopTrackingTable", "syncTriggers", "syncTriggers$room_runtime_release", "validateAndResolveTableNames", "Companion", "ObservedTableTracker", "Observer", "ObserverWrapper", "WeakObserver", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
public class InvalidationTracker {
    private static final String CREATE_TRACKING_TABLE_SQL = "CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";
    public static final Companion Companion = new Companion(null);
    private static final String INVALIDATED_COLUMN_NAME = "invalidated";
    public static final String RESET_UPDATED_TABLES_SQL = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1";
    public static final String SELECT_UPDATED_TABLES_SQL = "SELECT * FROM room_table_modification_log WHERE invalidated = 1;";
    private static final String TABLE_ID_COLUMN_NAME = "table_id";
    private static final String[] TRIGGERS = new String[]{"UPDATE", "DELETE", "INSERT"};
    private static final String UPDATE_TABLE_NAME = "room_table_modification_log";
    private AutoCloser autoCloser;
    private volatile SupportSQLiteStatement cleanupStatement;
    private final RoomDatabase database;
    private volatile boolean initialized;
    private final InvalidationLiveDataContainer invalidationLiveDataContainer;
    private MultiInstanceInvalidationClient multiInstanceInvalidationClient;
    private final ObservedTableTracker observedTableTracker;
    private final SafeIterableMap<Observer, ObserverWrapper> observerMap;
    private final AtomicBoolean pendingRefresh;
    public final Runnable refreshRunnable;
    private final Map<String, String> shadowTablesMap;
    private final Object syncTriggersLock;
    private final Map<String, Integer> tableIdLookup;
    private final String[] tablesNames;
    private final Object trackerLock;
    private final Map<String, Set<String>> viewTables;

    public InvalidationTracker(RoomDatabase object, Map<String, String> object2, Map<String, Set<String>> object32, String ... object4) {
        String string2;
        Intrinsics.checkNotNullParameter((Object)object, (String)"database");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"shadowTablesMap");
        Intrinsics.checkNotNullParameter((Object)object32, (String)"viewTables");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"tableNames");
        this.database = object;
        this.shadowTablesMap = object2;
        this.viewTables = object32;
        this.pendingRefresh = new AtomicBoolean(false);
        this.observedTableTracker = new ObservedTableTracker(((void)string2).length);
        this.invalidationLiveDataContainer = new InvalidationLiveDataContainer(this.database);
        this.observerMap = new SafeIterableMap();
        this.syncTriggersLock = new Object();
        this.trackerLock = new Object();
        this.tableIdLookup = new LinkedHashMap();
        int n = ((void)string2).length;
        String[] stringArray = new String[n];
        for (int i = 0; i < n; ++i) {
            object = string2[i];
            object2 = Locale.US;
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"US");
            object2 = ((String)object).toLowerCase((Locale)object2);
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"this as java.lang.String).toLowerCase(locale)");
            this.tableIdLookup.put((String)object2, i);
            object = this.shadowTablesMap.get(string2[i]);
            if (object != null) {
                Locale locale = Locale.US;
                Intrinsics.checkNotNullExpressionValue((Object)locale, (String)"US");
                object = ((String)object).toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"this as java.lang.String).toLowerCase(locale)");
            } else {
                object = null;
            }
            if (object == null) {
                object = object2;
            }
            stringArray[i] = object;
        }
        this.tablesNames = stringArray;
        for (Map.Entry<String, String> entry : this.shadowTablesMap.entrySet()) {
            string2 = entry.getValue();
            object2 = Locale.US;
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"US");
            object2 = string2.toLowerCase((Locale)object2);
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"this as java.lang.String).toLowerCase(locale)");
            if (!this.tableIdLookup.containsKey(object2)) continue;
            string2 = entry.getKey();
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue((Object)locale, (String)"US");
            String string3 = string2.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"this as java.lang.String).toLowerCase(locale)");
            this.tableIdLookup.put(string3, (Integer)MapsKt.getValue(this.tableIdLookup, (Object)object2));
        }
        this.refreshRunnable = new Runnable(this){
            final InvalidationTracker this$0;
            {
                this.this$0 = invalidationTracker;
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            private final Set<Integer> checkUpdatedTable() {
                Object object = this.this$0;
                Set set = SetsKt.createSetBuilder();
                object = RoomDatabase.query$default(((InvalidationTracker)object).getDatabase$room_runtime_release(), new SimpleSQLiteQuery("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"), null, 2, null);
                object = (Closeable)object;
                try {
                    Cursor cursor = (Cursor)object;
                    while (cursor.moveToNext()) {
                        set.add(cursor.getInt(0));
                    }
                    cursor = Unit.INSTANCE;
                }
                catch (Throwable throwable) {
                    try {
                        throw throwable;
                    }
                    catch (Throwable throwable2) {
                        CloseableKt.closeFinally((Closeable)object, (Throwable)throwable);
                        throw throwable2;
                    }
                }
                CloseableKt.closeFinally((Closeable)object, null);
                set = SetsKt.build((Set)set);
                if (!(((Collection)set).isEmpty() ^ true)) return set;
                if (this.this$0.getCleanupStatement$room_runtime_release() == null) throw new IllegalStateException("Required value was null.".toString());
                object = this.this$0.getCleanupStatement$room_runtime_release();
                if (object == null) throw new IllegalArgumentException("Required value was null.".toString());
                object.executeUpdateDelete();
                return set;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void run() {
                Throwable throwable322222;
                Object object;
                block24: {
                    Object object2;
                    Object object3;
                    block25: {
                        block26: {
                            block23: {
                                boolean bl;
                                block22: {
                                    block21: {
                                        object = this.this$0.getDatabase$room_runtime_release().getCloseLock$room_runtime_release();
                                        object.lock();
                                        bl = this.this$0.ensureInitialization$room_runtime_release();
                                        if (bl) break block21;
                                        object.unlock();
                                        object = InvalidationTracker.access$getAutoCloser$p(this.this$0);
                                        if (object != null) {
                                            ((AutoCloser)object).decrementCountAndScheduleClose();
                                        }
                                        return;
                                    }
                                    bl = this.this$0.getPendingRefresh().compareAndSet(true, false);
                                    if (bl) break block22;
                                    object.unlock();
                                    object = InvalidationTracker.access$getAutoCloser$p(this.this$0);
                                    if (object != null) {
                                        ((AutoCloser)object).decrementCountAndScheduleClose();
                                    }
                                    return;
                                }
                                bl = this.this$0.getDatabase$room_runtime_release().inTransaction();
                                if (!bl) break block23;
                                object.unlock();
                                object = InvalidationTracker.access$getAutoCloser$p(this.this$0);
                                if (object != null) {
                                    ((AutoCloser)object).decrementCountAndScheduleClose();
                                }
                                return;
                            }
                            object3 = this.this$0.getDatabase$room_runtime_release().getOpenHelper().getWritableDatabase();
                            object3.beginTransactionNonExclusive();
                            object2 = this.checkUpdatedTable();
                            object3.setTransactionSuccessful();
                            object3.endTransaction();
                            object.unlock();
                            object3 = InvalidationTracker.access$getAutoCloser$p(this.this$0);
                            object = object2;
                            if (object3 == null) break block25;
                            object = object2;
                            break block26;
                            catch (Throwable throwable2) {
                                object3.endTransaction();
                                throw throwable2;
                                {
                                    catch (Throwable throwable322222) {
                                        break block24;
                                    }
                                    catch (SQLiteException sQLiteException) {
                                        Log.e((String)"ROOM", (String)"Cannot run invalidation tracker. Is the db closed?", (Throwable)sQLiteException);
                                        object2 = SetsKt.emptySet();
                                        object.unlock();
                                        object3 = InvalidationTracker.access$getAutoCloser$p(this.this$0);
                                        object = object2;
                                        if (object3 == null) break block25;
                                        object = object2;
                                        break block26;
                                    }
                                    catch (IllegalStateException illegalStateException) {}
                                    {
                                        Log.e((String)"ROOM", (String)"Cannot run invalidation tracker. Is the db closed?", (Throwable)illegalStateException);
                                        object3 = SetsKt.emptySet();
                                        object.unlock();
                                    }
                                    object2 = InvalidationTracker.access$getAutoCloser$p(this.this$0);
                                    object = object3;
                                    if (object2 == null) break block25;
                                    object = object3;
                                    object3 = object2;
                                }
                            }
                        }
                        ((AutoCloser)object3).decrementCountAndScheduleClose();
                    }
                    if (true ^ ((Collection)object).isEmpty()) {
                        object3 = this.this$0.getObserverMap$room_runtime_release();
                        object2 = this.this$0;
                        synchronized (object3) {
                            object2 = ((Iterable)((InvalidationTracker)object2).getObserverMap$room_runtime_release()).iterator();
                            while (object2.hasNext()) {
                                ((ObserverWrapper)((Map.Entry)object2.next()).getValue()).notifyByTableInvalidStatus$room_runtime_release((Set<Integer>)object);
                            }
                            object = Unit.INSTANCE;
                        }
                    }
                    return;
                }
                object.unlock();
                object = InvalidationTracker.access$getAutoCloser$p(this.this$0);
                if (object != null) {
                    ((AutoCloser)object).decrementCountAndScheduleClose();
                }
                throw throwable322222;
            }
        };
    }

    public InvalidationTracker(RoomDatabase roomDatabase, String ... stringArray) {
        Intrinsics.checkNotNullParameter((Object)roomDatabase, (String)"database");
        Intrinsics.checkNotNullParameter((Object)stringArray, (String)"tableNames");
        this(roomDatabase, MapsKt.emptyMap(), MapsKt.emptyMap(), Arrays.copyOf(stringArray, stringArray.length));
    }

    public static final /* synthetic */ AutoCloser access$getAutoCloser$p(InvalidationTracker invalidationTracker) {
        return invalidationTracker.autoCloser;
    }

    public static /* synthetic */ void getRefreshRunnable$annotations() {
    }

    private final String[] resolveViews(String[] object) {
        Set set = SetsKt.createSetBuilder();
        for (Object object2 : object) {
            Map<String, Set<String>> map2 = this.viewTables;
            Object object3 = Locale.US;
            Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"US");
            object3 = ((String)object2).toLowerCase((Locale)object3);
            Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"this as java.lang.String).toLowerCase(locale)");
            if (map2.containsKey(object3)) {
                map2 = this.viewTables;
                object3 = Locale.US;
                Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"US");
                object2 = ((String)object2).toLowerCase((Locale)object3);
                Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"this as java.lang.String).toLowerCase(locale)");
                object2 = map2.get(object2);
                Intrinsics.checkNotNull((Object)object2);
                set.addAll((Collection)object2);
                continue;
            }
            set.add(object2);
        }
        object = SetsKt.build((Set)set);
        object = object.toArray(new String[0]);
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[])object;
    }

    private final void startTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int n) {
        supportSQLiteDatabase.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + n + ", 0)");
        String string2 = this.tablesNames[n];
        for (String string3 : TRIGGERS) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            charSequence.append(Companion.getTriggerName$room_runtime_release(string2, string3));
            charSequence.append(" AFTER ");
            charSequence.append(string3);
            charSequence.append(" ON `");
            charSequence.append(string2);
            charSequence.append("` BEGIN UPDATE ");
            charSequence.append(UPDATE_TABLE_NAME);
            charSequence.append(" SET ").append(INVALIDATED_COLUMN_NAME);
            charSequence.append(" = 1");
            charSequence.append(" WHERE ").append(TABLE_ID_COLUMN_NAME);
            charSequence.append(" = ").append(n);
            charSequence.append(" AND ").append(INVALIDATED_COLUMN_NAME);
            charSequence.append(" = 0");
            charSequence.append("; END");
            charSequence = charSequence.toString();
            Intrinsics.checkNotNullExpressionValue((Object)charSequence, (String)"StringBuilder().apply(builderAction).toString()");
            supportSQLiteDatabase.execSQL((String)charSequence);
        }
    }

    private final void stopTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int n) {
        String string2 = this.tablesNames[n];
        for (String string3 : TRIGGERS) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("DROP TRIGGER IF EXISTS ");
            charSequence.append(Companion.getTriggerName$room_runtime_release(string2, string3));
            charSequence = charSequence.toString();
            Intrinsics.checkNotNullExpressionValue((Object)charSequence, (String)"StringBuilder().apply(builderAction).toString()");
            supportSQLiteDatabase.execSQL((String)charSequence);
        }
    }

    private final String[] validateAndResolveTableNames(String[] stringArray) {
        stringArray = this.resolveViews(stringArray);
        int n = stringArray.length;
        for (int i = 0; i < n; ++i) {
            String string2 = stringArray[i];
            Map<String, Integer> map2 = this.tableIdLookup;
            Object object = Locale.US;
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"US");
            object = string2.toLowerCase((Locale)object);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"this as java.lang.String).toLowerCase(locale)");
            if (map2.containsKey(object)) {
                continue;
            }
            throw new IllegalArgumentException(("There is no table with name " + string2).toString());
        }
        return stringArray;
    }

    public void addObserver(Observer object) {
        Object object2;
        Intrinsics.checkNotNullParameter((Object)object, (String)"observer");
        Object object3 = this.resolveViews(((Observer)object).getTables$room_runtime_release());
        Object object4 = new ArrayList(((String[])object3).length);
        int n = ((String[])object3).length;
        for (int i = 0; i < n; ++i) {
            object2 = object3[i];
            Object object5 = this.tableIdLookup;
            Object object6 = Locale.US;
            Intrinsics.checkNotNullExpressionValue((Object)object6, (String)"US");
            object6 = ((String)object2).toLowerCase((Locale)object6);
            Intrinsics.checkNotNullExpressionValue((Object)object6, (String)"this as java.lang.String).toLowerCase(locale)");
            object5 = object5.get(object6);
            if (object5 != null) {
                object4.add(((Integer)object5).intValue());
                continue;
            }
            throw new IllegalArgumentException("There is no table with name " + (String)object2);
        }
        object4 = (List)object4;
        object4 = CollectionsKt.toIntArray((Collection)object4);
        object2 = new ObserverWrapper((Observer)object, (int[])object4, (String[])object3);
        object3 = this.observerMap;
        synchronized (object3) {
            object = this.observerMap.putIfAbsent((Observer)object, (ObserverWrapper)object2);
            // MONITOREXIT @DISABLED, blocks:[0, 1] lbl25 : MonitorExitStatement: MONITOREXIT : var4_3 /* !! */ 
            if (object == null && this.observedTableTracker.onAdded(Arrays.copyOf((int[])object4, ((Object)object4).length))) {
                this.syncTriggers$room_runtime_release();
            }
            return;
        }
    }

    public void addWeakObserver(Observer observer2) {
        Intrinsics.checkNotNullParameter((Object)observer2, (String)"observer");
        this.addObserver(new WeakObserver(this, observer2));
    }

    @Deprecated(message="Use [createLiveData(String[], boolean, Callable)]")
    public <T> LiveData<T> createLiveData(String[] stringArray, Callable<T> callable) {
        Intrinsics.checkNotNullParameter((Object)stringArray, (String)"tableNames");
        Intrinsics.checkNotNullParameter(callable, (String)"computeFunction");
        return this.createLiveData(stringArray, false, callable);
    }

    public <T> LiveData<T> createLiveData(String[] stringArray, boolean bl, Callable<T> callable) {
        Intrinsics.checkNotNullParameter((Object)stringArray, (String)"tableNames");
        Intrinsics.checkNotNullParameter(callable, (String)"computeFunction");
        return this.invalidationLiveDataContainer.create(this.validateAndResolveTableNames(stringArray), bl, callable);
    }

    public final boolean ensureInitialization$room_runtime_release() {
        if (!this.database.isOpen()) {
            return false;
        }
        if (!this.initialized) {
            this.database.getOpenHelper().getWritableDatabase();
        }
        if (!this.initialized) {
            Log.e((String)"ROOM", (String)"database is not initialized even though it is open");
            return false;
        }
        return true;
    }

    public final SupportSQLiteStatement getCleanupStatement$room_runtime_release() {
        return this.cleanupStatement;
    }

    public final RoomDatabase getDatabase$room_runtime_release() {
        return this.database;
    }

    public final SafeIterableMap<Observer, ObserverWrapper> getObserverMap$room_runtime_release() {
        return this.observerMap;
    }

    public final AtomicBoolean getPendingRefresh() {
        return this.pendingRefresh;
    }

    public final Map<String, Integer> getTableIdLookup$room_runtime_release() {
        return this.tableIdLookup;
    }

    public final String[] getTablesNames$room_runtime_release() {
        return this.tablesNames;
    }

    public final void internalInit$room_runtime_release(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"database");
        Object object = this.trackerLock;
        synchronized (object) {
            if (this.initialized) {
                Log.e((String)"ROOM", (String)"Invalidation tracker is initialized twice :/.");
                return;
            }
            supportSQLiteDatabase.execSQL("PRAGMA temp_store = MEMORY;");
            supportSQLiteDatabase.execSQL("PRAGMA recursive_triggers='ON';");
            supportSQLiteDatabase.execSQL(CREATE_TRACKING_TABLE_SQL);
            this.syncTriggers$room_runtime_release(supportSQLiteDatabase);
            this.cleanupStatement = supportSQLiteDatabase.compileStatement(RESET_UPDATED_TABLES_SQL);
            this.initialized = true;
            supportSQLiteDatabase = Unit.INSTANCE;
            return;
        }
    }

    public final void notifyObserversByTableNames(String ... unit) {
        Intrinsics.checkNotNullParameter((Object)unit, (String)"tables");
        SafeIterableMap<Observer, ObserverWrapper> safeIterableMap = this.observerMap;
        synchronized (safeIterableMap) {
            for (Object object : (Iterable)this.observerMap) {
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"(observer, wrapper)");
                Observer observer2 = (Observer)object.getKey();
                object = (ObserverWrapper)object.getValue();
                if (observer2.isRemote$room_runtime_release()) continue;
                ((ObserverWrapper)object).notifyByTableNames$room_runtime_release((String[])unit);
            }
            unit = Unit.INSTANCE;
            return;
        }
    }

    public final void onAutoCloseCallback$room_runtime_release() {
        Object object = this.trackerLock;
        synchronized (object) {
            this.initialized = false;
            this.observedTableTracker.resetTriggerState();
            Unit unit = Unit.INSTANCE;
            return;
        }
    }

    public void refreshVersionsAsync() {
        if (this.pendingRefresh.compareAndSet(false, true)) {
            AutoCloser autoCloser = this.autoCloser;
            if (autoCloser != null) {
                autoCloser.incrementCountAndEnsureDbIsOpen();
            }
            this.database.getQueryExecutor().execute(this.refreshRunnable);
        }
    }

    public void refreshVersionsSync() {
        AutoCloser autoCloser = this.autoCloser;
        if (autoCloser != null) {
            autoCloser.incrementCountAndEnsureDbIsOpen();
        }
        this.syncTriggers$room_runtime_release();
        this.refreshRunnable.run();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void removeObserver(Observer object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"observer");
        Object object2 = this.observerMap;
        // MONITORENTER : object2
        object = this.observerMap.remove((Observer)object);
        // MONITOREXIT : object2
        if (object == null) return;
        object2 = this.observedTableTracker;
        if (!((ObservedTableTracker)object2).onRemoved(Arrays.copyOf((int[])(object = (Object)((ObserverWrapper)object).getTableIds$room_runtime_release()), ((Object)object).length))) return;
        this.syncTriggers$room_runtime_release();
    }

    public final void setAutoCloser$room_runtime_release(AutoCloser autoCloser) {
        Intrinsics.checkNotNullParameter((Object)autoCloser, (String)"autoCloser");
        this.autoCloser = autoCloser;
        autoCloser.setAutoCloseCallback(new InvalidationTracker$$ExternalSyntheticLambda0(this));
    }

    public final void setCleanupStatement$room_runtime_release(SupportSQLiteStatement supportSQLiteStatement) {
        this.cleanupStatement = supportSQLiteStatement;
    }

    public final void startMultiInstanceInvalidation$room_runtime_release(Context context, String string2, Intent intent) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"name");
        Intrinsics.checkNotNullParameter((Object)intent, (String)"serviceIntent");
        this.multiInstanceInvalidationClient = new MultiInstanceInvalidationClient(context, string2, intent, this, this.database.getQueryExecutor());
    }

    public final void stopMultiInstanceInvalidation$room_runtime_release() {
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.multiInstanceInvalidationClient;
        if (multiInstanceInvalidationClient != null) {
            multiInstanceInvalidationClient.stop();
        }
        this.multiInstanceInvalidationClient = null;
    }

    public final void syncTriggers$room_runtime_release() {
        if (!this.database.isOpen()) {
            return;
        }
        this.syncTriggers$room_runtime_release(this.database.getOpenHelper().getWritableDatabase());
    }

    /*
     * Exception decompiling
     */
    public final void syncTriggers$room_runtime_release(SupportSQLiteDatabase var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [17[CASE]], but top level block is 7[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0000\u00a2\u0006\u0002\b\u0013J\u001d\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0000\u00a2\u0006\u0002\b\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00048\u0000X\u0081T\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0016\u0010\b\u001a\u00020\u00048\u0000X\u0081T\u00a2\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0002R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Landroidx/room/InvalidationTracker$Companion;", "", "()V", "CREATE_TRACKING_TABLE_SQL", "", "INVALIDATED_COLUMN_NAME", "RESET_UPDATED_TABLES_SQL", "getRESET_UPDATED_TABLES_SQL$room_runtime_release$annotations", "SELECT_UPDATED_TABLES_SQL", "getSELECT_UPDATED_TABLES_SQL$room_runtime_release$annotations", "TABLE_ID_COLUMN_NAME", "TRIGGERS", "", "[Ljava/lang/String;", "UPDATE_TABLE_NAME", "beginTransactionInternal", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "beginTransactionInternal$room_runtime_release", "getTriggerName", "tableName", "triggerType", "getTriggerName$room_runtime_release", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getRESET_UPDATED_TABLES_SQL$room_runtime_release$annotations() {
        }

        public static /* synthetic */ void getSELECT_UPDATED_TABLES_SQL$room_runtime_release$annotations() {
        }

        public final void beginTransactionInternal$room_runtime_release(SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"database");
            if (supportSQLiteDatabase.isWriteAheadLoggingEnabled()) {
                supportSQLiteDatabase.beginTransactionNonExclusive();
            } else {
                supportSQLiteDatabase.beginTransaction();
            }
        }

        public final String getTriggerName$room_runtime_release(String string2, String string3) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"tableName");
            Intrinsics.checkNotNullParameter((Object)string3, (String)"triggerType");
            return "`room_table_modification_trigger_" + string2 + '_' + string3 + '`';
        }
    }

    @Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0007J\u0012\u0010\u0014\u001a\u00020\u00062\n\u0010\u0015\u001a\u00020\u0010\"\u00020\u0003J\u0012\u0010\u0016\u001a\u00020\u00062\n\u0010\u0015\u001a\u00020\u0010\"\u00020\u0003J\u0006\u0010\u0017\u001a\u00020\u0018R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Landroidx/room/InvalidationTracker$ObservedTableTracker;", "", "tableCount", "", "(I)V", "needsSync", "", "getNeedsSync", "()Z", "setNeedsSync", "(Z)V", "tableObservers", "", "getTableObservers", "()[J", "triggerStateChanges", "", "triggerStates", "", "getTablesToSync", "onAdded", "tableIds", "onRemoved", "resetTriggerState", "", "Companion", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class ObservedTableTracker {
        public static final int ADD = 1;
        public static final Companion Companion = new Companion(null);
        public static final int NO_OP = 0;
        public static final int REMOVE = 2;
        private boolean needsSync;
        private final long[] tableObservers;
        private final int[] triggerStateChanges;
        private final boolean[] triggerStates;

        public ObservedTableTracker(int n) {
            this.tableObservers = new long[n];
            this.triggerStates = new boolean[n];
            this.triggerStateChanges = new int[n];
        }

        public final boolean getNeedsSync() {
            return this.needsSync;
        }

        public final long[] getTableObservers() {
            return this.tableObservers;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public final int[] getTablesToSync() {
            synchronized (this) {
                boolean bl = this.needsSync;
                if (!bl) {
                    return null;
                }
                long[] lArray = this.tableObservers;
                int n = 0;
                int n2 = lArray.length;
                int n3 = 0;
                while (true) {
                    if (n3 >= n2) {
                        this.needsSync = false;
                        return (int[])this.triggerStateChanges.clone();
                    }
                    bl = lArray[n3] > 0L;
                    if (bl != this.triggerStates[n]) {
                        int[] nArray = this.triggerStateChanges;
                        int n4 = bl ? 1 : 2;
                        nArray[n] = n4;
                    } else {
                        this.triggerStateChanges[n] = 0;
                    }
                    this.triggerStates[n] = bl;
                    ++n3;
                    ++n;
                }
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public final boolean onAdded(int ... object) {
            Intrinsics.checkNotNullParameter((Object)object, (String)"tableIds");
            boolean bl = false;
            synchronized (this) {
                int n = ((int[])object).length;
                int n2 = 0;
                while (true) {
                    if (n2 >= n) {
                        Unit unit = Unit.INSTANCE;
                        return bl;
                    }
                    int n3 = object[n2];
                    long l = this.tableObservers[n3];
                    this.tableObservers[n3] = 1L + l;
                    if (l == 0L) {
                        this.needsSync = true;
                        bl = true;
                    }
                    ++n2;
                }
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public final boolean onRemoved(int ... object) {
            Intrinsics.checkNotNullParameter((Object)object, (String)"tableIds");
            boolean bl = false;
            synchronized (this) {
                int n = ((int[])object).length;
                int n2 = 0;
                while (true) {
                    if (n2 >= n) {
                        Unit unit = Unit.INSTANCE;
                        return bl;
                    }
                    int n3 = object[n2];
                    long l = this.tableObservers[n3];
                    this.tableObservers[n3] = l - 1L;
                    if (l == 1L) {
                        this.needsSync = true;
                        bl = true;
                    }
                    ++n2;
                }
            }
        }

        public final void resetTriggerState() {
            synchronized (this) {
                Arrays.fill(this.triggerStates, false);
                this.needsSync = true;
                Unit unit = Unit.INSTANCE;
                return;
            }
        }

        public final void setNeedsSync(boolean bl) {
            this.needsSync = bl;
        }

        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2={"Landroidx/room/InvalidationTracker$ObservedTableTracker$Companion;", "", "()V", "ADD", "", "NO_OP", "REMOVE", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0010\"\n\u0000\b&\u0018\u00002\u00020\u0001B#\b\u0014\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005\"\u00020\u0003\u00a2\u0006\u0002\u0010\u0006B\u0015\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u0010\u001a\u00020\u00112\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H&R\u0014\u0010\t\u001a\u00020\n8PX\u0090\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005X\u0080\u0004\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2={"Landroidx/room/InvalidationTracker$Observer;", "", "firstTable", "", "rest", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "tables", "([Ljava/lang/String;)V", "isRemote", "", "isRemote$room_runtime_release", "()Z", "getTables$room_runtime_release", "()[Ljava/lang/String;", "[Ljava/lang/String;", "onInvalidated", "", "", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static abstract class Observer {
        private final String[] tables;

        protected Observer(String stringArray, String ... stringArray2) {
            Intrinsics.checkNotNullParameter((Object)stringArray, (String)"firstTable");
            Intrinsics.checkNotNullParameter((Object)stringArray2, (String)"rest");
            List list = CollectionsKt.createListBuilder();
            CollectionsKt.addAll((Collection)list, (Object[])stringArray2);
            list.add(stringArray);
            stringArray = CollectionsKt.build((List)list);
            stringArray = stringArray.toArray(new String[0]);
            Intrinsics.checkNotNull((Object)stringArray, (String)"null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            this(stringArray);
        }

        public Observer(String[] stringArray) {
            Intrinsics.checkNotNullParameter((Object)stringArray, (String)"tables");
            this.tables = stringArray;
        }

        public final String[] getTables$room_runtime_release() {
            return this.tables;
        }

        public boolean isRemote$room_runtime_release() {
            return false;
        }

        public abstract void onInvalidated(Set<String> var1);
    }

    @Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\u001d\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\rH\u0000\u00a2\u0006\u0002\b\u0015J\u001f\u0010\u0016\u001a\u00020\u00122\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0010\u00a8\u0006\u001a"}, d2={"Landroidx/room/InvalidationTracker$ObserverWrapper;", "", "observer", "Landroidx/room/InvalidationTracker$Observer;", "tableIds", "", "tableNames", "", "", "(Landroidx/room/InvalidationTracker$Observer;[I[Ljava/lang/String;)V", "getObserver$room_runtime_release", "()Landroidx/room/InvalidationTracker$Observer;", "singleTableSet", "", "getTableIds$room_runtime_release", "()[I", "[Ljava/lang/String;", "notifyByTableInvalidStatus", "", "invalidatedTablesIds", "", "notifyByTableInvalidStatus$room_runtime_release", "notifyByTableNames", "tables", "notifyByTableNames$room_runtime_release", "([Ljava/lang/String;)V", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class ObserverWrapper {
        private final Observer observer;
        private final Set<String> singleTableSet;
        private final int[] tableIds;
        private final String[] tableNames;

        public ObserverWrapper(Observer object, int[] nArray, String[] stringArray) {
            Intrinsics.checkNotNullParameter((Object)object, (String)"observer");
            Intrinsics.checkNotNullParameter((Object)nArray, (String)"tableIds");
            Intrinsics.checkNotNullParameter((Object)stringArray, (String)"tableNames");
            this.observer = object;
            this.tableIds = nArray;
            this.tableNames = stringArray;
            int n = this.tableNames.length;
            int n2 = 1;
            n = n == 0 ? 1 : 0;
            object = (n ^ 1) != 0 ? SetsKt.setOf((Object)this.tableNames[0]) : SetsKt.emptySet();
            this.singleTableSet = object;
            n = this.tableIds.length == this.tableNames.length ? n2 : 0;
            if (n != 0) {
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }

        public final Observer getObserver$room_runtime_release() {
            return this.observer;
        }

        public final int[] getTableIds$room_runtime_release() {
            return this.tableIds;
        }

        public final void notifyByTableInvalidStatus$room_runtime_release(Set<Integer> set) {
            block7: {
                int n;
                int[] nArray;
                Set set2;
                Intrinsics.checkNotNullParameter(set, (String)"invalidatedTablesIds");
                int n2 = this.tableIds.length;
                int n3 = 0;
                switch (n2) {
                    default: {
                        set2 = SetsKt.createSetBuilder();
                        nArray = this.tableIds;
                        n2 = 0;
                        n = nArray.length;
                        break;
                    }
                    case 1: {
                        set = set.contains(this.tableIds[0]) ? this.singleTableSet : SetsKt.emptySet();
                        break block7;
                    }
                    case 0: {
                        set = SetsKt.emptySet();
                        break block7;
                    }
                }
                while (n3 < n) {
                    if (set.contains(nArray[n3])) {
                        set2.add(this.tableNames[n2]);
                    }
                    ++n3;
                    ++n2;
                }
                set = SetsKt.build((Set)set2);
            }
            if (((Collection)set).isEmpty() ^ true) {
                this.observer.onInvalidated(set);
            }
        }

        /*
         * Unable to fully structure code
         * Could not resolve type clashes
         */
        public final void notifyByTableNames$room_runtime_release(String[] var1_1) {
            block8: {
                Intrinsics.checkNotNullParameter((Object)var1_1 /* !! */ , (String)"tables");
                var2_2 = this.tableNames.length;
                var3_3 = 0;
                switch (var2_2) {
                    default: {
                        var8_4 = SetsKt.createSetBuilder();
                        var5_5 = var1_1 /* !! */ .length;
                        break;
                    }
                    case 1: {
                        var4_6 = var1_1 /* !! */ .length;
                        for (var2_2 = 0; var2_2 < var4_6; ++var2_2) {
                            if (!StringsKt.equals((String)var1_1 /* !! */ [var2_2], (String)this.tableNames[0], (boolean)true)) continue;
                            var2_2 = 1;
                            ** GOTO lbl16
                        }
                        var2_2 = var3_3;
lbl16:
                        // 2 sources

                        var1_1 /* !! */  = var2_2 != 0 ? this.singleTableSet : SetsKt.emptySet();
                        break block8;
                    }
                    case 0: {
                        var1_1 /* !! */  = SetsKt.emptySet();
                        break block8;
                    }
                }
                for (var2_2 = 0; var2_2 < var5_5; ++var2_2) {
                    var7_9 = var1_1 /* !! */ [var2_2];
                    for (String var6_8 : this.tableNames) {
                        if (!StringsKt.equals((String)var6_8, (String)var7_9, (boolean)true)) continue;
                        var8_4.add(var6_8);
                    }
                }
                var1_1 /* !! */  = SetsKt.build((Set)var8_4);
            }
            if (((Collection)var1_1 /* !! */ ).isEmpty() ^ true) {
                this.observer.onInvalidated((Set<String>)var1_1 /* !! */ );
            }
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2={"Landroidx/room/InvalidationTracker$WeakObserver;", "Landroidx/room/InvalidationTracker$Observer;", "tracker", "Landroidx/room/InvalidationTracker;", "delegate", "(Landroidx/room/InvalidationTracker;Landroidx/room/InvalidationTracker$Observer;)V", "delegateRef", "Ljava/lang/ref/WeakReference;", "getDelegateRef", "()Ljava/lang/ref/WeakReference;", "getTracker", "()Landroidx/room/InvalidationTracker;", "onInvalidated", "", "tables", "", "", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class WeakObserver
    extends Observer {
        private final WeakReference<Observer> delegateRef;
        private final InvalidationTracker tracker;

        public WeakObserver(InvalidationTracker invalidationTracker, Observer observer2) {
            Intrinsics.checkNotNullParameter((Object)invalidationTracker, (String)"tracker");
            Intrinsics.checkNotNullParameter((Object)observer2, (String)"delegate");
            super(observer2.getTables$room_runtime_release());
            this.tracker = invalidationTracker;
            this.delegateRef = new WeakReference<Observer>(observer2);
        }

        public final WeakReference<Observer> getDelegateRef() {
            return this.delegateRef;
        }

        public final InvalidationTracker getTracker() {
            return this.tracker;
        }

        @Override
        public void onInvalidated(Set<String> set) {
            Intrinsics.checkNotNullParameter(set, (String)"tables");
            Observer observer2 = (Observer)this.delegateRef.get();
            if (observer2 == null) {
                this.tracker.removeObserver(this);
            } else {
                observer2.onInvalidated(set);
            }
        }
    }
}

