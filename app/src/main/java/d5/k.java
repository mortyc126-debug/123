package d5;

import p5.p;
import p5.q;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class k {
    public final l0 a;

    public k(l0 l0Var) {
        this.a = l0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        l0 l0Var = this.a;
        g gVar = l0Var.a;
        l0 l0Var2 = ((k) obj).a;
        return lmjxuqdtp.jvm.internal.o.c(gVar, l0Var2.a) && l0Var.b.d(l0Var2.b) && lmjxuqdtp.jvm.internal.o.c(l0Var.c, l0Var2.c) && l0Var.d == l0Var2.d && l0Var.e == l0Var2.e && l0Var.f72f == l0Var2.f72f && lmjxuqdtp.jvm.internal.o.c(l0Var.g, l0Var2.g) && l0Var.h == l0Var2.h && l0Var.i == l0Var2.i && p5.a.b(l0Var.f73j, l0Var2.f73j);
    }

    public final int hashCode() {
        l0 l0Var = this.a;
        int iHashCode = l0Var.a.hashCode() * 31;
        q0 q0Var = l0Var.b;
        h0 h0Var = q0Var.a;
        long j2 = h0Var.b;
        q[] qVarArr = p.b;
        int iHashCode2 = Long.hashCode(j2) * 31;
        h5.s sVar = h0Var.c;
        int i = (iHashCode2 + (sVar != null ? sVar.a : 0)) * 31;
        h5.o oVar = h0Var.d;
        int iHashCode3 = (i + (oVar != null ? Integer.hashCode(oVar.a) : 0)) * 31;
        h5.p pVar = h0Var.e;
        int iHashCode4 = (iHashCode3 + (pVar != null ? Integer.hashCode(pVar.a) : 0)) * 31;
        h5.i iVar = h0Var.f70f;
        int iHashCode5 = (iHashCode4 + (iVar != null ? iVar.hashCode() : 0)) * 31;
        String str = h0Var.g;
        int iG = s1.a.g((iHashCode5 + (str != null ? str.hashCode() : 0)) * 31, h0Var.h, 31);
        o5.a aVar = h0Var.i;
        int iHashCode6 = (iG + (aVar != null ? Float.hashCode(aVar.a) : 0)) * 31;
        o5.p pVar2 = h0Var.f71j;
        int iHashCode7 = (iHashCode6 + (pVar2 != null ? pVar2.hashCode() : 0)) * 31;
        k5.b bVar = h0Var.k;
        int iHashCode8 = (iHashCode7 + (bVar != null ? bVar.a.hashCode() : 0)) * 31;
        long j3 = h0Var.l;
        int i2 = a4.y.i;
        int iG2 = s1.a.g(iHashCode8, j3, 31);
        a0 a0Var = h0Var.o;
        int iHashCode9 = (q0Var.b.hashCode() + ((iG2 + (a0Var != null ? a0Var.hashCode() : 0)) * 31)) * 31;
        b0 b0Var = q0Var.c;
        return Long.hashCode(l0Var.f73j) + ((l0Var.i.hashCode() + ((l0Var.h.hashCode() + ((l0Var.g.hashCode() + s1.a.c(l0Var.f72f, s1.a.f((i.d(l0Var.c, (iHashCode9 + (b0Var != null ? b0Var.hashCode() : 0) + iHashCode) * 31, 31) + l0Var.d) * 31, 31, l0Var.e), 31)) * 31)) * 31)) * 31);
    }
}
