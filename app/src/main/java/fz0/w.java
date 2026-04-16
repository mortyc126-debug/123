package fz0;

import f3.f2;
import java.util.ArrayList;
import jv0.i0;
import lmjxuqdtp.jvm.functions.Function1;
import n30.k;
import ny1.p2;
import ny1.r2;
import o10.a4;
import oz0.d1;
import st.w0;
import x10.r;
import y11.l1;
import zs.n0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class w {
    public final wz0.y a;
    public final lw0.b b;
    public final xu0.p c;
    public final n0 d;
    public final dt.g e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final zi.a f150f;
    public final ky1.a0 g;
    public final i0 h;
    public final bt.b i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f151j;
    public final bt.l k;
    public final l1 l;
    public final r2 m;
    public final r2 n;
    public final v80.h o;
    public final wz0.g0 p;

    /* JADX WARN: Removed duplicated region for block: B:12:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public w(wz0.y r38, lw0.b r39, xu0.p r40, zs.n0 r41, dt.g r42, zi.a r43, ky1.a0 r44, jv0.i0 r45, fz0.p r46, bt.a r47) {
        /*
            Method dump skipped, instruction units count: 815
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: fz0.w.<init>(wz0.y, lw0.b, xu0.p, zs.n0, dt.g, zi.a, ky1.a0, jv0.i0, fz0.p, bt.a):void");
    }

    public final r a() {
        x10.c cVar;
        int i;
        if (this.a.a.d) {
            cVar = x10.v.Companion;
            i = 2132017587;
        } else {
            if (!lmjxuqdtp.jvm.internal.o.c(d().B, Boolean.TRUE)) {
                return null;
            }
            cVar = x10.v.Companion;
            i = 2132017553;
        }
        return com.ironsource.adqualitysdk.sdk.i.a0.v(cVar, i);
    }

    public final boolean b() {
        return this.a.e == a4.g && d().s != null;
    }

    public final k c(Function1 function1, Function1 function12) {
        bt.b bVar = this.i;
        oz0.n0 n0Var = ((d1) bVar.c).t;
        return w0.o0(n0Var != null ? ny1.z.c(n0Var) : (p2) bVar.d, new a2.q(this, function12, function1, 11));
    }

    public final d1 d() {
        return this.a.a.a;
    }

    public final x10.v e() {
        vu0.c cVar;
        String str;
        String strK;
        String str2;
        boolean z = this.f151j;
        if (z && !this.a.g) {
            m10.f fVar = d().e;
            if (fVar == null || (str2 = fVar.b) == null) {
                return null;
            }
            x10.v.Companion.getClass();
            return x10.c.d(str2);
        }
        if (z) {
            m10.f fVar2 = d().e;
            if (fVar2 == null || (strK = f2.k("@", fVar2.c)) == null) {
                return null;
            }
            x10.v.Companion.getClass();
            return x10.c.d(strK);
        }
        if (d().s == null || !b() || (cVar = d().s) == null || (str = cVar.b) == null) {
            return null;
        }
        g4.g gVar = new g4.g(4);
        gVar.d(new String[]{str});
        return gVar.e();
    }

    public final void f() {
        wz0.y yVar = this.a;
        if (!yVar.c || yVar.f676j) {
            return;
        }
        n10.f fVar = d().C;
        String str = fVar != null ? fVar.g : null;
        n10.a0 a0Var = yVar.n;
        n10.a aVar = n10.a.f;
        dt.g gVar = this.e;
        gVar.a(str, a0Var, aVar);
        bt.l lVar = this.k;
        lmjxuqdtp.jvm.internal.o.h(lVar, "info");
        qi.y yVar2 = gVar.a;
        ArrayList arrayList = new ArrayList();
        qi.r rVar = new qi.r(arrayList);
        rVar.e("post_creator_user_id", lVar.b);
        rVar.e("post_id", lVar.a);
        qi.y.k(yVar2, "post_profile_open", arrayList, (qi.h) null, 12);
        xu0.o oVar = (xu0.o) c(new r(this, 0), new r(this, 1)).getValue();
        if (oVar == null) {
            return;
        }
        this.c.e(oVar);
    }
}
