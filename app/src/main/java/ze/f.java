package ze;

import af.d;
import b02.x;
import ky1.m0;
import lmjxuqdtp.jvm.functions.Function1;
import q.q2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static final f o;
    public final b02.o a;
    public final qx1.i b;
    public final qx1.i c;
    public final qx1.i d;
    public final b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f730f;
    public final b g;
    public final Function1 h;
    public final Function1 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function1 f731j;
    public final af.j k;
    public final af.g l;
    public final d m;
    public final je.j n;

    static {
        x xVar = b02.o.a;
        ry1.e eVar = m0.a;
        ry1.d dVar = ry1.d.b;
        b bVar = b.c;
        af.e eVar2 = af.j.J0;
        af.g gVar = af.g.b;
        d dVar2 = d.a;
        je.j jVar = je.j.b;
        qx1.j jVar2 = qx1.j.a;
        gf.m mVar = gf.m.a;
        o = new f(xVar, jVar2, dVar, dVar, bVar, bVar, bVar, mVar, mVar, mVar, eVar2, gVar, dVar2, jVar);
    }

    public f(b02.o oVar, qx1.i iVar, qx1.i iVar2, qx1.i iVar3, b bVar, b bVar2, b bVar3, Function1 function1, Function1 function12, Function1 function13, af.j jVar, af.g gVar, d dVar, je.j jVar2) {
        this.a = oVar;
        this.b = iVar;
        this.c = iVar2;
        this.d = iVar3;
        this.e = bVar;
        this.f730f = bVar2;
        this.g = bVar3;
        this.h = function1;
        this.i = function12;
        this.f731j = function13;
        this.k = jVar;
        this.l = gVar;
        this.m = dVar;
        this.n = jVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, fVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, fVar.b) && lmjxuqdtp.jvm.internal.o.c(this.c, fVar.c) && lmjxuqdtp.jvm.internal.o.c(this.d, fVar.d) && this.e == fVar.e && this.f730f == fVar.f730f && this.g == fVar.g && lmjxuqdtp.jvm.internal.o.c(this.h, fVar.h) && lmjxuqdtp.jvm.internal.o.c(this.i, fVar.i) && lmjxuqdtp.jvm.internal.o.c(this.f731j, fVar.f731j) && lmjxuqdtp.jvm.internal.o.c(this.k, fVar.k) && this.l == fVar.l && this.m == fVar.m && lmjxuqdtp.jvm.internal.o.c(this.n, fVar.n);
    }

    public final int hashCode() {
        return this.n.a.hashCode() + ((this.m.hashCode() + ((this.l.hashCode() + ((this.k.hashCode() + q2.b(q2.b(q2.b((this.g.hashCode() + ((this.f730f.hashCode() + ((this.e.hashCode() + ((this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31, 31, this.h), 31, this.i), 31, this.f731j)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "Defaults(fileSystem=" + this.a + ", interceptorCoroutineContext=" + this.b + ", fetcherCoroutineContext=" + this.c + ", decoderCoroutineContext=" + this.d + ", memoryCachePolicy=" + this.e + ", diskCachePolicy=" + this.f730f + ", networkCachePolicy=" + this.g + ", placeholderFactory=" + this.h + ", errorFactory=" + this.i + ", fallbackFactory=" + this.f731j + ", sizeResolver=" + this.k + ", scale=" + this.l + ", precision=" + this.m + ", extras=" + this.n + ')';
    }
}
