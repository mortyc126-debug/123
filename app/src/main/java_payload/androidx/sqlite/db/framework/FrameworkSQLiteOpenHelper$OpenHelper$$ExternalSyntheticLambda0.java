/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.DatabaseErrorHandler
 *  android.database.sqlite.SQLiteDatabase
 */
package androidx.sqlite.db.framework;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;

public final class FrameworkSQLiteOpenHelper$OpenHelper$$ExternalSyntheticLambda0
implements DatabaseErrorHandler {
    public final SupportSQLiteOpenHelper.Callback f$0;
    public final FrameworkSQLiteOpenHelper.DBRefHolder f$1;

    public /* synthetic */ FrameworkSQLiteOpenHelper$OpenHelper$$ExternalSyntheticLambda0(SupportSQLiteOpenHelper.Callback callback2, FrameworkSQLiteOpenHelper.DBRefHolder dBRefHolder) {
        this.f$0 = callback2;
        this.f$1 = dBRefHolder;
    }

    public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
        FrameworkSQLiteOpenHelper.OpenHelper.$r8$lambda$wesXNSdtx2gMKZWCPManFjtpLB8(this.f$0, this.f$1, sQLiteDatabase);
    }
}

