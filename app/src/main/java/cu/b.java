package cu;

import d01.k;
import hw.q;
import hw.q0;
import hw.r0;
import i11.t;
import jv0.i0;
import lmjxuqdtp.jvm.internal.o;
import or.s0;
import qi.y;
import rz.t0;
import yb0.j;
import yc0.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements jw1.e {
    public final /* synthetic */ int a;
    public final iw1.b b;
    public final iw1.b c;
    public final jw1.f d;
    public final iw1.b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final iw1.b f55f;

    public /* synthetic */ b(jw1.f fVar, iw1.b bVar, iw1.b bVar2, jw1.e eVar, jw1.e eVar2, int i) {
        this.a = i;
        this.d = fVar;
        this.b = bVar;
        this.c = bVar2;
        this.e = eVar;
        this.f55f = eVar2;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                y10.a aVar = (y10.a) this.d.a;
                t tVar = (t) this.b.invoke();
                i0 i0Var = (i0) this.c.invoke();
                q qVar = (q) this.e.invoke();
                mt.b bVar = (mt.b) this.f55f.invoke();
                o.h(aVar, "appScope");
                o.h(tVar, "remoteConfig");
                o.h(i0Var, "userIdProvider");
                o.h(qVar, "membershipRepo");
                o.h(bVar, "apiServiceFactory");
                return new f(aVar, tVar, i0Var, qVar, bVar);
            case 1:
                y yVar = (y) this.b.invoke();
                ww.b bVar2 = (ww.b) this.c.invoke();
                y10.a aVar2 = (y10.a) this.d.a;
                k kVar = (k) this.e.invoke();
                lmjxuqdtp.time.e eVar = (lmjxuqdtp.time.e) this.f55f.invoke();
                o.h(yVar, "tracker");
                o.h(bVar2, "adEventTracker");
                o.h(aVar2, "scope");
                o.h(kVar, "preferenceConfig");
                o.h(eVar, "clock");
                return new dt.g(yVar, bVar2, aVar2, kVar, eVar);
            case 2:
                y10.a aVar3 = (y10.a) this.d.a;
                fw.c cVar = (fw.c) this.b.invoke();
                i0 i0Var2 = (i0) this.c.invoke();
                r0 r0Var = (r0) this.e.invoke();
                k kVar2 = (k) this.f55f.invoke();
                o.h(aVar3, "appCoroutineScope");
                o.h(cVar, "billingClientMediator");
                o.h(i0Var2, "userIdProvider");
                o.h(r0Var, "subsPurchasePrefConfig");
                o.h(kVar2, "preferenceConfig");
                return new q0(aVar3, cVar, i0Var2, r0Var, kVar2);
            case 3:
                mt.b bVar3 = (mt.b) this.b.invoke();
                y10.a aVar4 = (y10.a) this.d.a;
                i0 i0Var3 = (i0) this.c.invoke();
                y yVar2 = (y) this.e.invoke();
                y yVar3 = (y) this.f55f.invoke();
                o.h(bVar3, "apiServiceFactory");
                o.h(aVar4, "appScope");
                o.h(i0Var3, "userIdProvider");
                o.h(yVar2, "userPropertyTracker");
                o.h(yVar3, "tracker");
                return new s0(bVar3, aVar4, i0Var3, yVar2, yVar3);
            case 4:
                sy.f fVar = (sy.f) this.b.invoke();
                i0 i0Var4 = (i0) this.c.invoke();
                qo.a aVar5 = (qo.a) this.e.invoke();
                y10.a aVar6 = (y10.a) this.d.a;
                mt.b bVar4 = (mt.b) this.f55f.invoke();
                o.h(fVar, "conversationClient");
                o.h(i0Var4, "userIdProvider");
                o.h(aVar5, "authManager");
                o.h(aVar6, "appScope");
                o.h(bVar4, "apiServiceFactory");
                return new t0(fVar, i0Var4, aVar5, aVar6, bVar4);
            case 5:
                y10.a aVar7 = (y10.a) this.d.a;
                uc0.h hVar = (uc0.h) this.b.invoke();
                k kVar3 = (k) this.c.invoke();
                yb0.k kVar4 = (yb0.k) this.e.invoke();
                mt.b bVar5 = (mt.b) this.f55f.invoke();
                o.h(aVar7, "appScope");
                o.h(hVar, "localeProvider");
                o.h(kVar3, "preferenceConfig");
                o.h(kVar4, "labelsConfigFactory");
                o.h(bVar5, "apiServiceFactory");
                return new j(aVar7, hVar, kVar3, kVar4, bVar5);
            case 6:
                wb.a aVar8 = new wb.a(24);
                bj.k kVar5 = (bj.k) this.d.a;
                mt.b bVar6 = (mt.b) this.b.invoke();
                k kVar6 = (k) this.c.invoke();
                yc0.k kVar7 = (yc0.k) this.e.invoke();
                yc0.e eVar2 = (yc0.e) this.f55f.invoke();
                o.h(kVar5, "scope");
                o.h(bVar6, "apiServiceFactory");
                o.h(kVar6, "preferenceConfig");
                o.h(kVar7, "packFilterCacheConfigSelector");
                o.h(eVar2, "exploreCacheConfigSelector");
                return new d(aVar8, kVar5, bVar6, kVar6, kVar7, eVar2);
            default:
                bj.k kVar8 = (bj.k) this.d.a;
                p41.j jVar = (p41.j) this.b.invoke();
                m41.k kVar9 = (m41.k) this.c.invoke();
                lmjxuqdtp.time.e eVar3 = (lmjxuqdtp.time.e) this.e.invoke();
                mt.b bVar7 = (mt.b) this.f55f.invoke();
                o.h(kVar8, "userScope");
                o.h(jVar, "likeRepository");
                o.h(kVar9, "followRepository");
                o.h(eVar3, "clock");
                o.h(bVar7, "apiServiceFactory");
                return new yg1.g(kVar8, jVar, kVar9, eVar3, bVar7);
        }
    }

    public b(jw1.c cVar, jw1.f fVar, iw1.b bVar, iw1.b bVar2, iw1.b bVar3) {
        this.a = 3;
        this.b = cVar;
        this.d = fVar;
        this.c = bVar;
        this.e = bVar2;
        this.f55f = bVar3;
    }

    public b(iw1.b bVar, iw1.b bVar2, jw1.c cVar, jw1.f fVar, jw1.c cVar2) {
        this.a = 4;
        this.b = bVar;
        this.c = bVar2;
        this.e = cVar;
        this.d = fVar;
        this.f55f = cVar2;
    }

    public b(iw1.b bVar, iw1.b bVar2, jw1.f fVar, jw1.c cVar, a10.c cVar2) {
        this.a = 1;
        this.b = bVar;
        this.c = bVar2;
        this.d = fVar;
        this.e = cVar;
        this.f55f = cVar2;
    }
}
