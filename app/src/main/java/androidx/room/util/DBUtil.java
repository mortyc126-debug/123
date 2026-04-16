/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.AbstractWindowedCursor
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteConstraintException
 *  android.os.CancellationSignal
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 */
package androidx.room.util;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b\u001a\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001\u001a\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016\u00a8\u0006\u0017"}, d2={"createCancellationSignal", "Landroid/os/CancellationSignal;", "dropFtsSyncTriggers", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "foreignKeyCheck", "tableName", "", "processForeignKeyCheckFailure", "cursor", "Landroid/database/Cursor;", "query", "Landroidx/room/RoomDatabase;", "sqLiteQuery", "Landroidx/sqlite/db/SupportSQLiteQuery;", "maybeCopy", "", "signal", "readVersion", "", "databaseFile", "Ljava/io/File;", "room-runtime_release"}, k=2, mv={1, 7, 1}, xi=48)
public final class DBUtil {
    public static final CancellationSignal createCancellationSignal() {
        return SupportSQLiteCompat.Api16Impl.createCancellationSignal();
    }

    public static final void dropFtsSyncTriggers(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter((Object)supportSQLiteDatabase, (String)"db");
        Object object4 = CollectionsKt.createListBuilder();
        Object object2 = supportSQLiteDatabase.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        object2 = (Closeable)object2;
        try {
            Object object3 = object2;
            while (object3.moveToNext()) {
                object4.add(object3.getString(0));
            }
            object3 = Unit.INSTANCE;
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                CloseableKt.closeFinally((Closeable)object2, (Throwable)throwable);
                throw throwable2;
            }
        }
        CloseableKt.closeFinally((Closeable)object2, null);
        for (Object object4 : (Iterable)CollectionsKt.build((List)object4)) {
            Intrinsics.checkNotNullExpressionValue((Object)object4, (String)"triggerName");
            if (!StringsKt.startsWith$default((String)object4, (String)"room_fts_content_sync_", (boolean)false, (int)2, null)) continue;
            supportSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS " + (String)object4);
        }
        return;
    }

    public static final void foreignKeyCheck(SupportSQLiteDatabase closeable, String string2) {
        block5: {
            Intrinsics.checkNotNullParameter((Object)closeable, (String)"db");
            Intrinsics.checkNotNullParameter((Object)string2, (String)"tableName");
            closeable = closeable.query("PRAGMA foreign_key_check(`" + string2 + "`)");
            closeable = closeable;
            try {
                string2 = (Cursor)closeable;
                if (string2.getCount() > 0) break block5;
                string2 = Unit.INSTANCE;
            }
            catch (Throwable throwable) {
                try {
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
                    throw throwable2;
                }
            }
            CloseableKt.closeFinally((Closeable)closeable, null);
            return;
        }
        string2 = DBUtil.processForeignKeyCheckFailure((Cursor)string2);
        SQLiteConstraintException sQLiteConstraintException = new SQLiteConstraintException(string2);
        throw sQLiteConstraintException;
    }

    private static final String processForeignKeyCheckFailure(Cursor object) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = object.getCount();
        Object object2 = new LinkedHashMap();
        while (object.moveToNext()) {
            String object3;
            if (object.isFirst()) {
                stringBuilder.append("Foreign key violation(s) detected in '");
                stringBuilder.append(object.getString(0)).append("'.\n");
            }
            if (object2.containsKey(object3 = object.getString(3))) continue;
            Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"constraintIndex");
            String string2 = object.getString(2);
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"cursor.getString(2)");
            object2.put(object3, string2);
        }
        stringBuilder.append("Number of different violations discovered: ");
        stringBuilder.append(object2.keySet().size()).append("\n");
        stringBuilder.append("Number of rows in violation: ");
        stringBuilder.append(n).append("\n");
        stringBuilder.append("Violation(s) detected in the following constraint(s):\n");
        for (Map.Entry entry : object2.entrySet()) {
            object2 = (String)entry.getKey();
            String string3 = (String)entry.getValue();
            stringBuilder.append("\tParent Table = ");
            stringBuilder.append(string3);
            stringBuilder.append(", Foreign Key Constraint Index = ");
            stringBuilder.append((String)object2).append("\n");
        }
        object = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"StringBuilder().apply(builderAction).toString()");
        return object;
    }

    @Deprecated(message="This is only used in the generated code and shouldn't be called directly.")
    public static final Cursor query(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)roomDatabase, (String)"db");
        Intrinsics.checkNotNullParameter((Object)supportSQLiteQuery, (String)"sqLiteQuery");
        return DBUtil.query(roomDatabase, supportSQLiteQuery, bl, null);
    }

    public static final Cursor query(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean bl, CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter((Object)roomDatabase, (String)"db");
        Intrinsics.checkNotNullParameter((Object)supportSQLiteQuery, (String)"sqLiteQuery");
        roomDatabase = roomDatabase.query(supportSQLiteQuery, cancellationSignal);
        if (bl && roomDatabase instanceof AbstractWindowedCursor) {
            int n = ((AbstractWindowedCursor)roomDatabase).getCount();
            int n2 = ((AbstractWindowedCursor)roomDatabase).hasWindow() ? ((AbstractWindowedCursor)roomDatabase).getWindow().getNumRows() : n;
            if (n2 < n) {
                return CursorUtil.copyAndClose((Cursor)roomDatabase);
            }
        }
        return roomDatabase;
    }

    public static final int readVersion(File object) throws IOException {
        Object object2;
        block5: {
            int n;
            Intrinsics.checkNotNullParameter((Object)object, (String)"databaseFile");
            object = new FileInputStream((File)object).getChannel();
            try {
                FileChannel fileChannel = (FileChannel)object;
                object2 = ByteBuffer.allocate(4);
                fileChannel.tryLock(60L, 4L, true);
                fileChannel.position(60L);
                if (fileChannel.read((ByteBuffer)object2) != 4) break block5;
                ((ByteBuffer)object2).rewind();
                n = ((ByteBuffer)object2).getInt();
            }
            catch (Throwable throwable) {
                try {
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    CloseableKt.closeFinally((Closeable)object, (Throwable)throwable);
                    throw throwable2;
                }
            }
            CloseableKt.closeFinally((Closeable)object, null);
            return n;
        }
        object2 = new IOException("Bad database header, unable to read 4 bytes at offset 60");
        throw object2;
    }
}

