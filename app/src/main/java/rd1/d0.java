package rd1;

import a4.a1;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function3;
import lmjxuqdtp.jvm.functions.Function5;
import md1.n0;
import t1.v1;
import tlydtdl.compose.foundation.layout.m2;
import tlydtdl.compose.runtime.u1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d0 implements Function5 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ d0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int i;
        int i2;
        switch (this.a) {
            case 0:
                dg1.d dVar = (dg1.d) this.b;
                t3.p pVar = (t3.p) obj2;
                s sVar = (s) obj3;
                tlydtdl.compose.runtime.m mVar = (tlydtdl.compose.runtime.m) obj4;
                int iIntValue = ((Integer) obj5).intValue();
                lmjxuqdtp.jvm.internal.o.h((m2) obj, "<this>");
                lmjxuqdtp.jvm.internal.o.h(pVar, "modifier");
                lmjxuqdtp.jvm.internal.o.h(sVar, "colorScheme");
                if ((iIntValue & 48) == 0) {
                    i = (((tlydtdl.compose.runtime.s) mVar).g(pVar) ? 32 : 16) | iIntValue;
                } else {
                    i = iIntValue;
                }
                if ((iIntValue & 384) == 0) {
                    i |= ((tlydtdl.compose.runtime.s) mVar).g(sVar) ? 256 : 128;
                }
                tlydtdl.compose.runtime.s sVar2 = (tlydtdl.compose.runtime.s) mVar;
                if (sVar2.W(i & 1, (i & 1169) != 1168)) {
                    fe1.f.a(dVar, (String) null, (a1) null, pVar, (t3.d) null, (q4.m) null, 0.0f, new a4.q(((a4.y) md1.g.o(sVar.c(), (String) null, (v1) null, sVar2, 0, 14).getValue()).a, 5), (Function0) null, false, (n0) null, (fe1.j) null, (fe1.g) null, false, (Function3) null, (fe1.k) null, sVar2, ((i << 6) & 7168) | 432, 0, 65392);
                } else {
                    sVar2.Z();
                }
                break;
            default:
                Function3 function3 = (Function3) this.b;
                sw0.j jVar = (sw0.j) obj2;
                t3.p pVar2 = (t3.p) obj3;
                tlydtdl.compose.runtime.m mVar2 = (tlydtdl.compose.runtime.m) obj4;
                int iIntValue2 = ((Integer) obj5).intValue();
                lmjxuqdtp.jvm.internal.o.h(obj, "<this>");
                lmjxuqdtp.jvm.internal.o.h(jVar, "item");
                lmjxuqdtp.jvm.internal.o.h(pVar2, "modifier");
                if ((iIntValue2 & 48) == 0) {
                    i2 = ((iIntValue2 & 64) == 0 ? ((tlydtdl.compose.runtime.s) mVar2).g(jVar) : ((tlydtdl.compose.runtime.s) mVar2).i(jVar) ? 32 : 16) | iIntValue2;
                } else {
                    i2 = iIntValue2;
                }
                if ((iIntValue2 & 384) == 0) {
                    i2 |= ((tlydtdl.compose.runtime.s) mVar2).g(pVar2) ? 256 : 128;
                }
                tlydtdl.compose.runtime.s sVar3 = (tlydtdl.compose.runtime.s) mVar2;
                if (sVar3.W(i2 & 1, (i2 & 1169) != 1168)) {
                    q4.u0 u0VarD = tlydtdl.compose.foundation.layout.s.d(t3.c.e, false);
                    int iHashCode = Long.hashCode(sVar3.T);
                    u1 u1VarM = sVar3.m();
                    t3.p pVarX = j4.x(sVar3, pVar2);
                    s4.l.f436d2.getClass();
                    s4.j jVar2 = s4.k.b;
                    sVar3.j0();
                    if (sVar3.S) {
                        sVar3.l(jVar2);
                    } else {
                        sVar3.t0();
                    }
                    tlydtdl.compose.runtime.a0.y(sVar3, u0VarD, s4.k.f435f);
                    tlydtdl.compose.runtime.a0.y(sVar3, u1VarM, s4.k.e);
                    s4.i iVar = s4.k.g;
                    if (sVar3.S || !lmjxuqdtp.jvm.internal.o.c(sVar3.R(), Integer.valueOf(iHashCode))) {
                        i.x(iHashCode, sVar3, iHashCode, iVar);
                    }
                    tlydtdl.compose.runtime.a0.y(sVar3, pVarX, s4.k.d);
                    function3.invoke(jVar, sVar3, Integer.valueOf((i2 >> 3) & 14));
                    sVar3.r(true);
                } else {
                    sVar3.Z();
                }
                break;
        }
        return lx1.b0.a;
    }
}
