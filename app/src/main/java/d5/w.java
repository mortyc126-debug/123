package d5;

import o5.m;
import o5.q;
import p5.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class w implements b {
    public final int a;
    public final int b;
    public final long c;
    public final q d;
    public final z e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o5.i f77f;
    public final int g;
    public final int h;
    public final o5.s i;

    public w(int i, int i2, long j2, q qVar, z zVar, o5.i iVar, int i3, int i4, o5.s sVar) {
        this.a = i;
        this.b = i2;
        this.c = j2;
        this.d = qVar;
        this.e = zVar;
        this.f77f = iVar;
        this.g = i3;
        this.h = i4;
        this.i = sVar;
        if (p.a(j2, p.c) || p.c(j2) >= 0.0f) {
            return;
        }
        j5.a.c("lineHeight can't be negative (" + p.c(j2) + ')');
    }

    public final w a(w wVar) {
        return wVar == null ? this : x.a(this, wVar.a, wVar.b, wVar.c, wVar.d, wVar.e, wVar.f77f, wVar.g, wVar.h, wVar.i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.a == wVar.a && this.b == wVar.b && p.a(this.c, wVar.c) && lmjxuqdtp.jvm.internal.o.c(this.d, wVar.d) && lmjxuqdtp.jvm.internal.o.c(this.e, wVar.e) && lmjxuqdtp.jvm.internal.o.c(this.f77f, wVar.f77f) && this.g == wVar.g && this.h == wVar.h && lmjxuqdtp.jvm.internal.o.c(this.i, wVar.i);
    }

    public final int hashCode() {
        int iC = s1.a.c(this.b, Integer.hashCode(this.a) * 31, 31);
        p5.q[] qVarArr = p.b;
        int iG = s1.a.g(iC, this.c, 31);
        q qVar = this.d;
        int iHashCode = (iG + (qVar != null ? qVar.hashCode() : 0)) * 31;
        z zVar = this.e;
        int iHashCode2 = (iHashCode + (zVar != null ? zVar.hashCode() : 0)) * 31;
        o5.i iVar = this.f77f;
        int iC2 = s1.a.c(this.h, s1.a.c(this.g, (iHashCode2 + (iVar != null ? iVar.hashCode() : 0)) * 31, 31), 31);
        o5.s sVar = this.i;
        return iC2 + (sVar != null ? sVar.hashCode() : 0);
    }

    public final String toString() {
        return "ParagraphStyle(textAlign=" + ((Object) o5.k.a(this.a)) + ", textDirection=" + ((Object) m.a(this.b)) + ", lineHeight=" + ((Object) p.e(this.c)) + ", textIndent=" + this.d + ", platformStyle=" + this.e + ", lineHeightStyle=" + this.f77f + ", lineBreak=" + ((Object) o5.e.a(this.g)) + ", hyphens=" + ((Object) o5.d.a(this.h)) + ", textMotion=" + this.i + ')';
    }
}
