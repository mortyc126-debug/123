package qq;

import id1.a;
import lmjxuqdtp.jvm.internal.o;
import ny1.b2;
import ny1.r2;
import q40.f;
import rw0.e;
import st.w0;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.e1;
import tlydtdl.compose.runtime.l;
import tlydtdl.compose.runtime.m;
import tlydtdl.compose.runtime.s;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements a {
    public final fc0.a a;

    public c(fc0.a aVar) {
        this.a = aVar;
    }

    public final void a(n nVar, m mVar, int i) {
        o.h(nVar, "viewModel");
        s sVar = (s) mVar;
        sVar.h0(-1597565411);
        int i2 = (sVar.i(nVar) ? 4 : 2) | i;
        if (sVar.W(i2 & 1, (i2 & 3) != 2)) {
            e1 e1VarR = w0.r(nVar.d(), sVar, 0, 7);
            e1 e1VarR2 = w0.r(nVar.f(), sVar, 0, 7);
            e1 e1VarR3 = w0.r(nVar.g(), sVar, 0, 7);
            mc0.c cVar = (mc0.c) e1VarR.getValue();
            e eVarB = nVar.b();
            jd1.c cVar2 = (jd1.c) e1VarR2.getValue();
            b2 b2VarO = nVar.c().o();
            r2 r2VarE = nVar.e();
            boolean zBooleanValue = ((Boolean) e1VarR3.getValue()).booleanValue();
            boolean zI = sVar.i(nVar);
            Object objR = sVar.R();
            if (zI || objR == l.a) {
                objR = new qh0.a(nVar);
                sVar.q0(objR);
            }
            tq.a.a(cVar, eVarB, cVar2, b2VarO, r2VarE, zBooleanValue, (fy1.e) objR, nVar.a(), sVar, 0);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new f(this, nVar, i, 8);
        }
    }

    public final /* bridge */ /* synthetic */ void c(Object obj, m mVar, int i) {
        a((n) obj, mVar, 0);
    }
}
