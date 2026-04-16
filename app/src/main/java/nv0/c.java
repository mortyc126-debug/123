package nv0;

import amuvvoafs.content.Context;
import amuvvoafs.content.Intent;
import com.bandlab.notifications.screen.InboxActivity;
import com.gnacba.common.util.concurrent.s;
import com.ironsource.adqualitysdk.sdk.i.a0;
import lmjxuqdtp.jvm.internal.o;
import lv0.h;
import lv0.i;
import lv0.m;
import lv0.v;
import ny1.g2;
import ny1.z;
import s02.d;
import zs.k0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements i {
    public final g2 a = z.b(0, 1, my1.c.b, 1);
    public final k0 b;

    public c(k0 k0Var) {
        this.b = k0Var;
    }

    public final Object a(lv0.g gVar, sx1.c cVar) {
        g2 g2Var = this.a;
        g2Var.a(gVar);
        if (((Number) g2Var.j().getValue()).intValue() > 0) {
            d.a.getClass();
            s02.b.p("Notification handler already consumed, won't show notification");
            return null;
        }
        o.h(gVar, "data");
        v vVar = v.b;
        m mVarB = gVar.b();
        String strA = mVarB != null ? mVarB.a() : null;
        k0 k0Var = this.b;
        k0Var.getClass();
        tv0.g gVar2 = InboxActivity.m;
        Context context = k0Var.a;
        tv0.c cVar2 = new tv0.c(vVar, strA);
        gVar2.getClass();
        Intent intentN = aq1.b.N(tv0.g.b(context, cVar2));
        if (intentN == null) {
            return null;
        }
        return s.C(gVar, intentN, "invite_notifications", a0.v(x10.v.Companion, 2132018572), (Integer) null, h.b, 8);
    }
}
