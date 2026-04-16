package oz0;

import aj.a;
import lx1.j;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@a(deserializable = true, serializable = true)
public final class x0 {
    public static final w0 Companion;
    public static final Object a;
    public static final x0 b;
    public static final x0 c;
    public static final /* synthetic */ x0[] d;

    static {
        x0 x0Var = new x0("Album", 0);
        b = x0Var;
        x0 x0Var2 = new x0("RevisionPost", 1);
        x0 x0Var3 = new x0("Beat", 2);
        c = x0Var3;
        x0[] x0VarArr = {x0Var, x0Var2, x0Var3};
        d = x0VarArr;
        qg.a.j(x0VarArr);
        Companion = new w0();
        a = hs1.d.E(j.a, new ow.a(11));
    }

    public static x0 valueOf(String str) {
        return (x0) Enum.valueOf(x0.class, str);
    }

    public static x0[] values() {
        return (x0[]) d.clone();
    }
}
