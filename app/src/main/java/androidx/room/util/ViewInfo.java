/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  kotlin.Metadata
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.room.util;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Landroidx/room/util/ViewInfo;", "", "name", "", "sql", "(Ljava/lang/String;Ljava/lang/String;)V", "equals", "", "other", "hashCode", "", "toString", "Companion", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
public final class ViewInfo {
    public static final Companion Companion = new Companion(null);
    public final String name;
    public final String sql;

    public ViewInfo(String string2, String string3) {
        Intrinsics.checkNotNullParameter((Object)string2, (String)"name");
        this.name = string2;
        this.sql = string3;
    }

    @JvmStatic
    public static final ViewInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String string2) {
        return Companion.read(supportSQLiteDatabase, string2);
    }

    public boolean equals(Object object) {
        boolean bl;
        boolean bl2 = true;
        if (this == object) {
            return true;
        }
        if (!(object instanceof ViewInfo)) {
            return false;
        }
        bl = Intrinsics.areEqual((Object)this.name, (Object)((ViewInfo)object).name) && (bl = this.sql != null ? Intrinsics.areEqual((Object)this.sql, (Object)((ViewInfo)object).sql) : ((ViewInfo)object).sql == null) ? bl2 : false;
        return bl;
    }

    public int hashCode() {
        int n = this.name.hashCode();
        String string2 = this.sql;
        int n2 = string2 != null ? string2.hashCode() : 0;
        return n * 31 + n2;
    }

    public String toString() {
        return "ViewInfo{name='" + this.name + "', sql='" + this.sql + "'}";
    }

    @Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2={"Landroidx/room/util/ViewInfo$Companion;", "", "()V", "read", "Landroidx/room/util/ViewInfo;", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "viewName", "", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ViewInfo read(SupportSQLiteDatabase object, String string2) {
            Object object2;
            block5: {
                Intrinsics.checkNotNullParameter((Object)object, (String)"database");
                Intrinsics.checkNotNullParameter((Object)string2, (String)"viewName");
                object2 = new StringBuilder().append("SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '");
                object = object.query(((StringBuilder)object2).append(string2).append('\'').toString());
                object2 = (Closeable)object;
                try {
                    object = (Cursor)object2;
                    if (object.moveToFirst()) {
                        string2 = object.getString(0);
                        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"cursor.getString(0)");
                        object = new ViewInfo(string2, object.getString(1));
                        break block5;
                    }
                    object = new ViewInfo(string2, null);
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
            }
            CloseableKt.closeFinally((Closeable)object2, null);
            return object;
        }
    }
}

