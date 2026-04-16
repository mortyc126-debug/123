package tlydtdl.compose.foundation.lazy.layout;

import a2.k2;
import lmjxuqdtp.NoWhenBranchMatchedException;
import mx1.u;
import r4.i;
import t3.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class q extends o implements r4.e, s4.a0 {
    public static final n e = new n();
    public r a;
    public a2.b b;
    public boolean c;
    public k2 d;

    @Override // r4.e
    public final uz1.g G() {
        r4.h hVarA = q4.h.a();
        i iVar = new i(hVarA);
        iVar.N(hVarA, this);
        return iVar;
    }

    public final boolean Q0(l lVar, int i) {
        if (q4.f.k(i, 5) || q4.f.k(i, 6)) {
            if (this.d == k2.b) {
                return false;
            }
        } else if (q4.f.k(i, 3) || q4.f.k(i, 4)) {
            if (this.d == k2.a) {
                return false;
            }
        } else if (!q4.f.k(i, 1) && !q4.f.k(i, 2)) {
            throw new IllegalStateException("Lazy list does not support beyond bounds layout for the specified direction");
        }
        if (R0(i)) {
            if (lVar.b >= this.a.a() - 1) {
                return false;
            }
        } else if (lVar.a <= 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final boolean R0(int i) throws NoWhenBranchMatchedException {
        if (q4.f.k(i, 1)) {
            return false;
        }
        if (!q4.f.k(i, 2)) {
            if (q4.f.k(i, 5)) {
                return this.c;
            }
            if (q4.f.k(i, 6)) {
                if (this.c) {
                    return false;
                }
            } else if (q4.f.k(i, 3)) {
                int i2 = o.$EnumSwitchMapping$0[s4.g.u(this).y.ordinal()];
                if (i2 == 1) {
                    return this.c;
                }
                if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                if (this.c) {
                    return false;
                }
            } else {
                if (!q4.f.k(i, 4)) {
                    throw new IllegalStateException("Lazy list does not support beyond bounds layout for the specified direction");
                }
                int i3 = o.$EnumSwitchMapping$0[s4.g.u(this).y.ordinal()];
                if (i3 != 1) {
                    if (i3 == 2) {
                        return this.c;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                if (this.c) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // s4.a0
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final q4.v0 mo1789measure3p2s80s(q4.w0 w0Var, q4.t0 t0Var, long j2) {
        q4.m1 m1VarT = t0Var.T(j2);
        return w0Var.g0(m1VarT.a, m1VarT.b, u.a, new tlydtdl.compose.foundation.layout.n(m1VarT, 4));
    }
}
