package hj;

import lmjxuqdtp.jvm.internal.o;
import o6.c;
import x10.v;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b3 {
    public final boolean a;
    public final boolean b;
    public final String c;
    public final v d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f188f;
    public final ld1.r g;
    public final int h;

    public b3(boolean z, boolean z2, String str, v vVar, boolean z3, boolean z4, ld1.r rVar, int i) {
        this.a = z;
        this.b = z2;
        this.c = str;
        this.d = vVar;
        this.e = z3;
        this.f188f = z4;
        this.g = rVar;
        this.h = i;
    }

    public static b3 a(b3 b3Var, v vVar, boolean z, ld1.r rVar, int i, int i2) {
        boolean z2 = b3Var.a;
        boolean z3 = b3Var.b;
        String str = b3Var.c;
        if ((i2 & 8) != 0) {
            vVar = b3Var.d;
        }
        v vVar2 = vVar;
        boolean z4 = b3Var.e;
        if ((i2 & 32) != 0) {
            z = b3Var.f188f;
        }
        boolean z5 = z;
        if ((i2 & 64) != 0) {
            rVar = b3Var.g;
        }
        ld1.r rVar2 = rVar;
        if ((i2 & 128) != 0) {
            i = b3Var.h;
        }
        b3Var.getClass();
        return new b3(z2, z3, str, vVar2, z4, z5, rVar2, i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b3)) {
            return false;
        }
        b3 b3Var = (b3) obj;
        return this.a == b3Var.a && this.b == b3Var.b && o.c(this.c, b3Var.c) && o.c(this.d, b3Var.d) && this.e == b3Var.e && this.f188f == b3Var.f188f && o.c(this.g, b3Var.g) && this.h == b3Var.h;
    }

    public final int hashCode() {
        int iF = s1.a.f(Boolean.hashCode(this.a) * 31, 31, this.b);
        String str = this.c;
        int iHashCode = (iF + (str == null ? 0 : str.hashCode())) * 31;
        v vVar = this.d;
        return Integer.hashCode(this.h) + com.gnacba.ads.interactivemedia.v3.internal.a.f(this.g, s1.a.f(s1.a.f((iHashCode + (vVar != null ? vVar.hashCode() : 0)) * 31, 31, this.e), 31, this.f188f), 31);
    }

    public final String toString() {
        StringBuilder sbR = f3.f2.r("UiTrackProperties(canEdit=", ", isFrozen=", ", name=", this.a, this.b);
        sbR.append(this.c);
        sbR.append(", preset=");
        sbR.append(this.d);
        sbR.append(", selected=");
        c.C(sbR, this.e, ", isCollapsed=", this.f188f, ", color=");
        sbR.append(this.g);
        sbR.append(", visibleTakes=");
        sbR.append(this.h);
        sbR.append(")");
        return sbR.toString();
    }
}
