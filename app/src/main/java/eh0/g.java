package eh0;

import f3.f2;
import lmjxuqdtp.jvm.internal.o;
import x10.r;
import x10.v;
import yr.w7;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements h {
    public final e a;
    public final r b;
    public final v c;
    public final boolean d;
    public final Object e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(r rVar, v vVar, boolean z) {
        this(rVar, vVar, z, null);
        e eVar = e.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.a == gVar.a && o.c(this.b, gVar.b) && o.c(this.c, gVar.c) && this.d == gVar.d && o.c(this.e, gVar.e);
    }

    public final int hashCode() {
        int iF = s1.a.f(o6.c.d(s1.a.c(this.b.e, this.a.hashCode() * 31, 31), 31, this.c), 31, this.d);
        Object obj = this.e;
        return iF + (obj == null ? 0 : obj.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Message(duration=");
        sb.append(this.a);
        sb.append(", message=");
        sb.append(this.b);
        sb.append(", action=");
        sb.append(this.c);
        sb.append(", dismissible=");
        sb.append(this.d);
        sb.append(", tag=");
        return f2.m(sb, this.e, ")");
    }

    public g(r rVar, v vVar, boolean z, w7 w7Var) {
        e eVar = e.a;
        o.h(vVar, "action");
        this.a = eVar;
        this.b = rVar;
        this.c = vVar;
        this.d = z;
        this.e = w7Var;
    }
}
