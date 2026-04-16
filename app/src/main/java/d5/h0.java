package d5;

import a4.z0;
import h5.p;
import o5.n;
import p5.q;
import q.q2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 implements b {
    public final o5.o a;
    public final long b;
    public final h5.s c;
    public final h5.o d;
    public final p e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h5.i f70f;
    public final String g;
    public final long h;
    public final o5.a i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final o5.p f71j;
    public final k5.b k;
    public final long l;
    public final o5.l m;
    public final z0 n;
    public final a0 o;
    public final c4.e p;

    public h0(long j2, long j3, h5.s sVar, h5.o oVar, p pVar, h5.i iVar, String str, long j4, o5.a aVar, o5.p pVar2, k5.b bVar, long j5, o5.l lVar, z0 z0Var, a0 a0Var) {
        this(j2 != 16 ? new o5.c(j2) : n.a, j3, sVar, oVar, pVar, iVar, str, j4, aVar, pVar2, bVar, j5, lVar, z0Var, a0Var, null);
    }

    public static h0 a(h0 h0Var, long j2, int i) {
        long jB = (i & 1) != 0 ? h0Var.a.b() : j2;
        long j3 = h0Var.b;
        h5.s sVar = h0Var.c;
        h5.o oVar = h0Var.d;
        p pVar = h0Var.e;
        h5.i iVar = (i & 32) != 0 ? h0Var.f70f : null;
        String str = h0Var.g;
        long j4 = h0Var.h;
        o5.a aVar = h0Var.i;
        o5.p pVar2 = h0Var.f71j;
        k5.b bVar = h0Var.k;
        long j5 = h0Var.l;
        o5.l lVar = h0Var.m;
        z0 z0Var = h0Var.n;
        a0 a0Var = h0Var.o;
        c4.e eVar = h0Var.p;
        o5.o cVar = h0Var.a;
        if (!a4.y.c(jB, cVar.b())) {
            cVar = jB != 16 ? new o5.c(jB) : n.a;
        }
        return new h0(cVar, j3, sVar, oVar, pVar, iVar, str, j4, aVar, pVar2, bVar, j5, lVar, z0Var, a0Var, eVar);
    }

    public final boolean b(h0 h0Var) {
        if (this == h0Var) {
            return true;
        }
        return p5.p.a(this.b, h0Var.b) && lmjxuqdtp.jvm.internal.o.c(this.c, h0Var.c) && lmjxuqdtp.jvm.internal.o.c(this.d, h0Var.d) && lmjxuqdtp.jvm.internal.o.c(this.e, h0Var.e) && lmjxuqdtp.jvm.internal.o.c(this.f70f, h0Var.f70f) && lmjxuqdtp.jvm.internal.o.c(this.g, h0Var.g) && p5.p.a(this.h, h0Var.h) && lmjxuqdtp.jvm.internal.o.c(this.i, h0Var.i) && lmjxuqdtp.jvm.internal.o.c(this.f71j, h0Var.f71j) && lmjxuqdtp.jvm.internal.o.c(this.k, h0Var.k) && a4.y.c(this.l, h0Var.l) && lmjxuqdtp.jvm.internal.o.c(this.o, h0Var.o);
    }

    public final boolean c(h0 h0Var) {
        return lmjxuqdtp.jvm.internal.o.c(this.a, h0Var.a) && lmjxuqdtp.jvm.internal.o.c(this.m, h0Var.m) && lmjxuqdtp.jvm.internal.o.c(this.n, h0Var.n) && lmjxuqdtp.jvm.internal.o.c(this.p, h0Var.p);
    }

    public final h0 d(h0 h0Var) {
        if (h0Var == null) {
            return this;
        }
        o5.o oVar = h0Var.a;
        return i0.a(this, oVar.b(), oVar.c(), oVar.a(), h0Var.b, h0Var.c, h0Var.d, h0Var.e, h0Var.f70f, h0Var.g, h0Var.h, h0Var.i, h0Var.f71j, h0Var.k, h0Var.l, h0Var.m, h0Var.n, h0Var.o, h0Var.p);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return b(h0Var) && c(h0Var);
    }

    public final int hashCode() {
        o5.o oVar = this.a;
        long jB = oVar.b();
        int i = a4.y.i;
        int iHashCode = Long.hashCode(jB) * 31;
        a4.u uVarC = oVar.c();
        int iHashCode2 = (Float.hashCode(oVar.a()) + ((iHashCode + (uVarC != null ? uVarC.hashCode() : 0)) * 31)) * 31;
        q[] qVarArr = p5.p.b;
        int iG = s1.a.g(iHashCode2, this.b, 31);
        h5.s sVar = this.c;
        int i2 = (iG + (sVar != null ? sVar.a : 0)) * 31;
        h5.o oVar2 = this.d;
        int iHashCode3 = (i2 + (oVar2 != null ? Integer.hashCode(oVar2.a) : 0)) * 31;
        p pVar = this.e;
        int iHashCode4 = (iHashCode3 + (pVar != null ? Integer.hashCode(pVar.a) : 0)) * 31;
        h5.i iVar = this.f70f;
        int iHashCode5 = (iHashCode4 + (iVar != null ? iVar.hashCode() : 0)) * 31;
        String str = this.g;
        int iG2 = s1.a.g((iHashCode5 + (str != null ? str.hashCode() : 0)) * 31, this.h, 31);
        o5.a aVar = this.i;
        int iHashCode6 = (iG2 + (aVar != null ? Float.hashCode(aVar.a) : 0)) * 31;
        o5.p pVar2 = this.f71j;
        int iHashCode7 = (iHashCode6 + (pVar2 != null ? pVar2.hashCode() : 0)) * 31;
        k5.b bVar = this.k;
        int iG3 = s1.a.g((iHashCode7 + (bVar != null ? bVar.a.hashCode() : 0)) * 31, this.l, 31);
        o5.l lVar = this.m;
        int i3 = (iG3 + (lVar != null ? lVar.a : 0)) * 31;
        z0 z0Var = this.n;
        int iHashCode8 = (i3 + (z0Var != null ? z0Var.hashCode() : 0)) * 31;
        a0 a0Var = this.o;
        int iHashCode9 = (iHashCode8 + (a0Var != null ? a0Var.hashCode() : 0)) * 31;
        c4.e eVar = this.p;
        return iHashCode9 + (eVar != null ? eVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SpanStyle(color=");
        o5.o oVar = this.a;
        sb.append((Object) a4.y.i(oVar.b()));
        sb.append(", brush=");
        sb.append(oVar.c());
        sb.append(", alpha=");
        sb.append(oVar.a());
        sb.append(", fontSize=");
        sb.append((Object) p5.p.e(this.b));
        sb.append(", fontWeight=");
        sb.append(this.c);
        sb.append(", fontStyle=");
        sb.append(this.d);
        sb.append(", fontSynthesis=");
        sb.append(this.e);
        sb.append(", fontFamily=");
        sb.append(this.f70f);
        sb.append(", fontFeatureSettings=");
        sb.append(this.g);
        sb.append(", letterSpacing=");
        sb.append((Object) p5.p.e(this.h));
        sb.append(", baselineShift=");
        sb.append(this.i);
        sb.append(", textGeometricTransform=");
        sb.append(this.f71j);
        sb.append(", localeList=");
        sb.append(this.k);
        sb.append(", background=");
        q2.s(this.l, ", textDecoration=", sb);
        sb.append(this.m);
        sb.append(", shadow=");
        sb.append(this.n);
        sb.append(", platformStyle=");
        sb.append(this.o);
        sb.append(", drawStyle=");
        sb.append(this.p);
        sb.append(')');
        return sb.toString();
    }

    public h0(o5.o oVar, long j2, h5.s sVar, h5.o oVar2, p pVar, h5.i iVar, String str, long j3, o5.a aVar, o5.p pVar2, k5.b bVar, long j4, o5.l lVar, z0 z0Var, a0 a0Var, c4.e eVar) {
        this.a = oVar;
        this.b = j2;
        this.c = sVar;
        this.d = oVar2;
        this.e = pVar;
        this.f70f = iVar;
        this.g = str;
        this.h = j3;
        this.i = aVar;
        this.f71j = pVar2;
        this.k = bVar;
        this.l = j4;
        this.m = lVar;
        this.n = z0Var;
        this.o = a0Var;
        this.p = eVar;
    }

    public h0(long j2, long j3, h5.s sVar, h5.o oVar, p pVar, h5.i iVar, String str, long j4, o5.a aVar, o5.p pVar2, k5.b bVar, long j5, o5.l lVar, z0 z0Var, int i) {
        this((i & 1) != 0 ? a4.y.h : j2, (i & 2) != 0 ? p5.p.c : j3, (i & 4) != 0 ? null : sVar, (i & 8) != 0 ? null : oVar, (i & 16) != 0 ? null : pVar, (i & 32) != 0 ? null : iVar, (i & 64) != 0 ? null : str, (i & 128) != 0 ? p5.p.c : j4, (i & 256) != 0 ? null : aVar, (i & 512) != 0 ? null : pVar2, (i & 1024) != 0 ? null : bVar, (i & 2048) != 0 ? a4.y.h : j5, (i & 4096) != 0 ? null : lVar, (i & 8192) != 0 ? null : z0Var, (a0) null);
    }
}
