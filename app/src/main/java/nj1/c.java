package nj1;

import a2.z0;
import a70.a;
import ah.n;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import com.google.android.material.R;
import i2.d0;
import i2.f;
import java.util.List;
import ld1.r;
import lf.y;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.functions.Function3;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import q3.k;
import q4.u0;
import rw0.e;
import s4.j;
import sf1.q;
import sf1.s0;
import st.w0;
import t3.p;
import tlydtdl.compose.foundation.layout.e2;
import tlydtdl.compose.foundation.layout.o2;
import tlydtdl.compose.foundation.layout.v2;
import tlydtdl.compose.runtime.a0;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.e1;
import tlydtdl.compose.runtime.l;
import tlydtdl.compose.runtime.s;
import tlydtdl.compose.runtime.u1;
import tlydtdl.compose.runtime.x0;
import tlydtdl.datastore.preferences.protobuf.j1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static final k a = new k(new b(0), false, -1963583528);
    public static final k b = new k(new a(12), false, 1655343014);

    public static final void a(m mVar, tlydtdl.compose.runtime.m mVar2, int i) {
        o.h(mVar, "state");
        boolean z = mVar.f356f;
        s sVar = (s) mVar2;
        sVar.h0(486237332);
        int i2 = (sVar.g(mVar) ? 4 : 2) | i;
        if (sVar.W(i2 & 1, (i2 & 3) != 2)) {
            Object objR = sVar.R();
            x0 x0Var = l.a;
            if (objR == x0Var) {
                objR = a0.t(null);
                sVar.q0(objR);
            }
            e1 e1Var = (e1) objR;
            md1.g.i(sVar, 0);
            int i3 = i2 & 14;
            boolean z2 = i3 == 4;
            Object objR2 = sVar.R();
            if (z2 || objR2 == x0Var) {
                objR2 = new y(mVar, e1Var, (qx1.d) null, 2);
                sVar.q0(objR2);
            }
            a0.f(sVar, mVar, (Function2) objR2);
            if (z) {
                sVar.f0(-1428064202);
                j1.a(0, 1, sVar, mVar.g, false);
            } else {
                sVar.f0(-1430183858);
            }
            sVar.r(false);
            p pVarA = tlydtdl.compose.ui.platform.a.a(o2.d(t3.m.a, 1.0f), "video_post_player_container");
            u0 u0VarD = tlydtdl.compose.foundation.layout.s.d(t3.c.a, false);
            int iHashCode = Long.hashCode(sVar.T);
            u1 u1VarM = sVar.m();
            p pVarX = j4.x(sVar, pVarA);
            s4.l.f436d2.getClass();
            j jVar = s4.k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            a0.y(sVar, u0VarD, s4.k.f435f);
            a0.y(sVar, u1VarM, s4.k.e);
            s4.i iVar = s4.k.g;
            if (sVar.S || !o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar);
            }
            a0.y(sVar, pVarX, s4.k.d);
            Integer num = (Integer) e1Var.getValue();
            if (num != null) {
                sVar.f0(282132223);
                b(mVar, num.intValue(), null, sVar, i3);
            } else {
                sVar.f0(279765652);
            }
            sVar.r(false);
            if (z) {
                sVar.f0(282271072);
                q.f(new s0(i.u(r.Companion, R.dimen.m3_comp_fab_primary_large_container_height), mVar.h, 2), (r) null, (v2) null, (List) null, a.a, sVar, 24576, 14);
            } else {
                sVar.f0(279765652);
            }
            sVar.r(false);
            sVar.r(true);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new ln0.b(mVar, i, 4);
        }
    }

    public static final void b(m mVar, int i, p pVar, tlydtdl.compose.runtime.m mVar2, int i2) {
        p pVar2;
        i2.a0 a0Var;
        m mVar3;
        e1 e1Var;
        o.h(mVar, "state");
        e eVar = mVar.a;
        s sVar = (s) mVar2;
        sVar.h0(1522036138);
        int i3 = i2 | (sVar.g(mVar) ? 4 : 2) | (sVar.e(i) ? 32 : 16) | 384;
        if (sVar.W(i3 & 1, (i3 & 147) != 146)) {
            e1 e1VarP = w0.p(eVar.a, eVar.a(), sVar, 0);
            boolean zG = sVar.g(e1VarP);
            Object objR = sVar.R();
            x0 x0Var = l.a;
            if (zG || objR == x0Var) {
                objR = new lu0.g(e1VarP, 1);
                sVar.q0(objR);
            }
            i2.a0 a0VarB = d0.b(i, (Function0) objR, sVar, (i3 >> 3) & 14, 2);
            es1.c.g(new ge1.d(a0VarB, null, mVar.k, mVar.f357j, 2), sVar, 0);
            Object objR2 = sVar.R();
            if (objR2 == x0Var) {
                objR2 = a0.t(Boolean.FALSE);
                sVar.q0(objR2);
            }
            e1 e1Var2 = (e1) objR2;
            int i4 = i3 & 14;
            boolean zG2 = (i4 == 4) | sVar.g(a0VarB);
            Object objR3 = sVar.R();
            if (zG2 || objR3 == x0Var) {
                objR3 = new n(mVar, a0VarB, (qx1.d) null, 11);
                sVar.q0(objR3);
            }
            a0.f(sVar, b0.a, (Function2) objR3);
            boolean zG3 = sVar.g(a0VarB) | (i4 == 4);
            Object objR4 = sVar.R();
            if (zG3 || objR4 == x0Var) {
                c01.d dVar = new c01.d(a0VarB, mVar, e1Var2, (qx1.d) null, 2);
                a0Var = a0VarB;
                mVar3 = mVar;
                e1Var = e1Var2;
                sVar.q0(dVar);
                objR4 = dVar;
            } else {
                a0Var = a0VarB;
                mVar3 = mVar;
                e1Var = e1Var2;
            }
            a0.f(sVar, a0Var, (Function2) objR4);
            p pVar3 = t3.m.a;
            rw0.b.e(eVar, q3.p.d(-765766782, new z0(17, mVar3, e1Var), sVar), tlydtdl.compose.ui.platform.a.a(o2.d(pVar3, 1.0f), "video_post_player_pager"), a0Var, i, (e2) null, (f) null, 0.0f, false, (t3.f) null, 0, a, b, (Function3) null, sVar, ((i3 << 9) & 57344) | 48, 40928);
            pVar2 = pVar3;
        } else {
            sVar.Z();
            pVar2 = pVar;
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new an0.i(i, i2, 8, mVar, pVar2);
        }
    }
}
