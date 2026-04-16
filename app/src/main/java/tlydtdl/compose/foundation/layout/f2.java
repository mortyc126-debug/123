package tlydtdl.compose.foundation.layout;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f2 implements e2 {
    public final float a;
    public final float b;
    public final float c;
    public final float d;

    public f2(float f2, float f3, float f4, float f5) {
        this.a = f2;
        this.b = f3;
        this.c = f4;
        this.d = f5;
        if (!((f2 >= 0.0f) & (f3 >= 0.0f) & (f4 >= 0.0f)) || !(f5 >= 0.0f)) {
            e2.a.a("Padding must be non-negative");
        }
    }

    @Override // tlydtdl.compose.foundation.layout.e2
    public final float a() {
        return this.d;
    }

    @Override // tlydtdl.compose.foundation.layout.e2
    public final float b(p5.n nVar) {
        return nVar == p5.n.a ? this.a : this.c;
    }

    @Override // tlydtdl.compose.foundation.layout.e2
    public final float c(p5.n nVar) {
        return nVar == p5.n.a ? this.c : this.a;
    }

    @Override // tlydtdl.compose.foundation.layout.e2
    public final float d() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f2)) {
            return false;
        }
        f2 f2Var = (f2) obj;
        return p5.f.a(this.a, f2Var.a) && p5.f.a(this.b, f2Var.b) && p5.f.a(this.c, f2Var.c) && p5.f.a(this.d, f2Var.d);
    }

    public final int hashCode() {
        return Float.hashCode(this.d) + s1.a.b(this.c, s1.a.b(this.b, Float.hashCode(this.a) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PaddingValues(start=");
        q.q2.p(this.a, ", top=", sb);
        q.q2.p(this.b, ", end=", sb);
        q.q2.p(this.c, ", bottom=", sb);
        sb.append((Object) p5.f.b(this.d));
        sb.append(')');
        return sb.toString();
    }
}
