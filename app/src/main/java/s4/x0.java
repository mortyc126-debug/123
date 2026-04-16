package s4;

import kotlin.jvm.internal.IntCompanionObject;
import lmjxuqdtp.jvm.functions.Function1;
import q4.m1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class x0 extends m1 implements q4.t0, b, d1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n0 f445f;
    public boolean g;
    public boolean k;
    public boolean l;
    public p5.a m;
    public Function1 o;
    public d4.c p;
    public boolean u;
    public Object w;
    public boolean x;
    public int h = IntCompanionObject.MAX_VALUE;
    public int i = IntCompanionObject.MAX_VALUE;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public h0 f446j = h0.c;
    public long n = 0;
    public u0 q = u0.c;
    public final o0 r = new o0(this);
    public final k3.e s = new k3.e(0, new x0[16]);
    public boolean t = true;
    public boolean v = true;

    public x0(n0 n0Var) {
        this.f445f = n0Var;
        this.w = n0Var.p.r;
    }

    public final void B0(boolean z) {
        n0 n0Var = this.f445f;
        if (z && n0Var.c) {
            return;
        }
        if (z || n0Var.c) {
            this.q = u0.c;
            k3.e eVarZ = n0Var.a.z();
            Object[] objArr = eVarZ.a;
            int i = eVarZ.c;
            for (int i2 = 0; i2 < i; i2++) {
                x0 x0Var = ((j0) objArr[i2]).F.q;
                lmjxuqdtp.jvm.internal.o.e(x0Var);
                x0Var.B0(true);
            }
        }
    }

    public final void D0() {
        u0 u0Var = this.q;
        n0 n0Var = this.f445f;
        boolean z = n0Var.c;
        j0 j0Var = n0Var.a;
        if (z) {
            this.q = u0.b;
        } else {
            this.q = u0.a;
        }
        if (u0Var != u0.a && n0Var.e) {
            j0.W(j0Var, true, 6);
        }
        k3.e eVarZ = j0Var.z();
        Object[] objArr = eVarZ.a;
        int i = eVarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            j0 j0Var2 = (j0) objArr[i2];
            x0 x0Var = j0Var2.F.q;
            if (x0Var == null) {
                throw new IllegalArgumentException("Error: Child node's lookahead pass delegate cannot be null when in a lookahead scope.");
            }
            if (x0Var.i != Integer.MAX_VALUE) {
                x0Var.D0();
                j0.Z(j0Var2);
            }
        }
    }

    @Override // s4.b
    public final v G() {
        return (v) this.f445f.a.E.d;
    }

    public final void G0() {
        n0 n0Var = this.f445f;
        if (n0Var.o > 0) {
            k3.e eVarZ = n0Var.a.z();
            Object[] objArr = eVarZ.a;
            int i = eVarZ.c;
            for (int i2 = 0; i2 < i; i2++) {
                j0 j0Var = (j0) objArr[i2];
                n0 n0Var2 = j0Var.F;
                if ((n0Var2.m || n0Var2.n) && !n0Var2.f437f) {
                    j0Var.V(false);
                }
                x0 x0Var = n0Var2.q;
                if (x0Var != null) {
                    x0Var.G0();
                }
            }
        }
    }

    public final void I0() {
        n0 n0Var = this.f445f;
        j0.W(n0Var.a, false, 7);
        j0 j0Var = n0Var.a;
        j0 j0VarV = j0Var.v();
        if (j0VarV == null || j0Var.B != h0.c) {
            return;
        }
        int iOrdinal = j0VarV.F.d.ordinal();
        j0Var.B = iOrdinal != 0 ? iOrdinal != 2 ? j0VarV.B : h0.b : h0.a;
    }

    public final void K0() {
        f0 f0Var;
        this.x = true;
        n0 n0Var = this.f445f;
        j0 j0VarV = n0Var.a.v();
        u0 u0Var = this.q;
        if ((u0Var != u0.a && !n0Var.c) || (u0Var != u0.b && n0Var.c)) {
            D0();
            if (this.g && j0VarV != null) {
                j0VarV.V(false);
            }
        }
        if (j0VarV != null) {
            n0 n0Var2 = j0VarV.F;
            if (!this.g && ((f0Var = n0Var2.d) == f0.c || f0Var == f0.d)) {
                if (this.i != Integer.MAX_VALUE) {
                    p4.a.b("Place was called on a node which was placed already");
                }
                int i = n0Var2.h;
                this.i = i;
                n0Var2.h = i + 1;
            }
        } else {
            this.i = 0;
        }
        r();
    }

    public final int M(int i) {
        I0();
        t0 t0VarH1 = this.f445f.a().h1();
        lmjxuqdtp.jvm.internal.o.e(t0VarH1);
        return t0VarH1.M(i);
    }

    public final void M0(long j2, Function1 function1, d4.c cVar) throws Throwable {
        n0 n0Var = this.f445f;
        j0 j0Var = n0Var.a;
        j0 j0Var2 = n0Var.a;
        try {
            j0 j0VarV = j0Var.v();
            f0 f0Var = j0VarV != null ? j0VarV.F.d : null;
            f0 f0Var2 = f0.d;
            if (f0Var == f0Var2) {
                n0Var.c = false;
            }
            if (j0Var2.P) {
                p4.a.a("place is called on a deactivated node");
            }
            n0Var.d = f0Var2;
            this.k = true;
            this.x = false;
            if (!p5.k.b(j2, this.n)) {
                if (n0Var.n || n0Var.m) {
                    n0Var.f437f = true;
                }
                G0();
            }
            t4.x xVarA = m0.a(j0Var2);
            if (n0Var.f437f || !u()) {
                n0Var.h(false);
                this.r.e = false;
                u1 snapshotObserver = xVarA.getSnapshotObserver();
                w0 w0Var = new w0(this, xVarA, j2);
                snapshotObserver.getClass();
                if (j0Var2.g != null) {
                    snapshotObserver.a(j0Var2, snapshotObserver.g, w0Var);
                } else {
                    snapshotObserver.a(j0Var2, snapshotObserver.f443f, w0Var);
                }
            } else {
                t0 t0VarH1 = n0Var.a().h1();
                lmjxuqdtp.jvm.internal.o.e(t0VarH1);
                t0VarH1.a1(p5.k.d(j2, ((m1) t0VarH1).e));
                K0();
            }
            this.n = j2;
            this.o = function1;
            this.p = cVar;
            n0Var.d = f0.e;
        } catch (Throwable th) {
            j0Var.b0(th);
            throw null;
        }
    }

    public final boolean N0(long j2) {
        long j3;
        n0 n0Var = this.f445f;
        j0 j0Var = n0Var.a;
        j0 j0Var2 = n0Var.a;
        try {
            if (j0Var.P) {
                p4.a.a("measure is called on a deactivated node");
            }
            j0 j0VarV = j0Var2.v();
            j0Var2.D = j0Var2.D || (j0VarV != null && j0VarV.D);
            if (!j0Var2.F.e) {
                p5.a aVar = this.m;
                if (aVar == null ? false : p5.a.b(aVar.a, j2)) {
                    t4.x xVar = j0Var2.m;
                    if (xVar != null) {
                        xVar.O.g(j0Var2, true);
                    }
                    j0Var2.a0();
                    return false;
                }
            }
            this.m = new p5.a(j2);
            o0(j2);
            this.r.d = false;
            k3.e eVarZ = j0Var2.z();
            Object[] objArr = eVarZ.a;
            int i = eVarZ.c;
            for (int i2 = 0; i2 < i; i2++) {
                x0 x0Var = ((j0) objArr[i2]).F.q;
                lmjxuqdtp.jvm.internal.o.e(x0Var);
                x0Var.r.getClass();
            }
            if (this.l) {
                j3 = ((m1) this).c;
            } else {
                long j4 = IntCompanionObject.MIN_VALUE;
                j3 = (j4 & 4294967295L) | (j4 << 32);
            }
            this.l = true;
            t0 t0VarH1 = n0Var.a().h1();
            if (!(t0VarH1 != null)) {
                p4.a.b("Lookahead result from lookaheadRemeasure cannot be null");
            }
            n0Var.c(j2);
            m0((((long) ((m1) t0VarH1).b) & 4294967295L) | (((long) ((m1) t0VarH1).a) << 32));
            return (((int) (j3 >> 32)) == ((m1) t0VarH1).a && ((int) (j3 & 4294967295L)) == ((m1) t0VarH1).b) ? false : true;
        } catch (Throwable th) {
            j0Var.b0(th);
            throw null;
        }
    }

    public final int R(int i) {
        I0();
        t0 t0VarH1 = this.f445f.a().h1();
        lmjxuqdtp.jvm.internal.o.e(t0VarH1);
        return t0VarH1.R(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final q4.m1 T(long r6) {
        /*
            r5 = this;
            s4.n0 r0 = r5.f445f
            s4.j0 r1 = r0.a
            s4.j0 r1 = r1.v()
            r2 = 0
            if (r1 == 0) goto L10
            s4.n0 r1 = r1.F
            s4.f0 r1 = r1.d
            goto L11
        L10:
            r1 = r2
        L11:
            s4.f0 r3 = s4.f0.b
            if (r1 == r3) goto L25
            s4.j0 r1 = r0.a
            s4.j0 r1 = r1.v()
            if (r1 == 0) goto L21
            s4.n0 r1 = r1.F
            s4.f0 r2 = r1.d
        L21:
            s4.f0 r1 = s4.f0.d
            if (r2 != r1) goto L28
        L25:
            r1 = 0
            r0.b = r1
        L28:
            s4.j0 r1 = r0.a
            s4.j0 r2 = r1.v()
            if (r2 == 0) goto L72
            s4.n0 r2 = r2.F
            s4.h0 r3 = r5.f446j
            s4.h0 r4 = s4.h0.c
            if (r3 == r4) goto L42
            boolean r1 = r1.D
            if (r1 == 0) goto L3d
            goto L42
        L3d:
            java.lang.String r1 = "measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()"
            p4.a.b(r1)
        L42:
            s4.f0 r1 = r2.d
            int r1 = r1.ordinal()
            if (r1 == 0) goto L6d
            r3 = 1
            if (r1 == r3) goto L6d
            r3 = 2
            if (r1 == r3) goto L6a
            r3 = 3
            if (r1 != r3) goto L54
            goto L6a
        L54:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "Measurable could be only measured from the parent's measure or layout block. Parents state is "
            r7.<init>(r0)
            s4.f0 r0 = r2.d
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L6a:
            s4.h0 r1 = s4.h0.b
            goto L6f
        L6d:
            s4.h0 r1 = s4.h0.a
        L6f:
            r5.f446j = r1
            goto L76
        L72:
            s4.h0 r1 = s4.h0.c
            r5.f446j = r1
        L76:
            s4.j0 r0 = r0.a
            s4.h0 r1 = r0.B
            s4.h0 r2 = s4.h0.c
            if (r1 != r2) goto L81
            r0.d()
        L81:
            r5.N0(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: s4.x0.T(long):q4.m1");
    }

    @Override // s4.b
    public final void a0() {
        j0.W(this.f445f.a, false, 7);
    }

    @Override // s4.b
    public final a b() {
        return this.r;
    }

    public final int b0() {
        t0 t0VarH1 = this.f445f.a().h1();
        lmjxuqdtp.jvm.internal.o.e(t0VarH1);
        return t0VarH1.b0();
    }

    public final int c(int i) {
        I0();
        t0 t0VarH1 = this.f445f.a().h1();
        lmjxuqdtp.jvm.internal.o.e(t0VarH1);
        return t0VarH1.c(i);
    }

    public final int e0() {
        t0 t0VarH1 = this.f445f.a().h1();
        lmjxuqdtp.jvm.internal.o.e(t0VarH1);
        return t0VarH1.e0();
    }

    @Override // s4.b
    public final b f() {
        n0 n0Var;
        j0 j0VarV = this.f445f.a.v();
        if (j0VarV == null || (n0Var = j0VarV.F) == null) {
            return null;
        }
        return n0Var.q;
    }

    @Override // s4.b
    public final void j(tlydtdl.fragment.app.q qVar) {
        k3.e eVarZ = this.f445f.a.z();
        Object[] objArr = eVarZ.a;
        int i = eVarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            x0 x0Var = ((j0) objArr[i2]).F.q;
            lmjxuqdtp.jvm.internal.o.e(x0Var);
            qVar.invoke(x0Var);
        }
    }

    public final void j0(long j2, float f2, d4.c cVar) throws Throwable {
        M0(j2, null, cVar);
    }

    public final void k0(long j2, float f2, Function1 function1) throws Throwable {
        M0(j2, function1, null);
    }

    public final Object l() {
        return this.w;
    }

    @Override // s4.d1
    public final void m(boolean z) {
        t0 t0VarH1;
        n0 n0Var = this.f445f;
        t0 t0VarH12 = n0Var.a().h1();
        if (Boolean.valueOf(z).equals(t0VarH12 != null ? Boolean.valueOf(t0VarH12.i) : null) || (t0VarH1 = n0Var.a().h1()) == null) {
            return;
        }
        t0VarH1.i = z;
    }

    @Override // s4.b
    public final void r() {
        this.u = true;
        o0 o0Var = this.r;
        o0Var.i();
        n0 n0Var = this.f445f;
        boolean z = n0Var.f437f;
        j0 j0Var = n0Var.a;
        if (z) {
            k3.e eVarZ = j0Var.z();
            Object[] objArr = eVarZ.a;
            int i = eVarZ.c;
            for (int i2 = 0; i2 < i; i2++) {
                j0 j0Var2 = (j0) objArr[i2];
                n0 n0Var2 = j0Var2.F;
                if (n0Var2.e && j0Var2.s() == h0.a) {
                    x0 x0Var = n0Var2.q;
                    lmjxuqdtp.jvm.internal.o.e(x0Var);
                    x0 x0Var2 = n0Var2.q;
                    p5.a aVar = x0Var2 != null ? x0Var2.m : null;
                    lmjxuqdtp.jvm.internal.o.e(aVar);
                    if (x0Var.N0(aVar.a)) {
                        j0.W(j0Var, false, 7);
                    }
                }
            }
        }
        u uVar = G().Q;
        lmjxuqdtp.jvm.internal.o.e(uVar);
        if (n0Var.g || (!uVar.k && n0Var.f437f)) {
            n0Var.f437f = false;
            f0 f0Var = n0Var.d;
            n0Var.d = f0.d;
            t4.x xVarA = m0.a(j0Var);
            n0Var.i(false);
            u1 snapshotObserver = xVarA.getSnapshotObserver();
            kg.t tVar = new kg.t(3, this, uVar);
            snapshotObserver.getClass();
            if (j0Var.g != null) {
                snapshotObserver.a(j0Var, snapshotObserver.h, tVar);
            } else {
                snapshotObserver.a(j0Var, snapshotObserver.e, tVar);
            }
            n0Var.d = f0Var;
            if (n0Var.m && uVar.k) {
                requestLayout();
            }
            n0Var.g = false;
        }
        if (o0Var.b && o0Var.f()) {
            o0Var.h();
        }
        this.u = false;
    }

    @Override // s4.b
    public final void requestLayout() {
        this.f445f.a.V(false);
    }

    @Override // s4.b
    public final boolean u() {
        return this.q != u0.c;
    }

    public final int z(int i) {
        I0();
        t0 t0VarH1 = this.f445f.a().h1();
        lmjxuqdtp.jvm.internal.o.e(t0VarH1);
        return t0VarH1.z(i);
    }
}
