package oz0;

import aj.a;
import az1.b2;
import lx1.j;
import p10.l;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@a(deserializable = true, serializable = true)
public final class v0 {
    public static final u0 Companion = new u0();
    public static final lx1.h[] e = {null, null, null, hs1.d.E(j.a, new ow.a(10))};
    public final i a;
    public final d1 b;
    public final l c;
    public final x0 d;

    public /* synthetic */ v0(int i, i iVar, d1 d1Var, l lVar, x0 x0Var) {
        if (15 != (i & 15)) {
            b2.b(i, 15, t0.a.getDescriptor());
            throw null;
        }
        this.a = iVar;
        this.b = d1Var;
        this.c = lVar;
        this.d = x0Var;
    }

    public static v0 a(v0 v0Var, l lVar) {
        i iVar = v0Var.a;
        d1 d1Var = v0Var.b;
        x0 x0Var = v0Var.d;
        v0Var.getClass();
        return new v0(iVar, d1Var, lVar, x0Var);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v0)) {
            return false;
        }
        v0 v0Var = (v0) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, v0Var.a) && lmjxuqdtp.jvm.internal.o.c(this.b, v0Var.b) && lmjxuqdtp.jvm.internal.o.c(this.c, v0Var.c) && this.d == v0Var.d;
    }

    public final int hashCode() {
        i iVar = this.a;
        int iHashCode = (iVar == null ? 0 : iVar.hashCode()) * 31;
        d1 d1Var = this.b;
        int iHashCode2 = (iHashCode + (d1Var == null ? 0 : d1Var.hashCode())) * 31;
        l lVar = this.c;
        int iHashCode3 = (iHashCode2 + (lVar == null ? 0 : lVar.hashCode())) * 31;
        x0 x0Var = this.d;
        return iHashCode3 + (x0Var != null ? x0Var.hashCode() : 0);
    }

    public final String toString() {
        return "LinkEntity(album=" + this.a + ", revisionPost=" + this.b + ", beat=" + this.c + ", type=" + this.d + ")";
    }

    public v0(i iVar, d1 d1Var, l lVar, x0 x0Var) {
        this.a = iVar;
        this.b = d1Var;
        this.c = lVar;
        this.d = x0Var;
    }
}
