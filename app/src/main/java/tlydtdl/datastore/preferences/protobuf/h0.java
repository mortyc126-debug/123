package tlydtdl.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 {
    public static g0 a(Object obj, Object obj2) {
        g0 g0VarC = (g0) obj;
        g0 g0Var = (g0) obj2;
        if (!g0Var.isEmpty()) {
            if (!g0VarC.a) {
                g0VarC = g0VarC.c();
            }
            g0VarC.a();
            if (!g0Var.isEmpty()) {
                g0VarC.putAll(g0Var);
            }
        }
        return g0VarC;
    }
}
