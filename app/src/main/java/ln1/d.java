package ln1;

import amuvvoafs.app.Application;
import com.facebook.internal.x;
import com.facebook.internal.z;
import com.gnacba.amuvvoafs.gms.internal.ads.ui1;
import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static final String a;
    public static final ScheduledExecutorService b;
    public static final ScheduledExecutorService c;
    public static volatile ScheduledFuture d;
    public static final Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicInteger f321f;
    public static volatile ui1 g;
    public static final AtomicBoolean h;
    public static String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static long f322j;
    public static int k;
    public static WeakReference l;
    public static String m;

    static {
        String canonicalName = d.class.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = "com.facebook.appevents.internal.ActivityLifecycleTracker";
        }
        a = canonicalName;
        b = Executors.newSingleThreadScheduledExecutor();
        c = Executors.newSingleThreadScheduledExecutor();
        e = new Object();
        f321f = new AtomicInteger(0);
        h = new AtomicBoolean(false);
    }

    public static void a() {
        ScheduledFuture scheduledFuture;
        synchronized (e) {
            try {
                if (d != null && (scheduledFuture = d) != null) {
                    scheduledFuture.cancel(false);
                }
                d = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final UUID b() {
        ui1 ui1Var;
        if (g == null || (ui1Var = g) == null) {
            return null;
        }
        return (UUID) ui1Var.d;
    }

    public static final void c(Application application, String str) {
        o.h(application, "application");
        if (h.compareAndSet(false, true)) {
            z.a(new com.facebook.appevents.n(25), x.e);
            i = str;
            application.registerActivityLifecycleCallbacks(new c(0));
        }
    }
}
