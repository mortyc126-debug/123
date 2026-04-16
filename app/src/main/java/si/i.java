package si;

import b01.t;
import com.braze.BrazeUser;
import dh1.w;
import lx1.b0;
import tlydtdl.compose.foundation.lazy.layout.r1;
import y10.r;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends b01.c implements f {
    public static final i c;
    public static final String d;
    public static final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b01.n f465f;
    public static final b01.o g;
    public static final r1 h;

    static {
        i iVar = new i(0);
        c = iVar;
        d = "email_confirmed";
        e = iVar.d();
        iVar.i();
        f465f = b01.n.a;
        g = b01.o.a;
        h = r.b0(iVar, "email_confirmed", b01.r.a, 2);
    }

    @Override // b01.m
    public final b01.n f() {
        return f465f;
    }

    @Override // b01.m
    public final t g() {
        return g;
    }

    @Override // si.f
    public final String j() {
        return d;
    }

    @Override // b01.m
    public final b01.m k() {
        return h;
    }

    @Override // si.f
    public final Object l(BrazeUser brazeUser, w wVar, d01.k kVar, qi.o oVar) {
        Object objM = f.m(this, brazeUser, kVar.a(this), Boolean.valueOf(wVar.t), oVar);
        return objM == rx1.a.a ? objM : b0.a;
    }

    @Override // b01.c
    public final boolean q() {
        return false;
    }

    @Override // b01.c
    public final String u() {
        return e;
    }
}
