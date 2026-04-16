package ne0;

import j50.c1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class k {
    public final jp1.a a;
    public final kp1.j b;
    public final z c;
    public final c1 d;

    public k(jp1.a aVar, kp1.j jVar, z zVar, c1 c1Var) {
        this.a = aVar;
        this.b = jVar;
        this.c = zVar;
        this.d = c1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.a.equals(kVar.a) && this.b.equals(kVar.b) && this.c.equals(kVar.c) && this.d.equals(kVar.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "CastSession(castContext=" + this.a + ", remoteMediaClient=" + this.b + ", volumeController=" + this.c + ", playerFactory=" + this.d + ")";
    }
}
