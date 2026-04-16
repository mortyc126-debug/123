package cf1;

import qg.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class k0 {
    public static final k0 a;
    public static final k0 b;
    public static final k0 c;
    public static final /* synthetic */ k0[] d;

    static {
        k0 k0Var = new k0("Pressed", 0);
        a = k0Var;
        k0 k0Var2 = new k0("Dragging", 1);
        b = k0Var2;
        k0 k0Var3 = new k0("Released", 2);
        c = k0Var3;
        k0[] k0VarArr = {k0Var, k0Var2, k0Var3};
        d = k0VarArr;
        a.j(k0VarArr);
    }

    public static k0 valueOf(String str) {
        return (k0) Enum.valueOf(k0.class, str);
    }

    public static k0[] values() {
        return (k0[]) d.clone();
    }

    public final boolean a() {
        return this == a || this == b;
    }
}
