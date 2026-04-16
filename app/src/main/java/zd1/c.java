package zd1;

import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import lmjxuqdtp.jvm.internal.o;
import r02.l;
import r02.m;
import t3.p;
import v1.f0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final b a;
    public final m b;

    public c(b bVar, m mVar) {
        o.h(bVar, "dragDropState");
        o.h(mVar, "delegateScope");
        this.a = bVar;
        this.b = mVar;
    }

    public static p a(c cVar, p pVar, boolean z, int i) {
        if ((i & 1) != 0) {
            z = true;
        }
        vg0.c cVar2 = new vg0.c(19);
        g gVar = new g(0);
        cVar.getClass();
        o.h(pVar, "<this>");
        m mVar = cVar.b;
        f0 f0Var = new f0(14, cVar, cVar2);
        t1.d dVar = new t1.d(23, cVar, gVar);
        mVar.getClass();
        return j4.i(pVar, new l(mVar, z, f0Var, dVar));
    }
}
