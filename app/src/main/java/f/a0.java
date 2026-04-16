package f;

import amuvvoafs.window.OnBackInvokedDispatcher;
import bb.z0;
import kotlin.time.DurationKt;
import tlydtdl.lifecycle.g0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {
    public final Runnable a;
    public final kb.c b;
    public final y c;

    public a0(Runnable runnable) {
        this.a = runnable;
        kb.c cVar = new kb.c(new z0(7, this));
        this.b = cVar;
        y yVar = new y();
        this.c = yVar;
        cVar.b(yVar);
    }

    public final void a(g0 g0Var, w wVar) {
        lmjxuqdtp.jvm.internal.o.h(wVar, "onBackPressedCallback");
        tlydtdl.lifecycle.z lifecycle = g0Var.getLifecycle();
        if (lifecycle.b() == tlydtdl.lifecycle.y.a) {
            return;
        }
        v vVar = new v(wVar, new x(g0Var, wVar));
        wVar.a.add(vVar);
        vVar.g(false);
        kb.c.a(this.b, vVar);
        z zVar = new z(vVar, wVar, this, lifecycle);
        lifecycle.a(zVar);
        wVar.c.add(zVar);
    }

    public final void b(w wVar) {
        v vVar = new v(wVar, new x(null, wVar));
        wVar.a.add(vVar);
        kb.c.a(this.b, vVar);
    }

    public final void c(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        kb.n nVar = new kb.n(onBackInvokedDispatcher, 0);
        kb.c cVar = this.b;
        cVar.c(nVar, 1);
        cVar.c(new kb.n(onBackInvokedDispatcher, DurationKt.NANOS_IN_MILLIS), 0);
    }
}
