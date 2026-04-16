package g4;

import q.q2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class y extends c0 {
    public final float c;
    public final float d;
    public final float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f177f;

    public y(float f2, float f3, float f4, float f5) {
        super(2);
        this.c = f2;
        this.d = f3;
        this.e = f4;
        this.f177f = f5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return Float.compare(this.c, yVar.c) == 0 && Float.compare(this.d, yVar.d) == 0 && Float.compare(this.e, yVar.e) == 0 && Float.compare(this.f177f, yVar.f177f) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f177f) + s1.a.b(this.e, s1.a.b(this.d, Float.hashCode(this.c) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RelativeReflectiveCurveTo(dx1=");
        sb.append(this.c);
        sb.append(", dy1=");
        sb.append(this.d);
        sb.append(", dx2=");
        sb.append(this.e);
        sb.append(", dy2=");
        return q2.l(sb, this.f177f, ')');
    }
}
