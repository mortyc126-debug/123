package nj1;

import dg1.e;
import if1.j;
import lmjxuqdtp.jvm.internal.o;
import oj0.r;
import s1.a;
import x10.l;
import x10.v;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public final String a;
    public final e b;
    public final v c;
    public final boolean d;
    public final f e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r f353f;
    public final j g;
    public final v h;
    public final dg1.i i;

    public g(String str, e eVar, l lVar, boolean z, f fVar, r rVar, j jVar, l lVar2, e eVar2) {
        o.h(lVar, "name");
        this.a = str;
        this.b = eVar;
        this.c = lVar;
        this.d = z;
        this.e = fVar;
        this.f353f = rVar;
        this.g = jVar;
        this.h = lVar2;
        this.i = eVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return o.c(this.a, gVar.a) && this.b.equals(gVar.b) && o.c(this.c, gVar.c) && this.d == gVar.d && this.e.equals(gVar.e) && this.f353f.equals(gVar.f353f) && o.c(this.g, gVar.g) && o.c(this.h, gVar.h) && o.c(this.i, gVar.i);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (this.f353f.hashCode() + ((this.e.hashCode() + a.f(o6.c.d(com.gnacba.ads.interactivemedia.v3.internal.a.d(this.b, (str == null ? 0 : str.hashCode()) * 31, 31), 31, this.c), 31, this.d)) * 31)) * 31;
        j jVar = this.g;
        int iHashCode2 = (iHashCode + (jVar == null ? 0 : jVar.hashCode())) * 31;
        v vVar = this.h;
        int iHashCode3 = (iHashCode2 + (vVar == null ? 0 : vVar.hashCode())) * 31;
        dg1.i iVar = this.i;
        return iHashCode3 + (iVar != null ? iVar.hashCode() : 0);
    }

    public final String toString() {
        return "CreatorState(creatorId=" + this.a + ", picture=" + this.b + ", name=" + this.c + ", isVerified=" + this.d + ", subtitle=" + this.e + ", openProfile=" + this.f353f + ", followButtonState=" + this.g + ", bandName=" + this.h + ", authorPicture=" + this.i + ")";
    }
}
