/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work.impl;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import androidx.work.Clock;
import androidx.work.impl.CleanupCallback;
import androidx.work.impl.Migration_11_12;
import androidx.work.impl.Migration_12_13;
import androidx.work.impl.Migration_15_16;
import androidx.work.impl.Migration_16_17;
import androidx.work.impl.Migration_1_2;
import androidx.work.impl.Migration_3_4;
import androidx.work.impl.Migration_4_5;
import androidx.work.impl.Migration_6_7;
import androidx.work.impl.Migration_7_8;
import androidx.work.impl.Migration_8_9;
import androidx.work.impl.RescheduleMigration;
import androidx.work.impl.WorkDatabase$Companion$$ExternalSyntheticLambda0;
import androidx.work.impl.WorkMigration9To10;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.RawWorkInfoDao;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&\u00a8\u0006\u0014"}, d2={"Landroidx/work/impl/WorkDatabase;", "Landroidx/room/RoomDatabase;", "()V", "dependencyDao", "Landroidx/work/impl/model/DependencyDao;", "preferenceDao", "Landroidx/work/impl/model/PreferenceDao;", "rawWorkInfoDao", "Landroidx/work/impl/model/RawWorkInfoDao;", "systemIdInfoDao", "Landroidx/work/impl/model/SystemIdInfoDao;", "workNameDao", "Landroidx/work/impl/model/WorkNameDao;", "workProgressDao", "Landroidx/work/impl/model/WorkProgressDao;", "workSpecDao", "Landroidx/work/impl/model/WorkSpecDao;", "workTagDao", "Landroidx/work/impl/model/WorkTagDao;", "Companion", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
public abstract class WorkDatabase
extends RoomDatabase {
    public static final Companion Companion = new Companion(null);

    @JvmStatic
    public static final WorkDatabase create(Context context, Executor executor, Clock clock, boolean bl) {
        return Companion.create(context, executor, clock, bl);
    }

    public abstract DependencyDao dependencyDao();

    public abstract PreferenceDao preferenceDao();

    public abstract RawWorkInfoDao rawWorkInfoDao();

    public abstract SystemIdInfoDao systemIdInfoDao();

    public abstract WorkNameDao workNameDao();

    public abstract WorkProgressDao workProgressDao();

    public abstract WorkSpecDao workSpecDao();

    public abstract WorkTagDao workTagDao();

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007\u00a8\u0006\r"}, d2={"Landroidx/work/impl/WorkDatabase$Companion;", "", "()V", "create", "Landroidx/work/impl/WorkDatabase;", "context", "Landroid/content/Context;", "queryExecutor", "Ljava/util/concurrent/Executor;", "clock", "Landroidx/work/Clock;", "useTestDatabase", "", "work-runtime_release"}, k=1, mv={1, 8, 0}, xi=48)
    public static final class Companion {
        public static /* synthetic */ SupportSQLiteOpenHelper $r8$lambda$ZkS5S0p_73DOI66Tm39UHOpqbt0(Context context, SupportSQLiteOpenHelper.Configuration configuration2) {
            return androidx.work.impl.WorkDatabase$Companion.create$lambda$0(context, configuration2);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private static final SupportSQLiteOpenHelper create$lambda$0(Context object, SupportSQLiteOpenHelper.Configuration configuration2) {
            Intrinsics.checkNotNullParameter((Object)object, (String)"$context");
            Intrinsics.checkNotNullParameter((Object)configuration2, (String)"configuration");
            object = SupportSQLiteOpenHelper.Configuration.Companion.builder((Context)object);
            ((SupportSQLiteOpenHelper.Configuration.Builder)object).name(configuration2.name).callback(configuration2.callback).noBackupDirectory(true).allowDataLossOnRecovery(true);
            return new FrameworkSQLiteOpenHelperFactory().create(((SupportSQLiteOpenHelper.Configuration.Builder)object).build());
        }

        @JvmStatic
        public final WorkDatabase create(Context context, Executor executor, Clock clock, boolean bl) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)executor, (String)"queryExecutor");
            Intrinsics.checkNotNullParameter((Object)clock, (String)"clock");
            RoomDatabase.Builder<WorkDatabase> builder = bl ? Room.inMemoryDatabaseBuilder(context, WorkDatabase.class).allowMainThreadQueries() : Room.databaseBuilder(context, WorkDatabase.class, "androidx.work.workdb").openHelperFactory(new WorkDatabase$Companion$$ExternalSyntheticLambda0(context));
            return builder.setQueryExecutor(executor).addCallback(new CleanupCallback(clock)).addMigrations(Migration_1_2.INSTANCE).addMigrations(new RescheduleMigration(context, 2, 3)).addMigrations(Migration_3_4.INSTANCE).addMigrations(Migration_4_5.INSTANCE).addMigrations(new RescheduleMigration(context, 5, 6)).addMigrations(Migration_6_7.INSTANCE).addMigrations(Migration_7_8.INSTANCE).addMigrations(Migration_8_9.INSTANCE).addMigrations(new WorkMigration9To10(context)).addMigrations(new RescheduleMigration(context, 10, 11)).addMigrations(Migration_11_12.INSTANCE).addMigrations(Migration_12_13.INSTANCE).addMigrations(Migration_15_16.INSTANCE).addMigrations(Migration_16_17.INSTANCE).fallbackToDestructiveMigration().build();
        }
    }
}

