package e80;

import i2.a0;
import i2.d0;
import lmjxuqdtp.jvm.functions.Function0;
import tlydtdl.compose.runtime.j1;
import tlydtdl.compose.runtime.k1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements Function0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ a0 b;

    public /* synthetic */ g(a0 a0Var, int i) {
        this.a = i;
        this.b = a0Var;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                return Float.valueOf(((j1) this.b.d.d).h());
            case 1:
                return Integer.valueOf(this.b.k());
            case 2:
                return Integer.valueOf(this.b.m());
            case 3:
                return Integer.valueOf(this.b.m());
            case 4:
                a0 a0Var = this.b;
                return Integer.valueOf(a0Var.k.b() ? a0Var.t.h() : a0Var.k());
            case 5:
                a0 a0Var2 = this.b;
                k1 k1Var = a0Var2.s;
                return Integer.valueOf(a0Var2.j(!a0Var2.k.b() ? a0Var2.k() : k1Var.h() != -1 ? k1Var.h() : Math.abs(((j1) a0Var2.d.d).h()) >= Math.abs(Math.min(a0Var2.q.w0(d0.a), ((float) a0Var2.n()) / 2.0f) / ((float) a0Var2.n())) ? ((Boolean) a0Var2.H.getValue()).booleanValue() ? a0Var2.e + 1 : a0Var2.e : a0Var2.k()));
            case 6:
                return Integer.valueOf(this.b.k());
            case 7:
                return Boolean.valueOf(this.b.k.b());
            default:
                return Integer.valueOf(this.b.p());
        }
    }
}
