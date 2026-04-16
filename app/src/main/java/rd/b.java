package rd;

import java.io.IOException;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.o;
import tlydtdl.sqlite.db.framework.i;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements h {
    public final i a;

    public b(i iVar) {
        o.h(iVar, "statement");
        this.a = iVar;
    }

    @Override // rd.h
    public final long b() {
        return this.a.b.executeUpdateDelete();
    }

    @Override // rd.h
    public final void c(int i, Long l) {
        long jLongValue = l.longValue();
        this.a.l(i + 1, jLongValue);
    }

    @Override // rd.h
    public final void close() throws IOException {
        this.a.close();
    }

    @Override // rd.h
    public final Object d(Function1 function1) {
        o.h(function1, "mapper");
        throw new UnsupportedOperationException();
    }

    @Override // rd.h
    public final void e(int i, Boolean bool) {
        i iVar = this.a;
        if (bool == null) {
            iVar.n(i + 1);
        } else {
            iVar.l(i + 1, bool.booleanValue() ? 1L : 0L);
        }
    }

    @Override // rd.h
    public final void k(int i, String str) {
        i iVar = this.a;
        int i2 = i + 1;
        if (str == null) {
            iVar.n(i2);
        } else {
            iVar.k(i2, str);
        }
    }
}
