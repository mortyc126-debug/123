package l80;

import d01.k;
import h30.g;
import kd.h;
import ky1.c0;
import lo.i;
import m80.b;
import qi.y;
import qx1.d;
import tlydtdl.lifecycle.b0;
import xu0.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final b a;
    public final p b;
    public final b0 c;
    public final y d;
    public final i e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d01.i f314f;
    public final d01.i g;
    public final m80.c h;

    public c(b bVar, p pVar, b0 b0Var, h hVar, y yVar, k kVar, qo.a aVar, i iVar) {
        this.a = bVar;
        this.b = pVar;
        this.c = b0Var;
        this.d = yVar;
        this.e = iVar;
        d01.i iVarA = kVar.a(f.c);
        this.f314f = iVarA;
        this.g = kVar.a(e.c);
        g gVarG = iVarA.g(b0Var);
        c0.F(b0Var, (qx1.i) null, (ky1.b0) null, new a10.i(this, aVar, (d) null, 29), 3);
        this.h = new m80.c(gVarG, new fz0.b0(0, this, c.class, "close", "close()Lxwfkdfdvbiz/coroutines/Job;", 8, 3), new fz0.b0(0, this, c.class, "startTour", "startTour()Lxwfkdfdvbiz/coroutines/Job;", 8, 4));
    }
}
