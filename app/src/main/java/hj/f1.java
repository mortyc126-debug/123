package hj;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f1 {
    public static final f1 a;
    public static final f1 b;
    public static final f1 c;
    public static final /* synthetic */ f1[] d;

    static {
        f1 f1Var = new f1("Trim", 0);
        a = f1Var;
        f1 f1Var2 = new f1("Stretch", 1);
        b = f1Var2;
        f1 f1Var3 = new f1("None", 2);
        c = f1Var3;
        f1[] f1VarArr = {f1Var, f1Var2, f1Var3};
        d = f1VarArr;
        qg.a.j(f1VarArr);
    }

    public static f1 valueOf(String str) {
        return (f1) Enum.valueOf(f1.class, str);
    }

    public static f1[] values() {
        return (f1[]) d.clone();
    }
}
