package es0;

import hg1.x;
import lmjxuqdtp.time.n;
import n30.k;
import ny1.b2;
import ny1.g2;
import ny1.r2;
import tlydtdl.lifecycle.i1;
import tlydtdl.lifecycle.z;
import y11.c2;
import y11.d2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public final i a;
    public final i b;
    public final i c;
    public final g2 d;
    public final r2 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b2 f104f;
    public final r2 g;
    public final b2 h;
    public final r2 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b2 f105j;
    public final r2 k;
    public final b2 l;

    public b(z zVar, hg1.d dVar, d2 d2Var, i iVar, i iVar2, i iVar3, k kVar) {
        lmjxuqdtp.jvm.internal.o.h(d2Var, "metronome");
        this.a = iVar;
        this.b = iVar2;
        this.c = iVar3;
        g2 g2VarB = ny1.z.b(0, 5, my1.c.c, 1);
        this.d = g2VarB;
        r2 r2VarC = ny1.z.c(Integer.valueOf(d2Var.a));
        this.e = r2VarC;
        this.f104f = new b2(r2VarC);
        r2 r2VarC2 = ny1.z.c(dVar);
        this.g = r2VarC2;
        this.h = new b2(r2VarC2);
        r2 r2VarC3 = ny1.z.c(0);
        this.i = r2VarC3;
        this.f105j = new b2(r2VarC3);
        c2 c2Var = d2Var.b;
        r2 r2VarC4 = ny1.z.c(new x(c2Var.a, c2Var.b));
        this.k = r2VarC4;
        this.l = new b2(r2VarC4);
        int i = lmjxuqdtp.time.g.d;
        ny1.z.J(i1.f(zVar), new am.p(20, ny1.z.s(g2VarB, n.t(500L, lmjxuqdtp.time.i.d)), new ah.n(kVar, this, (qx1.d) null, 6)));
    }
}
