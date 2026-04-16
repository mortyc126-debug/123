package ja0;

import lx1.j;

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
    public static final /* synthetic */ tx1.b e;

    static {
        b bVar = new b("Feed", 0);
        b = bVar;
        b bVar2 = new b("Spotlight", 1);
        b bVar3 = new b("Create", 2);
        c = bVar3;
        b[] bVarArr = {bVar, bVar2, bVar3, new b("Beats", 3), new b("Library", 4)};
        d = bVarArr;
        e = qg.a.j(bVarArr);
        Companion = new a();
        a = hs1.d.E(j.a, new io.purchasely.managers.a(25));
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) d.clone();
    }
}
