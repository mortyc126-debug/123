package jv0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@aj.a(deserializable = true, serializable = true)
public final class b {
    public static final a Companion;
    public static final Object a;
    public static final b b;
    public static final b c;
    public static final /* synthetic */ b[] d;

    static {
        b bVar = new b("GracePeriod", 0);
        b = bVar;
        b bVar2 = new b("OnHold", 1);
        c = bVar2;
        b[] bVarArr = {bVar, bVar2};
        d = bVarArr;
        qg.a.j(bVarArr);
        Companion = new a();
        a = hs1.d.E(lx1.j.a, new jl1.a(14));
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) d.clone();
    }
}
