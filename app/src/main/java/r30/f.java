package r30;

import a4.w0;
import amuvvoafs.os.Bundle;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import ld1.r;
import lmjxuqdtp.jvm.internal.o;
import q4.u0;
import t3.p;
import tlydtdl.compose.runtime.a0;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.m;
import tlydtdl.compose.runtime.s;
import tlydtdl.compose.runtime.u1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements id1.c {
    public final void a(l lVar, m mVar, int i) {
        o.h(lVar, "viewModel");
        s sVar = (s) mVar;
        sVar.h0(394799840);
        int i2 = (sVar.i(lVar) ? 4 : 2) | i;
        if (sVar.W(i2 & 1, (i2 & 3) != 2)) {
            p pVarO = com.facebook.appevents.l.o(t3.m.a, i.e(2131100891, 0, sVar, r.Companion), w0.a);
            u0 u0VarD = tlydtdl.compose.foundation.layout.s.d(t3.c.a, false);
            int iHashCode = Long.hashCode(sVar.T);
            u1 u1VarM = sVar.m();
            p pVarX = j4.x(sVar, pVarO);
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
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
            p30.a.a((p30.d) st.w0.r(lVar.k, sVar, 0, 7).getValue(), sVar, 0);
            sVar.r(true);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new nu0.b(this, lVar, i, 7);
        }
    }

    public final Object b(Bundle bundle) {
        Object objY;
        o.h(bundle, "savedState");
        t10.f fVar = t10.f.d;
        wy1.a aVarSerializer = e.Companion.serializer();
        if (t10.r.Companion.a(bundle).a != fVar) {
            objY = null;
        } else {
            try {
                objY = ct1.b.y(bundle, "object", aVarSerializer);
            } catch (Exception e) {
                s02.b bVar = s02.d.a;
                String str = "Cannot parse to " + e.class.getName() + " from bundle: " + bundle;
                bVar.getClass();
                s02.b.s(str, e);
                objY = null;
            }
        }
        e eVar = (e) objY;
        return eVar == null ? new e(null) : eVar;
    }

    public final /* bridge */ /* synthetic */ void c(Object obj, m mVar, int i) {
        a((l) obj, mVar, 0);
    }
}
