package ln1;

import amuvvoafs.app.Activity;
import amuvvoafs.app.Application;
import amuvvoafs.content.Context;
import amuvvoafs.hardware.Sensor;
import amuvvoafs.hardware.SensorManager;
import amuvvoafs.os.Bundle;
import amuvvoafs.util.Log;
import com.facebook.appevents.m;
import com.facebook.d0;
import com.facebook.internal.g0;
import com.facebook.internal.j0;
import com.facebook.internal.t0;
import com.facebook.s;
import hy1.q;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Timer;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ int a;

    public /* synthetic */ c(int i) {
        this.a = i;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        int i = this.a;
        o.h(activity, "activity");
        switch (i) {
            case 0:
                iu1.d dVar = j0.c;
                iu1.d.p(d0.c, d.a, "onActivityCreated");
                d.b.execute(new an1.a(9));
                break;
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        int i = this.a;
        o.h(activity, "activity");
        switch (i) {
            case 0:
                iu1.d dVar = j0.c;
                iu1.d.p(d0.c, d.a, "onActivityDestroyed");
                cn1.e eVar = cn1.e.a;
                if (!vn1.a.b(cn1.e.class)) {
                    try {
                        cn1.h hVarK = cn1.h.f43f.k();
                        if (!vn1.a.b(hVarK)) {
                            try {
                                hVarK.e.remove(Integer.valueOf(activity.hashCode()));
                            } catch (Throwable th) {
                                vn1.a.a(hVarK, th);
                            }
                        }
                    } catch (Throwable th2) {
                        vn1.a.a(cn1.e.class, th2);
                        return;
                    }
                    break;
                }
                break;
        }
    }

    public final void onActivityPaused(Activity activity) {
        int i = this.a;
        o.h(activity, "activity");
        switch (i) {
            case 0:
                iu1.d dVar = j0.c;
                String str = d.a;
                iu1.d.p(d0.c, str, "onActivityPaused");
                AtomicInteger atomicInteger = d.f321f;
                if (atomicInteger.decrementAndGet() < 0) {
                    atomicInteger.set(0);
                    Log.w(str, "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application's onCreate method");
                }
                d.a();
                long jCurrentTimeMillis = System.currentTimeMillis();
                String strH = t0.H(activity);
                cn1.e eVar = cn1.e.a;
                if (!vn1.a.b(cn1.e.class)) {
                    try {
                        if (cn1.e.f42f.get()) {
                            cn1.h.f43f.k().c(activity);
                            cn1.n nVar = cn1.e.d;
                            if (nVar != null && !vn1.a.b(nVar)) {
                                try {
                                    if (((Activity) nVar.b.get()) != null) {
                                        try {
                                            Timer timer = nVar.c;
                                            if (timer != null) {
                                                timer.cancel();
                                            }
                                            nVar.c = null;
                                        } catch (Exception e) {
                                            Log.e(cn1.n.e, "Error unscheduling indexing job", e);
                                        }
                                    }
                                } catch (Throwable th) {
                                    vn1.a.a(nVar, th);
                                }
                            }
                            SensorManager sensorManager = cn1.e.c;
                            if (sensorManager != null) {
                                sensorManager.unregisterListener(cn1.e.b);
                            }
                            break;
                        }
                    } catch (Throwable th2) {
                        vn1.a.a(cn1.e.class, th2);
                    }
                }
                d.b.execute(new b(0, jCurrentTimeMillis, strH));
                break;
        }
    }

    public final void onActivityResumed(Activity activity) {
        int i = this.a;
        o.h(activity, "activity");
        switch (i) {
            case 0:
                iu1.d dVar = j0.c;
                iu1.d.p(d0.c, d.a, "onActivityResumed");
                d.l = new WeakReference(activity);
                d.f321f.incrementAndGet();
                d.a();
                long jCurrentTimeMillis = System.currentTimeMillis();
                d.f322j = jCurrentTimeMillis;
                String strH = t0.H(activity);
                cn1.o oVar = cn1.e.b;
                cn1.e eVar = cn1.e.a;
                if (!vn1.a.b(cn1.e.class)) {
                    try {
                        if (cn1.e.f42f.get()) {
                            cn1.h.f43f.k().a(activity);
                            Context applicationContext = activity.getApplicationContext();
                            String strB = s.b();
                            com.facebook.internal.d0 d0VarB = g0.b(strB);
                            if (d0VarB == null || !d0VarB.h) {
                                vn1.a.b(eVar);
                            } else {
                                SensorManager sensorManager = (SensorManager) applicationContext.getSystemService("sensor");
                                if (sensorManager != null) {
                                    cn1.e.c = sensorManager;
                                    Sensor defaultSensor = sensorManager.getDefaultSensor(1);
                                    cn1.n nVar = new cn1.n(activity);
                                    cn1.e.d = nVar;
                                    bv1.a aVar = new bv1.a(strB, 1, d0VarB);
                                    if (!vn1.a.b(oVar)) {
                                        try {
                                            oVar.a = aVar;
                                        } catch (Throwable th) {
                                            vn1.a.a(oVar, th);
                                        }
                                    }
                                    sensorManager.registerListener(oVar, defaultSensor, 2);
                                    if (d0VarB.h) {
                                        nVar.c();
                                    }
                                    break;
                                }
                            }
                            vn1.a.b(eVar);
                            break;
                        }
                    } catch (Throwable th2) {
                        vn1.a.a(cn1.e.class, th2);
                    }
                }
                if (!vn1.a.b(an1.b.class)) {
                    try {
                        if (an1.b.b) {
                            CopyOnWriteArraySet copyOnWriteArraySet = an1.d.d;
                            if (!new HashSet(an1.d.a()).isEmpty()) {
                                HashMap map = an1.e.e;
                                an1.b.b(activity);
                                break;
                            }
                        }
                    } catch (Exception unused) {
                    } catch (Throwable th3) {
                        vn1.a.a(an1.b.class, th3);
                    }
                }
                pn1.d.d(activity);
                String str = d.m;
                if (str != null && q.x0(str, "ProxyBillingActivity", false) && !strH.equals("ProxyBillingActivity")) {
                    d.c.execute(new an1.a(8));
                }
                d.b.execute(new a(activity.getApplicationContext(), strH, jCurrentTimeMillis));
                d.m = strH;
                break;
            default:
                i iVarA = i.b.a();
                if (iVarA != null) {
                    iVarA.b(activity);
                }
                break;
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        int i = this.a;
        o.h(activity, "activity");
        switch (i) {
            case 0:
                o.h(bundle, "outState");
                iu1.d dVar = j0.c;
                iu1.d.p(d0.c, d.a, "onActivitySaveInstanceState");
                break;
            default:
                o.h(bundle, "bundle");
                break;
        }
    }

    public final void onActivityStarted(Activity activity) {
        int i = this.a;
        o.h(activity, "activity");
        switch (i) {
            case 0:
                d.k++;
                iu1.d dVar = j0.c;
                iu1.d.p(d0.c, d.a, "onActivityStarted");
                break;
            default:
                i iVarA = i.b.a();
                if (iVarA != null) {
                    iVarA.b(activity);
                }
                break;
        }
    }

    public final void onActivityStopped(Activity activity) {
        int i = this.a;
        o.h(activity, "activity");
        switch (i) {
            case 0:
                iu1.d dVar = j0.c;
                iu1.d.p(d0.c, d.a, "onActivityStopped");
                String str = m.c;
                com.facebook.appevents.f fVar = com.facebook.appevents.k.a;
                if (!vn1.a.b(com.facebook.appevents.k.class)) {
                    try {
                        com.facebook.appevents.k.b.execute(new an1.a(3));
                    } catch (Throwable th) {
                        vn1.a.a(com.facebook.appevents.k.class, th);
                    }
                }
                d.k--;
                break;
        }
    }
}
