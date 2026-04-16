package tlydtdl.compose.foundation.layout;

import kotlin.jvm.internal.IntCompanionObject;
import lmjxuqdtp.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d3 extends t3.o implements s4.a0 {
    public k0 a;
    public boolean b;
    public Function2 c;

    @Override // s4.a0
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final q4.v0 mo1789measure3p2s80s(q4.w0 w0Var, q4.t0 t0Var, long j2) {
        k0 k0Var = this.a;
        k0 k0Var2 = k0.a;
        int iJ = k0Var != k0Var2 ? 0 : p5.a.j(j2);
        k0 k0Var3 = this.a;
        k0 k0Var4 = k0.b;
        int i = k0Var3 == k0Var4 ? p5.a.i(j2) : 0;
        k0 k0Var5 = this.a;
        int iG = IntCompanionObject.MAX_VALUE;
        int iH = (k0Var5 == k0Var2 || !this.b) ? p5.a.h(j2) : Integer.MAX_VALUE;
        if (this.a == k0Var4 || !this.b) {
            iG = p5.a.g(j2);
        }
        q4.m1 m1VarT = t0Var.T(p5.b.a(iJ, iH, i, iG));
        int iJ2 = st.w0.j(m1VarT.a, p5.a.j(j2), p5.a.h(j2));
        int iJ3 = st.w0.j(m1VarT.b, p5.a.i(j2), p5.a.g(j2));
        return w0Var.g0(iJ2, iJ3, mx1.u.a, new c3(this, iJ2, m1VarT, iJ3, w0Var));
    }
}
