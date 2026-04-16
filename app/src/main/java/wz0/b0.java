package wz0;

import com.google.android.material.R;
import dg1.g;
import lmjxuqdtp.jvm.functions.Function0;
import q.q2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 {
    public final x10.v a;
    public final boolean b;
    public final g c;
    public final ld1.q d;
    public final Function0 e;

    public b0(x10.v vVar, boolean z, g gVar, ld1.q qVar, Function0 function0) {
        this.a = vVar;
        this.b = z;
        this.c = gVar;
        this.d = qVar;
        this.e = function0;
    }

    public final me1.d a() {
        boolean z = this.b;
        return new me1.d(this.a, z ? i.u(ld1.r.Companion, 2131100957) : this.d, this.c, (g) null, z ? i.u(ld1.r.Companion, 2131100957) : i.u(ld1.r.Companion, R.dimen.m3_comp_fab_primary_pressed_container_elevation), (ld1.q) null, (of1.n) null, false, false, (String) null, this.e, 4072);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, b0Var.a) && this.b == b0Var.b && lmjxuqdtp.jvm.internal.o.c(this.c, b0Var.c) && lmjxuqdtp.jvm.internal.o.c(this.d, b0Var.d) && lmjxuqdtp.jvm.internal.o.c(this.e, b0Var.e);
    }

    public final int hashCode() {
        return this.e.hashCode() + s1.a.c(this.d.a, q2.e(this.c, s1.a.f(this.a.hashCode() * 31, 31, this.b), 31), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MenuItemState(text=");
        sb.append(this.a);
        sb.append(", isHighlighted=");
        sb.append(this.b);
        sb.append(", leadingIcon=");
        sb.append(this.c);
        sb.append(", nonHighlightedColor=");
        sb.append(this.d);
        sb.append(", onClick=");
        return q2.m(sb, this.e, ")");
    }

    public b0(g gVar, Function0 function0, x10.r rVar) {
        this(rVar, true, gVar, i.u(ld1.r.Companion, R.dimen.m3_comp_fab_primary_large_icon_size), function0);
    }
}
