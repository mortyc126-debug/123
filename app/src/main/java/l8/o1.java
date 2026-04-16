package l8;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class o1 {
    public static final o1 d = new o1(new n1());
    public static final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f306f;
    public static final String g;
    public final int a;
    public final boolean b;
    public final boolean c;

    static {
        int i = o8.f0.a;
        e = Integer.toString(1, 36);
        f306f = Integer.toString(2, 36);
        g = Integer.toString(3, 36);
    }

    public o1(n1 n1Var) {
        this.a = n1Var.a;
        this.b = n1Var.b;
        this.c = n1Var.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && o1.class == obj.getClass()) {
            o1 o1Var = (o1) obj;
            if (this.a == o1Var.a && this.b == o1Var.b && this.c == o1Var.c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.a + 31) * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0);
    }
}
