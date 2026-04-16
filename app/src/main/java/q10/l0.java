package q10;

import aj.a;
import hs1.d;
import lx1.j;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@a(deserializable = true, serializable = true)
public final class l0 {
    public static final k0 Companion;
    public static final Object a;
    public static final l0 b;
    public static final l0 c;
    public static final l0 d;
    public static final /* synthetic */ l0[] e;

    static {
        l0 l0Var = new l0("Following", 0);
        b = l0Var;
        l0 l0Var2 = new l0("ApprovalPending", 1);
        c = l0Var2;
        l0 l0Var3 = new l0("None", 2);
        d = l0Var3;
        l0[] l0VarArr = {l0Var, l0Var2, l0Var3};
        e = l0VarArr;
        qg.a.j(l0VarArr);
        Companion = new k0();
        a = d.E(j.a, new ow.a(25));
    }

    public static l0 valueOf(String str) {
        return (l0) Enum.valueOf(l0.class, str);
    }

    public static l0[] values() {
        return (l0[]) e.clone();
    }
}
