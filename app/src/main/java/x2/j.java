package x2;

import qg.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    public static final j a;
    public static final j b;
    public static final j c;
    public static final /* synthetic */ j[] d;

    static {
        j jVar = new j("None", 0);
        a = jVar;
        j jVar2 = new j("Touch", 1);
        b = jVar2;
        j jVar3 = new j("Mouse", 2);
        c = jVar3;
        j[] jVarArr = {jVar, jVar2, jVar3};
        d = jVarArr;
        a.j(jVarArr);
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) d.clone();
    }
}
