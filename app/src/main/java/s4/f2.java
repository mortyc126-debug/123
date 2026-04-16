package s4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f2 {
    public static final f2 a;
    public static final f2 b;
    public static final f2 c;
    public static final /* synthetic */ f2[] d;

    static {
        f2 f2Var = new f2("ContinueTraversal", 0);
        a = f2Var;
        f2 f2Var2 = new f2("SkipSubtreeAndContinueTraversal", 1);
        b = f2Var2;
        f2 f2Var3 = new f2("CancelTraversal", 2);
        c = f2Var3;
        f2[] f2VarArr = {f2Var, f2Var2, f2Var3};
        d = f2VarArr;
        qg.a.j(f2VarArr);
    }

    public static f2 valueOf(String str) {
        return (f2) Enum.valueOf(f2.class, str);
    }

    public static f2[] values() {
        return (f2[]) d.clone();
    }
}
