package ze;

import af.d;
import amuvvoafs.content.Context;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class m {
    public final Context a;
    public final af.i b;
    public final af.g c;
    public final d d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b02.o f737f;
    public final b g;
    public final b h;
    public final b i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final je.j f738j;

    public m(Context context, af.i iVar, af.g gVar, d dVar, String str, b02.o oVar, b bVar, b bVar2, b bVar3, je.j jVar) {
        this.a = context;
        this.b = iVar;
        this.c = gVar;
        this.d = dVar;
        this.e = str;
        this.f737f = oVar;
        this.g = bVar;
        this.h = bVar2;
        this.i = bVar3;
        this.f738j = jVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, mVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, mVar.b) && this.c == mVar.c && this.d == mVar.d && lmjxuqdtp.jvm.internal.o.c(this.e, mVar.e) && lmjxuqdtp.jvm.internal.o.c(this.f737f, mVar.f737f) && this.g == mVar.g && this.h == mVar.h && this.i == mVar.i && lmjxuqdtp.jvm.internal.o.c(this.f738j, mVar.f738j);
    }

    public final int hashCode() {
        int iHashCode = (this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31)) * 31;
        String str = this.e;
        return this.f738j.a.hashCode() + ((this.i.hashCode() + ((this.h.hashCode() + ((this.g.hashCode() + ((this.f737f.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "Options(context=" + this.a + ", size=" + this.b + ", scale=" + this.c + ", precision=" + this.d + ", diskCacheKey=" + this.e + ", fileSystem=" + this.f737f + ", memoryCachePolicy=" + this.g + ", diskCachePolicy=" + this.h + ", networkCachePolicy=" + this.i + ", extras=" + this.f738j + ')';
    }
}
