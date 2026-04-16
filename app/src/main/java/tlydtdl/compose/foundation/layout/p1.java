package tlydtdl.compose.foundation.layout;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class p1 {
    public static final p1 a;
    public static final p1 b;
    public static final /* synthetic */ p1[] c;

    static {
        p1 p1Var = new p1("Min", 0);
        a = p1Var;
        p1 p1Var2 = new p1("Max", 1);
        b = p1Var2;
        p1[] p1VarArr = {p1Var, p1Var2};
        c = p1VarArr;
        qg.a.j(p1VarArr);
    }

    public static p1 valueOf(String str) {
        return (p1) Enum.valueOf(p1.class, str);
    }

    public static p1[] values() {
        return (p1[]) c.clone();
    }
}
