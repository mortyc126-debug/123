package tlydtdl.sqlite.db.framework;

import amuvvoafs.content.ContentValues;
import amuvvoafs.database.Cursor;
import amuvvoafs.database.sqlite.SQLiteCursorDriver;
import amuvvoafs.database.sqlite.SQLiteDatabase;
import amuvvoafs.database.sqlite.SQLiteQuery;
import amuvvoafs.database.sqlite.SQLiteStatement;
import amuvvoafs.text.TextUtils;
import gc.e;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import lmjxuqdtp.jvm.internal.o;
import lx1.j;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements gc.a {
    public static final String[] b = {HttpUrl.FRAGMENT_ENCODE_SET, " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    public static final String[] c = new String[0];
    public static final Object d;
    public static final Object e;
    public final SQLiteDatabase a;

    static {
        j jVar = j.b;
        d = hs1.d.E(jVar, new g(16));
        e = hs1.d.E(jVar, new g(17));
    }

    public c(SQLiteDatabase sQLiteDatabase) {
        this.a = sQLiteDatabase;
    }

    @Override // gc.a
    public final void B() {
        this.a.beginTransactionNonExclusive();
    }

    @Override // gc.a
    public final void H() {
        this.a.endTransaction();
    }

    @Override // gc.a
    public final i c0(String str) {
        o.h(str, "sql");
        SQLiteStatement sQLiteStatementCompileStatement = this.a.compileStatement(str);
        o.g(sQLiteStatementCompileStatement, "compileStatement(...)");
        return new i(sQLiteStatementCompileStatement);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.a.close();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, lx1.h] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, lx1.h] */
    @Override // gc.a
    public final void e0() throws IllegalAccessException, InvocationTargetException {
        ?? r12 = e;
        if (((Method) r12.getValue()) != null) {
            ?? r2 = d;
            if (((Method) r2.getValue()) != null) {
                Method method = (Method) r12.getValue();
                o.e(method);
                Method method2 = (Method) r2.getValue();
                o.e(method2);
                Object objInvoke = method2.invoke(this.a, null);
                if (objInvoke == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                method.invoke(objInvoke, 0, null, 0, null);
                return;
            }
        }
        p();
    }

    @Override // gc.a
    public final void f0(Object[] objArr) {
        this.a.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", objArr);
    }

    @Override // gc.a
    public final boolean isOpen() {
        return this.a.isOpen();
    }

    @Override // gc.a
    public final void p() {
        this.a.beginTransaction();
    }

    @Override // gc.a
    public final Cursor q(e eVar) {
        final a aVar = new a(0, eVar);
        Cursor cursorRawQueryWithFactory = this.a.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: tlydtdl.sqlite.db.framework.b
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                return (Cursor) aVar.invoke(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, eVar.g(), c, (String) null);
        o.g(cursorRawQueryWithFactory, "rawQueryWithFactory(...)");
        return cursorRawQueryWithFactory;
    }

    @Override // gc.a
    public final boolean r0() {
        return this.a.inTransaction();
    }

    @Override // gc.a
    public final void s(String str) {
        o.h(str, "sql");
        this.a.execSQL(str);
    }

    @Override // gc.a
    public final boolean u0() {
        return this.a.isWriteAheadLoggingEnabled();
    }

    @Override // gc.a
    public final int y0(ContentValues contentValues, Object[] objArr) {
        if (contentValues.size() == 0) {
            throw new IllegalArgumentException("Empty values");
        }
        int size = contentValues.size();
        int length = objArr.length + size;
        Object[] objArr2 = new Object[length];
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(b[3]);
        sb.append("WorkSpec SET ");
        int i = 0;
        for (String str : contentValues.keySet()) {
            sb.append(i > 0 ? "," : HttpUrl.FRAGMENT_ENCODE_SET);
            sb.append(str);
            objArr2[i] = contentValues.get(str);
            sb.append("=?");
            i++;
        }
        for (int i2 = size; i2 < length; i2++) {
            objArr2[i2] = objArr[i2 - size];
        }
        if (!TextUtils.isEmpty("last_enqueue_time = 0 AND interval_duration <> 0 ")) {
            sb.append(" WHERE last_enqueue_time = 0 AND interval_duration <> 0 ");
        }
        i iVarC0 = c0(sb.toString());
        mn1.f.l(iVarC0, objArr2);
        return iVarC0.b.executeUpdateDelete();
    }

    @Override // gc.a
    public final void z() {
        this.a.setTransactionSuccessful();
    }
}
