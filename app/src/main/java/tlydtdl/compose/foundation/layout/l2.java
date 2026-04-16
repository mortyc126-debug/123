package tlydtdl.compose.foundation.layout;

import java.util.List;
import q4.u0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l2 implements u0, h2 {
    public final h a;
    public final t3.g b;

    public l2(h hVar, t3.g gVar) {
        this.a = hVar;
        this.b = gVar;
    }

    public final int a(q4.w wVar, List list, int i) {
        return d.c(list, i, wVar.O(this.a.c()));
    }

    public final int b(q4.w wVar, List list, int i) {
        return d.a(list, i, wVar.O(this.a.c()));
    }

    public final int c(q4.w wVar, List list, int i) {
        return d.b(list, i, wVar.O(this.a.c()));
    }

    public final q4.v0 d(q4.w0 w0Var, List list, long j2) {
        return m.w(this, p5.a.j(j2), p5.a.i(j2), p5.a.h(j2), p5.a.g(j2), w0Var.O(this.a.c()), w0Var, list, new q4.m1[list.size()], 0, list.size(), null, 0);
    }

    public final int e(q4.w wVar, List list, int i) {
        return d.d(list, i, wVar.O(this.a.c()));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l2)) {
            return false;
        }
        l2 l2Var = (l2) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, l2Var.a) && lmjxuqdtp.jvm.internal.o.c(this.b, l2Var.b);
    }

    @Override // tlydtdl.compose.foundation.layout.h2
    public final void f(int i, int[] iArr, int[] iArr2, q4.w0 w0Var) {
        this.a.k(w0Var, i, iArr, w0Var.getLayoutDirection(), iArr2);
    }

    @Override // tlydtdl.compose.foundation.layout.h2
    public final int g(q4.m1 m1Var) {
        return m1Var.b;
    }

    @Override // tlydtdl.compose.foundation.layout.h2
    public final long h(int i, int i2, int i3, boolean z) {
        return !z ? p5.b.a(i, i2, 0, i3) : di0.z.r(i, i2, 0, i3);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    @Override // tlydtdl.compose.foundation.layout.h2
    public final q4.v0 i(q4.m1[] m1VarArr, q4.w0 w0Var, int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i6) {
        return w0Var.g0(i, i2, mx1.u.a, new k2(m1VarArr, this, i2, iArr));
    }

    @Override // tlydtdl.compose.foundation.layout.h2
    public final int j(q4.m1 m1Var) {
        return m1Var.a;
    }

    public final String toString() {
        return "RowMeasurePolicy(horizontalArrangement=" + this.a + ", verticalAlignment=" + this.b + ')';
    }
}
