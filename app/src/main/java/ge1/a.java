package ge1;

import lg.e;
import lmjxuqdtp.jvm.functions.Function2;
import lx1.b0;
import mx1.v;
import sx1.i;
import tlydtdl.compose.runtime.e1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends i implements Function2 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f180j;
    public final /* synthetic */ e1 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(e1 e1Var, qx1.d dVar, int i) {
        super(2, dVar);
        this.f180j = i;
        this.k = e1Var;
    }

    public final qx1.d create(Object obj, qx1.d dVar) {
        switch (this.f180j) {
            case 0:
                return new a(this.k, dVar, 0);
            default:
                return new a(this.k, dVar, 1);
        }
    }

    public final Object invoke(Object obj, Object obj2) {
        switch (this.f180j) {
            case 0:
                a aVar = (a) create((b0) obj, (qx1.d) obj2);
                b0 b0Var = b0.a;
                aVar.invokeSuspend(b0Var);
                return b0Var;
            default:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                a aVar2 = (a) create(bool, (qx1.d) obj2);
                b0 b0Var2 = b0.a;
                aVar2.invokeSuspend(b0Var2);
                return b0Var2;
        }
    }

    public final Object invokeSuspend(Object obj) {
        int i = this.f180j;
        b0 b0Var = b0.a;
        e1 e1Var = this.k;
        switch (i) {
            case 0:
                rx1.a aVar = rx1.a.a;
                e.O(obj);
                a20.a aVar2 = (a20.a) e1Var.getValue();
                if (aVar2 != null) {
                    aVar2.f5j = v.a;
                }
                break;
            default:
                rx1.a aVar3 = rx1.a.a;
                e.O(obj);
                e1Var.setValue(Boolean.FALSE);
                break;
        }
        return b0Var;
    }
}
