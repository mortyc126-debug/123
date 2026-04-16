package wm;

import amuvvoafs.content.Context;
import b01.i;
import d01.k;
import jw1.e;
import ky1.a0;
import lmjxuqdtp.jvm.internal.o;
import p81.f;
import qi.y;
import sh0.l;
import vg.j;
import y10.g;
import yr.q2;
import yr.r5;
import yr.s5;
import zj.v1;
import zs.c0;
import zs.e1;
import zs.l1;
import zs.m1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 implements e {
    public final /* synthetic */ int a;
    public final iw1.b b;
    public final iw1.b c;
    public final iw1.b d;

    public /* synthetic */ f0(iw1.b bVar, iw1.b bVar2, iw1.b bVar3, int i) {
        this.a = i;
        this.b = bVar;
        this.c = bVar2;
        this.d = bVar3;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                f21.b bVar = new f21.b();
                k kVar = (k) this.b.invoke();
                i iVar = (i) this.c.invoke();
                b bVar2 = (b) this.d.invoke();
                o.h(kVar, "preferenceConfig");
                o.h(iVar, "configSelector");
                o.h(bVar2, "fileCleaner");
                return new k0(bVar, kVar, iVar, bVar2);
            case 1:
                Context context = (Context) this.b.invoke();
                f fVar = (f) this.c.invoke();
                ta0.d dVar = (ta0.d) this.d.invoke();
                o.h(context, "context");
                o.h(fVar, "toaster");
                o.h(dVar, "imageLoader");
                return new qu0.u(context, fVar, dVar, 23);
            case 2:
                y yVar = (y) this.b.invoke();
                yg0.b bVar3 = (yg0.b) this.c.invoke();
                y yVar2 = (y) this.d.invoke();
                o.h(yVar, "tracker");
                o.h(bVar3, "actionTracker");
                o.h(yVar2, "userPropertyTracker");
                return new yg0.d(yVar, bVar3, yVar2);
            case 3:
                zj.n nVar = (zj.n) this.b.invoke();
                kn0.b bVar4 = (kn0.b) this.c.invoke();
                f fVar2 = (f) this.d.invoke();
                o.h(nVar, "audioController");
                o.h(bVar4, "messageHolder");
                o.h(fVar2, "toaster");
                return new s70.k(nVar, bVar4, fVar2);
            case 4:
                v1 v1Var = (v1) this.b.invoke();
                a0 a0Var = (a0) this.c.invoke();
                kn0.b bVar5 = (kn0.b) this.d.invoke();
                o.h(v1Var, "mixController");
                o.h(a0Var, "scope");
                o.h(bVar5, "messageHolder");
                return new yr.t(v1Var, a0Var, bVar5);
            case 5:
                a0 a0Var2 = (a0) this.b.invoke();
                s5 s5Var = (s5) this.c.invoke();
                r5 r5Var = (r5) this.d.invoke();
                o.h(a0Var2, "scope");
                o.h(s5Var, "factory");
                o.h(r5Var, "regionActionsMenuViewModel");
                return s5Var.a(a0Var2, r5Var);
            case 6:
                vg.n nVar2 = (vg.n) this.b.invoke();
                j jVar = (j) this.c.invoke();
                zg.c cVar = (zg.c) this.d.invoke();
                o.h(nVar2, "adsManager");
                o.h(jVar, "adsLogger");
                o.h(cVar, "feedAdsViewModelFactory");
                return new w2.j(nVar2, jVar, cVar);
            case 7:
                zi.c cVar2 = (zi.c) this.b.invoke();
                g gVar = (g) this.c.invoke();
                lmjxuqdtp.time.e eVar = (lmjxuqdtp.time.e) this.d.invoke();
                o.h(cVar2, "resourcesProvider");
                o.h(gVar, "localDateTimeProvider");
                o.h(eVar, "clock");
                return new zi.a(cVar2, gVar, eVar);
            case 8:
                a0 a0Var3 = (a0) this.b.invoke();
                l lVar = (l) this.d.invoke();
                o.h(a0Var3, "scope");
                iw1.b bVar6 = this.c;
                o.h(bVar6, "mixProcessor");
                o.h(lVar, "availabilityProvider");
                return new zj.f0(a0Var3, bVar6, lVar);
            case 9:
                jv0.i0 i0Var = (jv0.i0) this.b.invoke();
                mt.b bVar7 = (mt.b) this.c.invoke();
                k kVar2 = (k) this.d.invoke();
                o.h(i0Var, "userIdProvider");
                o.h(bVar7, "apiServiceFactory");
                o.h(kVar2, "prefConfig");
                return new zq0.n(i0Var, bVar7, kVar2);
            case 10:
                Context context2 = (Context) this.b.invoke();
                e1 e1Var = (e1) this.c.invoke();
                qj.g gVar2 = (qj.g) this.d.invoke();
                o.h(context2, "context");
                o.h(e1Var, "navigationScreenActions");
                o.h(gVar2, "artistDashboardNavActions");
                return new c0(context2, e1Var, gVar2);
            case 11:
                Context context3 = (Context) this.b.invoke();
                tk1.b bVar8 = (tk1.b) this.c.invoke();
                xu0.o oVar = (xu0.o) this.d.invoke();
                o.h(context3, "context");
                o.h(bVar8, "urlNavigationProvider");
                o.h(oVar, "acctSettingsNavAction");
                return new l1(context3, bVar8, oVar);
            default:
                Context context4 = (Context) this.b.invoke();
                jv0.i0 i0Var2 = (jv0.i0) this.c.invoke();
                e1 e1Var2 = (e1) this.d.invoke();
                o.h(context4, "context");
                o.h(i0Var2, "userIdProvider");
                o.h(e1Var2, "navigationScreenActions");
                return new m1(context4, i0Var2, e1Var2);
        }
    }

    public f0(q2 q2Var, vi.c cVar, jw1.f fVar, iw1.b bVar) {
        this.a = 5;
        this.b = cVar;
        this.c = fVar;
        this.d = bVar;
    }
}
