package wz0;

import lmjxuqdtp.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n implements Function2 {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ xz0.a0 b;
    public final /* synthetic */ t3.p c;

    public /* synthetic */ n(xz0.a0 a0Var, t3.p pVar) {
        this.b = a0Var;
        this.c = pVar;
    }

    public final Object invoke(Object obj, Object obj2) {
        tlydtdl.compose.runtime.m mVar = (tlydtdl.compose.runtime.m) obj;
        Integer num = (Integer) obj2;
        switch (this.a) {
            case 0:
                int iIntValue = num.intValue();
                tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
                if (sVar.W(iIntValue & 1, (iIntValue & 3) != 2)) {
                    xz0.d.t(this.b, this.c, sVar, 0);
                } else {
                    sVar.Z();
                }
                break;
            default:
                num.getClass();
                xz0.d.t(this.b, this.c, mVar, tlydtdl.compose.runtime.a0.B(1));
                break;
        }
        return lx1.b0.a;
    }

    public /* synthetic */ n(xz0.a0 a0Var, t3.p pVar, int i) {
        this.b = a0Var;
        this.c = pVar;
    }
}
