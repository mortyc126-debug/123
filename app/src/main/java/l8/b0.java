package l8;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class b0 {
    public static final b0 h = new b0(new a0());
    public static final String i = Integer.toString(0, 36);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f283j = Integer.toString(1, 36);
    public static final String k = Integer.toString(2, 36);
    public static final String l = Integer.toString(3, 36);
    public static final String m = Integer.toString(4, 36);
    public static final String n = Integer.toString(5, 36);
    public static final String o = Integer.toString(6, 36);
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f284f;
    public final boolean g;

    public b0(a0 a0Var) {
        this.a = o8.f0.g0(a0Var.a);
        this.c = o8.f0.g0(a0Var.b);
        this.b = a0Var.a;
        this.d = a0Var.b;
        this.e = a0Var.c;
        this.f284f = a0Var.d;
        this.g = a0Var.e;
    }

    public final a0 a() {
        a0 a0Var = new a0();
        a0Var.a = this.b;
        a0Var.b = this.d;
        a0Var.c = this.e;
        a0Var.d = this.f284f;
        a0Var.e = this.g;
        return a0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return this.b == b0Var.b && this.d == b0Var.d && this.e == b0Var.e && this.f284f == b0Var.f284f && this.g == b0Var.g;
    }

    public final int hashCode() {
        long j2 = this.b;
        int i2 = ((int) (j2 ^ (j2 >>> 32))) * 31;
        long j3 = this.d;
        return ((((((i2 + ((int) ((j3 >>> 32) ^ j3))) * 31) + (this.e ? 1 : 0)) * 31) + (this.f284f ? 1 : 0)) * 31) + (this.g ? 1 : 0);
    }
}
