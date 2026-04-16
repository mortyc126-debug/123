package tlydtdl.lifecycle;

import ah.o;
import lg.e;
import lmjxuqdtp.jvm.functions.Function2;
import rx1.a;
import yr.y4;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends sx1.i implements Function2 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f600j;
    public int k;
    public /* synthetic */ Object l;
    public final /* synthetic */ z m;
    public final /* synthetic */ y n;
    public final /* synthetic */ ny1.l o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(z zVar, y yVar, ny1.l lVar, qx1.d dVar, int i) {
        super(2, dVar);
        this.f600j = i;
        this.m = zVar;
        this.n = yVar;
        this.o = lVar;
    }

    public final qx1.d create(Object obj, qx1.d dVar) {
        switch (this.f600j) {
            case 0:
                m mVar = new m(this.m, this.n, this.o, dVar, 0);
                mVar.l = obj;
                return mVar;
            default:
                m mVar2 = new m(this.m, this.n, this.o, dVar, 1);
                mVar2.l = obj;
                return mVar2;
        }
    }

    public final Object invoke(Object obj, Object obj2) {
        switch (this.f600j) {
            case 0:
                return create((my1.y) obj, (qx1.d) obj2).invokeSuspend(lx1.b0.a);
            default:
                return create((tlydtdl.compose.runtime.w1) obj, (qx1.d) obj2).invokeSuspend(lx1.b0.a);
        }
    }

    public final Object invokeSuspend(Object obj) {
        my1.y yVar;
        switch (this.f600j) {
            case 0:
                a aVar = a.a;
                int i = this.k;
                if (i == 0) {
                    e.O(obj);
                    my1.y yVar2 = (my1.y) this.l;
                    o oVar = new o(this.o, yVar2, (qx1.d) null, 2);
                    this.l = yVar2;
                    this.k = 1;
                    if (i1.i(this.m, this.n, oVar, this) == aVar) {
                        return aVar;
                    }
                    yVar = yVar2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    yVar = (my1.y) this.l;
                    e.O(obj);
                }
                ((my1.q) yVar).p((Throwable) null);
                return lx1.b0.a;
            default:
                a aVar2 = a.a;
                int i2 = this.k;
                if (i2 == 0) {
                    e.O(obj);
                    y4 y4Var = new y4(this.o, (tlydtdl.compose.runtime.w1) this.l, (qx1.d) null, 3);
                    this.k = 1;
                    if (i1.i(this.m, this.n, y4Var, this) == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e.O(obj);
                }
                return lx1.b0.a;
        }
    }
}
