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
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.impl.model.WorkTag;
import androidx.work.impl.model.WorkTagDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class WorkTagDao_Impl
implements WorkTagDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<WorkTag> __insertionAdapterOfWorkTag;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByWorkSpecId;

    public WorkTagDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfWorkTag = new EntityInsertionAdapter<WorkTag>(this, roomDatabase){
            final WorkTagDao_Impl this$0;
            {
                this.this$0 = workTagDao_Impl;
                super(roomDatabase);
            }

            @Override
            public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkTag workTag) {
                if (workTag.getTag() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, workTag.getTag());
                }
                if (workTag.getWorkSpecId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, workTag.getWorkSpecId());
                }
            }

            @Override
            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
            }
        };
        this.__preparedStmtOfDeleteByWorkSpecId = new SharedSQLiteStatement(this, roomDatabase){
            final WorkTagDao_Impl this$0;
            {
                this.this$0 = workTagDao_Impl;
                super(roomDatabase);
            }

            @Override
            public String createQuery() {
                return "DELETE FROM worktag WHERE work_spec_id=?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override
    public void deleteByWorkSpecId(String string2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteByWorkSpecId.acquire();
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
            this.__preparedStmtOfDeleteByWorkSpecId.release(supportSQLiteStatement);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public List<String> getTagsForWorkSpecId(String string2) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
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
    public List<String> getWorkSpecIdsWithTag(String string2) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT work_spec_id FROM worktag WHERE tag=?", 1);
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
    public void insert(WorkTag workTag) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfWorkTag.insert(workTag);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override
    public void insertTags(String string2, Set<String> set) {
        WorkTagDao.DefaultImpls.insertTags(this, string2, set);
    }
}

