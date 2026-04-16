package g4;

import q.q2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends c0 {
    public final float c;
    public final float d;
    public final float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f167f;
    public final boolean g;
    public final float h;
    public final float i;

    public j(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f7) {
        super(3);
        this.c = f2;
        this.d = f3;
        this.e = f4;
        this.f167f = z;
        this.g = z2;
        this.h = f5;
        this.i = f7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return Float.compare(this.c, jVar.c) == 0 && Float.compare(this.d, jVar.d) == 0 && Float.compare(this.e, jVar.e) == 0 && this.f167f == jVar.f167f && this.g == jVar.g && Float.compare(this.h, jVar.h) == 0 && Float.compare(this.i, jVar.i) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.i) + s1.a.b(this.h, s1.a.f(s1.a.f(s1.a.b(this.e, s1.a.b(this.d, Float.hashCode(this.c) * 31, 31), 31), 31, this.f167f), 31, this.g), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ArcTo(horizontalEllipseRadius=");
        sb.append(this.c);
        sb.append(", verticalEllipseRadius=");
        sb.append(this.d);
        sb.append(", theta=");
        sb.append(this.e);
        sb.append(", isMoreThanHalf=");
        sb.append(this.f167f);
        sb.append(", isPositiveArc=");
        sb.append(this.g);
        sb.append(", arcStartX=");
        sb.append(this.h);
        sb.append(", arcStartY=");
        return q2.l(sb, this.i, ')');
    }
}
