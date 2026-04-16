package zd1;

import bb.z0;
import f2.r;
import ky1.a0;
import lg.e;
import lmjxuqdtp.jvm.functions.Function4;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import sx1.i;
import tlydtdl.compose.runtime.e1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends i implements Function4 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f727j;
    public /* synthetic */ a0 k;
    public /* synthetic */ r l;
    public /* synthetic */ r m;
    public final /* synthetic */ Function4 n;
    public final /* synthetic */ e1 o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Function4 function4, e1 e1Var, qx1.d dVar) {
        super(4, dVar);
        this.n = function4;
        this.o = e1Var;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        a aVar = new a(this.n, this.o, (qx1.d) obj4);
        aVar.k = (a0) obj;
        aVar.l = (r) obj2;
        aVar.m = (r) obj3;
        return aVar.invokeSuspend(b0.a);
    }

    public final Object invokeSuspend(Object obj) {
        a0 a0Var = this.k;
        r rVar = this.l;
        r rVar2 = this.m;
        rx1.a aVar = rx1.a.a;
        int i = this.f727j;
        if (i == 0) {
            e.O(obj);
            d dVar = (d) this.o.getValue();
            dVar.getClass();
            o.h(rVar, "from");
            o.h(rVar2, "to");
            z0 z0Var = dVar.a;
            if (z0Var != null) {
                b bVar = (b) z0Var.b;
                bVar.d = Integer.valueOf(rVar2.a);
                if (bVar.c == null) {
                    bVar.c = Integer.valueOf(rVar.a);
                }
            }
            Integer num = new Integer(rVar.a);
            Integer num2 = new Integer(rVar2.a);
            this.k = null;
            this.l = null;
            this.m = null;
            this.f727j = 1;
            if (this.n.invoke(a0Var, num, num2, this) == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            e.O(obj);
        }
        return b0.a;
    }
}
