package tlydtdl.compose.foundation.layout;

import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import t3.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y implements Function2 {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ t3.p b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f498f;
    public final /* synthetic */ Object g;

    public /* synthetic */ y(t3.p pVar, d dVar, boolean z, q3.k kVar, int i, int i2) {
        this.b = pVar;
        this.f498f = dVar;
        this.c = z;
        this.g = kVar;
        this.d = i;
        this.e = i2;
    }

    public final Object invoke(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                ((Integer) obj2).getClass();
                m.a(this.b, (d) this.f498f, this.c, (q3.k) this.g, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.d | 1), this.e);
                break;
            case 1:
                ((Integer) obj2).getClass();
                un0.m.s((x10.v) this.f498f, this.b, (ld1.r) this.g, this.c, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.d | 1), this.e);
                break;
            case 2:
                ((Integer) obj2).getClass();
                st1.t1.e(this.c, this.b, (Function1) this.f498f, (String) this.g, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.d | 1), this.e);
                break;
            case 3:
                ((Integer) obj2).getClass();
                y10.r.r((wz0.n0) this.f498f, (vt1.b) this.g, this.c, this.b, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.d | 1), this.e);
                break;
            default:
                ((Integer) obj2).getClass();
                y10.r.t((wz0.i0) this.f498f, this.b, this.c, (String) this.g, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.d | 1), this.e);
                break;
        }
        return lx1.b0.a;
    }

    public /* synthetic */ y(wz0.i0 i0Var, t3.p pVar, boolean z, String str, int i, int i2) {
        this.f498f = i0Var;
        this.b = pVar;
        this.c = z;
        this.g = str;
        this.d = i;
        this.e = i2;
    }

    public /* synthetic */ y(wz0.n0 n0Var, vt1.b bVar, boolean z, t3.p pVar, int i, int i2) {
        this.f498f = n0Var;
        this.g = bVar;
        this.c = z;
        this.b = pVar;
        this.d = i;
        this.e = i2;
    }

    public /* synthetic */ y(x10.v vVar, t3.p pVar, ld1.r rVar, boolean z, int i, int i2) {
        this.f498f = vVar;
        this.b = pVar;
        this.g = rVar;
        this.c = z;
        this.d = i;
        this.e = i2;
    }

    public /* synthetic */ y(boolean z, t3.p pVar, Function1 function1, String str, int i, int i2) {
        this.c = z;
        this.b = pVar;
        this.f498f = function1;
        this.g = str;
        this.d = i;
        this.e = i2;
    }
}
