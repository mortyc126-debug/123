/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.impl.model.Dependency;
import androidx.work.impl.model.DependencyDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DependencyDao_Impl
implements DependencyDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<Dependency> __insertionAdapterOfDependency;

    public DependencyDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfDependency = new EntityInsertionAdapter<Dependency>(this, roomDatabase){
            final DependencyDao_Impl this$0;
            {
                this.this$0 = dependencyDao_Impl;
                super(roomDatabase);
            }

            @Override
            public void bind(SupportSQLiteStatement supportSQLiteStatement, Dependency dependency) {
                if (dependency.getWorkSpecId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, dependency.getWorkSpecId());
                }
                if (dependency.getPrerequisiteId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, dependency.getPrerequisiteId());
                }
            }

            @Override
            public String createQuery() {
                return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public List<String> getDependentWorkIds(String string2) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
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
    public List<String> getPrerequisites(String string2) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT prerequisite_id FROM dependency WHERE work_spec_id=?", 1);
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

    @Override
    public boolean hasCompletedAllPrerequisites(String string2) {
        Cursor cursor;
        RoomSQLiteQuery roomSQLiteQuery;
        boolean bl;
        block6: {
            bl = true;
            roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
            if (string2 == null) {
                roomSQLiteQuery.bindNull(1);
            } else {
                roomSQLiteQuery.bindString(1, string2);
            }
            this.__db.assertNotSuspendingTransaction();
            cursor = DBUtil.query(this.__db, roomSQLiteQuery, false, null);
            try {
                if (cursor.moveToFirst()) {
                    int n = cursor.getInt(0);
                    if (n == 0) {
                        bl = false;
                    }
                    break block6;
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
    public boolean hasDependents(String string2) {
        RoomSQLiteQuery roomSQLiteQuery;
        boolean bl;
        block6: {
            bl = true;
            roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
            if (string2 == null) {
                roomSQLiteQuery.bindNull(1);
            } else {
                roomSQLiteQuery.bindString(1, string2);
            }
            this.__db.assertNotSuspendingTransaction();
            string2 = DBUtil.query(this.__db, roomSQLiteQuery, false, null);
            try {
                if (string2.moveToFirst()) {
                    int n = string2.getInt(0);
                    if (n == 0) {
                        bl = false;
                    }
                    break block6;
                }
                bl = false;
            }
            catch (Throwable throwable) {
                string2.close();
                roomSQLiteQuery.release();
                throw throwable;
            }
        }
        string2.close();
        roomSQLiteQuery.release();
        return bl;
    }

    @Override
    public void insertDependency(Dependency dependency) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfDependency.insert(dependency);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }
}

