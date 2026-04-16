package wz0;

import x10.l;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 {
    public final x10.v a;
    public final e0 b;
    public final x10.v c;

    public f0(x10.v vVar, e0 e0Var, l lVar, int i) {
        vVar = (i & 1) != 0 ? null : vVar;
        e0Var = (i & 2) != 0 ? null : e0Var;
        lVar = (i & 4) != 0 ? null : lVar;
        this.a = vVar;
        this.b = e0Var;
        this.c = lVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, f0Var.a) && lmjxuqdtp.jvm.internal.o.c(this.b, f0Var.b) && lmjxuqdtp.jvm.internal.o.c(this.c, f0Var.c);
    }

    public final int hashCode() {
        x10.v vVar = this.a;
        int iHashCode = (vVar == null ? 0 : vVar.hashCode()) * 31;
        e0 e0Var = this.b;
        int iHashCode2 = (iHashCode + (e0Var == null ? 0 : e0Var.hashCode())) * 31;
        x10.v vVar2 = this.c;
        return iHashCode2 + (vVar2 != null ? vVar2.hashCode() : 0);
    }

    public final String toString() {
        return "Subtitle(prefix=" + this.a + ", suffix=" + this.b + ", highlightedUsername=" + this.c + ")";
    }
}
