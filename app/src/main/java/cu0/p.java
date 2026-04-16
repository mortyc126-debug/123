package cu0;

import ju0.a;
import lmjxuqdtp.jvm.functions.Function7;
import lx1.b0;
import qx1.d;
import st0.c;
import sx1.i;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class p extends i implements Function7 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f65j;
    public /* synthetic */ boolean k;
    public /* synthetic */ ju0.b l;
    public /* synthetic */ a m;
    public /* synthetic */ dg1.i n;
    public /* synthetic */ Enum o;
    public /* synthetic */ Object p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(int i, d dVar) {
        super(7, dVar);
        this.f65j = i;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        switch (this.f65j) {
            case 0:
                boolean zBooleanValue = ((Boolean) obj2).booleanValue();
                p pVar = new p(0, (d) obj7);
                pVar.o = (du0.h) obj;
                pVar.k = zBooleanValue;
                pVar.m = (a) obj3;
                pVar.n = (dg1.i) obj4;
                pVar.l = (ju0.b) obj5;
                pVar.p = (du0.e) obj6;
                return pVar.invokeSuspend(b0.a);
            case 1:
                boolean zBooleanValue2 = ((Boolean) obj2).booleanValue();
                p pVar2 = new p(1, (d) obj7);
                pVar2.o = (mr0.d) obj;
                pVar2.k = zBooleanValue2;
                pVar2.l = (ju0.b) obj3;
                pVar2.p = (ju0.b) obj4;
                pVar2.m = (a) obj5;
                pVar2.n = (dg1.i) obj6;
                return pVar2.invokeSuspend(b0.a);
            default:
                boolean zBooleanValue3 = ((Boolean) obj2).booleanValue();
                p pVar3 = new p(2, (d) obj7);
                pVar3.o = (st0.e) obj;
                pVar3.k = zBooleanValue3;
                pVar3.l = (ju0.b) obj3;
                pVar3.p = (c) obj4;
                pVar3.m = (a) obj5;
                pVar3.n = (dg1.i) obj6;
                return pVar3.invokeSuspend(b0.a);
        }
    }

    public final Object invokeSuspend(Object obj) {
        switch (this.f65j) {
            case 0:
                du0.h hVar = (du0.h) this.o;
                boolean z = this.k;
                a aVar = this.m;
                dg1.i iVar = this.n;
                ju0.b bVar = this.l;
                du0.e eVar = (du0.e) this.p;
                rx1.a aVar2 = rx1.a.a;
                lg.e.O(obj);
                return new du0.g(hVar, iVar, aVar, bVar, !z, eVar);
            case 1:
                mr0.d dVar = this.o;
                boolean z2 = this.k;
                ju0.b bVar2 = this.l;
                ju0.b bVar3 = (ju0.b) this.p;
                a aVar3 = this.m;
                dg1.i iVar2 = this.n;
                rx1.a aVar4 = rx1.a.a;
                lg.e.O(obj);
                return new mr0.c(dVar, iVar2, aVar3, bVar2, bVar3, !z2);
            default:
                st0.e eVar2 = this.o;
                boolean z3 = this.k;
                ju0.b bVar4 = this.l;
                c cVar = (c) this.p;
                a aVar5 = this.m;
                dg1.i iVar3 = this.n;
                rx1.a aVar6 = rx1.a.a;
                lg.e.O(obj);
                return new st0.d(eVar2, iVar3, cVar, aVar5, bVar4, !z3);
        }
    }
}
