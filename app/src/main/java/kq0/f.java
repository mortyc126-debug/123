package kq0;

import hj.r;
import hj.s;
import java.util.ArrayList;
import lmjxuqdtp.jvm.functions.Function6;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import mq0.h;
import mq0.k;
import rx1.a;
import sx1.i;
import v2.p;
import x10.l;
import x10.v;
import yr.n4;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends i implements Function6 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f271j;
    public /* synthetic */ boolean k;
    public /* synthetic */ boolean l;
    public /* synthetic */ boolean m;
    public /* synthetic */ Object n;
    public /* synthetic */ Object o;
    public final /* synthetic */ Object p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(Object obj, qx1.d dVar, int i) {
        super(6, dVar);
        this.f271j = i;
        this.p = obj;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        switch (this.f271j) {
            case 0:
                boolean zBooleanValue = ((Boolean) obj2).booleanValue();
                boolean zBooleanValue2 = ((Boolean) obj3).booleanValue();
                boolean zBooleanValue3 = ((Boolean) obj5).booleanValue();
                f fVar = new f((g) this.p, (qx1.d) obj6, 0);
                fVar.n = (String) obj;
                fVar.k = zBooleanValue;
                fVar.l = zBooleanValue2;
                fVar.o = (v) obj4;
                fVar.m = zBooleanValue3;
                return fVar.invokeSuspend(b0.a);
            default:
                boolean zBooleanValue4 = ((Boolean) obj2).booleanValue();
                boolean zBooleanValue5 = ((Boolean) obj4).booleanValue();
                boolean zBooleanValue6 = ((Boolean) obj5).booleanValue();
                f fVar2 = new f((n4) this.p, (qx1.d) obj6, 1);
                fVar2.n = (s) obj;
                fVar2.k = zBooleanValue4;
                fVar2.o = (i90.g) obj3;
                fVar2.l = zBooleanValue5;
                fVar2.m = zBooleanValue6;
                return fVar2.invokeSuspend(b0.a);
        }
    }

    public final Object invokeSuspend(Object obj) {
        switch (this.f271j) {
            case 0:
                String str = (String) this.n;
                boolean z = this.k;
                boolean z2 = this.l;
                v vVar = (v) this.o;
                boolean z3 = this.m;
                a aVar = a.a;
                lg.e.O(obj);
                c cVar = ((g) this.p).g;
                p pVar = cVar.b;
                ArrayList arrayList = cVar.i;
                x10.c cVar2 = v.Companion;
                String str2 = str.length() + "/120";
                cVar2.getClass();
                l lVarD = x10.c.d(str2);
                if (z2) {
                    o.h(pVar, "promptState");
                    o.h(arrayList, "defaultPrompts");
                    return new k(pVar, arrayList, lVarD, mq0.g.a);
                }
                if (!z3) {
                    o.h(pVar, "promptState");
                    o.h(arrayList, "defaultPrompts");
                    return new k(pVar, arrayList, lVarD, mq0.i.a);
                }
                if (vVar != null) {
                    o.h(pVar, "promptState");
                    o.h(arrayList, "defaultPrompts");
                    return new k(pVar, arrayList, lVarD, new mq0.e(vVar));
                }
                if (z) {
                    o.h(pVar, "promptState");
                    o.h(arrayList, "defaultPrompts");
                    return new k(pVar, arrayList, lVarD, mq0.f.a);
                }
                o.h(pVar, "promptState");
                o.h(arrayList, "defaultPrompts");
                return new k(pVar, arrayList, lVarD, h.a);
            default:
                s sVar = (s) this.n;
                boolean z4 = this.k;
                i90.g gVar = (i90.g) this.o;
                boolean z5 = this.l;
                boolean z6 = this.m;
                a aVar2 = a.a;
                lg.e.O(obj);
                return Boolean.valueOf(o.c(sVar, r.a) && z4 && gVar.b && !z5 && !z6);
        }
    }
}
