package dh;

import fy1.l;
import jv0.i0;
import lmjxuqdtp.jvm.internal.v;
import mt.b;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 {
    public static final /* synthetic */ l[] c;
    public final i0 a;
    public final b b;

    static {
        l vVar = new v(d0.class, "advertisingService", "getAdvertisingService()Lcom/bandlab/advertising/ads/impl/vast/VastService;", 0);
        lmjxuqdtp.jvm.internal.d0.a.getClass();
        c = new l[]{vVar};
    }

    public d0(i0 i0Var, b bVar) {
        this.a = i0Var;
        this.b = bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(ug.f r9, sx1.c r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof dh.c0
            if (r0 == 0) goto L14
            r0 = r10
            dh.c0 r0 = (dh.c0) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.l = r1
        L12:
            r5 = r0
            goto L1a
        L14:
            dh.c0 r0 = new dh.c0
            r0.<init>(r8, r10)
            goto L12
        L1a:
            java.lang.Object r10 = r5.j
            rx1.a r0 = rx1.a.a
            int r1 = r5.l
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            lg.e.O(r10)
            goto L62
        L29:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L31:
            lg.e.O(r10)
            fy1.l[] r10 = dh.d0.c
            r1 = 0
            r10 = r10[r1]
            jx0.h r1 = new jx0.h
            java.lang.Class<com.bandlab.advertising.ads.impl.vast.VastService> r3 = com.bandlab.advertising.ads.impl.vast.VastService.class
            lmjxuqdtp.jvm.internal.f r3 = lmjxuqdtp.jvm.internal.d0.a(r3)
            mt.b r4 = r8.b
            r1.<init>(r3, r4)
            java.lang.Object r10 = r1.t(r10)
            r1 = r10
            com.bandlab.advertising.ads.impl.vast.VastService r1 = (com.bandlab.advertising.ads.impl.vast.VastService) r1
            jv0.i0 r10 = r8.a
            or.q r10 = (or.q) r10
            java.lang.String r3 = r10.b()
            r5.l = r2
            r4 = 0
            r6 = 4
            r7 = 0
            r2 = r9
            java.lang.Object r10 = com.bandlab.advertising.ads.impl.vast.VastService.getVastAd$default(r1, r2, r3, r4, r5, r6, r7)
            if (r10 != r0) goto L62
            return r0
        L62:
            iz1.s0 r10 = (iz1.s0) r10
            java.lang.String r9 = r10.f()
            java.lang.String r9 = hs1.d.L(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: dh.d0.a(ug.f, sx1.c):java.lang.Object");
    }
}
