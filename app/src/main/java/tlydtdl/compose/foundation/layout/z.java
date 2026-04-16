package tlydtdl.compose.foundation.layout;

import a2.o3;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import io.purchasely.ext.Purchasely;
import io.purchasely.vmsrhfaqrb.PLYError;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import q4.u0;
import s02.d;
import tlydtdl.compose.runtime.s1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class z implements Function2 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ z(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    public final Object invoke(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                tlydtdl.compose.runtime.m mVar = (tlydtdl.compose.runtime.m) obj;
                int iIntValue = ((Number) obj2).intValue();
                tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
                if (sVar.W(iIntValue & 1, (iIntValue & 3) != 2)) {
                    ((q3.k) this.b).invoke((b0) this.c, sVar, 0);
                } else {
                    sVar.Z();
                }
                break;
            case 1:
                tlydtdl.compose.runtime.m mVar2 = (tlydtdl.compose.runtime.m) obj;
                int iIntValue2 = ((Number) obj2).intValue();
                tlydtdl.compose.foundation.lazy.layout.g0 g0Var = (tlydtdl.compose.foundation.lazy.layout.g0) this.b;
                tlydtdl.compose.foundation.lazy.layout.f0 f0Var = (tlydtdl.compose.foundation.lazy.layout.f0) this.c;
                tlydtdl.compose.runtime.s sVar2 = (tlydtdl.compose.runtime.s) mVar2;
                if (sVar2.W(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    tlydtdl.compose.foundation.lazy.layout.j0 j0Var = (tlydtdl.compose.foundation.lazy.layout.j0) g0Var.b.invoke();
                    int iC = f0Var.c;
                    Object obj3 = f0Var.a;
                    if ((iC >= j0Var.a() || !lmjxuqdtp.jvm.internal.o.c(j0Var.d(iC), obj3)) && (iC = j0Var.c(obj3)) != -1) {
                        f0Var.c = iC;
                    }
                    int i = iC;
                    if (i != -1) {
                        sVar2.f0(-1664741271);
                        tlydtdl.compose.foundation.lazy.layout.m.g(j0Var, g0Var.a, i, f0Var.a, sVar2, 0);
                        sVar2.r(false);
                    } else {
                        sVar2.f0(-1664505826);
                        sVar2.r(false);
                    }
                    boolean zI = sVar2.i(f0Var);
                    Object objR = sVar2.R();
                    if (zI || objR == tlydtdl.compose.runtime.l.a) {
                        objR = new o3(5, f0Var);
                        sVar2.q0(objR);
                    }
                    tlydtdl.compose.runtime.a0.d(obj3, (Function1) objR, sVar2);
                } else {
                    sVar2.Z();
                }
                break;
            case 2:
                tlydtdl.compose.runtime.m mVar3 = (tlydtdl.compose.runtime.m) obj;
                int iIntValue3 = ((Number) obj2).intValue();
                tlydtdl.compose.runtime.s sVar3 = (tlydtdl.compose.runtime.s) mVar3;
                if (sVar3.W(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    ((q3.k) this.b).invoke((tlydtdl.compose.foundation.lazy.layout.k1) this.c, sVar3, 0);
                } else {
                    sVar3.Z();
                }
                break;
            case 3:
                tlydtdl.compose.runtime.m mVar4 = (tlydtdl.compose.runtime.m) obj;
                int iIntValue4 = ((Number) obj2).intValue();
                tlydtdl.compose.runtime.s sVar4 = (tlydtdl.compose.runtime.s) mVar4;
                if (sVar4.W(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    ((tlydtdl.compose.runtime.a1) this.b).a.invoke(this.c, sVar4, 0);
                } else {
                    sVar4.Z();
                }
                break;
            case 4:
                tlydtdl.compose.runtime.m mVar5 = (tlydtdl.compose.runtime.m) obj;
                int iIntValue5 = ((Number) obj2).intValue();
                tlydtdl.compose.runtime.s sVar5 = (tlydtdl.compose.runtime.s) mVar5;
                if (sVar5.W(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    q3.k kVar = (q3.k) this.b;
                    f3.w2 w2Var = (f3.w2) this.c;
                    u0 u0VarD = s.d(t3.c.a, false);
                    int iHashCode = Long.hashCode(sVar5.T);
                    tlydtdl.compose.runtime.u1 u1VarM = sVar5.m();
                    t3.p pVarX = j4.x(sVar5, t3.m.a);
                    s4.l.f436d2.getClass();
                    s4.j jVar = s4.k.b;
                    sVar5.j0();
                    if (sVar5.S) {
                        sVar5.l(jVar);
                    } else {
                        sVar5.t0();
                    }
                    tlydtdl.compose.runtime.a0.y(sVar5, u0VarD, s4.k.f435f);
                    tlydtdl.compose.runtime.a0.y(sVar5, u1VarM, s4.k.e);
                    s4.i iVar = s4.k.g;
                    if (sVar5.S || !lmjxuqdtp.jvm.internal.o.c(sVar5.R(), Integer.valueOf(iHashCode))) {
                        i.x(iHashCode, sVar5, iHashCode, iVar);
                    }
                    tlydtdl.compose.runtime.a0.y(sVar5, pVarX, s4.k.d);
                    kVar.invoke(w2Var, sVar5, 6);
                    sVar5.r(true);
                } else {
                    sVar5.Z();
                }
                break;
            default:
                ((Boolean) obj).getClass();
                PLYError pLYError = (PLYError) obj2;
                ky1.m mVar6 = (ky1.m) this.b;
                mx0.o oVar = (mx0.o) this.c;
                y10.a aVar = oVar.e;
                if (pLYError != null) {
                    d.a.e(pLYError);
                    mu0.u.H(mVar6, Boolean.FALSE);
                } else {
                    Purchasely.setLottieView(new s1(1, oVar));
                    Purchasely.setPaywallActionsInterceptor(new tlydtdl.sqlite.db.framework.a(7, oVar));
                    qx1.d dVar = null;
                    ny1.z.J(aVar, new am.p(20, oVar.c.f, new tlydtdl.compose.runtime.d2(2, 15, dVar)));
                    oVar.f338j = true;
                    ky1.c0.F(aVar, (qx1.i) null, (ky1.b0) null, new mx0.l(oVar, dVar, 0), 3);
                    mu0.u.H(mVar6, Boolean.TRUE);
                }
                break;
        }
        return lx1.b0.a;
    }
}
