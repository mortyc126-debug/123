package oz0;

import aj.a;
import lx1.j;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@a(deserializable = true, serializable = true)
public final class v1 {
    public static final u1 Companion;
    public static final Object a;
    public static final /* synthetic */ v1[] b;

    static {
        v1[] v1VarArr = {new v1("Reacted", 0)};
        b = v1VarArr;
        qg.a.j(v1VarArr);
        Companion = new u1();
        a = hs1.d.E(j.a, new ow.a(16));
    }

    public static v1 valueOf(String str) {
        return (v1) Enum.valueOf(v1.class, str);
    }

    public static v1[] values() {
        return (v1[]) b.clone();
    }
}
