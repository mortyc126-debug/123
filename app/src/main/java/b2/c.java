package b2;

import a2.w3;
import a2.z0;
import f2.r;
import i2.a0;
import i2.s;
import i2.v;
import java.util.Iterator;
import st.w0;
import tlydtdl.compose.runtime.n1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements n {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ w3 b;
    public final /* synthetic */ Object c;

    public c(a0 a0Var, z0 z0Var, v vVar) {
        this.b = a0Var;
        this.c = z0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x01a4  */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, java.util.Collection, java.util.List] */
    @Override // b2.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float a(float r19) {
        /*
            Method dump skipped, instruction units count: 444
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.c.a(float):float");
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Iterable, java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, java.util.List] */
    @Override // b2.n
    public final float b(float f2, float f3) {
        switch (this.a) {
            case 0:
                float fAbs = Math.abs(f3);
                f2.q qVarH = this.b.h();
                int i = 0;
                if (!qVarH.k.isEmpty()) {
                    ?? r0 = qVarH.k;
                    int size = r0.size();
                    Iterator it = r0.iterator();
                    while (it.hasNext()) {
                        i += ((r) it.next()).q;
                    }
                    i /= size;
                }
                float f4 = fAbs - i;
                if (f4 < 0.0f) {
                    f4 = 0.0f;
                }
                return Math.signum(f3) * f4;
            default:
                a0 a0Var = this.b;
                int iN = a0Var.n();
                n1 n1Var = a0Var.p;
                int i2 = ((s) n1Var.getValue()).c + iN;
                if (i2 == 0) {
                    return 0.0f;
                }
                int i3 = f2 < 0.0f ? a0Var.e + 1 : a0Var.e;
                int iJ = w0.j(((int) (f3 / i2)) + i3, 0, a0Var.m());
                a0Var.n();
                int i4 = ((s) n1Var.getValue()).c;
                long j2 = i3;
                long j3 = 1;
                long j4 = j2 - j3;
                if (j4 < 0) {
                    j4 = 0;
                }
                int i6 = (int) j4;
                long j5 = j2 + j3;
                if (j5 > 2147483647L) {
                    j5 = 2147483647L;
                }
                int iAbs = Math.abs((w0.j(w0.j(iJ, i6, (int) j5), 0, a0Var.m()) - i3) * i2) - i2;
                int i7 = iAbs >= 0 ? iAbs : 0;
                if (i7 == 0) {
                    return i7;
                }
                return Math.signum(f2) * i7;
        }
    }

    public c(f2.a0 a0Var, q qVar) {
        this.b = a0Var;
        this.c = qVar;
    }
}
