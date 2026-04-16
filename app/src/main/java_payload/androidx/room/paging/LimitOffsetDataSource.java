/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  androidx.paging.PositionalDataSource
 *  androidx.paging.PositionalDataSource$LoadInitialCallback
 *  androidx.paging.PositionalDataSource$LoadInitialParams
 *  androidx.paging.PositionalDataSource$LoadRangeCallback
 *  androidx.paging.PositionalDataSource$LoadRangeParams
 */
package androidx.room.paging;

import android.database.Cursor;
import androidx.paging.PositionalDataSource;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class LimitOffsetDataSource<T>
extends PositionalDataSource<T> {
    private final String mCountQuery;
    private final RoomDatabase mDb;
    private final boolean mInTransaction;
    private final String mLimitOffsetQuery;
    private final InvalidationTracker.Observer mObserver;
    private final AtomicBoolean mRegisteredObserver = new AtomicBoolean(false);
    private final RoomSQLiteQuery mSourceQuery;

    protected LimitOffsetDataSource(RoomDatabase roomDatabase, RoomSQLiteQuery roomSQLiteQuery, boolean bl, boolean bl2, String ... stringArray) {
        this.mDb = roomDatabase;
        this.mSourceQuery = roomSQLiteQuery;
        this.mInTransaction = bl;
        this.mCountQuery = "SELECT COUNT(*) FROM ( " + this.mSourceQuery.getSql() + " )";
        this.mLimitOffsetQuery = "SELECT * FROM ( " + this.mSourceQuery.getSql() + " ) LIMIT ? OFFSET ?";
        this.mObserver = new InvalidationTracker.Observer(this, stringArray){
            final LimitOffsetDataSource this$0;
            {
                this.this$0 = limitOffsetDataSource;
                super(stringArray);
            }

            @Override
            public void onInvalidated(Set<String> set) {
                this.this$0.invalidate();
            }
        };
        if (bl2) {
            this.registerObserverIfNecessary();
        }
    }

    protected LimitOffsetDataSource(RoomDatabase roomDatabase, RoomSQLiteQuery roomSQLiteQuery, boolean bl, String ... stringArray) {
        this(roomDatabase, roomSQLiteQuery, bl, true, stringArray);
    }

    protected LimitOffsetDataSource(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean bl, boolean bl2, String ... stringArray) {
        this(roomDatabase, RoomSQLiteQuery.copyFrom(supportSQLiteQuery), bl, bl2, stringArray);
    }

    protected LimitOffsetDataSource(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean bl, String ... stringArray) {
        this(roomDatabase, RoomSQLiteQuery.copyFrom(supportSQLiteQuery), bl, stringArray);
    }

    private RoomSQLiteQuery getSQLiteQuery(int n, int n2) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire(this.mLimitOffsetQuery, this.mSourceQuery.getArgCount() + 2);
        roomSQLiteQuery.copyArgumentsFrom(this.mSourceQuery);
        roomSQLiteQuery.bindLong(roomSQLiteQuery.getArgCount() - 1, n2);
        roomSQLiteQuery.bindLong(roomSQLiteQuery.getArgCount(), n);
        return roomSQLiteQuery;
    }

    private void registerObserverIfNecessary() {
        if (this.mRegisteredObserver.compareAndSet(false, true)) {
            this.mDb.getInvalidationTracker().addWeakObserver(this.mObserver);
        }
    }

    protected abstract List<T> convertRows(Cursor var1);

    public int countItems() {
        this.registerObserverIfNecessary();
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire(this.mCountQuery, this.mSourceQuery.getArgCount());
        roomSQLiteQuery.copyArgumentsFrom(this.mSourceQuery);
        Cursor cursor = this.mDb.query(roomSQLiteQuery);
        try {
            if (cursor.moveToFirst()) {
                int n = cursor.getInt(0);
                return n;
            }
            return 0;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    public boolean isInvalid() {
        this.registerObserverIfNecessary();
        this.mDb.getInvalidationTracker().refreshVersionsSync();
        return super.isInvalid();
    }

    public void loadInitial(PositionalDataSource.LoadInitialParams object, PositionalDataSource.LoadInitialCallback<T> loadInitialCallback) {
        int n;
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQuery2;
        int n2;
        Object object2;
        block11: {
            this.registerObserverIfNecessary();
            object2 = Collections.emptyList();
            n2 = 0;
            RoomSQLiteQuery roomSQLiteQuery3 = null;
            RoomSQLiteQuery roomSQLiteQuery4 = null;
            Object object3 = null;
            RoomSQLiteQuery roomSQLiteQuery5 = null;
            this.mDb.beginTransaction();
            roomSQLiteQuery2 = roomSQLiteQuery3;
            roomSQLiteQuery = object3;
            try {
                n = this.countItems();
                roomSQLiteQuery = roomSQLiteQuery4;
                roomSQLiteQuery2 = roomSQLiteQuery5;
                if (n == 0) break block11;
                roomSQLiteQuery2 = roomSQLiteQuery3;
                roomSQLiteQuery = object3;
            }
            catch (Throwable throwable) {
                if (roomSQLiteQuery != null) {
                    roomSQLiteQuery.close();
                }
                this.mDb.endTransaction();
                if (roomSQLiteQuery2 != null) {
                    roomSQLiteQuery2.release();
                }
                throw throwable;
            }
            n2 = LimitOffsetDataSource.computeInitialLoadPosition((PositionalDataSource.LoadInitialParams)object, (int)n);
            roomSQLiteQuery2 = roomSQLiteQuery3;
            roomSQLiteQuery = object3;
            object = this.getSQLiteQuery(n2, LimitOffsetDataSource.computeInitialLoadSize((PositionalDataSource.LoadInitialParams)object, (int)n2, (int)n));
            roomSQLiteQuery2 = object;
            roomSQLiteQuery = object3;
            object2 = this.mDb.query((SupportSQLiteQuery)object);
            roomSQLiteQuery2 = object;
            roomSQLiteQuery = object2;
            object3 = this.convertRows((Cursor)object2);
            roomSQLiteQuery2 = object;
            roomSQLiteQuery = object2;
            this.mDb.setTransactionSuccessful();
            roomSQLiteQuery2 = object2;
            roomSQLiteQuery = object;
            object2 = object3;
        }
        if (roomSQLiteQuery2 != null) {
            roomSQLiteQuery2.close();
        }
        this.mDb.endTransaction();
        if (roomSQLiteQuery != null) {
            roomSQLiteQuery.release();
        }
        loadInitialCallback.onResult(object2, n2, n);
    }

    public List<T> loadRange(int n, int n2) {
        RoomSQLiteQuery roomSQLiteQuery = this.getSQLiteQuery(n, n2);
        if (this.mInTransaction) {
            List<T> list;
            block9: {
                Cursor cursor;
                this.mDb.beginTransaction();
                Cursor cursor2 = null;
                try {
                    cursor2 = cursor = this.mDb.query(roomSQLiteQuery);
                }
                catch (Throwable throwable) {
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    this.mDb.endTransaction();
                    roomSQLiteQuery.release();
                    throw throwable;
                }
                list = this.convertRows(cursor);
                cursor2 = cursor;
                this.mDb.setTransactionSuccessful();
                if (cursor == null) break block9;
                cursor.close();
            }
            this.mDb.endTransaction();
            roomSQLiteQuery.release();
            return list;
        }
        Cursor cursor = this.mDb.query(roomSQLiteQuery);
        try {
            List<T> list = this.convertRows(cursor);
            return list;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    public void loadRange(PositionalDataSource.LoadRangeParams loadRangeParams, PositionalDataSource.LoadRangeCallback<T> loadRangeCallback) {
        loadRangeCallback.onResult(this.loadRange(loadRangeParams.startPosition, loadRangeParams.loadSize));
    }
}

