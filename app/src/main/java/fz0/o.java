package fz0;

import amuvvoafs.app.ActivityManager;
import amuvvoafs.content.Context;
import ay0.k;
import bb.b1;
import com.bandlab.user.profile.connections.screen.connections.ExpandYourConnectionsActivity;
import com.braze.storage.c1;
import fi1.e0;
import gp.q0;
import hj.t2;
import io.purchasely.gnacba.BillingRepository;
import io.purchasely.storage.PLYSessionStorage;
import java.io.File;
import java.util.Map;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import m10.j0;
import m10.k1;
import ny1.p2;
import ny1.r2;
import org.json.JSONArray;
import tlydtdl.compose.foundation.lazy.layout.r1;
import wz0.i0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o implements Function0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ o(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public final Object invoke() {
        j0 j0Var;
        int largeMemoryClass;
        switch (this.a) {
            case 0:
                p pVar = (p) this.b;
                n10.f fVar = pVar.b().C;
                ((dt.g) pVar.e).a(fVar != null ? fVar.d : null, ((wz0.y) pVar.c).n, n10.a.c);
                return lx1.b0.a;
            case 1:
                hz0.b bVar = (hz0.b) this.b;
                lmjxuqdtp.jvm.internal.o.h(bVar, "<this>");
                return new i0(bVar.g, ny1.z.c((Object) null), null, new wz0.g0(new ny1.o(1, bVar.h), new ny1.o(1, (Object) null), null, new ny1.o(1, (Object) null), false, new ny1.o(1, new dg1.g(2131231708, false)), new e0(13, bVar), new e0(14, bVar), false, mx1.t.a, new cs0.t(10, new wz0.a[0]), ny1.z.c((Object) null), false, null, ny1.z.c(new wz0.f0(com.ironsource.adqualitysdk.sdk.i.a0.v(x10.v.Companion, 2132017516), null, null, 6)), false), null, bVar.k, new lg.f(null, null, null, null, true, null, null), new co1.c(2));
            case 2:
                k0 k0Var = (k0) this.b;
                se0.x xVar = new se0.x(k0Var.b(), false, 6);
                zx0.l lVarB = zx0.i.b(k0Var.e, xVar, by1.b.W(xVar, (p2) ((r1) k0Var.f146j.d).c, re0.l.c, ch0.b.F(k0Var.a.e), 4), (ay0.j) null, new k(ay0.p.c, false, ay0.m.a, (ay0.h) null, ay0.d.c, 10), (a00.l) null, (a00.l) null, 100);
                k1 k1Var = k0Var.b().k;
                return new lj1.h((k1Var == null || (j0Var = k1Var.b) == null) ? null : j0Var.d(), lVarB, false, k0Var.k, false, (Function1) null, 48);
            case 3:
                r2 r2Var = ((zj.n) this.b).C;
                Boolean bool = Boolean.TRUE;
                r2Var.getClass();
                r2Var.i((Object) null, bool);
                return lx1.b0.a;
            case 4:
                return com.braze.dispatch.g.a((c1) this.b);
            case 5:
                return com.braze.triggers.actions.c.a((com.braze.triggers.actions.c) this.b);
            case 6:
                return com.braze.triggers.actions.f.a((com.braze.triggers.actions.f) this.b);
            case 7:
                ((q0) this.b).a.b(new gp.i0(null));
                return lx1.b0.a;
            case 8:
                ((h80.e) this.b).m.invoke();
                return lx1.b0.a;
            case 9:
                r1 r1Var = (r1) this.b;
                com.bandlab.media.player.impl.i0 i0Var = (ue0.a) r1Var.c;
                ((w8.d0) i0Var.a).setVolume(!((Boolean) ((n30.k) r1Var.b).getValue()).booleanValue() ? 0.0f : 1.0f);
                ((l8.f) i0Var.a).L(true);
                return lx1.b0.a;
            case 10:
                ((t2) this.b).c.invalidate();
                return lx1.b0.a;
            case 11:
                return (bm.e) ((iw1.b) this.b).invoke();
            case 12:
                return com.braze.events.a.a((com.braze.events.e) this.b);
            case 13:
                return com.braze.triggers.managers.a.a((File[]) this.b);
            case 14:
                return com.braze.triggers.managers.a.b((File) this.b);
            case 15:
                return com.braze.triggers.managers.f.a((com.braze.triggers.actions.g) this.b);
            case 16:
                return com.braze.triggers.managers.f.e((com.braze.triggers.actions.h) this.b);
            case 17:
                return com.braze.triggers.managers.h.b((Map) this.b);
            case 18:
                return BillingRepository.c((BillingRepository) this.b);
            case 19:
                return PLYSessionStorage.a((PLYSessionStorage) this.b);
            case 20:
                return (z3.c) this.b;
            case 21:
                j80.i iVar = (j80.i) this.b;
                xu0.p pVar2 = iVar.c;
                zs.c0 c0Var = iVar.d;
                rh1.c cVar = ExpandYourConnectionsActivity.m;
                Context context = c0Var.a;
                cVar.getClass();
                pVar2.e(new xu0.l(rh1.c.b(context), -1));
                return lx1.b0.a;
            case 22:
                return ct1.b.B((lx1.l) this.b);
            case 23:
                Context context2 = (Context) ((a80.d) this.b).a;
                double d = 0.2d;
                try {
                    Object systemService = context2.getSystemService(ActivityManager.class);
                    lmjxuqdtp.jvm.internal.o.e(systemService);
                    if (((ActivityManager) systemService).isLowRamDevice()) {
                        d = 0.15d;
                    }
                } catch (Exception unused) {
                }
                if (0.0d > d || d > 1.0d) {
                    throw new IllegalArgumentException("percent must be in the range [0.0, 1.0].");
                }
                b02.d0 d0Var = new b02.d0(14, (byte) 0);
                try {
                    Object systemService2 = context2.getSystemService(ActivityManager.class);
                    lmjxuqdtp.jvm.internal.o.e(systemService2);
                    ActivityManager activityManager = (ActivityManager) systemService2;
                    largeMemoryClass = (context2.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass();
                    break;
                } catch (Exception unused2) {
                    largeMemoryClass = 256;
                }
                return new ue.d(new ps1.d((long) (d * ((long) largeMemoryClass) * 1048576), d0Var), d0Var);
            case 24:
                return ((je1.m) this.b).a.c().c.toString();
            case 25:
                return ((v2.p) this.b).c().c.toString();
            case 26:
                return com.braze.triggers.utils.c.b((JSONArray) this.b);
            case 27:
                ((k2.c) this.b).y.invoke(Boolean.valueOf(!r1.x));
                return lx1.b0.a;
            case 28:
                ((es0.l) ((b1) this.b).g).invoke();
                return lx1.b0.a;
            default:
                ((kg0.h) this.b).d().a(Boolean.FALSE);
                return lx1.b0.a;
        }
    }
}
