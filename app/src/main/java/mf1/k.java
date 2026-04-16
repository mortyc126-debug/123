package mf1;

import cq1.d;
import java.util.List;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function4;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import md1.g;
import okhttp3.internal.ws.WebSocketProtocol;
import st.w0;
import tlydtdl.compose.runtime.e1;
import tlydtdl.compose.runtime.f3;
import tlydtdl.compose.runtime.s;
import un0.n;
import un0.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements Function4 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ k(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        float f2;
        int i = this.a;
        b0 b0Var = b0.a;
        Object obj5 = this.c;
        Object obj6 = this.b;
        switch (i) {
            case 0:
                tlydtdl.compose.foundation.lazy.a aVar = (tlydtdl.compose.foundation.lazy.a) obj;
                int iIntValue = ((Number) obj2).intValue();
                tlydtdl.compose.runtime.m mVar = (tlydtdl.compose.runtime.m) obj3;
                int iIntValue2 = ((Number) obj4).intValue();
                int i2 = (iIntValue2 & 6) == 0 ? iIntValue2 | (((s) mVar).g(aVar) ? 4 : 2) : iIntValue2;
                if ((iIntValue2 & 48) == 0) {
                    i2 |= ((s) mVar).e(iIntValue) ? 32 : 16;
                }
                s sVar = (s) mVar;
                if (!sVar.W(i2 & 1, (i2 & 147) != 146)) {
                    sVar.Z();
                } else {
                    Object obj7 = ((List) obj6).get(iIntValue);
                    int i3 = i2 & WebSocketProtocol.PAYLOAD_SHORT;
                    sVar.f0(1867041059);
                    ((Function4) obj5).invoke(Integer.valueOf(iIntValue), obj7, sVar, Integer.valueOf((i3 >> 3) & 14));
                    sVar.r(false);
                }
                break;
            default:
                zd1.c cVar = (zd1.c) obj;
                boolean zBooleanValue = ((Boolean) obj2).booleanValue();
                tlydtdl.compose.runtime.m mVar2 = (tlydtdl.compose.runtime.m) obj3;
                int iIntValue3 = ((Number) obj4).intValue();
                un0.b bVar = (un0.b) obj6;
                o.h(cVar, "$this$DraggableItem");
                int i4 = (iIntValue3 & 6) == 0 ? (((s) mVar2).g(cVar) ? 4 : 2) | iIntValue3 : iIntValue3;
                if ((iIntValue3 & 48) == 0) {
                    i4 |= ((s) mVar2).h(zBooleanValue) ? 32 : 16;
                }
                s sVar2 = (s) mVar2;
                if (!sVar2.W(i4 & 1, (i4 & 147) != 146)) {
                    sVar2.Z();
                } else {
                    e1 e1VarR = w0.r(bVar.c, sVar2, 0, 7);
                    e1 e1VarR2 = w0.r(bVar.d, sVar2, 0, 7);
                    f3 f3VarB = t1.e.b(zBooleanValue ? 1.02f : 1.0f, (t1.j) null, "scaleAnimation", sVar2, 3072, 22);
                    float fI0 = 0.0f;
                    if (zBooleanValue) {
                        sVar2.f0(-995509619);
                        float fI02 = g.i0(4, sVar2);
                        sVar2.r(false);
                        f2 = fI02;
                    } else {
                        sVar2.f0(-796015337);
                        sVar2.r(false);
                        f2 = 0.0f;
                    }
                    f3 f3VarB2 = t1.e.b(f2, (t1.j) null, "translationAnimation", sVar2, 3072, 22);
                    if (zBooleanValue) {
                        sVar2.f0(-995501811);
                        fI0 = g.i0(32, sVar2);
                    } else {
                        sVar2.f0(-795773289);
                    }
                    sVar2.r(false);
                    f3 f3VarB3 = t1.e.b(fI0, (t1.j) null, "elevation", sVar2, 3072, 22);
                    e1 e1VarR3 = w0.r(bVar.b, sVar2, 0, 7);
                    n nVar = (n) e1VarR.getValue();
                    p pVar = (p) e1VarR2.getValue();
                    ng0.b bVar2 = ((n) e1VarR.getValue()).a;
                    t3.m mVar3 = t3.m.a;
                    t3.p pVarW = g.w(mVar3, false, (Function0) null, (Function0) null, bVar2, 15);
                    t3.p pVarH = tlydtdl.compose.foundation.layout.m.H(mVar3, 0.0f, 0.0f, 1, 0.0f, 11);
                    float f3 = tn0.s.a;
                    t3.p pVarA = zd1.c.a(cVar, pVarH, ((List) ((e1) obj5).getValue()).size() > 1, 14);
                    boolean zG = sVar2.g(f3VarB) | sVar2.g(f3VarB2) | sVar2.g(f3VarB3);
                    Object objR = sVar2.R();
                    if (zG || objR == tlydtdl.compose.runtime.l.a) {
                        objR = new tlydtdl.compose.runtime.e(f3VarB, f3VarB2, f3VarB3, 2);
                        sVar2.q0(objR);
                    }
                    d.c(e1VarR3, nVar, pVar, pVarW, tlydtdl.compose.ui.graphics.a.a(pVarA, (Function1) objR), zBooleanValue, sVar2, (i4 << 12) & 458752);
                }
                break;
        }
        return b0Var;
    }
}
