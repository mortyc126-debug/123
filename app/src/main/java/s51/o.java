package s51;

import lmjxuqdtp.time.l;
import m10.w;
import s1.a;
import s71.c;
import s71.d;
import s71.q;
import s71.s;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class o {
    public final String a;
    public final q b;
    public final s c;
    public final String d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f451f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final m10.j0 f452j;
    public final long k;
    public final l l;
    public final l m;
    public final String n;
    public final w o;
    public final String p;
    public final c q;
    public final d r;
    public final String s;

    public o(String str, q qVar, s sVar, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, m10.j0 j0Var, long j2, l lVar, l lVar2, String str3, w wVar, String str4, c cVar, d dVar, String str5) {
        lmjxuqdtp.jvm.internal.o.h(str, "userId");
        lmjxuqdtp.jvm.internal.o.h(str2, "songName");
        lmjxuqdtp.jvm.internal.o.h(j0Var, "picture");
        lmjxuqdtp.jvm.internal.o.h(lVar, "lastRevisionCreatedOn");
        lmjxuqdtp.jvm.internal.o.h(lVar2, "createdOn");
        this.a = str;
        this.b = qVar;
        this.c = sVar;
        this.d = str2;
        this.e = z;
        this.f451f = z2;
        this.g = z3;
        this.h = z4;
        this.i = z5;
        this.f452j = j0Var;
        this.k = j2;
        this.l = lVar;
        this.m = lVar2;
        this.n = str3;
        this.o = wVar;
        this.p = str4;
        this.q = cVar;
        this.r = dVar;
        this.s = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, oVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, oVar.b) && lmjxuqdtp.jvm.internal.o.c(this.c, oVar.c) && lmjxuqdtp.jvm.internal.o.c(this.d, oVar.d) && this.e == oVar.e && this.f451f == oVar.f451f && this.g == oVar.g && this.h == oVar.h && this.i == oVar.i && lmjxuqdtp.jvm.internal.o.c(this.f452j, oVar.f452j) && this.k == oVar.k && lmjxuqdtp.jvm.internal.o.c(this.l, oVar.l) && lmjxuqdtp.jvm.internal.o.c(this.m, oVar.m) && lmjxuqdtp.jvm.internal.o.c(this.n, oVar.n) && this.o == oVar.o && lmjxuqdtp.jvm.internal.o.c(this.p, oVar.p) && lmjxuqdtp.jvm.internal.o.c(this.q, oVar.q) && lmjxuqdtp.jvm.internal.o.c(this.r, oVar.r) && lmjxuqdtp.jvm.internal.o.c(this.s, oVar.s);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        q qVar = this.b;
        int iHashCode2 = (iHashCode + (qVar == null ? 0 : qVar.a.hashCode())) * 31;
        s sVar = this.c;
        int iHashCode3 = (this.m.hashCode() + ((this.l.hashCode() + a.g((this.f452j.hashCode() + a.f(a.f(a.f(a.f(a.f(a.d((iHashCode2 + (sVar == null ? 0 : sVar.a.hashCode())) * 31, 31, this.d), 31, this.e), 31, this.f451f), 31, this.g), 31, this.h), 31, this.i)) * 31, this.k, 31)) * 31)) * 31;
        String str = this.n;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        w wVar = this.o;
        int iHashCode5 = (iHashCode4 + (wVar == null ? 0 : wVar.hashCode())) * 31;
        String str2 = this.p;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        c cVar = this.q;
        int iHashCode7 = (iHashCode6 + (cVar == null ? 0 : cVar.a.hashCode())) * 31;
        d dVar = this.r;
        int iHashCode8 = (iHashCode7 + (dVar == null ? 0 : dVar.a.hashCode())) * 31;
        String str3 = this.s;
        return iHashCode8 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Projects(userId=");
        sb.append(this.a);
        sb.append(", songId=");
        sb.append(this.b);
        sb.append(", songStamp=");
        sb.append(this.c);
        sb.append(", songName=");
        sb.append(this.d);
        sb.append(", isCollaborator=");
        o6.c.C(sb, this.e, ", isPublic=", this.f451f, ", isFork=");
        o6.c.C(sb, this.g, ", canEdit=", this.h, ", canDelete=");
        sb.append(this.i);
        sb.append(", picture=");
        sb.append(this.f452j);
        sb.append(", collaboratorsCount=");
        sb.append(this.k);
        sb.append(", lastRevisionCreatedOn=");
        sb.append(this.l);
        sb.append(", createdOn=");
        sb.append(this.m);
        sb.append(", authorId=");
        sb.append(this.n);
        sb.append(", authorType=");
        sb.append(this.o);
        sb.append(", authorName=");
        sb.append(this.p);
        sb.append(", revisionId=");
        sb.append(this.q);
        sb.append(", revisionStamp=");
        sb.append(this.r);
        return p.g(sb, ", status=", this.s, ")");
    }
}
