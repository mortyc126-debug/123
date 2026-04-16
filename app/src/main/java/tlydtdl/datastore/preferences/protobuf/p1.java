package tlydtdl.datastore.preferences.protobuf;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF2' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class p1 {
    public static final l1 c;
    public static final m1 d;
    public static final n1 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ p1[] f576f;
    public final q1 a;
    public final int b;

    /* JADX INFO: Fake field, exist only in values array */
    p1 EF0;

    /* JADX INFO: Fake field, exist only in values array */
    p1 EF1;

    /* JADX INFO: Fake field, exist only in values array */
    p1 EF2;

    static {
        p1 p1Var = new p1("DOUBLE", 0, q1.d, 1);
        p1 p1Var2 = new p1("FLOAT", 1, q1.c, 5);
        q1 q1Var = q1.b;
        p1 p1Var3 = new p1("INT64", 2, q1Var, 0);
        p1 p1Var4 = new p1("UINT64", 3, q1Var, 0);
        q1 q1Var2 = q1.a;
        p1 p1Var5 = new p1("INT32", 4, q1Var2, 0);
        p1 p1Var6 = new p1("FIXED64", 5, q1Var, 1);
        p1 p1Var7 = new p1("FIXED32", 6, q1Var2, 5);
        p1 p1Var8 = new p1("BOOL", 7, q1.e, 0);
        l1 l1Var = new l1("STRING", 8, q1.f577f, 2);
        c = l1Var;
        q1 q1Var3 = q1.i;
        m1 m1Var = new m1("GROUP", 9, q1Var3, 3);
        d = m1Var;
        n1 n1Var = new n1("MESSAGE", 10, q1Var3, 2);
        e = n1Var;
        f576f = new p1[]{p1Var, p1Var2, p1Var3, p1Var4, p1Var5, p1Var6, p1Var7, p1Var8, l1Var, m1Var, n1Var, new o1("BYTES", 11, q1.g, 2), new p1("UINT32", 12, q1Var2, 0), new p1("ENUM", 13, q1.h, 0), new p1("SFIXED32", 14, q1Var2, 5), new p1("SFIXED64", 15, q1Var, 1), new p1("SINT32", 16, q1Var2, 0), new p1("SINT64", 17, q1Var, 0)};
    }

    public p1(String str, int i, q1 q1Var, int i2) {
        this.a = q1Var;
        this.b = i2;
    }

    public static p1 valueOf(String str) {
        return (p1) Enum.valueOf(p1.class, str);
    }

    public static p1[] values() {
        return (p1[]) f576f.clone();
    }
}
