package oc0;

import d01.k;
import lx1.b0;
import ny1.r2;
import ny1.z;
import rx1.a;
import sx1.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h {
    public final o a;
    public final d01.i b;
    public final r2 c = z.c(d.a);
    public final r2 d = z.c(Boolean.FALSE);

    public h(o oVar, k kVar) {
        this.a = oVar;
        this.b = kVar.a(oVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(sx1.c r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof oc0.g
            if (r0 == 0) goto L13
            r0 = r5
            oc0.g r0 = (oc0.g) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            oc0.g r0 = new oc0.g
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f365j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            lg.e.O(r5)
            goto L3d
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L2f:
            lg.e.O(r5)
            r0.l = r3
            d01.i r5 = r4.b
            java.lang.Object r5 = r5.a(r0)
            if (r5 != r1) goto L3d
            return r1
        L3d:
            tc0.h r5 = (tc0.h) r5
            tc0.g r0 = tc0.h.Companion
            r0.getClass()
            tc0.h r0 = tc0.h.c
            boolean r0 = lmjxuqdtp.jvm.internal.o.c(r5, r0)
            if (r0 == 0) goto L4d
            r5 = 0
        L4d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: oc0.h.a(sx1.c):java.lang.Object");
    }

    public final Object b(tc0.h hVar, c cVar) {
        if (hVar == null) {
            tc0.h.Companion.getClass();
            hVar = tc0.h.c;
        }
        Object objJ = this.b.j(hVar, cVar);
        return objJ == a.a ? objJ : b0.a;
    }
}
