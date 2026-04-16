package rd1;

import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g0 implements Function2 {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ t3.p b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f406f;
    public final /* synthetic */ Object g;
    public final /* synthetic */ Object h;
    public final /* synthetic */ Object i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ lx1.e f407j;

    public /* synthetic */ g0(int i, int i2, dg1.g gVar, Function0 function0, s sVar, a0 a0Var, t3.p pVar, x10.r rVar, boolean z) {
        this.f406f = rVar;
        this.g = gVar;
        this.c = z;
        this.h = sVar;
        this.i = a0Var;
        this.b = pVar;
        this.f407j = function0;
        this.d = i;
        this.e = i2;
    }

    public final Object invoke(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                x10.r rVar = (x10.r) this.f406f;
                dg1.g gVar = (dg1.g) this.g;
                s sVar = (s) this.h;
                a0 a0Var = (a0) this.i;
                Function0 function0 = this.f407j;
                ((Integer) obj2).getClass();
                ch0.b.c(tlydtdl.compose.runtime.a0.B(this.d | 1), this.e, (tlydtdl.compose.runtime.m) obj, gVar, function0, sVar, a0Var, this.b, rVar, this.c);
                break;
            default:
                ((Integer) obj2).getClass();
                uc0.p.c((tlydtdl.compose.foundation.lazy.a) this.f406f, (zd1.b) this.g, this.h, this.b, (t3.p) this.i, this.c, this.f407j, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.d | 1), this.e);
                break;
        }
        return lx1.b0.a;
    }

    public /* synthetic */ g0(tlydtdl.compose.foundation.lazy.a aVar, zd1.b bVar, Object obj, t3.p pVar, t3.p pVar2, boolean z, q3.k kVar, int i, int i2) {
        this.f406f = aVar;
        this.g = bVar;
        this.h = obj;
        this.b = pVar;
        this.i = pVar2;
        this.c = z;
        this.f407j = kVar;
        this.d = i;
        this.e = i2;
    }
}
