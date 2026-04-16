package tlydtdl.compose.foundation.layout;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class s2 extends t3.o implements s4.a0 {
    public float a;
    public float b;

    @Override // s4.a0
    public final int maxIntrinsicHeight(q4.w wVar, q4.v vVar, int i) {
        int iC = vVar.c(i);
        int iO = !Float.isNaN(this.b) ? wVar.O(this.b) : 0;
        return iC < iO ? iO : iC;
    }

    @Override // s4.a0
    public final int maxIntrinsicWidth(q4.w wVar, q4.v vVar, int i) {
        int iR = vVar.R(i);
        int iO = !Float.isNaN(this.a) ? wVar.O(this.a) : 0;
        return iR < iO ? iO : iR;
    }

    @Override // s4.a0
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final q4.v0 mo1789measure3p2s80s(q4.w0 w0Var, q4.t0 t0Var, long j2) {
        int iJ;
        int i;
        if (Float.isNaN(this.a) || p5.a.j(j2) != 0) {
            iJ = p5.a.j(j2);
        } else {
            int iO = w0Var.O(this.a);
            iJ = p5.a.h(j2);
            if (iO < 0) {
                iO = 0;
            }
            if (iO <= iJ) {
                iJ = iO;
            }
        }
        int iH = p5.a.h(j2);
        if (Float.isNaN(this.b) || p5.a.i(j2) != 0) {
            i = p5.a.i(j2);
        } else {
            int iO2 = w0Var.O(this.b);
            i = p5.a.g(j2);
            int i2 = iO2 >= 0 ? iO2 : 0;
            if (i2 <= i) {
                i = i2;
            }
        }
        q4.m1 m1VarT = t0Var.T(p5.b.a(iJ, iH, i, p5.a.g(j2)));
        return w0Var.g0(m1VarT.a, m1VarT.b, mx1.u.a, new n(m1VarT, 3));
    }

    @Override // s4.a0
    public final int minIntrinsicHeight(q4.w wVar, q4.v vVar, int i) {
        int iZ = vVar.z(i);
        int iO = !Float.isNaN(this.b) ? wVar.O(this.b) : 0;
        return iZ < iO ? iO : iZ;
    }

    @Override // s4.a0
    public final int minIntrinsicWidth(q4.w wVar, q4.v vVar, int i) {
        int iM = vVar.M(i);
        int iO = !Float.isNaN(this.a) ? wVar.O(this.a) : 0;
        return iM < iO ? iO : iM;
    }
}
