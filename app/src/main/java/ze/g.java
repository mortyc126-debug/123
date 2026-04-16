package ze;

import af.d;
import lmjxuqdtp.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public final qx1.i a;
    public final qx1.i b;
    public final qx1.i c;
    public final b d;
    public final b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1 f732f;
    public final Function1 g;
    public final Function1 h;
    public final af.j i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final af.g f733j;
    public final d k;

    public g(qx1.i iVar, qx1.i iVar2, qx1.i iVar3, b bVar, b bVar2, Function1 function1, Function1 function12, Function1 function13, af.j jVar, af.g gVar, d dVar) {
        this.a = iVar;
        this.b = iVar2;
        this.c = iVar3;
        this.d = bVar;
        this.e = bVar2;
        this.f732f = function1;
        this.g = function12;
        this.h = function13;
        this.i = jVar;
        this.f733j = gVar;
        this.k = dVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, gVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, gVar.b) && lmjxuqdtp.jvm.internal.o.c(this.c, gVar.c) && this.d == gVar.d && this.e == gVar.e && lmjxuqdtp.jvm.internal.o.c(this.f732f, gVar.f732f) && lmjxuqdtp.jvm.internal.o.c(this.g, gVar.g) && lmjxuqdtp.jvm.internal.o.c(this.h, gVar.h) && lmjxuqdtp.jvm.internal.o.c(this.i, gVar.i) && this.f733j == gVar.f733j && this.k == gVar.k;
    }

    public final int hashCode() {
        qx1.i iVar = this.a;
        int iHashCode = (iVar == null ? 0 : iVar.hashCode()) * 31;
        qx1.i iVar2 = this.b;
        int iHashCode2 = (iHashCode + (iVar2 == null ? 0 : iVar2.hashCode())) * 31;
        qx1.i iVar3 = this.c;
        int iHashCode3 = (iHashCode2 + (iVar3 == null ? 0 : iVar3.hashCode())) * 31;
        b bVar = this.d;
        int iHashCode4 = (iHashCode3 + (bVar == null ? 0 : bVar.hashCode())) * 31;
        b bVar2 = this.e;
        int iHashCode5 = (iHashCode4 + (bVar2 == null ? 0 : bVar2.hashCode())) * 961;
        Function1 function1 = this.f732f;
        int iHashCode6 = (iHashCode5 + (function1 == null ? 0 : function1.hashCode())) * 31;
        Function1 function12 = this.g;
        int iHashCode7 = (iHashCode6 + (function12 == null ? 0 : function12.hashCode())) * 31;
        Function1 function13 = this.h;
        int iHashCode8 = (iHashCode7 + (function13 == null ? 0 : function13.hashCode())) * 31;
        af.j jVar = this.i;
        int iHashCode9 = (iHashCode8 + (jVar == null ? 0 : jVar.hashCode())) * 31;
        af.g gVar = this.f733j;
        int iHashCode10 = (iHashCode9 + (gVar == null ? 0 : gVar.hashCode())) * 31;
        d dVar = this.k;
        return iHashCode10 + (dVar != null ? dVar.hashCode() : 0);
    }

    public final String toString() {
        return "Defined(fileSystem=null, interceptorCoroutineContext=" + this.a + ", fetcherCoroutineContext=" + this.b + ", decoderCoroutineContext=" + this.c + ", memoryCachePolicy=" + this.d + ", diskCachePolicy=" + this.e + ", networkCachePolicy=null, placeholderFactory=" + this.f732f + ", errorFactory=" + this.g + ", fallbackFactory=" + this.h + ", sizeResolver=" + this.i + ", scale=" + this.f733j + ", precision=" + this.k + ')';
    }
}
