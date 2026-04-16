package cs0;

import hg1.b;
import lmjxuqdtp.jvm.functions.Function2;
import lx1.b0;
import qx1.d;
import zj.u2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class n extends sx1.i implements Function2 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f48j;
    public /* synthetic */ float k;
    public final /* synthetic */ x l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(x xVar, d dVar) {
        super(2, dVar);
        this.l = xVar;
    }

    public final d create(Object obj, d dVar) {
        n nVar = new n(this.l, dVar);
        nVar.k = ((b) obj).a;
        return nVar;
    }

    public final Object invoke(Object obj, Object obj2) {
        float f2 = ((b) obj).a;
        n nVar = new n(this.l, (d) obj2);
        nVar.k = f2;
        return nVar.invokeSuspend(b0.a);
    }

    public final Object invokeSuspend(Object obj) {
        float f2 = this.k;
        rx1.a aVar = rx1.a.a;
        int i = this.f48j;
        if (i == 0) {
            lg.e.O(obj);
            x xVar = this.l;
            u2 u2VarD = xVar.d();
            this.k = f2;
            this.f48j = 1;
            if (x.a(xVar, u2VarD, f2, this) == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lg.e.O(obj);
        }
        return b0.a;
    }
}
