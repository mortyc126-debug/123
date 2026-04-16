package dh1;

import az1.b2;
import f3.f2;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.IntCompanionObject;
import m10.k1;
import m10.w0;
import n10.f;
import okhttp3.internal.http2.Http2;
import q10.j0;
import q10.l0;
import q10.s0;
import vu0.d;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@aj.a(deserializable = true, serializable = true)
public final class w implements d, o, q {
    public static final s Companion = new s();
    public static final lx1.h[] Q;
    public final boolean A;
    public final boolean B;
    public final boolean C;
    public final Boolean D;
    public final v E;
    public final String F;
    public final k1 G;
    public final String H;
    public final Map I;
    public final List J;
    public final Boolean K;
    public final f L;
    public final c M;
    public final boolean N;
    public final String O;
    public transient j0 P;
    public final String a;
    public final String b;
    public final String c;
    public final m10.j0 d;
    public final m10.j0 e;

    /* JADX INFO: renamed from: f */
    public final String f87f;
    public final String g;
    public final String h;
    public final String i;

    /* JADX INFO: renamed from: j */
    public final String f88j;
    public final k k;
    public final l0 l;
    public final l0 m;
    public final m10.n n;
    public final String o;
    public final boolean p;
    public final boolean q;
    public final String r;
    public final d0 s;
    public final boolean t;
    public final boolean u;
    public final List v;
    public final List w;
    public final List x;
    public final w0 y;
    public final boolean z;

    static {
        lx1.j jVar = lx1.j.a;
        Q = new lx1.h[]{null, null, null, null, null, null, null, null, null, null, hs1.d.E(jVar, new cl1.x(14)), hs1.d.E(jVar, new cl1.x(15)), hs1.d.E(jVar, new cl1.x(16)), hs1.d.E(jVar, new cl1.x(17)), null, null, null, null, null, null, null, hs1.d.E(jVar, new cl1.x(18)), hs1.d.E(jVar, new cl1.x(19)), hs1.d.E(jVar, new cl1.x(20)), null, null, null, null, null, null, null, null, null, null, hs1.d.E(jVar, new cl1.x(21)), hs1.d.E(jVar, new cl1.x(22)), null, null, null, null, null};
    }

    public /* synthetic */ w(int i, int i2, String str, String str2, String str3, m10.j0 j0Var, m10.j0 j0Var2, String str4, String str5, String str6, String str7, String str8, k kVar, l0 l0Var, l0 l0Var2, m10.n nVar, String str9, boolean z, boolean z2, String str10, d0 d0Var, boolean z3, boolean z4, List list, List list2, List list3, w0 w0Var, boolean z5, boolean z6, boolean z7, boolean z8, Boolean bool, v vVar, String str11, k1 k1Var, String str12, Map map, List list4, Boolean bool2, f fVar, c cVar, boolean z9, String str13) {
        if (3 != (i & 3)) {
            b2.a(new int[]{i, i2}, new int[]{3, 0}, r.a.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = str3;
        }
        if ((i & 8) == 0) {
            this.d = null;
        } else {
            this.d = j0Var;
        }
        if ((i & 16) == 0) {
            this.e = null;
        } else {
            this.e = j0Var2;
        }
        if ((i & 32) == 0) {
            this.f87f = null;
        } else {
            this.f87f = str4;
        }
        if ((i & 64) == 0) {
            this.g = null;
        } else {
            this.g = str5;
        }
        if ((i & 128) == 0) {
            this.h = null;
        } else {
            this.h = str6;
        }
        if ((i & 256) == 0) {
            this.i = null;
        } else {
            this.i = str7;
        }
        if ((i & 512) == 0) {
            this.f88j = null;
        } else {
            this.f88j = str8;
        }
        if ((i & 1024) == 0) {
            this.k = null;
        } else {
            this.k = kVar;
        }
        if ((i & 2048) == 0) {
            this.l = null;
        } else {
            this.l = l0Var;
        }
        if ((i & 4096) == 0) {
            this.m = null;
        } else {
            this.m = l0Var2;
        }
        if ((i & 8192) == 0) {
            this.n = null;
        } else {
            this.n = nVar;
        }
        if ((i & Http2.INITIAL_MAX_FRAME_SIZE) == 0) {
            this.o = null;
        } else {
            this.o = str9;
        }
        if ((32768 & i) == 0) {
            this.p = false;
        } else {
            this.p = z;
        }
        if ((65536 & i) == 0) {
            this.q = false;
        } else {
            this.q = z2;
        }
        if ((131072 & i) == 0) {
            this.r = null;
        } else {
            this.r = str10;
        }
        if ((262144 & i) == 0) {
            this.s = null;
        } else {
            this.s = d0Var;
        }
        if ((524288 & i) == 0) {
            this.t = false;
        } else {
            this.t = z3;
        }
        if ((1048576 & i) == 0) {
            this.u = false;
        } else {
            this.u = z4;
        }
        if ((2097152 & i) == 0) {
            this.v = null;
        } else {
            this.v = list;
        }
        if ((4194304 & i) == 0) {
            this.w = null;
        } else {
            this.w = list2;
        }
        if ((8388608 & i) == 0) {
            this.x = null;
        } else {
            this.x = list3;
        }
        if ((16777216 & i) == 0) {
            this.y = null;
        } else {
            this.y = w0Var;
        }
        if ((33554432 & i) == 0) {
            this.z = false;
        } else {
            this.z = z5;
        }
        if ((67108864 & i) == 0) {
            this.A = false;
        } else {
            this.A = z6;
        }
        if ((134217728 & i) == 0) {
            this.B = false;
        } else {
            this.B = z7;
        }
        if ((268435456 & i) == 0) {
            this.C = false;
        } else {
            this.C = z8;
        }
        if ((536870912 & i) == 0) {
            this.D = null;
        } else {
            this.D = bool;
        }
        if ((1073741824 & i) == 0) {
            this.E = null;
        } else {
            this.E = vVar;
        }
        if ((i & IntCompanionObject.MIN_VALUE) == 0) {
            this.F = null;
        } else {
            this.F = str11;
        }
        if ((i2 & 1) == 0) {
            this.G = null;
        } else {
            this.G = k1Var;
        }
        if ((i2 & 2) == 0) {
            this.H = null;
        } else {
            this.H = str12;
        }
        if ((i2 & 4) == 0) {
            this.I = null;
        } else {
            this.I = map;
        }
        if ((i2 & 8) == 0) {
            this.J = null;
        } else {
            this.J = list4;
        }
        if ((i2 & 16) == 0) {
            this.K = null;
        } else {
            this.K = bool2;
        }
        if ((i2 & 32) == 0) {
            this.L = null;
        } else {
            this.L = fVar;
        }
        if ((i2 & 64) == 0) {
            this.M = null;
        } else {
            this.M = cVar;
        }
        if ((i2 & 128) == 0) {
            this.N = false;
        } else {
            this.N = z9;
        }
        if ((i2 & 256) == 0) {
            this.O = null;
        } else {
            this.O = str13;
        }
        this.P = null;
    }

    public static w z(w wVar, f fVar, int i, int i2) {
        Boolean bool = Boolean.TRUE;
        String str = (i & 1) != 0 ? wVar.a : "NON_INITIALIZED_USER";
        String str2 = wVar.b;
        String str3 = wVar.c;
        m10.j0 j0Var = wVar.d;
        m10.j0 j0Var2 = wVar.e;
        String str4 = wVar.f87f;
        String str5 = wVar.g;
        String str6 = wVar.h;
        String str7 = wVar.i;
        String str8 = wVar.f88j;
        k kVar = wVar.k;
        l0 l0Var = wVar.l;
        l0 l0Var2 = wVar.m;
        m10.n nVar = wVar.n;
        String str9 = wVar.o;
        boolean z = wVar.p;
        boolean z2 = wVar.q;
        String str10 = wVar.r;
        d0 d0Var = wVar.s;
        boolean z3 = wVar.t;
        boolean z4 = (i & 1048576) != 0 ? wVar.u : true;
        List list = wVar.v;
        List list2 = wVar.w;
        List list3 = wVar.x;
        w0 w0Var = wVar.y;
        boolean z5 = wVar.z;
        boolean z6 = wVar.A;
        boolean z7 = wVar.B;
        boolean z8 = wVar.C;
        Boolean bool2 = wVar.D;
        v vVar = wVar.E;
        String str11 = wVar.F;
        k1 k1Var = wVar.G;
        String str12 = (i2 & 2) != 0 ? wVar.H : null;
        Map map = wVar.I;
        List list4 = wVar.J;
        Boolean bool3 = (i2 & 16) != 0 ? wVar.K : bool;
        f fVar2 = (i2 & 32) != 0 ? wVar.L : fVar;
        c cVar = wVar.M;
        boolean z9 = wVar.N;
        String str13 = wVar.O;
        wVar.getClass();
        lmjxuqdtp.jvm.internal.o.h(str, "id");
        return new w(str, str2, str3, j0Var, j0Var2, str4, str5, str6, str7, str8, kVar, l0Var, l0Var2, nVar, str9, z, z2, str10, d0Var, z3, z4, list, list2, list3, w0Var, z5, z6, z7, z8, bool2, vVar, str11, k1Var, str12, map, list4, bool3, fVar2, cVar, z9, str13);
    }

    public final j0 G() {
        j0 j0Var = this.P;
        if (j0Var != null) {
            return j0Var;
        }
        j0 j0Var2 = new j0(new s0(this.a), this.l, this.D);
        this.P = j0Var2;
        return j0Var2;
    }

    public final String Z() {
        return f2.k("@", this.b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, wVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, wVar.b) && lmjxuqdtp.jvm.internal.o.c(this.c, wVar.c) && lmjxuqdtp.jvm.internal.o.c(this.d, wVar.d) && lmjxuqdtp.jvm.internal.o.c(this.e, wVar.e) && lmjxuqdtp.jvm.internal.o.c(this.f87f, wVar.f87f) && lmjxuqdtp.jvm.internal.o.c(this.g, wVar.g) && lmjxuqdtp.jvm.internal.o.c(this.h, wVar.h) && lmjxuqdtp.jvm.internal.o.c(this.i, wVar.i) && lmjxuqdtp.jvm.internal.o.c(this.f88j, wVar.f88j) && this.k == wVar.k && this.l == wVar.l && this.m == wVar.m && this.n == wVar.n && lmjxuqdtp.jvm.internal.o.c(this.o, wVar.o) && this.p == wVar.p && this.q == wVar.q && lmjxuqdtp.jvm.internal.o.c(this.r, wVar.r) && lmjxuqdtp.jvm.internal.o.c(this.s, wVar.s) && this.t == wVar.t && this.u == wVar.u && lmjxuqdtp.jvm.internal.o.c(this.v, wVar.v) && lmjxuqdtp.jvm.internal.o.c(this.w, wVar.w) && lmjxuqdtp.jvm.internal.o.c(this.x, wVar.x) && lmjxuqdtp.jvm.internal.o.c(this.y, wVar.y) && this.z == wVar.z && this.A == wVar.A && this.B == wVar.B && this.C == wVar.C && lmjxuqdtp.jvm.internal.o.c(this.D, wVar.D) && lmjxuqdtp.jvm.internal.o.c(this.E, wVar.E) && lmjxuqdtp.jvm.internal.o.c(this.F, wVar.F) && lmjxuqdtp.jvm.internal.o.c(this.G, wVar.G) && lmjxuqdtp.jvm.internal.o.c(this.H, wVar.H) && lmjxuqdtp.jvm.internal.o.c(this.I, wVar.I) && lmjxuqdtp.jvm.internal.o.c(this.J, wVar.J) && lmjxuqdtp.jvm.internal.o.c(this.K, wVar.K) && lmjxuqdtp.jvm.internal.o.c(this.L, wVar.L) && lmjxuqdtp.jvm.internal.o.c(this.M, wVar.M) && this.N == wVar.N && lmjxuqdtp.jvm.internal.o.c(this.O, wVar.O);
    }

    public final String getId() {
        return this.a;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        m10.j0 j0Var = this.d;
        int iHashCode4 = (iHashCode3 + (j0Var == null ? 0 : j0Var.hashCode())) * 31;
        m10.j0 j0Var2 = this.e;
        int iHashCode5 = (iHashCode4 + (j0Var2 == null ? 0 : j0Var2.hashCode())) * 31;
        String str3 = this.f87f;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.g;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.h;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.i;
        int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f88j;
        int iHashCode10 = (iHashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        k kVar = this.k;
        int iHashCode11 = (iHashCode10 + (kVar == null ? 0 : kVar.hashCode())) * 31;
        l0 l0Var = this.l;
        int iHashCode12 = (iHashCode11 + (l0Var == null ? 0 : l0Var.hashCode())) * 31;
        l0 l0Var2 = this.m;
        int iHashCode13 = (iHashCode12 + (l0Var2 == null ? 0 : l0Var2.hashCode())) * 31;
        m10.n nVar = this.n;
        int iHashCode14 = (iHashCode13 + (nVar == null ? 0 : nVar.hashCode())) * 31;
        String str8 = this.o;
        int iF = s1.a.f(s1.a.f((iHashCode14 + (str8 == null ? 0 : str8.hashCode())) * 31, 31, this.p), 31, this.q);
        String str9 = this.r;
        int iHashCode15 = (iF + (str9 == null ? 0 : str9.hashCode())) * 31;
        d0 d0Var = this.s;
        int iF2 = s1.a.f(s1.a.f((iHashCode15 + (d0Var == null ? 0 : d0Var.hashCode())) * 31, 31, this.t), 31, this.u);
        List list = this.v;
        int iHashCode16 = (iF2 + (list == null ? 0 : list.hashCode())) * 31;
        List list2 = this.w;
        int iHashCode17 = (iHashCode16 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List list3 = this.x;
        int iHashCode18 = (iHashCode17 + (list3 == null ? 0 : list3.hashCode())) * 31;
        w0 w0Var = this.y;
        int iF3 = s1.a.f(s1.a.f(s1.a.f(s1.a.f((iHashCode18 + (w0Var == null ? 0 : w0Var.hashCode())) * 31, 31, this.z), 31, this.A), 31, this.B), 31, this.C);
        Boolean bool = this.D;
        int iHashCode19 = (iF3 + (bool == null ? 0 : bool.hashCode())) * 31;
        v vVar = this.E;
        int iHashCode20 = (iHashCode19 + (vVar == null ? 0 : vVar.hashCode())) * 31;
        String str10 = this.F;
        int iHashCode21 = (iHashCode20 + (str10 == null ? 0 : str10.hashCode())) * 31;
        k1 k1Var = this.G;
        int iHashCode22 = (iHashCode21 + (k1Var == null ? 0 : k1Var.hashCode())) * 31;
        String str11 = this.H;
        int iHashCode23 = (iHashCode22 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Map map = this.I;
        int iHashCode24 = (iHashCode23 + (map == null ? 0 : map.hashCode())) * 31;
        List list4 = this.J;
        int iHashCode25 = (iHashCode24 + (list4 == null ? 0 : list4.hashCode())) * 31;
        Boolean bool2 = this.K;
        int iHashCode26 = (iHashCode25 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        f fVar = this.L;
        int iHashCode27 = (iHashCode26 + (fVar == null ? 0 : fVar.hashCode())) * 31;
        c cVar = this.M;
        int iF4 = s1.a.f((iHashCode27 + (cVar == null ? 0 : cVar.hashCode())) * 31, 31, this.N);
        String str12 = this.O;
        return iF4 + (str12 != null ? str12.hashCode() : 0);
    }

    @Override // dh1.q
    public final String i0() {
        return this.r;
    }

    public final String toString() {
        StringBuilder sbJ = p.j("User(id=", this.a, ", username=", this.b, ", name=");
        sbJ.append(this.c);
        sbJ.append(", picture=");
        sbJ.append(this.d);
        sbJ.append(", backgroundPicture=");
        sbJ.append(this.e);
        sbJ.append(", backgroundPictureId=");
        sbJ.append(this.f87f);
        sbJ.append(", conversationId=");
        s1.a.y(sbJ, this.g, ", about=", this.h, ", email=");
        s1.a.y(sbJ, this.i, ", birthday=", this.f88j, ", gender=");
        sbJ.append(this.k);
        sbJ.append(", followingState=");
        sbJ.append(this.l);
        sbJ.append(", followingMeState=");
        sbJ.append(this.m);
        sbJ.append(", collaborationStatus=");
        sbJ.append(this.n);
        sbJ.append(", followRequestedOn=");
        o6.c.z(this.o, ", isSubscriber=", ", isBetaUser=", sbJ, this.p);
        bh.j.y(", role=", this.r, ", counters=", sbJ, this.q);
        sbJ.append(this.s);
        sbJ.append(", isEmailConfirmed=");
        sbJ.append(this.t);
        sbJ.append(", hasPassword=");
        sbJ.append(this.u);
        sbJ.append(", skills=");
        sbJ.append(this.v);
        sbJ.append(", genres=");
        o6.c.B(sbJ, this.w, ", badges=", this.x, ", place=");
        sbJ.append(this.y);
        sbJ.append(", isVerified=");
        sbJ.append(this.z);
        sbJ.append(", isTippable=");
        o6.c.C(sbJ, this.A, ", isBlocked=", this.B, ", isBlockingMe=");
        sbJ.append(this.C);
        sbJ.append(", isPrivate=");
        sbJ.append(this.D);
        sbJ.append(", permissions=");
        sbJ.append(this.E);
        sbJ.append(", createdOn=");
        sbJ.append(this.F);
        sbJ.append(", introVideo=");
        sbJ.append(this.G);
        sbJ.append(", phone=");
        sbJ.append(this.H);
        sbJ.append(", links=");
        sbJ.append(this.I);
        sbJ.append(", inspiredBy=");
        sbJ.append(this.J);
        sbJ.append(", isBoosted=");
        sbJ.append(this.K);
        sbJ.append(", trackingEvents=");
        sbJ.append(this.L);
        sbJ.append(", lookingFor=");
        sbJ.append(this.M);
        sbJ.append(", isSocial=");
        sbJ.append(this.N);
        sbJ.append(", language=");
        return i.p(sbJ, this.O, ")");
    }

    @Override // dh1.o
    public final String y() {
        return this.b;
    }

    public w(String str, String str2, String str3, m10.j0 j0Var, m10.j0 j0Var2, String str4, String str5, String str6, String str7, String str8, k kVar, l0 l0Var, l0 l0Var2, m10.n nVar, String str9, boolean z, boolean z2, String str10, d0 d0Var, boolean z3, boolean z4, List list, List list2, List list3, w0 w0Var, boolean z5, boolean z6, boolean z7, boolean z8, Boolean bool, v vVar, String str11, k1 k1Var, String str12, Map map, List list4, Boolean bool2, f fVar, c cVar, boolean z9, String str13) {
        lmjxuqdtp.jvm.internal.o.h(str, "id");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = j0Var;
        this.e = j0Var2;
        this.f87f = str4;
        this.g = str5;
        this.h = str6;
        this.i = str7;
        this.f88j = str8;
        this.k = kVar;
        this.l = l0Var;
        this.m = l0Var2;
        this.n = nVar;
        this.o = str9;
        this.p = z;
        this.q = z2;
        this.r = str10;
        this.s = d0Var;
        this.t = z3;
        this.u = z4;
        this.v = list;
        this.w = list2;
        this.x = list3;
        this.y = w0Var;
        this.z = z5;
        this.A = z6;
        this.B = z7;
        this.C = z8;
        this.D = bool;
        this.E = vVar;
        this.F = str11;
        this.G = k1Var;
        this.H = str12;
        this.I = map;
        this.J = list4;
        this.K = bool2;
        this.L = fVar;
        this.M = cVar;
        this.N = z9;
        this.O = str13;
    }

    public /* synthetic */ w(String str, String str2, String str3, m10.j0 j0Var, String str4, l0 l0Var, List list, List list2, boolean z, boolean z2, Boolean bool, Map map, int i, int i2) {
        this(str, str2, str3, (i & 8) != 0 ? null : j0Var, null, null, null, (i & 128) != 0 ? null : str4, null, null, null, (i & 2048) != 0 ? null : l0Var, null, null, null, false, false, null, null, false, false, (2097152 & i) != 0 ? null : list, (4194304 & i) != 0 ? null : list2, null, null, (33554432 & i) != 0 ? false : z, (67108864 & i) != 0 ? false : z2, false, false, (i & 536870912) != 0 ? null : bool, null, null, null, null, (i2 & 4) != 0 ? null : map, null, null, null, null, false, null);
    }
}
