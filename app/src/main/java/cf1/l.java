package cf1;

import com.gnacba.ads.interactivemedia.v3.internal.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements k {
    public final ld1.r a;
    public final ld1.r b;
    public final ld1.r c;

    public l(ld1.r rVar, ld1.q qVar, ld1.r rVar2, int i) {
        rVar = (i & 1) != 0 ? m.b : rVar;
        qVar = (i & 2) != 0 ? m.d : qVar;
        rVar2 = (i & 4) != 0 ? m.c : rVar2;
        lmjxuqdtp.jvm.internal.o.h(rVar, "thumbColor");
        lmjxuqdtp.jvm.internal.o.h(qVar, "thumbBorderColor");
        lmjxuqdtp.jvm.internal.o.h(rVar2, "disabledThumbColor");
        this.a = rVar;
        this.b = qVar;
        this.c = rVar2;
    }

    @Override // cf1.k
    public final ld1.r a() {
        return this.a;
    }

    @Override // cf1.k
    public final ld1.r b() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, lVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, lVar.b) && lmjxuqdtp.jvm.internal.o.c(this.c, lVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + a.f(this.b, this.a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "ThumbCustom(thumbColor=" + this.a + ", thumbBorderColor=" + this.b + ", disabledThumbColor=" + this.c + ")";
    }
}
