package tlydtdl.lifecycle;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f1 implements e0 {
    public final j1 a;

    public f1(j1 j1Var) {
        this.a = j1Var;
    }

    @Override // tlydtdl.lifecycle.e0
    public final void onStateChanged(g0 g0Var, x xVar) {
        if (xVar == x.ON_CREATE) {
            g0Var.getLifecycle().d(this);
            this.a.a();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + xVar).toString());
        }
    }
}
