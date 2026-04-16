package n7;

import okhttp3.HttpUrl;
import tlydtdl.datastore.preferences.protobuf.p0;
import tlydtdl.datastore.preferences.protobuf.t0;
import tlydtdl.datastore.preferences.protobuf.u;
import tlydtdl.datastore.preferences.protobuf.v;
import tlydtdl.datastore.preferences.protobuf.w;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends w {
    public static final int BOOLEAN_FIELD_NUMBER = 1;
    public static final int BYTES_FIELD_NUMBER = 8;
    private static final h DEFAULT_INSTANCE;
    public static final int DOUBLE_FIELD_NUMBER = 7;
    public static final int FLOAT_FIELD_NUMBER = 2;
    public static final int INTEGER_FIELD_NUMBER = 3;
    public static final int LONG_FIELD_NUMBER = 4;
    private static volatile p0 PARSER = null;
    public static final int STRING_FIELD_NUMBER = 5;
    public static final int STRING_SET_FIELD_NUMBER = 6;
    private int valueCase_ = 0;
    private Object value_;

    static {
        h hVar = new h();
        DEFAULT_INSTANCE = hVar;
        w.j(h.class, hVar);
    }

    public static g D() {
        return (g) ((u) DEFAULT_INSTANCE.c(5));
    }

    public static void l(h hVar, long j2) {
        hVar.valueCase_ = 4;
        hVar.value_ = Long.valueOf(j2);
    }

    public static void m(h hVar, String str) {
        hVar.getClass();
        hVar.valueCase_ = 5;
        hVar.value_ = str;
    }

    public static void n(h hVar, f fVar) {
        hVar.getClass();
        hVar.value_ = fVar;
        hVar.valueCase_ = 6;
    }

    public static void o(h hVar, double d) {
        hVar.valueCase_ = 7;
        hVar.value_ = Double.valueOf(d);
    }

    public static void p(h hVar, tlydtdl.datastore.preferences.protobuf.g gVar) {
        hVar.getClass();
        hVar.valueCase_ = 8;
        hVar.value_ = gVar;
    }

    public static void q(h hVar, boolean z) {
        hVar.valueCase_ = 1;
        hVar.value_ = Boolean.valueOf(z);
    }

    public static void r(h hVar, float f2) {
        hVar.valueCase_ = 2;
        hVar.value_ = Float.valueOf(f2);
    }

    public static void s(h hVar, int i) {
        hVar.valueCase_ = 3;
        hVar.value_ = Integer.valueOf(i);
    }

    public static h v() {
        return DEFAULT_INSTANCE;
    }

    public final String A() {
        return this.valueCase_ == 5 ? (String) this.value_ : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public final f B() {
        return this.valueCase_ == 6 ? (f) this.value_ : f.m();
    }

    public final int C() {
        switch (this.valueCase_) {
            case 0:
                return 9;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            default:
                return 0;
        }
    }

    @Override // tlydtdl.datastore.preferences.protobuf.w
    public final Object c(int i) {
        p0 vVar;
        switch (p.k(i)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new t0(DEFAULT_INSTANCE, "\u0001\b\u0001\u0000\u0001\b\b\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000\b=\u0000", new Object[]{"value_", "valueCase_", f.class});
            case 3:
                return new h();
            case 4:
                return new g(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p0 p0Var = PARSER;
                if (p0Var != null) {
                    return p0Var;
                }
                synchronized (h.class) {
                    try {
                        vVar = PARSER;
                        if (vVar == null) {
                            vVar = new v();
                            PARSER = vVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return vVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final boolean t() {
        if (this.valueCase_ == 1) {
            return ((Boolean) this.value_).booleanValue();
        }
        return false;
    }

    public final tlydtdl.datastore.preferences.protobuf.g u() {
        return this.valueCase_ == 8 ? (tlydtdl.datastore.preferences.protobuf.g) this.value_ : tlydtdl.datastore.preferences.protobuf.g.c;
    }

    public final double w() {
        if (this.valueCase_ == 7) {
            return ((Double) this.value_).doubleValue();
        }
        return 0.0d;
    }

    public final float x() {
        if (this.valueCase_ == 2) {
            return ((Float) this.value_).floatValue();
        }
        return 0.0f;
    }

    public final int y() {
        if (this.valueCase_ == 3) {
            return ((Integer) this.value_).intValue();
        }
        return 0;
    }

    public final long z() {
        if (this.valueCase_ == 4) {
            return ((Long) this.value_).longValue();
        }
        return 0L;
    }
}
