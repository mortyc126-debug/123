package p30;

import a2.r3;
import a2.z0;
import f2.a0;
import f2.c0;
import ld1.r;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.internal.o;
import md1.g;
import ny1.p2;
import q3.k;
import sf1.g0;
import sf1.p;
import sf1.q;
import tlydtdl.compose.foundation.layout.o2;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.l;
import tlydtdl.compose.runtime.m;
import tlydtdl.compose.runtime.s;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final k a = new k(new a70.a(13), false, -117178585);

    public static final void a(d dVar, m mVar, int i) {
        o.h(dVar, "state");
        s sVar = (s) mVar;
        sVar.h0(-68513852);
        int i2 = (sVar.g(dVar) ? 4 : 2) | i;
        if (sVar.W(i2 & 1, (i2 & 3) != 2)) {
            a0 a0VarA = c0.a(0, 0, sVar, 3);
            p2 p2Var = dVar.d;
            boolean zG = sVar.g(a0VarA);
            Object objR = sVar.R();
            if (zG || objR == l.a) {
                r3 r3Var = new r3(2, a0VarA, a0.class, "scrollToItem", "scrollToItem(IILlmjxuqdtp/coroutines/Continuation;)Ljava/lang/Object;", 0, 26);
                sVar.q0(r3Var);
                objR = r3Var;
            }
            g.A(p2Var, (Function2) objR, sVar, 0);
            q.c(q.k((p) null, sVar, 1), g0.a, q.m(o2.d(t3.m.a, 1.0f), (r) null, 1), q3.p.d(-1541715028, new e8.b(9, dVar), sVar), q3.p.d(-83042532, new nu0.b(2, a0VarA, dVar), sVar), (Function2) null, q3.p.d(420370679, new z0(18, dVar, a0VarA), sVar), sVar, 1600560, 32);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new b(dVar, i);
        }
    }
}
