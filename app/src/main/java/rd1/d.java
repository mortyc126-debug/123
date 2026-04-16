package rd1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends s {
    public final ld1.r a;
    public final ld1.r b;
    public final ld1.r c;

    public d(ld1.r rVar, ld1.r rVar2, ld1.r rVar3) {
        lmjxuqdtp.jvm.internal.o.h(rVar, "labelColor");
        lmjxuqdtp.jvm.internal.o.h(rVar3, "backgroundColor");
        this.a = rVar;
        this.b = rVar2;
        this.c = rVar3;
    }

    @Override // rd1.s
    public final ld1.r a() {
        return this.c;
    }

    @Override // rd1.s
    public final ld1.r c() {
        return this.b;
    }

    @Override // rd1.s
    public final ld1.r d() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, dVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, dVar.b) && lmjxuqdtp.jvm.internal.o.c(this.c, dVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + com.gnacba.ads.interactivemedia.v3.internal.a.f(this.b, this.a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "Custom(labelColor=" + this.a + ", iconColor=" + this.b + ", backgroundColor=" + this.c + ")";
    }
}
