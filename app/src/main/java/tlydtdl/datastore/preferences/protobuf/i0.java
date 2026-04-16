package tlydtdl.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i0 {
    public static final h0 a;
    public static final h0 b;

    static {
        r0 r0Var = r0.c;
        h0 h0Var = null;
        try {
            h0Var = (h0) Class.forName("tlydtdl.datastore.preferences.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        a = h0Var;
        b = new h0();
    }
}
