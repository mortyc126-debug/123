package wk;

import f3.f2;
import ny1.p2;
import q.q2;
import y11.o4;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements o, f {
    public final boolean a;
    public final boolean b;
    public final p2 c;
    public final lx1.l d;
    public final ok1.i e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ok1.i f660f;
    public final double g;
    public final double h;
    public final o4 i;

    public e(boolean z, boolean z2, p2 p2Var, lx1.l lVar, ok1.i iVar, ok1.i iVar2, double d, double d3, o4 o4Var) {
        lmjxuqdtp.jvm.internal.o.h(p2Var, "playPosition");
        this.a = z;
        this.b = z2;
        this.c = p2Var;
        this.d = lVar;
        this.e = iVar;
        this.f660f = iVar2;
        this.g = d;
        this.h = d3;
        this.i = o4Var;
    }

    public static e c(e eVar, boolean z, boolean z2, ok1.i iVar, int i) {
        if ((i & 1) != 0) {
            z = eVar.a;
        }
        boolean z3 = z;
        boolean z4 = (i & 2) != 0 ? eVar.b : z2;
        p2 p2Var = eVar.c;
        lx1.l lVar = eVar.d;
        ok1.i iVar2 = eVar.e;
        ok1.i iVar3 = (i & 32) != 0 ? eVar.f660f : iVar;
        double d = eVar.g;
        double d3 = eVar.h;
        o4 o4Var = eVar.i;
        lmjxuqdtp.jvm.internal.o.h(p2Var, "playPosition");
        return new e(z3, z4, p2Var, lVar, iVar2, iVar3, d, d3, o4Var);
    }

    @Override // wk.o
    public final p2 a() {
        return this.c;
    }

    @Override // wk.o
    public final lx1.l b() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.a == eVar.a && this.b == eVar.b && lmjxuqdtp.jvm.internal.o.c(this.c, eVar.c) && this.d.equals(eVar.d) && this.e.equals(eVar.e) && lmjxuqdtp.jvm.internal.o.c(this.f660f, eVar.f660f) && hg1.a.a(this.g, eVar.g) && hg1.a.a(this.h, eVar.h) && this.i == eVar.i;
    }

    public final int hashCode() {
        int iHashCode = (this.e.hashCode() + ((this.d.hashCode() + q2.h(this.c, s1.a.f(Boolean.hashCode(this.a) * 31, 31, this.b), 31)) * 31)) * 31;
        ok1.i iVar = this.f660f;
        return this.i.hashCode() + ((hg1.a.b(this.h) + ((hg1.a.b(this.g) + ((iHashCode + (iVar == null ? 0 : iVar.hashCode())) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String strC = hg1.a.c(this.g);
        String strC2 = hg1.a.c(this.h);
        StringBuilder sbR = f2.r("Ready(isPlaying=", ", isProjectMuted=", ", playPosition=", this.a, this.b);
        sbR.append(this.c);
        sbR.append(", playRange=");
        sbR.append(this.d);
        sbR.append(", originalMidiInfo=");
        sbR.append(this.e);
        sbR.append(", extendedMidiInfo=");
        sbR.append(this.f660f);
        sbR.append(", originalBars=");
        s1.a.y(sbR, strC, ", extendedBars=", strC2, ", trackColor=");
        sbR.append(this.i);
        sbR.append(")");
        return sbR.toString();
    }
}
