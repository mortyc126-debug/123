package f;

import tlydtdl.lifecycle.e0;
import tlydtdl.lifecycle.g0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class z implements e0, AutoCloseable {
    public final /* synthetic */ v a;
    public final /* synthetic */ w b;
    public final /* synthetic */ tlydtdl.lifecycle.z c;

    public z(v vVar, w wVar, a0 a0Var, tlydtdl.lifecycle.z zVar) {
        this.a = vVar;
        this.b = wVar;
        this.c = zVar;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.c.d(this);
    }

    @Override // tlydtdl.lifecycle.e0
    public final void onStateChanged(g0 g0Var, tlydtdl.lifecycle.x xVar) {
        boolean z = xVar.a().compareTo(tlydtdl.lifecycle.y.d) >= 0 && this.b.b;
        v vVar = this.a;
        vVar.g(z);
        if (xVar == tlydtdl.lifecycle.x.ON_DESTROY) {
            vVar.f();
            this.c.d(this);
        }
    }
}
