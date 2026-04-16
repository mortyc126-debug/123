package ds0;

import com.gnacba.amuvvoafs.gms.internal.measurement.b4;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import lx1.b0;
import tlydtdl.compose.runtime.a0;
import tlydtdl.compose.runtime.f3;
import un0.n;
import un0.p;
import x10.v;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Function2 {
    public final /* synthetic */ int a = 2;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f91f;
    public final /* synthetic */ Object g;
    public final /* synthetic */ Object h;

    public /* synthetic */ d(f3 f3Var, n nVar, p pVar, t3.p pVar2, t3.p pVar3, boolean z, int i) {
        this.d = f3Var;
        this.e = nVar;
        this.f91f = pVar;
        this.h = pVar2;
        this.g = pVar3;
        this.b = z;
        this.c = i;
    }

    public final Object invoke(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                ((Integer) obj2).getClass();
                int iB = a0.B(1);
                b4.c((v2.p) this.d, this.c, this.b, (Function0) this.e, (Function0) this.f91f, (Function1) this.g, (t3.p) this.h, (tlydtdl.compose.runtime.m) obj, iB);
                break;
            case 1:
                ((Integer) obj2).getClass();
                fs0.a.a((v) this.d, (v) this.e, (v) this.f91f, this.b, (fs0.e) this.g, (q3.k) this.h, (tlydtdl.compose.runtime.m) obj, a0.B(this.c | 1));
                break;
            default:
                ((Integer) obj2).getClass();
                cq1.d.c((f3) this.d, (n) this.e, (p) this.f91f, (t3.p) this.h, (t3.p) this.g, this.b, (tlydtdl.compose.runtime.m) obj, a0.B(this.c | 1));
                break;
        }
        return b0.a;
    }

    public /* synthetic */ d(v2.p pVar, int i, boolean z, Function0 function0, Function0 function02, Function1 function1, t3.p pVar2, int i2) {
        this.d = pVar;
        this.c = i;
        this.b = z;
        this.e = function0;
        this.f91f = function02;
        this.g = function1;
        this.h = pVar2;
    }

    public /* synthetic */ d(v vVar, v vVar2, v vVar3, boolean z, fs0.e eVar, q3.k kVar, int i) {
        this.d = vVar;
        this.e = vVar2;
        this.f91f = vVar3;
        this.b = z;
        this.g = eVar;
        this.h = kVar;
        this.c = i;
    }
}
