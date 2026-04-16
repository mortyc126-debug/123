package tlydtdl.compose.runtime;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class w1 implements e1, ky1.a0 {
    public final /* synthetic */ e1 a;
    public final qx1.i b;

    public w1(e1 e1Var, qx1.i iVar) {
        this.a = e1Var;
        this.b = iVar;
    }

    public final qx1.i getCoroutineContext() {
        return this.b;
    }

    @Override // tlydtdl.compose.runtime.f3
    public final Object getValue() {
        return this.a.getValue();
    }

    @Override // tlydtdl.compose.runtime.e1
    public final void setValue(Object obj) {
        this.a.setValue(obj);
    }
}
