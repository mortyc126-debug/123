package du0;

import dg1.i;
import ju0.a;
import ju0.b;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public final h a;
    public final i b;
    public final a c;
    public final b d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f95f;

    public g(h hVar, i iVar, a aVar, b bVar, boolean z, e eVar) {
        o.h(iVar, "keyboardIcon");
        o.h(aVar, "fxState");
        this.a = hVar;
        this.b = iVar;
        this.c = aVar;
        this.d = bVar;
        this.e = z;
        this.f95f = eVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.a == gVar.a && o.c(this.b, gVar.b) && o.c(this.c, gVar.c) && this.d == gVar.d && this.e == gVar.e && o.c(this.f95f, gVar.f95f);
    }

    public final int hashCode() {
        h hVar = this.a;
        int iHashCode = (this.c.hashCode() + ((this.b.hashCode() + ((hVar == null ? 0 : hVar.hashCode()) * 31)) * 31)) * 31;
        b bVar = this.d;
        int iF = s1.a.f((iHashCode + (bVar == null ? 0 : bVar.hashCode())) * 31, 31, this.e);
        e eVar = this.f95f;
        return iF + (eVar != null ? eVar.hashCode() : 0);
    }

    public final String toString() {
        return "State(tab=" + this.a + ", keyboardIcon=" + this.b + ", fxState=" + this.c + ", params=" + this.d + ", editMidiEnabled=" + this.e + ", keyboardOption=" + this.f95f + ")";
    }
}
