package tlydtdl.compose.foundation.layout;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class t1 {
    public static final t1 a;
    public static final t1 b;
    public static final /* synthetic */ t1[] c;

    static {
        t1 t1Var = new t1("Horizontal", 0);
        a = t1Var;
        t1 t1Var2 = new t1("Vertical", 1);
        b = t1Var2;
        t1[] t1VarArr = {t1Var, t1Var2};
        c = t1VarArr;
        qg.a.j(t1VarArr);
    }

    public static t1 valueOf(String str) {
        return (t1) Enum.valueOf(t1.class, str);
    }

    public static t1[] values() {
        return (t1[]) c.clone();
    }
}
