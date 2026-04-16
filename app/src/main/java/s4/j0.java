package s4;

import java.util.List;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.time.DurationKt;
import lmjxuqdtp.KotlinNothingValueException;
import lmjxuqdtp.NoWhenBranchMatchedException;
import q4.m1;
import q4.u0;
import t4.b3;
import tlydtdl.compose.runtime.g3;
import tlydtdl.compose.ui.node.Owner;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j0 implements tlydtdl.compose.runtime.j, t1, l {
    public static final e0 Q = new e0("Undefined intrinsics block and it is required");
    public static final d0 R = new d0();
    public static final tlydtdl.compose.foundation.lazy.layout.a S = new tlydtdl.compose.foundation.lazy.layout.a(14);
    public tlydtdl.compose.runtime.c0 A;
    public h0 B;
    public h0 C;
    public boolean D;
    public final dl.c E;
    public final n0 F;
    public q4.p0 G;
    public k1 H;
    public boolean I;
    public t3.p J;
    public t3.p K;
    public s5.d L;
    public m4.b0 M;
    public boolean N;
    public int O;
    public boolean P;
    public final boolean a;
    public int b;
    public long c;
    public long d;
    public long e;

    /* JADX INFO: renamed from: f */
    public boolean f433f;
    public j0 g;
    public int h;
    public final i11.c i;

    /* JADX INFO: renamed from: j */
    public k3.e f434j;
    public boolean k;
    public j0 l;
    public Owner m;
    public s5.v n;
    public int o;
    public boolean p;
    public boolean q;
    public a5.k r;
    public boolean s;
    public final k3.e t;
    public boolean u;
    public u0 v;
    public r7.a w;
    public p5.c x;
    public p5.n y;
    public b3 z;

    public j0(int i) {
        this((i & 1) == 0, a5.m.a.addAndGet(1));
    }

    public static boolean R(j0 j0Var) {
        b1 b1Var = j0Var.F.p;
        return j0Var.Q(b1Var.f427j ? new p5.a(((m1) b1Var).d) : null);
    }

    public static void W(j0 j0Var, boolean z, int i) {
        j0 j0VarV;
        if ((i & 1) != 0) {
            z = false;
        }
        boolean z2 = (i & 2) != 0;
        boolean z3 = (i & 4) != 0;
        if (j0Var.g == null) {
            p4.a.b("Lookahead measure cannot be requested on a node that is not a part of the LookaheadScope");
        }
        t4.x xVar = j0Var.m;
        if (xVar == null || j0Var.p || j0Var.a) {
            return;
        }
        xVar.v(j0Var, true, z, z2);
        if (z3) {
            x0 x0Var = j0Var.F.q;
            lmjxuqdtp.jvm.internal.o.e(x0Var);
            n0 n0Var = x0Var.f445f;
            j0 j0VarV2 = n0Var.a.v();
            h0 h0Var = n0Var.a.B;
            if (j0VarV2 == null || h0Var == h0.c) {
                return;
            }
            while (j0VarV2.B == h0Var && (j0VarV = j0VarV2.v()) != null) {
                j0VarV2 = j0VarV;
            }
            int iOrdinal = h0Var.ordinal();
            if (iOrdinal == 0) {
                if (j0VarV2.g != null) {
                    W(j0VarV2, z, 6);
                    return;
                } else {
                    Y(j0VarV2, z, 6);
                    return;
                }
            }
            if (iOrdinal != 1) {
                throw new IllegalStateException("Intrinsics isn't used by the parent");
            }
            if (j0VarV2.g != null) {
                j0VarV2.V(z);
            } else {
                j0VarV2.X(z);
            }
        }
    }

    public static void Y(j0 j0Var, boolean z, int i) {
        t4.x xVar;
        j0 j0VarV;
        if ((i & 1) != 0) {
            z = false;
        }
        boolean z2 = (i & 2) != 0;
        boolean z3 = (i & 4) != 0;
        if (j0Var.p || j0Var.a || (xVar = j0Var.m) == null) {
            return;
        }
        xVar.v(j0Var, false, z, z2);
        if (z3) {
            n0 n0Var = j0Var.F.p.f426f;
            j0 j0VarV2 = n0Var.a.v();
            h0 h0Var = n0Var.a.B;
            if (j0VarV2 == null || h0Var == h0.c) {
                return;
            }
            while (j0VarV2.B == h0Var && (j0VarV = j0VarV2.v()) != null) {
                j0VarV2 = j0VarV;
            }
            int iOrdinal = h0Var.ordinal();
            if (iOrdinal == 0) {
                Y(j0VarV2, z, 6);
            } else {
                if (iOrdinal != 1) {
                    throw new IllegalStateException("Intrinsics isn't used by the parent");
                }
                j0VarV2.X(z);
            }
        }
    }

    public static void Z(j0 j0Var) {
        n0 n0Var = j0Var.F;
        if (i0.$EnumSwitchMapping$0[n0Var.d.ordinal()] != 1) {
            throw new IllegalStateException("Unexpected state " + n0Var.d);
        }
        if (n0Var.e) {
            W(j0Var, true, 6);
            return;
        }
        if (n0Var.f437f) {
            j0Var.V(true);
        }
        if (j0Var.q()) {
            Y(j0Var, true, 6);
        } else if (j0Var.p()) {
            j0Var.X(true);
        }
    }

    private final String j(j0 j0Var) {
        StringBuilder sb = new StringBuilder("Cannot insert ");
        sb.append(j0Var);
        sb.append(" because it already has a parent or an owner. This tree: ");
        sb.append(g(0));
        sb.append(" Other tree: ");
        j0 j0Var2 = j0Var.l;
        sb.append(j0Var2 != null ? j0Var2.g(0) : null);
        return sb.toString();
    }

    public final void A(long j2, t tVar, int i, boolean z) {
        dl.c cVar = this.E;
        k1 k1Var = (k1) cVar.e;
        a4.x0 x0Var = k1.K;
        ((k1) cVar.e).o1(k1.N, k1Var.g1(j2), tVar, i, z);
    }

    public final void B(int i, j0 j0Var) throws KotlinNothingValueException {
        if (j0Var.l != null && j0Var.m != null) {
            p4.a.b(j(j0Var));
        }
        j0Var.l = this;
        i11.c cVar = this.i;
        ((k3.e) cVar.b).b(i, j0Var);
        ((b5.b) cVar.c).invoke();
        P();
        if (j0Var.a) {
            this.h++;
        }
        H();
        Owner owner = this.m;
        if (owner != null) {
            j0Var.c(owner);
        }
        if (j0Var.F.l > 0) {
            n0 n0Var = this.F;
            n0Var.d(n0Var.l + 1);
        }
        if (j0Var.O > 0) {
            e0(this.O + 1);
        }
    }

    public final void C() {
        if (this.I) {
            dl.c cVar = this.E;
            k1 k1Var = (v) cVar.d;
            k1 k1Var2 = ((k1) cVar.e).q;
            this.H = null;
            while (true) {
                if (lmjxuqdtp.jvm.internal.o.c(k1Var, k1Var2)) {
                    break;
                }
                if ((k1Var != null ? k1Var.I : null) != null) {
                    this.H = k1Var;
                    break;
                }
                k1Var = k1Var != null ? k1Var.q : null;
            }
        }
        k1 k1Var3 = this.H;
        if (k1Var3 != null && k1Var3.I == null) {
            throw s1.a.q("layer was not set");
        }
        if (k1Var3 != null) {
            k1Var3.q1();
            return;
        }
        j0 j0VarV = v();
        if (j0VarV != null) {
            j0VarV.C();
        }
    }

    public final void D() {
        dl.c cVar = this.E;
        k1 k1Var = (k1) cVar.e;
        v vVar = (v) cVar.d;
        while (k1Var != vVar) {
            lmjxuqdtp.jvm.internal.o.f(k1Var, "null cannot be cast to non-null type tlydtdl.compose.ui.node.LayoutModifierNodeCoordinator");
            c0 c0Var = (c0) k1Var;
            s1 s1Var = c0Var.I;
            if (s1Var != null) {
                s1Var.invalidate();
            }
            k1Var = c0Var.p;
        }
        s1 s1Var2 = ((v) cVar.d).I;
        if (s1Var2 != null) {
            s1Var2.invalidate();
        }
    }

    public final void E() {
        if (this.a) {
            j0 j0VarV = v();
            if (j0VarV != null) {
                j0VarV.E();
                return;
            }
            return;
        }
        if (this.g != null) {
            W(this, false, 7);
        } else {
            Y(this, false, 7);
        }
    }

    public final void F() {
        if (p5.k.b(this.c, 9223372034707292159L)) {
            return;
        }
        this.c = 9223372034707292159L;
        k3.e eVarZ = z();
        Object[] objArr = eVarZ.a;
        int i = eVarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            ((j0) objArr[i2]).F();
        }
    }

    public final void G() {
        if (this.s) {
            return;
        }
        if (((f1) this.E.c).getChild$ui_release() != null || this.K != null) {
            this.q = true;
            return;
        }
        a5.k kVar = this.r;
        this.s = true;
        lmjxuqdtp.jvm.internal.c0 c0Var = new lmjxuqdtp.jvm.internal.c0();
        c0Var.a = new a5.k();
        u1 snapshotObserver = m0.a(this).getSnapshotObserver();
        snapshotObserver.a(this, snapshotObserver.d, new ig.e(9, this, c0Var));
        this.s = false;
        this.r = (a5.k) c0Var.a;
        this.q = false;
        t4.x xVarA = m0.a(this);
        xVarA.getSemanticsOwner().b(this, kVar);
        xVarA.x();
    }

    public final void H() {
        j0 j0Var;
        if (this.h > 0) {
            this.k = true;
        }
        if (!this.a || (j0Var = this.l) == null) {
            return;
        }
        j0Var.H();
    }

    public final boolean I() {
        return this.m != null;
    }

    public final boolean J() {
        return this.F.p.s;
    }

    public final Boolean K() {
        x0 x0Var = this.F.q;
        if (x0Var != null) {
            return Boolean.valueOf(x0Var.u());
        }
        return null;
    }

    public final void L() {
        j0 j0VarV;
        if (this.B == h0.c) {
            f();
        }
        x0 x0Var = this.F.q;
        lmjxuqdtp.jvm.internal.o.e(x0Var);
        try {
            x0Var.g = true;
            if (!x0Var.k) {
                p4.a.b("replace() called on item that was not placed");
            }
            x0Var.x = false;
            boolean zU = x0Var.u();
            x0Var.M0(x0Var.n, x0Var.o, x0Var.p);
            if (zU && !x0Var.x && (j0VarV = x0Var.f445f.a.v()) != null) {
                j0VarV.V(false);
            }
            x0Var.g = false;
        } catch (Throwable th) {
            x0Var.g = false;
            throw th;
        }
    }

    public final void M(int i, int i2, int i3) {
        if (i == i2) {
            return;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            int i6 = i > i2 ? i + i4 : i;
            int i7 = i > i2 ? i2 + i4 : (i2 + i3) - 2;
            i11.c cVar = this.i;
            k3.e eVar = (k3.e) cVar.b;
            b5.b bVar = (b5.b) cVar.c;
            Object objO = eVar.o(i6);
            bVar.invoke();
            ((k3.e) cVar.b).b(i7, (j0) objO);
            bVar.invoke();
        }
        P();
        H();
        E();
    }

    public final void N(j0 j0Var) throws NoWhenBranchMatchedException, KotlinNothingValueException {
        if (j0Var.F.l > 0) {
            this.F.d(r0.l - 1);
        }
        if (this.m != null) {
            j0Var.h();
        }
        j0Var.l = null;
        if (j0Var.O > 0) {
            e0(this.O - 1);
        }
        ((k1) j0Var.E.e).q = null;
        if (j0Var.a) {
            this.h--;
            k3.e eVar = (k3.e) j0Var.i.b;
            Object[] objArr = eVar.a;
            int i = eVar.c;
            for (int i2 = 0; i2 < i; i2++) {
                ((k1) ((j0) objArr[i2]).E.e).q = null;
            }
        }
        H();
        P();
    }

    public final void O() {
        this.f433f = true;
        k3.e eVarZ = z();
        Object[] objArr = eVarZ.a;
        int i = eVarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            ((j0) objArr[i2]).F();
        }
    }

    public final void P() {
        if (!this.a) {
            this.u = true;
            return;
        }
        j0 j0VarV = v();
        if (j0VarV != null) {
            j0VarV.P();
        }
    }

    public final boolean Q(p5.a aVar) {
        if (aVar == null) {
            return false;
        }
        if (this.B == h0.c) {
            d();
        }
        return this.F.p.R0(aVar.a);
    }

    public final void S() throws NoWhenBranchMatchedException, KotlinNothingValueException {
        i11.c cVar = this.i;
        k3.e eVar = (k3.e) cVar.b;
        k3.e eVar2 = (k3.e) cVar.b;
        int i = eVar.c;
        while (true) {
            i--;
            if (-1 >= i) {
                eVar2.k();
                ((b5.b) cVar.c).invoke();
                return;
            }
            N((j0) eVar2.a[i]);
        }
    }

    public final void T(int i, int i2) throws NoWhenBranchMatchedException, KotlinNothingValueException {
        if (i2 < 0) {
            p4.a.a("count (" + i2 + ") must be greater than 0");
        }
        int i3 = (i2 + i) - 1;
        if (i > i3) {
            return;
        }
        while (true) {
            i11.c cVar = this.i;
            N((j0) ((k3.e) cVar.b).a[i3]);
            Object objO = ((k3.e) cVar.b).o(i3);
            ((b5.b) cVar.c).invoke();
            if (i3 == i) {
                return;
            } else {
                i3--;
            }
        }
    }

    public final void U() {
        j0 j0VarV;
        if (this.B == h0.c) {
            f();
        }
        b1 b1Var = this.F.p;
        n0 n0Var = b1Var.f426f;
        try {
            b1Var.g = true;
            if (!b1Var.k) {
                p4.a.b("replace called on unplaced item");
            }
            boolean z = b1Var.s;
            b1Var.O0(b1Var.m, b1Var.p, b1Var.n, b1Var.o);
            if (z && !b1Var.F && (j0VarV = n0Var.a.v()) != null) {
                j0VarV.X(false);
            }
        } finally {
        }
    }

    public final void V(boolean z) {
        t4.x xVar;
        if (this.a || (xVar = this.m) == null) {
            return;
        }
        xVar.w(this, true, z);
    }

    public final void X(boolean z) {
        t4.x xVar;
        if (this.a || (xVar = this.m) == null) {
            return;
        }
        xVar.w(this, false, z);
    }

    @Override // tlydtdl.compose.runtime.j
    public final void a() {
        s5.v vVar = this.n;
        if (vVar != null) {
            vVar.a();
        }
        q4.p0 p0Var = this.G;
        if (p0Var != null) {
            p0Var.f(true);
        }
        this.P = true;
        t3.o parent$ui_release = (d2) this.E.f89f;
        for (t3.o parent$ui_release2 = parent$ui_release; parent$ui_release2 != null; parent$ui_release2 = parent$ui_release2.getParent$ui_release()) {
            if (parent$ui_release2.isAttached()) {
                parent$ui_release2.reset$ui_release();
            }
        }
        for (t3.o parent$ui_release3 = parent$ui_release; parent$ui_release3 != null; parent$ui_release3 = parent$ui_release3.getParent$ui_release()) {
            if (parent$ui_release3.isAttached()) {
                parent$ui_release3.runDetachLifecycle$ui_release();
            }
        }
        while (parent$ui_release != null) {
            if (parent$ui_release.isAttached()) {
                parent$ui_release.markAsDetached$ui_release();
            }
            parent$ui_release = parent$ui_release.getParent$ui_release();
        }
        if (I()) {
            this.r = null;
            this.q = false;
        }
        t4.x xVar = this.m;
        if (xVar != null) {
            t4.x xVar2 = xVar;
            xVar2.getRectManager().j(this);
            u3.c cVar = xVar2.F;
            if (cVar == null || !cVar.h.e(this.b)) {
                return;
            }
            cVar.a.F(cVar.c, this.b, false);
        }
    }

    public final void a0() {
        k3.e eVarZ = z();
        Object[] objArr = eVarZ.a;
        int i = eVarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            j0 j0Var = (j0) objArr[i2];
            h0 h0Var = j0Var.C;
            j0Var.B = h0Var;
            if (h0Var != h0.c) {
                j0Var.a0();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3, types: [int] */
    /* JADX WARN: Type inference failed for: r13v5 */
    public final void b(t3.p pVar) throws KotlinNothingValueException {
        t3.o oVar;
        boolean z;
        t3.o oVar2;
        dl.c cVar;
        f1 f1Var;
        k3.e eVar;
        boolean z2;
        dl.c cVar2;
        char c;
        a4.b1 b1Var;
        dl.c cVar3 = this.E;
        boolean zP = cVar3.p(16);
        t3.o oVar3 = (d2) cVar3.f89f;
        boolean zP2 = cVar3.p(1024);
        this.J = pVar;
        v vVar = (v) cVar3.d;
        j0 j0Var = (j0) cVar3.b;
        t3.o oVar4 = (t3.o) cVar3.g;
        f1 f1Var2 = (f1) cVar3.c;
        if (oVar4 == f1Var2) {
            p4.a.b("padChain called on already padded chain");
        }
        t3.o oVar5 = (t3.o) cVar3.g;
        oVar5.setParent$ui_release(f1Var2);
        f1Var2.setChild$ui_release(oVar5);
        t3.o eVar2 = (k3.e) cVar3.h;
        int i = eVar2 != null ? ((k3.e) eVar2).c : 0;
        k3.e eVar3 = (k3.e) cVar3.i;
        if (eVar3 == null) {
            eVar3 = new k3.e(0, new t3.n[16]);
        }
        k3.e eVar4 = (k3.e) cVar3.f90j;
        eVar4.d(pVar);
        a4.b1 b1Var2 = null;
        while (true) {
            int i2 = eVar4.c;
            if (i2 == 0) {
                break;
            }
            t3.j jVar = (t3.p) eVar4.o(i2 - 1);
            if (jVar instanceof t3.j) {
                t3.j jVar2 = jVar;
                eVar4.d(jVar2.b);
                eVar4.d(jVar2.a);
            } else if (jVar instanceof t3.n) {
                eVar3.d(jVar);
            } else {
                if (b1Var2 == null) {
                    b1Var = new a4.b1(19, eVar3);
                    b1Var2 = b1Var;
                } else {
                    b1Var = b1Var2;
                }
                jVar.all(b1Var);
            }
        }
        int i3 = eVar3.c;
        if (i3 == i) {
            t3.o child$ui_release = f1Var2.getChild$ui_release();
            dl.c cVar4 = cVar3;
            int i4 = 0;
            while (child$ui_release != null && i4 < i) {
                if (eVar2 == null) {
                    throw s1.a.q("expected prior modifier list to be non-empty");
                }
                t3.n nVar = (t3.n) ((k3.e) eVar2).a[i4];
                t3.n nVar2 = (t3.n) eVar3.a[i4];
                if (lmjxuqdtp.jvm.internal.o.c(nVar, nVar2)) {
                    cVar2 = cVar4;
                    c = 2;
                } else {
                    cVar2 = cVar4;
                    c = nVar.getClass() == nVar2.getClass() ? (char) 1 : (char) 0;
                }
                if (c == 0) {
                    child$ui_release = child$ui_release.getParent$ui_release();
                    break;
                }
                if (c == 1) {
                    dl.c.u(nVar, nVar2, child$ui_release);
                }
                child$ui_release = child$ui_release.getChild$ui_release();
                i4++;
                cVar4 = cVar2;
            }
            cVar2 = cVar4;
            if (i4 >= i) {
                cVar3 = cVar2;
                oVar = null;
                cVar = cVar3;
                oVar2 = eVar2;
                f1Var = f1Var2;
                eVar = eVar3;
                z = false;
                z2 = false;
            } else {
                if (eVar2 == null) {
                    throw s1.a.q("expected prior modifier list to be non-empty");
                }
                if (child$ui_release == null) {
                    throw s1.a.q("structuralUpdate requires a non-null tail");
                }
                boolean z3 = j0Var.K != null;
                oVar2 = eVar2;
                eVar = eVar3;
                oVar = null;
                t3.o oVar6 = child$ui_release;
                cVar = cVar2;
                cVar.s(i4, oVar2, eVar, oVar6, !z3);
                f1Var = f1Var2;
                z = false;
                z2 = true;
            }
        } else {
            oVar = null;
            t3.p pVar2 = j0Var.K;
            if (pVar2 != null && i == 0) {
                t3.o oVarN = f1Var2;
                for (int i6 = 0; i6 < eVar3.c; i6++) {
                    oVarN = dl.c.n((t3.n) eVar3.a[i6], oVarN);
                }
                int kindSet$ui_release = 0;
                for (t3.o parent$ui_release = oVar3.getParent$ui_release(); parent$ui_release != null && parent$ui_release != f1Var2; parent$ui_release = parent$ui_release.getParent$ui_release()) {
                    kindSet$ui_release |= parent$ui_release.getKindSet$ui_release();
                    parent$ui_release.setAggregateChildKindSet$ui_release(kindSet$ui_release);
                }
                cVar = cVar3;
                oVar2 = eVar2;
                f1Var = f1Var2;
                eVar = eVar3;
                z = false;
                z2 = true;
            } else if (i3 != 0) {
                if (eVar2 == null) {
                    z = false;
                    eVar2 = new k3.e(0, new t3.n[16]);
                } else {
                    z = false;
                }
                oVar2 = eVar2;
                cVar = cVar3;
                f1Var = f1Var2;
                eVar = eVar3;
                cVar.s(0, oVar2, eVar, f1Var, !(pVar2 != null ? true : z));
                z2 = true;
            } else {
                if (eVar2 == null) {
                    throw s1.a.q("expected prior modifier list to be non-empty");
                }
                t3.o child$ui_release2 = f1Var2.getChild$ui_release();
                for (int i7 = 0; child$ui_release2 != null && i7 < ((k3.e) eVar2).c; i7++) {
                    child$ui_release2 = dl.c.o(child$ui_release2).getChild$ui_release();
                }
                j0 j0VarV = j0Var.v();
                vVar.q = j0VarV != null ? (v) j0VarV.E.d : null;
                cVar3.e = vVar;
                cVar = cVar3;
                oVar2 = eVar2;
                f1Var = f1Var2;
                eVar = eVar3;
                z = false;
                z2 = false;
            }
        }
        cVar.h = eVar;
        if (oVar2 != null) {
            oVar2.k();
        } else {
            oVar2 = oVar;
        }
        cVar.i = oVar2;
        t3.o child$ui_release3 = f1Var.getChild$ui_release();
        if (child$ui_release3 != null) {
            oVar3 = child$ui_release3;
        }
        oVar3.setParent$ui_release(oVar);
        f1Var.setChild$ui_release(oVar);
        f1Var.setAggregateChildKindSet$ui_release(-1);
        f1Var.updateCoordinator$ui_release(oVar);
        if (oVar3 == f1Var) {
            p4.a.b("trimChain did not update the head");
        }
        cVar.g = oVar3;
        if (z2) {
            cVar.t();
        }
        boolean zP3 = cVar.p(16);
        boolean zP4 = cVar.p(1024);
        this.F.j();
        if (this.g == null && cVar.p(512)) {
            f0(this);
        }
        if (zP == zP3 && zP2 == zP4) {
            return;
        }
        b5.c rectManager = m0.a(this).getRectManager();
        rectManager.getClass();
        if (I()) {
            tlydtdl.compose.foundation.lazy.layout.m1 m1Var = rectManager.a;
            int i8 = this.b & 67108863;
            long[] jArr = (long[]) m1Var.c;
            int i9 = m1Var.b;
            for (?? r13 = z; r13 < jArr.length - 2 && r13 < i9; r13 += 3) {
                int i10 = r13 + 2;
                long j2 = jArr[i10];
                if ((((int) j2) & 67108863) == i8) {
                    jArr[i10] = ((zP3 ? 1L : 0L) * Long.MIN_VALUE) | (DurationKt.MAX_MILLIS & j2) | ((zP4 ? 1L : 0L) * 4611686018427387904L);
                    return;
                }
            }
        }
    }

    public final void b0(Throwable th) throws Throwable {
        q3.o oVar = this.A;
        g3 g3Var = tlydtdl.compose.runtime.tooling.d.a;
        q3.o oVar2 = oVar;
        oVar2.getClass();
        tlydtdl.compose.runtime.tooling.c cVar = (tlydtdl.compose.runtime.tooling.c) tlydtdl.compose.runtime.a0.v(oVar2, g3Var);
        if (cVar == null) {
            throw th;
        }
        m8.d.Q(th, new a11.k(6, cVar, this));
        throw th;
    }

    public final void c(Owner owner) throws KotlinNothingValueException {
        j0 j0Var;
        a5.k kVarX;
        if (this.m != null) {
            p4.a.b("Cannot attach " + this + " as it already is attached.  Tree: " + g(0));
        }
        j0 j0Var2 = this.l;
        if (j0Var2 != null && !lmjxuqdtp.jvm.internal.o.c(j0Var2.m, owner)) {
            StringBuilder sb = new StringBuilder("Attaching to a different owner(");
            sb.append(owner);
            sb.append(") than the parent's owner(");
            j0 j0VarV = v();
            sb.append(j0VarV != null ? j0VarV.m : null);
            sb.append("). This tree: ");
            sb.append(g(0));
            sb.append(" Parent tree: ");
            j0 j0Var3 = this.l;
            sb.append(j0Var3 != null ? j0Var3.g(0) : null);
            p4.a.b(sb.toString());
        }
        j0 j0VarV2 = v();
        n0 n0Var = this.F;
        if (j0VarV2 == null) {
            n0Var.p.s = true;
            x0 x0Var = n0Var.q;
            if (x0Var != null) {
                x0Var.q = u0.a;
            }
        }
        dl.c cVar = this.E;
        ((k1) cVar.e).q = j0VarV2 != null ? (v) j0VarV2.E.d : null;
        this.m = owner;
        this.o = (j0VarV2 != null ? j0VarV2.o : -1) + 1;
        t3.p pVar = this.K;
        if (pVar != null) {
            b(pVar);
        }
        this.K = null;
        t4.x xVar = (t4.x) owner;
        xVar.getLayoutNodes().h(this.b, this);
        j0 j0Var4 = this.l;
        if (j0Var4 == null || (j0Var = j0Var4.g) == null) {
            j0Var = this.g;
        }
        f0(j0Var);
        if (this.g == null && cVar.p(512)) {
            f0(this);
        }
        if (!this.P) {
            for (t3.o child$ui_release = (t3.o) cVar.g; child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                child$ui_release.markAsAttached$ui_release();
            }
        }
        k3.e eVar = (k3.e) this.i.b;
        Object[] objArr = eVar.a;
        int i = eVar.c;
        for (int i2 = 0; i2 < i; i2++) {
            ((j0) objArr[i2]).c(owner);
        }
        if (!this.P) {
            cVar.q();
        }
        E();
        if (j0VarV2 != null) {
            j0VarV2.E();
        }
        s5.d dVar = this.L;
        if (dVar != null) {
            dVar.invoke(owner);
        }
        n0Var.j();
        if (!this.P && cVar.p(8)) {
            G();
        }
        u3.c cVar2 = xVar.F;
        if (cVar2 == null || (kVarX = x()) == null || !kVarX.a.b(a5.t.q)) {
            return;
        }
        cVar2.h.a(this.b);
        cVar2.a.F(cVar2.c, this.b, true);
    }

    public final void c0(p5.c cVar) {
        if (lmjxuqdtp.jvm.internal.o.c(this.x, cVar)) {
            return;
        }
        this.x = cVar;
        E();
        j0 j0VarV = v();
        if (j0VarV != null) {
            j0VarV.C();
        }
        D();
        for (t3.o child$ui_release = (t3.o) this.E.g; child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
            child$ui_release.onDensityChange();
        }
    }

    public final void d() {
        this.C = this.B;
        this.B = h0.c;
        k3.e eVarZ = z();
        Object[] objArr = eVarZ.a;
        int i = eVarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            j0 j0Var = (j0) objArr[i2];
            if (j0Var.B != h0.c) {
                j0Var.d();
            }
        }
    }

    @Override // s4.t1
    public final boolean d0() {
        return I();
    }

    @Override // tlydtdl.compose.runtime.j
    public final void e() throws NoWhenBranchMatchedException, KotlinNothingValueException {
        s5.v vVar = this.n;
        if (vVar != null) {
            vVar.e();
        }
        q4.p0 p0Var = this.G;
        if (p0Var != null) {
            p0Var.e();
        }
        dl.c cVar = this.E;
        k1 k1Var = ((v) cVar.d).p;
        for (k1 k1Var2 = (k1) cVar.e; !lmjxuqdtp.jvm.internal.o.c(k1Var2, k1Var) && k1Var2 != null; k1Var2 = k1Var2.p) {
            k1Var2.w1();
        }
    }

    public final void e0(int i) {
        j0 j0VarV;
        j0 j0VarV2;
        int i2 = this.O;
        if (i2 != i) {
            if (i > 0 && i2 == 0 && (j0VarV2 = v()) != null) {
                j0VarV2.e0(j0VarV2.O + 1);
            }
            if (i == 0 && this.O > 0 && (j0VarV = v()) != null) {
                j0VarV.e0(j0VarV.O - 1);
            }
            this.O = i;
        }
    }

    public final void f() {
        this.C = this.B;
        this.B = h0.c;
        k3.e eVarZ = z();
        Object[] objArr = eVarZ.a;
        int i = eVarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            j0 j0Var = (j0) objArr[i2];
            if (j0Var.B == h0.b) {
                j0Var.f();
            }
        }
    }

    public final void f0(j0 j0Var) {
        if (lmjxuqdtp.jvm.internal.o.c(j0Var, this.g)) {
            return;
        }
        this.g = j0Var;
        n0 n0Var = this.F;
        if (j0Var != null) {
            if (n0Var.q == null) {
                n0Var.q = new x0(n0Var);
            }
            dl.c cVar = this.E;
            k1 k1Var = ((v) cVar.d).p;
            for (k1 k1Var2 = (k1) cVar.e; !lmjxuqdtp.jvm.internal.o.c(k1Var2, k1Var) && k1Var2 != null; k1Var2 = k1Var2.p) {
                k1Var2.e1();
            }
        } else {
            n0Var.q = null;
            n0Var.f437f = false;
            n0Var.e = false;
        }
        E();
    }

    public final String g(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
        sb.append("|-");
        sb.append(toString());
        sb.append('\n');
        k3.e eVarZ = z();
        Object[] objArr = eVarZ.a;
        int i3 = eVarZ.c;
        for (int i4 = 0; i4 < i3; i4++) {
            sb.append(((j0) objArr[i4]).g(i + 1));
        }
        String string = sb.toString();
        if (i != 0) {
            return string;
        }
        String strSubstring = string.substring(0, string.length() - 1);
        lmjxuqdtp.jvm.internal.o.g(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final void g0(u0 u0Var) {
        if (lmjxuqdtp.jvm.internal.o.c(this.v, u0Var)) {
            return;
        }
        this.v = u0Var;
        r7.a aVar = this.w;
        if (aVar != null) {
            aVar.M(u0Var);
        }
        E();
    }

    public final void h() throws NoWhenBranchMatchedException, KotlinNothingValueException {
        o0 o0Var;
        t4.x xVar = this.m;
        if (xVar == null) {
            StringBuilder sb = new StringBuilder("Cannot detach node that is already detached!  Tree: ");
            j0 j0VarV = v();
            sb.append(j0VarV != null ? j0VarV.g(0) : null);
            p4.a.c(sb.toString());
            throw new KotlinNothingValueException();
        }
        j0 j0VarV2 = v();
        n0 n0Var = this.F;
        if (j0VarV2 != null) {
            j0VarV2.C();
            j0VarV2.E();
            b1 b1Var = n0Var.p;
            h0 h0Var = h0.c;
            b1Var.l = h0Var;
            x0 x0Var = n0Var.q;
            if (x0Var != null) {
                x0Var.f446j = h0Var;
            }
        }
        k0 k0Var = n0Var.p.x;
        k0Var.b = true;
        k0Var.c = false;
        k0Var.d = false;
        k0Var.e = false;
        k0Var.f425f = null;
        x0 x0Var2 = n0Var.q;
        if (x0Var2 != null && (o0Var = x0Var2.r) != null) {
            o0Var.b = true;
            o0Var.c = false;
            o0Var.d = false;
            o0Var.e = false;
            o0Var.f425f = null;
        }
        dl.c cVar = this.E;
        t3.o parent$ui_release = (d2) cVar.f89f;
        k1 k1Var = ((v) cVar.d).p;
        for (k1 k1Var2 = (k1) cVar.e; !lmjxuqdtp.jvm.internal.o.c(k1Var2, k1Var) && k1Var2 != null; k1Var2 = k1Var2.p) {
            k1Var2.B1();
        }
        m4.b0 b0Var = this.M;
        if (b0Var != null) {
            b0Var.invoke(xVar);
        }
        for (t3.o parent$ui_release2 = parent$ui_release; parent$ui_release2 != null; parent$ui_release2 = parent$ui_release2.getParent$ui_release()) {
            if (parent$ui_release2.isAttached()) {
                parent$ui_release2.runDetachLifecycle$ui_release();
            }
        }
        this.p = true;
        k3.e eVar = (k3.e) this.i.b;
        Object[] objArr = eVar.a;
        int i = eVar.c;
        for (int i2 = 0; i2 < i; i2++) {
            ((j0) objArr[i2]).h();
        }
        this.p = false;
        while (parent$ui_release != null) {
            if (parent$ui_release.isAttached()) {
                parent$ui_release.markAsDetached$ui_release();
            }
            parent$ui_release = parent$ui_release.getParent$ui_release();
        }
        t4.x xVar2 = xVar;
        xVar2.getLayoutNodes().g(this.b);
        z0 z0Var = xVar2.O;
        qu0.u uVar = z0Var.b;
        ((rs1.d) uVar.b).I(this);
        ((rs1.d) uVar.c).I(this);
        ((rs1.d) uVar.d).I(this);
        ((k3.e) z0Var.e.b).n(this);
        xVar2.G = true;
        xVar2.getRectManager().j(this);
        u3.c cVar2 = xVar2.F;
        if (cVar2 != null && cVar2.h.e(this.b)) {
            cVar2.a.F(cVar2.c, this.b, false);
        }
        this.m = null;
        this.c = 9223372034707292159L;
        f0(null);
        this.o = 0;
        b1 b1Var2 = n0Var.p;
        b1Var2.i = IntCompanionObject.MAX_VALUE;
        b1Var2.h = IntCompanionObject.MAX_VALUE;
        b1Var2.s = false;
        x0 x0Var3 = n0Var.q;
        if (x0Var3 != null) {
            x0Var3.i = IntCompanionObject.MAX_VALUE;
            x0Var3.h = IntCompanionObject.MAX_VALUE;
            x0Var3.q = u0.c;
        }
        if (cVar.p(8)) {
            a5.k kVar = this.r;
            this.r = null;
            this.q = false;
            xVar2.getSemanticsOwner().b(this, kVar);
            xVar2.x();
        }
    }

    public final void h0(t3.p pVar) {
        if (this.a && this.J != t3.m.a) {
            p4.a.a("Modifiers are not supported on virtual LayoutNodes");
        }
        if (this.P) {
            p4.a.a("modifier is updated when deactivated");
        }
        if (!I()) {
            this.K = pVar;
            return;
        }
        b(pVar);
        if (this.q) {
            G();
        }
    }

    public final void i(a4.w wVar, d4.c cVar) throws Throwable {
        try {
            ((k1) this.E.e).c1(wVar, cVar);
        } catch (Throwable th) {
            b0(th);
            throw null;
        }
    }

    public final void i0(b3 b3Var) {
        if (lmjxuqdtp.jvm.internal.o.c(this.z, b3Var)) {
            return;
        }
        this.z = b3Var;
        dl.c cVar = this.E;
        if ((((t3.o) cVar.g).getAggregateChildKindSet$ui_release() & 16) != 0) {
            for (t3.o child$ui_release = (t3.o) cVar.g; child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                if ((child$ui_release.getKindSet$ui_release() & 16) != 0) {
                    t3.o oVarE = child$ui_release;
                    k3.e eVar = null;
                    while (oVarE != null) {
                        if (oVarE instanceof x1) {
                            ((x1) oVarE).K0();
                        } else if ((oVarE.getKindSet$ui_release() & 16) != 0 && (oVarE instanceof o)) {
                            int i = 0;
                            for (t3.o child$ui_release2 = ((o) oVarE).b; child$ui_release2 != null; child$ui_release2 = child$ui_release2.getChild$ui_release()) {
                                if ((child$ui_release2.getKindSet$ui_release() & 16) != 0) {
                                    i++;
                                    if (i == 1) {
                                        oVarE = child$ui_release2;
                                    } else {
                                        if (eVar == null) {
                                            eVar = new k3.e(0, new t3.o[16]);
                                        }
                                        if (oVarE != null) {
                                            eVar.d(oVarE);
                                            oVarE = null;
                                        }
                                        eVar.d(child$ui_release2);
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                        oVarE = g.e(eVar);
                    }
                }
                if ((child$ui_release.getAggregateChildKindSet$ui_release() & 16) == 0) {
                    return;
                }
            }
        }
    }

    public final void j0() {
        if (this.h <= 0 || !this.k) {
            return;
        }
        this.k = false;
        k3.e eVar = this.f434j;
        if (eVar == null) {
            eVar = new k3.e(0, new j0[16]);
            this.f434j = eVar;
        }
        eVar.k();
        k3.e eVar2 = (k3.e) this.i.b;
        Object[] objArr = eVar2.a;
        int i = eVar2.c;
        for (int i2 = 0; i2 < i; i2++) {
            j0 j0Var = (j0) objArr[i2];
            if (j0Var.a) {
                eVar.h(eVar.c, j0Var.z());
            } else {
                eVar.d(j0Var);
            }
        }
        n0 n0Var = this.F;
        n0Var.p.z = true;
        x0 x0Var = n0Var.q;
        if (x0Var != null) {
            x0Var.t = true;
        }
    }

    public final void k() {
        if (this.g != null) {
            W(this, false, 5);
        } else {
            Y(this, false, 5);
        }
        b1 b1Var = this.F.p;
        p5.a aVar = b1Var.f427j ? new p5.a(((m1) b1Var).d) : null;
        if (aVar != null) {
            t4.x xVar = this.m;
            if (xVar != null) {
                xVar.r(this, aVar.a);
                return;
            }
            return;
        }
        t4.x xVar2 = this.m;
        if (xVar2 != null) {
            xVar2.q(true);
        }
    }

    public final List l() {
        x0 x0Var = this.F.q;
        lmjxuqdtp.jvm.internal.o.e(x0Var);
        k3.e eVar = x0Var.s;
        n0 n0Var = x0Var.f445f;
        n0Var.a.n();
        if (!x0Var.t) {
            return eVar.j();
        }
        j0 j0Var = n0Var.a;
        k3.e eVarZ = j0Var.z();
        Object[] objArr = eVarZ.a;
        int i = eVarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            j0 j0Var2 = (j0) objArr[i2];
            if (eVar.c <= i2) {
                x0 x0Var2 = j0Var2.F.q;
                lmjxuqdtp.jvm.internal.o.e(x0Var2);
                eVar.d(x0Var2);
            } else {
                x0 x0Var3 = j0Var2.F.q;
                lmjxuqdtp.jvm.internal.o.e(x0Var3);
                Object[] objArr2 = eVar.a;
                Object obj = objArr2[i2];
                objArr2[i2] = x0Var3;
            }
        }
        eVar.p(j0Var.n().a.c, eVar.c);
        x0Var.t = false;
        return eVar.j();
    }

    public final List m() {
        return this.F.p.B0();
    }

    public final List n() {
        return z().j();
    }

    public final List o() {
        return ((k3.e) this.i.b).j();
    }

    public final boolean p() {
        return this.F.p.v;
    }

    public final boolean q() {
        return this.F.p.u;
    }

    public final h0 r() {
        return this.F.p.l;
    }

    public final h0 s() {
        h0 h0Var;
        x0 x0Var = this.F.q;
        return (x0Var == null || (h0Var = x0Var.f446j) == null) ? h0.c : h0Var;
    }

    public final List t() {
        dl.c cVar = this.E;
        d2 d2Var = (d2) cVar.f89f;
        k3.e eVar = (k3.e) cVar.h;
        if (eVar == null) {
            return mx1.t.a;
        }
        int i = 0;
        k3.e eVar2 = new k3.e(0, new q4.a1[eVar.c]);
        t3.o child$ui_release = (t3.o) cVar.g;
        while (child$ui_release != null && child$ui_release != d2Var) {
            k1 coordinator$ui_release = child$ui_release.getCoordinator$ui_release();
            if (coordinator$ui_release == null) {
                throw new IllegalArgumentException("getModifierInfo called on node with no coordinator");
            }
            s1 s1Var = coordinator$ui_release.I;
            s1 s1Var2 = ((v) cVar.d).I;
            t3.o child$ui_release2 = child$ui_release.getChild$ui_release();
            if (child$ui_release2 != d2Var || child$ui_release.getCoordinator$ui_release() == child$ui_release2.getCoordinator$ui_release()) {
                s1Var2 = null;
            }
            if (s1Var == null) {
                s1Var = s1Var2;
            }
            eVar2.d(new q4.a1((t3.p) eVar.a[i], coordinator$ui_release, s1Var));
            child$ui_release = child$ui_release.getChild$ui_release();
            i++;
        }
        return eVar2.j();
    }

    public final String toString() {
        return q51.a.H(this) + " children: " + n().a.c + " measurePolicy: " + this.v + " deactivated: " + this.P;
    }

    public final r7.a u() {
        r7.a aVar = this.w;
        if (aVar != null) {
            return aVar;
        }
        r7.a aVar2 = new r7.a(this, this.v);
        this.w = aVar2;
        return aVar2;
    }

    public final j0 v() {
        j0 j0Var = this.l;
        while (j0Var != null && j0Var.a) {
            j0Var = j0Var.l;
        }
        return j0Var;
    }

    public final int w() {
        return this.F.p.i;
    }

    public final a5.k x() {
        if (I() && !this.P && this.E.p(8)) {
            return this.r;
        }
        return null;
    }

    public final k3.e y() {
        boolean z = this.u;
        k3.e eVar = this.t;
        if (z) {
            eVar.k();
            eVar.h(eVar.c, z());
            mx1.n.r0(eVar.a, S, 0, eVar.c);
            this.u = false;
        }
        return eVar;
    }

    public final k3.e z() {
        j0();
        if (this.h == 0) {
            return (k3.e) this.i.b;
        }
        k3.e eVar = this.f434j;
        lmjxuqdtp.jvm.internal.o.e(eVar);
        return eVar;
    }

    public j0(boolean z, int i) {
        this.a = z;
        this.b = i;
        this.c = 9223372034707292159L;
        this.d = 0L;
        this.e = 9223372034707292159L;
        this.f433f = true;
        this.i = new i11.c(19, new k3.e(0, new j0[16]), new b5.b(16, this));
        this.t = new k3.e(0, new j0[16]);
        this.u = true;
        this.v = Q;
        this.x = m0.a;
        this.y = p5.n.a;
        this.z = R;
        tlydtdl.compose.runtime.c0.K0.getClass();
        this.A = tlydtdl.compose.runtime.b0.b;
        h0 h0Var = h0.c;
        this.B = h0Var;
        this.C = h0Var;
        this.E = new dl.c(this);
        this.F = new n0(this);
        this.I = true;
        this.J = t3.m.a;
    }
}
