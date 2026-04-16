package va1;

import bp.m;
import c31.d;
import k41.b;
import ky1.c0;
import ky1.m0;
import ky1.x;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import ny1.c2;
import ny1.l;
import ny1.r2;
import ny1.z;
import p60.g;
import ry1.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements m {
    public final u00.c a;
    public final r2 b = z.c(Boolean.FALSE);

    public c(u00.c cVar) {
        this.a = cVar;
    }

    public final l a(String str) {
        o.h(str, "userId");
        u00.c cVar = this.a;
        d dVar = (d) cVar.b;
        c2 c2VarB = qg.a.B(new b(dVar, str, new ns.a(9, new nw.b(16), dVar)));
        e eVar = m0.a;
        x xVar = x30.b.a;
        o.h(xVar, "context");
        return z.u(new g(19, new pd.d(c2VarB, xVar, 0), cVar));
    }

    public final Object b(cc1.e eVar) {
        e eVar2 = m0.a;
        Object objR = c0.R(x30.b.a, new ua1.a(this.a, (qx1.d) null), eVar);
        rx1.a aVar = rx1.a.a;
        b0 b0Var = b0.a;
        if (objR != aVar) {
            objR = b0Var;
        }
        return objR == aVar ? objR : b0Var;
    }

    public final Object d(String str, qx1.d dVar) {
        Boolean bool = Boolean.FALSE;
        r2 r2Var = this.b;
        r2Var.getClass();
        r2Var.i((Object) null, bool);
        return b0.a;
    }
}
