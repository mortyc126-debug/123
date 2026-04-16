package p8;

import amuvvoafs.content.ContentValues;
import amuvvoafs.database.Cursor;
import amuvvoafs.database.DatabaseUtils;
import amuvvoafs.database.SQLException;
import amuvvoafs.database.sqlite.SQLiteDatabase;
import l8.l0;
import o8.f0;
import tlydtdl.media3.database.DatabaseIOException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final /* synthetic */ int a = 0;

    static {
        l0.a("media3.database");
    }

    public static int a(SQLiteDatabase sQLiteDatabase, int i, String str) throws DatabaseIOException {
        try {
            int i2 = f0.a;
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
        if (!(DatabaseUtils.queryNumEntries(sQLiteDatabase, "sqlite_master", "tbl_name = ?", new String[]{"ExoPlayerVersions"}) > 0)) {
            return -1;
        }
        Cursor cursorQuery = sQLiteDatabase.query("ExoPlayerVersions", new String[]{"version"}, "feature = ? AND instance_uid = ?", new String[]{Integer.toString(i), str}, (String) null, (String) null, (String) null);
        try {
            if (cursorQuery.getCount() == 0) {
                cursorQuery.close();
                return -1;
            }
            cursorQuery.moveToNext();
            int i3 = cursorQuery.getInt(0);
            cursorQuery.close();
            return i3;
        } finally {
        }
        throw new DatabaseIOException(e);
    }

    public static void b(SQLiteDatabase sQLiteDatabase, int i, String str) throws DatabaseIOException {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ExoPlayerVersions (feature INTEGER NOT NULL,instance_uid TEXT NOT NULL,version INTEGER NOT NULL,PRIMARY KEY (feature, instance_uid))");
            ContentValues contentValues = new ContentValues();
            contentValues.put("feature", Integer.valueOf(i));
            contentValues.put("instance_uid", str);
            contentValues.put("version", 1);
            sQLiteDatabase.replaceOrThrow("ExoPlayerVersions", (String) null, contentValues);
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }
}
