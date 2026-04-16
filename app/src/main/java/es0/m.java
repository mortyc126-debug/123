package es0;

import lmjxuqdtp.jvm.functions.Function3;
import lx1.b0;
import ny1.r2;
import st.f;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends sx1.i implements Function3 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f111j;
    public /* synthetic */ boolean k;
    public /* synthetic */ boolean l;
    public final /* synthetic */ Object m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(Object obj, qx1.d dVar, int i) {
        super(3, dVar);
        this.f111j = i;
        this.m = obj;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int i = this.f111j;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        boolean zBooleanValue2 = ((Boolean) obj2).booleanValue();
        qx1.d dVar = (qx1.d) obj3;
        switch (i) {
            case 0:
                m mVar = new m((zi.c) this.m, dVar, 0);
                mVar.k = zBooleanValue;
                mVar.l = zBooleanValue2;
                return mVar.invokeSuspend(b0.a);
            default:
                m mVar2 = new m((st.u) this.m, dVar, 1);
                mVar2.k = zBooleanValue;
                mVar2.l = zBooleanValue2;
                b0 b0Var = b0.a;
                mVar2.invokeSuspend(b0Var);
                return b0Var;
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object value;
        int i = this.f111j;
        Object obj2 = this.m;
        switch (i) {
            case 0:
                zi.c cVar = (zi.c) obj2;
                boolean z = this.k;
                boolean z2 = this.l;
                rx1.a aVar = rx1.a.a;
                lg.e.O(obj);
                return z ? z2 ? cVar.d(2132018554) : cVar.d(2132018553) : cVar.d(2132018552);
            default:
                boolean z3 = this.k;
                boolean z4 = this.l;
                rx1.a aVar2 = rx1.a.a;
                lg.e.O(obj);
                r2 r2Var = ((st.u) obj2).m;
                do {
                    value = r2Var.getValue();
                } while (!r2Var.d(value, new f((z3 || z4) ? false : true, ((f) value).b)));
                return b0.a;
        }
    }
}
