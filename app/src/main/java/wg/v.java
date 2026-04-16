package wg;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class v {
    public final d a;
    public final d b;
    public final d c;
    public final d d;
    public final d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f654f;
    public final d g;
    public final d h;
    public final d i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d f655j;
    public final d k;
    public final d l;

    public v(d dVar, d dVar2, d dVar3, d dVar4, d dVar5, d dVar6, d dVar7, d dVar8, d dVar9, d dVar10, d dVar11, d dVar12) {
        this.a = dVar;
        this.b = dVar2;
        this.c = dVar3;
        this.d = dVar4;
        this.e = dVar5;
        this.f654f = dVar6;
        this.g = dVar7;
        this.h = dVar8;
        this.i = dVar9;
        this.f655j = dVar10;
        this.k = dVar11;
        this.l = dVar12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, vVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, vVar.b) && lmjxuqdtp.jvm.internal.o.c(this.c, vVar.c) && lmjxuqdtp.jvm.internal.o.c(this.d, vVar.d) && lmjxuqdtp.jvm.internal.o.c(this.e, vVar.e) && lmjxuqdtp.jvm.internal.o.c(this.f654f, vVar.f654f) && lmjxuqdtp.jvm.internal.o.c(this.g, vVar.g) && lmjxuqdtp.jvm.internal.o.c(this.h, vVar.h) && lmjxuqdtp.jvm.internal.o.c(this.i, vVar.i) && lmjxuqdtp.jvm.internal.o.c(this.f655j, vVar.f655j) && lmjxuqdtp.jvm.internal.o.c(this.k, vVar.k) && lmjxuqdtp.jvm.internal.o.c(this.l, vVar.l);
    }

    public final int hashCode() {
        return this.l.hashCode() + ((this.k.hashCode() + ((this.f655j.hashCode() + ((this.i.hashCode() + ((this.h.hashCode() + ((this.g.hashCode() + ((this.f654f.hashCode() + ((this.e.hashCode() + ((this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "AppAdConfig(projectsToolbar=" + this.a + ", chatsList=" + this.b + ", studioRevisionSave=" + this.c + ", studioSoundsLibrary=" + this.d + ", studioNewTrackModal=" + this.e + ", interstitialFeed=" + this.f654f + ", interstitialStudio=" + this.g + ", interstitialTools=" + this.h + ", interstitialStudioTools=" + this.i + ", followingFeedAfterTwoAndFour=" + this.f655j + ", projectPage=" + this.k + ", revisionPage=" + this.l + ")";
    }
}
