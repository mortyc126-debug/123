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
import androidx.work.Data;
import androidx.work.impl.model.WorkProgress;
import androidx.work.impl.model.WorkProgressDao;
import java.util.Collections;
import java.util.List;

public final class WorkProgressDao_Impl
implements WorkProgressDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<WorkProgress> __insertionAdapterOfWorkProgress;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

    public WorkProgressDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfWorkProgress = new EntityInsertionAdapter<WorkProgress>(this, roomDatabase){
            final WorkProgressDao_Impl this$0;
            {
                this.this$0 = workProgressDao_Impl;
                super(roomDatabase);
            }

            @Override
            public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkProgress object) {
                if (((WorkProgress)object).getWorkSpecId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, ((WorkProgress)object).getWorkSpecId());
                }
                object = Data.toByteArrayInternal(((WorkProgress)object).getProgress());
                if (object == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindBlob(2, (byte[])object);
                }
            }

            @Override
            public String createQuery() {
                return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(this, roomDatabase){
            final WorkProgressDao_Impl this$0;
            {
                this.this$0 = workProgressDao_Impl;
                super(roomDatabase);
            }

            @Override
            public String createQuery() {
                return "DELETE from WorkProgress where work_spec_id=?";
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(this, roomDatabase){
            final WorkProgressDao_Impl this$0;
            {
                this.this$0 = workProgressDao_Impl;
                super(roomDatabase);
            }

            @Override
            public String createQuery() {
                return "DELETE FROM WorkProgress";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
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

    @Override
    public void deleteAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteAll.acquire();
        this.__db.beginTransaction();
        try {
            supportSQLiteStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAll.release(supportSQLiteStatement);
        }
    }

    @Override
    public Data getProgressForWorkSpecId(String object) {
        Cursor cursor;
        RoomSQLiteQuery roomSQLiteQuery;
        block11: {
            block10: {
                roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT progress FROM WorkProgress WHERE work_spec_id=?", 1);
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
            object = cursor.getBlob(0);
            if (object == null) {
                object = null;
            } else {
                block9: {
                    object = Data.fromByteArray((byte[])object);
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

    @Override
    public void insert(WorkProgress workProgress) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfWorkProgress.insert(workProgress);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }
}

