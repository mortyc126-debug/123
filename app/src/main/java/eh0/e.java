package eh0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static final e a;
    public static final /* synthetic */ e[] b;

    static {
        e eVar = new e("SHORT", 0);
        e eVar2 = new e("LONG", 1);
        e eVar3 = new e("LONGER", 2);
        e eVar4 = new e("PERMANENT", 3);
        a = eVar4;
        e[] eVarArr = {eVar, eVar2, eVar3, eVar4};
        b = eVarArr;
        qg.a.j(eVarArr);
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) b.clone();
    }
}
