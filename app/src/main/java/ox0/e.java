package ox0;

import fy1.l;
import jv0.i0;
import lmjxuqdtp.jvm.internal.d0;
import lmjxuqdtp.jvm.internal.v;
import mt.b;
import nc0.d;
import ny1.b2;
import ny1.r2;
import ny1.z;
import or.q;
import y10.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static final /* synthetic */ l[] e;
    public final i0 a;
    public final b b;
    public final r2 c;
    public final b2 d;

    static {
        l vVar = new v(e.class, "payoutsService", "getPayoutsService()Lcom/bandlab/payments/api/PayoutsService;", 0);
        d0.a.getClass();
        e = new l[]{vVar};
    }

    public e(i0 i0Var, b bVar, a aVar) {
        this.a = i0Var;
        this.b = bVar;
        r2 r2VarC = z.c(a.a);
        this.c = r2VarC;
        this.d = new b2(r2VarC);
        z.J(aVar, z.K(new d(this, (qx1.d) null, 26), ((q) i0Var).f));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(sx1.c r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof ox0.d
            if (r0 == 0) goto L13
            r0 = r8
            ox0.d r0 = (ox0.d) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            ox0.d r0 = new ox0.d
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            lg.e.O(r8)     // Catch: java.lang.Exception -> L27
            goto L5b
        L27:
            r8 = move-exception
            goto L63
        L29:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L31:
            lg.e.O(r8)
            jv0.i0 r8 = r7.a     // Catch: java.lang.Exception -> L27
            java.lang.String r8 = dd.v.D(r8)     // Catch: java.lang.Exception -> L27
            mt.b r2 = r7.b     // Catch: java.lang.Exception -> L27
            fy1.l[] r4 = ox0.e.e     // Catch: java.lang.Exception -> L27
            r5 = 0
            r4 = r4[r5]     // Catch: java.lang.Exception -> L27
            jx0.h r5 = new jx0.h     // Catch: java.lang.Exception -> L27
            java.lang.Class<com.bandlab.payments.api.PayoutsService> r6 = com.bandlab.payments.api.PayoutsService.class
            lmjxuqdtp.jvm.internal.f r6 = lmjxuqdtp.jvm.internal.d0.a(r6)     // Catch: java.lang.Exception -> L27
            r5.<init>(r6, r2)     // Catch: java.lang.Exception -> L27
            java.lang.Object r2 = r5.t(r4)     // Catch: java.lang.Exception -> L27
            com.bandlab.payments.api.PayoutsService r2 = (com.bandlab.payments.api.PayoutsService) r2     // Catch: java.lang.Exception -> L27
            r0.l = r3     // Catch: java.lang.Exception -> L27
            java.lang.Object r8 = r2.getIsUserPayoutMethodRequired(r8, r0)     // Catch: java.lang.Exception -> L27
            if (r8 != r1) goto L5b
            return r1
        L5b:
            dx0.c r8 = (dx0.c) r8     // Catch: java.lang.Exception -> L27
            ox0.b r0 = new ox0.b     // Catch: java.lang.Exception -> L27
            r0.<init>(r8)     // Catch: java.lang.Exception -> L27
            goto L6f
        L63:
            s02.b r0 = s02.d.a
            r0.getClass()
            java.lang.String r0 = "Failed to get is user payout method required"
            s02.b.s(r0, r8)
            ox0.a r0 = ox0.a.a
        L6f:
            ny1.r2 r8 = r7.c
            r8.getClass()
            r1 = 0
            r8.i(r1, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ox0.e.a(sx1.c):java.lang.Object");
    }
}
