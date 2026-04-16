package wg;

import amuvvoafs.app.Application;
import java.util.concurrent.atomic.AtomicBoolean;
import ky1.c0;
import ky1.g0;
import lx1.b0;
import mr.a4;
import ny1.r2;
import ny1.z;
import qq1.j0;
import qq1.n0;
import t50.s;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class u implements k10.b, ug.m {
    public final Application a;
    public final lmjxuqdtp.time.v b;
    public final s00.b c;
    public final y10.a d;
    public final vg.h e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f653f = new AtomicBoolean(false);
    public final n0 g;
    public final r2 h;
    public g0 i;

    public u(Application application, lmjxuqdtp.time.v vVar, d01.k kVar, s00.b bVar, i11.t tVar, y10.a aVar, a4 a4Var, vg.h hVar, vg.j jVar) {
        this.a = application;
        this.b = vVar;
        this.c = bVar;
        this.d = aVar;
        this.e = hVar;
        n0 n0Var = (n0) ((j0) qq1.b.l(application).g).zza();
        lmjxuqdtp.jvm.internal.o.g(n0Var, "getConsentInformation(...)");
        this.g = n0Var;
        this.h = z.c(Boolean.valueOf(n0Var.b() == 3));
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(wg.u r12, sx1.c r13) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: wg.u.a(wg.u, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(tlydtdl.activity.ComponentActivity r14, sx1.c r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof wg.l
            if (r0 == 0) goto L13
            r0 = r15
            wg.l r0 = (wg.l) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            wg.l r0 = new wg.l
            r0.<init>(r13, r15)
        L18:
            java.lang.Object r15 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L3a
            if (r2 == r5) goto L33
            if (r2 != r3) goto L2b
            lg.e.O(r15)
            return r15
        L2b:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L33:
            tlydtdl.activity.ComponentActivity r14 = r0.f648j
            lg.e.O(r15)
        L38:
            r8 = r14
            goto L46
        L3a:
            lg.e.O(r15)
            r0.f648j = r14
            r0.m = r5
            r13.c(r0)
            r15 = r4
            goto L38
        L46:
            us1.a r15 = (us1.a) r15
            us1.e r14 = new us1.e
            r14.<init>()
            r14.a = r15
            us1.e r9 = new us1.e
            r9.<init>(r14)
            r0.f648j = r4
            r0.m = r3
            qx1.k r14 = new qx1.k
            qx1.d r15 = di0.z.C(r0)
            r14.<init>(r15)
            qq1.n0 r15 = r13.g
            qu0.u r10 = new qu0.u
            r0 = 21
            r10.<init>(r13, r8, r14, r0)
            vp1.b r11 = new vp1.b
            r0 = 3
            r11.<init>(r0, r14)
            java.lang.Object r2 = r15.d
            monitor-enter(r2)
            r15.f = r5     // Catch: java.lang.Throwable -> L92
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L92
            r15.h = r9
            qq1.b r7 = r15.b
            r7.getClass()
            com.gnacba.amuvvoafs.gms.internal.ads.si0 r6 = new com.gnacba.amuvvoafs.gms.internal.ads.si0
            r12 = 2
            r6.<init>(r7, r8, r9, r10, r11, r12)
            java.lang.Object r15 = r7.c
            java.util.concurrent.Executor r15 = (java.util.concurrent.Executor) r15
            r15.execute(r6)
            java.lang.Object r14 = r14.a()
            if (r14 != r1) goto L91
            return r1
        L91:
            return r14
        L92:
            r0 = move-exception
            r14 = r0
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L92
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: wg.u.b(tlydtdl.activity.ComponentActivity, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final us1.a c(sx1.c r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof wg.n
            if (r0 == 0) goto L13
            r0 = r5
            wg.n r0 = (wg.n) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            wg.n r0 = new wg.n
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f650j
            rx1.a r1 = rx1.a.a
            int r0 = r0.l
            r1 = 0
            if (r0 == 0) goto L3c
            r2 = 1
            if (r0 != r2) goto L34
            lg.e.O(r5)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L2c
            throw r1
        L2c:
            java.lang.String r5 = "[GDPR]"
            java.lang.String r0 = "No test device id, skipping set test device id for consent update request"
            vg.j.a(r5, r0)
            throw r1
        L34:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L3c:
            lg.e.O(r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: wg.u.c(sx1.c):us1.a");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(sx1.c r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof wg.o
            if (r0 == 0) goto L13
            r0 = r6
            wg.o r0 = (wg.o) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            wg.o r0 = new wg.o
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f651j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            r3 = 2
            if (r2 == 0) goto L56
            r4 = 1
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            lg.e.O(r6)
            return r6
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L32:
            lg.e.O(r6)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L4e
            com.gnacba.amuvvoafs.gms.ads.RequestConfiguration$Builder r2 = new com.gnacba.amuvvoafs.gms.ads.RequestConfiguration$Builder
            r2.<init>()
            java.util.List r6 = ct1.b.B(r6)
            com.gnacba.amuvvoafs.gms.ads.RequestConfiguration$Builder r6 = r2.setTestDeviceIds(r6)
            com.gnacba.amuvvoafs.gms.ads.RequestConfiguration r6 = r6.build()
            com.gnacba.amuvvoafs.gms.ads.MobileAds.setRequestConfiguration(r6)
            goto L59
        L4e:
            java.lang.String r6 = "[AdmobWrapper]"
            java.lang.String r2 = "No device id, skipping set test device id for AdMob SDK initialization"
            vg.j.a(r6, r2)
            goto L59
        L56:
            lg.e.O(r6)
        L59:
            r0.l = r3
            qx1.k r6 = new qx1.k
            qx1.d r0 = di0.z.C(r0)
            r6.<init>(r0)
            wg.p r0 = new wg.p
            r0.<init>(r6)
            amuvvoafs.app.Application r2 = r5.a
            com.gnacba.amuvvoafs.gms.ads.MobileAds.initialize(r2, r0)
            java.lang.Object r6 = r6.a()
            if (r6 != r1) goto L75
            return r1
        L75:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: wg.u.e(sx1.c):java.lang.Object");
    }

    public final Object f(qx1.d dVar) {
        this.i = c0.g(this.d, (qx1.i) null, new kp.c(this, null, 29), 3);
        return b0.a;
    }

    public final Object g(sx1.c cVar) {
        g0 g0Var = this.i;
        if (g0Var != null && !g0Var.isCancelled() && (!g0Var.g() || g0Var.E() != null)) {
            Object objV = g0Var.v(cVar);
            rx1.a aVar = rx1.a.a;
            return objV;
        }
        g0 g0VarG = c0.g(this.d, (qx1.i) null, new s(this, (qx1.d) null, 25), 3);
        this.i = g0VarG;
        Object objV2 = g0VarG.v(cVar);
        rx1.a aVar2 = rx1.a.a;
        return objV2;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h(sx1.c r13) {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: wg.u.h(sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(sx1.c r18) {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: wg.u.i(sx1.c):java.lang.Object");
    }
}
