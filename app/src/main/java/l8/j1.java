package l8;

import amuvvoafs.net.Uri;
import com.gnacba.common.collect.f1;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import jn1.r;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j1 {
    public static final String A;
    public static final String B;
    public static final String C;
    public static final String D;
    public static final String E;
    public static final String F;
    public static final Object q = new Object();
    public static final Object r = new Object();
    public static final k0 s;
    public static final String t;
    public static final String u;
    public static final String v;
    public static final String w;
    public static final String x;
    public static final String y;
    public static final String z;
    public Object b;
    public Object d;
    public long e;

    /* JADX INFO: renamed from: f */
    public long f296f;
    public long g;
    public boolean h;
    public boolean i;

    /* JADX INFO: renamed from: j */
    public f0 f297j;
    public boolean k;
    public long l;
    public long m;
    public int n;
    public int o;
    public long p;
    public Object a = q;
    public k0 c = s;

    static {
        g0 g0Var;
        a0 a0Var = new a0();
        ec.b bVar = new ec.b();
        List list = Collections.EMPTY_LIST;
        f1 f1Var = f1.e;
        e0 e0Var = new e0();
        h0 h0Var = h0.d;
        Uri uri = Uri.EMPTY;
        o8.b.h(((Uri) bVar.e) == null || ((UUID) bVar.d) != null);
        d0 d0Var = null;
        if (uri != null) {
            if (((UUID) bVar.d) != null) {
                d0Var = new d0(bVar);
            }
            g0Var = new g0(uri, null, d0Var, null, list, null, f1Var, null, -9223372036854775807L);
        } else {
            g0Var = null;
        }
        s = new k0("tlydtdl.media3.common.Timeline", new c0(a0Var), g0Var, new f0(e0Var), n0.K, h0Var);
        t = Integer.toString(1, 36);
        u = Integer.toString(2, 36);
        v = Integer.toString(3, 36);
        w = Integer.toString(4, 36);
        x = Integer.toString(5, 36);
        y = Integer.toString(6, 36);
        z = Integer.toString(7, 36);
        A = Integer.toString(8, 36);
        B = Integer.toString(9, 36);
        C = Integer.toString(10, 36);
        D = Integer.toString(11, 36);
        E = Integer.toString(12, 36);
        F = Integer.toString(13, 36);
    }

    public final boolean a() {
        return this.f297j != null;
    }

    public final void b(Object obj, k0 k0Var, Object obj2, long j2, long j3, long j4, boolean z2, boolean z3, f0 f0Var, long j5, long j6, int i, int i2, long j7) {
        g0 g0Var;
        this.a = obj;
        this.c = k0Var != null ? k0Var : s;
        this.b = (k0Var == null || (g0Var = k0Var.b) == null) ? null : g0Var.h;
        this.d = obj2;
        this.e = j2;
        this.f296f = j3;
        this.g = j4;
        this.h = z2;
        this.i = z3;
        this.f297j = f0Var;
        this.l = j5;
        this.m = j6;
        this.n = i;
        this.o = i2;
        this.p = j7;
        this.k = false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && j1.class.equals(obj.getClass())) {
            j1 j1Var = (j1) obj;
            if (Objects.equals(this.a, j1Var.a) && Objects.equals(this.c, j1Var.c) && Objects.equals(this.d, j1Var.d) && Objects.equals(this.f297j, j1Var.f297j) && this.e == j1Var.e && this.f296f == j1Var.f296f && this.g == j1Var.g && this.h == j1Var.h && this.i == j1Var.i && this.k == j1Var.k && this.l == j1Var.l && this.m == j1Var.m && this.n == j1Var.n && this.o == j1Var.o && this.p == j1Var.p) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.c.hashCode() + r.i(217, 31, this.a)) * 31;
        Object obj = this.d;
        int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        f0 f0Var = this.f297j;
        int iHashCode3 = (iHashCode2 + (f0Var != null ? f0Var.hashCode() : 0)) * 31;
        long j2 = this.e;
        int i = (iHashCode3 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.f296f;
        int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.g;
        int i3 = (((((((i2 + ((int) (j4 ^ (j4 >>> 32)))) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0)) * 31) + (this.k ? 1 : 0)) * 31;
        long j5 = this.l;
        int i4 = (i3 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j6 = this.m;
        int i6 = (((((i4 + ((int) (j6 ^ (j6 >>> 32)))) * 31) + this.n) * 31) + this.o) * 31;
        long j7 = this.p;
        return i6 + ((int) (j7 ^ (j7 >>> 32)));
    }
}
