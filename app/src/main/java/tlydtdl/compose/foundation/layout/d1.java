package tlydtdl.compose.foundation.layout;

import lmjxuqdtp.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d1 {
    public q4.t0 a;
    public q4.m1 b;
    public q4.t0 c;
    public q4.m1 d;
    public q1.l e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public q1.l f485f;

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final q1.l a(int i, int i2, boolean z) throws NoWhenBranchMatchedException {
        z0 z0Var = z0.a;
        int i3 = c1.$EnumSwitchMapping$0[1];
        if (i3 == 1 || i3 == 2) {
            return null;
        }
        if (i3 == 3) {
            if (z) {
                return this.e;
            }
            return null;
        }
        if (i3 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        if (z) {
            return this.e;
        }
        if (i + 1 < 0 || i2 < 0) {
            return null;
        }
        return this.f485f;
    }

    public final void b(q4.v vVar, q4.v vVar2, boolean z, long j2) {
        long jP = m.p(j2, z ? t1.a : t1.b);
        if (vVar != null) {
            int iG = p5.a.g(jP);
            int iM = z ? vVar.M(iG) : vVar.z(iG);
            this.e = new q1.l(q1.l.a(iM, z ? vVar.z(iM) : vVar.M(iM)));
            this.a = vVar instanceof q4.t0 ? (q4.t0) vVar : null;
            this.b = null;
        }
        if (vVar2 != null) {
            int iG2 = p5.a.g(jP);
            int iM2 = z ? vVar2.M(iG2) : vVar2.z(iG2);
            this.f485f = new q1.l(q1.l.a(iM2, z ? vVar2.z(iM2) : vVar2.M(iM2)));
            this.c = vVar2 instanceof q4.t0 ? (q4.t0) vVar2 : null;
            this.d = null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d1)) {
            return false;
        }
        z0 z0Var = z0.a;
        return true;
    }

    public final int hashCode() {
        return Integer.hashCode(0) + s1.a.c(0, z0.a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "FlowLayoutOverflowState(type=" + z0.a + ", minLinesToShowCollapse=0, minCrossAxisSizeToShowCollapse=0)";
    }
}
