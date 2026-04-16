package l8;

import amuvvoafs.util.Pair;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k1 {
    public static final g1 a = new g1();
    public static final String b;
    public static final String c;
    public static final String d;

    static {
        int i = o8.f0.a;
        b = Integer.toString(0, 36);
        c = Integer.toString(1, 36);
        d = Integer.toString(2, 36);
    }

    public int a(boolean z) {
        return p() ? -1 : 0;
    }

    public abstract int b(Object obj);

    public int c(boolean z) {
        if (p()) {
            return -1;
        }
        return o() - 1;
    }

    public final int d(int i, h1 h1Var, j1 j1Var, int i2, boolean z) {
        int i3 = f(i, h1Var, false).c;
        if (m(i3, j1Var, 0L).o != i) {
            return i + 1;
        }
        int iE = e(i3, i2, z);
        if (iE == -1) {
            return -1;
        }
        return m(iE, j1Var, 0L).n;
    }

    public int e(int i, int i2, boolean z) {
        if (i2 == 0) {
            if (i == c(z)) {
                return -1;
            }
            return i + 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == c(z) ? a(z) : i + 1;
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        int iC;
        if (this != obj) {
            if (obj instanceof k1) {
                k1 k1Var = (k1) obj;
                if (k1Var.o() == o() && k1Var.h() == h()) {
                    j1 j1Var = new j1();
                    h1 h1Var = new h1();
                    j1 j1Var2 = new j1();
                    h1 h1Var2 = new h1();
                    int i = 0;
                    while (true) {
                        if (i >= o()) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= h()) {
                                    int iA = a(true);
                                    if (iA == k1Var.a(true) && (iC = c(true)) == k1Var.c(true)) {
                                        while (iA != iC) {
                                            int iE = e(iA, 0, true);
                                            if (iE == k1Var.e(iA, 0, true)) {
                                                iA = iE;
                                            }
                                        }
                                    }
                                } else {
                                    if (!f(i2, h1Var, true).equals(k1Var.f(i2, h1Var2, true))) {
                                        break;
                                    }
                                    i2++;
                                }
                            }
                        } else {
                            if (!m(i, j1Var, 0L).equals(k1Var.m(i, j1Var2, 0L))) {
                                break;
                            }
                            i++;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public abstract h1 f(int i, h1 h1Var, boolean z);

    public h1 g(Object obj, h1 h1Var) {
        return f(b(obj), h1Var, true);
    }

    public abstract int h();

    public int hashCode() {
        j1 j1Var = new j1();
        h1 h1Var = new h1();
        int iO = o() + 217;
        for (int i = 0; i < o(); i++) {
            iO = (iO * 31) + m(i, j1Var, 0L).hashCode();
        }
        int iH = h() + (iO * 31);
        for (int i2 = 0; i2 < h(); i2++) {
            iH = (iH * 31) + f(i2, h1Var, true).hashCode();
        }
        int iA = a(true);
        while (iA != -1) {
            iH = (iH * 31) + iA;
            iA = e(iA, 0, true);
        }
        return iH;
    }

    public final Pair i(j1 j1Var, h1 h1Var, int i, long j2) {
        Pair pairJ = j(j1Var, h1Var, i, j2, 0L);
        pairJ.getClass();
        return pairJ;
    }

    public final Pair j(j1 j1Var, h1 h1Var, int i, long j2, long j3) {
        o8.b.d(i, o());
        m(i, j1Var, j3);
        if (j2 == -9223372036854775807L) {
            j2 = j1Var.l;
            if (j2 == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = j1Var.n;
        f(i2, h1Var, false);
        while (i2 < j1Var.o && h1Var.e != j2) {
            int i3 = i2 + 1;
            if (f(i3, h1Var, false).e > j2) {
                break;
            }
            i2 = i3;
        }
        f(i2, h1Var, true);
        long jMin = j2 - h1Var.e;
        long j4 = h1Var.d;
        if (j4 != -9223372036854775807L) {
            jMin = Math.min(jMin, j4 - 1);
        }
        long jMax = Math.max(0L, jMin);
        Object obj = h1Var.b;
        obj.getClass();
        return Pair.create(obj, Long.valueOf(jMax));
    }

    public int k(int i, int i2, boolean z) {
        if (i2 == 0) {
            if (i == a(z)) {
                return -1;
            }
            return i - 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == a(z) ? c(z) : i - 1;
        }
        throw new IllegalStateException();
    }

    public abstract Object l(int i);

    public abstract j1 m(int i, j1 j1Var, long j2);

    public final void n(int i, j1 j1Var) {
        m(i, j1Var, 0L);
    }

    public abstract int o();

    public final boolean p() {
        return o() == 0;
    }
}
