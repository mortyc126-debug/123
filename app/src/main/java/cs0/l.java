package cs0;

import hg1.b;
import lmjxuqdtp.jvm.functions.Function3;
import lx1.b0;
import ny1.r2;
import qx1.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends sx1.i implements Function3 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public /* synthetic */ float f47j;
    public /* synthetic */ boolean k;
    public final /* synthetic */ x l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(x xVar, d dVar) {
        super(3, dVar);
        this.l = xVar;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        float f2 = ((b) obj).a;
        boolean zBooleanValue = ((Boolean) obj2).booleanValue();
        l lVar = new l(this.l, (d) obj3);
        lVar.f47j = f2;
        lVar.k = zBooleanValue;
        b0 b0Var = b0.a;
        lVar.invokeSuspend(b0Var);
        return b0Var;
    }

    public final Object invokeSuspend(Object obj) {
        Object value;
        float f2 = this.f47j;
        boolean z = this.k;
        rx1.a aVar = rx1.a.a;
        lg.e.O(obj);
        x xVar = this.l;
        x.b(xVar.f53f, f2);
        r2 r2Var = xVar.g;
        do {
            value = r2Var.getValue();
        } while (!r2Var.d(value, new g(f2, !z)));
        return b0.a;
    }
}
