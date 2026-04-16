package s4;

import kotlin.jvm.internal.IntCompanionObject;
import q4.m1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class u extends t0 {
    @Override // s4.s0
    public final int D0(q4.a aVar) {
        x0 x0Var = this.o.o.F.q;
        lmjxuqdtp.jvm.internal.o.e(x0Var);
        o0 o0Var = x0Var.r;
        n0 n0Var = x0Var.f445f;
        if (n0Var.d == f0.b) {
            o0Var.d = true;
            if (o0Var.b) {
                n0Var.f437f = true;
                n0Var.g = true;
            }
        } else {
            o0Var.e = true;
        }
        u uVar = x0Var.G().Q;
        if (uVar != null) {
            uVar.k = true;
        }
        x0Var.r();
        u uVar2 = x0Var.G().Q;
        if (uVar2 != null) {
            uVar2.k = false;
        }
        Integer num = (Integer) o0Var.g.get(aVar);
        int iIntValue = num != null ? num.intValue() : IntCompanionObject.MIN_VALUE;
        this.t.h(iIntValue, aVar);
        return iIntValue;
    }

    public final int M(int i) {
        return this.o.o.u().G(i);
    }

    public final int R(int i) {
        return this.o.o.u().C(i);
    }

    public final m1 T(long j2) {
        o0(j2);
        k1 k1Var = this.o;
        k3.e eVarZ = k1Var.o.z();
        Object[] objArr = eVarZ.a;
        int i = eVarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            x0 x0Var = ((j0) objArr[i2]).F.q;
            lmjxuqdtp.jvm.internal.o.e(x0Var);
            x0Var.f446j = h0.c;
        }
        j0 j0Var = k1Var.o;
        t0.Y0(this, j0Var.v.d(this, j0Var.l(), j2));
        return this;
    }

    @Override // s4.t0
    public final void Z0() {
        x0 x0Var = this.o.o.F.q;
        lmjxuqdtp.jvm.internal.o.e(x0Var);
        x0Var.K0();
    }

    public final int c(int i) {
        return this.o.o.u().B(i);
    }

    public final int z(int i) {
        return this.o.o.u().F(i);
    }
}
