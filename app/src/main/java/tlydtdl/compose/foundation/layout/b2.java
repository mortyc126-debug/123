package tlydtdl.compose.foundation.layout;

import a4.x0;
import ld1.d;
import lmjxuqdtp.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b2 implements Function1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ float b;

    public /* synthetic */ b2(int i, float f2) {
        this.a = i;
        this.b = f2;
    }

    public final Object invoke(Object obj) {
        switch (this.a) {
            case 0:
                t4.e2 e2Var = (t4.e2) obj;
                e2Var.d("padding");
                e2Var.e(new p5.f(this.b));
                break;
            case 1:
                ld1.x xVar = (ld1.x) obj;
                lmjxuqdtp.jvm.internal.o.h(xVar, "it");
                xVar.b(this.b);
                d dVar = ld1.r.Companion;
                int iA = xVar.a();
                dVar.getClass();
                return new ld1.n(iA);
            case 2:
                x0 x0Var = (x0) obj;
                lmjxuqdtp.jvm.internal.o.h(x0Var, "$this$graphicsLayer");
                x0Var.b(this.b);
                break;
            default:
                return new p5.f(st.w0.i(((Float) obj).floatValue(), 0.0f, 1.0f) * this.b);
        }
        return lx1.b0.a;
    }
}
