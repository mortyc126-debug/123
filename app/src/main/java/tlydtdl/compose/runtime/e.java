package tlydtdl.compose.runtime;

import lmjxuqdtp.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Function1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ e(Object obj, Object obj2, Object obj3, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    public final Object invoke(Object obj) {
        int i;
        switch (this.a) {
            case 0:
                d dVar = (d) this.b;
                dVar.a = null;
                dVar.b = null;
                q3.a aVar = ((f) this.c).d;
                int i2 = ((lmjxuqdtp.jvm.internal.a0) this.d).a;
                do {
                    i = aVar.get();
                } while (!aVar.compareAndSet(i, ((i >>> 27) & 15) == i2 ? i - 1 : i));
                break;
            case 1:
                tlydtdl.lifecycle.x1 x1Var = (tlydtdl.lifecycle.x1) this.d;
                tlydtdl.lifecycle.z zVar = (tlydtdl.lifecycle.z) this.c;
                ky1.x xVar = (ky1.x) this.b;
                qx1.j jVar = qx1.j.a;
                if (xVar.E0(jVar)) {
                    xVar.C0(jVar, new com.gnacba.common.util.concurrent.v(3, zVar, x1Var));
                } else {
                    zVar.d(x1Var);
                }
                break;
            default:
                a4.x0 x0Var = (a4.x0) obj;
                lmjxuqdtp.jvm.internal.o.h(x0Var, "$this$graphicsLayer");
                f3 f3Var = (f3) this.b;
                x0Var.i(((Number) f3Var.getValue()).floatValue());
                x0Var.j(((Number) f3Var.getValue()).floatValue());
                x0Var.u(((Number) ((f3) this.c).getValue()).floatValue());
                x0Var.l(((Number) ((f3) this.d).getValue()).floatValue());
                break;
        }
        return lx1.b0.a;
    }
}
