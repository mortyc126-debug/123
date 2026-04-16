package fz0;

import com.gnacba.amuvvoafs.gms.internal.ads.hb0;
import jn1.r;
import ny1.b2;
import ny1.p2;
import o10.a4;
import oz0.d1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public final d1 a;
    public final a4 b;
    public final ct.f c;
    public final n10.a0 d;
    public final se0.q e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final hb0 f135f;
    public final x20.m g;
    public final p2 h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f136j;
    public final c k;
    public final x20.a l;
    public final Integer m;

    public b(d1 d1Var, a4 a4Var, ct.f fVar, n10.a0 a0Var, se0.q qVar, hb0 hb0Var, x20.m mVar, b2 b2Var, c cVar, Integer num, int i) {
        se0.q qVar2;
        x20.a aVar = x20.a.a;
        n10.a0 a0Var2 = (i & 8) != 0 ? null : a0Var;
        if ((i & 16) != 0) {
            se0.q.e2.getClass();
            qVar2 = se0.p.b;
        } else {
            qVar2 = qVar;
        }
        hb0 hb0Var2 = (i & 32) != 0 ? null : hb0Var;
        b2 b2Var2 = (i & 128) != 0 ? null : b2Var;
        boolean z = (i & 256) != 0;
        boolean z2 = (i & 512) != 0;
        Integer num2 = (i & 4096) == 0 ? num : null;
        lmjxuqdtp.jvm.internal.o.h(d1Var, "post");
        lmjxuqdtp.jvm.internal.o.h(fVar, "postModel");
        lmjxuqdtp.jvm.internal.o.h(qVar2, "playlist");
        this.a = d1Var;
        this.b = a4Var;
        this.c = fVar;
        this.d = a0Var2;
        this.e = qVar2;
        this.f135f = hb0Var2;
        this.g = mVar;
        this.h = b2Var2;
        this.i = z;
        this.f136j = z2;
        this.k = cVar;
        this.l = aVar;
        this.m = num2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, bVar.a) && this.b == bVar.b && lmjxuqdtp.jvm.internal.o.c(this.c, bVar.c) && lmjxuqdtp.jvm.internal.o.c(this.d, bVar.d) && lmjxuqdtp.jvm.internal.o.c(this.e, bVar.e) && lmjxuqdtp.jvm.internal.o.c(this.f135f, bVar.f135f) && lmjxuqdtp.jvm.internal.o.c(this.g, bVar.g) && lmjxuqdtp.jvm.internal.o.c(this.h, bVar.h) && this.i == bVar.i && this.f136j == bVar.f136j && this.k == bVar.k && this.l == bVar.l && lmjxuqdtp.jvm.internal.o.c(this.m, bVar.m);
    }

    public final int hashCode() {
        int iHashCode = (this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31;
        n10.a0 a0Var = this.d;
        int iHashCode2 = (this.e.hashCode() + ((iHashCode + (a0Var == null ? 0 : a0Var.hashCode())) * 31)) * 31;
        hb0 hb0Var = this.f135f;
        int iHashCode3 = (this.g.hashCode() + ((iHashCode2 + (hb0Var == null ? 0 : hb0Var.hashCode())) * 31)) * 31;
        p2 p2Var = this.h;
        int iHashCode4 = (this.l.hashCode() + ((this.k.hashCode() + s1.a.f(s1.a.f((iHashCode3 + (p2Var == null ? 0 : p2Var.hashCode())) * 31, 31, this.i), 31, this.f136j)) * 31)) * 31;
        Integer num = this.m;
        return iHashCode4 + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CommunityPostData(post=");
        sb.append(this.a);
        sb.append(", postSource=");
        sb.append(this.b);
        sb.append(", postModel=");
        sb.append(this.c);
        sb.append(", nativeAdPlacement=");
        sb.append(this.d);
        sb.append(", playlist=");
        sb.append(this.e);
        sb.append(", postMenuViewModel=");
        sb.append(this.f135f);
        sb.append(", postScreenParams=");
        sb.append(this.g);
        sb.append(", community=");
        sb.append(this.h);
        sb.append(", showJoinButton=");
        o6.c.C(sb, this.i, ", showReactionCounter=", this.f136j, ", communityPostSubtitle=");
        sb.append(this.k);
        sb.append(", headerType=");
        sb.append(this.l);
        sb.append(", index=");
        return r.n(sb, this.m, ")");
    }
}
