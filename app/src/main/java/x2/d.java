package x2;

import f3.f2;
import s1.a;
import z3.b;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f677f = new d(false, 9205357640488583168L, 0.0f, o5.j.a, false);
    public final boolean a;
    public final long b;
    public final float c;
    public final o5.j d;
    public final boolean e;

    public d(boolean z, long j2, float f2, o5.j jVar, boolean z2) {
        this.a = z;
        this.b = j2;
        this.c = f2;
        this.d = jVar;
        this.e = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.a == dVar.a && b.d(this.b, dVar.b) && Float.compare(this.c, dVar.c) == 0 && this.d == dVar.d && this.e == dVar.e;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.e) + ((this.d.hashCode() + a.b(this.c, a.g(Boolean.hashCode(this.a) * 31, this.b, 31), 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TextFieldHandleState(visible=");
        sb.append(this.a);
        sb.append(", position=");
        sb.append((Object) b.l(this.b));
        sb.append(", lineHeight=");
        sb.append(this.c);
        sb.append(", direction=");
        sb.append(this.d);
        sb.append(", handlesCrossed=");
        return f2.n(sb, this.e, ')');
    }
}
