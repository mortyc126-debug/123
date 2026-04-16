/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_AutoMigration_13_14_Impl;
import androidx.work.impl.WorkDatabase_AutoMigration_14_15_Impl;
import androidx.work.impl.WorkDatabase_AutoMigration_16_17_Impl;
import androidx.work.impl.WorkDatabase_AutoMigration_17_18_Impl;
import androidx.work.impl.WorkDatabase_AutoMigration_18_19_Impl;
import androidx.work.impl.WorkDatabase_AutoMigration_19_20_Impl;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.DependencyDao_Impl;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.PreferenceDao_Impl;
import androidx.work.impl.model.RawWorkInfoDao;
import androidx.work.impl.model.RawWorkInfoDao_Impl;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.SystemIdInfoDao_Impl;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkNameDao_Impl;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkProgressDao_Impl;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.model.WorkTagDao_Impl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class WorkDatabase_Impl
extends WorkDatabase {
    private volatile DependencyDao _dependencyDao;
    private volatile PreferenceDao _preferenceDao;
    private volatile RawWorkInfoDao _rawWorkInfoDao;
    private volatile SystemIdInfoDao _systemIdInfoDao;
    private volatile WorkNameDao _workNameDao;
    private volatile WorkProgressDao _workProgressDao;
    private volatile WorkSpecDao _workSpecDao;
    private volatile WorkTagDao _workTagDao;

    static /* synthetic */ SupportSQLiteDatabase access$602(WorkDatabase_Impl workDatabase_Impl, SupportSQLiteDatabase supportSQLiteDatabase) {
        workDatabase_Impl.mDatabase = supportSQLiteDatabase;
        return supportSQLiteDatabase;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase supportSQLiteDatabase = super.getOpenHelper().getWritableDatabase();
        {
            super.beginTransaction();
            supportSQLiteDatabase.execSQL("PRAGMA defer_foreign_keys = TRUE");
            supportSQLiteDatabase.execSQL("DELETE FROM `Dependency`");
            supportSQLiteDatabase.execSQL("DELETE FROM `WorkSpec`");
            supportSQLiteDatabase.execSQL("DELETE FROM `WorkTag`");
            supportSQLiteDatabase.execSQL("DELETE FROM `SystemIdInfo`");
            supportSQLiteDatabase.execSQL("DELETE FROM `WorkName`");
            supportSQLiteDatabase.execSQL("DELETE FROM `WorkProgress`");
            supportSQLiteDatabase.execSQL("DELETE FROM `Preference`");
            super.setTransactionSuccessful();
        }
        super.endTransaction();
        supportSQLiteDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
        if (!supportSQLiteDatabase.inTransaction()) {
            supportSQLiteDatabase.execSQL("VACUUM");
        }
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker((RoomDatabase)this, new HashMap<String, String>(0), new HashMap<String, Set<String>>(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        Object object = new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(this, 20){
            final WorkDatabase_Impl this$0;
            {
                this.this$0 = workDatabase_Impl;
                super(n);
            }

            @Override
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT NOT NULL, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `last_enqueue_time` INTEGER NOT NULL DEFAULT -1, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `period_count` INTEGER NOT NULL DEFAULT 0, `generation` INTEGER NOT NULL DEFAULT 0, `next_schedule_time_override` INTEGER NOT NULL DEFAULT 9223372036854775807, `next_schedule_time_override_generation` INTEGER NOT NULL DEFAULT 0, `stop_reason` INTEGER NOT NULL DEFAULT -256, `required_network_type` INTEGER NOT NULL, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_last_enqueue_time` ON `WorkSpec` (`last_enqueue_time`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `generation` INTEGER NOT NULL DEFAULT 0, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`, `generation`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '7d73d21f1bd82c9e5268b6dcf9fde2cb')");
            }

            @Override
            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Dependency`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkSpec`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkTag`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `SystemIdInfo`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkName`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkProgress`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Preference`");
                if (this.this$0.mCallbacks != null) {
                    int n = this.this$0.mCallbacks.size();
                    for (int i = 0; i < n; ++i) {
                        ((RoomDatabase.Callback)this.this$0.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            @Override
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (this.this$0.mCallbacks != null) {
                    int n = this.this$0.mCallbacks.size();
                    for (int i = 0; i < n; ++i) {
                        ((RoomDatabase.Callback)this.this$0.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            @Override
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                WorkDatabase_Impl.access$602(this.this$0, supportSQLiteDatabase);
                supportSQLiteDatabase.execSQL("PRAGMA foreign_keys = ON");
                this.this$0.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (this.this$0.mCallbacks != null) {
                    int n = this.this$0.mCallbacks.size();
                    for (int i = 0; i < n; ++i) {
                        ((RoomDatabase.Callback)this.this$0.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            @Override
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            @Override
            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            @Override
            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase object) {
                Object object2 = new HashMap<String, TableInfo.Column>(2);
                ((HashMap)object2).put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 1, null, 1));
                ((HashMap)object2).put("prerequisite_id", new TableInfo.Column("prerequisite_id", "TEXT", true, 2, null, 1));
                Cloneable cloneable = new HashSet<TableInfo.ForeignKey>(2);
                ((HashSet)cloneable).add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                ((HashSet)cloneable).add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList("id")));
                Object object3 = new HashSet<TableInfo.Index>(2);
                ((HashSet)object3).add(new TableInfo.Index("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
                ((HashSet)object3).add(new TableInfo.Index("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id"), Arrays.asList("ASC")));
                object2 = new TableInfo("Dependency", (Map<String, TableInfo.Column>)object2, (Set<TableInfo.ForeignKey>)((Object)cloneable), (Set<TableInfo.Index>)object3);
                object3 = TableInfo.read((SupportSQLiteDatabase)object, "Dependency");
                if (!((TableInfo)object2).equals(object3)) {
                    return new RoomOpenHelper.ValidationResult(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + object2 + "\n Found:\n" + object3);
                }
                cloneable = new HashMap(30);
                ((HashMap)cloneable).put("id", new TableInfo.Column("id", "TEXT", true, 1, null, 1));
                ((HashMap)cloneable).put("state", new TableInfo.Column("state", "INTEGER", true, 0, null, 1));
                ((HashMap)cloneable).put("worker_class_name", new TableInfo.Column("worker_class_name", "TEXT", true, 0, null, 1));
                ((HashMap)cloneable).put("input_merger_class_name", new TableInfo.Column("input_merger_class_name", "TEXT", true, 0, null, 1));
                ((HashMap)cloneable).put("input", new TableInfo.Column("input", "BLOB", true, 0, null, 1));
                ((HashMap)cloneable).put("output", new TableInfo.Column("output", "BLOB", true, 0, null, 1));
                ((HashMap)cloneable).put("initial_delay", new TableInfo.Column("initial_delay", "INTEGER", true, 0, null, 1));
                ((HashMap)cloneable).put("interval_duration", new TableInfo.Column("interval_duration", "INTEGER", true, 0, null, 1));
                ((HashMap)cloneable).put("flex_duration", new TableInfo.Column("flex_duration", "INTEGER", true, 0, null, 1));
                ((HashMap)cloneable).put("run_attempt_count", new TableInfo.Column("run_attempt_count", "INTEGER", true, 0, null, 1));
                ((HashMap)cloneable).put("backoff_policy", new TableInfo.Column("backoff_policy", "INTEGER", true, 0, null, 1));
                ((HashMap)cloneable).put("backoff_delay_duration", new TableInfo.Column("backoff_delay_duration", "INTEGER", true, 0, null, 1));
                ((HashMap)cloneable).put("last_enqueue_time", new TableInfo.Column("last_enqueue_time", "INTEGER", true, 0, "-1", 1));
                ((HashMap)cloneable).put("minimum_retention_duration", new TableInfo.Column("minimum_retention_duration", "INTEGER", true, 0, null, 1));
                ((HashMap)cloneable).put("schedule_requested_at", new TableInfo.Column("schedule_requested_at", "INTEGER", true, 0, null, 1));
                ((HashMap)cloneable).put("run_in_foreground", new TableInfo.Column("run_in_foreground", "INTEGER", true, 0, null, 1));
                ((HashMap)cloneable).put("out_of_quota_policy", new TableInfo.Column("out_of_quota_policy", "INTEGER", true, 0, null, 1));
                ((HashMap)cloneable).put("period_count", new TableInfo.Column("period_count", "INTEGER", true, 0, "0", 1));
                ((HashMap)cloneable).put("generation", new TableInfo.Column("generation", "INTEGER", true, 0, "0", 1));
                ((HashMap)cloneable).put("next_schedule_time_override", new TableInfo.Column("next_schedule_time_override", "INTEGER", true, 0, "9223372036854775807", 1));
                ((HashMap)cloneable).put("next_schedule_time_override_generation", new TableInfo.Column("next_schedule_time_override_generation", "INTEGER", true, 0, "0", 1));
                ((HashMap)cloneable).put("stop_reason", new TableInfo.Column("stop_reason", "INTEGER", true, 0, "-256", 1));
                ((HashMap)cloneable).put("required_network_type", new TableInfo.Column("required_network_type", "INTEGER", true, 0, null, 1));
                ((HashMap)cloneable).put("requires_charging", new TableInfo.Column("requires_charging", "INTEGER", true, 0, null, 1));
                ((HashMap)cloneable).put("requires_device_idle", new TableInfo.Column("requires_device_idle", "INTEGER", true, 0, null, 1));
                ((HashMap)cloneable).put("requires_battery_not_low", new TableInfo.Column("requires_battery_not_low", "INTEGER", true, 0, null, 1));
                ((HashMap)cloneable).put("requires_storage_not_low", new TableInfo.Column("requires_storage_not_low", "INTEGER", true, 0, null, 1));
                ((HashMap)cloneable).put("trigger_content_update_delay", new TableInfo.Column("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
                ((HashMap)cloneable).put("trigger_max_content_delay", new TableInfo.Column("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
                ((HashMap)cloneable).put("content_uri_triggers", new TableInfo.Column("content_uri_triggers", "BLOB", true, 0, null, 1));
                object2 = new HashSet<TableInfo.ForeignKey>(0);
                object3 = new HashSet<TableInfo.Index>(2);
                ((HashSet)object3).add(new TableInfo.Index("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at"), Arrays.asList("ASC")));
                ((HashSet)object3).add(new TableInfo.Index("index_WorkSpec_last_enqueue_time", false, Arrays.asList("last_enqueue_time"), Arrays.asList("ASC")));
                object2 = new TableInfo("WorkSpec", (Map<String, TableInfo.Column>)((Object)cloneable), (Set<TableInfo.ForeignKey>)object2, (Set<TableInfo.Index>)object3);
                object3 = TableInfo.read((SupportSQLiteDatabase)object, "WorkSpec");
                if (!((TableInfo)object2).equals(object3)) {
                    return new RoomOpenHelper.ValidationResult(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + object2 + "\n Found:\n" + object3);
                }
                object3 = new HashMap<String, TableInfo.Column>(2);
                ((HashMap)object3).put("tag", new TableInfo.Column("tag", "TEXT", true, 1, null, 1));
                ((HashMap)object3).put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 2, null, 1));
                object2 = new HashSet<TableInfo.ForeignKey>(1);
                ((HashSet)object2).add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                cloneable = new HashSet(1);
                ((HashSet)cloneable).add(new TableInfo.Index("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
                object3 = new TableInfo("WorkTag", (Map<String, TableInfo.Column>)object3, (Set<TableInfo.ForeignKey>)object2, (Set<TableInfo.Index>)((Object)cloneable));
                object2 = TableInfo.read((SupportSQLiteDatabase)object, "WorkTag");
                if (!((TableInfo)object3).equals(object2)) {
                    return new RoomOpenHelper.ValidationResult(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + object3 + "\n Found:\n" + object2);
                }
                object3 = new HashMap<String, TableInfo.Column>(3);
                ((HashMap)object3).put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 1, null, 1));
                ((HashMap)object3).put("generation", new TableInfo.Column("generation", "INTEGER", true, 2, "0", 1));
                ((HashMap)object3).put("system_id", new TableInfo.Column("system_id", "INTEGER", true, 0, null, 1));
                object2 = new HashSet<TableInfo.ForeignKey>(1);
                ((HashSet)object2).add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                object3 = new TableInfo("SystemIdInfo", (Map<String, TableInfo.Column>)object3, (Set<TableInfo.ForeignKey>)object2, (Set<TableInfo.Index>)new HashSet<TableInfo.Index>(0));
                object2 = TableInfo.read((SupportSQLiteDatabase)object, "SystemIdInfo");
                if (!((TableInfo)object3).equals(object2)) {
                    return new RoomOpenHelper.ValidationResult(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + object3 + "\n Found:\n" + object2);
                }
                object2 = new HashMap<String, TableInfo.Column>(2);
                ((HashMap)object2).put("name", new TableInfo.Column("name", "TEXT", true, 1, null, 1));
                ((HashMap)object2).put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 2, null, 1));
                cloneable = new HashSet(1);
                ((HashSet)cloneable).add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                object3 = new HashSet<TableInfo.Index>(1);
                ((HashSet)object3).add(new TableInfo.Index("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
                object2 = new TableInfo("WorkName", (Map<String, TableInfo.Column>)object2, (Set<TableInfo.ForeignKey>)((Object)cloneable), (Set<TableInfo.Index>)object3);
                object3 = TableInfo.read((SupportSQLiteDatabase)object, "WorkName");
                if (!((TableInfo)object2).equals(object3)) {
                    return new RoomOpenHelper.ValidationResult(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + object2 + "\n Found:\n" + object3);
                }
                object3 = new HashMap<String, TableInfo.Column>(2);
                ((HashMap)object3).put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 1, null, 1));
                ((HashMap)object3).put("progress", new TableInfo.Column("progress", "BLOB", true, 0, null, 1));
                object2 = new HashSet<TableInfo.ForeignKey>(1);
                ((HashSet)object2).add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                object2 = new TableInfo("WorkProgress", (Map<String, TableInfo.Column>)object3, (Set<TableInfo.ForeignKey>)object2, (Set<TableInfo.Index>)new HashSet<TableInfo.Index>(0));
                object3 = TableInfo.read((SupportSQLiteDatabase)object, "WorkProgress");
                if (!((TableInfo)object2).equals(object3)) {
                    return new RoomOpenHelper.ValidationResult(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + object2 + "\n Found:\n" + object3);
                }
                object2 = new HashMap<String, TableInfo.Column>(2);
                ((HashMap)object2).put("key", new TableInfo.Column("key", "TEXT", true, 1, null, 1));
                ((HashMap)object2).put("long_value", new TableInfo.Column("long_value", "INTEGER", false, 0, null, 1));
                object2 = new TableInfo("Preference", (Map<String, TableInfo.Column>)object2, (Set<TableInfo.ForeignKey>)new HashSet<TableInfo.ForeignKey>(0), (Set<TableInfo.Index>)new HashSet<TableInfo.Index>(0));
                object = TableInfo.read((SupportSQLiteDatabase)object, "Preference");
                if (!((TableInfo)object2).equals(object)) {
                    return new RoomOpenHelper.ValidationResult(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + object2 + "\n Found:\n" + object);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "7d73d21f1bd82c9e5268b6dcf9fde2cb", "3071c8717539de5d5353f4c8cd59a032");
        object = SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback((SupportSQLiteOpenHelper.Callback)object).build();
        return databaseConfiguration.sqliteOpenHelperFactory.create((SupportSQLiteOpenHelper.Configuration)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public DependencyDao dependencyDao() {
        if (this._dependencyDao != null) {
            return this._dependencyDao;
        }
        synchronized (this) {
            if (this._dependencyDao != null) return this._dependencyDao;
            DependencyDao dependencyDao = new DependencyDao_Impl(this);
            this._dependencyDao = dependencyDao;
            return this._dependencyDao;
        }
    }

    @Override
    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map2) {
        return Arrays.asList(new WorkDatabase_AutoMigration_13_14_Impl(), new WorkDatabase_AutoMigration_14_15_Impl(), new WorkDatabase_AutoMigration_16_17_Impl(), new WorkDatabase_AutoMigration_17_18_Impl(), new WorkDatabase_AutoMigration_18_19_Impl(), new WorkDatabase_AutoMigration_19_20_Impl());
    }

    @Override
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet<Class<? extends AutoMigrationSpec>>();
    }

    @Override
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(WorkSpecDao.class, WorkSpecDao_Impl.getRequiredConverters());
        hashMap.put(DependencyDao.class, DependencyDao_Impl.getRequiredConverters());
        hashMap.put(WorkTagDao.class, WorkTagDao_Impl.getRequiredConverters());
        hashMap.put(SystemIdInfoDao.class, SystemIdInfoDao_Impl.getRequiredConverters());
        hashMap.put(WorkNameDao.class, WorkNameDao_Impl.getRequiredConverters());
        hashMap.put(WorkProgressDao.class, WorkProgressDao_Impl.getRequiredConverters());
        hashMap.put(PreferenceDao.class, PreferenceDao_Impl.getRequiredConverters());
        hashMap.put(RawWorkInfoDao.class, RawWorkInfoDao_Impl.getRequiredConverters());
        return hashMap;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public PreferenceDao preferenceDao() {
        if (this._preferenceDao != null) {
            return this._preferenceDao;
        }
        synchronized (this) {
            if (this._preferenceDao != null) return this._preferenceDao;
            PreferenceDao preferenceDao = new PreferenceDao_Impl(this);
            this._preferenceDao = preferenceDao;
            return this._preferenceDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public RawWorkInfoDao rawWorkInfoDao() {
        if (this._rawWorkInfoDao != null) {
            return this._rawWorkInfoDao;
        }
        synchronized (this) {
            if (this._rawWorkInfoDao != null) return this._rawWorkInfoDao;
            RawWorkInfoDao rawWorkInfoDao = new RawWorkInfoDao_Impl(this);
            this._rawWorkInfoDao = rawWorkInfoDao;
            return this._rawWorkInfoDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public SystemIdInfoDao systemIdInfoDao() {
        if (this._systemIdInfoDao != null) {
            return this._systemIdInfoDao;
        }
        synchronized (this) {
            if (this._systemIdInfoDao != null) return this._systemIdInfoDao;
            SystemIdInfoDao systemIdInfoDao = new SystemIdInfoDao_Impl(this);
            this._systemIdInfoDao = systemIdInfoDao;
            return this._systemIdInfoDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public WorkNameDao workNameDao() {
        if (this._workNameDao != null) {
            return this._workNameDao;
        }
        synchronized (this) {
            if (this._workNameDao != null) return this._workNameDao;
            WorkNameDao workNameDao = new WorkNameDao_Impl(this);
            this._workNameDao = workNameDao;
            return this._workNameDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public WorkProgressDao workProgressDao() {
        if (this._workProgressDao != null) {
            return this._workProgressDao;
        }
        synchronized (this) {
            if (this._workProgressDao != null) return this._workProgressDao;
            WorkProgressDao workProgressDao = new WorkProgressDao_Impl(this);
            this._workProgressDao = workProgressDao;
            return this._workProgressDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public WorkSpecDao workSpecDao() {
        if (this._workSpecDao != null) {
            return this._workSpecDao;
        }
        synchronized (this) {
            if (this._workSpecDao != null) return this._workSpecDao;
            WorkSpecDao workSpecDao = new WorkSpecDao_Impl(this);
            this._workSpecDao = workSpecDao;
            return this._workSpecDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public WorkTagDao workTagDao() {
        if (this._workTagDao != null) {
            return this._workTagDao;
        }
        synchronized (this) {
            if (this._workTagDao != null) return this._workTagDao;
            WorkTagDao workTagDao = new WorkTagDao_Impl(this);
            this._workTagDao = workTagDao;
            return this._workTagDao;
        }
    }
}

