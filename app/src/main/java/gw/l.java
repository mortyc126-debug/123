package gw;

import ah.o;
import am.p;
import fw.c;
import k10.b;
import lx1.b0;
import lx1.h;
import nc0.g;
import ny1.z;
import qx1.d;
import rx1.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements b {
    public final /* synthetic */ int a;
    public final Object b;
    public final Object c;

    public /* synthetic */ l(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(gw.l r6, sx1.c r7) {
        /*
            boolean r0 = r7 instanceof gw.k
            if (r0 == 0) goto L13
            r0 = r7
            gw.k r0 = (gw.k) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            gw.k r0 = new gw.k
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            lx1.b0 r3 = lx1.b0.a
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3a
            if (r2 == r5) goto L36
            if (r2 != r4) goto L2e
            lg.e.O(r7)     // Catch: java.lang.Exception -> L2c
            return r3
        L2c:
            r6 = move-exception
            goto L6f
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            lg.e.O(r7)
            goto L52
        L3a:
            lg.e.O(r7)
            java.lang.Object r7 = r6.b
            lx1.h r7 = (lx1.h) r7
            java.lang.Object r7 = r7.getValue()
            fw.c r7 = (fw.c) r7
            r0.l = r5
            java.lang.String r2 = "inapp"
            java.lang.Object r7 = r7.c(r2, r0)
            if (r7 != r1) goto L52
            goto L6d
        L52:
            java.util.List r7 = (java.util.List) r7
            boolean r2 = r7.isEmpty()
            if (r2 == 0) goto L5b
            goto L6e
        L5b:
            java.lang.Object r6 = r6.c     // Catch: java.lang.Exception -> L2c
            lx1.h r6 = (lx1.h) r6     // Catch: java.lang.Exception -> L2c
            java.lang.Object r6 = r6.getValue()     // Catch: java.lang.Exception -> L2c
            gw.s r6 = (gw.s) r6     // Catch: java.lang.Exception -> L2c
            r0.l = r4     // Catch: java.lang.Exception -> L2c
            java.lang.Object r6 = gw.s.d(r6, r7, r0)     // Catch: java.lang.Exception -> L2c
            if (r6 != r1) goto L6e
        L6d:
            return r1
        L6e:
            return r3
        L6f:
            s02.b r7 = s02.d.a
            r7.getClass()
            java.lang.String r7 = "BillingClient: OTP Purchase validation failed."
            s02.b.s(r7, r6)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: gw.l.a(gw.l, sx1.c):java.lang.Object");
    }

    public final Object f(d dVar) {
        switch (this.a) {
            case 0:
                Object objB = z.B(z.K(new o(this, (d) null, 24), ((c) ((h) this.b).getValue()).d), dVar);
                if (objB != a.a) {
                    break;
                }
                break;
            default:
                Object objB2 = z.B(new p(20, new g(((s00.b) this.c).b, 23), new kp.c(this, null, 28)), dVar);
                if (objB2 != a.a) {
                    break;
                }
                break;
        }
        return b0.a;
    }
}
