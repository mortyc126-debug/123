package oc0;

import qg.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class r {
    public static final r a;
    public static final r b;
    public static final /* synthetic */ r[] c;

    static {
        r rVar = new r("MY_BANDS", 0);
        a = rVar;
        r rVar2 = new r("MY_SONGS", 1);
        b = rVar2;
        r[] rVarArr = {rVar, rVar2};
        c = rVarArr;
        a.j(rVarArr);
    }

    public static r valueOf(String str) {
        return (r) Enum.valueOf(r.class, str);
    }

    public static r[] values() {
        return (r[]) c.clone();
    }
}
