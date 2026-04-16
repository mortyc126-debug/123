package cf1;

import ch0.b;
import lb.f;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i0 implements Function2 {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f36f;
    public final /* synthetic */ Object g;
    public final /* synthetic */ Object h;
    public final /* synthetic */ Object i;

    public /* synthetic */ i0(g0 g0Var, q qVar, n nVar, b0 b0Var, boolean z, boolean z2, q0 q0Var, int i) {
        this.e = g0Var;
        this.f36f = qVar;
        this.g = nVar;
        this.h = b0Var;
        this.b = z;
        this.c = z2;
        this.i = q0Var;
        this.d = i;
    }

    public final Object invoke(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                ((Integer) obj2).getClass();
                ((g0) this.e).c((q) this.f36f, (n) this.g, (b0) this.h, this.b, this.c, (q0) this.i, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.d | 1));
                break;
            default:
                ((Integer) obj2).getClass();
                b.e((f) this.e, this.b, (Function0) this.f36f, (Function0) this.g, this.c, (Function0) this.h, (Function0) this.i, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.d | 1));
                break;
        }
        return lx1.b0.a;
    }

    public /* synthetic */ i0(f fVar, boolean z, Function0 function0, Function0 function02, boolean z2, Function0 function03, Function0 function04, int i) {
        this.e = fVar;
        this.b = z;
        this.f36f = function0;
        this.g = function02;
        this.c = z2;
        this.h = function03;
        this.i = function04;
        this.d = i;
    }
}
