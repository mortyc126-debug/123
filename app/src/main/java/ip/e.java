package ip;

import com.bandlab.audio.controller.audioToMidi.h;
import cy.c;
import d01.k;
import fp.f;
import gl.g;
import gp.q0;
import gp.v;
import i11.t;
import iw1.b;
import lo.i;
import tlydtdl.activity.ComponentActivity;
import tlydtdl.lifecycle.z;
import v31.a;
import vo.j;
import xu0.p;
import yr.b3;
import yr.d3;
import yr.q1;
import zj.n;
import zs.j0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements jw1.e {
    public final /* synthetic */ int a = 0;
    public final b b;
    public final b c;
    public final b d;
    public final b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f224f;
    public final b g;
    public final b h;
    public final b i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f225j;
    public final b k;
    public final b l;
    public final b m;
    public final b n;
    public final jw1.e o;
    public final b p;

    public e(v vVar, b bVar, b bVar2, v vVar2, v vVar3, b bVar3, v vVar4, v vVar5, a aVar, b bVar4, g gVar, vl.e eVar, vi.a aVar2, vi.a aVar3, h hVar) {
        this.f225j = vVar;
        this.b = bVar;
        this.c = bVar2;
        this.d = vVar2;
        this.m = vVar3;
        this.e = bVar3;
        this.f224f = vVar4;
        this.n = vVar5;
        this.g = aVar;
        this.h = bVar4;
        this.o = gVar;
        this.p = eVar;
        this.i = aVar2;
        this.k = aVar3;
        this.l = hVar;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                i iVar = (i) ((v) this.f225j).invoke();
                j jVar = (j) this.b.invoke();
                c cVar = (c) this.c.invoke();
                t tVar = (t) this.d.invoke();
                qo.a aVar = (qo.a) ((v) this.m).invoke();
                f fVar = (f) this.e.invoke();
                ro.h hVar = (ro.h) this.f224f.invoke();
                p81.f fVar2 = (p81.f) ((v) this.n).invoke();
                p pVar = (p) this.g.invoke();
                q0 q0Var = (q0) this.h.invoke();
                dd.b bVar = (dd.b) ((g) this.o).invoke();
                q1 q1Var = (q1) this.p.invoke();
                z zVar = (z) this.i.invoke();
                ComponentActivity componentActivity = (ComponentActivity) this.k.invoke();
                d dVar = (d) this.l.invoke();
                lmjxuqdtp.jvm.internal.o.h(iVar, "authApi");
                lmjxuqdtp.jvm.internal.o.h(jVar, "marketingConsent");
                lmjxuqdtp.jvm.internal.o.h(cVar, "captcha");
                lmjxuqdtp.jvm.internal.o.h(tVar, "remoteConfig");
                lmjxuqdtp.jvm.internal.o.h(aVar, "authManager");
                lmjxuqdtp.jvm.internal.o.h(fVar, "authProfileLoader");
                lmjxuqdtp.jvm.internal.o.h(hVar, "sessionStorage");
                lmjxuqdtp.jvm.internal.o.h(fVar2, "toaster");
                lmjxuqdtp.jvm.internal.o.h(pVar, "navigation");
                lmjxuqdtp.jvm.internal.o.h(q0Var, "navigationViewModel");
                lmjxuqdtp.jvm.internal.o.h(zVar, "lifecycle");
                lmjxuqdtp.jvm.internal.o.h(componentActivity, "activity");
                lmjxuqdtp.jvm.internal.o.h(dVar, "ageVerificationHandler");
                return new o(iVar, jVar, cVar, tVar, aVar, fVar, hVar, fVar2, pVar, q0Var, bVar, q1Var, zVar, componentActivity, dVar);
            default:
                n nVar = (n) this.b.invoke();
                z zVar2 = (z) this.f225j.a;
                zi.i iVar2 = (zi.i) this.k.a;
                dr0.g gVar = (dr0.g) this.c.invoke();
                xs.p pVar2 = (xs.p) this.d.invoke();
                p81.f fVar3 = (p81.f) this.e.invoke();
                hw.q qVar = (hw.q) this.f224f.invoke();
                j0 j0Var = (j0) this.g.invoke();
                kd1.j jVar2 = (kd1.j) this.h.invoke();
                y00.a aVar2 = (y00.a) this.l.invoke();
                zx0.i iVar3 = (zx0.i) this.m.invoke();
                k kVar = (k) this.n.invoke();
                p pVar3 = (p) this.o.a;
                sh0.b bVar2 = (sh0.b) this.p.invoke();
                t tVar2 = (t) this.i.invoke();
                lmjxuqdtp.jvm.internal.o.h(nVar, "audioController");
                lmjxuqdtp.jvm.internal.o.h(zVar2, "lifecycle");
                lmjxuqdtp.jvm.internal.o.h(iVar2, "saveStateHelper");
                lmjxuqdtp.jvm.internal.o.h(gVar, "progressManager");
                lmjxuqdtp.jvm.internal.o.h(pVar2, "preferences");
                lmjxuqdtp.jvm.internal.o.h(fVar3, "toaster");
                lmjxuqdtp.jvm.internal.o.h(qVar, "membershipRepo");
                lmjxuqdtp.jvm.internal.o.h(j0Var, "fromMixEditorNavigation");
                lmjxuqdtp.jvm.internal.o.h(jVar2, "tooltipRepository");
                lmjxuqdtp.jvm.internal.o.h(kVar, "preferenceConfig");
                lmjxuqdtp.jvm.internal.o.h(pVar3, "navigationSource");
                lmjxuqdtp.jvm.internal.o.h(tVar2, "remoteConfig");
                return new tg0.f(nVar, zVar2, iVar2, gVar, pVar2, fVar3, qVar, j0Var, jVar2, aVar2, iVar3, kVar, pVar3, bVar2, tVar2);
        }
    }

    public e(b3 b3Var, jw1.f fVar, jw1.f fVar2, d3 d3Var, d3 d3Var2, b3 b3Var2, b3 b3Var3, d3 d3Var3, d3 d3Var4, a aVar, d3 d3Var5, d3 d3Var6, jw1.f fVar3, d3 d3Var7, b3 b3Var4) {
        this.b = b3Var;
        this.f225j = fVar;
        this.k = fVar2;
        this.c = d3Var;
        this.d = d3Var2;
        this.e = b3Var2;
        this.f224f = b3Var3;
        this.g = d3Var3;
        this.h = d3Var4;
        this.l = aVar;
        this.m = d3Var5;
        this.n = d3Var6;
        this.o = fVar3;
        this.p = d3Var7;
        this.i = b3Var4;
    }
}
