package kq0;

import amuvvoafs.content.ContentResolver;
import hw.q;
import iw1.b;
import ky1.a0;
import lmjxuqdtp.jvm.internal.o;
import ls0.l;
import m11.a;
import tlydtdl.lifecycle.z;
import u80.k;
import uq0.i0;
import xu0.p;
import yr.u1;
import yr.w1;
import zj.n;
import zs.j0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements jw1.e {
    public final /* synthetic */ int a;
    public final b b;
    public final b c;
    public final b d;
    public final b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f270f;
    public final b g;
    public final b h;
    public final b i;

    public /* synthetic */ e(b bVar, b bVar2, b bVar3, b bVar4, b bVar5, b bVar6, b bVar7, b bVar8, int i) {
        this.a = i;
        this.b = bVar;
        this.c = bVar2;
        this.d = bVar3;
        this.e = bVar4;
        this.f270f = bVar5;
        this.g = bVar6;
        this.h = bVar7;
        this.i = bVar8;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                tl.e eVar = (tl.e) this.b.invoke();
                q qVar = (q) this.c.invoke();
                p pVar = (p) this.d.invoke();
                i0 i0Var = (i0) this.e.invoke();
                j0 j0Var = (j0) this.f270f.invoke();
                a aVar = (a) this.g.invoke();
                c cVar = (c) this.h.invoke();
                a0 a0Var = (a0) this.i.invoke();
                o.h(eVar, "controller");
                o.h(qVar, "membershipRepo");
                o.h(pVar, "navigation");
                o.h(i0Var, "presetTracker");
                o.h(j0Var, "navActions");
                o.h(aVar, "reportManager");
                o.h(cVar, "stateHolder");
                o.h(a0Var, "scope");
                return new g(eVar, qVar, pVar, i0Var, j0Var, aVar, cVar, a0Var);
            default:
                z zVar = (z) this.b.invoke();
                n nVar = (n) this.c.invoke();
                k kVar = (k) this.d.invoke();
                dr0.g gVar = (dr0.g) this.e.invoke();
                w1 w1Var = (w1) this.f270f.invoke();
                ContentResolver contentResolver = (ContentResolver) this.g.invoke();
                l lVar = (l) this.h.invoke();
                kn0.b bVar = (kn0.b) this.i.invoke();
                o.h(zVar, "lifecycle");
                o.h(nVar, "engine");
                o.h(kVar, "filePickerHandle");
                o.h(gVar, "progressIndicatorManager");
                o.h(w1Var, "fragmentHandler");
                o.h(contentResolver, "contentResolver");
                o.h(lVar, "mixEditorStorageController");
                o.h(bVar, "messageHolder");
                return new u1(zVar, nVar, kVar, gVar, w1Var, contentResolver, lVar, bVar);
        }
    }
}
