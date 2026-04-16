package wg0;

import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@wy1.f
public final class c {
    public static final b Companion = new b();
    public final int a;

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.a == ((c) obj).a;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.a);
    }

    public final String toString() {
        return p.c(this.a, "PitchSliderPosition(value=", ")");
    }
}
