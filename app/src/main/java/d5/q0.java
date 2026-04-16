package d5;

import a4.z0;
import h5.p;
import kotlin.jvm.internal.IntCompanionObject;
import o5.m;
import o5.n;
import o5.q;
import q.q2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class q0 {
    public static final q0 d = new q0(0, 0, null, null, null, null, 0, null, 0, 0, 0, null, null, 16777215);
    public final h0 a;
    public final w b;
    public final b0 c;

    public q0(h0 h0Var, w wVar, b0 b0Var) {
        this.a = h0Var;
        this.b = wVar;
        this.c = b0Var;
    }

    public static q0 a(q0 q0Var, long j2, long j3, h5.s sVar, h5.o oVar, h5.i iVar, long j4, int i, long j5, b0 b0Var, o5.i iVar2, int i2) {
        long jB = (i2 & 1) != 0 ? q0Var.a.a.b() : j2;
        long j6 = (i2 & 2) != 0 ? q0Var.a.b : j3;
        h5.s sVar2 = (i2 & 4) != 0 ? q0Var.a.c : sVar;
        h5.o oVar2 = (i2 & 8) != 0 ? q0Var.a.d : oVar;
        h0 h0Var = q0Var.a;
        p pVar = h0Var.e;
        h5.i iVar3 = (i2 & 32) != 0 ? h0Var.f70f : iVar;
        String str = (i2 & 64) != 0 ? h0Var.g : null;
        long j7 = (i2 & 128) != 0 ? h0Var.h : j4;
        o5.a aVar = h0Var.i;
        o5.p pVar2 = h0Var.f71j;
        k5.b bVar = h0Var.k;
        long j8 = h0Var.l;
        o5.l lVar = (i2 & 4096) != 0 ? h0Var.m : o5.l.c;
        z0 z0Var = h0Var.n;
        c4.e eVar = h0Var.p;
        int i3 = (i2 & 32768) != 0 ? q0Var.b.a : i;
        w wVar = q0Var.b;
        int i4 = wVar.b;
        long j9 = (i2 & 131072) != 0 ? wVar.c : j5;
        q qVar = wVar.d;
        b0 b0Var2 = (i2 & 524288) != 0 ? q0Var.c : b0Var;
        return new q0(new h0(a4.y.c(jB, h0Var.a.b()) ? h0Var.a : jB != 16 ? new o5.c(jB) : n.a, j6, sVar2, oVar2, pVar, iVar3, str, j7, aVar, pVar2, bVar, j8, lVar, z0Var, b0Var2 != null ? b0Var2.a : null, eVar), new w(i3, i4, j9, qVar, b0Var2 != null ? b0Var2.b : null, (i2 & 1048576) != 0 ? wVar.f77f : iVar2, wVar.g, wVar.h, wVar.i), b0Var2);
    }

    public static q0 f(q0 q0Var, long j2, long j3, long j4, int i, long j5, int i2) {
        long j6 = (i2 & 1) != 0 ? a4.y.h : j2;
        long j7 = (i2 & 2) != 0 ? p5.p.c : j3;
        long j8 = (i2 & 128) != 0 ? p5.p.c : j4;
        long j9 = a4.y.h;
        int i3 = (32768 & i2) != 0 ? IntCompanionObject.MIN_VALUE : i;
        long j10 = (i2 & 131072) != 0 ? p5.p.c : j5;
        h0 h0VarA = i0.a(q0Var.a, j6, null, Float.NaN, j7, null, null, null, null, null, j8, null, null, null, j9, null, null, null, null);
        w wVarA = x.a(q0Var.b, i3, IntCompanionObject.MIN_VALUE, j10, null, null, null, 0, IntCompanionObject.MIN_VALUE, null);
        return (q0Var.a == h0VarA && q0Var.b == wVarA) ? q0Var : new q0(h0VarA, wVarA);
    }

    public final a4.u b() {
        return this.a.a.c();
    }

    public final long c() {
        return this.a.a.b();
    }

    public final boolean d(q0 q0Var) {
        if (this != q0Var) {
            return lmjxuqdtp.jvm.internal.o.c(this.b, q0Var.b) && this.a.b(q0Var.a);
        }
        return true;
    }

    public final q0 e(q0 q0Var) {
        return (q0Var == null || q0Var.equals(d)) ? this : new q0(this.a.d(q0Var.a), this.b.a(q0Var.b));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q0)) {
            return false;
        }
        q0 q0Var = (q0) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, q0Var.a) && lmjxuqdtp.jvm.internal.o.c(this.b, q0Var.b) && lmjxuqdtp.jvm.internal.o.c(this.c, q0Var.c);
    }

    public final int hashCode() {
        int iHashCode = (this.b.hashCode() + (this.a.hashCode() * 31)) * 31;
        b0 b0Var = this.c;
        return iHashCode + (b0Var != null ? b0Var.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TextStyle(color=");
        sb.append((Object) a4.y.i(c()));
        sb.append(", brush=");
        sb.append(b());
        sb.append(", alpha=");
        h0 h0Var = this.a;
        sb.append(h0Var.a.a());
        sb.append(", fontSize=");
        sb.append((Object) p5.p.e(h0Var.b));
        sb.append(", fontWeight=");
        sb.append(h0Var.c);
        sb.append(", fontStyle=");
        sb.append(h0Var.d);
        sb.append(", fontSynthesis=");
        sb.append(h0Var.e);
        sb.append(", fontFamily=");
        sb.append(h0Var.f70f);
        sb.append(", fontFeatureSettings=");
        sb.append(h0Var.g);
        sb.append(", letterSpacing=");
        sb.append((Object) p5.p.e(h0Var.h));
        sb.append(", baselineShift=");
        sb.append(h0Var.i);
        sb.append(", textGeometricTransform=");
        sb.append(h0Var.f71j);
        sb.append(", localeList=");
        sb.append(h0Var.k);
        sb.append(", background=");
        q2.s(h0Var.l, ", textDecoration=", sb);
        sb.append(h0Var.m);
        sb.append(", shadow=");
        sb.append(h0Var.n);
        sb.append(", drawStyle=");
        sb.append(h0Var.p);
        sb.append(", textAlign=");
        w wVar = this.b;
        sb.append((Object) o5.k.a(wVar.a));
        sb.append(", textDirection=");
        sb.append((Object) m.a(wVar.b));
        sb.append(", lineHeight=");
        sb.append((Object) p5.p.e(wVar.c));
        sb.append(", textIndent=");
        sb.append(wVar.d);
        sb.append(", platformStyle=");
        sb.append(this.c);
        sb.append(", lineHeightStyle=");
        sb.append(wVar.f77f);
        sb.append(", lineBreak=");
        sb.append((Object) o5.e.a(wVar.g));
        sb.append(", hyphens=");
        sb.append((Object) o5.d.a(wVar.h));
        sb.append(", textMotion=");
        sb.append(wVar.i);
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public q0(h0 h0Var, w wVar) {
        a0 a0Var = h0Var.o;
        z zVar = wVar.e;
        this(h0Var, wVar, (a0Var == null && zVar == null) ? null : new b0(a0Var, zVar));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public q0(long j2, long j3, h5.s sVar, h5.o oVar, h5.i iVar, String str, long j4, o5.l lVar, int i, int i2, long j5, b0 b0Var, o5.i iVar2, int i3) {
        long j6 = (i3 & 1) != 0 ? a4.y.h : j2;
        long j7 = (i3 & 2) != 0 ? p5.p.c : j3;
        h5.s sVar2 = (i3 & 4) != 0 ? null : sVar;
        h5.o oVar2 = (i3 & 8) != 0 ? null : oVar;
        h5.i iVar3 = (i3 & 32) != 0 ? null : iVar;
        String str2 = (i3 & 64) != 0 ? null : str;
        long j8 = (i3 & 128) != 0 ? p5.p.c : j4;
        long j9 = a4.y.h;
        o5.l lVar2 = (i3 & 4096) != 0 ? null : lVar;
        int i4 = (32768 & i3) != 0 ? Integer.MIN_VALUE : i;
        int i6 = (65536 & i3) != 0 ? Integer.MIN_VALUE : i2;
        long j10 = (131072 & i3) != 0 ? p5.p.c : j5;
        b0 b0Var2 = (524288 & i3) != 0 ? null : b0Var;
        o5.i iVar4 = (i3 & 1048576) != 0 ? null : iVar2;
        b0 b0Var3 = b0Var2;
        this(new h0(j6, j7, sVar2, oVar2, (p) null, iVar3, str2, j8, (o5.a) null, (o5.p) null, (k5.b) null, j9, lVar2, (z0) null, b0Var2 != null ? b0Var2.a : null), new w(i4, i6, j10, null, b0Var3 != null ? b0Var3.b : null, iVar4, 0, IntCompanionObject.MIN_VALUE, null), b0Var3);
    }
}
