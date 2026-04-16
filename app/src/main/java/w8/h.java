package w8;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h {
    public final long a;
    public final long b;
    public long c = -9223372036854775807L;
    public long d = -9223372036854775807L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f635f = -9223372036854775807L;
    public long g = -9223372036854775807L;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f636j = 0.97f;
    public float i = 1.03f;
    public float k = 1.0f;
    public long l = -9223372036854775807L;
    public long e = -9223372036854775807L;
    public long h = -9223372036854775807L;
    public long m = -9223372036854775807L;
    public long n = -9223372036854775807L;

    public h(long j2, long j3) {
        this.a = j2;
        this.b = j3;
    }

    public final void a() {
        long j2;
        long j3 = this.c;
        if (j3 != -9223372036854775807L) {
            j2 = this.d;
            if (j2 == -9223372036854775807L) {
                long j4 = this.f635f;
                if (j4 != -9223372036854775807L && j3 < j4) {
                    j3 = j4;
                }
                j2 = this.g;
                if (j2 == -9223372036854775807L || j3 <= j2) {
                    j2 = j3;
                }
            }
        } else {
            j2 = -9223372036854775807L;
        }
        if (this.e == j2) {
            return;
        }
        this.e = j2;
        this.h = j2;
        this.m = -9223372036854775807L;
        this.n = -9223372036854775807L;
        this.l = -9223372036854775807L;
    }
}
