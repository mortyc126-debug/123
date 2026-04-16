package p91;

import y10.t;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements t {
    public static final b b;
    public static final b c;
    public static final /* synthetic */ b[] d;
    public static final /* synthetic */ tx1.b e;
    public final String a;

    static {
        b bVar = new b("CreateTab", 0, "create_tab");
        b = bVar;
        b bVar2 = new b("Shortcut", 1, "shortcut");
        b bVar3 = new b("Deeplink", 2, "deeplink");
        c = bVar3;
        b[] bVarArr = {bVar, bVar2, bVar3};
        d = bVarArr;
        e = qg.a.j(bVarArr);
    }

    public b(String str, int i, String str2) {
        this.a = str2;
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) d.clone();
    }

    public final String getTag() {
        return this.a;
    }
}
