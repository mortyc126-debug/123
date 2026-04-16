package tlydtdl.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c1 extends a1 {
    @Override // tlydtdl.datastore.preferences.protobuf.a1
    public final b1 a(Object obj) {
        w wVar = (w) obj;
        b1 b1Var = wVar.unknownFields;
        if (b1Var != b1.f568f) {
            return b1Var;
        }
        b1 b1Var2 = new b1(0, new int[8], new Object[8], true);
        wVar.unknownFields = b1Var2;
        return b1Var2;
    }
}
