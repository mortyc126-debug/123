package e80;

import i2.a0;
import lmjxuqdtp.jvm.functions.Function2;
import lx1.b0;
import ny1.c2;
import qx1.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends sx1.i implements Function2 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f99j;
    public int k;
    public final /* synthetic */ a0 l;
    public final /* synthetic */ a m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(a0 a0Var, a aVar, d dVar, int i) {
        super(2, dVar);
        this.f99j = i;
        this.l = a0Var;
        this.m = aVar;
    }

    public final d create(Object obj, d dVar) {
        switch (this.f99j) {
            case 0:
                return new j(this.l, this.m, dVar, 0);
            default:
                return new j(this.l, this.m, dVar, 1);
        }
    }

    public final Object invoke(Object obj, Object obj2) {
        ky1.a0 a0Var = (ky1.a0) obj;
        d dVar = (d) obj2;
        switch (this.f99j) {
        }
        return create(a0Var, dVar).invokeSuspend(b0.a);
    }

    public final Object invokeSuspend(Object obj) {
        switch (this.f99j) {
            case 0:
                rx1.a aVar = rx1.a.a;
                int i = this.k;
                if (i == 0) {
                    lg.e.O(obj);
                    a0 a0Var = this.l;
                    if (!a0Var.k.b()) {
                        a aVar2 = this.m;
                        if (aVar2.c != a0Var.k()) {
                            int i2 = aVar2.c;
                            this.k = 1;
                            if (a0.v(i2, a0Var, this) == aVar) {
                                return aVar;
                            }
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
                rx1.a aVar3 = rx1.a.a;
                int i3 = this.k;
                if (i3 == 0) {
                    lg.e.O(obj);
                    c2 c2VarZ = tlydtdl.compose.runtime.a0.z(new g(this.l, 1));
                    k kVar = new k(0, this.m);
                    this.k = 1;
                    if (c2VarZ.collect(kVar, this) == aVar3) {
                        return aVar3;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lg.e.O(obj);
                }
                return b0.a;
        }
    }
}
