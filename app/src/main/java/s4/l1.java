package s4;

import lmjxuqdtp.KotlinNothingValueException;
import lmjxuqdtp.NoWhenBranchMatchedException;
import m4.z;
import okhttp3.internal.http2.Http2;
import q4.i1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l1 {
    public static final q1.f0 a;

    static {
        q1.f0 f0Var = q1.s0.a;
        a = new q1.f0();
    }

    public static final void a(t3.o oVar) {
        if (!oVar.isAttached()) {
            p4.a.b("autoInvalidateInsertedNode called on unattached node");
        }
        b(oVar, -1, 1);
    }

    public static final void b(t3.o oVar, int i, int i2) {
        if (!(oVar instanceof o)) {
            c(oVar, i & oVar.getKindSet$ui_release(), i2);
            return;
        }
        o oVar2 = (o) oVar;
        int i3 = oVar2.a;
        c(oVar, i3 & i, i2);
        int i4 = (~i3) & i;
        for (t3.o child$ui_release = oVar2.b; child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
            b(child$ui_release, i4, i2);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public static final void c(t3.o oVar, int i, int i2) throws NoWhenBranchMatchedException, KotlinNothingValueException {
        if (i2 != 0 || oVar.getShouldAutoInvalidate()) {
            if ((i & 2) != 0 && (oVar instanceof a0)) {
                g.u((a0) oVar).E();
                if (i2 == 2) {
                    g.s(oVar, 2).w1();
                }
            }
            if ((i & 128) != 0 && (oVar instanceof y) && i2 != 2) {
                g.u(oVar).E();
            }
            if ((i & 256) != 0 && (oVar instanceof r)) {
                if (i2 == 1) {
                    j0 j0VarU = g.u(oVar);
                    j0VarU.e0(j0VarU.O + 1);
                } else if (i2 == 2) {
                    g.u(oVar).e0(r0.O - 1);
                }
                if (i2 != 2) {
                    j0 j0VarU2 = g.u(oVar);
                    if (j0VarU2.O != 0 && !j0VarU2.p() && !j0VarU2.q() && !j0VarU2.N) {
                        t4.x xVarA = m0.a(j0VarU2);
                        eu0.k kVar = xVarA.O.e;
                        kVar.getClass();
                        if (j0VarU2.O > 0) {
                            ((k3.e) kVar.b).d(j0VarU2);
                            j0VarU2.N = true;
                        }
                        xVarA.B((j0) null);
                    }
                }
            }
            if ((i & 4) != 0 && (oVar instanceof q)) {
                g.l((q) oVar);
            }
            if ((i & 8) != 0 && (oVar instanceof b2)) {
                g.u(oVar).q = true;
            }
            if ((i & 64) != 0 && (oVar instanceof v1)) {
                n0 n0Var = g.u((v1) oVar).F;
                n0Var.p.q = true;
                x0 x0Var = n0Var.q;
                if (x0Var != null) {
                    x0Var.v = true;
                }
            }
            if ((i & 2048) != 0 && (oVar instanceof y3.r)) {
                t3.o oVar2 = (y3.r) oVar;
                h.b = null;
                oVar2.M0(h.a);
                if (h.b != null) {
                    t3.o oVar3 = oVar2;
                    if (!oVar3.getNode().isAttached()) {
                        p4.a.b("visitChildren called on an unattached node");
                    }
                    k3.e eVar = new k3.e(0, new t3.o[16]);
                    t3.o child$ui_release = oVar3.getNode().getChild$ui_release();
                    if (child$ui_release == null) {
                        g.b(eVar, oVar3.getNode());
                    } else {
                        eVar.d(child$ui_release);
                    }
                    while (true) {
                        int i3 = eVar.c;
                        if (i3 == 0) {
                            break;
                        }
                        t3.o oVarE = (t3.o) eVar.o(i3 - 1);
                        if ((oVarE.getAggregateChildKindSet$ui_release() & 1024) == 0) {
                            g.b(eVar, oVarE);
                        } else {
                            while (true) {
                                if (oVarE == null) {
                                    break;
                                }
                                if ((oVarE.getKindSet$ui_release() & 1024) != 0) {
                                    k3.e eVar2 = null;
                                    while (oVarE != null) {
                                        if (oVarE instanceof y3.a0) {
                                            y3.a0 a0Var = (y3.a0) oVarE;
                                            y3.h hVar = g.v(a0Var).getFocusOwner().d;
                                            if (hVar.c.a(a0Var)) {
                                                hVar.a();
                                            }
                                        } else if ((oVarE.getKindSet$ui_release() & 1024) != 0 && (oVarE instanceof o)) {
                                            int i4 = 0;
                                            for (t3.o child$ui_release2 = ((o) oVarE).b; child$ui_release2 != null; child$ui_release2 = child$ui_release2.getChild$ui_release()) {
                                                if ((child$ui_release2.getKindSet$ui_release() & 1024) != 0) {
                                                    i4++;
                                                    if (i4 == 1) {
                                                        oVarE = child$ui_release2;
                                                    } else {
                                                        if (eVar2 == null) {
                                                            eVar2 = new k3.e(0, new t3.o[16]);
                                                        }
                                                        if (oVarE != null) {
                                                            eVar2.d(oVarE);
                                                            oVarE = null;
                                                        }
                                                        eVar2.d(child$ui_release2);
                                                    }
                                                }
                                            }
                                            if (i4 == 1) {
                                            }
                                        }
                                        oVarE = g.e(eVar2);
                                    }
                                } else {
                                    oVarE = oVarE.getChild$ui_release();
                                }
                            }
                        }
                    }
                }
            }
            if ((i & 4096) == 0 || !(oVar instanceof y3.e)) {
                return;
            }
            y3.e eVar3 = (y3.e) oVar;
            y3.h hVar2 = g.v(eVar3).getFocusOwner().d;
            if (hVar2.d.a(eVar3)) {
                hVar2.a();
            }
        }
    }

    public static final void d(t3.o oVar) {
        if (!oVar.isAttached()) {
            p4.a.b("autoInvalidateUpdatedNode called on unattached node");
        }
        b(oVar, -1, 0);
    }

    public static final int e(t3.n nVar) {
        int i = nVar instanceof q4.e0 ? 3 : 1;
        if (nVar instanceof x3.e) {
            i |= 4;
        }
        if (nVar instanceof a5.l) {
            i |= 8;
        }
        if (nVar instanceof z) {
            i |= 16;
        }
        if ((nVar instanceof r4.c) || (nVar instanceof r4.f)) {
            i |= 32;
        }
        if (nVar instanceof q4.d1) {
            i |= 256;
        }
        if (nVar instanceof i1) {
            i |= 64;
        }
        return nVar instanceof x4.a ? 524288 | i : i;
    }

    public static final int f(t3.o oVar) {
        if (oVar.getKindSet$ui_release() != 0) {
            return oVar.getKindSet$ui_release();
        }
        Class<?> cls = oVar.getClass();
        q1.f0 f0Var = a;
        int iD = f0Var.d(cls);
        if (iD >= 0) {
            return f0Var.c[iD];
        }
        int i = oVar instanceof a0 ? 3 : 1;
        if (oVar instanceof q) {
            i |= 4;
        }
        if (oVar instanceof b2) {
            i |= 8;
        }
        if (oVar instanceof x1) {
            i |= 16;
        }
        if (oVar instanceof r4.e) {
            i |= 32;
        }
        if (oVar instanceof v1) {
            i |= 64;
        }
        if (oVar instanceof y) {
            i |= 128;
        }
        if (oVar instanceof r) {
            i |= 256;
        }
        if (oVar instanceof y3.a0) {
            i |= 1024;
        }
        if (oVar instanceof y3.r) {
            i |= 2048;
        }
        if (oVar instanceof y3.e) {
            i |= 4096;
        }
        if (oVar instanceof k4.d) {
            i |= 8192;
        }
        if (oVar instanceof o4.a) {
            i |= Http2.INITIAL_MAX_FRAME_SIZE;
        }
        if (oVar instanceof m) {
            i |= 32768;
        }
        if (oVar instanceof g2) {
            i |= 262144;
        }
        if (oVar instanceof x4.a) {
            i |= 524288;
        }
        f0Var.h(i, cls);
        return i;
    }

    public static final int g(t3.o oVar) {
        if (!(oVar instanceof o)) {
            return f(oVar);
        }
        o oVar2 = (o) oVar;
        int iG = oVar2.a;
        for (t3.o child$ui_release = oVar2.b; child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
            iG |= g(child$ui_release);
        }
        return iG;
    }

    public static final boolean h(int i) {
        return (i & 128) != 0;
    }
}
