package tlydtdl.compose.foundation.layout;

import a2.q3;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class z1 extends t3.o implements s4.a0 {
    public float a;
    public float b;
    public boolean c;

    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // s4.a0
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final q4.v0 mo1789measure3p2s80s(q4.w0 w0Var, q4.t0 t0Var, long j2) {
        q4.m1 m1VarT = t0Var.T(j2);
        return w0Var.g0(m1VarT.a, m1VarT.b, mx1.u.a, new q3(1, this, m1VarT));
    }
}
