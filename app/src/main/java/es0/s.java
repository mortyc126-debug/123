package es0;

import hg1.x;
import lmjxuqdtp.jvm.functions.Function12;
import lx1.b0;
import x10.v;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class s extends sx1.i implements Function12 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public /* synthetic */ boolean f114j;
    public /* synthetic */ int k;
    public /* synthetic */ boolean l;
    public /* synthetic */ boolean m;
    public /* synthetic */ v n;
    public /* synthetic */ int o;
    public /* synthetic */ gs0.c p;
    public /* synthetic */ hg1.d q;
    public /* synthetic */ boolean r;
    public /* synthetic */ ds0.l s;
    public /* synthetic */ x t;
    public final /* synthetic */ t u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(t tVar, qx1.d dVar) {
        super(12, dVar);
        this.u = tVar;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int iIntValue = ((Number) obj2).intValue();
        boolean zBooleanValue2 = ((Boolean) obj3).booleanValue();
        boolean zBooleanValue3 = ((Boolean) obj4).booleanValue();
        int iIntValue2 = ((Number) obj6).intValue();
        boolean zBooleanValue4 = ((Boolean) obj9).booleanValue();
        s sVar = new s(this.u, (qx1.d) obj12);
        sVar.f114j = zBooleanValue;
        sVar.k = iIntValue;
        sVar.l = zBooleanValue2;
        sVar.m = zBooleanValue3;
        sVar.n = (v) obj5;
        sVar.o = iIntValue2;
        sVar.p = (gs0.c) obj7;
        sVar.q = (hg1.d) obj8;
        sVar.r = zBooleanValue4;
        sVar.s = (ds0.l) obj10;
        sVar.t = (x) obj11;
        return sVar.invokeSuspend(b0.a);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z = this.f114j;
        int i = this.k;
        boolean z2 = this.l;
        boolean z3 = this.m;
        v vVar = this.n;
        int i2 = this.o;
        gs0.c cVar = this.p;
        hg1.d dVar = this.q;
        boolean z4 = this.r;
        ds0.l lVar = this.s;
        x xVar = this.t;
        rx1.a aVar = rx1.a.a;
        lg.e.O(obj);
        t tVar = this.u;
        gs0.a aVar2 = tVar.t;
        gs0.a aVar3 = tVar.p;
        gs0.a aVar4 = tVar.n;
        gs0.a aVar5 = tVar.q;
        boolean z5 = !z2;
        fs0.e cVar2 = z2 ? fs0.b.a : z ? fs0.d.a : new fs0.c(new o(tVar, 1));
        gs0.a aVar6 = tVar.r;
        v.Companion.getClass();
        return new gs0.d(aVar2, i, aVar3, aVar4, aVar5, z5, z3, vVar, cVar2, 200, i2, cVar, aVar6, dVar, z4, lVar, xVar, x10.c.d("Ctrl + /"));
    }
}
