package cf1;

import qg.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class m0 {
    public static final m0 a;
    public static final m0 b;
    public static final m0 c;
    public static final /* synthetic */ m0[] d;

    static {
        m0 m0Var = new m0("Hidden", 0);
        a = m0Var;
        m0 m0Var2 = new m0("AlwaysVisible", 1);
        b = m0Var2;
        m0 m0Var3 = new m0("VisibleOnlyOnDrag", 2);
        c = m0Var3;
        m0[] m0VarArr = {m0Var, m0Var2, m0Var3};
        d = m0VarArr;
        a.j(m0VarArr);
    }

    public static m0 valueOf(String str) {
        return (m0) Enum.valueOf(m0.class, str);
    }

    public static m0[] values() {
        return (m0[]) d.clone();
    }
}
