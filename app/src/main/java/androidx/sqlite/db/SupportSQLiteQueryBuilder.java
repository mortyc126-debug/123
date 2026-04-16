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

import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00002\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\n\u001a\u00020\u0000J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0003J\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003J)\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0005\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0014J\"\u0010\u0015\u001a\u00020\u0016*\u00060\u0017j\u0002`\u00182\u0006\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0002J%\u0010\u001b\u001a\u00020\u0016*\u00060\u0017j\u0002`\u00182\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0006H\u0002\u00a2\u0006\u0002\u0010\u001cR\u001c\u0010\u0005\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0007R\u001a\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2={"Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "", "table", "", "(Ljava/lang/String;)V", "bindArgs", "", "[Ljava/lang/Object;", "columns", "[Ljava/lang/String;", "distinct", "", "groupBy", "having", "limit", "orderBy", "selection", "([Ljava/lang/String;)Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "create", "Landroidx/sqlite/db/SupportSQLiteQuery;", "(Ljava/lang/String;[Ljava/lang/Object;)Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "appendClause", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "name", "clause", "appendColumns", "(Ljava/lang/StringBuilder;[Ljava/lang/String;)V", "Companion", "sqlite_release"}, k=1, mv={1, 7, 1}, xi=48)
public final class SupportSQLiteQueryBuilder {
    public static final Companion Companion = new Companion(null);
    private static final Pattern limitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    private Object[] bindArgs;
    private String[] columns;
    private boolean distinct;
    private String groupBy;
    private String having;
    private String limit;
    private String orderBy;
    private String selection;
    private final String table;

    private SupportSQLiteQueryBuilder(String string2) {
        this.table = string2;
    }

    public /* synthetic */ SupportSQLiteQueryBuilder(String string2, DefaultConstructorMarker defaultConstructorMarker) {
        this(string2);
    }

    private final void appendClause(StringBuilder stringBuilder, String string2, String string3) {
        CharSequence charSequence = string3;
        boolean bl = charSequence == null || charSequence.length() == 0;
        if (!bl) {
            stringBuilder.append(string2);
            stringBuilder.append(string3);
        }
    }

    private final void appendColumns(StringBuilder stringBuilder, String[] stringArray) {
        int n = stringArray.length;
        for (int i = 0; i < n; ++i) {
            String string2 = stringArray[i];
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(string2);
        }
        stringBuilder.append(' ');
    }

    @JvmStatic
    public static final SupportSQLiteQueryBuilder builder(String string2) {
        return Companion.builder(string2);
    }

    public final SupportSQLiteQueryBuilder columns(String[] stringArray) {
        this.columns = stringArray;
        return this;
    }

    /*
     * Unable to fully structure code
     */
    public final SupportSQLiteQuery create() {
        var3_1 = this.groupBy;
        var2_2 = false;
        var1_3 = var3_1 == null || var3_1.length() == 0;
        if (!var1_3) ** GOTO lbl-1000
        var3_1 = this.having;
        var1_3 = var3_1 == null || var3_1.length() == 0;
        if (!var1_3) {
            var1_3 = false;
        } else lbl-1000:
        // 2 sources

        {
            var1_3 = true;
        }
        if (var1_3) {
            var3_1 = new StringBuilder(120);
            var3_1.append("SELECT ");
            if (this.distinct) {
                var3_1.append("DISTINCT ");
            }
            if ((var4_4 = this.columns) == null || (var1_3 = var4_4.length == 0)) {
                var2_2 = true;
            }
            if (!var2_2) {
                var4_4 = this.columns;
                Intrinsics.checkNotNull((Object)var4_4);
                this.appendColumns((StringBuilder)var3_1, var4_4);
            } else {
                var3_1.append("* ");
            }
            var3_1.append("FROM ");
            var3_1.append(this.table);
            this.appendClause((StringBuilder)var3_1, " WHERE ", this.selection);
            this.appendClause((StringBuilder)var3_1, " GROUP BY ", this.groupBy);
            this.appendClause((StringBuilder)var3_1, " HAVING ", this.having);
            this.appendClause((StringBuilder)var3_1, " ORDER BY ", this.orderBy);
            this.appendClause((StringBuilder)var3_1, " LIMIT ", this.limit);
            var3_1 = var3_1.toString();
            Intrinsics.checkNotNullExpressionValue((Object)var3_1, (String)"StringBuilder(capacity).\u2026builderAction).toString()");
            return new SimpleSQLiteQuery((String)var3_1, this.bindArgs);
        }
        throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause".toString());
    }

    public final SupportSQLiteQueryBuilder distinct() {
        this.distinct = true;
        return this;
    }

    public final SupportSQLiteQueryBuilder groupBy(String string2) {
        this.groupBy = string2;
        return this;
    }

    public final SupportSQLiteQueryBuilder having(String string2) {
        this.having = string2;
        return this;
    }

    public final SupportSQLiteQueryBuilder limit(String string2) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"limit");
        SupportSQLiteQueryBuilder supportSQLiteQueryBuilder = this;
        boolean bl = limitPattern.matcher(string2).matches();
        int n = ((CharSequence)string2).length();
        boolean bl2 = true;
        n = n == 0 ? 1 : 0;
        boolean bl3 = bl2;
        if (n == 0) {
            bl3 = bl ? bl2 : false;
        }
        if (bl3) {
            supportSQLiteQueryBuilder.limit = string2;
            return this;
        }
        throw new IllegalArgumentException(("invalid LIMIT clauses:" + string2).toString());
    }

    public final SupportSQLiteQueryBuilder orderBy(String string2) {
        this.orderBy = string2;
        return this;
    }

    public final SupportSQLiteQueryBuilder selection(String string2, Object[] objectArray) {
        SupportSQLiteQueryBuilder supportSQLiteQueryBuilder = this;
        supportSQLiteQueryBuilder.selection = string2;
        supportSQLiteQueryBuilder.bindArgs = objectArray;
        return this;
    }

    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Landroidx/sqlite/db/SupportSQLiteQueryBuilder$Companion;", "", "()V", "limitPattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "builder", "Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "tableName", "", "sqlite_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final SupportSQLiteQueryBuilder builder(String string2) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"tableName");
            return new SupportSQLiteQueryBuilder(string2, null);
        }
    }
}

