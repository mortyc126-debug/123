package s4;

import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class z0 {
    public final j0 a;
    public boolean c;
    public boolean d;
    public p5.a i;
    public final qu0.u b = new qu0.u(4);
    public final eu0.k e = new eu0.k(27);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k3.e f447f = new k3.e(0, new j0[16]);
    public final long g = 1;
    public final k3.e h = new k3.e(0, new y0[16]);

    public z0(j0 j0Var) {
        this.a = j0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(s4.j0 r5, p5.a r6) {
        /*
            s4.j0 r0 = r5.g
            s4.n0 r1 = r5.F
            r2 = 0
            if (r0 != 0) goto L8
            return r2
        L8:
            if (r6 == 0) goto L1a
            if (r0 == 0) goto L18
            s4.x0 r0 = r1.q
            lmjxuqdtp.jvm.internal.o.e(r0)
            long r3 = r6.a
            boolean r6 = r0.N0(r3)
            goto L2f
        L18:
            r6 = r2
            goto L2f
        L1a:
            s4.x0 r6 = r1.q
            if (r6 == 0) goto L21
            p5.a r1 = r6.m
            goto L22
        L21:
            r1 = 0
        L22:
            if (r1 == 0) goto L18
            if (r0 == 0) goto L18
            lmjxuqdtp.jvm.internal.o.e(r6)
            long r0 = r1.a
            boolean r6 = r6.N0(r0)
        L2f:
            s4.j0 r0 = r5.v()
            if (r6 == 0) goto L57
            if (r0 == 0) goto L57
            s4.j0 r1 = r0.g
            r3 = 3
            if (r1 != 0) goto L40
            s4.j0.Y(r0, r2, r3)
            return r6
        L40:
            s4.h0 r1 = r5.s()
            s4.h0 r4 = s4.h0.a
            if (r1 != r4) goto L4c
            s4.j0.W(r0, r2, r3)
            return r6
        L4c:
            s4.h0 r5 = r5.s()
            s4.h0 r1 = s4.h0.b
            if (r5 != r1) goto L57
            r0.V(r2)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: s4.z0.c(s4.j0, p5.a):boolean");
    }

    public static boolean d(j0 j0Var, p5.a aVar) {
        boolean zQ = aVar != null ? j0Var.Q(aVar) : j0.R(j0Var);
        j0 j0VarV = j0Var.v();
        if (zQ && j0VarV != null) {
            if (j0Var.r() == h0.a) {
                j0.Y(j0VarV, false, 3);
                return zQ;
            }
            if (j0Var.r() == h0.b) {
                j0VarV.X(false);
            }
        }
        return zQ;
    }

    public static boolean i(j0 j0Var) {
        x0 x0Var;
        o0 o0Var;
        if (j0Var.F.e) {
            return (j0Var.s() == h0.c && ((x0Var = j0Var.F.q) == null || (o0Var = x0Var.r) == null || !o0Var.f())) ? false : true;
        }
        return false;
    }

    public static boolean j(j0 j0Var) {
        if (!j0Var.q()) {
            return false;
        }
        do {
            if (j0Var.r() == h0.c && !j0Var.F.p.x.f()) {
                j0 j0VarV = j0Var.v();
                if ((j0VarV != null ? j0VarV.F.d : null) != f0.a) {
                    return false;
                }
            }
            j0Var = j0Var.v();
            if (j0Var == null) {
                return false;
            }
        } while (!j0Var.J());
        return true;
    }

    public final void a() {
        t3.o parent$ui_release;
        k3.e eVar = this.f447f;
        Object[] objArr = eVar.a;
        int i = eVar.c;
        for (int i2 = 0; i2 < i; i2++) {
            dl.c cVar = ((j0) objArr[i2]).E;
            v vVar = (v) cVar.d;
            boolean zH = l1.h(128);
            if (zH) {
                parent$ui_release = vVar.P;
            } else {
                parent$ui_release = vVar.P.getParent$ui_release();
                if (parent$ui_release == null) {
                }
            }
            a4.x0 x0Var = k1.K;
            for (t3.o oVarL1 = vVar.l1(zH); oVarL1 != null && (oVarL1.getAggregateChildKindSet$ui_release() & 128) != 0; oVarL1 = oVarL1.getChild$ui_release()) {
                if ((oVarL1.getKindSet$ui_release() & 128) != 0) {
                    t3.o oVarE = oVarL1;
                    k3.e eVar2 = null;
                    while (oVarE != null) {
                        if (oVarE instanceof y) {
                            ((y) oVarE).R((v) cVar.d);
                        } else if ((oVarE.getKindSet$ui_release() & 128) != 0 && (oVarE instanceof o)) {
                            int i3 = 0;
                            for (t3.o child$ui_release = ((o) oVarE).b; child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                                if ((child$ui_release.getKindSet$ui_release() & 128) != 0) {
                                    i3++;
                                    if (i3 == 1) {
                                        oVarE = child$ui_release;
                                    } else {
                                        if (eVar2 == null) {
                                            eVar2 = new k3.e(0, new t3.o[16]);
                                        }
                                        if (oVarE != null) {
                                            eVar2.d(oVarE);
                                            oVarE = null;
                                        }
                                        eVar2.d(child$ui_release);
                                    }
                                }
                            }
                            if (i3 == 1) {
                            }
                        }
                        oVarE = g.e(eVar2);
                    }
                }
                if (oVarL1 != parent$ui_release) {
                }
            }
        }
        eVar.k();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(boolean r8) {
        /*
            r7 = this;
            r0 = 1
            eu0.k r1 = r7.e
            if (r8 == 0) goto L17
            java.lang.Object r8 = r1.b
            k3.e r8 = (k3.e) r8
            s4.j0 r2 = r7.a
            int r3 = r2.O
            if (r3 <= 0) goto L17
            r8.k()
            r8.d(r2)
            r2.N = r0
        L17:
            java.lang.Object r8 = r1.b
            k3.e r8 = (k3.e) r8
            int r2 = r8.c
            if (r2 == 0) goto L62
            s4.q1 r3 = s4.q1.b
            java.lang.Object[] r4 = r8.a
            r5 = 0
            mx1.n.r0(r4, r3, r5, r2)
            int r2 = r8.c
            java.lang.Object r3 = r1.c
            s4.j0[] r3 = (s4.j0[]) r3
            if (r3 == 0) goto L32
            int r4 = r3.length
            if (r4 >= r2) goto L3a
        L32:
            r3 = 16
            int r3 = java.lang.Math.max(r3, r2)
            s4.j0[] r3 = new s4.j0[r3]
        L3a:
            r4 = 0
            r1.c = r4
        L3d:
            if (r5 >= r2) goto L48
            java.lang.Object[] r6 = r8.a
            r6 = r6[r5]
            r3[r5] = r6
            int r5 = r5 + 1
            goto L3d
        L48:
            r8.k()
            int r2 = r2 - r0
        L4c:
            r8 = -1
            if (r8 >= r2) goto L60
            r8 = r3[r2]
            lmjxuqdtp.jvm.internal.o.e(r8)
            boolean r0 = r8.N
            if (r0 == 0) goto L5b
            eu0.k.o(r8)
        L5b:
            r3[r2] = r4
            int r2 = r2 + (-1)
            goto L4c
        L60:
            r1.c = r3
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s4.z0.b(boolean):void");
    }

    public final void e() {
        k3.e eVar = this.h;
        int i = eVar.c;
        if (i != 0) {
            Object[] objArr = eVar.a;
            for (int i2 = 0; i2 < i; i2++) {
                y0 y0Var = (y0) objArr[i2];
                j0 j0Var = y0Var.a;
                boolean z = y0Var.c;
                j0 j0Var2 = y0Var.a;
                if (j0Var.I()) {
                    if (y0Var.b) {
                        j0.W(j0Var2, z, 2);
                    } else {
                        j0.Y(j0Var2, z, 2);
                    }
                }
            }
            eVar.k();
        }
    }

    public final void f(j0 j0Var) {
        k3.e eVarZ = j0Var.z();
        Object[] objArr = eVarZ.a;
        int i = eVarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            j0 j0Var2 = (j0) objArr[i2];
            if (lmjxuqdtp.jvm.internal.o.c(j0Var2.K(), Boolean.TRUE) && !j0Var2.P) {
                if (this.b.n(j0Var2)) {
                    j0Var2.L();
                }
                f(j0Var2);
            }
        }
    }

    public final void g(j0 j0Var, boolean z) {
        if (!this.c) {
            p4.a.b("forceMeasureTheSubtree should be executed during the measureAndLayout pass");
        }
        if (z ? j0Var.F.e : j0Var.q()) {
            p4.a.a("node not yet measured");
        }
        h(j0Var, z);
    }

    public final void h(j0 j0Var, boolean z) {
        x0 x0Var;
        o0 o0Var;
        k3.e eVarZ = j0Var.z();
        Object[] objArr = eVarZ.a;
        int i = eVarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            j0 j0Var2 = (j0) objArr[i2];
            if ((!z && (j0Var2.r() == h0.a || j0Var2.F.p.x.f())) || (z && (j0Var2.s() == h0.a || ((x0Var = j0Var2.F.q) != null && (o0Var = x0Var.r) != null && o0Var.f())))) {
                boolean zP = g.p(j0Var2);
                n0 n0Var = j0Var2.F;
                if (zP && !z) {
                    if (n0Var.e && this.b.n(j0Var2)) {
                        n(j0Var2, true, false);
                    } else {
                        g(j0Var2, true);
                    }
                }
                if (z ? n0Var.e : j0Var2.q()) {
                    n(j0Var2, z, false);
                }
                if (!(z ? n0Var.e : j0Var2.q())) {
                    h(j0Var2, z);
                }
            }
        }
        if (z ? j0Var.F.e : j0Var.q()) {
            n(j0Var, z, false);
        }
    }

    public final boolean k(Function0 function0) {
        boolean z;
        boolean z2;
        j0 j0Var;
        boolean z3;
        qu0.u uVar = this.b;
        j0 j0Var2 = this.a;
        if (!j0Var2.I()) {
            p4.a.a("performMeasureAndLayout called with unattached root");
        }
        if (!j0Var2.J()) {
            p4.a.a("performMeasureAndLayout called with unplaced root");
        }
        if (this.c) {
            p4.a.a("performMeasureAndLayout called during measure layout");
        }
        boolean z4 = false;
        if (this.i != null) {
            this.c = true;
            this.d = true;
            try {
                boolean zB = uVar.B();
                rs1.d dVar = (rs1.d) uVar.b;
                if (zB) {
                    z = false;
                    while (true) {
                        rs1.d dVar2 = (rs1.d) uVar.d;
                        rs1.d dVar3 = (rs1.d) uVar.c;
                        if (!((c2) dVar.b).isEmpty()) {
                            j0Var = (j0) ((c2) dVar.b).first();
                            dVar.I(j0Var);
                            z3 = j0Var.g != null;
                            z2 = false;
                        } else if (!((c2) dVar3.b).isEmpty()) {
                            j0Var = (j0) ((c2) dVar3.b).first();
                            dVar3.I(j0Var);
                            z3 = j0Var.g != null;
                            z2 = true;
                        } else {
                            if (((c2) dVar2.b).isEmpty()) {
                                break;
                            }
                            j0 j0Var3 = (j0) ((c2) dVar2.b).first();
                            dVar2.I(j0Var3);
                            z2 = true;
                            j0Var = j0Var3;
                            z3 = false;
                        }
                        boolean zN = n(j0Var, z3, z2);
                        if (!z2) {
                            if (j0Var.F.f437f) {
                                uVar.k(j0Var, w.b);
                            }
                            if (j0Var.p()) {
                                uVar.k(j0Var, w.d);
                            }
                        }
                        if (j0Var == j0Var2 && zN) {
                            z = true;
                        }
                    }
                    if (function0 != null) {
                        function0.invoke();
                    }
                } else {
                    z = false;
                }
                this.c = false;
                this.d = false;
                z4 = z;
            } finally {
            }
        }
        a();
        return z4;
    }

    public final void l(j0 j0Var, long j2) {
        if (j0Var.P) {
            return;
        }
        j0 j0Var2 = this.a;
        if (j0Var.equals(j0Var2)) {
            p4.a.a("measureAndLayout called on root");
        }
        if (!j0Var2.I()) {
            p4.a.a("performMeasureAndLayout called with unattached root");
        }
        if (!j0Var2.J()) {
            p4.a.a("performMeasureAndLayout called with unplaced root");
        }
        if (this.c) {
            p4.a.a("performMeasureAndLayout called during measure layout");
        }
        if (this.i != null) {
            this.c = true;
            this.d = false;
            try {
                qu0.u uVar = this.b;
                ((rs1.d) uVar.b).I(j0Var);
                ((rs1.d) uVar.c).I(j0Var);
                ((rs1.d) uVar.d).I(j0Var);
                if ((c(j0Var, new p5.a(j2)) || j0Var.F.f437f) && lmjxuqdtp.jvm.internal.o.c(j0Var.K(), Boolean.TRUE)) {
                    j0Var.L();
                }
                f(j0Var);
                d(j0Var, new p5.a(j2));
                if (j0Var.p() && j0Var.J()) {
                    j0Var.U();
                    eu0.k kVar = this.e;
                    kVar.getClass();
                    if (j0Var.O > 0) {
                        ((k3.e) kVar.b).d(j0Var);
                        j0Var.N = true;
                    }
                }
                e();
            } finally {
            }
        }
        a();
    }

    public final void m() {
        qu0.u uVar = this.b;
        if (uVar.B()) {
            j0 j0Var = this.a;
            if (!j0Var.I()) {
                p4.a.a("performMeasureAndLayout called with unattached root");
            }
            if (!j0Var.J()) {
                p4.a.a("performMeasureAndLayout called with unplaced root");
            }
            if (this.c) {
                p4.a.a("performMeasureAndLayout called during measure layout");
            }
            if (this.i != null) {
                this.c = true;
                this.d = false;
                try {
                    if (!((c2) ((rs1.d) uVar.d).b).isEmpty() && !((c2) ((rs1.d) uVar.b).b).isEmpty()) {
                        if (j0Var.g != null) {
                            p(j0Var, true);
                        } else {
                            o(j0Var);
                        }
                    }
                    p(j0Var, false);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } finally {
                        this.c = false;
                        this.d = false;
                    }
                }
            }
        }
    }

    public final boolean n(j0 j0Var, boolean z, boolean z2) {
        p5.a aVar;
        boolean zC;
        q4.q0 placementScope;
        v vVar;
        j0 j0VarV;
        x0 x0Var;
        o0 o0Var;
        boolean z3 = j0Var.P;
        n0 n0Var = j0Var.F;
        if (z3 || (!j0Var.J() && !n0Var.p.t && !j(j0Var) && !lmjxuqdtp.jvm.internal.o.c(j0Var.K(), Boolean.TRUE) && !i(j0Var) && !n0Var.p.x.f() && ((x0Var = n0Var.q) == null || (o0Var = x0Var.r) == null || !o0Var.f()))) {
            return false;
        }
        j0 j0Var2 = this.a;
        if (j0Var == j0Var2) {
            aVar = this.i;
            lmjxuqdtp.jvm.internal.o.e(aVar);
        } else {
            aVar = null;
        }
        if (z) {
            zC = n0Var.e ? c(j0Var, aVar) : false;
            if (z2 && ((zC || n0Var.f437f) && lmjxuqdtp.jvm.internal.o.c(j0Var.K(), Boolean.TRUE))) {
                j0Var.L();
            }
        } else {
            boolean zD = j0Var.q() ? d(j0Var, aVar) : false;
            if (z2 && j0Var.p() && (j0Var == j0Var2 || ((j0VarV = j0Var.v()) != null && j0VarV.J() && n0Var.p.t))) {
                if (j0Var == j0Var2) {
                    if (j0Var.B == h0.c) {
                        j0Var.f();
                    }
                    j0 j0VarV2 = j0Var.v();
                    if (j0VarV2 == null || (vVar = (v) j0VarV2.E.d) == null || (placementScope = vVar.l) == null) {
                        placementScope = m0.a(j0Var).getPlacementScope();
                    }
                    q4.l1.m(placementScope, n0Var.p, 0, 0);
                } else {
                    j0Var.U();
                }
                eu0.k kVar = this.e;
                kVar.getClass();
                if (j0Var.O > 0) {
                    ((k3.e) kVar.b).d(j0Var);
                    j0Var.N = true;
                }
                m0.a(j0Var).getRectManager().e(j0Var);
            }
            zC = zD;
        }
        e();
        return zC;
    }

    public final void o(j0 j0Var) {
        k3.e eVarZ = j0Var.z();
        Object[] objArr = eVarZ.a;
        int i = eVarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            j0 j0Var2 = (j0) objArr[i2];
            if (j0Var2.r() == h0.a || j0Var2.F.p.x.f()) {
                if (g.p(j0Var2)) {
                    p(j0Var2, true);
                } else {
                    o(j0Var2);
                }
            }
        }
    }

    public final void p(j0 j0Var, boolean z) {
        p5.a aVar;
        if (j0Var.P) {
            return;
        }
        if (j0Var == this.a) {
            aVar = this.i;
            lmjxuqdtp.jvm.internal.o.e(aVar);
        } else {
            aVar = null;
        }
        if (z) {
            c(j0Var, aVar);
        } else {
            d(j0Var, aVar);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final boolean q(j0 j0Var, boolean z) throws NoWhenBranchMatchedException {
        int iOrdinal = j0Var.F.d.ordinal();
        if (iOrdinal != 0 && iOrdinal != 1) {
            if (iOrdinal == 2 || iOrdinal == 3) {
                this.h.d(new y0(j0Var, false, z));
            } else {
                if (iOrdinal != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                if (!j0Var.q() || z) {
                    j0Var.F.p.u = true;
                    if (!j0Var.P && (j0Var.J() || j(j0Var))) {
                        j0 j0VarV = j0Var.v();
                        if (j0VarV == null || !j0VarV.q()) {
                            this.b.k(j0Var, w.c);
                        }
                        if (!this.d) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final void r(long j2) {
        p5.a aVar = this.i;
        if (aVar == null ? false : p5.a.b(aVar.a, j2)) {
            return;
        }
        if (this.c) {
            p4.a.a("updateRootConstraints called while measuring");
        }
        this.i = new p5.a(j2);
        j0 j0Var = this.a;
        j0 j0Var2 = j0Var.g;
        n0 n0Var = j0Var.F;
        if (j0Var2 != null) {
            n0Var.e = true;
        }
        n0Var.p.u = true;
        this.b.k(j0Var, j0Var2 != null ? w.a : w.c);
    }
}
