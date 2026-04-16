package x2;

import qg.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {
    public static final a0 a;
    public static final a0 b;
    public static final a0 c;
    public static final /* synthetic */ a0[] d;

    static {
        a0 a0Var = new a0("None", 0);
        a = a0Var;
        a0 a0Var2 = new a0("Cursor", 1);
        b = a0Var2;
        a0 a0Var3 = new a0("Selection", 2);
        c = a0Var3;
        a0[] a0VarArr = {a0Var, a0Var2, a0Var3};
        d = a0VarArr;
        a.j(a0VarArr);
    }

    public static a0 valueOf(String str) {
        return (a0) Enum.valueOf(a0.class, str);
    }

    public static a0[] values() {
        return (a0[]) d.clone();
    }
}
