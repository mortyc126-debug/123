package rd1;

import a4.a1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 {
    public static final b0 b;
    public static final b0 c;
    public static final /* synthetic */ b0[] d;
    public final a1 a;

    static {
        b0 b0Var = new b0("Circle", 0, l2.f.a);
        b = b0Var;
        b0 b0Var2 = new b0("RoundedCorners", 1, l2.f.b(8));
        c = b0Var2;
        b0[] b0VarArr = {b0Var, b0Var2};
        d = b0VarArr;
        qg.a.j(b0VarArr);
    }

    public b0(String str, int i, a1 a1Var) {
        this.a = a1Var;
    }

    public static b0 valueOf(String str) {
        return (b0) Enum.valueOf(b0.class, str);
    }

    public static b0[] values() {
        return (b0[]) d.clone();
    }
}
