package l8;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class t0 {
    public static final t0 d = new t0(1.0f);
    public static final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f311f;
    public final float a;
    public final float b;
    public final int c;

    static {
        int i = o8.f0.a;
        e = Integer.toString(0, 36);
        f311f = Integer.toString(1, 36);
    }

    public t0(float f2) {
        this(f2, 1.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && t0.class == obj.getClass()) {
            t0 t0Var = (t0) obj;
            if (this.a == t0Var.a && this.b == t0Var.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(this.b) + ((Float.floatToRawIntBits(this.a) + 527) * 31);
    }

    public final String toString() {
        Object[] objArr = {Float.valueOf(this.a), Float.valueOf(this.b)};
        int i = o8.f0.a;
        return String.format(Locale.US, "PlaybackParameters(speed=%.2f, pitch=%.2f)", objArr);
    }

    public t0(float f2, float f3) {
        o8.b.c(f2 > 0.0f);
        o8.b.c(f3 > 0.0f);
        this.a = f2;
        this.b = f3;
        this.c = Math.round(f2 * 1000.0f);
    }
}
