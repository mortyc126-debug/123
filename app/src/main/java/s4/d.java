package s4;

import amuvvoafs.os.SystemClock;
import com.gnacba.amuvvoafs.gms.internal.ads.cy;
import java.util.HashSet;
import lmjxuqdtp.KotlinNothingValueException;
import m4.z;
import q4.i1;
import q4.m1;
import q4.v0;
import q4.w0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends t3.o implements a0, q, b2, x1, r4.e, r4.g, v1, y, r, y3.e, y3.r, y3.u, t1, x3.a {
    public t3.n a;
    public r4.a b;
    public HashSet c;

    @Override // s4.x1
    public final void A() {
        z zVar = this.a;
        lmjxuqdtp.jvm.internal.o.f(zVar, "null cannot be cast to non-null type tlydtdl.compose.ui.input.pointer.PointerInputModifier");
        zVar.d.getClass();
    }

    @Override // r4.e
    public final uz1.g G() {
        r4.a aVar = this.b;
        return aVar != null ? aVar : r4.b.a;
    }

    @Override // s4.x1
    public final boolean I0() {
        z zVar = this.a;
        lmjxuqdtp.jvm.internal.o.f(zVar, "null cannot be cast to non-null type tlydtdl.compose.ui.input.pointer.PointerInputModifier");
        zVar.d.getClass();
        return true;
    }

    public final void M0(y3.n nVar) {
        t3.n nVar2 = this.a;
        p4.a.b("applyFocusProperties called on wrong node");
        f3.f2.y(nVar2);
        throw null;
    }

    public final void Q0(boolean z) {
        if (!isAttached()) {
            p4.a.b("initializeModifier called on unattached node");
        }
        q4.p1 p1Var = this.a;
        if ((getKindSet$ui_release() & 32) != 0) {
            if (p1Var instanceof r4.c) {
                sideEffect(new c(this, 0));
            }
            if (p1Var instanceof r4.f) {
                r4.f fVar = (r4.f) p1Var;
                r4.a aVar = this.b;
                if (aVar == null || !aVar.m(fVar.getKey())) {
                    r4.a aVar2 = new r4.a();
                    aVar2.a = fVar;
                    this.b = aVar2;
                    if (g.c(this)) {
                        r4.d modifierLocalManager = g.v(this).getModifierLocalManager();
                        r4.h key = fVar.getKey();
                        modifierLocalManager.b.d(this);
                        modifierLocalManager.c.d(key);
                        modifierLocalManager.a();
                    }
                } else {
                    aVar.a = fVar;
                    r4.d modifierLocalManager2 = g.v(this).getModifierLocalManager();
                    r4.h key2 = fVar.getKey();
                    modifierLocalManager2.b.d(this);
                    modifierLocalManager2.c.d(key2);
                    modifierLocalManager2.a();
                }
            }
        }
        if ((getKindSet$ui_release() & 4) != 0 && !z) {
            g.s(this, 2).q1();
        }
        if ((getKindSet$ui_release() & 2) != 0) {
            if (g.c(this)) {
                k1 coordinator$ui_release = getCoordinator$ui_release();
                lmjxuqdtp.jvm.internal.o.e(coordinator$ui_release);
                ((c0) coordinator$ui_release).M1(this);
                t4.y1 y1Var = coordinator$ui_release.I;
                if (y1Var != null) {
                    y1Var.invalidate();
                }
            }
            if (!z) {
                g.s(this, 2).q1();
                g.u(this).E();
            }
        }
        if (p1Var instanceof q4.p1) {
            p1Var.j0(g.u(this));
        }
        getKindSet$ui_release();
        if ((getKindSet$ui_release() & 256) != 0 && (p1Var instanceof q4.d1) && g.c(this)) {
            g.u(this).E();
        }
        if ((getKindSet$ui_release() & 16) != 0 && (p1Var instanceof z)) {
            ((z) p1Var).d.b = getCoordinator$ui_release();
        }
        if ((getKindSet$ui_release() & 8) != 0) {
            g.v(this).x();
        }
    }

    @Override // s4.y
    public final void R(q4.b0 b0Var) {
    }

    public final void R0() {
        if (!isAttached()) {
            p4.a.b("unInitializeModifier called on unattached node");
        }
        t3.n nVar = this.a;
        if ((getKindSet$ui_release() & 32) != 0) {
            if (nVar instanceof r4.f) {
                r4.d modifierLocalManager = g.v(this).getModifierLocalManager();
                r4.h key = ((r4.f) nVar).getKey();
                modifierLocalManager.d.d(g.u(this));
                modifierLocalManager.e.d(key);
                modifierLocalManager.a();
            }
            if (nVar instanceof r4.c) {
                ((r4.c) nVar).V(g.a);
            }
        }
        if ((getKindSet$ui_release() & 8) != 0) {
            g.v(this).x();
        }
    }

    public final void S0() {
        if (isAttached()) {
            this.c.clear();
            g.v(this).getSnapshotObserver().a(this, f.d, new c(this, 1));
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.Collection, java.util.List] */
    @Override // s4.x1
    public final void a0(m4.l lVar, m4.m mVar, long j2) {
        boolean z;
        boolean z2;
        boolean z3;
        z zVar = this.a;
        lmjxuqdtp.jvm.internal.o.f(zVar, "null cannot be cast to non-null type tlydtdl.compose.ui.input.pointer.PointerInputModifier");
        cy cyVar = zVar.d;
        z zVar2 = (z) cyVar.e;
        ?? r0 = lVar.a;
        int size = r0.size();
        for (int i = 0; i < size; i++) {
            m4.t tVar = (m4.t) r0.get(i);
            if (m4.r.a(tVar) || m4.r.c(tVar)) {
                z = false;
                break;
            }
        }
        z = true;
        if (!z) {
            z2 = false;
            break;
        }
        int size2 = r0.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (((m4.t) r0.get(i2)).b()) {
                z2 = false;
                break;
            }
        }
        z2 = true;
        if (zVar2.c) {
            z3 = true;
        } else {
            int size3 = r0.size();
            int i3 = 0;
            while (true) {
                if (i3 < size3) {
                    m4.t tVar2 = (m4.t) r0.get(i3);
                    if (m4.r.a(tVar2) || m4.r.c(tVar2)) {
                        break;
                    } else {
                        i3++;
                    }
                } else if (z2) {
                    break;
                } else {
                    z3 = false;
                }
            }
            z3 = true;
        }
        if (((m4.x) cyVar.c) != m4.x.c) {
            if (mVar == m4.m.a && z3) {
                cyVar.d = lVar;
                cyVar.h(lVar, !z || zVar2.c);
            }
            if (mVar == m4.m.b && z && lVar.equals((m4.l) cyVar.d) && zVar2.c) {
                int size4 = r0.size();
                for (int i4 = 0; i4 < size4; i4++) {
                    ((m4.t) r0.get(i4)).a();
                }
            }
            if (mVar == m4.m.c && !z3 && !lVar.equals((m4.l) cyVar.d)) {
                cyVar.h(lVar, true);
            }
        }
        if (mVar == m4.m.c) {
            int size5 = r0.size();
            int i6 = 0;
            while (true) {
                if (i6 >= size5) {
                    cyVar.c = m4.x.a;
                    ((z) cyVar.e).c = false;
                    cyVar.d = null;
                    break;
                } else if (!m4.r.c((m4.t) r0.get(i6))) {
                    break;
                } else {
                    i6++;
                }
            }
            if (lVar.equals((m4.l) cyVar.d) && z) {
                int size6 = r0.size();
                int i7 = 0;
                while (true) {
                    if (i7 >= size6) {
                        break;
                    }
                    if (!((m4.t) r0.get(i7)).b()) {
                        i7++;
                    } else if (!zVar2.c) {
                        cyVar.p(lVar);
                        return;
                    }
                }
                int size7 = r0.size();
                for (int i8 = 0; i8 < size7; i8++) {
                    ((m4.t) r0.get(i8)).a();
                }
            }
        }
    }

    @Override // s4.b2
    public final void b(a5.k kVar) {
        int i;
        a5.l lVar = this.a;
        lmjxuqdtp.jvm.internal.o.f(lVar, "null cannot be cast to non-null type tlydtdl.compose.ui.semantics.SemanticsModifier");
        a5.k kVarO0 = lVar.O0();
        lmjxuqdtp.jvm.internal.o.f(kVar, "null cannot be cast to non-null type tlydtdl.compose.ui.semantics.SemanticsConfiguration");
        q1.n0 n0Var = kVar.a;
        if (kVarO0.c) {
            kVar.c = true;
        }
        if (kVarO0.d) {
            kVar.d = true;
        }
        q1.n0 n0Var2 = kVarO0.a;
        Object[] objArr = n0Var2.b;
        Object[] objArr2 = n0Var2.c;
        long[] jArr = n0Var2.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            long j2 = jArr[i2];
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8;
                int i4 = 8 - ((~(i2 - length)) >>> 31);
                int i6 = 0;
                while (i6 < i4) {
                    if ((255 & j2) < 128) {
                        int i7 = (i2 << 3) + i6;
                        Object obj = objArr[i7];
                        Object obj2 = objArr2[i7];
                        a5.w wVar = (a5.w) obj;
                        if (!n0Var.b(wVar)) {
                            n0Var.m(wVar, obj2);
                        } else if (obj2 instanceof a5.a) {
                            Object objG = n0Var.g(wVar);
                            lmjxuqdtp.jvm.internal.o.f(objG, "null cannot be cast to non-null type tlydtdl.compose.ui.semantics.AccessibilityAction<*>");
                            a5.a aVar = (a5.a) objG;
                            i = i3;
                            String str = aVar.a;
                            if (str == null) {
                                str = ((a5.a) obj2).a;
                            }
                            lx1.e eVar = aVar.b;
                            if (eVar == null) {
                                eVar = ((a5.a) obj2).b;
                            }
                            n0Var.m(wVar, new a5.a(str, eVar));
                        }
                        i = i3;
                    } else {
                        i = i3;
                    }
                    j2 >>= i;
                    i6++;
                    i3 = i;
                }
                if (i4 != i3) {
                    return;
                }
            }
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    @Override // s4.v1
    public final Object c(p5.c cVar, Object obj) {
        i1 i1Var = this.a;
        lmjxuqdtp.jvm.internal.o.f(i1Var, "null cannot be cast to non-null type tlydtdl.compose.ui.layout.ParentDataModifier");
        return i1Var.c(cVar, obj);
    }

    @Override // s4.r
    public final void d(k1 k1Var) {
        q4.d1 d1Var = this.a;
        lmjxuqdtp.jvm.internal.o.f(d1Var, "null cannot be cast to non-null type tlydtdl.compose.ui.layout.OnGloballyPositionedModifier");
        d1Var.d(k1Var);
    }

    public final p5.c e() {
        return g.u(this).x;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    @Override // r4.e, r4.g
    public final Object f(r4.h hVar) throws KotlinNothingValueException {
        dl.c cVar;
        this.c.add(hVar);
        if (!getNode().isAttached()) {
            p4.a.b("visitAncestors called on an unattached node");
        }
        t3.o parent$ui_release = getNode().getParent$ui_release();
        j0 j0VarU = g.u(this);
        while (j0VarU != null) {
            if ((((t3.o) j0VarU.E.g).getAggregateChildKindSet$ui_release() & 32) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & 32) != 0) {
                        t3.o oVarE = parent$ui_release;
                        k3.e eVar = null;
                        while (oVarE != null) {
                            if (oVarE instanceof r4.e) {
                                r4.e eVar2 = (r4.e) oVarE;
                                if (eVar2.G().m(hVar)) {
                                    return eVar2.G().s(hVar);
                                }
                            } else if ((oVarE.getKindSet$ui_release() & 32) != 0 && (oVarE instanceof o)) {
                                int i = 0;
                                for (t3.o child$ui_release = ((o) oVarE).b; child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                                    if ((child$ui_release.getKindSet$ui_release() & 32) != 0) {
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
                            oVarE = g.e(eVar);
                        }
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            j0VarU = j0VarU.v();
            parent$ui_release = (j0VarU == null || (cVar = j0VarU.E) == null) ? null : (d2) cVar.f89f;
        }
        return hVar.a.invoke();
    }

    @Override // s4.q
    public final void g(l0 l0Var) {
        x3.e eVar = this.a;
        lmjxuqdtp.jvm.internal.o.f(eVar, "null cannot be cast to non-null type tlydtdl.compose.ui.draw.DrawModifier");
        eVar.g(l0Var);
    }

    public final p5.n getLayoutDirection() {
        return g.u(this).y;
    }

    public final long h() {
        return ln1.e.P(((m1) g.s(this, 128)).c);
    }

    public final void l(y3.z zVar) {
        t3.n nVar = this.a;
        p4.a.b("onFocusEvent called on wrong node");
        f3.f2.y(nVar);
        throw null;
    }

    @Override // s4.y
    public final void m(long j2) {
    }

    @Override // s4.x1
    public final void m0() {
        z zVar = this.a;
        lmjxuqdtp.jvm.internal.o.f(zVar, "null cannot be cast to non-null type tlydtdl.compose.ui.input.pointer.PointerInputModifier");
        cy cyVar = zVar.d;
        m4.x xVar = (m4.x) cyVar.c;
        z zVar2 = (z) cyVar.e;
        if (xVar == m4.x.b) {
            m4.g0.a(SystemClock.uptimeMillis(), new m4.y(zVar2, 0));
            cyVar.c = m4.x.a;
            zVar2.c = false;
            cyVar.d = null;
        }
    }

    @Override // s4.a0
    public final int maxIntrinsicHeight(q4.w wVar, q4.v vVar, int i) {
        q4.e0 e0Var = this.a;
        lmjxuqdtp.jvm.internal.o.f(e0Var, "null cannot be cast to non-null type tlydtdl.compose.ui.layout.LayoutModifier");
        return e0Var.maxIntrinsicHeight(wVar, vVar, i);
    }

    @Override // s4.a0
    public final int maxIntrinsicWidth(q4.w wVar, q4.v vVar, int i) {
        q4.e0 e0Var = this.a;
        lmjxuqdtp.jvm.internal.o.f(e0Var, "null cannot be cast to non-null type tlydtdl.compose.ui.layout.LayoutModifier");
        return e0Var.maxIntrinsicWidth(wVar, vVar, i);
    }

    @Override // s4.a0
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final v0 mo1789measure3p2s80s(w0 w0Var, q4.t0 t0Var, long j2) {
        q4.e0 e0Var = this.a;
        lmjxuqdtp.jvm.internal.o.f(e0Var, "null cannot be cast to non-null type tlydtdl.compose.ui.layout.LayoutModifier");
        return e0Var.measure-3p2s80s(w0Var, t0Var, j2);
    }

    @Override // s4.a0
    public final int minIntrinsicHeight(q4.w wVar, q4.v vVar, int i) {
        q4.e0 e0Var = this.a;
        lmjxuqdtp.jvm.internal.o.f(e0Var, "null cannot be cast to non-null type tlydtdl.compose.ui.layout.LayoutModifier");
        return e0Var.minIntrinsicHeight(wVar, vVar, i);
    }

    @Override // s4.a0
    public final int minIntrinsicWidth(q4.w wVar, q4.v vVar, int i) {
        q4.e0 e0Var = this.a;
        lmjxuqdtp.jvm.internal.o.f(e0Var, "null cannot be cast to non-null type tlydtdl.compose.ui.layout.LayoutModifier");
        return e0Var.minIntrinsicWidth(wVar, vVar, i);
    }

    @Override // s4.q
    public final void o0() {
        g.l(this);
    }

    public final void onAttach() {
        Q0(true);
    }

    @Override // s4.n, s4.x1
    public final void onDensityChange() {
        if (this.a instanceof z) {
            m0();
        }
    }

    public final void onDetach() {
        R0();
    }

    public final String toString() {
        return this.a.toString();
    }
}
