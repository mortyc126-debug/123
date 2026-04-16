package oz0;

import aj.a;
import java.util.List;
import jv0.k;
import jv0.n;
import kotlin.jvm.internal.IntCompanionObject;
import lmjxuqdtp.time.l;
import lx1.j;
import m10.k1;
import okhttp3.internal.http2.Http2;
import y11.l1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@a(deserializable = true, serializable = true)
public final class d1 implements vu0.d {
    public static final c1 Companion = new c1();
    public static final lx1.h[] M;
    public final s10.c A;
    public final Boolean B;
    public final n10.f C;
    public final Integer D;
    public final String E;
    public final String F;
    public final List G;
    public final Boolean H;
    public final x1 I;
    public final Boolean J;
    public final p0 K;
    public final rw.f L;
    public final String a;
    public final Boolean b;
    public final f2 c;
    public final l d;
    public final m10.f e;

    /* JADX INFO: renamed from: f */
    public final String f378f;
    public final h1 g;
    public final List h;
    public final l1 i;

    /* JADX INFO: renamed from: j */
    public final String f379j;
    public final k1 k;
    public final k l;
    public final n m;
    public final i0 n;
    public final v0 o;
    public final Boolean p;
    public final Boolean q;
    public final Boolean r;
    public final vu0.c s;
    public final n0 t;
    public final Boolean u;
    public final p1 v;
    public final String w;
    public final String x;
    public final Boolean y;
    public final Boolean z;

    static {
        j jVar = j.a;
        M = new lx1.h[]{null, null, hs1.d.E(jVar, new ow.a(12)), null, null, null, null, hs1.d.E(jVar, new ow.a(13)), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, hs1.d.E(jVar, new ow.a(14)), null, null, null, hs1.d.E(jVar, new ow.a(15)), null};
    }

    public /* synthetic */ d1(int i, int i2, String str, Boolean bool, f2 f2Var, l lVar, m10.f fVar, String str2, h1 h1Var, List list, l1 l1Var, String str3, k1 k1Var, k kVar, n nVar, i0 i0Var, v0 v0Var, Boolean bool2, Boolean bool3, Boolean bool4, vu0.c cVar, n0 n0Var, Boolean bool5, p1 p1Var, String str4, String str5, Boolean bool6, Boolean bool7, s10.c cVar2, Boolean bool8, n10.f fVar2, Integer num, String str6, String str7, List list2, Boolean bool9, x1 x1Var, Boolean bool10, p0 p0Var, rw.f fVar3) {
        this.a = (i & 1) == 0 ? "LOCAL_empty_post" : str;
        if ((i & 2) == 0) {
            this.b = null;
        } else {
            this.b = bool;
        }
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = f2Var;
        }
        if ((i & 8) == 0) {
            this.d = null;
        } else {
            this.d = lVar;
        }
        if ((i & 16) == 0) {
            this.e = null;
        } else {
            this.e = fVar;
        }
        if ((i & 32) == 0) {
            this.f378f = null;
        } else {
            this.f378f = str2;
        }
        if ((i & 64) == 0) {
            this.g = null;
        } else {
            this.g = h1Var;
        }
        if ((i & 128) == 0) {
            this.h = null;
        } else {
            this.h = list;
        }
        if ((i & 256) == 0) {
            this.i = null;
        } else {
            this.i = l1Var;
        }
        if ((i & 512) == 0) {
            this.f379j = null;
        } else {
            this.f379j = str3;
        }
        if ((i & 1024) == 0) {
            this.k = null;
        } else {
            this.k = k1Var;
        }
        if ((i & 2048) == 0) {
            this.l = null;
        } else {
            this.l = kVar;
        }
        if ((i & 4096) == 0) {
            this.m = null;
        } else {
            this.m = nVar;
        }
        if ((i & 8192) == 0) {
            this.n = null;
        } else {
            this.n = i0Var;
        }
        if ((i & Http2.INITIAL_MAX_FRAME_SIZE) == 0) {
            this.o = null;
        } else {
            this.o = v0Var;
        }
        if ((32768 & i) == 0) {
            this.p = null;
        } else {
            this.p = bool2;
        }
        this.q = (65536 & i) == 0 ? Boolean.FALSE : bool3;
        if ((131072 & i) == 0) {
            this.r = null;
        } else {
            this.r = bool4;
        }
        if ((262144 & i) == 0) {
            this.s = null;
        } else {
            this.s = cVar;
        }
        if ((524288 & i) == 0) {
            this.t = null;
        } else {
            this.t = n0Var;
        }
        if ((1048576 & i) == 0) {
            this.u = null;
        } else {
            this.u = bool5;
        }
        if ((2097152 & i) == 0) {
            this.v = null;
        } else {
            this.v = p1Var;
        }
        if ((4194304 & i) == 0) {
            this.w = null;
        } else {
            this.w = str4;
        }
        if ((8388608 & i) == 0) {
            this.x = null;
        } else {
            this.x = str5;
        }
        if ((16777216 & i) == 0) {
            this.y = null;
        } else {
            this.y = bool6;
        }
        if ((33554432 & i) == 0) {
            this.z = null;
        } else {
            this.z = bool7;
        }
        if ((67108864 & i) == 0) {
            this.A = null;
        } else {
            this.A = cVar2;
        }
        if ((134217728 & i) == 0) {
            this.B = null;
        } else {
            this.B = bool8;
        }
        if ((268435456 & i) == 0) {
            this.C = null;
        } else {
            this.C = fVar2;
        }
        if ((536870912 & i) == 0) {
            this.D = null;
        } else {
            this.D = num;
        }
        if ((1073741824 & i) == 0) {
            this.E = null;
        } else {
            this.E = str6;
        }
        if ((i & IntCompanionObject.MIN_VALUE) == 0) {
            this.F = null;
        } else {
            this.F = str7;
        }
        if ((i2 & 1) == 0) {
            this.G = null;
        } else {
            this.G = list2;
        }
        if ((i2 & 2) == 0) {
            this.H = null;
        } else {
            this.H = bool9;
        }
        if ((i2 & 4) == 0) {
            this.I = null;
        } else {
            this.I = x1Var;
        }
        if ((i2 & 8) == 0) {
            this.J = null;
        } else {
            this.J = bool10;
        }
        if ((i2 & 16) == 0) {
            this.K = null;
        } else {
            this.K = p0Var;
        }
        if ((i2 & 32) == 0) {
            this.L = null;
        } else {
            this.L = fVar3;
        }
    }

    public static d1 y(d1 d1Var, i0 i0Var, v0 v0Var, n0 n0Var, s10.c cVar, n10.f fVar, p0 p0Var, int i, int i2) {
        Boolean bool = Boolean.TRUE;
        String str = d1Var.a;
        Boolean bool2 = d1Var.b;
        f2 f2Var = d1Var.c;
        l lVar = d1Var.d;
        m10.f fVar2 = d1Var.e;
        String str2 = d1Var.f378f;
        h1 h1Var = d1Var.g;
        List list = d1Var.h;
        l1 l1Var = d1Var.i;
        String str3 = d1Var.f379j;
        k1 k1Var = d1Var.k;
        k kVar = d1Var.l;
        n nVar = d1Var.m;
        i0 i0Var2 = (i & 8192) != 0 ? d1Var.n : i0Var;
        v0 v0Var2 = (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? d1Var.o : v0Var;
        Boolean bool3 = d1Var.p;
        Boolean bool4 = d1Var.q;
        Boolean bool5 = d1Var.r;
        vu0.c cVar2 = d1Var.s;
        n0 n0Var2 = (i & 524288) != 0 ? d1Var.t : n0Var;
        Boolean bool6 = d1Var.u;
        p1 p1Var = d1Var.v;
        String str4 = d1Var.w;
        String str5 = d1Var.x;
        Boolean bool7 = d1Var.y;
        Boolean bool8 = d1Var.z;
        s10.c cVar3 = (i & 67108864) != 0 ? d1Var.A : cVar;
        Boolean bool9 = (i & 134217728) != 0 ? d1Var.B : bool;
        n10.f fVar3 = (i & 268435456) != 0 ? d1Var.C : fVar;
        Integer num = (i & 536870912) != 0 ? d1Var.D : 5;
        String str6 = d1Var.E;
        String str7 = d1Var.F;
        List list2 = d1Var.G;
        Boolean bool10 = d1Var.H;
        x1 x1Var = d1Var.I;
        Boolean bool11 = d1Var.J;
        p0 p0Var2 = (i2 & 16) != 0 ? d1Var.K : p0Var;
        rw.f fVar4 = d1Var.L;
        d1Var.getClass();
        lmjxuqdtp.jvm.internal.o.h(str, "id");
        return new d1(str, bool2, f2Var, lVar, fVar2, str2, h1Var, list, l1Var, str3, k1Var, kVar, nVar, i0Var2, v0Var2, bool3, bool4, bool5, cVar2, n0Var2, bool6, p1Var, str4, str5, bool7, bool8, cVar3, bool9, fVar3, num, str6, str7, list2, bool10, x1Var, bool11, p0Var2, fVar4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d1)) {
            return false;
        }
        d1 d1Var = (d1) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, d1Var.a) && lmjxuqdtp.jvm.internal.o.c(this.b, d1Var.b) && this.c == d1Var.c && lmjxuqdtp.jvm.internal.o.c(this.d, d1Var.d) && lmjxuqdtp.jvm.internal.o.c(this.e, d1Var.e) && lmjxuqdtp.jvm.internal.o.c(this.f378f, d1Var.f378f) && lmjxuqdtp.jvm.internal.o.c(this.g, d1Var.g) && lmjxuqdtp.jvm.internal.o.c(this.h, d1Var.h) && lmjxuqdtp.jvm.internal.o.c(this.i, d1Var.i) && lmjxuqdtp.jvm.internal.o.c(this.f379j, d1Var.f379j) && lmjxuqdtp.jvm.internal.o.c(this.k, d1Var.k) && lmjxuqdtp.jvm.internal.o.c(this.l, d1Var.l) && lmjxuqdtp.jvm.internal.o.c(this.m, d1Var.m) && lmjxuqdtp.jvm.internal.o.c(this.n, d1Var.n) && lmjxuqdtp.jvm.internal.o.c(this.o, d1Var.o) && lmjxuqdtp.jvm.internal.o.c(this.p, d1Var.p) && lmjxuqdtp.jvm.internal.o.c(this.q, d1Var.q) && lmjxuqdtp.jvm.internal.o.c(this.r, d1Var.r) && lmjxuqdtp.jvm.internal.o.c(this.s, d1Var.s) && lmjxuqdtp.jvm.internal.o.c(this.t, d1Var.t) && lmjxuqdtp.jvm.internal.o.c(this.u, d1Var.u) && lmjxuqdtp.jvm.internal.o.c(this.v, d1Var.v) && lmjxuqdtp.jvm.internal.o.c(this.w, d1Var.w) && lmjxuqdtp.jvm.internal.o.c(this.x, d1Var.x) && lmjxuqdtp.jvm.internal.o.c(this.y, d1Var.y) && lmjxuqdtp.jvm.internal.o.c(this.z, d1Var.z) && lmjxuqdtp.jvm.internal.o.c(this.A, d1Var.A) && lmjxuqdtp.jvm.internal.o.c(this.B, d1Var.B) && lmjxuqdtp.jvm.internal.o.c(this.C, d1Var.C) && lmjxuqdtp.jvm.internal.o.c(this.D, d1Var.D) && lmjxuqdtp.jvm.internal.o.c(this.E, d1Var.E) && lmjxuqdtp.jvm.internal.o.c(this.F, d1Var.F) && lmjxuqdtp.jvm.internal.o.c(this.G, d1Var.G) && lmjxuqdtp.jvm.internal.o.c(this.H, d1Var.H) && lmjxuqdtp.jvm.internal.o.c(this.I, d1Var.I) && lmjxuqdtp.jvm.internal.o.c(this.J, d1Var.J) && this.K == d1Var.K && lmjxuqdtp.jvm.internal.o.c(this.L, d1Var.L);
    }

    public final String getId() {
        return this.a;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Boolean bool = this.b;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        f2 f2Var = this.c;
        int iHashCode3 = (iHashCode2 + (f2Var == null ? 0 : f2Var.hashCode())) * 31;
        l lVar = this.d;
        int iHashCode4 = (iHashCode3 + (lVar == null ? 0 : lVar.hashCode())) * 31;
        m10.f fVar = this.e;
        int iHashCode5 = (iHashCode4 + (fVar == null ? 0 : fVar.hashCode())) * 31;
        String str = this.f378f;
        int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        h1 h1Var = this.g;
        int iHashCode7 = (iHashCode6 + (h1Var == null ? 0 : h1Var.hashCode())) * 31;
        List list = this.h;
        int iHashCode8 = (iHashCode7 + (list == null ? 0 : list.hashCode())) * 31;
        l1 l1Var = this.i;
        int iHashCode9 = (iHashCode8 + (l1Var == null ? 0 : l1Var.hashCode())) * 31;
        String str2 = this.f379j;
        int iHashCode10 = (iHashCode9 + (str2 == null ? 0 : str2.hashCode())) * 31;
        k1 k1Var = this.k;
        int iHashCode11 = (iHashCode10 + (k1Var == null ? 0 : k1Var.hashCode())) * 31;
        k kVar = this.l;
        int iHashCode12 = (iHashCode11 + (kVar == null ? 0 : kVar.hashCode())) * 31;
        n nVar = this.m;
        int iHashCode13 = (iHashCode12 + (nVar == null ? 0 : nVar.hashCode())) * 31;
        i0 i0Var = this.n;
        int iHashCode14 = (iHashCode13 + (i0Var == null ? 0 : i0Var.hashCode())) * 31;
        v0 v0Var = this.o;
        int iHashCode15 = (iHashCode14 + (v0Var == null ? 0 : v0Var.hashCode())) * 31;
        Boolean bool2 = this.p;
        int iHashCode16 = (iHashCode15 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.q;
        int iHashCode17 = (iHashCode16 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.r;
        int iHashCode18 = (iHashCode17 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        vu0.c cVar = this.s;
        int iHashCode19 = (iHashCode18 + (cVar == null ? 0 : cVar.hashCode())) * 31;
        n0 n0Var = this.t;
        int iHashCode20 = (iHashCode19 + (n0Var == null ? 0 : n0Var.hashCode())) * 31;
        Boolean bool5 = this.u;
        int iHashCode21 = (iHashCode20 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        p1 p1Var = this.v;
        int iHashCode22 = (iHashCode21 + (p1Var == null ? 0 : p1Var.hashCode())) * 31;
        String str3 = this.w;
        int iHashCode23 = (iHashCode22 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.x;
        int iHashCode24 = (iHashCode23 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool6 = this.y;
        int iHashCode25 = (iHashCode24 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Boolean bool7 = this.z;
        int iHashCode26 = (iHashCode25 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
        s10.c cVar2 = this.A;
        int iHashCode27 = (iHashCode26 + (cVar2 == null ? 0 : cVar2.hashCode())) * 31;
        Boolean bool8 = this.B;
        int iHashCode28 = (iHashCode27 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
        n10.f fVar2 = this.C;
        int iHashCode29 = (iHashCode28 + (fVar2 == null ? 0 : fVar2.hashCode())) * 31;
        Integer num = this.D;
        int iHashCode30 = (iHashCode29 + (num == null ? 0 : num.hashCode())) * 31;
        String str5 = this.E;
        int iHashCode31 = (iHashCode30 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.F;
        int iHashCode32 = (iHashCode31 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List list2 = this.G;
        int iHashCode33 = (iHashCode32 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Boolean bool9 = this.H;
        int iHashCode34 = (iHashCode33 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
        x1 x1Var = this.I;
        int iHashCode35 = (iHashCode34 + (x1Var == null ? 0 : x1Var.hashCode())) * 31;
        Boolean bool10 = this.J;
        int iHashCode36 = (iHashCode35 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
        p0 p0Var = this.K;
        int iHashCode37 = (iHashCode36 + (p0Var == null ? 0 : p0Var.hashCode())) * 31;
        rw.f fVar3 = this.L;
        return iHashCode37 + (fVar3 != null ? fVar3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Post(id=");
        sb.append(this.a);
        sb.append(", isLiked=");
        sb.append(this.b);
        sb.append(", type=");
        sb.append(this.c);
        sb.append(", createdOn=");
        sb.append(this.d);
        sb.append(", creator=");
        sb.append(this.e);
        sb.append(", caption=");
        sb.append(this.f378f);
        sb.append(", counters=");
        sb.append(this.g);
        sb.append(", comments=");
        sb.append(this.h);
        sb.append(", revision=");
        sb.append(this.i);
        sb.append(", revisionId=");
        sb.append(this.f379j);
        sb.append(", video=");
        sb.append(this.k);
        sb.append(", image=");
        sb.append(this.l);
        sb.append(", link=");
        sb.append(this.m);
        sb.append(", track=");
        sb.append(this.n);
        sb.append(", linkEntity=");
        sb.append(this.o);
        sb.append(", canChangePinState=");
        sb.append(this.p);
        sb.append(", canEdit=");
        sb.append(this.q);
        sb.append(", isPinned=");
        sb.append(this.r);
        sb.append(", community=");
        sb.append(this.s);
        sb.append(", band=");
        sb.append(this.t);
        sb.append(", isExplicit=");
        sb.append(this.u);
        sb.append(", permissions=");
        sb.append(this.v);
        sb.append(", state=");
        s1.a.y(sb, this.w, ", backgroundId=", this.x, ", isCommentingAllowed=");
        sb.append(this.y);
        sb.append(", canDelete=");
        sb.append(this.z);
        sb.append(", poll=");
        sb.append(this.A);
        sb.append(", isBoosted=");
        sb.append(this.B);
        sb.append(", trackingEvents=");
        sb.append(this.C);
        sb.append(", trendingPostType=");
        sb.append(this.D);
        sb.append(", postCompositeId=");
        s1.a.y(sb, this.E, ", initiatorReaction=", this.F, ", reactions=");
        sb.append(this.G);
        sb.append(", isPostedAsBand=");
        sb.append(this.H);
        sb.append(", recommendationReason=");
        sb.append(this.I);
        sb.append(", isSensitive=");
        sb.append(this.J);
        sb.append(", creativeFormat=");
        sb.append(this.K);
        sb.append(", estimatedImpressions=");
        sb.append(this.L);
        sb.append(")");
        return sb.toString();
    }

    public d1(String str, Boolean bool, f2 f2Var, l lVar, m10.f fVar, String str2, h1 h1Var, List list, l1 l1Var, String str3, k1 k1Var, k kVar, n nVar, i0 i0Var, v0 v0Var, Boolean bool2, Boolean bool3, Boolean bool4, vu0.c cVar, n0 n0Var, Boolean bool5, p1 p1Var, String str4, String str5, Boolean bool6, Boolean bool7, s10.c cVar2, Boolean bool8, n10.f fVar2, Integer num, String str6, String str7, List list2, Boolean bool9, x1 x1Var, Boolean bool10, p0 p0Var, rw.f fVar3) {
        lmjxuqdtp.jvm.internal.o.h(str, "id");
        this.a = str;
        this.b = bool;
        this.c = f2Var;
        this.d = lVar;
        this.e = fVar;
        this.f378f = str2;
        this.g = h1Var;
        this.h = list;
        this.i = l1Var;
        this.f379j = str3;
        this.k = k1Var;
        this.l = kVar;
        this.m = nVar;
        this.n = i0Var;
        this.o = v0Var;
        this.p = bool2;
        this.q = bool3;
        this.r = bool4;
        this.s = cVar;
        this.t = n0Var;
        this.u = bool5;
        this.v = p1Var;
        this.w = str4;
        this.x = str5;
        this.y = bool6;
        this.z = bool7;
        this.A = cVar2;
        this.B = bool8;
        this.C = fVar2;
        this.D = num;
        this.E = str6;
        this.F = str7;
        this.G = list2;
        this.H = bool9;
        this.I = x1Var;
        this.J = bool10;
        this.K = p0Var;
        this.L = fVar3;
    }

    public /* synthetic */ d1(String str, m10.f fVar, n nVar, v0 v0Var, int i) {
        this((i & 1) != 0 ? "LOCAL_empty_post" : str, null, (i & 4) != 0 ? null : f2.f380f, null, (i & 16) != 0 ? null : fVar, null, null, null, null, null, null, null, (i & 4096) != 0 ? null : nVar, null, (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : v0Var, null, Boolean.FALSE, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }
}
