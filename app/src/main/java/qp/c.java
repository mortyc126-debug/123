package qp;

import com.gnacba.firebase.messaging.a0;
import eu0.k;
import gp.m;
import gp.q0;
import gp.r0;
import i11.t;
import ip.q;
import java.util.List;
import jp.e;
import jp.f;
import ky1.b0;
import ky1.c0;
import lmjxuqdtp.NoWhenBranchMatchedException;
import qi.h;
import qi.y;
import qx1.d;
import qx1.i;
import wp.p;
import wp.r;
import wp.u;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final a0 a;
    public final q0 b;
    public final r0 c;
    public final r d;
    public final List e;

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public c(a0 a0Var, q0 q0Var, r0 r0Var, q qVar, ky1.a0 a0Var2, k kVar, t tVar, m mVar) throws NoWhenBranchMatchedException {
        wp.q qVar2;
        this.a = a0Var;
        this.b = q0Var;
        this.c = r0Var;
        int iOrdinal = ((e) tVar.c(f.a)).ordinal();
        if (iOrdinal == 0) {
            qVar2 = p.b;
        } else if (iOrdinal == 1) {
            qVar2 = p.a;
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            qVar2 = wp.q.a;
        }
        this.d = qVar2;
        this.e = ct1.b.C(new u[]{u.b, u.c});
        d dVar = null;
        y.k((y) kVar.b, "welcome_screen_open", (List) null, h.c, 10);
        if (mVar.c) {
            c0.F(a0Var2, (i) null, (b0) null, new kp.c(qVar, dVar, 14), 3);
        }
    }
}
