package pf1;

import com.google.android.material.R;
import h5.s;
import ld1.q;
import ld1.r;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class i {
    public static final i d = new i(i.u(r.Companion, R.dimen.m3_comp_extended_fab_primary_focus_state_layer_opacity), s.f, o5.l.c);
    public final q a;
    public final s b;
    public final o5.l c;

    public i(q qVar, s sVar, o5.l lVar) {
        o.h(sVar, "fontWeight");
        this.a = qVar;
        this.b = sVar;
        this.c = lVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.a.equals(iVar.a) && o.c(this.b, iVar.b) && this.c.equals(iVar.c);
    }

    public final int hashCode() {
        return ((s1.a.c(0, Integer.hashCode(this.a.a) * 31, 31) + this.b.a) * 31) + this.c.a;
    }

    public final String toString() {
        return "LinkStyle(color=" + this.a + ", fontStyle=" + h5.o.a(0) + ", fontWeight=" + this.b + ", textDecoration=" + this.c + ")";
    }
}
