package es0;

import hg1.q;
import lmjxuqdtp.jvm.functions.Function2;
import lx1.b0;
import yr.x4;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends sx1.i implements Function2 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f110j;
    public /* synthetic */ float k;
    public final /* synthetic */ Object l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(Object obj, qx1.d dVar, int i) {
        super(2, dVar);
        this.f110j = i;
        this.l = obj;
    }

    public final qx1.d create(Object obj, qx1.d dVar) {
        switch (this.f110j) {
            case 0:
                j jVar = new j((t) this.l, dVar, 0);
                jVar.k = ((Number) obj).floatValue();
                return jVar;
            case 1:
                j jVar2 = new j((w90.h) this.l, dVar, 1);
                jVar2.k = ((Number) obj).floatValue();
                return jVar2;
            default:
                j jVar3 = new j((x4) this.l, dVar, 2);
                jVar3.k = ((hg1.b) obj).a;
                return jVar3;
        }
    }

    public final Object invoke(Object obj, Object obj2) {
        switch (this.f110j) {
            case 0:
                j jVarCreate = create(Float.valueOf(((Number) obj).floatValue()), (qx1.d) obj2);
                b0 b0Var = b0.a;
                jVarCreate.invokeSuspend(b0Var);
                return b0Var;
            case 1:
                j jVarCreate2 = create(Float.valueOf(((Number) obj).floatValue()), (qx1.d) obj2);
                b0 b0Var2 = b0.a;
                jVarCreate2.invokeSuspend(b0Var2);
                return b0Var2;
            default:
                float f2 = ((hg1.b) obj).a;
                j jVar = new j((x4) this.l, (qx1.d) obj2, 2);
                jVar.k = f2;
                b0 b0Var3 = b0.a;
                jVar.invokeSuspend(b0Var3);
                return b0Var3;
        }
    }

    public final Object invokeSuspend(Object obj) {
        int i = this.f110j;
        b0 b0Var = b0.a;
        Object obj2 = this.l;
        switch (i) {
            case 0:
                float f2 = this.k;
                rx1.a aVar = rx1.a.a;
                lg.e.O(obj);
                s1.a.u((int) (f2 * 100.0f), ((t) obj2).o.i, (Object) null);
                break;
            case 1:
                float f3 = this.k;
                rx1.a aVar2 = rx1.a.a;
                lg.e.O(obj);
                ((w90.h) obj2).d.invoke(new Float(f3));
                break;
            default:
                float f4 = this.k;
                rx1.a aVar3 = rx1.a.a;
                lg.e.O(obj);
                x4 x4Var = (x4) obj2;
                eh0.b bVar = x4Var.d;
                bVar.c = f4;
                double dB = bVar.b(x4Var.f.b());
                a80.d dVar = x4Var.c;
                dVar.S(new ey1.d(0.0d, dB));
                dVar.M(bVar.b(((q) r0.c().getValue()).a));
                break;
        }
        return b0Var;
    }
}
