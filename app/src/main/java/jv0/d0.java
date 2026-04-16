package jv0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@aj.a(deserializable = true, serializable = true)
public final class d0 {
    public static final c0 Companion;
    public static final Object a;
    public static final d0 b;
    public static final /* synthetic */ d0[] c;

    static {
        d0 d0Var = new d0("Free", 0);
        b = d0Var;
        d0[] d0VarArr = {d0Var, new d0("Basic", 1), new d0("Premium", 2)};
        c = d0VarArr;
        qg.a.j(d0VarArr);
        Companion = new c0();
        a = hs1.d.E(lx1.j.a, new jl1.a(22));
    }

    public static d0 valueOf(String str) {
        return (d0) Enum.valueOf(d0.class, str);
    }

    public static d0[] values() {
        return (d0[]) c.clone();
    }
}
