package x5;

import f3.f2;
import v5.f;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends i {
    public int s0;
    public boolean t0;
    public int u0;
    public boolean v0;

    @Override // x5.d
    public final boolean A() {
        return this.v0;
    }

    @Override // x5.d
    public final boolean B() {
        return this.v0;
    }

    public final boolean T() {
        int i;
        int i2;
        int i3;
        boolean z = true;
        int i4 = 0;
        while (true) {
            i = this.r0;
            if (i4 >= i) {
                break;
            }
            d dVar = this.q0[i4];
            if ((this.t0 || dVar.c()) && ((((i2 = this.s0) == 0 || i2 == 1) && !dVar.A()) || (((i3 = this.s0) == 2 || i3 == 3) && !dVar.B()))) {
                z = false;
            }
            i4++;
        }
        if (!z || i <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z2 = false;
        for (int i6 = 0; i6 < this.r0; i6++) {
            d dVar2 = this.q0[i6];
            if (this.t0 || dVar2.c()) {
                if (!z2) {
                    int i7 = this.s0;
                    if (i7 == 0) {
                        iMax = dVar2.i(2).d();
                    } else if (i7 == 1) {
                        iMax = dVar2.i(4).d();
                    } else if (i7 == 2) {
                        iMax = dVar2.i(3).d();
                    } else if (i7 == 3) {
                        iMax = dVar2.i(5).d();
                    }
                    z2 = true;
                }
                int i8 = this.s0;
                if (i8 == 0) {
                    iMax = Math.min(iMax, dVar2.i(2).d());
                } else if (i8 == 1) {
                    iMax = Math.max(iMax, dVar2.i(4).d());
                } else if (i8 == 2) {
                    iMax = Math.min(iMax, dVar2.i(3).d());
                } else if (i8 == 3) {
                    iMax = Math.max(iMax, dVar2.i(5).d());
                }
            }
        }
        int i9 = iMax + this.u0;
        int i10 = this.s0;
        if (i10 == 0 || i10 == 1) {
            J(i9, i9);
        } else {
            K(i9, i9);
        }
        this.v0 = true;
        return true;
    }

    public final int U() {
        int i = this.s0;
        if (i == 0 || i == 1) {
            return 0;
        }
        return (i == 2 || i == 3) ? 1 : -1;
    }

    @Override // x5.d
    public final void b(v5.c cVar, boolean z) {
        boolean z2;
        int i;
        int i2;
        c[] cVarArr = this.Q;
        c cVar2 = this.I;
        cVarArr[0] = cVar2;
        int i3 = 2;
        c cVar3 = this.J;
        cVarArr[2] = cVar3;
        c cVar4 = this.K;
        cVarArr[1] = cVar4;
        c cVar5 = this.L;
        cVarArr[3] = cVar5;
        for (c cVar6 : cVarArr) {
            cVar6.i = cVar.k(cVar6);
        }
        int i4 = this.s0;
        if (i4 < 0 || i4 >= 4) {
            return;
        }
        c cVar7 = cVarArr[i4];
        if (!this.v0) {
            T();
        }
        if (this.v0) {
            this.v0 = false;
            int i6 = this.s0;
            if (i6 == 0 || i6 == 1) {
                cVar.d(cVar2.i, this.Y);
                cVar.d(cVar4.i, this.Y);
                return;
            } else {
                if (i6 == 2 || i6 == 3) {
                    cVar.d(cVar3.i, this.Z);
                    cVar.d(cVar5.i, this.Z);
                    return;
                }
                return;
            }
        }
        for (int i7 = 0; i7 < this.r0; i7++) {
            d dVar = this.q0[i7];
            if ((this.t0 || dVar.c()) && ((((i2 = this.s0) == 0 || i2 == 1) && dVar.p0[0] == 3 && dVar.I.f686f != null && dVar.K.f686f != null) || ((i2 == 2 || i2 == 3) && dVar.p0[1] == 3 && dVar.J.f686f != null && dVar.L.f686f != null))) {
                z2 = true;
                break;
            }
        }
        z2 = false;
        boolean z3 = cVar2.g() || cVar4.g();
        boolean z4 = cVar3.g() || cVar5.g();
        int i8 = !(!z2 && (((i = this.s0) == 0 && z3) || ((i == 2 && z4) || ((i == 1 && z3) || (i == 3 && z4))))) ? 4 : 5;
        int i9 = 0;
        while (i9 < this.r0) {
            d dVar2 = this.q0[i9];
            if (this.t0 || dVar2.c()) {
                f fVarK = cVar.k(dVar2.Q[this.s0]);
                c[] cVarArr2 = dVar2.Q;
                int i10 = this.s0;
                c cVar8 = cVarArr2[i10];
                cVar8.i = fVarK;
                c cVar9 = cVar8.f686f;
                int i11 = (cVar9 == null || cVar9.d != this) ? 0 : cVar8.g;
                if (i10 == 0 || i10 == i3) {
                    f fVar = cVar7.i;
                    int i12 = this.u0 - i11;
                    v5.b bVarL = cVar.l();
                    f fVarM = cVar.m();
                    fVarM.d = 0;
                    bVarL.c(fVar, fVarK, fVarM, i12);
                    cVar.c(bVarL);
                } else {
                    f fVar2 = cVar7.i;
                    int i13 = this.u0 + i11;
                    v5.b bVarL2 = cVar.l();
                    f fVarM2 = cVar.m();
                    fVarM2.d = 0;
                    bVarL2.b(fVar2, fVarK, fVarM2, i13);
                    cVar.c(bVarL2);
                }
                cVar.e(cVar7.i, fVarK, this.u0 + i11, i8);
            }
            i9++;
            i3 = 2;
        }
        int i14 = this.s0;
        if (i14 == 0) {
            cVar.e(cVar4.i, cVar2.i, 0, 8);
            cVar.e(cVar2.i, this.T.K.i, 0, 4);
            cVar.e(cVar2.i, this.T.I.i, 0, 0);
            return;
        }
        if (i14 == 1) {
            cVar.e(cVar2.i, cVar4.i, 0, 8);
            cVar.e(cVar2.i, this.T.I.i, 0, 4);
            cVar.e(cVar2.i, this.T.K.i, 0, 0);
        } else if (i14 == 2) {
            cVar.e(cVar5.i, cVar3.i, 0, 8);
            cVar.e(cVar3.i, this.T.L.i, 0, 4);
            cVar.e(cVar3.i, this.T.J.i, 0, 0);
        } else if (i14 == 3) {
            cVar.e(cVar3.i, cVar5.i, 0, 8);
            cVar.e(cVar3.i, this.T.J.i, 0, 4);
            cVar.e(cVar3.i, this.T.L.i, 0, 0);
        }
    }

    @Override // x5.d
    public final boolean c() {
        return true;
    }

    @Override // x5.d
    public final String toString() {
        String strP = i.p(new StringBuilder("[Barrier] "), this.h0, " {");
        for (int i = 0; i < this.r0; i++) {
            d dVar = this.q0[i];
            if (i > 0) {
                strP = f2.C(strP, ", ");
            }
            StringBuilder sbQ = i.q(strP);
            sbQ.append(dVar.h0);
            strP = sbQ.toString();
        }
        return f2.C(strP, "}");
    }
}
