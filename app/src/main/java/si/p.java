package si;

import b01.t;
import com.braze.BrazeUser;
import dh1.w;
import lx1.b0;
import tlydtdl.compose.foundation.lazy.layout.r1;
import y10.r;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class p extends b01.c implements f {
    public static final p c;
    public static final String d;
    public static final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f472f;
    public static final b01.n g;
    public static final b01.o h;
    public static final r1 i;

    static {
        p pVar = new p(6);
        c = pVar;
        d = "username";
        e = pVar.d();
        f472f = pVar.i();
        g = b01.n.a;
        h = b01.o.a;
        i = r.b0(pVar, "username", b01.r.a, 2);
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
        Object objH = f.h(this, brazeUser, kVar.a(this), wVar.b, oVar);
        return objH == rx1.a.a ? objH : b0.a;
    }

    @Override // b01.c
    public final String o() {
        return null;
    }

    @Override // b01.c
    public final String s() {
        return f472f;
    }

    @Override // b01.c
    public final String u() {
        return e;
    }
}
