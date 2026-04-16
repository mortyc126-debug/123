package tlydtdl.compose.foundation.layout;

import java.util.List;
import lmjxuqdtp.jvm.functions.Function1;
import q4.u0;
import t3.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class v implements u0 {
    public final d a;
    public final boolean b;

    public v(d dVar, boolean z) {
        this.a = dVar;
        this.b = z;
    }

    public final q4.v0 d(final q4.w0 w0Var, List list, long j2) {
        int iJ;
        int i;
        q4.m1 m1VarT;
        boolean zIsEmpty = list.isEmpty();
        mx1.u uVar = mx1.u.a;
        if (zIsEmpty) {
            return w0Var.g0(p5.a.j(j2), p5.a.i(j2), uVar, new uc0.a(19));
        }
        long j3 = this.b ? j2 : j2 & (-8589934589L);
        if (list.size() == 1) {
            final q4.t0 t0Var = (q4.t0) list.get(0);
            Object objL = t0Var.l();
            p pVar = objL instanceof p ? (p) objL : null;
            if (pVar != null ? pVar.b : false) {
                iJ = p5.a.j(j2);
                i = p5.a.i(j2);
                int iJ2 = p5.a.j(j2);
                int i2 = p5.a.i(j2);
                if (!((i2 >= 0) & (iJ2 >= 0))) {
                    p5.j.a("width and height must be >= 0");
                }
                m1VarT = t0Var.T(p5.b.h(iJ2, iJ2, i2, i2));
            } else {
                m1VarT = t0Var.T(j3);
                iJ = Math.max(p5.a.j(j2), m1VarT.a);
                i = Math.max(p5.a.i(j2), m1VarT.b);
            }
            final int i3 = i;
            final int i4 = iJ;
            final q4.m1 m1Var = m1VarT;
            return w0Var.g0(i4, i3, uVar, new Function1() { // from class: tlydtdl.compose.foundation.layout.t
                public final Object invoke(Object obj) {
                    s.b((q4.l1) obj, m1Var, t0Var, w0Var.getLayoutDirection(), i4, i3, this.a);
                    return lx1.b0.a;
                }
            });
        }
        q4.m1[] m1VarArr = new q4.m1[list.size()];
        lmjxuqdtp.jvm.internal.a0 a0Var = new lmjxuqdtp.jvm.internal.a0();
        a0Var.a = p5.a.j(j2);
        lmjxuqdtp.jvm.internal.a0 a0Var2 = new lmjxuqdtp.jvm.internal.a0();
        a0Var2.a = p5.a.i(j2);
        int size = list.size();
        boolean z = false;
        for (int i6 = 0; i6 < size; i6++) {
            q4.t0 t0Var2 = (q4.t0) list.get(i6);
            Object objL2 = t0Var2.l();
            p pVar2 = objL2 instanceof p ? (p) objL2 : null;
            if (pVar2 != null ? pVar2.b : false) {
                z = true;
            } else {
                q4.m1 m1VarT2 = t0Var2.T(j3);
                m1VarArr[i6] = m1VarT2;
                a0Var.a = Math.max(a0Var.a, m1VarT2.a);
                a0Var2.a = Math.max(a0Var2.a, m1VarT2.b);
            }
        }
        if (z) {
            int i7 = a0Var.a;
            int i8 = i7 != Integer.MAX_VALUE ? i7 : 0;
            int i9 = a0Var2.a;
            long jA = p5.b.a(i8, i7, i9 != Integer.MAX_VALUE ? i9 : 0, i9);
            int size2 = list.size();
            for (int i10 = 0; i10 < size2; i10++) {
                q4.t0 t0Var3 = (q4.t0) list.get(i10);
                Object objL3 = t0Var3.l();
                p pVar3 = objL3 instanceof p ? (p) objL3 : null;
                if (pVar3 != null ? pVar3.b : false) {
                    m1VarArr[i10] = t0Var3.T(jA);
                }
            }
        }
        return w0Var.g0(a0Var.a, a0Var2.a, uVar, new u(m1VarArr, list, w0Var, a0Var, a0Var2, this, 0));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, vVar.a) && this.b == vVar.b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BoxMeasurePolicy(alignment=");
        sb.append(this.a);
        sb.append(", propagateMinConstraints=");
        return f3.f2.n(sb, this.b, ')');
    }
}
