package bh;

import am.p;
import amuvvoafs.content.Context;
import kotlin.jvm.internal.IntCompanionObject;
import ky1.b0;
import ky1.c0;
import ky1.g0;
import mr.a4;
import my1.c;
import ny1.a2;
import ny1.j2;
import ny1.z;
import qx1.d;
import tlydtdl.compose.runtime.d2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements k10.b {
    public final String a;
    public final Context b;
    public final a2 c;
    public final g0 d;

    public o(y10.a aVar, a4 a4Var, String str, Context context) {
        this.a = str;
        this.b = context;
        this.c = z.P(new p(20, z.h(z.i(new b(2, 0, (d) null)), IntCompanionObject.MAX_VALUE, c.a), new d2(2, 3, null)), aVar, j2.a, 0);
        this.d = c0.f(aVar, ry1.d.b, b0.b, new k(this, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r7, sx1.c r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof bh.l
            if (r0 == 0) goto L13
            r0 = r8
            bh.l r0 = (bh.l) r0
            int r1 = r0.n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.n = r1
            goto L18
        L13:
            bh.l r0 = new bh.l
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.l
            rx1.a r1 = rx1.a.a
            int r2 = r0.n
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            ny1.a2 r7 = r0.k
            java.lang.String r0 = r0.j
            lg.e.O(r8)
            goto L92
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            java.lang.String r7 = r0.j
            lg.e.O(r8)
            goto L4c
        L3c:
            lg.e.O(r8)
            r0.j = r7
            r0.n = r4
            ky1.g0 r8 = r6.d
            java.lang.Object r8 = r8.v(r0)
            if (r8 != r1) goto L4c
            goto L8f
        L4c:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L5b
            s02.b r8 = s02.d.a
            java.lang.String r2 = "[Ads][IronSource] Skip interstitial loading, SDK not initialized "
            i.A(r2, r7, r8)
        L5b:
            boolean r8 = com.ironsource.mediationsdk.IronSource.isInterstitialReady()
            ny1.a2 r2 = r6.c
            if (r8 != 0) goto L94
            com.ironsource.mediationsdk.IronSource.loadInterstitial()
            s02.b r8 = s02.d.a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "[Ads][IronSource] Loading placement "
            r4.<init>(r5)
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            r8.getClass()
            s02.b.p(r4)
            ac0.v r8 = new ac0.v
            r4 = 11
            r8.<init>(r4)
            r0.j = r7
            r0.k = r2
            r0.n = r3
            java.lang.Object r8 = ny1.z.A(r2, r8, r0)
            if (r8 != r1) goto L90
        L8f:
            return r1
        L90:
            r0 = r7
            r7 = r2
        L92:
            r2 = r7
            r7 = r0
        L94:
            bh.n r8 = new bh.n
            r8.<init>(r7, r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: bh.o.a(java.lang.String, sx1.c):java.lang.Object");
    }

    public final Object f(d dVar) {
        this.d.start();
        return lx1.b0.a;
    }
}
