package e80;

import a2.n3;
import a2.z0;
import a4.w0;
import aq1.b;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import dg1.d;
import i2.a0;
import i2.t;
import java.util.ArrayList;
import java.util.WeakHashMap;
import ld1.r;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function3;
import lmjxuqdtp.jvm.functions.Function4;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import sf1.g0;
import sf1.q;
import t3.p;
import t4.r1;
import tlydtdl.compose.foundation.layout.LayoutWeightElement;
import tlydtdl.compose.foundation.layout.c0;
import tlydtdl.compose.foundation.layout.e0;
import tlydtdl.compose.foundation.layout.e2;
import tlydtdl.compose.foundation.layout.j2;
import tlydtdl.compose.foundation.layout.l2;
import tlydtdl.compose.foundation.layout.o2;
import tlydtdl.compose.foundation.layout.v1;
import tlydtdl.compose.foundation.layout.x2;
import tlydtdl.compose.runtime.e1;
import tlydtdl.compose.runtime.f3;
import tlydtdl.compose.runtime.k1;
import tlydtdl.compose.runtime.s;
import tlydtdl.compose.runtime.u1;
import tlydtdl.compose.runtime.x0;
import tlydtdl.lifecycle.y;
import x10.v;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Function3 {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ Object b;
    public final /* synthetic */ e1 c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f97f;

    public /* synthetic */ f(f3 f3Var, e1 e1Var, un0.c cVar, f3 f3Var2, f3 f3Var3) {
        this.d = f3Var;
        this.c = e1Var;
        this.e = cVar;
        this.f97f = f3Var2;
        this.b = f3Var3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v18, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v17 */
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        boolean z;
        ?? r9;
        ?? r14;
        int i = this.a;
        x0 x0Var = tlydtdl.compose.runtime.l.a;
        b0 b0Var = b0.a;
        Object obj4 = this.b;
        Object obj5 = this.f97f;
        Object obj6 = this.e;
        e1 e1Var = this.c;
        Object obj7 = this.d;
        switch (i) {
            case 0:
                a aVar = (a) obj7;
                final a0 a0Var = (a0) obj6;
                final l lVar = (l) obj5;
                sf1.m mVar = (sf1.m) obj4;
                tlydtdl.compose.runtime.m mVar2 = (tlydtdl.compose.runtime.m) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                o.h((e2) obj, "contentPadding");
                s sVar = (s) mVar2;
                if (!sVar.W(iIntValue & 1, (iIntValue & 17) != 16)) {
                    sVar.Z();
                } else {
                    t3.m mVar3 = t3.m.a;
                    p pVarA = tlydtdl.compose.ui.platform.a.a(o2.e(mVar3, 1.0f), "feed-page");
                    e0 e0VarA = c0.a(tlydtdl.compose.foundation.layout.l.c, t3.c.m, sVar, 0);
                    int iHashCode = Long.hashCode(sVar.T);
                    u1 u1VarM = sVar.m();
                    p pVarX = j4.x(sVar, pVarA);
                    s4.l.f436d2.getClass();
                    s4.j jVar = s4.k.b;
                    sVar.j0();
                    if (sVar.S) {
                        sVar.l(jVar);
                    } else {
                        sVar.t0();
                    }
                    tlydtdl.compose.runtime.a0.y(sVar, e0VarA, s4.k.f435f);
                    tlydtdl.compose.runtime.a0.y(sVar, u1VarM, s4.k.e);
                    s4.i iVar = s4.k.g;
                    if (sVar.S || !o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                        i.x(iHashCode, sVar, iHashCode, iVar);
                    }
                    tlydtdl.compose.runtime.a0.y(sVar, pVarX, s4.k.d);
                    if (((Boolean) e1Var.getValue()).booleanValue()) {
                        z = false;
                        sVar.f0(-42947900);
                    } else {
                        sVar.f0(-38127121);
                        Object objR = sVar.R();
                        if (objR == x0Var) {
                            objR = tlydtdl.compose.runtime.a0.n(sVar);
                            sVar.q0(objR);
                        }
                        final ky1.a0 a0Var2 = (ky1.a0) objR;
                        ArrayList arrayList = aVar.b;
                        int iK = a0Var.k();
                        p pVarO = com.facebook.appevents.l.o(o2.e(mVar3, 1.0f), i.e(2131100885, 0, sVar, r.Companion), w0.a);
                        WeakHashMap weakHashMap = x2.v;
                        p pVarA2 = tlydtdl.compose.ui.platform.a.a(tlydtdl.compose.foundation.layout.m.O(pVarO, new v1(tlydtdl.compose.foundation.layout.e.e(sVar).k, 15)), "feed_tabs");
                        boolean zG = sVar.g(a0Var);
                        Object objR2 = sVar.R();
                        if (zG || objR2 == x0Var) {
                            z = false;
                            objR2 = new g(a0Var, 0);
                            sVar.q0(objR2);
                        } else {
                            z = false;
                        }
                        final int i2 = z ? 1 : 0;
                        b.g(arrayList, iK, pVarA2, (e2) null, (Function0) objR2, (Function3) null, q3.p.d(-1511967943, new Function4() { // from class: e80.h
                            public final Object invoke(Object obj8, Object obj9, Object obj10, Object obj11) {
                                int i3;
                                int i4;
                                switch (i2) {
                                    case 0:
                                        final a0 a0Var3 = (a0) a0Var;
                                        final l lVar2 = (l) lVar;
                                        final ky1.a0 a0Var4 = (ky1.a0) a0Var2;
                                        final int iIntValue2 = ((Integer) obj8).intValue();
                                        mf1.l lVar3 = (mf1.l) obj9;
                                        tlydtdl.compose.runtime.m mVar4 = (tlydtdl.compose.runtime.m) obj10;
                                        int iIntValue3 = ((Integer) obj11).intValue();
                                        o.h(lVar3, "tab");
                                        v vVar = lVar3.a;
                                        if ((iIntValue3 & 6) == 0) {
                                            i3 = (((s) mVar4).e(iIntValue2) ? 4 : 2) | iIntValue3;
                                        } else {
                                            i3 = iIntValue3;
                                        }
                                        if ((iIntValue3 & 48) == 0) {
                                            i3 |= ((s) mVar4).g(lVar3) ? 32 : 16;
                                        }
                                        s sVar2 = (s) mVar4;
                                        if (sVar2.W(i3 & 1, (i3 & 147) != 146)) {
                                            boolean z2 = iIntValue2 == a0Var3.k();
                                            d dVar = lVar3.b;
                                            Long l = lVar3.c;
                                            v.Companion.getClass();
                                            boolean zEquals = vVar.equals(new x10.r(2132020395));
                                            p pVarF = t3.m.a;
                                            if (zEquals) {
                                                pVarF = tlydtdl.compose.ui.layout.a.f(pVarF, bn1.c.i(lVar2.f101j, "trending_tab", null));
                                            }
                                            p pVar = pVarF;
                                            boolean zG2 = ((i3 & 14) == 4) | sVar2.g(a0Var3) | sVar2.g(lVar2) | sVar2.i(a0Var4);
                                            Object objR3 = sVar2.R();
                                            if (zG2 || objR3 == tlydtdl.compose.runtime.l.a) {
                                                objR3 = new Function0() { // from class: e80.e
                                                    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
                                                    public final Object invoke() throws NoWhenBranchMatchedException {
                                                        a0 a0Var5 = a0Var3;
                                                        int iK2 = a0Var5.k();
                                                        int i6 = iIntValue2;
                                                        if (i6 == iK2) {
                                                            lVar2.b.invoke();
                                                        } else {
                                                            ky1.c0.F(a0Var4, (qx1.i) null, (ky1.b0) null, new i(a0Var5, i6, null, 0), 3);
                                                        }
                                                        return b0.a;
                                                    }
                                                };
                                                sVar2.q0(objR3);
                                            }
                                            mf1.c.a.a(vVar, z2, pVar, dVar, l, false, (Function0) objR3, sVar2, 0, 64);
                                        } else {
                                            sVar2.Z();
                                        }
                                        break;
                                    case 1:
                                        a0 a0Var5 = (a0) a0Var;
                                        q1.a0 a0Var6 = (q1.a0) lVar;
                                        u00.a aVar2 = (u00.a) a0Var2;
                                        int iIntValue4 = ((Integer) obj9).intValue();
                                        tlydtdl.compose.runtime.m mVar5 = (tlydtdl.compose.runtime.m) obj10;
                                        int iIntValue5 = ((Integer) obj11).intValue();
                                        o.h((t) obj8, "$this$HorizontalPager");
                                        boolean z3 = iIntValue4 == a0Var5.k();
                                        if (z3) {
                                            a0Var6.a(iIntValue4);
                                        }
                                        if (a0Var6.b(iIntValue4)) {
                                            s sVar3 = (s) mVar5;
                                            sVar3.f0(747563572);
                                            pe1.g.b(aVar2, iIntValue4, z3, y.c, sVar3, (iIntValue5 & 112) | 3072, 0);
                                            sVar3.r(false);
                                        } else {
                                            s sVar4 = (s) mVar5;
                                            sVar4.f0(743210738);
                                            sVar4.r(false);
                                        }
                                        break;
                                    default:
                                        zd1.b bVar = (zd1.b) lVar;
                                        q3.k kVar = (q3.k) a0Var2;
                                        r02.m mVar6 = (r02.m) obj8;
                                        Boolean bool = (Boolean) obj9;
                                        boolean zBooleanValue = bool.booleanValue();
                                        tlydtdl.compose.runtime.m mVar7 = (tlydtdl.compose.runtime.m) obj10;
                                        int iIntValue6 = ((Integer) obj11).intValue();
                                        o.h(mVar6, "$this$ReorderableItem");
                                        if ((iIntValue6 & 6) == 0) {
                                            i4 = (((s) mVar7).g(mVar6) ? 4 : 2) | iIntValue6;
                                        } else {
                                            i4 = iIntValue6;
                                        }
                                        if ((iIntValue6 & 48) == 0) {
                                            i4 |= ((s) mVar7).h(zBooleanValue) ? 32 : 16;
                                        }
                                        s sVar5 = (s) mVar7;
                                        if (sVar5.W(i4 & 1, (i4 & 147) != 146)) {
                                            boolean zG3 = sVar5.g(a0Var) | ((i4 & 14) == 4) | sVar5.g(bVar);
                                            Object objR4 = sVar5.R();
                                            if (zG3 || objR4 == tlydtdl.compose.runtime.l.a) {
                                                objR4 = new zd1.c(bVar, mVar6);
                                                sVar5.q0(objR4);
                                            }
                                            kVar.invoke((zd1.c) objR4, bool, sVar5, Integer.valueOf(i4 & 112));
                                        } else {
                                            sVar5.Z();
                                        }
                                        break;
                                }
                                return b0.a;
                            }
                        }, sVar), sVar, 12582912, 80);
                    }
                    sVar.r(z);
                    Object objR3 = sVar.R();
                    if (objR3 == x0Var) {
                        objR3 = mVar.b;
                        sVar.q0(objR3);
                    }
                    k1 k1Var = (k1) objR3;
                    boolean zE = sVar.e(k1Var.h());
                    Object objR4 = sVar.R();
                    if (zE || objR4 == x0Var) {
                        objR4 = tlydtdl.compose.runtime.a0.q(new n3(23, k1Var));
                        sVar.q0(objR4);
                    }
                    pe1.g.c(aVar.a, tlydtdl.compose.foundation.layout.m.H(tlydtdl.compose.ui.platform.a.a(mVar3, "feed-pager-content"), 0.0f, 0.0f, 0.0f, ((p5.f) ((f3) objR4).getValue()).a, 7), a0Var, (Function1) null, (t3.g) null, 2, (e2) null, false, sVar, 196608, 216);
                    sVar.r(true);
                }
                break;
            case 1:
                sf1.m mVar4 = (sf1.m) obj4;
                g0 g0Var = (g0) obj7;
                Function3 function3 = (Function3) obj6;
                q3.k kVar = (q3.k) obj5;
                tlydtdl.compose.runtime.m mVar5 = (tlydtdl.compose.runtime.m) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                o.h((e2) obj, "it");
                s sVar2 = (s) mVar5;
                if (!sVar2.W(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    sVar2.Z();
                } else {
                    q.b(mVar4, g0Var, q3.p.d(1823620370, new je1.j(2, function3), sVar2), q3.p.d(1737312445, new z0(19, kVar, e1Var), sVar2), (p) null, false, false, sVar2, 3456, 112);
                }
                break;
            default:
                f3 f3Var = (f3) obj7;
                un0.c cVar = (un0.c) obj6;
                f3 f3Var2 = (f3) obj5;
                f3 f3Var3 = (f3) obj4;
                tlydtdl.compose.runtime.m mVar6 = (tlydtdl.compose.runtime.m) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                float f2 = tn0.s.a;
                float f3 = tn0.s.b;
                o.h((tlydtdl.compose.foundation.lazy.a) obj, "$this$item");
                s sVar3 = (s) mVar6;
                if (!sVar3.W(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    sVar3.Z();
                } else {
                    p5.c cVar2 = (p5.c) sVar3.k(r1.h);
                    float f4 = ((p5.f) f3Var.getValue()).a;
                    t3.m mVar7 = t3.m.a;
                    p pVarH = tlydtdl.compose.foundation.layout.m.H(mVar7, 0.0f, 0.0f, 0.0f, f4, 7);
                    boolean zG2 = sVar3.g(cVar2);
                    Object objR5 = sVar3.R();
                    Object obj8 = objR5;
                    if (zG2 || objR5 == x0Var) {
                        sf1.i iVar2 = new sf1.i(cVar2, e1Var, 1);
                        sVar3.q0(iVar2);
                        obj8 = iVar2;
                    }
                    p pVarG = tlydtdl.compose.ui.layout.a.g(pVarH, (Function1) obj8);
                    l2 l2VarA = j2.a(tlydtdl.compose.foundation.layout.l.a, t3.c.j, sVar3, 0);
                    int iHashCode2 = Long.hashCode(sVar3.T);
                    u1 u1VarM2 = sVar3.m();
                    p pVarX2 = j4.x(sVar3, pVarG);
                    s4.l.f436d2.getClass();
                    s4.j jVar2 = s4.k.b;
                    sVar3.j0();
                    if (sVar3.S) {
                        sVar3.l(jVar2);
                    } else {
                        sVar3.t0();
                    }
                    s4.i iVar3 = s4.k.f435f;
                    tlydtdl.compose.runtime.a0.y(sVar3, l2VarA, iVar3);
                    s4.i iVar4 = s4.k.e;
                    tlydtdl.compose.runtime.a0.y(sVar3, u1VarM2, iVar4);
                    s4.i iVar5 = s4.k.g;
                    if (sVar3.S || !o.c(sVar3.R(), Integer.valueOf(iHashCode2))) {
                        i.x(iHashCode2, sVar3, iHashCode2, iVar5);
                    }
                    s4.i iVar6 = s4.k.d;
                    tlydtdl.compose.runtime.a0.y(sVar3, pVarX2, iVar6);
                    if (1.0f <= 0.0d) {
                        e2.a.a("invalid weight; must be greater than zero");
                    }
                    LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                    e0 e0VarA2 = c0.a(tlydtdl.compose.foundation.layout.l.c, t3.c.m, sVar3, 0);
                    int iHashCode3 = Long.hashCode(sVar3.T);
                    u1 u1VarM3 = sVar3.m();
                    p pVarX3 = j4.x(sVar3, layoutWeightElement);
                    sVar3.j0();
                    if (sVar3.S) {
                        sVar3.l(jVar2);
                    } else {
                        sVar3.t0();
                    }
                    tlydtdl.compose.runtime.a0.y(sVar3, e0VarA2, iVar3);
                    tlydtdl.compose.runtime.a0.y(sVar3, u1VarM3, iVar4);
                    if (sVar3.S || !o.c(sVar3.R(), Integer.valueOf(iHashCode3))) {
                        i.x(iHashCode3, sVar3, iHashCode3, iVar5);
                    }
                    tlydtdl.compose.runtime.a0.y(sVar3, pVarX3, iVar6);
                    ig0.b bVar = (ig0.b) f3Var2.getValue();
                    if (bVar == null) {
                        sVar3.f0(15344104);
                        r9 = 0;
                    } else {
                        r9 = 0;
                        sVar3.f0(15344105);
                        ig0.c.a(bVar, tlydtdl.compose.foundation.layout.m.F(mVar7, 0.0f, f3, 1), sVar3, 48);
                    }
                    sVar3.r(r9);
                    en0.a aVar2 = (en0.a) f3Var3.getValue();
                    if (aVar2 == null) {
                        sVar3.f0(15726923);
                        sVar3.r(r9);
                        r14 = 1;
                    } else {
                        sVar3.f0(15726924);
                        r14 = 1;
                        st.w0.e(aVar2, o2.f(tlydtdl.compose.foundation.layout.m.F(mVar7, 0.0f, f3, 1), f2), sVar3, 48);
                        sVar3.r(r9);
                    }
                    cn0.g gVar = (cn0.g) st.w0.r(cVar.e, sVar3, (int) r9, 7).getValue();
                    p pVarF = o2.f(tlydtdl.compose.foundation.layout.m.F(mVar7, 0.0f, f3, r14), f2);
                    cn0.g gVar2 = cn0.g.k;
                    com.facebook.appevents.p.a(gVar, pVarF, sVar3, 56);
                    sVar3.r(r14);
                    e1 e1VarR = st.w0.r(cVar.f, sVar3, (int) r9, 7);
                    lg.e.a(384, sVar3, ((un0.a) e1VarR.getValue()).b, o2.p(tlydtdl.compose.foundation.layout.m.E(mVar7, 4, f3), 48), ((un0.a) e1VarR.getValue()).a);
                    sVar3.r(true);
                }
                break;
        }
        return b0Var;
    }

    public /* synthetic */ f(a aVar, i2.b bVar, e1 e1Var, l lVar, sf1.m mVar) {
        this.d = aVar;
        this.e = bVar;
        this.c = e1Var;
        this.f97f = lVar;
        this.b = mVar;
    }

    public /* synthetic */ f(sf1.m mVar, g0 g0Var, Function3 function3, q3.k kVar, e1 e1Var) {
        this.b = mVar;
        this.d = g0Var;
        this.e = function3;
        this.f97f = kVar;
        this.c = e1Var;
    }
}
