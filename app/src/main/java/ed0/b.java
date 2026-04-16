package ed0;

import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final ey1.e b = new ey1.e(0.0f, 100.0f);
    public final int a;

    public static final boolean a(int i) {
        return i == 50;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.a == ((b) obj).a;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.a);
    }

    public final String toString() {
        return p.c(this.a, "MasteringIntensity(level=", ")");
    }
}
