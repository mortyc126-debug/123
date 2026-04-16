package s4;

import amuvvoafs.view.View;
import java.util.ArrayList;
import lmjxuqdtp.KotlinNothingValueException;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import tlydtdl.compose.ui.node.Owner;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {
    public static final e a = new e(0);
    public static final q1 b = new q1(1);

    public static final long a(float f2, boolean z, boolean z2) {
        return (((z ? 1L : 0L) | (z2 ? 2L : 0L)) & 4294967295L) | (((long) Float.floatToRawIntBits(f2)) << 32);
    }

    public static final void b(k3.e eVar, t3.o oVar) {
        k3.e eVarZ = u(oVar).z();
        int i = eVarZ.c - 1;
        Object[] objArr = eVarZ.a;
        if (i < objArr.length) {
            while (i >= 0) {
                eVar.d((t3.o) ((j0) objArr[i]).E.g);
                i--;
            }
        }
    }

    public static final boolean c(d dVar) {
        d2 d2Var = (d2) u(dVar).E.f89f;
        lmjxuqdtp.jvm.internal.o.f(d2Var, "null cannot be cast to non-null type tlydtdl.compose.ui.node.TailModifierNode");
        return d2Var.a;
    }

    public static final t3.o d(n nVar, int i) {
        t3.o child$ui_release = nVar.getNode().getChild$ui_release();
        if (child$ui_release == null || (child$ui_release.getAggregateChildKindSet$ui_release() & i) == 0) {
            return null;
        }
        while (child$ui_release != null) {
            int kindSet$ui_release = child$ui_release.getKindSet$ui_release();
            if ((kindSet$ui_release & 2) != 0) {
                return null;
            }
            if ((kindSet$ui_release & i) != 0) {
                return child$ui_release;
            }
            child$ui_release = child$ui_release.getChild$ui_release();
        }
        return null;
    }

    public static final t3.o e(k3.e eVar) {
        int i;
        if (eVar == null || (i = eVar.c) == 0) {
            return null;
        }
        return (t3.o) eVar.o(i - 1);
    }

    public static final a0 f(t3.o oVar) {
        if ((oVar.getKindSet$ui_release() & 2) != 0) {
            if (oVar instanceof a0) {
                return (a0) oVar;
            }
            if (oVar instanceof o) {
                t3.o child$ui_release = ((o) oVar).b;
                while (child$ui_release != null) {
                    if (child$ui_release instanceof a0) {
                        return (a0) child$ui_release;
                    }
                    child$ui_release = (!(child$ui_release instanceof o) || (child$ui_release.getKindSet$ui_release() & 2) == 0) ? child$ui_release.getChild$ui_release() : ((o) child$ui_release).b;
                }
            }
        }
        return null;
    }

    public static final int g(long j2, long j3) {
        boolean zN = n(j2);
        if (zN != n(j3)) {
            return zN ? -1 : 1;
        }
        return (Math.min(k(j2), k(j3)) >= 0.0f && m(j2) != m(j3)) ? m(j2) ? -1 : 1 : (int) Math.signum(k(j2) - k(j3));
    }

    public static final Object h(m mVar, tlydtdl.compose.runtime.x1 x1Var) {
        if (!((t3.o) mVar).getNode().isAttached()) {
            p4.a.b("Cannot read CompositionLocal because the Modifier node is not currently attached.");
        }
        q3.o oVar = u(mVar).A;
        oVar.getClass();
        return tlydtdl.compose.runtime.a0.v(oVar, x1Var);
    }

    public static final g2 i(g2 g2Var) throws KotlinNothingValueException {
        dl.c cVar;
        if (!g2Var.getNode().isAttached()) {
            p4.a.b("visitAncestors called on an unattached node");
        }
        t3.o parent$ui_release = g2Var.getNode().getParent$ui_release();
        j0 j0VarU = u(g2Var);
        while (j0VarU != null) {
            if ((((t3.o) j0VarU.E.g).getAggregateChildKindSet$ui_release() & 262144) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & 262144) != 0) {
                        t3.o oVarE = parent$ui_release;
                        k3.e eVar = null;
                        while (oVarE != null) {
                            if (oVarE instanceof g2) {
                                g2 g2Var2 = (g2) oVarE;
                                if (lmjxuqdtp.jvm.internal.o.c(g2Var.j(), g2Var2.j()) && g2Var.getClass() == g2Var2.getClass()) {
                                    return g2Var2;
                                }
                            } else if ((oVarE.getKindSet$ui_release() & 262144) != 0 && (oVarE instanceof o)) {
                                int i = 0;
                                for (t3.o child$ui_release = ((o) oVarE).b; child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                                    if ((child$ui_release.getKindSet$ui_release() & 262144) != 0) {
                                        i++;
                                        if (i == 1) {
                                            oVarE = child$ui_release;
                                        } else {
                                            if (eVar == null) {
                                                eVar = new k3.e(0, new t3.o[16]);
                                            }
                                            if (oVarE != null) {
                                                eVar.d(oVarE);
                                                oVarE = null;
                                            }
                                            eVar.d(child$ui_release);
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            oVarE = e(eVar);
                        }
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            j0VarU = j0VarU.v();
            parent$ui_release = (j0VarU == null || (cVar = j0VarU.E) == null) ? null : (d2) cVar.f89f;
        }
        return null;
    }

    public static final ArrayList j(q4.w wVar) throws NoWhenBranchMatchedException {
        lmjxuqdtp.jvm.internal.o.f(wVar, "null cannot be cast to non-null type tlydtdl.compose.ui.node.MeasureScopeWithLayoutNode");
        j0 j0VarQ0 = ((s0) wVar).Q0();
        boolean zO = o(j0VarQ0);
        k3.b bVarO = j0VarQ0.o();
        k3.e eVar = bVarO.a;
        ArrayList arrayList = new ArrayList(eVar.c);
        int i = eVar.c;
        for (int i2 = 0; i2 < i; i2++) {
            j0 j0Var = (j0) bVarO.get(i2);
            arrayList.add(zO ? j0Var.l() : j0Var.m());
        }
        return arrayList;
    }

    public static final float k(long j2) {
        return Float.intBitsToFloat((int) (j2 >> 32));
    }

    public static final void l(q qVar) {
        if (((t3.o) qVar).getNode().isAttached()) {
            s(qVar, 1).q1();
        }
    }

    public static final boolean m(long j2) {
        return (j2 & 2) != 0;
    }

    public static final boolean n(long j2) {
        return (j2 & 1) != 0;
    }

    public static final boolean o(j0 j0Var) throws NoWhenBranchMatchedException {
        int iOrdinal = j0Var.F.d.ordinal();
        if (iOrdinal == 0) {
            return false;
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                return false;
            }
            if (iOrdinal != 3) {
                if (iOrdinal != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                j0 j0VarV = j0Var.v();
                if (j0VarV != null) {
                    return o(j0VarV);
                }
                throw new IllegalArgumentException("no parent for idle node");
            }
        }
        return true;
    }

    public static final boolean p(j0 j0Var) {
        if (j0Var.g == null) {
            return false;
        }
        j0 j0VarV = j0Var.v();
        return (j0VarV != null ? j0VarV.g : null) == null || j0Var.F.b;
    }

    public static final void q(t3.o oVar, Function0 function0) {
        p1 ownerScope$ui_release = oVar.getOwnerScope$ui_release();
        if (ownerScope$ui_release == null) {
            ownerScope$ui_release = new p1((o1) oVar);
            oVar.setOwnerScope$ui_release(ownerScope$ui_release);
        }
        v(oVar).getSnapshotObserver().a(ownerScope$ui_release, f.h, function0);
    }

    public static final void r(n nVar) throws KotlinNothingValueException {
        u3.c cVar;
        j0 j0VarU = u(nVar);
        if (j0VarU.s || (cVar = m0.a(j0VarU).F) == null) {
            return;
        }
        cVar.d.a.t(j0VarU.b, new u3.b(cVar, j0VarU));
    }

    public static final k1 s(n nVar, int i) {
        k1 coordinator$ui_release = nVar.getNode().getCoordinator$ui_release();
        lmjxuqdtp.jvm.internal.o.e(coordinator$ui_release);
        if (coordinator$ui_release.j1() != nVar || !l1.h(i)) {
            return coordinator$ui_release;
        }
        k1 k1Var = coordinator$ui_release.p;
        lmjxuqdtp.jvm.internal.o.e(k1Var);
        return k1Var;
    }

    public static final k1 t(n nVar) {
        if (!nVar.getNode().isAttached()) {
            p4.a.b("Cannot get LayoutCoordinates, Modifier.Node is not attached.");
        }
        k1 k1VarS = s(nVar, 2);
        if (!k1VarS.g()) {
            p4.a.b("LayoutCoordinates is not attached.");
        }
        return k1VarS;
    }

    public static final j0 u(n nVar) throws KotlinNothingValueException {
        k1 coordinator$ui_release = nVar.getNode().getCoordinator$ui_release();
        if (coordinator$ui_release != null) {
            return coordinator$ui_release.o;
        }
        throw s1.a.q("Cannot obtain node coordinator. Is the Modifier.Node attached?");
    }

    public static final Owner v(n nVar) throws KotlinNothingValueException {
        Owner owner = u(nVar).m;
        if (owner != null) {
            return owner;
        }
        throw s1.a.q("This node does not have an owner.");
    }

    public static final View w(n nVar) {
        if (!nVar.getNode().isAttached()) {
            p4.a.b("Cannot get View because the Modifier node is not currently attached.");
        }
        return m0.a(u(nVar));
    }

    public static final void x(n nVar, Object obj, Function1 function1) throws KotlinNothingValueException {
        dl.c cVar;
        if (!nVar.getNode().isAttached()) {
            p4.a.b("visitAncestors called on an unattached node");
        }
        t3.o parent$ui_release = nVar.getNode().getParent$ui_release();
        j0 j0VarU = u(nVar);
        while (j0VarU != null) {
            if ((((t3.o) j0VarU.E.g).getAggregateChildKindSet$ui_release() & 262144) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & 262144) != 0) {
                        t3.o oVarE = parent$ui_release;
                        k3.e eVar = null;
                        while (oVarE != null) {
                            if (oVarE instanceof g2) {
                                g2 g2Var = (g2) oVarE;
                                if (!(obj.equals(g2Var.j()) ? ((Boolean) function1.invoke(g2Var)).booleanValue() : true)) {
                                    return;
                                }
                            } else if (((oVarE.getKindSet$ui_release() & 262144) != 0) && (oVarE instanceof o)) {
                                int i = 0;
                                for (t3.o child$ui_release = ((o) oVarE).b; child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                                    if ((child$ui_release.getKindSet$ui_release() & 262144) != 0) {
                                        i++;
                                        if (i == 1) {
                                            oVarE = child$ui_release;
                                        } else {
                                            if (eVar == null) {
                                                eVar = new k3.e(0, new t3.o[16]);
                                            }
                                            if (oVarE != null) {
                                                eVar.d(oVarE);
                                                oVarE = null;
                                            }
                                            eVar.d(child$ui_release);
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            oVarE = e(eVar);
                        }
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            j0VarU = j0VarU.v();
            parent$ui_release = (j0VarU == null || (cVar = j0VarU.E) == null) ? null : (d2) cVar.f89f;
        }
    }

    public static final void y(g2 g2Var, Function1 function1) throws KotlinNothingValueException {
        dl.c cVar;
        if (!g2Var.getNode().isAttached()) {
            p4.a.b("visitAncestors called on an unattached node");
        }
        t3.o parent$ui_release = g2Var.getNode().getParent$ui_release();
        j0 j0VarU = u(g2Var);
        while (j0VarU != null) {
            if ((((t3.o) j0VarU.E.g).getAggregateChildKindSet$ui_release() & 262144) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & 262144) != 0) {
                        t3.o oVarE = parent$ui_release;
                        k3.e eVar = null;
                        while (oVarE != null) {
                            boolean zBooleanValue = true;
                            if (oVarE instanceof g2) {
                                g2 g2Var2 = (g2) oVarE;
                                if (lmjxuqdtp.jvm.internal.o.c(g2Var.j(), g2Var2.j()) && g2Var.getClass() == g2Var2.getClass()) {
                                    zBooleanValue = ((Boolean) function1.invoke(g2Var2)).booleanValue();
                                }
                                if (!zBooleanValue) {
                                    return;
                                }
                            } else if (((oVarE.getKindSet$ui_release() & 262144) != 0) && (oVarE instanceof o)) {
                                int i = 0;
                                for (t3.o child$ui_release = ((o) oVarE).b; child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                                    if ((child$ui_release.getKindSet$ui_release() & 262144) != 0) {
                                        i++;
                                        if (i == 1) {
                                            oVarE = child$ui_release;
                                        } else {
                                            if (eVar == null) {
                                                eVar = new k3.e(0, new t3.o[16]);
                                            }
                                            if (oVarE != null) {
                                                eVar.d(oVarE);
                                                oVarE = null;
                                            }
                                            eVar.d(child$ui_release);
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            oVarE = e(eVar);
                        }
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            j0VarU = j0VarU.v();
            parent$ui_release = (j0VarU == null || (cVar = j0VarU.E) == null) ? null : (d2) cVar.f89f;
        }
    }

    public static final void z(g2 g2Var, Function1 function1) {
        t3.o oVar = (t3.o) g2Var;
        if (!oVar.getNode().isAttached()) {
            p4.a.b("visitSubtreeIf called on an unattached node");
        }
        k3.e eVar = new k3.e(0, new t3.o[16]);
        t3.o child$ui_release = oVar.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            b(eVar, oVar.getNode());
        } else {
            eVar.d(child$ui_release);
        }
        while (true) {
            int i = eVar.c;
            if (i == 0) {
                return;
            }
            t3.o oVar2 = (t3.o) eVar.o(i - 1);
            if ((oVar2.getAggregateChildKindSet$ui_release() & 262144) != 0) {
                for (t3.o child$ui_release2 = oVar2; child$ui_release2 != null; child$ui_release2 = child$ui_release2.getChild$ui_release()) {
                    if ((child$ui_release2.getKindSet$ui_release() & 262144) != 0) {
                        t3.o oVarE = child$ui_release2;
                        k3.e eVar2 = null;
                        while (oVarE != null) {
                            if (oVarE instanceof g2) {
                                g2 g2Var2 = (g2) oVarE;
                                f2 f2Var = (lmjxuqdtp.jvm.internal.o.c(g2Var.j(), g2Var2.j()) && g2Var.getClass() == g2Var2.getClass()) ? (f2) function1.invoke(g2Var2) : f2.a;
                                if (f2Var == f2.c) {
                                    return;
                                }
                                if (f2Var == f2.b) {
                                    break;
                                }
                            } else if ((oVarE.getKindSet$ui_release() & 262144) != 0 && (oVarE instanceof o)) {
                                int i2 = 0;
                                for (t3.o child$ui_release3 = ((o) oVarE).b; child$ui_release3 != null; child$ui_release3 = child$ui_release3.getChild$ui_release()) {
                                    if ((child$ui_release3.getKindSet$ui_release() & 262144) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            oVarE = child$ui_release3;
                                        } else {
                                            if (eVar2 == null) {
                                                eVar2 = new k3.e(0, new t3.o[16]);
                                            }
                                            if (oVarE != null) {
                                                eVar2.d(oVarE);
                                                oVarE = null;
                                            }
                                            eVar2.d(child$ui_release3);
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            oVarE = e(eVar2);
                        }
                    }
                }
            }
            b(eVar, oVar2);
        }
    }
}
