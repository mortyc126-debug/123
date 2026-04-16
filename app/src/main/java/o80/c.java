package o80;

import dg1.f;
import f3.f2;
import x10.l;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final l a;
    public final f b;
    public final boolean c;

    public c(l lVar, f fVar, boolean z) {
        this.a = lVar;
        this.b = fVar;
        this.c = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.a.equals(cVar.a) && this.b.equals(cVar.b) && this.c == cVar.c;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.c) + ((this.b.hashCode() + (this.a.e.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BoostedProfileTag(label=");
        sb.append(this.a);
        sb.append(", icon=");
        sb.append(this.b);
        sb.append(", isArtist=");
        return f2.o(sb, this.c, ")");
    }
}
