package cu;

import lmjxuqdtp.jvm.functions.Function2;
import lx1.b0;
import qx1.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends sx1.i implements Function2 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f56j;
    public int k;
    public /* synthetic */ boolean l;
    public final /* synthetic */ f m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(f fVar, d dVar, int i) {
        super(2, dVar);
        this.f56j = i;
        this.m = fVar;
    }

    public final d create(Object obj, d dVar) {
        switch (this.f56j) {
            case 0:
                c cVar = new c(this.m, dVar, 0);
                cVar.l = ((Boolean) obj).booleanValue();
                return cVar;
            default:
                c cVar2 = new c(this.m, dVar, 1);
                cVar2.l = ((Boolean) obj).booleanValue();
                return cVar2;
        }
    }

    public final Object invoke(Object obj, Object obj2) {
        int i = this.f56j;
        Boolean bool = (Boolean) obj;
        bool.booleanValue();
        d dVar = (d) obj2;
        switch (i) {
        }
        return ((c) create(bool, dVar)).invokeSuspend(b0.a);
    }

    public final Object invokeSuspend(Object obj) {
        switch (this.f56j) {
            case 0:
                boolean z = this.l;
                rx1.a aVar = rx1.a.a;
                int i = this.k;
                if (i == 0) {
                    lg.e.O(obj);
                    if (z) {
                        this.l = z;
                        this.k = 1;
                        if (this.m.b(this) == aVar) {
                            return aVar;
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lg.e.O(obj);
                }
                return b0.a;
            default:
                boolean z2 = this.l;
                rx1.a aVar2 = rx1.a.a;
                int i2 = this.k;
                if (i2 == 0) {
                    lg.e.O(obj);
                    if (z2) {
                        this.l = z2;
                        this.k = 1;
                        if (this.m.b(this) == aVar2) {
                            return aVar2;
                        }
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
