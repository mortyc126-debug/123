package rd;

import amuvvoafs.database.Cursor;
import java.io.Closeable;
import java.util.ArrayList;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.o;
import mu0.u;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements gc.e, h {
    public final String a;
    public final gc.a b;
    public final ArrayList c;

    public c(String str, gc.a aVar, int i) {
        o.h(str, "sql");
        o.h(aVar, "database");
        this.a = str;
        this.b = aVar;
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(null);
        }
        this.c = arrayList;
    }

    @Override // rd.h
    public final long b() {
        throw new UnsupportedOperationException();
    }

    @Override // rd.h
    public final void c(int i, Long l) {
        this.c.set(i, new df1.a(l, i, 4));
    }

    @Override // rd.h
    public final void close() {
    }

    @Override // rd.h
    public final Object d(Function1 function1) {
        o.h(function1, "mapper");
        Cursor cursor = (Closeable) this.b.q(this);
        try {
            Object value = ((qd.e) function1.invoke(new a(cursor))).getValue();
            u.j(cursor, (Throwable) null);
            return value;
        } finally {
        }
    }

    @Override // rd.h
    public final void e(int i, Boolean bool) {
        this.c.set(i, new df1.a(bool, i, 2));
    }

    @Override // gc.e
    public final String g() {
        return this.a;
    }

    @Override // gc.e
    public final void j(gc.d dVar) {
        for (Function1 function1 : this.c) {
            o.e(function1);
            function1.invoke(dVar);
        }
    }

    @Override // rd.h
    public final void k(int i, String str) {
        this.c.set(i, new df1.a(str, i, 3));
    }

    public final String toString() {
        return this.a;
    }
}
