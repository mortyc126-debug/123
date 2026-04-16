package nj1;

import ny1.o;
import ny1.r2;
import oj0.j;
import oj0.r;
import rw0.e;
import s1.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class m {
    public final e a;
    public final boolean b;
    public final o c;
    public final r2 d;
    public final r2 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f356f;
    public final r g;
    public final r h;
    public final com.bandlab.media.player.impl.r i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final j f357j;
    public final j k;
    public final r2 l;

    public m(e eVar, boolean z, o oVar, r2 r2Var, r2 r2Var2, boolean z2, r rVar, r rVar2, com.bandlab.media.player.impl.r rVar3, j jVar, j jVar2, r2 r2Var3) {
        this.a = eVar;
        this.b = z;
        this.c = oVar;
        this.d = r2Var;
        this.e = r2Var2;
        this.f356f = z2;
        this.g = rVar;
        this.h = rVar2;
        this.i = rVar3;
        this.f357j = jVar;
        this.k = jVar2;
        this.l = r2Var3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.a.equals(mVar.a) && this.b == mVar.b && this.c.equals(mVar.c) && this.d.equals(mVar.d) && this.e.equals(mVar.e) && this.f356f == mVar.f356f && this.g.equals(mVar.g) && this.h.equals(mVar.h) && this.i.equals(mVar.i) && this.f357j.equals(mVar.f357j) && this.k.equals(mVar.k) && this.l.equals(mVar.l);
    }

    public final int hashCode() {
        return this.l.hashCode() + ((this.k.hashCode() + ((this.f357j.hashCode() + ((this.i.hashCode() + ((this.h.hashCode() + ((this.g.hashCode() + a.f(com.gnacba.ads.interactivemedia.v3.internal.a.g(this.e, com.gnacba.ads.interactivemedia.v3.internal.a.g(this.d, (this.c.hashCode() + a.f(this.a.hashCode() * 31, 31, this.b)) * 31, 31), 31), 31, this.f356f)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "VideoPlayerScreenState(listManagerUiState=" + this.a + ", isSwipeGestureEnabled=" + this.b + ", initialIndexFlow=" + this.c + ", swipeHintVisibilityChangedEvent=" + this.d + ", navigateBackToVideoEvent=" + this.e + ", isFullScreenMode=" + this.f356f + ", navigateBack=" + this.g + ", navigateUp=" + this.h + ", onPageRender=" + this.i + ", onNthItemViewed=" + this.f357j + ", onItemImpressed=" + this.k + ", scrollToTop=" + this.l + ")";
    }
}
