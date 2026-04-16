package r30;

import a21.v;
import com.bandlab.listmanager.pagination.impl.n;
import com.gnacba.amuvvoafs.gms.internal.ads.j70;
import com.gnacba.firebase.messaging.a0;
import lmjxuqdtp.jvm.internal.o;
import mx1.t;
import ny1.b2;
import ny1.j2;
import ny1.r2;
import ny1.z;
import qu0.u;
import rz.j0;
import st.w0;
import t30.m;
import xu0.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l {
    public final p a;
    public final j70 b;
    public final t30.g c;
    public final s70.k d;
    public final a0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final t30.j f393f;
    public final n30.k g;
    public final m h;
    public final r2 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final kx0.e f394j;
    public final b2 k;

    public l(p pVar, j70 j70Var, t30.g gVar, s70.k kVar, a0 a0Var, t30.j jVar, t30.l lVar, u uVar, ix0.a aVar, u00.e eVar, ky1.a0 a0Var2, ky1.a0 a0Var3, e eVar2, ny1.l lVar2) {
        this.a = pVar;
        this.b = j70Var;
        this.c = gVar;
        this.d = kVar;
        this.e = a0Var;
        this.f393f = jVar;
        n30.k kVarO0 = w0.o0(z.R(lVar2, a0Var2, j2.a(3), eVar2), new p90.f(22));
        this.g = kVarO0;
        b2 b2VarR = z.R(new nc0.g(gVar.g, 10), a0Var2, j2.a(3), t.a);
        r70.a aVar2 = lVar.a;
        j70 j70Var2 = (j70) ((fg0.b) aVar2.e).invoke();
        p pVar2 = (p) ((iw1.b) aVar2.b).invoke();
        i iVar = (i) ((iw1.b) aVar2.c).invoke();
        ky1.a0 a0Var4 = (ky1.a0) ((iw1.b) aVar2.d).invoke();
        i11.t tVar = (i11.t) ((iw1.b) aVar2.f).invoke();
        o.h(pVar2, "navigation");
        o.h(iVar, "tracker");
        o.h(a0Var4, "scope");
        o.h(tVar, "remoteConfig");
        m mVar = new m();
        mVar.a = j70Var2;
        mVar.b = pVar2;
        mVar.c = iVar;
        mVar.d = new q30.u(w0.o0(w0.u(kVarO0, tVar.b(s30.e.a, a0Var4), a0Var4, new ln0.b(25, mVar)), new sw0.l(0)));
        this.h = mVar;
        r2 r2VarC = z.c(z10.a.c);
        this.i = r2VarC;
        kx0.e eVar3 = (kx0.e) aVar.a(ix0.b.m, true).d;
        this.f394j = eVar3;
        n nVarR = cq1.d.r(a0Var3, new d10.j(b2VarR, (n30.k) uVar.d, new au0.n(this, (qx1.d) null, 3), 9));
        this.k = z.R(new am.p(28, new j0(4, nVarR.getState(), nVarR), this), a0Var3, j2.a(3), new p30.d(eVar3, com.facebook.appevents.l.N(nVarR), new ng0.b(0, this, l.class, "onNewProject", "onNewProject()V", 0, 24), r2VarC));
        z.J(a0Var2, z10.d.l(new v(this, (qx1.d) null, 18), eVar.a(t10.f.d)));
    }
}
