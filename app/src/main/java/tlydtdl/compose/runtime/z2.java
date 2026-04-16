package tlydtdl.compose.runtime;

import lmjxuqdtp.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class z2 extends sx1.i implements Function2 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f552j;
    public int k;
    public /* synthetic */ Object l;
    public final /* synthetic */ Function2 m;
    public final /* synthetic */ e1 n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z2(Function2 function2, e1 e1Var, qx1.d dVar, int i) {
        super(2, dVar);
        this.f552j = i;
        this.m = function2;
        this.n = e1Var;
    }

    public final qx1.d create(Object obj, qx1.d dVar) {
        switch (this.f552j) {
            case 0:
                z2 z2Var = new z2(this.m, this.n, dVar, 0);
                z2Var.l = obj;
                return z2Var;
            case 1:
                z2 z2Var2 = new z2(this.m, this.n, dVar, 1);
                z2Var2.l = obj;
                return z2Var2;
            default:
                z2 z2Var3 = new z2(this.m, this.n, dVar, 2);
                z2Var3.l = obj;
                return z2Var3;
        }
    }

    public final Object invoke(Object obj, Object obj2) {
        ky1.a0 a0Var = (ky1.a0) obj;
        qx1.d dVar = (qx1.d) obj2;
        switch (this.f552j) {
        }
        return create(a0Var, dVar).invokeSuspend(lx1.b0.a);
    }

    public final Object invokeSuspend(Object obj) {
        switch (this.f552j) {
            case 0:
                rx1.a aVar = rx1.a.a;
                int i = this.k;
                if (i == 0) {
                    lg.e.O(obj);
                    w1 w1Var = new w1(this.n, ((ky1.a0) this.l).getCoroutineContext());
                    this.k = 1;
                    if (this.m.invoke(w1Var, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lg.e.O(obj);
                }
                return lx1.b0.a;
            case 1:
                rx1.a aVar2 = rx1.a.a;
                int i2 = this.k;
                if (i2 == 0) {
                    lg.e.O(obj);
                    w1 w1Var2 = new w1(this.n, ((ky1.a0) this.l).getCoroutineContext());
                    this.k = 1;
                    if (this.m.invoke(w1Var2, this) == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lg.e.O(obj);
                }
                return lx1.b0.a;
            default:
                rx1.a aVar3 = rx1.a.a;
                int i3 = this.k;
                if (i3 == 0) {
                    lg.e.O(obj);
                    w1 w1Var3 = new w1(this.n, ((ky1.a0) this.l).getCoroutineContext());
                    this.k = 1;
                    if (this.m.invoke(w1Var3, this) == aVar3) {
                        return aVar3;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lg.e.O(obj);
                }
                return lx1.b0.a;
        }
    }
}
