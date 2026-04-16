package tlydtdl.compose.foundation.layout;

import lmjxuqdtp.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y1 implements Function1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ float b;
    public final /* synthetic */ float c;

    public /* synthetic */ y1(float f2, float f3, int i) {
        this.a = i;
        this.b = f2;
        this.c = f3;
    }

    public final Object invoke(Object obj) {
        t4.e2 e2Var = (t4.e2) obj;
        switch (this.a) {
            case 0:
                e2Var.d("offset");
                e2Var.b().c(new p5.f(this.b), "x");
                e2Var.b().c(new p5.f(this.c), "y");
                break;
            default:
                e2Var.d("padding");
                e2Var.b().c(new p5.f(this.b), "horizontal");
                e2Var.b().c(new p5.f(this.c), "vertical");
                break;
        }
        return lx1.b0.a;
    }
}
