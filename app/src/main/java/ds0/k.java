package ds0;

import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lx1.b0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends sx1.i implements Function1 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f94j;
    public final /* synthetic */ l k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(l lVar, qx1.d dVar, int i) {
        super(1, dVar);
        this.f94j = i;
        this.k = lVar;
    }

    public final qx1.d create(qx1.d dVar) {
        switch (this.f94j) {
            case 0:
                return new k(this.k, dVar, 0);
            default:
                return new k(this.k, dVar, 1);
        }
    }

    public final Object invoke(Object obj) {
        qx1.d dVar = (qx1.d) obj;
        switch (this.f94j) {
            case 0:
                k kVarCreate = create(dVar);
                b0 b0Var = b0.a;
                kVarCreate.invokeSuspend(b0Var);
                return b0Var;
            default:
                k kVarCreate2 = create(dVar);
                b0 b0Var2 = b0.a;
                kVarCreate2.invokeSuspend(b0Var2);
                return b0Var2;
        }
    }

    public final Object invokeSuspend(Object obj) {
        int i = this.f94j;
        b0 b0Var = b0.a;
        l lVar = this.k;
        switch (i) {
            case 0:
                rx1.a aVar = rx1.a.a;
                lg.e.O(obj);
                ((Function0) lVar.d.e).invoke();
                break;
            default:
                rx1.a aVar2 = rx1.a.a;
                lg.e.O(obj);
                ((Function0) lVar.d.e).invoke();
                break;
        }
        return b0Var;
    }
}
