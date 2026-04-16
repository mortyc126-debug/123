package mx0;

import d01.f;
import d10.j;
import ky1.a0;
import ky1.c0;
import lg.e;
import lmjxuqdtp.jvm.functions.Function2;
import lx1.b0;
import nc0.g;
import ny1.z;
import qx1.d;
import sx1.i;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends i implements Function2 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f334j;
    public int k;
    public final /* synthetic */ o l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(o oVar, d dVar, int i) {
        super(2, dVar);
        this.f334j = i;
        this.l = oVar;
    }

    public final d create(Object obj, d dVar) {
        switch (this.f334j) {
            case 0:
                return new l(this.l, dVar, 0);
            case 1:
                return new l(this.l, dVar, 1);
            default:
                return new l(this.l, dVar, 2);
        }
    }

    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        d dVar = (d) obj2;
        switch (this.f334j) {
        }
        return create(a0Var, dVar).invokeSuspend(b0.a);
    }

    public final Object invokeSuspend(Object obj) {
        switch (this.f334j) {
            case 0:
                rx1.a aVar = rx1.a.a;
                int i = this.k;
                if (i == 0) {
                    e.O(obj);
                    this.k = 1;
                    if (this.l.e(this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e.O(obj);
                }
                return b0.a;
            case 1:
                rx1.a aVar2 = rx1.a.a;
                int i2 = this.k;
                o oVar = this.l;
                if (i2 == 0) {
                    e.O(obj);
                    this.k = 1;
                    if (oVar.c(this) == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e.O(obj);
                }
                c0.F(oVar.e, (qx1.i) null, (ky1.b0) null, new l(oVar, null, 2), 3);
                return b0.a;
            default:
                rx1.a aVar3 = rx1.a.a;
                int i3 = this.k;
                if (i3 == 0) {
                    e.O(obj);
                    o oVar2 = this.l;
                    hg0.d dVar = new hg0.d(new j(oVar2.b.e, new g(oVar2.c.f, 1), new f(3, 2, (d) null), 9), 1);
                    this.k = 1;
                    if (z.B(dVar, this) == aVar3) {
                        return aVar3;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e.O(obj);
                }
                return b0.a;
        }
    }
}
