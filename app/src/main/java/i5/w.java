package i5;

import d5.g;
import d5.p0;
import okhttp3.HttpUrl;
import s1.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class w {
    public static final g4.d0 d = new g4.d0(21, new ef1.d(11), new fz0.z(18));
    public final g a;
    public final long b;
    public final p0 c;

    public w(g gVar, long j2, p0 p0Var) {
        p0 p0Var2;
        this.a = gVar;
        this.b = uc0.p.o(gVar.b.length(), j2);
        if (p0Var != null) {
            p0Var2 = new p0(uc0.p.o(gVar.b.length(), p0Var.a));
        } else {
            p0Var2 = null;
        }
        this.c = p0Var2;
    }

    public static w a(w wVar, g gVar, long j2, int i) {
        if ((i & 1) != 0) {
            gVar = wVar.a;
        }
        if ((i & 2) != 0) {
            j2 = wVar.b;
        }
        p0 p0Var = (i & 4) != 0 ? wVar.c : null;
        wVar.getClass();
        return new w(gVar, j2, p0Var);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return p0.c(this.b, wVar.b) && lmjxuqdtp.jvm.internal.o.c(this.c, wVar.c) && lmjxuqdtp.jvm.internal.o.c(this.a, wVar.a);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        int i = p0.c;
        int iG = a.g(iHashCode, this.b, 31);
        p0 p0Var = this.c;
        return iG + (p0Var != null ? Long.hashCode(p0Var.a) : 0);
    }

    public final String toString() {
        return "TextFieldValue(text='" + ((Object) this.a) + "', selection=" + ((Object) p0.i(this.b)) + ", composition=" + this.c + ')';
    }

    public w(int i, long j2, String str) {
        this(new g((i & 1) != 0 ? HttpUrl.FRAGMENT_ENCODE_SET : str), (i & 2) != 0 ? p0.b : j2, (p0) null);
    }
}
