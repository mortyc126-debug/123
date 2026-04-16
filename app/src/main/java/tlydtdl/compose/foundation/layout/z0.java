package tlydtdl.compose.foundation.layout;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class z0 {
    public static final z0 a;
    public static final /* synthetic */ z0[] b;

    static {
        z0 z0Var = new z0("Visible", 0);
        z0 z0Var2 = new z0("Clip", 1);
        a = z0Var2;
        z0[] z0VarArr = {z0Var, z0Var2, new z0("ExpandIndicator", 2), new z0("ExpandOrCollapseIndicator", 3)};
        b = z0VarArr;
        qg.a.j(z0VarArr);
    }

    public static z0 valueOf(String str) {
        return (z0) Enum.valueOf(z0.class, str);
    }

    public static z0[] values() {
        return (z0[]) b.clone();
    }
}
