package eh0;

import f3.f2;
import hg1.n;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final d d = new d(-1, 0, c.a);
    public final int a;
    public final float b;
    public final c c;

    public d(int i, float f2, c cVar) {
        this.a = i;
        this.b = f2;
        this.c = cVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.a == dVar.a && n.b(this.b, dVar.b) && this.c == dVar.c;
    }

    public final int hashCode() {
        return this.c.hashCode() + s1.a.b(this.b, Integer.hashCode(this.a) * 31, 31);
    }

    public final String toString() {
        StringBuilder sbP = f2.p("TracksScrollState(trackIndex=", this.a, ", offsetY=", n.c(this.b), ", source=");
        sbP.append(this.c);
        sbP.append(")");
        return sbP.toString();
    }
}
