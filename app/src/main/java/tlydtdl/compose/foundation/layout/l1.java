package tlydtdl.compose.foundation.layout;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l1 implements q4.e0, r4.c, r4.f {
    public final v2 a;
    public final tlydtdl.compose.runtime.n1 b;
    public final tlydtdl.compose.runtime.n1 c;

    public l1(v2 v2Var) {
        this.a = v2Var;
        this.b = tlydtdl.compose.runtime.a0.t(v2Var);
        this.c = tlydtdl.compose.runtime.a0.t(v2Var);
    }

    @Override // r4.c
    public final void V(r4.g gVar) {
        v2 v2Var = (v2) gVar.f(m.a);
        v2 v2Var2 = this.a;
        this.b.setValue(new l0(v2Var2, v2Var));
        this.c.setValue(new q2(v2Var, v2Var2));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l1) {
            return lmjxuqdtp.jvm.internal.o.c(((l1) obj).a, this.a);
        }
        return false;
    }

    @Override // r4.f
    public final r4.h getKey() {
        return m.a;
    }

    @Override // r4.f
    public final Object getValue() {
        return (v2) this.c.getValue();
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public final q4.v0 m1790measure3p2s80s(q4.w0 w0Var, q4.t0 t0Var, long j2) {
        tlydtdl.compose.runtime.n1 n1Var = this.b;
        int iB = ((v2) n1Var.getValue()).b(w0Var, w0Var.getLayoutDirection());
        int iD = ((v2) n1Var.getValue()).d(w0Var);
        int iC = ((v2) n1Var.getValue()).c(w0Var, w0Var.getLayoutDirection()) + iB;
        int iA = ((v2) n1Var.getValue()).a(w0Var) + iD;
        q4.m1 m1VarT = t0Var.T(p5.b.i(-iC, j2, -iA));
        return w0Var.g0(p5.b.g(m1VarT.a + iC, j2), p5.b.f(m1VarT.b + iA, j2), mx1.u.a, new k1(m1VarT, iB, iD, 0));
    }
}
