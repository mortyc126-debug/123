package d5;

import f3.f2;
import uc0.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class p0 {
    public static final long b = p.h(0, 0);
    public static final /* synthetic */ int c = 0;
    public final long a;

    public static final boolean a(long j2, long j3) {
        return (g(j2) <= g(j3)) & (f(j3) <= f(j2));
    }

    public static boolean b(Object obj, long j2) {
        return (obj instanceof p0) && j2 == ((p0) obj).a;
    }

    public static final boolean c(long j2, long j3) {
        return j2 == j3;
    }

    public static final boolean d(long j2) {
        return ((int) (j2 >> 32)) == ((int) (j2 & 4294967295L));
    }

    public static final int e(long j2) {
        return f(j2) - g(j2);
    }

    public static final int f(long j2) {
        return Math.max((int) (j2 >> 32), (int) (j2 & 4294967295L));
    }

    public static final int g(long j2) {
        return Math.min((int) (j2 >> 32), (int) (j2 & 4294967295L));
    }

    public static final boolean h(long j2) {
        return ((int) (j2 >> 32)) > ((int) (j2 & 4294967295L));
    }

    public static String i(long j2) {
        StringBuilder sb = new StringBuilder("TextRange(");
        sb.append((int) (j2 >> 32));
        sb.append(", ");
        return f2.l(sb, (int) (j2 & 4294967295L), ')');
    }

    public final boolean equals(Object obj) {
        return b(obj, this.a);
    }

    public final int hashCode() {
        return Long.hashCode(this.a);
    }

    public final String toString() {
        return i(this.a);
    }
}
