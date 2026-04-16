/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteOpenHelper
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.CancellationSignal
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.sqlite.db;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\b"}, d2={"Landroidx/sqlite/db/SupportSQLiteCompat;", "", "()V", "Api16Impl", "Api19Impl", "Api21Impl", "Api23Impl", "Api29Impl", "sqlite_release"}, k=1, mv={1, 7, 1}, xi=48)
public final class SupportSQLiteCompat {
    private SupportSQLiteCompat() {
    }

    @Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0007JI\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0010\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00130\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0007\u00a2\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\tH\u0007J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\tH\u0007\u00a8\u0006 "}, d2={"Landroidx/sqlite/db/SupportSQLiteCompat$Api16Impl;", "", "()V", "cancel", "", "cancellationSignal", "Landroid/os/CancellationSignal;", "createCancellationSignal", "deleteDatabase", "", "file", "Ljava/io/File;", "disableWriteAheadLogging", "sQLiteDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "isWriteAheadLoggingEnabled", "rawQueryWithFactory", "Landroid/database/Cursor;", "sql", "", "selectionArgs", "", "editTable", "cursorFactory", "Landroid/database/sqlite/SQLiteDatabase$CursorFactory;", "(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/os/CancellationSignal;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/Cursor;", "setForeignKeyConstraintsEnabled", "enable", "setWriteAheadLoggingEnabled", "sQLiteOpenHelper", "Landroid/database/sqlite/SQLiteOpenHelper;", "enabled", "sqlite_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Api16Impl {
        public static final Api16Impl INSTANCE = new Api16Impl();

        private Api16Impl() {
        }

        @JvmStatic
        public static final void cancel(CancellationSignal cancellationSignal) {
            Intrinsics.checkNotNullParameter((Object)cancellationSignal, (String)"cancellationSignal");
            cancellationSignal.cancel();
        }

        @JvmStatic
        public static final CancellationSignal createCancellationSignal() {
            return new CancellationSignal();
        }

        @JvmStatic
        public static final boolean deleteDatabase(File file) {
            Intrinsics.checkNotNullParameter((Object)file, (String)"file");
            return SQLiteDatabase.deleteDatabase((File)file);
        }

        @JvmStatic
        public static final void disableWriteAheadLogging(SQLiteDatabase sQLiteDatabase) {
            Intrinsics.checkNotNullParameter((Object)sQLiteDatabase, (String)"sQLiteDatabase");
            sQLiteDatabase.disableWriteAheadLogging();
        }

        @JvmStatic
        public static final boolean isWriteAheadLoggingEnabled(SQLiteDatabase sQLiteDatabase) {
            Intrinsics.checkNotNullParameter((Object)sQLiteDatabase, (String)"sQLiteDatabase");
            return sQLiteDatabase.isWriteAheadLoggingEnabled();
        }

        @JvmStatic
        public static final Cursor rawQueryWithFactory(SQLiteDatabase sQLiteDatabase, String string2, String[] stringArray, String string3, CancellationSignal cancellationSignal, SQLiteDatabase.CursorFactory cursorFactory2) {
            Intrinsics.checkNotNullParameter((Object)sQLiteDatabase, (String)"sQLiteDatabase");
            Intrinsics.checkNotNullParameter((Object)string2, (String)"sql");
            Intrinsics.checkNotNullParameter((Object)stringArray, (String)"selectionArgs");
            Intrinsics.checkNotNullParameter((Object)cancellationSignal, (String)"cancellationSignal");
            Intrinsics.checkNotNullParameter((Object)cursorFactory2, (String)"cursorFactory");
            sQLiteDatabase = sQLiteDatabase.rawQueryWithFactory(cursorFactory2, string2, stringArray, string3, cancellationSignal);
            Intrinsics.checkNotNullExpressionValue((Object)sQLiteDatabase, (String)"sQLiteDatabase.rawQueryW\u2026ationSignal\n            )");
            return sQLiteDatabase;
        }

        @JvmStatic
        public static final void setForeignKeyConstraintsEnabled(SQLiteDatabase sQLiteDatabase, boolean bl) {
            Intrinsics.checkNotNullParameter((Object)sQLiteDatabase, (String)"sQLiteDatabase");
            sQLiteDatabase.setForeignKeyConstraintsEnabled(bl);
        }

        @JvmStatic
        public static final void setWriteAheadLoggingEnabled(SQLiteOpenHelper sQLiteOpenHelper, boolean bl) {
            Intrinsics.checkNotNullParameter((Object)sQLiteOpenHelper, (String)"sQLiteOpenHelper");
            sQLiteOpenHelper.setWriteAheadLoggingEnabled(bl);
        }
    }

    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007\u00a8\u0006\u000b"}, d2={"Landroidx/sqlite/db/SupportSQLiteCompat$Api19Impl;", "", "()V", "getNotificationUri", "Landroid/net/Uri;", "cursor", "Landroid/database/Cursor;", "isLowRamDevice", "", "activityManager", "Landroid/app/ActivityManager;", "sqlite_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Api19Impl {
        public static final Api19Impl INSTANCE = new Api19Impl();

        private Api19Impl() {
        }

        @JvmStatic
        public static final Uri getNotificationUri(Cursor cursor) {
            Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
            cursor = cursor.getNotificationUri();
            Intrinsics.checkNotNullExpressionValue((Object)cursor, (String)"cursor.notificationUri");
            return cursor;
        }

        @JvmStatic
        public static final boolean isLowRamDevice(ActivityManager activityManager) {
            Intrinsics.checkNotNullParameter((Object)activityManager, (String)"activityManager");
            return activityManager.isLowRamDevice();
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2={"Landroidx/sqlite/db/SupportSQLiteCompat$Api21Impl;", "", "()V", "getNoBackupFilesDir", "Ljava/io/File;", "context", "Landroid/content/Context;", "sqlite_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Api21Impl {
        public static final Api21Impl INSTANCE = new Api21Impl();

        private Api21Impl() {
        }

        @JvmStatic
        public static final File getNoBackupFilesDir(Context object) {
            Intrinsics.checkNotNullParameter((Object)object, (String)"context");
            object = object.getNoBackupFilesDir();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"context.noBackupFilesDir");
            return object;
        }
    }

    @Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2={"Landroidx/sqlite/db/SupportSQLiteCompat$Api23Impl;", "", "()V", "setExtras", "", "cursor", "Landroid/database/Cursor;", "extras", "Landroid/os/Bundle;", "sqlite_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Api23Impl {
        public static final Api23Impl INSTANCE = new Api23Impl();

        private Api23Impl() {
        }

        @JvmStatic
        public static final void setExtras(Cursor cursor, Bundle bundle) {
            Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
            Intrinsics.checkNotNullParameter((Object)bundle, (String)"extras");
            cursor.setExtras(bundle);
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J(\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0007\u00a8\u0006\r"}, d2={"Landroidx/sqlite/db/SupportSQLiteCompat$Api29Impl;", "", "()V", "getNotificationUris", "", "Landroid/net/Uri;", "cursor", "Landroid/database/Cursor;", "setNotificationUris", "", "cr", "Landroid/content/ContentResolver;", "uris", "sqlite_release"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class Api29Impl {
        public static final Api29Impl INSTANCE = new Api29Impl();

        private Api29Impl() {
        }

        @JvmStatic
        public static final List<Uri> getNotificationUris(Cursor object) {
            Intrinsics.checkNotNullParameter((Object)object, (String)"cursor");
            object = object.getNotificationUris();
            Intrinsics.checkNotNull((Object)object);
            return object;
        }

        @JvmStatic
        public static final void setNotificationUris(Cursor cursor, ContentResolver contentResolver, List<? extends Uri> list) {
            Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
            Intrinsics.checkNotNullParameter((Object)contentResolver, (String)"cr");
            Intrinsics.checkNotNullParameter(list, (String)"uris");
            cursor.setNotificationUris(contentResolver, list);
        }
    }
}

