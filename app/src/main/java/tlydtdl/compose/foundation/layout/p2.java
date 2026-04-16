package tlydtdl.compose.foundation.layout;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class p2 extends t3.o implements s4.a0 {
    public float a;
    public float b;
    public float c;
    public float d;
    public boolean e;

    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long Q0(q4.w0 r7) {
        /*
            r6 = this;
            float r0 = r6.c
            boolean r0 = java.lang.Float.isNaN(r0)
            r1 = 2147483647(0x7fffffff, float:NaN)
            r2 = 0
            if (r0 != 0) goto L16
            float r0 = r6.c
            int r0 = r7.O(r0)
            if (r0 >= 0) goto L17
            r0 = r2
            goto L17
        L16:
            r0 = r1
        L17:
            float r3 = r6.d
            boolean r3 = java.lang.Float.isNaN(r3)
            if (r3 != 0) goto L29
            float r3 = r6.d
            int r3 = r7.O(r3)
            if (r3 >= 0) goto L2a
            r3 = r2
            goto L2a
        L29:
            r3 = r1
        L2a:
            float r4 = r6.a
            boolean r4 = java.lang.Float.isNaN(r4)
            if (r4 != 0) goto L41
            float r4 = r6.a
            int r4 = r7.O(r4)
            if (r4 >= 0) goto L3b
            r4 = r2
        L3b:
            if (r4 <= r0) goto L3e
            r4 = r0
        L3e:
            if (r4 == r1) goto L41
            goto L42
        L41:
            r4 = r2
        L42:
            float r5 = r6.b
            boolean r5 = java.lang.Float.isNaN(r5)
            if (r5 != 0) goto L59
            float r5 = r6.b
            int r7 = r7.O(r5)
            if (r7 >= 0) goto L53
            r7 = r2
        L53:
            if (r7 <= r3) goto L56
            r7 = r3
        L56:
            if (r7 == r1) goto L59
            r2 = r7
        L59:
            long r0 = p5.b.a(r4, r0, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.foundation.layout.p2.Q0(q4.w0):long");
    }

    @Override // s4.a0
    public final int maxIntrinsicHeight(q4.w wVar, q4.v vVar, int i) {
        long jQ0 = Q0((q4.w0) wVar);
        if (p5.a.e(jQ0)) {
            return p5.a.g(jQ0);
        }
        if (!this.e) {
            i = p5.b.g(i, jQ0);
        }
        return p5.b.f(vVar.c(i), jQ0);
    }

    @Override // s4.a0
    public final int maxIntrinsicWidth(q4.w wVar, q4.v vVar, int i) {
        long jQ0 = Q0((q4.w0) wVar);
        if (p5.a.f(jQ0)) {
            return p5.a.h(jQ0);
        }
        if (!this.e) {
            i = p5.b.f(i, jQ0);
        }
        return p5.b.g(vVar.R(i), jQ0);
    }

    @Override // s4.a0
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final q4.v0 mo1789measure3p2s80s(q4.w0 w0Var, q4.t0 t0Var, long j2) {
        int iJ;
        int iH;
        int i;
        int iG;
        long jA;
        long jQ0 = Q0(w0Var);
        if (this.e) {
            jA = p5.b.e(j2, jQ0);
        } else {
            if (Float.isNaN(this.a)) {
                iJ = p5.a.j(j2);
                int iH2 = p5.a.h(jQ0);
                if (iJ > iH2) {
                    iJ = iH2;
                }
            } else {
                iJ = p5.a.j(jQ0);
            }
            if (Float.isNaN(this.c)) {
                iH = p5.a.h(j2);
                int iJ2 = p5.a.j(jQ0);
                if (iH < iJ2) {
                    iH = iJ2;
                }
            } else {
                iH = p5.a.h(jQ0);
            }
            if (Float.isNaN(this.b)) {
                i = p5.a.i(j2);
                int iG2 = p5.a.g(jQ0);
                if (i > iG2) {
                    i = iG2;
                }
            } else {
                i = p5.a.i(jQ0);
            }
            if (Float.isNaN(this.d)) {
                iG = p5.a.g(j2);
                int i2 = p5.a.i(jQ0);
                if (iG < i2) {
                    iG = i2;
                }
            } else {
                iG = p5.a.g(jQ0);
            }
            jA = p5.b.a(iJ, iH, i, iG);
        }
        q4.m1 m1VarT = t0Var.T(jA);
        return w0Var.g0(m1VarT.a, m1VarT.b, mx1.u.a, new n(m1VarT, 2));
    }

    @Override // s4.a0
    public final int minIntrinsicHeight(q4.w wVar, q4.v vVar, int i) {
        long jQ0 = Q0((q4.w0) wVar);
        if (p5.a.e(jQ0)) {
            return p5.a.g(jQ0);
        }
        if (!this.e) {
            i = p5.b.g(i, jQ0);
        }
        return p5.b.f(vVar.z(i), jQ0);
    }

    @Override // s4.a0
    public final int minIntrinsicWidth(q4.w wVar, q4.v vVar, int i) {
        long jQ0 = Q0((q4.w0) wVar);
        if (p5.a.f(jQ0)) {
            return p5.a.h(jQ0);
        }
        if (!this.e) {
            i = p5.b.f(i, jQ0);
        }
        return p5.b.g(vVar.M(i), jQ0);
    }
}
