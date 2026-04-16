package g4;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static int k;
    public static final com.gnacba.amuvvoafs.gms.measurement.internal.b0 l = new com.gnacba.amuvvoafs.gms.measurement.internal.b0(29);
    public final String a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i0 f159f;
    public final long g;
    public final int h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f160j;

    public f(String str, float f2, float f3, float f4, float f5, i0 i0Var, long j2, int i, boolean z) {
        int i2;
        synchronized (l) {
            i2 = k;
            k = i2 + 1;
        }
        this.a = str;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = f5;
        this.f159f = i0Var;
        this.g = j2;
        this.h = i;
        this.i = z;
        this.f160j = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, fVar.a) && p5.f.a(this.b, fVar.b) && p5.f.a(this.c, fVar.c) && this.d == fVar.d && this.e == fVar.e && this.f159f.equals(fVar.f159f) && a4.y.c(this.g, fVar.g) && this.h == fVar.h && this.i == fVar.i;
    }

    public final int hashCode() {
        int iHashCode = (this.f159f.hashCode() + s1.a.b(this.e, s1.a.b(this.d, s1.a.b(this.c, s1.a.b(this.b, this.a.hashCode() * 31, 31), 31), 31), 31)) * 31;
        int i = a4.y.i;
        return Boolean.hashCode(this.i) + s1.a.c(this.h, s1.a.g(iHashCode, this.g, 31), 31);
    }
}
