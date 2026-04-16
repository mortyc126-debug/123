package tlydtdl.compose.foundation.lazy.layout;

import a2.r2;
import amuvvoafs.view.View;
import com.gnacba.amuvvoafs.gms.internal.ads.wc0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.functions.Function3;
import q4.c2;
import q4.y1;
import t3.p;
import tlydtdl.compose.runtime.e1;
import tlydtdl.compose.runtime.s;
import tlydtdl.compose.runtime.x0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class n0 implements Function3 {
    public final /* synthetic */ z0 a;
    public final /* synthetic */ p b;
    public final /* synthetic */ o0 c;
    public final /* synthetic */ e1 d;

    public n0(z0 z0Var, p pVar, o0 o0Var, e1 e1Var) {
        this.a = z0Var;
        this.b = pVar;
        this.c = o0Var;
        this.d = e1Var;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        p pVarThen;
        r3.c cVar = (r3.c) obj;
        ((Number) obj3).intValue();
        s sVar = (s) ((tlydtdl.compose.runtime.m) obj2);
        Object objR = sVar.R();
        x0 x0Var = tlydtdl.compose.runtime.l.a;
        if (objR == x0Var) {
            objR = new g0(cVar, new l0(0, this.d));
            sVar.q0(objR);
        }
        g0 g0Var = (g0) objR;
        Object objR2 = sVar.R();
        if (objR2 == x0Var) {
            objR2 = new c2(new wc0(g0Var));
            sVar.q0(objR2);
        }
        c2 c2Var = (c2) objR2;
        z0 z0Var = this.a;
        if (z0Var != null) {
            sVar.f0(1743490539);
            sVar.f0(887527095);
            Object obj4 = u1.a;
            if (obj4 != null) {
                sVar.f0(1345648624);
                sVar.r(false);
            } else {
                sVar.f0(1345697697);
                View view = (View) sVar.k(t4.r0.f);
                boolean zG = sVar.g(view);
                Object objR3 = sVar.R();
                if (zG || objR3 == x0Var) {
                    Object tag = view.getTag(2131427699);
                    objR3 = tag instanceof s1 ? (s1) tag : null;
                    if (objR3 == null) {
                        objR3 = new c(view);
                        view.setTag(2131427699, objR3);
                    }
                    sVar.q0(objR3);
                }
                obj4 = (s1) objR3;
                sVar.r(false);
            }
            Object obj5 = obj4;
            sVar.r(false);
            Object[] objArr = {z0Var, g0Var, c2Var, obj5};
            boolean zG2 = sVar.g(z0Var) | sVar.i(g0Var) | sVar.i(c2Var) | sVar.i(obj5);
            Object objR4 = sVar.R();
            if (zG2 || objR4 == x0Var) {
                objR4 = new m0(z0Var, g0Var, c2Var, obj5, 0);
                sVar.q0(objR4);
            }
            tlydtdl.compose.runtime.a0.e(objArr, (Function1) objR4, sVar);
            sVar.r(false);
        } else {
            sVar.f0(1744076749);
            sVar.r(false);
        }
        int i = a1.a;
        p pVar = this.b;
        if (z0Var != null && (pVarThen = pVar.then(new TraversablePrefetchStateModifierElement(z0Var))) != null) {
            pVar = pVarThen;
        }
        boolean zG3 = sVar.g(g0Var);
        o0 o0Var = this.c;
        boolean zG4 = zG3 | sVar.g(o0Var);
        Object objR5 = sVar.R();
        if (zG4 || objR5 == x0Var) {
            objR5 = new r2(5, g0Var, o0Var);
            sVar.q0(objR5);
        }
        y1.a(c2Var, pVar, (Function2) objR5, sVar, 8);
        return lx1.b0.a;
    }
}
