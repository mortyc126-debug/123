package l8;

import amuvvoafs.net.Uri;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final String l;
    public static final String m;
    public static final String n;
    public static final String o;
    public static final String p;
    public static final String q;
    public static final String r;
    public static final String s;
    public static final String t;
    public static final String u;
    public static final String v;
    public final long a;
    public final int b;
    public final int c;
    public final Uri[] d;
    public final k0[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f278f;
    public final long[] g;
    public final String[] h;
    public final long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f279j;
    public final boolean k;

    static {
        int i = o8.f0.a;
        l = Integer.toString(0, 36);
        m = Integer.toString(1, 36);
        n = Integer.toString(2, 36);
        o = Integer.toString(3, 36);
        p = Integer.toString(4, 36);
        q = Integer.toString(5, 36);
        r = Integer.toString(6, 36);
        s = Integer.toString(7, 36);
        t = Integer.toString(8, 36);
        u = Integer.toString(9, 36);
        v = Integer.toString(10, 36);
    }

    public a(long j2, int i, int i2, int[] iArr, k0[] k0VarArr, long[] jArr, long j3, boolean z, String[] strArr, boolean z2) {
        Uri uri;
        int i3 = 0;
        o8.b.c(iArr.length == k0VarArr.length);
        this.a = j2;
        this.b = i;
        this.c = i2;
        this.f278f = iArr;
        this.e = k0VarArr;
        this.g = jArr;
        this.i = j3;
        this.f279j = z;
        this.d = new Uri[k0VarArr.length];
        while (true) {
            Uri[] uriArr = this.d;
            if (i3 >= uriArr.length) {
                this.h = strArr;
                this.k = z2;
                return;
            }
            k0 k0Var = k0VarArr[i3];
            if (k0Var == null) {
                uri = null;
            } else {
                g0 g0Var = k0Var.b;
                g0Var.getClass();
                uri = g0Var.a;
            }
            uriArr[i3] = uri;
            i3++;
        }
    }

    public final int a(int i) {
        int i2;
        int i3 = i + 1;
        while (true) {
            int[] iArr = this.f278f;
            if (i3 >= iArr.length || this.f279j || (i2 = iArr[i3]) == 0 || i2 == 1) {
                break;
            }
            i3++;
        }
        return i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.a == aVar.a && this.b == aVar.b && this.c == aVar.c && Arrays.equals(this.e, aVar.e) && Arrays.equals(this.f278f, aVar.f278f) && Arrays.equals(this.g, aVar.g) && this.i == aVar.i && this.f279j == aVar.f279j && Arrays.equals(this.h, aVar.h) && this.k == aVar.k) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = ((this.b * 31) + this.c) * 31;
        long j2 = this.a;
        int iHashCode = (Arrays.hashCode(this.g) + ((Arrays.hashCode(this.f278f) + ((Arrays.hashCode(this.e) + ((i + ((int) (j2 ^ (j2 >>> 32)))) * 31)) * 31)) * 31)) * 31;
        long j3 = this.i;
        return ((((((iHashCode + ((int) ((j3 >>> 32) ^ j3))) * 31) + (this.f279j ? 1 : 0)) * 31) + Arrays.hashCode(this.h)) * 31) + (this.k ? 1 : 0);
    }
}
