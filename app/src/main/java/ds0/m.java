package ds0;

import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function2;
import lx1.b0;
import t3.p;
import tlydtdl.compose.runtime.a0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m implements Function2 {
    public final /* synthetic */ int a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ p d;

    public /* synthetic */ m(p pVar, boolean z, Function0 function0, int i) {
        this.a = 3;
        this.d = pVar;
        this.b = z;
        this.c = function0;
    }

    public final Object invoke(Object obj, Object obj2) {
        int i = this.a;
        tlydtdl.compose.runtime.m mVar = (tlydtdl.compose.runtime.m) obj;
        ((Integer) obj2).getClass();
        switch (i) {
            case 0:
                cq1.d.h(a0.B(385), mVar, this.c, this.d, this.b);
                break;
            case 1:
                ct1.b.e(a0.B(1), mVar, this.c, this.d, this.b);
                break;
            case 2:
                lg.e.a(a0.B(385), mVar, this.c, this.d, this.b);
                break;
            default:
                es1.c.j(a0.B(7), mVar, this.c, this.d, this.b);
                break;
        }
        return b0.a;
    }

    public /* synthetic */ m(boolean z, Function0 function0, p pVar, int i, int i2) {
        this.a = i2;
        this.b = z;
        this.c = function0;
        this.d = pVar;
    }
}
