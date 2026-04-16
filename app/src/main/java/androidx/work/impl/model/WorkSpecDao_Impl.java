/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package androidx.work.impl.model;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTypeConverters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlinx.coroutines.flow.Flow;

public final class WorkSpecDao_Impl
implements WorkSpecDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<WorkSpec> __insertionAdapterOfWorkSpec;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfIncrementGeneration;
    private final SharedSQLiteStatement __preparedStmtOfIncrementPeriodCount;
    private final SharedSQLiteStatement __preparedStmtOfIncrementWorkSpecRunAttemptCount;
    private final SharedSQLiteStatement __preparedStmtOfMarkWorkSpecScheduled;
    private final SharedSQLiteStatement __preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast;
    private final SharedSQLiteStatement __preparedStmtOfResetScheduledState;
    private final SharedSQLiteStatement __preparedStmtOfResetWorkSpecNextScheduleTimeOverride;
    private final SharedSQLiteStatement __preparedStmtOfResetWorkSpecRunAttemptCount;
    private final SharedSQLiteStatement __preparedStmtOfSetCancelledState;
    private final SharedSQLiteStatement __preparedStmtOfSetLastEnqueueTime;
    private final SharedSQLiteStatement __preparedStmtOfSetNextScheduleTimeOverride;
    private final SharedSQLiteStatement __preparedStmtOfSetOutput;
    private final SharedSQLiteStatement __preparedStmtOfSetState;
    private final SharedSQLiteStatement __preparedStmtOfSetStopReason;
    private final EntityDeletionOrUpdateAdapter<WorkSpec> __updateAdapterOfWorkSpec;

    public WorkSpecDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfWorkSpec = new EntityInsertionAdapter<WorkSpec>(this, roomDatabase){
            final WorkSpecDao_Impl this$0;
            {
                this.this$0 = workSpecDao_Impl;
                super(roomDatabase);
            }

            @Override
            public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkSpec object) {
                if (((WorkSpec)object).id == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, ((WorkSpec)object).id);
                }
                Object object2 = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindLong(2, WorkTypeConverters.stateToInt(((WorkSpec)object).state));
                if (((WorkSpec)object).workerClassName == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, ((WorkSpec)object).workerClassName);
                }
                if (((WorkSpec)object).inputMergerClassName == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, ((WorkSpec)object).inputMergerClassName);
                }
                object2 = Data.toByteArrayInternal(((WorkSpec)object).input);
                if (object2 == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindBlob(5, (byte[])object2);
                }
                object2 = Data.toByteArrayInternal(((WorkSpec)object).output);
                if (object2 == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindBlob(6, (byte[])object2);
                }
                supportSQLiteStatement.bindLong(7, ((WorkSpec)object).initialDelay);
                supportSQLiteStatement.bindLong(8, ((WorkSpec)object).intervalDuration);
                supportSQLiteStatement.bindLong(9, ((WorkSpec)object).flexDuration);
                supportSQLiteStatement.bindLong(10, ((WorkSpec)object).runAttemptCount);
                object2 = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindLong(11, WorkTypeConverters.backoffPolicyToInt(((WorkSpec)object).backoffPolicy));
                supportSQLiteStatement.bindLong(12, ((WorkSpec)object).backoffDelayDuration);
                supportSQLiteStatement.bindLong(13, ((WorkSpec)object).lastEnqueueTime);
                supportSQLiteStatement.bindLong(14, ((WorkSpec)object).minimumRetentionDuration);
                supportSQLiteStatement.bindLong(15, ((WorkSpec)object).scheduleRequestedAt);
                supportSQLiteStatement.bindLong(16, (long)((WorkSpec)object).expedited);
                object2 = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindLong(17, WorkTypeConverters.outOfQuotaPolicyToInt(((WorkSpec)object).outOfQuotaPolicy));
                supportSQLiteStatement.bindLong(18, ((WorkSpec)object).getPeriodCount());
                supportSQLiteStatement.bindLong(19, ((WorkSpec)object).getGeneration());
                supportSQLiteStatement.bindLong(20, ((WorkSpec)object).getNextScheduleTimeOverride());
                supportSQLiteStatement.bindLong(21, ((WorkSpec)object).getNextScheduleTimeOverrideGeneration());
                supportSQLiteStatement.bindLong(22, ((WorkSpec)object).getStopReason());
                object = ((WorkSpec)object).constraints;
                if (object != null) {
                    object2 = WorkTypeConverters.INSTANCE;
                    supportSQLiteStatement.bindLong(23, WorkTypeConverters.networkTypeToInt(((Constraints)object).getRequiredNetworkType()));
                    supportSQLiteStatement.bindLong(24, (long)((Constraints)object).requiresCharging());
                    supportSQLiteStatement.bindLong(25, (long)((Constraints)object).requiresDeviceIdle());
                    supportSQLiteStatement.bindLong(26, (long)((Constraints)object).requiresBatteryNotLow());
                    supportSQLiteStatement.bindLong(27, (long)((Constraints)object).requiresStorageNotLow());
                    supportSQLiteStatement.bindLong(28, ((Constraints)object).getContentTriggerUpdateDelayMillis());
                    supportSQLiteStatement.bindLong(29, ((Constraints)object).getContentTriggerMaxDelayMillis());
                    object2 = WorkTypeConverters.INSTANCE;
                    object = WorkTypeConverters.setOfTriggersToByteArray(((Constraints)object).getContentUriTriggers());
                    if (object == null) {
                        supportSQLiteStatement.bindNull(30);
                    } else {
                        supportSQLiteStatement.bindBlob(30, (byte[])object);
                    }
                } else {
                    supportSQLiteStatement.bindNull(23);
                    supportSQLiteStatement.bindNull(24);
                    supportSQLiteStatement.bindNull(25);
                    supportSQLiteStatement.bindNull(26);
                    supportSQLiteStatement.bindNull(27);
                    supportSQLiteStatement.bindNull(28);
                    supportSQLiteStatement.bindNull(29);
                    supportSQLiteStatement.bindNull(30);
                }
            }

            @Override
            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`last_enqueue_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`period_count`,`generation`,`next_schedule_time_override`,`next_schedule_time_override_generation`,`stop_reason`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }
        };
        this.__updateAdapterOfWorkSpec = new EntityDeletionOrUpdateAdapter<WorkSpec>(this, roomDatabase){
            final WorkSpecDao_Impl this$0;
            {
                this.this$0 = workSpecDao_Impl;
                super(roomDatabase);
            }

            @Override
            public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkSpec workSpec) {
                if (workSpec.id == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, workSpec.id);
                }
                Object object = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindLong(2, WorkTypeConverters.stateToInt(workSpec.state));
                if (workSpec.workerClassName == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, workSpec.workerClassName);
                }
                if (workSpec.inputMergerClassName == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, workSpec.inputMergerClassName);
                }
                object = Data.toByteArrayInternal(workSpec.input);
                if (object == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindBlob(5, (byte[])object);
                }
                object = Data.toByteArrayInternal(workSpec.output);
                if (object == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindBlob(6, (byte[])object);
                }
                supportSQLiteStatement.bindLong(7, workSpec.initialDelay);
                supportSQLiteStatement.bindLong(8, workSpec.intervalDuration);
                supportSQLiteStatement.bindLong(9, workSpec.flexDuration);
                supportSQLiteStatement.bindLong(10, workSpec.runAttemptCount);
                object = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindLong(11, WorkTypeConverters.backoffPolicyToInt(workSpec.backoffPolicy));
                supportSQLiteStatement.bindLong(12, workSpec.backoffDelayDuration);
                supportSQLiteStatement.bindLong(13, workSpec.lastEnqueueTime);
                supportSQLiteStatement.bindLong(14, workSpec.minimumRetentionDuration);
                supportSQLiteStatement.bindLong(15, workSpec.scheduleRequestedAt);
                supportSQLiteStatement.bindLong(16, (long)workSpec.expedited);
                object = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindLong(17, WorkTypeConverters.outOfQuotaPolicyToInt(workSpec.outOfQuotaPolicy));
                supportSQLiteStatement.bindLong(18, workSpec.getPeriodCount());
                supportSQLiteStatement.bindLong(19, workSpec.getGeneration());
                supportSQLiteStatement.bindLong(20, workSpec.getNextScheduleTimeOverride());
                supportSQLiteStatement.bindLong(21, workSpec.getNextScheduleTimeOverrideGeneration());
                supportSQLiteStatement.bindLong(22, workSpec.getStopReason());
                object = workSpec.constraints;
                if (object != null) {
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    supportSQLiteStatement.bindLong(23, WorkTypeConverters.networkTypeToInt(((Constraints)object).getRequiredNetworkType()));
                    supportSQLiteStatement.bindLong(24, (long)((Constraints)object).requiresCharging());
                    supportSQLiteStatement.bindLong(25, (long)((Constraints)object).requiresDeviceIdle());
                    supportSQLiteStatement.bindLong(26, (long)((Constraints)object).requiresBatteryNotLow());
                    supportSQLiteStatement.bindLong(27, (long)((Constraints)object).requiresStorageNotLow());
                    supportSQLiteStatement.bindLong(28, ((Constraints)object).getContentTriggerUpdateDelayMillis());
                    supportSQLiteStatement.bindLong(29, ((Constraints)object).getContentTriggerMaxDelayMillis());
                    workTypeConverters = WorkTypeConverters.INSTANCE;
                    object = WorkTypeConverters.setOfTriggersToByteArray(((Constraints)object).getContentUriTriggers());
                    if (object == null) {
                        supportSQLiteStatement.bindNull(30);
                    } else {
                        supportSQLiteStatement.bindBlob(30, (byte[])object);
                    }
                } else {
                    supportSQLiteStatement.bindNull(23);
                    supportSQLiteStatement.bindNull(24);
                    supportSQLiteStatement.bindNull(25);
                    supportSQLiteStatement.bindNull(26);
                    supportSQLiteStatement.bindNull(27);
                    supportSQLiteStatement.bindNull(28);
                    supportSQLiteStatement.bindNull(29);
                    supportSQLiteStatement.bindNull(30);
                }
                if (workSpec.id == null) {
                    supportSQLiteStatement.bindNull(31);
                } else {
                    supportSQLiteStatement.bindString(31, workSpec.id);
                }
            }

            @Override
            public String createQuery() {
                return "UPDATE OR ABORT `WorkSpec` SET `id` = ?,`state` = ?,`worker_class_name` = ?,`input_merger_class_name` = ?,`input` = ?,`output` = ?,`initial_delay` = ?,`interval_duration` = ?,`flex_duration` = ?,`run_attempt_count` = ?,`backoff_policy` = ?,`backoff_delay_duration` = ?,`last_enqueue_time` = ?,`minimum_retention_duration` = ?,`schedule_requested_at` = ?,`run_in_foreground` = ?,`out_of_quota_policy` = ?,`period_count` = ?,`generation` = ?,`next_schedule_time_override` = ?,`next_schedule_time_override_generation` = ?,`stop_reason` = ?,`required_network_type` = ?,`requires_charging` = ?,`requires_device_idle` = ?,`requires_battery_not_low` = ?,`requires_storage_not_low` = ?,`trigger_content_update_delay` = ?,`trigger_max_content_delay` = ?,`content_uri_triggers` = ? WHERE `id` = ?";
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(this, roomDatabase){
            final WorkSpecDao_Impl this$0;
            {
                this.this$0 = workSpecDao_Impl;
                super(roomDatabase);
            }

            @Override
            public String createQuery() {
                return "DELETE FROM workspec WHERE id=?";
            }
        };
        this.__preparedStmtOfSetState = new SharedSQLiteStatement(this, roomDatabase){
            final WorkSpecDao_Impl this$0;
            {
                this.this$0 = workSpecDao_Impl;
                super(roomDatabase);
            }

            @Override
            public String createQuery() {
                return "UPDATE workspec SET state=? WHERE id=?";
            }
        };
        this.__preparedStmtOfSetCancelledState = new SharedSQLiteStatement(this, roomDatabase){
            final WorkSpecDao_Impl this$0;
            {
                this.this$0 = workSpecDao_Impl;
                super(roomDatabase);
            }

            @Override
            public String createQuery() {
                return "UPDATE workspec SET stop_reason = CASE WHEN state=1 THEN 1 ELSE -256 END, state=5 WHERE id=?";
            }
        };
        this.__preparedStmtOfIncrementPeriodCount = new SharedSQLiteStatement(this, roomDatabase){
            final WorkSpecDao_Impl this$0;
            {
                this.this$0 = workSpecDao_Impl;
                super(roomDatabase);
            }

            @Override
            public String createQuery() {
                return "UPDATE workspec SET period_count=period_count+1 WHERE id=?";
            }
        };
        this.__preparedStmtOfSetOutput = new SharedSQLiteStatement(this, roomDatabase){
            final WorkSpecDao_Impl this$0;
            {
                this.this$0 = workSpecDao_Impl;
                super(roomDatabase);
            }

            @Override
            public String createQuery() {
                return "UPDATE workspec SET output=? WHERE id=?";
            }
        };
        this.__preparedStmtOfSetLastEnqueueTime = new SharedSQLiteStatement(this, roomDatabase){
            final WorkSpecDao_Impl this$0;
            {
                this.this$0 = workSpecDao_Impl;
                super(roomDatabase);
            }

            @Override
            public String createQuery() {
                return "UPDATE workspec SET last_enqueue_time=? WHERE id=?";
            }
        };
        this.__preparedStmtOfIncrementWorkSpecRunAttemptCount = new SharedSQLiteStatement(this, roomDatabase){
            final WorkSpecDao_Impl this$0;
            {
                this.this$0 = workSpecDao_Impl;
                super(roomDatabase);
            }

            @Override
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            }
        };
        this.__preparedStmtOfResetWorkSpecRunAttemptCount = new SharedSQLiteStatement(this, roomDatabase){
            final WorkSpecDao_Impl this$0;
            {
                this.this$0 = workSpecDao_Impl;
                super(roomDatabase);
            }

            @Override
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            }
        };
        this.__preparedStmtOfSetNextScheduleTimeOverride = new SharedSQLiteStatement(this, roomDatabase){
            final WorkSpecDao_Impl this$0;
            {
                this.this$0 = workSpecDao_Impl;
                super(roomDatabase);
            }

            @Override
            public String createQuery() {
                return "UPDATE workspec SET next_schedule_time_override=? WHERE id=?";
            }
        };
        this.__preparedStmtOfResetWorkSpecNextScheduleTimeOverride = new SharedSQLiteStatement(this, roomDatabase){
            final WorkSpecDao_Impl this$0;
            {
                this.this$0 = workSpecDao_Impl;
                super(roomDatabase);
            }

            @Override
            public String createQuery() {
                return "UPDATE workspec SET next_schedule_time_override=9223372036854775807 WHERE (id=? AND next_schedule_time_override_generation=?)";
            }
        };
        this.__preparedStmtOfMarkWorkSpecScheduled = new SharedSQLiteStatement(this, roomDatabase){
            final WorkSpecDao_Impl this$0;
            {
                this.this$0 = workSpecDao_Impl;
                super(roomDatabase);
            }

            @Override
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            }
        };
        this.__preparedStmtOfResetScheduledState = new SharedSQLiteStatement(this, roomDatabase){
            final WorkSpecDao_Impl this$0;
            {
                this.this$0 = workSpecDao_Impl;
                super(roomDatabase);
            }

            @Override
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            }
        };
        this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast = new SharedSQLiteStatement(this, roomDatabase){
            final WorkSpecDao_Impl this$0;
            {
                this.this$0 = workSpecDao_Impl;
                super(roomDatabase);
            }

            @Override
            public String createQuery() {
                return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
            }
        };
        this.__preparedStmtOfIncrementGeneration = new SharedSQLiteStatement(this, roomDatabase){
            final WorkSpecDao_Impl this$0;
            {
                this.this$0 = workSpecDao_Impl;
                super(roomDatabase);
            }

            @Override
            public String createQuery() {
                return "UPDATE workspec SET generation=generation+1 WHERE id=?";
            }
        };
        this.__preparedStmtOfSetStopReason = new SharedSQLiteStatement(this, roomDatabase){
            final WorkSpecDao_Impl this$0;
            {
                this.this$0 = workSpecDao_Impl;
                super(roomDatabase);
            }

            @Override
            public String createQuery() {
                return "UPDATE workspec SET stop_reason=? WHERE id=?";
            }
        };
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void __fetchRelationshipWorkProgressAsandroidxWorkData(HashMap<String, ArrayList<Data>> hashMap) {
        ArrayList<Data> arrayList;
        int n;
        Object object;
        Object object2;
        block13: {
            object2 = hashMap.keySet();
            if (object2.isEmpty()) {
                return;
            }
            if (hashMap.size() > 999) {
                Object object3 = new HashMap<String, ArrayList<Data>>(999);
                int n2 = 0;
                Iterator<String> iterator2 = object2.iterator();
                while (true) {
                    if (!iterator2.hasNext()) {
                        if (n2 <= 0) return;
                        this.__fetchRelationshipWorkProgressAsandroidxWorkData((HashMap<String, ArrayList<Data>>)object3);
                        return;
                    }
                    object2 = iterator2.next();
                    ((HashMap)object3).put((String)object2, hashMap.get(object2));
                    int n3 = n2 + 1;
                    object2 = object3;
                    n2 = n3;
                    if (n3 == 999) {
                        this.__fetchRelationshipWorkProgressAsandroidxWorkData((HashMap<String, ArrayList<Data>>)object3);
                        object2 = new HashMap(999);
                        n2 = 0;
                    }
                    object3 = object2;
                }
            }
            object = StringUtil.newStringBuilder();
            ((StringBuilder)object).append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
            n = object2.size();
            StringUtil.appendPlaceholders((StringBuilder)object, n);
            ((StringBuilder)object).append(")");
            object = RoomSQLiteQuery.acquire(((StringBuilder)object).toString(), n + 0);
            n = 1;
            object2 = object2.iterator();
            while (object2.hasNext()) {
                arrayList = (String)object2.next();
                if (arrayList == null) {
                    ((RoomSQLiteQuery)object).bindNull(n);
                } else {
                    ((RoomSQLiteQuery)object).bindString(n, (String)((Object)arrayList));
                }
                ++n;
            }
            object2 = DBUtil.query(this.__db, (SupportSQLiteQuery)object, false, null);
            n = CursorUtil.getColumnIndex((Cursor)object2, "work_spec_id");
            if (n != -1) break block13;
            object2.close();
            return;
        }
        try {
            while (object2.moveToNext()) {
                arrayList = hashMap.get(object2.getString(n));
                if (arrayList == null) continue;
                object = object2.isNull(0) ? null : (Object)object2.getBlob(0);
                arrayList.add(Data.fromByteArray((byte[])object));
            }
            return;
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        finally {
            object2.close();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void __fetchRelationshipWorkTagAsjavaLangString(HashMap<String, ArrayList<String>> hashMap) {
        ArrayList<String> arrayList;
        int n;
        Object object;
        Object object2;
        block13: {
            object2 = hashMap.keySet();
            if (object2.isEmpty()) {
                return;
            }
            if (hashMap.size() > 999) {
                Object object3 = new HashMap<String, ArrayList<String>>(999);
                int n2 = 0;
                Iterator<String> iterator2 = object2.iterator();
                while (true) {
                    if (!iterator2.hasNext()) {
                        if (n2 <= 0) return;
                        this.__fetchRelationshipWorkTagAsjavaLangString((HashMap<String, ArrayList<String>>)object3);
                        return;
                    }
                    object2 = iterator2.next();
                    ((HashMap)object3).put((String)object2, hashMap.get(object2));
                    int n3 = n2 + 1;
                    object2 = object3;
                    n2 = n3;
                    if (n3 == 999) {
                        this.__fetchRelationshipWorkTagAsjavaLangString((HashMap<String, ArrayList<String>>)object3);
                        object2 = new HashMap(999);
                        n2 = 0;
                    }
                    object3 = object2;
                }
            }
            object = StringUtil.newStringBuilder();
            ((StringBuilder)object).append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
            n = object2.size();
            StringUtil.appendPlaceholders((StringBuilder)object, n);
            ((StringBuilder)object).append(")");
            object = RoomSQLiteQuery.acquire(((StringBuilder)object).toString(), n + 0);
            n = 1;
            object2 = object2.iterator();
            while (object2.hasNext()) {
                arrayList = (String)object2.next();
                if (arrayList == null) {
                    ((RoomSQLiteQuery)object).bindNull(n);
                } else {
                    ((RoomSQLiteQuery)object).bindString(n, (String)((Object)arrayList));
                }
                ++n;
            }
            object2 = DBUtil.query(this.__db, (SupportSQLiteQuery)object, false, null);
            n = CursorUtil.getColumnIndex((Cursor)object2, "work_spec_id");
            if (n != -1) break block13;
            object2.close();
            return;
        }
        try {
            while (object2.moveToNext()) {
                arrayList = hashMap.get(object2.getString(n));
                if (arrayList == null) continue;
                object = object2.isNull(0) ? null : object2.getString(0);
                arrayList.add((String)object);
            }
            return;
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        finally {
            object2.close();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override
    public int countNonFinishedContentUriTriggerWorkers() {
        int n;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("Select COUNT(*) FROM workspec WHERE LENGTH(content_uri_triggers)<>0 AND state NOT IN (2, 3, 5)", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor = DBUtil.query(this.__db, roomSQLiteQuery, false, null);
        try {
            n = cursor.moveToFirst() ? cursor.getInt(0) : 0;
        }
        catch (Throwable throwable) {
            cursor.close();
            roomSQLiteQuery.release();
            throw throwable;
        }
        cursor.close();
        roomSQLiteQuery.release();
        return n;
    }

    @Override
    public void delete(String string2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDelete.acquire();
        if (string2 == null) {
            supportSQLiteStatement.bindNull(1);
        } else {
            supportSQLiteStatement.bindString(1, string2);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDelete.release(supportSQLiteStatement);
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public List<WorkSpec> getAllEligibleWorkSpecsForScheduling(int n) {
        void var62_60;
        Cursor cursor;
        RoomSQLiteQuery roomSQLiteQuery;
        block15: {
            ArrayList<WorkSpec> arrayList;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            int n15;
            roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?", 1);
            roomSQLiteQuery.bindLong(1, n);
            this.__db.assertNotSuspendingTransaction();
            cursor = DBUtil.query(this.__db, roomSQLiteQuery, false, null);
            try {
                n15 = CursorUtil.getColumnIndexOrThrow(cursor, "id");
                n14 = CursorUtil.getColumnIndexOrThrow(cursor, "state");
                n13 = CursorUtil.getColumnIndexOrThrow(cursor, "worker_class_name");
                n12 = CursorUtil.getColumnIndexOrThrow(cursor, "input_merger_class_name");
                n11 = CursorUtil.getColumnIndexOrThrow(cursor, "input");
                n10 = CursorUtil.getColumnIndexOrThrow(cursor, "output");
                n9 = CursorUtil.getColumnIndexOrThrow(cursor, "initial_delay");
                n8 = CursorUtil.getColumnIndexOrThrow(cursor, "interval_duration");
                n7 = CursorUtil.getColumnIndexOrThrow(cursor, "flex_duration");
                n6 = CursorUtil.getColumnIndexOrThrow(cursor, "run_attempt_count");
                n5 = CursorUtil.getColumnIndexOrThrow(cursor, "backoff_policy");
            }
            catch (Throwable throwable) {
                // empty catch block
                break block15;
            }
            try {
                n4 = CursorUtil.getColumnIndexOrThrow(cursor, "backoff_delay_duration");
            }
            catch (Throwable throwable) {
                break block15;
            }
            try {
                n3 = CursorUtil.getColumnIndexOrThrow(cursor, "last_enqueue_time");
                n2 = CursorUtil.getColumnIndexOrThrow(cursor, "minimum_retention_duration");
            }
            catch (Throwable throwable) {
                break block15;
            }
            try {
                int n16 = CursorUtil.getColumnIndexOrThrow(cursor, "schedule_requested_at");
                int n17 = CursorUtil.getColumnIndexOrThrow(cursor, "run_in_foreground");
                int n18 = CursorUtil.getColumnIndexOrThrow(cursor, "out_of_quota_policy");
                int n19 = CursorUtil.getColumnIndexOrThrow(cursor, "period_count");
                int n20 = CursorUtil.getColumnIndexOrThrow(cursor, "generation");
                int n21 = CursorUtil.getColumnIndexOrThrow(cursor, "next_schedule_time_override");
                int n22 = CursorUtil.getColumnIndexOrThrow(cursor, "next_schedule_time_override_generation");
                int n23 = CursorUtil.getColumnIndexOrThrow(cursor, "stop_reason");
                int n24 = CursorUtil.getColumnIndexOrThrow(cursor, "required_network_type");
                int n25 = CursorUtil.getColumnIndexOrThrow(cursor, "requires_charging");
                int n26 = CursorUtil.getColumnIndexOrThrow(cursor, "requires_device_idle");
                int n27 = CursorUtil.getColumnIndexOrThrow(cursor, "requires_battery_not_low");
                n = CursorUtil.getColumnIndexOrThrow(cursor, "requires_storage_not_low");
                int n28 = CursorUtil.getColumnIndexOrThrow(cursor, "trigger_content_update_delay");
                int n29 = CursorUtil.getColumnIndexOrThrow(cursor, "trigger_max_content_delay");
                int n30 = CursorUtil.getColumnIndexOrThrow(cursor, "content_uri_triggers");
                arrayList = new ArrayList<WorkSpec>(cursor.getCount());
                while (cursor.moveToNext()) {
                    void var65_75;
                    void var65_69;
                    void var65_66;
                    String string2 = cursor.isNull(n15) ? null : cursor.getString(n15);
                    int n31 = cursor.getInt(n14);
                    Object object = WorkTypeConverters.INSTANCE;
                    WorkInfo.State state = WorkTypeConverters.intToState(n31);
                    object = cursor.isNull(n13) ? null : cursor.getString(n13);
                    String string3 = cursor.isNull(n12) ? null : cursor.getString(n12);
                    if (cursor.isNull(n11)) {
                        Object var65_64 = null;
                    } else {
                        byte[] byArray = cursor.getBlob(n11);
                    }
                    Data data = Data.fromByteArray((byte[])var65_66);
                    if (cursor.isNull(n10)) {
                        Object var65_67 = null;
                    } else {
                        byte[] byArray = cursor.getBlob(n10);
                    }
                    Data data2 = Data.fromByteArray((byte[])var65_69);
                    long l = cursor.getLong(n9);
                    long l2 = cursor.getLong(n8);
                    long l3 = cursor.getLong(n7);
                    n31 = cursor.getInt(n6);
                    int n32 = cursor.getInt(n5);
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    BackoffPolicy backoffPolicy = WorkTypeConverters.intToBackoffPolicy(n32);
                    long l4 = cursor.getLong(n4);
                    long l5 = cursor.getLong(n3);
                    long l6 = cursor.getLong(n2);
                    long l7 = cursor.getLong(n16);
                    boolean bl = cursor.getInt(n17) != 0;
                    n32 = cursor.getInt(n18);
                    WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                    OutOfQuotaPolicy outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(n32);
                    n32 = cursor.getInt(n19);
                    int n33 = cursor.getInt(n20);
                    long l8 = cursor.getLong(n21);
                    int n34 = cursor.getInt(n22);
                    int n35 = cursor.getInt(n23);
                    int n36 = cursor.getInt(n24);
                    WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                    NetworkType networkType = WorkTypeConverters.intToNetworkType(n36);
                    boolean bl2 = cursor.getInt(n25) != 0;
                    boolean bl3 = cursor.getInt(n26) != 0;
                    boolean bl4 = cursor.getInt(n27) != 0;
                    boolean bl5 = cursor.getInt(n) != 0;
                    long l9 = cursor.getLong(n28);
                    long l10 = cursor.getLong(n29);
                    if (cursor.isNull(n30)) {
                        Object var65_73 = null;
                    } else {
                        byte[] byArray = cursor.getBlob(n30);
                    }
                    Object object2 = WorkTypeConverters.INSTANCE;
                    object2 = WorkTypeConverters.byteArrayToSetOfTriggers((byte[])var65_75);
                    Constraints constraints = new Constraints(networkType, bl2, bl3, bl4, bl5, l9, l10, (Set<Constraints.ContentUriTrigger>)object2);
                    WorkSpec workSpec = new WorkSpec(string2, state, (String)object, string3, data, data2, l, l2, l3, constraints, n31, backoffPolicy, l4, l5, l6, l7, bl, outOfQuotaPolicy, n32, n33, l8, n34, n35);
                    arrayList.add(workSpec);
                }
            }
            catch (Throwable throwable) {
                break block15;
            }
            cursor.close();
            roomSQLiteQuery.release();
            return arrayList;
        }
        cursor.close();
        roomSQLiteQuery.release();
        throw var62_60;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public List<String> getAllUnfinishedWork() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor = DBUtil.query(this.__db, roomSQLiteQuery, false, null);
        try {
            ArrayList<String> arrayList = new ArrayList<String>(cursor.getCount());
            while (cursor.moveToNext()) {
                String string2 = cursor.isNull(0) ? null : cursor.getString(0);
                arrayList.add(string2);
            }
            return arrayList;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public List<String> getAllWorkSpecIds() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT id FROM workspec", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor = DBUtil.query(this.__db, roomSQLiteQuery, false, null);
        try {
            ArrayList<String> arrayList = new ArrayList<String>(cursor.getCount());
            while (cursor.moveToNext()) {
                String string2 = cursor.isNull(0) ? null : cursor.getString(0);
                arrayList.add(string2);
            }
            return arrayList;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    @Override
    public LiveData<List<String>> getAllWorkSpecIdsLiveData() {
        Object object = RoomSQLiteQuery.acquire("SELECT id FROM workspec", 0);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        object = new Callable<List<String>>(){
            final WorkSpecDao_Impl this$0;
            final RoomSQLiteQuery val$_statement;
            {
                this.this$0 = workSpecDao_Impl;
                this.val$_statement = roomSQLiteQuery;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public List<String> call() throws Exception {
                ArrayList<String> arrayList;
                this.this$0.__db.beginTransaction();
                Cursor cursor = DBUtil.query(this.this$0.__db, this.val$_statement, false, null);
                try {
                    arrayList = new ArrayList<String>(cursor.getCount());
                    while (cursor.moveToNext()) {
                        String string2 = cursor.isNull(0) ? null : cursor.getString(0);
                        arrayList.add(string2);
                    }
                    this.this$0.__db.setTransactionSuccessful();
                }
                catch (Throwable throwable) {
                    cursor.close();
                    throw throwable;
                }
                try {
                    cursor.close();
                    return arrayList;
                }
                finally {
                    this.this$0.__db.endTransaction();
                }
            }

            protected void finalize() {
                this.val$_statement.release();
            }
        };
        return invalidationTracker.createLiveData(new String[]{"workspec"}, true, object);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public List<WorkSpec> getEligibleWorkForScheduling(int n) {
        void var62_60;
        Cursor cursor;
        RoomSQLiteQuery roomSQLiteQuery;
        block15: {
            ArrayList<WorkSpec> arrayList;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            int n15;
            roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND LENGTH(content_uri_triggers)=0 AND state NOT IN (2, 3, 5))", 1);
            roomSQLiteQuery.bindLong(1, n);
            this.__db.assertNotSuspendingTransaction();
            cursor = DBUtil.query(this.__db, roomSQLiteQuery, false, null);
            try {
                n15 = CursorUtil.getColumnIndexOrThrow(cursor, "id");
                n14 = CursorUtil.getColumnIndexOrThrow(cursor, "state");
                n13 = CursorUtil.getColumnIndexOrThrow(cursor, "worker_class_name");
                n12 = CursorUtil.getColumnIndexOrThrow(cursor, "input_merger_class_name");
                n11 = CursorUtil.getColumnIndexOrThrow(cursor, "input");
                n10 = CursorUtil.getColumnIndexOrThrow(cursor, "output");
                n9 = CursorUtil.getColumnIndexOrThrow(cursor, "initial_delay");
                n8 = CursorUtil.getColumnIndexOrThrow(cursor, "interval_duration");
                n7 = CursorUtil.getColumnIndexOrThrow(cursor, "flex_duration");
                n6 = CursorUtil.getColumnIndexOrThrow(cursor, "run_attempt_count");
                n5 = CursorUtil.getColumnIndexOrThrow(cursor, "backoff_policy");
            }
            catch (Throwable throwable) {
                // empty catch block
                break block15;
            }
            try {
                n4 = CursorUtil.getColumnIndexOrThrow(cursor, "backoff_delay_duration");
            }
            catch (Throwable throwable) {
                break block15;
            }
            try {
                n3 = CursorUtil.getColumnIndexOrThrow(cursor, "last_enqueue_time");
                n2 = CursorUtil.getColumnIndexOrThrow(cursor, "minimum_retention_duration");
            }
            catch (Throwable throwable) {
                break block15;
            }
            try {
                int n16 = CursorUtil.getColumnIndexOrThrow(cursor, "schedule_requested_at");
                int n17 = CursorUtil.getColumnIndexOrThrow(cursor, "run_in_foreground");
                int n18 = CursorUtil.getColumnIndexOrThrow(cursor, "out_of_quota_policy");
                int n19 = CursorUtil.getColumnIndexOrThrow(cursor, "period_count");
                int n20 = CursorUtil.getColumnIndexOrThrow(cursor, "generation");
                int n21 = CursorUtil.getColumnIndexOrThrow(cursor, "next_schedule_time_override");
                int n22 = CursorUtil.getColumnIndexOrThrow(cursor, "next_schedule_time_override_generation");
                int n23 = CursorUtil.getColumnIndexOrThrow(cursor, "stop_reason");
                int n24 = CursorUtil.getColumnIndexOrThrow(cursor, "required_network_type");
                int n25 = CursorUtil.getColumnIndexOrThrow(cursor, "requires_charging");
                int n26 = CursorUtil.getColumnIndexOrThrow(cursor, "requires_device_idle");
                int n27 = CursorUtil.getColumnIndexOrThrow(cursor, "requires_battery_not_low");
                n = CursorUtil.getColumnIndexOrThrow(cursor, "requires_storage_not_low");
                int n28 = CursorUtil.getColumnIndexOrThrow(cursor, "trigger_content_update_delay");
                int n29 = CursorUtil.getColumnIndexOrThrow(cursor, "trigger_max_content_delay");
                int n30 = CursorUtil.getColumnIndexOrThrow(cursor, "content_uri_triggers");
                arrayList = new ArrayList<WorkSpec>(cursor.getCount());
                while (cursor.moveToNext()) {
                    void var65_75;
                    void var65_69;
                    void var65_66;
                    String string2 = cursor.isNull(n15) ? null : cursor.getString(n15);
                    int n31 = cursor.getInt(n14);
                    Object object = WorkTypeConverters.INSTANCE;
                    WorkInfo.State state = WorkTypeConverters.intToState(n31);
                    object = cursor.isNull(n13) ? null : cursor.getString(n13);
                    String string3 = cursor.isNull(n12) ? null : cursor.getString(n12);
                    if (cursor.isNull(n11)) {
                        Object var65_64 = null;
                    } else {
                        byte[] byArray = cursor.getBlob(n11);
                    }
                    Data data = Data.fromByteArray((byte[])var65_66);
                    if (cursor.isNull(n10)) {
                        Object var65_67 = null;
                    } else {
                        byte[] byArray = cursor.getBlob(n10);
                    }
                    Data data2 = Data.fromByteArray((byte[])var65_69);
                    long l = cursor.getLong(n9);
                    long l2 = cursor.getLong(n8);
                    long l3 = cursor.getLong(n7);
                    n31 = cursor.getInt(n6);
                    int n32 = cursor.getInt(n5);
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    BackoffPolicy backoffPolicy = WorkTypeConverters.intToBackoffPolicy(n32);
                    long l4 = cursor.getLong(n4);
                    long l5 = cursor.getLong(n3);
                    long l6 = cursor.getLong(n2);
                    long l7 = cursor.getLong(n16);
                    boolean bl = cursor.getInt(n17) != 0;
                    n32 = cursor.getInt(n18);
                    WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                    OutOfQuotaPolicy outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(n32);
                    n32 = cursor.getInt(n19);
                    int n33 = cursor.getInt(n20);
                    long l8 = cursor.getLong(n21);
                    int n34 = cursor.getInt(n22);
                    int n35 = cursor.getInt(n23);
                    int n36 = cursor.getInt(n24);
                    WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                    NetworkType networkType = WorkTypeConverters.intToNetworkType(n36);
                    boolean bl2 = cursor.getInt(n25) != 0;
                    boolean bl3 = cursor.getInt(n26) != 0;
                    boolean bl4 = cursor.getInt(n27) != 0;
                    boolean bl5 = cursor.getInt(n) != 0;
                    long l9 = cursor.getLong(n28);
                    long l10 = cursor.getLong(n29);
                    if (cursor.isNull(n30)) {
                        Object var65_73 = null;
                    } else {
                        byte[] byArray = cursor.getBlob(n30);
                    }
                    Object object2 = WorkTypeConverters.INSTANCE;
                    object2 = WorkTypeConverters.byteArrayToSetOfTriggers((byte[])var65_75);
                    Constraints constraints = new Constraints(networkType, bl2, bl3, bl4, bl5, l9, l10, (Set<Constraints.ContentUriTrigger>)object2);
                    WorkSpec workSpec = new WorkSpec(string2, state, (String)object, string3, data, data2, l, l2, l3, constraints, n31, backoffPolicy, l4, l5, l6, l7, bl, outOfQuotaPolicy, n32, n33, l8, n34, n35);
                    arrayList.add(workSpec);
                }
            }
            catch (Throwable throwable) {
                break block15;
            }
            cursor.close();
            roomSQLiteQuery.release();
            return arrayList;
        }
        cursor.close();
        roomSQLiteQuery.release();
        throw var62_60;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public List<WorkSpec> getEligibleWorkForSchedulingWithContentUris() {
        void var62_59;
        Cursor cursor;
        RoomSQLiteQuery roomSQLiteQuery;
        block13: {
            ArrayList<WorkSpec> arrayList;
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 AND LENGTH(content_uri_triggers)<>0 ORDER BY last_enqueue_time", 0);
            this.__db.assertNotSuspendingTransaction();
            cursor = DBUtil.query(this.__db, roomSQLiteQuery, false, null);
            try {
                n14 = CursorUtil.getColumnIndexOrThrow(cursor, "id");
                n13 = CursorUtil.getColumnIndexOrThrow(cursor, "state");
                n12 = CursorUtil.getColumnIndexOrThrow(cursor, "worker_class_name");
                n11 = CursorUtil.getColumnIndexOrThrow(cursor, "input_merger_class_name");
                n10 = CursorUtil.getColumnIndexOrThrow(cursor, "input");
                n9 = CursorUtil.getColumnIndexOrThrow(cursor, "output");
                n8 = CursorUtil.getColumnIndexOrThrow(cursor, "initial_delay");
                n7 = CursorUtil.getColumnIndexOrThrow(cursor, "interval_duration");
                n6 = CursorUtil.getColumnIndexOrThrow(cursor, "flex_duration");
                n5 = CursorUtil.getColumnIndexOrThrow(cursor, "run_attempt_count");
                n4 = CursorUtil.getColumnIndexOrThrow(cursor, "backoff_policy");
                n3 = CursorUtil.getColumnIndexOrThrow(cursor, "backoff_delay_duration");
                n2 = CursorUtil.getColumnIndexOrThrow(cursor, "last_enqueue_time");
            }
            catch (Throwable throwable) {
                // empty catch block
                break block13;
            }
            try {
                n = CursorUtil.getColumnIndexOrThrow(cursor, "minimum_retention_duration");
            }
            catch (Throwable throwable) {
                break block13;
            }
            try {
                int n15 = CursorUtil.getColumnIndexOrThrow(cursor, "schedule_requested_at");
                int n16 = CursorUtil.getColumnIndexOrThrow(cursor, "run_in_foreground");
                int n17 = CursorUtil.getColumnIndexOrThrow(cursor, "out_of_quota_policy");
                int n18 = CursorUtil.getColumnIndexOrThrow(cursor, "period_count");
                int n19 = CursorUtil.getColumnIndexOrThrow(cursor, "generation");
                int n20 = CursorUtil.getColumnIndexOrThrow(cursor, "next_schedule_time_override");
                int n21 = CursorUtil.getColumnIndexOrThrow(cursor, "next_schedule_time_override_generation");
                int n22 = CursorUtil.getColumnIndexOrThrow(cursor, "stop_reason");
                int n23 = CursorUtil.getColumnIndexOrThrow(cursor, "required_network_type");
                int n24 = CursorUtil.getColumnIndexOrThrow(cursor, "requires_charging");
                int n25 = CursorUtil.getColumnIndexOrThrow(cursor, "requires_device_idle");
                int n26 = CursorUtil.getColumnIndexOrThrow(cursor, "requires_battery_not_low");
                int n27 = CursorUtil.getColumnIndexOrThrow(cursor, "requires_storage_not_low");
                int n28 = CursorUtil.getColumnIndexOrThrow(cursor, "trigger_content_update_delay");
                int n29 = CursorUtil.getColumnIndexOrThrow(cursor, "trigger_max_content_delay");
                int n30 = CursorUtil.getColumnIndexOrThrow(cursor, "content_uri_triggers");
                arrayList = new ArrayList<WorkSpec>(cursor.getCount());
                while (cursor.moveToNext()) {
                    void var65_74;
                    void var65_68;
                    void var65_65;
                    String string2 = cursor.isNull(n14) ? null : cursor.getString(n14);
                    int n31 = cursor.getInt(n13);
                    Object object = WorkTypeConverters.INSTANCE;
                    WorkInfo.State state = WorkTypeConverters.intToState(n31);
                    object = cursor.isNull(n12) ? null : cursor.getString(n12);
                    String string3 = cursor.isNull(n11) ? null : cursor.getString(n11);
                    if (cursor.isNull(n10)) {
                        Object var65_63 = null;
                    } else {
                        byte[] byArray = cursor.getBlob(n10);
                    }
                    Data data = Data.fromByteArray((byte[])var65_65);
                    if (cursor.isNull(n9)) {
                        Object var65_66 = null;
                    } else {
                        byte[] byArray = cursor.getBlob(n9);
                    }
                    Data data2 = Data.fromByteArray((byte[])var65_68);
                    long l = cursor.getLong(n8);
                    long l2 = cursor.getLong(n7);
                    long l3 = cursor.getLong(n6);
                    n31 = cursor.getInt(n5);
                    int n32 = cursor.getInt(n4);
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    BackoffPolicy backoffPolicy = WorkTypeConverters.intToBackoffPolicy(n32);
                    long l4 = cursor.getLong(n3);
                    long l5 = cursor.getLong(n2);
                    long l6 = cursor.getLong(n);
                    long l7 = cursor.getLong(n15);
                    boolean bl = cursor.getInt(n16) != 0;
                    n32 = cursor.getInt(n17);
                    WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                    OutOfQuotaPolicy outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(n32);
                    n32 = cursor.getInt(n18);
                    int n33 = cursor.getInt(n19);
                    long l8 = cursor.getLong(n20);
                    int n34 = cursor.getInt(n21);
                    int n35 = cursor.getInt(n22);
                    int n36 = cursor.getInt(n23);
                    WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                    NetworkType networkType = WorkTypeConverters.intToNetworkType(n36);
                    boolean bl2 = cursor.getInt(n24) != 0;
                    boolean bl3 = cursor.getInt(n25) != 0;
                    boolean bl4 = cursor.getInt(n26) != 0;
                    boolean bl5 = cursor.getInt(n27) != 0;
                    long l9 = cursor.getLong(n28);
                    long l10 = cursor.getLong(n29);
                    if (cursor.isNull(n30)) {
                        Object var65_72 = null;
                    } else {
                        byte[] byArray = cursor.getBlob(n30);
                    }
                    Object object2 = WorkTypeConverters.INSTANCE;
                    object2 = WorkTypeConverters.byteArrayToSetOfTriggers((byte[])var65_74);
                    Constraints constraints = new Constraints(networkType, bl2, bl3, bl4, bl5, l9, l10, (Set<Constraints.ContentUriTrigger>)object2);
                    WorkSpec workSpec = new WorkSpec(string2, state, (String)object, string3, data, data2, l, l2, l3, constraints, n31, backoffPolicy, l4, l5, l6, l7, bl, outOfQuotaPolicy, n32, n33, l8, n34, n35);
                    arrayList.add(workSpec);
                }
            }
            catch (Throwable throwable) {
                break block13;
            }
            cursor.close();
            roomSQLiteQuery.release();
            return arrayList;
        }
        cursor.close();
        roomSQLiteQuery.release();
        throw var62_59;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public List<Data> getInputsFromPrerequisites(String object) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (object == null) {
            roomSQLiteQuery.bindNull(1);
        } else {
            roomSQLiteQuery.bindString(1, (String)object);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor = DBUtil.query(this.__db, roomSQLiteQuery, false, null);
        try {
            ArrayList<Data> arrayList = new ArrayList<Data>(cursor.getCount());
            while (cursor.moveToNext()) {
                object = cursor.isNull(0) ? null : (Object)cursor.getBlob(0);
                arrayList.add(Data.fromByteArray((byte[])object));
            }
            return arrayList;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public List<WorkSpec> getRecentlyCompletedWork(long l) {
        void var62_60;
        Cursor cursor;
        RoomSQLiteQuery roomSQLiteQuery;
        block15: {
            ArrayList<WorkSpec> arrayList;
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC", 1);
            roomSQLiteQuery.bindLong(1, l);
            this.__db.assertNotSuspendingTransaction();
            cursor = DBUtil.query(this.__db, roomSQLiteQuery, false, null);
            try {
                n14 = CursorUtil.getColumnIndexOrThrow(cursor, "id");
                n13 = CursorUtil.getColumnIndexOrThrow(cursor, "state");
                n12 = CursorUtil.getColumnIndexOrThrow(cursor, "worker_class_name");
                n11 = CursorUtil.getColumnIndexOrThrow(cursor, "input_merger_class_name");
                n10 = CursorUtil.getColumnIndexOrThrow(cursor, "input");
                n9 = CursorUtil.getColumnIndexOrThrow(cursor, "output");
                n8 = CursorUtil.getColumnIndexOrThrow(cursor, "initial_delay");
                n7 = CursorUtil.getColumnIndexOrThrow(cursor, "interval_duration");
                n6 = CursorUtil.getColumnIndexOrThrow(cursor, "flex_duration");
                n5 = CursorUtil.getColumnIndexOrThrow(cursor, "run_attempt_count");
            }
            catch (Throwable throwable) {
                // empty catch block
                break block15;
            }
            try {
                n4 = CursorUtil.getColumnIndexOrThrow(cursor, "backoff_policy");
            }
            catch (Throwable throwable) {
                break block15;
            }
            try {
                n3 = CursorUtil.getColumnIndexOrThrow(cursor, "backoff_delay_duration");
                n2 = CursorUtil.getColumnIndexOrThrow(cursor, "last_enqueue_time");
                n = CursorUtil.getColumnIndexOrThrow(cursor, "minimum_retention_duration");
            }
            catch (Throwable throwable) {
                break block15;
            }
            try {
                int n15 = CursorUtil.getColumnIndexOrThrow(cursor, "schedule_requested_at");
                int n16 = CursorUtil.getColumnIndexOrThrow(cursor, "run_in_foreground");
                int n17 = CursorUtil.getColumnIndexOrThrow(cursor, "out_of_quota_policy");
                int n18 = CursorUtil.getColumnIndexOrThrow(cursor, "period_count");
                int n19 = CursorUtil.getColumnIndexOrThrow(cursor, "generation");
                int n20 = CursorUtil.getColumnIndexOrThrow(cursor, "next_schedule_time_override");
                int n21 = CursorUtil.getColumnIndexOrThrow(cursor, "next_schedule_time_override_generation");
                int n22 = CursorUtil.getColumnIndexOrThrow(cursor, "stop_reason");
                int n23 = CursorUtil.getColumnIndexOrThrow(cursor, "required_network_type");
                int n24 = CursorUtil.getColumnIndexOrThrow(cursor, "requires_charging");
                int n25 = CursorUtil.getColumnIndexOrThrow(cursor, "requires_device_idle");
                int n26 = CursorUtil.getColumnIndexOrThrow(cursor, "requires_battery_not_low");
                int n27 = CursorUtil.getColumnIndexOrThrow(cursor, "requires_storage_not_low");
                int n28 = CursorUtil.getColumnIndexOrThrow(cursor, "trigger_content_update_delay");
                int n29 = CursorUtil.getColumnIndexOrThrow(cursor, "trigger_max_content_delay");
                int n30 = CursorUtil.getColumnIndexOrThrow(cursor, "content_uri_triggers");
                arrayList = new ArrayList<WorkSpec>(cursor.getCount());
                while (cursor.moveToNext()) {
                    void var65_75;
                    void var65_69;
                    void var65_66;
                    String string2 = cursor.isNull(n14) ? null : cursor.getString(n14);
                    int n31 = cursor.getInt(n13);
                    Object object = WorkTypeConverters.INSTANCE;
                    WorkInfo.State state = WorkTypeConverters.intToState(n31);
                    object = cursor.isNull(n12) ? null : cursor.getString(n12);
                    String string3 = cursor.isNull(n11) ? null : cursor.getString(n11);
                    if (cursor.isNull(n10)) {
                        Object var65_64 = null;
                    } else {
                        byte[] byArray = cursor.getBlob(n10);
                    }
                    Data data = Data.fromByteArray((byte[])var65_66);
                    if (cursor.isNull(n9)) {
                        Object var65_67 = null;
                    } else {
                        byte[] byArray = cursor.getBlob(n9);
                    }
                    Data data2 = Data.fromByteArray((byte[])var65_69);
                    long l2 = cursor.getLong(n8);
                    l = cursor.getLong(n7);
                    long l3 = cursor.getLong(n6);
                    n31 = cursor.getInt(n5);
                    int n32 = cursor.getInt(n4);
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    BackoffPolicy backoffPolicy = WorkTypeConverters.intToBackoffPolicy(n32);
                    long l4 = cursor.getLong(n3);
                    long l5 = cursor.getLong(n2);
                    long l6 = cursor.getLong(n);
                    long l7 = cursor.getLong(n15);
                    boolean bl = cursor.getInt(n16) != 0;
                    n32 = cursor.getInt(n17);
                    WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                    OutOfQuotaPolicy outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(n32);
                    n32 = cursor.getInt(n18);
                    int n33 = cursor.getInt(n19);
                    long l8 = cursor.getLong(n20);
                    int n34 = cursor.getInt(n21);
                    int n35 = cursor.getInt(n22);
                    int n36 = cursor.getInt(n23);
                    WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                    NetworkType networkType = WorkTypeConverters.intToNetworkType(n36);
                    boolean bl2 = cursor.getInt(n24) != 0;
                    boolean bl3 = cursor.getInt(n25) != 0;
                    boolean bl4 = cursor.getInt(n26) != 0;
                    boolean bl5 = cursor.getInt(n27) != 0;
                    long l9 = cursor.getLong(n28);
                    long l10 = cursor.getLong(n29);
                    if (cursor.isNull(n30)) {
                        Object var65_73 = null;
                    } else {
                        byte[] byArray = cursor.getBlob(n30);
                    }
                    Object object2 = WorkTypeConverters.INSTANCE;
                    object2 = WorkTypeConverters.byteArrayToSetOfTriggers((byte[])var65_75);
                    Constraints constraints = new Constraints(networkType, bl2, bl3, bl4, bl5, l9, l10, (Set<Constraints.ContentUriTrigger>)object2);
                    WorkSpec workSpec = new WorkSpec(string2, state, (String)object, string3, data, data2, l2, l, l3, constraints, n31, backoffPolicy, l4, l5, l6, l7, bl, outOfQuotaPolicy, n32, n33, l8, n34, n35);
                    arrayList.add(workSpec);
                }
            }
            catch (Throwable throwable) {
                break block15;
            }
            cursor.close();
            roomSQLiteQuery.release();
            return arrayList;
        }
        cursor.close();
        roomSQLiteQuery.release();
        throw var62_60;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public List<WorkSpec> getRunningWork() {
        void var62_59;
        Cursor cursor;
        RoomSQLiteQuery roomSQLiteQuery;
        block13: {
            ArrayList<WorkSpec> arrayList;
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=1", 0);
            this.__db.assertNotSuspendingTransaction();
            cursor = DBUtil.query(this.__db, roomSQLiteQuery, false, null);
            try {
                n14 = CursorUtil.getColumnIndexOrThrow(cursor, "id");
                n13 = CursorUtil.getColumnIndexOrThrow(cursor, "state");
                n12 = CursorUtil.getColumnIndexOrThrow(cursor, "worker_class_name");
                n11 = CursorUtil.getColumnIndexOrThrow(cursor, "input_merger_class_name");
                n10 = CursorUtil.getColumnIndexOrThrow(cursor, "input");
                n9 = CursorUtil.getColumnIndexOrThrow(cursor, "output");
                n8 = CursorUtil.getColumnIndexOrThrow(cursor, "initial_delay");
                n7 = CursorUtil.getColumnIndexOrThrow(cursor, "interval_duration");
                n6 = CursorUtil.getColumnIndexOrThrow(cursor, "flex_duration");
                n5 = CursorUtil.getColumnIndexOrThrow(cursor, "run_attempt_count");
                n4 = CursorUtil.getColumnIndexOrThrow(cursor, "backoff_policy");
                n3 = CursorUtil.getColumnIndexOrThrow(cursor, "backoff_delay_duration");
                n2 = CursorUtil.getColumnIndexOrThrow(cursor, "last_enqueue_time");
            }
            catch (Throwable throwable) {
                // empty catch block
                break block13;
            }
            try {
                n = CursorUtil.getColumnIndexOrThrow(cursor, "minimum_retention_duration");
            }
            catch (Throwable throwable) {
                break block13;
            }
            try {
                int n15 = CursorUtil.getColumnIndexOrThrow(cursor, "schedule_requested_at");
                int n16 = CursorUtil.getColumnIndexOrThrow(cursor, "run_in_foreground");
                int n17 = CursorUtil.getColumnIndexOrThrow(cursor, "out_of_quota_policy");
                int n18 = CursorUtil.getColumnIndexOrThrow(cursor, "period_count");
                int n19 = CursorUtil.getColumnIndexOrThrow(cursor, "generation");
                int n20 = CursorUtil.getColumnIndexOrThrow(cursor, "next_schedule_time_override");
                int n21 = CursorUtil.getColumnIndexOrThrow(cursor, "next_schedule_time_override_generation");
                int n22 = CursorUtil.getColumnIndexOrThrow(cursor, "stop_reason");
                int n23 = CursorUtil.getColumnIndexOrThrow(cursor, "required_network_type");
                int n24 = CursorUtil.getColumnIndexOrThrow(cursor, "requires_charging");
                int n25 = CursorUtil.getColumnIndexOrThrow(cursor, "requires_device_idle");
                int n26 = CursorUtil.getColumnIndexOrThrow(cursor, "requires_battery_not_low");
                int n27 = CursorUtil.getColumnIndexOrThrow(cursor, "requires_storage_not_low");
                int n28 = CursorUtil.getColumnIndexOrThrow(cursor, "trigger_content_update_delay");
                int n29 = CursorUtil.getColumnIndexOrThrow(cursor, "trigger_max_content_delay");
                int n30 = CursorUtil.getColumnIndexOrThrow(cursor, "content_uri_triggers");
                arrayList = new ArrayList<WorkSpec>(cursor.getCount());
                while (cursor.moveToNext()) {
                    void var65_74;
                    void var65_68;
                    void var65_65;
                    String string2 = cursor.isNull(n14) ? null : cursor.getString(n14);
                    int n31 = cursor.getInt(n13);
                    Object object = WorkTypeConverters.INSTANCE;
                    WorkInfo.State state = WorkTypeConverters.intToState(n31);
                    object = cursor.isNull(n12) ? null : cursor.getString(n12);
                    String string3 = cursor.isNull(n11) ? null : cursor.getString(n11);
                    if (cursor.isNull(n10)) {
                        Object var65_63 = null;
                    } else {
                        byte[] byArray = cursor.getBlob(n10);
                    }
                    Data data = Data.fromByteArray((byte[])var65_65);
                    if (cursor.isNull(n9)) {
                        Object var65_66 = null;
                    } else {
                        byte[] byArray = cursor.getBlob(n9);
                    }
                    Data data2 = Data.fromByteArray((byte[])var65_68);
                    long l = cursor.getLong(n8);
                    long l2 = cursor.getLong(n7);
                    long l3 = cursor.getLong(n6);
                    n31 = cursor.getInt(n5);
                    int n32 = cursor.getInt(n4);
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    BackoffPolicy backoffPolicy = WorkTypeConverters.intToBackoffPolicy(n32);
                    long l4 = cursor.getLong(n3);
                    long l5 = cursor.getLong(n2);
                    long l6 = cursor.getLong(n);
                    long l7 = cursor.getLong(n15);
                    boolean bl = cursor.getInt(n16) != 0;
                    n32 = cursor.getInt(n17);
                    WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                    OutOfQuotaPolicy outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(n32);
                    n32 = cursor.getInt(n18);
                    int n33 = cursor.getInt(n19);
                    long l8 = cursor.getLong(n20);
                    int n34 = cursor.getInt(n21);
                    int n35 = cursor.getInt(n22);
                    int n36 = cursor.getInt(n23);
                    WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                    NetworkType networkType = WorkTypeConverters.intToNetworkType(n36);
                    boolean bl2 = cursor.getInt(n24) != 0;
                    boolean bl3 = cursor.getInt(n25) != 0;
                    boolean bl4 = cursor.getInt(n26) != 0;
                    boolean bl5 = cursor.getInt(n27) != 0;
                    long l9 = cursor.getLong(n28);
                    long l10 = cursor.getLong(n29);
                    if (cursor.isNull(n30)) {
                        Object var65_72 = null;
                    } else {
                        byte[] byArray = cursor.getBlob(n30);
                    }
                    Object object2 = WorkTypeConverters.INSTANCE;
                    object2 = WorkTypeConverters.byteArrayToSetOfTriggers((byte[])var65_74);
                    Constraints constraints = new Constraints(networkType, bl2, bl3, bl4, bl5, l9, l10, (Set<Constraints.ContentUriTrigger>)object2);
                    WorkSpec workSpec = new WorkSpec(string2, state, (String)object, string3, data, data2, l, l2, l3, constraints, n31, backoffPolicy, l4, l5, l6, l7, bl, outOfQuotaPolicy, n32, n33, l8, n34, n35);
                    arrayList.add(workSpec);
                }
            }
            catch (Throwable throwable) {
                break block13;
            }
            cursor.close();
            roomSQLiteQuery.release();
            return arrayList;
        }
        cursor.close();
        roomSQLiteQuery.release();
        throw var62_59;
    }

    @Override
    public LiveData<Long> getScheduleRequestedAtLiveData(String object) {
        Object object2 = RoomSQLiteQuery.acquire("SELECT schedule_requested_at FROM workspec WHERE id=?", 1);
        if (object == null) {
            ((RoomSQLiteQuery)object2).bindNull(1);
        } else {
            ((RoomSQLiteQuery)object2).bindString(1, (String)object);
        }
        object = this.__db.getInvalidationTracker();
        object2 = new Callable<Long>(){
            final WorkSpecDao_Impl this$0;
            final RoomSQLiteQuery val$_statement;
            {
                this.this$0 = workSpecDao_Impl;
                this.val$_statement = roomSQLiteQuery;
            }

            @Override
            public Long call() throws Exception {
                long l;
                Cursor cursor = DBUtil.query(this.this$0.__db, this.val$_statement, false, null);
                try {
                    l = cursor.moveToFirst() ? cursor.getLong(0) : 0L;
                }
                catch (Throwable throwable) {
                    cursor.close();
                    throw throwable;
                }
                cursor.close();
                return l;
            }

            protected void finalize() {
                this.val$_statement.release();
            }
        };
        return ((InvalidationTracker)object).createLiveData(new String[]{"workspec"}, false, object2);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public List<WorkSpec> getScheduledWork() {
        void var62_59;
        Cursor cursor;
        RoomSQLiteQuery roomSQLiteQuery;
        block13: {
            ArrayList<WorkSpec> arrayList;
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
            this.__db.assertNotSuspendingTransaction();
            cursor = DBUtil.query(this.__db, roomSQLiteQuery, false, null);
            try {
                n14 = CursorUtil.getColumnIndexOrThrow(cursor, "id");
                n13 = CursorUtil.getColumnIndexOrThrow(cursor, "state");
                n12 = CursorUtil.getColumnIndexOrThrow(cursor, "worker_class_name");
                n11 = CursorUtil.getColumnIndexOrThrow(cursor, "input_merger_class_name");
                n10 = CursorUtil.getColumnIndexOrThrow(cursor, "input");
                n9 = CursorUtil.getColumnIndexOrThrow(cursor, "output");
                n8 = CursorUtil.getColumnIndexOrThrow(cursor, "initial_delay");
                n7 = CursorUtil.getColumnIndexOrThrow(cursor, "interval_duration");
                n6 = CursorUtil.getColumnIndexOrThrow(cursor, "flex_duration");
                n5 = CursorUtil.getColumnIndexOrThrow(cursor, "run_attempt_count");
                n4 = CursorUtil.getColumnIndexOrThrow(cursor, "backoff_policy");
                n3 = CursorUtil.getColumnIndexOrThrow(cursor, "backoff_delay_duration");
                n2 = CursorUtil.getColumnIndexOrThrow(cursor, "last_enqueue_time");
            }
            catch (Throwable throwable) {
                // empty catch block
                break block13;
            }
            try {
                n = CursorUtil.getColumnIndexOrThrow(cursor, "minimum_retention_duration");
            }
            catch (Throwable throwable) {
                break block13;
            }
            try {
                int n15 = CursorUtil.getColumnIndexOrThrow(cursor, "schedule_requested_at");
                int n16 = CursorUtil.getColumnIndexOrThrow(cursor, "run_in_foreground");
                int n17 = CursorUtil.getColumnIndexOrThrow(cursor, "out_of_quota_policy");
                int n18 = CursorUtil.getColumnIndexOrThrow(cursor, "period_count");
                int n19 = CursorUtil.getColumnIndexOrThrow(cursor, "generation");
                int n20 = CursorUtil.getColumnIndexOrThrow(cursor, "next_schedule_time_override");
                int n21 = CursorUtil.getColumnIndexOrThrow(cursor, "next_schedule_time_override_generation");
                int n22 = CursorUtil.getColumnIndexOrThrow(cursor, "stop_reason");
                int n23 = CursorUtil.getColumnIndexOrThrow(cursor, "required_network_type");
                int n24 = CursorUtil.getColumnIndexOrThrow(cursor, "requires_charging");
                int n25 = CursorUtil.getColumnIndexOrThrow(cursor, "requires_device_idle");
                int n26 = CursorUtil.getColumnIndexOrThrow(cursor, "requires_battery_not_low");
                int n27 = CursorUtil.getColumnIndexOrThrow(cursor, "requires_storage_not_low");
                int n28 = CursorUtil.getColumnIndexOrThrow(cursor, "trigger_content_update_delay");
                int n29 = CursorUtil.getColumnIndexOrThrow(cursor, "trigger_max_content_delay");
                int n30 = CursorUtil.getColumnIndexOrThrow(cursor, "content_uri_triggers");
                arrayList = new ArrayList<WorkSpec>(cursor.getCount());
                while (cursor.moveToNext()) {
                    void var65_74;
                    void var65_68;
                    void var65_65;
                    String string2 = cursor.isNull(n14) ? null : cursor.getString(n14);
                    int n31 = cursor.getInt(n13);
                    Object object = WorkTypeConverters.INSTANCE;
                    WorkInfo.State state = WorkTypeConverters.intToState(n31);
                    object = cursor.isNull(n12) ? null : cursor.getString(n12);
                    String string3 = cursor.isNull(n11) ? null : cursor.getString(n11);
                    if (cursor.isNull(n10)) {
                        Object var65_63 = null;
                    } else {
                        byte[] byArray = cursor.getBlob(n10);
                    }
                    Data data = Data.fromByteArray((byte[])var65_65);
                    if (cursor.isNull(n9)) {
                        Object var65_66 = null;
                    } else {
                        byte[] byArray = cursor.getBlob(n9);
                    }
                    Data data2 = Data.fromByteArray((byte[])var65_68);
                    long l = cursor.getLong(n8);
                    long l2 = cursor.getLong(n7);
                    long l3 = cursor.getLong(n6);
                    n31 = cursor.getInt(n5);
                    int n32 = cursor.getInt(n4);
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    BackoffPolicy backoffPolicy = WorkTypeConverters.intToBackoffPolicy(n32);
                    long l4 = cursor.getLong(n3);
                    long l5 = cursor.getLong(n2);
                    long l6 = cursor.getLong(n);
                    long l7 = cursor.getLong(n15);
                    boolean bl = cursor.getInt(n16) != 0;
                    n32 = cursor.getInt(n17);
                    WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                    OutOfQuotaPolicy outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(n32);
                    n32 = cursor.getInt(n18);
                    int n33 = cursor.getInt(n19);
                    long l8 = cursor.getLong(n20);
                    int n34 = cursor.getInt(n21);
                    int n35 = cursor.getInt(n22);
                    int n36 = cursor.getInt(n23);
                    WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                    NetworkType networkType = WorkTypeConverters.intToNetworkType(n36);
                    boolean bl2 = cursor.getInt(n24) != 0;
                    boolean bl3 = cursor.getInt(n25) != 0;
                    boolean bl4 = cursor.getInt(n26) != 0;
                    boolean bl5 = cursor.getInt(n27) != 0;
                    long l9 = cursor.getLong(n28);
                    long l10 = cursor.getLong(n29);
                    if (cursor.isNull(n30)) {
                        Object var65_72 = null;
                    } else {
                        byte[] byArray = cursor.getBlob(n30);
                    }
                    Object object2 = WorkTypeConverters.INSTANCE;
                    object2 = WorkTypeConverters.byteArrayToSetOfTriggers((byte[])var65_74);
                    Constraints constraints = new Constraints(networkType, bl2, bl3, bl4, bl5, l9, l10, (Set<Constraints.ContentUriTrigger>)object2);
                    WorkSpec workSpec = new WorkSpec(string2, state, (String)object, string3, data, data2, l, l2, l3, constraints, n31, backoffPolicy, l4, l5, l6, l7, bl, outOfQuotaPolicy, n32, n33, l8, n34, n35);
                    arrayList.add(workSpec);
                }
            }
            catch (Throwable throwable) {
                break block13;
            }
            cursor.close();
            roomSQLiteQuery.release();
            return arrayList;
        }
        cursor.close();
        roomSQLiteQuery.release();
        throw var62_59;
    }

    @Override
    public WorkInfo.State getState(String object) {
        Cursor cursor;
        RoomSQLiteQuery roomSQLiteQuery;
        block11: {
            block10: {
                roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT state FROM workspec WHERE id=?", 1);
                if (object == null) {
                    roomSQLiteQuery.bindNull(1);
                } else {
                    roomSQLiteQuery.bindString(1, (String)object);
                }
                this.__db.assertNotSuspendingTransaction();
                cursor = DBUtil.query(this.__db, roomSQLiteQuery, false, null);
                if (!cursor.moveToFirst()) break block9;
                if (!cursor.isNull(0)) break block10;
                object = null;
            }
            object = cursor.getInt(0);
            if (object == null) {
                object = null;
            } else {
                block9: {
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    object = WorkTypeConverters.intToState((Integer)object);
                    break block11;
                }
                object = null;
            }
        }
        return object;
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public List<String> getUnfinishedWorkWithName(String string2) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (string2 == null) {
            roomSQLiteQuery.bindNull(1);
        } else {
            roomSQLiteQuery.bindString(1, string2);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor = DBUtil.query(this.__db, roomSQLiteQuery, false, null);
        try {
            ArrayList<String> arrayList = new ArrayList<String>(cursor.getCount());
            while (cursor.moveToNext()) {
                string2 = cursor.isNull(0) ? null : cursor.getString(0);
                arrayList.add(string2);
            }
            return arrayList;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public List<String> getUnfinishedWorkWithTag(String string2) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (string2 == null) {
            roomSQLiteQuery.bindNull(1);
        } else {
            roomSQLiteQuery.bindString(1, string2);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor = DBUtil.query(this.__db, roomSQLiteQuery, false, null);
        try {
            ArrayList<String> arrayList = new ArrayList<String>(cursor.getCount());
            while (cursor.moveToNext()) {
                string2 = cursor.isNull(0) ? null : cursor.getString(0);
                arrayList.add(string2);
            }
            return arrayList;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public WorkSpec getWorkSpec(String object) {
        void var1_6;
        Cursor cursor;
        RoomSQLiteQuery roomSQLiteQuery;
        block18: {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE id=?", 1);
            if (object == null) {
                roomSQLiteQuery.bindNull(1);
            } else {
                roomSQLiteQuery.bindString(1, (String)object);
            }
            this.__db.assertNotSuspendingTransaction();
            cursor = DBUtil.query(this.__db, roomSQLiteQuery, false, null);
            try {
                n14 = CursorUtil.getColumnIndexOrThrow(cursor, "id");
                n13 = CursorUtil.getColumnIndexOrThrow(cursor, "state");
                n12 = CursorUtil.getColumnIndexOrThrow(cursor, "worker_class_name");
                n11 = CursorUtil.getColumnIndexOrThrow(cursor, "input_merger_class_name");
                n10 = CursorUtil.getColumnIndexOrThrow(cursor, "input");
                n9 = CursorUtil.getColumnIndexOrThrow(cursor, "output");
                n8 = CursorUtil.getColumnIndexOrThrow(cursor, "initial_delay");
                n7 = CursorUtil.getColumnIndexOrThrow(cursor, "interval_duration");
                n6 = CursorUtil.getColumnIndexOrThrow(cursor, "flex_duration");
                n5 = CursorUtil.getColumnIndexOrThrow(cursor, "run_attempt_count");
                n4 = CursorUtil.getColumnIndexOrThrow(cursor, "backoff_policy");
                n3 = CursorUtil.getColumnIndexOrThrow(cursor, "backoff_delay_duration");
            }
            catch (Throwable throwable) {
                // empty catch block
                break block18;
            }
            try {
                n2 = CursorUtil.getColumnIndexOrThrow(cursor, "last_enqueue_time");
            }
            catch (Throwable throwable) {
                break block18;
            }
            try {
                n = CursorUtil.getColumnIndexOrThrow(cursor, "minimum_retention_duration");
            }
            catch (Throwable throwable) {
                break block18;
            }
            try {
                int n15 = CursorUtil.getColumnIndexOrThrow(cursor, "schedule_requested_at");
                int n16 = CursorUtil.getColumnIndexOrThrow(cursor, "run_in_foreground");
                int n17 = CursorUtil.getColumnIndexOrThrow(cursor, "out_of_quota_policy");
                int n18 = CursorUtil.getColumnIndexOrThrow(cursor, "period_count");
                int n19 = CursorUtil.getColumnIndexOrThrow(cursor, "generation");
                int n20 = CursorUtil.getColumnIndexOrThrow(cursor, "next_schedule_time_override");
                int n21 = CursorUtil.getColumnIndexOrThrow(cursor, "next_schedule_time_override_generation");
                int n22 = CursorUtil.getColumnIndexOrThrow(cursor, "stop_reason");
                int n23 = CursorUtil.getColumnIndexOrThrow(cursor, "required_network_type");
                int n24 = CursorUtil.getColumnIndexOrThrow(cursor, "requires_charging");
                int n25 = CursorUtil.getColumnIndexOrThrow(cursor, "requires_device_idle");
                int n26 = CursorUtil.getColumnIndexOrThrow(cursor, "requires_battery_not_low");
                int n27 = CursorUtil.getColumnIndexOrThrow(cursor, "requires_storage_not_low");
                int n28 = CursorUtil.getColumnIndexOrThrow(cursor, "trigger_content_update_delay");
                int n29 = CursorUtil.getColumnIndexOrThrow(cursor, "trigger_max_content_delay");
                int n30 = CursorUtil.getColumnIndexOrThrow(cursor, "content_uri_triggers");
                if (cursor.moveToFirst()) {
                    void var59_53;
                    void var59_47;
                    void var59_44;
                    object = cursor.isNull(n14) ? null : cursor.getString(n14);
                    n13 = cursor.getInt(n13);
                    Object object2 = WorkTypeConverters.INSTANCE;
                    WorkInfo.State state = WorkTypeConverters.intToState(n13);
                    object2 = cursor.isNull(n12) ? null : cursor.getString(n12);
                    String string2 = cursor.isNull(n11) ? null : cursor.getString(n11);
                    if (cursor.isNull(n10)) {
                        Object var59_42 = null;
                    } else {
                        byte[] byArray = cursor.getBlob(n10);
                    }
                    Data data = Data.fromByteArray((byte[])var59_44);
                    if (cursor.isNull(n9)) {
                        Object var59_45 = null;
                    } else {
                        byte[] byArray = cursor.getBlob(n9);
                    }
                    Data data2 = Data.fromByteArray((byte[])var59_47);
                    long l = cursor.getLong(n8);
                    long l2 = cursor.getLong(n7);
                    long l3 = cursor.getLong(n6);
                    n12 = cursor.getInt(n5);
                    n4 = cursor.getInt(n4);
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    BackoffPolicy backoffPolicy = WorkTypeConverters.intToBackoffPolicy(n4);
                    long l4 = cursor.getLong(n3);
                    long l5 = cursor.getLong(n2);
                    long l6 = cursor.getLong(n);
                    long l7 = cursor.getLong(n15);
                    boolean bl = cursor.getInt(n16) != 0;
                    n3 = cursor.getInt(n17);
                    WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                    OutOfQuotaPolicy outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(n3);
                    n18 = cursor.getInt(n18);
                    n19 = cursor.getInt(n19);
                    long l8 = cursor.getLong(n20);
                    n21 = cursor.getInt(n21);
                    n22 = cursor.getInt(n22);
                    n23 = cursor.getInt(n23);
                    WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                    NetworkType networkType = WorkTypeConverters.intToNetworkType(n23);
                    boolean bl2 = cursor.getInt(n24) != 0;
                    boolean bl3 = cursor.getInt(n25) != 0;
                    boolean bl4 = cursor.getInt(n26) != 0;
                    boolean bl5 = cursor.getInt(n27) != 0;
                    long l9 = cursor.getLong(n28);
                    long l10 = cursor.getLong(n29);
                    if (cursor.isNull(n30)) {
                        Object var59_51 = null;
                    } else {
                        byte[] byArray = cursor.getBlob(n30);
                    }
                    Object object3 = WorkTypeConverters.INSTANCE;
                    object3 = WorkTypeConverters.byteArrayToSetOfTriggers((byte[])var59_53);
                    Constraints constraints = new Constraints(networkType, bl2, bl3, bl4, bl5, l9, l10, (Set<Constraints.ContentUriTrigger>)object3);
                    object = new WorkSpec((String)object, state, (String)object2, string2, data, data2, l, l2, l3, constraints, n12, backoffPolicy, l4, l5, l6, l7, bl, outOfQuotaPolicy, n18, n19, l8, n21, n22);
                } else {
                    object = null;
                }
            }
            catch (Throwable throwable) {
                break block18;
            }
            cursor.close();
            roomSQLiteQuery.release();
            return object;
        }
        cursor.close();
        roomSQLiteQuery.release();
        throw var1_6;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public List<WorkSpec.IdAndState> getWorkSpecIdAndStatesForName(String string2) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (string2 == null) {
            roomSQLiteQuery.bindNull(1);
        } else {
            roomSQLiteQuery.bindString(1, string2);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor = DBUtil.query(this.__db, roomSQLiteQuery, false, null);
        try {
            ArrayList<WorkSpec.IdAndState> arrayList = new ArrayList<WorkSpec.IdAndState>(cursor.getCount());
            while (cursor.moveToNext()) {
                string2 = cursor.isNull(0) ? null : cursor.getString(0);
                int n = cursor.getInt(1);
                WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                WorkInfo.State state = WorkTypeConverters.intToState(n);
                WorkSpec.IdAndState idAndState = new WorkSpec.IdAndState(string2, state);
                arrayList.add(idAndState);
            }
            return arrayList;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    @Override
    public Flow<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoFlowDataForIds(List<String> object) {
        Object object2 = StringUtil.newStringBuilder();
        ((StringBuilder)object2).append("SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (");
        int n = object.size();
        StringUtil.appendPlaceholders((StringBuilder)object2, n);
        ((StringBuilder)object2).append(")");
        object2 = RoomSQLiteQuery.acquire(((StringBuilder)object2).toString(), n + 0);
        n = 1;
        Iterator<String> iterator2 = object.iterator();
        while (iterator2.hasNext()) {
            object = iterator2.next();
            if (object == null) {
                ((RoomSQLiteQuery)object2).bindNull(n);
            } else {
                ((RoomSQLiteQuery)object2).bindString(n, (String)object);
            }
            ++n;
        }
        object = this.__db;
        object2 = new Callable<List<WorkSpec.WorkInfoPojo>>(){
            final WorkSpecDao_Impl this$0;
            final RoomSQLiteQuery val$_statement;
            {
                this.this$0 = workSpecDao_Impl;
                this.val$_statement = roomSQLiteQuery;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                ArrayList<WorkSpec.WorkInfoPojo> arrayList;
                this.this$0.__db.beginTransaction();
                Cursor cursor = DBUtil.query(this.this$0.__db, this.val$_statement, true, null);
                boolean bl = false;
                boolean bl2 = true;
                int n = 2;
                int n2 = 3;
                try {
                    Object object;
                    Object object2;
                    HashMap hashMap = new HashMap();
                    HashMap hashMap2 = new HashMap();
                    while (cursor.moveToNext()) {
                        object2 = cursor.getString(0);
                        if ((ArrayList)hashMap.get(object2) == null) {
                            object = new ArrayList();
                            hashMap.put((String)object2, object);
                        }
                        if ((ArrayList)hashMap2.get(object2 = cursor.getString(0)) != null) continue;
                        object = new ArrayList();
                        hashMap2.put((String)object2, object);
                    }
                    object = hashMap2;
                    cursor.moveToPosition(-1);
                    this.this$0.__fetchRelationshipWorkTagAsjavaLangString(hashMap);
                    this.this$0.__fetchRelationshipWorkProgressAsandroidxWorkData(object);
                    arrayList = new ArrayList<WorkSpec.WorkInfoPojo>(cursor.getCount());
                    n = n2;
                    hashMap2 = hashMap;
                    hashMap = object;
                    while (cursor.moveToNext()) {
                        object = cursor.isNull(0) ? null : cursor.getString(0);
                        n2 = cursor.getInt(1);
                        object2 = WorkTypeConverters.INSTANCE;
                        WorkInfo.State state = WorkTypeConverters.intToState(n2);
                        object2 = cursor.isNull(2) ? null : (Object)cursor.getBlob(2);
                        Data data = Data.fromByteArray((byte[])object2);
                        int n3 = cursor.getInt(3);
                        n2 = cursor.getInt(4);
                        long l = cursor.getLong(13);
                        long l2 = cursor.getLong(14);
                        long l3 = cursor.getLong(15);
                        int n4 = cursor.getInt(16);
                        object2 = WorkTypeConverters.INSTANCE;
                        BackoffPolicy backoffPolicy = WorkTypeConverters.intToBackoffPolicy(n4);
                        long l4 = cursor.getLong(17);
                        long l5 = cursor.getLong(18);
                        int n5 = cursor.getInt(19);
                        long l6 = cursor.getLong(20);
                        n4 = cursor.getInt(21);
                        int n6 = cursor.getInt(5);
                        object2 = WorkTypeConverters.INSTANCE;
                        Object object3 = WorkTypeConverters.intToNetworkType(n6);
                        bl2 = cursor.getInt(6) != 0;
                        bl = cursor.getInt(7) != 0;
                        boolean bl3 = cursor.getInt(8) != 0;
                        boolean bl4 = cursor.getInt(9) != 0;
                        long l7 = cursor.getLong(10);
                        long l8 = cursor.getLong(11);
                        object2 = cursor.isNull(12) ? null : (Object)cursor.getBlob(12);
                        Object object4 = WorkTypeConverters.INSTANCE;
                        object2 = WorkTypeConverters.byteArrayToSetOfTriggers((byte[])object2);
                        object4 = new Constraints((NetworkType)((Object)object3), bl2, bl, bl3, bl4, l7, l8, (Set<Constraints.ContentUriTrigger>)object2);
                        object2 = (ArrayList)hashMap2.get(cursor.getString(0));
                        if (object2 == null) {
                            object2 = new Object();
                        }
                        if ((object3 = (ArrayList)hashMap.get(cursor.getString(0))) == null) {
                            object3 = new ArrayList();
                        }
                        WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo((String)object, state, data, l, l2, l3, (Constraints)object4, n3, backoffPolicy, l4, l5, n5, n2, l6, n4, (List<String>)object2, (List<Data>)object3);
                        arrayList.add(workInfoPojo);
                    }
                    this.this$0.__db.setTransactionSuccessful();
                }
                catch (Throwable throwable) {
                    cursor.close();
                    throw throwable;
                }
                try {
                    cursor.close();
                    return arrayList;
                }
                finally {
                    this.this$0.__db.endTransaction();
                }
            }

            protected void finalize() {
                this.val$_statement.release();
            }
        };
        return CoroutinesRoom.createFlow((RoomDatabase)object, true, new String[]{"WorkTag", "WorkProgress", "workspec"}, object2);
    }

    @Override
    public Flow<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoFlowForName(String object) {
        Object object2 = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (object == null) {
            ((RoomSQLiteQuery)object2).bindNull(1);
        } else {
            ((RoomSQLiteQuery)object2).bindString(1, (String)object);
        }
        object = this.__db;
        object2 = new Callable<List<WorkSpec.WorkInfoPojo>>(){
            final WorkSpecDao_Impl this$0;
            final RoomSQLiteQuery val$_statement;
            {
                this.this$0 = workSpecDao_Impl;
                this.val$_statement = roomSQLiteQuery;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                ArrayList<WorkSpec.WorkInfoPojo> arrayList;
                this.this$0.__db.beginTransaction();
                Cursor cursor = DBUtil.query(this.this$0.__db, this.val$_statement, true, null);
                boolean bl = false;
                boolean bl2 = true;
                int n = 2;
                int n2 = 3;
                try {
                    Collection<Constraints.ContentUriTrigger> collection;
                    Object object;
                    Cloneable cloneable = new HashMap();
                    HashMap hashMap = new HashMap();
                    while (cursor.moveToNext()) {
                        object = cursor.getString(0);
                        if ((ArrayList)((HashMap)cloneable).get(object) == null) {
                            collection = new Collection<Constraints.ContentUriTrigger>();
                            ((HashMap)cloneable).put(object, collection);
                        }
                        if ((ArrayList)hashMap.get(collection = cursor.getString(0)) != null) continue;
                        object = new ArrayList();
                        hashMap.put(collection, object);
                    }
                    object = hashMap;
                    cursor.moveToPosition(-1);
                    this.this$0.__fetchRelationshipWorkTagAsjavaLangString(cloneable);
                    this.this$0.__fetchRelationshipWorkProgressAsandroidxWorkData((HashMap)object);
                    arrayList = new ArrayList<WorkSpec.WorkInfoPojo>(cursor.getCount());
                    n = n2;
                    hashMap = cloneable;
                    cloneable = object;
                    while (cursor.moveToNext()) {
                        object = cursor.isNull(0) ? null : cursor.getString(0);
                        n2 = cursor.getInt(1);
                        collection = WorkTypeConverters.INSTANCE;
                        WorkInfo.State state = WorkTypeConverters.intToState(n2);
                        collection = cursor.isNull(2) ? null : (Collection<Constraints.ContentUriTrigger>)cursor.getBlob(2);
                        Data data = Data.fromByteArray((byte[])collection);
                        int n3 = cursor.getInt(3);
                        n2 = cursor.getInt(4);
                        long l = cursor.getLong(13);
                        long l2 = cursor.getLong(14);
                        long l3 = cursor.getLong(15);
                        int n4 = cursor.getInt(16);
                        collection = WorkTypeConverters.INSTANCE;
                        BackoffPolicy backoffPolicy = WorkTypeConverters.intToBackoffPolicy(n4);
                        long l4 = cursor.getLong(17);
                        long l5 = cursor.getLong(18);
                        int n5 = cursor.getInt(19);
                        long l6 = cursor.getLong(20);
                        int n6 = cursor.getInt(21);
                        n4 = cursor.getInt(5);
                        collection = WorkTypeConverters.INSTANCE;
                        Object object2 = WorkTypeConverters.intToNetworkType(n4);
                        bl2 = cursor.getInt(6) != 0;
                        bl = cursor.getInt(7) != 0;
                        boolean bl3 = cursor.getInt(8) != 0;
                        boolean bl4 = cursor.getInt(9) != 0;
                        long l7 = cursor.getLong(10);
                        long l8 = cursor.getLong(11);
                        collection = cursor.isNull(12) ? null : (Collection<Constraints.ContentUriTrigger>)cursor.getBlob(12);
                        Object object3 = WorkTypeConverters.INSTANCE;
                        collection = WorkTypeConverters.byteArrayToSetOfTriggers((byte[])collection);
                        object3 = new Constraints((NetworkType)((Object)object2), bl2, bl, bl3, bl4, l7, l8, (Set<Constraints.ContentUriTrigger>)collection);
                        collection = (ArrayList)hashMap.get(cursor.getString(0));
                        if (collection == null) {
                            collection = new Collection<Constraints.ContentUriTrigger>();
                        }
                        if ((object2 = (ArrayList)((HashMap)cloneable).get(cursor.getString(0))) == null) {
                            object2 = new ArrayList();
                        }
                        WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo((String)object, state, data, l, l2, l3, (Constraints)object3, n3, backoffPolicy, l4, l5, n5, n2, l6, n6, (List<String>)collection, (List<Data>)object2);
                        arrayList.add(workInfoPojo);
                    }
                    this.this$0.__db.setTransactionSuccessful();
                }
                catch (Throwable throwable) {
                    cursor.close();
                    throw throwable;
                }
                try {
                    cursor.close();
                    return arrayList;
                }
                finally {
                    this.this$0.__db.endTransaction();
                }
            }

            protected void finalize() {
                this.val$_statement.release();
            }
        };
        return CoroutinesRoom.createFlow((RoomDatabase)object, true, new String[]{"WorkTag", "WorkProgress", "workspec", "workname"}, object2);
    }

    @Override
    public Flow<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoFlowForTag(String object) {
        Object object2 = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (object == null) {
            ((RoomSQLiteQuery)object2).bindNull(1);
        } else {
            ((RoomSQLiteQuery)object2).bindString(1, (String)object);
        }
        object = this.__db;
        object2 = new Callable<List<WorkSpec.WorkInfoPojo>>(){
            final WorkSpecDao_Impl this$0;
            final RoomSQLiteQuery val$_statement;
            {
                this.this$0 = workSpecDao_Impl;
                this.val$_statement = roomSQLiteQuery;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                ArrayList<WorkSpec.WorkInfoPojo> arrayList;
                this.this$0.__db.beginTransaction();
                Cursor cursor = DBUtil.query(this.this$0.__db, this.val$_statement, true, null);
                boolean bl = false;
                boolean bl2 = true;
                int n = 2;
                int n2 = 3;
                try {
                    Object object;
                    Object object2;
                    HashMap hashMap = new HashMap();
                    HashMap hashMap2 = new HashMap();
                    while (cursor.moveToNext()) {
                        object2 = cursor.getString(0);
                        if ((ArrayList)hashMap.get(object2) == null) {
                            object = new ArrayList();
                            hashMap.put((String)object2, object);
                        }
                        if ((ArrayList)hashMap2.get(object2 = cursor.getString(0)) != null) continue;
                        object = new ArrayList();
                        hashMap2.put((String)object2, object);
                    }
                    object = hashMap2;
                    cursor.moveToPosition(-1);
                    this.this$0.__fetchRelationshipWorkTagAsjavaLangString(hashMap);
                    this.this$0.__fetchRelationshipWorkProgressAsandroidxWorkData(object);
                    arrayList = new ArrayList<WorkSpec.WorkInfoPojo>(cursor.getCount());
                    n = n2;
                    hashMap2 = hashMap;
                    hashMap = object;
                    while (cursor.moveToNext()) {
                        object = cursor.isNull(0) ? null : cursor.getString(0);
                        n2 = cursor.getInt(1);
                        object2 = WorkTypeConverters.INSTANCE;
                        WorkInfo.State state = WorkTypeConverters.intToState(n2);
                        object2 = cursor.isNull(2) ? null : (Object)cursor.getBlob(2);
                        Data data = Data.fromByteArray((byte[])object2);
                        n2 = cursor.getInt(3);
                        int n3 = cursor.getInt(4);
                        long l = cursor.getLong(13);
                        long l2 = cursor.getLong(14);
                        long l3 = cursor.getLong(15);
                        int n4 = cursor.getInt(16);
                        object2 = WorkTypeConverters.INSTANCE;
                        BackoffPolicy backoffPolicy = WorkTypeConverters.intToBackoffPolicy(n4);
                        long l4 = cursor.getLong(17);
                        long l5 = cursor.getLong(18);
                        int n5 = cursor.getInt(19);
                        long l6 = cursor.getLong(20);
                        n4 = cursor.getInt(21);
                        int n6 = cursor.getInt(5);
                        object2 = WorkTypeConverters.INSTANCE;
                        Object object3 = WorkTypeConverters.intToNetworkType(n6);
                        bl2 = cursor.getInt(6) != 0;
                        bl = cursor.getInt(7) != 0;
                        boolean bl3 = cursor.getInt(8) != 0;
                        boolean bl4 = cursor.getInt(9) != 0;
                        long l7 = cursor.getLong(10);
                        long l8 = cursor.getLong(11);
                        object2 = cursor.isNull(12) ? null : (Object)cursor.getBlob(12);
                        Object object4 = WorkTypeConverters.INSTANCE;
                        object2 = WorkTypeConverters.byteArrayToSetOfTriggers((byte[])object2);
                        object4 = new Constraints((NetworkType)((Object)object3), bl2, bl, bl3, bl4, l7, l8, (Set<Constraints.ContentUriTrigger>)object2);
                        object2 = (ArrayList)hashMap2.get(cursor.getString(0));
                        if (object2 == null) {
                            object2 = new Object();
                        }
                        if ((object3 = (ArrayList)hashMap.get(cursor.getString(0))) == null) {
                            object3 = new ArrayList();
                        }
                        WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo((String)object, state, data, l, l2, l3, (Constraints)object4, n2, backoffPolicy, l4, l5, n5, n3, l6, n4, (List<String>)object2, (List<Data>)object3);
                        arrayList.add(workInfoPojo);
                    }
                    this.this$0.__db.setTransactionSuccessful();
                }
                catch (Throwable throwable) {
                    cursor.close();
                    throw throwable;
                }
                try {
                    cursor.close();
                    return arrayList;
                }
                finally {
                    this.this$0.__db.endTransaction();
                }
            }

            protected void finalize() {
                this.val$_statement.release();
            }
        };
        return CoroutinesRoom.createFlow((RoomDatabase)object, true, new String[]{"WorkTag", "WorkProgress", "workspec", "worktag"}, object2);
    }

    /*
     * Exception decompiling
     */
    @Override
    public WorkSpec.WorkInfoPojo getWorkStatusPojoForId(String var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [31[UNCONDITIONALDOLOOP]], but top level block is 13[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    @Override
    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForIds(List<String> var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [42[UNCONDITIONALDOLOOP]], but top level block is 27[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    @Override
    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForName(String var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [38[UNCONDITIONALDOLOOP]], but top level block is 26[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    @Override
    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForTag(String var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [38[UNCONDITIONALDOLOOP]], but top level block is 26[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForIds(List<String> object) {
        Object object2 = StringUtil.newStringBuilder();
        ((StringBuilder)object2).append("SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (");
        int n = object.size();
        StringUtil.appendPlaceholders((StringBuilder)object2, n);
        ((StringBuilder)object2).append(")");
        object2 = RoomSQLiteQuery.acquire(((StringBuilder)object2).toString(), n + 0);
        n = 1;
        Iterator<String> iterator2 = object.iterator();
        while (iterator2.hasNext()) {
            object = iterator2.next();
            if (object == null) {
                ((RoomSQLiteQuery)object2).bindNull(n);
            } else {
                ((RoomSQLiteQuery)object2).bindString(n, (String)object);
            }
            ++n;
        }
        object = this.__db.getInvalidationTracker();
        object2 = new Callable<List<WorkSpec.WorkInfoPojo>>(){
            final WorkSpecDao_Impl this$0;
            final RoomSQLiteQuery val$_statement;
            {
                this.this$0 = workSpecDao_Impl;
                this.val$_statement = roomSQLiteQuery;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                ArrayList<WorkSpec.WorkInfoPojo> arrayList;
                this.this$0.__db.beginTransaction();
                Cursor cursor = DBUtil.query(this.this$0.__db, this.val$_statement, true, null);
                boolean bl = false;
                boolean bl2 = true;
                int n = 2;
                int n2 = 3;
                try {
                    Object object;
                    Object object2;
                    Object object3 = new HashMap();
                    HashMap hashMap = new HashMap();
                    while (cursor.moveToNext()) {
                        object2 = cursor.getString(0);
                        if ((ArrayList)((HashMap)object3).get(object2) == null) {
                            object = new ArrayList();
                            ((HashMap)object3).put(object2, object);
                        }
                        if ((ArrayList)hashMap.get(object = cursor.getString(0)) != null) continue;
                        object2 = new Object();
                        hashMap.put(object, object2);
                    }
                    object = hashMap;
                    cursor.moveToPosition(-1);
                    this.this$0.__fetchRelationshipWorkTagAsjavaLangString(object3);
                    this.this$0.__fetchRelationshipWorkProgressAsandroidxWorkData((HashMap)object);
                    arrayList = new ArrayList<WorkSpec.WorkInfoPojo>(cursor.getCount());
                    n = n2;
                    hashMap = object3;
                    object3 = object;
                    while (cursor.moveToNext()) {
                        object = cursor.isNull(0) ? null : cursor.getString(0);
                        n2 = cursor.getInt(1);
                        object2 = WorkTypeConverters.INSTANCE;
                        WorkInfo.State state = WorkTypeConverters.intToState(n2);
                        object2 = cursor.isNull(2) ? null : (Object)cursor.getBlob(2);
                        Data data = Data.fromByteArray((byte[])object2);
                        n2 = cursor.getInt(3);
                        int n3 = cursor.getInt(4);
                        long l = cursor.getLong(13);
                        long l2 = cursor.getLong(14);
                        long l3 = cursor.getLong(15);
                        int n4 = cursor.getInt(16);
                        object2 = WorkTypeConverters.INSTANCE;
                        BackoffPolicy backoffPolicy = WorkTypeConverters.intToBackoffPolicy(n4);
                        long l4 = cursor.getLong(17);
                        long l5 = cursor.getLong(18);
                        int n5 = cursor.getInt(19);
                        long l6 = cursor.getLong(20);
                        int n6 = cursor.getInt(21);
                        n4 = cursor.getInt(5);
                        object2 = WorkTypeConverters.INSTANCE;
                        Object object4 = WorkTypeConverters.intToNetworkType(n4);
                        bl2 = cursor.getInt(6) != 0;
                        bl = cursor.getInt(7) != 0;
                        boolean bl3 = cursor.getInt(8) != 0;
                        boolean bl4 = cursor.getInt(9) != 0;
                        long l7 = cursor.getLong(10);
                        long l8 = cursor.getLong(11);
                        object2 = cursor.isNull(12) ? null : (Object)cursor.getBlob(12);
                        Object object5 = WorkTypeConverters.INSTANCE;
                        object2 = WorkTypeConverters.byteArrayToSetOfTriggers((byte[])object2);
                        object5 = new Constraints((NetworkType)((Object)object4), bl2, bl, bl3, bl4, l7, l8, (Set<Constraints.ContentUriTrigger>)object2);
                        object2 = (ArrayList)hashMap.get(cursor.getString(0));
                        if (object2 == null) {
                            object2 = new Object();
                        }
                        if ((object4 = (ArrayList)((HashMap)object3).get(cursor.getString(0))) == null) {
                            object4 = new ArrayList();
                        }
                        WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo((String)object, state, data, l, l2, l3, (Constraints)object5, n2, backoffPolicy, l4, l5, n5, n3, l6, n6, (List<String>)object2, (List<Data>)object4);
                        arrayList.add(workInfoPojo);
                    }
                    this.this$0.__db.setTransactionSuccessful();
                }
                catch (Throwable throwable) {
                    cursor.close();
                    throw throwable;
                }
                try {
                    cursor.close();
                    return arrayList;
                }
                finally {
                    this.this$0.__db.endTransaction();
                }
            }

            protected void finalize() {
                this.val$_statement.release();
            }
        };
        return ((InvalidationTracker)object).createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec"}, true, object2);
    }

    @Override
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForName(String object) {
        Object object2 = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (object == null) {
            ((RoomSQLiteQuery)object2).bindNull(1);
        } else {
            ((RoomSQLiteQuery)object2).bindString(1, (String)object);
        }
        object = this.__db.getInvalidationTracker();
        object2 = new Callable<List<WorkSpec.WorkInfoPojo>>(){
            final WorkSpecDao_Impl this$0;
            final RoomSQLiteQuery val$_statement;
            {
                this.this$0 = workSpecDao_Impl;
                this.val$_statement = roomSQLiteQuery;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                ArrayList<WorkSpec.WorkInfoPojo> arrayList;
                this.this$0.__db.beginTransaction();
                Cursor cursor = DBUtil.query(this.this$0.__db, this.val$_statement, true, null);
                boolean bl = false;
                boolean bl2 = true;
                int n = 2;
                int n2 = 3;
                try {
                    Object object;
                    Object object2;
                    HashMap hashMap = new HashMap();
                    HashMap hashMap2 = new HashMap();
                    while (cursor.moveToNext()) {
                        object2 = cursor.getString(0);
                        if ((ArrayList)hashMap.get(object2) == null) {
                            object = new ArrayList();
                            hashMap.put((String)object2, object);
                        }
                        if ((ArrayList)hashMap2.get(object2 = cursor.getString(0)) != null) continue;
                        object = new ArrayList();
                        hashMap2.put((String)object2, object);
                    }
                    object = hashMap;
                    hashMap = hashMap2;
                    cursor.moveToPosition(-1);
                    this.this$0.__fetchRelationshipWorkTagAsjavaLangString(object);
                    this.this$0.__fetchRelationshipWorkProgressAsandroidxWorkData(hashMap);
                    arrayList = new ArrayList<WorkSpec.WorkInfoPojo>(cursor.getCount());
                    n = n2;
                    hashMap2 = object;
                    while (cursor.moveToNext()) {
                        object = cursor.isNull(0) ? null : cursor.getString(0);
                        n2 = cursor.getInt(1);
                        object2 = WorkTypeConverters.INSTANCE;
                        WorkInfo.State state = WorkTypeConverters.intToState(n2);
                        object2 = cursor.isNull(2) ? null : (Object)cursor.getBlob(2);
                        Data data = Data.fromByteArray((byte[])object2);
                        n2 = cursor.getInt(3);
                        int n3 = cursor.getInt(4);
                        long l = cursor.getLong(13);
                        long l2 = cursor.getLong(14);
                        long l3 = cursor.getLong(15);
                        int n4 = cursor.getInt(16);
                        object2 = WorkTypeConverters.INSTANCE;
                        BackoffPolicy backoffPolicy = WorkTypeConverters.intToBackoffPolicy(n4);
                        long l4 = cursor.getLong(17);
                        long l5 = cursor.getLong(18);
                        n4 = cursor.getInt(19);
                        long l6 = cursor.getLong(20);
                        int n5 = cursor.getInt(21);
                        int n6 = cursor.getInt(5);
                        object2 = WorkTypeConverters.INSTANCE;
                        Object object3 = WorkTypeConverters.intToNetworkType(n6);
                        bl2 = cursor.getInt(6) != 0;
                        bl = cursor.getInt(7) != 0;
                        boolean bl3 = cursor.getInt(8) != 0;
                        boolean bl4 = cursor.getInt(9) != 0;
                        long l7 = cursor.getLong(10);
                        long l8 = cursor.getLong(11);
                        object2 = cursor.isNull(12) ? null : (Object)cursor.getBlob(12);
                        Object object4 = WorkTypeConverters.INSTANCE;
                        object2 = WorkTypeConverters.byteArrayToSetOfTriggers((byte[])object2);
                        object4 = new Constraints((NetworkType)((Object)object3), bl2, bl, bl3, bl4, l7, l8, (Set<Constraints.ContentUriTrigger>)object2);
                        object2 = (ArrayList)hashMap2.get(cursor.getString(0));
                        if (object2 == null) {
                            object2 = new Object();
                        }
                        if ((object3 = (ArrayList)hashMap.get(cursor.getString(0))) == null) {
                            object3 = new ArrayList();
                        }
                        WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo((String)object, state, data, l, l2, l3, (Constraints)object4, n2, backoffPolicy, l4, l5, n4, n3, l6, n5, (List<String>)object2, (List<Data>)object3);
                        arrayList.add(workInfoPojo);
                    }
                    this.this$0.__db.setTransactionSuccessful();
                }
                catch (Throwable throwable) {
                    cursor.close();
                    throw throwable;
                }
                try {
                    cursor.close();
                    return arrayList;
                }
                finally {
                    this.this$0.__db.endTransaction();
                }
            }

            protected void finalize() {
                this.val$_statement.release();
            }
        };
        return ((InvalidationTracker)object).createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec", "workname"}, true, object2);
    }

    @Override
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForTag(String object) {
        Object object2 = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (object == null) {
            ((RoomSQLiteQuery)object2).bindNull(1);
        } else {
            ((RoomSQLiteQuery)object2).bindString(1, (String)object);
        }
        object = this.__db.getInvalidationTracker();
        object2 = new Callable<List<WorkSpec.WorkInfoPojo>>(){
            final WorkSpecDao_Impl this$0;
            final RoomSQLiteQuery val$_statement;
            {
                this.this$0 = workSpecDao_Impl;
                this.val$_statement = roomSQLiteQuery;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                ArrayList<WorkSpec.WorkInfoPojo> arrayList;
                this.this$0.__db.beginTransaction();
                Cursor cursor = DBUtil.query(this.this$0.__db, this.val$_statement, true, null);
                boolean bl = false;
                boolean bl2 = true;
                int n = 2;
                int n2 = 3;
                try {
                    Object object;
                    Object object2;
                    Object object3 = new HashMap();
                    HashMap hashMap = new HashMap();
                    while (cursor.moveToNext()) {
                        object2 = cursor.getString(0);
                        if ((ArrayList)((HashMap)object3).get(object2) == null) {
                            object = new ArrayList();
                            ((HashMap)object3).put(object2, object);
                        }
                        if ((ArrayList)hashMap.get(object = cursor.getString(0)) != null) continue;
                        object2 = new Object();
                        hashMap.put(object, object2);
                    }
                    object = hashMap;
                    cursor.moveToPosition(-1);
                    this.this$0.__fetchRelationshipWorkTagAsjavaLangString(object3);
                    this.this$0.__fetchRelationshipWorkProgressAsandroidxWorkData((HashMap)object);
                    arrayList = new ArrayList<WorkSpec.WorkInfoPojo>(cursor.getCount());
                    n = n2;
                    hashMap = object3;
                    object3 = object;
                    while (cursor.moveToNext()) {
                        object = cursor.isNull(0) ? null : cursor.getString(0);
                        n2 = cursor.getInt(1);
                        object2 = WorkTypeConverters.INSTANCE;
                        WorkInfo.State state = WorkTypeConverters.intToState(n2);
                        object2 = cursor.isNull(2) ? null : (Object)cursor.getBlob(2);
                        Data data = Data.fromByteArray((byte[])object2);
                        int n3 = cursor.getInt(3);
                        n2 = cursor.getInt(4);
                        long l = cursor.getLong(13);
                        long l2 = cursor.getLong(14);
                        long l3 = cursor.getLong(15);
                        int n4 = cursor.getInt(16);
                        object2 = WorkTypeConverters.INSTANCE;
                        BackoffPolicy backoffPolicy = WorkTypeConverters.intToBackoffPolicy(n4);
                        long l4 = cursor.getLong(17);
                        long l5 = cursor.getLong(18);
                        int n5 = cursor.getInt(19);
                        long l6 = cursor.getLong(20);
                        int n6 = cursor.getInt(21);
                        n4 = cursor.getInt(5);
                        object2 = WorkTypeConverters.INSTANCE;
                        Object object4 = WorkTypeConverters.intToNetworkType(n4);
                        bl2 = cursor.getInt(6) != 0;
                        bl = cursor.getInt(7) != 0;
                        boolean bl3 = cursor.getInt(8) != 0;
                        boolean bl4 = cursor.getInt(9) != 0;
                        long l7 = cursor.getLong(10);
                        long l8 = cursor.getLong(11);
                        object2 = cursor.isNull(12) ? null : (Object)cursor.getBlob(12);
                        Object object5 = WorkTypeConverters.INSTANCE;
                        object2 = WorkTypeConverters.byteArrayToSetOfTriggers((byte[])object2);
                        object5 = new Constraints((NetworkType)((Object)object4), bl2, bl, bl3, bl4, l7, l8, (Set<Constraints.ContentUriTrigger>)object2);
                        object2 = (ArrayList)hashMap.get(cursor.getString(0));
                        if (object2 == null) {
                            object2 = new Object();
                        }
                        if ((object4 = (ArrayList)((HashMap)object3).get(cursor.getString(0))) == null) {
                            object4 = new ArrayList();
                        }
                        WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo((String)object, state, data, l, l2, l3, (Constraints)object5, n3, backoffPolicy, l4, l5, n5, n2, l6, n6, (List<String>)object2, (List<Data>)object4);
                        arrayList.add(workInfoPojo);
                    }
                    this.this$0.__db.setTransactionSuccessful();
                }
                catch (Throwable throwable) {
                    cursor.close();
                    throw throwable;
                }
                try {
                    cursor.close();
                    return arrayList;
                }
                finally {
                    this.this$0.__db.endTransaction();
                }
            }

            protected void finalize() {
                this.val$_statement.release();
            }
        };
        return ((InvalidationTracker)object).createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec", "worktag"}, true, object2);
    }

    @Override
    public boolean hasUnfinishedWork() {
        Cursor cursor;
        RoomSQLiteQuery roomSQLiteQuery;
        boolean bl;
        block4: {
            bl = false;
            roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
            this.__db.assertNotSuspendingTransaction();
            cursor = DBUtil.query(this.__db, roomSQLiteQuery, false, null);
            try {
                if (cursor.moveToFirst()) {
                    int n = cursor.getInt(0);
                    if (n != 0) {
                        bl = true;
                    }
                    break block4;
                }
                bl = false;
            }
            catch (Throwable throwable) {
                cursor.close();
                roomSQLiteQuery.release();
                throw throwable;
            }
        }
        cursor.close();
        roomSQLiteQuery.release();
        return bl;
    }

    @Override
    public void incrementGeneration(String string2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfIncrementGeneration.acquire();
        if (string2 == null) {
            supportSQLiteStatement.bindNull(1);
        } else {
            supportSQLiteStatement.bindString(1, string2);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfIncrementGeneration.release(supportSQLiteStatement);
        }
    }

    @Override
    public void incrementPeriodCount(String string2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfIncrementPeriodCount.acquire();
        if (string2 == null) {
            supportSQLiteStatement.bindNull(1);
        } else {
            supportSQLiteStatement.bindString(1, string2);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfIncrementPeriodCount.release(supportSQLiteStatement);
        }
    }

    @Override
    public int incrementWorkSpecRunAttemptCount(String string2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.acquire();
        if (string2 == null) {
            supportSQLiteStatement.bindNull(1);
        } else {
            supportSQLiteStatement.bindString(1, string2);
        }
        this.__db.beginTransaction();
        try {
            int n = supportSQLiteStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return n;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.release(supportSQLiteStatement);
        }
    }

    @Override
    public void insertWorkSpec(WorkSpec workSpec) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfWorkSpec.insert(workSpec);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override
    public int markWorkSpecScheduled(String string2, long l) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfMarkWorkSpecScheduled.acquire();
        supportSQLiteStatement.bindLong(1, l);
        if (string2 == null) {
            supportSQLiteStatement.bindNull(2);
        } else {
            supportSQLiteStatement.bindString(2, string2);
        }
        this.__db.beginTransaction();
        try {
            int n = supportSQLiteStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return n;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfMarkWorkSpecScheduled.release(supportSQLiteStatement);
        }
    }

    @Override
    public void pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast.acquire();
        this.__db.beginTransaction();
        try {
            supportSQLiteStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast.release(supportSQLiteStatement);
        }
    }

    @Override
    public int resetScheduledState() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfResetScheduledState.acquire();
        this.__db.beginTransaction();
        try {
            int n = supportSQLiteStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return n;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetScheduledState.release(supportSQLiteStatement);
        }
    }

    @Override
    public void resetWorkSpecNextScheduleTimeOverride(String string2, int n) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfResetWorkSpecNextScheduleTimeOverride.acquire();
        if (string2 == null) {
            supportSQLiteStatement.bindNull(1);
        } else {
            supportSQLiteStatement.bindString(1, string2);
        }
        supportSQLiteStatement.bindLong(2, n);
        this.__db.beginTransaction();
        try {
            supportSQLiteStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetWorkSpecNextScheduleTimeOverride.release(supportSQLiteStatement);
        }
    }

    @Override
    public int resetWorkSpecRunAttemptCount(String string2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfResetWorkSpecRunAttemptCount.acquire();
        if (string2 == null) {
            supportSQLiteStatement.bindNull(1);
        } else {
            supportSQLiteStatement.bindString(1, string2);
        }
        this.__db.beginTransaction();
        try {
            int n = supportSQLiteStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return n;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetWorkSpecRunAttemptCount.release(supportSQLiteStatement);
        }
    }

    @Override
    public int setCancelledState(String string2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfSetCancelledState.acquire();
        if (string2 == null) {
            supportSQLiteStatement.bindNull(1);
        } else {
            supportSQLiteStatement.bindString(1, string2);
        }
        this.__db.beginTransaction();
        try {
            int n = supportSQLiteStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return n;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetCancelledState.release(supportSQLiteStatement);
        }
    }

    @Override
    public void setLastEnqueueTime(String string2, long l) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfSetLastEnqueueTime.acquire();
        supportSQLiteStatement.bindLong(1, l);
        if (string2 == null) {
            supportSQLiteStatement.bindNull(2);
        } else {
            supportSQLiteStatement.bindString(2, string2);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetLastEnqueueTime.release(supportSQLiteStatement);
        }
    }

    @Override
    public void setNextScheduleTimeOverride(String string2, long l) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfSetNextScheduleTimeOverride.acquire();
        supportSQLiteStatement.bindLong(1, l);
        if (string2 == null) {
            supportSQLiteStatement.bindNull(2);
        } else {
            supportSQLiteStatement.bindString(2, string2);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetNextScheduleTimeOverride.release(supportSQLiteStatement);
        }
    }

    @Override
    public void setOutput(String string2, Data object) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfSetOutput.acquire();
        object = Data.toByteArrayInternal((Data)object);
        if (object == null) {
            supportSQLiteStatement.bindNull(1);
        } else {
            supportSQLiteStatement.bindBlob(1, (byte[])object);
        }
        if (string2 == null) {
            supportSQLiteStatement.bindNull(2);
        } else {
            supportSQLiteStatement.bindString(2, string2);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetOutput.release(supportSQLiteStatement);
        }
    }

    @Override
    public int setState(WorkInfo.State state, String string2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfSetState.acquire();
        WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
        supportSQLiteStatement.bindLong(1, WorkTypeConverters.stateToInt(state));
        if (string2 == null) {
            supportSQLiteStatement.bindNull(2);
        } else {
            supportSQLiteStatement.bindString(2, string2);
        }
        this.__db.beginTransaction();
        try {
            int n = supportSQLiteStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return n;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetState.release(supportSQLiteStatement);
        }
    }

    @Override
    public void setStopReason(String string2, int n) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfSetStopReason.acquire();
        supportSQLiteStatement.bindLong(1, n);
        if (string2 == null) {
            supportSQLiteStatement.bindNull(2);
        } else {
            supportSQLiteStatement.bindString(2, string2);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetStopReason.release(supportSQLiteStatement);
        }
    }

    @Override
    public void updateWorkSpec(WorkSpec workSpec) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfWorkSpec.handle(workSpec);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }
}

