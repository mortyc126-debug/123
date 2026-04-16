package wz0;

import aq1.b;
import lmjxuqdtp.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l0 implements Function2 {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ n0 b;
    public final /* synthetic */ int c;

    public /* synthetic */ l0(n0 n0Var, int i) {
        this.b = n0Var;
        this.c = i;
    }

    public final Object invoke(Object obj, Object obj2) {
        tlydtdl.compose.runtime.m mVar = (tlydtdl.compose.runtime.m) obj;
        Integer num = (Integer) obj2;
        switch (this.a) {
            case 0:
                num.getClass();
                b.j(this.b, this.c, mVar, tlydtdl.compose.runtime.a0.B(1));
                break;
            default:
                int iIntValue = num.intValue();
                tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
                if (sVar.W(iIntValue & 1, (iIntValue & 3) != 2)) {
                    b.j(this.b, this.c, sVar, 0);
                } else {
                    sVar.Z();
                }
                break;
        }
        return lx1.b0.a;
    }

    public /* synthetic */ l0(n0 n0Var, int i, int i2) {
        this.b = n0Var;
        this.c = i;
    }
}
