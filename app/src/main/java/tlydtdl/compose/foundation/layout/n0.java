package tlydtdl.compose.foundation.layout;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class n0 implements v2 {
    public final float a;
    public final float b;
    public final float c;
    public final float d;

    public n0(float f2, float f3, float f4, float f5) {
        this.a = f2;
        this.b = f3;
        this.c = f4;
        this.d = f5;
    }

    @Override // tlydtdl.compose.foundation.layout.v2
    public final int a(p5.c cVar) {
        return cVar.O(this.d);
    }

    @Override // tlydtdl.compose.foundation.layout.v2
    public final int b(p5.c cVar, p5.n nVar) {
        return cVar.O(this.a);
    }

    @Override // tlydtdl.compose.foundation.layout.v2
    public final int c(p5.c cVar, p5.n nVar) {
        return cVar.O(this.c);
    }

    @Override // tlydtdl.compose.foundation.layout.v2
    public final int d(p5.c cVar) {
        return cVar.O(this.b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n0)) {
            return false;
        }
        n0 n0Var = (n0) obj;
        return p5.f.a(this.a, n0Var.a) && p5.f.a(this.b, n0Var.b) && p5.f.a(this.c, n0Var.c) && p5.f.a(this.d, n0Var.d);
    }

    public final int hashCode() {
        return Float.hashCode(this.d) + s1.a.b(this.c, s1.a.b(this.b, Float.hashCode(this.a) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Insets(left=");
        q.q2.p(this.a, ", top=", sb);
        q.q2.p(this.b, ", right=", sb);
        q.q2.p(this.c, ", bottom=", sb);
        sb.append((Object) p5.f.b(this.d));
        sb.append(')');
        return sb.toString();
    }
}
