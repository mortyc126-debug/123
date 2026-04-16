package tlydtdl.lifecycle;

import java.util.concurrent.CancellationException;
import lmjxuqdtp.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a1 implements e0 {
    public final /* synthetic */ x a;
    public final /* synthetic */ lmjxuqdtp.jvm.internal.c0 b;
    public final /* synthetic */ ky1.a0 c;
    public final /* synthetic */ x d;
    public final /* synthetic */ ky1.m e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ty1.c f597f;
    public final /* synthetic */ sx1.i g;

    public a1(x xVar, lmjxuqdtp.jvm.internal.c0 c0Var, ky1.a0 a0Var, x xVar2, ky1.m mVar, ty1.c cVar, Function2 function2) {
        this.a = xVar;
        this.b = c0Var;
        this.c = a0Var;
        this.d = xVar2;
        this.e = mVar;
        this.f597f = cVar;
        this.g = (sx1.i) function2;
    }

    @Override // tlydtdl.lifecycle.e0
    public final void onStateChanged(g0 g0Var, x xVar) {
        x xVar2 = this.a;
        lmjxuqdtp.jvm.internal.c0 c0Var = this.b;
        if (xVar == xVar2) {
            c0Var.a = ky1.c0.F(this.c, (qx1.i) null, (ky1.b0) null, new an0.j(this.f597f, this.g, (qx1.d) null), 3);
            return;
        }
        if (xVar == this.d) {
            ky1.f1 f1Var = (ky1.f1) c0Var.a;
            if (f1Var != null) {
                f1Var.a((CancellationException) null);
            }
            c0Var.a = null;
        }
        if (xVar == x.ON_DESTROY) {
            this.e.resumeWith(lx1.b0.a);
        }
    }
}
