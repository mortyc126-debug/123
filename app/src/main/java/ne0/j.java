package ne0;

import ay0.l;
import ky1.a0;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.internal.o;
import ny1.b2;
import ny1.j2;
import ny1.p2;
import ny1.r2;
import ny1.z;
import st.w0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements l {
    public final a0 a;
    public final zx0.l b;
    public final ay0.k c;
    public final s d;
    public final y e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f346f;
    public final b2 g;
    public final Object h;
    public final b2 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b2 f347j;

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public j(a0 a0Var, zx0.l lVar, ay0.k kVar, s sVar, y yVar) throws NoWhenBranchMatchedException {
        b2 b2VarC;
        o.h(a0Var, "scope");
        this.a = a0Var;
        this.b = lVar;
        this.c = kVar;
        this.d = sVar;
        this.e = yVar;
        re0.e eVarI = lVar.i();
        this.f346f = new a(a0Var, eVarI, sVar, yVar);
        se0.k kVarC = i().c();
        o.h(kVarC, "mediaId");
        n30.k kVar2 = sVar.g;
        r2 r2Var = sVar.h;
        d10.j jVar = new d10.j(kVar2, r2Var, new ev0.t(kVarC, (qx1.d) null, 6), 9);
        y10.a aVar = sVar.a;
        b2 b2VarR = z.R(jVar, aVar, j2.a(3), Boolean.valueOf(o.c(kVar2.getValue(), kVarC) && ((Boolean) r2Var.getValue()).booleanValue()));
        this.g = com.facebook.appevents.h.h(yVar, a0Var, lVar.n, b2VarR);
        int i = i.$EnumSwitchMapping$0[kVar.e.ordinal()];
        if (i == 1 || i == 2) {
            b2VarC = z.c(Boolean.FALSE);
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            se0.k kVarC2 = i().c();
            o.h(kVarC2, "mediaId");
            r2 r2Var2 = sVar.i;
            b2VarC = z.R(new d10.j(kVar2, r2Var2, new am0.c(kVarC2, (qx1.d) null, 19), 9), aVar, j2.a(3), Boolean.valueOf(o.c(kVar2.getValue(), kVarC2) && ((Boolean) r2Var2.getValue()).booleanValue()));
        }
        this.h = b2VarC;
        this.i = com.facebook.appevents.h.h(yVar, a0Var, lVar.o, b2VarC);
        this.f347j = com.facebook.appevents.h.h(yVar, a0Var, lVar.l, w0.t(b2VarR, eVarI.isActive(), a0Var, j2.a(3), new ln0.b(3, this)));
    }

    public final void a() {
        this.b.a();
    }

    public final p2 b() {
        return this.i;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final void c() throws NoWhenBranchMatchedException {
        if (l()) {
            this.d.g();
        } else {
            this.b.p((re0.i) null);
        }
    }

    public final p2 d() {
        return this.b.p;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final void e() throws NoWhenBranchMatchedException {
        c();
    }

    public final boolean f() {
        return this.b.d.b;
    }

    public final p2 g() {
        return this.b.m;
    }

    public final re0.e h() {
        return this.f346f;
    }

    public final re0.e i() {
        return this.e.a() ? this.f346f : this.b.i();
    }

    public final p2 isPlaying() {
        return this.g;
    }

    public final p2 j() {
        return this.b.q;
    }

    public final p2 k() {
        return this.f347j;
    }

    public final boolean l() {
        return this.e.a() && ((Boolean) this.b.i().isActive().getValue()).booleanValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final void pause() throws NoWhenBranchMatchedException {
        if (!l()) {
            this.b.p((re0.i) null);
            return;
        }
        s sVar = this.d;
        if (((Boolean) sVar.l.getValue()).booleanValue()) {
            sVar.c(ke0.d.a);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final void play() throws NoWhenBranchMatchedException {
        if (!l()) {
            this.b.o((re0.i) null);
            return;
        }
        s sVar = this.d;
        if (((Boolean) sVar.l.getValue()).booleanValue()) {
            sVar.c(ke0.e.a);
        } else {
            sVar.e(true);
        }
    }

    public final void stop() {
        this.b.stop();
    }
}
