package s4;

import kotlin.jvm.internal.IntCompanionObject;
import lmjxuqdtp.KotlinNothingValueException;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import q4.m1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a1 extends lmjxuqdtp.jvm.internal.p implements Function0 {
    public final /* synthetic */ int c;
    public final /* synthetic */ b1 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a1(b1 b1Var, int i) {
        super(0);
        this.c = i;
        this.d = b1Var;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final Object invoke() throws NoWhenBranchMatchedException, KotlinNothingValueException {
        q4.q0 placementScope;
        switch (this.c) {
            case 0:
                b1 b1Var = this.d;
                n0 n0Var = b1Var.f426f;
                n0Var.i = 0;
                k3.e eVarZ = n0Var.a.z();
                Object[] objArr = eVarZ.a;
                int i = eVarZ.c;
                for (int i2 = 0; i2 < i; i2++) {
                    b1 b1Var2 = ((j0) objArr[i2]).F.p;
                    b1Var2.h = b1Var2.i;
                    b1Var2.i = IntCompanionObject.MAX_VALUE;
                    b1Var2.t = false;
                    if (b1Var2.l == h0.b) {
                        b1Var2.l = h0.c;
                    }
                }
                j0 j0Var = n0Var.a;
                j0 j0Var2 = n0Var.a;
                k3.e eVarZ2 = j0Var.z();
                Object[] objArr2 = eVarZ2.a;
                int i3 = eVarZ2.c;
                for (int i4 = 0; i4 < i3; i4++) {
                    ((j0) objArr2[i4]).F.p.x.getClass();
                }
                b1Var.G().R0().c();
                k3.e eVarZ3 = j0Var2.z();
                Object[] objArr3 = eVarZ3.a;
                int i6 = eVarZ3.c;
                for (int i7 = 0; i7 < i6; i7++) {
                    j0 j0Var3 = (j0) objArr3[i7];
                    n0 n0Var2 = j0Var3.F;
                    if (n0Var2.p.h != j0Var3.w()) {
                        j0Var2.P();
                        j0Var2.C();
                        if (j0Var3.w() == Integer.MAX_VALUE) {
                            if (n0Var2.c) {
                                x0 x0Var = n0Var2.q;
                                lmjxuqdtp.jvm.internal.o.e(x0Var);
                                x0Var.B0(false);
                            }
                            n0Var2.p.G0();
                        }
                    }
                }
                k3.e eVarZ4 = j0Var2.z();
                Object[] objArr4 = eVarZ4.a;
                int i8 = eVarZ4.c;
                for (int i9 = 0; i9 < i8; i9++) {
                    k0 k0Var = ((j0) objArr4[i9]).F.p.x;
                    k0Var.getClass();
                    k0Var.c = false;
                }
                break;
            case 1:
                b1 b1Var3 = this.d;
                b1Var3.f426f.a().T(b1Var3.B);
                break;
            default:
                b1 b1Var4 = this.d;
                n0 n0Var3 = b1Var4.f426f;
                k1 k1Var = n0Var3.a().q;
                if (k1Var == null || (placementScope = k1Var.l) == null) {
                    placementScope = m0.a(n0Var3.a).getPlacementScope();
                }
                Function1 function1 = b1Var4.G;
                d4.c cVar = b1Var4.H;
                if (cVar != null) {
                    k1 k1VarA = n0Var3.a();
                    long j2 = b1Var4.I;
                    float f2 = b1Var4.J;
                    placementScope.getClass();
                    q4.l1.b(placementScope, k1VarA);
                    k1VarA.j0(p5.k.d(j2, ((m1) k1VarA).e), f2, cVar);
                } else if (function1 == null) {
                    placementScope.j(n0Var3.a(), b1Var4.I, b1Var4.J);
                } else {
                    k1 k1VarA2 = n0Var3.a();
                    long j3 = b1Var4.I;
                    float f3 = b1Var4.J;
                    placementScope.getClass();
                    q4.l1.b(placementScope, k1VarA2);
                    k1VarA2.k0(p5.k.d(j3, ((m1) k1VarA2).e), f3, function1);
                }
                break;
        }
        return lx1.b0.a;
    }
}
