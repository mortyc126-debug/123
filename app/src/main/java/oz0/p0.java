package oz0;

import aj.a;
import lx1.j;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@a(deserializable = true, serializable = true)
public final class p0 {
    public static final o0 Companion;
    public static final Object a;
    public static final p0 b;
    public static final p0 c;
    public static final /* synthetic */ p0[] d;

    static {
        p0 p0Var = new p0("FollowCta", 0);
        b = p0Var;
        p0 p0Var2 = new p0("Default", 1);
        c = p0Var2;
        p0[] p0VarArr = {p0Var, p0Var2};
        d = p0VarArr;
        qg.a.j(p0VarArr);
        Companion = new o0();
        a = hs1.d.E(j.a, new ow.a(9));
    }

    public static p0 valueOf(String str) {
        return (p0) Enum.valueOf(p0.class, str);
    }

    public static p0[] values() {
        return (p0[]) d.clone();
    }
}
