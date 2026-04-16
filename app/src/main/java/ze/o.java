package ze;

import f3.f2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements k {
    public final je.k a;
    public final h b;
    public final me.g c;
    public final ue.a d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f739f;
    public final boolean g;

    public o(je.k kVar, h hVar, me.g gVar, ue.a aVar, String str, boolean z, boolean z2) {
        this.a = kVar;
        this.b = hVar;
        this.c = gVar;
        this.d = aVar;
        this.e = str;
        this.f739f = z;
        this.g = z2;
    }

    @Override // ze.k
    public final h a() {
        return this.b;
    }

    @Override // ze.k
    public final je.k b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, oVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, oVar.b) && this.c == oVar.c && lmjxuqdtp.jvm.internal.o.c(this.d, oVar.d) && lmjxuqdtp.jvm.internal.o.c(this.e, oVar.e) && this.f739f == oVar.f739f && this.g == oVar.g;
    }

    public final int hashCode() {
        int iHashCode = (this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31;
        ue.a aVar = this.d;
        int iHashCode2 = (iHashCode + (aVar == null ? 0 : aVar.hashCode())) * 31;
        String str = this.e;
        return Boolean.hashCode(this.g) + s1.a.f((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31, 31, this.f739f);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SuccessResult(image=");
        sb.append(this.a);
        sb.append(", request=");
        sb.append(this.b);
        sb.append(", dataSource=");
        sb.append(this.c);
        sb.append(", memoryCacheKey=");
        sb.append(this.d);
        sb.append(", diskCacheKey=");
        sb.append(this.e);
        sb.append(", isSampled=");
        sb.append(this.f739f);
        sb.append(", isPlaceholderCached=");
        return f2.n(sb, this.g, ')');
    }
}
