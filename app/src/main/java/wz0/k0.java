package wz0;

import au0.j;
import au0.k;
import com.bandlab.bandlab.AppGraph$$;
import com.facebook.appevents.h;
import gl.g;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class k0 {
    public final xu0.p a;
    public final ky1.a0 b;
    public final tlydtdl.lifecycle.z c;
    public final kz0.d d;

    public k0(xu0.p pVar, ky1.a0 a0Var, tlydtdl.lifecycle.z zVar, kz0.d dVar) {
        this.a = pVar;
        this.b = a0Var;
        this.c = zVar;
        this.d = dVar;
    }

    public final fz0.c0 a(y yVar) {
        kz0.c cVar = new kz0.c(yVar, this.a, this.b, this.c, (AppGraph$$.MetroGraph) h.C(this.d.a));
        jw1.f fVar = cVar.a;
        jw1.f fVar2 = cVar.b;
        kz0.a aVar = cVar.e;
        kz0.a aVar2 = cVar.f273f;
        b81.c cVar2 = new b81.c(fVar, fVar2, aVar, aVar2, 10);
        g gVar = new g(cVar.l, 29);
        kz0.a aVar3 = cVar.s;
        kz0.a aVar4 = cVar.f274j;
        jw1.f fVar3 = cVar.c;
        kz0.a aVar5 = cVar.n;
        kz0.a aVar6 = cVar.k;
        kz0.a aVar7 = cVar.h;
        ah.f fVar4 = new ah.f(fVar, fVar2, aVar2, aVar3, aVar4, gVar, fVar3, aVar5, aVar6, aVar7);
        kz0.a aVar8 = cVar.i;
        return (fz0.c0) new k(fVar, aVar5, cVar.t, cVar.u, fVar2, aVar, aVar2, cVar2, fVar4, new b81.c(fVar, fVar2, aVar8, aVar2, 20), cVar.q, cVar.o, cVar.m, cVar.p, new vl.e(fVar3, cVar.v, 10), cVar.r, aVar4, new j(fVar3, fVar2, cVar.g, 1), fVar3, aVar8, aVar7).invoke();
    }
}
