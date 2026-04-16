package wz0;

import oz0.v1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 {
    public final dg1.e a;
    public final String b;
    public final v1 c;
    public final fi1.e0 d;
    public final fi1.e0 e;

    public h0(dg1.e eVar, String str, v1 v1Var, fi1.e0 e0Var, fi1.e0 e0Var2) {
        lmjxuqdtp.jvm.internal.o.h(v1Var, "reason");
        this.a = eVar;
        this.b = str;
        this.c = v1Var;
        this.d = e0Var;
        this.e = e0Var2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return this.a.equals(h0Var.a) && this.b.equals(h0Var.b) && this.c == h0Var.c && this.d.equals(h0Var.d) && this.e.equals(h0Var.e);
    }

    public final int hashCode() {
        return this.e.hashCode() + ((this.d.hashCode() + ((this.c.hashCode() + s1.a.d(this.a.hashCode() * 31, 31, this.b)) * 31)) * 31);
    }

    public final String toString() {
        return "RecommendationReason(picture=" + this.a + ", name=" + this.b + ", reason=" + this.c + ", onUserClick=" + this.d + ", onClose=" + this.e + ")";
    }
}
