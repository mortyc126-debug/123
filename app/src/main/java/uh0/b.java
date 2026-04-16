package uh0;

import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import com.google.android.material.R;
import com.ironsource.adqualitysdk.sdk.i.a0;
import cy1.e;
import dg1.d;
import dg1.g;
import java.util.List;
import ld1.r;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import of1.q;
import org.apache.commons.net.telnet.TelnetCommand;
import s4.i;
import s4.j;
import s4.k;
import st.w0;
import t3.c;
import t3.p;
import tlydtdl.compose.foundation.layout.c0;
import tlydtdl.compose.foundation.layout.e0;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.k1;
import tlydtdl.compose.runtime.l;
import tlydtdl.compose.runtime.m;
import tlydtdl.compose.runtime.s;
import tlydtdl.compose.runtime.u1;
import tlydtdl.compose.runtime.x0;
import x10.v;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static final List a = ct1.b.C(new d[]{new g(2131231728, false), new g(2131231444, false), new g(2131231311, false), new g(2131231437, false), new g(2131231402, false), new g(2131231782, false), new g(2131231448, false), new g(2131231450, false), new g(2131231501, false)});
    public static final List b = ct1.b.C(new r[]{w0.i0(), w0.d0(), w0.j0(), w0.a0(), w0.Z(), w0.g0()});

    public static final void a(m mVar, int i) {
        s sVar = (s) mVar;
        sVar.h0(-1641814020);
        if (sVar.W(i & 1, i != 0)) {
            Object objR = sVar.R();
            x0 x0Var = l.a;
            if (objR == x0Var) {
                cy1.d dVar = e.a;
                objR = a0.g(e.b.c(a.size()), sVar);
            }
            k1 k1Var = (k1) objR;
            Object objR2 = sVar.R();
            if (objR2 == x0Var) {
                cy1.d dVar2 = e.a;
                objR2 = a0.g(e.b.c(b.size()), sVar);
            }
            k1 k1Var2 = (k1) objR2;
            Object objR3 = sVar.R();
            if (objR3 == x0Var) {
                objR3 = new sm.a(k1Var, k1Var2, null, 10);
                sVar.q0(objR3);
            }
            tlydtdl.compose.runtime.a0.f(sVar, b0.a, (Function2) objR3);
            e0 e0VarA = c0.a(tlydtdl.compose.foundation.layout.l.g(20), c.n, sVar, 54);
            int iHashCode = Long.hashCode(sVar.T);
            u1 u1VarM = sVar.m();
            p pVarX = j4.x(sVar, t3.m.a);
            s4.l.f436d2.getClass();
            j jVar = k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar, e0VarA, k.f435f);
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM, k.e);
            i iVar = k.g;
            if (sVar.S || !o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar);
            }
            tlydtdl.compose.runtime.a0.y(sVar, pVarX, k.d);
            tlydtdl.compose.animation.a.a(new lx1.l(Integer.valueOf(k1Var.h()), Integer.valueOf(k1Var2.h())), null, null, null, null, null, a.a, sVar, 1572864, 62);
            z10.d.h(a0.v(v.Companion, 2132019034), i.u(r.Companion, R.dimen.m3_comp_fab_primary_focus_state_layer_opacity), q.a(), (p) null, false, (of1.e) null, 0, (Function1) null, sVar, 0, TelnetCommand.EL);
            sVar = sVar;
            sVar.r(true);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new nj1.b(i, 15);
        }
    }
}
