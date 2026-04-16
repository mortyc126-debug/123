package ne0;

import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import lx1.l;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class r extends sx1.i implements Function2 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f349j;
    public /* synthetic */ Object k;
    public final /* synthetic */ s l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(s sVar, qx1.d dVar, int i) {
        super(2, dVar);
        this.f349j = i;
        this.l = sVar;
    }

    public final qx1.d create(Object obj, qx1.d dVar) {
        switch (this.f349j) {
            case 0:
                r rVar = new r(this.l, dVar, 0);
                rVar.k = obj;
                return rVar;
            default:
                r rVar2 = new r(this.l, dVar, 1);
                rVar2.k = obj;
                return rVar2;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
        switch (this.f349j) {
            case 0:
                r rVarCreate = create((k) obj, (qx1.d) obj2);
                b0 b0Var = b0.a;
                rVarCreate.invokeSuspend(b0Var);
                return b0Var;
            default:
                r rVarCreate2 = create((l) obj, (qx1.d) obj2);
                b0 b0Var2 = b0.a;
                rVarCreate2.invokeSuspend(b0Var2);
                return b0Var2;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final Object invokeSuspend(Object obj) throws NoWhenBranchMatchedException {
        int i = this.f349j;
        s sVar = this.l;
        b0 b0Var = b0.a;
        switch (i) {
            case 0:
                k kVar = (k) this.k;
                rx1.a aVar = rx1.a.a;
                lg.e.O(obj);
                if (kVar != null) {
                    sVar.e(false);
                } else {
                    sVar.f();
                }
                return b0Var;
            default:
                l lVar = (l) this.k;
                rx1.a aVar2 = rx1.a.a;
                lg.e.O(obj);
                re0.a aVar3 = (re0.j) lVar.a;
                if (!o.c((ke0.c) lVar.b, ke0.b.a) && ((Boolean) sVar.l.getValue()).booleanValue()) {
                    if (aVar3 instanceof re0.a) {
                        aVar3.a.invoke();
                    } else if (aVar3 instanceof re0.k) {
                        ((re0.k) aVar3).a.invoke();
                    } else if (!(aVar3 instanceof re0.b) && !(aVar3 instanceof re0.c) && !(aVar3 instanceof re0.f)) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                return b0Var;
        }
    }
}
