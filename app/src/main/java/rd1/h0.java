package rd1;

import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h0 implements Function2 {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ t3.p b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f408f;
    public final /* synthetic */ Object g;
    public final /* synthetic */ Object h;
    public final /* synthetic */ Object i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ lx1.e f409j;

    public /* synthetic */ h0(dg1.d dVar, s sVar, a0 a0Var, t3.p pVar, boolean z, boolean z2, Function0 function0, int i, int i2) {
        this.g = dVar;
        this.h = sVar;
        this.i = a0Var;
        this.b = pVar;
        this.c = z;
        this.d = z2;
        this.f409j = function0;
        this.e = i;
        this.f408f = i2;
    }

    public final Object invoke(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                ((Integer) obj2).getClass();
                com.facebook.appevents.h.c((dg1.d) this.g, (s) this.h, (a0) this.i, this.b, this.c, this.d, this.f409j, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.e | 1), this.f408f);
                break;
            default:
                ((Integer) obj2).getClass();
                sf1.q.b((sf1.m) this.g, (sf1.g0) this.h, (Function3) this.i, this.f409j, this.b, this.c, this.d, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.e | 1), this.f408f);
                break;
        }
        return lx1.b0.a;
    }

    public /* synthetic */ h0(sf1.m mVar, sf1.g0 g0Var, Function3 function3, q3.k kVar, t3.p pVar, boolean z, boolean z2, int i, int i2) {
        this.g = mVar;
        this.h = g0Var;
        this.i = function3;
        this.f409j = kVar;
        this.b = pVar;
        this.c = z;
        this.d = z2;
        this.e = i;
        this.f408f = i2;
    }
}
