package tlydtdl.compose.foundation.layout;

import d5.q0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function3;
import okhttp3.internal.http2.Settings;
import tlydtdl.compose.runtime.f3;
import tlydtdl.compose.runtime.x0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class z2 implements Function3 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ z2(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.a) {
            case 0:
                ((Number) obj3).intValue();
                tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) ((tlydtdl.compose.runtime.m) obj2);
                sVar.f0(-1608161351);
                Function1 function1 = (Function1) this.b;
                boolean zG = sVar.g(function1);
                Object objR = sVar.R();
                if (zG || objR == tlydtdl.compose.runtime.l.a) {
                    objR = new h0(function1);
                    sVar.q0(objR);
                }
                h0 h0Var = (h0) objR;
                sVar.r(false);
                return h0Var;
            case 1:
                tlydtdl.compose.runtime.m mVar = (tlydtdl.compose.runtime.m) obj2;
                int iIntValue = ((Number) obj3).intValue();
                if ((iIntValue & 6) == 0) {
                    iIntValue |= (iIntValue & 8) == 0 ? ((tlydtdl.compose.runtime.s) mVar).g(obj) : ((tlydtdl.compose.runtime.s) mVar).i(obj) ? 4 : 2;
                }
                tlydtdl.compose.runtime.s sVar2 = (tlydtdl.compose.runtime.s) mVar;
                if (sVar2.W(iIntValue & 1, (iIntValue & 19) != 18)) {
                    sVar2.I((tlydtdl.compose.runtime.a1) this.b, sVar2.m(), obj, false);
                } else {
                    sVar2.Z();
                }
                return lx1.b0.a;
            case 2:
                ((Number) obj3).intValue();
                ((q3.k) this.b).invoke((tlydtdl.compose.runtime.m) obj2, 0);
                return lx1.b0.a;
            default:
                ((Number) obj3).intValue();
                tlydtdl.compose.runtime.s sVar3 = (tlydtdl.compose.runtime.s) ((tlydtdl.compose.runtime.m) obj2);
                sVar3.f0(1582736677);
                p5.c cVar = (p5.c) sVar3.k(t4.r1.h);
                h5.j jVar = (h5.h) sVar3.k(t4.r1.k);
                p5.n nVar = (p5.n) sVar3.k(t4.r1.n);
                q0 q0Var = (q0) this.b;
                boolean zG2 = sVar3.g(q0Var) | sVar3.e(nVar.ordinal());
                Object objR2 = sVar3.R();
                x0 x0Var = tlydtdl.compose.runtime.l.a;
                if (zG2 || objR2 == x0Var) {
                    objR2 = un0.m.v0(q0Var, nVar);
                    sVar3.q0(objR2);
                }
                q0 q0Var2 = (q0) objR2;
                boolean zG3 = sVar3.g(jVar) | sVar3.g(q0Var2);
                Object objR3 = sVar3.R();
                if (zG3 || objR3 == x0Var) {
                    d5.h0 h0Var2 = q0Var2.a;
                    h5.i iVar = h0Var2.f70f;
                    h5.s sVar4 = h0Var2.c;
                    if (sVar4 == null) {
                        sVar4 = h5.s.f;
                    }
                    h5.o oVar = h0Var2.d;
                    int i = oVar != null ? oVar.a : 0;
                    h5.p pVar = h0Var2.e;
                    objR3 = jVar.b(iVar, sVar4, i, pVar != null ? pVar.a : Settings.DEFAULT_INITIAL_WINDOW_SIZE);
                    sVar3.q0(objR3);
                }
                f3 f3Var = (f3) objR3;
                Object objR4 = sVar3.R();
                Object obj4 = objR4;
                if (objR4 == x0Var) {
                    Object value = f3Var.getValue();
                    m2.k2 k2Var = new m2.k2();
                    k2Var.a = nVar;
                    k2Var.b = cVar;
                    k2Var.c = jVar;
                    k2Var.d = q0Var;
                    k2Var.e = value;
                    k2Var.f = m2.z1.b(q0Var, cVar, jVar);
                    sVar3.q0(k2Var);
                    obj4 = k2Var;
                }
                m2.k2 k2Var2 = (m2.k2) obj4;
                Object value2 = f3Var.getValue();
                if (nVar != k2Var2.a || !lmjxuqdtp.jvm.internal.o.c(cVar, k2Var2.b) || !lmjxuqdtp.jvm.internal.o.c(jVar, k2Var2.c) || !lmjxuqdtp.jvm.internal.o.c(q0Var2, k2Var2.d) || !lmjxuqdtp.jvm.internal.o.c(value2, k2Var2.e)) {
                    k2Var2.a = nVar;
                    k2Var2.b = cVar;
                    k2Var2.c = jVar;
                    k2Var2.d = q0Var2;
                    k2Var2.e = value2;
                    k2Var2.f = m2.z1.b(q0Var2, cVar, jVar);
                }
                boolean zI = sVar3.i(k2Var2);
                Object objR5 = sVar3.R();
                if (zI || objR5 == x0Var) {
                    objR5 = new e8.b(5, k2Var2);
                    sVar3.q0(objR5);
                }
                t3.p pVarB = tlydtdl.compose.ui.layout.a.b(t3.m.a, (Function3) objR5);
                sVar3.r(false);
                return pVarB;
        }
    }
}
