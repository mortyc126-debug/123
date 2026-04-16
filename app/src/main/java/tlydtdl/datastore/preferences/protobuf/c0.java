package tlydtdl.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c0 {
    public static final b0 a;
    public static final b0 b;

    static {
        r0 r0Var = r0.c;
        b0 b0Var = null;
        try {
            b0Var = (b0) Class.forName("tlydtdl.datastore.preferences.protobuf.ListFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        a = b0Var;
        b = new b0();
    }
}
