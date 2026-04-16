/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.annotation.AnnotationRetention
 *  kotlin.annotation.Retention
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\b\u0007\u0018\u0000 62\u00020\u00012\u00020\u0002:\u000256B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0010H\u0016J\u0018\u0010&\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020'H\u0016J\u0018\u0010(\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0004H\u0016J\u0018\u0010+\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u001bH\u0016J\u0010\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u0002H\u0016J\b\u0010.\u001a\u00020#H\u0016J\b\u0010/\u001a\u00020#H\u0016J\u000e\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020\u0000J\u0016\u00102\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u0004J\u0006\u00104\u001a\u00020#R\u001e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004@RX\u0096\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\f\u0010\rR \u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0012\u0012\u0004\b\u0011\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0016\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\rR\u0016\u0010\u0017\u001a\u00020\u00188\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\rR\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u000f8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010!\u0012\u0004\b \u0010\r\u00a8\u00067"}, d2={"Landroidx/room/RoomSQLiteQuery;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "Landroidx/sqlite/db/SupportSQLiteProgram;", "capacity", "", "(I)V", "<set-?>", "argCount", "getArgCount", "()I", "bindingTypes", "", "getBindingTypes$annotations", "()V", "blobBindings", "", "", "getBlobBindings$annotations", "[[B", "getCapacity", "doubleBindings", "", "getDoubleBindings$annotations", "longBindings", "", "getLongBindings$annotations", "query", "", "sql", "getSql", "()Ljava/lang/String;", "stringBindings", "getStringBindings$annotations", "[Ljava/lang/String;", "bindBlob", "", "index", "value", "bindDouble", "", "bindLong", "", "bindNull", "bindString", "bindTo", "statement", "clearBindings", "close", "copyArgumentsFrom", "other", "init", "initArgCount", "release", "Binding", "Companion", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
public final class RoomSQLiteQuery
implements SupportSQLiteQuery,
SupportSQLiteProgram {
    private static final int BLOB = 5;
    public static final Companion Companion = new Companion(null);
    public static final int DESIRED_POOL_SIZE = 10;
    private static final int DOUBLE = 3;
    private static final int LONG = 2;
    private static final int NULL = 1;
    public static final int POOL_LIMIT = 15;
    private static final int STRING = 4;
    public static final TreeMap<Integer, RoomSQLiteQuery> queryPool = new TreeMap();
    private int argCount;
    private final int[] bindingTypes;
    public final byte[][] blobBindings;
    private final int capacity;
    public final double[] doubleBindings;
    public final long[] longBindings;
    private volatile String query;
    public final String[] stringBindings;

    private RoomSQLiteQuery(int n) {
        this.capacity = n;
        n = this.capacity + 1;
        this.bindingTypes = new int[n];
        this.longBindings = new long[n];
        this.doubleBindings = new double[n];
        this.stringBindings = new String[n];
        this.blobBindings = new byte[n][];
    }

    public /* synthetic */ RoomSQLiteQuery(int n, DefaultConstructorMarker defaultConstructorMarker) {
        this(n);
    }

    @JvmStatic
    public static final RoomSQLiteQuery acquire(String string2, int n) {
        return Companion.acquire(string2, n);
    }

    @JvmStatic
    public static final RoomSQLiteQuery copyFrom(SupportSQLiteQuery supportSQLiteQuery) {
        return Companion.copyFrom(supportSQLiteQuery);
    }

    private static /* synthetic */ void getBindingTypes$annotations() {
    }

    public static /* synthetic */ void getBlobBindings$annotations() {
    }

    public static /* synthetic */ void getDoubleBindings$annotations() {
    }

    public static /* synthetic */ void getLongBindings$annotations() {
    }

    public static /* synthetic */ void getStringBindings$annotations() {
    }

    @Override
    public void bindBlob(int n, byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"value");
        this.bindingTypes[n] = 5;
        this.blobBindings[n] = byArray;
    }

    @Override
    public void bindDouble(int n, double d) {
        this.bindingTypes[n] = 3;
        this.doubleBindings[n] = d;
    }

    @Override
    public void bindLong(int n, long l) {
        this.bindingTypes[n] = 2;
        this.longBindings[n] = l;
    }

    @Override
    public void bindNull(int n) {
        this.bindingTypes[n] = 1;
    }

    @Override
    public void bindString(int n, String string2) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"value");
        this.bindingTypes[n] = 4;
        this.stringBindings[n] = string2;
    }

    @Override
    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        Intrinsics.checkNotNullParameter((Object)supportSQLiteProgram, (String)"statement");
        int n = 1;
        int n2 = this.getArgCount();
        if (1 <= n2) {
            while (true) {
                switch (this.bindingTypes[n]) {
                    default: {
                        break;
                    }
                    case 5: {
                        Object object = this.blobBindings[n];
                        if (object != null) {
                            supportSQLiteProgram.bindBlob(n, (byte[])object);
                            break;
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    case 4: {
                        Object object = this.stringBindings[n];
                        if (object != null) {
                            supportSQLiteProgram.bindString(n, (String)object);
                            break;
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    case 3: {
                        supportSQLiteProgram.bindDouble(n, this.doubleBindings[n]);
                        break;
                    }
                    case 2: {
                        supportSQLiteProgram.bindLong(n, this.longBindings[n]);
                        break;
                    }
                    case 1: {
                        supportSQLiteProgram.bindNull(n);
                    }
                }
                if (n == n2) break;
                ++n;
            }
        }
    }

    @Override
    public void clearBindings() {
        Arrays.fill(this.bindingTypes, 1);
        Arrays.fill(this.stringBindings, null);
        Arrays.fill((Object[])this.blobBindings, null);
        this.query = null;
    }

    @Override
    public void close() {
    }

    public final void copyArgumentsFrom(RoomSQLiteQuery roomSQLiteQuery) {
        Intrinsics.checkNotNullParameter((Object)roomSQLiteQuery, (String)"other");
        int n = roomSQLiteQuery.getArgCount() + 1;
        System.arraycopy(roomSQLiteQuery.bindingTypes, 0, this.bindingTypes, 0, n);
        System.arraycopy(roomSQLiteQuery.longBindings, 0, this.longBindings, 0, n);
        System.arraycopy(roomSQLiteQuery.stringBindings, 0, this.stringBindings, 0, n);
        System.arraycopy(roomSQLiteQuery.blobBindings, 0, this.blobBindings, 0, n);
        System.arraycopy(roomSQLiteQuery.doubleBindings, 0, this.doubleBindings, 0, n);
    }

    @Override
    public int getArgCount() {
        return this.argCount;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    @Override
    public String getSql() {
        String string2 = this.query;
        if (string2 != null) {
            return string2;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final void init(String string2, int n) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"query");
        this.query = string2;
        this.argCount = n;
    }

    public final void release() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = queryPool;
        synchronized (treeMap) {
            ((Map)queryPool).put(this.capacity, this);
            Companion.prunePoolLocked$room_runtime_release();
            Unit unit = Unit.INSTANCE;
            return;
        }
    }

    @java.lang.annotation.Retention(value=RetentionPolicy.SOURCE)
    @Metadata(d1={"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2={"Landroidx/room/RoomSQLiteQuery$Binding;", "", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
    @Retention(value=AnnotationRetention.SOURCE)
    public static @interface Binding {
    }

    @Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\r\u0010\u0018\u001a\u00020\u0019H\u0000\u00a2\u0006\u0002\b\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087T\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u00048\u0006X\u0087T\u00a2\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0002\u00a8\u0006\u001b"}, d2={"Landroidx/room/RoomSQLiteQuery$Companion;", "", "()V", "BLOB", "", "DESIRED_POOL_SIZE", "getDESIRED_POOL_SIZE$annotations", "DOUBLE", "LONG", "NULL", "POOL_LIMIT", "getPOOL_LIMIT$annotations", "STRING", "queryPool", "Ljava/util/TreeMap;", "Landroidx/room/RoomSQLiteQuery;", "getQueryPool$annotations", "acquire", "query", "", "argumentCount", "copyFrom", "supportSQLiteQuery", "Landroidx/sqlite/db/SupportSQLiteQuery;", "prunePoolLocked", "", "prunePoolLocked$room_runtime_release", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getDESIRED_POOL_SIZE$annotations() {
        }

        public static /* synthetic */ void getPOOL_LIMIT$annotations() {
        }

        public static /* synthetic */ void getQueryPool$annotations() {
        }

        @JvmStatic
        public final RoomSQLiteQuery acquire(String string2, int n) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"query");
            Object object = queryPool;
            synchronized (object) {
                Object object2;
                block5: {
                    object2 = queryPool.ceilingEntry(n);
                    if (object2 == null) break block5;
                    queryPool.remove(object2.getKey());
                    object2 = (RoomSQLiteQuery)object2.getValue();
                    ((RoomSQLiteQuery)object2).init(string2, n);
                    Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"sqliteQuery");
                    return object2;
                }
                object2 = Unit.INSTANCE;
                // MONITOREXIT @DISABLED, blocks:[2, 3] lbl17 : MonitorExitStatement: MONITOREXIT : var3_4
                object = new RoomSQLiteQuery(n, null);
                ((RoomSQLiteQuery)object).init(string2, n);
                return object;
            }
        }

        @JvmStatic
        public final RoomSQLiteQuery copyFrom(SupportSQLiteQuery supportSQLiteQuery) {
            Intrinsics.checkNotNullParameter((Object)supportSQLiteQuery, (String)"supportSQLiteQuery");
            RoomSQLiteQuery roomSQLiteQuery = this.acquire(supportSQLiteQuery.getSql(), supportSQLiteQuery.getArgCount());
            supportSQLiteQuery.bindTo(new SupportSQLiteProgram(roomSQLiteQuery){
                private final RoomSQLiteQuery $$delegate_0;
                {
                    this.$$delegate_0 = roomSQLiteQuery;
                }

                public void bindBlob(int n, byte[] byArray) {
                    Intrinsics.checkNotNullParameter((Object)byArray, (String)"value");
                    this.$$delegate_0.bindBlob(n, byArray);
                }

                public void bindDouble(int n, double d) {
                    this.$$delegate_0.bindDouble(n, d);
                }

                public void bindLong(int n, long l) {
                    this.$$delegate_0.bindLong(n, l);
                }

                public void bindNull(int n) {
                    this.$$delegate_0.bindNull(n);
                }

                public void bindString(int n, String string2) {
                    Intrinsics.checkNotNullParameter((Object)string2, (String)"value");
                    this.$$delegate_0.bindString(n, string2);
                }

                public void clearBindings() {
                    this.$$delegate_0.clearBindings();
                }

                public void close() {
                    this.$$delegate_0.close();
                }
            });
            return roomSQLiteQuery;
        }

        public final void prunePoolLocked$room_runtime_release() {
            if (queryPool.size() > 15) {
                Iterator<Integer> iterator2 = queryPool.descendingKeySet().iterator();
                Intrinsics.checkNotNullExpressionValue(iterator2, (String)"queryPool.descendingKeySet().iterator()");
                for (int i = queryPool.size() - 10; i > 0; --i) {
                    iterator2.next();
                    iterator2.remove();
                }
            }
        }
    }
}

