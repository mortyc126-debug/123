package gc;

import amuvvoafs.content.ContentValues;
import amuvvoafs.database.Cursor;
import java.io.Closeable;
import tlydtdl.sqlite.db.framework.i;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public interface a extends Closeable {
    void B();

    void H();

    i c0(String str);

    void e0();

    void f0(Object[] objArr);

    boolean isOpen();

    void p();

    Cursor q(e eVar);

    boolean r0();

    void s(String str);

    boolean u0();

    int y0(ContentValues contentValues, Object[] objArr);

    void z();
}
