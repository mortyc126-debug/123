package ze;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final b c;
    public static final b d;
    public static final /* synthetic */ b[] e;
    public final boolean a;
    public final boolean b;

    static {
        b bVar = new b(0, "ENABLED", true, true);
        c = bVar;
        b bVar2 = new b(1, "READ_ONLY", true, false);
        b bVar3 = new b(2, "WRITE_ONLY", false, true);
        b bVar4 = new b(3, "DISABLED", false, false);
        d = bVar4;
        b[] bVarArr = {bVar, bVar2, bVar3, bVar4};
        e = bVarArr;
        qg.a.j(bVarArr);
    }

    public b(int i, String str, boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) e.clone();
    }
}
