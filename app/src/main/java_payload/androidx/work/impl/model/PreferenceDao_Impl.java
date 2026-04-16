/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package androidx.work.impl.model;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.impl.model.Preference;
import androidx.work.impl.model.PreferenceDao;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public final class PreferenceDao_Impl
implements PreferenceDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<Preference> __insertionAdapterOfPreference;

    public PreferenceDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfPreference = new EntityInsertionAdapter<Preference>(this, roomDatabase){
            final PreferenceDao_Impl this$0;
            {
                this.this$0 = preferenceDao_Impl;
                super(roomDatabase);
            }

            @Override
            public void bind(SupportSQLiteStatement supportSQLiteStatement, Preference preference) {
                if (preference.getKey() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, preference.getKey());
                }
                if (preference.getValue() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindLong(2, preference.getValue());
                }
            }

            @Override
            public String createQuery() {
                return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override
    public Long getLongValue(String object) {
        Cursor cursor;
        RoomSQLiteQuery roomSQLiteQuery;
        block8: {
            block6: {
                block7: {
                    roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT long_value FROM Preference where `key`=?", 1);
                    if (object == null) {
                        roomSQLiteQuery.bindNull(1);
                    } else {
                        roomSQLiteQuery.bindString(1, (String)object);
                    }
                    this.__db.assertNotSuspendingTransaction();
                    cursor = DBUtil.query(this.__db, roomSQLiteQuery, false, null);
                    if (!cursor.moveToFirst()) break block6;
                    if (!cursor.isNull(0)) break block7;
                    object = null;
                }
                object = cursor.getLong(0);
                break block8;
            }
            object = null;
        }
        return object;
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    @Override
    public LiveData<Long> getObservableLongValue(String object) {
        Object object2 = RoomSQLiteQuery.acquire("SELECT long_value FROM Preference where `key`=?", 1);
        if (object == null) {
            ((RoomSQLiteQuery)object2).bindNull(1);
        } else {
            ((RoomSQLiteQuery)object2).bindString(1, (String)object);
        }
        object = this.__db.getInvalidationTracker();
        object2 = new Callable<Long>(){
            final PreferenceDao_Impl this$0;
            final RoomSQLiteQuery val$_statement;
            {
                this.this$0 = preferenceDao_Impl;
                this.val$_statement = roomSQLiteQuery;
            }

            @Override
            public Long call() throws Exception {
                Long l;
                Cursor cursor;
                block6: {
                    block4: {
                        block5: {
                            cursor = DBUtil.query(this.this$0.__db, this.val$_statement, false, null);
                            if (!cursor.moveToFirst()) break block4;
                            if (!cursor.isNull(0)) break block5;
                            l = null;
                        }
                        l = cursor.getLong(0);
                        break block6;
                    }
                    l = null;
                }
                return l;
                finally {
                    cursor.close();
                }
            }

            protected void finalize() {
                this.val$_statement.release();
            }
        };
        return ((InvalidationTracker)object).createLiveData(new String[]{"Preference"}, false, object2);
    }

    @Override
    public void insertPreference(Preference preference) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPreference.insert(preference);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }
}

