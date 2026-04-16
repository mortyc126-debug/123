package cu0;

import d10.j;
import lmjxuqdtp.jvm.functions.Function3;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import ny1.m;
import ny1.z;
import qx1.d;
import rx1.a;
import sx1.i;
import y11.q4;
import zj.v1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends i implements Function3 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f61j;
    public int k;
    public /* synthetic */ m l;
    public /* synthetic */ Object m;
    public final /* synthetic */ q n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(d dVar, q qVar, int i) {
        super(3, dVar);
        this.f61j = i;
        this.n = qVar;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        m mVar = (m) obj;
        d dVar = (d) obj3;
        switch (this.f61j) {
            case 0:
                e eVar = new e(dVar, this.n, 0);
                eVar.l = mVar;
                eVar.m = obj2;
                return eVar.invokeSuspend(b0.a);
            default:
                e eVar2 = new e(dVar, this.n, 1);
                eVar2.l = mVar;
                eVar2.m = obj2;
                return eVar2.invokeSuspend(b0.a);
        }
    }

    public final Object invokeSuspend(Object obj) {
        j oVar;
        switch (this.f61j) {
            case 0:
                a aVar = a.a;
                int i = this.k;
                if (i == 0) {
                    lg.e.O(obj);
                    m mVar = this.l;
                    String str = ((q4) this.m).a;
                    eu0.k kVar = this.n.g;
                    o.h(str, "trackId");
                    oy1.k kVarU = z.U(z.u(new eu0.i(((v1) kVar.b).x, str, 0)), new c80.j((d) null, kVar, str, 3));
                    this.l = null;
                    this.m = null;
                    this.k = 1;
                    if (z.x(mVar, kVarU, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lg.e.O(obj);
                }
                return b0.a;
            default:
                a aVar2 = a.a;
                int i2 = this.k;
                if (i2 == 0) {
                    lg.e.O(obj);
                    m mVar2 = this.l;
                    if (((Boolean) this.m).booleanValue()) {
                        q qVar = this.n;
                        oVar = new j(qVar.e.D, qVar.b.h, new ai1.k(9), 9);
                    } else {
                        oVar = new ny1.o(1, (Object) null);
                    }
                    this.l = null;
                    this.m = null;
                    this.k = 1;
                    if (z.x(mVar2, oVar, this) == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lg.e.O(obj);
                }
                return b0.a;
        }
    }
}
