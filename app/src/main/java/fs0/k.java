package fs0;

import java.util.List;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.functions.Function3;
import sf1.t0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements Function2 {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ x10.v b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f124f;
    public final /* synthetic */ Object g;
    public final /* synthetic */ Object h;
    public final /* synthetic */ lx1.e i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ lx1.e f125j;
    public final /* synthetic */ Object k;

    public /* synthetic */ k(x10.v vVar, Object obj, List list, Function1 function1, Function1 function12, x10.v vVar2, boolean z, e eVar, int i, int i2) {
        this.b = vVar;
        this.g = obj;
        this.h = list;
        this.i = function1;
        this.f125j = function12;
        this.f124f = vVar2;
        this.c = z;
        this.k = eVar;
        this.d = i;
        this.e = i2;
    }

    public final Object invoke(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                ((Integer) obj2).getClass();
                a.f(this.b, this.g, (List) this.h, this.i, this.f125j, (x10.v) this.f124f, this.c, (e) this.k, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.d | 1), this.e);
                break;
            default:
                ((Integer) obj2).getClass();
                uo.a.a(this.b, (t0) this.f124f, (uo.e) this.g, this.c, (uo.d) this.h, this.i, this.f125j, (q3.k) this.k, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.d | 1), this.e);
                break;
        }
        return lx1.b0.a;
    }

    public /* synthetic */ k(x10.v vVar, t0 t0Var, uo.e eVar, boolean z, uo.d dVar, Function3 function3, Function2 function2, q3.k kVar, int i, int i2) {
        this.b = vVar;
        this.f124f = t0Var;
        this.g = eVar;
        this.c = z;
        this.h = dVar;
        this.i = function3;
        this.f125j = function2;
        this.k = kVar;
        this.d = i;
        this.e = i2;
    }
}
