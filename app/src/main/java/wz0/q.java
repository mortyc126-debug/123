package wz0;

import bb.b1;
import lmjxuqdtp.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q implements Function2 {
    public final /* synthetic */ int a;
    public final /* synthetic */ b1 b;

    public /* synthetic */ q(b1 b1Var, int i) {
        this.a = i;
        this.b = b1Var;
    }

    public final Object invoke(Object obj, Object obj2) {
        int i = this.a;
        tlydtdl.compose.runtime.m mVar = (tlydtdl.compose.runtime.m) obj;
        int iIntValue = ((Integer) obj2).intValue();
        switch (i) {
            case 0:
                tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
                if (sVar.W(iIntValue & 1, (iIntValue & 3) != 2)) {
                    hs1.d.o(this.b, (t3.p) null, sVar, 0);
                } else {
                    sVar.Z();
                }
                break;
            default:
                tlydtdl.compose.runtime.s sVar2 = (tlydtdl.compose.runtime.s) mVar;
                if (sVar2.W(iIntValue & 1, (iIntValue & 3) != 2)) {
                    hs1.d.o(this.b, (t3.p) null, sVar2, 0);
                } else {
                    sVar2.Z();
                }
                break;
        }
        return lx1.b0.a;
    }
}
