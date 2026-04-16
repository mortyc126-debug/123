package tlydtdl.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class q {
    public static final p a = new p();
    public static final p b;

    static {
        r0 r0Var = r0.c;
        p pVar = null;
        try {
            pVar = (p) Class.forName("tlydtdl.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        b = pVar;
    }
}
