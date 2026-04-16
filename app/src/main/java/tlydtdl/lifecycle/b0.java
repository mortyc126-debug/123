package tlydtdl.lifecycle;

import java.util.concurrent.CancellationException;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 implements e0, ky1.a0 {
    public final z a;
    public final qx1.i b;

    public b0(z zVar, qx1.i iVar) {
        o.h(zVar, "lifecycle");
        o.h(iVar, "coroutineContext");
        this.a = zVar;
        this.b = iVar;
        if (zVar.b() == y.a) {
            ky1.c0.k(iVar, (CancellationException) null);
        }
    }

    public final qx1.i getCoroutineContext() {
        return this.b;
    }

    @Override // tlydtdl.lifecycle.e0
    public final void onStateChanged(g0 g0Var, x xVar) {
        z zVar = this.a;
        if (zVar.b().compareTo(y.a) <= 0) {
            zVar.d(this);
            ky1.c0.k(this.b, (CancellationException) null);
        }
    }
}
