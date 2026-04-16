package fz0;

import a2.n3;
import jv0.i0;
import o10.c4;
import oz0.d1;
import oz0.f2;
import y11.l1;
import zs.n0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h {
    public final wz0.y a;
    public final xu0.p b;
    public final n0 c;
    public final p81.f d;
    public final i0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final dt.g f141f;
    public final v31.b g;
    public final f0 h;
    public final Object i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f142j;

    public h(wz0.y yVar, xu0.p pVar, n0 n0Var, p81.f fVar, i0 i0Var, dt.g gVar, v31.b bVar, q41.b bVar2, l41.j jVar, d0 d0Var, ky1.a0 a0Var) {
        this.a = yVar;
        this.b = pVar;
        this.c = n0Var;
        this.d = fVar;
        this.e = i0Var;
        this.f141f = gVar;
        this.g = bVar;
        d1 d1VarA = a();
        if (d1VarA.c == f2.b) {
            l1 l1Var = d1VarA.i;
            if (l1Var != null && com.facebook.appevents.p.V(d1VarA)) {
                boolean z = l1Var.o;
            }
        } else {
            com.facebook.appevents.p.V(d1VarA);
        }
        n3 n3Var = new n3(29, this);
        dl.c cVar = d0Var.a;
        xu0.p pVar2 = (xu0.p) ((jw1.f) cVar.b).a;
        n0 n0Var2 = (n0) ((kz0.a) cVar.c).invoke();
        p41.g gVar2 = (p41.g) ((kz0.a) cVar.d).invoke();
        dt.h hVar = (dt.h) ((kz0.a) cVar.e).invoke();
        p81.f fVar2 = (p81.f) ((kz0.a) cVar.f89f).invoke();
        tlydtdl.lifecycle.z zVar = (tlydtdl.lifecycle.z) ((jw1.f) cVar.g).a;
        ky1.a0 a0Var2 = (ky1.a0) ((jw1.f) cVar.h).a;
        kd1.j jVar2 = (kd1.j) ((kz0.a) cVar.i).invoke();
        qi.y yVar2 = (qi.y) ((kz0.a) cVar.f90j).invoke();
        i0 i0Var2 = (i0) ((kz0.a) cVar.k).invoke();
        lmjxuqdtp.jvm.internal.o.h(pVar2, "navigation");
        lmjxuqdtp.jvm.internal.o.h(fVar2, "toaster");
        lmjxuqdtp.jvm.internal.o.h(zVar, "lifecycle");
        lmjxuqdtp.jvm.internal.o.h(a0Var2, "coroutineScope");
        lmjxuqdtp.jvm.internal.o.h(jVar2, "tooltipRepository");
        lmjxuqdtp.jvm.internal.o.h(yVar2, "tracker");
        lmjxuqdtp.jvm.internal.o.h(i0Var2, "userIdProvider");
        this.h = new f0(n3Var, yVar, pVar2, n0Var2, gVar2, hVar, fVar2, zVar, a0Var2, jVar2, yVar2, i0Var2);
        this.i = jVar.d(a0Var, a());
        this.f142j = bVar2.f(a0Var, a());
        l1 l1Var2 = a().i;
    }

    public final d1 a() {
        return this.a.a.a;
    }

    public final void b() {
        wz0.y yVar = this.a;
        if (yVar.f676j) {
            return;
        }
        n10.f fVar = a().C;
        this.f141f.a(fVar != null ? fVar.c : null, yVar.n, n10.a.b);
        this.b.e(this.c.b(a().a, yVar.e, com.facebook.appevents.p.W(a()) ? c4.a : null, a().D));
    }
}
