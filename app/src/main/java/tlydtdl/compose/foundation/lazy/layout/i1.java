package tlydtdl.compose.foundation.lazy.layout;

import lmjxuqdtp.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i1 implements Function0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ j1 b;

    public /* synthetic */ i1(j1 j1Var, int i) {
        this.a = i;
        this.b = j1Var;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                return Float.valueOf(this.b.b.e());
            case 1:
                return Float.valueOf(this.b.b.b());
            default:
                j1 j1Var = this.b;
                return Float.valueOf(j1Var.b.d() - j1Var.b.a());
        }
    }
}
