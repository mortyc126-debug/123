package dg;

import a2.r4;
import ah.o;
import bg.e;
import bg.f;
import cg.g;
import ky1.a0;
import ky1.b0;
import ky1.c0;
import ky1.x;
import lf.d;
import w2.u;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements f {
    public d c;
    public bg.c e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g f83f;
    public final e a = e.c;
    public final u b = new u(4);
    public final boolean d = true;

    public final void a(d dVar) {
        this.c = dVar;
        u uVar = this.b;
        uVar.getClass();
        uVar.b = dVar;
        bg.c cVar = new bg.c(dVar);
        this.e = cVar;
        cVar.i = true;
        d dVar2 = cVar.a;
        x xVar = dVar2.f;
        bg.b bVar = new bg.b(cVar, (qx1.d) null);
        a0 a0Var = cVar.f;
        c0.F(a0Var, xVar, (b0) null, bVar, 2);
        c0.F(a0Var, dVar2.e, (b0) null, new r4(cVar, (qx1.d) null, 1), 2);
        this.f83f = new g(dVar.d(), dVar, dVar.f(), dVar.a, this);
        c cVar2 = new c(0);
        d();
        uVar.f(cVar2);
    }

    public final ag.a b(ag.a aVar) {
        return null;
    }

    public final void c(ag.a aVar) {
        if (((ag.b) aVar).a != null || ((ag.b) aVar).b != null) {
            c0.F(d().c, d().f, (b0) null, new o(this, aVar, (qx1.d) null, 13), 2);
            return;
        }
        d().f().b("Event is invalid for missing information like userId and deviceId. Dropping event: " + aVar.a());
    }

    public final d d() {
        d dVar = this.c;
        if (dVar != null) {
            return dVar;
        }
        lmjxuqdtp.jvm.internal.o.m("amplitude");
        throw null;
    }

    public final e getType() {
        return this.a;
    }
}
