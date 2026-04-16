package nj1;

import cs0.t;
import lmjxuqdtp.jvm.internal.o;
import me1.h;
import n30.k;
import ny1.p2;
import ny1.r2;
import oj0.j;
import oj0.r;
import oj1.s;
import q.q2;
import qu0.u;
import s1.a;
import wz0.n0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements vu0.d {
    public final u A;
    public final String a;
    public final boolean b;
    public final k c;
    public final k d;
    public final k e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r2 f354f;
    public final p2 g;
    public final r2 h;
    public final xd1.d i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final s f355j;
    public final p2 k;
    public final g l;
    public final n0 m;
    public final j n;
    public final r o;
    public final r p;
    public final r q;
    public final r r;
    public final r s;
    public final r t;
    public final j u;
    public final r v;
    public final t w;
    public final h x;
    public final te1.b y;
    public final boolean z;

    public i(String str, boolean z, k kVar, k kVar2, k kVar3, r2 r2Var, h30.g gVar, r2 r2Var2, xd1.d dVar, s sVar, r2 r2Var3, g gVar2, n0 n0Var, j jVar, r rVar, r rVar2, r rVar3, r rVar4, r rVar5, r rVar6, j jVar2, r rVar7, t tVar, h hVar, te1.b bVar, boolean z2, u uVar) {
        o.h(str, "id");
        o.h(gVar, "isBoostButtonVisible");
        o.h(r2Var3, "startPlaybackEvent");
        o.h(bVar, "playerSliderState");
        this.a = str;
        this.b = z;
        this.c = kVar;
        this.d = kVar2;
        this.e = kVar3;
        this.f354f = r2Var;
        this.g = gVar;
        this.h = r2Var2;
        this.i = dVar;
        this.f355j = sVar;
        this.k = r2Var3;
        this.l = gVar2;
        this.m = n0Var;
        this.n = jVar;
        this.o = rVar;
        this.p = rVar2;
        this.q = rVar3;
        this.r = rVar4;
        this.s = rVar5;
        this.t = rVar6;
        this.u = jVar2;
        this.v = rVar7;
        this.w = tVar;
        this.x = hVar;
        this.y = bVar;
        this.z = z2;
        this.A = uVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return o.c(this.a, iVar.a) && this.b == iVar.b && this.c.equals(iVar.c) && this.d.equals(iVar.d) && this.e.equals(iVar.e) && this.f354f.equals(iVar.f354f) && o.c(this.g, iVar.g) && this.h.equals(iVar.h) && this.i.equals(iVar.i) && this.f355j.equals(iVar.f355j) && o.c(this.k, iVar.k) && this.l.equals(iVar.l) && this.m.equals(iVar.m) && this.n.equals(iVar.n) && this.o.equals(iVar.o) && this.p.equals(iVar.p) && this.q.equals(iVar.q) && this.r.equals(iVar.r) && this.s.equals(iVar.s) && this.t.equals(iVar.t) && this.u.equals(iVar.u) && this.v.equals(iVar.v) && this.w.equals(iVar.w) && this.x.equals(iVar.x) && o.c(this.y, iVar.y) && this.z == iVar.z && this.A.equals(iVar.A);
    }

    public final String getId() {
        return this.a;
    }

    public final int hashCode() {
        return this.A.hashCode() + a.f((this.y.hashCode() + ((this.x.hashCode() + ((this.w.hashCode() + ((this.v.hashCode() + ((this.u.hashCode() + ((this.t.hashCode() + ((this.s.hashCode() + ((this.r.hashCode() + ((this.q.hashCode() + ((this.p.hashCode() + ((this.o.hashCode() + ((this.n.hashCode() + ((this.m.hashCode() + ((this.l.hashCode() + q2.h(this.k, (this.f355j.hashCode() + ((this.i.hashCode() + com.gnacba.ads.interactivemedia.v3.internal.a.g(this.h, q2.h(this.g, com.gnacba.ads.interactivemedia.v3.internal.a.g(this.f354f, jn1.r.j(this.e, jn1.r.j(this.d, jn1.r.j(this.c, a.f(this.a.hashCode() * 31, 31, this.b), 31), 31), 31), 31), 31), 31)) * 31)) * 31, 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31, 31, this.z);
    }

    public final String toString() {
        StringBuilder sbS = bh.j.s("PostCardState(id=", this.a, ", isBandPost=", ", isLiked=", this.b);
        sbS.append(this.c);
        sbS.append(", likesCount=");
        sbS.append(this.d);
        sbS.append(", commentsCount=");
        sbS.append(this.e);
        sbS.append(", isOverlayVisible=");
        sbS.append(this.f354f);
        sbS.append(", isBoostButtonVisible=");
        sbS.append(this.g);
        sbS.append(", isBlockConfirmationDialogShown=");
        sbS.append(this.h);
        sbS.append(", blockUserDialogState=");
        sbS.append(this.i);
        sbS.append(", postCardViewModel=");
        sbS.append(this.f355j);
        sbS.append(", startPlaybackEvent=");
        sbS.append(this.k);
        sbS.append(", creatorState=");
        sbS.append(this.l);
        sbS.append(", textState=");
        sbS.append(this.m);
        sbS.append(", toggleOverlayVisibility=");
        sbS.append(this.n);
        sbS.append(", onPostEngaged=");
        sbS.append(this.o);
        sbS.append(", onBoostBtnClick=");
        sbS.append(this.p);
        sbS.append(", onLikeBtnClick=");
        sbS.append(this.q);
        sbS.append(", onOpenLikes=");
        sbS.append(this.r);
        sbS.append(", onOpenComment=");
        sbS.append(this.s);
        sbS.append(", onShareBtnClick=");
        sbS.append(this.t);
        sbS.append(", onSwipeToProfile=");
        sbS.append(this.u);
        sbS.append(", onSwipeGestureHintShown=");
        sbS.append(this.v);
        sbS.append(", boostButtonAnimationTrigger=");
        sbS.append(this.w);
        sbS.append(", menu=");
        sbS.append(this.x);
        sbS.append(", playerSliderState=");
        sbS.append(this.y);
        sbS.append(", isFullScreenMode=");
        sbS.append(this.z);
        sbS.append(", sensitiveContentState=");
        sbS.append(this.A);
        sbS.append(")");
        return sbS.toString();
    }
}
