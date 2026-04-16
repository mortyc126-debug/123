package l8;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a2 {
    public static final a2 d = new a2(0, 0);
    public static final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f280f;
    public static final String g;
    public final int a;
    public final int b;
    public final float c;

    static {
        int i = o8.f0.a;
        e = Integer.toString(0, 36);
        f280f = Integer.toString(1, 36);
        g = Integer.toString(3, 36);
    }

    public a2(int i, int i2) {
        this(1.0f, i, i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a2) {
            a2 a2Var = (a2) obj;
            if (this.a == a2Var.a && this.b == a2Var.b && this.c == a2Var.c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(this.c) + ((((217 + this.a) * 31) + this.b) * 31);
    }

    public a2(float f2, int i, int i2) {
        this.a = i;
        this.b = i2;
        this.c = f2;
    }
}
