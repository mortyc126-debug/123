package ze;

import af.d;
import amuvvoafs.content.Context;
import com.ironsource.adqualitysdk.sdk.i.a0;
import java.util.Map;
import jn1.r;
import lmjxuqdtp.jvm.functions.Function1;
import q.q2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h {
    public final Context a;
    public final Object b;
    public final df.b c;
    public final Map d;
    public final b02.o e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final qx1.i f734f;
    public final qx1.i g;
    public final qx1.i h;
    public final b i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f735j;
    public final b k;
    public final Function1 l;
    public final Function1 m;
    public final Function1 n;
    public final af.j o;
    public final af.g p;
    public final d q;
    public final je.j r;
    public final g s;
    public final f t;

    public h(Context context, Object obj, df.b bVar, Map map, b02.o oVar, qx1.i iVar, qx1.i iVar2, qx1.i iVar3, b bVar2, b bVar3, b bVar4, Function1 function1, Function1 function12, Function1 function13, af.j jVar, af.g gVar, d dVar, je.j jVar2, g gVar2, f fVar) {
        this.a = context;
        this.b = obj;
        this.c = bVar;
        this.d = map;
        this.e = oVar;
        this.f734f = iVar;
        this.g = iVar2;
        this.h = iVar3;
        this.i = bVar2;
        this.f735j = bVar3;
        this.k = bVar4;
        this.l = function1;
        this.m = function12;
        this.n = function13;
        this.o = jVar;
        this.p = gVar;
        this.q = dVar;
        this.r = jVar2;
        this.s = gVar2;
        this.t = fVar;
    }

    public static e a(h hVar) {
        Context context = hVar.a;
        hVar.getClass();
        return new e(hVar, context);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, hVar.a) && this.b.equals(hVar.b) && lmjxuqdtp.jvm.internal.o.c(this.c, hVar.c) && this.d.equals(hVar.d) && lmjxuqdtp.jvm.internal.o.c(this.e, hVar.e) && lmjxuqdtp.jvm.internal.o.c(this.f734f, hVar.f734f) && lmjxuqdtp.jvm.internal.o.c(this.g, hVar.g) && lmjxuqdtp.jvm.internal.o.c(this.h, hVar.h) && this.i == hVar.i && this.f735j == hVar.f735j && this.k == hVar.k && lmjxuqdtp.jvm.internal.o.c(this.l, hVar.l) && lmjxuqdtp.jvm.internal.o.c(this.m, hVar.m) && lmjxuqdtp.jvm.internal.o.c(this.n, hVar.n) && lmjxuqdtp.jvm.internal.o.c(this.o, hVar.o) && this.p == hVar.p && this.q == hVar.q && this.r.equals(hVar.r) && this.s.equals(hVar.s) && lmjxuqdtp.jvm.internal.o.c(this.t, hVar.t);
    }

    public final int hashCode() {
        int i = r.i(this.a.hashCode() * 31, 31, this.b);
        df.b bVar = this.c;
        return this.t.hashCode() + ((this.s.hashCode() + a0.c((this.q.hashCode() + ((this.p.hashCode() + ((this.o.hashCode() + q2.b(q2.b(q2.b((this.k.hashCode() + ((this.f735j.hashCode() + ((this.i.hashCode() + ((this.h.hashCode() + ((this.g.hashCode() + ((this.f734f.hashCode() + ((this.e.hashCode() + a0.c((i + (bVar == null ? 0 : bVar.hashCode())) * 29791, this.d, 961)) * 29791)) * 31)) * 31)) * 31)) * 31)) * 31)) * 961, 31, this.l), 31, this.m), 31, this.n)) * 31)) * 31)) * 31, this.r.a, 31)) * 31);
    }

    public final String toString() {
        return "ImageRequest(context=" + this.a + ", data=" + this.b + ", target=" + this.c + ", listener=null, memoryCacheKey=null, memoryCacheKeyExtras=" + this.d + ", diskCacheKey=null, fileSystem=" + this.e + ", fetcherFactory=null, decoderFactory=null, interceptorCoroutineContext=" + this.f734f + ", fetcherCoroutineContext=" + this.g + ", decoderCoroutineContext=" + this.h + ", memoryCachePolicy=" + this.i + ", diskCachePolicy=" + this.f735j + ", networkCachePolicy=" + this.k + ", placeholderMemoryCacheKey=null, placeholderFactory=" + this.l + ", errorFactory=" + this.m + ", fallbackFactory=" + this.n + ", sizeResolver=" + this.o + ", scale=" + this.p + ", precision=" + this.q + ", extras=" + this.r + ", defined=" + this.s + ", defaults=" + this.t + ')';
    }
}
