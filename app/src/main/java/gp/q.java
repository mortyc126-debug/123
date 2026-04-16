package gp;

import com.bandlab.auth.screens.JoinBandlabActivity;
import com.bandlab.auth.screens.JoinBandlabActivityGraph$$;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import iw1.a;
import jw1.d;
import lmjxuqdtp.jvm.internal.o;
import mr.z3;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements y {
    public final jw1.f a;
    public final jw1.f b;
    public final iw1.b c;
    public final /* synthetic */ JoinBandlabActivityGraph$$.MetroGraph d;

    public q(JoinBandlabActivityGraph$$.MetroGraph metroGraph, JoinBandlabActivity joinBandlabActivity) {
        this.d = metroGraph;
        jw1.f fVar = new jw1.f(joinBandlabActivity);
        this.a = fVar;
        this.b = new jw1.f(this);
        vi.c cVar = new vi.c(this, uz1.g.n(this, fVar), 2);
        d dVar = new d(new d10.f(this, uz1.g.n(this, fVar), 2));
        v vVar = metroGraph.w;
        o.h(vVar, "jsonMapper");
        gl.g gVar = new gl.g(vVar, 22);
        v vVar2 = metroGraph.n;
        vi.c cVar2 = new vi.c(this, uz1.g.n(this, fVar), 3);
        v vVar3 = metroGraph.E;
        d10.f fVar2 = new d10.f(uz1.g.n(this, fVar), 1);
        v vVar4 = metroGraph.Q;
        v vVar5 = metroGraph.f;
        v vVar6 = metroGraph.e;
        v vVar7 = metroGraph.d;
        v vVar8 = metroGraph.G;
        v vVar9 = metroGraph.P;
        w wVar = metroGraph.T;
        v vVar10 = metroGraph.D;
        v vVar11 = metroGraph.w;
        o.h(vVar11, "jsonMapper");
        d dVar2 = new d(j4.m(gVar, vVar2, cVar2, vVar3, fVar2, vVar4, vVar5, vVar6, vVar7, vVar8, vVar9, cVar, dVar, wVar, vVar10, new gl.g(vVar11, 21)));
        iw1.b bVar = metroGraph.H;
        v vVar12 = metroGraph.h;
        ao0.g gVar2 = new ao0.g(24, vVar12, new z3(vVar12, 24));
        iw1.b bVar2 = metroGraph.O;
        vi.c cVar3 = new vi.c(this, uz1.g.n(this, fVar), 0);
        v vVar13 = metroGraph.j;
        o.h(bVar2, "authViewModel");
        b81.c cVar4 = new b81.c(gVar2, bVar2, cVar3, vVar13);
        iw1.b bVar3 = metroGraph.r;
        v vVar14 = metroGraph.G;
        au0.e eVar = new au0.e(metroGraph, metroGraph.a, 4);
        o.h(bVar, "authHandler");
        o.h(bVar3, "navigationViewModel");
        o.h(vVar14, "toaster");
        this.c = new d(new a80.l(bVar, cVar4, bVar3, vVar14, cVar, eVar, dVar2));
    }

    public final a a() {
        JoinBandlabActivityGraph$$.MetroGraph metroGraph = this.d;
        v vVar = metroGraph.g;
        v vVar2 = metroGraph.k;
        v vVar3 = metroGraph.i;
        y yVar = (y) this.b.a;
        o.h(yVar, "instance");
        ao0.g gVar = new ao0.g(20, yVar, this.a);
        v vVar4 = metroGraph.p;
        o.h(vVar4, "authProfileChecker");
        qs0.a aVar = new qs0.a((iw1.b) vVar2, (iw1.b) vVar3, (jw1.e) gVar, (iw1.b) vVar4, 8);
        v vVar5 = metroGraph.i;
        w wVar = metroGraph.S;
        o.h(wVar, "tooltipRepository");
        qs0.a aVar2 = new qs0.a((iw1.b) vVar, (iw1.b) aVar, (iw1.b) vVar5, (iw1.b) wVar, 7);
        iw1.b bVar = this.c;
        o.h(bVar, "joinBandLabViewModel");
        return new au0.c(aVar2, bVar, 1);
    }
}
