/*
 * Decompiled with CFR 0.152.
 */
package androidx.room.migration;

import androidx.sqlite.db.SupportSQLiteDatabase;

public interface AutoMigrationSpec {
    default public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
    }
}

