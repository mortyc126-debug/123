package ds0;

import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lx1.b0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends sx1.i implements Function1 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f93j;
    public final /* synthetic */ Object k;
    public final /* synthetic */ Object l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(Object obj, Object obj2, qx1.d dVar, int i) {
        super(1, dVar);
        this.f93j = i;
        this.k = obj;
        this.l = obj2;
    }

    public final qx1.d create(qx1.d dVar) {
        switch (this.f93j) {
            case 0:
                return new j((y3.i) this.k, (l) this.l, dVar, 0);
            case 1:
                return new j((y3.i) this.k, (l) this.l, dVar, 1);
            default:
                return new j((t1.b) this.k, this.l, dVar, 2);
        }
    }

    public final Object invoke(Object obj) {
        qx1.d dVar = (qx1.d) obj;
        switch (this.f93j) {
            case 0:
                j jVarCreate = create(dVar);
                b0 b0Var = b0.a;
                jVarCreate.invokeSuspend(b0Var);
                return b0Var;
            case 1:
                j jVarCreate2 = create(dVar);
                b0 b0Var2 = b0.a;
                jVarCreate2.invokeSuspend(b0Var2);
                return b0Var2;
            default:
                j jVarCreate3 = create(dVar);
                b0 b0Var3 = b0.a;
                jVarCreate3.invokeSuspend(b0Var3);
                return b0Var3;
        }
    }

    public final Object invokeSuspend(Object obj) {
        int i = this.f93j;
        b0 b0Var = b0.a;
        Object obj2 = this.l;
        Object obj3 = this.k;
        switch (i) {
            case 0:
                rx1.a aVar = rx1.a.a;
                lg.e.O(obj);
                ((y3.i) obj3).b(false);
                ((Function0) ((l) obj2).d.c).invoke();
                break;
            case 1:
                rx1.a aVar2 = rx1.a.a;
                lg.e.O(obj);
                ((y3.i) obj3).b(false);
                ((Function0) ((l) obj2).d.d).invoke();
                break;
            default:
                rx1.a aVar3 = rx1.a.a;
                lg.e.O(obj);
                t1.b bVar = (t1.b) obj3;
                t1.b.a(bVar);
                Object objC = bVar.c(obj2);
                bVar.c.b.setValue(objC);
                bVar.e.setValue(objC);
                break;
        }
        return b0Var;
    }
}
