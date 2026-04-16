package s4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 {
    public static final f0 a;
    public static final f0 b;
    public static final f0 c;
    public static final f0 d;
    public static final f0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ f0[] f431f;

    static {
        f0 f0Var = new f0("Measuring", 0);
        a = f0Var;
        f0 f0Var2 = new f0("LookaheadMeasuring", 1);
        b = f0Var2;
        f0 f0Var3 = new f0("LayingOut", 2);
        c = f0Var3;
        f0 f0Var4 = new f0("LookaheadLayingOut", 3);
        d = f0Var4;
        f0 f0Var5 = new f0("Idle", 4);
        e = f0Var5;
        f0[] f0VarArr = {f0Var, f0Var2, f0Var3, f0Var4, f0Var5};
        f431f = f0VarArr;
        qg.a.j(f0VarArr);
    }

    public static f0 valueOf(String str) {
        return (f0) Enum.valueOf(f0.class, str);
    }

    public static f0[] values() {
        return (f0[]) f431f.clone();
    }
}
