package rd1;

import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function5;
import t1.v1;
import tlydtdl.compose.foundation.layout.f2;
import tlydtdl.compose.foundation.layout.m2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c0 implements Function5 {
    public final /* synthetic */ a0 a;
    public final /* synthetic */ f2 b;
    public final /* synthetic */ x10.v c;

    public /* synthetic */ c0(a0 a0Var, f2 f2Var, x10.v vVar) {
        this.a = a0Var;
        this.b = f2Var;
        this.c = vVar;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int i;
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
            z10.d.h(this.c, md1.g.x(ld1.r.Companion, ((a4.y) md1.g.o(sVar.d(), (String) null, (v1) null, sVar2, 0, 14).getValue()).a), this.a.a(), tlydtdl.compose.foundation.layout.m.C(pVar, this.b), false, of1.e.f370f, 0, (Function1) null, sVar2, 196608, 208);
        } else {
            sVar2.Z();
        }
        return lx1.b0.a;
    }
}
