package p30;

import q30.f;
import q30.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements vu0.d {
    public final o a;
    public final f b;

    public c(o oVar, f fVar) {
        this.a = oVar;
        this.b = fVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, cVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, cVar.b);
    }

    public final String getId() {
        return "shortcuts_help";
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.a.hashCode() * 31);
    }

    public final String toString() {
        return "FooterState(shortcuts=" + this.a + ", help=" + this.b + ")";
    }
}
