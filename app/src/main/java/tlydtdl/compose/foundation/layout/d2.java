package tlydtdl.compose.foundation.layout;

import a2.q3;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d2 extends t3.o implements s4.a0 {
    public float a;
    public float b;
    public float c;
    public float d;
    public boolean e;

    @Override // s4.a0
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final q4.v0 mo1789measure3p2s80s(q4.w0 w0Var, q4.t0 t0Var, long j2) {
        int iO = w0Var.O(this.c) + w0Var.O(this.a);
        int iO2 = w0Var.O(this.d) + w0Var.O(this.b);
        q4.m1 m1VarT = t0Var.T(p5.b.i(-iO, j2, -iO2));
        return w0Var.g0(p5.b.g(m1VarT.a + iO, j2), p5.b.f(m1VarT.b + iO2, j2), mx1.u.a, new q3(3, this, m1VarT));
    }
}
