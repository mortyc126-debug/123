package zi;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static final g a;
    public static final g b;
    public static final g c;
    public static final /* synthetic */ g[] d;

    static {
        g gVar = new g("NotInited", 0);
        a = gVar;
        g gVar2 = new g("Inited", 1);
        b = gVar2;
        g gVar3 = new g("Restored", 2);
        c = gVar3;
        g[] gVarArr = {gVar, gVar2, gVar3};
        d = gVarArr;
        qg.a.j(gVarArr);
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) d.clone();
    }
}
