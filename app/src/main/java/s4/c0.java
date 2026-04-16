package s4;

import a4.w0;
import kotlin.jvm.internal.IntCompanionObject;
import lmjxuqdtp.KotlinNothingValueException;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function1;
import q4.m1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 extends k1 {
    public static final a4.i R;
    public a0 P;
    public b0 Q;

    static {
        a4.i iVarG = w0.g();
        iVarG.e(a4.y.e);
        iVarG.l(1.0f);
        iVarG.m(1);
        R = iVarG;
    }

    public c0(j0 j0Var, a0 a0Var) {
        super(j0Var);
        this.P = a0Var;
        this.Q = j0Var.g != null ? new b0(this) : null;
        if ((a0Var.getNode().getKindSet$ui_release() & 512) != 0) {
            throw new ClassCastException();
        }
    }

    @Override // s4.s0
    public final int D0(q4.a aVar) {
        b0 b0Var = this.Q;
        if (b0Var == null) {
            return q8.c.i(this, aVar);
        }
        q1.f0 f0Var = b0Var.t;
        int iD = f0Var.d(aVar);
        return iD >= 0 ? f0Var.c[iD] : IntCompanionObject.MIN_VALUE;
    }

    public final void L1() {
        if (this.f442j) {
            return;
        }
        v1();
        R0().c();
        lmjxuqdtp.jvm.internal.o.e(this.p);
    }

    public final int M(int i) {
        a0 a0Var = this.P;
        k1 k1Var = this.p;
        lmjxuqdtp.jvm.internal.o.e(k1Var);
        return a0Var.minIntrinsicWidth(this, k1Var, i);
    }

    public final void M1(a0 a0Var) {
        if (!a0Var.equals(this.P) && (a0Var.getNode().getKindSet$ui_release() & 512) != 0) {
            throw new ClassCastException();
        }
        this.P = a0Var;
    }

    public final int R(int i) {
        a0 a0Var = this.P;
        k1 k1Var = this.p;
        lmjxuqdtp.jvm.internal.o.e(k1Var);
        return a0Var.maxIntrinsicWidth(this, k1Var, i);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final m1 T(long j2) throws NoWhenBranchMatchedException, KotlinNothingValueException {
        o0(j2);
        a0 a0Var = this.P;
        k1 k1Var = this.p;
        lmjxuqdtp.jvm.internal.o.e(k1Var);
        C1(a0Var.mo1789measure3p2s80s(this, k1Var, j2));
        u1();
        return this;
    }

    public final int c(int i) {
        a0 a0Var = this.P;
        k1 k1Var = this.p;
        lmjxuqdtp.jvm.internal.o.e(k1Var);
        return a0Var.maxIntrinsicHeight(this, k1Var, i);
    }

    @Override // s4.k1
    public final void e1() {
        if (this.Q == null) {
            this.Q = new b0(this);
        }
    }

    @Override // s4.k1
    public final t0 h1() {
        return this.Q;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    @Override // s4.k1
    public final void j0(long j2, float f2, d4.c cVar) throws NoWhenBranchMatchedException, KotlinNothingValueException {
        z1(j2, f2, null, cVar);
        L1();
    }

    @Override // s4.k1
    public final t3.o j1() {
        return this.P.getNode();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final void k0(long j2, float f2, Function1 function1) throws NoWhenBranchMatchedException, KotlinNothingValueException {
        z1(j2, f2, function1, null);
        L1();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    @Override // s4.k1
    public final void y1(a4.w wVar, d4.c cVar) throws NoWhenBranchMatchedException {
        k1 k1Var;
        k1 k1Var2 = this.p;
        lmjxuqdtp.jvm.internal.o.e(k1Var2);
        k1Var2.c1(wVar, cVar);
        if (!m0.a(this.o).getShowLayoutBounds() || (k1Var = this.p) == null) {
            return;
        }
        if (p5.m.a(((m1) this).c, ((m1) k1Var).c) && p5.k.b(k1Var.z, 0L)) {
            return;
        }
        long j2 = ((m1) this).c;
        wVar.d(0.5f, 0.5f, ((int) (j2 >> 32)) - 0.5f, ((int) (j2 & 4294967295L)) - 0.5f, R);
    }

    public final int z(int i) {
        a0 a0Var = this.P;
        k1 k1Var = this.p;
        lmjxuqdtp.jvm.internal.o.e(k1Var);
        return a0Var.minIntrinsicHeight(this, k1Var, i);
    }
}
