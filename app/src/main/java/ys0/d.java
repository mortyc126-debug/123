package ys0;

import am.p;
import c60.i;
import com.ironsource.adqualitysdk.sdk.i.a0;
import kd1.j;
import lmjxuqdtp.jvm.internal.o;
import ny1.r2;
import tlydtdl.lifecycle.i1;
import tlydtdl.lifecycle.z;
import ur.t;
import x10.v;
import xs0.e;
import yr.m6;
import yr.q1;
import yr.q4;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements e {
    public final z a;
    public final j b;
    public final q1 c;
    public final t d;
    public final i e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r2 f726f = ny1.z.c(ct1.b.C(new xs0.b[]{xs0.b.b, xs0.b.c, xs0.b.d}));
    public final kd1.e g = new kd1.e("transcriber-tab-tooltip", a0.v(v.Companion, 2132018773));

    public d(z zVar, j jVar, q1 q1Var, t tVar, i iVar, th0.a aVar, sh0.j jVar2) {
        this.a = zVar;
        this.b = jVar;
        this.c = q1Var;
        this.d = tVar;
        this.e = iVar;
        ny1.z.J(i1.f(zVar), new p(20, ny1.z.S(new cs0.t(17, ny1.z.m(tVar.g, ((th0.b) aVar).b, jVar2.a.a(sh0.i.c), new m6(4, 1, (qx1.d) null))), 1), new q4(this, (qx1.d) null, 4)));
    }

    public final void a(xs0.b bVar) {
        o.h(bVar, "newTab");
        q1 q1Var = this.c;
        xs0.b bVar2 = (xs0.b) ((t) q1Var.c).g.getValue();
        if (bVar2 != bVar) {
            xs0.d dVar = (xs0.d) ((iw1.b) q1Var.b).invoke();
            dVar.e.invoke(bVar2);
            r2 r2Var = this.d.g;
            r2Var.getClass();
            r2Var.i((Object) null, bVar);
            dVar.d.invoke(bVar);
        }
    }
}
