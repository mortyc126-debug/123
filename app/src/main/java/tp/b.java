package tp;

import amuvvoafs.content.SharedPreferences;
import com.facebook.e0;
import com.facebook.g;
import com.facebook.internal.i;
import com.facebook.login.y;
import hs1.d;
import java.util.Date;
import java.util.List;
import ky1.b0;
import ky1.c0;
import lx1.q;
import n0.f;
import ny1.r2;
import ny1.z;
import rp.a;
import sf1.h;
import tlydtdl.activity.ComponentActivity;
import tlydtdl.lifecycle.i1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements a {
    public final ComponentActivity a;
    public final List b;
    public final r2 c = z.c(z10.a.c);
    public final q d = d.F(new t10.d(11));
    public final i e = new i();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public bp.a f609f;

    public b(ComponentActivity componentActivity, List list) {
        this.a = componentActivity;
        this.b = list;
        h02.a.u(componentActivity.getLifecycle(), new h(6, this));
    }

    public final void a() {
        try {
            y yVar = (y) this.d.getValue();
            if (yVar != null) {
                Date date = com.facebook.b.l;
                g.f.l().c((com.facebook.b) null, true);
                f.O((com.facebook.i) null);
                tlydtdl.compose.runtime.b.X((e0) null);
                SharedPreferences.Editor editorEdit = yVar.a.edit();
                editorEdit.putBoolean("express_login_allowed", false);
                editorEdit.apply();
            }
        } catch (Exception e) {
            s02.d.a.getClass();
            s02.b.s("Facebook logout failed", e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.facebook.FacebookException */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(bp.a r14, qx1.d r15) throws com.facebook.FacebookException {
        /*
            Method dump skipped, instruction units count: 347
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tp.b.b(bp.a, qx1.d):java.lang.Object");
    }

    public final void c(RuntimeException runtimeException) {
        s02.d.a.getClass();
        s02.b.p("FacebookAuthenticator::notifyFailure: ");
        c0.F(i1.g(this.a), (qx1.i) null, (b0) null, new s91.b(this, runtimeException, (qx1.d) null, 19), 3);
    }
}
