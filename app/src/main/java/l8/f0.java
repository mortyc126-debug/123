package l8;

import amuvvoafs.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f0 f289f = new f0(new e0());
    public static final String g;
    public static final String h;
    public static final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f290j;
    public static final String k;
    public final long a;
    public final long b;
    public final long c;
    public final float d;
    public final float e;

    static {
        int i2 = o8.f0.a;
        g = Integer.toString(0, 36);
        h = Integer.toString(1, 36);
        i = Integer.toString(2, 36);
        f290j = Integer.toString(3, 36);
        k = Integer.toString(4, 36);
    }

    public f0(e0 e0Var) {
        long j2 = e0Var.a;
        long j3 = e0Var.b;
        long j4 = e0Var.c;
        float f2 = e0Var.d;
        float f3 = e0Var.e;
        this.a = j2;
        this.b = j3;
        this.c = j4;
        this.d = f2;
        this.e = f3;
    }

    public static f0 b(Bundle bundle) {
        e0 e0Var = new e0();
        f0 f0Var = f289f;
        e0Var.a = bundle.getLong(g, f0Var.a);
        e0Var.b = bundle.getLong(h, f0Var.b);
        e0Var.c = bundle.getLong(i, f0Var.c);
        e0Var.d = bundle.getFloat(f290j, f0Var.d);
        e0Var.e = bundle.getFloat(k, f0Var.e);
        return new f0(e0Var);
    }

    public final e0 a() {
        e0 e0Var = new e0();
        e0Var.a = this.a;
        e0Var.b = this.b;
        e0Var.c = this.c;
        e0Var.d = this.d;
        e0Var.e = this.e;
        return e0Var;
    }

    public final Bundle c() {
        Bundle bundle = new Bundle();
        f0 f0Var = f289f;
        long j2 = f0Var.a;
        long j3 = this.a;
        if (j3 != j2) {
            bundle.putLong(g, j3);
        }
        long j4 = f0Var.b;
        long j5 = this.b;
        if (j5 != j4) {
            bundle.putLong(h, j5);
        }
        long j6 = f0Var.c;
        long j7 = this.c;
        if (j7 != j6) {
            bundle.putLong(i, j7);
        }
        float f2 = f0Var.d;
        float f3 = this.d;
        if (f3 != f2) {
            bundle.putFloat(f290j, f3);
        }
        float f4 = f0Var.e;
        float f5 = this.e;
        if (f5 != f4) {
            bundle.putFloat(k, f5);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return this.a == f0Var.a && this.b == f0Var.b && this.c == f0Var.c && this.d == f0Var.d && this.e == f0Var.e;
    }

    public final int hashCode() {
        long j2 = this.a;
        long j3 = this.b;
        int i2 = ((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.c;
        int i3 = (i2 + ((int) ((j4 >>> 32) ^ j4))) * 31;
        float f2 = this.d;
        int iFloatToIntBits = (i3 + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31;
        float f3 = this.e;
        return iFloatToIntBits + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0);
    }
}
