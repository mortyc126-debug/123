package u70;

import lmjxuqdtp.jvm.functions.Function1;
import lx1.b0;
import w2.i0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends sx1.i implements Function1 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f616j;
    public final /* synthetic */ Object k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(Object obj, qx1.d dVar, int i) {
        super(1, dVar);
        this.f616j = i;
        this.k = obj;
    }

    public final qx1.d create(qx1.d dVar) {
        switch (this.f616j) {
            case 0:
                return new h((j) this.k, dVar, 0);
            default:
                return new h((i0) this.k, dVar, 1);
        }
    }

    public final Object invoke(Object obj) {
        qx1.d dVar = (qx1.d) obj;
        switch (this.f616j) {
            case 0:
                h hVarCreate = create(dVar);
                b0 b0Var = b0.a;
                hVarCreate.invokeSuspend(b0Var);
                return b0Var;
            default:
                h hVarCreate2 = create(dVar);
                b0 b0Var2 = b0.a;
                hVarCreate2.invokeSuspend(b0Var2);
                return b0Var2;
        }
    }

    public final Object invokeSuspend(Object obj) {
        int i = this.f616j;
        b0 b0Var = b0.a;
        Object obj2 = this.k;
        switch (i) {
            case 0:
                rx1.a aVar = rx1.a.a;
                lg.e.O(obj);
                j.b((j) obj2);
                break;
            default:
                rx1.a aVar2 = rx1.a.a;
                lg.e.O(obj);
                ((i0) obj2).g.v.setValue(Boolean.FALSE);
                break;
        }
        return b0Var;
    }
}
