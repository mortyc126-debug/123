package kp;

import am.p;
import com.gnacba.firebase.messaging.a0;
import d10.j;
import eu0.k;
import gp.i0;
import gp.q0;
import gp.r0;
import ip.q;
import java.util.List;
import je1.m;
import k7.w;
import ky1.b0;
import ky1.c0;
import ny1.b2;
import ny1.j2;
import ny1.z;
import okhttp3.HttpUrl;
import qi.h;
import qi.y;
import wp.u;
import zi.i;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public final k a;
    public final q b;
    public final q0 c;
    public final a0 d;
    public final r0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ky1.a0 f267f;
    public final List g;
    public final m h;
    public final m i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b2 f268j;

    public e(k kVar, q qVar, q0 q0Var, a0 a0Var, r0 r0Var, ky1.a0 a0Var2, i iVar, i0 i0Var) {
        this.a = kVar;
        this.b = qVar;
        this.c = q0Var;
        this.d = a0Var;
        this.e = r0Var;
        this.f267f = a0Var2;
        qx1.d dVar = null;
        y.k((y) kVar.b, "log_in_open", (List) null, (h) null, 14);
        z.J(a0Var2, new p(20, q0Var.e, new tlydtdl.lifecycle.a0(this, dVar, 22)));
        int i = 0;
        int i2 = 3;
        c0.F(a0Var2, (qx1.i) null, (b0) null, new c(this, dVar, i), 3);
        this.g = ct1.b.C(new u[]{u.b, u.c, u.a});
        String str = i0Var.a;
        v2.p pVarL = z10.d.L(iVar, "email_login_username", a0Var2, str == null ? HttpUrl.FRAGMENT_ENCODE_SET : str, 8);
        v2.p pVarL2 = z10.d.L(iVar, "email_login_password", a0Var2, (String) null, 12);
        za0.h hVar = za0.c.a;
        m mVarP = aq1.b.P(pVarL, new za0.h[]{hVar}, (za0.a) null, (w) null, a0Var2, false, 22);
        this.h = mVarP;
        m mVarP2 = aq1.b.P(pVarL2, new za0.h[]{hVar}, (za0.a) null, (w) null, a0Var2, false, 22);
        this.i = mVarP2;
        this.f268j = z.R(new j(mVarP.c, mVarP2.c, new d(i2, i, dVar), 9), a0Var2, j2.a(3), Boolean.FALSE);
    }
}
