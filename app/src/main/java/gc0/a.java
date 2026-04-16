package gc0;

import f3.f2;
import lmjxuqdtp.jvm.internal.o;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final int a;
    public final int b;
    public final Object c;

    public a(int i, int i2, Object obj) {
        this.a = i;
        this.b = i2;
        this.c = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a == aVar.a && this.b == aVar.b && o.c(this.c, aVar.c);
    }

    public final int hashCode() {
        int iC = s1.a.c(this.b, Integer.hashCode(this.a) * 31, 31);
        Object obj = this.c;
        return iC + (obj == null ? 0 : obj.hashCode());
    }

    public final String toString() {
        return f2.m(p.i(this.a, this.b, "DatabaseCursor(skip=", ", limit=", ", filter="), this.c, ")");
    }
}
