package cs0;

import hg1.b;
import o6.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements h {
    public final float a;
    public final boolean b;

    public g(float f2, boolean z) {
        this.a = f2;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return b.a(this.a, gVar.a) && this.b == gVar.b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (Float.hashCode(this.a) * 31);
    }

    public final String toString() {
        return c.n("Valid(bpm=", b.b(this.a), ", isEnabled=", ")", this.b);
    }
}
