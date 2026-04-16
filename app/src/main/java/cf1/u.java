package cf1;

import lmjxuqdtp.jvm.functions.Function4;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u implements Function4 {
    public final /* synthetic */ t a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ u(t tVar, boolean z) {
        this.a = tVar;
        this.b = z;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        int i;
        tlydtdl.compose.foundation.layout.w wVar = (tlydtdl.compose.foundation.layout.w) obj;
        l0 l0Var = (l0) obj2;
        tlydtdl.compose.runtime.m mVar = (tlydtdl.compose.runtime.m) obj3;
        int iIntValue = ((Integer) obj4).intValue();
        lmjxuqdtp.jvm.internal.o.h(wVar, "<this>");
        lmjxuqdtp.jvm.internal.o.h(l0Var, "state");
        if ((iIntValue & 6) == 0) {
            i = (((tlydtdl.compose.runtime.s) mVar).g(wVar) ? 4 : 2) | iIntValue;
        } else {
            i = iIntValue;
        }
        if ((iIntValue & 48) == 0) {
            i |= ((tlydtdl.compose.runtime.s) mVar).g(l0Var) ? 32 : 16;
        }
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        if (sVar.W(i & 1, (i & 147) != 146)) {
            g0.a.b(wVar, l0Var, this.a.a(), this.b, sVar, (i & 14) | 24576 | (i & 112));
        } else {
            sVar.Z();
        }
        return lx1.b0.a;
    }
}
