package tlydtdl.compose.foundation.layout;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g2 extends t3.o implements s4.a0 {
    public e2 a;

    @Override // s4.a0
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final q4.v0 mo1789measure3p2s80s(q4.w0 w0Var, q4.t0 t0Var, long j2) {
        float fB = this.a.b(w0Var.getLayoutDirection());
        float fD = this.a.d();
        float fC = this.a.c(w0Var.getLayoutDirection());
        float fA = this.a.a();
        float f2 = 0;
        if (!((Float.compare(fA, f2) >= 0) & (Float.compare(fB, f2) >= 0) & (Float.compare(fD, f2) >= 0) & (Float.compare(fC, f2) >= 0))) {
            e2.a.a("Padding must be non-negative");
        }
        int iO = w0Var.O(fB);
        int iO2 = w0Var.O(fC) + iO;
        int iO3 = w0Var.O(fD);
        int iO4 = w0Var.O(fA) + iO3;
        q4.m1 m1VarT = t0Var.T(p5.b.i(-iO2, j2, -iO4));
        return w0Var.g0(p5.b.g(m1VarT.a + iO2, j2), p5.b.f(m1VarT.b + iO4, j2), mx1.u.a, new k1(m1VarT, iO, iO3, 1));
    }
}
