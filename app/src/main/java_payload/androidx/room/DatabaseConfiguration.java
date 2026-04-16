/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.room;

import android.content.Context;
import android.content.Intent;
import androidx.room.MultiInstanceInvalidationService;
import androidx.room.RoomDatabase;
import androidx.room.migration.AutoMigrationSpec;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001Bi\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u00a2\u0006\u0002\u0010\u0017B\u0081\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u00a2\u0006\u0002\u0010\u001bB\u0095\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0002\u0010\u001fB\u00a5\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!\u00a2\u0006\u0002\u0010#B\u00af\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!\u0012\b\u0010$\u001a\u0004\u0018\u00010%\u00a2\u0006\u0002\u0010&B\u00bd\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!\u0012\b\u0010$\u001a\u0004\u0018\u00010%\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b\u00a2\u0006\u0002\u0010(B\u00cb\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!\u0012\b\u0010$\u001a\u0004\u0018\u00010%\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u000b\u00a2\u0006\u0002\u0010+B\u00cd\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0012\u0012\b\u0010,\u001a\u0004\u0018\u00010-\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!\u0012\b\u0010$\u001a\u0004\u0018\u00010%\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u000b\u00a2\u0006\u0002\u0010.J\u0018\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u00020\u0016H\u0016J\u0010\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u0016H\u0017R\u0010\u0010\u001a\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010,\u001a\u0004\u0018\u00010-8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2={"Landroidx/room/DatabaseConfiguration;", "", "context", "Landroid/content/Context;", "name", "", "sqliteOpenHelperFactory", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;", "migrationContainer", "Landroidx/room/RoomDatabase$MigrationContainer;", "callbacks", "", "Landroidx/room/RoomDatabase$Callback;", "allowMainThreadQueries", "", "journalMode", "Landroidx/room/RoomDatabase$JournalMode;", "queryExecutor", "Ljava/util/concurrent/Executor;", "requireMigration", "migrationNotRequiredFrom", "", "", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Landroidx/room/RoomDatabase$MigrationContainer;Ljava/util/List;ZLandroidx/room/RoomDatabase$JournalMode;Ljava/util/concurrent/Executor;ZLjava/util/Set;)V", "transactionExecutor", "multiInstanceInvalidation", "allowDestructiveMigrationOnDowngrade", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Landroidx/room/RoomDatabase$MigrationContainer;Ljava/util/List;ZLandroidx/room/RoomDatabase$JournalMode;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;ZZZLjava/util/Set;)V", "copyFromAssetPath", "copyFromFile", "Ljava/io/File;", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Landroidx/room/RoomDatabase$MigrationContainer;Ljava/util/List;ZLandroidx/room/RoomDatabase$JournalMode;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;ZZZLjava/util/Set;Ljava/lang/String;Ljava/io/File;)V", "copyFromInputStream", "Ljava/util/concurrent/Callable;", "Ljava/io/InputStream;", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Landroidx/room/RoomDatabase$MigrationContainer;Ljava/util/List;ZLandroidx/room/RoomDatabase$JournalMode;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;ZZZLjava/util/Set;Ljava/lang/String;Ljava/io/File;Ljava/util/concurrent/Callable;)V", "prepackagedDatabaseCallback", "Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Landroidx/room/RoomDatabase$MigrationContainer;Ljava/util/List;ZLandroidx/room/RoomDatabase$JournalMode;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;ZZZLjava/util/Set;Ljava/lang/String;Ljava/io/File;Ljava/util/concurrent/Callable;Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;)V", "typeConverters", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Landroidx/room/RoomDatabase$MigrationContainer;Ljava/util/List;ZLandroidx/room/RoomDatabase$JournalMode;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;ZZZLjava/util/Set;Ljava/lang/String;Ljava/io/File;Ljava/util/concurrent/Callable;Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;Ljava/util/List;)V", "autoMigrationSpecs", "Landroidx/room/migration/AutoMigrationSpec;", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Landroidx/room/RoomDatabase$MigrationContainer;Ljava/util/List;ZLandroidx/room/RoomDatabase$JournalMode;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;ZZZLjava/util/Set;Ljava/lang/String;Ljava/io/File;Ljava/util/concurrent/Callable;Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;Ljava/util/List;Ljava/util/List;)V", "multiInstanceInvalidationServiceIntent", "Landroid/content/Intent;", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Landroidx/room/RoomDatabase$MigrationContainer;Ljava/util/List;ZLandroidx/room/RoomDatabase$JournalMode;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Landroid/content/Intent;ZZLjava/util/Set;Ljava/lang/String;Ljava/io/File;Ljava/util/concurrent/Callable;Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;Ljava/util/List;Ljava/util/List;)V", "isMigrationRequired", "fromVersion", "toVersion", "isMigrationRequiredFrom", "version", "room-runtime_release"}, k=1, mv={1, 7, 1}, xi=48)
public class DatabaseConfiguration {
    public final boolean allowDestructiveMigrationOnDowngrade;
    public final boolean allowMainThreadQueries;
    public final List<AutoMigrationSpec> autoMigrationSpecs;
    public final List<RoomDatabase.Callback> callbacks;
    public final Context context;
    public final String copyFromAssetPath;
    public final File copyFromFile;
    public final Callable<InputStream> copyFromInputStream;
    public final RoomDatabase.JournalMode journalMode;
    public final RoomDatabase.MigrationContainer migrationContainer;
    private final Set<Integer> migrationNotRequiredFrom;
    public final boolean multiInstanceInvalidation;
    public final Intent multiInstanceInvalidationServiceIntent;
    public final String name;
    public final RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback;
    public final Executor queryExecutor;
    public final boolean requireMigration;
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;
    public final Executor transactionExecutor;
    public final List<Object> typeConverters;

    public DatabaseConfiguration(Context context, String string2, SupportSQLiteOpenHelper.Factory factory2, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean bl, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, Intent intent, boolean bl2, boolean bl3, Set<Integer> set, String string3, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, List<? extends Object> list2, List<? extends AutoMigrationSpec> list3) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)factory2, (String)"sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter((Object)migrationContainer, (String)"migrationContainer");
        Intrinsics.checkNotNullParameter((Object)((Object)journalMode), (String)"journalMode");
        Intrinsics.checkNotNullParameter((Object)executor, (String)"queryExecutor");
        Intrinsics.checkNotNullParameter((Object)executor2, (String)"transactionExecutor");
        Intrinsics.checkNotNullParameter(list2, (String)"typeConverters");
        Intrinsics.checkNotNullParameter(list3, (String)"autoMigrationSpecs");
        this.context = context;
        this.name = string2;
        this.sqliteOpenHelperFactory = factory2;
        this.migrationContainer = migrationContainer;
        this.callbacks = list;
        this.allowMainThreadQueries = bl;
        this.journalMode = journalMode;
        this.queryExecutor = executor;
        this.transactionExecutor = executor2;
        this.multiInstanceInvalidationServiceIntent = intent;
        this.requireMigration = bl2;
        this.allowDestructiveMigrationOnDowngrade = bl3;
        this.migrationNotRequiredFrom = set;
        this.copyFromAssetPath = string3;
        this.copyFromFile = file;
        this.copyFromInputStream = callable;
        this.prepackagedDatabaseCallback = prepackagedDatabaseCallback;
        this.typeConverters = list2;
        this.autoMigrationSpecs = list3;
        bl = this.multiInstanceInvalidationServiceIntent != null;
        this.multiInstanceInvalidation = bl;
    }

    @Deprecated(message="This constructor is deprecated.", replaceWith=@ReplaceWith(expression="DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports={}))
    public DatabaseConfiguration(Context context, String string2, SupportSQLiteOpenHelper.Factory factory2, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean bl, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, boolean bl2, boolean bl3, boolean bl4, Set<Integer> set) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)factory2, (String)"sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter((Object)migrationContainer, (String)"migrationContainer");
        Intrinsics.checkNotNullParameter((Object)((Object)journalMode), (String)"journalMode");
        Intrinsics.checkNotNullParameter((Object)executor, (String)"queryExecutor");
        Intrinsics.checkNotNullParameter((Object)executor2, (String)"transactionExecutor");
        Intent intent = bl2 ? new Intent(context, MultiInstanceInvalidationService.class) : null;
        List list2 = CollectionsKt.emptyList();
        List list3 = CollectionsKt.emptyList();
        this(context, string2, factory2, migrationContainer, list, bl, journalMode, executor, executor2, intent, bl3, bl4, set, null, null, null, null, (List<? extends Object>)list2, (List<? extends AutoMigrationSpec>)list3);
    }

    @Deprecated(message="This constructor is deprecated.", replaceWith=@ReplaceWith(expression="DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports={}))
    public DatabaseConfiguration(Context context, String string2, SupportSQLiteOpenHelper.Factory factory2, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean bl, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, boolean bl2, boolean bl3, boolean bl4, Set<Integer> set, String string3, File file) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)factory2, (String)"sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter((Object)migrationContainer, (String)"migrationContainer");
        Intrinsics.checkNotNullParameter((Object)((Object)journalMode), (String)"journalMode");
        Intrinsics.checkNotNullParameter((Object)executor, (String)"queryExecutor");
        Intrinsics.checkNotNullParameter((Object)executor2, (String)"transactionExecutor");
        Intent intent = bl2 ? new Intent(context, MultiInstanceInvalidationService.class) : null;
        List list2 = CollectionsKt.emptyList();
        List list3 = CollectionsKt.emptyList();
        this(context, string2, factory2, migrationContainer, list, bl, journalMode, executor, executor2, intent, bl3, bl4, set, string3, file, null, null, (List<? extends Object>)list2, (List<? extends AutoMigrationSpec>)list3);
    }

    @Deprecated(message="This constructor is deprecated.", replaceWith=@ReplaceWith(expression="DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports={}))
    public DatabaseConfiguration(Context context, String string2, SupportSQLiteOpenHelper.Factory factory2, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean bl, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, boolean bl2, boolean bl3, boolean bl4, Set<Integer> set, String string3, File file, Callable<InputStream> callable) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)factory2, (String)"sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter((Object)migrationContainer, (String)"migrationContainer");
        Intrinsics.checkNotNullParameter((Object)((Object)journalMode), (String)"journalMode");
        Intrinsics.checkNotNullParameter((Object)executor, (String)"queryExecutor");
        Intrinsics.checkNotNullParameter((Object)executor2, (String)"transactionExecutor");
        Intent intent = bl2 ? new Intent(context, MultiInstanceInvalidationService.class) : null;
        List list2 = CollectionsKt.emptyList();
        List list3 = CollectionsKt.emptyList();
        this(context, string2, factory2, migrationContainer, list, bl, journalMode, executor, executor2, intent, bl3, bl4, set, string3, file, callable, null, (List<? extends Object>)list2, (List<? extends AutoMigrationSpec>)list3);
    }

    @Deprecated(message="This constructor is deprecated.", replaceWith=@ReplaceWith(expression="DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports={}))
    public DatabaseConfiguration(Context context, String string2, SupportSQLiteOpenHelper.Factory factory2, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean bl, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, boolean bl2, boolean bl3, boolean bl4, Set<Integer> set, String string3, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)factory2, (String)"sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter((Object)migrationContainer, (String)"migrationContainer");
        Intrinsics.checkNotNullParameter((Object)((Object)journalMode), (String)"journalMode");
        Intrinsics.checkNotNullParameter((Object)executor, (String)"queryExecutor");
        Intrinsics.checkNotNullParameter((Object)executor2, (String)"transactionExecutor");
        Intent intent = bl2 ? new Intent(context, MultiInstanceInvalidationService.class) : null;
        List list2 = CollectionsKt.emptyList();
        List list3 = CollectionsKt.emptyList();
        this(context, string2, factory2, migrationContainer, list, bl, journalMode, executor, executor2, intent, bl3, bl4, set, string3, file, callable, prepackagedDatabaseCallback, (List<? extends Object>)list2, (List<? extends AutoMigrationSpec>)list3);
    }

    @Deprecated(message="This constructor is deprecated.", replaceWith=@ReplaceWith(expression="DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports={}))
    public DatabaseConfiguration(Context context, String string2, SupportSQLiteOpenHelper.Factory factory2, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean bl, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, boolean bl2, boolean bl3, boolean bl4, Set<Integer> set, String string3, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, List<? extends Object> list2) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)factory2, (String)"sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter((Object)migrationContainer, (String)"migrationContainer");
        Intrinsics.checkNotNullParameter((Object)((Object)journalMode), (String)"journalMode");
        Intrinsics.checkNotNullParameter((Object)executor, (String)"queryExecutor");
        Intrinsics.checkNotNullParameter((Object)executor2, (String)"transactionExecutor");
        Intrinsics.checkNotNullParameter(list2, (String)"typeConverters");
        Intent intent = bl2 ? new Intent(context, MultiInstanceInvalidationService.class) : null;
        List list3 = CollectionsKt.emptyList();
        this(context, string2, factory2, migrationContainer, list, bl, journalMode, executor, executor2, intent, bl3, bl4, set, string3, file, callable, prepackagedDatabaseCallback, list2, (List<? extends AutoMigrationSpec>)list3);
    }

    @Deprecated(message="This constructor is deprecated.", replaceWith=@ReplaceWith(expression="DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports={}))
    public DatabaseConfiguration(Context context, String string2, SupportSQLiteOpenHelper.Factory factory2, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean bl, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, boolean bl2, boolean bl3, boolean bl4, Set<Integer> set, String string3, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, List<? extends Object> list2, List<? extends AutoMigrationSpec> list3) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)factory2, (String)"sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter((Object)migrationContainer, (String)"migrationContainer");
        Intrinsics.checkNotNullParameter((Object)((Object)journalMode), (String)"journalMode");
        Intrinsics.checkNotNullParameter((Object)executor, (String)"queryExecutor");
        Intrinsics.checkNotNullParameter((Object)executor2, (String)"transactionExecutor");
        Intrinsics.checkNotNullParameter(list2, (String)"typeConverters");
        Intrinsics.checkNotNullParameter(list3, (String)"autoMigrationSpecs");
        prepackagedDatabaseCallback = bl2 ? new Intent(context, MultiInstanceInvalidationService.class) : null;
        this(context, string2, factory2, migrationContainer, list, bl, journalMode, executor, executor2, (Intent)prepackagedDatabaseCallback, bl3, bl4, set, string3, file, callable, null, list2, list3);
    }

    @Deprecated(message="This constructor is deprecated.", replaceWith=@ReplaceWith(expression="DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports={}))
    public DatabaseConfiguration(Context context, String string2, SupportSQLiteOpenHelper.Factory factory2, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean bl, RoomDatabase.JournalMode journalMode, Executor executor, boolean bl2, Set<Integer> set) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)factory2, (String)"sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter((Object)migrationContainer, (String)"migrationContainer");
        Intrinsics.checkNotNullParameter((Object)((Object)journalMode), (String)"journalMode");
        Intrinsics.checkNotNullParameter((Object)executor, (String)"queryExecutor");
        List list2 = CollectionsKt.emptyList();
        List list3 = CollectionsKt.emptyList();
        this(context, string2, factory2, migrationContainer, list, bl, journalMode, executor, executor, null, bl2, false, set, null, null, null, null, (List<? extends Object>)list2, (List<? extends AutoMigrationSpec>)list3);
    }

    public boolean isMigrationRequired(int n, int n2) {
        boolean bl = true;
        if ((n2 = n > n2 ? 1 : 0) != 0 && this.allowDestructiveMigrationOnDowngrade) {
            return false;
        }
        if (!this.requireMigration || this.migrationNotRequiredFrom != null && this.migrationNotRequiredFrom.contains(n)) {
            bl = false;
        }
        return bl;
    }

    @Deprecated(message="Use [isMigrationRequired(int, int)] which takes\n      [allowDestructiveMigrationOnDowngrade] into account.", replaceWith=@ReplaceWith(expression="isMigrationRequired(version, version + 1)", imports={}))
    public boolean isMigrationRequiredFrom(int n) {
        return this.isMigrationRequired(n, n + 1);
    }
}

