/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.sqlite.db;

import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0005\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2={"Landroidx/sqlite/db/SimpleSQLiteQuery;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "query", "", "(Ljava/lang/String;)V", "bindArgs", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "argCount", "", "getArgCount", "()I", "[Ljava/lang/Object;", "sql", "getSql", "()Ljava/lang/String;", "bindTo", "", "statement", "Landroidx/sqlite/db/SupportSQLiteProgram;", "Companion", "sqlite_release"}, k=1, mv={1, 7, 1}, xi=48)
public final class SimpleSQLiteQuery
implements SupportSQLiteQuery {
    public static final Companion Companion = new Companion(null);
    private final Object[] bindArgs;
    private final String query;

    public SimpleSQLiteQuery(String string2) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"query");
        this(string2, null);
    }

    public SimpleSQLiteQuery(String string2, Object[] objectArray) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"query");
        this.query = string2;
        this.bindArgs = objectArray;
    }

    @JvmStatic
    public static final void bind(SupportSQLiteProgram supportSQLiteProgram, Object[] objectArray) {
        Companion.bind(supportSQLiteProgram, objectArray);
    }

    @Override
    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        Intrinsics.checkNotNullParameter((Object)supportSQLiteProgram, (String)"statement");
        Companion.bind(supportSQLiteProgram, this.bindArgs);
    }

    @Override
    public int getArgCount() {
        Object[] objectArray = this.bindArgs;
        int n = objectArray != null ? objectArray.length : 0;
        return n;
    }

    @Override
    public String getSql() {
        return this.query;
    }

    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\bH\u0007\u00a2\u0006\u0002\u0010\tJ\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0002\u00a8\u0006\r"}, d2={"Landroidx/sqlite/db/SimpleSQLiteQuery$Companion;", "", "()V", "bind", "", "statement", "Landroidx/sqlite/db/SupportSQLiteProgram;", "bindArgs", "", "(Landroidx/sqlite/db/SupportSQLiteProgram;[Ljava/lang/Object;)V", "index", "", "arg", "sqlite_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void bind(SupportSQLiteProgram supportSQLiteProgram, int n, Object object) {
            block12: {
                block3: {
                    block11: {
                        block10: {
                            block9: {
                                block8: {
                                    block7: {
                                        block6: {
                                            block5: {
                                                block4: {
                                                    block2: {
                                                        if (object != null) break block2;
                                                        supportSQLiteProgram.bindNull(n);
                                                        break block3;
                                                    }
                                                    if (!(object instanceof byte[])) break block4;
                                                    supportSQLiteProgram.bindBlob(n, (byte[])object);
                                                    break block3;
                                                }
                                                if (!(object instanceof Float)) break block5;
                                                supportSQLiteProgram.bindDouble(n, ((Number)object).floatValue());
                                                break block3;
                                            }
                                            if (!(object instanceof Double)) break block6;
                                            supportSQLiteProgram.bindDouble(n, ((Number)object).doubleValue());
                                            break block3;
                                        }
                                        if (!(object instanceof Long)) break block7;
                                        supportSQLiteProgram.bindLong(n, ((Number)object).longValue());
                                        break block3;
                                    }
                                    if (!(object instanceof Integer)) break block8;
                                    supportSQLiteProgram.bindLong(n, ((Number)object).intValue());
                                    break block3;
                                }
                                if (!(object instanceof Short)) break block9;
                                supportSQLiteProgram.bindLong(n, ((Number)object).shortValue());
                                break block3;
                            }
                            if (!(object instanceof Byte)) break block10;
                            supportSQLiteProgram.bindLong(n, ((Number)object).byteValue());
                            break block3;
                        }
                        if (!(object instanceof String)) break block11;
                        supportSQLiteProgram.bindString(n, (String)object);
                        break block3;
                    }
                    if (!(object instanceof Boolean)) break block12;
                    long l = (Boolean)object != false ? 1L : 0L;
                    supportSQLiteProgram.bindLong(n, l);
                }
                return;
            }
            throw new IllegalArgumentException("Cannot bind " + object + " at index " + n + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
        }

        @JvmStatic
        public final void bind(SupportSQLiteProgram supportSQLiteProgram, Object[] objectArray) {
            Intrinsics.checkNotNullParameter((Object)supportSQLiteProgram, (String)"statement");
            if (objectArray == null) {
                return;
            }
            int n = objectArray.length;
            for (int i = 0; i < n; ++i) {
                this.bind(supportSQLiteProgram, i + 1, objectArray[i]);
            }
        }
    }
}

