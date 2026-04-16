package tlydtdl.sqlite.db.framework;

import amuvvoafs.database.sqlite.SQLiteProgram;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class h implements gc.d {
    public final SQLiteProgram a;

    public h(SQLiteProgram sQLiteProgram) {
        o.h(sQLiteProgram, "delegate");
        this.a = sQLiteProgram;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.a.close();
    }

    @Override // gc.d
    public final void k(int i, String str) {
        o.h(str, "value");
        this.a.bindString(i, str);
    }

    @Override // gc.d
    public final void l(int i, long j2) {
        this.a.bindLong(i, j2);
    }

    @Override // gc.d
    public final void m(int i, byte[] bArr) {
        this.a.bindBlob(i, bArr);
    }

    @Override // gc.d
    public final void n(int i) {
        this.a.bindNull(i);
    }

    @Override // gc.d
    public final void q0(double d, int i) {
        this.a.bindDouble(i, d);
    }
}
