package tlydtdl.compose.foundation.layout;

import t3.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 implements a0, w {
    public final p5.c a;
    public final long b;

    public b0(q4.d2 d2Var, long j2) {
        this.a = d2Var;
        this.b = j2;
    }

    @Override // tlydtdl.compose.foundation.layout.w
    public final t3.p a(t3.p pVar) {
        return new BoxChildDataElement(t3.c.e, true);
    }

    @Override // tlydtdl.compose.foundation.layout.w
    public final t3.p b(t3.p pVar, d dVar) {
        return pVar.then(new BoxChildDataElement(dVar, false));
    }

    public final float c() {
        long j2 = this.b;
        if (!p5.a.c(j2)) {
            return Float.POSITIVE_INFINITY;
        }
        return this.a.p0(p5.a.g(j2));
    }

    public final float d() {
        long j2 = this.b;
        if (!p5.a.d(j2)) {
            return Float.POSITIVE_INFINITY;
        }
        return this.a.p0(p5.a.h(j2));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, b0Var.a) && p5.a.b(this.b, b0Var.b);
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "BoxWithConstraintsScopeImpl(density=" + this.a + ", constraints=" + ((Object) p5.a.l(this.b)) + ')';
    }
}
