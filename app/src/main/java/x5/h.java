package x5;

import java.util.ArrayList;
import v5.f;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends d {
    public float q0 = -1.0f;
    public int r0 = -1;
    public int s0 = -1;
    public c t0 = this.J;
    public int u0 = 0;
    public boolean v0;

    public h() {
        this.R.clear();
        this.R.add(this.t0);
        int length = this.Q.length;
        for (int i = 0; i < length; i++) {
            this.Q[i] = this.t0;
        }
    }

    @Override // x5.d
    public final boolean A() {
        return this.v0;
    }

    @Override // x5.d
    public final boolean B() {
        return this.v0;
    }

    @Override // x5.d
    public final void Q(v5.c cVar, boolean z) {
        if (this.T == null) {
            return;
        }
        c cVar2 = this.t0;
        cVar.getClass();
        int iN = v5.c.n(cVar2);
        if (this.u0 == 1) {
            this.Y = iN;
            this.Z = 0;
            L(this.T.k());
            O(0);
            return;
        }
        this.Y = 0;
        this.Z = iN;
        O(this.T.q());
        L(0);
    }

    public final void R(int i) {
        this.t0.l(i);
        this.v0 = true;
    }

    public final void S(int i) {
        if (this.u0 == i) {
            return;
        }
        this.u0 = i;
        ArrayList arrayList = this.R;
        arrayList.clear();
        if (this.u0 == 1) {
            this.t0 = this.I;
        } else {
            this.t0 = this.J;
        }
        arrayList.add(this.t0);
        c[] cVarArr = this.Q;
        int length = cVarArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            cVarArr[i2] = this.t0;
        }
    }

    @Override // x5.d
    public final void b(v5.c cVar, boolean z) {
        e eVar = (e) this.T;
        if (eVar == null) {
            return;
        }
        c cVarI = eVar.i(2);
        c cVarI2 = eVar.i(4);
        d dVar = this.T;
        boolean z2 = dVar != null && dVar.p0[0] == 2;
        if (this.u0 == 0) {
            cVarI = eVar.i(3);
            cVarI2 = eVar.i(5);
            d dVar2 = this.T;
            z2 = dVar2 != null && dVar2.p0[1] == 2;
        }
        if (this.v0) {
            c cVar2 = this.t0;
            if (cVar2.c) {
                f fVarK = cVar.k(cVar2);
                cVar.d(fVarK, this.t0.d());
                if (this.r0 != -1) {
                    if (z2) {
                        cVar.f(cVar.k(cVarI2), fVarK, 0, 5);
                    }
                } else if (this.s0 != -1 && z2) {
                    f fVarK2 = cVar.k(cVarI2);
                    cVar.f(fVarK, cVar.k(cVarI), 0, 5);
                    cVar.f(fVarK2, fVarK, 0, 5);
                }
                this.v0 = false;
                return;
            }
        }
        if (this.r0 != -1) {
            f fVarK3 = cVar.k(this.t0);
            cVar.e(fVarK3, cVar.k(cVarI), this.r0, 8);
            if (z2) {
                cVar.f(cVar.k(cVarI2), fVarK3, 0, 5);
                return;
            }
            return;
        }
        if (this.s0 != -1) {
            f fVarK4 = cVar.k(this.t0);
            f fVarK5 = cVar.k(cVarI2);
            cVar.e(fVarK4, fVarK5, -this.s0, 8);
            if (z2) {
                cVar.f(fVarK4, cVar.k(cVarI), 0, 5);
                cVar.f(fVarK5, fVarK4, 0, 5);
                return;
            }
            return;
        }
        if (this.q0 != -1.0f) {
            f fVarK6 = cVar.k(this.t0);
            f fVarK7 = cVar.k(cVarI2);
            float f2 = this.q0;
            v5.b bVarL = cVar.l();
            bVarL.d.g(fVarK6, -1.0f);
            bVarL.d.g(fVarK7, f2);
            cVar.c(bVarL);
        }
    }

    @Override // x5.d
    public final boolean c() {
        return true;
    }

    @Override // x5.d
    public final c i(int i) {
        int iK = p.k(i);
        if (iK != 1) {
            if (iK != 2) {
                if (iK != 3) {
                    if (iK != 4) {
                        return null;
                    }
                }
            }
            if (this.u0 == 0) {
                return this.t0;
            }
            return null;
        }
        if (this.u0 == 1) {
            return this.t0;
        }
        return null;
    }
}
