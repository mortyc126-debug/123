package cf1;

import qg.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class q0 {
    public static final q0 a;
    public static final q0 b;
    public static final /* synthetic */ q0[] c;

    static {
        q0 q0Var = new q0("FromStart", 0);
        a = q0Var;
        q0 q0Var2 = new q0("FromCenter", 1);
        b = q0Var2;
        q0[] q0VarArr = {q0Var, q0Var2};
        c = q0VarArr;
        a.j(q0VarArr);
    }

    public static q0 valueOf(String str) {
        return (q0) Enum.valueOf(q0.class, str);
    }

    public static q0[] values() {
        return (q0[]) c.clone();
    }
}
