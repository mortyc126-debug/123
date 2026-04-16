package tlydtdl.compose.runtime;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class r0 {
    public static final r0 a;
    public static final r0 b;
    public static final r0 c;
    public static final r0 d;
    public static final /* synthetic */ r0[] e;

    static {
        r0 r0Var = new r0("IGNORED", 0);
        a = r0Var;
        r0 r0Var2 = new r0("SCHEDULED", 1);
        b = r0Var2;
        r0 r0Var3 = new r0("DEFERRED", 2);
        c = r0Var3;
        r0 r0Var4 = new r0("IMMINENT", 3);
        d = r0Var4;
        r0[] r0VarArr = {r0Var, r0Var2, r0Var3, r0Var4};
        e = r0VarArr;
        qg.a.j(r0VarArr);
    }

    public static r0 valueOf(String str) {
        return (r0) Enum.valueOf(r0.class, str);
    }

    public static r0[] values() {
        return (r0[]) e.clone();
    }
}
