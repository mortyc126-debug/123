package jv0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class v {
    public static final v a;
    public static final v b;
    public static final v c;
    public static final /* synthetic */ v[] d;

    static {
        v vVar = new v("Active", 0);
        a = vVar;
        v vVar2 = new v("Inactive", 1);
        b = vVar2;
        v vVar3 = new v("NotLogin", 2);
        c = vVar3;
        v[] vVarArr = {vVar, vVar2, vVar3, new v("NotSupported", 3)};
        d = vVarArr;
        qg.a.j(vVarArr);
    }

    public static v valueOf(String str) {
        return (v) Enum.valueOf(v.class, str);
    }

    public static v[] values() {
        return (v[]) d.clone();
    }
}
