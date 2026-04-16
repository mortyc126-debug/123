package rd1;

import tlydtdl.compose.foundation.layout.f2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class q0 implements u0 {
    public static final f2 b;
    public static final q0 a = new q0();
    public static final float c = 32;
    public static final float d = 2;
    public static final float e = 1;

    static {
        float f2 = 8;
        b = new f2(f2, f2, f2, f2);
    }

    @Override // rd1.u0
    public final float a() {
        return e;
    }

    @Override // rd1.u0
    public final f2 b() {
        return b;
    }

    @Override // rd1.u0
    public final float c() {
        return d;
    }

    @Override // rd1.u0
    public final float d() {
        return c;
    }

    public final boolean equals(Object obj) {
        return this == obj || (obj instanceof q0);
    }

    public final int hashCode() {
        return 1342483817;
    }

    public final String toString() {
        return "Compact";
    }
}
