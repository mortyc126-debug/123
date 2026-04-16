package xr0;

import a2.r4;
import js0.t;
import js0.u;
import ky1.b0;
import ky1.c0;
import ky1.m0;
import ky1.s;
import lmjxuqdtp.jvm.internal.o;
import ny1.g2;
import ny1.z;
import qq1.b;
import qx1.i;
import s71.d1;
import tlydtdl.compose.runtime.d3;
import y11.l2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public final y10.a a;
    public final b b;
    public final vp1.b c;
    public final b d;
    public final cg0.a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final my1.a f698f;
    public final g2 g = z.a(0, 1, my1.c.b);

    public e(y10.a aVar, b bVar, vp1.b bVar2, f21.b bVar3, b bVar4, cg0.a aVar2) {
        this.a = aVar;
        this.b = bVar;
        this.c = bVar2;
        this.d = bVar4;
        this.e = aVar2;
        this.f698f = es1.c.m(aVar, (i) null, 0, new d3(this, null, 6), 15);
    }

    public final s a(t tVar, wr0.a aVar) {
        o.h(tVar, "studioState");
        s sVar = new s();
        c0.F(this.a, (i) null, (b0) null, new q61.d(this, tVar, aVar, sVar, (qx1.d) null, 26), 3);
        return sVar;
    }

    public final s b(a21.e eVar, u uVar, d1 d1Var, l2 l2Var) {
        o.h(eVar, "revisionState");
        o.h(uVar, "properties");
        s sVar = new s();
        ry1.e eVar2 = m0.a;
        c0.F(this.a, ry1.d.b, (b0) null, new r4(eVar, uVar, this, l2Var, d1Var, sVar, (qx1.d) null), 2).K(new a(0, sVar));
        return sVar;
    }
}
