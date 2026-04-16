package p30;

import kx0.e;
import lmjxuqdtp.jvm.internal.o;
import ny1.p2;
import ny1.r2;
import sw0.k;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public final e a;
    public final k b;
    public final ng0.b c;
    public final p2 d;

    public d(e eVar, k kVar, ng0.b bVar, r2 r2Var) {
        o.h(eVar, "getButton");
        o.h(kVar, "content");
        o.h(r2Var, "onScrollTo");
        this.a = eVar;
        this.b = kVar;
        this.c = bVar;
        this.d = r2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return o.c(this.a, dVar.a) && o.c(this.b, dVar.b) && this.c.equals(dVar.c) && o.c(this.d, dVar.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "CreateTabState(getButton=" + this.a + ", content=" + this.b + ", onFabClick=" + this.c + ", onScrollTo=" + this.d + ")";
    }
}
