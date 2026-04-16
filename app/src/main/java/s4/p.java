package s4;

import q.q2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class p {
    public final float a;
    public final float b;
    public final float c;
    public final float d;

    public p(float f2, float f3, float f4, float f5) {
        this.a = f2;
        this.b = f3;
        this.c = f4;
        this.d = f5;
        if (f2 < 0.0f) {
            p4.a.a("Left must be non-negative");
        }
        if (f3 < 0.0f) {
            p4.a.a("Top must be non-negative");
        }
        if (f4 < 0.0f) {
            p4.a.a("Right must be non-negative");
        }
        if (f5 >= 0.0f) {
            return;
        }
        p4.a.a("Bottom must be non-negative");
    }

    public final long a(p5.c cVar) {
        int i = e2.b;
        return rw1.a.v(cVar.O(this.a), cVar.O(this.b), cVar.O(this.c), cVar.O(this.d));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return p5.f.a(this.a, pVar.a) && p5.f.a(this.b, pVar.b) && p5.f.a(this.c, pVar.c) && p5.f.a(this.d, pVar.d);
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + s1.a.b(this.d, s1.a.b(this.c, s1.a.b(this.b, Float.hashCode(this.a) * 31, 31), 31), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DpTouchBoundsExpansion(start=");
        q2.p(this.a, ", top=", sb);
        q2.p(this.b, ", end=", sb);
        q2.p(this.c, ", bottom=", sb);
        sb.append((Object) p5.f.b(this.d));
        sb.append(", isLayoutDirectionAware=true)");
        return sb.toString();
    }
}
