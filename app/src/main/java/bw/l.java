package bw;

import hv.d;
import m10.j0;
import ny1.r2;
import rd1.v0;
import x10.v;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l {
    public final x10.l a;
    public final x10.l b;
    public final x10.l c;
    public final x10.f d;
    public final xu.c e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final v0 f30f;
    public final j0 g;
    public final boolean h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final v f31j;
    public final d k;
    public final d l;
    public final r2 m;
    public final r2 n;

    public l(x10.l lVar, x10.l lVar2, x10.l lVar3, x10.f fVar, xu.c cVar, v0 v0Var, j0 j0Var, boolean z, boolean z2, v vVar, d dVar, d dVar2, r2 r2Var, r2 r2Var2) {
        lmjxuqdtp.jvm.internal.o.h(cVar, "price");
        this.a = lVar;
        this.b = lVar2;
        this.c = lVar3;
        this.d = fVar;
        this.e = cVar;
        this.f30f = v0Var;
        this.g = j0Var;
        this.h = z;
        this.i = z2;
        this.f31j = vVar;
        this.k = dVar;
        this.l = dVar2;
        this.m = r2Var;
        this.n = r2Var2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.a.equals(lVar.a) && this.b.equals(lVar.b) && this.c.equals(lVar.c) && this.d.equals(lVar.d) && lmjxuqdtp.jvm.internal.o.c(this.e, lVar.e) && this.f30f.equals(lVar.f30f) && lmjxuqdtp.jvm.internal.o.c(this.g, lVar.g) && this.h == lVar.h && this.i == lVar.i && this.f31j.equals(lVar.f31j) && this.k.equals(lVar.k) && this.l.equals(lVar.l) && this.m.equals(lVar.m) && this.n.equals(lVar.n);
    }

    public final int hashCode() {
        int iHashCode = (this.f30f.hashCode() + ((this.e.hashCode() + ((this.d.hashCode() + com.gnacba.ads.interactivemedia.v3.internal.a.c(com.gnacba.ads.interactivemedia.v3.internal.a.c(this.a.e.hashCode() * 31, 31, this.b.e), 31, this.c.e)) * 31)) * 31)) * 31;
        j0 j0Var = this.g;
        return this.n.hashCode() + com.gnacba.ads.interactivemedia.v3.internal.a.g(this.m, (this.l.hashCode() + ((this.k.hashCode() + o6.c.d(s1.a.f(s1.a.f((iHashCode + (j0Var == null ? 0 : j0Var.hashCode())) * 31, 31, this.h), 31, this.i), 31, this.f31j)) * 31)) * 31, 31);
    }

    public final String toString() {
        return "PostBeatState(title=" + this.a + ", author=" + this.b + ", duration=" + this.c + ", genreAndBpm=" + this.d + ", price=" + this.e + ", playerState=" + this.f30f + ", cover=" + this.g + ", showPrice=" + this.h + ", areActionsEnabled=" + this.i + ", actionDescription=" + this.f31j + ", openDetails=" + this.k + ", purchase=" + this.l + ", playerSliderState=" + this.m + ", playbackTrigger=" + this.n + ")";
    }
}
