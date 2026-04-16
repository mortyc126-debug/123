package wk;

import f3.f2;
import ny1.p2;
import q.q2;
import y11.o4;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements o, n {
    public final boolean a;
    public final boolean b;
    public final p2 c;
    public final lx1.l d;
    public final ok1.i e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ok1.i f661f;
    public final double g;
    public final o4 h;
    public final o4 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final k f662j;

    public l(boolean z, boolean z2, p2 p2Var, lx1.l lVar, ok1.i iVar, ok1.i iVar2, double d, o4 o4Var, o4 o4Var2, k kVar) {
        lmjxuqdtp.jvm.internal.o.h(p2Var, "playPosition");
        lmjxuqdtp.jvm.internal.o.h(o4Var2, "recomposedTrackColor");
        this.a = z;
        this.b = z2;
        this.c = p2Var;
        this.d = lVar;
        this.e = iVar;
        this.f661f = iVar2;
        this.g = d;
        this.h = o4Var;
        this.i = o4Var2;
        this.f662j = kVar;
    }

    public static l c(l lVar, boolean z, boolean z2, ok1.i iVar, k kVar, int i) {
        boolean z3 = (i & 1) != 0 ? lVar.a : z;
        boolean z4 = (i & 2) != 0 ? lVar.b : z2;
        p2 p2Var = lVar.c;
        lx1.l lVar2 = lVar.d;
        ok1.i iVar2 = lVar.e;
        ok1.i iVar3 = (i & 32) != 0 ? lVar.f661f : iVar;
        double d = lVar.g;
        o4 o4Var = lVar.h;
        o4 o4Var2 = lVar.i;
        k kVar2 = (i & 512) != 0 ? lVar.f662j : kVar;
        lmjxuqdtp.jvm.internal.o.h(p2Var, "playPosition");
        lmjxuqdtp.jvm.internal.o.h(o4Var2, "recomposedTrackColor");
        return new l(z3, z4, p2Var, lVar2, iVar2, iVar3, d, o4Var, o4Var2, kVar2);
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
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.a == lVar.a && this.b == lVar.b && lmjxuqdtp.jvm.internal.o.c(this.c, lVar.c) && this.d.equals(lVar.d) && this.e.equals(lVar.e) && lmjxuqdtp.jvm.internal.o.c(this.f661f, lVar.f661f) && hg1.a.a(this.g, lVar.g) && this.h == lVar.h && this.i == lVar.i && this.f662j == lVar.f662j;
    }

    public final int hashCode() {
        int iHashCode = (this.e.hashCode() + ((this.d.hashCode() + q2.h(this.c, s1.a.f(Boolean.hashCode(this.a) * 31, 31, this.b), 31)) * 31)) * 31;
        ok1.i iVar = this.f661f;
        return this.f662j.hashCode() + ((this.i.hashCode() + ((this.h.hashCode() + ((hg1.a.b(this.g) + ((iHashCode + (iVar == null ? 0 : iVar.hashCode())) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String strC = hg1.a.c(this.g);
        StringBuilder sbR = f2.r("Ready(isPlaying=", ", isProjectMuted=", ", playPosition=", this.a, this.b);
        sbR.append(this.c);
        sbR.append(", playRange=");
        sbR.append(this.d);
        sbR.append(", originalMidiInfo=");
        sbR.append(this.e);
        sbR.append(", recomposedMidiInfo=");
        sbR.append(this.f661f);
        sbR.append(", bars=");
        sbR.append(strC);
        sbR.append(", originalTrackColor=");
        sbR.append(this.h);
        sbR.append(", recomposedTrackColor=");
        sbR.append(this.i);
        sbR.append(", playingTrack=");
        sbR.append(this.f662j);
        sbR.append(")");
        return sbR.toString();
    }
}
