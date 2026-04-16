package ec1;

import a61.b;
import db.r;
import e71.p;
import id1.a;
import java.util.List;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.internal.o;
import mc0.c;
import md1.g;
import ny1.r2;
import qx1.d;
import rw0.e;
import st.w0;
import t4.r1;
import t4.t2;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.e1;
import tlydtdl.compose.runtime.s;
import tlydtdl.compose.runtime.x0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements a {
    public final fc0.a a;

    public l(fc0.a aVar) {
        this.a = aVar;
    }

    public final void a(u uVar, tlydtdl.compose.runtime.m mVar, int i) {
        o.h(uVar, "viewModel");
        s sVar = (s) mVar;
        sVar.h0(-2100912800);
        int i2 = (sVar.i(uVar) ? 4 : 2) | i;
        if (sVar.W(i2 & 1, (i2 & 3) != 2)) {
            e1 e1VarR = w0.r(uVar.h(), sVar, 0, 7);
            e1 e1VarR2 = w0.r(uVar.i(), sVar, 0, 7);
            e1 e1VarR3 = w0.r(uVar.c(), sVar, 0, 7);
            e1 e1VarR4 = w0.r(uVar.d(), sVar, 0, 7);
            e1 e1VarR5 = w0.r(uVar.b(), sVar, 0, 7);
            t2 t2Var = (t2) sVar.k(r1.p);
            r2 r2VarE = uVar.e();
            boolean zG = sVar.g(t2Var);
            Object objR = sVar.R();
            x0 x0Var = tlydtdl.compose.runtime.l.a;
            if (zG || objR == x0Var) {
                objR = new b(t2Var, (d) null, 3);
                sVar.q0(objR);
            }
            g.A(r2VarE, (Function2) objR, sVar, 0);
            List list = (List) e1VarR4.getValue();
            e eVarG = uVar.g();
            c cVar = (c) e1VarR3.getValue();
            jd1.c cVar2 = (jd1.c) e1VarR.getValue();
            r2 r2VarF = uVar.f();
            hc1.g gVar = (hc1.g) e1VarR5.getValue();
            boolean zBooleanValue = ((Boolean) e1VarR2.getValue()).booleanValue();
            r2 r2VarA = uVar.a();
            boolean zI = sVar.i(uVar);
            Object objR2 = sVar.R();
            if (zI || objR2 == x0Var) {
                objR2 = new p(uVar);
                sVar.q0(objR2);
            }
            hc1.a.b(list, cVar2, eVarG, r2VarF, zBooleanValue, (fy1.e) objR2, cVar, gVar, r2VarA, sVar, 0);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new r(this, uVar, i, 18);
        }
    }

    public final /* bridge */ /* synthetic */ void c(Object obj, tlydtdl.compose.runtime.m mVar, int i) {
        a((u) obj, mVar, 0);
    }
}
