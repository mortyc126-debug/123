package ed0;

import a2.k5;
import d81.h0;
import f3.f2;
import fy1.l;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import ky1.a0;
import ky1.b0;
import ky1.c0;
import ky1.t1;
import lmjxuqdtp.jvm.internal.d0;
import lmjxuqdtp.jvm.internal.o;
import lmjxuqdtp.jvm.internal.v;
import m8.d;
import qi.h;
import qi.y;
import yr.q1;
import zi.k;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class i {
    public static final /* synthetic */ l[] e;
    public final y a;
    public final q1 b;
    public g c;
    public t1 d;

    static {
        l vVar = new v(i.class, "shouldSendInputGainEvent", "getShouldSendInputGainEvent()Lcom/bandlab/amuvvoafs/common/utils/StateProperty;", 0);
        d0.a.getClass();
        e = new l[]{vVar};
    }

    public i(y yVar, zi.i iVar) {
        this.a = yVar;
        this.b = iVar.c(Boolean.TRUE);
    }

    public final void a(float f2, dd0.a aVar) {
        l[] lVarArr = e;
        l lVar = lVarArr[0];
        q1 q1Var = this.b;
        if (((Boolean) ((k) q1Var.d(this, lVar)).e).booleanValue()) {
            ((k) q1Var.d(this, lVarArr[0])).a(Boolean.FALSE);
            y.k(this.a, "mastering_auto_input_gain", d.o(new k5(f2, this, aVar, 2)), h.c, 8);
        }
    }

    public final void b(String str, boolean z, e eVar) {
        o.h(eVar, "state");
        y.k(this.a, "mastering_download", d.o(new db.k(str, z, eVar, 1)), h.e, 8);
    }

    public final void c(String str) {
        t1 t1Var = this.d;
        if (t1Var != null) {
            t1Var.a((CancellationException) null);
        }
        ArrayList arrayList = new ArrayList();
        f2.z("details", str, arrayList);
        y.k(this.a, "mastering_failed", arrayList, (h) null, 12);
    }

    public final synchronized void d(String str, Float f2, a0 a0Var) {
        t1 t1Var;
        try {
            o.h(a0Var, "scope");
            g gVar = new g(str, (int) ((f2 != null ? f2.floatValue() : 0.0f) * 100.0f));
            if (gVar.equals(this.c) && (t1Var = this.d) != null && t1Var.isActive()) {
                return;
            }
            t1 t1Var2 = this.d;
            if (t1Var2 != null) {
                t1Var2.a((CancellationException) null);
            }
            this.c = gVar;
            this.d = c0.F(a0Var, (qx1.i) null, (b0) null, new h0(gVar, this, (qx1.d) null, 23), 3);
        } catch (Throwable th) {
            throw th;
        }
    }
}
