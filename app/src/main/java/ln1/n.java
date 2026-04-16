package ln1;

import amuvvoafs.content.Context;
import amuvvoafs.os.Bundle;
import com.facebook.appevents.m;
import com.facebook.d0;
import com.facebook.i0;
import com.facebook.internal.j0;
import com.facebook.s;
import com.gnacba.amuvvoafs.gms.internal.ads.ui1;
import com.gnacba.amuvvoafs.gms.internal.measurement.o4;
import java.util.Arrays;
import java.util.Locale;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class n {
    public static final n a = new n();
    public static final long[] b = {300000, 900000, 1800000, 3600000, 21600000, 43200000, 86400000, 172800000, 259200000, 604800000, 1209600000, 1814400000, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};

    public static final void b(Context context, String str, String str2) {
        if (vn1.a.b(n.class)) {
            return;
        }
        try {
            o.h(context, "context");
            Bundle bundle = new Bundle();
            bundle.putString("fb_mobile_launch_source", "Unclassified");
            m mVar = new m(str, str2);
            s sVar = s.a;
            if (i0.c()) {
                mVar.d(bundle, "fb_mobile_activate_app");
            }
            String str3 = m.c;
            if (kd.h.k() == 2 || vn1.a.b(mVar)) {
                return;
            }
            try {
                com.facebook.appevents.k.c(1);
            } catch (Throwable th) {
                vn1.a.a(mVar, th);
            }
        } catch (Throwable th2) {
            vn1.a.a(n.class, th2);
        }
    }

    public static final void d(String str, ui1 ui1Var, String str2) {
        String string;
        Long l;
        if (vn1.a.b(n.class) || ui1Var == null) {
            return;
        }
        try {
            Long l2 = (Long) ui1Var.e;
            if (l2 == null) {
                l2 = 0L;
            }
            long jLongValue = l2.longValue();
            n nVar = a;
            if (jLongValue < 0) {
                nVar.c();
                jLongValue = 0;
            }
            Long l4 = (Long) ui1Var.b;
            long jLongValue2 = (l4 == null || (l = (Long) ui1Var.c) == null) ? 0L : l.longValue() - l4.longValue();
            if (jLongValue2 < 0) {
                nVar.c();
                jLongValue2 = 0;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("fb_mobile_app_interruptions", ui1Var.a);
            Locale locale = Locale.ROOT;
            int i = 0;
            if (!vn1.a.b(n.class)) {
                int i2 = 0;
                while (true) {
                    try {
                        long[] jArr = b;
                        if (i2 >= 19 || jArr[i2] >= jLongValue) {
                            break;
                        } else {
                            i2++;
                        }
                    } catch (Throwable th) {
                        vn1.a.a(n.class, th);
                    }
                }
                i = i2;
            }
            bundle.putString("fb_mobile_time_between_sessions", String.format(locale, "session_quanta_%d", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1)));
            o4 o4Var = (o4) ui1Var.f;
            if (o4Var == null || (string = o4Var.toString()) == null) {
                string = "Unclassified";
            }
            bundle.putString("fb_mobile_launch_source", string);
            Long l6 = (Long) ui1Var.c;
            bundle.putLong("_logTime", (l6 != null ? l6.longValue() : 0L) / ((long) 1000));
            m mVar = new m(str, str2);
            double d = jLongValue2 / 1000;
            s sVar = s.a;
            if (!i0.c() || vn1.a.b(mVar)) {
                return;
            }
            try {
                m.f(mVar, "fb_mobile_deactivate_app", Double.valueOf(d), bundle, false, d.b());
            } catch (Throwable th2) {
                vn1.a.a(mVar, th2);
            }
        } catch (Throwable th3) {
            vn1.a.a(n.class, th3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0032 A[Catch: all -> 0x0048, TRY_LEAVE, TryCatch #1 {, blocks: (B:11:0x0016, B:15:0x0020, B:23:0x0032, B:29:0x0044, B:21:0x002d, B:26:0x0040, B:18:0x0029), top: B:40:0x0016, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ln1.i a() {
        /*
            r3 = this;
            java.lang.Class<ln1.i> r0 = ln1.i.class
            boolean r1 = vn1.a.b(r0)
            r2 = 0
            if (r1 == 0) goto Lb
        L9:
            r0 = r2
            goto L13
        Lb:
            ln1.i r0 = ln1.i.c     // Catch: java.lang.Throwable -> Le
            goto L13
        Le:
            r1 = move-exception
            vn1.a.a(r0, r1)
            goto L9
        L13:
            if (r0 != 0) goto L4e
            monitor-enter(r3)
            java.util.concurrent.atomic.AtomicBoolean r0 = com.facebook.s.o     // Catch: java.lang.Throwable -> L48
            boolean r0 = r0.get()     // Catch: java.lang.Throwable -> L48
            if (r0 != 0) goto L20
            monitor-exit(r3)
            return r2
        L20:
            java.lang.Class<ln1.i> r0 = ln1.i.class
            boolean r1 = vn1.a.b(r0)     // Catch: java.lang.Throwable -> L48
            if (r1 == 0) goto L29
            goto L30
        L29:
            ln1.i r2 = ln1.i.c     // Catch: java.lang.Throwable -> L2c
            goto L30
        L2c:
            r1 = move-exception
            vn1.a.a(r0, r1)     // Catch: java.lang.Throwable -> L48
        L30:
            if (r2 != 0) goto L4a
            ln1.i r2 = new ln1.i     // Catch: java.lang.Throwable -> L48
            r2.<init>()     // Catch: java.lang.Throwable -> L48
            java.lang.Class<ln1.i> r0 = ln1.i.class
            boolean r1 = vn1.a.b(r0)     // Catch: java.lang.Throwable -> L48
            if (r1 == 0) goto L40
            goto L4a
        L40:
            ln1.i.c = r2     // Catch: java.lang.Throwable -> L43
            goto L4a
        L43:
            r1 = move-exception
            vn1.a.a(r0, r1)     // Catch: java.lang.Throwable -> L48
            goto L4a
        L48:
            r0 = move-exception
            goto L4c
        L4a:
            monitor-exit(r3)
            return r2
        L4c:
            monitor-exit(r3)
            throw r0
        L4e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ln1.n.a():ln1.i");
    }

    public void c() {
        if (vn1.a.b(this)) {
            return;
        }
        try {
            iu1.d dVar = j0.c;
            iu1.d.p(d0.c, "ln1.n", "Clock skew detected");
        } catch (Throwable th) {
            vn1.a.a(this, th);
        }
    }
}
