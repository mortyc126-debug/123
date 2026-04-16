package tlydtdl.compose.runtime;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c2 {
    public static final c2 a;
    public static final c2 b;
    public static final c2 c;
    public static final c2 d;
    public static final c2 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c2 f524f;
    public static final /* synthetic */ c2[] g;

    static {
        c2 c2Var = new c2("ShutDown", 0);
        a = c2Var;
        c2 c2Var2 = new c2("ShuttingDown", 1);
        b = c2Var2;
        c2 c2Var3 = new c2("Inactive", 2);
        c = c2Var3;
        c2 c2Var4 = new c2("InactivePendingWork", 3);
        d = c2Var4;
        c2 c2Var5 = new c2("Idle", 4);
        e = c2Var5;
        c2 c2Var6 = new c2("PendingWork", 5);
        f524f = c2Var6;
        c2[] c2VarArr = {c2Var, c2Var2, c2Var3, c2Var4, c2Var5, c2Var6};
        g = c2VarArr;
        qg.a.j(c2VarArr);
    }

    public static c2 valueOf(String str) {
        return (c2) Enum.valueOf(c2.class, str);
    }

    public static c2[] values() {
        return (c2[]) g.clone();
    }
}
