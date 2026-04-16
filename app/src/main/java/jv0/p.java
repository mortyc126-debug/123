package jv0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@aj.a(deserializable = true, serializable = true)
public final class p {
    public static final o Companion;
    public static final Object a;
    public static final p b;
    public static final /* synthetic */ p[] c;

    static {
        p pVar = new p("Month", 0);
        b = pVar;
        p[] pVarArr = {pVar, new p("Year", 1), new p("Day", 2)};
        c = pVarArr;
        qg.a.j(pVarArr);
        Companion = new o();
        a = hs1.d.E(lx1.j.a, new jl1.a(15));
    }

    public static p valueOf(String str) {
        return (p) Enum.valueOf(p.class, str);
    }

    public static p[] values() {
        return (p[]) c.clone();
    }
}
