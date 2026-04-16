package fs0;

import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function2;
import t3.p;
import tlydtdl.compose.runtime.f3;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements Function2 {
    public final /* synthetic */ int a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f122f;

    public /* synthetic */ g(Object obj, boolean z, Object obj2, Object obj3, int i, int i2) {
        this.a = i2;
        this.e = obj;
        this.f122f = obj2;
        this.c = obj3;
        this.b = z;
        this.d = i;
    }

    public final Object invoke(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                ((Integer) obj2).getClass();
                int iB = tlydtdl.compose.runtime.a0.B(1);
                a.g((x10.v) this.e, (x10.v) this.f122f, this.b, (Function0) this.c, (tlydtdl.compose.runtime.m) obj, iB, this.d);
                break;
            case 1:
                ((Integer) obj2).getClass();
                lu0.m.f(this.b, (Function0) this.c, (Function0) this.e, (p) this.f122f, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.d | 1));
                break;
            case 2:
                ((Integer) obj2).getClass();
                h02.a.b((x10.v) this.e, (qd1.k) this.f122f, (qd1.n) this.c, this.b, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.d | 1));
                break;
            default:
                ((Integer) obj2).getClass();
                h02.a.i((p) this.e, (f3) this.f122f, (un0.w) this.c, this.b, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.d | 1));
                break;
        }
        return lx1.b0.a;
    }

    public /* synthetic */ g(x10.v vVar, x10.v vVar2, boolean z, Function0 function0, int i, int i2) {
        this.a = 0;
        this.e = vVar;
        this.f122f = vVar2;
        this.b = z;
        this.c = function0;
        this.d = i2;
    }

    public /* synthetic */ g(boolean z, Function0 function0, Function0 function02, p pVar, int i) {
        this.a = 1;
        this.b = z;
        this.c = function0;
        this.e = function02;
        this.f122f = pVar;
        this.d = i;
    }
}
