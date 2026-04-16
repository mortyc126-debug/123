package tlydtdl.compose.foundation.layout;

import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import lmjxuqdtp.jvm.functions.Function2;
import q4.u0;
import t3.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class s {
    public static final q1.n0 a = c(true);
    public static final q1.n0 b = c(false);
    public static final r c = r.b;

    public static final void a(final t3.p pVar, tlydtdl.compose.runtime.m mVar, final int i) {
        int i2;
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(-211209833);
        if ((i & 6) == 0) {
            i2 = (sVar.g(pVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (sVar.W(i2 & 1, (i2 & 3) != 2)) {
            int iHashCode = Long.hashCode(sVar.T);
            t3.p pVarX = j4.x(sVar, pVar);
            tlydtdl.compose.runtime.u1 u1VarM = sVar.m();
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar, c, s4.k.f435f);
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM, s4.k.e);
            tlydtdl.compose.runtime.a0.y(sVar, pVarX, s4.k.d);
            s4.i iVar = s4.k.g;
            if (sVar.S || !lmjxuqdtp.jvm.internal.o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar);
            }
            sVar.r(true);
        } else {
            sVar.Z();
        }
        tlydtdl.compose.runtime.a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            final int i3 = 0;
            a2VarV.d = new Function2() { // from class: tlydtdl.compose.foundation.layout.q
                public final Object invoke(Object obj, Object obj2) {
                    tlydtdl.compose.runtime.m mVar2 = (tlydtdl.compose.runtime.m) obj;
                    Integer num = (Integer) obj2;
                    switch (i3) {
                        case 0:
                            num.intValue();
                            s.a(pVar, mVar2, tlydtdl.compose.runtime.a0.B(i | 1));
                            break;
                        default:
                            num.getClass();
                            y10.r.x(pVar, mVar2, tlydtdl.compose.runtime.a0.B(i | 1));
                            break;
                    }
                    return lx1.b0.a;
                }
            };
        }
    }

    public static final void b(q4.l1 l1Var, q4.m1 m1Var, q4.t0 t0Var, p5.n nVar, int i, int i2, d dVar) {
        d dVar2;
        Object objL = t0Var.l();
        p pVar = objL instanceof p ? (p) objL : null;
        q4.l1.l(l1Var, m1Var, ((pVar == null || (dVar2 = pVar.a) == null) ? dVar : dVar2).a((((long) m1Var.a) << 32) | (((long) m1Var.b) & 4294967295L), (((long) i) << 32) | (((long) i2) & 4294967295L), nVar));
    }

    public static final q1.n0 c(boolean z) {
        q1.n0 n0Var = new q1.n0(9);
        t3.h hVar = t3.c.a;
        n0Var.m(hVar, new v(hVar, z));
        t3.h hVar2 = t3.c.b;
        n0Var.m(hVar2, new v(hVar2, z));
        t3.h hVar3 = t3.c.c;
        n0Var.m(hVar3, new v(hVar3, z));
        t3.h hVar4 = t3.c.d;
        n0Var.m(hVar4, new v(hVar4, z));
        t3.h hVar5 = t3.c.e;
        n0Var.m(hVar5, new v(hVar5, z));
        t3.h hVar6 = t3.c.f;
        n0Var.m(hVar6, new v(hVar6, z));
        t3.h hVar7 = t3.c.g;
        n0Var.m(hVar7, new v(hVar7, z));
        t3.h hVar8 = t3.c.h;
        n0Var.m(hVar8, new v(hVar8, z));
        t3.h hVar9 = t3.c.i;
        n0Var.m(hVar9, new v(hVar9, z));
        return n0Var;
    }

    public static final u0 d(d dVar, boolean z) {
        u0 u0Var = (u0) (z ? a : b).g(dVar);
        return u0Var == null ? new v(dVar, z) : u0Var;
    }
}
