package d5;

import q.q2;
import st.w0;
import uc0.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class t {
    public final a a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f76f;
    public final float g;

    public t(a aVar, int i, int i2, int i3, int i4, float f2, float f3) {
        this.a = aVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f76f = f2;
        this.g = f3;
    }

    public final z3.c a(z3.c cVar) {
        return cVar.p((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(this.f76f)) & 4294967295L));
    }

    public final long b(long j2, boolean z) {
        if (z) {
            long j3 = p0.b;
            if (p0.c(j2, j3)) {
                return j3;
            }
        }
        int i = p0.c;
        int i2 = (int) (j2 >> 32);
        int i3 = this.b;
        return p.h(i2 + i3, ((int) (j2 & 4294967295L)) + i3);
    }

    public final z3.c c(z3.c cVar) {
        float f2 = -this.f76f;
        return cVar.p((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L));
    }

    public final int d(int i) {
        int i2 = this.c;
        int i3 = this.b;
        return w0.j(i, i3, i2) - i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.a.equals(tVar.a) && this.b == tVar.b && this.c == tVar.c && this.d == tVar.d && this.e == tVar.e && Float.compare(this.f76f, tVar.f76f) == 0 && Float.compare(this.g, tVar.g) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.g) + s1.a.b(this.f76f, s1.a.c(this.e, s1.a.c(this.d, s1.a.c(this.c, s1.a.c(this.b, this.a.hashCode() * 31, 31), 31), 31), 31), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ParagraphInfo(paragraph=");
        sb.append(this.a);
        sb.append(", startIndex=");
        sb.append(this.b);
        sb.append(", endIndex=");
        sb.append(this.c);
        sb.append(", startLineIndex=");
        sb.append(this.d);
        sb.append(", endLineIndex=");
        sb.append(this.e);
        sb.append(", top=");
        sb.append(this.f76f);
        sb.append(", bottom=");
        return q2.l(sb, this.g, ')');
    }
}
