package cf1;

import z3.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class p0 {
    public final long a;
    public final long b;

    public p0(long j2, long j3) {
        this.a = j2;
        this.b = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p0)) {
            return false;
        }
        p0 p0Var = (p0) obj;
        return e.b(this.a, p0Var.a) && lg.e.v(this.b, p0Var.b);
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Long.hashCode(this.a) * 31);
    }

    public final String toString() {
        return z.p.f("TickRenderer(tickSize=", e.h(this.a), ", radius=", lg.e.T(this.b), ")");
    }
}
