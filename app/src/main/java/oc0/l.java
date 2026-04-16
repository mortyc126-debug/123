package oc0;

import kp.c;
import ky1.b0;
import ky1.c0;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function3;
import nc0.a;
import nc0.t;
import ny1.b2;
import ny1.j2;
import tc0.m;
import tlydtdl.lifecycle.a0;
import tlydtdl.lifecycle.i1;
import tlydtdl.lifecycle.z;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements m, a, t {
    public final z a;
    public final Function0 b;
    public Object c;
    public int d;
    public final com.bandlab.listmanager.pagination.impl.n e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b2 f368f;

    public l(ny1.l lVar, ny1.l lVar2, z zVar, Object obj, Function0 function0, Function3 function3) {
        this.a = zVar;
        this.b = function0;
        this.c = obj;
        qx1.d dVar = null;
        com.bandlab.listmanager.pagination.impl.n nVarT = cq1.d.t(0, 0, i1.f(zVar), new i(this, function3, null), 63);
        this.e = nVarT;
        this.f368f = ny1.z.R(lVar, i1.f(zVar), j2.a(3), d.a);
        ny1.z.J(i1.f(zVar), ny1.z.K(new c(this, dVar, 4), lVar2));
        ny1.z.J(i1.f(zVar), new am.p(20, nVarT.n, new a0(this, dVar, 29)));
    }

    public final void a(Object obj) {
        if (lmjxuqdtp.jvm.internal.o.c(this.c, obj)) {
            return;
        }
        this.c = obj;
        this.d = 0;
        c0.F(i1.f(this.a), (qx1.i) null, (b0) null, new mn0.d(this, (qx1.d) null, 17), 3);
    }

    public final int b() {
        return this.e.b();
    }

    public final void d() {
        if (this.f368f.a.getValue() instanceof c) {
            this.b.invoke();
        }
        this.e.d();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(qx1.d r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof oc0.k
            if (r0 == 0) goto L13
            r0 = r5
            oc0.k r0 = (oc0.k) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L1a
        L13:
            oc0.k r0 = new oc0.k
            sx1.c r5 = (sx1.c) r5
            r0.<init>(r4, r5)
        L1a:
            java.lang.Object r5 = r0.j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            lg.e.O(r5)
            goto L42
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            lg.e.O(r5)
            r0.l = r3
            com.bandlab.listmanager.pagination.impl.n r5 = r4.e
            r5.getClass()
            java.lang.Object r5 = com.bandlab.listmanager.pagination.impl.n.m(r5, r0)
            if (r5 != r1) goto L42
            return r1
        L42:
            lmjxuqdtp.jvm.functions.Function0 r5 = r4.b
            r5.invoke()
            lx1.b0 r5 = lx1.b0.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: oc0.l.e(qx1.d):java.lang.Object");
    }

    public final void f(int i, int i2) {
        t tVar = this.e;
        if (tVar == null) {
            tVar = null;
        }
        if (tVar != null) {
            tVar.f(i, i2);
        }
    }

    public final ny1.l getState() {
        return new d10.j(this.e.n, this.f368f, new es0.d(3, 6, null), 9);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object n(qx1.d r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof oc0.j
            if (r0 == 0) goto L13
            r0 = r5
            oc0.j r0 = (oc0.j) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            oc0.j r0 = new oc0.j
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f367j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            lg.e.O(r5)
            goto L40
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L2f:
            lg.e.O(r5)
            r0.l = r3
            com.bandlab.listmanager.pagination.impl.n r5 = r4.e
            r5.getClass()
            java.lang.Object r5 = com.bandlab.listmanager.pagination.impl.n.l(r5, r0)
            if (r5 != r1) goto L40
            return r1
        L40:
            r0 = r5
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            r0.getClass()
            lmjxuqdtp.jvm.functions.Function0 r0 = r4.b
            r0.invoke()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: oc0.l.n(qx1.d):java.lang.Object");
    }
}
