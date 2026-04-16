package cf1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements t {
    public final k a;
    public final r b;
    public final o c;

    public i(k kVar, r rVar, o oVar) {
        lmjxuqdtp.jvm.internal.o.h(kVar, "thumbScheme");
        this.a = kVar;
        this.b = rVar;
        this.c = oVar;
    }

    @Override // cf1.t
    public final k a() {
        return this.a;
    }

    @Override // cf1.t
    public final q b() {
        return this.b;
    }

    @Override // cf1.t
    public final n c() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, iVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, iVar.b) && lmjxuqdtp.jvm.internal.o.c(this.c, iVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "Custom(thumbScheme=" + this.a + ", trackScheme=" + this.b + ", tickScheme=" + this.c + ")";
    }

    public i(l lVar, r rVar, int i) {
        this((i & 1) != 0 ? new l(null, null, null, 7) : lVar, rVar, new o(p.b, p.c, p.d, p.e));
    }
}
