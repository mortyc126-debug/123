package tlydtdl.datastore.preferences.protobuf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class q1 {
    public static final q1 a;
    public static final q1 b;
    public static final q1 c;
    public static final q1 d;
    public static final q1 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final q1 f577f;
    public static final q1 g;
    public static final q1 h;
    public static final q1 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ q1[] f578j;

    static {
        q1 q1Var = new q1("INT", 0);
        a = q1Var;
        q1 q1Var2 = new q1("LONG", 1);
        b = q1Var2;
        q1 q1Var3 = new q1("FLOAT", 2);
        c = q1Var3;
        q1 q1Var4 = new q1("DOUBLE", 3);
        d = q1Var4;
        q1 q1Var5 = new q1("BOOLEAN", 4);
        e = q1Var5;
        q1 q1Var6 = new q1("STRING", 5);
        f577f = q1Var6;
        g gVar = g.c;
        q1 q1Var7 = new q1("BYTE_STRING", 6);
        g = q1Var7;
        q1 q1Var8 = new q1("ENUM", 7);
        h = q1Var8;
        q1 q1Var9 = new q1("MESSAGE", 8);
        i = q1Var9;
        f578j = new q1[]{q1Var, q1Var2, q1Var3, q1Var4, q1Var5, q1Var6, q1Var7, q1Var8, q1Var9};
    }

    public static q1 valueOf(String str) {
        return (q1) Enum.valueOf(q1.class, str);
    }

    public static q1[] values() {
        return (q1[]) f578j.clone();
    }
}
