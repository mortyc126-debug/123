package y5;

import java.util.HashSet;
import x5.c;
import x5.e;
import x5.h;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {
    public static final b a = new b();

    public static boolean a(x5.d dVar) {
        int[] iArr = dVar.p0;
        int i = iArr[0];
        int i2 = iArr[1];
        x5.d dVar2 = dVar.T;
        e eVar = dVar2 != null ? (e) dVar2 : null;
        if (eVar != null) {
            int i3 = eVar.p0[0];
        }
        if (eVar != null) {
            int i4 = eVar.p0[1];
        }
        boolean z = i == 1 || dVar.A() || i == 2 || (i == 3 && dVar.r == 0 && dVar.W == 0.0f && dVar.t(0)) || (i == 3 && dVar.r == 1 && dVar.u(0, dVar.q()));
        boolean z2 = i2 == 1 || dVar.B() || i2 == 2 || (i2 == 3 && dVar.s == 0 && dVar.W == 0.0f && dVar.t(1)) || (i2 == 3 && dVar.s == 1 && dVar.u(1, dVar.k()));
        return (dVar.W > 0.0f && (z || z2)) || (z && z2);
    }

    public static void b(int i, a6.e eVar, x5.d dVar, boolean z) {
        c cVar;
        c cVar2;
        boolean z2;
        c cVar3;
        c cVar4;
        if (dVar.m) {
            return;
        }
        if (!(dVar instanceof e) && dVar.z() && a(dVar)) {
            e.V(dVar, eVar, new b());
        }
        c cVarI = dVar.i(2);
        c cVarI2 = dVar.i(4);
        int iD = cVarI.d();
        int iD2 = cVarI2.d();
        HashSet<c> hashSet = cVarI.a;
        if (hashSet != null && cVarI.c) {
            for (c cVar5 : hashSet) {
                x5.d dVar2 = cVar5.d;
                int i2 = i + 1;
                boolean zA = a(dVar2);
                c cVar6 = dVar2.I;
                c cVar7 = dVar2.K;
                if (dVar2.z() && zA) {
                    z2 = true;
                    e.V(dVar2, eVar, new b());
                } else {
                    z2 = true;
                }
                boolean z3 = ((cVar5 == cVar6 && (cVar4 = cVar7.f686f) != null && cVar4.c) || (cVar5 == cVar7 && (cVar3 = cVar6.f686f) != null && cVar3.c)) ? z2 : false;
                int i3 = dVar2.p0[0];
                if (i3 != 3 || zA) {
                    if (!dVar2.z()) {
                        if (cVar5 == cVar6 && cVar7.f686f == null) {
                            int iE = cVar6.e() + iD;
                            dVar2.J(iE, dVar2.q() + iE);
                            b(i2, eVar, dVar2, z);
                        } else if (cVar5 == cVar7 && cVar6.f686f == null) {
                            int iE2 = iD - cVar7.e();
                            dVar2.J(iE2 - dVar2.q(), iE2);
                            b(i2, eVar, dVar2, z);
                        } else if (z3 && !dVar2.x()) {
                            c(i2, eVar, dVar2, z);
                        }
                    }
                } else if (i3 == 3 && dVar2.v >= 0 && dVar2.u >= 0 && (dVar2.g0 == 8 || (dVar2.r == 0 && dVar2.W == 0.0f))) {
                    if (!dVar2.x() && !dVar2.F && z3 && !dVar2.x()) {
                        d(i2, dVar, eVar, dVar2, z);
                    }
                }
            }
        }
        if (dVar instanceof h) {
            return;
        }
        HashSet<c> hashSet2 = cVarI2.a;
        if (hashSet2 != null && cVarI2.c) {
            for (c cVar8 : hashSet2) {
                x5.d dVar3 = cVar8.d;
                int i4 = i + 1;
                boolean zA2 = a(dVar3);
                c cVar9 = dVar3.I;
                c cVar10 = dVar3.K;
                if (dVar3.z() && zA2) {
                    e.V(dVar3, eVar, new b());
                }
                boolean z4 = (cVar8 == cVar9 && (cVar2 = cVar10.f686f) != null && cVar2.c) || (cVar8 == cVar10 && (cVar = cVar9.f686f) != null && cVar.c);
                int i6 = dVar3.p0[0];
                if (i6 != 3 || zA2) {
                    if (!dVar3.z()) {
                        if (cVar8 == cVar9 && cVar10.f686f == null) {
                            int iE3 = cVar9.e() + iD2;
                            dVar3.J(iE3, dVar3.q() + iE3);
                            b(i4, eVar, dVar3, z);
                        } else if (cVar8 == cVar10 && cVar9.f686f == null) {
                            int iE4 = iD2 - cVar10.e();
                            dVar3.J(iE4 - dVar3.q(), iE4);
                            b(i4, eVar, dVar3, z);
                        } else if (z4 && !dVar3.x()) {
                            c(i4, eVar, dVar3, z);
                        }
                    }
                } else if (i6 == 3 && dVar3.v >= 0 && dVar3.u >= 0) {
                    if (dVar3.g0 == 8 || (dVar3.r == 0 && dVar3.W == 0.0f)) {
                        if (!dVar3.x() && !dVar3.F && z4 && !dVar3.x()) {
                            d(i4, dVar, eVar, dVar3, z);
                        }
                    }
                }
            }
        }
        dVar.m = true;
    }

    public static void c(int i, a6.e eVar, x5.d dVar, boolean z) {
        float f2 = dVar.d0;
        c cVar = dVar.I;
        int iD = cVar.f686f.d();
        c cVar2 = dVar.K;
        int iD2 = cVar2.f686f.d();
        int iE = cVar.e() + iD;
        int iE2 = iD2 - cVar2.e();
        if (iD == iD2) {
            f2 = 0.5f;
        } else {
            iD = iE;
            iD2 = iE2;
        }
        int iQ = dVar.q();
        int i2 = (iD2 - iD) - iQ;
        if (iD > iD2) {
            i2 = (iD - iD2) - iQ;
        }
        int i3 = ((int) (i2 > 0 ? (f2 * i2) + 0.5f : f2 * i2)) + iD;
        int i4 = i3 + iQ;
        if (iD > iD2) {
            i4 = i3 - iQ;
        }
        dVar.J(i3, i4);
        b(i + 1, eVar, dVar, z);
    }

    public static void d(int i, x5.d dVar, a6.e eVar, x5.d dVar2, boolean z) {
        float f2 = dVar2.d0;
        c cVar = dVar2.I;
        int iE = cVar.e() + cVar.f686f.d();
        c cVar2 = dVar2.K;
        int iD = cVar2.f686f.d() - cVar2.e();
        if (iD >= iE) {
            int iQ = dVar2.q();
            if (dVar2.g0 != 8) {
                int i2 = dVar2.r;
                if (i2 == 2) {
                    iQ = (int) (dVar2.d0 * 0.5f * (dVar instanceof e ? dVar.q() : dVar.T.q()));
                } else if (i2 == 0) {
                    iQ = iD - iE;
                }
                iQ = Math.max(dVar2.u, iQ);
                int i3 = dVar2.v;
                if (i3 > 0) {
                    iQ = Math.min(i3, iQ);
                }
            }
            int i4 = iE + ((int) ((f2 * ((iD - iE) - iQ)) + 0.5f));
            dVar2.J(i4, iQ + i4);
            b(i + 1, eVar, dVar2, z);
        }
    }

    public static void e(int i, a6.e eVar, x5.d dVar) {
        float f2 = dVar.e0;
        c cVar = dVar.J;
        int iD = cVar.f686f.d();
        c cVar2 = dVar.L;
        int iD2 = cVar2.f686f.d();
        int iE = cVar.e() + iD;
        int iE2 = iD2 - cVar2.e();
        if (iD == iD2) {
            f2 = 0.5f;
        } else {
            iD = iE;
            iD2 = iE2;
        }
        int iK = dVar.k();
        int i2 = (iD2 - iD) - iK;
        if (iD > iD2) {
            i2 = (iD - iD2) - iK;
        }
        int i3 = (int) (i2 > 0 ? (f2 * i2) + 0.5f : f2 * i2);
        int i4 = iD + i3;
        int i6 = i4 + iK;
        if (iD > iD2) {
            i4 = iD - i3;
            i6 = i4 - iK;
        }
        dVar.K(i4, i6);
        g(i + 1, eVar, dVar);
    }

    public static void f(int i, x5.d dVar, a6.e eVar, x5.d dVar2) {
        float f2 = dVar2.e0;
        c cVar = dVar2.J;
        int iE = cVar.e() + cVar.f686f.d();
        c cVar2 = dVar2.L;
        int iD = cVar2.f686f.d() - cVar2.e();
        if (iD >= iE) {
            int iK = dVar2.k();
            if (dVar2.g0 != 8) {
                int i2 = dVar2.s;
                if (i2 == 2) {
                    iK = (int) (f2 * 0.5f * (dVar instanceof e ? dVar.k() : dVar.T.k()));
                } else if (i2 == 0) {
                    iK = iD - iE;
                }
                iK = Math.max(dVar2.x, iK);
                int i3 = dVar2.y;
                if (i3 > 0) {
                    iK = Math.min(i3, iK);
                }
            }
            int i4 = iE + ((int) ((f2 * ((iD - iE) - iK)) + 0.5f));
            dVar2.K(i4, iK + i4);
            g(i + 1, eVar, dVar2);
        }
    }

    public static void g(int i, a6.e eVar, x5.d dVar) {
        boolean z;
        c cVar;
        c cVar2;
        c cVar3;
        c cVar4;
        if (dVar.n) {
            return;
        }
        if (!(dVar instanceof e) && dVar.z() && a(dVar)) {
            e.V(dVar, eVar, new b());
        }
        c cVarI = dVar.i(3);
        c cVarI2 = dVar.i(5);
        int iD = cVarI.d();
        int iD2 = cVarI2.d();
        HashSet<c> hashSet = cVarI.a;
        if (hashSet != null && cVarI.c) {
            for (c cVar5 : hashSet) {
                x5.d dVar2 = cVar5.d;
                int i2 = i + 1;
                boolean zA = a(dVar2);
                c cVar6 = dVar2.J;
                c cVar7 = dVar2.L;
                if (dVar2.z() && zA) {
                    e.V(dVar2, eVar, new b());
                }
                boolean z2 = (cVar5 == cVar6 && (cVar4 = cVar7.f686f) != null && cVar4.c) || (cVar5 == cVar7 && (cVar3 = cVar6.f686f) != null && cVar3.c);
                int i3 = dVar2.p0[1];
                if (i3 != 3 || zA) {
                    if (!dVar2.z()) {
                        if (cVar5 == cVar6 && cVar7.f686f == null) {
                            int iE = cVar6.e() + iD;
                            dVar2.K(iE, dVar2.k() + iE);
                            g(i2, eVar, dVar2);
                        } else if (cVar5 == cVar7 && cVar6.f686f == null) {
                            int iE2 = iD - cVar7.e();
                            dVar2.K(iE2 - dVar2.k(), iE2);
                            g(i2, eVar, dVar2);
                        } else if (z2 && !dVar2.y()) {
                            e(i2, eVar, dVar2);
                        }
                    }
                } else if (i3 == 3 && dVar2.y >= 0 && dVar2.x >= 0 && (dVar2.g0 == 8 || (dVar2.s == 0 && dVar2.W == 0.0f))) {
                    if (!dVar2.y() && !dVar2.F && z2 && !dVar2.y()) {
                        f(i2, dVar, eVar, dVar2);
                    }
                }
            }
        }
        boolean z3 = true;
        z3 = true;
        z3 = true;
        if (dVar instanceof h) {
            return;
        }
        HashSet<c> hashSet2 = cVarI2.a;
        if (hashSet2 != null && cVarI2.c) {
            for (c cVar8 : hashSet2) {
                x5.d dVar3 = cVar8.d;
                int i4 = i + 1;
                boolean zA2 = a(dVar3);
                c cVar9 = dVar3.J;
                c cVar10 = dVar3.L;
                if (dVar3.z() && zA2) {
                    e.V(dVar3, eVar, new b());
                }
                boolean z4 = (cVar8 == cVar9 && (cVar2 = cVar10.f686f) != null && cVar2.c) || (cVar8 == cVar10 && (cVar = cVar9.f686f) != null && cVar.c);
                int i6 = dVar3.p0[1];
                if (i6 != 3 || zA2) {
                    if (!dVar3.z()) {
                        if (cVar8 == cVar9 && cVar10.f686f == null) {
                            int iE3 = cVar9.e() + iD2;
                            dVar3.K(iE3, dVar3.k() + iE3);
                            g(i4, eVar, dVar3);
                        } else if (cVar8 == cVar10 && cVar9.f686f == null) {
                            int iE4 = iD2 - cVar10.e();
                            dVar3.K(iE4 - dVar3.k(), iE4);
                            g(i4, eVar, dVar3);
                        } else if (z4 && !dVar3.y()) {
                            e(i4, eVar, dVar3);
                        }
                    }
                } else if (i6 == 3 && dVar3.y >= 0 && dVar3.x >= 0 && (dVar3.g0 == 8 || (dVar3.s == 0 && dVar3.W == 0.0f))) {
                    if (!dVar3.y() && !dVar3.F && z4 && !dVar3.y()) {
                        f(i4, dVar, eVar, dVar3);
                    }
                }
            }
        }
        c cVarI3 = dVar.i(6);
        if (cVarI3.a != null && cVarI3.c) {
            int iD3 = cVarI3.d();
            for (c cVar11 : cVarI3.a) {
                x5.d dVar4 = cVar11.d;
                int i7 = i + 1;
                boolean zA3 = a(dVar4);
                c cVar12 = dVar4.M;
                if (dVar4.z() && zA3) {
                    e.V(dVar4, eVar, new b());
                }
                if (dVar4.p0[z3 ? 1 : 0] != 3 || zA3) {
                    if (!dVar4.z()) {
                        if (cVar11 == cVar12) {
                            int iE5 = cVar11.e() + iD3;
                            if (dVar4.E) {
                                int i8 = iE5 - dVar4.a0;
                                int i9 = dVar4.V + i8;
                                dVar4.Z = i8;
                                dVar4.J.l(i8);
                                dVar4.L.l(i9);
                                cVar12.l(iE5);
                                z = z3 ? 1 : 0;
                                dVar4.l = z;
                            } else {
                                z = z3 ? 1 : 0;
                            }
                            g(i7, eVar, dVar4);
                        }
                        z3 = z;
                    }
                }
                z = z3 ? 1 : 0;
                z3 = z;
            }
        }
        dVar.n = z3;
    }
}
