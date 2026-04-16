package s4;

import java.util.List;
import kotlin.jvm.internal.IntCompanionObject;
import lmjxuqdtp.KotlinNothingValueException;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function1;
import q4.m1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b1 extends m1 implements q4.t0, b, d1 {
    public boolean A;
    public float E;
    public boolean F;
    public Function1 G;
    public d4.c H;
    public float J;
    public boolean L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n0 f426f;
    public boolean g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f427j;
    public boolean k;
    public Function1 n;
    public d4.c o;
    public float p;
    public Object r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public int h = IntCompanionObject.MAX_VALUE;
    public int i = IntCompanionObject.MAX_VALUE;
    public h0 l = h0.c;
    public long m = 0;
    public boolean q = true;
    public final k0 x = new k0(this);
    public final k3.e y = new k3.e(0, new b1[16]);
    public boolean z = true;
    public long B = p5.b.b(0, 0, 15);
    public final a1 C = new a1(this, 1);
    public final a1 D = new a1(this, 0);
    public long I = 0;
    public final a1 K = new a1(this, 2);

    public b1(n0 n0Var) {
        this.f426f = n0Var;
    }

    public final List B0() {
        n0 n0Var = this.f426f;
        n0Var.a.j0();
        boolean z = this.z;
        k3.e eVar = this.y;
        if (!z) {
            return eVar.j();
        }
        j0 j0Var = n0Var.a;
        k3.e eVarZ = j0Var.z();
        Object[] objArr = eVarZ.a;
        int i = eVarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            j0 j0Var2 = (j0) objArr[i2];
            if (eVar.c <= i2) {
                eVar.d(j0Var2.F.p);
            } else {
                b1 b1Var = j0Var2.F.p;
                Object[] objArr2 = eVar.a;
                Object obj = objArr2[i2];
                objArr2[i2] = b1Var;
            }
        }
        eVar.p(j0Var.n().a.c, eVar.c);
        this.z = false;
        return eVar.j();
    }

    public final void D0() {
        boolean z = this.s;
        this.s = true;
        j0 j0Var = this.f426f.a;
        dl.c cVar = j0Var.E;
        if (!z) {
            ((v) cVar.d).v1();
            if (j0Var.q()) {
                j0.Y(j0Var, true, 6);
            } else if (j0Var.F.e) {
                j0.W(j0Var, true, 6);
            }
        }
        k1 k1Var = ((v) cVar.d).p;
        for (k1 k1Var2 = (k1) cVar.e; !lmjxuqdtp.jvm.internal.o.c(k1Var2, k1Var) && k1Var2 != null; k1Var2 = k1Var2.p) {
            if (k1Var2.H) {
                k1Var2.q1();
            }
        }
        k3.e eVarZ = j0Var.z();
        Object[] objArr = eVarZ.a;
        int i = eVarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            j0 j0Var2 = (j0) objArr[i2];
            if (j0Var2.w() != Integer.MAX_VALUE) {
                j0Var2.F.p.D0();
                j0.Z(j0Var2);
            }
        }
    }

    @Override // s4.b
    public final v G() {
        return (v) this.f426f.a.E.d;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final void G0() throws NoWhenBranchMatchedException, KotlinNothingValueException {
        if (this.s) {
            this.s = false;
            n0 n0Var = this.f426f;
            dl.c cVar = n0Var.a.E;
            k1 k1Var = ((v) cVar.d).p;
            for (k1 k1Var2 = (k1) cVar.e; !lmjxuqdtp.jvm.internal.o.c(k1Var2, k1Var) && k1Var2 != null; k1Var2 = k1Var2.p) {
                t3.o oVarL1 = k1Var2.l1(l1.h(1048576));
                if (oVarL1 != null && (oVarL1.getNode().getAggregateChildKindSet$ui_release() & 1048576) != 0) {
                    boolean zH = l1.h(1048576);
                    t3.o oVarJ1 = k1Var2.j1();
                    if (zH || (oVarJ1 = oVarJ1.getParent$ui_release()) != null) {
                        for (t3.o oVarL12 = k1Var2.l1(zH); oVarL12 != null && (oVarL12.getAggregateChildKindSet$ui_release() & 1048576) != 0; oVarL12 = oVarL12.getChild$ui_release()) {
                            if ((oVarL12.getKindSet$ui_release() & 1048576) != 0) {
                                t3.o oVarE = oVarL12;
                                k3.e eVar = null;
                                while (oVarE != null) {
                                    if ((oVarE.getKindSet$ui_release() & 1048576) != 0 && (oVarE instanceof o)) {
                                        int i = 0;
                                        for (t3.o child$ui_release = ((o) oVarE).b; child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                                            if ((child$ui_release.getKindSet$ui_release() & 1048576) != 0) {
                                                i++;
                                                if (i == 1) {
                                                    oVarE = child$ui_release;
                                                } else {
                                                    if (eVar == null) {
                                                        eVar = new k3.e(0, new t3.o[16]);
                                                    }
                                                    if (oVarE != null) {
                                                        eVar.d(oVarE);
                                                        oVarE = null;
                                                    }
                                                    eVar.d(child$ui_release);
                                                }
                                            }
                                        }
                                        if (i == 1) {
                                        }
                                    }
                                    oVarE = g.e(eVar);
                                }
                            }
                            if (oVarL12 != oVarJ1) {
                            }
                        }
                    }
                }
                k1Var2.B1();
            }
            k3.e eVarZ = n0Var.a.z();
            Object[] objArr = eVarZ.a;
            int i2 = eVarZ.c;
            for (int i3 = 0; i3 < i2; i3++) {
                ((j0) objArr[i3]).F.p.G0();
            }
        }
    }

    public final void I0() {
        n0 n0Var = this.f426f;
        if (n0Var.l > 0) {
            k3.e eVarZ = n0Var.a.z();
            Object[] objArr = eVarZ.a;
            int i = eVarZ.c;
            for (int i2 = 0; i2 < i; i2++) {
                j0 j0Var = (j0) objArr[i2];
                n0 n0Var2 = j0Var.F;
                boolean z = n0Var2.f438j;
                b1 b1Var = n0Var2.p;
                if ((z || n0Var2.k) && !b1Var.v) {
                    j0Var.X(false);
                }
                b1Var.I0();
            }
        }
    }

    public final void K0() {
        n0 n0Var = this.f426f;
        j0.Y(n0Var.a, false, 7);
        j0 j0Var = n0Var.a;
        j0 j0VarV = j0Var.v();
        if (j0VarV == null || j0Var.B != h0.c) {
            return;
        }
        int iOrdinal = j0VarV.F.d.ordinal();
        j0Var.B = iOrdinal != 0 ? iOrdinal != 2 ? j0VarV.B : h0.b : h0.a;
    }

    public final int M(int i) {
        n0 n0Var = this.f426f;
        if (!g.p(n0Var.a)) {
            K0();
            return n0Var.a().M(i);
        }
        x0 x0Var = n0Var.q;
        lmjxuqdtp.jvm.internal.o.e(x0Var);
        return x0Var.M(i);
    }

    public final void M0() {
        this.F = true;
        n0 n0Var = this.f426f;
        j0 j0VarV = n0Var.a.v();
        float f2 = G().A;
        j0 j0Var = n0Var.a;
        dl.c cVar = j0Var.E;
        k1 k1Var = (k1) cVar.e;
        v vVar = (v) cVar.d;
        while (k1Var != vVar) {
            lmjxuqdtp.jvm.internal.o.f(k1Var, "null cannot be cast to non-null type tlydtdl.compose.ui.node.LayoutModifierNodeCoordinator");
            c0 c0Var = (c0) k1Var;
            f2 += c0Var.A;
            k1Var = c0Var.p;
        }
        if (f2 != this.E) {
            this.E = f2;
            if (j0VarV != null) {
                j0VarV.P();
            }
            if (j0VarV != null) {
                j0VarV.C();
            }
        }
        if (this.s) {
            ((v) j0Var.E.d).v1();
        } else {
            if (j0VarV != null) {
                j0VarV.C();
            }
            D0();
            if (this.g && j0VarV != null) {
                j0VarV.X(false);
            }
        }
        if (j0VarV != null) {
            n0 n0Var2 = j0VarV.F;
            if (!this.g && n0Var2.d == f0.c) {
                if (this.i != Integer.MAX_VALUE) {
                    p4.a.b("Place was called on a node which was placed already");
                }
                int i = n0Var2.i;
                this.i = i;
                n0Var2.i = i + 1;
            }
        } else {
            this.i = 0;
        }
        r();
    }

    public final void N0(long j2) {
        n0 n0Var = this.f426f;
        f0 f0Var = n0Var.d;
        j0 j0Var = n0Var.a;
        f0 f0Var2 = f0.e;
        if (f0Var != f0Var2) {
            p4.a.b("layout state is not idle before measure starts");
        }
        this.B = j2;
        f0 f0Var3 = f0.a;
        n0Var.d = f0Var3;
        this.u = false;
        u1 snapshotObserver = m0.a(j0Var).getSnapshotObserver();
        snapshotObserver.a(j0Var, snapshotObserver.c, this.C);
        if (n0Var.d == f0Var3) {
            this.v = true;
            this.w = true;
            n0Var.d = f0Var2;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final void O0(long j2, float f2, Function1 function1, d4.c cVar) throws NoWhenBranchMatchedException, KotlinNothingValueException {
        n0 n0Var = this.f426f;
        j0 j0Var = n0Var.a;
        j0 j0Var2 = n0Var.a;
        if (j0Var.P) {
            p4.a.a("place is called on a deactivated node");
        }
        n0Var.d = f0.c;
        this.m = j2;
        this.p = f2;
        this.n = function1;
        this.o = cVar;
        this.F = false;
        t4.x xVarA = m0.a(j0Var2);
        if (this.v || !this.s) {
            this.x.e = false;
            n0Var.f(false);
            this.G = function1;
            this.I = j2;
            this.J = f2;
            this.H = cVar;
            u1 snapshotObserver = xVarA.getSnapshotObserver();
            snapshotObserver.a(j0Var2, snapshotObserver.f443f, this.K);
        } else {
            k1 k1VarA = n0Var.a();
            k1VarA.z1(p5.k.d(j2, ((m1) k1VarA).e), f2, function1, cVar);
            M0();
        }
        n0Var.d = f0.e;
        this.k = true;
    }

    public final void Q0(long j2, float f2, Function1 function1, d4.c cVar) throws Throwable {
        boolean z;
        q4.q0 placementScope;
        n0 n0Var = this.f426f;
        j0 j0Var = n0Var.a;
        j0 j0Var2 = n0Var.a;
        boolean z2 = true;
        try {
            this.t = true;
            if (!p5.k.b(j2, this.m) || this.L) {
                if (n0Var.k || n0Var.f438j || this.L) {
                    this.v = true;
                    this.L = false;
                }
                I0();
            }
            x0 x0Var = n0Var.q;
            if (x0Var != null) {
                n0 n0Var2 = x0Var.f445f;
                if (g.p(n0Var2.a)) {
                    z = true;
                } else {
                    if (x0Var.q == u0.c && !n0Var2.b) {
                        n0Var2.c = true;
                    }
                    z = n0Var2.c;
                }
                if (z) {
                    k1 k1Var = n0Var.a().q;
                    if (k1Var == null || (placementScope = k1Var.l) == null) {
                        placementScope = m0.a(j0Var2).getPlacementScope();
                    }
                    x0 x0Var2 = n0Var.q;
                    lmjxuqdtp.jvm.internal.o.e(x0Var2);
                    j0 j0VarV = j0Var2.v();
                    if (j0VarV != null) {
                        j0VarV.F.h = 0;
                    }
                    x0Var2.i = IntCompanionObject.MAX_VALUE;
                    q4.l1.i(placementScope, x0Var2, (int) (j2 >> 32), (int) (4294967295L & j2));
                }
            }
            x0 x0Var3 = n0Var.q;
            if (x0Var3 == null || x0Var3.k) {
                z2 = false;
            }
            if (z2) {
                p4.a.b("Error: Placement happened before lookahead.");
            }
            O0(j2, f2, function1, cVar);
        } catch (Throwable th) {
            j0Var.b0(th);
            throw null;
        }
    }

    public final int R(int i) {
        n0 n0Var = this.f426f;
        if (!g.p(n0Var.a)) {
            K0();
            return n0Var.a().R(i);
        }
        x0 x0Var = n0Var.q;
        lmjxuqdtp.jvm.internal.o.e(x0Var);
        return x0Var.R(i);
    }

    public final boolean R0(long j2) throws Throwable {
        n0 n0Var = this.f426f;
        j0 j0Var = n0Var.a;
        j0 j0Var2 = n0Var.a;
        try {
            if (j0Var.P) {
                p4.a.a("measure is called on a deactivated node");
            }
            t4.x xVarA = m0.a(j0Var2);
            j0 j0VarV = j0Var2.v();
            boolean z = true;
            j0Var2.D = j0Var2.D || (j0VarV != null && j0VarV.D);
            if (!j0Var2.q() && p5.a.b(((m1) this).d, j2)) {
                xVarA.O.g(j0Var2, false);
                j0Var2.a0();
                return false;
            }
            this.x.d = false;
            k3.e eVarZ = j0Var2.z();
            Object[] objArr = eVarZ.a;
            int i = eVarZ.c;
            for (int i2 = 0; i2 < i; i2++) {
                ((j0) objArr[i2]).F.p.x.getClass();
            }
            this.f427j = true;
            long j3 = ((m1) n0Var.a()).c;
            o0(j2);
            N0(j2);
            if (p5.m.a(((m1) n0Var.a()).c, j3) && ((m1) n0Var.a()).a == ((m1) this).a && ((m1) n0Var.a()).b == ((m1) this).b) {
                z = false;
            }
            m0((((long) ((m1) n0Var.a()).b) & 4294967295L) | (((long) ((m1) n0Var.a()).a) << 32));
            return z;
        } catch (Throwable th) {
            j0Var.b0(th);
            throw null;
        }
    }

    public final m1 T(long j2) throws Throwable {
        h0 h0Var;
        n0 n0Var = this.f426f;
        j0 j0Var = n0Var.a;
        h0 h0Var2 = j0Var.B;
        h0 h0Var3 = h0.c;
        if (h0Var2 == h0Var3) {
            j0Var.d();
        }
        if (g.p(n0Var.a)) {
            x0 x0Var = n0Var.q;
            lmjxuqdtp.jvm.internal.o.e(x0Var);
            x0Var.f446j = h0Var3;
            x0Var.T(j2);
        }
        j0 j0Var2 = n0Var.a;
        j0 j0VarV = j0Var2.v();
        if (j0VarV != null) {
            n0 n0Var2 = j0VarV.F;
            if (this.l != h0Var3 && !j0Var2.D) {
                p4.a.b("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()");
            }
            int iOrdinal = n0Var2.d.ordinal();
            if (iOrdinal == 0) {
                h0Var = h0.a;
            } else {
                if (iOrdinal != 2) {
                    throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + n0Var2.d);
                }
                h0Var = h0.b;
            }
            this.l = h0Var;
        } else {
            this.l = h0Var3;
        }
        R0(j2);
        return this;
    }

    @Override // s4.b
    public final void a0() {
        j0.Y(this.f426f.a, false, 7);
    }

    @Override // s4.b
    public final a b() {
        return this.x;
    }

    public final int b0() {
        return this.f426f.a().b0();
    }

    public final int c(int i) {
        n0 n0Var = this.f426f;
        if (!g.p(n0Var.a)) {
            K0();
            return n0Var.a().c(i);
        }
        x0 x0Var = n0Var.q;
        lmjxuqdtp.jvm.internal.o.e(x0Var);
        return x0Var.c(i);
    }

    public final int e0() {
        return this.f426f.a().e0();
    }

    @Override // s4.b
    public final b f() {
        n0 n0Var;
        j0 j0VarV = this.f426f.a.v();
        if (j0VarV == null || (n0Var = j0VarV.F) == null) {
            return null;
        }
        return n0Var.p;
    }

    @Override // s4.b
    public final void j(tlydtdl.fragment.app.q qVar) {
        k3.e eVarZ = this.f426f.a.z();
        Object[] objArr = eVarZ.a;
        int i = eVarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            qVar.invoke(((j0) objArr[i2]).F.p);
        }
    }

    public final void j0(long j2, float f2, d4.c cVar) throws Throwable {
        Q0(j2, f2, null, cVar);
    }

    public final void k0(long j2, float f2, Function1 function1) throws Throwable {
        Q0(j2, f2, function1, null);
    }

    public final Object l() {
        return this.r;
    }

    @Override // s4.d1
    public final void m(boolean z) {
        n0 n0Var = this.f426f;
        if (z != n0Var.a().i) {
            n0Var.a().i = z;
            this.L = true;
        }
    }

    @Override // s4.b
    public final void r() {
        this.A = true;
        k0 k0Var = this.x;
        k0Var.i();
        boolean z = this.v;
        n0 n0Var = this.f426f;
        if (z) {
            k3.e eVarZ = n0Var.a.z();
            Object[] objArr = eVarZ.a;
            int i = eVarZ.c;
            for (int i2 = 0; i2 < i; i2++) {
                j0 j0Var = (j0) objArr[i2];
                if (j0Var.q() && j0Var.r() == h0.a && j0.R(j0Var)) {
                    j0.Y(n0Var.a, false, 7);
                }
            }
        }
        if (this.w || (!G().k && this.v)) {
            this.v = false;
            f0 f0Var = n0Var.d;
            n0Var.d = f0.c;
            n0Var.g(false);
            j0 j0Var2 = n0Var.a;
            u1 snapshotObserver = m0.a(j0Var2).getSnapshotObserver();
            snapshotObserver.a(j0Var2, snapshotObserver.e, this.D);
            n0Var.d = f0Var;
            if (G().k && n0Var.f438j) {
                requestLayout();
            }
            this.w = false;
        }
        if (k0Var.b && k0Var.f()) {
            k0Var.h();
        }
        this.A = false;
    }

    @Override // s4.b
    public final void requestLayout() {
        this.f426f.a.X(false);
    }

    @Override // s4.b
    public final boolean u() {
        return this.s;
    }

    public final int z(int i) {
        n0 n0Var = this.f426f;
        if (!g.p(n0Var.a)) {
            K0();
            return n0Var.a().z(i);
        }
        x0 x0Var = n0Var.q;
        lmjxuqdtp.jvm.internal.o.e(x0Var);
        return x0Var.z(i);
    }
}
