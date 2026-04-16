package tlydtdl.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f1 extends h1 {
    @Override // tlydtdl.datastore.preferences.protobuf.h1
    public final boolean c(Object obj, long j2) {
        return i1.g ? i1.b(obj, j2) : i1.c(obj, j2);
    }

    @Override // tlydtdl.datastore.preferences.protobuf.h1
    public final double d(Object obj, long j2) {
        return Double.longBitsToDouble(g(obj, j2));
    }

    @Override // tlydtdl.datastore.preferences.protobuf.h1
    public final float e(Object obj, long j2) {
        return Float.intBitsToFloat(f(obj, j2));
    }

    @Override // tlydtdl.datastore.preferences.protobuf.h1
    public final void j(Object obj, long j2, boolean z) {
        if (i1.g) {
            i1.k(obj, j2, z ? (byte) 1 : (byte) 0);
        } else {
            i1.l(obj, j2, z ? (byte) 1 : (byte) 0);
        }
    }

    @Override // tlydtdl.datastore.preferences.protobuf.h1
    public final void k(Object obj, long j2, byte b) {
        if (i1.g) {
            i1.k(obj, j2, b);
        } else {
            i1.l(obj, j2, b);
        }
    }

    @Override // tlydtdl.datastore.preferences.protobuf.h1
    public final void l(Object obj, long j2, double d) {
        o(obj, j2, Double.doubleToLongBits(d));
    }

    @Override // tlydtdl.datastore.preferences.protobuf.h1
    public final void m(Object obj, long j2, float f2) {
        n(j2, obj, Float.floatToIntBits(f2));
    }

    @Override // tlydtdl.datastore.preferences.protobuf.h1
    public final boolean r() {
        return false;
    }
}
