package kg0;

import ak.s1;
import k7.w;
import ky1.a0;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function5;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import ny1.b2;
import qx1.d;
import st.w0;
import sx1.i;
import wk.b;
import wk.c;
import wk.f;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends i implements Function5 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f262j;
    public /* synthetic */ f k;
    public /* synthetic */ boolean l;
    public /* synthetic */ boolean m;
    public /* synthetic */ Integer n;
    public final /* synthetic */ h o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar, d dVar) {
        super(5, dVar);
        this.o = hVar;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        boolean zBooleanValue = ((Boolean) obj2).booleanValue();
        boolean zBooleanValue2 = ((Boolean) obj3).booleanValue();
        g gVar = new g(this.o, (d) obj5);
        gVar.k = (f) obj;
        gVar.l = zBooleanValue;
        gVar.m = zBooleanValue2;
        gVar.n = (Integer) obj4;
        return gVar.invokeSuspend(b0.a);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final Object invokeSuspend(Object obj) throws NoWhenBranchMatchedException {
        f fVar = this.k;
        boolean z = this.l;
        boolean z2 = this.m;
        Integer num = this.n;
        rx1.a aVar = rx1.a.a;
        int i = this.f262j;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lg.e.O(obj);
            return null;
        }
        lg.e.O(obj);
        h hVar = this.o;
        if (z2) {
            return new lg0.d(hVar.n);
        }
        if (fVar instanceof b) {
            this.k = null;
            this.n = null;
            this.l = z;
            this.m = z2;
            this.f262j = 1;
            if (h.b(hVar, (b) fVar, this) == aVar) {
                return aVar;
            }
        } else {
            if (fVar instanceof c) {
                c cVar = (c) fVar;
                return new lg0.c(cVar.a, cVar.b, hVar.m);
            }
            if (fVar instanceof wk.e) {
                wk.e eVar = (wk.e) fVar;
                w wVar = hVar.f264j;
                a0 a0Var = hVar.b;
                b2 b2VarE = wVar.e(eVar, a0Var);
                double d = eVar.g;
                double d3 = eVar.h;
                double d4 = d / (d + d3);
                return new lg0.e(eVar.b, eVar.a, b2VarE, wVar.f(eVar, a0Var), w.d(eVar), w0.o0(b2VarE, new s1(d4, 1)), w0.o0(b2VarE, new s1(d4, 2)), eVar.e, eVar.f660f, (float) d, (float) d3, z, eVar.i, num, hVar.l);
            }
            if (!o.c(fVar, wk.d.a)) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return null;
    }
}
