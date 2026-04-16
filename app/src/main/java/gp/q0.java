package gp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lp.a;
import mx1.o;
import ny1.g2;
import ny1.r2;
import s02.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class q0 {
    public final a a;
    public final r2 b;
    public final r2 c;
    public final g2 d;
    public final g2 e;

    public q0(a aVar, m mVar, qo.a aVar2, tlydtdl.lifecycle.z zVar) {
        this.a = aVar;
        h02.a.w(zVar, new a80.m(mVar, aVar2, this, 7));
        this.b = ny1.z.c((Object) null);
        this.c = ny1.z.c((Object) null);
        g2 g2VarB = ny1.z.b(0, 1, my1.c.b, 1);
        this.d = g2VarB;
        this.e = g2VarB;
    }

    public final void a() {
        d.a.getClass();
        s02.b.p("NavController: Navigating up");
        a aVar = this.a;
        List list = (List) aVar.a().e;
        if (list.isEmpty()) {
            return;
        }
        aVar.c(o.q0(1, list));
    }

    public final void b(boolean z) {
        bv0.b bVar;
        a aVar = this.a;
        if (z) {
            aVar.b(f0.INSTANCE);
            return;
        }
        if (lmjxuqdtp.jvm.internal.o.c((bv0.b) o.I0((List) aVar.a().e), f0.INSTANCE)) {
            d.a.getClass();
            s02.b.p("NavController: Clearing overlay");
            bv0.b bVar2 = (bv0.b) o.I0((List) aVar.a().e);
            if (bVar2 != null) {
                Set setB = bVar2.b();
                bv0.a aVar2 = bv0.a.a;
                if (setB.contains(aVar2)) {
                    ArrayList arrayListO1 = o.o1((List) aVar.a().e);
                    if (!arrayListO1.isEmpty() && (bVar = (bv0.b) o.G0(arrayListO1)) != null && bVar.b().contains(aVar2)) {
                        o.X0(arrayListO1);
                    }
                    aVar.c(arrayListO1);
                }
            }
        }
    }
}
