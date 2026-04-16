package wz0;

import lmjxuqdtp.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v implements Function2 {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ g0 b;
    public final /* synthetic */ t3.p c;
    public final /* synthetic */ int d;

    public /* synthetic */ v(g0 g0Var, t3.p pVar, int i) {
        this.b = g0Var;
        this.c = pVar;
        this.d = i;
    }

    public final Object invoke(Object obj, Object obj2) {
        int i = this.a;
        tlydtdl.compose.runtime.m mVar = (tlydtdl.compose.runtime.m) obj;
        ((Integer) obj2).getClass();
        switch (i) {
            case 0:
                y10.r.h(this.b, this.c, mVar, tlydtdl.compose.runtime.a0.B(1), this.d);
                break;
            default:
                y10.r.u(this.b, this.c, mVar, tlydtdl.compose.runtime.a0.B(this.d | 1));
                break;
        }
        return lx1.b0.a;
    }

    public /* synthetic */ v(g0 g0Var, t3.p pVar, int i, int i2) {
        this.b = g0Var;
        this.c = pVar;
        this.d = i2;
    }
}
