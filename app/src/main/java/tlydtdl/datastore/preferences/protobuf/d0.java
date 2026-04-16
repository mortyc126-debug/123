package tlydtdl.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 implements j0 {
    public j0[] a;

    @Override // tlydtdl.datastore.preferences.protobuf.j0
    public final t0 a(Class cls) {
        for (j0 j0Var : this.a) {
            if (j0Var.b(cls)) {
                return j0Var.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // tlydtdl.datastore.preferences.protobuf.j0
    public final boolean b(Class cls) {
        for (j0 j0Var : this.a) {
            if (j0Var.b(cls)) {
                return true;
            }
        }
        return false;
    }
}
