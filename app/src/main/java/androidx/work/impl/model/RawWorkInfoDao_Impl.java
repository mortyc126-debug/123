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
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.WorkInfo;
import androidx.work.impl.model.RawWorkInfoDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkTypeConverters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlinx.coroutines.flow.Flow;

public final class RawWorkInfoDao_Impl
implements RawWorkInfoDao {
    private final RoomDatabase __db;

    public RawWorkInfoDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
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
            arrayList = object2.iterator();
            while (arrayList.hasNext()) {
                object2 = (String)arrayList.next();
                if (object2 == null) {
                    ((RoomSQLiteQuery)object).bindNull(n);
                } else {
                    ((RoomSQLiteQuery)object).bindString(n, (String)object2);
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

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public List<WorkSpec.WorkInfoPojo> getWorkInfoPojos(SupportSQLiteQuery object) {
        void var1_4;
        Cursor cursor;
        block32: {
            ArrayList<WorkSpec.WorkInfoPojo> arrayList;
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
            this.__db.assertNotSuspendingTransaction();
            cursor = DBUtil.query(this.__db, (SupportSQLiteQuery)object, true, null);
            try {
                n13 = CursorUtil.getColumnIndex(cursor, "id");
                n12 = CursorUtil.getColumnIndex(cursor, "state");
                n11 = CursorUtil.getColumnIndex(cursor, "output");
                n10 = CursorUtil.getColumnIndex(cursor, "initial_delay");
                n9 = CursorUtil.getColumnIndex(cursor, "interval_duration");
                n8 = CursorUtil.getColumnIndex(cursor, "flex_duration");
                n7 = CursorUtil.getColumnIndex(cursor, "run_attempt_count");
                n6 = CursorUtil.getColumnIndex(cursor, "backoff_policy");
                n5 = CursorUtil.getColumnIndex(cursor, "backoff_delay_duration");
                n4 = CursorUtil.getColumnIndex(cursor, "last_enqueue_time");
                n3 = CursorUtil.getColumnIndex(cursor, "period_count");
                n2 = CursorUtil.getColumnIndex(cursor, "generation");
                n = CursorUtil.getColumnIndex(cursor, "next_schedule_time_override");
            }
            catch (Throwable throwable) {
                // empty catch block
                break block32;
            }
            try {
                int n14 = CursorUtil.getColumnIndex(cursor, "stop_reason");
                int n15 = CursorUtil.getColumnIndex(cursor, "required_network_type");
                int n16 = CursorUtil.getColumnIndex(cursor, "requires_charging");
                int n17 = CursorUtil.getColumnIndex(cursor, "requires_device_idle");
                int n18 = CursorUtil.getColumnIndex(cursor, "requires_battery_not_low");
                int n19 = CursorUtil.getColumnIndex(cursor, "requires_storage_not_low");
                int n20 = CursorUtil.getColumnIndex(cursor, "trigger_content_update_delay");
                int n21 = CursorUtil.getColumnIndex(cursor, "trigger_max_content_delay");
                int n22 = CursorUtil.getColumnIndex(cursor, "content_uri_triggers");
                HashMap<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();
                HashMap<String, ArrayList<Data>> hashMap2 = new HashMap<String, ArrayList<Data>>();
                while (cursor.moveToNext()) {
                    String string2;
                    object = cursor.getString(n13);
                    if ((ArrayList)hashMap.get(object) == null) {
                        ArrayList arrayList2 = new ArrayList();
                        hashMap.put((String)object, arrayList2);
                    }
                    if (hashMap2.get(string2 = cursor.getString(n13)) != null) continue;
                    object = new ArrayList();
                    hashMap2.put(string2, (ArrayList<Data>)object);
                }
                int n23 = n3;
                n3 = n2;
                cursor.moveToPosition(-1);
                this.__fetchRelationshipWorkTagAsjavaLangString(hashMap);
                this.__fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
                arrayList = new ArrayList<WorkSpec.WorkInfoPojo>(cursor.getCount());
                n2 = n23;
                int n24 = n;
                int n25 = n22;
                n = n19;
                n22 = n18;
                n23 = n17;
                while (cursor.moveToNext()) {
                    void var56_74;
                    void var55_67;
                    void var54_63;
                    void var53_57;
                    void var52_37;
                    ArrayList<Data> arrayList3;
                    void var56_80;
                    void var55_71;
                    Object object2;
                    boolean bl;
                    boolean bl2;
                    boolean bl3;
                    boolean bl4;
                    object = n13 == -1 ? null : (cursor.isNull(n13) ? null : cursor.getString(n13));
                    if (n12 == -1) {
                        Object var52_34 = null;
                    } else {
                        n17 = cursor.getInt(n12);
                        WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                        WorkInfo.State state = WorkTypeConverters.intToState(n17);
                    }
                    if (n11 == -1) {
                        Object var53_58 = null;
                    } else {
                        void var53_61;
                        if (cursor.isNull(n11)) {
                            Object var53_59 = null;
                        } else {
                            byte[] byArray = cursor.getBlob(n11);
                        }
                        Data data = Data.fromByteArray((byte[])var53_61);
                    }
                    long l = n10 == -1 ? 0L : cursor.getLong(n10);
                    long l2 = n9 == -1 ? 0L : cursor.getLong(n9);
                    long l3 = n8 == -1 ? 0L : cursor.getLong(n8);
                    n17 = n7 == -1 ? 0 : cursor.getInt(n7);
                    if (n6 == -1) {
                        Object var54_64 = null;
                    } else {
                        n18 = cursor.getInt(n6);
                        WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                        BackoffPolicy backoffPolicy = WorkTypeConverters.intToBackoffPolicy(n18);
                    }
                    long l4 = n5 == -1 ? 0L : cursor.getLong(n5);
                    long l5 = n4 == -1 ? 0L : cursor.getLong(n4);
                    n18 = n2 == -1 ? 0 : cursor.getInt(n2);
                    n19 = n3 == -1 ? 0 : cursor.getInt(n3);
                    long l6 = n24 == -1 ? 0L : cursor.getLong(n24);
                    int n26 = n24;
                    n24 = n14 == -1 ? 0 : cursor.getInt(n14);
                    if (n15 == -1) {
                        Object var55_68 = null;
                    } else {
                        int n27 = cursor.getInt(n15);
                        WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                        NetworkType networkType = WorkTypeConverters.intToNetworkType(n27);
                    }
                    boolean bl5 = false;
                    if (n16 == -1) {
                        bl4 = false;
                    } else {
                        bl3 = cursor.getInt(n16) != 0;
                        bl4 = bl3;
                    }
                    if (n23 == -1) {
                        bl2 = false;
                    } else {
                        bl3 = cursor.getInt(n23) != 0;
                        bl2 = bl3;
                    }
                    if (n22 == -1) {
                        bl = false;
                    } else {
                        bl3 = cursor.getInt(n22) != 0;
                        bl = bl3;
                    }
                    if (n == -1) {
                        bl3 = false;
                    } else {
                        bl3 = bl5;
                        if (cursor.getInt(n) != 0) {
                            bl3 = true;
                        }
                    }
                    long l7 = n20 == -1 ? 0L : cursor.getLong(n20);
                    long l8 = n21 == -1 ? 0L : cursor.getLong(n21);
                    if (n25 == -1) {
                        Object var56_75 = null;
                    } else {
                        void var56_78;
                        if (cursor.isNull(n25)) {
                            Object var56_76 = null;
                        } else {
                            byte[] byArray = cursor.getBlob(n25);
                        }
                        object2 = WorkTypeConverters.INSTANCE;
                        Set<Constraints.ContentUriTrigger> set = WorkTypeConverters.byteArrayToSetOfTriggers((byte[])var56_78);
                    }
                    object2 = new Constraints((NetworkType)var55_71, bl4, bl2, bl, bl3, l7, l8, (Set<Constraints.ContentUriTrigger>)var56_80);
                    ArrayList<String> arrayList4 = hashMap.get(cursor.getString(n13));
                    if (arrayList4 == null) {
                        ArrayList arrayList5 = new ArrayList();
                    }
                    if ((arrayList3 = hashMap2.get(cursor.getString(n13))) == null) {
                        ArrayList arrayList6 = new ArrayList();
                    }
                    WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo((String)object, (WorkInfo.State)var52_37, (Data)var53_57, l, l2, l3, (Constraints)object2, n17, (BackoffPolicy)var54_63, l4, l5, n18, n19, l6, n24, (List<String>)var55_67, (List<Data>)var56_74);
                    arrayList.add(workInfoPojo);
                    n24 = n26;
                }
            }
            catch (Throwable throwable) {
                break block32;
            }
            cursor.close();
            return arrayList;
        }
        cursor.close();
        throw var1_4;
    }

    @Override
    public Flow<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosFlow(SupportSQLiteQuery object) {
        RoomDatabase roomDatabase = this.__db;
        object = new Callable<List<WorkSpec.WorkInfoPojo>>(){
            final RawWorkInfoDao_Impl this$0;
            final SupportSQLiteQuery val$_internalQuery;
            {
                this.this$0 = rawWorkInfoDao_Impl;
                this.val$_internalQuery = supportSQLiteQuery;
            }

            /*
             * WARNING - void declaration
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                try (Cursor cursor = DBUtil.query(this.this$0.__db, this.val$_internalQuery, true, null);){
                    Object object;
                    int n = CursorUtil.getColumnIndex(cursor, "id");
                    int n2 = CursorUtil.getColumnIndex(cursor, "state");
                    int n3 = CursorUtil.getColumnIndex(cursor, "output");
                    int n4 = CursorUtil.getColumnIndex(cursor, "initial_delay");
                    int n5 = CursorUtil.getColumnIndex(cursor, "interval_duration");
                    int n6 = CursorUtil.getColumnIndex(cursor, "flex_duration");
                    int n7 = CursorUtil.getColumnIndex(cursor, "run_attempt_count");
                    int n8 = CursorUtil.getColumnIndex(cursor, "backoff_policy");
                    int n9 = CursorUtil.getColumnIndex(cursor, "backoff_delay_duration");
                    int n10 = CursorUtil.getColumnIndex(cursor, "last_enqueue_time");
                    int n11 = CursorUtil.getColumnIndex(cursor, "period_count");
                    int n12 = CursorUtil.getColumnIndex(cursor, "generation");
                    int n13 = CursorUtil.getColumnIndex(cursor, "next_schedule_time_override");
                    int n14 = CursorUtil.getColumnIndex(cursor, "stop_reason");
                    int n15 = CursorUtil.getColumnIndex(cursor, "required_network_type");
                    int n16 = CursorUtil.getColumnIndex(cursor, "requires_charging");
                    int n17 = CursorUtil.getColumnIndex(cursor, "requires_device_idle");
                    int n18 = CursorUtil.getColumnIndex(cursor, "requires_battery_not_low");
                    int n19 = CursorUtil.getColumnIndex(cursor, "requires_storage_not_low");
                    int n20 = CursorUtil.getColumnIndex(cursor, "trigger_content_update_delay");
                    int n21 = CursorUtil.getColumnIndex(cursor, "trigger_max_content_delay");
                    int n22 = CursorUtil.getColumnIndex(cursor, "content_uri_triggers");
                    HashMap hashMap = new HashMap();
                    HashMap hashMap2 = new HashMap();
                    while (cursor.moveToNext()) {
                        String string2;
                        object = cursor.getString(n);
                        if ((ArrayList)hashMap.get(object) == null) {
                            ArrayList arrayList = new ArrayList();
                            hashMap.put((String)object, arrayList);
                        }
                        if ((ArrayList)hashMap2.get(string2 = cursor.getString(n)) != null) continue;
                        object = new ArrayList();
                        hashMap2.put(string2, object);
                    }
                    int n23 = n12;
                    cursor.moveToPosition(-1);
                    this.this$0.__fetchRelationshipWorkTagAsjavaLangString(hashMap);
                    this.this$0.__fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
                    ArrayList<WorkSpec.WorkInfoPojo> arrayList = new ArrayList<WorkSpec.WorkInfoPojo>(cursor.getCount());
                    n12 = n11;
                    n11 = n23;
                    int n24 = n13;
                    int n25 = n22;
                    n13 = n19;
                    n22 = n18;
                    n23 = n15;
                    while (cursor.moveToNext()) {
                        void var56_72;
                        void var55_65;
                        void var54_61;
                        void var53_55;
                        void var52_35;
                        ArrayList arrayList2;
                        void var56_78;
                        void var55_69;
                        Object object2;
                        boolean bl;
                        boolean bl2;
                        boolean bl3;
                        boolean bl4;
                        object = n == -1 ? null : (cursor.isNull(n) ? null : cursor.getString(n));
                        if (n2 == -1) {
                            Object var52_32 = null;
                        } else {
                            n15 = cursor.getInt(n2);
                            WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                            WorkInfo.State state = WorkTypeConverters.intToState(n15);
                        }
                        if (n3 == -1) {
                            Object var53_56 = null;
                        } else {
                            void var53_59;
                            if (cursor.isNull(n3)) {
                                Object var53_57 = null;
                            } else {
                                byte[] byArray = cursor.getBlob(n3);
                            }
                            Data data = Data.fromByteArray((byte[])var53_59);
                        }
                        long l = n4 == -1 ? 0L : cursor.getLong(n4);
                        long l2 = n5 == -1 ? 0L : cursor.getLong(n5);
                        long l3 = n6 == -1 ? 0L : cursor.getLong(n6);
                        n15 = n7 == -1 ? 0 : cursor.getInt(n7);
                        if (n8 == -1) {
                            Object var54_62 = null;
                        } else {
                            n18 = cursor.getInt(n8);
                            WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                            BackoffPolicy backoffPolicy = WorkTypeConverters.intToBackoffPolicy(n18);
                        }
                        long l4 = n9 == -1 ? 0L : cursor.getLong(n9);
                        long l5 = n10 == -1 ? 0L : cursor.getLong(n10);
                        n18 = n12 == -1 ? 0 : cursor.getInt(n12);
                        n19 = n11 == -1 ? 0 : cursor.getInt(n11);
                        long l6 = n24 == -1 ? 0L : cursor.getLong(n24);
                        int n26 = n24;
                        n24 = n14 == -1 ? 0 : cursor.getInt(n14);
                        if (n23 == -1) {
                            Object var55_66 = null;
                        } else {
                            int n27 = cursor.getInt(n23);
                            WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                            NetworkType networkType = WorkTypeConverters.intToNetworkType(n27);
                        }
                        boolean bl5 = false;
                        if (n16 == -1) {
                            bl4 = false;
                        } else {
                            bl3 = cursor.getInt(n16) != 0;
                            bl4 = bl3;
                        }
                        if (n17 == -1) {
                            bl2 = false;
                        } else {
                            bl3 = cursor.getInt(n17) != 0;
                            bl2 = bl3;
                        }
                        if (n22 == -1) {
                            bl = false;
                        } else {
                            bl3 = cursor.getInt(n22) != 0;
                            bl = bl3;
                        }
                        if (n13 == -1) {
                            bl3 = false;
                        } else {
                            bl3 = bl5;
                            if (cursor.getInt(n13) != 0) {
                                bl3 = true;
                            }
                        }
                        long l7 = n20 == -1 ? 0L : cursor.getLong(n20);
                        long l8 = n21 == -1 ? 0L : cursor.getLong(n21);
                        if (n25 == -1) {
                            Object var56_73 = null;
                        } else {
                            void var56_76;
                            if (cursor.isNull(n25)) {
                                Object var56_74 = null;
                            } else {
                                byte[] byArray = cursor.getBlob(n25);
                            }
                            object2 = WorkTypeConverters.INSTANCE;
                            Set<Constraints.ContentUriTrigger> set = WorkTypeConverters.byteArrayToSetOfTriggers((byte[])var56_76);
                        }
                        object2 = new Constraints((NetworkType)var55_69, bl4, bl2, bl, bl3, l7, l8, (Set<Constraints.ContentUriTrigger>)var56_78);
                        ArrayList arrayList3 = (ArrayList)hashMap.get(cursor.getString(n));
                        if (arrayList3 == null) {
                            ArrayList arrayList4 = new ArrayList();
                        }
                        if ((arrayList2 = (ArrayList)hashMap2.get(cursor.getString(n))) == null) {
                            ArrayList arrayList5 = new ArrayList();
                        }
                        WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo((String)object, (WorkInfo.State)var52_35, (Data)var53_55, l, l2, l3, (Constraints)object2, n15, (BackoffPolicy)var54_61, l4, l5, n18, n19, l6, n24, (List<String>)var55_65, (List<Data>)var56_72);
                        arrayList.add(workInfoPojo);
                        n24 = n26;
                    }
                    return arrayList;
                }
            }
        };
        return CoroutinesRoom.createFlow(roomDatabase, false, new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, object);
    }

    @Override
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosLiveData(SupportSQLiteQuery object) {
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        object = new Callable<List<WorkSpec.WorkInfoPojo>>(){
            final RawWorkInfoDao_Impl this$0;
            final SupportSQLiteQuery val$_internalQuery;
            {
                this.this$0 = rawWorkInfoDao_Impl;
                this.val$_internalQuery = supportSQLiteQuery;
            }

            /*
             * WARNING - void declaration
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                try (Cursor cursor = DBUtil.query(this.this$0.__db, this.val$_internalQuery, true, null);){
                    Object object;
                    int n = CursorUtil.getColumnIndex(cursor, "id");
                    int n2 = CursorUtil.getColumnIndex(cursor, "state");
                    int n3 = CursorUtil.getColumnIndex(cursor, "output");
                    int n4 = CursorUtil.getColumnIndex(cursor, "initial_delay");
                    int n5 = CursorUtil.getColumnIndex(cursor, "interval_duration");
                    int n6 = CursorUtil.getColumnIndex(cursor, "flex_duration");
                    int n7 = CursorUtil.getColumnIndex(cursor, "run_attempt_count");
                    int n8 = CursorUtil.getColumnIndex(cursor, "backoff_policy");
                    int n9 = CursorUtil.getColumnIndex(cursor, "backoff_delay_duration");
                    int n10 = CursorUtil.getColumnIndex(cursor, "last_enqueue_time");
                    int n11 = CursorUtil.getColumnIndex(cursor, "period_count");
                    int n12 = CursorUtil.getColumnIndex(cursor, "generation");
                    int n13 = CursorUtil.getColumnIndex(cursor, "next_schedule_time_override");
                    int n14 = CursorUtil.getColumnIndex(cursor, "stop_reason");
                    int n15 = CursorUtil.getColumnIndex(cursor, "required_network_type");
                    int n16 = CursorUtil.getColumnIndex(cursor, "requires_charging");
                    int n17 = CursorUtil.getColumnIndex(cursor, "requires_device_idle");
                    int n18 = CursorUtil.getColumnIndex(cursor, "requires_battery_not_low");
                    int n19 = CursorUtil.getColumnIndex(cursor, "requires_storage_not_low");
                    int n20 = CursorUtil.getColumnIndex(cursor, "trigger_content_update_delay");
                    int n21 = CursorUtil.getColumnIndex(cursor, "trigger_max_content_delay");
                    int n22 = CursorUtil.getColumnIndex(cursor, "content_uri_triggers");
                    HashMap hashMap = new HashMap();
                    HashMap hashMap2 = new HashMap();
                    while (cursor.moveToNext()) {
                        object = cursor.getString(n);
                        if ((ArrayList)hashMap.get(object) == null) {
                            ArrayList arrayList = new ArrayList();
                            hashMap.put((String)object, arrayList);
                        }
                        if ((ArrayList)hashMap2.get(object = cursor.getString(n)) != null) continue;
                        ArrayList arrayList = new ArrayList();
                        hashMap2.put((String)object, arrayList);
                    }
                    cursor.moveToPosition(-1);
                    this.this$0.__fetchRelationshipWorkTagAsjavaLangString(hashMap);
                    this.this$0.__fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
                    ArrayList<WorkSpec.WorkInfoPojo> arrayList = new ArrayList<WorkSpec.WorkInfoPojo>(cursor.getCount());
                    int n23 = n13;
                    int n24 = n22;
                    n13 = n19;
                    n22 = n18;
                    while (cursor.moveToNext()) {
                        void var56_72;
                        void var55_65;
                        void var54_61;
                        void var53_55;
                        void var52_35;
                        ArrayList arrayList2;
                        void var56_78;
                        void var55_69;
                        Object object2;
                        boolean bl;
                        boolean bl2;
                        boolean bl3;
                        boolean bl4;
                        object = n == -1 ? null : (cursor.isNull(n) ? null : cursor.getString(n));
                        if (n2 == -1) {
                            Object var52_32 = null;
                        } else {
                            n18 = cursor.getInt(n2);
                            WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                            WorkInfo.State state = WorkTypeConverters.intToState(n18);
                        }
                        if (n3 == -1) {
                            Object var53_56 = null;
                        } else {
                            void var53_59;
                            if (cursor.isNull(n3)) {
                                Object var53_57 = null;
                            } else {
                                byte[] byArray = cursor.getBlob(n3);
                            }
                            Data data = Data.fromByteArray((byte[])var53_59);
                        }
                        long l = n4 == -1 ? 0L : cursor.getLong(n4);
                        long l2 = n5 == -1 ? 0L : cursor.getLong(n5);
                        long l3 = n6 == -1 ? 0L : cursor.getLong(n6);
                        n18 = n7 == -1 ? 0 : cursor.getInt(n7);
                        if (n8 == -1) {
                            Object var54_62 = null;
                        } else {
                            n19 = cursor.getInt(n8);
                            WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                            BackoffPolicy backoffPolicy = WorkTypeConverters.intToBackoffPolicy(n19);
                        }
                        long l4 = n9 == -1 ? 0L : cursor.getLong(n9);
                        long l5 = n10 == -1 ? 0L : cursor.getLong(n10);
                        n19 = n11 == -1 ? 0 : cursor.getInt(n11);
                        int n25 = n12 == -1 ? 0 : cursor.getInt(n12);
                        long l6 = n23 == -1 ? 0L : cursor.getLong(n23);
                        int n26 = n23;
                        n23 = n14 == -1 ? 0 : cursor.getInt(n14);
                        if (n15 == -1) {
                            Object var55_66 = null;
                        } else {
                            int n27 = cursor.getInt(n15);
                            WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                            NetworkType networkType = WorkTypeConverters.intToNetworkType(n27);
                        }
                        boolean bl5 = false;
                        if (n16 == -1) {
                            bl4 = false;
                        } else {
                            bl3 = cursor.getInt(n16) != 0;
                            bl4 = bl3;
                        }
                        if (n17 == -1) {
                            bl2 = false;
                        } else {
                            bl3 = cursor.getInt(n17) != 0;
                            bl2 = bl3;
                        }
                        if (n22 == -1) {
                            bl = false;
                        } else {
                            bl3 = cursor.getInt(n22) != 0;
                            bl = bl3;
                        }
                        if (n13 == -1) {
                            bl3 = false;
                        } else {
                            bl3 = bl5;
                            if (cursor.getInt(n13) != 0) {
                                bl3 = true;
                            }
                        }
                        long l7 = n20 == -1 ? 0L : cursor.getLong(n20);
                        long l8 = n21 == -1 ? 0L : cursor.getLong(n21);
                        if (n24 == -1) {
                            Object var56_73 = null;
                        } else {
                            void var56_76;
                            if (cursor.isNull(n24)) {
                                Object var56_74 = null;
                            } else {
                                byte[] byArray = cursor.getBlob(n24);
                            }
                            object2 = WorkTypeConverters.INSTANCE;
                            Set<Constraints.ContentUriTrigger> set = WorkTypeConverters.byteArrayToSetOfTriggers((byte[])var56_76);
                        }
                        object2 = new Constraints((NetworkType)var55_69, bl4, bl2, bl, bl3, l7, l8, (Set<Constraints.ContentUriTrigger>)var56_78);
                        ArrayList arrayList3 = (ArrayList)hashMap.get(cursor.getString(n));
                        if (arrayList3 == null) {
                            ArrayList arrayList4 = new ArrayList();
                        }
                        if ((arrayList2 = (ArrayList)hashMap2.get(cursor.getString(n))) == null) {
                            ArrayList arrayList5 = new ArrayList();
                        }
                        WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo((String)object, (WorkInfo.State)var52_35, (Data)var53_55, l, l2, l3, (Constraints)object2, n18, (BackoffPolicy)var54_61, l4, l5, n19, n25, l6, n23, (List<String>)var55_65, (List<Data>)var56_72);
                        arrayList.add(workInfoPojo);
                        n23 = n26;
                    }
                    return arrayList;
                }
            }
        };
        return invalidationTracker.createLiveData(new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, false, object);
    }
}

