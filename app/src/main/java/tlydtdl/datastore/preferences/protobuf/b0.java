package tlydtdl.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 {
    public static x a(Object obj, long j2) {
        x xVar = (x) i1.c.h(obj, j2);
        if (((b) xVar).a) {
            return xVar;
        }
        s0 s0Var = (s0) xVar;
        int i = s0Var.c;
        s0 s0VarE = s0Var.e(i == 0 ? 10 : i * 2);
        i1.o(j2, obj, s0VarE);
        return s0VarE;
    }
}
