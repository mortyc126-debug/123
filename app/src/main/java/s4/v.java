package s4;

import a4.w0;
import kotlin.jvm.internal.IntCompanionObject;
import lmjxuqdtp.KotlinNothingValueException;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function1;
import q4.m1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class v extends k1 {
    public static final a4.i R;
    public final d2 P;
    public u Q;

    static {
        a4.i iVarG = w0.g();
        iVarG.e(a4.y.d);
        iVarG.l(1.0f);
        iVarG.m(1);
        R = iVarG;
    }

    public v(j0 j0Var) {
        super(j0Var);
        d2 d2Var = new d2();
        d2Var.setAggregateChildKindSet$ui_release(0);
        this.P = d2Var;
        d2Var.updateCoordinator$ui_release(this);
        this.Q = j0Var.g != null ? new u(this) : null;
    }

    @Override // s4.s0
    public final int D0(q4.a aVar) {
        u uVar = this.Q;
        if (uVar != null) {
            return uVar.D0(aVar);
        }
        b1 b1Var = this.o.F.p;
        k0 k0Var = b1Var.x;
        if (b1Var.f426f.d == f0.a) {
            k0Var.d = true;
            if (k0Var.b) {
                b1Var.v = true;
                b1Var.w = true;
            }
        } else {
            k0Var.e = true;
        }
        b1Var.G().k = true;
        b1Var.r();
        b1Var.G().k = false;
        Integer num = (Integer) k0Var.g.get(aVar);
        return num != null ? num.intValue() : IntCompanionObject.MIN_VALUE;
    }

    public final int M(int i) {
        return this.o.u().E(i);
    }

    public final int R(int i) {
        return this.o.u().A(i);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final m1 T(long j2) throws NoWhenBranchMatchedException, KotlinNothingValueException {
        o0(j2);
        j0 j0Var = this.o;
        k3.e eVarZ = j0Var.z();
        Object[] objArr = eVarZ.a;
        int i = eVarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            ((j0) objArr[i2]).F.p.l = h0.c;
        }
        C1(j0Var.v.d(this, j0Var.m(), j2));
        u1();
        return this;
    }

    public final int c(int i) {
        return this.o.u().z(i);
    }

    @Override // s4.k1
    public final void e1() {
        if (this.Q == null) {
            this.Q = new u(this);
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
        if (this.f442j) {
            return;
        }
        this.o.F.p.M0();
    }

    @Override // s4.k1
    public final t3.o j1() {
        return this.P;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final void k0(long j2, float f2, Function1 function1) throws NoWhenBranchMatchedException, KotlinNothingValueException {
        z1(j2, f2, function1, null);
        if (this.f442j) {
            return;
        }
        this.o.F.p.M0();
    }

    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0051  */
    @Override // s4.k1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void p1(s4.e r19, long r20, s4.t r22, int r23, boolean r24) {
        /*
            Method dump skipped, instruction units count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: s4.v.p1(s4.e, long, s4.t, int, boolean):void");
    }

    @Override // s4.k1
    public final void y1(a4.w wVar, d4.c cVar) throws Throwable {
        j0 j0Var = this.o;
        t4.x xVarA = m0.a(j0Var);
        k3.e eVarY = j0Var.y();
        Object[] objArr = eVarY.a;
        int i = eVarY.c;
        for (int i2 = 0; i2 < i; i2++) {
            j0 j0Var2 = (j0) objArr[i2];
            if (j0Var2.J()) {
                j0Var2.i(wVar, cVar);
            }
        }
        if (xVarA.getShowLayoutBounds()) {
            long j2 = ((m1) this).c;
            wVar.d(0.5f, 0.5f, ((int) (j2 >> 32)) - 0.5f, ((int) (j2 & 4294967295L)) - 0.5f, R);
        }
    }

    public final int z(int i) {
        return this.o.u().D(i);
    }
}
