package oz0;

import aj.a;
import lx1.j;
import tx1.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@a(deserializable = true, serializable = true)
public final class k0 {
    public static final j0 Companion;
    public static final Object a;
    public static final k0 b;
    public static final /* synthetic */ k0[] c;
    public static final /* synthetic */ b d;

    static {
        k0 k0Var = new k0("Album", 0);
        b = k0Var;
        k0[] k0VarArr = {k0Var, new k0("LP", 1), new k0("EP", 2), new k0("Single", 3), new k0("Mixtape", 4)};
        c = k0VarArr;
        d = qg.a.j(k0VarArr);
        Companion = new j0();
        a = hs1.d.E(j.a, new ow.a(7));
    }

    public static k0 valueOf(String str) {
        return (k0) Enum.valueOf(k0.class, str);
    }

    public static k0[] values() {
        return (k0[]) c.clone();
    }
}
