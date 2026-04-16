package ne0;

import ky1.a0;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.internal.o;
import m2.i2;
import ny1.b2;
import ny1.j2;
import ny1.p2;
import ny1.z;
import okhttp3.HttpUrl;
import oz0.e1;
import st.w0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements ay0.g {
    public final zx0.h a;
    public final e1 b;
    public final ay0.k c;
    public final s d;
    public final y e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n30.k f344f;
    public final n30.k g;

    public e(a0 a0Var, zx0.h hVar, e1 e1Var, ay0.k kVar, s sVar, y yVar) {
        o.h(a0Var, "scope");
        this.a = hVar;
        this.b = e1Var;
        this.c = kVar;
        this.d = sVar;
        this.e = yVar;
        b2 b2VarR = z.R(new d10.j(sVar.f351j, sVar.h, new ev0.t(this, (qx1.d) null, 5), 9), a0Var, j2.a(3), ay0.f.b);
        n30.k kVar2 = yVar.b;
        b2 b2Var = hVar.v;
        b2 b2VarR2 = z.R(z.m(kVar2, b2Var, b2VarR, new d(4, 0, null)), a0Var, j2.a(3), b2Var.a.getValue());
        this.f344f = w0.o0(b2VarR2, new lb.d(13, this));
        this.g = w0.o0(b2VarR2, new i2(17));
    }

    public final p2 b() {
        return this.g;
    }

    public final p2 d() {
        return this.a.t;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final void e() throws NoWhenBranchMatchedException {
        if (this.e.a()) {
            e1 e1Var = this.b;
            String id = e1Var != null ? e1Var.getId() : null;
            if (id == null) {
                id = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            s sVar = this.d;
            if (id.equals(sVar.f351j.getValue())) {
                sVar.g();
                return;
            }
        }
        this.a.e();
    }

    public final boolean f() {
        return this.a.e.b;
    }

    public final p2 g() {
        return this.a.q;
    }

    public final re0.e h() {
        return this.a.h();
    }

    public final p2 isPlaying() {
        return this.f344f;
    }

    public final p2 j() {
        return this.a.p;
    }

    public final p2 k() {
        return this.a.r;
    }
}
