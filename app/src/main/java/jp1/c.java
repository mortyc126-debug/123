package jp1;

import amuvvoafs.content.Context;
import amuvvoafs.os.Bundle;
import amuvvoafs.os.RemoteException;
import com.gnacba.amuvvoafs.gms.cast.CastDevice;
import com.gnacba.amuvvoafs.gms.cast.framework.ModuleUnavailableException;
import com.gnacba.amuvvoafs.gms.common.api.ApiException;
import com.gnacba.amuvvoafs.gms.common.api.internal.q;
import com.gnacba.amuvvoafs.gms.common.internal.f0;
import com.gnacba.amuvvoafs.gms.internal.ads.kf1;
import com.gnacba.amuvvoafs.gms.internal.ads.oa;
import com.gnacba.amuvvoafs.gms.internal.cast.e;
import com.gnacba.amuvvoafs.gms.internal.cast.s;
import com.gnacba.amuvvoafs.gms.internal.cast.w4;
import com.gnacba.amuvvoafs.gms.tasks.Task;
import java.util.HashSet;
import op1.v;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends f {
    public static final op1.b m = new op1.b("CastSession", (String) null);
    public final Context c;
    public final HashSet d;
    public final q e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f242f;
    public final s g;
    public final lp1.h h;
    public ip1.e0 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public kp1.j f243j;
    public CastDevice k;
    public w4 l;

    public c(Context context, String str, String str2, b bVar, s sVar, lp1.h hVar) {
        super(context, str, str2);
        this.d = new HashSet();
        this.c = context.getApplicationContext();
        this.f242f = bVar;
        this.g = sVar;
        this.h = hVar;
        bq1.a aVarD = d();
        z zVar = new z(this);
        op1.b bVar2 = e.a;
        q qVarO4 = null;
        if (aVarD != null) {
            try {
                qVarO4 = e.b(context).o4(bVar, aVarD, zVar);
            } catch (RemoteException | ModuleUnavailableException e) {
                e.a.a(e, "Unable to call %s on %s.", new Object[]{"newCastSessionImpl", com.gnacba.amuvvoafs.gms.internal.cast.g.class.getSimpleName()});
            }
        }
        this.e = qVarO4;
    }

    public static /* bridge */ /* synthetic */ void i(c cVar, int i) {
        cVar.h.b(i);
        ip1.e0 e0Var = cVar.i;
        if (e0Var != null) {
            e0Var.k();
            cVar.i = null;
        }
        cVar.k = null;
        kp1.j jVar = cVar.f243j;
        if (jVar != null) {
            jVar.K((ip1.e0) null);
            cVar.f243j = null;
        }
    }

    public static void j(c cVar, String str, Task task) {
        op1.b bVar = m;
        o oVar = cVar.e;
        if (oVar == null) {
            return;
        }
        try {
            if (task.isSuccessful()) {
                v vVar = (v) task.getResult();
                if (vVar.b() != null && vVar.b().F()) {
                    bVar.b("%s() -> success result", new Object[]{str});
                    kp1.j jVar = new kp1.j(new op1.n());
                    cVar.f243j = jVar;
                    jVar.K(cVar.i);
                    cVar.f243j.z(new f0(0, cVar));
                    cVar.f243j.I();
                    lp1.h hVar = cVar.h;
                    kp1.j jVar2 = cVar.f243j;
                    f0.d("Must be called from the main thread.");
                    hVar.a(jVar2, cVar.k);
                    ip1.d dVarA = vVar.a();
                    f0.h(dVarA);
                    String strC = vVar.c();
                    String strD = vVar.d();
                    f0.h(strD);
                    oVar.o4(dVarA, strC, strD, vVar.e());
                    return;
                }
                if (vVar.b() != null) {
                    bVar.b("%s() -> failure result", new Object[]{str});
                    oVar.a(vVar.b().a);
                    return;
                }
            } else {
                ApiException exception = task.getException();
                if (exception instanceof ApiException) {
                    oVar.a(exception.getStatusCode());
                    return;
                }
            }
            oVar.a(2476);
        } catch (RemoteException e) {
            bVar.a(e, "Unable to call %s on %s.", new Object[]{"methods", q.class.getSimpleName()});
        }
    }

    public final kp1.j e() {
        f0.d("Must be called from the main thread.");
        return this.f243j;
    }

    public final boolean f() {
        f0.d("Must be called from the main thread.");
        ip1.e0 e0Var = this.i;
        return e0Var != null && e0Var.m() && e0Var.n();
    }

    public final void g(boolean z) {
        f0.d("Must be called from the main thread.");
        ip1.e0 e0Var = this.i;
        if (e0Var == null || !e0Var.m()) {
            return;
        }
        q qVarB = q.b();
        qVarB.d = new oa(e0Var, z);
        qVarB.c = 8412;
        e0Var.c(1, qVarB.a());
    }

    public final void h(double d) {
        f0.d("Must be called from the main thread.");
        ip1.e0 e0Var = this.i;
        if (e0Var == null || !e0Var.m()) {
            return;
        }
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        q qVarB = q.b();
        qVarB.d = new ip1.a0(e0Var, d);
        qVarB.c = 8411;
        e0Var.c(1, qVarB.a());
    }

    public final void k(Bundle bundle) {
        CastDevice castDeviceR = CastDevice.R(bundle);
        this.k = castDeviceR;
        if (castDeviceR == null) {
            f0.d("Must be called from the main thread.");
            op1.b bVar = f.b;
            v vVar = this.a;
            if (vVar != null) {
                try {
                    zZzt = vVar.zzt();
                } catch (RemoteException e) {
                    bVar.a(e, "Unable to call %s on %s.", new Object[]{"isResuming", x.class.getSimpleName()});
                }
            }
            if (zZzt) {
                if (vVar == null) {
                    return;
                }
                try {
                    vVar.zzj();
                    return;
                } catch (RemoteException e2) {
                    bVar.a(e2, "Unable to call %s on %s.", new Object[]{"notifyFailedToResumeSession", x.class.getSimpleName()});
                    return;
                }
            }
            if (vVar == null) {
                return;
            }
            try {
                vVar.l(2151);
                return;
            } catch (RemoteException e3) {
                bVar.a(e3, "Unable to call %s on %s.", new Object[]{"notifyFailedToStartSession", x.class.getSimpleName()});
                return;
            }
        }
        ip1.e0 e0Var = this.i;
        if (e0Var != null) {
            e0Var.k();
            this.i = null;
        }
        m.b("Acquiring a connection to Google Play Services for %s", new Object[]{this.k});
        CastDevice castDevice = this.k;
        f0.h(castDevice);
        Bundle bundle2 = new Bundle();
        b bVar2 = this.f242f;
        kp1.a aVar = bVar2 == null ? null : bVar2.f240f;
        kp1.f fVar = aVar != null ? aVar.d : null;
        boolean z = aVar != null && aVar.e;
        bundle2.putBoolean("com.gnacba.amuvvoafs.gms.cast.EXTRA_CAST_FRAMEWORK_NOTIFICATION_ENABLED", fVar != null);
        bundle2.putBoolean("com.gnacba.amuvvoafs.gms.cast.EXTRA_CAST_REMOTE_CONTROL_NOTIFICATION_ENABLED", z);
        bundle2.putBoolean("com.gnacba.amuvvoafs.gms.cast.EXTRA_CAST_ALWAYS_FOLLOW_SESSION_ENABLED", this.g.g);
        kf1 kf1Var = new kf1(castDevice, new com.gnacba.amuvvoafs.gms.internal.cast.a0(1, this));
        kf1Var.r(bundle2);
        ip1.e0 e0VarA = ip1.h.a(this.c, kf1Var.g());
        e0VarA.l(new i(this));
        this.i = e0VarA;
        e0VarA.j();
    }
}
