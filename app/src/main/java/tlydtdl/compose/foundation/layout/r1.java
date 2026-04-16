package tlydtdl.compose.foundation.layout;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class r1 extends t3.o implements s4.a0 {
    public final /* synthetic */ int a;

    public abstract long Q0(q4.t0 t0Var, long j2);

    public abstract boolean R0();

    public int maxIntrinsicHeight(q4.w wVar, q4.v vVar, int i) {
        switch (this.a) {
        }
        return vVar.c(i);
    }

    @Override // s4.a0
    public int maxIntrinsicWidth(q4.w wVar, q4.v vVar, int i) {
        switch (this.a) {
        }
        return vVar.R(i);
    }

    @Override // s4.a0
    /* JADX INFO: renamed from: measure-3p2s80s */
    public q4.v0 mo1789measure3p2s80s(q4.w0 w0Var, q4.t0 t0Var, long j2) {
        long jQ0 = Q0(t0Var, j2);
        if (R0()) {
            jQ0 = p5.b.e(j2, jQ0);
        }
        q4.m1 m1VarT = t0Var.T(jQ0);
        return w0Var.g0(m1VarT.a, m1VarT.b, mx1.u.a, new q1(m1VarT, 0));
    }

    public int minIntrinsicHeight(q4.w wVar, q4.v vVar, int i) {
        switch (this.a) {
        }
        return vVar.z(i);
    }

    @Override // s4.a0
    public int minIntrinsicWidth(q4.w wVar, q4.v vVar, int i) {
        switch (this.a) {
        }
        return vVar.M(i);
    }
}
