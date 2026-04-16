package r8;

import a80.d;
import amuvvoafs.content.ContentValues;
import amuvvoafs.database.Cursor;
import amuvvoafs.database.DatabaseUtils;
import amuvvoafs.database.SQLException;
import amuvvoafs.database.sqlite.SQLiteDatabase;
import amuvvoafs.database.sqlite.SQLiteException;
import amuvvoafs.util.SparseArray;
import f3.f2;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import o8.b;
import o8.f0;
import tlydtdl.media3.database.DatabaseIOException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements l {
    public static final String[] e = {"id", "key", "metadata"};
    public final oe0.a a;
    public final SparseArray b = new SparseArray();
    public String c;
    public String d;

    public k(oe0.a aVar) {
        this.a = aVar;
    }

    public final void a(SQLiteDatabase sQLiteDatabase, j jVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        d.i(jVar.c(), new DataOutputStream(byteArrayOutputStream));
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(jVar.a));
        contentValues.put("key", jVar.b);
        contentValues.put("metadata", byteArray);
        String str = this.d;
        str.getClass();
        sQLiteDatabase.replaceOrThrow(str, (String) null, contentValues);
    }

    public final void b(SQLiteDatabase sQLiteDatabase) throws DatabaseIOException {
        String str = this.c;
        str.getClass();
        p8.a.b(sQLiteDatabase, 1, str);
        String str2 = this.d;
        str2.getClass();
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ".concat(str2));
        sQLiteDatabase.execSQL("CREATE TABLE " + this.d + " (id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
    }

    @Override // r8.l
    public final void o() throws DatabaseIOException {
        oe0.a aVar = this.a;
        String str = this.c;
        str.getClass();
        try {
            String strConcat = "ExoPlayerCacheIndex".concat(str);
            SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                int i = p8.a.a;
                try {
                    int i2 = f0.a;
                    if (DatabaseUtils.queryNumEntries(writableDatabase, "sqlite_master", "tbl_name = ?", new String[]{"ExoPlayerVersions"}) > 0) {
                        writableDatabase.delete("ExoPlayerVersions", "feature = ? AND instance_uid = ?", new String[]{Integer.toString(1), str});
                    }
                    writableDatabase.execSQL("DROP TABLE IF EXISTS " + strConcat);
                    writableDatabase.setTransactionSuccessful();
                } catch (SQLException e2) {
                    throw new DatabaseIOException(e2);
                }
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e3) {
            throw new DatabaseIOException(e3);
        }
    }

    @Override // r8.l
    public final void p(j jVar) {
        this.b.put(jVar.a, jVar);
    }

    @Override // r8.l
    public final void q(j jVar, boolean z) {
        int i = jVar.a;
        SparseArray sparseArray = this.b;
        if (z) {
            sparseArray.delete(i);
        } else {
            sparseArray.put(i, (Object) null);
        }
    }

    @Override // r8.l
    public final boolean r() throws DatabaseIOException {
        try {
            SQLiteDatabase readableDatabase = this.a.getReadableDatabase();
            String str = this.c;
            str.getClass();
            return p8.a.a(readableDatabase, 1, str) != -1;
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    @Override // r8.l
    public final void s(HashMap map) throws DatabaseIOException {
        SparseArray sparseArray = this.b;
        if (sparseArray.size() == 0) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            for (int i = 0; i < sparseArray.size(); i++) {
                try {
                    j jVar = (j) sparseArray.valueAt(i);
                    if (jVar == null) {
                        int iKeyAt = sparseArray.keyAt(i);
                        String str = this.d;
                        str.getClass();
                        writableDatabase.delete(str, "id = ?", new String[]{Integer.toString(iKeyAt)});
                    } else {
                        a(writableDatabase, jVar);
                    }
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
            writableDatabase.setTransactionSuccessful();
            sparseArray.clear();
            writableDatabase.endTransaction();
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    @Override // r8.l
    public final void t(long j2) {
        String hexString = Long.toHexString(j2);
        this.c = hexString;
        this.d = f2.k("ExoPlayerCacheIndex", hexString);
    }

    @Override // r8.l
    public final void u(HashMap map) throws DatabaseIOException {
        try {
            SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                b(writableDatabase);
                Iterator it = map.values().iterator();
                while (it.hasNext()) {
                    a(writableDatabase, (j) it.next());
                }
                writableDatabase.setTransactionSuccessful();
                this.b.clear();
                writableDatabase.endTransaction();
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    @Override // r8.l
    public final void v(HashMap map, SparseArray sparseArray) throws DatabaseIOException {
        oe0.a aVar = this.a;
        b.h(this.b.size() == 0);
        try {
            SQLiteDatabase readableDatabase = aVar.getReadableDatabase();
            String str = this.c;
            str.getClass();
            if (p8.a.a(readableDatabase, 1, str) != 1) {
                SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    b(writableDatabase);
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
            SQLiteDatabase readableDatabase2 = aVar.getReadableDatabase();
            String str2 = this.d;
            str2.getClass();
            Cursor cursorQuery = readableDatabase2.query(str2, e, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            while (cursorQuery.moveToNext()) {
                try {
                    int i = cursorQuery.getInt(0);
                    String string = cursorQuery.getString(1);
                    string.getClass();
                    map.put(string, new j(i, string, d.h(new DataInputStream(new ByteArrayInputStream(cursorQuery.getBlob(2))))));
                    sparseArray.put(i, string);
                } finally {
                }
            }
            cursorQuery.close();
        } catch (SQLiteException e2) {
            map.clear();
            sparseArray.clear();
            throw new DatabaseIOException(e2);
        }
    }
}
