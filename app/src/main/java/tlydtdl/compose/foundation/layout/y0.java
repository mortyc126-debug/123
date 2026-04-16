package tlydtdl.compose.foundation.layout;

import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import lmjxuqdtp.jvm.functions.Function2;
import q4.u0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class y0 implements Function2 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ y0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public final Object invoke(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                tlydtdl.compose.runtime.m mVar = (tlydtdl.compose.runtime.m) obj;
                int iIntValue = ((Number) obj2).intValue();
                tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
                if (sVar.W(iIntValue & 1, (iIntValue & 3) != 2)) {
                    ((q3.k) this.b).invoke(h1.a, sVar, 6);
                } else {
                    sVar.Z();
                }
                break;
            case 1:
                tlydtdl.compose.runtime.m mVar2 = (tlydtdl.compose.runtime.m) obj;
                int iIntValue2 = ((Number) obj2).intValue();
                tlydtdl.compose.runtime.s sVar2 = (tlydtdl.compose.runtime.s) mVar2;
                if (sVar2.W(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    q3.k kVar = (q3.k) this.b;
                    u0 u0VarD = s.d(t3.c.a, false);
                    int iHashCode = Long.hashCode(sVar2.T);
                    tlydtdl.compose.runtime.u1 u1VarM = sVar2.m();
                    t3.p pVarX = j4.x(sVar2, t3.m.a);
                    s4.l.f436d2.getClass();
                    s4.j jVar = s4.k.b;
                    sVar2.j0();
                    if (sVar2.S) {
                        sVar2.l(jVar);
                    } else {
                        sVar2.t0();
                    }
                    tlydtdl.compose.runtime.a0.y(sVar2, u0VarD, s4.k.f435f);
                    tlydtdl.compose.runtime.a0.y(sVar2, u1VarM, s4.k.e);
                    s4.i iVar = s4.k.g;
                    if (sVar2.S || !lmjxuqdtp.jvm.internal.o.c(sVar2.R(), Integer.valueOf(iHashCode))) {
                        i.x(iHashCode, sVar2, iHashCode, iVar);
                    }
                    tlydtdl.compose.runtime.a0.y(sVar2, pVarX, s4.k.d);
                    i.z(0, kVar, sVar2, true);
                } else {
                    sVar2.Z();
                }
                break;
            default:
                tlydtdl.compose.runtime.m mVar3 = (tlydtdl.compose.runtime.m) obj;
                int iIntValue3 = ((Number) obj2).intValue();
                tlydtdl.compose.runtime.s sVar3 = (tlydtdl.compose.runtime.s) mVar3;
                if (sVar3.W(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    sVar3.I((tlydtdl.compose.runtime.a1) this.b, sVar3.m(), null, false);
                } else {
                    sVar3.Z();
                }
                break;
        }
        return lx1.b0.a;
    }
}
