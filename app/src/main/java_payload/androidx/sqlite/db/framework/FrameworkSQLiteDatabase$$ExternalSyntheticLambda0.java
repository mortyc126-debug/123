/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteCursorDriver
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteQuery
 */
package androidx.sqlite.db.framework;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;

public final class FrameworkSQLiteDatabase$$ExternalSyntheticLambda0
implements SQLiteDatabase.CursorFactory {
    public final SupportSQLiteQuery f$0;

    public /* synthetic */ FrameworkSQLiteDatabase$$ExternalSyntheticLambda0(SupportSQLiteQuery supportSQLiteQuery) {
        this.f$0 = supportSQLiteQuery;
    }

    public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String string2, SQLiteQuery sQLiteQuery) {
        return FrameworkSQLiteDatabase.$r8$lambda$BFGJjdMOCDz5XPIMAR1G27bXFjU(this.f$0, sQLiteDatabase, sQLiteCursorDriver, string2, sQLiteQuery);
    }
}

