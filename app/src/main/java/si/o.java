package si;

import b01.t;
import com.braze.BrazeUser;
import dh1.w;
import lx1.b0;
import tlydtdl.compose.foundation.lazy.layout.r1;
import y10.r;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends b01.c implements f {
    public static final o c;
    public static final String d;
    public static final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f471f;
    public static final b01.n g;
    public static final b01.o h;
    public static final r1 i;

    static {
        o oVar = new o(6);
        c = oVar;
        d = "registration_date";
        e = oVar.d();
        f471f = oVar.i();
        g = b01.n.a;
        h = b01.o.a;
        i = r.b0(oVar, "registration_date", b01.r.a, 2);
    }

    @Override // b01.m
    public final b01.n f() {
        return g;
    }

    @Override // b01.m
    public final t g() {
        return h;
    }

    @Override // si.f
    public final String j() {
        return d;
    }

    @Override // b01.m
    public final b01.m k() {
        return i;
    }

    @Override // si.f
    public final Object l(BrazeUser brazeUser, w wVar, d01.k kVar, qi.o oVar) {
        Object objH = f.h(this, brazeUser, kVar.a(this), wVar.F, oVar);
        return objH == rx1.a.a ? objH : b0.a;
    }

    @Override // b01.c
    public final String o() {
        return null;
    }

    @Override // b01.c
    public final String s() {
        return f471f;
    }

    @Override // b01.c
    public final String u() {
        return e;
    }
}
