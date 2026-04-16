package l8;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h1 {
    public static final String h;
    public static final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f294j;
    public static final String k;
    public static final String l;
    public Object a;
    public Object b;
    public int c;
    public long d;
    public long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f295f;
    public b g = b.f281f;

    static {
        int i2 = o8.f0.a;
        h = Integer.toString(0, 36);
        i = Integer.toString(1, 36);
        f294j = Integer.toString(2, 36);
        k = Integer.toString(3, 36);
        l = Integer.toString(4, 36);
    }

    public final long a(int i2, int i3) {
        a aVarA = this.g.a(i2);
        if (aVarA.b != -1) {
            return aVarA.g[i3];
        }
        return -9223372036854775807L;
    }

    public final int b(long j2) {
        a aVarA;
        int i2;
        b bVar = this.g;
        long j3 = this.d;
        int i3 = bVar.a;
        if (j2 != Long.MIN_VALUE && (j3 == -9223372036854775807L || j2 < j3)) {
            int i4 = bVar.d;
            while (i4 < i3 && ((bVar.a(i4).a != Long.MIN_VALUE && bVar.a(i4).a <= j2) || ((i2 = (aVarA = bVar.a(i4)).b) != -1 && aVarA.a(-1) >= i2))) {
                i4++;
            }
            if (i4 < i3) {
                return i4;
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int c(long r15) {
        /*
            r14 = this;
            l8.b r0 = r14.g
            long r1 = r14.d
            int r3 = r0.a
            int r4 = r3 + (-1)
            r5 = 1
            int r3 = r3 - r5
            r6 = 0
            r7 = -9223372036854775808
            r9 = -1
            if (r4 != r3) goto L24
            l8.a r3 = r0.a(r4)
            boolean r10 = r3.k
            if (r10 == 0) goto L24
            long r10 = r3.a
            int r10 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r10 != 0) goto L24
            int r3 = r3.b
            if (r3 != r9) goto L24
            r3 = r5
            goto L25
        L24:
            r3 = r6
        L25:
            int r4 = r4 - r3
        L26:
            if (r4 < 0) goto L59
            int r3 = (r15 > r7 ? 1 : (r15 == r7 ? 0 : -1))
            if (r3 != 0) goto L2d
            goto L59
        L2d:
            l8.a r3 = r0.a(r4)
            long r10 = r3.a
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 != 0) goto L52
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r12 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1))
            if (r12 == 0) goto L56
            boolean r12 = r3.k
            if (r12 == 0) goto L4d
            int r10 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r10 != 0) goto L4d
            int r3 = r3.b
            if (r3 != r9) goto L4d
            goto L56
        L4d:
            int r3 = (r15 > r1 ? 1 : (r15 == r1 ? 0 : -1))
            if (r3 >= 0) goto L59
            goto L56
        L52:
            int r3 = (r15 > r10 ? 1 : (r15 == r10 ? 0 : -1))
            if (r3 >= 0) goto L59
        L56:
            int r4 = r4 + (-1)
            goto L26
        L59:
            if (r4 < 0) goto L73
            l8.a r0 = r0.a(r4)
            int r1 = r0.b
            if (r1 != r9) goto L64
            goto L72
        L64:
            if (r6 >= r1) goto L73
            int[] r2 = r0.f278f
            r2 = r2[r6]
            if (r2 == 0) goto L72
            if (r2 != r5) goto L6f
            goto L72
        L6f:
            int r6 = r6 + 1
            goto L64
        L72:
            return r4
        L73:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: l8.h1.c(long):int");
    }

    public final long d(int i2) {
        return this.g.a(i2).a;
    }

    public final int e(int i2, int i3) {
        a aVarA = this.g.a(i2);
        if (aVarA.b != -1) {
            return aVarA.f278f[i3];
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && h1.class.equals(obj.getClass())) {
            h1 h1Var = (h1) obj;
            if (Objects.equals(this.a, h1Var.a) && Objects.equals(this.b, h1Var.b) && this.c == h1Var.c && this.d == h1Var.d && this.e == h1Var.e && this.f295f == h1Var.f295f && Objects.equals(this.g, h1Var.g)) {
                return true;
            }
        }
        return false;
    }

    public final int f(int i2) {
        return this.g.a(i2).a(-1);
    }

    public final boolean g(int i2) {
        b bVar = this.g;
        int i3 = bVar.a;
        if (i2 != i3 - 1 || i2 != i3 - 1) {
            return false;
        }
        a aVarA = bVar.a(i2);
        return aVarA.k && aVarA.a == Long.MIN_VALUE && aVarA.b == -1;
    }

    public final boolean h(int i2) {
        return this.g.a(i2).f279j;
    }

    public final int hashCode() {
        Object obj = this.a;
        int iHashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
        Object obj2 = this.b;
        int iHashCode2 = (((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.c) * 31;
        long j2 = this.d;
        int i2 = (iHashCode2 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.e;
        return this.g.hashCode() + ((((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.f295f ? 1 : 0)) * 31);
    }

    public final void i(Object obj, Object obj2, int i2, long j2, long j3, b bVar, boolean z) {
        this.a = obj;
        this.b = obj2;
        this.c = i2;
        this.d = j2;
        this.e = j3;
        this.g = bVar;
        this.f295f = z;
    }
}
