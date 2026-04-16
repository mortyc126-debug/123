package kq0;

import aq1.b;
import hw.q;
import java.util.ArrayList;
import java.util.List;
import k01.n;
import ky1.a0;
import lmjxuqdtp.jvm.internal.o;
import m11.a;
import mq0.k;
import ny1.b2;
import ny1.j2;
import ny1.r2;
import ny1.z;
import qi.h;
import qi.y;
import uq0.i0;
import x10.l;
import x10.r;
import x10.v;
import xu0.p;
import zs.j0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public final tl.e a;
    public final q b;
    public final p c;
    public final i0 d;
    public final j0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f272f;
    public final c g;
    public final r2 h;
    public final b2 i;

    public g(tl.e eVar, q qVar, p pVar, i0 i0Var, j0 j0Var, a aVar, c cVar, a0 a0Var) {
        this.a = eVar;
        this.b = qVar;
        this.c = pVar;
        this.d = i0Var;
        this.e = j0Var;
        this.f272f = aVar;
        this.g = cVar;
        b2 b2VarR = z.R(qVar.k(jv0.q.g), a0Var, j2.a(3), Boolean.TRUE);
        this.h = z.c((Object) null);
        v2.p pVar2 = cVar.b;
        ArrayList arrayList = cVar.i;
        x10.c cVar2 = v.Companion;
        String str = pVar2.c().c.length() + "/120";
        cVar2.getClass();
        l lVarD = x10.c.d(str);
        o.h(pVar2, "promptState");
        o.h(arrayList, "defaultPrompts");
        this.i = z.R(z.n(b.M(pVar2), cVar.f269f, cVar.g, cVar.h, b2VarR, new f(this, null, 0)), a0Var, j2.a(3), new k(pVar2, arrayList, lVarD, mq0.g.a));
    }

    public static final void a(g gVar) {
        gVar.c.e(gVar.e.b("ai_fx_preset_generator", lx0.k.INSTANCE));
    }

    public static final void b(g gVar) {
        r2 r2Var = gVar.h;
        xd1.d dVar = new xd1.d((v) null, com.ironsource.adqualitysdk.sdk.i.a0.v(v.Companion, 2132019134), rs1.g.m(new r(2132020490), new b(gVar, 1)), rs1.g.m(new r(2132017839), new n(gVar, 14)), rs1.g.m(new r(2132019940), new b(gVar, 2)), new n(gVar, 15));
        r2Var.getClass();
        r2Var.i((Object) null, dVar);
    }

    public final void c() {
        c cVar = this.g;
        v2.q.c(cVar.b);
        y.k(this.d.a, "fx_ai_prompt_open", (List) null, h.b, 10);
        cVar.b(false);
        cVar.e.setValue((Object) null);
    }
}
