package g4;

import q.q2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends c0 {
    public final float c;
    public final float d;
    public final float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f168f;
    public final float g;
    public final float h;

    public l(float f2, float f3, float f4, float f5, float f7, float f8) {
        super(2);
        this.c = f2;
        this.d = f3;
        this.e = f4;
        this.f168f = f5;
        this.g = f7;
        this.h = f8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return Float.compare(this.c, lVar.c) == 0 && Float.compare(this.d, lVar.d) == 0 && Float.compare(this.e, lVar.e) == 0 && Float.compare(this.f168f, lVar.f168f) == 0 && Float.compare(this.g, lVar.g) == 0 && Float.compare(this.h, lVar.h) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.h) + s1.a.b(this.g, s1.a.b(this.f168f, s1.a.b(this.e, s1.a.b(this.d, Float.hashCode(this.c) * 31, 31), 31), 31), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CurveTo(x1=");
        sb.append(this.c);
        sb.append(", y1=");
        sb.append(this.d);
        sb.append(", x2=");
        sb.append(this.e);
        sb.append(", y2=");
        sb.append(this.f168f);
        sb.append(", x3=");
        sb.append(this.g);
        sb.append(", y3=");
        return q2.l(sb, this.h, ')');
    }
}
