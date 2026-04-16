package zq0;

import com.bandlab.mixeditor.presets.services.ExclusivePresetsService;
import com.bandlab.mixeditor.presets.services.TrendingPresetsService;
import fy1.l;
import java.util.List;
import jx0.h;
import lmjxuqdtp.jvm.functions.Function3;
import lmjxuqdtp.jvm.internal.d0;
import lx1.b0;
import ny1.m;
import ny1.z;
import sx1.i;
import tc0.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends i implements Function3 {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int f746j;
    public int k;
    public /* synthetic */ Object l;
    public final /* synthetic */ Object m;
    public /* synthetic */ Object n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(Object obj, String str, qx1.d dVar, int i) {
        super(3, dVar);
        this.f746j = i;
        this.n = obj;
        this.m = str;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.f746j) {
            case 0:
                d dVar = new d((g) this.n, (String) this.m, (qx1.d) obj3, 0);
                dVar.l = (p) obj2;
                return dVar.invokeSuspend(b0.a);
            case 1:
                d dVar2 = new d((u) this.n, (String) this.m, (qx1.d) obj3, 1);
                dVar2.l = (p) obj2;
                return dVar2.invokeSuspend(b0.a);
            case 2:
                d dVar3 = new d((h0) this.n, (String) this.m, (qx1.d) obj3, 2);
                dVar3.l = (p) obj2;
                return dVar3.invokeSuspend(b0.a);
            case 3:
                d dVar4 = new d((n0) this.n, (String) this.m, (qx1.d) obj3, 3);
                dVar4.l = (p) obj2;
                return dVar4.invokeSuspend(b0.a);
            default:
                d dVar5 = new d((qx1.d) obj3, (zr0.g) this.m);
                dVar5.l = (m) obj;
                dVar5.n = obj2;
                return dVar5.invokeSuspend(b0.a);
        }
    }

    public final Object invokeSuspend(Object obj) {
        int i = this.f746j;
        Object obj2 = this.m;
        switch (i) {
            case 0:
                p pVar = (p) this.l;
                rx1.a aVar = rx1.a.a;
                int i2 = this.k;
                if (i2 != 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lg.e.O(obj);
                    return obj;
                }
                lg.e.O(obj);
                mt.b bVar = ((g) this.n).c;
                l lVar = g.f749f[0];
                this.l = null;
                this.k = 1;
                Object categories = ((ExclusivePresetsService) new h(d0.a(ExclusivePresetsService.class), bVar).t(lVar)).getCategories((String) obj2, pVar, this);
                return categories == aVar ? aVar : categories;
            case 1:
                p pVar2 = (p) this.l;
                tc0.l lVar2 = rx1.a.a;
                int i3 = this.k;
                if (i3 == 0) {
                    lg.e.O(obj);
                    u uVar = (u) this.n;
                    l[] lVarArr = u.f758f;
                    this.l = null;
                    this.k = 1;
                    obj = uVar.c().loadFavoritePresets((String) obj2, pVar2, this);
                    if (obj != lVar2) {
                    }
                    return lVar2;
                }
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lg.e.O(obj);
                tc0.l lVar3 = (tc0.l) obj;
                lmjxuqdtp.jvm.internal.o.h(lVar3, "<this>");
                List list = lVar3.a;
                lVar2 = new tc0.l(list != null ? mx1.o.u0(list) : null, lVar3.b);
                return lVar2;
            case 2:
                p pVar3 = (p) this.l;
                rx1.a aVar2 = rx1.a.a;
                int i4 = this.k;
                if (i4 != 0) {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lg.e.O(obj);
                    return obj;
                }
                lg.e.O(obj);
                h0 h0Var = (h0) this.n;
                l[] lVarArr2 = h0.l;
                this.l = null;
                this.k = 1;
                Object presets = h0Var.h().getPresets((String) obj2, pVar3, this);
                return presets == aVar2 ? aVar2 : presets;
            case 3:
                p pVar4 = (p) this.l;
                rx1.a aVar3 = rx1.a.a;
                int i6 = this.k;
                if (i6 != 0) {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lg.e.O(obj);
                    return obj;
                }
                lg.e.O(obj);
                mt.b bVar2 = ((n0) this.n).b;
                l lVar4 = n0.f755f[0];
                this.l = null;
                this.k = 1;
                Object objLoadTrendingPresets = ((TrendingPresetsService) new h(d0.a(TrendingPresetsService.class), bVar2).t(lVar4)).loadTrendingPresets((String) obj2, pVar4, this);
                return objLoadTrendingPresets == aVar3 ? aVar3 : objLoadTrendingPresets;
            default:
                zr0.g gVar = (zr0.g) obj2;
                rx1.a aVar4 = rx1.a.a;
                int i7 = this.k;
                if (i7 == 0) {
                    lg.e.O(obj);
                    m mVar = (m) this.l;
                    String str = (String) this.n;
                    ny1.o oVar = str == null ? new ny1.o(1, as0.a.a) : new b60.s(z.u(new eu0.i(gVar.e.x, str, 12)), str, gVar);
                    this.l = null;
                    this.n = null;
                    this.k = 1;
                    if (z.x(mVar, oVar, this) == aVar4) {
                        return aVar4;
                    }
                } else {
                    if (i7 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lg.e.O(obj);
                }
                return b0.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(qx1.d dVar, zr0.g gVar) {
        super(3, dVar);
        this.f746j = 4;
        this.m = gVar;
    }
}
