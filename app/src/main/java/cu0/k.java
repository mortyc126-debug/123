package cu0;

import com.gnacba.firebase.messaging.a0;
import d10.j;
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
public final class k extends i implements Function3 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f63j;
    public int k;
    public /* synthetic */ m l;
    public /* synthetic */ Object m;
    public final /* synthetic */ a0 n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(d dVar, a0 a0Var, int i) {
        super(3, dVar);
        this.f63j = i;
        this.n = a0Var;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        m mVar = (m) obj;
        d dVar = (d) obj3;
        switch (this.f63j) {
            case 0:
                k kVar = new k(dVar, this.n, 0);
                kVar.l = mVar;
                kVar.m = obj2;
                return kVar.invokeSuspend(b0.a);
            case 1:
                k kVar2 = new k(dVar, this.n, 1);
                kVar2.l = mVar;
                kVar2.m = obj2;
                return kVar2.invokeSuspend(b0.a);
            case 2:
                k kVar3 = new k(dVar, this.n, 2);
                kVar3.l = mVar;
                kVar3.m = obj2;
                return kVar3.invokeSuspend(b0.a);
            default:
                k kVar4 = new k(dVar, this.n, 3);
                kVar4.l = mVar;
                kVar4.m = obj2;
                return kVar4.invokeSuspend(b0.a);
        }
    }

    public final Object invokeSuspend(Object obj) {
        switch (this.f63j) {
            case 0:
                a aVar = a.a;
                int i = this.k;
                if (i == 0) {
                    lg.e.O(obj);
                    m mVar = this.l;
                    j jVarX = this.n.x(((q4) this.m).a);
                    this.l = null;
                    this.m = null;
                    this.k = 1;
                    if (z.x(mVar, jVarX, this) == aVar) {
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
                    j jVarX2 = this.n.x(((q4) this.m).a);
                    this.l = null;
                    this.m = null;
                    this.k = 1;
                    if (z.x(mVar2, jVarX2, this) == aVar2) {
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
                    j jVarX3 = this.n.x(((q4) this.m).a);
                    this.l = null;
                    this.m = null;
                    this.k = 1;
                    if (z.x(mVar3, jVarX3, this) == aVar3) {
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
                    j jVarX4 = this.n.x(((q4) this.m).a);
                    this.l = null;
                    this.m = null;
                    this.k = 1;
                    if (z.x(mVar4, jVarX4, this) == aVar4) {
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
