package au;

import fy1.c;
import java.lang.annotation.Annotation;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.internal.d0;
import lmjxuqdtp.jvm.internal.o;
import o10.g3;
import wy1.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final /* synthetic */ a a = new a();

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public static q a(q qVar) throws NoWhenBranchMatchedException {
        if (!(qVar instanceof d)) {
            if (qVar instanceof g) {
                return g.a((g) qVar);
            }
            if (qVar instanceof j) {
                return j.a();
            }
            if (qVar instanceof m) {
                return m.a((m) qVar);
            }
            if (qVar instanceof p) {
                return p.a((p) qVar);
            }
            throw new NoWhenBranchMatchedException();
        }
        d dVar = (d) qVar;
        String str = dVar.f8f;
        Integer num = (o.c(str, "PurchaseCountPast30DaysDescending") || o.c(str, "MostRecent")) ? dVar.b : null;
        x xVar = dVar.a;
        g3 g3Var = dVar.c;
        boolean z = dVar.d;
        Integer num2 = dVar.e;
        String str2 = dVar.f8f;
        String str3 = dVar.g;
        boolean z2 = dVar.h;
        o.h(xVar, "type");
        o.h(g3Var, "playlistSource");
        return new d(xVar, num, g3Var, z, num2, str2, str3, z2);
    }

    public final wy1.a serializer() {
        return new e("com.bandlab.beat.api.list.BeatsCarouselParams", d0.a(q.class), new c[]{d0.a(d.class), d0.a(g.class), d0.a(j.class), d0.a(m.class), d0.a(p.class)}, new wy1.a[]{b.a, e.a, h.a, k.a, n.a}, new Annotation[0]);
    }
}
