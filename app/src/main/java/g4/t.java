package g4;

import q.q2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class t extends c0 {
    public final float c;
    public final float d;
    public final float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f175f;
    public final float g;
    public final float h;

    public t(float f2, float f3, float f4, float f5, float f7, float f8) {
        super(2);
        this.c = f2;
        this.d = f3;
        this.e = f4;
        this.f175f = f5;
        this.g = f7;
        this.h = f8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return Float.compare(this.c, tVar.c) == 0 && Float.compare(this.d, tVar.d) == 0 && Float.compare(this.e, tVar.e) == 0 && Float.compare(this.f175f, tVar.f175f) == 0 && Float.compare(this.g, tVar.g) == 0 && Float.compare(this.h, tVar.h) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.h) + s1.a.b(this.g, s1.a.b(this.f175f, s1.a.b(this.e, s1.a.b(this.d, Float.hashCode(this.c) * 31, 31), 31), 31), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RelativeCurveTo(dx1=");
        sb.append(this.c);
        sb.append(", dy1=");
        sb.append(this.d);
        sb.append(", dx2=");
        sb.append(this.e);
        sb.append(", dy2=");
        sb.append(this.f175f);
        sb.append(", dx3=");
        sb.append(this.g);
        sb.append(", dy3=");
        return q2.l(sb, this.h, ')');
    }
}
