package wg0;

import az1.b2;
import java.util.ArrayList;
import java.util.List;
import s1.a;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@wy1.f
public final class y implements a0 {
    public static final o Companion = new o();
    public static final lx1.h[] g = {hs1.d.E(lx1.j.a, new vb.z(14)), null, null, null, null, null};
    public final List a;
    public final int b;
    public final int c;
    public final boolean d;
    public final boolean e;

    /* JADX INFO: renamed from: f */
    public final x f659f;

    public y(List list, int i, int i2, boolean z, boolean z2, x xVar) {
        lmjxuqdtp.jvm.internal.o.h(list, "voices");
        this.a = list;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
        this.f659f = xVar;
    }

    public static y a(y yVar, ArrayList arrayList, int i, boolean z, x xVar, int i2) {
        List list = arrayList;
        if ((i2 & 1) != 0) {
            list = yVar.a;
        }
        List list2 = list;
        if ((i2 & 2) != 0) {
            i = yVar.b;
        }
        int i3 = i;
        int i4 = yVar.c;
        boolean z2 = yVar.d;
        if ((i2 & 16) != 0) {
            z = yVar.e;
        }
        boolean z3 = z;
        if ((i2 & 32) != 0) {
            xVar = yVar.f659f;
        }
        x xVar2 = xVar;
        lmjxuqdtp.jvm.internal.o.h(list2, "voices");
        lmjxuqdtp.jvm.internal.o.h(xVar2, "voicesGenericPreview");
        return new y(list2, i3, i4, z2, z3, xVar2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, yVar.a) && this.b == yVar.b && this.c == yVar.c && this.d == yVar.d && this.e == yVar.e && lmjxuqdtp.jvm.internal.o.c(this.f659f, yVar.f659f);
    }

    public final int hashCode() {
        return this.f659f.hashCode() + a.f(a.f(a.c(this.c, a.c(this.b, this.a.hashCode() * 31, 31), 31), 31, this.d), 31, this.e);
    }

    public final String toString() {
        return "Main(voices=" + this.a + ", pitchSliderPosition=" + p.c(this.b, "PitchSliderPosition(value=", ")") + ", pitchesCount=" + this.c + ", showApplyForWholeTrack=" + this.d + ", applyForWholeTrack=" + this.e + ", voicesGenericPreview=" + this.f659f + ")";
    }

    public /* synthetic */ y(int i, List list, c cVar, int i2, boolean z, boolean z2, x xVar) {
        if (63 != (i & 63)) {
            b2.b(i, 63, n.a.getDescriptor());
            throw null;
        }
        this.a = list;
        this.b = cVar.a;
        this.c = i2;
        this.d = z;
        this.e = z2;
        this.f659f = xVar;
    }
}
