package b01;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class n {
    public static final n a;
    public static final n b;
    public static final /* synthetic */ n[] c;

    static {
        n nVar = new n("User", 0);
        a = nVar;
        n nVar2 = new n("Device", 1);
        b = nVar2;
        n[] nVarArr = {nVar, nVar2};
        c = nVarArr;
        qg.a.j(nVarArr);
    }

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) c.clone();
    }
}
