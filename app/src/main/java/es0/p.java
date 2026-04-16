package es0;

import dh1.w;
import java.util.List;
import java.util.Map;
import lmjxuqdtp.jvm.functions.Function6;
import lx1.b0;
import vg.k;
import x10.v;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class p extends sx1.i implements Function6 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f112j;
    public /* synthetic */ boolean k;
    public /* synthetic */ Object l;
    public /* synthetic */ Object m;
    public /* synthetic */ Object n;
    public /* synthetic */ Object o;
    public final /* synthetic */ Object p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(Object obj, qx1.d dVar, int i) {
        super(6, dVar);
        this.f112j = i;
        this.p = obj;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        switch (this.f112j) {
            case 0:
                boolean zBooleanValue = ((Boolean) obj5).booleanValue();
                p pVar = new p((t) this.p, (qx1.d) obj6, 0);
                pVar.l = (List) obj;
                pVar.m = (String) obj2;
                pVar.n = (v) obj3;
                pVar.o = (v) obj4;
                pVar.k = zBooleanValue;
                return pVar.invokeSuspend(b0.a);
            default:
                boolean zBooleanValue2 = ((Boolean) obj).booleanValue();
                p pVar2 = new p((ug.g) this.p, (qx1.d) obj6, 1);
                pVar2.k = zBooleanValue2;
                pVar2.l = (Map) obj2;
                pVar2.m = (lmjxuqdtp.time.l) obj3;
                pVar2.n = (yg.l) obj4;
                pVar2.o = (w) obj5;
                return pVar2.invokeSuspend(b0.a);
        }
    }

    public final Object invokeSuspend(Object obj) {
        fs0.e cVar;
        fs0.e eVar;
        int i = this.f112j;
        Object obj2 = this.p;
        switch (i) {
            case 0:
                List list = (List) this.l;
                String str = (String) this.m;
                v vVar = (v) this.n;
                v vVar2 = (v) this.o;
                boolean z = this.k;
                rx1.a aVar = rx1.a.a;
                lg.e.O(obj);
                if (z) {
                    eVar = fs0.b.a;
                } else {
                    if (list.isEmpty()) {
                        cVar = new fs0.c(new o((t) obj2, 0));
                        return new gs0.c(list, str, vVar, vVar2, cVar);
                    }
                    eVar = fs0.d.a;
                }
                cVar = eVar;
                return new gs0.c(list, str, vVar, vVar2, cVar);
            default:
                boolean z2 = this.k;
                Map map = (Map) this.l;
                lmjxuqdtp.time.l lVar = (lmjxuqdtp.time.l) this.m;
                yg.l lVar2 = (yg.l) this.n;
                w wVar = (w) this.o;
                rx1.a aVar2 = rx1.a.a;
                lg.e.O(obj);
                return new k((ug.g) obj2, lVar2, z2, map, lVar, wVar);
        }
    }
}
