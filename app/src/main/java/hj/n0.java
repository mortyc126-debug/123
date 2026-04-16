package hj;

import amuvvoafs.graphics.Typeface;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class n0 {
    public final float a;
    public final Typeface b;
    public final float c;
    public final float d;
    public final float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f205f;
    public final int g;

    public n0(float f2, Typeface typeface, float f3, float f4, float f5, float f7, int i) {
        o.h(typeface, "typeface");
        this.a = f2;
        this.b = typeface;
        this.c = f3;
        this.d = f4;
        this.e = f5;
        this.f205f = f7;
        this.g = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n0)) {
            return false;
        }
        n0 n0Var = (n0) obj;
        return hg1.n.b(this.a, n0Var.a) && o.c(this.b, n0Var.b) && hg1.n.b(this.c, n0Var.c) && hg1.n.b(this.d, n0Var.d) && hg1.n.b(this.e, n0Var.e) && hg1.n.b(this.f205f, n0Var.f205f) && this.g == n0Var.g;
    }

    public final int hashCode() {
        return Integer.hashCode(this.g) + s1.a.b(this.f205f, s1.a.b(this.e, s1.a.b(this.d, s1.a.b(this.c, (this.b.hashCode() + (Float.hashCode(this.a) * 31)) * 31, 31), 31), 31), 31);
    }

    public final String toString() {
        String strC = hg1.n.c(this.a);
        String strC2 = hg1.n.c(this.c);
        String strC3 = hg1.n.c(this.d);
        String strC4 = hg1.n.c(this.e);
        String strC5 = hg1.n.c(this.f205f);
        StringBuilder sb = new StringBuilder("Attributes(iconSize=");
        sb.append(strC);
        sb.append(", typeface=");
        sb.append(this.b);
        sb.append(", textSize=");
        s1.a.y(sb, strC2, ", verticalPadding=", strC3, ", horizontalPadding=");
        s1.a.y(sb, strC4, ", spacing=", strC5, ", background=");
        return z.p.d(this.g, ")", sb);
    }
}
