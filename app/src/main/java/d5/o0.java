package d5;

import h5.h;
import kotlin.jvm.internal.IntCompanionObject;
import p5.n;
import st.w0;
import tlydtdl.compose.foundation.lazy.layout.r1;
import un0.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class o0 {
    public final h a;
    public final p5.c b;
    public final n c;
    public final r1 d;

    public o0(h hVar, p5.c cVar, n nVar, int i) {
        this.a = hVar;
        this.b = cVar;
        this.c = nVar;
        this.d = i > 0 ? new r1(i, 12) : null;
    }

    public static m0 a(o0 o0Var, String str, q0 q0Var, int i) {
        int i2 = (i & 4) != 0 ? 1 : 3;
        int i3 = (i & 16) != 0 ? IntCompanionObject.MAX_VALUE : 1;
        long jB = p5.b.b(0, 0, 15);
        n nVar = o0Var.c;
        p5.c cVar = o0Var.b;
        h hVar = o0Var.a;
        o0Var.getClass();
        return b(o0Var, new g(str), q0Var, i2, true, i3, jB, nVar, cVar, hVar, 32);
    }

    public static m0 b(o0 o0Var, g gVar, q0 q0Var, int i, boolean z, int i2, long j2, n nVar, p5.c cVar, h hVar, int i3) {
        char c;
        long j3;
        m0 m0Var;
        int i4 = 1;
        int i6 = (i3 & 4) != 0 ? 1 : i;
        r1 r1Var = o0Var.d;
        mx1.t tVar = mx1.t.a;
        l0 l0Var = new l0(gVar, q0Var, tVar, i2, z, i6, cVar, nVar, hVar, j2);
        m0 m0Var2 = null;
        if (r1Var != null) {
            k kVar = new k(l0Var);
            q1.u uVar = (q1.u) r1Var.c;
            if (uVar != null) {
                m0Var = (m0) uVar.c(kVar);
            } else if (lmjxuqdtp.jvm.internal.o.c((k) r1Var.b, kVar)) {
                m0Var = (m0) r1Var.d;
            }
            if (m0Var != null && !m0Var.b.a.a()) {
                m0Var2 = m0Var;
            }
        }
        if (m0Var2 != null) {
            return new m0(l0Var, m0Var2.b, p5.b.d(j2, (((long) ((int) Math.ceil(r1.e))) & 4294967295L) | (((long) ((int) Math.ceil(r1.d))) << 32)));
        }
        av1.g gVar2 = new av1.g(gVar, m.v0(q0Var, nVar), tVar, cVar, hVar);
        int iJ = p5.a.j(j2);
        int iH = ((z || i6 == 2 || i6 == 4 || i6 == 5) && p5.a.d(j2)) ? p5.a.h(j2) : IntCompanionObject.MAX_VALUE;
        if (z || (i6 != 2 && i6 != 4 && i6 != 5)) {
            i4 = i2;
        }
        if (iJ == iH) {
            c = ' ';
            j3 = 4294967295L;
        } else {
            c = ' ';
            j3 = 4294967295L;
            iH = w0.j((int) Math.ceil(gVar2.b()), iJ, iH);
        }
        m0 m0Var3 = new m0(l0Var, new r(gVar2, di0.z.r(0, iH, 0, p5.a.g(j2)), i4, i6), p5.b.d(j2, (((long) ((int) Math.ceil(r1.e))) & j3) | (((long) ((int) Math.ceil(r1.d))) << c)));
        if (r1Var != null) {
            q1.u uVar2 = (q1.u) r1Var.c;
            if (uVar2 != null) {
                uVar2.d(new k(l0Var), m0Var3);
                return m0Var3;
            }
            r1Var.b = new k(l0Var);
            r1Var.d = m0Var3;
        }
        return m0Var3;
    }
}
