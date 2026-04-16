/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.annotation.AnnotationRetention
 *  kotlin.annotation.Retention
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 */
package androidx.room.util;

import androidx.room.Index;
import androidx.room.util.TableInfoKt;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0006\u0014\u0015\u0016\u0017\u0018\u0019B1\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\u0010\nBA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b\u00a2\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Landroidx/room/util/TableInfo;", "", "name", "", "columns", "", "Landroidx/room/util/TableInfo$Column;", "foreignKeys", "", "Landroidx/room/util/TableInfo$ForeignKey;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Set;)V", "indices", "Landroidx/room/util/TableInfo$Index;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;)V", "equals", "", "other", "hashCode", "", "toString", "Column", "Companion", "CreatedFrom", "ForeignKey", "ForeignKeyWithSequence", "Index", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
public final class TableInfo {
    public static final int CREATED_FROM_DATABASE = 2;
    public static final int CREATED_FROM_ENTITY = 1;
    public static final int CREATED_FROM_UNKNOWN = 0;
    public static final Companion Companion = new Companion(null);
    public final Map<String, Column> columns;
    public final Set<ForeignKey> foreignKeys;
    public final Set<Index> indices;
    public final String name;

    public TableInfo(String string2, Map<String, Column> map2, Set<ForeignKey> set) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"name");
        Intrinsics.checkNotNullParameter(map2, (String)"columns");
        Intrinsics.checkNotNullParameter(set, (String)"foreignKeys");
        this(string2, map2, set, SetsKt.emptySet());
    }

    public TableInfo(String string2, Map<String, Column> map2, Set<ForeignKey> set, Set<Index> set2) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"name");
        Intrinsics.checkNotNullParameter(map2, (String)"columns");
        Intrinsics.checkNotNullParameter(set, (String)"foreignKeys");
        this.name = string2;
        this.columns = map2;
        this.foreignKeys = set;
        this.indices = set2;
    }

    public /* synthetic */ TableInfo(String string2, Map map2, Set set, Set set2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 8) != 0) {
            set2 = null;
        }
        this(string2, map2, set, set2);
    }

    @JvmStatic
    public static final TableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String string2) {
        return Companion.read(supportSQLiteDatabase, string2);
    }

    public boolean equals(Object object) {
        boolean bl;
        block5: {
            bl = true;
            if (this == object) {
                return true;
            }
            if (!(object instanceof TableInfo)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.name, (Object)((TableInfo)object).name)) {
                return false;
            }
            if (!Intrinsics.areEqual(this.columns, ((TableInfo)object).columns)) {
                return false;
            }
            if (!Intrinsics.areEqual(this.foreignKeys, ((TableInfo)object).foreignKeys)) {
                return false;
            }
            if (this.indices == null || ((TableInfo)object).indices == null) break block5;
            bl = Intrinsics.areEqual(this.indices, ((TableInfo)object).indices);
        }
        return bl;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31 + ((Object)this.columns).hashCode()) * 31 + ((Object)this.foreignKeys).hashCode();
    }

    public String toString() {
        return "TableInfo{name='" + this.name + "', columns=" + this.columns + ", foreignKeys=" + this.foreignKeys + ", indices=" + this.indices + '}';
    }

    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0002\u0010\fJ\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0003J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u0016\u0010\r\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000fR\u0010\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Landroidx/room/util/TableInfo$Column;", "", "name", "", "type", "notNull", "", "primaryKeyPosition", "", "(Ljava/lang/String;Ljava/lang/String;ZI)V", "defaultValue", "createdFrom", "(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;I)V", "affinity", "getAffinity$annotations", "()V", "isPrimaryKey", "()Z", "equals", "other", "findAffinity", "hashCode", "toString", "Companion", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Column {
        public static final Companion Companion = new Companion(null);
        public final int affinity;
        public final int createdFrom;
        public final String defaultValue;
        public final String name;
        public final boolean notNull;
        public final int primaryKeyPosition;
        public final String type;

        @Deprecated(message="Use {@link Column#Column(String, String, boolean, int, String, int)} instead.")
        public Column(String string2, String string3, boolean bl, int n) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"name");
            Intrinsics.checkNotNullParameter((Object)string3, (String)"type");
            this(string2, string3, bl, n, null, 0);
        }

        public Column(String string2, String string3, boolean bl, int n, String string4, int n2) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"name");
            Intrinsics.checkNotNullParameter((Object)string3, (String)"type");
            this.name = string2;
            this.type = string3;
            this.notNull = bl;
            this.primaryKeyPosition = n;
            this.defaultValue = string4;
            this.createdFrom = n2;
            this.affinity = this.findAffinity(this.type);
        }

        @JvmStatic
        public static final boolean defaultValueEquals(String string2, String string3) {
            return Companion.defaultValueEquals(string2, string3);
        }

        private final int findAffinity(String string2) {
            if (string2 == null) {
                return 5;
            }
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue((Object)locale, (String)"US");
            string2 = string2.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"this as java.lang.String).toUpperCase(locale)");
            if (StringsKt.contains$default((CharSequence)string2, (CharSequence)"INT", (boolean)false, (int)2, null)) {
                return 3;
            }
            if (!(StringsKt.contains$default((CharSequence)string2, (CharSequence)"CHAR", (boolean)false, (int)2, null) || StringsKt.contains$default((CharSequence)string2, (CharSequence)"CLOB", (boolean)false, (int)2, null) || StringsKt.contains$default((CharSequence)string2, (CharSequence)"TEXT", (boolean)false, (int)2, null))) {
                if (StringsKt.contains$default((CharSequence)string2, (CharSequence)"BLOB", (boolean)false, (int)2, null)) {
                    return 5;
                }
                if (!(StringsKt.contains$default((CharSequence)string2, (CharSequence)"REAL", (boolean)false, (int)2, null) || StringsKt.contains$default((CharSequence)string2, (CharSequence)"FLOA", (boolean)false, (int)2, null) || StringsKt.contains$default((CharSequence)string2, (CharSequence)"DOUB", (boolean)false, (int)2, null))) {
                    return 1;
                }
                return 4;
            }
            return 2;
        }

        public static /* synthetic */ void getAffinity$annotations() {
        }

        public boolean equals(Object object) {
            boolean bl = true;
            if (this == object) {
                return true;
            }
            if (!(object instanceof Column)) {
                return false;
            }
            if (this.primaryKeyPosition != ((Column)object).primaryKeyPosition) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.name, (Object)((Column)object).name)) {
                return false;
            }
            if (this.notNull != ((Column)object).notNull) {
                return false;
            }
            if (this.createdFrom == 1 && ((Column)object).createdFrom == 2 && this.defaultValue != null && !Companion.defaultValueEquals(this.defaultValue, ((Column)object).defaultValue)) {
                return false;
            }
            if (this.createdFrom == 2 && ((Column)object).createdFrom == 1 && ((Column)object).defaultValue != null && !Companion.defaultValueEquals(((Column)object).defaultValue, this.defaultValue)) {
                return false;
            }
            if (this.createdFrom != 0 && this.createdFrom == ((Column)object).createdFrom) {
                boolean bl2 = this.defaultValue != null ? !Companion.defaultValueEquals(this.defaultValue, ((Column)object).defaultValue) : ((Column)object).defaultValue != null;
                if (bl2) {
                    return false;
                }
            }
            if (this.affinity != ((Column)object).affinity) {
                bl = false;
            }
            return bl;
        }

        public int hashCode() {
            int n = this.name.hashCode();
            int n2 = this.affinity;
            int n3 = this.notNull ? 1231 : 1237;
            return ((n * 31 + n2) * 31 + n3) * 31 + this.primaryKeyPosition;
        }

        public final boolean isPrimaryKey() {
            boolean bl = this.primaryKeyPosition > 0;
            return bl;
        }

        public String toString() {
            CharSequence charSequence = new StringBuilder().append("Column{name='").append(this.name).append("', type='").append(this.type).append("', affinity='").append(this.affinity).append("', notNull=").append(this.notNull);
            charSequence = ((StringBuilder)charSequence).append(", primaryKeyPosition=").append(this.primaryKeyPosition);
            StringBuilder stringBuilder = ((StringBuilder)charSequence).append(", defaultValue='");
            String string2 = this.defaultValue;
            charSequence = string2;
            if (string2 == null) {
                charSequence = "undefined";
            }
            charSequence = stringBuilder.append((String)charSequence);
            return ((StringBuilder)charSequence).append("'}").toString();
        }

        @Metadata(d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0007\u00a8\u0006\t"}, d2={"Landroidx/room/util/TableInfo$Column$Companion;", "", "()V", "containsSurroundingParenthesis", "", "current", "", "defaultValueEquals", "other", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final boolean containsSurroundingParenthesis(String string2) {
                int n = ((CharSequence)string2).length();
                boolean bl = true;
                if ((n = n == 0 ? 1 : 0) != 0) {
                    return false;
                }
                int n2 = 0;
                CharSequence charSequence = string2;
                int n3 = 0;
                int n4 = 0;
                while (n4 < charSequence.length()) {
                    char c = charSequence.charAt(n4);
                    if (n3 == 0 && c != '(') {
                        return false;
                    }
                    if (c == '(') {
                        n = n2 + 1;
                    } else {
                        n = n2--;
                        if (c == ')') {
                            n = n2;
                            if (n2 == 0) {
                                n = n2;
                                if (n3 != string2.length() - 1) {
                                    return false;
                                }
                            }
                        }
                    }
                    ++n4;
                    ++n3;
                    n2 = n;
                }
                if (n2 != 0) {
                    bl = false;
                }
                return bl;
            }

            @JvmStatic
            public final boolean defaultValueEquals(String string2, String string3) {
                Intrinsics.checkNotNullParameter((Object)string2, (String)"current");
                if (Intrinsics.areEqual((Object)string2, (Object)string3)) {
                    return true;
                }
                if (this.containsSurroundingParenthesis(string2)) {
                    string2 = string2.substring(1, string2.length() - 1);
                    Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"this as java.lang.String\u2026ing(startIndex, endIndex)");
                    return Intrinsics.areEqual((Object)((Object)StringsKt.trim((CharSequence)string2)).toString(), (Object)string3);
                }
                return false;
            }
        }
    }

    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Landroidx/room/util/TableInfo$Companion;", "", "()V", "CREATED_FROM_DATABASE", "", "CREATED_FROM_ENTITY", "CREATED_FROM_UNKNOWN", "read", "Landroidx/room/util/TableInfo;", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "tableName", "", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final TableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String string2) {
            Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"database");
            Intrinsics.checkNotNullParameter((Object)string2, (String)"tableName");
            return TableInfoKt.readTableInfo(supportSQLiteDatabase, string2);
        }
    }

    @java.lang.annotation.Retention(value=RetentionPolicy.SOURCE)
    @Metadata(d1={"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2={"Landroidx/room/util/TableInfo$CreatedFrom;", "", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
    @Retention(value=AnnotationRetention.SOURCE)
    public static @interface CreatedFrom {
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Landroidx/room/util/TableInfo$ForeignKey;", "", "referenceTable", "", "onDelete", "onUpdate", "columnNames", "", "referenceColumnNames", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "equals", "", "other", "hashCode", "", "toString", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class ForeignKey {
        public final List<String> columnNames;
        public final String onDelete;
        public final String onUpdate;
        public final List<String> referenceColumnNames;
        public final String referenceTable;

        public ForeignKey(String string2, String string3, String string4, List<String> list, List<String> list2) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"referenceTable");
            Intrinsics.checkNotNullParameter((Object)string3, (String)"onDelete");
            Intrinsics.checkNotNullParameter((Object)string4, (String)"onUpdate");
            Intrinsics.checkNotNullParameter(list, (String)"columnNames");
            Intrinsics.checkNotNullParameter(list2, (String)"referenceColumnNames");
            this.referenceTable = string2;
            this.onDelete = string3;
            this.onUpdate = string4;
            this.columnNames = list;
            this.referenceColumnNames = list2;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            boolean bl = object instanceof ForeignKey;
            boolean bl2 = false;
            if (!bl) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.referenceTable, (Object)((ForeignKey)object).referenceTable)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.onDelete, (Object)((ForeignKey)object).onDelete)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.onUpdate, (Object)((ForeignKey)object).onUpdate)) {
                return false;
            }
            if (Intrinsics.areEqual(this.columnNames, ((ForeignKey)object).columnNames)) {
                bl2 = Intrinsics.areEqual(this.referenceColumnNames, ((ForeignKey)object).referenceColumnNames);
            }
            return bl2;
        }

        public int hashCode() {
            return (((this.referenceTable.hashCode() * 31 + this.onDelete.hashCode()) * 31 + this.onUpdate.hashCode()) * 31 + ((Object)this.columnNames).hashCode()) * 31 + ((Object)this.referenceColumnNames).hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder().append("ForeignKey{referenceTable='").append(this.referenceTable).append("', onDelete='").append(this.onDelete).append(" +', onUpdate='").append(this.onUpdate);
            stringBuilder = stringBuilder.append("', columnNames=").append(this.columnNames);
            return stringBuilder.append(", referenceColumnNames=").append(this.referenceColumnNames).append('}').toString();
        }
    }

    @Metadata(d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\bJ\u0011\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0000H\u0096\u0002R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u00a8\u0006\u0011"}, d2={"Landroidx/room/util/TableInfo$ForeignKeyWithSequence;", "", "id", "", "sequence", "from", "", "to", "(IILjava/lang/String;Ljava/lang/String;)V", "getFrom", "()Ljava/lang/String;", "getId", "()I", "getSequence", "getTo", "compareTo", "other", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class ForeignKeyWithSequence
    implements Comparable<ForeignKeyWithSequence> {
        private final String from;
        private final int id;
        private final int sequence;
        private final String to;

        public ForeignKeyWithSequence(int n, int n2, String string2, String string3) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"from");
            Intrinsics.checkNotNullParameter((Object)string3, (String)"to");
            this.id = n;
            this.sequence = n2;
            this.from = string2;
            this.to = string3;
        }

        @Override
        public int compareTo(ForeignKeyWithSequence foreignKeyWithSequence) {
            int n;
            block0: {
                Intrinsics.checkNotNullParameter((Object)foreignKeyWithSequence, (String)"other");
                n = this.id - foreignKeyWithSequence.id;
                if (n != 0) break block0;
                n = this.sequence - foreignKeyWithSequence.sequence;
            }
            return n;
        }

        public final String getFrom() {
            return this.from;
        }

        public final int getId() {
            return this.id;
        }

        public final int getSequence() {
            return this.sequence;
        }

        public final String getTo() {
            return this.to;
        }
    }

    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\u0002\u0010\bB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Landroidx/room/util/TableInfo$Index;", "", "name", "", "unique", "", "columns", "", "(Ljava/lang/String;ZLjava/util/List;)V", "orders", "(Ljava/lang/String;ZLjava/util/List;Ljava/util/List;)V", "equals", "other", "hashCode", "", "toString", "Companion", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Index {
        public static final Companion Companion = new Companion(null);
        public static final String DEFAULT_PREFIX = "index_";
        public final List<String> columns;
        public final String name;
        public List<String> orders;
        public final boolean unique;

        @Deprecated(message="Use {@link #Index(String, boolean, List, List)}")
        public Index(String string2, boolean bl, List<String> list) {
            Intrinsics.checkNotNullParameter((Object)string2, (String)"name");
            Intrinsics.checkNotNullParameter(list, (String)"columns");
            int n = list.size();
            ArrayList<String> arrayList = new ArrayList<String>(n);
            for (int i = 0; i < n; ++i) {
                arrayList.add(Index.Order.ASC.name());
            }
            this(string2, bl, list, (List<String>)arrayList);
        }

        public Index(String list, boolean bl, List<String> collection, List<String> list2) {
            Intrinsics.checkNotNullParameter((Object)list, (String)"name");
            Intrinsics.checkNotNullParameter(collection, (String)"columns");
            Intrinsics.checkNotNullParameter(list2, (String)"orders");
            this.name = list;
            this.unique = bl;
            this.columns = collection;
            this.orders = list2;
            collection = this.orders;
            list = collection;
            if (collection.isEmpty()) {
                int n = this.columns.size();
                list = new ArrayList<String>(n);
                for (int i = 0; i < n; ++i) {
                    list.add(Index.Order.ASC.name());
                }
                list = list;
            }
            this.orders = list;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof Index)) {
                return false;
            }
            if (this.unique != ((Index)object).unique) {
                return false;
            }
            if (!Intrinsics.areEqual(this.columns, ((Index)object).columns)) {
                return false;
            }
            if (!Intrinsics.areEqual(this.orders, ((Index)object).orders)) {
                return false;
            }
            boolean bl = StringsKt.startsWith$default((String)this.name, (String)DEFAULT_PREFIX, (boolean)false, (int)2, null) ? StringsKt.startsWith$default((String)((Index)object).name, (String)DEFAULT_PREFIX, (boolean)false, (int)2, null) : Intrinsics.areEqual((Object)this.name, (Object)((Index)object).name);
            return bl;
        }

        public int hashCode() {
            int n = StringsKt.startsWith$default((String)this.name, (String)DEFAULT_PREFIX, (boolean)false, (int)2, null) ? DEFAULT_PREFIX.hashCode() : this.name.hashCode();
            return ((n * 31 + this.unique) * 31 + ((Object)this.columns).hashCode()) * 31 + ((Object)this.orders).hashCode();
        }

        public String toString() {
            return "Index{name='" + this.name + "', unique=" + this.unique + ", columns=" + this.columns + ", orders=" + this.orders + "'}";
        }

        @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2={"Landroidx/room/util/TableInfo$Index$Companion;", "", "()V", "DEFAULT_PREFIX", "", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }
}

