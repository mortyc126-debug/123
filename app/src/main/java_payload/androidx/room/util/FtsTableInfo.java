/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 */
package androidx.room.util;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.io.Closeable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Landroidx/room/util/FtsTableInfo;", "", "name", "", "columns", "", "createSql", "(Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;)V", "options", "(Ljava/lang/String;Ljava/util/Set;Ljava/util/Set;)V", "equals", "", "other", "hashCode", "", "toString", "Companion", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
public final class FtsTableInfo {
    public static final Companion Companion = new Companion(null);
    private static final String[] FTS_OPTIONS = new String[]{"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};
    public final Set<String> columns;
    public final String name;
    public final Set<String> options;

    public FtsTableInfo(String string2, Set<String> set, String string3) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"name");
        Intrinsics.checkNotNullParameter(set, (String)"columns");
        Intrinsics.checkNotNullParameter((Object)string3, (String)"createSql");
        this(string2, set, Companion.parseOptions(string3));
    }

    public FtsTableInfo(String string2, Set<String> set, Set<String> set2) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"name");
        Intrinsics.checkNotNullParameter(set, (String)"columns");
        Intrinsics.checkNotNullParameter(set2, (String)"options");
        this.name = string2;
        this.columns = set;
        this.options = set2;
    }

    @JvmStatic
    public static final Set<String> parseOptions(String string2) {
        return Companion.parseOptions(string2);
    }

    @JvmStatic
    public static final FtsTableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String string2) {
        return Companion.read(supportSQLiteDatabase, string2);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof FtsTableInfo)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.name, (Object)((FtsTableInfo)object).name)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.columns, ((FtsTableInfo)object).columns)) {
            return false;
        }
        return Intrinsics.areEqual(this.options, ((FtsTableInfo)object).options);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31 + ((Object)this.columns).hashCode()) * 31 + ((Object)this.options).hashCode();
    }

    public String toString() {
        return "FtsTableInfo{name='" + this.name + "', columns=" + this.columns + ", options=" + this.options + "'}";
    }

    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\u0005H\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0007J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006\u0011"}, d2={"Landroidx/room/util/FtsTableInfo$Companion;", "", "()V", "FTS_OPTIONS", "", "", "[Ljava/lang/String;", "parseOptions", "", "createStatement", "read", "Landroidx/room/util/FtsTableInfo;", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "tableName", "readColumns", "readOptions", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Set<String> readColumns(SupportSQLiteDatabase closeable, String string2) {
            Set set = SetsKt.createSetBuilder();
            closeable = closeable.query("PRAGMA table_info(`" + string2 + "`)");
            closeable = closeable;
            try {
                Cursor cursor = (Cursor)closeable;
                if (cursor.getColumnCount() > 0) {
                    int n = cursor.getColumnIndex("name");
                    while (cursor.moveToNext()) {
                        string2 = cursor.getString(n);
                        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"cursor.getString(nameIndex)");
                        set.add(string2);
                    }
                }
                string2 = Unit.INSTANCE;
            }
            catch (Throwable throwable) {
                try {
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
                    throw throwable2;
                }
            }
            CloseableKt.closeFinally((Closeable)closeable, null);
            return SetsKt.build((Set)set);
        }

        private final Set<String> readOptions(SupportSQLiteDatabase object, String object2) {
            block6: {
                block5: {
                    object = object.query("SELECT * FROM sqlite_master WHERE `name` = '" + (String)object2 + '\'');
                    object2 = (Closeable)object;
                    try {
                        object = (Cursor)object2;
                        boolean bl = object.moveToFirst();
                        if (!bl) break block5;
                    }
                    catch (Throwable throwable) {
                        try {
                            throw throwable;
                        }
                        catch (Throwable throwable2) {
                            CloseableKt.closeFinally((Closeable)object2, (Throwable)throwable);
                            throw throwable2;
                        }
                    }
                    object = object.getString(object.getColumnIndexOrThrow("sql"));
                    break block6;
                }
                object = "";
            }
            CloseableKt.closeFinally((Closeable)object2, null);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"sql");
            return this.parseOptions((String)object);
        }

        /*
         * Enabled aggressive block sorting
         */
        @JvmStatic
        public final Set<String> parseOptions(String object) {
            String[] stringArray;
            Object object2;
            Intrinsics.checkNotNullParameter((Object)object, (String)"createStatement");
            int n = ((CharSequence)object).length();
            int n2 = 1;
            n = n == 0 ? 1 : 0;
            if (n != 0) {
                return SetsKt.emptySet();
            }
            String string2 = ((String)object).substring(StringsKt.indexOf$default((CharSequence)((CharSequence)object), (char)'(', (int)0, (boolean)false, (int)6, null) + 1, StringsKt.lastIndexOf$default((CharSequence)((CharSequence)object), (char)')', (int)0, (boolean)false, (int)6, null));
            Object object3 = "this as java.lang.String\u2026ing(startIndex, endIndex)";
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"this as java.lang.String\u2026ing(startIndex, endIndex)");
            Object object4 = new ArrayList();
            object = new ArrayDeque();
            int n3 = -1;
            Object object5 = string2;
            int n4 = 0;
            int n5 = 0;
            n = n2;
            while (true) {
                block22: {
                    char c;
                    block24: {
                        if (n5 >= object5.length()) break;
                        c = object5.charAt(n5);
                        n2 = c == '\'' || c == '\"' ? n : 0;
                        if ((n2 = n2 != 0 || c == '`' ? n : 0) == 0) break block24;
                        if (((ArrayDeque)object).isEmpty()) {
                            ((ArrayDeque)object).push(Character.valueOf(c));
                            object2 = object;
                            object = object3;
                            object3 = object2;
                            break block22;
                        } else {
                            object2 = (Character)((ArrayDeque)object).peek();
                            if (object2 != null && ((Character)object2).charValue() == c) {
                                ((ArrayDeque)object).pop();
                                object2 = object3;
                                object3 = object;
                                object = object2;
                                break block22;
                            } else {
                                object2 = object;
                                object = object3;
                                object3 = object2;
                            }
                        }
                        break block22;
                    }
                    if (c == '[') {
                        if (((ArrayDeque)object).isEmpty()) {
                            ((ArrayDeque)object).push(Character.valueOf(c));
                            object2 = object3;
                            object3 = object;
                            object = object2;
                        } else {
                            object2 = object;
                            object = object3;
                            object3 = object2;
                        }
                    } else if (c == ']') {
                        if (!((ArrayDeque)object).isEmpty() && (object2 = (Character)((ArrayDeque)object).peek()) != null && ((Character)object2).charValue() == '[') {
                            ((ArrayDeque)object).pop();
                            object2 = object3;
                            object3 = object;
                            n = 1;
                            object = object2;
                        } else {
                            object2 = object;
                            n = 1;
                            object = object3;
                            object3 = object2;
                        }
                    } else if (c != ',' || !((ArrayDeque)object).isEmpty()) {
                        object2 = object3;
                        n = 1;
                        object3 = object;
                        object = object2;
                    } else {
                        object2 = string2.substring(n3 + 1, n4);
                        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)object3);
                        stringArray = (String[])object2;
                        n = stringArray.length();
                        int n6 = 1;
                        n2 = 0;
                        n3 = 0;
                        --n;
                        while (n3 <= n) {
                            int n7 = n2 == 0 ? n3 : n;
                            n7 = Intrinsics.compare((int)stringArray.charAt(n7), (int)32) <= 0 ? 1 : 0;
                            if (n2 == 0) {
                                if (n7 == 0) {
                                    n2 = 1;
                                    continue;
                                }
                                ++n3;
                                continue;
                            }
                            if (n7 == 0) break;
                            --n;
                        }
                        object2 = object;
                        object = object3;
                        object4.add(((Object)stringArray.subSequence(n3, n + 1)).toString());
                        n3 = n4;
                        n = n6;
                        object3 = object2;
                    }
                }
                ++n5;
                ++n4;
                object2 = object3;
                object3 = object;
                object = object2;
            }
            object = string2.substring(n3 + 1);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"this as java.lang.String).substring(startIndex)");
            object4.add(((Object)StringsKt.trim((CharSequence)((CharSequence)object))).toString());
            object3 = (Iterable)object4;
            boolean bl = false;
            object5 = new ArrayList();
            object2 = object3;
            object4 = object2.iterator();
            object = string2;
            while (true) {
                Object e;
                block23: {
                    if (!object4.hasNext()) {
                        object = (List)object5;
                        return CollectionsKt.toSet((Iterable)((Iterable)object));
                    }
                    e = object4.next();
                    string2 = (String)e;
                    stringArray = FTS_OPTIONS;
                    n3 = stringArray.length;
                    for (n4 = 0; n4 < n3; ++n4) {
                        if (!StringsKt.startsWith$default((String)string2, (String)stringArray[n4], (boolean)false, (int)2, null)) continue;
                        n4 = n;
                        break block23;
                    }
                    n4 = 0;
                }
                if (n4 == 0) continue;
                object5.add(e);
            }
        }

        @JvmStatic
        public final FtsTableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String string2) {
            Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"database");
            Intrinsics.checkNotNullParameter((Object)string2, (String)"tableName");
            return new FtsTableInfo(string2, this.readColumns(supportSQLiteDatabase, string2), this.readOptions(supportSQLiteDatabase, string2));
        }
    }
}

