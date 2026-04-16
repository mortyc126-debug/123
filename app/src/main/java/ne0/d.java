package ne0;

import ci0.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ki0.h0;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function4;
import lx1.b0;
import so0.f1;
import tc0.l;
import tl0.n;
import uj0.i0;
import uj0.z;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends sx1.i implements Function4 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f343j;
    public /* synthetic */ Object k;
    public /* synthetic */ Object l;
    public /* synthetic */ Object m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(int i, int i2, qx1.d dVar) {
        super(i, dVar);
        this.f343j = i2;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        switch (this.f343j) {
            case 0:
                d dVar = new d(4, 0, (qx1.d) obj4);
                dVar.k = (ke0.c) obj;
                dVar.l = (ay0.f) obj2;
                dVar.m = (ay0.f) obj3;
                return dVar.invokeSuspend(b0.a);
            case 1:
                d dVar2 = new d(4, 1, (qx1.d) obj4);
                dVar2.k = (tl0.r) obj;
                dVar2.l = (di0.y) obj2;
                dVar2.m = (di0.y) obj3;
                return dVar2.invokeSuspend(b0.a);
            default:
                d dVar3 = new d(4, 2, (qx1.d) obj4);
                dVar3.k = (f1) obj;
                dVar3.l = (so0.c) obj2;
                dVar3.m = (so0.c) obj3;
                return dVar3.invokeSuspend(b0.a);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final Object invokeSuspend(Object obj) throws NoWhenBranchMatchedException {
        z zVar;
        String name;
        l lVarO;
        List list;
        Object next;
        switch (this.f343j) {
            case 0:
                ke0.c cVar = (ke0.c) this.k;
                ay0.f fVar = (ay0.f) this.l;
                ay0.f fVar2 = (ay0.f) this.m;
                rx1.a aVar = rx1.a.a;
                lg.e.O(obj);
                return (fVar != ay0.f.c && (cVar instanceof ke0.a)) ? fVar2 : fVar;
            case 1:
                tl0.s sVar = (tl0.r) this.k;
                di0.y yVar = (di0.y) this.l;
                di0.y yVar2 = (di0.y) this.m;
                rx1.a aVar2 = rx1.a.a;
                lg.e.O(obj);
                if (sVar instanceof n) {
                    return yVar2;
                }
                if (!(sVar instanceof tl0.s)) {
                    throw new NoWhenBranchMatchedException();
                }
                l lVarO2 = q6.f.o(yVar2);
                List<uj0.y> list2 = lVarO2.a;
                ArrayList arrayList = null;
                if (list2 != null) {
                    ArrayList arrayList2 = new ArrayList(mx1.p.c0(list2, 10));
                    for (uj0.y yVarB : list2) {
                        if (yVarB instanceof uj0.y) {
                            uj0.y yVar3 = yVarB;
                            if (o.b(yVar3.a(), sVar.a().a())) {
                                if (yVar == null || (lVarO = q6.f.o(yVar)) == null || (list = lVarO.a) == null) {
                                    zVar = null;
                                } else {
                                    Iterator it = list.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            next = it.next();
                                            if (o.b(((z) next).a(), yVar3.a())) {
                                            }
                                        } else {
                                            next = null;
                                        }
                                    }
                                    zVar = (z) next;
                                }
                                if (zVar == null || (name = zVar.getName()) == null) {
                                    name = yVar3.getName();
                                }
                                yVarB = uj0.y.b(yVar3, (List) null, (i0) null, (List) null, (h0) null, name, 895);
                            }
                        }
                        arrayList2.add(yVarB);
                    }
                    arrayList = arrayList2;
                }
                return di0.y.a(yVar2, new l(arrayList, lVarO2.b), 0, 6);
            default:
                f1 f1Var = (f1) this.k;
                so0.c cVar2 = (so0.c) this.l;
                so0.c cVar3 = (so0.c) this.m;
                rx1.a aVar3 = rx1.a.a;
                lg.e.O(obj);
                return f1Var != null ? f1Var : cVar3 != null ? cVar3 : cVar2;
        }
    }
}
