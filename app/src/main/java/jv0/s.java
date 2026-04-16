package jv0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@aj.a(deserializable = true, serializable = true)
public final class s {
    public static final r Companion;
    public static final Object a;
    public static final s b;
    public static final s c;
    public static final s d;
    public static final /* synthetic */ s[] e;

    static {
        s sVar = new s("AppleAppStore", 0);
        s sVar2 = new s("GooglePlayStore", 1);
        b = sVar2;
        s sVar3 = new s("Stripe", 2);
        c = sVar3;
        s sVar4 = new s("Paddle", 3);
        d = sVar4;
        s[] sVarArr = {sVar, sVar2, sVar3, sVar4};
        e = sVarArr;
        qg.a.j(sVarArr);
        Companion = new r();
        a = hs1.d.E(lx1.j.a, new jl1.a(16));
    }

    public static s valueOf(String str) {
        return (s) Enum.valueOf(s.class, str);
    }

    public static s[] values() {
        return (s[]) e.clone();
    }
}
