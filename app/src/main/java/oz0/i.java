package oz0;

import aj.a;
import az1.b2;
import java.util.List;
import lx1.j;
import okhttp3.internal.http2.Http2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@a(deserializable = true, serializable = true)
public final class i implements e1 {
    public static final e Companion = new e();
    public static final lx1.h[] v;
    public final String a;
    public final String b;
    public final m10.q c;
    public final m10.f d;
    public final h e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f381f;
    public final Boolean g;
    public final Boolean h;
    public final m10.j0 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f382j;
    public final List k;
    public final Boolean l;
    public final String m;
    public final w n;
    public final String o;
    public final k0 p;
    public final q q;
    public final List r;
    public final o s;
    public final Boolean t;
    public final Boolean u;

    static {
        j jVar = j.a;
        v = new lx1.h[]{null, null, null, null, null, null, null, null, null, null, hs1.d.E(jVar, new ow.a(2)), null, null, null, null, hs1.d.E(jVar, new ow.a(3)), hs1.d.E(jVar, new ow.a(4)), hs1.d.E(jVar, new ow.a(5)), null, null, null};
    }

    public /* synthetic */ i(int i, String str, String str2, m10.q qVar, m10.f fVar, h hVar, String str3, Boolean bool, Boolean bool2, m10.j0 j0Var, String str4, List list, Boolean bool3, String str5, w wVar, String str6, k0 k0Var, q qVar2, List list2, o oVar, Boolean bool4, Boolean bool5) {
        if (1 != (i & 1)) {
            b2.b(i, 1, d.a.getDescriptor());
            throw null;
        }
        this.a = str;
        if ((i & 2) == 0) {
            this.b = null;
        } else {
            this.b = str2;
        }
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = qVar;
        }
        if ((i & 8) == 0) {
            this.d = null;
        } else {
            this.d = fVar;
        }
        if ((i & 16) == 0) {
            this.e = null;
        } else {
            this.e = hVar;
        }
        if ((i & 32) == 0) {
            this.f381f = null;
        } else {
            this.f381f = str3;
        }
        if ((i & 64) == 0) {
            this.g = null;
        } else {
            this.g = bool;
        }
        if ((i & 128) == 0) {
            this.h = null;
        } else {
            this.h = bool2;
        }
        if ((i & 256) == 0) {
            this.i = null;
        } else {
            this.i = j0Var;
        }
        if ((i & 512) == 0) {
            this.f382j = null;
        } else {
            this.f382j = str4;
        }
        if ((i & 1024) == 0) {
            this.k = null;
        } else {
            this.k = list;
        }
        if ((i & 2048) == 0) {
            this.l = null;
        } else {
            this.l = bool3;
        }
        if ((i & 4096) == 0) {
            this.m = null;
        } else {
            this.m = str5;
        }
        if ((i & 8192) == 0) {
            this.n = null;
        } else {
            this.n = wVar;
        }
        if ((i & Http2.INITIAL_MAX_FRAME_SIZE) == 0) {
            this.o = null;
        } else {
            this.o = str6;
        }
        if ((32768 & i) == 0) {
            this.p = null;
        } else {
            this.p = k0Var;
        }
        if ((65536 & i) == 0) {
            this.q = null;
        } else {
            this.q = qVar2;
        }
        if ((131072 & i) == 0) {
            this.r = null;
        } else {
            this.r = list2;
        }
        if ((262144 & i) == 0) {
            this.s = null;
        } else {
            this.s = oVar;
        }
        if ((524288 & i) == 0) {
            this.t = null;
        } else {
            this.t = bool4;
        }
        if ((i & 1048576) == 0) {
            this.u = null;
        } else {
            this.u = bool5;
        }
    }

    @Override // oz0.e1
    public final List e0() {
        return this.k;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, iVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, iVar.b) && lmjxuqdtp.jvm.internal.o.c(this.c, iVar.c) && lmjxuqdtp.jvm.internal.o.c(this.d, iVar.d) && lmjxuqdtp.jvm.internal.o.c(this.e, iVar.e) && lmjxuqdtp.jvm.internal.o.c(this.f381f, iVar.f381f) && lmjxuqdtp.jvm.internal.o.c(this.g, iVar.g) && lmjxuqdtp.jvm.internal.o.c(this.h, iVar.h) && lmjxuqdtp.jvm.internal.o.c(this.i, iVar.i) && lmjxuqdtp.jvm.internal.o.c(this.f382j, iVar.f382j) && lmjxuqdtp.jvm.internal.o.c(this.k, iVar.k) && lmjxuqdtp.jvm.internal.o.c(this.l, iVar.l) && lmjxuqdtp.jvm.internal.o.c(this.m, iVar.m) && lmjxuqdtp.jvm.internal.o.c(this.n, iVar.n) && lmjxuqdtp.jvm.internal.o.c(this.o, iVar.o) && this.p == iVar.p && this.q == iVar.q && lmjxuqdtp.jvm.internal.o.c(this.r, iVar.r) && lmjxuqdtp.jvm.internal.o.c(this.s, iVar.s) && lmjxuqdtp.jvm.internal.o.c(this.t, iVar.t) && lmjxuqdtp.jvm.internal.o.c(this.u, iVar.u);
    }

    public final String getId() {
        return this.a;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        m10.q qVar = this.c;
        int iHashCode3 = (iHashCode2 + (qVar == null ? 0 : qVar.hashCode())) * 31;
        m10.f fVar = this.d;
        int iHashCode4 = (iHashCode3 + (fVar == null ? 0 : fVar.hashCode())) * 31;
        h hVar = this.e;
        int iHashCode5 = (iHashCode4 + (hVar == null ? 0 : hVar.hashCode())) * 31;
        String str2 = this.f381f;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.g;
        int iHashCode7 = (iHashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.h;
        int iHashCode8 = (iHashCode7 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        m10.j0 j0Var = this.i;
        int iHashCode9 = (iHashCode8 + (j0Var == null ? 0 : j0Var.hashCode())) * 31;
        String str3 = this.f382j;
        int iHashCode10 = (iHashCode9 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List list = this.k;
        int iHashCode11 = (iHashCode10 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool3 = this.l;
        int iHashCode12 = (iHashCode11 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str4 = this.m;
        int iHashCode13 = (iHashCode12 + (str4 == null ? 0 : str4.hashCode())) * 31;
        w wVar = this.n;
        int iHashCode14 = (iHashCode13 + (wVar == null ? 0 : wVar.hashCode())) * 31;
        String str5 = this.o;
        int iHashCode15 = (iHashCode14 + (str5 == null ? 0 : str5.hashCode())) * 31;
        k0 k0Var = this.p;
        int iHashCode16 = (iHashCode15 + (k0Var == null ? 0 : k0Var.hashCode())) * 31;
        q qVar2 = this.q;
        int iHashCode17 = (iHashCode16 + (qVar2 == null ? 0 : qVar2.hashCode())) * 31;
        List list2 = this.r;
        int iHashCode18 = (iHashCode17 + (list2 == null ? 0 : list2.hashCode())) * 31;
        o oVar = this.s;
        int iHashCode19 = (iHashCode18 + (oVar == null ? 0 : oVar.hashCode())) * 31;
        Boolean bool4 = this.t;
        int iHashCode20 = (iHashCode19 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.u;
        return iHashCode20 + (bool5 != null ? bool5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbJ = z.p.j("Album(id=", this.a, ", name=", this.b, ", creator=");
        sbJ.append(this.c);
        sbJ.append(", artist=");
        sbJ.append(this.d);
        sbJ.append(", counters=");
        sbJ.append(this.e);
        sbJ.append(", releaseDate=");
        sbJ.append(this.f381f);
        sbJ.append(", isReleaseScheduled=");
        sbJ.append(this.g);
        sbJ.append(", isPurchased=");
        sbJ.append(this.h);
        sbJ.append(", picture=");
        sbJ.append(this.i);
        sbJ.append(", description=");
        sbJ.append(this.f382j);
        sbJ.append(", posts=");
        sbJ.append(this.k);
        sbJ.append(", isLiked=");
        sbJ.append(this.l);
        sbJ.append(", genreId=");
        sbJ.append(this.m);
        sbJ.append(", theme=");
        sbJ.append(this.n);
        sbJ.append(", themeId=");
        sbJ.append(this.o);
        sbJ.append(", type=");
        sbJ.append(this.p);
        sbJ.append(", state=");
        sbJ.append(this.q);
        sbJ.append(", supporters=");
        sbJ.append(this.r);
        sbJ.append(", permissions=");
        sbJ.append(this.s);
        sbJ.append(", isCommentingAllowed=");
        sbJ.append(this.t);
        sbJ.append(", isAutoRepostEnabled=");
        sbJ.append(this.u);
        sbJ.append(")");
        return sbJ.toString();
    }

    public final boolean y() {
        return this.q == q.b;
    }

    public i(String str, String str2, m10.q qVar, m10.f fVar, h hVar, String str3, Boolean bool, Boolean bool2, m10.j0 j0Var, String str4, List list, Boolean bool3, String str5, w wVar, String str6, k0 k0Var, q qVar2, List list2, o oVar, Boolean bool4, Boolean bool5) {
        lmjxuqdtp.jvm.internal.o.h(str, "id");
        this.a = str;
        this.b = str2;
        this.c = qVar;
        this.d = fVar;
        this.e = hVar;
        this.f381f = str3;
        this.g = bool;
        this.h = bool2;
        this.i = j0Var;
        this.f382j = str4;
        this.k = list;
        this.l = bool3;
        this.m = str5;
        this.n = wVar;
        this.o = str6;
        this.p = k0Var;
        this.q = qVar2;
        this.r = list2;
        this.s = oVar;
        this.t = bool4;
        this.u = bool5;
    }
}
