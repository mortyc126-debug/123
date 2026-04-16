package hj;

import cg1.b;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d3 implements b {
    public final float a;
    public final float b;

    public d3(float f2, float f3) {
        this.a = f2;
        this.b = f3;
    }

    @Override // cg1.b
    public final hg1.n a() {
        return new hg1.n(this.a);
    }

    @Override // cg1.b
    public final hg1.n b() {
        return new hg1.n(this.b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d3)) {
            return false;
        }
        d3 d3Var = (d3) obj;
        return hg1.n.b(this.a, d3Var.a) && hg1.n.b(this.b, d3Var.b);
    }

    public final int hashCode() {
        return Float.hashCode(this.b) + (Float.hashCode(this.a) * 31);
    }

    public final String toString() {
        return z.p.f("VerticalPosition(top=", hg1.n.c(this.a), ", bottom=", hg1.n.c(this.b), ")");
    }
}
