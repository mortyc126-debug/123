package jv0;

import java.util.List;
import okhttp3.internal.http2.Http2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@aj.a(deserializable = true, serializable = true)
public final class y {
    public static final x Companion = new x();
    public static final lx1.h[] p;
    public final d0 a;
    public final s b;
    public final b c;
    public final Boolean d;
    public final p e;

    /* JADX INFO: renamed from: f */
    public final String f251f;
    public final String g;
    public final String h;
    public final List i;

    /* JADX INFO: renamed from: j */
    public final String f252j;
    public final Boolean k;
    public final Double l;
    public final Double m;
    public final Boolean n;
    public final Boolean o;

    static {
        lx1.j jVar = lx1.j.a;
        p = new lx1.h[]{hs1.d.E(jVar, new jl1.a(17)), hs1.d.E(jVar, new jl1.a(18)), hs1.d.E(jVar, new jl1.a(19)), null, hs1.d.E(jVar, new jl1.a(20)), null, null, null, hs1.d.E(jVar, new jl1.a(21)), null, null, null, null, null, null};
    }

    public y() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f251f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.f252j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
    }

    public final boolean a() {
        d0 d0Var = this.a;
        return (d0Var == null || d0Var == d0.b) ? false : true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return this.a == yVar.a && this.b == yVar.b && this.c == yVar.c && lmjxuqdtp.jvm.internal.o.c(this.d, yVar.d) && this.e == yVar.e && lmjxuqdtp.jvm.internal.o.c(this.f251f, yVar.f251f) && lmjxuqdtp.jvm.internal.o.c(this.g, yVar.g) && lmjxuqdtp.jvm.internal.o.c(this.h, yVar.h) && lmjxuqdtp.jvm.internal.o.c(this.i, yVar.i) && lmjxuqdtp.jvm.internal.o.c(this.f252j, yVar.f252j) && lmjxuqdtp.jvm.internal.o.c(this.k, yVar.k) && lmjxuqdtp.jvm.internal.o.c(this.l, yVar.l) && lmjxuqdtp.jvm.internal.o.c(this.m, yVar.m) && lmjxuqdtp.jvm.internal.o.c(this.n, yVar.n) && lmjxuqdtp.jvm.internal.o.c(this.o, yVar.o);
    }

    public final int hashCode() {
        d0 d0Var = this.a;
        int iHashCode = (d0Var == null ? 0 : d0Var.hashCode()) * 31;
        s sVar = this.b;
        int iHashCode2 = (iHashCode + (sVar == null ? 0 : sVar.hashCode())) * 31;
        b bVar = this.c;
        int iHashCode3 = (iHashCode2 + (bVar == null ? 0 : bVar.hashCode())) * 31;
        Boolean bool = this.d;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        p pVar = this.e;
        int iHashCode5 = (iHashCode4 + (pVar == null ? 0 : pVar.hashCode())) * 31;
        String str = this.f251f;
        int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.g;
        int iHashCode7 = (iHashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.h;
        int iHashCode8 = (iHashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List list = this.i;
        int iHashCode9 = (iHashCode8 + (list == null ? 0 : list.hashCode())) * 31;
        String str4 = this.f252j;
        int iHashCode10 = (iHashCode9 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool2 = this.k;
        int iHashCode11 = (iHashCode10 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Double d = this.l;
        int iHashCode12 = (iHashCode11 + (d == null ? 0 : d.hashCode())) * 31;
        Double d3 = this.m;
        int iHashCode13 = (iHashCode12 + (d3 == null ? 0 : d3.hashCode())) * 31;
        Boolean bool3 = this.n;
        int iHashCode14 = (iHashCode13 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.o;
        return iHashCode14 + (bool4 != null ? bool4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MembershipStatus(plan=");
        sb.append(this.a);
        sb.append(", paymentProvider=");
        sb.append(this.b);
        sb.append(", billingIssue=");
        sb.append(this.c);
        sb.append(", isTrial=");
        sb.append(this.d);
        sb.append(", billingInterval=");
        sb.append(this.e);
        sb.append(", startedOn=");
        sb.append(this.f251f);
        sb.append(", expiresOn=");
        s1.a.y(sb, this.g, ", priceCurrency=", this.h, ", availableFeatures=");
        sb.append(this.i);
        sb.append(", canceledOn=");
        sb.append(this.f252j);
        sb.append(", isTrialAllowed=");
        sb.append(this.k);
        sb.append(", nextRenewalPrice=");
        sb.append(this.l);
        sb.append(", price=");
        sb.append(this.m);
        sb.append(", isCanceled=");
        sb.append(this.n);
        sb.append(", isTrialUsed=");
        sb.append(this.o);
        sb.append(")");
        return sb.toString();
    }

    public /* synthetic */ y(int i, d0 d0Var, s sVar, b bVar, Boolean bool, p pVar, String str, String str2, String str3, List list, String str4, Boolean bool2, Double d, Double d3, Boolean bool3, Boolean bool4) {
        if ((i & 1) == 0) {
            this.a = null;
        } else {
            this.a = d0Var;
        }
        if ((i & 2) == 0) {
            this.b = null;
        } else {
            this.b = sVar;
        }
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = bVar;
        }
        if ((i & 8) == 0) {
            this.d = null;
        } else {
            this.d = bool;
        }
        if ((i & 16) == 0) {
            this.e = null;
        } else {
            this.e = pVar;
        }
        if ((i & 32) == 0) {
            this.f251f = null;
        } else {
            this.f251f = str;
        }
        if ((i & 64) == 0) {
            this.g = null;
        } else {
            this.g = str2;
        }
        if ((i & 128) == 0) {
            this.h = null;
        } else {
            this.h = str3;
        }
        if ((i & 256) == 0) {
            this.i = null;
        } else {
            this.i = list;
        }
        if ((i & 512) == 0) {
            this.f252j = null;
        } else {
            this.f252j = str4;
        }
        if ((i & 1024) == 0) {
            this.k = null;
        } else {
            this.k = bool2;
        }
        if ((i & 2048) == 0) {
            this.l = null;
        } else {
            this.l = d;
        }
        if ((i & 4096) == 0) {
            this.m = null;
        } else {
            this.m = d3;
        }
        if ((i & 8192) == 0) {
            this.n = null;
        } else {
            this.n = bool3;
        }
        if ((i & Http2.INITIAL_MAX_FRAME_SIZE) == 0) {
            this.o = null;
        } else {
            this.o = bool4;
        }
    }
}
