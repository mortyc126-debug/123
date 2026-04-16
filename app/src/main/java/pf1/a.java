package pf1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final a a;
    public static final a b;
    public static final a c;
    public static final a d;
    public static final /* synthetic */ a[] e;

    static {
        a aVar = new a("User", 0);
        a = aVar;
        a aVar2 = new a("HashTag", 1);
        b = aVar2;
        a aVar3 = new a("Url", 2);
        c = aVar3;
        a aVar4 = new a("Whole", 3);
        d = aVar4;
        a[] aVarArr = {aVar, aVar2, aVar3, aVar4};
        e = aVarArr;
        qg.a.j(aVarArr);
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) e.clone();
    }
}
