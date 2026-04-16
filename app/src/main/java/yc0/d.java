package yc0;

import bj.k;
import com.bandlab.loop.api.manager.network.LoopPacksService;
import d01.i;
import fy1.l;
import jx0.h;
import lmjxuqdtp.jvm.internal.d0;
import lmjxuqdtp.jvm.internal.v;
import mt.b;
import wb.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ l[] f711f;
    public final a a;
    public final k b;
    public final b c;
    public final i d;
    public final i e;

    static {
        l vVar = new v(d.class, "api", "getApi()Lcom/bandlab/loop/api/manager/network/LoopPacksService;", 0);
        d0.a.getClass();
        f711f = new l[]{vVar};
    }

    public d(a aVar, k kVar, b bVar, d01.k kVar2, k kVar3, e eVar) {
        this.a = aVar;
        this.b = kVar;
        this.c = bVar;
        this.d = kVar2.a(kVar3);
        this.e = kVar2.a(eVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(sx1.c r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof yc0.a
            if (r0 == 0) goto L13
            r0 = r9
            yc0.a r0 = (yc0.a) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            yc0.a r0 = new yc0.a
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            d01.i r3 = r8.e
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3a
            if (r2 == r5) goto L36
            if (r2 != r4) goto L2e
            wb.a r0 = r0.j
            lg.e.O(r9)
            goto L73
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L36:
            lg.e.O(r9)
            goto L46
        L3a:
            lg.e.O(r9)
            r0.m = r5
            java.lang.Object r9 = r3.a(r0)
            if (r9 != r1) goto L46
            goto L71
        L46:
            java.util.List r9 = (java.util.List) r9
            ua.n r2 = new ua.n
            im1.g r5 = new im1.g
            r6 = 4
            r5.<init>(r9, r6)
            y61.b r9 = new y61.b
            r9.<init>(r6, r3)
            yc0.b r3 = new yc0.b
            r6 = 0
            r7 = 0
            r3.<init>(r8, r7, r6)
            r2.<init>(r5, r9, r3)
            bj.k r9 = r8.b
            ky1.g0 r9 = r2.j(r9)
            wb.a r2 = r8.a
            r0.j = r2
            r0.m = r4
            java.lang.Object r9 = r9.v(r0)
            if (r9 != r1) goto L72
        L71:
            return r1
        L72:
            r0 = r2
        L73:
            java.util.List r9 = (java.util.List) r9
            java.util.List r9 = r0.x(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: yc0.d.a(sx1.c):java.lang.Object");
    }

    public final LoopPacksService b() {
        return (LoopPacksService) new h(d0.a(LoopPacksService.class), this.c).t(f711f[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(sx1.c r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof yc0.c
            if (r0 == 0) goto L13
            r0 = r9
            yc0.c r0 = (yc0.c) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            yc0.c r0 = new yc0.c
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            d01.i r3 = r8.d
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L38
            if (r2 == r5) goto L34
            if (r2 != r4) goto L2c
            lg.e.O(r9)
            return r9
        L2c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L34:
            lg.e.O(r9)
            goto L44
        L38:
            lg.e.O(r9)
            r0.l = r5
            java.lang.Object r9 = r3.a(r0)
            if (r9 != r1) goto L44
            goto L6c
        L44:
            java.util.List r9 = (java.util.List) r9
            ua.n r2 = new ua.n
            im1.g r5 = new im1.g
            r6 = 4
            r5.<init>(r9, r6)
            y61.b r9 = new y61.b
            r6 = 5
            r9.<init>(r6, r3)
            yc0.b r3 = new yc0.b
            r6 = 1
            r7 = 0
            r3.<init>(r8, r7, r6)
            r2.<init>(r5, r9, r3)
            bj.k r9 = r8.b
            ky1.g0 r9 = r2.j(r9)
            r0.l = r4
            java.lang.Object r9 = r9.v(r0)
            if (r9 != r1) goto L6d
        L6c:
            return r1
        L6d:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: yc0.d.c(sx1.c):java.lang.Object");
    }
}
