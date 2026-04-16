package v2;

import lmjxuqdtp.jvm.internal.o;
import m2.m1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements c {
    public final c a;
    public final c b;

    public a(c cVar, c cVar2) {
        this.a = cVar;
        this.b = cVar2;
    }

    @Override // v2.c
    public final void a(h hVar) {
        this.a.a(hVar);
        this.b.a(hVar);
    }

    @Override // v2.c
    public final void b(a5.k kVar) {
        this.a.b(kVar);
        this.b.b(kVar);
    }

    @Override // v2.c
    public final m1 c() {
        m1 m1VarC = this.b.c();
        c cVar = this.a;
        return m1VarC != null ? m1VarC.b(cVar.c()) : cVar.c();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return o.c(this.a, aVar.a) && o.c(this.b, aVar.b) && o.c(c(), aVar.c());
    }

    public final int hashCode() {
        int iHashCode = (this.b.hashCode() + (this.a.hashCode() * 31)) * 32;
        m1 m1VarC = c();
        return iHashCode + (m1VarC != null ? m1VarC.hashCode() : 0);
    }

    public final String toString() {
        return this.a + ".then(" + this.b + ')';
    }
}
