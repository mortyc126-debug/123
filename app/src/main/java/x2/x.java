package x2;

import lg.e;
import lmjxuqdtp.jvm.functions.Function2;
import lx1.b0;
import m2.k;
import ny1.z;
import rx1.a;
import st1.t1;
import sx1.i;
import vg0.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class x extends i implements Function2 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f681j;
    public int k;
    public final /* synthetic */ y l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ x(y yVar, qx1.d dVar, int i) {
        super(2, dVar);
        this.f681j = i;
        this.l = yVar;
    }

    public final qx1.d create(Object obj, qx1.d dVar) {
        switch (this.f681j) {
            case 0:
                return new x(this.l, dVar, 0);
            default:
                return new x(this.l, dVar, 1);
        }
    }

    public final Object invoke(Object obj, Object obj2) {
        ky1.a0 a0Var = (ky1.a0) obj;
        qx1.d dVar = (qx1.d) obj2;
        switch (this.f681j) {
        }
        return create(a0Var, dVar).invokeSuspend(b0.a);
    }

    public final Object invokeSuspend(Object obj) {
        switch (this.f681j) {
            case 0:
                a aVar = a.a;
                int i = this.k;
                b0 b0Var = b0.a;
                if (i == 0) {
                    e.O(obj);
                    this.k = 1;
                    y yVar = this.l;
                    yVar.getClass();
                    Object objCollect = z.w(z.t(q.b, tlydtdl.compose.runtime.a0.z(new k(yVar, 5))), 1).collect(new r(yVar, 0), this);
                    if (objCollect != aVar) {
                        objCollect = b0Var;
                    }
                    if (objCollect == aVar) {
                        return aVar;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e.O(obj);
                }
                return b0Var;
            default:
                a aVar2 = a.a;
                int i2 = this.k;
                b0 b0Var2 = b0.a;
                if (i2 == 0) {
                    e.O(obj);
                    this.k = 1;
                    y yVar2 = this.l;
                    yVar2.getClass();
                    ny1.j jVarZ = tlydtdl.compose.runtime.a0.z(new k(yVar2, 4));
                    if (t1.a) {
                        jVarZ = z.v(jVarZ, new c(6), z.b);
                    }
                    Object objCollect2 = jVarZ.collect(new r(yVar2, 1), this);
                    if (objCollect2 != aVar2) {
                        objCollect2 = b0Var2;
                    }
                    if (objCollect2 == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e.O(obj);
                }
                return b0Var2;
        }
    }
}
