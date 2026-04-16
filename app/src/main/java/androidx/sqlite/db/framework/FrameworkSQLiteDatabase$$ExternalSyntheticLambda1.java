/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteCursorDriver
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteQuery
 *  kotlin.jvm.functions.Function4
 */
package androidx.sqlite.db.framework;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import kotlin.jvm.functions.Function4;

public final class FrameworkSQLiteDatabase$$ExternalSyntheticLambda1
implements SQLiteDatabase.CursorFactory {
    public final Function4 f$0;

    public /* synthetic */ FrameworkSQLiteDatabase$$ExternalSyntheticLambda1(Function4 function4) {
        this.f$0 = function4;
    }

    public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String string2, SQLiteQuery sQLiteQuery) {
        return FrameworkSQLiteDatabase.$r8$lambda$xWs7VTYEzeAWyi_2-SJixQ1HyKQ(this.f$0, sQLiteDatabase, sQLiteCursorDriver, string2, sQLiteQuery);
    }
}

