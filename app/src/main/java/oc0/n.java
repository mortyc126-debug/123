package oc0;

import kp.c;
import ky1.c0;
import ky1.m0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.functions.Function3;
import lmjxuqdtp.jvm.internal.k;
import ny1.r2;
import s1.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class n extends tc0.e {
    public final h g;
    public final Object h;
    public final k i;

    public n(h hVar, Function2 function2, Function1 function1, Function3 function3) {
        super(30, 30, 100, function3);
        this.g = hVar;
        this.h = function2;
        this.i = (k) function1;
    }

    public final tc0.h a() {
        return (tc0.h) c0.J(qx1.j.a, new c(this, null, 5));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(sx1.c r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof oc0.m
            if (r0 == 0) goto L13
            r0 = r8
            oc0.m r0 = (oc0.m) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            oc0.m r0 = new oc0.m
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            lx1.b0 r3 = lx1.b0.a
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L38
            if (r2 == r5) goto L34
            if (r2 != r4) goto L2c
            lg.e.O(r8)
            return r3
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L34:
            lg.e.O(r8)
            goto L43
        L38:
            lg.e.O(r8)
            r0.l = r5
            super.c(r0)
            if (r3 != r1) goto L43
            goto L57
        L43:
            ry1.e r8 = ky1.m0.a
            ky1.x r8 = x30.b.a
            mn0.d r2 = new mn0.d
            r5 = 0
            r6 = 18
            r2.<init>(r7, r5, r6)
            r0.l = r4
            java.lang.Object r8 = ky1.c0.R(r8, r2, r0)
            if (r8 != r1) goto L58
        L57:
            return r1
        L58:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: oc0.n.c(sx1.c):java.lang.Object");
    }

    public final Object f(sx1.c cVar) {
        s02.b bVar = s02.d.a;
        String str = "DatabasePaginator:: load next page for " + this.g.a.c;
        bVar.getClass();
        s02.b.p(str);
        ry1.e eVar = m0.a;
        return c0.R(x30.b.a, new nc0.d(this, (qx1.d) null, 14), cVar);
    }

    public final void i(tc0.h hVar) {
        c0.K(new i2.d(this, hVar, (qx1.d) null, 20));
    }

    public final Object j(qx1.d dVar) {
        s02.b bVar = s02.d.a;
        String str = "DatabasePaginator:: load new items for " + this.g.a.c;
        bVar.getClass();
        s02.b.p(str);
        ry1.e eVar = m0.a;
        return c0.R(x30.b.a, new i2.d(this, (qx1.d) null, 21), dVar);
    }

    public final void k(boolean z) {
        a.A(z, this.g.d, (Object) null);
    }

    public final void l(Exception exc) {
        r2 r2Var = this.g.c;
        c cVar = exc != null ? new c(exc) : d.a;
        r2Var.getClass();
        r2Var.i((Object) null, cVar);
    }

    public final String toString() {
        return n.class.getName() + "_" + this.g.a.c;
    }
}
