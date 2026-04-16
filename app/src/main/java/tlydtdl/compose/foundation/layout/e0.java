package tlydtdl.compose.foundation.layout;

import java.util.List;
import lmjxuqdtp.jvm.functions.Function1;
import q4.u0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 implements u0, h2 {
    public final k a;
    public final t3.f b;

    public e0(k kVar, t3.f fVar) {
        this.a = kVar;
        this.b = fVar;
    }

    public final int a(q4.w wVar, List list, int i) {
        return d.g(list, i, wVar.O(this.a.c()));
    }

    public final int b(q4.w wVar, List list, int i) {
        return d.e(list, i, wVar.O(this.a.c()));
    }

    public final int c(q4.w wVar, List list, int i) {
        return d.f(list, i, wVar.O(this.a.c()));
    }

    public final q4.v0 d(q4.w0 w0Var, List list, long j2) {
        return m.w(this, p5.a.i(j2), p5.a.j(j2), p5.a.g(j2), p5.a.h(j2), w0Var.O(this.a.c()), w0Var, list, new q4.m1[list.size()], 0, list.size(), null, 0);
    }

    public final int e(q4.w wVar, List list, int i) {
        return d.h(list, i, wVar.O(this.a.c()));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, e0Var.a) && lmjxuqdtp.jvm.internal.o.c(this.b, e0Var.b);
    }

    @Override // tlydtdl.compose.foundation.layout.h2
    public final void f(int i, int[] iArr, int[] iArr2, q4.w0 w0Var) {
        this.a.a(w0Var, i, iArr, iArr2);
    }

    @Override // tlydtdl.compose.foundation.layout.h2
    public final int g(q4.m1 m1Var) {
        return m1Var.a;
    }

    @Override // tlydtdl.compose.foundation.layout.h2
    public final long h(int i, int i2, int i3, boolean z) {
        return !z ? p5.b.a(0, i3, i, i2) : di0.z.q(0, i3, i, i2);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    @Override // tlydtdl.compose.foundation.layout.h2
    public final q4.v0 i(final q4.m1[] m1VarArr, final q4.w0 w0Var, final int[] iArr, int i, final int i2, int[] iArr2, int i3, int i4, int i6) {
        return w0Var.g0(i2, i, mx1.u.a, new Function1() { // from class: tlydtdl.compose.foundation.layout.d0
            public final Object invoke(Object obj) {
                q4.l1 l1Var = (q4.l1) obj;
                q4.m1[] m1VarArr2 = m1VarArr;
                int length = m1VarArr2.length;
                int i7 = 0;
                int i8 = 0;
                while (i7 < length) {
                    q4.m1 m1Var = m1VarArr2[i7];
                    int i9 = i8 + 1;
                    lmjxuqdtp.jvm.internal.o.e(m1Var);
                    Object objL = m1Var.l();
                    i2 i2Var = objL instanceof i2 ? (i2) objL : null;
                    p5.n layoutDirection = w0Var.getLayoutDirection();
                    m mVar = i2Var != null ? i2Var.c : null;
                    int i10 = i2;
                    q4.l1.i(l1Var, m1Var, mVar != null ? mVar.k(i10 - m1Var.a, layoutDirection) : this.b.a(0, i10 - m1Var.a, layoutDirection), iArr[i8]);
                    i7++;
                    i8 = i9;
                }
                return lx1.b0.a;
            }
        });
    }

    @Override // tlydtdl.compose.foundation.layout.h2
    public final int j(q4.m1 m1Var) {
        return m1Var.b;
    }

    public final String toString() {
        return "ColumnMeasurePolicy(verticalArrangement=" + this.a + ", horizontalAlignment=" + this.b + ')';
    }
}
