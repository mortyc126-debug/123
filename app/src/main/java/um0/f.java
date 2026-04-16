package um0;

import ju0.a;
import lmjxuqdtp.jvm.functions.Function7;
import lx1.b0;
import sx1.i;
import vm0.c;
import vm0.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends i implements Function7 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public /* synthetic */ e f621j;
    public /* synthetic */ a k;
    public /* synthetic */ dg1.i l;
    public /* synthetic */ boolean m;
    public /* synthetic */ boolean n;
    public /* synthetic */ boolean o;

    public f(qx1.d dVar) {
        super(7, dVar);
    }

    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        boolean zBooleanValue = ((Boolean) obj4).booleanValue();
        boolean zBooleanValue2 = ((Boolean) obj5).booleanValue();
        boolean zBooleanValue3 = ((Boolean) obj6).booleanValue();
        f fVar = new f((qx1.d) obj7);
        fVar.f621j = (e) obj;
        fVar.k = (a) obj2;
        fVar.l = (dg1.i) obj3;
        fVar.m = zBooleanValue;
        fVar.n = zBooleanValue2;
        fVar.o = zBooleanValue3;
        return fVar.invokeSuspend(b0.a);
    }

    public final Object invokeSuspend(Object obj) {
        e eVar = this.f621j;
        a aVar = this.k;
        dg1.i iVar = this.l;
        boolean z = this.m;
        boolean z2 = this.n;
        boolean z3 = this.o;
        rx1.a aVar2 = rx1.a.a;
        lg.e.O(obj);
        return new vm0.d(eVar, iVar, aVar, (z && z3) ? new c(!z2) : null);
    }
}
