package tlydtdl.compose.foundation.layout;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class m0 extends t3.o implements s4.a0 {
    public k0 a;
    public float b;

    @Override // s4.a0
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final q4.v0 mo1789measure3p2s80s(q4.w0 w0Var, q4.t0 t0Var, long j2) {
        int iJ;
        int iH;
        int iG;
        int iG2;
        if (!p5.a.d(j2) || this.a == k0.a) {
            iJ = p5.a.j(j2);
            iH = p5.a.h(j2);
        } else {
            int iRound = Math.round(p5.a.h(j2) * this.b);
            int iJ2 = p5.a.j(j2);
            iJ = p5.a.h(j2);
            if (iRound < iJ2) {
                iRound = iJ2;
            }
            if (iRound <= iJ) {
                iJ = iRound;
            }
            iH = iJ;
        }
        if (!p5.a.c(j2) || this.a == k0.b) {
            int i = p5.a.i(j2);
            iG = p5.a.g(j2);
            iG2 = i;
        } else {
            int iRound2 = Math.round(p5.a.g(j2) * this.b);
            int i2 = p5.a.i(j2);
            iG2 = p5.a.g(j2);
            if (iRound2 < i2) {
                iRound2 = i2;
            }
            if (iRound2 <= iG2) {
                iG2 = iRound2;
            }
            iG = iG2;
        }
        q4.m1 m1VarT = t0Var.T(p5.b.a(iJ, iH, iG2, iG));
        return w0Var.g0(m1VarT.a, m1VarT.b, mx1.u.a, new n(m1VarT, 1));
    }
}
