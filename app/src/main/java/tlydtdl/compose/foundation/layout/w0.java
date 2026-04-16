package tlydtdl.compose.foundation.layout;

import java.util.List;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w0 implements Function2 {
    public final /* synthetic */ int a = 2;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Function3 c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f495f;
    public final /* synthetic */ Object g;
    public final /* synthetic */ Object h;

    public /* synthetic */ w0(sf1.t0 t0Var, ld1.r rVar, v2 v2Var, List list, Function3 function3, int i, int i2) {
        this.b = t0Var;
        this.f495f = rVar;
        this.g = v2Var;
        this.h = list;
        this.c = function3;
        this.d = i;
        this.e = i2;
    }

    public final Object invoke(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                ((Integer) obj2).getClass();
                m.d((t3.p) this.b, (h) this.f495f, (k) this.g, this.d, (g1) this.h, this.c, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.e | 1));
                break;
            case 1:
                ((Integer) obj2).getClass();
                md1.g.l((t3.p) this.b, this.c, (Function2) this.f495f, (Function2) this.g, (q3.k) this.h, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.d | 1), this.e);
                break;
            default:
                ((Integer) obj2).getClass();
                sf1.q.f((sf1.t0) this.b, (ld1.r) this.f495f, (v2) this.g, (List) this.h, this.c, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.d | 1), this.e);
                break;
        }
        return lx1.b0.a;
    }

    public /* synthetic */ w0(t3.p pVar, h hVar, k kVar, int i, g1 g1Var, q3.k kVar2, int i2) {
        this.b = pVar;
        this.f495f = hVar;
        this.g = kVar;
        this.d = i;
        this.h = g1Var;
        this.c = kVar2;
        this.e = i2;
    }

    public /* synthetic */ w0(t3.p pVar, q3.k kVar, Function2 function2, Function2 function22, q3.k kVar2, int i, int i2) {
        this.b = pVar;
        this.c = kVar;
        this.f495f = function2;
        this.g = function22;
        this.h = kVar2;
        this.d = i;
        this.e = i2;
    }
}
