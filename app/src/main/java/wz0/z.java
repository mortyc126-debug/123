package wz0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class z {
    public static final z a;
    public static final z b;
    public static final /* synthetic */ z[] c;

    static {
        z zVar = new z("AboveEntity", 0);
        a = zVar;
        z zVar2 = new z("BetweenEntityAndSocialActions", 1);
        b = zVar2;
        z[] zVarArr = {zVar, zVar2};
        c = zVarArr;
        qg.a.j(zVarArr);
    }

    public static z valueOf(String str) {
        return (z) Enum.valueOf(z.class, str);
    }

    public static z[] values() {
        return (z[]) c.clone();
    }
}
