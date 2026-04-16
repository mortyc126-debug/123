package wz0;

import a4.a1;
import a5.h;
import by1.b;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import fe1.g;
import fe1.j;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function3;
import q3.k;
import q4.l;
import q4.u0;
import s4.i;
import tlydtdl.compose.foundation.layout.o2;
import tlydtdl.compose.runtime.u1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j0 implements Function3 {
    public final /* synthetic */ dg1.f a;
    public final /* synthetic */ float b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ k d;

    public /* synthetic */ j0(dg1.f fVar, float f2, Function0 function0, k kVar) {
        this.a = fVar;
        this.b = f2;
        this.c = function0;
        this.d = kVar;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        tlydtdl.compose.foundation.layout.a0 a0Var = (tlydtdl.compose.foundation.layout.a0) obj;
        tlydtdl.compose.runtime.m mVar = (tlydtdl.compose.runtime.m) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        lmjxuqdtp.jvm.internal.o.h(a0Var, "$this$BoxWithConstraints");
        if ((iIntValue & 6) == 0) {
            iIntValue |= ((tlydtdl.compose.runtime.s) mVar).g(a0Var) ? 4 : 2;
        }
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        if (sVar.W(iIntValue & 1, (iIntValue & 19) != 18)) {
            q4.k kVar = l.b;
            Object objR = sVar.R();
            if (objR == tlydtdl.compose.runtime.l.a) {
                objR = new g(3, 15.0f);
                sVar.q0(objR);
            }
            g gVar = (g) objR;
            tlydtdl.compose.foundation.layout.b0 b0Var = (tlydtdl.compose.foundation.layout.b0) a0Var;
            tlydtdl.compose.foundation.layout.x xVar = tlydtdl.compose.foundation.layout.x.a;
            t3.m mVar2 = t3.m.a;
            fe1.f.a(this.a, (String) null, (a1) null, xVar.a(mVar2), (t3.d) null, kVar, 0.0f, (a4.z) null, (Function0) null, false, (md1.n0) null, (j) null, gVar, false, (Function3) null, (fe1.k) null, sVar, 197040, 384, 61392);
            long jE = h02.a.e(b0Var.d(), b.L(new p5.f(b0Var.d()), new p5.f(this.b)).a);
            t3.p pVarQ = o2.q(jE, mVar2);
            u0 u0VarD = tlydtdl.compose.foundation.layout.s.d(t3.c.a, false);
            int iHashCode = Long.hashCode(sVar.T);
            u1 u1VarM = sVar.m();
            t3.p pVarX = j4.x(sVar, pVarQ);
            s4.l.f436d2.getClass();
            s4.j jVar = s4.k.b;
            sVar.j0();
            if (sVar.S) {
                sVar.l(jVar);
            } else {
                sVar.t0();
            }
            tlydtdl.compose.runtime.a0.y(sVar, u0VarD, s4.k.f435f);
            tlydtdl.compose.runtime.a0.y(sVar, u1VarM, s4.k.e);
            i iVar = s4.k.g;
            if (sVar.S || !lmjxuqdtp.jvm.internal.o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar, iHashCode, iVar);
            }
            tlydtdl.compose.runtime.a0.y(sVar, pVarX, s4.k.d);
            this.d.invoke(xVar, new p5.i(jE), sVar, 6);
            sVar.r(true);
            Function0 function0 = this.c;
            if (function0 != null) {
                sVar.f0(207554617);
                tlydtdl.compose.foundation.layout.m.i(sVar, md1.g.v(xVar.a(mVar2), md1.m0.a, (h) null, false, false, (Function0) null, (Function0) null, function0, 62));
            } else {
                sVar.f0(205157325);
            }
            sVar.r(false);
        } else {
            sVar.Z();
        }
        return lx1.b0.a;
    }
}
