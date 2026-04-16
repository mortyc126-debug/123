package s4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 {
    public static final h0 a;
    public static final h0 b;
    public static final h0 c;
    public static final /* synthetic */ h0[] d;

    static {
        h0 h0Var = new h0("InMeasureBlock", 0);
        a = h0Var;
        h0 h0Var2 = new h0("InLayoutBlock", 1);
        b = h0Var2;
        h0 h0Var3 = new h0("NotUsed", 2);
        c = h0Var3;
        h0[] h0VarArr = {h0Var, h0Var2, h0Var3};
        d = h0VarArr;
        qg.a.j(h0VarArr);
    }

    public static h0 valueOf(String str) {
        return (h0) Enum.valueOf(h0.class, str);
    }

    public static h0[] values() {
        return (h0[]) d.clone();
    }
}
