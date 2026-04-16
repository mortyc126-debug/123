package cf1;

import com.gnacba.ads.interactivemedia.v3.internal.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements q {
    public final ld1.r a;
    public final ld1.r b;
    public final ld1.r c;
    public final ld1.r d;

    public r(ld1.r rVar, ld1.r rVar2, ld1.r rVar3, ld1.q qVar, int i) {
        this((i & 1) != 0 ? s.b : rVar, (i & 2) != 0 ? s.c : rVar2, (i & 4) != 0 ? s.d : rVar3, (i & 8) != 0 ? s.e : qVar);
    }

    @Override // cf1.q
    public final ld1.r a() {
        return this.c;
    }

    @Override // cf1.q
    public final ld1.r b() {
        return this.b;
    }

    @Override // cf1.q
    public final ld1.r c() {
        return this.d;
    }

    @Override // cf1.q
    public final ld1.r d() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, rVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, rVar.b) && lmjxuqdtp.jvm.internal.o.c(this.c, rVar.c) && lmjxuqdtp.jvm.internal.o.c(this.d, rVar.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + a.f(this.c, a.f(this.b, this.a.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        return "TrackCustom(activeTrackColor=" + this.a + ", inactiveTrackColor=" + this.b + ", disabledActiveTrackColor=" + this.c + ", disabledInactiveTrackColor=" + this.d + ")";
    }

    public r(ld1.r rVar, ld1.r rVar2, ld1.r rVar3, ld1.r rVar4) {
        lmjxuqdtp.jvm.internal.o.h(rVar, "activeTrackColor");
        lmjxuqdtp.jvm.internal.o.h(rVar2, "inactiveTrackColor");
        lmjxuqdtp.jvm.internal.o.h(rVar3, "disabledActiveTrackColor");
        lmjxuqdtp.jvm.internal.o.h(rVar4, "disabledInactiveTrackColor");
        this.a = rVar;
        this.b = rVar2;
        this.c = rVar3;
        this.d = rVar4;
    }
}
