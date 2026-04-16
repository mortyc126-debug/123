/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 */
package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

@Metadata(d1={"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00010\u0006\u00a2\u0006\u0002\b\u0007H\u0086\b\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2={"transaction", "T", "Landroid/database/sqlite/SQLiteDatabase;", "exclusive", "", "body", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroid/database/sqlite/SQLiteDatabase;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "core-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class SQLiteDatabaseKt {
    public static final <T> T transaction(SQLiteDatabase sQLiteDatabase, boolean bl, Function1<? super SQLiteDatabase, ? extends T> object) {
        if (bl) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            object = object.invoke((Object)sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return (T)object;
        }
        finally {
            InlineMarker.finallyStart((int)1);
            sQLiteDatabase.endTransaction();
            InlineMarker.finallyEnd((int)1);
        }
    }

    public static /* synthetic */ Object transaction$default(SQLiteDatabase sQLiteDatabase, boolean bl, Function1 object, int n, Object object2) {
        if ((n & 1) != 0) {
            bl = true;
        }
        if (bl) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            object = object.invoke((Object)sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return object;
        }
        finally {
            InlineMarker.finallyStart((int)1);
            sQLiteDatabase.endTransaction();
            InlineMarker.finallyEnd((int)1);
        }
    }
}

