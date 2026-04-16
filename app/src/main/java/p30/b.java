package p30;

import kx0.i;
import lmjxuqdtp.jvm.functions.Function2;
import lx1.b0;
import t3.p;
import tlydtdl.compose.runtime.a0;
import tlydtdl.compose.runtime.m;
import tlydtdl.compose.runtime.s;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Function2 {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ d b;

    public final Object invoke(Object obj, Object obj2) {
        m mVar = (m) obj;
        Integer num = (Integer) obj2;
        switch (this.a) {
            case 0:
                num.getClass();
                a.a(this.b, mVar, a0.B(1));
                break;
            default:
                int iIntValue = num.intValue();
                s sVar = (s) mVar;
                if (sVar.W(iIntValue & 1, (iIntValue & 3) != 2)) {
                    i.a(this.b.a, (p) null, sVar, 8, 2);
                } else {
                    sVar.Z();
                }
                break;
        }
        return b0.a;
    }

    public /* synthetic */ b(d dVar, int i) {
        this.b = dVar;
    }
}
