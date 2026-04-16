package hj;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class o0 {
    public static final o0 a;
    public static final o0 b;
    public static final o0 c;
    public static final o0 d;
    public static final /* synthetic */ o0[] e;

    static {
        o0 o0Var = new o0("Untouched", 0);
        a = o0Var;
        o0 o0Var2 = new o0("Tapped", 1);
        b = o0Var2;
        o0 o0Var3 = new o0("DoubleTapped", 2);
        c = o0Var3;
        o0 o0Var4 = new o0("Dragging", 3);
        d = o0Var4;
        o0[] o0VarArr = {o0Var, o0Var2, o0Var3, o0Var4};
        e = o0VarArr;
        qg.a.j(o0VarArr);
    }

    public static o0 valueOf(String str) {
        return (o0) Enum.valueOf(o0.class, str);
    }

    public static o0[] values() {
        return (o0[]) e.clone();
    }
}
