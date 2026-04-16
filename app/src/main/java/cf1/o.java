package cf1;

import com.gnacba.ads.interactivemedia.v3.internal.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements n {
    public final ld1.r a;
    public final ld1.r b;
    public final ld1.r c;
    public final ld1.r d;

    public o(ld1.r rVar, ld1.r rVar2, ld1.r rVar3, ld1.r rVar4) {
        lmjxuqdtp.jvm.internal.o.h(rVar, "activeTickColor");
        lmjxuqdtp.jvm.internal.o.h(rVar2, "inactiveTickColor");
        lmjxuqdtp.jvm.internal.o.h(rVar3, "disabledActiveTickColor");
        lmjxuqdtp.jvm.internal.o.h(rVar4, "disabledInactiveTickColor");
        this.a = rVar;
        this.b = rVar2;
        this.c = rVar3;
        this.d = rVar4;
    }

    @Override // cf1.n
    public final ld1.r a() {
        return this.b;
    }

    @Override // cf1.n
    public final ld1.r b() {
        return this.d;
    }

    @Override // cf1.n
    public final ld1.r c() {
        return this.a;
    }

    @Override // cf1.n
    public final ld1.r d() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, oVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, oVar.b) && lmjxuqdtp.jvm.internal.o.c(this.c, oVar.c) && lmjxuqdtp.jvm.internal.o.c(this.d, oVar.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + a.f(this.c, a.f(this.b, this.a.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        return "TickCustom(activeTickColor=" + this.a + ", inactiveTickColor=" + this.b + ", disabledActiveTickColor=" + this.c + ", disabledInactiveTickColor=" + this.d + ")";
    }
}
