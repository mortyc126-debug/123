package cu0;

import lmjxuqdtp.jvm.functions.Function3;
import lx1.b0;
import ny1.m;
import ny1.z;
import qx1.d;
import rx1.a;
import sx1.i;
import y11.q4;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends i implements Function3 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f64j;
    public int k;
    public /* synthetic */ m l;
    public /* synthetic */ Object m;
    public final /* synthetic */ hu0.i n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(d dVar, hu0.i iVar, int i) {
        super(3, dVar);
        this.f64j = i;
        this.n = iVar;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        m mVar = (m) obj;
        d dVar = (d) obj3;
        switch (this.f64j) {
            case 0:
                l lVar = new l(dVar, this.n, 0);
                lVar.l = mVar;
                lVar.m = obj2;
                return lVar.invokeSuspend(b0.a);
            case 1:
                l lVar2 = new l(dVar, this.n, 1);
                lVar2.l = mVar;
                lVar2.m = obj2;
                return lVar2.invokeSuspend(b0.a);
            case 2:
                l lVar3 = new l(dVar, this.n, 2);
                lVar3.l = mVar;
                lVar3.m = obj2;
                return lVar3.invokeSuspend(b0.a);
            default:
                l lVar4 = new l(dVar, this.n, 3);
                lVar4.l = mVar;
                lVar4.m = obj2;
                return lVar4.invokeSuspend(b0.a);
        }
    }

    public final Object invokeSuspend(Object obj) {
        switch (this.f64j) {
            case 0:
                a aVar = a.a;
                int i = this.k;
                if (i == 0) {
                    lg.e.O(obj);
                    m mVar = this.l;
                    hm0.n nVarB = this.n.b(((q4) this.m).a);
                    this.l = null;
                    this.m = null;
                    this.k = 1;
                    if (z.x(mVar, nVarB, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lg.e.O(obj);
                }
                return b0.a;
            case 1:
                a aVar2 = a.a;
                int i2 = this.k;
                if (i2 == 0) {
                    lg.e.O(obj);
                    m mVar2 = this.l;
                    hm0.n nVarB2 = this.n.b(((q4) this.m).a);
                    this.l = null;
                    this.m = null;
                    this.k = 1;
                    if (z.x(mVar2, nVarB2, this) == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lg.e.O(obj);
                }
                return b0.a;
            case 2:
                a aVar3 = a.a;
                int i3 = this.k;
                if (i3 == 0) {
                    lg.e.O(obj);
                    m mVar3 = this.l;
                    hm0.n nVarB3 = this.n.b(((q4) this.m).a);
                    this.l = null;
                    this.m = null;
                    this.k = 1;
                    if (z.x(mVar3, nVarB3, this) == aVar3) {
                        return aVar3;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lg.e.O(obj);
                }
                return b0.a;
            default:
                a aVar4 = a.a;
                int i4 = this.k;
                if (i4 == 0) {
                    lg.e.O(obj);
                    m mVar4 = this.l;
                    hm0.n nVarB4 = this.n.b(((q4) this.m).a);
                    this.l = null;
                    this.m = null;
                    this.k = 1;
                    if (z.x(mVar4, nVarB4, this) == aVar4) {
                        return aVar4;
                    }
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lg.e.O(obj);
                }
                return b0.a;
        }
    }
}
