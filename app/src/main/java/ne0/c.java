package ne0;

import ky1.a0;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.internal.o;
import m2.i2;
import ny1.b2;
import ny1.j2;
import ny1.o2;
import ny1.p2;
import ny1.z;
import st.w0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements ay0.a {
    public final a0 a;
    public final zx0.d b;
    public final String c;
    public final s d;
    public final y e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b2 f342f;
    public final b2 g;

    public c(a0 a0Var, zx0.d dVar, String str, s sVar, y yVar) {
        o.h(str, "beatCollectionId");
        this.a = a0Var;
        this.b = dVar;
        this.c = str;
        this.d = sVar;
        this.e = yVar;
        am.p pVarM = z.m(sVar.f351j, sVar.h, sVar.i, new gn0.c(this, (qx1.d) null, 1));
        o2 o2VarA = j2.a(3);
        b bVar = b.b;
        b2 b2VarR = z.R(pVarM, a0Var, o2VarA, bVar);
        n30.k kVar = dVar.n;
        b2 b2VarR2 = z.R(new d10.j(kVar, b2VarR, new al1.s(3, 10, (qx1.d) null), 9), a0Var, j2.a(3), bVar);
        this.f342f = com.facebook.appevents.h.h(yVar, a0Var, dVar.m, w0.o0(b2VarR2, new i2(15)));
        this.g = com.facebook.appevents.h.h(yVar, a0Var, kVar, w0.o0(b2VarR2, new i2(16)));
    }

    public final p2 b() {
        return this.g;
    }

    public final p2 d() {
        return this.b.l;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final void e() throws NoWhenBranchMatchedException {
        if (this.e.a()) {
            s sVar = this.d;
            if (o.c(sVar.f351j.getValue(), this.c)) {
                sVar.g();
                return;
            }
        }
        this.b.e();
    }

    public final boolean f() {
        return true;
    }

    public final p2 g() {
        return this.b.h;
    }

    public final re0.e h() {
        return null;
    }

    public final p2 isPlaying() {
        return this.f342f;
    }

    public final p2 j() {
        return this.b.g;
    }

    public final p2 k() {
        return this.b.i;
    }
}
