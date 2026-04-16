package gp;

import com.bandlab.auth.screens.JoinBandlabActivityGraph$$;
import jw1.d;
import lmjxuqdtp.jvm.internal.o;
import mr.z3;
import qp.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class u implements qp.b {
    public final iw1.b a;

    public u(JoinBandlabActivityGraph$$.MetroGraph metroGraph, a aVar, v00.e eVar) {
        jw1.f fVar = new jw1.f(eVar);
        new jw1.f(this);
        v vVar = metroGraph.h;
        ao0.g gVar = new ao0.g(24, vVar, new z3(vVar, 24));
        v00.a aVar2 = new v00.a(this, new v00.f(this, fVar, 2), 1);
        iw1.b bVar = metroGraph.O;
        v vVar2 = metroGraph.j;
        o.h(bVar, "authViewModel");
        b81.c cVar = new b81.c(gVar, bVar, aVar2, vVar2);
        iw1.b bVar2 = metroGraph.r;
        v vVar3 = metroGraph.Q;
        v00.a aVar3 = new v00.a(this, new v00.f(this, fVar, 0), 2);
        o.h(vVar3, "urlNav");
        ao0.g gVar2 = new ao0.g(21, vVar3, aVar3);
        iw1.b bVar3 = metroGraph.O;
        v vVar4 = metroGraph.n;
        au0.e eVar2 = new au0.e(metroGraph, metroGraph.a, 4);
        o.h(bVar2, "navigationViewModel");
        o.h(bVar3, "authViewModel");
        o.h(vVar4, "remoteConfig");
        this.a = new d(new com.bandlab.fcm.service.m(cVar, bVar2, gVar2, bVar3, aVar2, gVar, vVar4, eVar2));
    }

    public final Object a() {
        return (qp.c) this.a.invoke();
    }
}
