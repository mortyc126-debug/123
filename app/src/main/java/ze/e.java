package ze;

import af.d;
import amuvvoafs.content.Context;
import java.util.Map;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.g0;
import mx1.u;
import mx1.z;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public final Context a;
    public f b;
    public Object c;
    public df.b d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map f728f;
    public qx1.i g;
    public qx1.i h;
    public qx1.i i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f729j;
    public b k;
    public final Function1 l;
    public Function1 m;
    public Function1 n;
    public af.j o;
    public af.g p;
    public d q;
    public Object r;

    public e(Context context) {
        this.a = context;
        this.b = f.o;
        this.c = null;
        this.d = null;
        this.f728f = u.a;
        this.g = null;
        this.h = null;
        this.i = null;
        this.f729j = null;
        this.k = null;
        gf.m mVar = gf.m.a;
        this.l = mVar;
        this.m = mVar;
        this.n = mVar;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = je.j.b;
    }

    public final h a() {
        Map mapN;
        je.j jVar;
        Object obj = this.c;
        if (obj == null) {
            obj = l.a;
        }
        Object obj2 = obj;
        df.b bVar = this.d;
        Map map = this.f728f;
        if (lmjxuqdtp.jvm.internal.o.c(map, Boolean.valueOf(this.e))) {
            lmjxuqdtp.jvm.internal.o.f(map, "null cannot be cast to non-null type lmjxuqdtp.collections.MutableMap<*, *>");
            mapN = hs1.d.N(g0.c(map));
        } else {
            if (!(map instanceof Map)) {
                throw new AssertionError();
            }
            mapN = map;
        }
        Map map2 = mapN;
        lmjxuqdtp.jvm.internal.o.f(map2, "null cannot be cast to non-null type lmjxuqdtp.collections.Map<lmjxuqdtp.String, lmjxuqdtp.String>");
        f fVar = this.b;
        b02.o oVar = fVar.a;
        b bVar2 = this.f729j;
        if (bVar2 == null) {
            bVar2 = fVar.e;
        }
        b bVar3 = bVar2;
        b bVar4 = this.k;
        if (bVar4 == null) {
            bVar4 = fVar.f730f;
        }
        b bVar5 = bVar4;
        b bVar6 = fVar.g;
        qx1.i iVar = this.g;
        if (iVar == null) {
            iVar = fVar.b;
        }
        qx1.i iVar2 = iVar;
        qx1.i iVar3 = this.h;
        if (iVar3 == null) {
            iVar3 = fVar.c;
        }
        qx1.i iVar4 = iVar3;
        qx1.i iVar5 = this.i;
        if (iVar5 == null) {
            iVar5 = fVar.d;
        }
        qx1.i iVar6 = iVar5;
        Function1 function1 = this.l;
        if (function1 == null) {
            function1 = fVar.h;
        }
        Function1 function12 = function1;
        Function1 function13 = this.m;
        if (function13 == null) {
            function13 = fVar.i;
        }
        Function1 function14 = function13;
        Function1 function15 = this.n;
        if (function15 == null) {
            function15 = fVar.f731j;
        }
        Function1 function16 = function15;
        af.j jVar2 = this.o;
        if (jVar2 == null) {
            jVar2 = fVar.k;
        }
        af.j jVar3 = jVar2;
        af.g gVar = this.p;
        if (gVar == null) {
            gVar = fVar.l;
        }
        af.g gVar2 = gVar;
        d dVar = this.q;
        if (dVar == null) {
            dVar = fVar.m;
        }
        d dVar2 = dVar;
        Object obj3 = this.r;
        if (obj3 instanceof je.h) {
            jVar = new je.j(hs1.d.N(((je.h) obj3).a));
        } else {
            if (!(obj3 instanceof je.j)) {
                throw new AssertionError();
            }
            jVar = (je.j) obj3;
        }
        je.j jVar4 = jVar;
        qx1.i iVar7 = this.g;
        qx1.i iVar8 = this.h;
        qx1.i iVar9 = this.i;
        Function1 function17 = this.m;
        Function1 function18 = this.n;
        return new h(this.a, obj2, bVar, map2, oVar, iVar2, iVar4, iVar6, bVar3, bVar5, bVar6, function12, function14, function16, jVar3, gVar2, dVar2, jVar4, new g(iVar7, iVar8, iVar9, this.f729j, this.k, this.l, function17, function18, this.o, this.p, this.q), this.b);
    }

    public final je.h b() {
        Object obj = this.r;
        if (obj instanceof je.h) {
            return (je.h) obj;
        }
        if (!(obj instanceof je.j)) {
            throw new AssertionError();
        }
        je.h hVar = new je.h((je.j) obj);
        this.r = hVar;
        return hVar;
    }

    public final Map c() {
        Map mapF0 = this.f728f;
        if (!lmjxuqdtp.jvm.internal.o.c(mapF0, Boolean.valueOf(this.e))) {
            if (!(mapF0 instanceof Map)) {
                throw new AssertionError();
            }
            mapF0 = z.f0(mapF0);
            this.f728f = mapF0;
            this.e = true;
        }
        lmjxuqdtp.jvm.internal.o.f(mapF0, "null cannot be cast to non-null type lmjxuqdtp.collections.MutableMap<lmjxuqdtp.String, lmjxuqdtp.String>");
        return g0.c(mapF0);
    }

    public e(h hVar, Context context) {
        this.a = context;
        this.b = hVar.t;
        this.c = hVar.b;
        this.d = hVar.c;
        this.f728f = hVar.d;
        g gVar = hVar.s;
        this.g = gVar.a;
        this.h = gVar.b;
        this.i = gVar.c;
        this.f729j = gVar.d;
        this.k = gVar.e;
        this.l = gVar.f732f;
        this.m = gVar.g;
        this.n = gVar.h;
        this.o = gVar.i;
        this.p = gVar.f733j;
        this.q = gVar.k;
        this.r = hVar.r;
    }
}
