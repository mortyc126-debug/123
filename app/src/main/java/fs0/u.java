package fs0;

import a2.q1;
import a2.z0;
import a4.w0;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import com.google.android.material.R;
import ds0.l;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Set;
import ld1.r;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function3;
import lmjxuqdtp.jvm.functions.Function4;
import of1.q;
import q1.o0;
import tlydtdl.compose.foundation.layout.e2;
import tlydtdl.compose.foundation.layout.f0;
import tlydtdl.compose.foundation.layout.f2;
import tlydtdl.compose.foundation.layout.v2;
import tlydtdl.compose.foundation.layout.x1;
import tlydtdl.compose.foundation.lazy.layout.m0;
import tlydtdl.compose.runtime.e1;
import tlydtdl.compose.runtime.x0;
import u10.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u implements Function3 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f129f;
    public final /* synthetic */ Object g;

    public /* synthetic */ u(l lVar, hg1.x xVar, Function1 function1, e eVar, hg1.d dVar, Function1 function12) {
        this.a = 0;
        this.b = lVar;
        this.c = xVar;
        this.d = function1;
        this.f129f = eVar;
        this.g = dVar;
        this.e = function12;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.util.List] */
    public final Object invoke(Object obj, Object obj2, Object obj3) throws NoWhenBranchMatchedException {
        ?? O0;
        Object obj4 = obj;
        switch (this.a) {
            case 0:
                l lVar = (l) this.b;
                hg1.x xVar = (hg1.x) this.c;
                Function1 function1 = (Function1) this.d;
                e eVar = (e) this.f129f;
                hg1.d dVar = (hg1.d) this.g;
                Function1 function12 = (Function1) this.e;
                tlydtdl.compose.runtime.m mVar = (tlydtdl.compose.runtime.m) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                lmjxuqdtp.jvm.internal.o.h((f0) obj, "$this$Group");
                tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
                if (sVar.W(iIntValue & 1, (iIntValue & 17) != 16)) {
                    float f2 = 16;
                    float f3 = 12;
                    t3.m mVar2 = t3.m.a;
                    z10.d.h(com.ironsource.adqualitysdk.sdk.i.a0.v(x10.v.Companion, 2132019218), i.u(r.Companion, R.dimen.m3_comp_fab_primary_large_icon_size), q.d(), tlydtdl.compose.foundation.layout.m.H(mVar2, f2, f3, f2, 0.0f, 8), false, (of1.e) null, 0, (Function1) null, sVar, 3072, 240);
                    j4.e(lVar, tlydtdl.compose.foundation.layout.m.G(mVar2, f2, 8, f2, f3), sVar, 48);
                    a.j(sVar);
                    boolean zG = sVar.g(function1);
                    Object objR = sVar.R();
                    x0 x0Var = tlydtdl.compose.runtime.l.a;
                    if (zG || objR == x0Var) {
                        objR = new x1(4, function1);
                        sVar.q0(objR);
                    }
                    a.q(xVar, (Function1) objR, eVar, sVar, 0);
                    a.j(sVar);
                    x10.r rVar = new x10.r(2132019966);
                    tx1.b bVar = hg1.d.C;
                    Object objR2 = sVar.R();
                    if (objR2 == x0Var) {
                        objR2 = new dr0.i(20);
                        sVar.q0(objR2);
                    }
                    a.f(rVar, dVar, bVar, (Function1) objR2, function12, null, false, eVar, sVar, 3072, 96);
                } else {
                    sVar.Z();
                }
                return lx1.b0.a;
            case 1:
                t30.m mVar3 = (t30.m) this.b;
                qu0.u uVar = (qu0.u) this.c;
                Function0 function0 = (Function0) this.d;
                t10.o oVar = (t10.o) this.e;
                cd1.g gVar = (cd1.g) this.f129f;
                q3.k kVar = (q3.k) this.g;
                e2 e2Var = (e2) obj;
                tlydtdl.compose.runtime.m mVar4 = (tlydtdl.compose.runtime.m) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                lmjxuqdtp.jvm.internal.o.h(e2Var, "contentPadding");
                if ((iIntValue2 & 6) == 0) {
                    iIntValue2 |= ((tlydtdl.compose.runtime.s) mVar4).g(e2Var) ? 4 : 2;
                }
                tlydtdl.compose.runtime.s sVar2 = (tlydtdl.compose.runtime.s) mVar4;
                if (sVar2.W(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                    p.b(mVar3, uVar, function0, tlydtdl.compose.foundation.a.c(t3.m.a, i.e(2131100890, 0, sVar2, r.Companion), w0.a), oVar, gVar, q3.p.d(545186968, new cj0.j(4, kVar, e2Var), sVar2), sVar2, 1572864);
                } else {
                    sVar2.Z();
                }
                return lx1.b0.a;
            case 2:
                Set set = (Set) this.b;
                Set set2 = (Set) this.d;
                e1 e1Var = (e1) this.e;
                List list = (List) this.f129f;
                hb.d dVar2 = (hb.d) this.g;
                tlydtdl.compose.runtime.m mVar5 = (tlydtdl.compose.runtime.m) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                tlydtdl.compose.runtime.s sVar3 = (tlydtdl.compose.runtime.s) mVar5;
                if (sVar3.W(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    boolean zI = sVar3.i(set);
                    Object obj5 = this.c;
                    boolean zI2 = zI | sVar3.i(obj5) | sVar3.i(set2) | sVar3.g(e1Var);
                    Object objR3 = sVar3.R();
                    if (zI2 || objR3 == tlydtdl.compose.runtime.l.a) {
                        m0 m0Var = new m0(set, obj5, set2, e1Var, 4);
                        sVar3.q0(m0Var);
                        objR3 = m0Var;
                    }
                    tlydtdl.compose.runtime.a0.d(obj5, (Function1) objR3, sVar3);
                    sVar3.f0(358947325);
                    if (list instanceof RandomAccess) {
                        o0 o0Var = new o0(list.size());
                        O0 = new ArrayList(list.size());
                        int size = list.size();
                        for (int i = 0; i < size; i++) {
                            Object obj6 = list.get(i);
                            if (o0Var.a(obj6)) {
                                O0.add(obj6);
                            }
                        }
                    } else {
                        O0 = mx1.o.o0(list);
                    }
                    if (!O0.isEmpty()) {
                        ListIterator listIterator = O0.listIterator(O0.size());
                        while (listIterator.hasPrevious()) {
                            dVar2 = new hb.d(dVar2, q3.p.d(-330823412, new z0(9, (hb.e) listIterator.previous(), dVar2), sVar3));
                        }
                    }
                    sVar3.r(false);
                    dVar2.a(sVar3, 0);
                } else {
                    sVar3.Z();
                }
                return lx1.b0.a;
            case 3:
                sw0.k kVar2 = (sw0.k) this.b;
                vp1.b bVar2 = (vp1.b) this.c;
                Function3 function3 = (Function3) this.d;
                q3.k kVar3 = (q3.k) this.e;
                Function3 function32 = (Function3) this.f129f;
                Function3 function33 = (Function3) this.g;
                tlydtdl.compose.runtime.m mVar6 = (tlydtdl.compose.runtime.m) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                lmjxuqdtp.jvm.internal.o.h(obj4, "<this>");
                if ((iIntValue4 & 6) == 0) {
                    iIntValue4 |= (iIntValue4 & 8) == 0 ? ((tlydtdl.compose.runtime.s) mVar6).g(obj4) : ((tlydtdl.compose.runtime.s) mVar6).i(obj4) ? 4 : 2;
                }
                int i2 = iIntValue4;
                tlydtdl.compose.runtime.s sVar4 = (tlydtdl.compose.runtime.s) mVar6;
                if (sVar4.W(i2 & 1, (i2 & 19) != 18)) {
                    nc0.i iVar = kVar2.a;
                    Function0 function02 = kVar2.b;
                    int size2 = iVar.b().size();
                    int i3 = -987690475;
                    sVar4.f0(-987690475);
                    sVar4.r(false);
                    sVar4.f0(106732150);
                    int i4 = 0;
                    for (Object obj7 : iVar.b()) {
                        int i6 = i4 + 1;
                        if (i4 < 0) {
                            ct1.b.X();
                            throw null;
                        }
                        vu0.d dVar3 = (vu0.d) obj7;
                        vp1.b bVar3 = bVar2;
                        sw0.c cVar = new sw0.c(i4, dVar3);
                        sVar4.f0(106736856);
                        bVar3.p(obj4, cVar, kVar3, sVar4, i2 & 14);
                        sVar4.r(false);
                        obj4 = obj;
                        bVar2 = bVar3;
                        i3 = -987690475;
                        i4 = i6;
                    }
                    int i7 = i3;
                    vp1.b bVar4 = bVar2;
                    sVar4.r(false);
                    if (iVar instanceof nc0.k) {
                        sVar4.f0(-985777651);
                        sVar4.r(false);
                        if (function02 != null) {
                            function02.invoke();
                        }
                    } else if (iVar instanceof nc0.m) {
                        sVar4.f0(106751857);
                        sVar4.r(false);
                    } else if (iVar instanceof nc0.i) {
                        sVar4.f0(-985513004);
                        if (!iVar.e || function3 == null) {
                            sVar4.f0(i7);
                        } else {
                            sVar4.f0(-985443161);
                            boolean z = size2 == 0;
                            sVar4.f0(-488836485);
                            bVar4.p(obj, sw0.d.b(z), function3, sVar4, i2 & 14);
                            sVar4.r(false);
                        }
                        sVar4.r(false);
                        sVar4.r(false);
                    } else if (iVar instanceof nc0.j) {
                        sVar4.f0(-985027544);
                        sw0.e eVar2 = new sw0.e(size2 == 0, ((nc0.j) iVar).a, function02);
                        sVar4.f0(2113506704);
                        bVar4.p(obj, eVar2, function32, sVar4, i2 & 14);
                        sVar4.r(false);
                        sVar4.r(false);
                    } else {
                        if (!(iVar instanceof nc0.l)) {
                            throw com.ironsource.adqualitysdk.sdk.i.a0.q(sVar4, 106745012, false);
                        }
                        sVar4.f0(-984533435);
                        sVar4.f0(355828456);
                        bVar4.p(obj, sw0.h.a, function33, sVar4, (i2 & 14) | 48);
                        sVar4.r(false);
                        sVar4.r(false);
                    }
                    sVar4.f0(i7);
                    sVar4.r(false);
                } else {
                    sVar4.Z();
                }
                return lx1.b0.a;
            default:
                s60.d dVar4 = (s60.d) this.b;
                f2 f2Var = (f2) this.c;
                f2.a0 a0Var = (f2.a0) this.d;
                f2 f2Var2 = (f2) this.e;
                q3.k kVar4 = (q3.k) this.f129f;
                q3.k kVar5 = (q3.k) this.g;
                t3.p pVar = (t3.p) obj4;
                tlydtdl.compose.runtime.m mVar7 = (tlydtdl.compose.runtime.m) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                lmjxuqdtp.jvm.internal.o.h(pVar, "mod");
                if ((iIntValue5 & 6) == 0) {
                    iIntValue5 |= ((tlydtdl.compose.runtime.s) mVar7).g(pVar) ? 4 : 2;
                }
                tlydtdl.compose.runtime.s sVar5 = (tlydtdl.compose.runtime.s) mVar7;
                if (sVar5.W(iIntValue5 & 1, (iIntValue5 & 19) != 18)) {
                    rw0.b.d(dVar4.B(), q3.p.d(-838815355, new vw0.c(1, kVar4), sVar5), tlydtdl.compose.ui.platform.a.a(tlydtdl.compose.foundation.layout.m.C(pVar, f2Var), "trending_video_row"), (t3.p) null, a0Var, f2Var2, tlydtdl.compose.foundation.layout.l.g(8), (t3.g) null, (q1) null, (v2) null, false, (Function1) null, q3.p.d(-617325374, new vw0.c(2, kVar5), sVar5), (Function4) null, (Function4) null, (rw0.m0) null, true, sVar5, 12582960, 3072, 6, 1040200);
                } else {
                    sVar5.Z();
                }
                return lx1.b0.a;
        }
    }

    public /* synthetic */ u(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
        this.e = obj4;
        this.f129f = obj5;
        this.g = obj6;
    }
}
